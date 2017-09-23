package com.publish;

import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/9/1.
 */
public class Caller {

    @Test
    public void t2Method() {
        getCaller();
    }

    public static void getCaller() {
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();
        for (StackTraceElement ste : stack) {
            //System.out.println("MethodName:" + ste.getMethodName());
            if ((ste.getMethodName().indexOf("t2Method")) != -1) {
                System.out.println("called by " + ste.getClassName() + "." + ste.getMethodName() + "/" + ste.getFileName());
            }
        }
    }

    public static void main(String[] args) {
        //t2Method();
    }
}
