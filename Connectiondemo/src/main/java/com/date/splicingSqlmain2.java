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

//        String aa= "{\"id\":9,\"list\":[{\"advancedConfig\":true,\"advancedConfigList\":[{\"billingTimeFee\":300,\"billingTimeUnit\":240,\"endTime\":240,\"startTime\":0,\"topFee\":300},{\"billingTimeFee\":100,\"billingTimeUnit\":60,\"endTime\":720,\"startTime\":240}],\"fee\":\"\",\"freeTime\":15,\"hasEx\":\"Y\",\"offTime\":30,\"special\":{\"newEnergy\":{\"ignoreFreeTime\":true,\"manyIgnoreFreeTime\":true,\"manyReductionFreeTime\":0,\"manyReductionRate\":50,\"reductionEndTime\":\"20:00:00\",\"reductionFreeTime\":120,\"reductionRate\":50,\"reductionStartTime\":\"08:00:00\"}},\"timeE\":\"20:00:00\",\"timeS\":\"08:00:00\",\"topPrice\":\"\",\"type\":\"time\"}],\"name\":\"�����ʷѷ�ʱ�����\",\"postageRuleChinese\":\"�ٵ���ͣ������15��������ͣ���ѡ�\\n�ڳ���15���ӣ�ǰ4Сʱ�շ�3Ԫ������4Сʱ��ÿ����1Сʱ����1Ԫ������1Сʱ��1Сʱ�Ʒѡ�\\n���շ�ʱ��8:00����20:00��ÿ��8:00��ʼ���¼Ʒѡ�\\n������Դ��ÿ������2Сʱͣ���Żݣ�����2Сʱ��ͣ���Ѽ�����ȡ��\\n\",\"setting\":1,\"topFee\":\"\"}";
        String aa= "{\"endTime\":\"2022-08-25 07:32:08\",\"id\":86,\"list\":[{\"advancedConfig\":true,\"advancedConfigList\":[{\"billingTimeFee\":200,\"billingTimeUnit\":30,\"endTime\":60,\"startTime\":0,\"topFee\":400},{\"billingTimeFee\":250,\"billingTimeUnit\":30,\"endTime\":660,\"startTime\":60,\"topFee\":6000}],\"fee\":\"\",\"freeTime\":15,\"hasEx\":\"Y\",\"offTime\":15,\"timeE\":\"18:30:00\",\"timeS\":\"07:30:00\",\"topPrice\":\"\",\"type\":\"time\"},{\"advancedConfig\":true,\"advancedConfigList\":[{\"billingTimeFee\":100,\"billingTimeUnit\":30,\"endTime\":60,\"startTime\":0,\"topFee\":200},{\"billingTimeFee\":150,\"billingTimeUnit\":30,\"endTime\":120,\"startTime\":60,\"topFee\":300}],\"fee\":\"\",\"freeTime\":15,\"hasEx\":\"Y\",\"offTime\":15,\"timeE\":\"20:30:00\",\"timeS\":\"18:30:00\",\"topPrice\":\"\",\"type\":\"time\"},{\"advancedConfig\":true,\"advancedConfigList\":[{\"billingTimeFee\":100,\"billingTimeUnit\":30,\"endTime\":660,\"startTime\":0,\"topFee\":500}],\"fee\":\"\",\"freeTime\":15,\"hasEx\":\"Y\",\"offTime\":15,\"timeE\":\"07:30:00\",\"timeS\":\"20:30:00\",\"topPrice\":\"\",\"type\":\"time\"}],\"name\":\"����·�����ʷ�\",\"newEnergy\":false,\"postageRuleChinese\":\"07:30-18:30����Сʱ2Ԫ/��Сʱ����Сʱ��2.5Ԫ/��Сʱ\\n18:30-20:30����Сʱ1Ԫ/��Сʱ����Сʱ��1.5Ԫ/��Сʱ\\n20:30-07:30��1Ԫ/��Сʱ����߲�����5Ԫ/��\",\"setting\":1,\"startTime\":\"2022-08-24 19:56:42\",\"topFee\":\"\"}";;

        String value = "select * from transfer_payment_record_status r where r.step_status =2 and \n" +
                "not exists (select 1 from transfer_payment_record_status b where r.settlement_no=b.settlement_no and r.step_status  in (3,4)) ";
                System.out.println(value);



    }
}
