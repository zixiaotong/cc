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
            + "\"comment\":\"��Ʊ��Ч��12���¡���Ʊ����ǩת�� ��ȡ���ڷ�CNY200 ,"
            + "���ں��е�/ƽ/�����ı䣬��������/��ĩ�ı䣬�������¼����˼ۣ��˼۲�������Ӧ���ڷ�һ����ȡ��ͬ��λ���������ǰ�������Ʊ��֮����ڲ�ۣ��貹���ۡ��˼۲���ٲ��಻�� ����ȡ��Ʊ��CNY200 "
            + "����Ʊ��ƱӦ���״����俪ʼ֮���𣨿�Ʊ��һ����δʹ�õģ��ӿ�Ʊ�֮����ʮ��������������� , ���ڶ����������\",\"isPublish\":\"1\",\"refundedAm\":200,"
            + "\"refundedFg\":\"1\"},{\"cabinName\":\"K\",\"tourCode\":\"WEB1005\",\"passengerType\":\"CHD\","
            + "\"fareBasis\":\"KSRWCHCH\",\"changeAirlineFg\":\"0\",\"rescheduledAm\":200,\"giftId\":\"0\","
            + "\"commission\":\"\",\"rescheduledAmPer\":\"0\",\"productCode\":\"\",\"minStay\":\"\","
            + "\"policyFg\":\"\",\"changeAirlineAmPer\":\"0\",\"rescheduledFg\":\"1\",\"maxStay\":\"12M\","
            + "\"price\":\"1280\",\"fareRank\":\"K\",\"baggageWeight\":\"20KG\",\"changeAirlineAm\":0,"
            + "\"ruleId\":205864,\"ei\":\"Q/NON-END-RERCHG200CNY REF200CNY\",\"refundedAmPer\":\"0\","
            + "\"comment\":\"��Ʊ��Ч��12���¡���Ʊ����ǩת�� ��ȡ���ڷ�CNY200 ,"
            + "���ں��е�/ƽ/�����ı䣬��������/��ĩ�ı䣬�������¼����˼ۣ��˼۲�������Ӧ���ڷ�һ����ȡ��ͬ��λ���������ǰ�������Ʊ��֮����ڲ�ۣ��貹���ۡ��˼۲���ٲ��಻�� ����ȡ��Ʊ��CNY200 "
            + "����Ʊ��ƱӦ���״����俪ʼ֮���𣨿�Ʊ��һ����δʹ�õģ��ӿ�Ʊ�֮����ʮ��������������� , ���ڶ����������\",\"isPublish\":\"1\",\"refundedAm\":200,"
            + "\"refundedFg\":\"1\"},{\"cabinName\":\"Y\",\"tourCode\":\"WEB1005\",\"passengerType\":\"INF\","
            + "\"fareBasis\":\"YFFWCH\",\"changeAirlineFg\":\"0\",\"rescheduledAm\":0,\"giftId\":\"0\","
            + "\"commission\":\"\",\"rescheduledAmPer\":\"0\",\"productCode\":\"\",\"minStay\":\"\","
            + "\"policyFg\":\"\",\"changeAirlineAmPer\":\"0\",\"rescheduledFg\":\"1\",\"maxStay\":\"12M\","
            + "\"price\":\"260\",\"fareRank\":\"LOW\",\"baggageWeight\":\"20KG\",\"changeAirlineAm\":0,\"ruleId\":0,"
            + "\"ei\":\"Q/NON-END-RER REF100CNY\",\"refundedAmPer\":\"0\",\"comment\":\"��Ʊ��Ч��12���¡���Ʊ����ǩת�� �������������� ,"
            + "���ں��е�/ƽ/�����ı䣬��������/��ĩ�ı䣬�������¼����˼ۣ��˼۲�������Ӧ���ڷ�һ����ȡ��ͬ��λ���������ǰ�������Ʊ��֮����ڲ�ۣ��貹���ۡ��˼۲���ٲ��಻�� ����ȡ��Ʊ��CNY100 "
            + "����Ʊ��ƱӦ���״����俪ʼ֮���𣨿�Ʊ��һ����δʹ�õģ��ӿ�Ʊ�֮����ʮ��������������� , ���ڶ����������\",\"isPublish\":\"1\",\"refundedAm\":100,"
            + "\"refundedFg\":\"1\"},{\"cabinName\":\"Y\",\"tourCode\":\"WEB1005\",\"passengerType\":\"INF\","
            + "\"fareBasis\":\"YFFWCH\",\"changeAirlineFg\":\"0\",\"rescheduledAm\":0,\"giftId\":\"0\","
            + "\"commission\":\"\",\"rescheduledAmPer\":\"0\",\"productCode\":\"\",\"minStay\":\"\","
            + "\"policyFg\":\"\",\"changeAirlineAmPer\":\"0\",\"rescheduledFg\":\"1\",\"maxStay\":\"12M\","
            + "\"price\":\"260\",\"fareRank\":\"NORMAL\",\"baggageWeight\":\"20KG\",\"changeAirlineAm\":0,"
            + "\"ruleId\":0,\"ei\":\"Q/NON-END-RER REF100CNY\",\"refundedAmPer\":\"0\","
            + "\"comment\":\"��Ʊ��Ч��12���¡���Ʊ����ǩת�� �������������� ,"
            + "���ں��е�/ƽ/�����ı䣬��������/��ĩ�ı䣬�������¼����˼ۣ��˼۲�������Ӧ���ڷ�һ����ȡ��ͬ��λ���������ǰ�������Ʊ��֮����ڲ�ۣ��貹���ۡ��˼۲���ٲ��಻�� ����ȡ��Ʊ��CNY100 "
            + "����Ʊ��ƱӦ���״����俪ʼ֮���𣨿�Ʊ��һ����δʹ�õģ��ӿ�Ʊ�֮����ʮ��������������� , ���ڶ����������\",\"isPublish\":\"1\",\"refundedAm\":100,"
            + "\"refundedFg\":\"1\"},{\"cabinName\":\"Y\",\"tourCode\":\"WEB1005\",\"passengerType\":\"INF\","
            + "\"fareBasis\":\"YFFWCH\",\"changeAirlineFg\":\"0\",\"rescheduledAm\":0,\"giftId\":\"0\","
            + "\"commission\":\"\",\"rescheduledAmPer\":\"0\",\"productCode\":\"\",\"minStay\":\"\","
            + "\"policyFg\":\"\",\"changeAirlineAmPer\":\"0\",\"rescheduledFg\":\"1\",\"maxStay\":\"12M\","
            + "\"price\":\"260\",\"fareRank\":\"SUPER\",\"baggageWeight\":\"20KG\",\"changeAirlineAm\":0,"
            + "\"ruleId\":0,\"ei\":\"Q/NON-END-RER REF100CNY\",\"refundedAmPer\":\"0\","
            + "\"comment\":\"��Ʊ��Ч��12���¡���Ʊ����ǩת�� �������������� ,"
            + "���ں��е�/ƽ/�����ı䣬��������/��ĩ�ı䣬�������¼����˼ۣ��˼۲�������Ӧ���ڷ�һ����ȡ��ͬ��λ���������ǰ�������Ʊ��֮����ڲ�ۣ��貹���ۡ��˼۲���ٲ��಻�� ����ȡ��Ʊ��CNY100 "
            + "����Ʊ��ƱӦ���״����俪ʼ֮���𣨿�Ʊ��һ����δʹ�õģ��ӿ�Ʊ�֮����ʮ��������������� , ���ڶ����������\",\"isPublish\":\"1\",\"refundedAm\":100,"
            + "\"refundedFg\":\"1\"}]}],\"language\":\"zh\",\"channelNo\":22,\"cabinRank\":\"ECONOMY\","
            + "\"currency\":\"CNY\"}";


        //CancelRQ readRQ = JSON.parseObject(s, CancelRQ.class);
    }
}
