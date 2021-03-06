package com.mt.entity.utils;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/2
 */


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class HBaseUtil {

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
    public HBaseUtil() {
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

    /**
     * @param tableName 创建一个表 tableName 指定的表名　 seriesStr
     * @param seriesStr 以字符串的形式指定表的列族，每个列族以逗号的形式隔开,(例如：＂f1,f2＂两个列族，分别为f1和f2)
     **/
    public boolean createTable(String tableName, String seriesStr) {
        boolean isSuccess = false;// 判断是否创建成功！初始值为false
        Admin admin = null;
        TableName table = TableName.valueOf(tableName);
        try {
            admin = connection.getAdmin();
            if (!admin.tableExists(table)) {
                System.out.println("INFO:Hbase::  " + tableName + "原数据库中表不存在！开始创建...");
                HTableDescriptor descriptor = new HTableDescriptor(table);
                String[] series = seriesStr.split(",");
                for (String s : series) {
                    descriptor.addFamily(new HColumnDescriptor(s.getBytes()));
                }
                admin.createTable(descriptor);
                System.out.println("INFO:Hbase::  " + tableName + "新的" + tableName + "表创建成功！");
                isSuccess = true;
            } else {
                System.out.println("INFO:Hbase::  该表已经存在，不需要在创建！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(admin);
        }
        return isSuccess;
    }

    /**
     * 删除指定表名的表
     *
     * @param tableName 　表名
     * @throws IOException
     */
    public boolean dropTable(String tableName) throws IOException {
        boolean isSuccess = false;// 判断是否创建成功！初始值为false
        Admin admin = null;
        TableName table = TableName.valueOf(tableName);
        try {
            admin = connection.getAdmin();
            if (admin.tableExists(table)) {
                admin.disableTable(table);
                admin.deleteTable(table);
                isSuccess = true;
            }
        } finally {
            IOUtils.closeQuietly(admin);
        }
        return isSuccess;
    }


    /**
     * 向指定表中插入数据
     *
     * @param tableName 要插入数据的表名
     * @param rowkey    指定要插入数据的表的行键
     * @param family    指定要插入数据的表的列族family
     * @param qualifier 要插入数据的qualifier
     * @param value     要插入数据的值value
     */
    protected static void putDataH(String tableName, String rowkey, String family,
                                   String qualifier, Object value) throws IOException {
        Admin admin = null;
        TableName tN = TableName.valueOf(tableName);
        admin = connection.getAdmin();
        if (admin.tableExists(tN)) {
            try (Table table = connection.getTable(TableName.valueOf(tableName
                    .getBytes()))) {
                Put put = new Put(rowkey.getBytes());
                put.addColumn(family.getBytes(), qualifier.getBytes(),
                        value.toString().getBytes());
                table.put(put);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("插入数据的表不存在，请指定正确的tableName ! ");
        }
    }

    /**
     * 根据指定表获取指定行键rowkey和列族family的数据 并以字符串的形式返回查询到的结果
     *
     * @param tableName 要获取表 tableName 的表名
     * @param rowKey    指定要获取数据的行键
     * @param family    指定要获取数据的列族元素
     * @param qualifier 指定要获取数据的qualifier
     */
    protected static String getValueBySeriesH(String tableName, String rowKey,
                                              String family, String qualifier) throws IllegalArgumentException, IOException {
        Table table = null;
        String resultStr = null;
        try {
            table = connection
                    .getTable(TableName.valueOf(tableName.getBytes()));
            Get get = new Get(Bytes.toBytes(rowKey));
            if (!get.isCheckExistenceOnly()) {
                get.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier));
                Result res = table.get(get);
                byte[] result = res.getValue(Bytes.toBytes(family),
                        Bytes.toBytes(qualifier));
                resultStr = Bytes.toString(result);
            } else {
                resultStr = null;
            }
        } finally {
            IOUtils.closeQuietly(table);
        }
        return resultStr;
    }


    /**
     * 根据指定表获取指定行键rowKey和列族family的数据 并以Map集合的形式返回查询到的结果
     *
     * @param tableName 要获取表 tableName 的表名
     * @param rowKey    指定的行键rowKey
     * @param family    指定列族family
     */
    protected static Map<String, String> getAllValueＨ(String tableName,
                                                      String rowKey, String family) throws IllegalArgumentException, IOException {
        Table table = null;
        Map<String, String> resultMap = null;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            Get get = new Get(Bytes.toBytes(rowKey));
            if (get.isCheckExistenceOnly()) {
                Result res = table.get(get);
                Map<byte[], byte[]> result = res.getFamilyMap(family.getBytes());
                Iterator<Entry<byte[], byte[]>> it = result.entrySet().iterator();
                resultMap = new HashMap<String, String>();
                while (it.hasNext()) {
                    Entry<byte[], byte[]> entry = it.next();
                    resultMap.put(Bytes.toString(entry.getKey()),
                            Bytes.toString(entry.getValue()));
                }
            }
        } finally {
            IOUtils.closeQuietly(table);
        }
        return resultMap;
    }


    /**
     * 根据指定表获取指定行键rowKey的所有数据 并以Map集合的形式返回查询到的结果
     * 每条数据之间用&&&将Qualifier和Value进行区分
     *
     * @param tableName 要获取表 tableName 的表名
     * @param rowkey    指定的行键rowKey
     */
    public ArrayList<String> getFromRowkeyValues(String tableName, String rowkey) {
        Table table = null;
        ArrayList<String> Resultlist = new ArrayList<>();
        Get get = new Get(Bytes.toBytes(rowkey));
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            Result r = table.get(get);
            for (Cell cell : r.rawCells()) {
                //每条数据之间用&&&将Qualifier和Value进行区分
                String reString = Bytes.toString(CellUtil.cloneQualifier(cell)) + "&&&" + Bytes.toString(CellUtil.cloneValue(cell));
                Resultlist.add(reString);
            }
            table.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return Resultlist;
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


    /**
     * 根据表名获取所有的数据
     */
    @SuppressWarnings("unused")
    private void getAllValues(String tableName) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
            ResultScanner resutScanner = table.getScanner(scan);
            for (Result result : resutScanner) {
                System.out.println("scan:  " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TableName[] getTables() {

        final Admin admin;
        try {

            admin = connection.getAdmin();

            final TableName[] tableNames = admin.listTableNames();
            connection.close();
            return tableNames;
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;

    }


    /**
     * 根据rowkey前缀获取数据
     */
//    @SuppressWarnings("unused")
    public ResultScanner getPrefixFilterGetData(String tableName, String prefixrowkey) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
//            PrefixFilter prefixFilter = new PrefixFilter(Bytes.toBytes(prefixrowkey));
//            scan.setFilter(prefixFilter);
            ResultScanner resutScanner = table.getScanner(scan);
            return resutScanner;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 根据rowkey前缀获取数据
     */
    public ResultScanner getRowData(String tableName) {
        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            ResultScanner resutScanner = table.getScanner(new Scan());
            return resutScanner;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 根据rowkey前缀获取数据
     */
    @SuppressWarnings("unused")
    public void getFilterListData(String tableName, ArrayList<Integer> arrayList) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
            //组合过滤器filterList  statistic:park_id
            FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ONE);
            for (Integer park_id : arrayList) {
//                System.out.println(park_id);
                SingleColumnValueFilter singleColumnValueFilter = new SingleColumnValueFilter(
                        Bytes.toBytes("statistic"),
                        Bytes.toBytes("park_id"),
                        CompareOperator.EQUAL,
                        new BinaryComparator(Bytes.toBytes(park_id + "")));
                filterList.addFilter(singleColumnValueFilter);
                scan.setFilter(filterList);
                System.out.println(filterList.getFilters().size());
            }


            ResultScanner resutScanner = table.getScanner(scan);
            int i = 1;
            for (Result result : resutScanner) {
                System.out.println(i++ + "==>scan:  " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据rowkey前缀获取数据
     */
    @SuppressWarnings("unused")
    public void getRegexFilterListData(String tableName, String regex) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
            //组合过滤器filterList  statistic:park_id
            FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
            RowFilter rowFilter = new RowFilter(CompareOperator.EQUAL,
                    new RegexStringComparator(regex));

            filterList.addFilter(rowFilter);
            scan.setFilter(filterList);
            ResultScanner resutScanner = table.getScanner(scan);
            int i = 1;
            for (Result result : resutScanner) {
                System.out.println(i++ + "==>scan:  " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getTestDate(String tableName) throws IOException {
        Table table = null;
        table = connection.getTable(TableName.valueOf(tableName));
        int count = 0;
        Scan scan = new Scan();
        scan.addFamily("f".getBytes());

        Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,
                new RegexStringComparator("112213.*"));
        scan.setFilter(filter);
        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result : resultScanner) {
            System.out.println(result);
            count++;
        }
        System.out.println("INFO:Hbase::  测试结束！共有　" + count + "条数据");
    }


//    public ResultScanner delete(String tableName,String rowkey,String family,String version) throws IOException {
//        Table table = null;
//        table = connection.getTable(TableName.valueOf(tableName));
//        Delete delete = new Delete(Bytes.toBytes(rowkey));
//        delete.addColumns(Bytes.toBytes(family), Bytes.toBytes(version));
////        delete.add(Bytes.toBytes(family), Bytes.toBytes(version));
//
////        delete.deleteFamily(Bytes.toBytes("professional"));
//    }
}