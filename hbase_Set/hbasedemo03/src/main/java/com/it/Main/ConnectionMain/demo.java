package com.it.Main.ConnectionMain;

import com.it.utils.HBaseUtil;
import org.apache.hadoop.hbase.TableName;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/19
 */
public class demo {
    public static void main(String[] args) {
        final HBaseUtil hBaseUtil = new HBaseUtil();
        hBaseUtil.setHBaseconfig();
        final TableName[] tables = hBaseUtil.getTables();
        for (TableName table : tables) {
            System.out.println(new String(table.getName()));

        }

        final HBaseUtil hBaseUtil2 = new HBaseUtil();
        hBaseUtil2.setHBaseconfig();
        final TableName[] tables2 = hBaseUtil2.getTables();
        for (TableName table : tables2) {
            System.out.println(new String(table.getName()));

        }
    }
}
