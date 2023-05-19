package com.date;

import cn.hutool.core.text.StrBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain {
    public static void main(String[] args) {

//        StringBuilder sql = new StringBuilder();
        String sql = "SELECT t.lessThanThirtyMin * 100 / t.countCar AS lessThanThirtyMinPer, \n" +
                "t.thirtyToSixtyMin * 100 / t.countCar AS thirtyToSixtyMinPer, t.oneToTwoHours * 100 / t.countCar \n" +
                "AS oneToTwoHoursPer, t.twoToFourHours * 100 / t.countCar AS twoToFourHoursPer, \n" +
                "t.moreThanFourHours * 100 / t.countCar AS moreThanFourHoursPer FROM ( SELECT SUM(ap.park_carnum) \n" +
                "AS countCar, SUM( CASE WHEN ap.min_time IN (0, 600) THEN ap.park_carnum ELSE 0 END ) AS \n" +
                "lessThanThirtyMin, SUM( CASE WHEN ap.min_time IN (1800) THEN ap.park_carnum ELSE 0 END ) AS \n" +
                "thirtyToSixtyMin, SUM( CASE WHEN ap.min_time IN (3600) THEN ap.park_carnum ELSE 0 END ) AS \n" +
                "oneToTwoHours, SUM( CASE WHEN ap.min_time IN (7200) THEN ap.park_carnum ELSE 0 END ) AS \n" +
                "twoToFourHours, SUM( CASE WHEN ap.min_time IN ( 14400, 21600, 28800, 36000, 43200 ) THEN \n" +
                "ap.park_carnum ELSE 0 END ) AS moreThanFourHours FROM analysis_parktimerate ap \n ) AS t;";


        System.out.println(sql);
        System.out.println("2303021716341558062".length());


    }
}
