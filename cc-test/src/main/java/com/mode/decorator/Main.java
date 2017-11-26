//package com.mode.decorator;
//
///**
// * Created by shanglei on 2017/6/12.
// */
//public class Main {
//
//    public static void main(String[] args) {
//        Component component = new ConcreteComponent();
//        System.out.println("------------------------------");
//        component.method();//ԭ���ķ���
//
//        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(component);//װ�γ�A
//        System.out.println("------------------------------");
//        concreteDecoratorA.method();//ԭ���ķ���
//        concreteDecoratorA.methodA();//װ�γ�A�Ժ������ķ���
//
//        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(component);//װ�γ�B
//        System.out.println("------------------------------");
//        concreteDecoratorB.method();//ԭ���ķ���
//        concreteDecoratorB.methodB();//װ�γ�B�Ժ������ķ���
//        concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);//װ�γ�A�Ժ���װ�γ�B
//        System.out.println("------------------------------");
//        concreteDecoratorB.method();//ԭ���ķ���
//        concreteDecoratorB.methodB();//װ�γ�B�Ժ������ķ���
//    }
//}
