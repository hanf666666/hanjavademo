package com.date.hutooldemo01;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

/**
 * to do
 *  Ëã¹¤×÷ÈÕ
 * @author Hj
 * @date 2022/1/13
 */
public class demo04 {
    public static void main(String[] args) {
        DateTime initdate = DateUtil.parse("2017-09-06 14:21:51.000");
        long between = DateUtil.between(initdate, DateUtil.date(), DateUnit.DAY);
        DateTime nowdate = DateUtil.date();
        for (int i = 0; i < between+2; i++) {
            DateTime curdate=DateUtil.offsetDay(nowdate, -i);
            String curdatestr=DateUtil.format(curdate, DatePattern.NORM_DATE_PATTERN);
            System.out.print("('"+curdatestr+"'),");
        }



    }


}
