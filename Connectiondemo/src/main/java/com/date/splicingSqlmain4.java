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


        String sql222 = "  select ipr.price,o.amount,o.pay_num as payNum, ipr.id as id,ipr.`name` as name,o.plate_no as plateNo ,o.plate_no_colour as plateNoColour,r.start_date as deliverStartDate ,r.end_date as deliverEndDate,ipr.gift_time as giftTime,\n" +
                " r.used_time  as usedTime,o.order_type as orderType,o.pay_time as payTime,o.order_status as orderStatus,SUBSTR(o.start_date,1,10) as priStartDate,SUBSTR(o.end_date,1,10) as  priEndDate\n" +
                " from idler_package_roadside_order o\n" +
                " left join idler_package_roadside_effective_record r on o.order_no =r.order_no and  r.start_date <now() and r.end_date>now() and r.effective_type =2 " +
                "left join idler_package_roadside ipr on o.package_id =ipr.id\n" +
                " where   o.order_no  = :orderNo";
        System.out.println(sql222);


    }
}
