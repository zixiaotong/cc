package com.bigdata.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/11/26.
 */
public class WordCountDriver {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job wcjob = Job.getInstance(conf);

        wcjob.setJarByClass(WordCountDriver.class);

        wcjob.setMapperClass(WordCountMapper.class);
        wcjob.setReducerClass(WordCountReducer.class);

        wcjob.setMapOutputKeyClass(Test.class);
        wcjob.setMapOutputValueClass(LongWritable.class);

        wcjob.setOutputKeyClass(Test.class);
        wcjob.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(wcjob, new Path("/hello.txt"));

        FileOutputFormat.setOutputPath(wcjob, new Path("/wordcount/output"));

        wcjob.waitForCompletion(true);
    }

}
