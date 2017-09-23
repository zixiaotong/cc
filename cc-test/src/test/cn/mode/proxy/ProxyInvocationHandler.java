package cn.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shanglei on 2017/6/6.
 */
public class ProxyInvocationHandler implements InvocationHandler {

    private User user;

    private ProxyInvocationHandler(User user) {
        this.user = user;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ddd");
        return method.invoke(user, args);
    }

    public static void main(String[] args) {
        User userImpl = new UserImpl();
        User user1 = (User) Proxy.newProxyInstance(userImpl.getClass().getClassLoader(),userImpl.getClass().getInterfaces(),
            new ProxyInvocationHandler(userImpl));

        user1.getUser();
        user1.getName();

    }
}
