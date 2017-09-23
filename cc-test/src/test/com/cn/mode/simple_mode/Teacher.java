package com.cn.mode.simple_mode;

/**
 * @author shanglei
 */ /*
 * 面试题：（懒汉式）
 *
 * 		请写出一个单例设计模式。
 * 		开发：饿汉式
 * 		面试：懒汉式
 * 				A:延迟加载。什么时候用，什么时候造。
 * 				B:线程安全问题。
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
