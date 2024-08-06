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
        String sql =
                "SELECT " +
                        "a.created_dt AS createdDt," +
                        "a.phone AS phone," +
                        "a.plate_no AS plateNo," +
                        "a.park_id AS parkId," +
                        "a.park_record_num AS parkRecordNum," +
                        "a.no AS no," +
                        "a.channel_order AS channelOrder," +
                        "a.refund_order AS refundOrder," +
                        "a.refund_no AS refundNo," +
                        "a.coupon_pay AS couponPay," +
                        "a.money_pay AS moneyPay," +
                        "a.back_pay AS backPay," +
                        "a.dispute_back_pay AS disputeBackPay," +
                        "a.channel AS channel," +
                        "a.wx_type AS wxType," +
                        "a.order_service_type AS orderServiceType," +
                        "a.order_status AS orderStatus," +
                        "a.transaction_type AS transactionType," +
                        "a.order_category AS orderCategory," +
                        "a.refund AS refund," +
                        "a.order_type AS orderType," +
                        "a.pay_time AS payTime," +
                        "a.provider_service AS providerService," +
                        "b.park_owner_id as parkOwnerId " +
                        "FROM water_bills_record a " +
                        "left join equipment_park b " +
                        "on a.park_id = b.id " +
                        "WHERE channel in (1,2,3) " +
                        "AND a.pay_time >= :startDate AND a.pay_time < :endDate ";

        String s = sql.toString().replaceAll("]]>", "")
                .replaceAll("CDATA", "")
                .replaceAll("<!\\[\\[", "");
        System.out.println(s);


    }
}
