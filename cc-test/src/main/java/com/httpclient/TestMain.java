package com.httpclient;

import java.io.IOException;

/**
 * @author shanglei
 * @date 2017/8/25.
 */
public class TestMain {

    public static void main(String[] args) {
        String s = "";

        //s = SendPost.sendPost("http://home.ccoop.cn/home/getFloorGoodsDataBySsIdAndSmId?ssid=272", "",
        //    "application/json;charset=utf-8", null);
        s = SendPost.sendPost("http://goodsapi.zhangheyun.com/api/GoodsInfo/GetDispatchShopsIDAndName",
            "{\"SupermarketId\":465159,"

                + "\"SsId\":27}",
            "application/json;charset=utf-8", null);

        System.out.println(s);
    }
}
