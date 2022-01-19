package com.it.utils;


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

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/2
 */

public class HBaseUtil {


    /**
     * 连接池对象
     */
    public Connection connection;


    /**
     * 静态构造，在调用静态方法时前进行运行
     * 初始化连接对象．
     * */

    /**
     * 设置hbase的配置信息,从yml中获取
     */
    public void setHBaseconfig() {
        try {
            Configuration configuration = HBaseConfiguration.create();
            configuration.set("hbase.zookeeper.quorum", "172.17.134.80:2181,172.17.134.81:2181,172.17.134.82:2181");
            connection = ConnectionFactory.createConnection(configuration);
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
    protected void putDataH(String tableName, String rowkey, String family,
                            String qualifier, Object value) throws IOException {
        Admin admin = connection.getAdmin();
        TableName tN = TableName.valueOf(tableName);
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
    protected String getValueBySeriesH(String tableName, String rowKey,
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
    protected Map<String, String> getAllValueＨ(String tableName,
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
                resultMap = new HashMap<>();
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
     * 获取hbase的表
     *
     * @return
     */
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
     * 根据指定表获取指定行键rowKey的所有数据 并以Map集合的形式返回查询到的结果
     * 每条数据之间用&&&将Qualifier和Value进行区分
     *
     * @param tableName 要获取表 tableName 的表名
     * @param rowkey    指定的行键rowKey
     */
    public ArrayList<String> getFromRowkeyValues(String tableName, String rowkey) {
        ArrayList<String> Resultlist = new ArrayList<>();
        Get get = new Get(Bytes.toBytes(rowkey));
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
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

    /**
     * 根据表名获取所有的数据
     */
    @SuppressWarnings("unused")
    private void getAllValues(String tableName) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            table.close();
            Scan scan = new Scan();
            ResultScanner resultScanner = table.getScanner(scan);
            for (Result result : resultScanner) {
                System.out.println("scan:  " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据rowkey前缀获取数据
     */
    @SuppressWarnings("unused")
    public ResultScanner getPrefixFilterGetData(String tableName, String prefixRowkey) {
        ResultScanner resultScanner = null;
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
            PrefixFilter prefixFilter = new PrefixFilter(Bytes.toBytes(prefixRowkey));
            scan.setFilter(prefixFilter);
            resultScanner = table.getScanner(scan);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultScanner;
    }


    /**
     * 根据rowkey前缀的数据范围
     */
    @SuppressWarnings("unused")
    public ResultScanner getRowRangeData(String tableName, String startRow, String endRow) {
        ResultScanner resultScanner = null;
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
            scan.withStartRow(Bytes.toBytes(startRow));
            scan.withStopRow(Bytes.toBytes(endRow));
            resultScanner = table.getScanner(scan);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultScanner;
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


            ResultScanner resultScanner = table.getScanner(scan);
            int i = 1;
            for (Result result : resultScanner) {
                System.out.println(i++ + "==>scan:  " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String genRowKey(String[] array) {
        String rowKey = "";
        rowKey = String.join("_", Arrays.asList(array));

        return rowKey;

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
            ResultScanner resultScanner = table.getScanner(scan);
            int i = 1;
            for (Result result : resultScanner) {
                System.out.println(i++ + "==>scan:  " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getTestDate(String tableName) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
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


    public ResultScanner getAll(String tableName, String family) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        scan.addFamily(family.getBytes());
        return table.getScanner(scan);
    }

    public void insertbean(String tableName, Object object) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));

        List<Put> putList = new ArrayList<>();
        final Put put = new Put("aaa".getBytes());
        put.addColumn("info".getBytes(), "name".getBytes(), "hanjing".getBytes());
        putList.add(put);
        table.put(putList);

    }

    /**
     * @param tableName
     * @param put
     * @throws IOException
     */
    public void insertPut(String tableName, Put put) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        table.put(put);

    }

    /**
     * @param tableName
     * @param putList
     * @throws IOException
     */
    public void insertPutList(String tableName, List<Put> putList) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        table.put(putList);

    }


}