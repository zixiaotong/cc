package com.mode.simplemode;

/**
 * @author shanglei
 * @date 2017/6/8
 */
public class Singleton {

    private Singleton() {}

    public static Singleton getInstance() {
        return SingletonInstance.instance;
    }

    /**
     * 这种方式是在类加载的时候就初始化好。固然可以，但问题是初始化好不用，怎么办？浪费资源
     */
    private static class SingletonInstance {
        static Singleton instance = new Singleton();
    }

    public static void main(String[] args) {
        Singleton s = getInstance();
        Singleton s1 = getInstance();
        System.out.println(s == s1);
    }

}
