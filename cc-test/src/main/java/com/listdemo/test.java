package com.listdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.google.common.collect.Maps;
import com.sun.tools.javac.util.Convert;
import org.junit.Test;

public class test {
    private static Properties p = new Properties();

    //private static Map<String, String> cabinLevelMap = new HashMap<>();
    //
    //static {
    //    //经济舱
    //    cabinLevelMap.put("B", "Y");
    //    cabinLevelMap.put("E", "Y");
    //    cabinLevelMap.put("H", "Y");
    //    cabinLevelMap.put("K", "Y");
    //    cabinLevelMap.put("L", "Y");
    //    cabinLevelMap.put("M", "Y");
    //    cabinLevelMap.put("N", "Y");
    //    cabinLevelMap.put("Q", "Y");
    //    cabinLevelMap.put("R", "Y");
    //    cabinLevelMap.put("S", "Y");
    //    cabinLevelMap.put("T", "Y");
    //    cabinLevelMap.put("V", "Y");
    //    cabinLevelMap.put("W", "Y");
    //    //商务舱
    //    cabinLevelMap.put("C", "C");
    //    cabinLevelMap.put("D", "C");
    //    cabinLevelMap.put("F", "F");
    //    cabinLevelMap.put("I", "C");
    //    cabinLevelMap.put("J", "C");
    //    cabinLevelMap.put("P", "F");
    //    cabinLevelMap.put("U", "F");
    //}

    static {
        try {
            InputStream is = Object.class
                .getResourceAsStream("/test.properties");
            if (null != is) {
                p.load(is);
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //public static String getProperties(final String key) {
    //    System.out.println("加载配置文件test.properties中的属性：" + key + ",值：" + p.get(key));
    //    if (null != p.get(key)) {
    //        return ((String)p.get(key)).trim();
    //    }
    //    return null;
    //}

    //public static void main(String[] args) {
    //    //String a = getProperties("a");
    //    //System.out.println(a);
    //
    //    Double a = 1233D;
    //    Double b = 1234D;
    //    //System.out.println(a<b);
    //
    //    System.out.println(cabinLevelMap.toString());
    //
    //}

    @Test
    public void test1() {
        int flag1 = 0;
        flag1++;
        System.out.println(flag1);
    }

    @Test
    public void test2() {
        String s = null;
        System.out.println(s.toUpperCase());
    }

    @Test
    public void test3() {
        Map<String, String> segmentMap = Maps.newConcurrentMap();
        segmentMap.put("1", "2");
        segmentMap.put("1", "3");
        System.out.println(segmentMap.toString());
    }

    //@Test
    //public void readLog(){
    //    Map<String, String> segmentMap = Maps.newConcurrentMap();
    //    Map<String,String> mapss = new HashMap<>();
    //    mapss.put("1","3");
    //    mapss.put("1","22");
    //    mapss.put("12","2442");
    //    System.out.println(mapss.toString());
    //}

    //@Test
    //public void test5(){
    //
    //    listdemo<String> list1 = new ArrayList<>();
    //    list1.add("1");
    //    list1.add("2");
    //    list1.add("3");
    //    list1.add("4");
    //    list1.add("5");
    //
    //    Map<String, listdemo> segmentMap = Maps.newConcurrentMap();
    //    segmentMap.put("1",list1);
    //
    //    segmentMap.put("1",segmentMap.get("1").subList(0,3));
    //
    //    if(segmentMap.get("2")==null){
    //        System.out.println("Dd");
    //    }
    //
    //    System.out.println(segmentMap.toString());
    //}

    //@Test
    //public String sss(){
    //    for (int i = 0; i <3 ; i++) {
    //        System.out.println(i);
    //        if(10>2){
    //            return "d";
    //        }
    //    }
    //    return "";
    //}

    @Test
    public void test6() {
        //System.out.println(sss());
        System.out.println("ddd");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);

        Long s = 2222233333L;
        System.out.println(Long.toBinaryString(s));

    }

    @Test
    public void test7() {

        int num = 50;
        System.out.println("11111:" + num % 2);
        StringBuffer sb = new StringBuffer();//创建一个StringBuffer容器用于接收对2取模的数
        while (num > 0) {
            sb.append(num % 2);
            System.out.println("num % 2:" + num % 2);
            num = num / 2;
            System.out.println("num:" + num);
        }
        System.out.println("sb:" + sb);
        System.out.print(sb.reverse());

    }

    @Test
    public void test8() {
        //String s1 = new String("hello");
        //String s3 = new String("hello");
        //String s2 = "hello";
        //System.out.println(s1.equals(s3));
        //System.out.println(s1==s3);

        //String s1 = "helloworld";
        //String s2 = "hello";
        //String s3 = "world";
        //
        //System.out.println(s1==s2+s3);
        //System.out.println(s1=="hello"+"world");

        //String s3 = new String("hello");
        //String s4 = "hello";
        //System.out.println(s3==s4);	   //==	可以比基本，也可以比引用
        //System.out.println(s3.equals(s4));//   比的是地址值

        String s1 = "hello";        //基本类型：形参改变不影响实参
        String s2 = "world";        //引用类型：

        s1 += "java";
        s2 += "ee";
        System.out.println(s1);
        System.out.println(s2);

    }

    @Test
    public void test9() {
        //Integer i1 = new Integer(128);
        //Integer i2 = new Integer(128);
        //System.out.println(i1 == i2);
        //System.out.println(i1.equals(i2));

        //Integer i5 = 127;
        //Integer i6 = 127;
        //System.out.println(i5==i6);
        //System.out.println(i5.equals(i6));
        //System.out.println(Integer.MAX_VALUE);

        //Integer r =1;
        //int t =1;
        //System.out.println(r==t);

        Collection c = new ArrayList<String>();

        c.add("hello");
        c.add("world");
        c.add("java");

        Iterator it = c.iterator();
        while (it.hasNext()) {
            String s = (String)it.next();
            System.out.println(s);
        }
    }

    @Test
    public void test10() {
        short i = 1;
        //i=i+1;  会有精度损失，
        System.out.println(i);
    }

    @Test
    public void test11() {
        // 超过19位就玩不了了。
        String a = "999999999999999999";
        //Long b = Long.parseLong(a);

        //long b = (int)Convert.ToDecimal(a);
        System.out.println(a);
    }

    @Test
    public void test12() throws UnsupportedEncodingException {
        String a = "云中台请求未响应：{\\\"app_id\\\":\\\"945dj20161226987542695\\\","
            + "\\\"jsonData\\\":\\\"%7B%22merchantId%22%3A6%2C%22mpName%22%3A%222%E5%8D%87%E5%8F%AF%E5%8F%A3%E9%9B%AA"
            + "%E7%A2%A7%E8%8A%AC%E8%BE%BE%22%2C%22subTitle%22%3A%222%E5%8D%87%E5%8F%AF%E5%8F%A3%E9%9B%AA%E7%A2%A7%E8"
            + "%8A%AC%E8%BE%BE%22%2C%22brandId%22%3A202143%2C%22categoryId%22%3A47%2C%22barCode%22%3A%22zh4636661%22"
            + "%2C%22grossWeight%22%3A0.0%2C%22picUrl%22%3A%5B%22http%3A%2F%2Fimg.zhanghetianxia"
            + ".com%2F%2FServiceStation%2F2017%2F12%2F17%2Fe8da4d5332f04c1db23d524389815246.jpg360_360.jpg%22%5D%2C"
            + "%22unit%22%3A%22%E7%93%B6%22%2C%22specs%22%3A%222%E5%8D%87%2F%E7%93%B6%22%7D\\\","
            + "\\\"sign\\\":\\\"977CC63B9905BD03C97F0A017214A312\\\",\\\"v\\\":\\\"1.0\\\"}";

        String strUTF8 = URLDecoder.decode(a, "UTF-8");
        System.out.println(strUTF8);
        System.out.println(strUTF8.length());
        //System.out.println(a.length());

        String b = "云中台请求未响应：{\"app_id\":\"945dj20161226987542695\",\"jsonData\":\"{\\\"merchantId\\\":6,"
            + "\\\"mpName\\\":\\\"冰糖雪梨\\\",\\\"subTitle\\\":\\\"统一 冰糖雪梨 梨汁饮料 500*1/瓶\\\",\\\"brandId\\\":426,"
            + "\\\"categoryId\\\":43,\\\"barCode\\\":\\\"6925303750275\\\",\\\"grossWeight\\\":100.0,"
            + "\\\"picUrl\\\":[\\\"http://img.zhanghetianxia.com/GoodStore/2015/1/28/415A17905064A2AC5EF24B7F8435B86E"
            + ".jpg\\\"],\\\"unit\\\":\\\"1\\\",\\\"specs\\\":\\\"500\\\"}\","
            + "\"sign\":\"6BD9D782CD4236BFA1197BE168991899\",\"v\":\"1.0\"}";
        System.out.println(b.length());
    }
}