package com.date;

import cn.hutool.core.text.StrBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain2 {
    public static void main(String[] args) {
        String membersql = "SELECT a.created_dt AS createdDt,\n" +
                "        a.member_phone AS phone,\n" +
                "        a.order_no AS parkRecordNum,\n" +
                "        a.order_no AS no,\n" +
                "        a.pay_no AS channelOrder,\n" +
                "        a.pay_money AS moneyPay,\n" +
                "        a.pay_time AS payTime \n" +
                " from member_right_order a\n" +
                "left join park_order_member_rel rel on a.order_no=rel.member_order_no \n" +
                "where 1=1 and  rel.deleted =0 " +
                " and a.pay_no= :channelOrder ";

        String s = membersql.toString().replaceAll("]]>", "")
                .replaceAll("CDATA", "")
                .replaceAll("<!\\[\\[", "");
        System.out.println(s);


    }
}
