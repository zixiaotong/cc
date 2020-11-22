package com.thread.floor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shanglei
 * @date 2018/9/13 10:07
 */
public class MultiThread2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Thread1());
        executor.submit(new Thread2());
        executor.submit(new Thread3());
        executor.shutdown();
    }

    public static class Thread1 implements Runnable {
        @Override
        public void run() {
            while (true){

                System.out.println("Thread1");
            }
        }
    }

    public static class Thread2 implements Runnable {
        @Override
        public void run() {
            while (true){
                System.out.println("Thread2");
            }
        }
    }

    public static class Thread3 implements Runnable {
        @Override
        public void run() {
            while (true){
                System.out.println("Thread3");
            }

        }
    }
}
