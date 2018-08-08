package com.mode.proxy;

/**
 * Created by shanglei on 2017/6/6.
 */
public class IUserImpl implements IUser {
    @Override
    public void getUser() {
        System.out.println("UserImplUser");
    }

    @Override
    public void getName() {
        System.out.printf("UserImplName\r\n");
    }
}
