package com.cn.mode.proxy;

/**
 * Created by shanglei on 2017/6/6.
 */
public class StaticProxy implements User {

    private User user;

    private StaticProxy(User user) {
        this.user = user;
    }

    @Override
    public void getUser() {
        System.out.println("user1");
        user.getUser();
    }

    @Override
    public void getName() {
        System.out.println("name1");
        user.getName();
    }

    public static void main(String[] args) {
        User user = new UserImpl();
        User staticProxy = new StaticProxy(user);
        staticProxy.getUser();
        staticProxy.getName();
    }
}
