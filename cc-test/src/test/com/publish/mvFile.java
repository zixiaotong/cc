package com.publish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.publish.utils.JschUtils;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/7/31.
 */
public class mvFile {

    @Test
    public void test() throws IOException {
        /**
         * �ƶ��ļ�
         */
        //String command = "cd /usr/shangleitest;mv bin /usr/shangleitest/apache-tomcat-7.0.73";
        /**
         * �����ļ�
         */
        //String command = "cd /usr/shangleitest/apache-tomcat-7.0.73;cp RUNNING.txt /usr/shangleitest/";

        /**
         * ��ͨ���������ļ�
         */
        String command = "cd /usr/shangleitest;scp RUNNING.txt root@192.168.102.79:/usr/";
        InputStream in = JschUtils.executeExec("192.168.102.185", 22, "root",
            "zhtx1.q", 600000, command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String buf;
        StringBuffer sb = new StringBuffer();
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
            System.out.println("buf:" + buf);
        }
    }
}
