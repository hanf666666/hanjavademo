package com.print.tableManager;

import com.print.utils.HBaseUtil;
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
                "park_duration_rate",
                "park_duration_rate3",
                "details",
                "bigdata003_parking_lot_roadside",
                "bigdata003_parking_lot_indoor",

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
