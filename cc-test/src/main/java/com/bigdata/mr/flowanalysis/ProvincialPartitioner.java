package com.bigdata.mr.flowanalysis;

import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author shanglei
 * @date 2018/4/6 15:24
 */
public class ProvincialPartitioner extends Partitioner<Text, FlowBean> {

    private static HashMap<String, Integer> provinceMap = new HashMap<String, Integer>();
    static {
        provinceMap.put("136", 0);
        provinceMap.put("137", 1);
        provinceMap.put("138", 2);
        provinceMap.put("139", 3);
    }

    @Override
    public int getPartition(Text text, FlowBean flowBean, int i) {
        String subKey = text.toString().substring(0, 3);
        Integer provinceId = provinceMap.get(subKey);
        return provinceId == null ? 4 : provinceId;
    }
}
