
DROP DATABASE  IF EXISTS test20210707;
CREATE DATABASE test20210707;
USE test20210707;
CREATE TABLE student(id INT,NAME VARCHAR(20),name2 VARCHAR(20),age INT,age2 INT,created_dt DATETIME,created_dt2 DATETIME(3));

INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(1,'º«','º«¾²',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.111');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(2,'º«','º«¾²',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.112');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(3,'º«','º«¾²',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.113');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(4,'º«','º«¾²',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.114');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(5,'º«','º«¾²',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.115');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(6,'º«','º«¾²',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.116');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES(7,'º«','º«¾²',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.117');
INSERT INTO student(id,NAME,name2,age,age2,created_dt,created_dt2) VALUES
(8,'º«','º«¾²',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.118'),
(9,'º«','º«¾²',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.119'),
(10,'º«','º«¾²',21,21,'2021-01-01 12:11:11','2021-01-01 12:11:11.120');

SELECT * FROM student;


UPDATE student SET age=11 WHERE id=1;
UPDATE student SET age=26 WHERE id>1;
DELETE FROM student WHERE  id=1;
DELETE FROM student WHERE  id>5;


TRUNCATE TABLE student;