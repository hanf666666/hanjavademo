

CREATE TABLE `chengjiao_house` (
  `projectname` varchar(100) NOT NULL,
  `buildingid` varchar(100) NOT NULL,
  `enterprisename` varchar(100) NOT NULL,
  `locationfu` varchar(100) NOT NULL,
  `fjh` varchar(100) NOT NULL,
  `downloadDate` datetime NOT NULL,
  `roomstatus` varchar(30) DEFAULT NULL,
  `use` varchar(30) DEFAULT NULL,
  `locationzi` varchar(100) DEFAULT NULL,
  `nsjg` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`fjh`,`downloadDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


select count(1) from current_house;


select * from current_house where roomstatus='�ַ�'


select * from current_house where projectname like '%��ɽ����%'
select * from current_house where projectname like '%��Ϫ����%'


select * from current_house where date(downloadDate)=DATE_SUB(current_date(),INTERVAL 0 day) and projectname like '%��ɽ����%' and roomstatus in ('�ַ�','�ڷ�')

select distinct projectname from current_house where projectname like '%��%' 


select  max(downloadDate) from current_house
update current_house set downloadDate=DATE_SUB(now(),INTERVAL 1 day) where downloadDate='2022-05-14 05:00:00'

select  fjh from current_house 
where   downloadDate='2022-05-14 11:00:15' 
group by fjh having count(1)>1 



select * from current_house where fjh='BB00900305800000140100100060001';

select * from current_house where fjh in(
select  fjh from current_house 
where   date(downloadDate)=DATE_SUB(current_date(),INTERVAL 0 day) 
group by fjh having count(1)>1
) and date(downloadDate)=DATE_SUB(current_date(),INTERVAL 0 day) 

select count(1) from current_house where date(downloadDate)=DATE_SUB(current_date(),INTERVAL 0 day);

select DATE_SUB(now(),INTERVAL 1 day),now();
select  date(downloadDate),count(1) from current_house group by  date(downloadDate)

select  date(downloadDate),projectname,count(1) from current_house where   date(downloadDate)=DATE_SUB(current_date(),INTERVAL 0 day) group by  date(downloadDate),projectname







select DATE_SUB(current_date(),INTERVAL 11 day)



select a.roomstatus ,b.downloadDate ,b.roomstatus ,concat(a.nsjg, 'Ԫ') '���ڼ۸�',b.fjh ,a.* from current_house a
left join current_house b on a.fjh =b.fjh 
where date(a.downloadDate)=DATE_SUB(current_date(),INTERVAL 2 day)
and date(b.downloadDate)=DATE_SUB(current_date(),INTERVAL 0 day) 
and a.roomstatus !=b.roomstatus  and  a.roomstatus not in('��ǩ','�Ϲ�') and b.roomstatus in('��ǩ','�Ϲ�') 
order by b.downloadDate 

delete from chengjiao_house where date(downloadDate)=DATE_SUB(current_date(),INTERVAL 0 day) 
--����
delete from current_house  where date(downloadDate)<='2022-05-13' ;
select DATE_SUB(current_date(),INTERVAL 11 day)
--����
delete from  current_house where downloadDate='2022-05-14 11:00:15'  and fjh in (
select fjh from (
select  fjh from current_house 
where   downloadDate='2022-05-14 11:00:15' 
group by fjh having count(1)>1 
) aa
)





insert into chengjiao_house
select b.* from current_house a
left join current_house b on a.fjh =b.fjh 
where date(a.downloadDate)=DATE_SUB(current_date(),INTERVAL 2 day)
and date(b.downloadDate)=DATE_SUB(current_date(),INTERVAL 1 day) 
and a.roomstatus !=b.roomstatus and  a.roomstatus not in('��ǩ','�Ϲ�')  and  b.roomstatus in('��ǩ','�Ϲ�') 
order by b.downloadDate 


select  b.projectname,b.locationfu ,b.downloadDate '�ɽ�ʱ��' ,b.roomstatus ,concat(b.nsjg, 'Ԫ') '���ڼ۸�',b.fjh ,b.*from chengjiao_house b
where date(b.downloadDate)=DATE_SUB(current_date(),INTERVAL 1 day)  and b.nsjg >17000 
order by b.projectname,downloadDate ;

select  b.projectname,b.locationfu,b.downloadDate '�ɽ�ʱ��' ,b.roomstatus ,concat(b.nsjg, 'Ԫ') '���ڼ۸�',b.fjh from chengjiao_house b 
where date(b.downloadDate)=DATE_SUB(current_date(),INTERVAL 1 day)  and b.nsjg >17000 
order by b.downloadDate ;



select a.roomstatus ,b.roomstatus ,a.* from current_house a
left join current_house b on a.fjh =b.fjh 
where a.fjh='BB00900304670000150100100020002' and a.roomstatus !=b.roomstatus and b.roomstatus in('��ǩ','�Ϲ�')


select * from current_house b where b.nsjg >17000 
and date(b.downloadDate)=DATE_SUB(current_date(),INTERVAL 1 day) 


select * from current_house b where b.projectname ='������ɽ���ű���ҼƷ' and fjh like '%%0001' and date(b.downloadDate)=DATE_SUB(current_date(),INTERVAL 1 day) 













































CREATE TABLE `ippools` (
  `ipport` varchar(30) NOT NULL COMMENT 'ipport��ַ:�˿�',
  `httptype` varchar(20) NOT NULL COMMENT 'http��https',
  `soure` varchar(40) DEFAULT NULL COMMENT '��Դ',
  `anonymous` varchar(20) DEFAULT NULL COMMENT '��������:����',
  `downloadDate` datetime DEFAULT NULL COMMENT '����ʱ��',
  `status` varchar(20) DEFAULT NULL COMMENT 'ip��״̬0����,1������',
  `highstatus` varchar(20) DEFAULT NULL COMMENT 'boot����֤0����,1������',
  `updateDate` datetime DEFAULT NULL COMMENT '��֤ʱ��',
  `checkingCount` int(11) DEFAULT NULL COMMENT '��֤����',
  PRIMARY KEY (`ipport`,`httptype`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8





select  *  from ippools i where status='0' and highstatus='0'  and httptype='http' order by checkingCount desc ,updateDate desc;
select * from ippools i where status='1' and httptype='http' order by checkingCount desc ,updateDate desc;
update ippools set highstatus='1' where ipport like '58.220.95.32:10174%'
select  *  from ippools i where status='0' and httptype='https' order by checkingCount desc ,updateDate desc;
select * from ippools i where status='1' and httptype='https' order by checkingCount desc ,updateDate desc;

select * from ippools i where ipport ='120.26.198.187:8877'
select * from ippools i where ipport like '43.248.133.29:8080%'


truncate table ippools;
drop table ippools



INSERT INTO housedb.ippools(ipport, httptype,soure, anonymous, downloadDate, status, updateDate, checkingCount)
VALUES('115.223.210.67:9000', 'http','https://www.89ip.cn/index_{}.html' ,'anonymous', '2022-05-09 11:33:29.173417', '0', '2022-05-09 11:33:29.173417', 0)                       

on duplicate key update checkingCount = checkingCount+1,updateDate='2022-05-09 11:33:29.173417',status=0;

