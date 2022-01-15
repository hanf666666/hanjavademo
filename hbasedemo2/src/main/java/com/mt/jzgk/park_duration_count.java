package com.mt.jzgk;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.print.utils.HBaseUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
public class park_duration_count {
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
    public void getfasdferList() {
        final DateTime starttime = DateUtil.date();
        final ResultScanner bigdata003_parking_lot2ResultScanner = hBaseUtil.
                getPrefixFilterGetData("bigdata003_park_duration_count", "");
        int i = 1;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (Result result : bigdata003_parking_lot2ResultScanner) {

            Map<byte[], byte[]> columnMap = result.getFamilyMap(Bytes.toBytes("info"));
            String line="'"+Bytes.toString(result.getRow())+"',";
            String[] arrayStr ={"park_id","park_duration","car_num"};
            for (int j = 0; j <arrayStr.length ; j++) {
//                System.out.println(arrayStr[j]);
                final byte[] valuebytes = columnMap.get(Bytes.toBytes(arrayStr[j]));
                if (arrayStr[j].contains("park_duration")){
                    line+="'"+Bytes.toString(valuebytes)+"',";
                }else{
                    line+=Bytes.toString(valuebytes)+",";
                }
            }
            System.out.println("("+line+"),");

        }


    }



}
