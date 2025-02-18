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
        String fieldsSql = " cd.order_num,cd.trade_no,cd.recon_date,cd.park_id,cd.receivable_amount,cd.voucher_amount,cd.sell_voucher_amount,cd.receipts_amunt,cd.refund_amount,cd.earning_ratio/100 as earning_ratio,cd.clear_amount,cd.clear_count,e.name,cd.hand_fee,cd.agent_service_charge,cd.separate_money ";
        StringBuffer mainSql = new StringBuffer(
                " FROM  clear_batch_detail cd LEFT JOIN clear_batch c ON c.batch_no=cd.batch_no LEFT JOIN equipment_park e on cd.park_id=e.id  "+ " WHERE "
                        + "1=1  AND c.settlement_status = 2");
        System.out.println("mainSql = \n" + mainSql.toString());


    }
}
