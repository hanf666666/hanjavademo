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
        // a*b �Ľ���� int ���ͣ���ô c ��ǿ�Ʋ���� int ���ͣ��׳� NPE �쳣
//        Integer result=(flag? a*b : c);
//        Integer result=(flag? new Integer(a*b) : c);
//        Integer result=a*b;


//        String aa= "{\"id\":9,\"list\":[{\"advancedConfig\":true,\"advancedConfigList\":[{\"billingTimeFee\":300,\"billingTimeUnit\":240,\"endTime\":240,\"startTime\":0,\"topFee\":300},{\"billingTimeFee\":100,\"billingTimeUnit\":60,\"endTime\":720,\"startTime\":240}],\"fee\":\"\",\"freeTime\":15,\"hasEx\":\"Y\",\"offTime\":30,\"special\":{\"newEnergy\":{\"ignoreFreeTime\":true,\"manyIgnoreFreeTime\":true,\"manyReductionFreeTime\":0,\"manyReductionRate\":50,\"reductionEndTime\":\"20:00:00\",\"reductionFreeTime\":120,\"reductionRate\":50,\"reductionStartTime\":\"08:00:00\"}},\"timeE\":\"20:00:00\",\"timeS\":\"08:00:00\",\"topPrice\":\"\",\"type\":\"time\"}],\"name\":\"�����ʷѷ�ʱ�����\",\"postageRuleChinese\":\"�ٵ���ͣ������15��������ͣ���ѡ�\\n�ڳ���15���ӣ�ǰ4Сʱ�շ�3Ԫ������4Сʱ��ÿ����1Сʱ����1Ԫ������1Сʱ��1Сʱ�Ʒѡ�\\n���շ�ʱ��8:00����20:00��ÿ��8:00��ʼ���¼Ʒѡ�\\n������Դ��ÿ������2Сʱͣ���Żݣ�����2Сʱ��ͣ���Ѽ�����ȡ��\\n\",\"setting\":1,\"topFee\":\"\"}";
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
