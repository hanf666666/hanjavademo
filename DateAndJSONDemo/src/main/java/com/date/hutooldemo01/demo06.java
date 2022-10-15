package com.date.hutooldemo01;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
public class demo06 {
    public static void main(String[] args) {
        Date date = new Date();
        String yyyy = DateUtil.date(date).toString("yyyy-MM-dd 00:00:00");
        DateTime parse = DateUtil.parse(yyyy);
        System.out.println(parse);

        int i = minuteDiff(date, parse);
        System.out.println(i);

    }

    public static int minuteDiff(Date startDate, Date endDate){
        return (int) (startDate.getTime()-endDate.getTime());
    }
}
