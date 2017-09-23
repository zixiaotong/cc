package com.publish;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * @author shanglei
 * @date 2017/7/20.
 */
public class uploadFile {

    /**
     * 上传文件 OK
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Session session = null;
        Channel channel = null;ChannelSftp sftp =null;
        try {
            JSch jsch = new JSch();
            String userName = "root";
            String password = "zhtx1.q";
            String host = "192.168.102.79";
            int port = 22;
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
            sftp.cd("/root");
            Vector v = sftp.ls("*.log");
            for (int i = 0; i < v.size(); i++) {
                String s = (String)v.get(i);
                System.out.println(s);

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
            System.out.println(sftp.getExitStatus());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.disconnect();
            channel.disconnect();
        }
    }

}
