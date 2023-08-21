package com.date;

import cn.hutool.core.text.StrBuilder;

import java.util.Objects;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain2 {
    public static void main(String[] args) {

//        String aa= "{\"id\":9,\"list\":[{\"advancedConfig\":true,\"advancedConfigList\":[{\"billingTimeFee\":300,\"billingTimeUnit\":240,\"endTime\":240,\"startTime\":0,\"topFee\":300},{\"billingTimeFee\":100,\"billingTimeUnit\":60,\"endTime\":720,\"startTime\":240}],\"fee\":\"\",\"freeTime\":15,\"hasEx\":\"Y\",\"offTime\":30,\"special\":{\"newEnergy\":{\"ignoreFreeTime\":true,\"manyIgnoreFreeTime\":true,\"manyReductionFreeTime\":0,\"manyReductionRate\":50,\"reductionEndTime\":\"20:00:00\",\"reductionFreeTime\":120,\"reductionRate\":50,\"reductionStartTime\":\"08:00:00\"}},\"timeE\":\"20:00:00\",\"timeS\":\"08:00:00\",\"topPrice\":\"\",\"type\":\"time\"}],\"name\":\"遂宁资费分时段免费\",\"postageRuleChinese\":\"①单次停车不足15分钟免收停车费。\\n②超过15分钟，前4小时收费3元；超过4小时，每增加1小时加收1元，不足1小时按1小时计费。\\n③收费时段8:00——20:00，每日8:00开始重新计费。\\n④新能源车每日免首2小时停车优惠，超过2小时，停车费减半收取。\\n\",\"setting\":1,\"topFee\":\"\"}";
        String aa= "{\"endTime\":\"2022-08-25 07:32:08\",\"id\":86,\"list\":[{\"advancedConfig\":true,\"advancedConfigList\":[{\"billingTimeFee\":200,\"billingTimeUnit\":30,\"endTime\":60,\"startTime\":0,\"topFee\":400},{\"billingTimeFee\":250,\"billingTimeUnit\":30,\"endTime\":660,\"startTime\":60,\"topFee\":6000}],\"fee\":\"\",\"freeTime\":15,\"hasEx\":\"Y\",\"offTime\":15,\"timeE\":\"18:30:00\",\"timeS\":\"07:30:00\",\"topPrice\":\"\",\"type\":\"time\"},{\"advancedConfig\":true,\"advancedConfigList\":[{\"billingTimeFee\":100,\"billingTimeUnit\":30,\"endTime\":60,\"startTime\":0,\"topFee\":200},{\"billingTimeFee\":150,\"billingTimeUnit\":30,\"endTime\":120,\"startTime\":60,\"topFee\":300}],\"fee\":\"\",\"freeTime\":15,\"hasEx\":\"Y\",\"offTime\":15,\"timeE\":\"20:30:00\",\"timeS\":\"18:30:00\",\"topPrice\":\"\",\"type\":\"time\"},{\"advancedConfig\":true,\"advancedConfigList\":[{\"billingTimeFee\":100,\"billingTimeUnit\":30,\"endTime\":660,\"startTime\":0,\"topFee\":500}],\"fee\":\"\",\"freeTime\":15,\"hasEx\":\"Y\",\"offTime\":15,\"timeE\":\"07:30:00\",\"timeS\":\"20:30:00\",\"topPrice\":\"\",\"type\":\"time\"}],\"name\":\"景阳路测试资费\",\"newEnergy\":false,\"postageRuleChinese\":\"07:30-18:30，首小时2元/半小时，次小时起2.5元/半小时\\n18:30-20:30，首小时1元/半小时，次小时起1.5元/半小时\\n20:30-07:30，1元/半小时，最高不超过5元/次\",\"setting\":1,\"startTime\":\"2022-08-24 19:56:42\",\"topFee\":\"\"}";;

        String value = "select * from transfer_payment_record_status r where r.step_status =2 and \n" +
                "not exists (select 1 from transfer_payment_record_status b where r.settlement_no=b.settlement_no and r.step_status  in (3,4)) ";
                System.out.println(value);



    }
}
