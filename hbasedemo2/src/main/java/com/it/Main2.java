/*
package com.it;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;

*/
/**
 * to do
 *
 * @author Hj
 * @date 2021/8/2
 *//*

public class Main2 {

    public static void main(String[] args) throws IOException {


    }
    public static String selectRow(String tablename, String rowKey) throws IOException {
        String record = "";
        TableName name=TableName.valueOf(tablename);
        Table table = connection.getTable(name);
        Get g = new Get(rowKey.getBytes());

        Result rs = table.get(g);
        NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> map = rs.getMap();
        for (Cell cell : rs.rawCells()) {
            */
/*StringBuffer stringBuffer = new StringBuffer().append(Bytes.toString(cell.getRow())).append("\t")
                    .append(Bytes.toString(cell.getFamily())).append("\t")
                    .append(Bytes.toString(cell.getQualifier())).append("\t")
                    .append(Bytes.toString(cell.getValue())).append("\n");*//*

            StringBuffer stringBuffer = new StringBuffer().append(new String(cell.getRowArray(),"UTF-8")).append("\t")
                    .append(new String(cell.getFamilyArray(),"UTF-8")).append("\t")
                    .append(new String(cell.getQualifierArray(),"UTF-8")).append("\t")
                    .append(new String(cell.getValueArray(),"UTF-8")).append("\n");
            String str = stringBuffer.toString();
            record += str;
        }
        return record;
    }

    private static void Getdata(Connection hBaseConnection) throws IOException {
        final Table table = hBaseConnection.getTable(TableName.valueOf("ns1:t1"));
        final Get get = new Get(Bytes.toBytes("r1"));
        final Result result = table.get(get);
        for (Cell cell : result.rawCells()) {
            System.out.println("Famiily:" + new String(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength(), "UTF-8"));
            System.out.println("Qualifier:" + new String(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength(), "UTF-8"));
            System.out.println("TimeStamp:" + cell.getTimestamp());
            System.out.println("rowkey:" + new String(cell.getRowArray(), cell.getRowOffset(), cell.getRowLength(), "UTF-8"));
            System.out.println("Value:" + new String(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength(), "UTF-8"));
        }
    }

}
*/
