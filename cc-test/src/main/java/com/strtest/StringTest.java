package com.strtest;

import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/11/10.
 */
public class StringTest {
    @Test
    public void test1() {
        String s1 = new String("java");
        String s2 = new String("java");
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
    }

    @Test
    public void test2() {
        int x = 2114;
        int x1 = x / 1000;
        int x2 = x % 1000 / 100;
        int x3 = x % 100 / 10;
        int x4 = x % 10;
        System.out.println(x1 + ";" + x2 + ";" + x3 + ";" + x4);
    }

    @Test
    public void test3() {
       String str  = "yuwen";
        System.out.println(str.hashCode());
        System.out.println(str.hashCode());
    }
}

