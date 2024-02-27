package com.date.hutooldemo01;

import cn.hutool.core.date.*;

import java.util.Arrays;

/**
 * to do
 *  Ëã¹¤×÷ÈÕ
 * @author Hj
 * @date 2022/1/13
 */
public class demo05 {
    public static void main(String[] args) {
        DateTime nowdate = DateUtil.date();
        DateTime startdate = DateUtil.date().offset(DateField.MINUTE, -5);
//        System.out.println(nowdate.toString());
//        System.out.println(startdate);


        DateTime initdate = DateUtil.parse("2017-09-01 14:21:51.000");
        DateTime enddate = DateUtil.parse("2024-03-06 14:21:51.000");
        long between = DateUtil.betweenMonth(initdate,enddate,true);
        for (int i = 0; i < between+1; i++) {
            DateTime curdate = DateUtil.offsetMonth(initdate, i);
            System.out.println("----------------1"+curdate);
            String[] endKey = new String[]{
                    "ids",
                    DateUtil.format(curdate, DatePattern.PURE_DATETIME_MS_PATTERN)
            };

            String[]startKey = new String[]{
                     "ids",
                    DateUtil.format(DateUtil.offsetMonth(curdate, -1), DatePattern.PURE_DATETIME_MS_PATTERN)
            };

            System.out.println("----------------2"+DateUtil.offsetMonth(curdate, -1));

            System.out.println(genRowKey(startKey));
            System.out.println(genRowKey(endKey));
        }

    }
    public static String genRowKey(String[] array) {
        String rowKey = "";
        rowKey = String.join("_", Arrays.asList(array));

        return rowKey;

    }


}
