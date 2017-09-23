package com.cn.mode.simple_mode;

/**
 *
 * @author shanglei
 * @date 2017/6/8
 * ����ʽ��
 * �Ƽ�����д����
 *
 * ���Ⲣ������
 * �ڲ����ӳټ��أ�ʹ�õ�ʱ���ټ��أ�������getInstance����ʱ��ż���
 */
public class Singleton {

    private Singleton() {}

    public static Singleton getInstance() {
        return SingletonInstance.instance;
    }

    private static class SingletonInstance {
        // ��̬���� ���õ�ʱ��Żᴴ������
        // �ڲ���ı�����ʼ�����̰߳�ȫ ����jvm��֤��

        static Singleton instance = new Singleton();
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s1 = Singleton.getInstance();
        System.out.println(s == s1);
    }

}
