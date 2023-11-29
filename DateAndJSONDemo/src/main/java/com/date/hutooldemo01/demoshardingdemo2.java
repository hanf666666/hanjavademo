package com.date.hutooldemo01;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
 * to do
 * 按月分表
 *
 * @author Hj
 * @date 2023/8/21
 */
public class demoshardingdemo2 {
    public static void main(String[] args) {

        String sql = "DROP TABLE if EXISTS order_park_order_201701;\n" +
                "CREATE TABLE  `order_park_order_201701` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',\n" +
                "  `created_by` bigint(20) NOT NULL COMMENT '创建人主键',\n" +
                "  `created_dt` datetime NOT NULL COMMENT '创建时间',\n" +
                "  `deleted` int(1) DEFAULT NULL COMMENT '删除标记,未删:0,已删:1',\n" +
                "  `updated_by` bigint(20) DEFAULT NULL COMMENT '更新人主键',\n" +
                "  `updated_dt` datetime DEFAULT NULL COMMENT '更新时间',\n" +
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
                "  `phone` varchar(32) DEFAULT NULL COMMENT '车主手机号',\n" +
                "  `plate_no` varchar(32) DEFAULT NULL COMMENT '车牌号',\n" +
                "  `postage` bigint(20) DEFAULT NULL COMMENT 'postage',\n" +
                "  `start_date` datetime NOT NULL COMMENT 'startDate',\n" +
                "  `status` tinyint(3) unsigned NOT NULL COMMENT '缴费状态',\n" +
                "  `type` tinyint(3) unsigned NOT NULL COMMENT '订单类型 1:外 2:内',\n" +
                "  `validity` bigint(20) DEFAULT NULL COMMENT 'validity',\n" +
                "  `submit_date` datetime DEFAULT NULL COMMENT 'submitDate',\n" +
                "  `advance_charge` bigint(20) DEFAULT NULL COMMENT '预付款(分)',\n" +
                "  `username` varchar(200) DEFAULT NULL COMMENT '清除逃费操作人',\n" +
                "  `video_record_id` bigint(20) DEFAULT NULL COMMENT '视频桩记录ID',\n" +
                "  `category` tinyint(3) unsigned DEFAULT NULL COMMENT '室内1.立方(1.0系统)2.自营(2.0系统),室外订单类型11.手持端12.高位视频桩13.视频桩14.地磁',\n" +
                "  `data_flag` smallint(6) DEFAULT NULL COMMENT '数据标记，1为假数据，空值为真实数据',\n" +
                "  `in_type` tinyint(3) unsigned DEFAULT NULL COMMENT '入场方式：1-视频识别 2-手动放行 3-手动录入 4-微信扫码 5-支付宝扫码',\n" +
                "  `park_owner_id` bigint(20) DEFAULT NULL COMMENT '车场商户Id',\n" +
                "  `park_owner_name` varchar(128) DEFAULT NULL COMMENT '车场商户名字',\n" +
                "  `pic_record_id` varchar(32) DEFAULT NULL COMMENT 'POS抓拍记录ID',\n" +
                "  `is_cleared` int(4) DEFAULT '0' COMMENT '清除状态： 0-未被清除，1-已被清除',\n" +
                "  `modify_type` int(4) DEFAULT '1' COMMENT '数据版本',\n" +
                "  `remark` varchar(128) DEFAULT NULL COMMENT '备注,记录跟踪一些关键操作',\n" +
                "  `occupy_order_id` bigint(20) DEFAULT NULL COMMENT '预约占位订单Id(该字段为null，则为普通停车)',\n" +
                "  `forced_timeout_status` int(4) DEFAULT '0' COMMENT '清除状态： 0-未被清除，1-已被清除',\n" +
                "  `in_channel_id` varchar(20) DEFAULT NULL COMMENT '封闭式车场，岗亭入口通道ID',\n" +
                "  `park_type` int(10) unsigned DEFAULT '10' COMMENT '停车类型  10：临时停车  20：长租车 30：白名单 40：储值卡 50：无牌车 60：公检法 70：领事馆',\n" +
                "  `out_category` tinyint(2) DEFAULT NULL,\n" +
                "  `plate_type` varchar(4) DEFAULT NULL COMMENT '车牌类型 02小型汽车，03使馆汽车，52小型新能源汽车号牌等',\n" +
                "  `park_type_change_time` datetime DEFAULT NULL COMMENT '停车类型变更时间',\n" +
                "  `original_park_type` int(4) DEFAULT NULL COMMENT '原停车类型  10：临时停车  20：长租车 30：白名单 40：储值卡 50：无牌车 60：公检法 70：领事馆',\n" +
                "  `plate_no_colour` int(11) DEFAULT NULL COMMENT '车牌颜色',\n" +
                "  `clean_pay` bigint(20) DEFAULT NULL COMMENT '清除金额',\n" +
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
