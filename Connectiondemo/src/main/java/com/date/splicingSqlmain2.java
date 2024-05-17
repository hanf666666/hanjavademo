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

        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = false;
        // a*b 的结果是 int 类型，那么 c 会强制拆箱成 int 类型，抛出 NPE 异常
//        Integer result=(flag? a*b : c);
//        Integer result=(flag? new Integer(a*b) : c);
//        Integer result=a*b;


//        String aa= "{\"id\":9,\"list\":[{\"advancedConfig\":true,\"advancedConfigList\":[{\"billingTimeFee\":300,\"billingTimeUnit\":240,\"endTime\":240,\"startTime\":0,\"topFee\":300},{\"billingTimeFee\":100,\"billingTimeUnit\":60,\"endTime\":720,\"startTime\":240}],\"fee\":\"\",\"freeTime\":15,\"hasEx\":\"Y\",\"offTime\":30,\"special\":{\"newEnergy\":{\"ignoreFreeTime\":true,\"manyIgnoreFreeTime\":true,\"manyReductionFreeTime\":0,\"manyReductionRate\":50,\"reductionEndTime\":\"20:00:00\",\"reductionFreeTime\":120,\"reductionRate\":50,\"reductionStartTime\":\"08:00:00\"}},\"timeE\":\"20:00:00\",\"timeS\":\"08:00:00\",\"topPrice\":\"\",\"type\":\"time\"}],\"name\":\"遂宁资费分时段免费\",\"postageRuleChinese\":\"①单次停车不足15分钟免收停车费。\\n②超过15分钟，前4小时收费3元；超过4小时，每增加1小时加收1元，不足1小时按1小时计费。\\n③收费时段8:00——20:00，每日8:00开始重新计费。\\n④新能源车每日免首2小时停车优惠，超过2小时，停车费减半收取。\\n\",\"setting\":1,\"topFee\":\"\"}";
        String fieldsSql = " s.settlement_no,ep.name as parkOwnerName,e.`name` as parkNames,s.account_period,s.settlement_count,s.settlement_amount,s.settlement_status,s.start_time,s.end_time,(CASE WHEN epd.setting_value in (1,2,3) THEN '自动结算'  ELSE '手动结算' END ) clearType , epd2.setting_value as bankCode,t.created_dt as transeferSuccessDt,tr.receipt_date,tr.receipt_number,tr.receipt_serial_no ";
        String sql = "select a.amount,a.discount_category discountCategory,ifnull(b.saler_version,c.saler_version) salerVersion " +
                "from discount_record a " +
                "left join mobile_app_user_cash b on a.cash_id=b.id " +
                "left join mobile_vehicle_cash c on a.cash_id=c.id " +
                "where a.order_park_order_item_no in (:payNos) and a.deleted = 0";

        String s = sql.toString().replaceAll("]]>", "")
                .replaceAll("CDATA", "")
                .replaceAll("<!\\[\\[", "");
        System.out.println(s);


    }
}
