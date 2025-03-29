package com.date;

import cn.hutool.core.text.StrBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * to do
 * splitsql
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain2 {
    public static void main(String[] args) {
        String value = "select a.* from pay_route_info a \n" +
                "join pay_route_business b on a.id=b.pay_route_id \n" +
                "join pay_route_owner c on a.id =c.pay_route_id \n" +
                "where a.deleted =0 and a.pay_app_id =?1 \n" +
                "and b.deleted =0 and b.pay_business_id in ?2\n" +
                "and c.deleted =0 and c.park_owner_id =?3";

        String s = value.toString().replaceAll("]]>", "")
                .replaceAll("CDATA", "")
                .replaceAll("<!\\[\\[", "");
        System.out.println(s);


    }
}
