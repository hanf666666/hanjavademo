package com.Thread.alidemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/3
 */
public class Maindemo01 {


    private static final String TABLE_NAME = "mytable2";
    private static final String CF_DEFAULT = "cf";
    public static final byte[] QUALIFIER = "col1".getBytes();
    private static final byte[] ROWKEY = "rowkey1".getBytes();

    public static void main(String[] args) {
        Configuration config = HBaseConfiguration.create();
        //ZKµÿ÷∑
        String zkAddress = "hb-2zei94r0f7s815763-master1-001.hbase.rds.aliyuncs.com:2181,hb-2zei94r0f7s815763-master2-001.hbase.rds.aliyuncs.com:2181,hb-2zei94r0f7s815763-master3-001.hbase.rds.aliyuncs.com:2181";
        config.set(HConstants.ZOOKEEPER_QUORUM, zkAddress);
        Connection connection = null;

        try {
            connection = ConnectionFactory.createConnection(config);

            HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(TABLE_NAME));
            tableDescriptor.addFamily(new HColumnDescriptor(CF_DEFAULT));
//            System.out.print("Creating table. ");
//            Admin admin = connection.getAdmin();
//            admin.createTable(tableDescriptor);
//            System.out.println(" Done.");
            Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
            try {
                Put put = new Put(ROWKEY);
                put.addColumn(CF_DEFAULT.getBytes(), QUALIFIER, "this is value".getBytes());
                table.put(put);
                Get get = new Get(ROWKEY);
                Result r = table.get(get);
                byte[] b = r.getValue(CF_DEFAULT.getBytes(), QUALIFIER);  // returns current version of value
                System.out.println(new String(b));
            } finally {
                if (table != null) table.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
