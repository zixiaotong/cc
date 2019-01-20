package com.time;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/11/8.
 */
public class time {

    /**
     * 展示时分秒毫秒
     */
    @Test
    public void test1() {
        //其中yyyy-MM-dd是你要表示的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        for (int i = 0; i <= 1000000; i++) {
            // 可以任意组合，不限个数和次序；具体表示为：MM-month,dd-day,yyyy-year;kk-hour,mm-minute,ss-second;
            String str = sdf.format(new Date());
            System.out.println("The date is : " + str);
        }

    }


    @Test
    public void test2() throws Exception {
        Date a = new Date(new Date().getTime()-2*60*1000);
        System.out.println(judgmentDate(new Date(),a));
    }
    /**
     * 判断是否超过30分钟
     * @return boolean
     * @throws Exception
     */
    public static boolean judgmentDate(Date now, Date payDate) throws Exception {
        long cha = now.getTime() - payDate.getTime();
        if (cha < 0) {
            return false;
        }
        double result = cha * 1.0 / (1000 * 60);
        if (result < 30) {
            return true;
        } else {
            return false;
        }
    }

}
