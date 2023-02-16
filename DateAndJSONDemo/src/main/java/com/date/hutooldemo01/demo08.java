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
public class demo08 {
    public static void main(String[] args) {

//        int millisecond = DateUtil.date().millisecond();
        Long millisecond = DateUtil.date().getTime();
        System.out.println(millisecond);


    }

}
