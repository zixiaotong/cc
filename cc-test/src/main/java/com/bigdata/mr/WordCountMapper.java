package com.bigdata.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author shanglei
 * @date 2017/11/26.
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    //map方法中就是我们到业务逻辑
    @Override
    protected void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException {

        //拿到一行到内容
        String line = value.toString();
        //切分单词
        String[] words = line.split(" ");
        //输出<单词，1>这样到kv对
        for (String word : words) {
            context.write(new Text(word), new LongWritable(1));

        }

    }
}
