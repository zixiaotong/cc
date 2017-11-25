package com.bigdata.rpc;

/**
 * @author shanglei
 * @date 2017/11/22.
 */
public class UserLoginImpl implements IUserLogin {
    @Override
    public String login(String name, String password) {
        return name + "登陆了";
    }
}
