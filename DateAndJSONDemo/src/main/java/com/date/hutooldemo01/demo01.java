package com.date.hutooldemo01;

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
        String yyyy = DateUtil.date().toString("yyyy-MM-dd 23:59:59");
        System.out.println(yyyy);
    }
}
