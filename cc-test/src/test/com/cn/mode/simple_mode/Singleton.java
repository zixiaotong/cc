package com.cn.mode.simple_mode;

/**
 *
 * @author shanglei
 * @date 2017/6/8
 * 懒汉式：
 * 推荐这种写法：
 *
 * 避免并发问题
 * 内部类延迟加载（使用的时候再加载），调用getInstance方法时候才加载
 */
public class Singleton {

    private Singleton() {}

    public static Singleton getInstance() {
        return SingletonInstance.instance;
    }

    private static class SingletonInstance {
        // 静态变量 调用的时候才会创建对象
        // 内部类的变量初始化是线程安全 这是jvm保证的

        static Singleton instance = new Singleton();
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s1 = Singleton.getInstance();
        System.out.println(s == s1);
    }

}
