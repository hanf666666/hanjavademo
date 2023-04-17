package com.date;

import cn.hutool.core.text.StrBuilder;

import java.util.Random;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain {
    public static void main(String[] args) {

        String settlementBatchSql="SELECT  distinct(`park_id`) FROM  `order_business` WHERE `recon_date` = '' and (`is_settlement` = 1  and  `settlement_status` = 3) or (is_settlement =2  and vouch_settlement_status =1 and vouch_settlement_status = 3)  ";


        System.out.println(settlementBatchSql);
        System.out.println("2303021716341558062".length());


    }
}
