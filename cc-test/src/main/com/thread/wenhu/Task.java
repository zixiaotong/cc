package com.thread.wenhu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Task {
    /**
     * 每次抓取100条数据
     */
    static int num = 100;

    /**
     * 任务线程数据
     */
    static int threadNum = 4;

    /**
     * 数据源 线程安全的map
     */
    private static ConcurrentHashMap<String, OrderTest> map = new ConcurrentHashMap<>();

    public static void init() {
        // 添加数据
        for (int i = 0; i < num; i++) {
            OrderTest orderTest = new OrderTest();
            orderTest.setLId(Long.valueOf(i));
            orderTest.setStrTaskName("task" + i);
            orderTest.setNState(0);
            orderTest.setDtHandleTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            map.put(String.valueOf(i), orderTest);
        }
    }

    /**
     * 任务计数器
     */
    private static CountDownLatch taskCount = new CountDownLatch(num);

    /**
     * 任务计数器
     */
    private static CountDownLatch selectCount = new CountDownLatch(1);

    /**
     * 数据容器
     */
    private static BlockingQueue<OrderTest> queue = new LinkedBlockingQueue<OrderTest>();

    private class ThreadMainClass implements Runnable {
        public void run() {
            while (true) {
                try {
                    selectCount.await(10, TimeUnit.MINUTES);
                    // 等待数据抓取
                    if (queue.size() == 0) {
                        System.out.println(Thread.currentThread().getId() + "队列为空");
                        Thread.sleep(10);
                        continue;
                    }
                    // 抓取数据
                    OrderTest data = queue.poll();
                    if (null == data) {
                        System.out.println(Thread.currentThread().getId() + "数据被其它线程获取");
                        Thread.sleep(10);
                        continue;
                    }

                    // 处理业务逻辑
                    data.setNState(1);
                    System.out.println(data + "do something!" + Thread.currentThread().getId());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 业务处理结束计数器减一
                    taskCount.countDown();
                }
            }
        }
    }

    /**
     * 获取数据线程
     *
     * @author Administrator
     */
    private class ThreadClass implements Runnable {

        public void run() {
            // 获取数据
            while (true) {
                try {
                    if (queue.size() > 0) {
                        taskCount.await(10, TimeUnit.MINUTES);
                        continue;
                    }

                    //					System.out.println("开始抓取数据-------------------------------");
                    // 新建查询计数器
                    selectCount = new CountDownLatch(1);
                    // 抓取数据
                    Set<String> key = map.keySet();
                    Iterator<String> iter = key.iterator();
                    while (iter.hasNext()) {
                        OrderTest orderTest = map.get(iter.next());
                        if (orderTest.getNState() == 0) {
                            System.out.println(orderTest.toString());
                            queue.offer(orderTest);
                        }
                    }
                    // 数据抓取结束，查询计数器关闭
                    selectCount.countDown();

                    // 数据获取完毕，新建任务处理计数器
                    taskCount = new CountDownLatch(queue.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 休眠等待任务执行结束
                    try {
                        taskCount.await(10, TimeUnit.MINUTES);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // 初始化数据
        init();
        // 执行任务
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        // 获取数据线程
        executor.execute(new Task().new ThreadClass());
        // 处理数据线程
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new Task().new ThreadMainClass());
        }
    }
}  