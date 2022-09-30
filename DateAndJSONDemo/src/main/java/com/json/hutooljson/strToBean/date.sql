SELECT e.*  FROM equipment_park e
left  JOIN equipment_park_enhance epe ON e.id = epe.id
where e.type = 2 AND e.deleted = 0 and e.is_inservice =1  AND epe.park_mode =3




INSERT INTO meisoodev.analysis_park_report
(id, report_date, park_id, park_no, park_name,
-- 右上角
total_park_num, in_park_num, temp_park_num, long_park_num, white_num, no_plate_num,

 enter_num, out_num, cur_day_park_long, up_to_now_park_long, today_incr_trade_amount, today_incr_trade_num, today_incr_park_num, up_to_now_trade_amount, up_to_now_park_num, handle_exception_num, temp_trade_num, temp_trade_amount, temp_refund_num, temp_refund_amount, long_trade_num, long_trade_amount, long_refund_num, long_refund_amount, today_income, created_dt, updated_dt,

 first_hour_car_in, second_hour_car_in, third_hour_car_in, fourth_hour_car_in, fifth_hour_car_in, sixth_hour_car_in, seventh_hour_car_in, eighth_hour_car_in, ninth_hour_car_in, tenth_hour_car_in, eleventh_hour_car_in, twelfth_hour_car_in, thirteenth_hour_car_in, fourteenth_hour_car_in, fifteenth_hour_car_in, sixteenth_hour_car_in, seventeenth_hour_car_in, eighteenth_hour_car_in, nineteenth_hour_car_in, twentieth_hour_car_in, twenty_first_hour_car_in, twenty_second_hour_car_in, twenty_third_hour_car_in, twenty_fourth_hour_car_in,

 first_hour_car_out, second_hour_car_out, third_hour_car_out, fourth_hour_car_out, fifth_hour_car_out, sixth_hour_car_out, seventh_hour_car_out, eighth_hour_car_out, ninth_hour_car_out, tenth_hour_car_out, eleventh_hour_car_out, twelfth_hour_car_out, thirteenth_hour_car_out, fourteenth_hour_car_out, fifteenth_hour_car_out, sixteenth_hour_car_out, seventeenth_hour_car_out, eighteenth_hour_car_out, nineteenth_hour_car_out, twentieth_hour_car_out, twenty_first_hour_car_out, twenty_second_hour_car_out, twenty_third_hour_car_out, twenty_fourth_hour_car_out,

 pay_wx_num, pay_ali_num, pay_balance_num, pay_etc_num
 )
VALUES(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


meisoodev.analysis_park_report
(report_date, park_id, park_no, park_name,
-- 右上角
total_park_num, in_park_num, temp_park_num, long_park_num, white_num, no_plate_num,

 enter_num, out_num, cur_day_park_long, up_to_now_park_long, today_incr_trade_amount, today_incr_trade_num, today_incr_park_num, up_to_now_trade_amount, up_to_now_park_num, handle_exception_num, temp_trade_num, temp_trade_amount, temp_refund_num, temp_refund_amount, long_trade_num, long_trade_amount, long_refund_num, long_refund_amount, today_income, created_dt, updated_dt,

 first_hour_car_in, second_hour_car_in, third_hour_car_in, fourth_hour_car_in, fifth_hour_car_in, sixth_hour_car_in, seventh_hour_car_in, eighth_hour_car_in, ninth_hour_car_in, tenth_hour_car_in, eleventh_hour_car_in, twelfth_hour_car_in, thirteenth_hour_car_in, fourteenth_hour_car_in, fifteenth_hour_car_in, sixteenth_hour_car_in, seventeenth_hour_car_in, eighteenth_hour_car_in, nineteenth_hour_car_in, twentieth_hour_car_in, twenty_first_hour_car_in, twenty_second_hour_car_in, twenty_third_hour_car_in, twenty_fourth_hour_car_in,

 first_hour_car_out, second_hour_car_out, third_hour_car_out, fourth_hour_car_out, fifth_hour_car_out, sixth_hour_car_out, seventh_hour_car_out, eighth_hour_car_out, ninth_hour_car_out, tenth_hour_car_out, eleventh_hour_car_out, twelfth_hour_car_out, thirteenth_hour_car_out, fourteenth_hour_car_out, fifteenth_hour_car_out, sixteenth_hour_car_out, seventeenth_hour_car_out, eighteenth_hour_car_out, nineteenth_hour_car_out, twentieth_hour_car_out, twenty_first_hour_car_out, twenty_second_hour_car_out, twenty_third_hour_car_out, twenty_fourth_hour_car_out,

 pay_wx_num, pay_ali_num, pay_balance_num, pay_etc_num
 )
        SELECT
  e.name ,e.park_owner_id,e.id , fee_rule_template ,json,epe.charge_rules
FROM
  equipment_park e
  left JOIN equipment_park_enhance epe ON e.id = epe.id
where
  e.type = 2
  AND e.deleted = 0
  and e.is_inservice = 1
  AND epe.park_mode = 3




AnalysisParkReportMapper

com.meisoo.service.core.entity.AnalysisParkReport
insertSelective
updateByPrimaryKey
insert

com.meisoo.service.core.entity.AnalysisParkReport

    where park_id = #{parkId,jdbcType=BIGINT}
    and report_date = #{reportDate, jdbcType=DATE}


CREATE TABLE `analysis_park_report` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `report_date` date NOT NULL DEFAULT '1000-01-01' COMMENT '上报日期',

  -- 右上角 当天
  `park_id` int(11) NOT NULL DEFAULT '0' COMMENT '车场id',
  `park_no` varchar(255) NOT NULL DEFAULT '' COMMENT '车场编号',
  `park_name` varchar(255) NOT NULL DEFAULT '' COMMENT '车场名称',
  `total_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '总车位数',
  `in_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '在停车位数',
  `temp_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '临停车位数',
  `long_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '长租车位数',
  `white_num` int(11) NOT NULL DEFAULT '0' COMMENT '白名单数',
  `no_plate_num` int(11) NOT NULL DEFAULT '0' COMMENT '无牌车数',

  -- 泊位利用率等计算   历史
  `enter_num` int(11) NOT NULL DEFAULT '0' COMMENT '入场数',
  `out_num` int(11) NOT NULL DEFAULT '0' COMMENT '出场数',
  `cur_day_park_long` bigint(20) NOT NULL DEFAULT '0' COMMENT '当天停车时长(秒)',
  `up_to_now_park_long` bigint(20) NOT NULL DEFAULT '0' COMMENT '截至今日历史停车总时长(秒)',


  --  今日信息 累计交易金额 包含 历史
  `today_incr_trade_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '今日新增交易金额',
  `today_incr_trade_num` int(11) NOT NULL DEFAULT '0' COMMENT '今日新增交易笔数',
  `today_incr_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '今日新增停车记录数',
  `up_to_now_trade_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '截至目前总交易金额',
  `up_to_now_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '截至今日历史停车次数',
  `handle_exception_num` int(11) NOT NULL DEFAULT '0' COMMENT '异常处理数',
  `temp_trade_num` int(11) NOT NULL DEFAULT '0' COMMENT '临停交易笔数',
  `temp_trade_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '临停交易金额',
  `temp_refund_num` int(11) NOT NULL DEFAULT '0' COMMENT '临停退费笔数',
  `temp_refund_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '临停退费金额',
  `long_trade_num` int(11) NOT NULL DEFAULT '0' COMMENT '长租交易笔数',
  `long_trade_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '长租交易金额',
  `long_refund_num` int(11) NOT NULL DEFAULT '0' COMMENT '长租退费笔数',
  `long_refund_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '长租退费金额',
  `today_income` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '当日营收',
  `created_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',


   -- 实时 当天
  `first_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '0-1点入场车数',
  `second_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '1-2点入场车数',
  `third_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '2-3点入场车数',
  `fourth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '3-4点入场车数',
  `fifth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '4-5点入场车数',
  `sixth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '5-6点入场车数',
  `seventh_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '6-7点入场车数',
  `eighth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '7-8点入场车数',
  `ninth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '8-9点入场车数',
  `tenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '9-10点入场车数',
  `eleventh_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '10-11点入场车数',
  `twelfth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '11-12点入场车数',
  `thirteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '12-13点入场车数',
  `fourteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '13-14点入场车数',
  `fifteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '14-15点入场车数',
  `sixteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '15-16点入场车数',
  `seventeenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '16-17点入场车数',
  `eighteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '17-18点入场车数',
  `nineteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '18-19点入场车数',
  `twentieth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '19-20点入场车数',
  `twenty_first_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '20-21点入场车数',
  `twenty_second_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '21-22点入场车数',
  `twenty_third_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '22-23点入场车数',
  `twenty_fourth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '23-0点入场车数',
  `first_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT ' 0-1点出场车数',
  `second_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '1-2点出场车数',
  `third_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '2-3点出场车数',
  `fourth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '3-4点出场车数',
  `fifth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '4-5点出场车数',
  `sixth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '5-6点出场车数',
  `seventh_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '6-7点出场车数',
  `eighth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '7-8点出场车数',
  `ninth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '8-9点出场车数',
  `tenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '9-10点出场车数',
  `eleventh_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '10-11点出场车数',
  `twelfth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '11-12点出场车数',
  `thirteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '12-13点出场车数',
  `fourteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '13-14点出场车数',
  `fifteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '14-15点出场车数',
  `sixteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '15-16点出场车数',
  `seventeenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '16-17点出场车数',
  `eighteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '17-18点出场车数',
  `nineteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '18-19点出场车数',
  `twentieth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '19-20点出场车数',
  `twenty_first_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '20-21点出场车数',
  `twenty_second_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '21-22点出场车数',
  `twenty_third_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '22-23点出场车数',
  `twenty_fourth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '23-0点出场车数',


  -- 右下角 历史
  `pay_wx_num` bigint(20) NOT NULL DEFAULT '0' COMMENT '微信支付次数',
  `pay_ali_num` bigint(20) NOT NULL DEFAULT '0' COMMENT '支付宝支付次数',
  `pay_balance_num` bigint(20) NOT NULL DEFAULT '0' COMMENT '余额支付次数',
  `pay_etc_num` bigint(20) NOT NULL DEFAULT '0' COMMENT 'etc支付次数',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_date_park` (`report_date`,`park_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='云ms3.0 - 车场运营数据统计'








--脚本-----------------------------------------------------------------------------------
        SELECT
 e.id as park_id,e.no as park_no, e.name as park_name ,epe.paking_lot as total_park_num,
( epe.paking_lot-epe.free_parking_lot)  as in_park_num
FROM
  equipment_park e
  left JOIN equipment_park_enhance epe ON e.id = epe.id
where
  e.type = 2
  AND e.deleted = 0
  and e.is_inservice = 1
  AND epe.park_mode = 3













