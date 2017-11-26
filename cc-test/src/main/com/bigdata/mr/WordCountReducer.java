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
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context)
        throws IOException, InterruptedException {
        long count = 0;
        for (LongWritable longWritable : values) {
            count += longWritable.get();
        }
        // 输出单词key，对对应的count总和
        context.write(key, new LongWritable(count));
    }
}
