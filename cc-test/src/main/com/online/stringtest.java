package com.online;

import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/8/21.
 */
public class stringtest {

    @Test
    public void test1() {
        /**
         *    server 192.168.102.185:8305 weight=1;
         server 192.168.102.111:8003;
         server 192.168.102.112:8003;
         */

        String s = "server 192.168.102.185:8305 weight=1;";
        String sq = "server 192.168.102.111:8003;";

        System.out.println(sq.substring(7, sq.length() - 1));
    }

    @Test
    public void test2() {
        /**
         /usr/local/nginx/conf/nginx.conf
         /usr/local/nginx/conf/nginx_com_cn.conf
         /usr/local/nginx/conf/nginx_ccoop.conf
         获取  nginx.conf
         */
        String s = "/usr/local/nginx/conf/nginx_ccoop.conf";
        String[] name = s.split("/");
        //System.out.println(arr[0]);
        //System.out.println(arr[1]);
        //System.out.println(arr[2]);
        //System.out.println(arr[3]);
        //System.out.println(arr[4]);
        //System.out.println(arr[5]);
        String pathback = name[0]+"/"+name[1]+"/"+name[2]+"/"+name[3]+"/"+name[4]+"/toolsback/";
        System.out.println(pathback);
    }
    public static String ToDateString(Date o, String strFormat) {
        if(o == null) {
            return "";
        } else {
            if(strFormat == null || strFormat.isEmpty()) {
                strFormat = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
            String defaultDate = "";
            defaultDate = sdf.format(o);
            return defaultDate;
        }
    }
    public static String ToDateString(Date o) {
        return ToDateString(o, (String)null);
    }
    @Test
    public void test3() {
        System.out.println(ToDateString(new Date()));
    }

    @Test
    public void test4() {
        String ids = "0,1,2,3,4,5";
        String[] arr = ids.split(",");

        for(String x : arr){
            System.out.println(x);
        }
    }

    @Test
    public void test5() {
        // 保存a和b共同元素的list
        List<String> commonList = new ArrayList<>();
        // 数组a
        //String[] b = {"1", "2", "3", "4"};
        //String[] a = {"1", "2", "3"};

        String[] a = {"1", "2", "3", "4"};
        String[] b = {"1", "2", "3"};
        if (a.length > b.length) {
            System.out.println("D");
            // 数组b转换的list
            List<String> bList = new ArrayList<>();
            Collections.addAll(bList, b);
            // 循环a数组
            for (String aValue : a) {
                // 判断b中是否包含元素aValue,包含则增加为a和b的共元素
                if (!bList.contains(aValue)) {
                    commonList.add(aValue);
                }
            }
        }else{
            System.out.println("SDf");
            // 数组b转换的list
            List<String> bList = new ArrayList<>();
            Collections.addAll(bList, a);
            // 循环a数组
            for (String aValue : b) {
                // 判断b中是否包含元素aValue,包含则增加为a和b的共元素
                if (!bList.contains(aValue)) {
                    commonList.add(aValue);
                }
            }
        }
        // 打印commonList
        System.out.println(commonList.toString());
    }

    @Test
    public void test6(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, 20);
        System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()));
    }

    @Test
    public void test7(){
        long s = 1504777058000L;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(s);
        Date date = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
        String fmt = dateFormat.format(date);
        System.out.println(fmt);
    }

}
