package com.thread.blockingqueu;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author shanglei
 * @date 2018/8/27 17:05
 */
public class ArrayBlockingQueueDemo {
    private final static ArrayBlockingQueue<Apple> queue = new ArrayBlockingQueue<>(0);

    public static void main(String[] args) {

        float f = (float)3.4;
        System.out.println(f);
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("SDfdsf");

        //CountDownLatch cdl = new CountDownLatch(3);
        //cdl.countDown();
        //cdl.await(90, TimeUnit.SECONDS);

        //new Thread(new Producer(queue)).start();
        //new Thread(new Producer(queue)).start();
        //new Thread(new Consumer(queue)).start();
        //new Thread(new Consumer(queue)).start();
    }
}

class Apple {
    public Apple() {}
}

/**
 * 生产者线程
 */
class Producer implements Runnable {
    private final ArrayBlockingQueue<Apple> mAbq;

    Producer(ArrayBlockingQueue<Apple> arrayBlockingQueue) {
        this.mAbq = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            Produce();
        }
    }

    private void Produce() {
        try {
            Apple apple = new Apple();
            mAbq.put(apple);
            System.out.println("生产:" + apple);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 消费者线程
 */
class Consumer implements Runnable {

    private ArrayBlockingQueue<Apple> mAbq;

    Consumer(ArrayBlockingQueue<Apple> arrayBlockingQueue) {
        this.mAbq = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                comsume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void comsume() throws InterruptedException {
        Apple apple = mAbq.take();
        System.out.println("消费Apple=" + apple);

    }
}
