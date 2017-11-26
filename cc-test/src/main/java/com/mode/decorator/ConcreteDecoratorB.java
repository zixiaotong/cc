package com.mode.decorator;

/**
 * Created by shanglei on 2017/6/12.
 */
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    public void methodB() {
        System.out.println("��װ����B��չ�Ĺ���");
    }

    @Override
    public void method() {
        System.out.println("��Ը÷�����һ��B��װ");
        super.method();
        System.out.println("B��װ����");
    }
}
