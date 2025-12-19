package com.date;

import java.util.HashMap;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain4 {
    public static void main(String[] args) {
        String sql = "  select pco.id AS  orderItemId,13 AS orderType,'ÔÂÆ±' AS parkName,pco.plate_no AS plateNo,0 AS howLong,NULL AS rentingTerm,\n" +
                "pco.created_dt AS createdDt,pco.amount AS moneyPay,0 AS type,pco.back_pay AS backPay,\n" +
                "NULL AS  refundStatus,NULL AS disputeBackPay,0  As rechargeElectricityDegrees \n" +
                "from park_card_order pco where pco.deleted =0 and pco.phone =:phone AND pco.created_dt > :createDate and pco.order_status=2 AND pco.invoice_id IS NULL";

        StringBuffer selectClause=new StringBuffer("select u.id," +
                "u.chinese_name as chineseName," +
                "u.username," +
                "u.phone," +
                "ru.role_id as roleId," +
                "tg.name groupName," +
                "ta.name areaName ");
        StringBuffer fromClause=new StringBuffer("from toll_user u left join pos_role_user ru on u.id=ru.user_id " +
                "left join toll_user_group_rel tur on u.id = tur.toll_user_id " +
                "left join toll_user_group tg on tur.group_id = tg.id " +
                "left join toll_user_group_area_rel tugr on tg.id = tugr.group_id " +
                "left join toll_user_area ta on tugr.area_id = ta.id ");
        System.out.println(selectClause.append(fromClause));


    }
}
