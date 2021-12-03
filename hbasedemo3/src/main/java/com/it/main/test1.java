package com.it.main;

import com.it.utils.HBaseUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;

import java.io.IOException;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
public class test1 {
    public static void main(String[] args) throws IOException {
        final HBaseUtil hBaseUtil = new HBaseUtil();
        hBaseUtil.setHBaseconfig();
//        final boolean afdasf = hBaseUtil.createTable("afdasf","info");
//        final boolean afdasf = hBaseUtil.dropTable("afdasf");
//        System.out.println(afdasf);
        final ResultScanner resultScanner = hBaseUtil.getAll("bigdata003_parking_lot2","cf");
//        final ResultScanner resultScanner = hBaseUtil.getAll("bigdata003_ParkingPaymentChannel","info");
        for (Result result : resultScanner) {
            System.out.println(result);

        }



    }
}
