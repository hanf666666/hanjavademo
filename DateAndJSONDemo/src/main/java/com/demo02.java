package com;

import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * to do
 *
 * @author Hj
 * @date 2024/3/13
 */
public class demo02 {
    public static void main(String[] args) {
        BigDecimal refund = new BigDecimal(3);
        BigDecimal profitRate = new BigDecimal(0.18+"");
        BigDecimal subtract = new BigDecimal(0).subtract(refund.multiply(profitRate).setScale(0, RoundingMode.HALF_UP));
        System.out.println(subtract);
    }
}
