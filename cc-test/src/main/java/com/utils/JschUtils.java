package com.utils;

import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * @author shanglei
 * @date 2017/7/31.
 */
public class JschUtils {

    public static InputStream executeExec(String host, int port, String userName, String password, int timeout,
                                          String command) {
        ChannelExec channelExec = null;
        InputStream inputStream = null;
        try {
            Session session = getSession(host, port, userName, password, timeout);
            channelExec = (ChannelExec)session.openChannel("exec");
            channelExec.setCommand(command);
            channelExec.setInputStream(null);
            channelExec.setErrStream(System.err);
            channelExec.connect();
            inputStream = channelExec.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public static Session getSession(String host, int port, String userName, String password, int timeout) {
        Session session = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(userName, host, port);
            session.setPassword(password);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            // 为Session对象设置properties
            session.setConfig(config);
            session.setTimeout(timeout);
            // 通过Session建立链接
            session.connect(30*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
}
