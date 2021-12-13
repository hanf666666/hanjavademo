package com.Thread.mt.main;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.Thread.utils.HBaseUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * to do
 * 单位时间内的出入场信息
 * @author Hj
 * @date 2021/10/12
 */
public class AppRealtimeScreenInOrOutCountTest {
    public HBaseUtil hBaseUtil = null;

    @Before
    public void before() {
        hBaseUtil = new HBaseUtil();
    }

    @Test
    public void createTable() {
        final boolean centralized_management_realtime_park;
        try {
            centralized_management_realtime_park = hBaseUtil.dropTable("InOrOutCountinfo");
            System.out.println(centralized_management_realtime_park);
        } catch (IOException e) {
            e.printStackTrace();
        }


        hBaseUtil.createTable("InOrOutCountinfo", "statistic");
    }

    @Test
    public void getPrefixFilterGetData() {
        final DateTime starttime = DateUtil.date();
        for (int i = 0; i < 50; i++) {
            hBaseUtil.getPrefixFilterGetData("centralized_management_realtime_park", "19701_0");

        }
        final DateTime endtime = DateUtil.date();
        System.out.println("响应时间==>" + DateUtil.between(starttime, endtime, DateUnit.MS) + "ms");

    }


    @Test
    public void getFilterList() {
        final DateTime starttime = DateUtil.date();
        final ArrayList<Integer> parkidList = new ArrayList<Integer>();
        for (int i = 19060; i < 19860; i++) {
            parkidList.add(i);
        }
        hBaseUtil.getFilterListData("centralized_management_realtime_park", parkidList);
        final DateTime endtime = DateUtil.date();
        System.out.println("响应时间==>" + DateUtil.between(starttime, endtime, DateUnit.MS) + "ms");

    }

    @Test
    public void getRegexFilterList() {
        final DateTime starttime = DateUtil.date();
        hBaseUtil.getRegexFilterListData("centralized_management_realtime_park", ".*2021100901$");
        final DateTime endtime = DateUtil.date();
        System.out.println("响应时间==>" + DateUtil.between(starttime, endtime, DateUnit.MS) + "ms");

    }
}
