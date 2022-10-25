package com.numberutil.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/22
 */
public class demo02 {
    public static void main(String[] args) {
        System.out.println(Convert.toLong(null,100L));
        System.out.println(String.format("%.2f",(double)100));
        System.out.println(getUtilizationRage(200L,1*3600L,null));

        DecimalFormat df = new DecimalFormat("000000");



        System.out.println(df.format(1987560));

        for (int i = 0; i <100 ; i++) {
            System.out.println(i);
            break;

        }
        ArrayList<Long> longs1 = new ArrayList<>();
        longs1.add(1L);
        longs1.add(2L);


        ArrayList<Long> longs2 = new ArrayList<>();
        longs2.add(1L);
        longs2.add(2L);
        longs2.add(3L);


        System.out.println(longs2.containsAll(longs1));
        System.out.println(longs1.containsAll(longs2));
    }


    /**
     * 获取泊位利用率
     * 公式: 今日停车总时长（s)/（平台所有泊位数量*24*3600）*100%
     *
     * @param totalParkLot 泊位数量
     * @param timeLong     停车时长
     * @return
     */
    private static String getUtilizationRage(Long totalParkLot, Long timeLong, String busyRate) {
        if (0L != totalParkLot) {

            return String.format("%.21f", ((double) timeLong / (24 * 3600)) * 100) + "%";
        } else {
            return "0.00%";
        }
    }
}
