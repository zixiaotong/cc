package com.cn.test;

import org.junit.Test;

/**
 * Created by shanglei on 2017/4/20.
 */
public class DevTest {

    @Test
    public void test1(){
        Double priceAdt = 400.0D;
        String a = "400";
        System.out.println(Double.valueOf(a));
        System.out.println(Double.valueOf(a).compareTo(priceAdt));

    }

    @Test
    public void test2(){
        String s = "{\"paxType\":\"NORMAL\",\"routeType\":\"OW\",\"errId\":\"\",\"errMsg\":\"\","
            + "\"saleDate\":\"2017-04-01\",\"routeCombineList\":[{\"flightNo\":\"MU701\","
            + "\"odFareInfoList\":[{\"cabinName\":\"K\",\"tourCode\":\"WEB1005\",\"passengerType\":\"ADT\","
            + "\"fareBasis\":\"KSRWCH\",\"changeAirlineFg\":\"0\",\"rescheduledAm\":200,\"giftId\":\"0\","
            + "\"commission\":\"\",\"rescheduledAmPer\":\"0\",\"productCode\":\"\",\"minStay\":\"\","
            + "\"policyFg\":\"\",\"changeAirlineAmPer\":\"0\",\"rescheduledFg\":\"1\",\"maxStay\":\"12M\","
            + "\"price\":\"1700\",\"fareRank\":\"K\",\"baggageWeight\":\"20KG\",\"changeAirlineAm\":0,"
            + "\"ruleId\":205864,\"ei\":\"Q/NON-END-RERCHG200CNY REF200CNY\",\"refundedAmPer\":\"0\","
            + "\"comment\":\"客票有效期12个月。客票不得签转； 收取改期费CNY200 ,"
            + "改期后有淡/平/旺季改变，或者周中/周末改变，则需重新计算运价，运价差额加上相应改期费一并收取；同舱位变更，如变更前后的适用票价之间存在差价，需补足差价。运价差额少补多不退 ；收取退票费CNY200 "
            + "。客票退票应在首次运输开始之日起（客票第一航段未使用的，从客票填开之日起）十三个月内申请办理 , 逾期东航不予办理。\",\"isPublish\":\"1\",\"refundedAm\":200,"
            + "\"refundedFg\":\"1\"},{\"cabinName\":\"K\",\"tourCode\":\"WEB1005\",\"passengerType\":\"CHD\","
            + "\"fareBasis\":\"KSRWCHCH\",\"changeAirlineFg\":\"0\",\"rescheduledAm\":200,\"giftId\":\"0\","
            + "\"commission\":\"\",\"rescheduledAmPer\":\"0\",\"productCode\":\"\",\"minStay\":\"\","
            + "\"policyFg\":\"\",\"changeAirlineAmPer\":\"0\",\"rescheduledFg\":\"1\",\"maxStay\":\"12M\","
            + "\"price\":\"1280\",\"fareRank\":\"K\",\"baggageWeight\":\"20KG\",\"changeAirlineAm\":0,"
            + "\"ruleId\":205864,\"ei\":\"Q/NON-END-RERCHG200CNY REF200CNY\",\"refundedAmPer\":\"0\","
            + "\"comment\":\"客票有效期12个月。客票不得签转； 收取改期费CNY200 ,"
            + "改期后有淡/平/旺季改变，或者周中/周末改变，则需重新计算运价，运价差额加上相应改期费一并收取；同舱位变更，如变更前后的适用票价之间存在差价，需补足差价。运价差额少补多不退 ；收取退票费CNY200 "
            + "。客票退票应在首次运输开始之日起（客票第一航段未使用的，从客票填开之日起）十三个月内申请办理 , 逾期东航不予办理。\",\"isPublish\":\"1\",\"refundedAm\":200,"
            + "\"refundedFg\":\"1\"},{\"cabinName\":\"Y\",\"tourCode\":\"WEB1005\",\"passengerType\":\"INF\","
            + "\"fareBasis\":\"YFFWCH\",\"changeAirlineFg\":\"0\",\"rescheduledAm\":0,\"giftId\":\"0\","
            + "\"commission\":\"\",\"rescheduledAmPer\":\"0\",\"productCode\":\"\",\"minStay\":\"\","
            + "\"policyFg\":\"\",\"changeAirlineAmPer\":\"0\",\"rescheduledFg\":\"1\",\"maxStay\":\"12M\","
            + "\"price\":\"260\",\"fareRank\":\"LOW\",\"baggageWeight\":\"20KG\",\"changeAirlineAm\":0,\"ruleId\":0,"
            + "\"ei\":\"Q/NON-END-RER REF100CNY\",\"refundedAmPer\":\"0\",\"comment\":\"客票有效期12个月。客票不得签转； 改期免收手续费 ,"
            + "改期后有淡/平/旺季改变，或者周中/周末改变，则需重新计算运价，运价差额加上相应改期费一并收取；同舱位变更，如变更前后的适用票价之间存在差价，需补足差价。运价差额少补多不退 ；收取退票费CNY100 "
            + "。客票退票应在首次运输开始之日起（客票第一航段未使用的，从客票填开之日起）十三个月内申请办理 , 逾期东航不予办理。\",\"isPublish\":\"1\",\"refundedAm\":100,"
            + "\"refundedFg\":\"1\"},{\"cabinName\":\"Y\",\"tourCode\":\"WEB1005\",\"passengerType\":\"INF\","
            + "\"fareBasis\":\"YFFWCH\",\"changeAirlineFg\":\"0\",\"rescheduledAm\":0,\"giftId\":\"0\","
            + "\"commission\":\"\",\"rescheduledAmPer\":\"0\",\"productCode\":\"\",\"minStay\":\"\","
            + "\"policyFg\":\"\",\"changeAirlineAmPer\":\"0\",\"rescheduledFg\":\"1\",\"maxStay\":\"12M\","
            + "\"price\":\"260\",\"fareRank\":\"NORMAL\",\"baggageWeight\":\"20KG\",\"changeAirlineAm\":0,"
            + "\"ruleId\":0,\"ei\":\"Q/NON-END-RER REF100CNY\",\"refundedAmPer\":\"0\","
            + "\"comment\":\"客票有效期12个月。客票不得签转； 改期免收手续费 ,"
            + "改期后有淡/平/旺季改变，或者周中/周末改变，则需重新计算运价，运价差额加上相应改期费一并收取；同舱位变更，如变更前后的适用票价之间存在差价，需补足差价。运价差额少补多不退 ；收取退票费CNY100 "
            + "。客票退票应在首次运输开始之日起（客票第一航段未使用的，从客票填开之日起）十三个月内申请办理 , 逾期东航不予办理。\",\"isPublish\":\"1\",\"refundedAm\":100,"
            + "\"refundedFg\":\"1\"},{\"cabinName\":\"Y\",\"tourCode\":\"WEB1005\",\"passengerType\":\"INF\","
            + "\"fareBasis\":\"YFFWCH\",\"changeAirlineFg\":\"0\",\"rescheduledAm\":0,\"giftId\":\"0\","
            + "\"commission\":\"\",\"rescheduledAmPer\":\"0\",\"productCode\":\"\",\"minStay\":\"\","
            + "\"policyFg\":\"\",\"changeAirlineAmPer\":\"0\",\"rescheduledFg\":\"1\",\"maxStay\":\"12M\","
            + "\"price\":\"260\",\"fareRank\":\"SUPER\",\"baggageWeight\":\"20KG\",\"changeAirlineAm\":0,"
            + "\"ruleId\":0,\"ei\":\"Q/NON-END-RER REF100CNY\",\"refundedAmPer\":\"0\","
            + "\"comment\":\"客票有效期12个月。客票不得签转； 改期免收手续费 ,"
            + "改期后有淡/平/旺季改变，或者周中/周末改变，则需重新计算运价，运价差额加上相应改期费一并收取；同舱位变更，如变更前后的适用票价之间存在差价，需补足差价。运价差额少补多不退 ；收取退票费CNY100 "
            + "。客票退票应在首次运输开始之日起（客票第一航段未使用的，从客票填开之日起）十三个月内申请办理 , 逾期东航不予办理。\",\"isPublish\":\"1\",\"refundedAm\":100,"
            + "\"refundedFg\":\"1\"}]}],\"language\":\"zh\",\"channelNo\":22,\"cabinRank\":\"ECONOMY\","
            + "\"currency\":\"CNY\"}";


        //CancelRQ readRQ = JSON.parseObject(s, CancelRQ.class);
    }
}
