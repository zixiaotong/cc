package com.strtest;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/11/10.
 */
public class StringTest {
    @Test
    public void test1() {
        String s1 = new String("java");
        String s2 = new String("java");
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
    }

    @Test
    public void test2() {
        int x = 2114;
        int x1 = x / 1000;
        int x2 = x % 1000 / 100;
        int x3 = x % 100 / 10;
        int x4 = x % 10;
        System.out.println(x1 + ";" + x2 + ";" + x3 + ";" + x4);
    }

    @Test
    public void test3() {
        String str = "yuwen";
        System.out.println(str.hashCode());
        System.out.println(str.hashCode());
    }

    @Test
    public void test4() {
        String desc = String.format("由\"%s\"修改为\"%s\";", "1", "2");
        System.out.println(desc);
    }

    @Test
    public void test5() {
        BigDecimal decimal = new BigDecimal("0.5");

        BigDecimal f1 = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(f1);
    }

    @Test
    public void test6() {
        String s = "12||||";
        System.out.println(s.replace("||||", ""));
    }

    public static String formatBanlance(BigDecimal i) {
        if (i == null) {
            return "0.00";
        } else {
            DecimalFormat myformat = new DecimalFormat();
            myformat.applyPattern("##.00");
            String res = myformat.format(i);
            return res.indexOf(".") == 0 ? "0" + res : res;
        }
    }

    public static BigDecimal decimalRound(BigDecimal bd) {
        return bd.setScale(2, 4);
    }

    @Test
    public void test7() {
        BigDecimal bigDecimal = new BigDecimal(9999999999.99);
        System.out.println(decimalRound(bigDecimal));
    }

    @Test
    public void test8() {
        String a = null;
        System.out.println(a.toString());
    }

    @Test
    public void test9() {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString().equals(""));
    }

    @Test
    public void test10() {
        Object o1 = null;
        Object o2 = null;
        Integer o3 = null;
        System.out.println(o3 instanceof Integer);
    }

    public static void main(String args[]) {
        BigDecimal a = new BigDecimal("2.34");
        test(a);
        System.out.println("main:" + a);
    }

    private static void test(BigDecimal b) {
        BigDecimal k = new BigDecimal("0.2");
        b = b.subtract(k);
        System.out.println("test" + b);
    }

    public static String formartDate1(Date date, String format) {
        if (format == null) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        if (date == null) {
            return "";
        } else {
            SimpleDateFormat ft = new SimpleDateFormat(format);
            return ft.format(date);
        }
    }

    @Test
    public void test11() {
        Object beItem = null;
        //int stock = Integer.parseInt(beItem + "");
        //System.out.println(stock);

        //System.out.println(beItem.equals("a"));
        System.out.println(formartDate1((Date)beItem, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test12() {
        BigDecimal bignum2 = new BigDecimal("5");
        BigDecimal bignum3 = BigDecimal.ZERO;

        //加法
        bignum3 = bignum3.add(bignum2);
        System.out.println("和 是：" + bignum3);
    }

    @Test
    public void test13() throws InterruptedException {
        long milliSecondsLeftToday = (1000 * 60 * 60 * 24) - DateUtils.getFragmentInMilliseconds(
            Calendar.getInstance(), Calendar.DATE);

        long milliSecondsLeftToday2 = 86400000 -
            DateUtils.getFragmentInMilliseconds(Calendar.getInstance(), Calendar.DATE);

        System.out.println(milliSecondsLeftToday / 1000);
        System.out.println((1000 * 60 * 60 * 24));

    }

    @Test
    public void test14() {
        BigDecimal bignum2 = new BigDecimal("0.03");

        System.out.println(bignum2 + "元");
    }

    @Test
    public void test15() {
        Random rnd = new Random();
        System.out.println(rnd.nextInt(100));
        int randNum = rnd.nextInt(100); //随机数
        System.out.println(randNum);
    }

    @Test
    public void test16() {
        DecimalFormat df = new DecimalFormat("0.00");
        BigDecimal bigDecimal = new BigDecimal("7676767676767.999");
        BigDecimal redMoney = new BigDecimal(df.format(bigDecimal));
        System.out.println(redMoney);
    }

    @Test
    public void test17() {
        if (!StringUtils.isEmpty("4,74")) {
            boolean flag = false;
            String[] arrSsId = "4,74".split(",");
            for (String ssid : arrSsId) {
                if (ssid.equals(String.valueOf(4))) {
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("不包含，返回了。");
                return;
            }

        }
        System.out.println("继续走");
    }

    @Test
    public void test18() {
        int a = 1;
        System.out.println(a == 1 ? "OK" : "NO");
    }

    @Test
    public void test19() {
        int a = Math.max(1, Math.min(128, 1280));
        System.out.println(a);
    }

    @Test
    public void test20() {
        System.out.println("".split(",").length);
    }
    public static String validateHeadLine(String headLine) {
        String validate = "<,>,＜,＞,&,＆,#,＃,＝,=";
        String result = "";
        if (headLine==null || headLine.length()<=0) {
            result = "请输入商品标题";
        }
        for (String s1 : validate.split(",")) {
            if (headLine.contains(s1)) {
                result = "商品标题不能包含" + s1 + "";
                return result;
            }
        }
        return result;
    }

    @Test
    public void test21() {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String,String> hashMap = new HashMap<>();

        System.out.println("SDfdsf");
        String str = "123456789";
        System.out.println(str.substring(0,6));
    }
    @Test
    public void test22() {

        String str = "1";
        Integer b = 1;
        System.out.println(str.equals(String.valueOf(b.intValue())));
    }
    @Test
    public void test23(){
        Pattern pattern=Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        Matcher match=pattern.matcher("45353gfhfd");
        if(match.matches()==false){
            System.out.println(false);
        }else{
            System.out.println(true);
        }
    }
    private static Pattern NUMBER_PATTERN = Pattern.compile("^-?[1-9]\\d*$");
    @Test
    public void test24(){

        boolean v = NUMBER_PATTERN.matcher("123.54").find();
        System.out.println(v);


    }
    public Pattern getNumberPattern() {
        // Avoid use Pattern.compile in method body.
        Pattern localPattern = Pattern.compile("[0-9]+");
        return localPattern;
    }

    @Test
    public void test25() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long startDate = sdf.parse("2019-03-25 00:00:00").getTime();
        Long endDate = sdf.parse("2019-04-03 10:00:00").getTime();
        Long nowTime = System.currentTimeMillis();
        if ((nowTime >= startDate && nowTime <= endDate)) {
            System.out.println("SDfsd");
        }
    }

}

