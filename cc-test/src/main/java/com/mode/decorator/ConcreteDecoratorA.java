package com.mode.decorator;

/**
 * Created by shanglei on 2017/6/12.
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public void methodA(){
        System.out.println("��װ����A��չ�Ĺ���");
    }

    @Override
    public void method(){
        System.out.println("��Ը÷�����һ��A��װ");
        super.method();
        System.out.println("A��װ����");
    }
}
