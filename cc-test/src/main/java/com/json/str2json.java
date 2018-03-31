package com.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.junit.Test;

/**
 * @author shanglei
 * @date 2018/3/28 16:47
 */
public class str2json {

    @Test
    public void test1() {
        String s = "{\"drawPrize\":0,\"ssIds\":\"4,73\",\"activityStartTime\":\"2018-04-01 00:00:00\","
            + "\"activityEndTime\":\"2018-04-30 23:59:59\",\"accountTypeList\":[{\"accountId\":99989,"
            + "\"accountType\":0,\"startTime\":\"2018-04-01 00:00:00\",\"endTime\":\"2018-04-10 23:59:59\"},"
            + "{\"accountId\":99988,\"accountType\":0,\"startTime\":\"2018-04-11 00:00:00\",\"endTime\":\"2018-04-20 "
            + "23:59:59\"},{\"accountId\":99987,\"accountType\":0,\"startTime\":\"2018-04-21 00:00:00\","
            + "\"endTime\":\"2018-04-30 23:59:59\"},{\"accountId\":99986,\"accountType\":1,\"startTime\":\"\","
            + "\"endTime\":\"\"}]}";

        JSONObject o = JSON.parseObject(s);
        int drawPrize = o.getIntValue("drawPrize");
        JSONArray jsonArray = o.getJSONArray("accountTypeList");
        for (Object guest : jsonArray) {
            JSONObject jo  = (JSONObject)guest;
            System.out.println(jo.getIntValue("accountId"));
        }
    }
}
