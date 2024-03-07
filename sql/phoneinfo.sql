/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - phoneinfo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`phoneinfo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `phoneinfo`;

/*Table structure for table `informations` */

DROP TABLE IF EXISTS `informations`;

CREATE TABLE `informations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `replyCount` int(11) NOT NULL,
  `viewCount` int(11) NOT NULL,
  `reportTime` datetime NOT NULL,
  `lastPostTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `informations` */

insert  into `informations`(`id`,`title`,`content`,`replyCount`,`viewCount`,`reportTime`,`lastPostTime`) values (1,'资讯标题1','资讯内容1',2,14,'2023-06-23 13:36:51','2023-06-23 18:41:13'),(2,'资讯标题2','资讯内容2',3,16,'2023-06-23 13:36:51','2023-06-23 21:53:05'),(3,'资讯标题3','资讯内容3',4,10,'2023-06-23 13:36:51','2023-06-23 19:09:43');

/*Table structure for table `replies` */

DROP TABLE IF EXISTS `replies`;

CREATE TABLE `replies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `replyTime` datetime NOT NULL,
  `infoId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_infoId` (`infoId`),
  CONSTRAINT `fk_infoId` FOREIGN KEY (`infoId`) REFERENCES `informations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `replies` */

insert  into `replies`(`id`,`content`,`replyTime`,`infoId`) values (1,'回复内容1','2023-06-23 13:36:51',1),(2,'回复内容2','2023-06-23 13:36:51',2),(3,'你好','2023-06-23 17:20:22',1),(4,'今天天气怎么样','2023-06-23 17:26:11',1),(5,'天气不错','2023-06-23 17:44:41',1),(6,'加油','2023-06-23 17:45:04',1),(7,'回复数联','2023-06-23 17:46:05',1),(8,'你好','2023-06-23 17:46:22',2),(9,'1111','2023-06-23 17:50:35',3),(10,'222','2023-06-23 17:51:09',3),(11,'1111111','2023-06-23 18:41:13',1),(12,'1111','2023-06-23 19:01:17',2),(13,'*666666','2023-06-23 19:09:43',3),(14,'22222','2023-06-23 21:53:05',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
