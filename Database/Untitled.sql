-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: dacn_webbanhang
-- ------------------------------------------------------
-- Server version	5.7.12

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `bill_id` int(1) NOT NULL AUTO_INCREMENT,
  `bill_prefix` varchar(5) DEFAULT NULL,
  `bill_customer_id` char(15) DEFAULT NULL,
  `bill_date_created` varchar(45) DEFAULT NULL,
  `bill_payments` varchar(45) DEFAULT NULL,
  `bill_advance_payment` varchar(45) DEFAULT NULL,
  `bill_owe` decimal(20,0) DEFAULT NULL,
  `bill_discount` int(11) DEFAULT NULL,
  `bill_TypeUnitPrice` int(11) DEFAULT NULL,
  `bill_note` varchar(300) DEFAULT NULL,
  `bill_Total_Amount` decimal(20,0) DEFAULT NULL,
  `bill_user_created_id` char(15) DEFAULT NULL,
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_detail`
--

DROP TABLE IF EXISTS `bill_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill_detail` (
  `bill_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_id` int(11) DEFAULT NULL,
  `bill_detailcol` varchar(45) DEFAULT NULL,
  `bill_detail_product_id` int(11) DEFAULT NULL,
  `bill_detail_quantity` int(11) DEFAULT NULL,
  `bill_detail_TypeUnitPrice` int(11) DEFAULT NULL,
  `bill_detail_discount` int(11) DEFAULT NULL,
  `bill_price` decimal(20,0) DEFAULT NULL,
  PRIMARY KEY (`bill_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_detail`
--

LOCK TABLES `bill_detail` WRITE;
/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_prefix` varchar(5) DEFAULT NULL,
  `category_name` varchar(45) DEFAULT NULL,
  `category_group_id` int(11) DEFAULT NULL,
  `category_note` varchar(100) DEFAULT NULL,
  `category_created_date` varchar(45) DEFAULT NULL,
  `category_author_created_id` int(11) DEFAULT NULL,
  `category_last_modified` varchar(45) DEFAULT NULL,
  `category_manager_id` int(11) DEFAULT NULL,
  `category_is_enable` bit(1) DEFAULT NULL,
  `category_isdelete` bit(1) DEFAULT NULL,
  `category_image` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_group`
--

DROP TABLE IF EXISTS `category_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_group` (
  `category_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_group_prefix` varchar(5) DEFAULT NULL,
  `category_group_name` varchar(50) DEFAULT NULL,
  `category_group_note` varchar(200) DEFAULT NULL,
  `category_groupcategory_group_created_date` varchar(45) DEFAULT NULL,
  `category_group_manager_id` int(11) DEFAULT NULL,
  `category_group_is_enable` bit(1) DEFAULT NULL,
  `category_group_image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`category_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_group`
--

LOCK TABLES `category_group` WRITE;
/*!40000 ALTER TABLE `category_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_prefix` varchar(5) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `customer_address` varchar(200) DEFAULT NULL,
  `customer_phone` varchar(50) DEFAULT NULL,
  `customer_email` varchar(100) DEFAULT NULL,
  `customer_user_id` int(11) DEFAULT NULL,
  `customer_last_messaged` varchar(45) DEFAULT NULL,
  `customer_gender` bit(1) DEFAULT NULL,
  `customer_birthdate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import`
--

DROP TABLE IF EXISTS `import`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `import` (
  `import_id` int(11) NOT NULL AUTO_INCREMENT,
  `import_prefix` varchar(5) DEFAULT NULL,
  `import_provider_id` int(11) DEFAULT NULL,
  `import_user_import_id` int(11) DEFAULT NULL,
  `import_date_imported` varchar(45) DEFAULT NULL,
  `import_payment` varchar(45) DEFAULT NULL,
  `import_advance_payment` decimal(15,0) DEFAULT NULL,
  `import_owe` decimal(15,0) DEFAULT NULL,
  PRIMARY KEY (`import_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import`
--

LOCK TABLES `import` WRITE;
/*!40000 ALTER TABLE `import` DISABLE KEYS */;
/*!40000 ALTER TABLE `import` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_detail`
--

DROP TABLE IF EXISTS `import_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `import_detail` (
  `import_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `import_id` int(11) DEFAULT NULL,
  `import_detail_product_id` int(11) DEFAULT NULL,
  `import_detail_quantity` int(11) DEFAULT NULL,
  `import_detail_price` decimal(15,0) DEFAULT NULL,
  PRIMARY KEY (`import_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_detail`
--

LOCK TABLES `import_detail` WRITE;
/*!40000 ALTER TABLE `import_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `import_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `permission_id` tinyint(10) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(45) DEFAULT NULL,
  `permission_description` varchar(100) DEFAULT NULL,
  `permission_date_created` varchar(45) DEFAULT NULL,
  `permission_is_enable` bit(1) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'admin','admin permission','27-01-2017',''),(2,'user','permission for user, can view, can order ... but can\'t edit','27-01-2017',''),(3,'staff','staff permission','27-01-2017','');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_prefix` varchar(5) DEFAULT NULL,
  `product_name` varchar(50) DEFAULT NULL,
  `product_status` bit(1) DEFAULT NULL,
  `product_category_id` int(11) DEFAULT NULL,
  `product_quantity` int(11) DEFAULT NULL,
  `product_origin_price` decimal(20,0) DEFAULT NULL,
  `product_price2` decimal(20,0) DEFAULT NULL,
  `product_price3` decimal(20,0) DEFAULT NULL,
  `product_price_discount` tinyint(10) DEFAULT NULL,
  `product_imported_date` varchar(45) DEFAULT NULL,
  `product_last_modified` varchar(45) DEFAULT NULL,
  `product_specification` text,
  `product_note` varchar(100) DEFAULT NULL,
  `product_warranty_time` int(11) DEFAULT NULL,
  `product_provider_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider`
--

DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provider` (
  `provider_id` int(11) NOT NULL AUTO_INCREMENT,
  `provider_prefix` varchar(5) DEFAULT NULL,
  `provider_name` varchar(50) DEFAULT NULL,
  `provider_address` varchar(100) DEFAULT NULL,
  `provider_note` varchar(300) DEFAULT NULL,
  `provider_phone` varchar(45) DEFAULT NULL,
  `provider_homephone` varchar(45) DEFAULT NULL,
  `provider_taxcode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`provider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider`
--

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_prefix` varchar(5) DEFAULT NULL,
  `user_username` varchar(100) DEFAULT NULL,
  `user_password` varchar(100) DEFAULT NULL,
  `user_address` varchar(200) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_birthdate` varchar(45) DEFAULT NULL,
  `user_Lastlogined` varchar(45) DEFAULT NULL,
  `user_isLogined` bit(1) DEFAULT NULL,
  `user_gender` bit(1) DEFAULT NULL,
  `user_note` varchar(200) DEFAULT NULL,
  `user_permission_id` tinyint(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'admin','admin',NULL,'aceonlinevn@gmail.com',NULL,NULL,'\0',NULL,NULL,1),(2,NULL,'hoanghiep','hoanghiep',NULL,'hoanghiephaui@gmail.com',NULL,NULL,'\0',NULL,NULL,1),(3,NULL,'user','user','Tu liem - Ha Noi',NULL,'20-01-1995',NULL,'\0',NULL,NULL,2),(4,NULL,'staff','staff','Tu liem - Ha Noi',NULL,NULL,NULL,'\0',NULL,NULL,3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-01 10:08:24
