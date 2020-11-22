package com.bigdata.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author shanglei
 * @date 2017/11/26.
 */
public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
    //reduce方法调用到时候会传递进来一个key以及这个key所有到value
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context)
        throws IOException, InterruptedException {

        //定义一个计数器
        long count = 0;
        //遍历values，累加到计数器中
        for (LongWritable value : values) {

            count += value.get();

        }

        //输出一个单词key及其总次数
        context.write(key, new LongWritable(count));

    }
}
