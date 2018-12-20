package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author shanglei
 * @date 2018/11/7 11:02
 */
public class ArratListTest {
    @Test
    public void test1(){
        List list = new ArrayList<String>();
        list.add("555");
        list.add(null);
        // add remove 添加删除元素
        // get set  获取 修改元素
        list.get(0);
        list.set(0,"666");
        System.out.println(list);
    }

    @Test
    public void test2(){
        Map map = new HashMap<String,String>(16,0.75f);
        map.put("1","2");
        map.put("2","2");
        System.out.println(map);
    }
}
