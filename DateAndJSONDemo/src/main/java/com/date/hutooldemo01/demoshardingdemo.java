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
                 "   `id` BIGINT    COMMENT '主键',\n" +
                 "      `park_id` BIGINT   COMMENT 'parkId',\n" +
                 "  `no` VARCHAR(200)   COMMENT 'no',\n" +
                 "  `created_by` BIGINT   COMMENT '创建人主键',\n" +
                 "  `created_dt` TIMESTAMP   COMMENT '创建时间',\n" +
                 "  `deleted` INT   COMMENT '删除标记,未删:0,已删:1',\n" +
                 "  `updated_by` BIGINT   COMMENT '更新人主键',\n" +
                 "  `updated_dt` TIMESTAMP   COMMENT '更新时间',\n" +
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
                 "  `phone` VARCHAR(32)   COMMENT '车主手机号',\n" +
                 "  `plate_no` VARCHAR(32)   COMMENT '车牌号',\n" +
                 "  `postage` BIGINT   COMMENT 'postage',\n" +
                 "  `start_date` TIMESTAMP   COMMENT 'startDate',\n" +
                 "  `status` TINYINT    COMMENT '缴费状态',\n" +
                 "  `type` TINYINT    COMMENT '订单类型 1:外 2:内',\n" +
                 "  `validity` BIGINT   COMMENT 'validity',\n" +
                 "  `submit_date` TIMESTAMP   COMMENT 'submitDate',\n" +
                 "  `advance_charge` BIGINT   COMMENT '预付款(分)',\n" +
                 "  `username` VARCHAR(200)   COMMENT '清除逃费操作人',\n" +
                 "  `video_record_id` BIGINT   COMMENT '视频桩记录ID',\n" +
                 "  `category` TINYINT    COMMENT '室内1.立方(1.0系统)2.自营(2.0系统),室外订单类型11.手持端12.高位视频桩13.视频桩14.地磁',\n" +
                 "  `data_flag` SMALLINT   COMMENT '数据标记，1为假数据，空值为真实数据',\n" +
                 "  `in_type` TINYINT    COMMENT '入场方式：1-视频识别 2-手动放行 3-手动录入 4-微信扫码 5-支付宝扫码',\n" +
                 "  `park_owner_id` BIGINT   COMMENT '车场商户Id',\n" +
                 "  `park_owner_name` VARCHAR(128)   COMMENT '车场商户名字',\n" +
                 "  `pic_record_id` VARCHAR(32)   COMMENT 'POS抓拍记录ID',\n" +
                 "  `is_cleared` INT  COMMENT '清除状态： 0-未被清除，1-已被清除',\n" +
                 "  `modify_type` INT  COMMENT '数据版本',\n" +
                 "  `remark` VARCHAR(128)   COMMENT '备注,记录跟踪一些关键操作',\n" +
                 "  `occupy_order_id` BIGINT   COMMENT '预约占位订单Id(该字段为null，则为普通停车)',\n" +
                 "  `forced_timeout_status` INT  COMMENT '清除状态： 0-未被清除，1-已被清除',\n" +
                 "  `in_channel_id` VARCHAR(20)   COMMENT '封闭式车场，岗亭入口通道ID',\n" +
                 "  `park_type` INT   COMMENT '停车类型  10：临时停车  20：长租车 30：白名单 40：储值卡 50：无牌车 60：公检法 70：领事馆',\n" +
                 "  `out_category` TINYINT  ,\n" +
                 "  `plate_type` VARCHAR(4)   COMMENT '车牌类型 02小型汽车，03使馆汽车，52小型新能源汽车号牌等',\n" +
                 "  `park_type_change_time` TIMESTAMP   COMMENT '停车类型变更时间',\n" +
                 "  `original_park_type` INT   COMMENT '原停车类型  10：临时停车  20：长租车 30：白名单 40：储值卡 50：无牌车 60：公检法 70：领事馆',\n" +
                 "  `plate_no_colour` INT   COMMENT '车牌颜色',\n" +
                 "  `clean_pay` BIGINT   COMMENT '清除金额',\n" +
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
