package com.bigdata.hbase;

import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.BinaryPrefixComparator;
import org.apache.hadoop.hbase.filter.ByteArrayComparable;
import org.apache.hadoop.hbase.filter.ColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.FamilyFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.QualifierFilter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;

public class HbaseDemo {

    private Configuration conf;

    @Before
    public void init() {
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "note5:2181,note6:2181,note7:2181");
    }

    @Test
    public void testDrop() throws Exception {
        HBaseAdmin admin = new HBaseAdmin(conf);
        admin.disableTable("account");
        admin.deleteTable("account");
        admin.close();
    }

    @Test
    public void testPut() throws Exception {
        HTable table = new HTable(conf, "person_info");
        Put p = new Put(Bytes.toBytes("person_rk_bj_zhang_000002"));
        p.add("base_info".getBytes(), "name".getBytes(), "zhangwuji".getBytes());
        table.put(p);
        table.close();
    }

    @Test
    public void testGet() throws Exception {
        HTable table = new HTable(conf, "person_info");
        Get get = new Get(Bytes.toBytes("person_rk_bj_zhang_000001"));
        get.setMaxVersions(5);
        Result result = table.get(get);

        List<Cell> cells = result.listCells();

        for (Cell c : cells) {
        }
        List<KeyValue> kvs = result.list();
        for (KeyValue kv : kvs) {
            String family = new String(kv.getFamily());
            System.out.println(family);
            String qualifier = new String(kv.getQualifier());
            System.out.println(qualifier);
            System.out.println(new String(kv.getValue()));
        }
        table.close();
    }

    @Test
    public void testScan() throws Exception {
        HTable table = new HTable(conf, "person_info".getBytes());
        Scan scan = new Scan(Bytes.toBytes("person_rk_bj_zhang_000001"), Bytes.toBytes("person_rk_bj_zhang_000002"));

        Filter filter;

        ByteArrayComparable rowComparator = new BinaryComparator(Bytes.toBytes("person_rk_bj_zhang_000001"));
        RowFilter rf = new RowFilter(CompareOp.LESS_OR_EQUAL, rowComparator);

        rf = new RowFilter(CompareOp.EQUAL, new SubstringComparator("_2014-12-21_"));

        new SingleColumnValueFilter("base_info".getBytes(), "name".getBytes(), CompareOp.EQUAL, "zhangsan".getBytes());
        ByteArrayComparable comparator = new RegexStringComparator("zhang.");
        new SingleColumnValueFilter("info".getBytes(), "NAME".getBytes(), CompareOp.EQUAL, comparator);

        comparator = new SubstringComparator("wu");
        new SingleColumnValueFilter("info".getBytes(), "NAME".getBytes(), CompareOp.EQUAL, comparator);

        FamilyFilter ff = new FamilyFilter(
            CompareOp.EQUAL,
            new BinaryComparator(Bytes.toBytes("base_info"))
        );
        ff = new FamilyFilter(
            CompareOp.EQUAL,
            new BinaryPrefixComparator(Bytes.toBytes("inf"))
        );

        filter = new QualifierFilter(
            CompareOp.EQUAL,
            new BinaryComparator(Bytes.toBytes("na"))
        );
        filter = new QualifierFilter(
            CompareOp.EQUAL,
            new BinaryPrefixComparator(Bytes.toBytes("na"))
        );

        filter = new ColumnPrefixFilter("na".getBytes());

        byte[][] prefixes = new byte[][] {Bytes.toBytes("na"), Bytes.toBytes("me")};
        filter = new MultipleColumnPrefixFilter(prefixes);

        scan.setFilter(filter);

        scan.addFamily(Bytes.toBytes("base_info"));
        ResultScanner scanner = table.getScanner(scan);
        for (Result r : scanner) {

            for (KeyValue kv : r.list()) {
                String family = new String(kv.getFamily());
                System.out.println(family);
                String qualifier = new String(kv.getQualifier());
                System.out.println(qualifier);
                System.out.println(new String(kv.getValue()));
            }

            byte[] value = r.getValue(Bytes.toBytes("base_info"), Bytes.toBytes("name"));
            System.out.println(new String(value));
        }
        table.close();
    }

    @Test
    public void testDel() throws Exception {
        HTable table = new HTable(conf, "user");
        Delete del = new Delete(Bytes.toBytes("rk0001"));
        del.deleteColumn(Bytes.toBytes("data"), Bytes.toBytes("pic"));
        table.delete(del);
        table.close();
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "note5:2181,note6:2181,note7:2181");
        HBaseAdmin admin = new HBaseAdmin(conf);

        TableName tableName = TableName.valueOf("person_info");
        HTableDescriptor td = new HTableDescriptor(tableName);
        HColumnDescriptor cd = new HColumnDescriptor("base_info");
        cd.setMaxVersions(10);
        td.addFamily(cd);
        admin.createTable(td);
        admin.close();

    }

}
