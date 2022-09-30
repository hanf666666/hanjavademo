package com.numberutil;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * to do
 *
 * @author Hj
 * @date 2022/9/30
 */
public class demo04 {
    public static void main(String[] args) {
        //禁用 new BigDecimal(double)
        BigDecimal bd1 = new BigDecimal(0.01);
        BigDecimal bd2 = BigDecimal.valueOf(0.01);
        //bd1 = 0.01000000000000000020816681711721685132943093776702880859375
        //bd2 = 0.01
        System.out.println("bd1 = " + bd1);
        System.out.println("bd2 = " + bd2);


        BigDecimal bd3 = new BigDecimal("1.0");
        BigDecimal bd4 = new BigDecimal("1.00");
        //bd1.equals(bd2) 禁用
        System.out.println(bd3.equals(bd4));
        System.out.println(bd3.compareTo(bd4));



        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("3.0");
        //ROUND_HALF_UP
        BigDecimal mul = NumberUtil.div(a,b);
        System.out.println(mul);

        //Exception in thread "main" java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
//        a.divide(b);




        //4BigDecimal 转回 String 要小心
        BigDecimal d = BigDecimal.valueOf(12334535345456700.12345634534534578901);
        String out = d.toString(); // Or perform any formatting that needs to be done
        System.out.println(out); // 1.23345353454567E+16
        System.out.println(d.toPlainString()); //12334535345456700
        System.out.println(d.toEngineeringString()); //12334535345456700


        //5执行顺序不能调换（乘法交换律失效）
        BigDecimal a5 = BigDecimal.valueOf(1.0);
        BigDecimal b5 = BigDecimal.valueOf(3.0);
        BigDecimal c5 = BigDecimal.valueOf(3.0);
        System.out.println(a5.divide(b5, 2, RoundingMode.HALF_UP));
        System.out.println(a5.divide(b5, 2, RoundingMode.HALF_UP).multiply(c5)); // 0.990

        System.out.println(a5.multiply(c5).divide(b, 2, RoundingMode.HALF_UP)); // 1.00


    }
}
