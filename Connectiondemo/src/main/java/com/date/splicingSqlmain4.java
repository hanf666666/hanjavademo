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


        sql = "select a.* from pay_route_info a \n" +
                "join pay_route_business b on a.id=b.pay_route_id \n" +
                "where a.deleted =0 and a.pay_app_id =?1 \n" +
                "and b.deleted =0 and b.pay_business_id in ?2";

        sql = "select a.* from pay_route_info a \n" +
                "join pay_route_business b on a.id=b.pay_route_id \n" +
                "join pay_route_owner c on a.id =c.pay_route_id \n" +
                "where a.deleted =0 and a.pay_app_id =?1 \n" +
                "and b.deleted =0 and b.pay_business_id in ?2\n" +
                "and c.deleted =0 and c.park_owner_id =?3";
        System.out.println(sql);


    }
}
