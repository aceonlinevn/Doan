-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dacn_webbanhang
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `key_rule`
--

DROP TABLE IF EXISTS `key_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `key_rule` (
  `key_rule_id` int(11) NOT NULL AUTO_INCREMENT,
  `key_rule_name` varchar(30) DEFAULT NULL,
  `key_rule_prefix` varchar(10) DEFAULT NULL,
  `key_rule_length` tinyint(10) DEFAULT NULL,
  `key_rule_suffixes` varchar(10) DEFAULT NULL,
  `key_rule_start` tinyint(10) DEFAULT NULL,
  `key_rule_last_modified` varchar(30) DEFAULT NULL,
  `key_rule_description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`key_rule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `key_rule`
--

LOCK TABLES `key_rule` WRITE;
/*!40000 ALTER TABLE `key_rule` DISABLE KEYS */;
INSERT INTO `key_rule` VALUES (1,'import','NK',6,NULL,1,NULL,'Nhập kho'),(2,'export','XK',6,NULL,1,NULL,'Xuất kho'),(3,'bill','HD',10,NULL,1,NULL,'Hóa đơn'),(4,'warranty','BH',6,NULL,1,NULL,'Bảo hành'),(5,'product','SP',6,NULL,1,NULL,'Sản phẩm'),(6,'provider','NCC',6,NULL,1,NULL,'Nhà cung cấp'),(7,'product_laptop','LT',6,NULL,1,NULL,'Sản phẩm laptop'),(8,'product_camera','CAM',6,NULL,1,NULL,'Sản phẩm camera'),(9,'product_pc','PC',6,NULL,1,NULL,'Sản phẩm PC'),(10,'product_component','LK',6,NULL,1,NULL,'Linh kiện'),(11,'product_accessories','PK',6,NULL,1,NULL,'Phụ kiện'),(12,'user','U',6,NULL,1,NULL,'Người dùng'),(13,'customer','KH',6,NULL,1,NULL,'Khách hàng');
/*!40000 ALTER TABLE `key_rule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-30 21:37:17
