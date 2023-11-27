package com.date.date;

import cn.hutool.core.date.DateUtil;

import java.sql.Timestamp;

/**
 * to do
 *
 * @author Hj
 * @date 2022/12/19
 */
public class demo04 {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(1699865976000L);
        System.out.println(timestamp.toString());
        String yyyyMM = DateUtil.parse(timestamp.toString()).toString("yyyyMM");

        System.out.println(yyyyMM);




    }
}
