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
        String settlementBatchSql = "  select \n" +
                "  sb.park_id as parkId, \n" +
                "  ep.name as parkName, \n" +
                "  sb.park_owner_id as parkOwnerId, \n" +
                "  sb.account_period as accountPeriod, \n" +
                "  sb.settlement_amount as amt, \n" +
                "  sb.settlement_no as settlementNo, \n" +
                "  epo.bank_account as rcvAcno, \n" +
                "  epo.bank_account_name as rcvAcname, \n" +
                "  epo.bank_name as rcvBankName\n" +
                "from settlement_batch sb\n" +
                "  left join equipment_park ep  on  sb.park_id = ep.id \n" +
                "  left join equipment_park_owner epo  on  sb.park_owner_id = epo.id \n" +
                " where \n" +
                "   sb.settlement_status in( 2 , 4 ) \n" +
                " and  `settlement_no` = :settlementNo ";

        String s = settlementBatchSql.toString().replaceAll("]]>", "")
                .replaceAll("CDATA", "")
                .replaceAll("<!\\[\\[", "");
        System.out.println(s);


    }
}
