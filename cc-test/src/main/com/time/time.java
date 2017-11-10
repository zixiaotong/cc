package com.time;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/11/8.
 */
public class time {

    @Test
    public void test1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");//其中yyyy-MM-dd是你要表示的格式
        for (int i = 0; i <= 1000000; i++) {
            // 可以任意组合，不限个数和次序；具体表示为：MM-month,dd-day,yyyy-year;kk-hour,mm-minute,ss-second;
            String str = sdf.format(new Date());
            System.out.println("The date is : " + str);
        }

    }
}
