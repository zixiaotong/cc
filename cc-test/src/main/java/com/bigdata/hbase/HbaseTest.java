package com.bigdata.hbase;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2018/4/15 14:56
 */
public class HbaseTest {
    /**
     * 建表
     *
     * @param
     * @author shanglei
     * @date 2018/4/15 15:29
     */
    @Test
    public void test1() throws IOException {
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "note5:2181,note6:2181,note7:2181");
        HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration);

        TableName tableName = TableName.valueOf("article");
        HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);

        HColumnDescriptor f1 = new HColumnDescriptor("f1");
        f1.setMaxVersions(3);
        HColumnDescriptor f2 = new HColumnDescriptor("f2");

        hTableDescriptor.addFamily(f1);
        hTableDescriptor.addFamily(f2);

        hBaseAdmin.createTable(hTableDescriptor);
        hBaseAdmin.close();

    }

    @Test
    public void insert() throws IOException {
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "note5:2181,note6:2181,note7:2181");

        HTable hTable = new HTable(configuration, "article");
        Put put = new Put("zhangsan-yule_2018-04-15_sina".getBytes());
        put.add("f1".getBytes(), "title".getBytes(), "XXX".getBytes());
        put.add("f1".getBytes(), "auther".getBytes(), "dalei".getBytes());

        Put put2 = new Put("zhangsan-tiyu_2015-04-09_sina".getBytes());
        put2.add("f1".getBytes(), "title".getBytes(), "superisenbaisselledtocba".getBytes());
        put2.add("f1".getBytes(), "author".getBytes(), "qiaodan".getBytes());
        put2.add("f1".getBytes(), "content".getBytes(), "sladjflsakdjglskjgdlksajgdlkjdsglksgd".getBytes());

        Put put3 = new Put("zhangsan-yule_2015-04-10_sina".getBytes());
        put3.add("f1".getBytes(), "title".getBytes(), "fengjiezhengrongchenggongchaobingbing".getBytes());
        put3.add("f1".getBytes(), "author".getBytes(), "yahanmeirongzhengxing".getBytes());
        put3.add("f1".getBytes(), "content".getBytes(), "we098r70932ut50329uwoijelwejt".getBytes());

        ArrayList<Put> rows = new ArrayList<Put>();
        rows.add(put2);
        rows.add(put3);

        hTable.put(rows);
        hTable.close();
    }

    @Test
    public void testQuery() throws Exception {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "note5:2181,note6:2181,note7:2181");
        HTable article = new HTable(conf, "article");

        Get get = new Get(Bytes.toBytes("zhangsan-yule_2015-04-10_sina"));
        get.addFamily("f1".getBytes());
        Result result = article.get(get);
        byte[] title = result.getValue("f1".getBytes(), "title".getBytes());
        byte[] author = result.getValue("f1".getBytes(), "author".getBytes());
        byte[] content = result.getValue("f1".getBytes(), "content".getBytes());
        System.out.println(new String(title) + "  " + new String(author) + " " + new String(content));

        article.close();

    }
}
