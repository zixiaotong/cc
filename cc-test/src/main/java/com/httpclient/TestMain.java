package com.httpclient;

import java.io.IOException;

/**
 * @author shanglei
 * @date 2017/8/25.
 */
public class TestMain {

    public static void main(String[] args) {
        String s = "";
        try {
            //s = SendPost.sendPost("http://home.ccoop.cn/home/getFloorGoodsDataBySsIdAndSmId?ssid=272", "",
            //    "application/json;charset=utf-8", null);
            s = SendPost.sendPost("http://192.168.210.49:80/services/alert/heart", "",
                "application/json;charset=utf-8", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
