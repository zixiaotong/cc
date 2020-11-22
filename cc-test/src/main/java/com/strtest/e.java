package com.strtest;

import java.math.BigDecimal;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author shanglei
 * @date 2018/3/14 09:28
 */
public class e {
    public static void main(String[] args) {
        //BigDecimal a=new BigDecimal("2.34");
        //test(a);
        //System.out.println("main:"+a);


        Boolean flag = false;
        flag = test1();
        System.out.println(flag);

    }

    private static Boolean test1(){
       return true;
    }
    private static void test(BigDecimal b){
        BigDecimal k=new BigDecimal("0.2");
        b=b.subtract(k);
        System.out.println("test"+b);
    }
}
