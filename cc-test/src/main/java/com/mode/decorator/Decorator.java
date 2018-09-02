package com.mode.decorator;

/**
 *
 * @author shanglei
 * @date 2017/6/12
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void method() {
        component.method();
    }
}
