package com.mt.main;

import com.mt.entity.utils.HBaseUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/2
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        final Connection hBaseConnection = getHBaseConnection();
//        Getdata(hBaseConnection);
        final HBaseUtil hBaseUtil = new HBaseUtil();
        final boolean f1 = hBaseUtil.createTable("student", "f1");
        System.out.println(f1);


        final ArrayList<String> list = hBaseUtil.getFromRowkeyValues("student", "r1");
        for (String key : list
        ) {
            System.out.println(key);
        }

    }

    private static void Getdata(Connection hBaseConnection) throws IOException {
        final Table table = hBaseConnection.getTable(TableName.valueOf("ns1:t1"));
        final Get get = new Get(Bytes.toBytes("r1"));
        final Result result = table.get(get);
        for (Cell rowKv : result.rawCells()) {
            System.out.println("Famiily:" + new String(rowKv.getFamilyArray(), rowKv.getFamilyOffset(), rowKv.getFamilyLength(), "UTF-8"));
            System.out.println("Qualifier:" + new String(rowKv.getQualifierArray(), rowKv.getQualifierOffset(), rowKv.getQualifierLength(), "UTF-8"));
            System.out.println("TimeStamp:" + rowKv.getTimestamp());
            System.out.println("rowkey:" + new String(rowKv.getRowArray(), rowKv.getRowOffset(), rowKv.getRowLength(), "UTF-8"));
            System.out.println("Value:" + new String(rowKv.getValueArray(), rowKv.getValueOffset(), rowKv.getValueLength(), "UTF-8"));
        }
    }

    public static Connection getHBaseConnection() throws IOException {
        // 创建HBASE的链接对象
        final Configuration hbaseConf = HBaseConfiguration.create();
//    System.getProperties.setProperty("HADOOP_USER_NAME","hdfs")
        hbaseConf.set("hbase.zookeeper.quorum", "172.17.134.80:2181,172.17.134.81:2181,172.17.134.82:2181");
        hbaseConf.set("hbase.zookeeper.property.clientPort", "2181");
        final Connection connection = ConnectionFactory.createConnection(hbaseConf);
        return connection;

    }
}
