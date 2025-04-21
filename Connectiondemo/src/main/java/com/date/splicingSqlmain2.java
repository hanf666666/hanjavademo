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
        String value = "select p.account_code " +
                "as accountCode,a.app_id as appId,p.api_key as apiKey    \n" +
                "from meisoodev.pay_route_info r,meisoodev.pay_account_info p ,meisoodev.pay_app_info a\n" +
                "where r.pay_account_id =p.id and r.pay_app_id =a.id and p.account_code  in ('1705358801','1616069988')\n" +
                "group by p.server_account_code,p.account_code,p.api_key   ";

        String s = value.toString().replaceAll("]]>", "")
                .replaceAll("CDATA", "")
                .replaceAll("<!\\[\\[", "");
        System.out.println(s);


    }
}
