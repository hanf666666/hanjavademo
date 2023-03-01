package com.date.hutooldemo01;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * to do
 *
 * @author Hj
 * @date 2022/9/30
 */
public class demo11 {
    public static void main(String[] args) {

        DateTime startTime = DateUtil.parse("2022-11-07 17:24:30");
        DateTime endTime = DateUtil.parse("2023-02-07 15:11:49");
        System.out.println(startTime.after(endTime));
        System.out.println(startTime.isBefore(endTime));


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
