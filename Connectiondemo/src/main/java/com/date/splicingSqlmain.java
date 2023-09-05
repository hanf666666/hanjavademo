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

//        StringBuilder sql = new StringBuilder();
        StringBuffer sql = new StringBuffer("SELECT DATE_FORMAT(recon_date,'%y-%m') reconDate," +
                "SUM(CASE WHEN plat_order_status=1 THEN payment_amount ELSE 0 END) AS payMoney," +
                "SUM(CASE WHEN payment_status=2 THEN ready_refund + dispute_refund ELSE 0 END) AS refundMoney" +
                " FROM order_plat force index(IDX_RECON_DATE_settlement_status) ");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, +1);

        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.MONTH, -11);
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
        //本月
        String thisMonth = dft.format(cal.getTime());
        //本月-12个月
        String minMonth = dft.format(cal1.getTime());

        sql.append("WHERE recon_date< '"+thisMonth+"-01"+"' and recon_date>='"+minMonth+"-01"+"' AND settlement_status>=3 " +
                "GROUP BY  DATE_FORMAT(recon_date,'%y-%m')");


        System.out.println(sql.toString());
        String fasdfas = fasdfas();
        System.out.println(fasdfas);


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
