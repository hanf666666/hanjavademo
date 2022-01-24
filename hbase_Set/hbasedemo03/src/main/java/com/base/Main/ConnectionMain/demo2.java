package com.base.Main.ConnectionMain;

import com.base.utils.HBaseUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.ResultScanner;

/**
 * to do
 *setCaching
 * @author Hj
 * @date 2022/1/19
 */
public class demo2 {
    public static void main(String[] args) {
        final HBaseUtil hBaseUtil = new HBaseUtil();
        hBaseUtil.setHBaseconfig();
        final TableName[] tables = hBaseUtil.getTables();
        for (TableName table : tables) {
            System.out.println(new String(table.getName()));

        }
        hBaseUtil.setHBaseconfig();
        final ResultScanner carIODataResultScanner = hBaseUtil.getRowRangeData("CarIOData", "4590DE_TD4590DE0b95f3db-ae05-4a0c-84ae-b40a167a0f53", "4590DE_TD4590DE0b95f3db-ae05-4a0c-84ae-b40a167a0f5~");
        carIODataResultScanner.forEach(result -> {
            System.out.println(result.toString());
        });



    }
}
