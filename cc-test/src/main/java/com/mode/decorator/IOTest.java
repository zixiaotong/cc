package com.mode.decorator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PushbackInputStream;
import java.io.PushbackReader;

/**
 * Created by shanglei on 2017/6/12.
 */
public class IOTest {

    public static void main(String[] args) throws IOException {
        final String filePath = "E:/myeclipse project/POITest/src/com/decorator/com.online.cn.test.test.txt";

        InputStream inputStream = new FileInputStream(filePath);
        final int len = inputStream.available();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedInputStream.mark(0);
        char c = (char)bufferedInputStream.read();
        bufferedInputStream.reset();
        c = (char)bufferedInputStream.read();
        bufferedInputStream.reset();
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        dataInputStream.reset();
        int value = dataInputStream.readInt();
        String binary = Integer.toBinaryString(value);
        int first = binary.length() % 8;
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                System.out.print(((char)Integer.valueOf(binary.substring(0, first), 2).intValue()));
            } else {
                System.out.print(((char)Integer.valueOf(binary.substring((i - 1) * 8 + first, i * 8 + first), 2)
                    .intValue()));
            }
        }
        System.out.println();

        System.out.println("---------------------------------------------------------------------------------");

        inputStream = new FileInputStream(filePath);
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, len);
        byte[] bytes = new byte[len];
        pushbackInputStream.read(bytes);
        pushbackInputStream.unread(bytes);
        bytes = new byte[len];
        pushbackInputStream.read(bytes);

        inputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
        inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        PushbackReader pushbackReader = new PushbackReader(inputStreamReader, len);
        char[] chars = new char[len];
        pushbackReader.read(chars);
        pushbackReader.unread(chars);
        chars = new char[len];
        pushbackReader.read(chars);
    }
}
