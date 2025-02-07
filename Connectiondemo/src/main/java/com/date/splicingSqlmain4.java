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
        String sql = new StringBuffer().append("SELECT * from (SELECT park_owner_id parkOwnerId,MAX( CASE setting_key WHEN 'ALIPAY_FEE' THEN setting_value ELSE '' END ) alipay_fee,")
                .append(" MAX( CASE setting_key WHEN 'WECHAT_FEE' THEN setting_value ELSE '' END ) wechat_fee,MAX( CASE setting_key WHEN 'BALANCE_FEE' THEN setting_value ELSE '' END ) balance_fee ," +
                        "MAX(  CASE setting_key WHEN 'parking_percent' THEN setting_value ELSE '' END) as parking_percent")
                .append(" FROM equipment_park_owner_setting where park_owner_id in (:parkOwnerList) GROUP BY park_owner_id HAVING alipay_fee != '' OR wechat_fee != '' OR balance_fee != '' ) oi ").toString();

        System.out.println(sql);


    }
}
