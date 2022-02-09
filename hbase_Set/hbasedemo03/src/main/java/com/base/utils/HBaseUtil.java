package com.base.utils;


import org.apache.commons.io.IOUtils;
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
     * ���ӳض���
     */
    public Connection connection;


    /**
     * ��̬���죬�ڵ��þ�̬����ʱǰ��������
     * ��ʼ�����Ӷ���
     * */

    /**
     * ����hbase��������Ϣ,��yml�л�ȡ
     */
    public void setHBaseconfig() {
        try {
            Configuration configuration = HBaseConfiguration.create();
            configuration.set("hbase.zookeeper.quorum", "172.17.134.80:2181,172.17.134.81:2181,172.17.134.82:2181");
            connection = ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }// �������ӳ�
    }

    /**
     * @param tableName ����һ���� tableName ָ���ı����� seriesStr
     * @param seriesStr ���ַ�������ʽָ��������壬ÿ�������Զ��ŵ���ʽ����,(���磺��f1,f2���������壬�ֱ�Ϊf1��f2)
     **/
    public boolean createTable(String tableName, String seriesStr) {
        boolean isSuccess = false;// �ж��Ƿ񴴽��ɹ�����ʼֵΪfalse
        Admin admin = null;
        TableName table = TableName.valueOf(tableName);
        try {
            admin = connection.getAdmin();
            if (!admin.tableExists(table)) {
                System.out.println("INFO:Hbase::  " + tableName + "ԭ���ݿ��б����ڣ���ʼ����...");
                HTableDescriptor descriptor = new HTableDescriptor(table);
                String[] series = seriesStr.split(",");
                for (String s : series) {
                    descriptor.addFamily(new HColumnDescriptor(s.getBytes()));
                }
                admin.createTable(descriptor);
                System.out.println("INFO:Hbase::  " + tableName + "�µ�" + tableName + "�����ɹ���");
                isSuccess = true;
            } else {
                System.out.println("INFO:Hbase::  �ñ��Ѿ����ڣ�����Ҫ�ڴ�����");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(admin);
        }
        return isSuccess;
    }

    /**
     * ɾ��ָ�������ı�
     *
     * @param tableName ������
     * @throws IOException
     */
    public boolean dropTable(String tableName) throws IOException {
        boolean isSuccess = false;// �ж��Ƿ񴴽��ɹ�����ʼֵΪfalse
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
     * ��ָ�����в�������
     *
     * @param tableName Ҫ�������ݵı���
     * @param rowkey    ָ��Ҫ�������ݵı���м�
     * @param family    ָ��Ҫ�������ݵı������family
     * @param qualifier Ҫ�������ݵ�qualifier
     * @param value     Ҫ�������ݵ�ֵvalue
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
            System.out.println("�������ݵı����ڣ���ָ����ȷ��tableName ! ");
        }
    }

    /**
     * ����ָ�����ȡָ���м�rowkey������family������ �����ַ�������ʽ���ز�ѯ���Ľ��
     *
     * @param tableName Ҫ��ȡ�� tableName �ı���
     * @param rowKey    ָ��Ҫ��ȡ���ݵ��м�
     * @param family    ָ��Ҫ��ȡ���ݵ�����Ԫ��
     * @param qualifier ָ��Ҫ��ȡ���ݵ�qualifier
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
     * ����ָ�����ȡָ���м�rowKey������family������ ����Map���ϵ���ʽ���ز�ѯ���Ľ��
     *
     * @param tableName Ҫ��ȡ�� tableName �ı���
     * @param rowKey    ָ�����м�rowKey
     * @param family    ָ������family
     */
    protected Map<String, String> getAllValue��(String tableName,
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
     * ��ȡhbase�ı�
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
     * ����ָ�����ȡָ���м�rowKey���������� ����Map���ϵ���ʽ���ز�ѯ���Ľ��
     * ÿ������֮����&&&��Qualifier��Value��������
     *
     * @param tableName Ҫ��ȡ�� tableName �ı���
     * @param rowkey    ָ�����м�rowKey
     */
    public ArrayList<String> getFromRowkeyValues(String tableName, String rowkey) {
        ArrayList<String> Resultlist = new ArrayList<>();
        Get get = new Get(Bytes.toBytes(rowkey));
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Result r = table.get(get);
            for (Cell cell : r.rawCells()) {
                //ÿ������֮����&&&��Qualifier��Value��������
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
     * ���ݱ�����ȡ���е�����
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
     * ����rowkeyǰ׺��ȡ����
     */
    @SuppressWarnings("unused")
    public ResultScanner getPrefixFilterGetData(String tableName, String prefixRowkey) {
        ResultScanner  resultScanner = null;
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
     * ����rowkeyǰ׺�����ݷ�Χ
     */
    @SuppressWarnings("unused")
    public ResultScanner getRowRangeData(String tableName, String startRow, String endRow) {
        ResultScanner resultScanner = null;
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
            scan.withStartRow(Bytes.toBytes(startRow));
            scan.withStopRow(Bytes.toBytes(endRow));
            scan.setCaching(100);
            scan.addColumn(Bytes.toBytes("info"),Bytes.toBytes("carInImage"));
            resultScanner = table.getScanner(scan);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultScanner;
    }


    /**
     * ����rowkeyǰ׺��ȡ����
     */
    @SuppressWarnings("unused")
    public void getFilterListData(String tableName, ArrayList<Integer> arrayList) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
            //��Ϲ�����filterList  statistic:park_id
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
     * ����rowkeyǰ׺��ȡ����
     */
    @SuppressWarnings("unused")
    public void getRegexFilterListData(String tableName, String regex) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
            //��Ϲ�����filterList  statistic:park_id
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
        System.out.println("INFO:Hbase::  ���Խ��������С�" + count + "������");
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