package com.mt.connectdemo;

import com.mt.entity.utils.HBaseUtil;
import org.apache.hadoop.hbase.TableName;
import org.junit.Test;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
public class connectCount2 {

    @Test
    public void getTables() {
        HBaseUtil hBaseUtil = new HBaseUtil();
        HBaseUtil hBaseUtil2 = new HBaseUtil();
        final TableName[] tables = hBaseUtil.getTables();
        final TableName[] tables2 = hBaseUtil2.getTables();
        for (TableName table : tables) {
            System.out.println(new String(table.getName()));

        }
        for (TableName table : tables2) {
            System.out.println(new String(table.getName()));

        }
    }


}
