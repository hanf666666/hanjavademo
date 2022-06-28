package com.mt.producthbase;

/**
 * @author zhangbo
 * @Date 2022/6/17 16:52
 * @describe
 */


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HBaseUtil2222 {

    /**
     * 连接池对象
     */
    protected static Connection connection;
//    private static final String ZK_QUORUM = "hbase.zookeeper.quorum";
//    private static final String ZK_CLIENT_PORT = "hbase.zookeeper.property.clientPort";
//    /**
//     * HBase位置
//     */
//    private static final String HBASE_POS = "192.168.1.104";
//
//    /**
//     * ZooKeeper位置
//     */
//    private static final String ZK_POS = "172.17.134.80:2181,172.17.134.81:2181,172.17.134.82:2181";
//
//    /**
//     * zookeeper服务端口
//     */
//    private final static String ZK_PORT_VALUE = "2181";

    /**
     * 静态构造，在调用静态方法时前进行运行
     * 初始化连接对象．
     * */
    static {
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "bigdata-alpha-003.meitianbigdata.local:2181,bigdata-alpha-004.meitianbigdata.local:2181,bigdata-alpha-005.meitianbigdata.local:2181");
//        configuration.set("hbase.zookeeper.quorum", "172.17.134.80:2181,172.17.134.81:2181,172.17.134.82:2181");
//        configuration.set("hbase.zookeeper.quorum", "hb-2zei94r0f7s815763-master1-001.hbase.rds.aliyuncs.com:2181,hb-2zei94r0f7s815763-master2-001.hbase.rds.aliyuncs.com:2181,hb-2zei94r0f7s815763-master3-001.hbase.rds.aliyuncs.com:2181");
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        try {
            connection = ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }// 创建连接池
    }

    /**
     * 构造函数，用于初始化内置对象
     */
    public HBaseUtil2222() {
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "172.17.134.80:2181,172.17.134.81:2181,172.17.134.82:2181");
//        configuration.set("hbase.zookeeper.quorum", "hb-2zei94r0f7s815763-master1-001.hbase.rds.aliyuncs.com:2181,hb-2zei94r0f7s815763-master2-001.hbase.rds.aliyuncs.com:2181,hb-2zei94r0f7s815763-master3-001.hbase.rds.aliyuncs.com:2181");
//        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        try {
            connection = ConnectionFactory.createConnection(configuration);
            System.out.println(connection);
        } catch (IOException e) {
            e.printStackTrace();
        }// 创建连接池
    }


    public void getFilterListData(String ormTableName, Scan scan) {
        ResultScanner resultScanner = null;

        try {
            Table table = connection.getTable(TableName.valueOf(ormTableName));
            resultScanner = table.getScanner(scan);
            int count=0;
            for (Result result : resultScanner) {

                for (Cell cell : result.rawCells()) {
                    //每条数据之间用&&&将Qualifier和Value进行区分
                    String reString = Bytes.toString(CellUtil.cloneQualifier(cell)) + "   ==   " + Bytes.toString(CellUtil.cloneValue(cell));
                    System.out.println(reString);
                }
                System.out.println(count+++"======================================================================");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }









    public void getFilterListData222() {
        ResultScanner resultScanner = null;

        try {
            Admin admin=connection.getAdmin();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }




    public static void main(String[] args) {
        HBaseUtil2222 aaa= new HBaseUtil2222();
        aaa.getFilterListData("remain_number_change_79432",new Scan());
    }
}