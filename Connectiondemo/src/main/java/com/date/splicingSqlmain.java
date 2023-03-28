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

        String fieldSql = " select rlco.id,rlco.trade_no,rlco.no,rlco.user_name,rlco.phone,rlc.status,rlco.rule_name,rlco.combo_name,rlco.pay_type,rlco.pay_channel,rlco.payable,rlco.discount,rlco.money_pay,rlco.charge_name,rlco.start_time,rlco.end_time,rlco.pay_time,rlco.action,rlco.truck_space,rlco.plate_nos,rlco.park_names,rlco.long_car_id ";
        StrBuilder bodySql = new StrBuilder(" from roadside_longrent_car_order rlco left join roadside_longrent_car rlc on rlco.long_car_id = rlc.id  ");
        StrBuilder whereSql = new StrBuilder(" where  rlco.deleted = 0 and rlco.status = 2 ");
        System.out.println(fieldSql+bodySql+whereSql);
        System.out.println("2303021716341558062".length());


    }
}
