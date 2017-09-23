package com.publish;

import net.neoremind.sshxcute.core.ConnBean;
import net.neoremind.sshxcute.core.Result;
import net.neoremind.sshxcute.core.SSHExec;
import net.neoremind.sshxcute.exception.TaskExecFailException;
import net.neoremind.sshxcute.task.CustomTask;
import net.neoremind.sshxcute.task.impl.ExecCommand;
import net.neoremind.sshxcute.task.impl.ExecShellScript;

/**
 * @author shanglei
 * @date 2017/7/24.
 */
public class sshexec {

    public static void main(String[] args) {
        // 新建一个 SSHExec 引用
        SSHExec ssh = null;
        // 下面所有的代码都放在 try-catch 块中
        try {
            String userName = "root";// 用户名
            String password = "zhtx1.q";// 密码
            String host = "192.168.102.185";// 服务器地址
            int port = 22;// 端口号
            //String cmd = "sh /usr/shangleitest/apache-tomcat-7.0.73/bin/shutdown.sh";// 要运行的命令
            String cmd = "sh /data/apache-tomcat-7.0.73shangleitest/bin/a.sh";// 要运行的命令


            // 实例化一个 ConnBean 对象，参数依次是 IP 地址、用户名和密码
            ConnBean cb = new ConnBean("192.168.102.185", "root","zhtx1.q");
            // 将刚刚实例化的 ConnBean 对象作为参数传递给 SSHExec 的单例方法得到一个 SSHExec 对象
            ssh = SSHExec.getInstance(cb);
            // 新建一个 ExecCommand 对象，引用必须是其继承的 CustomTask 类
            CustomTask ct1 = new ExecCommand("sh /data/apache-tomcat-7.0.73shangleitest/bin/a.sh");
            // 新建一个 ExecShellScript 对象，引用必须是其继承的 CustomTask 类
            //CustomTask ct2 = new ExecShellScript("/home/tsadmin","./sshxcute_test.sh","hello world");
            // 连接服务器
            ssh.connect();
            // 上传 shell 脚本到 /home/tsadmin 目录
            //ssh.uploadSingleDataToServer("data/sshxcute_test.sh", "/home/tsadmin");
            // 执行命令
            Result res = ssh.exec(ct1);
            // 执行脚本并且返回一个 Result 对象
            //Result res = ssh.exec(ct2);
            // 检查执行结果，如果执行成功打印输出，如果执行失败，打印错误信息
            if (res.isSuccess)
            {
                System.out.println("Return code: " + res.rc);
                System.out.println("sysout: " + res.sysout);
            }
            else
            {
                System.out.println("Return code: " + res.rc);
                System.out.println("error message: " + res.error_msg);
            }
        }
        catch (TaskExecFailException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            ssh.disconnect();
        }
    }

}
