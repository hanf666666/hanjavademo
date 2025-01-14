package com.date.hutooldemo01;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;

/**
 * to do
 *
 * @author Hj
 * @date 2023/11/3
 */
public class Demo12 {
    public static void main(String[] args) {

        BigDecimal divide = new BigDecimal(11).divide(new BigDecimal(22+""));

        DateTime startTime = DateUtil.parse("2023-08-03 00:00:00");
//        DateTime endTime = DateUtil.parse("2024-03-27 00:00:00");
//        long between = DateUtil.between(startTime, endTime, DateUnit.DAY);
//        long wokerDay=0L;
//        for (long i = 0; i < between; i++) {
//            DateTime offset = startTime.offset(DateField.DAY_OF_YEAR, 1);
//            if(!DateUtil.isWeekend(offset)){
//                ++wokerDay;
//            }
//            if(wokerDay==80+4){
//                System.out.println(offset);
//            }
//        }


        String yyyyMM = startTime.toString("yyyyMM");
        String yyyy =startTime.toString("yyyy");
        System.out.println((yyyy+"07").compareTo(yyyyMM));
        yyyyMM=(yyyyMM).compareTo(yyyy+"07")>=0?yyyy+"07":yyyy+"01";
        System.out.println(yyyyMM);


        System.out.println(DateUtil.date(0));

        System.out.println(443446145/(24*60*60*1000));
        System.out.println(DateUtil.date(443446145));

        int code = 111; // 示例代码
        String formattedCode = String.format("%03d", code); // 格式化为6位数字，不足则补0
        System.out.println("格式化后的代码: " + formattedCode);



        }
}
