package com.thread.floor;

public class Test2 extends Thread {
    private boolean flag = true;
    private int count = 10;
    private static Object obj = new Object();

    public void run() {
        while (true) {
            synchronized (obj) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "..." + (count--));

            }
        }
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        Thread t1 = new Thread(t, " 1 ");
        Thread t2 = new Thread(t, " 2 ");
        Thread t3 = new Thread(t, " 3 ");
        t1.start();
        t2.start();
        t3.start();
    }
}
