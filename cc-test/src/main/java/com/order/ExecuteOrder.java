package com.order;

/**
 * Created by shanglei on 2017/6/7.
 */
public class ExecuteOrder {

    public static void main(String[] args) {
        //Abc.c();
        new Abc();
    }

}

class Abc {

    private final static int t = 0;

    Abc() {
        System.out.println("======���췽��=========");
    }

    public static void c() {
        System.out.println("==========��̬����===========");
    }

    static {
        int b = 2;
        System.out.println("=====��̬��======");
    }
    public static Bcd i = new Bcd();
}

class Bcd {
    Bcd() {
        System.out.println("======��̬��Ա����========");
    }
}