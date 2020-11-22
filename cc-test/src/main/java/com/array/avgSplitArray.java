package com.array;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2018/12/20 22:19
 */
public class avgSplitArray {
    @Test
    public void testSendMsg() {
        System.out.println(split(Lists.newArrayList(1,5), 3));
    }

    public static List<List<Integer>> split(List<Integer> origin, int num) {
        if (origin == null || origin.size() == 0) {
            return null;
        }
        if (num <= 0) {
            throw new RuntimeException();
        }
        List<Integer> copy = new ArrayList<>(origin);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = num; i > 0; i--) {
            int length = copy.size();
            if (length == 0) {
                result.add(new ArrayList<>());
                continue;
            }
            int tmp = length / i;
            if (length % i != 0) {
                tmp++;
            }
            result.add(copy.subList(0, tmp));
            if (tmp < copy.size()) {
                copy = copy.subList(tmp, copy.size());
            } else {
                copy = new ArrayList<>();
            }
        }
        return result;
    }

    public static List<List<Integer>> split2(List<Integer> origin, int num) {
        List<List<Integer>> result = new ArrayList<>();
        int length = origin.size();
        int index = 0;
        for (int i = num; i > 0; i--) {
            if (length == 0) {
                result.add(new ArrayList<Integer>());
                continue;
            }
            int tmp = length / i;
            if (length % i != 0) {
                tmp++;
            }
            result.add(origin.subList(index, index + tmp));
            index += tmp;
            length -= tmp;
        }

        return result;
    }
    public void ssss(){
        System.out.println("DFd");
    }
}
