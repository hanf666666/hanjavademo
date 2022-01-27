package com.mt.producthbase;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.mt.entity.utils.HBaseUtil;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/27
 */
public class HbaseDemo {

    public HBaseUtil hBaseUtil = null;

    @Before
    public void before() {
        hBaseUtil = new HBaseUtil();
    }


    @Test
    public void getFilterList() {
        //scan 组装
        Scan scan = new Scan();
//        scan.withStartRow(Bytes.toBytes("other_20220118164840000_230018084"));
//        scan.withStopRow(Bytes.toBytes( "other_20220118164840000_230018084~"));

        scan.withStartRow(Bytes.toBytes("other"));
        scan.withStopRow(Bytes.toBytes( "other~"));
        //过滤器组装
        scan.setCaching(1000);
        scan.setCacheBlocks(false);
        hBaseUtil.getFilterListData("CarOutData", scan);

    }
}
