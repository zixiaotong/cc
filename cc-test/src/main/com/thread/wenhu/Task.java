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
     * ÿ��ץȡ100������
     */
    static int num = 100;

    /**
     * �����߳�����
     */
    static int threadNum = 4;

    /**
     * ����Դ �̰߳�ȫ��map
     */
    private static ConcurrentHashMap<String, OrderTest> map = new ConcurrentHashMap<>();

    public static void init() {
        // �������
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
     * ���������
     */
    private static CountDownLatch taskCount = new CountDownLatch(num);

    /**
     * ���������
     */
    private static CountDownLatch selectCount = new CountDownLatch(1);

    /**
     * ��������
     */
    private static BlockingQueue<OrderTest> queue = new LinkedBlockingQueue<OrderTest>();

    private class ThreadMainClass implements Runnable {
        public void run() {
            while (true) {
                try {
                    selectCount.await(10, TimeUnit.MINUTES);
                    // �ȴ�����ץȡ
                    if (queue.size() == 0) {
                        System.out.println(Thread.currentThread().getId() + "����Ϊ��");
                        Thread.sleep(10);
                        continue;
                    }
                    // ץȡ����
                    OrderTest data = queue.poll();
                    if (null == data) {
                        System.out.println(Thread.currentThread().getId() + "���ݱ������̻߳�ȡ");
                        Thread.sleep(10);
                        continue;
                    }

                    // ����ҵ���߼�
                    data.setNState(1);
                    System.out.println(data + "do something!" + Thread.currentThread().getId());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // ҵ���������������һ
                    taskCount.countDown();
                }
            }
        }
    }

    /**
     * ��ȡ�����߳�
     *
     * @author Administrator
     */
    private class ThreadClass implements Runnable {

        public void run() {
            // ��ȡ����
            while (true) {
                try {
                    if (queue.size() > 0) {
                        taskCount.await(10, TimeUnit.MINUTES);
                        continue;
                    }

                    //					System.out.println("��ʼץȡ����-------------------------------");
                    // �½���ѯ������
                    selectCount = new CountDownLatch(1);
                    // ץȡ����
                    Set<String> key = map.keySet();
                    Iterator<String> iter = key.iterator();
                    while (iter.hasNext()) {
                        OrderTest orderTest = map.get(iter.next());
                        if (orderTest.getNState() == 0) {
                            System.out.println(orderTest.toString());
                            queue.offer(orderTest);
                        }
                    }
                    // ����ץȡ��������ѯ�������ر�
                    selectCount.countDown();

                    // ���ݻ�ȡ��ϣ��½������������
                    taskCount = new CountDownLatch(queue.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // ���ߵȴ�����ִ�н���
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
        // ��ʼ������
        init();
        // ִ������
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        // ��ȡ�����߳�
        executor.execute(new Task().new ThreadClass());
        // ���������߳�
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new Task().new ThreadMainClass());
        }
    }
}  