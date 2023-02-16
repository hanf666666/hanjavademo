package com.date;

/**
 * to do
 *
 * @author Hj
 * @date 2023/2/11
 */
public class sss {
    public static void main(String[] args) {
        String sql="select a.order_park_order_no as no,a.no as refund_no,"
                + " a.order_park_order_item_no as trade_no,"
                + " b.channel_order as balance_num,"
                + " a.channel_order as refund_channel_order,"
                + " b.phone as pay_phone,a.submit_time as refund_date,"
                + " a.`type` as `type`,a.pay_channel as refund_channel,"
                + " a.refund_amount as refund_money,c.remark as remarks,"
                + " c.applicant_name as user_name "
                + " from order_park_order_refund a "
                + " inner join order_park_order_item b on a.order_park_order_item_no = b.no "
                + " left join finance_boss_approval_record c on a.no = c.order_park_order_refund_no"
                + " where a.order_park_order_no = :orderNo  order by a.id desc limit 1";


        System.out.println(sql);
    }
}
