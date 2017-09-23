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
        // �½�һ�� SSHExec ����
        SSHExec ssh = null;
        // �������еĴ��붼���� try-catch ����
        try {
            String userName = "root";// �û���
            String password = "zhtx1.q";// ����
            String host = "192.168.102.185";// ��������ַ
            int port = 22;// �˿ں�
            //String cmd = "sh /usr/shangleitest/apache-tomcat-7.0.73/bin/shutdown.sh";// Ҫ���е�����
            String cmd = "sh /data/apache-tomcat-7.0.73shangleitest/bin/a.sh";// Ҫ���е�����


            // ʵ����һ�� ConnBean ���󣬲��������� IP ��ַ���û���������
            ConnBean cb = new ConnBean("192.168.102.185", "root","zhtx1.q");
            // ���ո�ʵ������ ConnBean ������Ϊ�������ݸ� SSHExec �ĵ��������õ�һ�� SSHExec ����
            ssh = SSHExec.getInstance(cb);
            // �½�һ�� ExecCommand �������ñ�������̳е� CustomTask ��
            CustomTask ct1 = new ExecCommand("sh /data/apache-tomcat-7.0.73shangleitest/bin/a.sh");
            // �½�һ�� ExecShellScript �������ñ�������̳е� CustomTask ��
            //CustomTask ct2 = new ExecShellScript("/home/tsadmin","./sshxcute_test.sh","hello world");
            // ���ӷ�����
            ssh.connect();
            // �ϴ� shell �ű��� /home/tsadmin Ŀ¼
            //ssh.uploadSingleDataToServer("data/sshxcute_test.sh", "/home/tsadmin");
            // ִ������
            Result res = ssh.exec(ct1);
            // ִ�нű����ҷ���һ�� Result ����
            //Result res = ssh.exec(ct2);
            // ���ִ�н�������ִ�гɹ���ӡ��������ִ��ʧ�ܣ���ӡ������Ϣ
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
