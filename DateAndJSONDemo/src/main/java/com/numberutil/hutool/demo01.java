package com.numberutil.hutool;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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

       //´íÎó·½Ê½  new BigDecimal(double)
       System.out.println(new BigDecimal(2.11116).setScale(4, BigDecimal.ROUND_HALF_DOWN));
       System.out.println(new BigDecimal(2.11115).setScale(4, BigDecimal.ROUND_HALF_UP));

        String format = new DecimalFormat("0000").format(123456789);
        System.out.println("format======>"+format);


    }
}
