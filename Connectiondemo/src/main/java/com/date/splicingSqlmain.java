package com.date;

import cn.hutool.core.text.StrBuilder;

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
        StringBuilder sql = new StringBuilder("select no,type,category,out_category,phone,plate_no,park_id,park_name,park_item_id,park_item_name,plate_no_colour," +
                "start_date,end_date,status,park_type from order_park_order where plate_no=:plateNo  and status in (0,1,2,3,4) and deleted=0 and type = 2 ");
        Map<String,Object> params = new HashMap<>(3);

        sql.append(" order by start_date desc ");


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
