/*
SQLyog Ultimate v8.32 
MySQL - 5.7.19-log : Database - hantest3
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `course` */

CREATE TABLE `course` (
  `cid` varchar(10) NOT NULL,
  `cname` varchar(10) DEFAULT NULL,
  `tid` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`cid`,`cname`,`tid`)
values ('01','语文','06'),('02','语文','06'),
('03','语文','06'),('04','语文','06');

/*Table structure for table `details` */

CREATE TABLE `details` (
  `sname` varchar(200) NOT NULL,
  `count1` int(11) DEFAULT NULL,
  PRIMARY KEY (`sname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `details` */

/*Table structure for table `sc` */

CREATE TABLE `sc` (
  `sid` varchar(10) NOT NULL,
  `cid` varchar(10) NOT NULL,
  `score` decimal(18,1) DEFAULT NULL,
  PRIMARY KEY (`sid`,`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sc` */

insert  into `sc`(`sid`,`cid`,`score`) values ('01','01','23.0');

/*Table structure for table `student` */

CREATE TABLE `student` (
  `sid` varchar(10) NOT NULL,
  `sname` varchar(10) DEFAULT NULL,
  `sage` datetime DEFAULT NULL,
  `ssex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`sid`,`sname`,`sage`,`ssex`)
values ('01','赵雷','1990-01-01 00:00:00','男'),('02','钱电','1990-12-21 00:00:00','男'),
('03','孙风','1990-05-20 00:00:00','男');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;







SELECT * FROM student stu
LEFT JOIN sc ON sc.sid=stu.sid