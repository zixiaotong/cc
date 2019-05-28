package com.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang.math.NumberUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间操作工具
 *
 * @author shanglei
 */
public class TimeUtil {
    public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME2 = "yyyy-MM-dd HH:mm";
    public static final String DATETIME3 = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE = "yyyy-MM-dd";
    public static final String DATE1 = "yyyy.MM.dd";
    public static final String DATE2 = "yyyyMMdd";
    public static final String DATE3 = "yyyy/MM/dd";
    public static final String YEAR_MONTH = "yyyy-MM";
    public static final String TIME = "HH:mm:ss";
    public static final String TIME2 = "HHmmss";
    public static final String YEAR = "yyyy";
    public static final String MONTH = "MM";
    public static final String DAY = "dd";
    public static final String HOUR = "HH";
    public static final String MINUTE = "mm";
    public static final String SEC = "ss";
    public static final String DATETIMECHINESE = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String DATETIMECHINESE_SHORT = "MM月dd日 HH:mm";
    public static final String DATECHINESE = "yyyy年MM月dd日";
    public static final String SIMPLEDATECHINESE = "MM月dd日";
    public static final String SIMPLEDATECHINESE1 = "MM月dd日HH:mm";
    public static final String WEIXINDATETIME = "yyyyMMddHHmmss";
    private static final Object dateFormatLock = new Object();
    private static final Map<String, ThreadLocal<SimpleDateFormat>> dateFormatPool = new HashMap<String, ThreadLocal<SimpleDateFormat>>();


    /**
     * 判断一个字符串日期是否过期
     *
     * @param dateTime
     * @return (int)&nbsp;过期返回1，不过期返回0
     * @throws ParseException
     */
    public static int isOutOfDate(String dateTime) throws ParseException {
        long nowTimeLong = new Date().getTime();
        long ckTimeLong = new SimpleDateFormat(DATETIME).parse(dateTime).getTime();
        if (nowTimeLong - ckTimeLong > 0) {// 过期
            return 1;
        }
        return 0;
    }

    /**
     * 判断是否在一个起止日期内<br/>
     * 例如:2012-04-05 00:00:00~2012-04-15 00:00:00
     *
     * @param start_time
     * @param over_time
     * @return (int)&nbsp;在这个时间段内返回1，不在返回0
     * @throws ParseException
     */
    public static int isOutOfDate(String start_time, String over_time) throws ParseException {
        long nowTimeLong = new Date().getTime();
        long ckStartTimeLong = new SimpleDateFormat(DATETIME).parse(start_time).getTime();
        long ckOverTimeLong = new SimpleDateFormat(DATETIME).parse(over_time).getTime();
        if (nowTimeLong > ckStartTimeLong && nowTimeLong < ckOverTimeLong) {
            return 1;
        }
        return 0;
    }

    /**
     * 判断一个自定义日期是否在一个起止日期内<br/>
     * 例如:判断2012-01-05 00:00:00是否在2012-04-05 00:00:00~2012-04-15 00:00:00
     *
     * @param start_time
     * @param over_time
     * @return (int)&nbsp;在这个时间段内返回1，不在返回0
     * @throws ParseException
     */
    public static int isOutOfDate(String time, String start_time, String over_time) throws ParseException {
        long timeLong = new SimpleDateFormat(DATETIME).parse(time).getTime();
        long ckStartTimeLong = new SimpleDateFormat(DATETIME).parse(start_time).getTime();
        long ckOverTimeLong = new SimpleDateFormat(DATETIME).parse(over_time).getTime();
        if (timeLong > ckStartTimeLong && timeLong < ckOverTimeLong) {
            return 1;
        }
        return 0;
    }

    public static int isOutOfDate(String time, String start_time, String over_time, String format) throws ParseException {
        long timeLong = new SimpleDateFormat(format).parse(time).getTime();
        long ckStartTimeLong = new SimpleDateFormat(format).parse(start_time).getTime();
        long ckOverTimeLong = new SimpleDateFormat(format).parse(over_time).getTime();
        if (timeLong > ckStartTimeLong && timeLong < ckOverTimeLong) {
            return 1;
        }
        return 0;
    }

    /**
     * 判断是否在一个时间段内<br/>
     * 例如:8:00~10:00
     *
     * @param time_limit_start
     * @param time_limit_over
     * @return (int) 1在这个时间段内，0不在这个时间段内
     * @throws ParseException
     */
    public static int isInTime(String time_limit_start, String time_limit_over) throws ParseException {
        // 获取当前日期
        String nowDate = new SimpleDateFormat(DATE).format(new Date());
        return isOutOfDate(nowDate + " " + time_limit_start, nowDate + " " + time_limit_over);
    }

    /**
     * 判断一个自定义时间是否在一个时间段内<br/>
     * 例如:判断02:00是否在08:00~10:00时间段内
     *
     * @param time_limit_start
     * @param time_limit_over
     * @return (int) 1在这个时间段内，0不在这个时间段内
     * @throws ParseException
     */
    public static int isInTime(String time, String time_limit_start, String time_limit_over) throws ParseException {
        String nowDate = new SimpleDateFormat(DATE).format(new Date());
        return isOutOfDate(nowDate + " " + time, nowDate + " " + time_limit_start, nowDate + " " + time_limit_over);
    }

    /**
     * 取得自定义月份后的日期，如13个月以后的时间
     *
     * @param monthNum 往后几个月
     * @return 时间字符串
     */
    public static String crateTimeFromNowTimeByMonth(int monthNum) {
        Calendar calendar = new GregorianCalendar(NumberUtils.toInt(getYear()), NumberUtils.toInt(getMonth()) - 1,
                NumberUtils.toInt(getDay()), NumberUtils.toInt(getHour()), NumberUtils.toInt(getMinute()),
                NumberUtils.toInt(getSec()));
        calendar.add(Calendar.MONTH, monthNum);
        return new SimpleDateFormat(DATETIME).format(calendar.getTime());
    }

    /**
     * 取得自定义天数后的日期，如13天以后的时间
     *
     * @param dayNum 往后几天
     * @return 时间字符串(DateTime)
     */
    public static String crateTimeFromNowTimeByDay(int dayNum) {
        Calendar calendar = new GregorianCalendar(NumberUtils.toInt(getYear()), NumberUtils.toInt(getMonth()) - 1,
                NumberUtils.toInt(getDay()), NumberUtils.toInt(getHour()), NumberUtils.toInt(getMinute()),
                NumberUtils.toInt(getSec()));
        calendar.add(Calendar.DATE, dayNum);
        return new SimpleDateFormat(DATETIME).format(calendar.getTime());
    }

    public static Date crateTimeFromTimeByDay4Date(Date date, int dayNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dayNum);
        return calendar.getTime();
    }

    public static Date crateTimeFromTimeByMinute4Date(Date date, int minuteNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minuteNum);
        return calendar.getTime();
    }

    /**
     * 取得自定义天数后的日期，如13天以后的时间
     *
     * @param dayNum 往后几天
     * @return 时间字符串(Date)
     */
    public static String crateTimeFromNowDayByDay(int dayNum) {
        Calendar calendar = new GregorianCalendar(NumberUtils.toInt(getYear()), NumberUtils.toInt(getMonth()) - 1,
                NumberUtils.toInt(getDay()), NumberUtils.toInt(getHour()), NumberUtils.toInt(getMinute()),
                NumberUtils.toInt(getSec()));
        calendar.add(Calendar.DATE, dayNum);
        return new SimpleDateFormat(DATE).format(calendar.getTime());
    }

    /**
     * 取得自定义时间后再过几分钟的时间，如12:05以后5分钟的时间
     *
     * @param dayNum 往后几天
     * @return 时间字符串(Date)
     */
    public static String crateTimeFromNowDayByTime(int timeNum) {
        Calendar calendar = new GregorianCalendar(NumberUtils.toInt(getYear()), NumberUtils.toInt(getMonth()) - 1,
                NumberUtils.toInt(getDay()), NumberUtils.toInt(getHour()), NumberUtils.toInt(getMinute()),
                NumberUtils.toInt(getSec()));
        calendar.add(Calendar.MINUTE, timeNum);
        return new SimpleDateFormat(DATETIME).format(calendar.getTime());
    }

    public static String getHourAndMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(GregorianCalendar.HOUR_OF_DAY) + ":" + calendar.get(GregorianCalendar.MINUTE);
    }

    /**
     * 计算两个时间间隔(精确到分钟)
     *
     * @param startDay  开始日(整型):0表示当日，1表示明日
     * @param startTime 开始时间(24h):00:00
     * @param endDay    结束日(整型):0表示当日，1表示明日，限制：大于等于 startDay
     * @param endTime   结束时间(24h):23:50
     * @return 格式化的日期格式：DD天HH小时mm分
     */
    public static String calculateIntervalTime(int startDay, String startTime, int endDay, String endTime) {
        int day = endDay - startDay;
        int hour = 0;
        int mm = 0;
        if (day < 0) {
            return null;
        } else {
            int sh = Integer.valueOf(startTime.split(":")[0]);
            int eh = Integer.valueOf(endTime.split(":")[0]);
            int sm = Integer.valueOf(startTime.split(":")[1]);
            int em = Integer.valueOf(endTime.split(":")[1]);
            hour = eh - sh;
            if (hour > 0) {
                mm = em - sm;
                if (mm < 0) {
                    hour--;
                    mm = 60 + mm;
                }
            } else {
                day = day - 1;
                hour = 24 + hour;
                mm = em - sm;
                if (mm < 0) {
                    hour--;
                    mm = 60 + mm;
                }
            }
        }
        if (hour == 24) {
            day++;
            hour = 0;
        }
        if (day != 0) {
            return day + "天" + hour + "小时" + mm + "分";
        } else {
            return hour + "小时" + mm + "分";
        }
    }

    /**
     * 计算两个时间差
     *
     * @param startTime
     * @param endTime
     * @return long
     * @throws ParseException
     */
    public static long calculateIntervalTime(String startTime, String endTime) throws ParseException {
        return parseDateTime(endTime).getTime() - parseDateTime(startTime).getTime();
    }

    // 字符串转换成时间
    public static Date parseDateTime(String datetime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME);
        return sdf.parse(datetime);
    }

    // 字符串转换成时间
    public static Date parseDateTime(String datetime, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(datetime);
    }

    // 字符串转换成时间
    public static String dateTime2String(Date datetime, String format) throws ParseException {
        return new SimpleDateFormat(format).format(datetime);
    }

    // 获取当前日期
    public static String getDate() {
        return new SimpleDateFormat(DATE).format(new Date());
    }

    // 获取当前详细日期时间
    public static String getDateTime() {
        return new SimpleDateFormat(DATETIME).format(new Date());
    }

    // 转换为中文时间
    public static String getChineseDateTime() {
        return new SimpleDateFormat(DATETIMECHINESE).format(new Date());
    }

    // 转换为中文时间
    public static String getChineseDate() {
        return new SimpleDateFormat(DATECHINESE).format(new Date());
    }

    // 转换为中文时间
    public static String getSimpleChineseDate() {
        return new SimpleDateFormat(SIMPLEDATECHINESE).format(new Date());
    }

    // 转换为中文时间 如果num为-1表示前一天 1为后一天 0为当天
    public static String getSimpleChineseDate(int num) {
        Date d = new Date();
        try {
            d = parseDateTime(crateTimeFromNowTimeByDay(num));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(SIMPLEDATECHINESE).format(d);
    }

    // 获取当前时间
    public static String getTime() {
        return new SimpleDateFormat(TIME).format(new Date());
    }

    // 获取当前年
    public static String getYear() {
        return new SimpleDateFormat(YEAR).format(new Date());
    }

    // 获取当前月
    public static String getMonth() {
        return new SimpleDateFormat(MONTH).format(new Date());
    }

    // 获取当前日
    public static String getDay() {
        return new SimpleDateFormat(DAY).format(new Date());
    }

    // 获取当前时
    public static String getHour() {
        return new SimpleDateFormat(HOUR).format(new Date());
    }

    // 获取当前分
    public static String getMinute() {
        return new SimpleDateFormat(MINUTE).format(new Date());
    }

    // 获取当前秒
    public static String getSec() {
        return new SimpleDateFormat(SEC).format(new Date());
    }

    // 获取昨天日期
    public static String getYestday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date d = cal.getTime();
        return new SimpleDateFormat(DATE).format(d);// 获取昨天日期
    }

    // 取得本周一
    public static String getMonday() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
                0, 0);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return new SimpleDateFormat(DATETIME).format(calendar.getTime());// 获取昨天日期
    }

    // 取得本周一
    public static String getMondayDay() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
                0, 0);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return new SimpleDateFormat(DATE).format(calendar.getTime());
    }

    // 取得本周日
    public static String getSundayDay() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
                0, 0);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DATE, 6);
        return new SimpleDateFormat(DATE).format(calendar.getTime());
    }

    // 取得下周一
    public static String getNextMondayDay() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
                0, 0);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DATE, 7);
        return new SimpleDateFormat(DATE).format(calendar.getTime());
    }

    // 取得本月第一天
    public static String getMonthFirstDay() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return new SimpleDateFormat(DATE).format(calendar.getTime());
    }

    public static String getMonthFirstDay(String timeStr) throws ParseException {
        Date dateTime = parseDateTime(timeStr, TimeUtil.YEAR_MONTH);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dateTime);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return new SimpleDateFormat(DATE).format(calendar.getTime());
    }

    // 取得本月第一天
    public static Date getMonthFirstDay2Date() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    // 取得下月第一天
    public static String getNextMonthFirstDay() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return new SimpleDateFormat(DATE).format(calendar.getTime());
    }

    public static String getNextMonthFirstDay(String timeStr) throws ParseException {
        Date dateTime = parseDateTime(timeStr, TimeUtil.YEAR_MONTH);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dateTime);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return new SimpleDateFormat(DATE).format(calendar.getTime());
    }

    // 取得本月最后一天
    public static String getMonthLastDay(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return new SimpleDateFormat(DATE).format(date.getTime());
    }

    public static String getTimeWithTimestamp(Timestamp time) {
        SimpleDateFormat df = new SimpleDateFormat(DATETIME);// 定义格式，不显示毫秒
        String str = df.format(time);
        return str;
    }

    /**
     * 获得日期字符串数组
     *
     * @param calendarType 日期跨度的类型，
     */

    public static Date[] getDateArrays(Date start, Date end, int calendarType) {
        ArrayList<Date> ret = new ArrayList<Date>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        Date tmpDate = calendar.getTime();
        long endTime = end.getTime();
        while (tmpDate.before(end) || tmpDate.getTime() == endTime) {
            ret.add(calendar.getTime());
            calendar.add(calendarType, 1);
            tmpDate = calendar.getTime();
        }

        Date[] dates = new Date[ret.size()];
        return ret.toArray(dates);
    }

    public static boolean getWeekEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            return true;
        else
            return false;
    }

    /**
     * 判断是否超过30分钟
     *
     * @param date1
     * @param date2
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

    /**
     * 判断是否超过30分钟
     * 更改小于0时分会true.是为了防止多服务器时间差几毫秒问题。
     *
     * @param date1
     * @param date2
     * @return boolean
     * @throws Exception
     */

    public static boolean calDateDiff(Date now, Date payDate) {
        long cha = now.getTime() - payDate.getTime();
        if (cha < 0) {
            return true;
        }
        double result = cha * 1.0 / (1000 * 60);
        if (result < 30) {
            return true;
        } else {
            return false;
        }
    }

    public static long intervalNumberOfMinutes(Date now, Date payDate) throws Exception {
        long cha = now.getTime() - payDate.getTime();
        long result = (30 * 60 * 1000 - cha) / (1000 * 60);
        return result;

    }

    public static long intervalNumberOfMinutes15m(Date now, Date payDate) throws Exception {
        long cha = now.getTime() - payDate.getTime();
        long result = (15 * 60 * 1000 - cha) / (1000 * 60);
        return result;

    }

    public static Date getExpirationTime(Integer validity) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, validity);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        Date time = cal.getTime();
        return time;
    }

    public static int getMonthSpace(Date beginDate, Date endDate)
            throws ParseException {

        int result = 0;

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(beginDate);
        c2.setTime(endDate);

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH) + (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12;

        return Math.abs(result);

    }

    public static int getDaySpace(Date beginDate, Date endDate) {
        long time = endDate.getTime() - beginDate.getTime();
        Long day = time / (1000 * 3600 * 24);
        return day.intValue();
    }

    public static long getSecondSpace(Date beginDate, Date endDate) {
        long time = endDate.getTime() - beginDate.getTime();
        long second = time / 1000;
        return second;
    }

    private static String getMonthFirstDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return new SimpleDateFormat(DATE).format(cal.getTime());
    }

    public static Date lastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static Date getToday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date time = cal.getTime();
        return time;
    }

    public static List<String> getMonthList(Date beginDate, Date endDate) throws ParseException {
        List<String> monthList = Lists.newArrayList();
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int monthSpace = getMonthSpace(beginDate, endDate) + 1;
        for (int i = 0; i < monthSpace; i++) {
            monthList.add(getMonthFirstDay(cal.getTime()));
            cal.add(Calendar.MONTH, 1);
        }
        return monthList;
    }

    public static List<String> getYearMonthList(Date beginDate, Date endDate) throws ParseException {
        List<String> monthList = Lists.newArrayList();
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        int monthSpace = getMonthSpace(beginDate, endDate) + 1;
        for (int i = 0; i < monthSpace; i++) {
            monthList.add(dateTime2String(cal.getTime(), TimeUtil.YEAR_MONTH));
            cal.add(Calendar.MONTH, 1);
        }
        return monthList;
    }

    /**
     * 比较两个日期大小 time1 >= time2 返回1 否则返回-1
     *
     * @param time1
     * @param time2
     * @param format
     * @return
     */
    public static int compareDate(String time1, String time2, String format) {
        int i = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date date1 = sdf.parse(time1);
            Date date2 = sdf.parse(time2);
            if (date1.getTime() > date2.getTime()) {
                i = 1;
            } else if (date1.getTime() < date2.getTime()) {
                i = -1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args) throws ParseException {
        Date beginDate = parseDateTime("2015-01-01", "yyyy-MM-dd");
        Date endDate = new Date();
        List<String> monthList = getMonthList(beginDate, endDate);
        for (String string : monthList) {
            System.out.println(string);
        }
        System.out.println(dateTime2String(new Date(), TimeUtil.SIMPLEDATECHINESE1));
    }

    /**
     * 格式化成日期格式
     *
     * @param datetime 要格式化的日期
     * @return "年年年年-月月-日日"格式的日期字符串
     */
    public static String dateFormat(long datetime) {
        return getDateFormat().format(new Date(datetime));
    }

    private static SimpleDateFormat getDateFormat() {
        ThreadLocal<SimpleDateFormat> tl = dateFormatPool
                .get(DATE);
        if (null == tl) {
            synchronized (dateFormatLock) {
                tl = dateFormatPool.get(DATE);
                if (null == tl) {
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        protected synchronized SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(DATE);
                        }
                    };
                    dateFormatPool.put(DATE, tl);
                }
            }
        }
        return tl.get();
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static Integer daysBetween(Date smdate, Date bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            smdate = sdf.parse(sdf.format(smdate));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        try {
            bdate = sdf.parse(sdf.format(bdate));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 格式化成日期格式
     *
     * @param datetime 要格式化的日期
     * @return "年年年年-月月-日日"格式的日期字符串
     */
    public static String dateFormat(Date datetime) {
        return getDateFormat().format(datetime);
    }

    public static Date getStartDateFarmat(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = dateFormat(date);
        return sdf.parse(str.trim() + " 00:00:00");
    }

    public static Date getEndDateFarmat(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = dateFormat(date);
        return sdf.parse(str.trim() + " 23:59:59");
    }

    /**
     * 返回传的时间-1天
     *
     * @param date
     * @return
     */
    public static Date getYesDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);//+1今天的时间减一天
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取指定年月的最后一天
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }
}
