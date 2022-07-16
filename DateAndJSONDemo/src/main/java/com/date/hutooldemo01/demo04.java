package com.date.hutooldemo01;

import cn.hutool.core.date.*;

/**
 * to do
 *  Ëã¹¤×÷ÈÕ
 * @author Hj
 * @date 2022/1/13
 */
public class demo04 {
    public static void main(String[] args) {
        DateTime initdate = DateUtil.parse("2017-09-06 14:21:51.000");
        DateTime nowDate = DateUtil.date();
        nowDate=nowDate.offset(DateField.DAY_OF_YEAR, 60);
        long between = DateUtil.between(initdate,nowDate, DateUnit.DAY);

        for (int i = 0; i < between+2; i++) {
            DateTime curdate=DateUtil.offsetDay(nowDate, -i);
            String curdatestr=DateUtil.format(curdate, DatePattern.NORM_DATE_PATTERN);
            System.out.print("('"+curdatestr+"'),");
        }



    }


}
