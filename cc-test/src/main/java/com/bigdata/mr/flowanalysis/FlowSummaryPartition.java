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

public class FlowSummaryPartition {

    public static class FlowSummaryPartitionMapper extends
        Mapper<LongWritable, Text, Text, FlowBean> {

        @Override
        protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

            // 拿到一行的内容
            String line = value.toString();
            // 切分出各个字段
            String[] fields = StringUtils.split(line, "\t");
            // extract出我们需要的字段
            String phoneNbr = fields[1];
            long up_flow = Long.parseLong(fields[fields.length - 3]);
            long d_flow = Long.parseLong(fields[fields.length - 2]);

            FlowBean bean = new FlowBean();
            bean.set(up_flow, d_flow);
            context.write(new Text(phoneNbr), bean);

        }

    }

    public static class FlowSummaryPartitionReducer extends Reducer<Text, FlowBean, Text, FlowBean> {

        @Override
        protected void reduce(Text key, Iterable<FlowBean> beans, Context context)
            throws IOException, InterruptedException {

            long up_sum = 0;
            long d_sum = 0;
            for (FlowBean bean : beans) {

                up_sum += bean.getUp_flow();
                d_sum += bean.getD_flow();
            }

            FlowBean bean = new FlowBean();
            bean.set(up_sum, d_sum);
            context.write(key, bean);
        }

    }

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(FlowSummaryPartition.class);

        job.setMapperClass(FlowSummaryPartitionMapper.class);
        job.setReducerClass(FlowSummaryPartitionReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //指定分组逻辑使用我们自定义的分组器ProvincialPartitioner
        job.setPartitionerClass(ProvincialPartitioner.class);
        //指定reduce task的实例数 设置成4会抛异常计算出来的手机号不知道应该放到哪。
        //可以设置成8，多余的3个会没有数据
        //可以设置成1，可以工作，计算得到的全放到那一个里面。
        job.setNumReduceTasks(5);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        int res = job.waitForCompletion(true) ? 0 : 1;
        System.exit(res);

    }

}
