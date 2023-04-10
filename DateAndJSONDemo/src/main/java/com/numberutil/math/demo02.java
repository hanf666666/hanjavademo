package com.numberutil.math;

import java.math.BigDecimal;

/**
 * to do
 *
 * @author Hj
 * @date 2023/4/10
 */
public class demo02 {
    public static void main(String[] args) {
        //错误方式  new BigDecimal(double)
        System.out.println(new BigDecimal(2.11115).setScale(4, BigDecimal.ROUND_HALF_UP));
        // 四舍五入法
        BigDecimal a = new BigDecimal("2.11115").setScale(4, BigDecimal.ROUND_HALF_UP); // 0.10
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.094").setScale(2, BigDecimal.ROUND_HALF_UP); // 0.09
        System.out.println(b);

        BigDecimal c = new BigDecimal("-0.095").setScale(2, BigDecimal.ROUND_HALF_UP); // -0.10
        BigDecimal d = new BigDecimal("-0.094").setScale(2, BigDecimal.ROUND_HALF_UP); // -0.09
        BigDecimal e = new BigDecimal("-0.090").setScale(2, BigDecimal.ROUND_HALF_UP); // -0.09
        BigDecimal f = new BigDecimal("-0.098").setScale(2, BigDecimal.ROUND_HALF_UP); // -0.10


    }
}
