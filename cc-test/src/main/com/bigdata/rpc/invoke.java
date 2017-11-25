package com.bigdata.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

/**
 * @author shanglei
 * @date 2017/11/25.
 */
public class invoke {

    public static void main(String[] args) throws IOException {
        IUserLogin iUserLogin = RPC.getProxy(IUserLogin.class, 1L, new InetSocketAddress("master", 10041),
            new Configuration());
        String result = iUserLogin.login("zishang", "zishang");
        System.out.println(result);

    }
}
