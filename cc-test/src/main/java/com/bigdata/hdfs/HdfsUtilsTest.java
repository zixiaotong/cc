package com.bigdata.hdfs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/11/19.
 */
public class HdfsUtilsTest {

    FileSystem fs;

    @Before
    public void init() throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://master:9000");
        fs = FileSystem.get(new URI("hdfs://master:9000"), conf, "root");
    }

    /**
     * 上传文件到hdfs
     */
    @Test
    public void testUpload() throws IOException {
        fs.copyFromLocalFile(new Path("/Users/shanglei/Downloads/nginx_164.tar.gz"),
            new Path("/nginx_164.tar.gz"));
    }

    /**
     * 下载文件到本地
     */
    @Test
    public void testDownload() throws IOException {
        fs.copyToLocalFile(new Path("/nginx_164.tar.gz"),
            new Path("/Users/shanglei/Downloads/nginx_164_1.tar.gz"));
    }

    /**
     * 下载文件代码跟踪
     */
    @Test
    public void testFileCodeDownload() throws IOException {
        FSDataInputStream fsDataInputStream = fs.open(new Path("/test.tar"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(""));
        IOUtils.copy(fsDataInputStream, fileOutputStream);

    }

    /**
     * 创建文件夹
     */
    @Test
    public void testMkdir() throws IOException {
        fs.mkdirs(new Path("/a/b/c"));
    }

    /**
     * 查看目录信息
     */
    @Test
    public void listFileInfo() throws IOException {
        RemoteIterator<LocatedFileStatus> remoteIterator = fs.listFiles(new Path("/"), true);
        while (remoteIterator.hasNext()) {
            LocatedFileStatus info = remoteIterator.next();
            System.out.println(info.getPath().getName());
        }
        System.out.println("--------------------");
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (FileStatus fileStatus : fileStatuses) {
            String str = fileStatus.isDirectory() ? "d--" : "f--";
            System.out.println(str + "---" + fileStatus.getPath().getName());
        }
    }

    /**
     * 修改文件名
     */
    @Test
    public void removeName() throws IOException {
        fs.rename(new Path("/nginx_164.tar.gz"), new Path("/nginx164.tar.gz"));
    }
}
