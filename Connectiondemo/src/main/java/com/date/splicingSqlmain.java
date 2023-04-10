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

        String sql = new StringBuffer().append("SELECT * from (SELECT park_owner_id parkOwnerId,MAX( CASE setting_key WHEN 'ALIPAY_FEE' THEN setting_value ELSE '' END ) alipay_fee,")
                .append(" MAX( CASE setting_key WHEN 'WECHAT_FEE' THEN setting_value ELSE '' END ) wechat_fee,MAX( CASE setting_key WHEN 'BALANCE_FEE' THEN setting_value ELSE '' END ) balance_fee ")
                .append(" FROM equipment_park_owner_setting where park_owner_id in (:parkOwnerList) GROUP BY park_owner_id HAVING alipay_fee != '' OR wechat_fee != '' OR balance_fee != '' ) oi ").toString();

        System.out.println(sql);
        System.out.println("2303021716341558062".length());


    }
}
