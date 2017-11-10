package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/10/23.
 */
public class replaceStr {

    @Test
    public void test1() throws IOException {
        File file = new File("/Users/shanglei/Downloads/zhanghetianxia/floor/");
        File[] files = file.listFiles();
        for (File file2 : files) {
            // 读取文件内容
            String str = readFile(file2.getAbsolutePath());
            // 替换文件内容
            String repStr = replace(str);
            //替换空格
            String repStr2 = replace2(repStr);
            // 写入文件
            wirteFile(file2.getName(), repStr2);
        }
    }

    private static void wirteFile(String name, String atr) throws IOException {
        File filepath = new File("/Users/shanglei/Downloads/zhanghetianxia/floor2/");
        if (!filepath.exists()) {
            filepath.mkdirs();
        }
        File filename = new File("/Users/shanglei/Downloads/zhanghetianxia/floor2/" + name);
        if (!filename.exists()) {
            filename.createNewFile();
        }
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filename), "utf-8");
        osw.write(atr);
        osw.flush();
        osw.close();
    }

    private static String replace2(String result) {
        if (result.indexOf("  ") >= 0) {
            return replace(result.replace("  ", " "));
        } else {
            return result;
        }
    }

    private static String replace(String result) {
        if (result.indexOf("zhangheyun.cn") >= 0) {
            return replace(result.replace("zhangheyun.cn", "zhtxw.cn"));
        } else {
            return result;
        }
    }

    private String readFile(String str) throws IOException {
        FileInputStream file = new FileInputStream(str);
        InputStreamReader isr = new InputStreamReader(file, "UTF-8");
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(isr);
        String s;
        while ((s = br.readLine()) != null) {
            result.append(s);
        }
        br.close();
        return result.toString();
    }
}
