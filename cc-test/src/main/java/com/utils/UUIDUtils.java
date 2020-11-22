package com.utils;

import java.util.UUID;

/**
 * @author shanglei
 * @date 2017/9/1.
 */
public class UUIDUtils {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String temp1 = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str
            .substring(24);
        String temp = str.substring(0, 8);
        return temp;
    }

    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

    public static void main(String[] args) {
        String[] ss = getUUID(1000000);
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i] + "----" + i);
            if (ss[i].equals(ss[i + 1])) {
                System.out.println(ss[i]);
                break;
            }
        }
    }
}
