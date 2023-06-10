package com.date;

import cn.hutool.core.text.StrBuilder;

import java.util.Objects;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain2 {
    public static void main(String[] args) {

        StringBuffer mainSql = new StringBuffer(
                " FROM " + " settlement_batch s LEFT JOIN equipment_park e ON s.park_id = e.id " +
                        " LEFT JOIN finance_approval_record r ON s.settlement_no = r.batch_num " +
                        " LEFT JOIN equipment_park_owner ep ON s.park_owner_id=ep.id  " +
                        " LEFT JOIN equipment_park_owner_setting epd ON ep.id = epd.park_owner_id  "
                        + " WHERE "
                        + " 1=1 and s.`settlement_status` = 1 and setting_key = 'pay_date_type' and r.`current_step_user_id` =");



        System.out.println(mainSql.toString());



    }
}
