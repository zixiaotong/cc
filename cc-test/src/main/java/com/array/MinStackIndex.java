package com.array;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @author shanglei
 * @date 2018/10/9 12:41
 */
public class MinStackIndex {
    private List<Integer> data = new ArrayList<>();
    private List<Integer> mins = new ArrayList<>();

    public void push(int num) {
        data.add(num);
        if (mins.size() == 0) {
            // 初始化mins
            mins.add(0);
        } else {
            // 辅助栈mins push最小值的索引
            int min = getMin();
            if (num < min) {
                mins.add(data.size() - 1);
            }
        }
    }

    public int pop() {
        // 栈空，抛出异常
        if (data.size() == 0) {
            throw new EmptyStackException();
        }
        // pop时先获取索引
        int popIndex = data.size() - 1;
        // 获取mins栈顶元素，它是最小值索引
        int minIndex = mins.get(mins.size() - 1);
        // 如果pop出去的索引就是最小值索引，mins才出栈
        if (popIndex == minIndex) {
            mins.remove(mins.size() - 1);
        }
        return data.remove(data.size() - 1);
    }

    public int getMin() {
        // 栈空，抛出异常
        if (data.size() == 0) {
            throw new EmptyStackException();
        }
        // 获取mins栈顶元素，它是最小值索引
        int minIndex = mins.get(mins.size() - 1);
        return data.get(minIndex);
    }
}
