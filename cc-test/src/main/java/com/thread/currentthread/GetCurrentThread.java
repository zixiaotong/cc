package com.thread.currentthread;

import com.bean.User;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/12/1.
 */
public class GetCurrentThread {

    @Test
    public void test1(){
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        //int i;i
        User user = new User();
        System.out.println(user.getMarks());

        String s = "dddddttttbbbb";
        System.out.println(s.replace("v","a"));
    }
}
