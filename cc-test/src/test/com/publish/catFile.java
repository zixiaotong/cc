package com.publish;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.publish.utils.JschUtils;

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
        //
        //String command1 = "pwd;";
        //InputStream in1 = JschUtils.executeExec("192.168.102.79", 22, "root",
        //    "zhtx1.q", 600000, command1);
        //BufferedReader reader1 = new BufferedReader(new InputStreamReader(in1, Charset.forName("UTF-8")));
        //String buf1 = null;
        //while ((buf1 = reader1.readLine()) != null) {
        //    System.out.println("buf1:" + buf1);
        //}


        //String command1 = "nginx -t -c /usr/local/nginx/conf/nginx.conf";
        //InputStream in1 = JschUtils.executeExec("192.168.102.190", 22, "root",
        //    "zhtx1.q", 600000, command1);
        //BufferedReader reader1 = new BufferedReader(new InputStreamReader(in1, Charset.forName("UTF-8")));
        //String buf1 = null;
        //while ((buf1 = reader1.readLine()) != null) {
        //    System.out.println("buf1:" + buf1);
        //}
    }
}
