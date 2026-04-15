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



        String sql2221 = "select " +
                "    a.id as group_id, " +
                "    b.way_type, " +
                "    case b.way_type " +
                "        when 1 then c.cycle_day " +
                "        when 2 then c.cycle_day " +
                "        when 3 then d.cycle_day " +
                "        when 4 then e.cycle_day " +
                "        when 5 then f.cycle_day " +
                "        when 6 then c.cycle_day " +
                "        when 7 then f.cycle_day " +
                "        when 8 then f.cycle_day " +
                "        when 9 then f.cycle_day " +
                "        end as cycle_day ," +
                "    c.template_id, " +
                "    c.time_type, " +
                "    c.time_value, " +
                "    c.time_day, " +
                "    c.time_week, " +
                "    c.time_month  " +
                "from " +
                "    strategy_assistance_pay_group a " +
                "        left join strategy_assistance_pay_way b on a.id = b.group_id " +
                "        left join strategy_assistance_pay_way_config c on a.id = c.group_id and b.way_type = c.way_type " +
                "        left join strategy_assistance_pay_task_config d on a.id = d.group_id and b.way_type = 3 " +
                "        left join strategy_assistance_ms_park_config e on a.id = e.group_id and b.way_type = 4 " +
                "        left join strategy_assistance_data_push_config f on a.id = f.group_id and b.way_type = f.way_type " +
                "        left join strategy_assistance_timely_park g on a.id = g.group_id " +
                "where " +
                "      a.status = 3 " +
                "  and a.data_type = 2 " +
                "  and a.deleted = 0 " +
                "  and g.park_id = :parkId " +
                "order by " +
                "    a.id, b.sort";
        System.out.println(sql2221);


    }
}
