package com.map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author shanglei
 * @date 2018/1/9.
 */
public class MapKey {
    @Test
    public void test1() {
        Map<String, Object> retMap = new HashMap<String, Object>();
        //retMap.put("flag", true);
        retMap.put("flag", true);
        retMap.put("msg", "超市未开通");

        System.out.println(retMap.containsKey("msg1"));
        System.out.println(retMap.get("msg"));
    }
}
