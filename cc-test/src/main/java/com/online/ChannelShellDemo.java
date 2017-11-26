package com.online;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/8/1.
 */
public class ChannelShellDemo {

    @Test
    public void test2() throws Exception {
        String ip = "192.168.102.146";
        int port = 8802;
        String localIp = null;
        int localPort = 20;
        int timeOut = 3000;
        String userName = "root";
        String password = "zhtx1.q";

        String[] cmds = new String[] {"ifconfig\n","ssh -p 8802 root@192.168.102.147 #p\n","/usr/local/nginx/sbin/nginx -t\n"};
        String[] result = null;
        try {
            result = execShellCmdBySSH(ip, port, localIp, localPort, timeOut, userName, password, cmds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            for (String string : result) {
                System.out.println(string);
                //System.out.println("-------------------");
            }
        }

    }

    /**
     * ????Session??????Session????
     *
     * @param dstIp
     * @param dstPort
     * @param localIp
     * @param localPort
     * @param userName
     * @param password
     * @param timeOut
     * @return
     * @throws JSchException
     */
    public static Session createSession(String dstIp, int dstPort,
                                        final String localIp, final int localPort, String userName,
                                        String password, final int timeOut) throws JSchException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(userName, dstIp, dstPort);
        session.setPassword(password);

        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        session.setConfig(sshConfig);
        session.connect(timeOut);
        return session;
    }

    /**
     * ???SSH§¿?ï…?????Linux Shell????§ß??????????????
     *
     * @param dstIp
     * @param dstport   default :22
     * @param localIp
     * @param localPort
     * @param timeOut
     * @param userName
     * @param password
     * @param cmds
     * @return
     * @throws Exception
     */
    public static String[] execShellCmdBySSH(String dstIp, int dstport,
                                             String localIp, int localPort, int timeOut, String userName,
                                             String password, String... cmds) throws Exception {
        Session session = null;
        Channel channel = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            session = createSession(dstIp, dstport, localIp, localPort, userName, password, timeOut);
            channel = session.openChannel("shell");

            channel.connect();
            is = channel.getInputStream();
            os = channel.getOutputStream();
            String[] result = new String[cmds.length];
            for (int i = 0; i < cmds.length; i++) {
                Thread.sleep(10000);
                result[i] = sendCommand(is, os, cmds[i]);
            }
            Thread.sleep(10000);
            System.out.println("status1:"+channel.getExitStatus());
            return result;
        } catch (JSchException e) {
            if (e.getMessage().contains("Auth fail")) {
                throw new Exception("Auth error");
            } else {
                throw new Exception("Connect error");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
            try {
                os.close();
            } catch (IOException e) {
            }
            Thread.sleep(10000);
            System.out.println("status2:"+channel.getExitStatus());
            channel.disconnect();
            session.disconnect();
        }
    }

    /**
     * ???Shell???????????§ß??
     *
     * @param is
     * @param os
     * @param cmd
     * @return
     * @throws IOException
     */
    private static String sendCommand(InputStream is, OutputStream os,
                                      String cmd) throws IOException {
        os.write(cmd.getBytes());
        os.flush();
        StringBuffer sb = new StringBuffer();
        int beat = 0;
        while (true) {
            if (beat > 3) {
                break;
            }
            if (is.available() > 0) {
                byte[] b = new byte[is.available()];
                is.read(b);
                sb.append(new String(b));
                beat = 0;
            } else {
                if (sb.length() > 0) {
                    beat++;
                }
                try {
                    Thread.sleep(sb.toString().trim().length() == 0 ? 1000 : 300);
                } catch (InterruptedException e) {
                }
            }
        }
        return sb.toString();
    }

}
