/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.12 : Database - sso
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `oauth_client_details` */

DROP TABLE IF EXISTS `oauth_client_details`;

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL,
  `resource_ids` varchar(128) DEFAULT NULL,
  `client_secret` varchar(128) DEFAULT NULL,
  `scope` varchar(128) DEFAULT NULL,
  `authorized_grant_types` varchar(128) DEFAULT NULL,
  `web_server_redirect_uri` varchar(128) DEFAULT NULL,
  `authorities` varchar(128) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `oauth_client_details` */

insert  into `oauth_client_details`(`client_id`,`resource_ids`,`client_secret`,`scope`,`authorized_grant_types`,`web_server_redirect_uri`,`authorities`,`access_token_validity`,`refresh_token_validity`,`additional_information`,`autoapprove`) values ('test-client-id','all','$2a$10$ScMSs1zQ9CbYV2cPi9iZi.mNHsiQMye/cVdu0epc.6v4S.KYywSNO','all','authorization_code,refresh_token,client_credentials','http://localhost:9003/login,http://localhost:9004/login','all',7200,7200,NULL,'0');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `account` varchar(128) NOT NULL,
  `password` varchar(1024) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  `name` varchar(128) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`account`,`password`,`enable`,`name`,`last_login_time`) values ('test','$2a$10$65oVg7lO3WJi7wi2OFD2jOmCiyYcF94nymvCcHGTB/3V89KuGw2S.',1,'test',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
