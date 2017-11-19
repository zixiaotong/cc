package com.bigdata.hdfs;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/11/19.
 */
public class hdfsUtils {

    @Test
    public void test1() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://master:9000");
        FileSystem fs = FileSystem.get(conf);
        FSDataOutputStream os = fs.create(new Path("hdfs://master:9000/nginx_164.tar.gz"));
        FileInputStream is = new FileInputStream("/Users/shanglei/Downloads/nginx_164.tar.gz");
        IOUtils.copy(is, os);
    }
}
