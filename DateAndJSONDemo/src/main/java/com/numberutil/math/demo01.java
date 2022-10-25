package com.numberutil.math;

import java.math.BigDecimal;

/**
 * to do
 *
 * @author Hj
 * @date 2022/10/18
 */

public class demo01 {
    public static void main(String[] args) {
        int a1 = 1;
        int b1 = 1;
        int c1 = 1;
        BigDecimal add = new BigDecimal(a1).add(new BigDecimal(b1));
        System.out.println(add);

        String s = new BigDecimal(a1).
                add(new BigDecimal(b1)).
                multiply(new BigDecimal(100)).
                divide(new BigDecimal(c1), 2, BigDecimal.ROUND_HALF_UP).toString() + "%";
        System.out.println(s);


    }
}
