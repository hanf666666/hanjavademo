package com.numberutil.hutool;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * to do
 *
 * @author Hj
 * @date 2022/9/30
 */
public class demo05 {
    public static void main(String[] args) {
        System.out.println(new BigDecimal("46.93").divide(new BigDecimal("199368"), 8, RoundingMode.HALF_UP));
        System.out.println(new BigDecimal("49.26").divide(new BigDecimal("209244"), 8, RoundingMode.HALF_UP));
        System.out.println(new BigDecimal("6.46").divide(new BigDecimal("25831"), 8, RoundingMode.HALF_UP));


    }
}
