package com.publish.utils;

import java.util.HashSet;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/7/26.
 */
public class randomUtils {

    public static void main(String[] args) {
        Base64 base64 = new Base64();
        byte[] bytes = new byte[8];
        Random random = new Random();
        //HashSet<String> hash=new HashSet<String>();
        //for(int j=0;j<10;j++) {
        //hash.clear();
        //for (int i = 0; i < 10; i++) {

        random.nextBytes(bytes);
        String s = base64.encodeToString(bytes);
        System.out.println(s.substring(0,s.length()-1));
        //if (hash.contains(s)) {
        //    System.out.println("发现重复数字" + i);
        //    break;
        //}
        //hash.add(s);
        //}
        //}
    }

    @Test
    public void test1() {
        StringBuffer s = new StringBuffer("date_add(DATE_FORMAT(receive_time,'%Y-%m-%d')");
        for (int i = s.length()-1; i >=0; i--) {
            if (String.valueOf(s.charAt(i)).equals("'")) {
                System.out.println(i);
                s.insert(i,"\\");
            }
        }
        System.out.println(s.toString());
    }

    @Test
    public void test2() {
        StringBuffer str = new StringBuffer("Thanks for your help");
        String strInsert = "1";
        str.insert(0, strInsert + " ");
        System.out.println(str.toString());
    }

    @Test
    public void test3(){
        String s = "date_add(DATE_FORMAT(receive_time,'%Y-%m-%d')";
        //StringBuffer s = new StringBuffer("date_add(DATE_FORMAT(receive_time,'%Y-%m-%d')");
        if(s.contains("'")){
            String[] ss = s.split("'");
            System.out.println(ss.length);
            String s4 = "";
            for(int x = 0 ;x<ss.length;x++){
                s4+=ss[x]+"\\";
            }
            System.out.println(s4);
        }


    }

}
