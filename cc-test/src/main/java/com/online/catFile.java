package com.online;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.utils.JschUtils;

/**
 * @author shanglei
 * @date 2017/7/20.
 */
public class catFile {

    /**
     * 执行多条命令，返回查看的文件内容
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //String command = "cat /usr/zhtx/yuncom/fwzweb/fwz/css/details.css";
        String command = "ifconfig";
        InputStream in = JschUtils.executeExec("192.168.72.111", 22, "root",
            "123456", 600000, command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String buf = null;
        StringBuffer sb = new StringBuffer();
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
            System.out.println("buf:" + buf);
        }

    }
}
