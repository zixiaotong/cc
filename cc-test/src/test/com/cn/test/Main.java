package com.cn.test;//package com.online.cn.test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        //for (int i =0; i < 10; i = i + 2) {
//        //    List<Integer> list1 = new ArrayList<>();
//        //    list1.add(i);
//        //    if (i + 1 < 10) {
//        //        list1.add(i + 1);
//        //    }
//        //    System.out.println(list1.toString());
//        //}
//
//        List<List<String>> list = new ArrayList<>();
//
//        List<String> list11 = new ArrayList<>();
//        list11.add("a");
//        List<String> list12 = new ArrayList<>();
//        list12.add("b");
//        List<String> list13 = new ArrayList<>();
//        list13.add("c");
//
//        list.add(list11);
//        list.add(list12);
//        list.add(list13);
//
//        List<List<String>> list2 = new ArrayList<>();
//        List<String> list22 = new ArrayList<>();
//        list22.add("1");
//        List<String> list23 = new ArrayList<>();
//        list23.add("2");
//        List<String> list24 = new ArrayList<>();
//        list24.add("3");
//        list2.add(list22);
//        list2.add(list23);
//        list2.add(list24);
//
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list2.size(); j++) {
//
//                for (int k = 0; k < list.get(i).size(); k++) {
//                    for (int l = 0; l < list2.get(j).size(); l++) {
//                        System.out.println(list.get(i).get(k) + "---" + list2.get(j).get(l));
//                    }
//                }
//            }
//        }
//
//        //
//        //
//        //for(int i = 0; i <=list.size(); i = i + 2){
//        //    List<String> list1 = new ArrayList<>();
//        //    list1.add(list.get(i));
//        //    if (i + 1 < list.size()) {
//        //        list1.add(list.get(i+1));
//        //    }
//        //    System.out.println(list1.toString());
//        //}
//
//    }
//
//}
////[1, 2]
////[3, 4]
////[5, 6]
////[7, 8]
////[9]
