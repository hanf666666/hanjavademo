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
        String sql =
                "SELECT "+
                        "a.created_dt AS createdDt,"+
                        "a.phone AS phone,"+
                        "a.plate_no AS plateNo,"+
                        "a.park_id AS parkId,"+
                        "a.park_record_num AS parkRecordNum,"+
                        "a.no AS no,"+
                        "a.channel_order AS channelOrder,"+
                        "a.refund_order AS refundOrder,"+
                        "a.refund_no AS refundNo,"+
                        "a.coupon_pay AS couponPay,"+
                        "a.money_pay AS moneyPay,"+
                        "a.back_pay AS backPay,"+
                        "a.dispute_back_pay AS disputeBackPay,"+
                        "a.channel AS channel,"+
                        "a.wx_type AS wxType,"+
                        "a.order_service_type AS orderServiceType,"+
                        "a.order_status AS orderStatus,"+
                        "a.transaction_type AS transactionType,"+
                        "a.order_category AS orderCategory,"+
                        "a.refund AS refund,"+
                        "a.order_type AS orderType,"+
                        "a.pay_time AS payTime,"+
                        "a.provider_service AS providerService,"+
                        "b.park_owner_id as parkOwnerId "+
                        "FROM water_bills_record a "+
                        "left join equipment_park b "+
                        "on a.park_id = b.id "+
                        "WHERE channel in (1,2,3) "+
                        "AND a.pay_time >= :startDate AND a.pay_time < :endDate ";

        System.out.println(sql);
        System.out.println("2303021716341558062".length());


    }
}
