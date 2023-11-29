package com.date.hutooldemo01;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
 * to do
 * ���·ֱ�
 *
 * @author Hj
 * @date 2023/8/21
 */
public class demoshardingdemo2 {
    public static void main(String[] args) {

        String sql = "DROP TABLE if EXISTS order_park_order_201701;\n" +
                "CREATE TABLE  `order_park_order_201701` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '����',\n" +
                "  `created_by` bigint(20) NOT NULL COMMENT '����������',\n" +
                "  `created_dt` datetime NOT NULL COMMENT '����ʱ��',\n" +
                "  `deleted` int(1) DEFAULT NULL COMMENT 'ɾ�����,δɾ:0,��ɾ:1',\n" +
                "  `updated_by` bigint(20) DEFAULT NULL COMMENT '����������',\n" +
                "  `updated_dt` datetime DEFAULT NULL COMMENT '����ʱ��',\n" +
                "  `back_pay` bigint(20) DEFAULT NULL COMMENT 'backPay',\n" +
                "  `coupon_pay` bigint(20) DEFAULT NULL COMMENT 'couponPay',\n" +
                "  `end_date` datetime DEFAULT NULL COMMENT 'endDate',\n" +
                "  `how_long` bigint(20) DEFAULT NULL COMMENT 'howLong',\n" +
                "  `money_pay` bigint(20) DEFAULT NULL COMMENT 'moneyPay',\n" +
                "  `no` varchar(200) NOT NULL COMMENT 'no',\n" +
                "  `park_id` bigint(20) NOT NULL COMMENT 'parkId',\n" +
                "  `park_item_id` bigint(20) DEFAULT NULL COMMENT 'parkItemId',\n" +
                "  `park_item_name` varchar(200) DEFAULT NULL COMMENT 'parkItemName',\n" +
                "  `park_name` varchar(200) NOT NULL COMMENT 'parkName',\n" +
                "  `pay_date` datetime DEFAULT NULL COMMENT 'payDate',\n" +
                "  `phone` varchar(32) DEFAULT NULL COMMENT '�����ֻ���',\n" +
                "  `plate_no` varchar(32) DEFAULT NULL COMMENT '���ƺ�',\n" +
                "  `postage` bigint(20) DEFAULT NULL COMMENT 'postage',\n" +
                "  `start_date` datetime NOT NULL COMMENT 'startDate',\n" +
                "  `status` tinyint(3) unsigned NOT NULL COMMENT '�ɷ�״̬',\n" +
                "  `type` tinyint(3) unsigned NOT NULL COMMENT '�������� 1:�� 2:��',\n" +
                "  `validity` bigint(20) DEFAULT NULL COMMENT 'validity',\n" +
                "  `submit_date` datetime DEFAULT NULL COMMENT 'submitDate',\n" +
                "  `advance_charge` bigint(20) DEFAULT NULL COMMENT 'Ԥ����(��)',\n" +
                "  `username` varchar(200) DEFAULT NULL COMMENT '����ӷѲ�����',\n" +
                "  `video_record_id` bigint(20) DEFAULT NULL COMMENT '��Ƶ׮��¼ID',\n" +
                "  `category` tinyint(3) unsigned DEFAULT NULL COMMENT '����1.����(1.0ϵͳ)2.��Ӫ(2.0ϵͳ),���ⶩ������11.�ֳֶ�12.��λ��Ƶ׮13.��Ƶ׮14.�ش�',\n" +
                "  `data_flag` smallint(6) DEFAULT NULL COMMENT '���ݱ�ǣ�1Ϊ�����ݣ���ֵΪ��ʵ����',\n" +
                "  `in_type` tinyint(3) unsigned DEFAULT NULL COMMENT '�볡��ʽ��1-��Ƶʶ�� 2-�ֶ����� 3-�ֶ�¼�� 4-΢��ɨ�� 5-֧����ɨ��',\n" +
                "  `park_owner_id` bigint(20) DEFAULT NULL COMMENT '�����̻�Id',\n" +
                "  `park_owner_name` varchar(128) DEFAULT NULL COMMENT '�����̻�����',\n" +
                "  `pic_record_id` varchar(32) DEFAULT NULL COMMENT 'POSץ�ļ�¼ID',\n" +
                "  `is_cleared` int(4) DEFAULT '0' COMMENT '���״̬�� 0-δ�������1-�ѱ����',\n" +
                "  `modify_type` int(4) DEFAULT '1' COMMENT '���ݰ汾',\n" +
                "  `remark` varchar(128) DEFAULT NULL COMMENT '��ע,��¼����һЩ�ؼ�����',\n" +
                "  `occupy_order_id` bigint(20) DEFAULT NULL COMMENT 'ԤԼռλ����Id(���ֶ�Ϊnull����Ϊ��ͨͣ��)',\n" +
                "  `forced_timeout_status` int(4) DEFAULT '0' COMMENT '���״̬�� 0-δ�������1-�ѱ����',\n" +
                "  `in_channel_id` varchar(20) DEFAULT NULL COMMENT '���ʽ��������ͤ���ͨ��ID',\n" +
                "  `park_type` int(10) unsigned DEFAULT '10' COMMENT 'ͣ������  10����ʱͣ��  20�����⳵ 30�������� 40����ֵ�� 50�����Ƴ� 60�����취 70�����¹�',\n" +
                "  `out_category` tinyint(2) DEFAULT NULL,\n" +
                "  `plate_type` varchar(4) DEFAULT NULL COMMENT '�������� 02С��������03ʹ��������52С������Դ�������Ƶ�',\n" +
                "  `park_type_change_time` datetime DEFAULT NULL COMMENT 'ͣ�����ͱ��ʱ��',\n" +
                "  `original_park_type` int(4) DEFAULT NULL COMMENT 'ԭͣ������  10����ʱͣ��  20�����⳵ 30�������� 40����ֵ�� 50�����Ƴ� 60�����취 70�����¹�',\n" +
                "  `plate_no_colour` int(11) DEFAULT NULL COMMENT '������ɫ',\n" +
                "  `clean_pay` bigint(20) DEFAULT NULL COMMENT '������',\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE KEY `UK1nrtvog2iuj1dcrmj7u2p4dwu` (`no`),\n" +
                "  KEY `index_start_date` (`start_date`),\n" +
                "  KEY `idx_type_status` (`type`,`status`),\n" +
                "  KEY `idx_park_order_plt_no` (`plate_no`),\n" +
                "  KEY `ix_created_dt` (`created_dt`),\n" +
                "  KEY `idx_order_park_order_park_id` (`park_id`),\n" +
                "  KEY `IDX_ORDER_PARK_ORDER_END_DATE` (`end_date`),\n" +
                "  KEY `idx_status_deleted` (`status`,`deleted`),\n" +
                "  KEY `idx_park_order_phone` (`phone`),\n" +
                "  KEY `park_item_name_index` (`park_item_name`),\n" +
                "  KEY `idx_end_date_start_date_type_deleted_park_id` (`type`,`deleted`,`end_date`) USING BTREE\n" +
                ") DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;";

        DateTime startTime = DateUtil.parse("2016-12-22 15:11:49");
        DateTime endTime = DateUtil.parse("2024-04-22 15:11:49");
        long days = DateUtil.betweenMonth(startTime, endTime, true);

        for (int i = 0; i < days; i++) {
            startTime = startTime.offset(DateField.MONTH, 1);
            String yyyyMM = startTime.toString("yyyyMM");
            String MM = startTime.toString("MM");
//            sql="select count(1) from order_park_order_201701;";
            if (!MM.contains("01") && !MM.contains("07")) {
                System.out.println(sql.replaceAll("201701", yyyyMM));
            }

        }


    }
}
