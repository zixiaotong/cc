package com.httpclient;

import java.io.IOException;

import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/8/25.
 */
public class TestMain {

    public static void main(String[] args) {
        String s = "";

        s = SendPost.sendPost("http://home.ccoop.cn/home/getFloorGoodsDataBySsIdAndSmId?ssid=272", "",
            "application/json;charset=utf-8", null);
        s = SendPost.sendPost("http://goodsapi.zhangheyun.com/api/GoodsInfo/GetDispatchShopsIDAndName",
            "{\"SupermarketId\":465159,"

                + "\"SsId\":27}",
            "application/json;charset=utf-8", null);

        s = SendPost.sendPost("http://192.168.200.108:8104/services/alert/heart",
            "",
            "application/json;charset=utf-8", null);

        System.out.println(s);
    }


    @Test
    public void test1(){
        String s = "";
        String url = "http://localhost:8091/orderapihttp/services/orderchildservice/okreceivedUpdateShopMoney";
        s = SendPost.sendPost(url,
            "order_child_id:3964831",
            "application/json;charset=utf-8", null);

        System.out.println(s);
    }
}
