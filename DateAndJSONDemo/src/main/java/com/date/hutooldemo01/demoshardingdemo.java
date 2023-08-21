package com.date.hutooldemo01;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
 * to do
 *
 * @author Hj
 * @date 2023/8/21
 */
public class demoshardingdemo {
    public static void main(String[] args) {

         String sql="create TEMPORARY table pre_order_park_order_201707 (\n" +
                 "\n" +
                 "   `id` BIGINT    COMMENT '����',\n" +
                 "      `park_id` BIGINT   COMMENT 'parkId',\n" +
                 "  `no` VARCHAR(200)   COMMENT 'no',\n" +
                 "  `created_by` BIGINT   COMMENT '����������',\n" +
                 "  `created_dt` TIMESTAMP   COMMENT '����ʱ��',\n" +
                 "  `deleted` INT   COMMENT 'ɾ�����,δɾ:0,��ɾ:1',\n" +
                 "  `updated_by` BIGINT   COMMENT '����������',\n" +
                 "  `updated_dt` TIMESTAMP   COMMENT '����ʱ��',\n" +
                 "  `back_pay` BIGINT   COMMENT 'backPay',\n" +
                 "  `coupon_pay` BIGINT   COMMENT 'couponPay',\n" +
                 "  `end_date` TIMESTAMP   COMMENT 'endDate',\n" +
                 "  `how_long` BIGINT   COMMENT 'howLong',\n" +
                 "  `money_pay` BIGINT   COMMENT 'moneyPay',\n" +
                 "\n" +
                 "  \n" +
                 "  `park_item_id` BIGINT   COMMENT 'parkItemId',\n" +
                 "  `park_item_name` VARCHAR(200)   COMMENT 'parkItemName',\n" +
                 "  `park_name` VARCHAR(200)   COMMENT 'parkName',\n" +
                 "  `pay_date` TIMESTAMP   COMMENT 'payDate',\n" +
                 "  `phone` VARCHAR(32)   COMMENT '�����ֻ���',\n" +
                 "  `plate_no` VARCHAR(32)   COMMENT '���ƺ�',\n" +
                 "  `postage` BIGINT   COMMENT 'postage',\n" +
                 "  `start_date` TIMESTAMP   COMMENT 'startDate',\n" +
                 "  `status` TINYINT    COMMENT '�ɷ�״̬',\n" +
                 "  `type` TINYINT    COMMENT '�������� 1:�� 2:��',\n" +
                 "  `validity` BIGINT   COMMENT 'validity',\n" +
                 "  `submit_date` TIMESTAMP   COMMENT 'submitDate',\n" +
                 "  `advance_charge` BIGINT   COMMENT 'Ԥ����(��)',\n" +
                 "  `username` VARCHAR(200)   COMMENT '����ӷѲ�����',\n" +
                 "  `video_record_id` BIGINT   COMMENT '��Ƶ׮��¼ID',\n" +
                 "  `category` TINYINT    COMMENT '����1.����(1.0ϵͳ)2.��Ӫ(2.0ϵͳ),���ⶩ������11.�ֳֶ�12.��λ��Ƶ׮13.��Ƶ׮14.�ش�',\n" +
                 "  `data_flag` SMALLINT   COMMENT '���ݱ�ǣ�1Ϊ�����ݣ���ֵΪ��ʵ����',\n" +
                 "  `in_type` TINYINT    COMMENT '�볡��ʽ��1-��Ƶʶ�� 2-�ֶ����� 3-�ֶ�¼�� 4-΢��ɨ�� 5-֧����ɨ��',\n" +
                 "  `park_owner_id` BIGINT   COMMENT '�����̻�Id',\n" +
                 "  `park_owner_name` VARCHAR(128)   COMMENT '�����̻�����',\n" +
                 "  `pic_record_id` VARCHAR(32)   COMMENT 'POSץ�ļ�¼ID',\n" +
                 "  `is_cleared` INT  COMMENT '���״̬�� 0-δ�������1-�ѱ����',\n" +
                 "  `modify_type` INT  COMMENT '���ݰ汾',\n" +
                 "  `remark` VARCHAR(128)   COMMENT '��ע,��¼����һЩ�ؼ�����',\n" +
                 "  `occupy_order_id` BIGINT   COMMENT 'ԤԼռλ����Id(���ֶ�Ϊnull����Ϊ��ͨͣ��)',\n" +
                 "  `forced_timeout_status` INT  COMMENT '���״̬�� 0-δ�������1-�ѱ����',\n" +
                 "  `in_channel_id` VARCHAR(20)   COMMENT '���ʽ��������ͤ���ͨ��ID',\n" +
                 "  `park_type` INT   COMMENT 'ͣ������  10����ʱͣ��  20�����⳵ 30�������� 40����ֵ�� 50�����Ƴ� 60�����취 70�����¹�',\n" +
                 "  `out_category` TINYINT  ,\n" +
                 "  `plate_type` VARCHAR(4)   COMMENT '�������� 02С��������03ʹ��������52С������Դ�������Ƶ�',\n" +
                 "  `park_type_change_time` TIMESTAMP   COMMENT 'ͣ�����ͱ��ʱ��',\n" +
                 "  `original_park_type` INT   COMMENT 'ԭͣ������  10����ʱͣ��  20�����⳵ 30�������� 40����ֵ�� 50�����Ƴ� 60�����취 70�����¹�',\n" +
                 "  `plate_no_colour` INT   COMMENT '������ɫ',\n" +
                 "  `clean_pay` BIGINT   COMMENT '������',\n" +
                 "    PRIMARY KEY (id) NOT ENFORCED\n" +
                 "  ) \n" +
                 "WITH (\n" +
                 "        'connector' = 'jdbc',\n" +
                 "    'url' = 'jdbc:mysql://rm-2zeo71tq83aq0381u.mysql.rds.aliyuncs.com:3306/meisoodev?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=true&allowPublicKeyRetrieval=true',\n" +
                 "    'username' = 'api_deploy',\n" +
                 "    'password' = '1qaz@WSX',\n" +
                 "    'table-name' = 'order_park_order_201707'\n" +
                 "  );";

         DateTime startTime = DateUtil.parse("2017-02-07 15:11:49");
        DateTime endTime = DateUtil.parse("2023-04-07 15:11:49");
        long days = DateUtil.age(startTime, endTime) ;
//        for (int i = 0; i < days; i++) {
//            startTime = startTime.offset(DateField.YEAR, 1);
//            String yyyy = startTime.toString("yyyy");
//            System.out.println(sql.replaceAll("201707",yyyy+"01"));
//            System.out.println(sql.replaceAll("201707",yyyy+"07"));
//        }

        for (int i = 0; i < days; i++) {
            startTime = startTime.offset(DateField.YEAR, 1);
            String yyyy = startTime.toString("yyyy");
            sql="insert into pre_order_park_order_201701\n" +
                    "select *\n" +
                    "from\n" +
                    "  bigdata005_order_park_order  where created_dt<='2017-06-30 23:59:59' and created_dt>='2017-01-01 00:00:00';";
            System.out.println(sql.replaceAll("201707",yyyy+"01").replaceAll("2017",yyyy));
            sql="insert into pre_order_park_order_201707\n" +
                    "select *\n" +
                    "from\n" +
                    "  bigdata005_order_park_order where created_dt <='2017-12-30 23:59:59' and created_dt>'2017-06-30 23:59:59';";

            System.out.println(sql.replaceAll("201707",yyyy+"07").replaceAll("2017",yyyy));
//            System.out.println(sql.replaceAll("201707",yyyy+"07"));
        }




    }
}
