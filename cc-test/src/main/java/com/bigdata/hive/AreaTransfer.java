package com.bigdata.hive;

import java.util.HashMap;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * @author shanglei
 * @date 2018/4/21 16:38
 */
public class AreaTransfer extends UDF {

    private static HashMap<String, String> areaMap = new HashMap<>();

    static {
        areaMap.put("138", "beijing");
        areaMap.put("139", "nanjing");
        areaMap.put("137", "tianjin");
    }

    public String evaluate(String phone) {

        return areaMap.get(phone.substring(0, 3)) == null ? "other" : areaMap
            .get(phone.substring(0, 3));

    }

}
