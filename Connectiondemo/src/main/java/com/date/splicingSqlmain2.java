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
        String fieldsSql = " s.settlement_no,ep.name as parkOwnerName,e.`name` as parkNames,s.account_period,s.settlement_count,s.settlement_amount,s.settlement_status,s.start_time,s.end_time,(CASE WHEN epd.setting_value in (1,2,3) THEN '�Զ�����'  ELSE '�ֶ�����' END ) clearType , epd2.setting_value as bankCode,t.created_dt as transeferSuccessDt,tr.receipt_date,tr.receipt_number,tr.receipt_serial_no ";
        StringBuffer mainSql = new StringBuffer(
                " FROM " + " settlement_batch s "
                        + "   LEFT JOIN transfer_payment_record_status t ON s.settlement_no = t.settlement_no and t.step_status =4 "
                        + "   LEFT JOIN transfer_payment_record tr ON t.serial_no = tr.serial_no "
                        + "   LEFT JOIN equipment_park e ON s.park_id = e.id "
                        + " LEFT JOIN equipment_park_owner ep ON s.park_owner_id=ep.id  "
                        + "  LEFT JOIN equipment_park_owner_setting epd ON ep.id = epd.park_owner_id   AND epd.setting_key = 'pay_date_type'  "
                        + "  LEFT JOIN equipment_park_owner_setting epd2 ON ep.id = epd2.park_owner_id   AND epd2.setting_key = 'bankCode' "
                        + " WHERE "
                        + " 1=1  ");;

        String s = mainSql.toString().replaceAll("]]>", "")
                .replaceAll("CDATA", "")
                .replaceAll("<!\\[\\[", "");
        System.out.println(s);


    }
}
