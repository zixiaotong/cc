package com.bigdata.mr.flowanalysis;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FlowSummarySort {
    public static class FlowSummarySortMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
        @Override
        protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
            String s = value.toString();
            String[] fields = StringUtils.split(s, "\t");
            String phoneStr = fields[0];
            long up_flow = Long.parseLong(fields[1]);
            long d_flow = Long.parseLong(fields[2]);
            FlowBean flowBean = new FlowBean();
            flowBean.set(up_flow, d_flow);
            context.write(flowBean, new Text(phoneStr));
        }
    }

    public static class FlowSummarySortReducer extends Reducer<FlowBean, Text, Text, FlowBean> {
        @Override
        protected void reduce(FlowBean bean, Iterable<Text> phoneStr, Context context)
            throws IOException, InterruptedException {
            for (Text text : phoneStr) {
                context.write(text, bean);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(FlowSummarySort.class);
        job.setMapperClass(FlowSummarySortMapper.class);
        job.setReducerClass(FlowSummarySortReducer.class);
        // 此处一定要分清楚输入和输出
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        int result = job.waitForCompletion(true) ? 0 : 1;
        System.exit(result);
    }
}
