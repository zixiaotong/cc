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
     * 拿到日志文件打印的输出
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        JSch jsch = new JSch(); // 创建JSch对象
        String userName = "root";// 用户名
        String password = "zhtx1.q";// 密码
        String host = "192.168.102.51";// 服务器地址
        int port = 22;// 端口号
        String cmd = "tail -f /data/tomcat_user/logs/catalina.out";// 要运行的命令
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
        channelExec.setInputStream(null);
        channelExec.setErrStream(System.err);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));

        StringBuffer stringBuffer = new StringBuffer();
        // 用来存放总数据
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
        System.out.println("exitStatus：" + exitStatus);//如果返回0，则说明，执行sh脚本完毕。

        reader.close();
        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }
    }



}
