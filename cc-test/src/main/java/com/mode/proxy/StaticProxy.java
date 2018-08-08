package com.mode.proxy;

/**
 * @author shanglei
 * @date 2017/6/6
 */
public class StaticProxy implements IUser {

    private IUser IUser;

    private StaticProxy(IUser IUser) {
        this.IUser = IUser;
    }

    @Override
    public void getUser() {
        System.out.println("StaticProxyUser\r\n");
        IUser.getUser();
    }

    @Override
    public void getName() {
        System.out.println("StaticProxyName");
        IUser.getName();
    }

    public static void main(String[] args) {
        IUser IUser = new IUserImpl();
        IUser.getName();
        IUser.getUser();

        IUser staticProxy = new StaticProxy(IUser);
        staticProxy.getUser();
        staticProxy.getName();
    }
}
