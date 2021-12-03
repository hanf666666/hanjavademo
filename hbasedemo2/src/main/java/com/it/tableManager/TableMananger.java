package com.it.tableManager;

import com.it.utils.HBaseUtil;
import org.apache.hadoop.hbase.TableName;
import org.junit.Before;
import org.junit.Test;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/3
 */
public class TableMananger {
    public HBaseUtil hBaseUtil = null;

    @Before
    public void before() {
        hBaseUtil = new HBaseUtil();
    }

    @Test
    public void getTables() {
        final TableName[] tables = hBaseUtil.getTables();
        for (TableName table : tables) {
            System.out.println(new String(table.getName()));

        }
    }
    @Test
    public void createtable(){
         hBaseUtil.createTable("bigdata003_parking_lot2","info");

    }
}
