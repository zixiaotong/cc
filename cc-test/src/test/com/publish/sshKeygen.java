package com.publish;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import com.github.odiszapc.nginxparser.NgxConfig;
import com.github.odiszapc.nginxparser.NgxDumper;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/7/31.
 */
public class sshKeygen {

    @Test
    public void test1() throws Exception {
        JSch jsch = new JSch(); // 创建JSch对象
        String userName = "root";// 用户名
        String password = "zhtx1.q";// 密码
        String host = "192.168.102.185";// 服务器地址
        int port = 22;// 端口号
        String cmd = "ssh -l root 192.168.102.190;ifconfig";// 要运行的命令

        Session session = jsch.getSession(userName, host, port); // 根据用户名，主机ip，端口获取一个Session对象
        session.setPassword(password); // 设置密码
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        int timeout = 60000000;
        session.setTimeout(timeout); // 设置timeout时间
        session.connect(); // 通过Session建立链接
        ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.connect();
        int exitStatus = channelExec.getExitStatus();
        System.out.println("1exitStatus：" + exitStatus);
        InputStream in = channelExec.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String buf = null;
        StringBuffer sb = new StringBuffer();
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
            System.out.println("buf:" + buf);
        }
        int exitStatus1 = channelExec.getExitStatus();
        System.out.println("2exitStatus：" + exitStatus1);
        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }
    }
}
