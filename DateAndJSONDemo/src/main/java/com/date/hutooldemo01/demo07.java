package com.date.hutooldemo01;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * to do
 *
 * @author Hj
 * @date 2022/9/30
 */
public class demo07 {
    public static void main(String[] args) {

        DateTime startTime = DateUtil.parse("2022-10-10 23:59:20");
        DateTime endTime = DateUtil.parse("2022-10-13 00:00:20");
        long days = DateUtil.betweenDay(startTime, endTime, true) + 1;
        for (int i = 0; i < days; i++) {
            if (i == 0) {
                DateTime curstartTime = DateUtil.parse(startTime.toString("yyyy-MM-dd 23:59:59"));
                System.out.println("第一天curstartTime:" + curstartTime + "时长" + DateUtil.between(startTime, curstartTime, DateUnit.MS));

            } else if (i == days - 1) {
                DateTime curstartTime = DateUtil.parse(startTime.toString("yyyy-MM-dd 00:00:00"));
                System.out.println("最后一天curstartTime:" + curstartTime + "时长" + DateUtil.between(endTime, curstartTime, DateUnit.MS));

            } else {
                startTime = DateUtil.parse(startTime.toString("yyyy-MM-dd 23:59:59"));
                DateTime curstartTime = DateUtil.parse(startTime.toString("yyyy-MM-dd 00:00:00"));
                System.out.println("2curstartTime:" + curstartTime + "时长" + DateUtil.between(startTime, curstartTime, DateUnit.MS));

            }
            startTime = startTime.offset(DateField.DAY_OF_YEAR, 1);

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
