package cn.mode.decorator;

/**
 * Created by shanglei on 2017/6/12.
 */
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    public void methodB() {
        System.out.println("被装饰器B扩展的功能");
    }

    @Override
    public void method() {
        System.out.println("针对该方法加一层B包装");
        super.method();
        System.out.println("B包装结束");
    }
}
