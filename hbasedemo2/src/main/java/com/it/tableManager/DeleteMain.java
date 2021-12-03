package com.it.tableManager;

import com.it.utils.HBaseUtil;
import org.apache.hadoop.hbase.TableName;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/3
 */

public class DeleteMain {
    public HBaseUtil hBaseUtil = null;

    @Before
    public void before() {
        hBaseUtil = new HBaseUtil();
    }

    @Test
    public void deleteTable() {
        String[] tableArray={
                "bigdata003_parking_lot2",

        };
        for (int i = 0; i < tableArray.length; i++) {
            try {
                hBaseUtil.dropTable(tableArray[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
