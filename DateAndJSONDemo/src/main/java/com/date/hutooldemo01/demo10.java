package com.date.hutooldemo01;

import cn.hutool.core.date.*;

import java.text.DateFormat;
import java.util.Date;

/**
 * to do
 *
 * @author Hj
 * @date 2022/9/30
 */
public class demo10 {
    public static void main(String[] args) {


        DateTime startTime = DateUtil.parse("2024-01-01 00:11:49");
        DateTime endTime = DateUtil.parse("2024-01-31 00:12:00");
        long days = DateUtil.betweenDay(startTime, endTime, true) + 1;
        for (int i = 0; i < days; i++) {
            System.out.println("('"+startTime.toString(DatePattern.NORM_DATE_PATTERN)+"'),");
            startTime = startTime.offset(DateField.DAY_OF_YEAR, 1);

        }
        /*
        DateTime startTime = DateUtil.parse("2023-02-07 15:11:49");
        DateTime endTime = DateUtil.parse("2023-04-07 15:11:49");
        long days = DateUtil.betweenDay(startTime, endTime, true) + 1;
        for (int i = 0; i < days; i++) {
            startTime = startTime.offset(DateField.DAY_OF_YEAR, 1);
            System.out.println("('"+startTime.toString(DatePattern.NORM_DATE_PATTERN)+"'),");
        }*/

    }

    public static int minuteDiff(Date startDate, Date endDate) {
        long temp = millisecondDiff(startDate, endDate);
        return (int) (temp / (1000 * 60));
    }


    /**
     * 计算两个日期相关的秒数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int secondDiff(Date startDate, Date endDate) {
        long temp = millisecondDiff(startDate, endDate);
        return (int) (temp / (1000));
    }

    /**
     * 计算两个日期的相差值，返回毫秒
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static long millisecondDiff(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            throw new NullPointerException("开始日期或结束日期为空.");
        }

        if (startDate.getTime() > endDate.getTime()) {
            throw new IllegalArgumentException("开始日期大于结束日期. ");
        }

        return endDate.getTime() - startDate.getTime();
    }
}
