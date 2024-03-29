package com.numberutil.hutool;

import cn.hutool.core.convert.Convert;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/22
 */
public class demo03 {
    public static void main(String[] args) {

        List<Long> longs2 = new ArrayList<>();
        longs2.add(1L);
        longs2.add(2L);
        longs2.add(3L);

//        System.out.println(String.join(",", (CharSequence) longs2));
        List<String> stringList = new ArrayList<>();
        stringList.add("1L");
        stringList.add("2L");


        System.out.println(String.join(",",  stringList));
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
