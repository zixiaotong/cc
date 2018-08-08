package com.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author shanglei
 * @date 2017/6/6
 */
public class ProxyInvocationHandler implements InvocationHandler {

    private IUser IUser;

    private ProxyInvocationHandler(IUser IUser) {
        this.IUser = IUser;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("被调用之前做些事情");
        return method.invoke(IUser, args);
    }

    public static void main(String[] args) {
        IUser IUserImpl = new IUserImpl();
        IUser IUser1 = (IUser) Proxy.newProxyInstance(IUserImpl.getClass().getClassLoader(), IUserImpl.getClass().getInterfaces(),
            new ProxyInvocationHandler(IUserImpl));
        IUser1.getUser();
        IUser1.getName();
    }
}
