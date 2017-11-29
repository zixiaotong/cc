package com.mode.simple_mode;

/**
 * @author shanglei
 */ /*
 * �����⣺������ʽ��
 *
 * 		��д��һ���������ģʽ��
 * 		����������ʽ
 * 		���ԣ�����ʽ
 * 				A:�ӳټ��ء�ʲôʱ���ã�ʲôʱ���졣
 * 				B:�̰߳�ȫ���⡣
 */
public class Teacher {
    private Teacher() {
    }

    private static Object obj = new Object();

    private static Teacher t = null;

    public static Teacher getTeacher() {
        synchronized (obj) {
            // t1,t2,t3
            if (t == null) {
                // t1,t2,t3
                t = new Teacher();
            }
        }
        return t;
    }

    public void show() {
        System.out.println("show");
    }
}
