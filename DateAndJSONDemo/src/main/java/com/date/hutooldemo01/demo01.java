package com.date.hutooldemo01;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
public class demo01 {
    public static void main(String[] args) {
        String yyyy = DateUtil.date().toString("yyyy-MM-dd 00:00:00");
        DateTime startDate = DateUtil.date().offset(DateField.DAY_OF_YEAR, -1);
        String startDateStr=startDate.toString("yyyy-MM-dd 00:00:00");
        System.out.println(yyyy);
        System.out.println(startDateStr);


        String endDateTime = DateUtil.offsetDay(DateUtil.date(), -0).toString("yyyy-MM-dd 23:59:59");
        System.out.println("endDateTime"+endDateTime);

        System.out.println(DateUtil.date().getTime());
    }
}
