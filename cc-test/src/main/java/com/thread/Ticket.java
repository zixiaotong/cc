package com.thread;

/*
 * 同步代码块：
 * 		synchronized(对象){
 * 			被同步的代码。
 * 		}
 *
 * 		问题：
 * 			A:对象是谁?
 * 				如果我们不知道，我们就用Object的对象。
 * 			B:被同步的代码是哪些?
 * 				哪里导致程序出问题，就加在哪里。
 * 				那么，哪里会导致出问题呢?
 * 					请参照我刚才讲解的三个产生线程问题的原因。
 *
 * 		注意：
 * 			这个同步解决问题的最重要的原理就在那个对象上。
 * 			因为这个对象就是一把锁。它可以把代码锁起来。
 * 			解决问题的时候，一定要注意，多个线程使用的锁必须是同一把。
 */
public class Ticket implements Runnable {

    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // t1,t2,t3,t4
            // ticket=1,假设t1抢到
            // 当代码走到这里，一看同步，就知道代码将来有锁。
            // 但是，现在只有t1来了，这个标记现在是0。
            // t1就进去了，一进去，把标记改为1。
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        // t1睡眠
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                        + "正在出售第" + (ticket--) + "张票");
                }
            }
            // t1出来了
        }
    }
}
