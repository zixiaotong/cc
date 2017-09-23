package cn.mode.decorator;

/**
 * Created by shanglei on 2017/6/12.
 */
public abstract class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void method() {
        component.method();
    }
}
