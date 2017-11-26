package com.cn.test;//package com.online.cn.test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.listdemo;
//import java.util.Map;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        //for (int i =0; i < 10; i = i + 2) {
//        //    listdemo<Integer> list1 = new ArrayList<>();
//        //    list1.add(i);
//        //    if (i + 1 < 10) {
//        //        list1.add(i + 1);
//        //    }
//        //    System.out.println(list1.toString());
//        //}
//
//        listdemo<listdemo<String>> listdemo = new ArrayList<>();
//
//        listdemo<String> list11 = new ArrayList<>();
//        list11.add("a");
//        listdemo<String> list12 = new ArrayList<>();
//        list12.add("b");
//        listdemo<String> list13 = new ArrayList<>();
//        list13.add("c");
//
//        listdemo.add(list11);
//        listdemo.add(list12);
//        listdemo.add(list13);
//
//        listdemo<listdemo<String>> list2 = new ArrayList<>();
//        listdemo<String> list22 = new ArrayList<>();
//        list22.add("1");
//        listdemo<String> list23 = new ArrayList<>();
//        list23.add("2");
//        listdemo<String> list24 = new ArrayList<>();
//        list24.add("3");
//        list2.add(list22);
//        list2.add(list23);
//        list2.add(list24);
//
//        for (int i = 0; i < listdemo.size(); i++) {
//            for (int j = 0; j < list2.size(); j++) {
//
//                for (int k = 0; k < listdemo.get(i).size(); k++) {
//                    for (int l = 0; l < list2.get(j).size(); l++) {
//                        System.out.println(listdemo.get(i).get(k) + "---" + list2.get(j).get(l));
//                    }
//                }
//            }
//        }
//
//        //
//        //
//        //for(int i = 0; i <=listdemo.size(); i = i + 2){
//        //    listdemo<String> list1 = new ArrayList<>();
//        //    list1.add(listdemo.get(i));
//        //    if (i + 1 < listdemo.size()) {
//        //        list1.add(listdemo.get(i+1));
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
