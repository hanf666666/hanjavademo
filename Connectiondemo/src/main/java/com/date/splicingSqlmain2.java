package com.date;

import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.StrUtil;

import java.util.*;

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


        String sql = "select * from \n" +
                "(\n" +
                "SELECT pcr.project_id AS projectId,pcr.id,pcr.park_card_meal_id parkCardMealId,pcm.expired_remind_days expiredRemindDays,pcm.`name` cardName,pcm.card_type cardType,pcm.period_type periodType,\n" +
                "pcr.plate_no plateNo,pcr.plate_no_color plateNoColor,pcr.validity_start_date validityStartDate,pcr.validity_end_date validityEndDate,\n" +
                "pco.amount as amount,pco.order_no orderNo,pco.pay_time as payTime,pcr.status\n" +
                " FROM user_purchase_card_record pcr \n" +
                " JOIN park_card_meal pcm ON pcr.park_card_meal_id = pcm.id AND pcr.deleted = 0 \n" +
                " JOIN park_card_order pco ON pcr.order_no = pco.order_no \n" +
                " WHERE pcr.deleted = 0 \n" +
                " AND pcr.phone = :phone\n" +
                "\n" +
                " union all\n" +
                "\t\n" +
                "SELECT pcr.project_id AS projectId,pcr.id,pcr.park_card_meal_id parkCardMealId,pcm.expired_remind_days expiredRemindDays,pcm.`name` cardName,pcm.card_type cardType,pcm.period_type periodType,\n" +
                "pcr.plate_no plateNo,pcr.plate_no_color plateNoColor,pcr.validity_start_date validityStartDate,pcr.validity_end_date validityEndDate,\n" +
                "pco.money as amount,pco.order_no orderNo,pco.pay_dt as payTime,pcr.status\n" +
                " FROM user_purchase_card_record pcr \n" +
                " JOIN park_card_meal pcm ON pcr.park_card_meal_id = pcm.id AND pcr.deleted = 0 \n" +
                " JOIN score_store_order pco ON pcr.order_no = pco.order_no \n" +
                " WHERE pcr.deleted = 0 \n" +
                " AND pcr.phone = :phone\n" +
                " ) t\n" +
                "ORDER BY t.status ASC,t.validityEndDate ASC";

        Map<String, Object> paramMap = new HashMap<>();

//        if (Objects.nonNull(dto.getCityId())){
//            sql.append("AND ep.city_id = :cityId ");
//            paramMap.put("cityId",dto.getCityId());
//        }
//        if (StrUtil.isNotBlank(dto.getName())){
//            sql.append("AND (pcm.`name` LIKE :name OR ep.`name` LIKE :name) ");
//            paramMap.put("name","%"+dto.getName()+"%");
//        }

        String s = sql.toString().replaceAll("]]>", "")
                .replaceAll("CDATA", "")
                .replaceAll("<!\\[\\[", "");
        System.out.println(s);


    }
}
