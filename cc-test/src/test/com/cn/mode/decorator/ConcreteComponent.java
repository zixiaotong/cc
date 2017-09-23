package com.cn.mode.decorator;

/**
 * Created by shanglei on 2017/6/12.
 */
public class ConcreteComponent implements Component {
    @Override
    public void method() {
        System.out.println("ConcreteComponent method");
    }
}
