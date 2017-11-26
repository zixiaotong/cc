package com.online;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.utils.JDBCUtils;

/**
 * @author shanglei
 * @date 2017/7/20.
 */
public class readSh {

    /**
     * �õ��ű���ӡ�����
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        JSch jsch = new JSch(); // ����JSch����
        String userName = "root";// �û���
        String password = "zhtx1.q";// ����
        //String host = "192.168.102.185";// ��������ַ
        String host = "192.168.102.157";// ��������ַ
        int port = 22;// �˿ں�
        // String cmd = "sh /usr/local/autodeploy/web_status.sh";// Ҫ���е�����
        /*
        ������ʱ������һ������1��
        Neither the JAVA_HOME nor the JRE_HOME environment variable is definedAt least one of these environment
        variable is needed to run this program
         �ȿ�Tomcat��startup.bat����������catalina.bat,��catalina.bat�������setclasspath.bat��ֻҪ��setclasspath.bat�Ŀ�ͷ������������ ���ɡ�
         ��tomcat��binĿ¼�����setclasspath.sh
         export JAVA_HOME=/usr/java/jdk1.8.0_51
         export JRE_HOME=$JAVA_HOME/jre

         ��������2��
         a�ű�����b�ű���b�ű�����c�ű� ����������ýű�����Ҫд�Ͻű�ȫ·����
         */
        //String cmd = "sh /data/apache-tomcat-7.0.73shangleitest/bin/startup.sh";// Ҫ���е�����
        String cmd = "sh /usr/local/test/1_kill_tomcat.sh myaccountweb /data/tomcat/_myaccountweb webapps ROOT.war http://192.168.102.157:8079/alert/heart /usr/local/test/ 192.168.102.157";// Ҫ���е�����
        //String cmd = "sh /data/apache-tomcat-7.0.73shangleitest/bin/a.sh";// Ҫ���е�����
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
        //channelExec.setInputStream(null);
        //channelExec.setErrStream(System.err);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String buf;
        StringBuffer stringBuffer = new StringBuffer();
        // �������������
        List<String> lists = new ArrayList<>();
        while ((buf = reader.readLine()) != null) {
            lists.add(buf);
            stringBuffer.append(buf + "\n");
            if (lists.size() == 4) {

                String sql = "insert into `tstorddb`.`runlog` \n"
                    + "( `app`, `serverip`, `createdate`, `log`, `deployid`) \n"
                    + "values ( 'csweb', '192.168.19.89', NOW(), '" + stringBuffer.toString() + "', '4343434');";

                JDBCUtils.insertData(sql);

                System.out.println("sql:" + sql);
                lists.clear();
                stringBuffer.delete(0, stringBuffer.length());
            }
        }
        String sql1 = "insert into `tstorddb`.`runlog` \n"
            + "( `app`, `serverip`, `createdate`, `log`, `deployid`) \n"
            + "values ( 'csweb', '192.168.19.89', NOW(), '" + stringBuffer.toString() + "', '4343434');";

        JDBCUtils.insertData(sql1);
        int exitStatus = channelExec.getExitStatus();
        System.out.println("exitStatus��" + exitStatus);//�������0����˵����ִ��sh�ű��ɹ���
        reader.close();
        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }
    }

}
