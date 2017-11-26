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
public class readLog {

    /**
     * �õ���־�ļ���ӡ�����
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        JSch jsch = new JSch(); // ����JSch����
        String userName = "root";// �û���
        String password = "zhtx1.q";// ����
        String host = "192.168.102.51";// ��������ַ
        int port = 22;// �˿ں�
        String cmd = "tail -f /data/tomcat_user/logs/catalina.out";// Ҫ���е�����
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
        channelExec.setInputStream(null);
        channelExec.setErrStream(System.err);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));

        StringBuffer stringBuffer = new StringBuffer();
        // �������������
        List<String> lists = new ArrayList<String>();
        String buf;
        while ((buf = reader.readLine()) != null) {

            StringBuffer s = new StringBuffer(buf);
            for (int i = s.length()-1; i >=0; i--) {
                if (String.valueOf(s.charAt(i)).equals("'")) {
                    s.insert(i,"\\");
                }
            }
            buf=s.toString();

            lists.add(buf);
            stringBuffer.append(buf + "\n");
            if (lists.size() == 30) {

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
        System.out.println("exitStatus��" + exitStatus);//�������0����˵����ִ��sh�ű���ϡ�

        reader.close();
        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }
    }



}
