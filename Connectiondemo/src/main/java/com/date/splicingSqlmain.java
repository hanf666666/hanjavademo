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
public class splicingSqlmain {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        builder.append(" FROM equipment_park ep LEFT JOIN equipment_park_owner epo ON ep.park_owner_id = epo.id LEFT JOIN equipment_park_owner_setting epd ON epo.id = epd.park_owner_id LEFT JOIN park_time pt ON ep.id = pt.park_id " +
                "left join (" +
                "select park_id,sum(clear_count) \n" +
                "as clear_count,sum(platform_verification_amount) as platform_verification_amount,sum(clear_amount) as clear_amount,settle_pay_id,settle_pay_acno \n" +
                " from clear_batch c where c.settlement_status=2 group by park_id,settle_pay_id,settle_pay_acno ) temp on temp.park_id=ep.id ");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, +1);

        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.MONTH, -11);
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
        //本月
        String thisMonth = dft.format(cal.getTime());
        //本月-12个月
        String minMonth = dft.format(cal1.getTime());
//
//        sql.append("WHERE recon_date< '"+thisMonth+"-01"+"' and recon_date>='"+minMonth+"-01"+"' AND settlement_status>=3 " +
//                "GROUP BY  DATE_FORMAT(recon_date,'%y-%m')");


        System.out.println(builder.toString());
//        String fasdfas = fasdfas();
//        System.out.println(fasdfas);


    }

    private static String  fasdfas() {
        try {
            System.out.println("2303021716341558062".length());
            Integer aa=null;
            aa.longValue();
            return "222222";
        } catch (Exception e) {
            e.printStackTrace();
            return "3333333";
        } finally {
            System.out.println("111111111111");
//            return "1111";

        }

    }
}
