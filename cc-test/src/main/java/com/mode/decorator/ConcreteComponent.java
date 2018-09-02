package com.mode.decorator;

/**
 * @author shanglei
 * @date 2018/8/31 17:37
 */
public class ConcreteComponent implements Component {
    @Override
    public void method() {
        System.out.println("原来的方法");
    }
}
