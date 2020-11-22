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

/**
 * @author shanglei
 * @date 2018/4/5 15:55
 */
public class FlowSummary {

    public static class FlowSummaryMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
        @Override
        protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
            String line = value.toString();
            String[] fields = StringUtils.split(line, "\t");
            String phoneStr = fields[1];
            long up_flow = Long.parseLong(fields[fields.length - 3]);
            long d_flow = Long.parseLong(fields[fields.length - 2]);
            FlowBean flowBean = new FlowBean();
            flowBean.set(up_flow, d_flow);
            context.write(new Text(phoneStr), flowBean);
        }
    }

    public static class FlowSummaryReducer extends Reducer<Text, FlowBean, Text, FlowBean> {
        @Override
        protected void reduce(Text key, Iterable<FlowBean> values, Context context)
            throws IOException, InterruptedException {
            long up_sum = 0;
            long d_sum = 0;
            for (FlowBean flowBean : values) {
                d_sum += flowBean.getD_flow();
                up_sum += flowBean.getUp_flow();
            }
            FlowBean flowBean = new FlowBean();
            flowBean.set(up_sum, d_sum);
            context.write(key, flowBean);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(FlowSummary.class);
        job.setMapperClass(FlowSummaryMapper.class);
        job.setReducerClass(FlowSummaryReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        int result = job.waitForCompletion(true) ? 0 : 1;
        System.exit(result);
    }
}
