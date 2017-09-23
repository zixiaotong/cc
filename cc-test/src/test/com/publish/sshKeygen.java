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
        JSch jsch = new JSch(); // ����JSch����
        String userName = "root";// �û���
        String password = "zhtx1.q";// ����
        String host = "192.168.102.185";// ��������ַ
        int port = 22;// �˿ں�
        String cmd = "ssh -l root 192.168.102.190;ifconfig";// Ҫ���е�����

        Session session = jsch.getSession(userName, host, port); // �����û���������ip���˿ڻ�ȡһ��Session����
        session.setPassword(password); // ��������
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // ΪSession��������properties
        int timeout = 60000000;
        session.setTimeout(timeout); // ����timeoutʱ��
        session.connect(); // ͨ��Session��������
        ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.connect();
        int exitStatus = channelExec.getExitStatus();
        System.out.println("1exitStatus��" + exitStatus);
        InputStream in = channelExec.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String buf = null;
        StringBuffer sb = new StringBuffer();
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
            System.out.println("buf:" + buf);
        }
        int exitStatus1 = channelExec.getExitStatus();
        System.out.println("2exitStatus��" + exitStatus1);
        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }
    }
}
