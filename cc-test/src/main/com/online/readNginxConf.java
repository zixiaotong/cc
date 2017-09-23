package com.online;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.github.odiszapc.nginxparser.NgxBlock;
import com.github.odiszapc.nginxparser.NgxConfig;
import com.github.odiszapc.nginxparser.NgxDumper;
import com.github.odiszapc.nginxparser.NgxParam;
import com.github.odiszapc.nginxparser.NgxToken;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/7/26.
 */
public class readNginxConf {
    /**
     * ��ȡnginx�����ļ�
     */
    @Test
    public void test1() throws Exception {
        JSch jsch = new JSch();
        String userName = "root";
        String password = "zhtx1.q";
        String host = "192.168.102.146";
        int port = 8802;
        String cmd = "cat /usr/local/nginx/conf/nginx.conf";
        Session session = jsch.getSession(userName, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        int timeout = 60000000;
        session.setTimeout(timeout);
        session.setConfig("userauth.gssapi-with-mic", "no");
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        NgxConfig conf = NgxConfig.read(in);
        //NgxConfig conf = NgxConfig.read("/Users/shanglei/Downloads/nginx.conf");
        //��ʽ�������ļ�
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);

        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }
    }

    @Test
    public void test2() throws Exception {
        JSch jsch = new JSch();
        String userName = "root";
        String password = "zhtx1.q";
        String host = "192.168.102.190";
        int port = 22;
        String cmd = "nginx -t -c /usr/local/nginx/conf/nginx.conf";
        Session session = jsch.getSession(userName, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        int timeout = 60000000;
        session.setTimeout(timeout);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.setInputStream(null);
        channelExec.setErrStream(System.err);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String buf1 = null;
        while ((buf1 = reader1.readLine()) != null) {
            System.out.println("buf1:" + buf1);
        }
        Thread.sleep(1000);
        System.out.println(channelExec.getExitStatus());
        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }
    }

    /**
     * ����upstream ���� server
     * ����Ƴ��ڵ�
     *
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        NgxConfig conf = NgxConfig.read("/Users/shanglei/Downloads/nginx.conf1");
        ArrayList arrayList = (ArrayList)conf.getEntries();
        NgxBlock ngxBlock = conf.findBlock("http");
        ArrayList arrayList1 = (ArrayList)ngxBlock.getEntries();

        for (int i = 0; i < arrayList1.size(); i++) {
            if ("upstream chaoshi.zhangheyun.com.online.cn {".equals(arrayList1.get(i).toString())) {
                ArrayList arrayList2 = (ArrayList)((NgxBlock)arrayList1.get(i)).getEntries();
                for (int j = 0; j < arrayList2.size(); j++) {
                    if (arrayList2.get(j).toString().equals("server 192.168.102.157:8079 weight=10;")) {
                        NgxParam ngxParam = new NgxParam();
                        ngxParam.addValue(new NgxToken("#server 192.168.102.191:8079 weight=12"));
                        arrayList2.remove(j);
                        arrayList2.add(j, ngxParam);
                    }
                    //else {
                    //    NgxParam ngxParam = new NgxParam();
                    //    ngxParam.addValue(new NgxToken("#" + arrayList2.get(j).toString() + ""));
                    //    arrayList2.remove(j);
                    //    arrayList2.add(j, ngxParam);
                    //}
                }
            }
        }
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);
    }

    @Test
    public void test4() throws IOException {
        NgxConfig conf = NgxConfig.read("/Users/shanglei/Downloads/nginx.conf");
        ArrayList arrayList = (ArrayList)conf.getEntries();
        NgxBlock ngxBlock = (NgxBlock)arrayList.get(7);
        ArrayList arrayList1 = (ArrayList)ngxBlock.getEntries();
        for (int i = 0; i < arrayList1.size(); i++) {
            if (arrayList1.get(i).toString().startsWith("upstream")) {
                System.out.println(arrayList1.get(i).toString().split(" ")[1]);
                ArrayList arrayList2 = (ArrayList)((NgxBlock)arrayList1.get(i)).getEntries();
                for (int j = 0; j < arrayList2.size(); j++) {
                    if (arrayList2.get(j).toString().startsWith("server")) {
                        System.out.println(arrayList2.size());
                    }
                }
            }
        }
    }
    public static void aaa(String s) throws Exception {
        JSch jsch = new JSch(); // ����JSch����
        String userName = "root";// �û���
        String password = "zhtx1.q";// ����
        String host = "192.168.102.190";// ��������ַ
        int port = 22;// �˿ں�
        String cmd = "cat " + s;// Ҫ���е�����
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
        InputStream in = channelExec.getInputStream();
        NgxConfig conf = NgxConfig.read(in);
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);

        ArrayList arrayList1 = (ArrayList)conf.getEntries();
        for (int i = 0; i < arrayList1.size(); i++) {
            if (arrayList1.get(i).toString().startsWith("upstream")) {
                System.out.println(arrayList1.get(i).toString().split(" ")[1]);
                ArrayList arrayList2 = (ArrayList)((NgxBlock)arrayList1.get(i)).getEntries();
                for (int j = 0; j < arrayList2.size(); j++) {
                    if (arrayList2.get(j).toString().startsWith("server")) {
                        System.out.println(arrayList2.size());
                    }
                }
            }
        }
        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }
    }

    @Test
    public void test6() {
        List<String> pathList = new ArrayList<>();
        for (String s : pathList) {
            System.out.println("4");
            System.out.println(s);
        }
    }

    @Test
    public void test7() throws Exception {
        JSch jsch = new JSch(); // ����JSch����
        String userName = "root";// �û���
        String password = "zhtx1.q";// ����
        String host = "192.168.102.190";// ��������ַ
        int port = 22;// �˿ں�
        String cmd = "cat /usr/local/nginx/conf/nginx_ccoop.conf";// Ҫ���е�����
        Session session = jsch.getSession(userName, host, port); // �����û���������ip���˿ڻ�ȡһ��Session����
        session.setPassword(password); // ��������
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // ΪSession��������properties
        int timeout = 60000000;
        session.setTimeout(timeout); // ����timeoutʱ��
        session.setConfig("userauth.gssapi-with-mic", "no");
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect(); // ͨ��Session��������
        ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        //��ʽ�������ļ�
        NgxConfig conf = NgxConfig.read(in);
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);


        File filename = new File("/Users/shanglei/Downloads/nginx_back.conf");
        if (!filename.exists()) {
            filename.createNewFile();
        }

        PrintStream ps = new PrintStream(new FileOutputStream(filename));
        NgxDumper ngxDumper = new NgxDumper(conf);
        //ngxDumper.writeToStream(conf, ps, int level);

        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }
    }


    @Test
    public void test8() throws Exception {
        JSch jsch = new JSch();
        String userName = "root";
        String password = "zhtx1.q";
        //String host = "192.168.102.157";// ��������ַ
        String host = "192.168.102.146";// ��������ַ
        //String host = "192.168.102.190";
        int port = 8802;
        String cmd = "/usr/local/nginx/sbin/nginx -s reload";
        //String cmd = "cd /root";
        //String cmd1 = "cat /usr/zhtx/yuncom/fwzweb/fwz/css/details.css";// Ҫ���е�����
        Session session = jsch.getSession(userName, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setTimeout(60000000);
        //session.setConfig("userauth.gssapi-with-mic", "no");
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect(); // ͨ��Session��������
        ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String buf = null;
        StringBuffer sb = new StringBuffer();
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
            System.out.println("buf:" + buf);
        }
        reader.close();
        Thread.sleep(1);
        System.out.println("exitStatus��" + channelExec.getExitStatus());
        channelExec.disconnect();
        System.out.println("exitStatus��" + channelExec.getExitStatus());
        if (null != session) {
            session.disconnect();
            System.out.println("exitStatus��" + channelExec.getExitStatus());
        }
        System.out.println("exitStatus��" + channelExec.getExitStatus());
        //�������0����˵����ִ��sh�ű��ɹ���
    }

    @Test
    public void test9()  throws Exception{
        JSch jsch = new JSch();
        String userName = "root";
        String password = "zhtx1.q";
        String host = "192.168.102.146";
        int port = 8802;
        //String cmd = "/usr/local/nginx/sbin/nginx -s reload";
        String cmd = "ssh -p 8802 root@192.168.102.147 #p;pwd";
        Session session = jsch.getSession(userName, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setTimeout(6000);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String buf = null;
        StringBuffer sb = new StringBuffer();
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
            System.out.println("buf:" + buf);
        }
        reader.close();
        Thread.sleep(1);
        System.out.println("exitStatus��" + channelExec.getExitStatus());
        channelExec.disconnect();
        System.out.println("exitStatus��" + channelExec.getExitStatus());
        if (null != session) {
            session.disconnect();
            System.out.println("exitStatus��" + channelExec.getExitStatus());
        }
        System.out.println("exitStatus��" + channelExec.getExitStatus());
        //�������0����˵����ִ��sh�ű��ɹ���
    }

    @Test
    public void test10()  throws Exception{
        JSch jsch = new JSch();
        String userName = "root";
        String password = "zhtx1.q";
        String host = "192.168.102.146";
        int port = 22;
        String cmd = "sh /usr/local/test/9_ng.sh";
        Session session = jsch.getSession(userName, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setTimeout(6000);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String buf;
        StringBuffer sb = new StringBuffer();
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
            System.out.println(buf);
        }
        reader.close();
        Thread.sleep(1);
        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }
        System.out.println("exitStatus��" + channelExec.getExitStatus());
        //�������0����˵����ִ��sh�ű��ɹ���
    }
}
