SELECT e.*  FROM equipment_park e
left  JOIN equipment_park_enhance epe ON e.id = epe.id
where e.type = 2 AND e.deleted = 0 and e.is_inservice =1  AND epe.park_mode =3




INSERT INTO meisoodev.analysis_park_report
(id, report_date, park_id, park_no, park_name,
-- ���Ͻ�
total_park_num, in_park_num, temp_park_num, long_park_num, white_num, no_plate_num,

 enter_num, out_num, cur_day_park_long, up_to_now_park_long, today_incr_trade_amount, today_incr_trade_num, today_incr_park_num, up_to_now_trade_amount, up_to_now_park_num, handle_exception_num, temp_trade_num, temp_trade_amount, temp_refund_num, temp_refund_amount, long_trade_num, long_trade_amount, long_refund_num, long_refund_amount, today_income, created_dt, updated_dt,

 first_hour_car_in, second_hour_car_in, third_hour_car_in, fourth_hour_car_in, fifth_hour_car_in, sixth_hour_car_in, seventh_hour_car_in, eighth_hour_car_in, ninth_hour_car_in, tenth_hour_car_in, eleventh_hour_car_in, twelfth_hour_car_in, thirteenth_hour_car_in, fourteenth_hour_car_in, fifteenth_hour_car_in, sixteenth_hour_car_in, seventeenth_hour_car_in, eighteenth_hour_car_in, nineteenth_hour_car_in, twentieth_hour_car_in, twenty_first_hour_car_in, twenty_second_hour_car_in, twenty_third_hour_car_in, twenty_fourth_hour_car_in,

 first_hour_car_out, second_hour_car_out, third_hour_car_out, fourth_hour_car_out, fifth_hour_car_out, sixth_hour_car_out, seventh_hour_car_out, eighth_hour_car_out, ninth_hour_car_out, tenth_hour_car_out, eleventh_hour_car_out, twelfth_hour_car_out, thirteenth_hour_car_out, fourteenth_hour_car_out, fifteenth_hour_car_out, sixteenth_hour_car_out, seventeenth_hour_car_out, eighteenth_hour_car_out, nineteenth_hour_car_out, twentieth_hour_car_out, twenty_first_hour_car_out, twenty_second_hour_car_out, twenty_third_hour_car_out, twenty_fourth_hour_car_out,

 pay_wx_num, pay_ali_num, pay_balance_num, pay_etc_num
 )
VALUES(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


meisoodev.analysis_park_report
(report_date, park_id, park_no, park_name,
-- ���Ͻ�
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
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `report_date` date NOT NULL DEFAULT '1000-01-01' COMMENT '�ϱ�����',

  -- ���Ͻ� ����
  `park_id` int(11) NOT NULL DEFAULT '0' COMMENT '����id',
  `park_no` varchar(255) NOT NULL DEFAULT '' COMMENT '�������',
  `park_name` varchar(255) NOT NULL DEFAULT '' COMMENT '��������',
  `total_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '�ܳ�λ��',
  `in_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '��ͣ��λ��',
  `temp_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '��ͣ��λ��',
  `long_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '���⳵λ��',
  `white_num` int(11) NOT NULL DEFAULT '0' COMMENT '��������',
  `no_plate_num` int(11) NOT NULL DEFAULT '0' COMMENT '���Ƴ���',

  -- ��λ�����ʵȼ���   ��ʷ
  `enter_num` int(11) NOT NULL DEFAULT '0' COMMENT '�볡��',
  `out_num` int(11) NOT NULL DEFAULT '0' COMMENT '������',
  `cur_day_park_long` bigint(20) NOT NULL DEFAULT '0' COMMENT '����ͣ��ʱ��(��)',
  `up_to_now_park_long` bigint(20) NOT NULL DEFAULT '0' COMMENT '����������ʷͣ����ʱ��(��)',


  --  ������Ϣ �ۼƽ��׽�� ���� ��ʷ
  `today_incr_trade_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '�����������׽��',
  `today_incr_trade_num` int(11) NOT NULL DEFAULT '0' COMMENT '�����������ױ���',
  `today_incr_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '��������ͣ����¼��',
  `up_to_now_trade_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '����Ŀǰ�ܽ��׽��',
  `up_to_now_park_num` int(11) NOT NULL DEFAULT '0' COMMENT '����������ʷͣ������',
  `handle_exception_num` int(11) NOT NULL DEFAULT '0' COMMENT '�쳣������',
  `temp_trade_num` int(11) NOT NULL DEFAULT '0' COMMENT '��ͣ���ױ���',
  `temp_trade_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '��ͣ���׽��',
  `temp_refund_num` int(11) NOT NULL DEFAULT '0' COMMENT '��ͣ�˷ѱ���',
  `temp_refund_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '��ͣ�˷ѽ��',
  `long_trade_num` int(11) NOT NULL DEFAULT '0' COMMENT '���⽻�ױ���',
  `long_trade_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '���⽻�׽��',
  `long_refund_num` int(11) NOT NULL DEFAULT '0' COMMENT '�����˷ѱ���',
  `long_refund_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '�����˷ѽ��',
  `today_income` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '����Ӫ��',
  `created_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `updated_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '����ʱ��',


   -- ʵʱ ����
  `first_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '0-1���볡����',
  `second_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '1-2���볡����',
  `third_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '2-3���볡����',
  `fourth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '3-4���볡����',
  `fifth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '4-5���볡����',
  `sixth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '5-6���볡����',
  `seventh_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '6-7���볡����',
  `eighth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '7-8���볡����',
  `ninth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '8-9���볡����',
  `tenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '9-10���볡����',
  `eleventh_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '10-11���볡����',
  `twelfth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '11-12���볡����',
  `thirteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '12-13���볡����',
  `fourteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '13-14���볡����',
  `fifteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '14-15���볡����',
  `sixteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '15-16���볡����',
  `seventeenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '16-17���볡����',
  `eighteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '17-18���볡����',
  `nineteenth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '18-19���볡����',
  `twentieth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '19-20���볡����',
  `twenty_first_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '20-21���볡����',
  `twenty_second_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '21-22���볡����',
  `twenty_third_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '22-23���볡����',
  `twenty_fourth_hour_car_in` int(11) NOT NULL DEFAULT '0' COMMENT '23-0���볡����',
  `first_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT ' 0-1���������',
  `second_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '1-2���������',
  `third_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '2-3���������',
  `fourth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '3-4���������',
  `fifth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '4-5���������',
  `sixth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '5-6���������',
  `seventh_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '6-7���������',
  `eighth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '7-8���������',
  `ninth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '8-9���������',
  `tenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '9-10���������',
  `eleventh_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '10-11���������',
  `twelfth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '11-12���������',
  `thirteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '12-13���������',
  `fourteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '13-14���������',
  `fifteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '14-15���������',
  `sixteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '15-16���������',
  `seventeenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '16-17���������',
  `eighteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '17-18���������',
  `nineteenth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '18-19���������',
  `twentieth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '19-20���������',
  `twenty_first_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '20-21���������',
  `twenty_second_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '21-22���������',
  `twenty_third_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '22-23���������',
  `twenty_fourth_hour_car_out` int(11) NOT NULL DEFAULT '0' COMMENT '23-0���������',


  -- ���½� ��ʷ
  `pay_wx_num` bigint(20) NOT NULL DEFAULT '0' COMMENT '΢��֧������',
  `pay_ali_num` bigint(20) NOT NULL DEFAULT '0' COMMENT '֧����֧������',
  `pay_balance_num` bigint(20) NOT NULL DEFAULT '0' COMMENT '���֧������',
  `pay_etc_num` bigint(20) NOT NULL DEFAULT '0' COMMENT 'etc֧������',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_date_park` (`report_date`,`park_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='��ms3.0 - ������Ӫ����ͳ��'








--�ű�-----------------------------------------------------------------------------------
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













