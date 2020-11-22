package com.loadclass;

/**
 * @author shanglei
 * @date 2018/7/26 11:41
 */
public class SSClass {
    static {
        System.out.println("SSClass");
    }
}

class SuperClass extends SSClass {
    static {
        System.out.println("SuperClass init!");
    }

    {
        System.out.println("NO static SuperClass init!");
    }

    public int value = 123;

    public SuperClass() {
        System.out.println("init SuperClass");
    }
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass() {
        System.out.println("init SubClass");
    }
}

class NotInitialization {
    public static void main(String[] args) {
        System.out.println(new SubClass().value);
    }
}
