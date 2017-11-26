package com.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 定义文件名，传数据
 *
 * @author shanglei
 * @date 2017/7/25.
 */
public class ReadWriteFileUtils {

    /**
     * 写文件.
     */
    public static void writeTxtFile(String path, String newData) throws IOException {
        File filename = new File(path);
        if (!filename.exists()) {
            filename.createNewFile();
        }
        String read;
        String readStr = "";
        try {
            FileReader fileread = new FileReader(filename);
            BufferedReader bufread = new BufferedReader(fileread);
            while ((read = bufread.readLine()) != null) {
                readStr = readStr + read + "\r\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //先读取原有文件内容，然后进行写入操作
        String filein = readStr + newData;
        RandomAccessFile mm = null;
        try {
            mm = new RandomAccessFile(filename, "rw");
            mm.write(filein.getBytes("UTF-8"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (mm != null) {
                try {
                    mm.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
    public static void addLogData(String data) throws IOException {
        // 路径及名称，需要再仔细斟酌定义
        writeTxtFile("/Users/shanglei/Downloads/suncity.txt", data);
    }
}
