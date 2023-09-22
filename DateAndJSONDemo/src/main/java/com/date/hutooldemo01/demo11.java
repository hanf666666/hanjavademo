package com.date.hutooldemo01;

import cn.hutool.core.date.*;

import java.util.Date;

/**
 * to do
 *
 * @author Hj
 * @date 2022/9/30
 */
public class demo11 {
    public static void main(String[] args) {

        DateTime startTime = DateUtil.parse("2023-02-07 11:11:49");
        DateTime endTime = DateUtil.parse("2023-02-07 15:11:48");
        System.out.println(startTime.after(endTime));
        System.out.println(startTime.isBefore(endTime));


        System.out.println(DateUtil.between(startTime,endTime, DateUnit.HOUR));
        System.out.println(DateUtil.between(startTime,endTime, DateUnit.DAY));
        DateTime offset = DateUtil.offset(startTime, DateField.DAY_OF_YEAR, 1);
        System.out.println(DateUtil.parse(offset.toString(DatePattern.NORM_DATE_PATTERN)+" 00:00:00"));
        String aaa= "0101.zip";
        System.out.println(aaa.substring(0,aaa.length()-4));

        System.out.println("=========================================");
         startTime = DateUtil.parse("2023-01-01 00:00:00");
         endTime = DateUtil.parse("2023-06-01 15:11:48");

        System.out.println(DateUtil.betweenMonth(startTime,endTime,true));
        long betweenMonth = DateUtil.betweenMonth(startTime, endTime, true);
        for (int i = 0; i < betweenMonth; i++) {
            System.out.println(startTime.toString("yyyy-MM-dd 00:00:00"));
            DateTime dateTime = DateUtil.offsetMonth(startTime, 1);
            System.out.println(dateTime.toString("yyyy-MM-dd 00:00:00"));
            startTime=dateTime;

        }


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
