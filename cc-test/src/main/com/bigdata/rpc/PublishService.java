package com.bigdata.rpc;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Builder;
import org.apache.hadoop.ipc.RPC.Server;

/**
 * @author shanglei
 * @date 2017/11/22.
 */
public class PublishService {
    /**
     * 通过hadoop 的rpc框架来发布一个服务，启动的其实是scoket的server
     */
    public static void main(String[] args) {
        Builder builder = new RPC.Builder(new Configuration());
        builder.setBindAddress("master").setPort(10041).setProtocol(IUserLogin.class).
                setInstance(new UserLoginImpl());
        Server server = null;
        try {
            server = builder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.start();
    }
}
