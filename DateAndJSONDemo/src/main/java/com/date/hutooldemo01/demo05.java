package com.date.hutooldemo01;

import cn.hutool.core.date.*;

/**
 * to do
 *  Ëã¹¤×÷ÈÕ
 * @author Hj
 * @date 2022/1/13
 */
public class demo05 {
    public static void main(String[] args) {
        DateTime nowdate = DateUtil.date();
        DateTime startdate = DateUtil.date().offset(DateField.MINUTE, -5);
        System.out.println(nowdate.toString());
        System.out.println(startdate);


    }


}
