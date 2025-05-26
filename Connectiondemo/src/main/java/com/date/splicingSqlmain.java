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
          String bodySql = " from (\n" +
                "select '1' as orderType,oi.order_no as orderNo,oi.pay_time as  payDt,oi.phone as  phoneTailNo, sta.name as stationName , oi.gun_no as gunNo,\n" +
                "oi.oil_no  as oilNo,oi.show_money/100 as showAmount,oi.oil_money/100 as writeOffAmount,acc.real_name as writeOffPerson\n" +
                ",'' as merchantName,'' as   productName,'' as  originalMoney, '' as money,'' as  settleMoney,'' as detail \n" +
                "\n" +
                "from member_right_oil_order oi \n" +
                "left join member_right_partner_station sta on oi.station_id =sta.id\n" +
                "left join member_right_store_account acc on oi.write_off_person =acc.id\n" +
                "where \n" +
                "oi.station_id in (:stationId) and oi.deleted=0 and pay_time>=:startDate and pay_time<=:endDate \n" +
                "and order_status=:orderStatus and write_off_status=:writeOffStatus\n" +
                "union  all\n" +
                "select  '2' as orderType,'' as orderNo,code.pay_dt as payDt,code.phone as  phoneTailNo, '' as stationName , '' as gunNo,''  as oilNo,'' as showAmount,'' fAmount,acc.real_name  as writeOffPerson,\n" +
                " m.name as merchantName ,p.name as   productName,code.original_money/100 as  originalMoney, code.money/100 as money,code.settle_money/100 as  settleMoney,p.detail as detail   \n" +
                "from score_store_life_code code  \n" +
                "left join score_store_merchant m on m.id=code.merchant_id    " +
                "left join score_store_product p on code.product_id=p.id  " +
                "left join member_right_store_account acc on code.check_by =acc.id " +
                "where code.check_status=:writeOffStatus and  code.product_id=:merchantId and code.status=2   \n" +
                " and code.pay_dt >=:startDate and pay_dt<=:endDate\n" +
                ") temp " +
                "";
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


        System.out.println(bodySql.toString());
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
