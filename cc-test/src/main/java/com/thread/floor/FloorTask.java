package com.thread.floor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.bean.User;

/**
 * @author shanglei
 * @date 2017/10/17.
 */
public class FloorTask {

    private static Map<Integer, String> map = new HashMap<>();
    private static int taskThreadNum = Runtime.getRuntime().availableProcessors() * 2;
    private static ExecutorService executorService = Executors.newFixedThreadPool(taskThreadNum);

    private static void run() {
        Long stat = System.currentTimeMillis();
        List<User> userList = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            User user = new User();
            user.setAge(i);
            user.setName(i + "zhanghe");
            userList.add(user);
        }
        //try {
            //final CountDownLatch cdl = new CountDownLatch(userList.size());
            for (User user : userList) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        String result = getResult(user.getAge());
                        if (result.contains("error") || result.contains("Exception")) {
                            return;
                        }
                        try {
                            String sHtml = map.get(user.getAge());
                            if (sHtml == null) {
                                wirteFile(user.getAge(), result);
                            } else {
                                if (!sHtml.equals(result)) {
                                    wirteFile(user.getAge(), result);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //cdl.countDown();
                        //System.out.println("getCount:"+cdl.getCount());
                    }
                });
            }
            //cdl.await(50, TimeUnit.SECONDS);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        System.out.println(System.currentTimeMillis() - stat + "毫秒");
    }

    private static String getResult(Integer i) {
        String result = "zhanghetianxia";
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (i.intValue() == 5) {
            result = "Exception";
        }
        return result;
    }

    private static synchronized void wirteFile(int id, String result) throws IOException {
        String floorPath = "/Users/shanglei/Downloads/zhanghetianxia/testFile";
        List<String> arrayList = new ArrayList<>();
        if (floorPath.contains(",")) {
            String[] split = floorPath.split(",");
            for (String sarr : split) {
                arrayList.add(sarr);
            }
        } else {
            arrayList.add(floorPath);
        }
        for (String sarr : arrayList) {
            File filepath = new File(sarr);
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            File filename = new File(sarr + "/" + id + ".html");
            if (!filename.exists()) {
                filename.createNewFile();
            }
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filename), "utf-8");
            System.out.println(Thread.currentThread().getName() + "正在消费list的id是" + id);
            osw.write(result);
            osw.flush();
            osw.close();
        }
        map.put(id, result);
    }

    public static void main(String[] args) {
        run();
    }
}
