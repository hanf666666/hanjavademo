/*
SQLyog Ultimate v8.32 
MySQL - 5.7.19-log : Database - replicastest
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `student` */

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `name2` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `age2` int(11) DEFAULT NULL,
  `created_dt` datetime DEFAULT NULL,
  `created_dt2` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(1,'demo','demo01',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.111');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(2,'demo','demo01',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.112');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(3,'demo','demo01',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.113');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(4,'demo','demo01',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.114');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(5,'demo','demo01',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.115');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(6,'demo','demo01',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.116');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(7,'demo','demo01',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.117');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES
(8,'demo','demo01',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.118'),
(9,'demo','demo01',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.119')