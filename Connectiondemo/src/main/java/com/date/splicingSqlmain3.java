package com.date;

import cn.hutool.core.text.StrBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain3 {
    public static void main(String[] args) {
       String value = "select * from transfer_payment_record_status r where r.step_status =2 and \n" +
               "not exists (select 1 from transfer_payment_record_status b where r.settlement_no=b.settlement_no and b.step_status  in (3,4)) ";

        value = "select count(1)  from " +
                "transfer_payment_record tpr  \n" +
                "where created_dt between  ?1  and  ?2 and receipt_date is null ";
       System.out.println(value);


        StringBuffer sql = new StringBuffer();
        sql.append("SELECT e.campaignDetailId,e.dayTime,e.getNum,e.registerNum,e.getUserNum,IFNULL(f.useCouponNum,0) useCouponNum,IFNULL(f.deductPay,0) deductPay FROM ")
                .append("(").append(getActivityInfoStr("filterSql.toString()")).append(") e LEFT JOIN (").append(getUserCashInfoStr())
                .append(" ) f ON e.campaignDetailId = f.coupon_activity_id AND e.dayTime = f.dayTime ")
                .append(" ORDER BY e.dayTime ");


        System.out.println("sql1 = \n" + sql.toString());
        StringBuffer sql2 = new StringBuffer("SELECT a.`campaign_detail_id` campaignDetailId,DATE_FORMAT(a.created_dt,'%Y-%m-%d') dayTime,IFNULL(COUNT(1),0) getNum,SUM(IF(b.`regist_channel`=7,1,0)) registerNum,COUNT(DISTINCT(a.`mobile_app_user_id`)) getUserNum FROM `event_assign_prize_result` a,`mobile_app_user` b,`event_campaign_detail` c ")
                .append("WHERE a.prize_type = 1 AND b.`deleted` = 0 AND a.`mobile_app_user_id` = b.`id` AND a.campaign_detail_id = c.`id` AND c.`campaign_id` = :campaignId ").append("")
                .append(" GROUP BY DATE_FORMAT(a.created_dt,'%Y-%m-%d'),a.`campaign_detail_id` ");

        System.out.println("sql2 = \n" + sql2.toString());
        StringBuffer sql3 = new StringBuffer();
        sql3.append("SELECT a.`created_dt`,a.`phone`,IF(b.`regist_channel`= 7 ,1 ,0) isNew,COUNT(1) getNum,SUM(IF(a.`type`=1,1,0)) useNum,SUM(IF(a.`type`=1,a.deduct_pay,0)) deductCost FROM `mobile_app_user_cash` a,`mobile_app_user` b ")
                .append(" WHERE b.`deleted`= 0 AND a.`phone` = b.`phone` AND a.`coupon_activity_type` = 10 AND a.`coupon_activity_id` = :couponActivityId ").append("filterSql")
                .append("  GROUP BY a.`phone`,a.`created_dt`,b.`register_channel`  ");
        System.out.println("sql3 = \n" + sql3.toString());


    }
    private static String getUserCashInfoStr(){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT DATE_FORMAT(c.created_dt,'%Y-%m-%d') dayTime,c.coupon_activity_id,COUNT(DISTINCT(c.phone)) useCouponNum,IFNULL(SUM(c.deduct_pay),0) deductPay FROM`mobile_app_user_cash` c ")
                .append(" WHERE c.coupon_activity_type = 10 AND c.`type`= 1 GROUP BY c.coupon_activity_id,DATE_FORMAT(c.created_dt,'%Y-%m-%d') ");
        return sql.toString();
    }
    private static String getActivityInfoStr(String filterSql) {
        StringBuffer sql = new StringBuffer("SELECT a.`campaign_detail_id` campaignDetailId,DATE_FORMAT(a.created_dt,'%Y-%m-%d') dayTime,IFNULL(COUNT(1),0) getNum,SUM(IF(b.`regist_channel`=7,1,0)) registerNum,COUNT(DISTINCT(a.`mobile_app_user_id`)) getUserNum FROM `event_assign_prize_result` a,`mobile_app_user` b,`event_campaign_detail` c ")
                .append("WHERE a.prize_type = 1 AND b.`deleted` = 0 AND a.`mobile_app_user_id` = b.`id` AND a.campaign_detail_id = c.`id` AND c.`campaign_id` = :campaignId ").append(filterSql)
                .append(" GROUP BY DATE_FORMAT(a.created_dt,'%Y-%m-%d'),a.`campaign_detail_id` ");
        return sql.toString();

    }
}
