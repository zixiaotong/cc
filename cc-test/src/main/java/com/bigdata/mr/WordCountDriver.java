package com.bigdata.mr;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.junit.Before;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/11/26.
 */
public class WordCountDriver {

    /**
     * 集群中运行模式打成jar包OK
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job wcjob = Job.getInstance(conf);
        wcjob.setJarByClass(WordCountDriver.class);
        wcjob.setMapperClass(WordCountMapper.class);
        wcjob.setReducerClass(WordCountReducer.class);
        wcjob.setMapOutputKeyClass(Text.class);
        wcjob.setMapOutputValueClass(LongWritable.class);
        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(LongWritable.class);
        FileInputFormat.setInputPaths(wcjob, new Path("/wordcount/data/"));
        FileOutputFormat.setOutputPath(wcjob, new Path("/wordcount/output/"));
        wcjob.waitForCompletion(true);
    }

    /**
     * 本地只运行程序，数据取的是hdfs上的，计算数据在本地OK
     */
    @Test
    public void test1() throws Exception {
        Configuration conf = new Configuration();
        // 在idea本地run集群中的数据，需要加这一行。否则路径要写全路径（hdfs集群中的全路径）
        conf.set("fs.defaultFS", "hdfs://master:9000");
        Job wcjob = Job.getInstance(conf);
        wcjob.setJarByClass(WordCountDriver.class);
        wcjob.setMapperClass(WordCountMapper.class);
        wcjob.setReducerClass(WordCountReducer.class);
        wcjob.setMapOutputKeyClass(Text.class);
        wcjob.setMapOutputValueClass(LongWritable.class);
        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(LongWritable.class);
        FileInputFormat.setInputPaths(wcjob, new Path("/wordcount/data/"));
        FileOutputFormat.setOutputPath(wcjob, new Path("/wordcount/output/"));
        wcjob.waitForCompletion(true);
    }

    /**
     * 本地只运行程序，数据在本地，计算数据在本地OK
     */
    @Test
    public void test2() throws Exception {
        Configuration conf = new Configuration();
        Job wcjob = Job.getInstance(conf);
        wcjob.setJarByClass(WordCountDriver.class);
        wcjob.setMapperClass(WordCountMapper.class);
        wcjob.setReducerClass(WordCountReducer.class);
        wcjob.setMapOutputKeyClass(Text.class);
        wcjob.setMapOutputValueClass(LongWritable.class);
        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(LongWritable.class);
        FileInputFormat.setInputPaths(wcjob, new Path("/home/wordcount/data/"));
        FileOutputFormat.setOutputPath(wcjob, new Path("/home/wordcount/output/"));
        wcjob.waitForCompletion(true);
    }

    /**
     * 本地只运行程序，数据取的是hdfs上的，计算数据也在yarn集群上
     * 需要加四个xml OK
     */
    @Test
    public void test3() throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://master:9000");
        conf.set("mapreduce.job.jar", "cc-test.jar");
        Job wcjob = Job.getInstance(conf);
        wcjob.setJarByClass(WordCountDriver.class);
        wcjob.setMapperClass(WordCountMapper.class);
        wcjob.setReducerClass(WordCountReducer.class);
        wcjob.setMapOutputKeyClass(Text.class);
        wcjob.setMapOutputValueClass(LongWritable.class);
        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(LongWritable.class);
        FileInputFormat.setInputPaths(wcjob, new Path("/wordcount/data/"));
        FileOutputFormat.setOutputPath(wcjob, new Path("/wordcount/output/"));
        wcjob.waitForCompletion(true);
    }

    // 以上都是在linux上运行

    // 下面例子在mac上运行

    /**
     * 跑本地模式 OK 记住不能加配置文件
     *
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        Configuration conf = new Configuration();
        Job wcjob = Job.getInstance(conf);
        wcjob.setJarByClass(WordCountDriver.class);
        wcjob.setMapperClass(WordCountMapper.class);
        wcjob.setReducerClass(WordCountReducer.class);
        wcjob.setMapOutputKeyClass(Text.class);
        wcjob.setMapOutputValueClass(LongWritable.class);
        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(LongWritable.class);
        FileInputFormat.setInputPaths(wcjob, new Path("/Users/shanglei/Downloads/wordcount/data/"));
        FileOutputFormat.setOutputPath(wcjob, new Path("/Users/shanglei/Downloads/wordcount/output1/"));
        wcjob.waitForCompletion(true);
    }

    /**
     * 跑集群模式
     *
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {
        Configuration conf = new Configuration();
        conf.set("mapreduce.job.jar", "cc-test.jar");
        Job wcjob = Job.getInstance(conf);
        wcjob.setJarByClass(WordCountDriver.class);
        wcjob.setMapperClass(WordCountMapper.class);
        wcjob.setReducerClass(WordCountReducer.class);
        wcjob.setMapOutputKeyClass(Text.class);
        wcjob.setMapOutputValueClass(LongWritable.class);
        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(LongWritable.class);
        FileInputFormat.setInputPaths(wcjob, new Path("/wordcount/data/"));
        FileOutputFormat.setOutputPath(wcjob, new Path("/wordcount/output2/"));
        wcjob.waitForCompletion(true);
    }

}
