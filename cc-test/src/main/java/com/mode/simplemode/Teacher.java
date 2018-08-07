package com.mode.simplemode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shanglei
 */

public class Teacher {

    /**
     * 其他类不能创建该累对象
     */
    private Teacher() {}

    private static Object obj = new Object();

    private static Teacher t;

    public  Teacher getTeacher() {
        if (t == null) {
            synchronized (Teacher.class) {
                if (t == null) {
                    t = new Teacher();
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.getTeacher();
        //ExecutorService executorService = Executors.newFixedThreadPool(100);
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //executorService.execute(new Runnable() {
        //    @Override
        //    public void run() {
        //        while (true) {
        //            Teacher t1 = getTeacher();
        //            Teacher t2 = getTeacher();
        //            System.out.println(t1 == t2);
        //        }
        //    }
        //});
    }
}
