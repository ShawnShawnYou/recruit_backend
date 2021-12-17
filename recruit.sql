/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.24 : Database - recruit
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`recruit` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `recruit`;

/*Table structure for table `education_entry` */

DROP TABLE IF EXISTS `education_entry`;

CREATE TABLE `education_entry` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `school` varchar(32) DEFAULT NULL,
  `major` varchar(32) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `education_entry` */

insert  into `education_entry`(`id`,`user_id`,`school`,`major`,`start_time`,`end_time`,`level`) values 
(5,1,'xxxxx','软件','2022-09-01 00:00:00','2025-06-01 00:00:00','硕士'),
(6,2,'华东师范大学','软件','2022-09-01 00:00:00','2025-06-01 00:00:00','硕士'),
(8,2,'华东师范大学','软件','2022-09-01 00:00:00','2025-06-01 00:00:00','硕士'),
(9,1,'xxxxx','软件','2022-09-01 00:00:00','2025-06-01 00:00:00','硕士');

/*Table structure for table `experiment_entry` */

DROP TABLE IF EXISTS `experiment_entry`;

CREATE TABLE `experiment_entry` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `role` varchar(64) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `experiment_entry` */

insert  into `experiment_entry`(`id`,`user_id`,`name`,`role`,`start_time`,`end_time`,`description`) values 
(2,1,'项目B','组长','2022-09-01 00:00:00','2025-06-01 00:00:00',NULL);

/*Table structure for table `language_entry` */

DROP TABLE IF EXISTS `language_entry`;

CREATE TABLE `language_entry` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `language` varchar(32) DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `language_entry` */

insert  into `language_entry`(`id`,`user_id`,`language`,`level`) values 
(2,1,'英语','六级'),
(3,1,'英语','八级'),
(4,1,'英语','八级');

/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `base` varchar(32) DEFAULT NULL,
  `department` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `requirement` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `position` */

insert  into `position`(`id`,`name`,`base`,`department`,`description`,`requirement`,`update_time`) values 
(1,'程序员','成都','开发','啊啊啊','是人','2021-12-16 22:23:06'),
(2,'程序员','成都','开发','啊啊啊','是人','2021-12-16 22:25:16');

/*Table structure for table `resume_basic` */

DROP TABLE IF EXISTS `resume_basic`;

CREATE TABLE `resume_basic` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `self_evaluate` varchar(256) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `resume_basic` */

insert  into `resume_basic`(`id`,`user_id`,`name`,`phone`,`email`,`self_evaluate`,`update_time`) values 
(2,1,'钟萧遥',NULL,NULL,NULL,'2021-12-16 17:00:24');

/*Table structure for table `resume_file` */

DROP TABLE IF EXISTS `resume_file`;

CREATE TABLE `resume_file` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `location` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `old_name` varchar(256) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `resume_file` */

/*Table structure for table `resume_submit_status` */

DROP TABLE IF EXISTS `resume_submit_status`;

CREATE TABLE `resume_submit_status` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `id_position` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `resume_submit_status` */

insert  into `resume_submit_status`(`id`,`user_id`,`id_position`,`status`,`update_time`) values 
(1,1,1,0,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `phone` char(11) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `type` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`phone`,`password`,`type`) values 
(1,'1','1',0),
(2,'2','2',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
