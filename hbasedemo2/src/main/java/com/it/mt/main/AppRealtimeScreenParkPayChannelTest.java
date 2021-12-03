package com.it.mt.main;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.it.utils.HBaseUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * to do
 *
 * @author Hj
 * @date 2021/9/24
 */

public class AppRealtimeScreenParkPayChannelTest {

    public HBaseUtil hBaseUtil = null;

    @Before
    public void before() {
        hBaseUtil = new HBaseUtil();
    }

    @Test
    public void createTable() {
        final boolean centralized_management_realtime_park;
        try {
            centralized_management_realtime_park = hBaseUtil.dropTable("centralized_management_realtime_park");
            System.out.println(centralized_management_realtime_park);
        } catch (IOException e) {
            e.printStackTrace();
        }


        hBaseUtil.createTable("centralized_management_realtime_park", "statistic");
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

    @Test
    public void getfasdferList() {
        final DateTime starttime = DateUtil.date();
        hBaseUtil.getPrefixFilterGetData("bigdata003_parking_lot2", "");
        final DateTime endtime = DateUtil.date();
        System.out.println("响应时间==>" + DateUtil.between(starttime, endtime, DateUnit.MS) + "ms");

    }
}
