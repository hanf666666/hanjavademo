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
        String value = "select   order_item_no as orderItemNo, pay_app_id as payappId, app_id as payappAppId, pay_business_id as payBusinessId, pay_account_id as payAccountId, account_code as accountCode, server_account_code as serverAccountCode, pay_route_id as payRouteId,\n" +
                "temp.settlement_flag as settlementFlag,temp.settlement_channel_id as settlementChannelId,temp.pay_acno as settlementChannelNo,rp2.attr_val as attrVal,\n" +
                "rp2.settlement_flag as couponSettlementFlag\n" +
                "from (\n" +
                "\tselect r.*,rp.settlement_flag,rp.settlement_channel_id,st.pay_acno\n" +
                "\tfrom pay_param_order_record r\n" +
                "\tleft join  pay_param_order_record_attr rp\n" +
                "\ton r.id=rp.pay_record_id and (rp.attr_type=1 or rp.attr_type is null) \n" +
                "\tleft join settle_accounts_config st on rp.settlement_channel_id=st.id\n" +
                "\n" +
                "\twhere `order_item_no`=:orderItemNo and  r.deleted=0 \n" +
                ") as temp left join pay_param_order_record_attr rp2 on  temp.id=rp2.pay_record_id and rp2.attr_type=2 limit 1";

        String s = value.toString().replaceAll("]]>", "")
                .replaceAll("CDATA", "")
                .replaceAll("<!\\[\\[", "");
        System.out.println(s);


    }
}
