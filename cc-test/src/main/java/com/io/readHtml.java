package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author shanglei
 * @date 2017/10/18.
 */
public class readHtml {

    /**
     * 读取txt文件的内容
     *
     * @return 返回文件内容
     */
    public static String txt2String() {
        File file = new File("/Users/shanglei/Downloads/zhanghetianxia/111.html");
        StringBuilder result = new StringBuilder();
        try {
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            //使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String result = txt2String();
        System.out.println("333:"+replace(result));
    }

    private static String replace(String result) {
        System.out.println(result.indexOf("  "));
        if (result.indexOf("  ") > 0) {
            return replace(result.replace("  ", " "));
        } else {
            return result;
        }
    }
}
