package com.numberutil;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/22
 */
public class demo01 {
    public static void main(String[] args) {
        BigDecimal mul = NumberUtil.mul("22.1111", "22.1111");
       System.out.println(mul.setScale(4, BigDecimal.ROUND_HALF_DOWN));

       System.out.println(new BigDecimal(2.11116).setScale(4, BigDecimal.ROUND_HALF_DOWN));
       System.out.println(new BigDecimal(2.11115).setScale(4, BigDecimal.ROUND_HALF_UP));




    }
}
