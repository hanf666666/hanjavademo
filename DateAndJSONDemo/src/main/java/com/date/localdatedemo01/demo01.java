package com.date.localdatedemo01;

import cn.hutool.core.date.DateUtil;

import java.time.LocalDateTime;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
public class demo01 {
    public static void main(String[] args) {
        Long aa=1640966400000L;
        final LocalDateTime localDateTime = DateUtil.date(aa).toLocalDateTime();
        final String s = localDateTime.toString();

        System.out.println(s);
    }
}
