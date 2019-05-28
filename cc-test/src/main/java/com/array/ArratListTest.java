package com.array;

import java.util.*;

import org.apache.commons.lang.math.NumberUtils;
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
        map.put("2","22");
        System.out.println(map);


    }
    @Test
    public void test3() {
        int[] a = {1, 3, 4, 5, 67};
        Arrays.sort(a);
        /**
         * 从前台传过来的课程id集合，用，隔开
         */
        String[] b = {"1", "4", "5", "3", "67"};
        int[] ints = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            ints[i] = Integer.parseInt(b[i]);
        }
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.equals(a, ints));
    }
    @Test
    public void test4() {
        String[] a = {  "4", "2","1" };
        String[] b = { "1","2","3","4" };
        List<String> alist = new ArrayList<>(Arrays.asList(a));
        List<String> blist = new ArrayList<>(Arrays.asList(b));
        List<String> aaaaaaaa = Arrays.asList(b);
//        blist.retainAll(alist);
//        System.out.println(alist);
//        System.out.println(blist);
//        System.out.println(blist.size() == alist.size());

        System.out.println(blist.containsAll(alist));
    }
}
