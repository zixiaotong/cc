package com.bigdata.rpc;

/**
 * @author shanglei
 * @date 2017/11/22.
 */
public interface IUserLogin {
    public static final long versionID = 1L;

    String login(String name, String password);
}
