package com.time;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

import com.utils.DateUtil;
import com.utils.TimeUtil;
import org.joda.time.DateTime;
import org.junit.Test;

import static com.utils.DateUtil.formatDateToDate;
import static com.utils.DateUtil.getStartDateFarmat;

/**
 * @author shanglei
 * @date 2017/11/8.
 */
public class time {

    private static final ZoneId DEFAULT_ZONE_ID = TimeZone.getDefault().toZoneId();

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
        Date a = new Date(new Date().getTime() - 2 * 60 * 1000);
        System.out.println(judgmentDate(new Date(), a));
    }

    /**
     * 判断是否超过30分钟
     *
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

    @Test
    public void test3() throws ParseException {
        Date nowDate = new Date();
        Calendar cal = Calendar.getInstance();

        cal.setTime(nowDate);

        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Long a = cal.getTime().getTime() - nowDate.getTime();
        System.out.println(a / 1000 / 60 / 60);

    }

    public static Date getNextWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, 7);
        return cal.getTime();
    }

    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    public static long nextWeekLeftTimeMilli() {

        long now = System.currentTimeMillis();

        return nextWeekStartTimeMilli(now) - now;

    }

    public static long nextWeekStartTimeMilli(long timestamp) {
        return LocalDate.now
                (Clock.fixed(Instant.ofEpochMilli(timestamp), DEFAULT_ZONE_ID))
                .plusWeeks(1).with(DayOfWeek.MONDAY)
                .atStartOfDay(DEFAULT_ZONE_ID).
                        toInstant().toEpochMilli();
    }

    /**
     * 获取当前时间所在周的第一天和最后一天
     */
    @Test
    public void test4() throws ParseException {
        System.out.println(lastWeek(new Date()));
    }

    /**
     * 返回当前时间所在周的最后一天与当前时间相差的秒数
     * 如果时间在5.13-5.21之间，那最后一周就是5.21
     *
     * @param date
     * @return
     */
    private Long lastWeek(Date date) {
        long l = 0;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int d;
            if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
                d = -6;
            } else {
                d = 2 - cal.get(Calendar.DAY_OF_WEEK);
            }
            cal.add(Calendar.DAY_OF_WEEK, d);
            cal.add(Calendar.DAY_OF_WEEK, 6);
            // 所在周结束日期
            String data2 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date lastweek = format.parse(data2 + " 23:59:59");

            Long startDate = format.parse("2019-05-13 00:00:00").getTime();
            Long endDate = format.parse("2019-05-21 23:59:59").getTime();

            if (date.getTime() >= startDate && date.getTime() <= endDate) {
                lastweek = format.parse("2019-05-21 23:59:59");
            }
            l = (lastweek.getTime() - date.getTime()) / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    public static Date getLastDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, 1);
            cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 6);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cal.getTime();
    }

    public Date getEndDayOfWeek(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return this.getEndDayOfWeek(localDate);
    }

    public Date getEndDayOfWeek(TemporalAccessor date) {
        TemporalField fieldISO = WeekFields.of(Locale.CHINA).dayOfWeek();
        LocalDate localDate = LocalDate.from(date);
        localDate.with(fieldISO, 7);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).plusDays(1L).minusNanos(1L).toInstant());
    }

    /**
     * 判断是当前时间是否在某个时间段之间
     *
     * @throws ParseException
     */
    @Test
    public void test5() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date now = df.parse(df.format(new Date()));
        Date begin = df.parse("09:00");
        Date end = df.parse("21:00");
        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(now);
        Calendar beginTime = Calendar.getInstance();
        beginTime.setTime(begin);
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(end);
        if (nowTime.before(endTime) && nowTime.after(beginTime)) {
            System.out.println("在时间区间内");
        } else {
            System.out.println("不在");
        }
    }

    @Test
    public void test6() {
        //方法三:LocalDateTime和ChronoUnit为1.8新增
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
//        long millSeconds = ChronoUnit.MILLIS.between(LocalDateTime.now(),midnight);
        long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
//        System.out.println("当天剩余毫秒3：" + millSeconds);
        System.out.println("当天剩余秒3：" + seconds);
    }

    @Test
    public void test7() {
        for (int i = 0; i <= 1; i++) {
            System.out.println("E");
        }
        Date D = crateTimeFromTimeByDay4Date(new Date(), 7);
        System.out.println(D);
    }

    public static Date crateTimeFromTimeByDay4Date(Date date, int dayNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dayNum);
        return calendar.getTime();
    }

    @Test
    public void test8() {
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
        System.out.println(seconds);
    }

    @Test
    public void test9() {
//        String str = "<p style=&quot;text-align: left;&quot;><strong>优惠福利：</strong></p><p>购买过《奶哥教你学AI》系列插画课程的老学员有100元优惠（优惠劵发到账户中）</p><p>购买直播课的学员送《AI商业插画：扁平风插画设计》（优惠券发到账户中，0元购买即可）</p><p style=&quot;text-align: center;&quot;><img src=&quot;https://image.gogoup.com/course/20181218/1545107168355.jpg&quot; title=&quot;1545107168355.jpg&quot; alt=&quot;1545107168355.jpg&quot; width=&quot;360&quot; height=&quot;4138&quot; border=&quot;0&quot; vspace=&quot;0&quot; style=&quot;width: 360px; height: 4138px;&quot;/></p><p style=&quot;text-align: center;&quot;><strong><span style=&quot;color: rgb(0, 0, 0);&quot;>【<strong style=&quot;text-align: center; white-space: normal;&quot;>报名时你需要注意的4点</strong>】</span></strong></p><p><strong><span style=&quot;color: rgb(0, 0, 0);&quot;>1.课程时长、开课时间：</span></strong>2019年1月16日（周三）8：30第1节课，之后每周五晚20:30—22:30（节假日后延）。11次课程，22小时，所有课程均有录播回放，有效期1年，高高手App端可缓存下载。</p><p><strong><span style=&quot;color: rgb(0, 0, 0);&quot;>2.作业布置与点评：</span></strong>每周1次作业，会在作业贴、直播中点评，有固定答疑时间（每周四晚21:00-22:00）</p><p><strong><span style=&quot;color: rgb(0, 0, 0);&quot;>3.答疑服务：</span></strong>配有1名助教全程服务</p><p>4.成功报名的同学请加入<strong><span style=&quot;color: rgb(0, 0, 0);&quot;>vip班级qq群</span></strong>：759051012（入群暗号：购买本课程的订单号)。</p>";
        String str = null;
        System.out.println(str.replaceAll("&quot;", ""));
    }

    @Test
    public void test10() throws ParseException {
//        yyyy-MM-dd hh:mm:ss");
        String data2 = "2019-04-21";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date lastweek = format.parse(data2 + " 23:00:00");

        long a = lastWeek(lastweek);
        System.out.println(a);
    }

    @Test
    public void test11() {
        String str = "0,1,2,3,4,5";
        String[] arr = str.split(","); // 用,分割
        System.out.println(Arrays.toString(arr)); // [0, 1, 2, 3, 4, 5]
        for (String s : arr) {
            System.out.println(s);
        }
    }

    @Test
    public void test12() {
        if (-2 < 0) {
            System.out.println("D");
        }
    }

    @Test
    public void test13() {
//        System.out.println(deciMal(2, 15));
        Double rate = 0.038;
        NumberFormat num = NumberFormat.getPercentInstance();
        String rates = num.format(rate);
        System.out.println(rates);
    }

    private double deciMal(int top, int below) {
        double result = new BigDecimal((float) top / below).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    @Test
    public void test14() throws ParseException {
        String str1 = "2018-04";
        String str2 = "2018-09";
        Set<String> set = new TreeSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(sdf.parse(str1));
        aft.setTime(sdf.parse(str2));
        int month = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int year = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        int diff = Math.abs(year + month);
        String[] s = str1.split("-");
        int year11 = Integer.valueOf(s[0]);
        int month11 = Integer.valueOf(s[1]);
        set.add(str1);
        for (int i = 0; i < diff; i++) {
            month11 += 1;
            if (month11 > 12) {
                year11 += 1;
                month11 = 1;
                set.add(year11 + "-" + month11);
            } else {
                set.add(year11 + "-" + month11);
            }
        }
        Set<String> set1 = new TreeSet<>();
        for (String date : set) {
            String str = sdf.format(TimeUtil.parseDateTime(date, TimeUtil.YEAR_MONTH));
            set1.add(str);
        }
        System.out.println(set1);
    }


}
