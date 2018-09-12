package com.thread.floor;

/**
 * @author shanglei
 * @date 2018/9/12 14:13
 */
public class Thread123 {

    public static void main(String[] args) {

        final Print business = new Print();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    business.print_1();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    business.print_2();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    business.print_3();
                }
            }
        }).start();

    }
}

class Print {
    private boolean should_1 = true;
    private boolean should_2;
    private boolean should_3;

    public synchronized void print_1() {
        while (should_2 || should_3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("1");
        should_1 = false;
        should_2 = true;
        should_3 = false;
        notifyAll();
    }

    public synchronized void print_2() {
        while (should_1 || should_3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("2");
        should_1 = false;
        should_2 = false;
        should_3 = true;
        notifyAll();
    }

    public synchronized void print_3() {
        while (should_1 || should_2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("3");
        should_1 = true;
        should_2 = false;
        should_3 = false;
        notifyAll();
    }

}
