package com.mode.simple_mode;

/**
 *
 * @author shanglei
 * @date 2017/6/8
 */
public class Singleton {

    private Singleton() {}

    public static Singleton getInstance() {
        return SingletonInstance.instance;
    }

    private static class SingletonInstance {

        static Singleton instance = new Singleton();
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s1 = Singleton.getInstance();
        System.out.println(s == s1);
    }

}
