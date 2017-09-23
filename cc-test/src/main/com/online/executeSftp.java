package com.online;

import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/8/29.
 */
public class executeSftp {

    @Test
    public void test1() {
        Session session = null;
        Channel channel = null;ChannelSftp sftp =null;
        try {
            JSch jsch = new JSch();
            String userName = "root";
            String password = "zhtx1.q";
            String host = "192.168.72.146";
            int port = 8802;
            session = jsch.getSession(userName, host, port);
            session.setPassword(password);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setTimeout(60000000);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect(100000);
            sftp = (ChannelSftp)channel;
            sftp.cd("/usr/local/nginx/conf/toolsback");

            //sftp.put("/Users/shanglei/Downloads/a.html", "/usr/local/nginx/conf/s/a.html");
            Vector v = sftp.ls("*itrg0Tbw6cM_192.168.200.93:8002");
            for (int i = 0; i < v.size(); i++) {
                Object s = v.get(i);
                System.out.println(s.toString());
            }
            //OutputStream outstream = sftp.put("a.html");
            //sftp.rename("/root/a.html","/root/a.html12121");

            //sftp.put("/Users/shanglei/Downloads/a.html","/root/a.html");

            //InputStream instream = new FileInputStream(new File("/Users/shanglei/Downloads/a.html"));
            //byte b[] = new byte[1024];
            //int n;
            //while ((n = instream.read(b)) != -1) {
            //    outstream.write(b, 0, n);
            //}
            //outstream.flush();
            //outstream.close();
            //instream.close();
            //Thread.sleep(1000);
            //System.out.println(sftp.getExitStatus());
        } catch (Exception e) {
            e.printStackTrace();
            //try {
            //    sftp.mkdir("/usr/local/nginx/conf/s");
            //} catch (SftpException e1) {
            //    System.out.println("d");
            //   // e1.printStackTrace();
            //}
        } finally {
            session.disconnect();
            channel.disconnect();
        }

    }


    @Test
    public void test2() {
        Session session = null;
        Channel channel = null;ChannelSftp sftp =null;
        try {
            JSch jsch = new JSch();
            String userName = "root";
            String password = "zhtx1.q";
            String host = "192.168.72.146";
            int port = 8802;
            session = jsch.getSession(userName, host, port);
            session.setPassword(password);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setTimeout(60000000);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect(100000);
            sftp = (ChannelSftp)channel;
            sftp.cd("/usr/local/nginx/conf/toolsback");

            //sftp.put("/Users/shanglei/Downloads/a.html", "/usr/local/nginx/conf/s/a.html");
            //Vector v = sftp.ls("*itrg0Tbw6cM_192.168.200.93:8002");
            //for (int i = 0; i < v.size(); i++) {
            //    Object s = v.get(i);
            //    System.out.println(s.toString());
            //}
            Thread.sleep(1000);
            System.out.println(sftp.getExitStatus());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.disconnect();
            channel.disconnect();
        }

    }
}