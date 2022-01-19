package com.mt.connectdemo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.mt.entity.utils.HBaseUtil;
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
public class connectCount {
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




}
