package com.date.hutooldemo01;

import cn.hutool.core.date.DateUtil;

import java.util.Calendar;

/**
 * to do
 *  �㹤����
 * @author Hj
 * @date 2022/1/13
 */
public class demo03 {
    public static void main(String[] args) {

        String time = DateUtil.date().getTime()+"";
        System.out.println(time.substring(0,10));

    }


}
