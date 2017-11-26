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
     * 拿到脚本打印的输出
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        JSch jsch = new JSch(); // 创建JSch对象
        String userName = "root";// 用户名
        String password = "zhtx1.q";// 密码
        //String host = "192.168.102.185";// 服务器地址
        String host = "192.168.102.157";// 服务器地址
        int port = 22;// 端口号
        // String cmd = "sh /usr/local/autodeploy/web_status.sh";// 要运行的命令
        /*
        在启动时遇到了一个问题1：
        Neither the JAVA_HOME nor the JRE_HOME environment variable is definedAt least one of these environment
        variable is needed to run this program
         先看Tomcat的startup.bat，它调用了catalina.bat,而catalina.bat则调用了setclasspath.bat。只要在setclasspath.bat的开头声明环境变量 即可、
         打开tomcat的bin目录下面的setclasspath.sh
         export JAVA_HOME=/usr/java/jdk1.8.0_51
         export JRE_HOME=$JAVA_HOME/jre

         遇到问题2：
         a脚本调用b脚本，b脚本调用c脚本 的情况，调用脚本中需要写上脚本全路径。
         */
        //String cmd = "sh /data/apache-tomcat-7.0.73shangleitest/bin/startup.sh";// 要运行的命令
        String cmd = "sh /usr/local/test/1_kill_tomcat.sh myaccountweb /data/tomcat/_myaccountweb webapps ROOT.war http://192.168.102.157:8079/alert/heart /usr/local/test/ 192.168.102.157";// 要运行的命令
        //String cmd = "sh /data/apache-tomcat-7.0.73shangleitest/bin/a.sh";// 要运行的命令
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
        //channelExec.setInputStream(null);
        //channelExec.setErrStream(System.err);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        String buf;
        StringBuffer stringBuffer = new StringBuffer();
        // 用来存放总数据
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
        System.out.println("exitStatus：" + exitStatus);//如果返回0，则说明，执行sh脚本成功。
        reader.close();
        channelExec.disconnect();
        if (null != session) {
            session.disconnect();
        }
    }

}
