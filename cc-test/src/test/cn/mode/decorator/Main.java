package cn.mode.decorator;

/**
 * Created by shanglei on 2017/6/12.
 */
public class Main {

    /**
     * 定义：装饰模式是在不必改变原类文件和使用继承的情况下，动态的扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象。

     这一个解释，引自百度百科，我们注意其中的几点。

     1，不改变原类文件。

     2，不使用继承。

     3，动态扩展。
     * @param args
     */


    public static void main(String[] args) {
        Component component = new ConcreteComponent();//原来的对象
        System.out.println("------------------------------");
        component.method();//原来的方法

        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(component);//装饰成A
        System.out.println("------------------------------");
        concreteDecoratorA.method();//原来的方法
        concreteDecoratorA.methodA();//装饰成A以后新增的方法

        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(component);//装饰成B
        System.out.println("------------------------------");
        concreteDecoratorB.method();//原来的方法
        concreteDecoratorB.methodB();//装饰成B以后新增的方法
        concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);//装饰成A以后再装饰成B
        System.out.println("------------------------------");
        concreteDecoratorB.method();//原来的方法
        concreteDecoratorB.methodB();//装饰成B以后新增的方法
    }
}
