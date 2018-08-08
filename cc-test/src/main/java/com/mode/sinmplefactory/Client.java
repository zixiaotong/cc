package com.mode.sinmplefactory;

/**
 * @author shanglei
 * @date 2018/8/7 14:13
 */
public class Client {
    public static void main(String[] args) {
        IProduct producta = Creator.createProduct("A");
        IProduct productb = Creator.createProduct("B");
        producta.method();
        productb.method();
    }
}
