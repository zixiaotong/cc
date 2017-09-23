package com.httpclient;

import java.io.IOException;

/**
 * @author shanglei
 * @date 2017/8/25.
 */
public class TestMain    {


    public static void main(String[] args){
        String s = "";
        try {
            s = SendPost.sendPost("http://192.168.200.21:8084/alert/heart", "", "application/json;charset=utf-8", null);
        } catch (IOException e) {
            System.out.println("我就想逮你一下。");
            //e.printStackTrace();

        }
        System.out.println(s);

    }
}
