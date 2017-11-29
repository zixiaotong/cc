package com.listdemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.google.common.collect.Maps;
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
    public void test1(){
        int flag1 = 0;
        flag1++;
        System.out.println(flag1);
    }

    @Test
    public void test2(){
        String s = null;
        System.out.println(s.toUpperCase());
    }

    @Test
    public void test3(){
        Map<String, String> segmentMap = Maps.newConcurrentMap();
        segmentMap.put("1","2");
        segmentMap.put("1","3");
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
        System.out.println("11111:"+num % 2);
        StringBuffer sb = new StringBuffer();//创建一个StringBuffer容器用于接收对2取模的数
        while (num > 0) {
            sb.append(num % 2);
            System.out.println("num % 2:"+num % 2);
            num = num / 2;
            System.out.println("num:"+num);
        }
        System.out.println("sb:"+sb);
        System.out.print(sb.reverse());

    }

    @Test
    public void test8(){
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


        String s1 = "hello";	    //基本类型：形参改变不影响实参
        String s2 = "world";	    //引用类型：

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
        while(it.hasNext()) {
            String s = (String)it.next();
            System.out.println(s);
        }
    }

    @Test
    public void test10(){
        short i =1;
        //i=i+1;  会有精度损失，
        System.out.println(i);
    }
}