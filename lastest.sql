-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: jj
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

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
-- Table structure for table `batch_product_rs`
--

DROP TABLE IF EXISTS `batch_product_rs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batch_product_rs` (
  `batch_product_rs_id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_id` int(11) NOT NULL,
  `product_sub_option_id` int(11) NOT NULL,
  `unit_cost` decimal(6,2) DEFAULT NULL,
  `qty` int(11) NOT NULL DEFAULT '0',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`batch_product_rs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_product_rs`
--

LOCK TABLES `batch_product_rs` WRITE;
/*!40000 ALTER TABLE `batch_product_rs` DISABLE KEYS */;
INSERT INTO `batch_product_rs` VALUES (23,18,22,5.00,10,0,'euphona','2016-12-05 22:59:10','euphona','2016-12-05 22:59:10','Y'),(24,18,23,3.00,10,0,'euphona','2016-12-05 23:00:00','euphona','2016-12-05 23:00:00','Y'),(25,18,23,6.00,10,0,'euphona','2016-12-05 23:00:00','euphona','2016-12-05 23:00:00','Y'),(26,18,23,2.00,20,0,'euphona','2016-12-05 23:03:37','euphona','2016-12-05 23:03:37','N'),(27,18,23,2.00,20,0,'euphona','2016-12-05 23:03:37','euphona','2016-12-05 23:03:37','N'),(28,18,23,2.00,20,0,'euphona','2016-12-05 23:03:37','euphona','2016-12-05 23:03:37','N'),(29,18,22,2.00,20,0,'euphona','2016-12-05 23:03:37','euphona','2016-12-05 23:03:37','N'),(30,18,23,2.00,15,0,'euphona','2016-12-05 23:03:37','euphona','2016-12-05 23:03:37','N'),(31,19,22,4.00,53,0,'euphona','2016-12-05 23:10:51','euphona','2016-12-05 23:10:51','Y'),(32,19,23,60.00,79,0,'euphona','2016-12-05 23:13:05','euphona','2016-12-05 23:13:05','Y'),(33,19,22,4.00,345,0,'euphona','2016-12-05 23:13:05','euphona','2016-12-05 23:13:05','Y'),(34,20,22,3.00,3,0,'euphona','2016-12-06 22:41:53','euphona','2016-12-06 22:41:53','N'),(35,22,41,3.00,2,0,'euphona','2016-12-30 15:17:22','euphona','2016-12-30 16:02:53','Y'),(36,22,42,2.00,1,0,'euphona','2016-12-30 15:17:22','euphona','2016-12-30 16:06:40','N'),(37,22,41,2.00,1,0,'euphona','2016-12-30 16:04:58','euphona','2016-12-30 16:04:58','Y'),(38,23,41,10.00,2,0,'euphona','2017-01-16 22:25:56','euphona','2017-01-18 22:42:40','N'),(39,23,43,3.00,3,0,'euphona','2017-01-16 22:25:56','euphona','2017-01-18 22:42:40','N'),(40,24,44,5.00,2,0,'euphona','2017-01-18 22:52:51','euphona','2017-01-18 22:59:48','Y'),(41,24,41,3.00,1,0,'euphona','2017-01-18 22:52:51','euphona','2017-01-18 22:59:48','Y'),(42,25,41,5.00,1,0,'euphona','2017-01-18 23:03:59','euphona','2017-01-18 23:06:34','Y'),(43,25,45,2.00,7,0,'euphona','2017-01-18 23:03:59','euphona','2017-01-18 23:07:46','Y'),(44,25,46,3.00,1,0,'euphona','2017-01-18 23:06:38','euphona','2017-01-18 23:18:16','Y'),(45,25,47,5.00,1,0,'euphona','2017-01-18 23:14:12','euphona','2017-01-18 23:14:12','Y'),(46,25,48,5.00,2,0,'euphona','2017-01-18 23:18:19','euphona','2017-01-18 23:18:40','Y'),(47,25,49,5.00,4,0,'euphona','2017-01-18 23:24:01','euphona','2017-01-18 23:24:01','Y'),(48,25,41,10.00,10,0,'euphona','2017-01-19 20:36:50','euphona','2017-01-19 20:36:50','Y'),(49,25,50,4.00,2,0,'euphona','2017-01-19 20:36:50','euphona','2017-01-19 20:36:50','Y'),(50,25,51,3.00,6,0,'euphona','2017-01-19 20:36:50','euphona','2017-01-19 20:36:50','Y');
/*!40000 ALTER TABLE `batch_product_rs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batch_stock_intake`
--

DROP TABLE IF EXISTS `batch_stock_intake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batch_stock_intake` (
  `batch_id` int(11) NOT NULL AUTO_INCREMENT,
  `remarks` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `storage_location` int(11) NOT NULL,
  `total_cost` decimal(8,2) NOT NULL DEFAULT '0.00',
  `additional_cost` decimal(6,2) DEFAULT '0.00',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`batch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_stock_intake`
--

LOCK TABLES `batch_stock_intake` WRITE;
/*!40000 ALTER TABLE `batch_stock_intake` DISABLE KEYS */;
INSERT INTO `batch_stock_intake` VALUES (18,'batch for getting bulbs','2016-11-05 00:00:00',1,500.00,310.00,0,'euphona','2016-12-05 23:08:35','euphona','2016-12-05 23:08:35','N'),(19,'tesrtih','2018-01-05 00:00:00',1,500.00,-5620.00,0,'euphona','2016-12-05 23:13:05','euphona','2016-12-05 23:13:05','Y'),(20,'test warehouse','2016-12-06 00:00:00',1,23.00,14.00,0,'euphona','2016-12-06 22:48:43','euphona','2016-12-06 22:48:43','N'),(21,'Batch','2016-12-30 00:00:00',1,20.00,8.00,0,'euphona','2016-12-30 15:14:29','euphona','2016-12-30 15:14:29','N'),(22,'Batch','2016-12-30 00:00:00',1,10.00,8.00,0,'euphona','2016-12-30 15:17:22','euphona','2016-12-30 16:06:40','N'),(23,'testshit','2017-01-16 00:00:00',2,30.00,1.00,0,'euphona','2017-01-16 22:25:55','euphona','2017-01-18 22:44:31','N'),(24,'difficult','2017-01-18 00:00:00',3,30.00,17.00,0,'euphona','2017-01-18 22:52:51','euphona','2017-01-18 23:01:27','Y'),(25,'bloated','2017-01-18 00:00:00',2,150.00,24.00,0,'euphona','2017-01-18 23:03:59','euphona','2017-01-19 20:36:50','Y');
/*!40000 ALTER TABLE `batch_stock_intake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheque`
--

DROP TABLE IF EXISTS `cheque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheque` (
  `cheque_id` int(11) NOT NULL AUTO_INCREMENT,
  `cheque_num` varchar(45) NOT NULL,
  `cheque_date` date NOT NULL,
  `cheque_amt` decimal(8,2) NOT NULL DEFAULT '0.00',
  `debit_date` date DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `bounce_cheque_ind` char(1) NOT NULL DEFAULT 'N',
  `bounce_date` date DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`cheque_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheque`
--

LOCK TABLES `cheque` WRITE;
/*!40000 ALTER TABLE `cheque` DISABLE KEYS */;
INSERT INTO `cheque` VALUES (1,'100-100-111','2017-02-24',725.00,NULL,'test','Y','2016-10-10',1,'ck1232','2017-03-28 23:50:15','euphona','2017-04-22 20:13:48','N'),(2,'400-400','2017-03-27',500.00,NULL,NULL,'Y','2017-03-31',1,'ck1232','2017-03-28 23:52:51','ck1232','2017-03-28 23:52:51','N'),(3,'211-211','2016-06-24',7.00,NULL,NULL,'Y','2017-04-12',1,'euphona','2017-03-28 23:52:51','euphona','2017-04-22 21:09:39','N'),(4,'300-300','2017-03-27',3310.00,NULL,NULL,'Y','2017-04-07',1,'euphona','2017-03-28 23:52:51','euphona','2017-03-28 23:52:51','N'),(5,'500-500','2017-03-27',13079.00,NULL,NULL,'N',NULL,1,'euphona','2017-03-28 23:52:51','euphona','2017-03-28 23:52:51','N'),(6,'600-600','2017-03-27',10.00,NULL,NULL,'N',NULL,1,'euphona','2017-03-28 23:52:51','euphona','2017-03-28 23:52:51','N'),(7,'700-700','2017-03-27',2500.00,NULL,NULL,'Y','2017-03-31',1,'euphona','2017-03-28 23:52:51','euphona','2017-03-28 23:52:51','N'),(8,'111-111-1111-111','2017-04-19',100.00,NULL,NULL,'N',NULL,1,'euphona','2017-04-06 23:52:39','euphona','2017-04-06 23:52:39','N'),(10,'5784','2017-04-12',33.83,NULL,NULL,'N',NULL,1,'euphona','2017-04-14 14:41:35','euphona','2017-04-14 14:41:35','N'),(11,'2222','2017-04-19',50.00,NULL,NULL,'Y',NULL,1,'euphona','2017-04-16 22:44:38','euphona','2017-04-16 22:44:38','N'),(14,'111-111-2311-111','2017-04-12',25.00,'2017-04-01','remark','N',NULL,1,'euphona','2017-04-19 21:54:35','euphona','2017-04-22 20:34:33','N'),(15,'4324222','2017-04-27',100.00,NULL,NULL,'N',NULL,1,'euphona','2017-04-19 22:12:41','euphona','2017-04-19 22:12:41','N'),(16,'111-111-2311-111','2017-04-19',209.00,NULL,NULL,'N',NULL,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(17,'122-111-2311-111','2017-04-19',100.00,NULL,NULL,'N',NULL,1,'euphona','2017-04-21 23:31:07','euphona','2017-04-21 23:31:07','N'),(18,'301-301','2017-04-08',2500.00,NULL,NULL,'N',NULL,1,'euphona','2017-04-23 22:36:59','euphona','2017-04-23 22:36:59','N');
/*!40000 ALTER TABLE `cheque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `gender` char(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `dob` date DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `is_active` char(1) NOT NULL DEFAULT 'Y',
  `user_id` varchar(255) NOT NULL,
  `password` varchar(256) NOT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'F','Lee Jia Cin Janice','2016-11-30','euphona@hotmail.com','0','euphona','12345',1,'Janice','2016-11-09 19:29:00','Janice','2016-11-09 19:29:00','N');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_address`
--

DROP TABLE IF EXISTS `customer_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `recipient_name` varchar(255) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `contact_number` bigint(10) DEFAULT NULL,
  `postal_code` int(8) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `default_ind` char(1) NOT NULL DEFAULT 'N',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_address`
--

LOCK TABLES `customer_address` WRITE;
/*!40000 ALTER TABLE `customer_address` DISABLE KEYS */;
INSERT INTO `customer_address` VALUES (1,1,'CK111','Blk 252 #02-390 Pending Road Singapore 670252',93273252,670255,'Singapore','N',1,'Janice','2016-11-09 19:29:00','Janice','2016-11-09 19:29:00','Y');
/*!40000 ALTER TABLE `customer_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_fee`
--

DROP TABLE IF EXISTS `delivery_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_fee` (
  `delivery_fee_id` int(11) NOT NULL,
  `weight` int(11) NOT NULL DEFAULT '0',
  `price` decimal(6,2) NOT NULL DEFAULT '0.00',
  `sequence` int(11) DEFAULT NULL,
  `carrier_type` varchar(255) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`delivery_fee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_fee`
--

LOCK TABLES `delivery_fee` WRITE;
/*!40000 ALTER TABLE `delivery_fee` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discount` (
  `discount_id` int(11) NOT NULL AUTO_INCREMENT,
  `promo_id` int(11) DEFAULT NULL,
  `discount_name` varchar(255) DEFAULT NULL,
  `discount_type` varchar(100) DEFAULT NULL,
  `discount_value` decimal(6,2) NOT NULL DEFAULT '0.00',
  `apply_type` varchar(255) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (1,NULL,'5 % discount','Percentage %',5.00,'Delivery',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(2,3,'4%','Percentage %',4.00,'Total',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N');
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `employee_type` varchar(255) NOT NULL,
  `dob` date DEFAULT NULL,
  `nationality` varchar(255) NOT NULL,
  `basic_salary` decimal(8,2) NOT NULL DEFAULT '0.00',
  `employment_start_date` date DEFAULT NULL,
  `employment_end_date` date DEFAULT NULL,
  `cdac_ind` char(1) NOT NULL DEFAULT 'N',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Beh Choon Keat','FULL_LOCAL','1990-05-19','Singapor',2500.00,'2017-03-13',NULL,'Y',1,'euphona','2017-03-12 22:34:53','euphona','2017-06-08 20:29:18','N'),(2,'test','FULL_FW',NULL,'Malaysia',1000.00,NULL,NULL,'Y',0,'euphona','2017-03-12 22:36:58','euphona','2017-03-12 22:37:04','Y'),(3,'Father1','FULL_LOCAL','2017-03-01','Singaporean',2600.00,'2017-03-23',NULL,'Y',1,'ck1232','2017-03-28 21:38:29','ck1232','2017-03-28 21:53:31','Y');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_bonus`
--

DROP TABLE IF EXISTS `employee_bonus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_bonus` (
  `bonus_id` int(11) NOT NULL AUTO_INCREMENT,
  `bonus_date` date NOT NULL,
  `employee_id` int(11) NOT NULL,
  `bonus_amt` decimal(8,2) NOT NULL DEFAULT '0.00',
  `employee_cpf` decimal(6,2) DEFAULT NULL,
  `employer_cpf` decimal(6,2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`bonus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_bonus`
--

LOCK TABLES `employee_bonus` WRITE;
/*!40000 ALTER TABLE `employee_bonus` DISABLE KEYS */;
INSERT INTO `employee_bonus` VALUES (1,'2017-03-08',1,1000.00,600.00,123.00,'UNPAID',1,'ck1232','2017-03-28 22:14:03','ck1232','2017-03-28 22:14:03','N'),(2,'2017-03-23',1,100.00,10.00,20.00,'PAID',2,'ck1232','2017-03-28 22:20:49','euphona','2017-04-25 23:05:20','N'),(3,'2017-04-26',1,100.00,20.00,20.00,'PAID',2,'euphona','2017-04-06 23:52:12','euphona','2017-04-06 23:52:49','N');
/*!40000 ALTER TABLE `employee_bonus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_salary`
--

DROP TABLE IF EXISTS `employee_salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_salary` (
  `salary_id` int(11) NOT NULL AUTO_INCREMENT,
  `salary_date` date NOT NULL,
  `employee_id` int(11) NOT NULL,
  `basic_salary_amt` decimal(8,2) NOT NULL DEFAULT '0.00',
  `over_time_amt` decimal(6,2) DEFAULT NULL,
  `over_time_hours` decimal(6,2) DEFAULT NULL,
  `over_time_remarks` varchar(512) DEFAULT NULL,
  `allowance` decimal(6,2) DEFAULT NULL,
  `medical` decimal(6,2) DEFAULT NULL,
  `leave_balance` decimal(5,2) DEFAULT NULL,
  `leave_taken` decimal(5,2) DEFAULT NULL,
  `unpaid_leave_amt` decimal(6,2) DEFAULT NULL,
  `unpaid_leave_remarks` varchar(512) DEFAULT NULL,
  `employee_cpf` decimal(8,2) DEFAULT NULL,
  `employer_cpf` decimal(8,2) DEFAULT NULL,
  `cdac_amt` decimal(6,2) DEFAULT NULL,
  `sdl_amt` decimal(6,2) DEFAULT NULL,
  `fw_levy` decimal(6,2) DEFAULT NULL,
  `status` varchar(255) NOT NULL DEFAULT 'UNPAID',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`salary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_salary`
--

LOCK TABLES `employee_salary` WRITE;
/*!40000 ALTER TABLE `employee_salary` DISABLE KEYS */;
INSERT INTO `employee_salary` VALUES (1,'2017-03-13',1,2500.00,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,'PAID',1,'euphona','2017-03-13 13:23:49','euphona','2017-04-23 23:43:32','N'),(2,'2017-02-08',1,2500.00,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,'PAID',0,'euphona','2017-03-13 15:58:37','euphona','2017-03-13 17:57:21','N'),(3,'2017-03-08',1,1000.00,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,'',20.50,NULL,NULL,NULL,NULL,'UNPAID',1,'ck1232','2017-03-28 22:16:41','ck1232','2017-03-28 22:16:41','Y'),(4,'2017-03-08',1,2500.00,1.00,1.00,'1',1.00,5.00,14.00,1.00,1.00,'1',NULL,50.00,1.00,1.00,1.00,'PAID',1,'ck1232','2017-03-28 22:20:06','euphona','2017-04-25 23:05:20','N');
/*!40000 ALTER TABLE `employee_salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense`
--

DROP TABLE IF EXISTS `expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expense` (
  `expense_id` int(11) NOT NULL AUTO_INCREMENT,
  `expense_type_id` int(11) NOT NULL,
  `invoice_no` varchar(255) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  `expense_date` date NOT NULL,
  `supplier` varchar(255) NOT NULL,
  `total_amt` decimal(8,2) NOT NULL DEFAULT '0.00',
  `remarks` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL DEFAULT 'UNPAID',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`expense_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense`
--

LOCK TABLES `expense` WRITE;
/*!40000 ALTER TABLE `expense` DISABLE KEYS */;
INSERT INTO `expense` VALUES (1,2,'','desc','2017-03-15','supplier',20.00,'remarks','PAID',0,'euphona','2017-03-05 17:02:51','euphona','2017-03-06 22:27:53','N'),(2,1,'','','2017-02-05','supplier',10.00,'remarks','PAID',1,'euphona','2017-03-05 21:54:05','euphona','2017-04-23 22:00:33','N'),(3,1,'','desc','2016-03-05','supplier',5.00,'remarks','PAID',1,'euphona','2017-03-05 21:54:51','euphona','2017-04-23 22:00:33','N'),(4,1,'','desc','2017-03-30','supplier',5.00,'remarks','UNPAID',0,'euphona','2017-03-05 21:55:51','euphona','2017-03-05 21:55:51','N'),(5,6,'','','2017-03-14','LTA',20.00,'remarks','PAID',0,'euphona','2017-03-06 22:27:20','euphona','2017-03-07 22:54:27','N'),(6,9,'','desc','2017-03-07','equip pte ltd',100.00,'remarks','PAID',1,'euphona','2017-03-09 22:30:13','euphona','2017-04-21 23:31:07','N'),(7,13,'','desc','2017-03-07','supplier',100.00,'remarks','UNPAID',0,'euphona','2017-03-09 22:31:03','euphona','2017-03-09 22:31:03','N'),(8,9,'','desc','2017-03-15','supplier',100.00,'remarks','UNPAID',0,'euphona','2017-03-09 22:33:30','euphona','2017-03-09 22:33:30','N'),(9,7,'','desc','2017-03-14','supplier',100.00,'remarks','PAID',1,'euphona','2017-03-09 22:42:24','euphona','2017-04-19 21:54:35','N'),(10,5,'','desc','2017-03-14','supplier',100.00,'remarks','UNPAID',0,'euphona','2017-03-09 22:45:52','euphona','2017-03-09 22:45:52','N'),(11,10,'','desc','2017-03-09','supplier',100.00,'remarks','PAID',0,'euphona','2017-03-09 22:49:47','euphona','2017-03-09 22:50:00','N'),(12,15,'','from china','2017-03-16','dasdas',2000.00,'remarks','UNPAID',0,'euphona','2017-03-09 22:53:32','euphona','2017-03-09 22:53:32','N'),(13,15,'','dasdas','2017-03-21','adsda',20.00,'remarks','PAID',0,'euphona','2017-03-09 22:53:49','euphona','2017-03-09 23:22:49','N'),(14,15,'','For paying china stock','2017-01-01','china supplier',999999.00,'For paying china stock','UNPAID',1,'ck1232','2017-03-28 22:28:59','euphona','2017-04-23 23:40:17','N'),(15,9,'','','2017-03-29','supplier',1000.00,'remarks','UNPAID',1,'euphona','2017-03-29 22:08:08','euphona','2017-03-29 22:08:08','Y'),(16,12,'','desc','2017-04-19','supplier',100.00,'remarks','PAID',1,'euphona','2017-04-16 22:43:56','euphona','2017-04-23 23:27:06','N');
/*!40000 ALTER TABLE `expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_type`
--

DROP TABLE IF EXISTS `expense_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expense_type` (
  `expense_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `expense_type` varchar(255) NOT NULL,
  PRIMARY KEY (`expense_type_id`),
  UNIQUE KEY `expense_type_UNIQUE` (`expense_type`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_type`
--

LOCK TABLES `expense_type` WRITE;
/*!40000 ALTER TABLE `expense_type` DISABLE KEYS */;
INSERT INTO `expense_type` VALUES (9,'Asset-Equipment'),(10,'Asset-Vehicle'),(13,'Entertainment'),(14,'Fees and Taxes'),(12,'Meal Expenses'),(8,'Office Expenses'),(11,'Rent Expenses'),(1,'Stock'),(15,'Stock(China)'),(2,'Sub-Con'),(6,'Vehicle-Car Parking and ERP'),(3,'Vehicle-Fuel'),(7,'Vehicle-Insurance'),(5,'Vehicle-Repair'),(4,'Vehicle-Road Tax');
/*!40000 ALTER TABLE `expense_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `inventory_from`
--

DROP TABLE IF EXISTS `inventory_from`;
/*!50001 DROP VIEW IF EXISTS `inventory_from`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `inventory_from` AS SELECT 
 1 AS `product_suboption_rs_id`,
 1 AS `transfer_from`,
 1 AS `qty`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `inventory_location_final_qty`
--

DROP TABLE IF EXISTS `inventory_location_final_qty`;
/*!50001 DROP VIEW IF EXISTS `inventory_location_final_qty`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `inventory_location_final_qty` AS SELECT 
 1 AS `product_suboption_rs_id`,
 1 AS `location_id`,
 1 AS `qty`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `inventory_location_qty`
--

DROP TABLE IF EXISTS `inventory_location_qty`;
/*!50001 DROP VIEW IF EXISTS `inventory_location_qty`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `inventory_location_qty` AS SELECT 
 1 AS `product_suboption_rs_id`,
 1 AS `location_id`,
 1 AS `to_qty`,
 1 AS `from_qty`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `inventory_to`
--

DROP TABLE IF EXISTS `inventory_to`;
/*!50001 DROP VIEW IF EXISTS `inventory_to`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `inventory_to` AS SELECT 
 1 AS `product_suboption_rs_id`,
 1 AS `transfer_to`,
 1 AS `qty`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `messenger` varchar(255) NOT NULL,
  `invoice_date` date NOT NULL,
  `total_amt` decimal(8,2) NOT NULL DEFAULT '0.00',
  `status` varchar(255) NOT NULL DEFAULT 'UNPAID',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6275 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (5354,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2015-03-01',3310.00,'PAID',1,'ck1232','2017-02-27 22:33:50','euphona','2017-04-23 22:36:59','N'),(6246,'mu interior pte ltd','2017-01-05',415.00,'PAID',1,'ck1232','2017-03-01 00:07:42','euphona','2017-04-23 22:36:59','N'),(6247,'WJM FURNITURE PTE LTD','2017-01-07',541.00,'PAID',1,'ck1232','2017-02-26 23:49:19','euphona','2017-04-23 22:36:59','N'),(6248,'Kar Lee Electrical Engineering ','2017-01-09',946.00,'PAID',0,'ck1232','2017-02-27 21:58:49','euphona','2017-03-07 20:51:30','N'),(6249,'JAMES KING PTE LTD','2017-01-14',13079.00,'PAID',0,'ck1232','2017-02-27 21:59:31','euphona','2017-03-07 22:51:01','N'),(6250,'mu interior pte ltd','2017-01-16',800.00,'PAID',0,'ck1232','2017-02-27 22:00:03','euphona','2017-03-07 22:51:01','N'),(6251,'mu interior pte ltd','2017-01-18',540.00,'PAID',1,'ck1232','2017-02-27 21:59:51','ck1232','2017-03-28 23:36:09','N'),(6252,'mu interior pte ltd','2017-02-02',725.00,'PAID',2,'ck1232','2017-02-27 22:00:03','euphona','2017-04-23 23:33:40','N'),(6253,'Liberty Furniture Pte Ltd','2017-01-24',2530.00,'PAID',1,'ck1232','2017-02-26 23:49:19','euphona','2017-04-14 14:31:21','N'),(6254,'ASTIQUE DESIGN PTE LTD','2017-01-13',90.00,'PENDING',0,'ck1232','2017-02-26 23:49:19','ck1232','2017-03-01 00:08:31','Y'),(6255,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2017-01-02',1370.00,'PAID',1,'ck1232','2017-02-26 23:49:19','euphona','2017-04-19 22:27:52','N'),(6256,'JAMES KING PTE LTD','2017-02-02',209.00,'PAID',1,'ck1232','2017-02-27 22:00:03','euphona','2017-04-19 22:19:13','N'),(6257,'Precise International Pte Ltd','2017-02-02',200.00,'PAID',1,'ck1232','2017-02-27 22:08:43','euphona','2017-04-19 22:19:13','N'),(6258,'Precise International Pte Ltd','2017-02-03',200.00,'PAID',1,'ck1232','2017-02-27 22:07:09','euphona','2017-04-19 22:19:13','N'),(6259,'Precise International Pte Ltd','2017-02-03',200.00,'PAID',1,'ck1232','2017-02-27 22:08:43','euphona','2017-04-19 22:19:13','N'),(6260,'Precise International Pte Ltd','2017-02-03',400.00,'PAID',1,'ck1232','2017-02-27 22:08:43','euphona','2017-04-19 22:27:52','N'),(6261,'Precise International Pte Ltd','2017-02-09',100.00,'PAID',1,'ck1232','2017-02-27 22:08:43','euphona','2017-04-19 22:29:54','N'),(6262,'Precise International Pte Ltd','2017-02-10',1170.00,'PAID',1,'ck1232','2017-02-27 22:08:43','euphona','2017-04-19 22:29:54','N'),(6263,'Precise International Pte Ltd','2017-02-10',1480.00,'PENDING',0,'ck1232','2017-02-27 22:08:43','ck1232','2017-03-01 00:08:31','Y'),(6264,'Precise International Pte Ltd','2017-02-10',5270.00,'PENDING',0,'ck1232','2017-02-27 22:08:43','ck1232','2017-03-01 00:08:31','N'),(6265,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2017-01-06',124.00,'PENDING',0,'ck1232','2017-02-26 23:49:19','ck1232','2017-03-01 00:08:31','N'),(6266,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2017-01-07',220.00,'PENDING',0,'ck1232','2017-02-26 23:49:19','ck1232','2017-03-01 00:08:31','N'),(6267,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2017-01-09',118.00,'PENDING',0,'ck1232','2017-02-26 23:49:19','ck1232','2017-03-01 00:08:31','N'),(6268,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2017-01-10',60.00,'PENDING',0,'ck1232','2017-02-27 22:13:02','ck1232','2017-03-01 00:08:31','N'),(6269,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2017-01-11',67.00,'PENDING',0,'ck1232','2017-02-26 23:49:19','ck1232','2017-03-01 00:08:31','N'),(6270,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2017-01-12',66.00,'PENDING',0,'ck1232','2017-02-27 22:13:02','ck1232','2017-03-01 00:08:31','N'),(6271,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2017-01-21',187.00,'PENDING',0,'ck1232','2017-02-26 23:49:19','ck1232','2017-03-01 00:08:31','N'),(6272,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2017-01-22',60.00,'PENDING',0,'ck1232','2017-02-27 22:13:59','ck1232','2017-03-01 00:08:31','N'),(6273,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2017-01-17',50.00,'PENDING',0,'ck1232','2017-02-26 23:49:19','ck1232','2017-03-01 00:08:31','N'),(6274,'WOODHOUSE FURNITURE & CONSTRUCTION PTE LTD','2017-02-09',170.00,'PENDING',0,'ck1232','2017-02-26 23:49:19','ck1232','2017-03-01 00:08:31','N');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_grant`
--

DROP TABLE IF EXISTS `invoice_grant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_grant` (
  `grant_id` int(11) NOT NULL AUTO_INCREMENT,
  `organisation` varchar(255) NOT NULL,
  `grant_date` date NOT NULL,
  `total_amt` decimal(8,2) NOT NULL,
  `status` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  `version` int(5) NOT NULL DEFAULT '1',
  PRIMARY KEY (`grant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_grant`
--

LOCK TABLES `invoice_grant` WRITE;
/*!40000 ALTER TABLE `invoice_grant` DISABLE KEYS */;
INSERT INTO `invoice_grant` VALUES (1,'IRAS','2017-01-05',533.83,'PAID','euphona','2017-03-01 00:07:42','euphona','2017-04-14 14:41:35','N',2),(2,'ck','2017-04-26',300.00,'PAID','euphona','2017-04-14 15:16:49','euphona','2017-04-19 22:12:42','N',2),(3,'janice','2017-04-27',5000.00,'PAID','euphona','2017-04-14 15:23:33','euphona','2017-04-19 22:26:50','N',2),(4,'janice','2017-04-27',600.00,'PAID','euphona','2017-04-14 15:25:11','euphona','2017-04-14 15:25:41','N',2),(5,'IRAS','2017-04-20',200.00,'PENDING','euphona','2017-04-21 22:49:56','euphona','2017-04-21 22:49:56','Y',1);
/*!40000 ALTER TABLE `invoice_grant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_items`
--

DROP TABLE IF EXISTS `menu_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_items` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `display_ind` char(1) NOT NULL DEFAULT 'N',
  `parent_id` int(11) DEFAULT NULL,
  `href` varchar(512) DEFAULT NULL,
  `sequence` int(3) NOT NULL DEFAULT '0',
  `version` int(5) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_items`
--

LOCK TABLES `menu_items` WRITE;
/*!40000 ALTER TABLE `menu_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(255) NOT NULL,
  `icon` varchar(45) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES (1,'Admin Management','fa-users',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(5,'Product management','fa-users',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(6,'Promotion Management','fa-users',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(7,'Customer Management','fa-users',1,'euphona','2016-11-15 21:23:46','euphona','2016-11-15 21:23:46','N'),(8,'Batch Management','fa-users',1,'euphona','2016-11-26 20:11:59','euphona','2016-11-26 20:11:59','N'),(9,'Inventory Management','fa-users',1,'euphona','2017-01-05 21:16:30','euphona','2017-01-05 21:16:30','N'),(10,'Demo Management','fa-users',1,'euphona','2017-02-25 16:39:47','euphona','2017-02-25 16:39:47','N'),(11,'Invoice Management','fa-users',1,'euphona','2017-02-27 10:31:46','euphona','2017-02-27 10:31:53','N'),(12,'Expense Management','fa-users',1,'euphona','2017-03-05 15:47:20','euphona','2017-03-05 15:47:20','N'),(13,'Salary & Bonus Management','fa-users',1,'euphona','2017-03-11 10:52:41','euphona','2017-03-11 22:42:22','N'),(14,'Employee Management','fa-users',1,'euphona','2017-03-12 17:44:25','euphona','2017-03-12 17:44:25','N'),(15,'Cheque Management','fa-users',1,'euphona','2017-04-05 21:45:02','euphona','2017-04-05 21:45:02','N'),(16,'Report Management','fa-users',1,'euphona','2017-04-07 21:58:46','euphona','2017-04-07 21:58:46','N');
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_detail`
--

DROP TABLE IF EXISTS `payment_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_detail` (
  `payment_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_date` date NOT NULL,
  `payment_mode` int(11) NOT NULL,
  `payment_amt` decimal(8,2) NOT NULL DEFAULT '0.00',
  `cheque_id` varchar(45) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`payment_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_detail`
--

LOCK TABLES `payment_detail` WRITE;
/*!40000 ALTER TABLE `payment_detail` DISABLE KEYS */;
INSERT INTO `payment_detail` VALUES (3,'2017-03-05',1,8.00,NULL,0,'euphona','2017-03-06 20:53:10','euphona','2017-03-06 20:53:10','N'),(4,'2017-03-06',2,7.00,'3',0,'euphona','2017-03-06 20:53:27','euphona','2017-03-06 20:53:27','N'),(5,'2017-03-08',1,10.00,NULL,0,'euphona','2017-03-06 22:24:18','euphona','2017-03-06 22:24:18','N'),(6,'2017-03-07',1,956.00,NULL,0,'euphona','2017-03-07 20:41:47','euphona','2017-03-07 20:41:47','N'),(7,'2017-03-07',2,3310.00,'4',0,'euphona','2017-03-07 20:41:47','euphona','2017-03-07 20:41:47','N'),(8,'2017-03-07',1,946.00,NULL,0,'euphona','2017-03-07 20:51:30','euphona','2017-03-07 20:51:30','N'),(9,'2017-03-13',1,800.00,NULL,0,'euphona','2017-03-07 22:51:00','euphona','2017-03-07 22:51:00','N'),(10,'2017-03-13',2,13079.00,'5',0,'euphona','2017-03-07 22:51:00','euphona','2017-03-07 22:51:00','N'),(11,'2017-03-14',1,10.00,NULL,0,'euphona','2017-03-07 22:54:27','euphona','2017-03-07 22:54:27','N'),(12,'2017-03-14',2,10.00,'6',0,'euphona','2017-03-07 22:54:27','euphona','2017-03-07 22:54:27','N'),(13,'2017-03-09',1,100.00,NULL,0,'euphona','2017-03-09 22:50:00','euphona','2017-03-09 22:50:00','N'),(15,'2017-03-28',1,100.00,NULL,0,'euphona','2017-03-09 23:22:49','euphona','2017-03-09 23:22:49','N'),(16,'2017-03-01',2,2500.00,'7',0,'euphona','2017-03-13 16:45:33','euphona','2017-03-13 16:45:33','N'),(18,'2017-03-01',1,2500.00,NULL,0,'euphona','2017-03-13 17:57:18','euphona','2017-03-13 17:57:18','N'),(24,'2017-03-15',1,540.00,NULL,1,'ck1232','2017-03-28 23:36:07','ck1232','2017-03-28 23:36:07','N'),(25,'2017-03-22',2,725.00,'1',1,'ck1232','2017-03-28 23:50:15','ck1232','2017-03-28 23:50:15','N'),(26,'2017-03-15',2,500.00,'2',1,'ck1232','2017-03-28 23:52:51','ck1232','2017-03-28 23:52:51','N'),(27,'2017-04-26',2,100.00,'8',1,'euphona','2017-04-06 23:52:39','euphona','2017-04-06 23:52:39','N'),(28,'2017-04-12',1,2530.00,NULL,1,'euphona','2017-04-14 14:31:21','euphona','2017-04-14 14:31:21','N'),(29,'2017-04-12',1,500.00,NULL,1,'euphona','2017-04-14 14:41:35','euphona','2017-04-14 14:41:35','N'),(30,'2017-04-12',2,33.83,'10',1,'euphona','2017-04-14 14:41:35','euphona','2017-04-14 14:41:35','N'),(31,'2017-04-28',1,600.00,NULL,1,'euphona','2017-04-14 15:25:41','euphona','2017-04-14 15:25:41','N'),(32,'2017-04-19',1,50.00,NULL,1,'euphona','2017-04-16 22:44:38','euphona','2017-04-16 22:44:38','N'),(33,'2017-04-19',2,50.00,'11',1,'euphona','2017-04-16 22:44:38','euphona','2017-04-16 22:44:38','N'),(40,'2017-04-12',1,50.00,NULL,1,'euphona','2017-04-19 21:54:35','euphona','2017-04-19 21:54:35','N'),(41,'2017-04-12',2,25.00,'14',1,'euphona','2017-04-19 21:54:35','euphona','2017-04-19 21:54:35','N'),(42,'2017-04-12',3,25.00,NULL,1,'euphona','2017-04-19 21:54:35','euphona','2017-04-19 21:54:35','N'),(43,'2017-04-27',1,100.00,NULL,1,'euphona','2017-04-19 22:12:41','euphona','2017-04-19 22:12:41','N'),(44,'2017-04-27',2,100.00,'15',1,'euphona','2017-04-19 22:12:41','euphona','2017-04-19 22:12:41','N'),(45,'2017-04-27',5,100.00,NULL,1,'euphona','2017-04-19 22:12:41','euphona','2017-04-19 22:12:41','N'),(46,'2017-04-21',1,400.00,NULL,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(47,'2017-04-21',2,209.00,'16',1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(48,'2017-04-21',5,200.00,NULL,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(49,'2017-04-27',5,5000.00,NULL,1,'euphona','2017-04-19 22:26:49','euphona','2017-04-19 22:26:49','N'),(50,'2017-01-25',1,1770.00,NULL,1,'euphona','2017-04-19 22:27:52','euphona','2017-04-19 22:27:52','N'),(51,'2017-02-09',5,1270.00,NULL,1,'euphona','2017-04-19 22:29:54','euphona','2017-04-19 22:29:54','N'),(52,'2017-04-20',1,500.00,NULL,1,'euphona','2017-04-19 22:32:42','euphona','2017-04-19 22:32:42','N'),(53,'2017-04-20',3,500.00,NULL,1,'euphona','2017-04-19 22:32:42','euphona','2017-04-19 22:32:42','N'),(54,'2017-04-19',2,100.00,'17',1,'euphona','2017-04-21 23:31:07','euphona','2017-04-21 23:31:07','N'),(55,'2017-04-12',3,7.00,NULL,1,'euphona','2017-04-23 22:00:33','euphona','2017-04-23 22:00:33','N'),(56,'2017-04-08',1,810.00,NULL,1,'euphona','2017-04-23 22:36:59','euphona','2017-04-23 22:36:59','N'),(57,'2017-04-08',2,2500.00,'18',1,'euphona','2017-04-23 22:36:59','euphona','2017-04-23 22:36:59','N'),(58,'2017-04-12',1,50.00,NULL,1,'euphona','2017-04-23 23:27:06','euphona','2017-04-23 23:27:06','N'),(59,'2017-04-05',1,725.00,NULL,1,'euphona','2017-04-23 23:33:40','euphona','2017-04-23 23:33:40','N'),(60,'2017-04-21',1,500.00,NULL,1,'euphona','2017-04-23 23:40:17','euphona','2017-04-23 23:40:17','N'),(61,'2017-03-31',1,2500.00,NULL,1,'euphona','2017-04-23 23:43:32','euphona','2017-04-23 23:43:32','N'),(62,'2017-04-19',3,2606.00,NULL,1,'euphona','2017-04-25 23:05:20','euphona','2017-04-25 23:05:20','N'),(63,'2017-04-19',3,2606.00,NULL,1,'euphona','2017-04-25 23:05:20','euphona','2017-04-25 23:05:20','N');
/*!40000 ALTER TABLE `payment_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_mode`
--

DROP TABLE IF EXISTS `payment_mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_mode` (
  `payment_mode_id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_mode` varchar(255) NOT NULL,
  PRIMARY KEY (`payment_mode_id`),
  UNIQUE KEY `payment_mode_UNIQUE` (`payment_mode`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_mode`
--

LOCK TABLES `payment_mode` WRITE;
/*!40000 ALTER TABLE `payment_mode` DISABLE KEYS */;
INSERT INTO `payment_mode` VALUES (4,'Bad Debt'),(1,'Cash'),(2,'Cheque'),(5,'GIRO'),(3,'Pay By Director');
/*!40000 ALTER TABLE `payment_mode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_rs`
--

DROP TABLE IF EXISTS `payment_rs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_rs` (
  `payment_rs_id` int(11) NOT NULL AUTO_INCREMENT,
  `reference_type` varchar(255) NOT NULL,
  `reference_id` int(11) NOT NULL,
  `payment_detail_id` int(11) NOT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`payment_rs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_rs`
--

LOCK TABLES `payment_rs` WRITE;
/*!40000 ALTER TABLE `payment_rs` DISABLE KEYS */;
INSERT INTO `payment_rs` VALUES (1,'expense',2,3,0,'euphona','2017-03-06 20:53:29','euphona','2017-03-06 20:53:29','N'),(2,'expense',3,3,0,'euphona','2017-03-06 20:53:29','euphona','2017-03-06 20:53:29','N'),(3,'expense',2,4,0,'euphona','2017-03-06 20:53:30','euphona','2017-03-06 20:53:30','N'),(4,'expense',3,4,0,'euphona','2017-03-06 20:53:30','euphona','2017-03-06 20:53:30','N'),(5,'expense',1,5,0,'euphona','2017-03-06 22:24:18','euphona','2017-03-06 22:24:18','N'),(6,'invoice',5354,6,0,'euphona','2017-03-07 20:41:47','euphona','2017-03-07 20:41:47','N'),(7,'invoice',6246,6,0,'euphona','2017-03-07 20:41:47','euphona','2017-03-07 20:41:47','N'),(8,'invoice',6247,6,0,'euphona','2017-03-07 20:41:48','euphona','2017-03-07 20:41:48','N'),(9,'invoice',5354,7,0,'euphona','2017-03-07 20:41:48','euphona','2017-03-07 20:41:48','N'),(10,'invoice',6246,7,0,'euphona','2017-03-07 20:41:48','euphona','2017-03-07 20:41:48','N'),(11,'invoice',6247,7,0,'euphona','2017-03-07 20:41:48','euphona','2017-03-07 20:41:48','N'),(12,'invoice',6248,8,0,'euphona','2017-03-07 20:51:30','euphona','2017-03-07 20:51:30','N'),(13,'invoice',6250,9,0,'euphona','2017-03-07 22:51:00','euphona','2017-03-07 22:51:00','N'),(14,'invoice',6249,9,0,'euphona','2017-03-07 22:51:01','euphona','2017-03-07 22:51:01','N'),(15,'invoice',6250,10,0,'euphona','2017-03-07 22:51:01','euphona','2017-03-07 22:51:01','N'),(16,'invoice',6249,10,0,'euphona','2017-03-07 22:51:01','euphona','2017-03-07 22:51:01','N'),(17,'expense',5,11,0,'euphona','2017-03-07 22:54:27','euphona','2017-03-07 22:54:27','N'),(18,'expense',5,12,0,'euphona','2017-03-07 22:54:27','euphona','2017-03-07 22:54:27','N'),(19,'expense',11,13,0,'euphona','2017-03-09 22:50:00','euphona','2017-03-09 22:50:00','N'),(21,'expense',13,15,0,'euphona','2017-03-09 23:22:49','euphona','2017-03-09 23:22:49','N'),(22,'salary',1,16,0,'euphona','2017-03-13 16:45:33','euphona','2017-03-13 16:45:33','N'),(27,'salary',2,18,0,'euphona','2017-03-13 17:57:18','euphona','2017-03-13 17:57:18','N'),(28,'invoice',6251,24,1,'ck1232','2017-03-28 23:36:09','ck1232','2017-03-28 23:36:09','N'),(29,'invoice',6252,25,1,'ck1232','2017-03-28 23:50:15','ck1232','2017-03-28 23:50:15','N'),(30,'expense',14,26,1,'ck1232','2017-03-28 23:52:51','ck1232','2017-03-28 23:52:51','N'),(31,'bonus',3,27,1,'euphona','2017-04-06 23:52:39','euphona','2017-04-06 23:52:39','N'),(32,'invoice',6253,28,1,'euphona','2017-04-14 14:31:21','euphona','2017-04-14 14:31:21','N'),(33,'grant',1,29,1,'euphona','2017-04-14 14:41:35','euphona','2017-04-14 14:41:35','N'),(34,'grant',1,30,1,'euphona','2017-04-14 14:41:35','euphona','2017-04-14 14:41:35','N'),(35,'grant',4,31,1,'euphona','2017-04-14 15:25:41','euphona','2017-04-14 15:25:41','N'),(36,'expense',16,32,1,'euphona','2017-04-16 22:44:38','euphona','2017-04-16 22:44:38','N'),(37,'expense',16,33,1,'euphona','2017-04-16 22:44:38','euphona','2017-04-16 22:44:38','N'),(38,'expense',9,40,1,'euphona','2017-04-19 21:54:35','euphona','2017-04-19 21:54:35','N'),(39,'expense',9,41,1,'euphona','2017-04-19 21:54:35','euphona','2017-04-19 21:54:35','N'),(40,'expense',9,42,1,'euphona','2017-04-19 21:54:35','euphona','2017-04-19 21:54:35','N'),(41,'grant',2,43,1,'euphona','2017-04-19 22:12:41','euphona','2017-04-19 22:12:41','N'),(42,'grant',2,44,1,'euphona','2017-04-19 22:12:42','euphona','2017-04-19 22:12:42','N'),(43,'grant',2,45,1,'euphona','2017-04-19 22:12:42','euphona','2017-04-19 22:12:42','N'),(44,'invoice',6258,46,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(45,'invoice',6259,46,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(46,'invoice',6256,46,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(47,'invoice',6257,46,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(48,'invoice',6258,47,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(49,'invoice',6259,47,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(50,'invoice',6256,47,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(51,'invoice',6257,47,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(52,'invoice',6258,48,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(53,'invoice',6259,48,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(54,'invoice',6256,48,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(55,'invoice',6257,48,1,'euphona','2017-04-19 22:19:13','euphona','2017-04-19 22:19:13','N'),(56,'grant',3,49,1,'euphona','2017-04-19 22:26:50','euphona','2017-04-19 22:26:50','N'),(57,'invoice',6260,50,1,'euphona','2017-04-19 22:27:52','euphona','2017-04-19 22:27:52','N'),(58,'invoice',6255,50,1,'euphona','2017-04-19 22:27:52','euphona','2017-04-19 22:27:52','N'),(59,'invoice',6262,51,1,'euphona','2017-04-19 22:29:54','euphona','2017-04-19 22:29:54','N'),(60,'invoice',6261,51,1,'euphona','2017-04-19 22:29:54','euphona','2017-04-19 22:29:54','N'),(61,'expense',14,52,1,'euphona','2017-04-19 22:32:42','euphona','2017-04-19 22:32:42','N'),(62,'expense',14,53,1,'euphona','2017-04-19 22:32:42','euphona','2017-04-19 22:32:42','N'),(63,'expense',6,54,1,'euphona','2017-04-21 23:31:07','euphona','2017-04-21 23:31:07','N'),(64,'expense',2,55,1,'euphona','2017-04-23 22:00:33','euphona','2017-04-23 22:00:33','N'),(65,'expense',3,55,1,'euphona','2017-04-23 22:00:33','euphona','2017-04-23 22:00:33','N'),(66,'invoice',6247,56,1,'euphona','2017-04-23 22:36:59','euphona','2017-04-23 22:36:59','N'),(67,'invoice',6246,56,1,'euphona','2017-04-23 22:36:59','euphona','2017-04-23 22:36:59','N'),(68,'invoice',5354,56,1,'euphona','2017-04-23 22:36:59','euphona','2017-04-23 22:36:59','N'),(69,'invoice',6247,57,1,'euphona','2017-04-23 22:36:59','euphona','2017-04-23 22:36:59','N'),(70,'invoice',6246,57,1,'euphona','2017-04-23 22:36:59','euphona','2017-04-23 22:36:59','N'),(71,'invoice',5354,57,1,'euphona','2017-04-23 22:36:59','euphona','2017-04-23 22:36:59','N'),(72,'expense',16,58,1,'euphona','2017-04-23 23:27:06','euphona','2017-04-23 23:27:06','N'),(73,'invoice',6252,59,1,'euphona','2017-04-23 23:33:40','euphona','2017-04-23 23:33:40','N'),(74,'expense',14,60,1,'euphona','2017-04-23 23:40:17','euphona','2017-04-23 23:40:17','N'),(75,'salary',1,61,1,'euphona','2017-04-23 23:43:32','euphona','2017-04-23 23:43:32','N'),(76,'salary',4,62,1,'euphona','2017-04-25 23:05:20','euphona','2017-04-25 23:05:20','N'),(77,'bonus',2,62,1,'euphona','2017-04-25 23:05:20','euphona','2017-04-25 23:05:20','N');
/*!40000 ALTER TABLE `payment_rs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `unit_amt` decimal(8,2) NOT NULL DEFAULT '0.00',
  `weight` int(6) NOT NULL DEFAULT '0',
  `sub_category_id` int(11) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `product_code` varchar(10) NOT NULL,
  `paypay_id` varchar(255) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (17,'1',0.00,0,NULL,NULL,'',NULL,1,'ck1232','2016-11-23 22:02:02','ck1232','2016-11-23 22:02:02','Y'),(18,'testing',123.00,500,2,NULL,'',NULL,0,'ck1232','2017-02-28 22:29:59','ck1232','2016-11-23 22:02:02','Y'),(19,'testing1',23.00,23,3,NULL,'',NULL,0,'ck1232','2017-02-28 22:29:59','ck1232','2016-11-23 22:02:02','Y'),(20,'testing1',23.00,23,3,NULL,'',NULL,0,'ck1232','2017-02-28 22:29:59','ck1232','2016-11-23 22:02:02','Y'),(21,'testing1',23.00,23,3,NULL,'',NULL,0,'ck1232','2017-02-28 22:29:59','ck1232','2016-11-23 22:02:02','Y'),(22,'testing',123.00,456,2,NULL,'esting1','P3SXMRT7JA672',1,'ck1232','2017-02-28 22:29:59','euphona','2017-02-22 22:15:37','N'),(23,'product3',100.00,1,2,NULL,'Iphone1',NULL,1,'ck1232','2017-02-28 22:29:59','ck1232','2017-02-26 23:21:14','Y'),(24,'Iphone',512.00,26,2,NULL,'Iphone',NULL,1,'ck1232','2017-02-28 22:29:59','ck1232','2017-02-26 23:20:46','N'),(25,'IPHONE',12.00,123,2,NULL,'test','7WY8XKT8FR58J',1,'ck1232','2017-02-28 22:29:59','ck1232','2017-02-28 22:54:21','N');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `is_parent` char(1) NOT NULL DEFAULT 'N',
  `display_ind` char(1) DEFAULT 'Y',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,'light bulb','Y','Y',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(2,'hel','Y','Y',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','Y'),(3,'testing','Y','Y',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(4,'lamp','Y','N',1,'','0000-00-00 00:00:00','euphona','2017-06-08 21:14:06','N');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_discount_rs`
--

DROP TABLE IF EXISTS `product_discount_rs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_discount_rs` (
  `product_discount_rs_id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `discount_amt` decimal(8,2) NOT NULL DEFAULT '0.00',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`product_discount_rs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_discount_rs`
--

LOCK TABLES `product_discount_rs` WRITE;
/*!40000 ALTER TABLE `product_discount_rs` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_discount_rs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_image` (
  `product_image_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `image_name` varchar(255) NOT NULL,
  `image` mediumblob NOT NULL,
  `sequence` int(2) NOT NULL DEFAULT '1',
  `thumb_nail_image` mediumblob,
  `file_type` varchar(255) DEFAULT NULL,
  `display_ind` char(1) DEFAULT 'Y',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`product_image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
INSERT INTO `product_image` VALUES (3,17,'0.jpg','ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿ\Û\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\05?\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rğbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Ú\0\0\0?\0õn3FW?zª…l‘“U\æò.[\Èw1Jx8É¯?˜ê±¤Jö ş4›”sŸÖ¸ıSG\Ôm›Í‚i]G8j…¹,ù7l\ãÉ¥\ÌW³¹\è;\×=F)\áÀ=q\\¥Í²jvÙy#$|²\Æ\äõ®^\î]{@—2\ÜM$ğû\ÉSR¸{6z\ÔS`	\â£Õ´vÉ¡¹‰[pÀ8®Dñ@¸²“ş\Ñ\ê>µ\Ûi÷Ì¸w!\èi\Æz’\à\Ñ\äzƒõ/k_n²W–Ø“Œ\â¼û\Åú½Æ£$Ó‚§§Lb¾³tŠ\æ=²*²ŸZ\à¼MğŸJ\×w\É0J\Ç9Q\Ækª5;˜J7\Øù¢\Òû{yo{Ö‡–r[±\ã\é^¨|\Ô-Y¤´¹I@\ä9®Z\ëL¸\Òn\âmu\àûÖŠI\ìf\âÑ”¯\Ğ~54mƒ‚x<\âqnÉ’¸ œ\äT@ ’>¦™%‚`ñ“Ò”û¥°j5\'${\ÓÁL~˜„<1\0ñùÒ…;3\ÔJB¡H\ã?^\Ô\áĞ¢€a=‡^iJ\ç÷\É\íH„\ÓÒŒœñ\Å£x\0œ\Òm >)É‚r\İi¬2Àps\Ğ\Ğ¯\Êr\r^\ádù$#õª[€<‚sNTE\ç\0\àóJÀW\Ôô¢\Èeˆ\×<¥¢b*}+´‚\ádAœgÖ¨\ê\Ú>\á\æDh9	\Æz*p~˜5@«G!S• r1S\Ç.2I\ê1Š[Y9õ\éRg¦>™5\Ê6úg¥9	8óL[²zqõ§c9\ï\íU\ÕHO\\sR¬™íƒŸZ\0R\0\0Ã­8x8Áh\àqÚ”\ÏN(\0BH#‚i\Êñó~T\ÜcœŸN”\åS\×\Ç4€<•<œzÓ–N\0¡\ä\â¡F!º\ä\Z™\Ç€t\Ö\Ñ]&\n\çñ\\ı\æ•,ÎªY}+ ´ñœ÷#µL¬²)W\n}\Í\0q?:1µ$rÃ¯\é[\×\Ú/œ\â\ë\×\æ°%‚XlˆA\0\àY*\ÄdsƒW-üA©Ø°^Î£¶\×5®½\Æ{Òºq»\îûzŠc6OŒu¶BP˜À¹¬ûZ\î\ås,ò>{3f³‰*:~tn;OO^iig\ÇRN*E”†\0cŞ©\î\01zx~:P3Jı>•v²½ğ}	¬T—½»U„\É9\Ç|\Ò\Ó\Új·…Lr²°\çƒÒ»\â=õ“¢\Í\'˜¦¼n9\'>•r§ƒú\Òb>\ĞüqaªÆ \È\ãk¥ÈŸ„úW\Ê6:›Á 1¹w½gÀ¾*b‘M.\á\ïM!\ÜõÀŒ•Z{/¡©¢Kq\ÜVe\Şri¡ˆ÷µ]®˜œf¡e\æšV˜´\ìÃ‚j¬’L™#¥I\ĞÔ£9R[\Érj\Ü7\äŒf£’\Ù[9ª\ín\Êr´À\×Y÷\r/˜İ«&)]\ÍW\â˜51D\ÍR¥\ÉQ´\Å\0_KÂ¦W\Íe«S\Ç.(ø9¥¨PjPÙ¤1\ÔQE9£\Zœ2`©\ä\Z\Ë\Õô\áu	+”r\ë\Ï>üKqƒ¬Ë²o»o;ı“\ï^¸\èzƒ^t\â\â\ì\Î\Ø\Êú£Ÿ\Ñ/¤–op2\èq\ÏqM\Ö|7kª!tTİˆ¤\Õì§°˜^Z®\å\ÎXW´½N\ßT‡Ø”}\ä=EA~h\â\Ş-WÃ“bE/¨\ä\Z\Ü\Óõ[-Z#9\Ç\'9®h7FRDóğU†k–\Ôü#\×\Z[˜e\ì\Ï\éC\Ôi\ßs/Zğt\Ö\Ò\Í ’-yOZ4/Ilÿ\0f½\08 ğGÒ¬Zëš–‹ ‡R…\Ù»Ÿi\\\é\ÚGŠ\àó­¤H®H\ê89÷ıG\êu\ÚmüsD¬’ˆôaZ[˜G\"¼’\Ú}WÂ—^]\Â3\ÂO\Ş\ä©ük\Ğt=~\ÛT„ymówBy¤e\Ü\Êp¶¨\Ü,\ÇQ_=üQ„Á\âÀ`5}k\Èş+øj\î\é…üdU6J\Ú\Ò1’\ÒÇ”\ÂÁ\Ô+À\Õy­b@\Ê\ç#Š21V\àŠ»ù‹µˆ\àÿ\0œ\×A\ÎfòI9\ì\à9«7V\Û\ì\é\éU3´mnZ˜‰G,=zšx\0\Ùô¨wÀ°\æ\\1\ëõ 	7m \Æy\Ï4Ü“L\ã¿a\ëN\r\ÈÁ\æ€x\Æ}1Ö˜¤œ‚qCdõüiA\Ãh\ár@\ÇNÃµ9IÁ\íıiƒß€iAc\Ôó\é@Á`?ˆU\Ø.Õ\Æ\ç>µH@\ã“Ô“J:g\0š—\Äe\ãÀ`2}ëš‘^\ŞB¬¸Ç­upK‡\Ø\Íò¹¦jzJ\\\Çæ¢‚\Ø\ïHg7‡\îƒòÕ…;ˆ\"©K@ûm\ç½I¹n@\ÏNM\0^C‚Hæœ§9õõ5]‡=\êP\Ç<Š\0²’\Ç<S÷`õ5¾0zúS‡\İ\'ñ 	\×$\ã8\"“y\èM©\çG9 dœA\ã­\0=\\–\Î)\ÊN6˜g©¨\Â\ãƒÖ—\Ø\ïŠ\0œ7BO=\×!l¯z\â«órH\Å=_*NE\0Z\\~oOj.tø\ï#-€*\0JƒƒšpšD ÿ\0“@\íö“-«’\à*\â8Û´ûŠ\îP¤\à‰\'Š\Æ\Ô4\"\à\É_aÉ¤;‚\Ã\0gpAüjwŠKy6²ô¦0,2E\"ÀiOP\Çü(e\Ú9<ı)¸\ÏZ`J­\Ï^”ğpÄ„z\Õp\ØİƒÈ§+Ãµ .,‡±œtÉ«Ë+;p9ô©\ã“ny8 Fœs\ç\'º/\ë/cy\ry®=e\çŒsV#˜‚1ùw¤\Ö^\×\"\Ô,“\ç\â¶ob\ãp¯<	\ã	tÛ¸\á™ğ¤€9â¾„\Óuµ;5u`r)2‘¦\à\Z±qF<U~E\ZV”fIEÀ†Iü±“Ò\Äo\Ü\Zm\ÄtD\rr÷2]\éó“‚W4\Ñ,\ëŒhÂ›\å?)®~\Ó\Ä\nÀ+œ\Z×‚ş9º50/¤›F\rXW\ÍPğj\Ì#=\è\È\0Š]¾ô›\á‘L@¤Š9ˆ¨\Ç\"†€.£‚:\Ó\ê’¤U‘\'†|!q1[\ãb¥NAr\r{—\ÃŠ‹x±hšôÊ·v†8ş\ËzzğV9rßŠ¶A ƒY\Î\nJ\Ì\Ò2qgÛ‡l\ÊWªšç¯¼?²sui/\Ù\îA\ÎG\n\Õ\äø\Ãs¤¬Zwˆ7\ÜZ•.G/ôo\ï\×\ë^\ékªY\ê\Ö	we<w\î2$üúW\à\âõ:¡4ö(\Úkoúœ~[<\Ğ>S\ïZ\ŞL7¾÷S‘YWV…ù¶‘cnñJ7#‡\áY\ÂV²|¼mıøO™şµ–¹©}n\Ê\Z;\Ëq=»g+–¹ğÚ¬~‰w²QÏ’Í´ş\Ô\Ù\ë2¸Ã´7({¡ÁÇ¸¥¾°±½\Ìò)?¼œEÆ´9\ÛO¼ñ/ñ\r‘*x\Ş\Ëü\êKRğ\íÈ‘G\Ì[§Òuitq\É\r\ì#¤Wk\ì\ßız§Öq\ç\é\Ï=£\ç˜eùf\éù\Óô‹AñvùE–ª¾D\ã\ÍÀ\'úWW<1]\ÂREWFZ\á..­µ%k:{[\ÌF\â1kGI½ºÒˆˆN·öC¡\çAô«Œú3Ãª8\ßü6\0I}¥§\ÍÕµ\åØ’Z9£/\Zú¶\'†ö\Ü<l\Z¸\Z|<‡TW»²QÂŒ\à\Zºa>Œ\ç”/±\ãh\Æ\rS¼³\n§=\ê\ÕÍ­Î™t\Ğ\Ü\Æ\È\êpA\íV-cûl«\0RYˆ­Œš9ÜŒrps\éOR$VÎ· K§H¤¼ğ1X€òGC\ïLM\ÇOL\Ó\×>Ø¨À9Ú¤Q•$ÿ\0‘@‰v\Şy\î)@\ã×œ\ÓóÁ5\"O8\ÏZ\0p¦\æ˜\Æ\çô§€¼n\èE_N¥zq@	\Ğg¯¥8\Ã\ïc½0’I\Ç•r\Ã\ïŞ€^£\'ñ«V\×°\äıjù8=©	*Kt÷ dš––—q\ï\Î8õ®Vkwµ˜«\ãy\ÖErCmsô¤\Ôt\È\î\ãŞ˜¤-€¶Â§W\ÏÍ‚1Úª\ÜZ½¤\Å\\\ëOYwq\í@A,9\"¤^WnA ô5Q *ecœgñô 	„˜ùjT7N:æ«Œ™\"¤V œqÚ€,Q\ë\ÇZN¨~cŠfw€=irGğğ}h@N	\éN\È^3“éŠ‹±jN#Š\0z¾\Æ>•2üÃ…9\ïUW\àš•$\ãs@ Xr*\ÄW#¡}j¨\Ã¼õ4p¼ƒùP·š|‰œ\r\äv®^\ëL–Õ9\çŠ\é\Ör¬1œu©ó\Â\í‘>ô\Â@#<\â¢b}>¼WS¨hŠ¡ôµ`\Ín\Ñı\åÁ e0P–\Ï¦‘QSPm<p€‡\'Ş¤Võ#ƒ\éP¶@uE(mªú\â€-n\Ú\ß{·\"Jv\ã§õªª\ÙR*~\î\0Rü:0m\Ä\Ó\ë|v\Öó%¥Ôœtµ\ãa°£$zU›k†‚P\ê\Ø#s@²\â’+ûe’6\r‘Ú©Kˆ¯+øqñqK+¹9\è	5\ìe\ÜBD \äv ¤gv¥ö§º$S¤Q\Ëk\ë‡PjJQÚ€9K\Ã\\™ =x¬R×š|˜`\Ø\ÏZô]\ãg\"³\î-!»$5JBh\ç,õ\Ö\à9ú\×CgªD\ê>ašÂ¾ğÌ‹™!ø¬}\×Oµ\Ã)ô{ô¸n\Õ\ÇZ]Z¸+=]—«Vİ¶®2i\Ò\í\à+2õq÷ª\ìw*{\Ğ…\Ó\ÊñMFV=jfø÷\Å\ßõ¯Jò\ÍÍ<Jƒ$q\\I\à\×\Õ\Şø‡\á\ïÛ­³·½aóY\Îy?\îŸ\âşu\Îx\×\àÅ–¤e¼\Ñqot~m˜ùXı?¨©\Z—s\çPA\ÎzVç‡¼U«øbó\í\Z]\ëEŸ½\å´§ƒüê¶µ\áıO\Ã÷mm©Z¼,	±•?CYY\Í&“Ü´\í±ôw„>,i>#x­55\Zv \Ø\0–ıÔ‡\ØöúÎ½)­\â*\0\ã¨\ï_n!²N•\ë^øÁ&‘lš^¾$\ÑF\"^1\èGqú\×5J\Ö&ğ«Ñ\İ2\Æ)\Z÷€¬û­b{E;0;sWl\ïluM2=B\Êu\ÚUÜ®¿\çƒT¾\Ï\rÛ“\Ê:\×1ÒrûÄº¤\ì*‘®y%j­\İ\ã\rp\Ùÿ\0d\ãùV¾¡b¹À] t¬F²)–nŞ´hQJ\ï\Äú”Er\áz€pG\ëU?\á>º·l\Ïgo9\Æ¿1\Ç\éTµ^B±|\İk9t)®\Ü\àw•I\"\×X|fKû\Í.Së‰³ŸütW¤xg\âƒ\â´	oq\ä\İÍ¼\ß+~µ\âK\áTQ±r)§\ÃZ:\Ï\0(\Ë\Èe=+UÊŒ¥õ=§\Åş	´×­™\ÑDw e\\\nñûm6\ë\Ãúß—wR‡†\Ç\é^‹\àoLvi:\ì¤K\Ò‡<7±>µ\Ø\ë^²\Ö-\ØM–#†‘Z\ÆmJ7>yñV¹ö›\Óó\rª0s>ls\ÈrÀt¯@ñWÂ½j6–K%[ˆ‰\àg+\nñ&\Şdšt†0y\Ç8­”“\Ø\ÆQe5À¶°§\Æy<sRMl\å~\î\×Q\È#½UY\'‚Ö¨’\Ğ\èO¤n\0ş8ª\èC¶	<T\ã \è:z\Ğ\"\ÂsÇ§ñ·v@:Tğ	J™y9 \ä\ÓŒp	\Å w‘È©\ns\Ç=\é€~n¤´‚\nş•+“°(4\Ş\0\Éõ\ëŞ¤\ë\Î0>´€Ç‘“Â¦†wB‘Ó­ ;˜\àŒzRI\Ğg‚{Š\0[»\ï`İ´g¯\Ê\İZKi/Ì¼gƒÖº¨guxúR\Ü\ÚGi\Ê,ü.}jtm\Üâ¢»±’\ÖVaA\ïQ\Ä\à	\ãµ\0^V\ÈN”ğ\Ø#Š¬	\æ¦•\0YB\Û\ê)û‰rj¸lóÀ©P\á{ps@Œ’{šp\êA&˜üšUP@\É\çÖ€Â¤c\Ü\Ó\Ï”eº:P òy\ãÚ¤\ÕX€\àj•n	\Å\0?;\çŞ”1eXg°¤yúö¡¸9\Çó kqŒ:õ\Ïj†\ê\Æ¸\Ë(Á5\ã\Î\'ŒT\É1\\{v z\ïM’\"r>^Õ™4;3Œ\×wº)ÁV\Ç5‘¨iüñ\àJ\0\å#ÿ\0®i™ùy­\\¹µx\æSùU2	\í\Çs@\ÅRÀppONi\à\çŸÆ¡ c8\Ç*ò€z\Ğ\Ê70>½*\Â\åx=~½*ª‚I\ÍN¤u#iv\Ú\æ[[$LU—vk\Ú|ñ%dT²½|?@I\ë^“‚2zs\ÍOo<°J®ŒCGj\0û\\\Åwx\È9©…kÈ¼\ã½\Å-.\äù‡\0“Ö½zcºˆ<l>”††b“)R)¸ ƒ\ÎJ˜\Ó4¸\ÅG(\Êšo¤qIÀYz—‡\í\ï°ƒ&¹ó®]\èóf@^ş•\Óizõ–«h¤»ŒÑ®\â8GÃ·Z5$•J)¥Œ•`As^³5¼s© \ç½sº¯†£•K\Ä\0>Â©K¹-v9«[\â1\Íl[\ß6z\ÖÅŒö2\Èv\ç­Ior09\ÅP¶\Úø\æ´\ãº5\É\ÛM\Ó\æ­8\ç!G4ø\Â)^\ãvWS•e8\"½sÁ_¯ô³—ˆƒ^\ÚÀÿ\0Zƒ\ßû\ßÎ¼„\ã¯\éHis\ì\'¶ğ\Ï\Ä-Î‰\íï­¤,£%O¡A¯ñ§ÁmCHi.ôPn­sŸ(ı\åÇ½yö…\âMW\Ãw‹u¥\İ\Éo(\ë´ü®=t#š÷\ï|iÒµğ–\Z\êÇ§Ş·\Ê$?\êe?S÷O±\âY£\æ\Ùa–	^9Q’E;YX`ƒ\î*>;\çŠú\Ç\Æô_[™\ãE†èŒ¤\ÑcŸÇ½|ñ\â\Ï\0k^¾\ÕIk\Út÷ô¤4Í‡?\ß\Âò¾™4¹ú÷11ş!\í^\ß\áÇky\'\Õâ•·#©\È+Ú¾U³€\Ü\\¢ô\ä\×\Ñú\r\Ò\é€D\Øm£Éˆ‚^ñ\ÕBM\èu7Ğ«©=\0\ï\\uû´òy0ı\Ğyjµguys#‘Š š¸,•rx¼W9\ÒbCe	’»rjÍ¡´/µJŒğG¥:úÔº\á8ük\nXç³“{=\é­Dukcğ„\äJºúd[T©\n­m/\Ú4¤oùi\ãŠÎšş\â‘ƒL’¶·¥¢32¡9¥\áO\\\é\Ò\Ça©¹–Ô«#™?ú\ÕFÿ\0]H\\\Ä`š\æ\'¸‹y9\Ö\Ğ\Ô\ÎiB’³D$Œ‡†A]‚4/ \èzŠó\ßx\ÈE\"iW\Òf&\â)ô>•\é“F²FH\ç#‚)\Ø\Îö\Ğù\ËÆˆxEU\01\ÏJ\æ.l¼\Âdº¿ˆĞ½¿‰Xó¢¹xgÁ ô=«¢	ŒÖ¥%ù\×^jl\îq€O¶j\åÅ¢Ê‚T\ÆGZ\Î;¢l0\Éd@8\ÆA:pü\êª6\à9\ÅN¯‘şy D¤‚OB(\Ø	Áõ¦gŒšv\îGg­\09ƒıh\ÇN9÷§\ç,ü©\Ä?\â€ H \Z™õ¤p\ÊÄF1B6\àpyô c³2}©\ÑHcsŞ’5€8\Ïô©j‡ŒP.m\"¼Œ\î5\Ê\İ\Ù\Éi;¸\×.\ä9ô\ê*»x\î\â<s\Ø\Ò–\É\\t©£b:úT7–\ÒZJx8\íQ$˜zv\Í\0h‡<*‘Œc5Z6\Èÿ\0\Z–<öP2\È\è	\àõ(a’§[q\Æ÷\æ¤|\Ù$‘õ Dƒ;~lS\ÆOlm\éL\ß\Æ2*E\È\ïŸZ\0SÁ\ät\ëI’=}h\ÈlƒH\Çò 	²s)û É¨”r3Œÿ\0:\\®\î:PŒ	\è)\È\Ø\ãÓ°¨\Ãr	\Èôîœ½8 †e9\0š¶’|€7oz zƒ»¾*Pp:ñŠ\0}ÖŸ\r\Ú\ÇÒ¹›\í!\à…\\j\êVR½\ÉQ\ĞT\ÅRdÃƒŞ€<ù¢o\â#¯\Ò+±½\ÒQ¹1ósXWZt‘¸q\ë@\Ì\ä—¦=M=Ÿ€\èy_ºx¦£ÿ\0¯@”\åH•N¼G÷s\Ïj¦‡§8­O\çgr½I\" KyDm®§ƒ^\Ë\à+„²»\0“Ú¼HJúô«÷R[J²D\åYOh\ë\è\åKˆ–D ƒAZò?ü@²\Îò@ dµ\ë‘M\ÌBH\ØFx¤1„\Z†~•9¼\Ğ2Õ¢\\\ÄcqÁ¯=\×-õ\r]}¶Ä¹Œ•\é¸\ÅAycô\rª#½4\ì#ğ—\Ä\ëMI¶\Ù\'Oš½\Zˆ®c†S\é_:ø¿Á÷\Z5ó_X\î	œµ©\áŸ^i¾ZL\ì\É\ÆsM\Ån…{\İy¦\Ãt„®CSğÜ–\î^p+Dñ5¯\n•‘Cúf¶™VE\Ã\0A¥v‡kg’@û$#ŠÓ|§Z\èu+Yf¹¹\ì\'²|•«N\ä\Ú\ÇÈœ‚=¹\Å&NsŞ\Ôd¡õ¦\ã¾\r\"„\ê:PN\n^ƒ\ßø#â¶¹\à÷Kws}¦¶\Ó7\İ\ì\ßÊ¾„ğ\ï‹|5ñOd·‘M¿¼´›Dü;q\Å|vxö®»\áŞ…s­øš\ÒÂ°|\í$lT`E&\ì®·z§\âß„QZŞµæ…±w6LX\éZ°øoX:40”U0Nk¿² HĞ¶Ñ†y$\Õ[›\é\íÉ‚…oN•\ÃR¯>‡]:n9§i\ßb„&r\İÏ½hmø\Ïœ±#©«©.3+#c>{UR6s~(u†#ù˜ñŠ\ì\ï\á\"\"\É\ÎA\\Ş¥j¶£+<G\"šZˆ‡\ÃZ\å‹*é·®-\î1òùœn­½CHI\í\ÚT\Ö¾ƒ\ÄZDB\â5Im\Şük?¶ü) ‚\çu\å‰8Ff \ã\Ğ7cõ­9o°ŠZş›qg9@	C\ßÒ°#‰\Ø\Ä\çÖ»-WY³¸´2I\Ì|te\Íp\Z‡—3<=H\"µ\ìDÑ©n\ïn\à’G=«Ö¼\ãu½	¥_\È b)	û\Ş\ßZñO\í9.”F÷8\â¶\í¢1Gñ1.\Ç5M\îz÷¼‰-±|·*2¬+Àõ=\"\ïF½kk¸Š8$s\Ğ\×\Òñ¦·¥\Å¹F¼@–\"~a\ïŠoŠ¼a\âKFYc`>Wi\ÆV\ĞÉ«Ÿ:\Ø\ÈX…\è1Ş¦º\Ó\Öh÷(±Wu\r\ŞøsRhg¼¼ü®:Q\Ã.\á0kd\îC]\Ì‚Dr¤cŞ¸\0p3\êz\×Awd%·,«\Î+h\Ú)p\Ê\Ã™$£\n@#Š”Nr8¨T\å†y¥\0ƒœ\ZJ\İ\Û=\êBA*‰T’9©J…#ŸA@`q¼\Òc?…?w8n„Tly\ã8 cq’8¥+\éœúT{~• 8 A\Ûüi\Çz`zv¦{€)sÛµ\"º³‘\çmr·vRZJÀ3Ş»(ÜÓn\Õ\r\å’]! |Æ|o\Ó&¬\Æ@\ZŠ\î\Ê[i¥2\'0I eôn™5*õ\İU$Œµ2v\Ğ¥b~¢¿óQ\éÖ•\îú\ÔŸx\ÆI¥û«“üéƒ‘\ÎE;¿$P”\Ù*BN\ìŠ|q\äja$§\0¡ºc¦*E\Æ:õE38\ÉúP§¢€\'S\Ç­)7=Hæ˜˜Áõ\ïš\\“@±@\Æ;c=)\ÊÇ·S\×\Å$“\Ğb„ùp	¥\0YSŒ)\Ïo \r ŸJ®A\àÿ\0UI\Å1Çš\0Æ¾\Ğ;IÁ\'\îô¬;‹)\íX¤±‘\èq]Ú°u\0\ã=©²[«œ:†Q\íHgŸ`€”ª29\ï\í]eÖ…m0f‰„m\Øv¬Y¬\r±) Ñ e~}q\ëS\Ç&X“\ÕDŒ\ÍI¾\ïOjb,Er\Ö\ï\æF\Å0zW©ø\âK\Æ\Éi|\Ø\ìšó³\n£w\'\ëÒš@\Ã)ÁŒv ¬lµHo\âWÁ\È\ã¬kÀ|\ãy4\é#·¹N&½«K\ÖmõU‘Á\Èõ©¦F)Ê´\Ğ\ÊOZx4^ö\Â+\ëvŠU^O\â\nË¦Ló[¡1“\Øt¯c^ö\Î+\ëvE#Ó°4xf™ª\Ü\éó+\Å+.#5\ê¾ñ\Ò\\‚\è\àúš\á¼K\á‰t\é\Şh“÷g+Ÿ\Ş7\áˆ\"­¤\É\ÕJAq\Ìa\â`À\ÒOk\ë†Qšñÿ\0xº\ê\ÆDF%:rk\Ôt\Íz\Úş`\Ølr+6¬R>\Z\0u\çŸj3“Á®÷\Æ_µJ\ÒÁ\İYòw¨\åG½p„c‚0}*€N¤`ò;\Òu\'œœRdj^\İy U.ÁTI\0b½ÿ\0\áW‡\ÛB\Ó\Ì÷‹™†zr=«\Æ<)Sx\Å\'\Æ\Ã\'CÜ•ôF›\r¾±\åËŸ-P(±¯++Ğ…\İû\Zv\Z\ìW7—W4o’‡û‡h¥¼ şMszı¾ı —vs²\ÈH½Z\Ó&{\ë,®[W.—:›W7\ã\'5\"Îªv“ëŠ•\"8ã ¨n-¾`qI´À<\'ö®jş‚F–!\\V¾û;aş\\pOcS²¥Õ¹qÊ‘T€¥\á^ZKi\r‡½_\Ô\ï4\ÈKE9X\Ø|Ñ‘œ\×$\Ú[Å®FUŠ«6*§Š¼\âµ»\ÒgIao¼’d\ÌU­XØº­“#4v2Olş\íˆ*¿L\×\Z\ÚB¤®/˜3\Øu­ı7X´\n\×$‡¢ô¬«\ÇûSFá·ƒ\Èa[D\ÊEÄ°@­ƒ#†)ñ)n\ÇZ²±\Æ\â=ªˆ±Á\ëú\ç‡|Ei}c;Á2rN3ÿ\0Ö¯ >üC³ñš\İSPˆbHó÷½\Å|\ïñµ[‘\ï\\æ‡­^\è\Z¤7\Ö34r\ÆÀğzû\Z®[£&õ>\Ï\×tMj\Í\â0\Ùq^\â?\n]øz\í™Tµ¹\'kc8ú×¨|?ø‰§ø\ÊÁc.#\ÔyqŸq]6«¥A©[´SÆ¬\î*œGdôgÏ¶r‚¥IÓ¯tˆ\îcó\0\Õ\Ğ\ë\Ş\r¹\ÒoÄ–ñ´’dŠ\ç5Um\n¤yV_¼¦·M=Lœm¹\Í\Ë–²´n¸4‹1\Æ;Zÿ\0h¶\Ö\";v\ï5¹™pA¥2K\n\ã=½jQƒ\Ï©£@\ïõaX\ã­’\ç©\Å8÷\É:\Ò&A\'©;dş4o\0^ô1\İ\ëœ})\0\çü(=NM\0*ü§=ªL Ö¢\àqù\Ó\Ç\È1\ÈÀ\ë@ÀS\Í0–\r\ë×µ*¿\êM¡“8 P}Í°¹ˆñ\ÍsWVolüs]“©\"ª^Xùñ2 9Dÿ\0‘VCş½Ewhö²ŸLğ{S#rs·\Ôæ—”\ås\Æ)Àçš®¬\0\Ú\rJ®\0ğ:P•l(=*Eldu5W#\Õ\"–•,«\à\í\í\íK·$ğ};\Zˆ1\Î?ˆT™\èG$õ\ç¥\0;\å¾´¥rs\Í4yÀô§qM\0\n\Ä69õ&ı\ÜwúTL@<´ª\ä0÷\ä\Ğ\í\ÈÁ\ÉÀ\íJ$1LR¯\Ğ\ãÓ½9r84\0\á\é\Î=©\Ù\È\"£\ÏS\Ïô¥\Ï\0ƒõ\Ígóü\êdœ‘ƒU\Î\Öa9¨÷\ìH\íH\"Ê§i\Æ+Ÿ½³d\Äõ­€\ä6OÒŸ¸0#© g&!a/\ÌŞ•qZ8#\ÆF}\ri\Ü\Ù		*T¬»[€ığ8¦Ë¨\ÄGQ\Ç#Hr\Ç¢HÂŸ›9\éW-\í\åœb4lg#Š\0j£\å<ık´ğ—‹n4Ù’)œ˜óOJ\ÂM‘F\âA\ÇJ‰\íŠr¨ö\ïHv>“\Ñ5¨5ex\ØEm¯\"¾uğÇ‰®4›•YùY\ïÚ½\ÏA\Ö\à\Ôí•‘Á$z\Ò¶)Âı)E+\Ş\ÙG{G\"ƒ‘^]\â?É§\Ì\ÓD…£<œW­Š†\ê\Î+¸ŠH \æšv\áöŠKm\èEuZTò[“µˆú\Z~³á·°¸iaL\ÆNjµ¦B±#‘T	\Z~ø¡¡x\Ö\İlo•,õ0`”ü®\Øo\éÖ°|gğ‚\ËXinôp-\îù%@ù_\ê?­|ö¬QƒA‚Nk\Õ<ñŸPĞ™,õ¥kû p$\Ï\ïP}‹ñ ›v<óZ\Ğ5-ğ\ÛjV\Í\çFú\Z\ËÏ¾+\ì9-|+ñ#C3Bğ]\Ã\"\à>d>„u¼;\Æ\ß5-	¤º\Ò\Ã]ZõXoZCLó\İ¤W¶–0w#‚½{=\åüS\Ã\rÓ‰ œ \r\×\r\î+\Ïü¢y÷%¤b¬§Xr¡¯IkMöÿ\0guQ\ÇCŞ¢qL\Òq\Ø\æ\îu2\év±*\Üg¾k\Òü3›exæ¼®\æ\İ-n\Ê\ÃÂõ\éş½¬£^F+\ZŠ\Ñ\ĞÖ›nZ¥¬(q’^\Ş? \í\à\â²\ä”F	¬]G\Ä\Æ\Äò\ÚO`y®tÍšmkV’aŠ®q\í\\ı‰.4«µ‚\î3\ä1\ÆqÒ´ŸÆ–W–\ì!,d^\n¶¹]SY[…e’\\U$ö*\ç¥Gkük,xlò\æ¶mª‚)pÀq’+€ø«y·\Ñi\î\ß#}\Â•z|–¨®¿1J,™Ilq-·€\r\ÛW8ô¯7š(\áœD¹ñ]ß\î6‰\0\ãõ\ç†\áÕ±fBj\à)t4bPÀ\Æ*I7…Á\Í2†\0KV>õj\î5D\Ü:b¬ƒ\Ëş °3ÛŒó\é\\=uş9p÷¨\Ê\Ä\ã\"¹\İ2Í¯õm”½†~•¬v9\å¹\é?l\æ\Ó\ì—QVd•U…}\á}u‹%I\Ø-\Ò0?\Å\ï^We§­¥”ª€yµôó-­È¸ŠùR’¸”¬\ÏT»´I£m\Ê\ÇzóOü5‹Y¥ŠCŒ:¯OÊ»\r\ÅPj\å­f+Ò»Ÿ½ô­§Û‘Xİ§¡²³Z#¦ü!º´¸$^¶{ŒT~$ğUÕ„ ³8\ëŒW¶00>£­r¾;”G§«}ª•I\\%\ØğYm\Ş\ŞB¬¤ŞŒ³Æºû,\ß\Ã\ç*\Õ\Ì\\Ú½«\êsš\è9†!\0uü3OLn=ªr8úSÔ‘\Ğ@€wSü½\Ç9\ã\Å89\Æ*]\Ù\Æ½\"a´ñú\Ñ\Ôäš‘”i8\ç>”\0\Åny?LU•`8\ÏZ­Œ`\ã‘\íN\rùƒ@\Ëó\Èâ·#\0vª\ë&MN¹\Èa@/l„\ÈA^~•\Ì]Z=«·9\â»Só)^sY÷¶i:}¨”Gc\Ç\'\ëŞ§¿Q\ŞY\Ém1lg4\È\äÀ\àô©ú·LŠ½ªj\àš™d|½;\Ğ¡&\Â8üªA&\ï^}j $3*TlşqLA \ãÔ¤r=\ê \àœóæŒs\É\à\Ğ°\n“ƒJGÀ\ÏœÁ$\Ò\È\à{\Ğ\0¹_cŞ¥RI\Î\ÔD|ƒ4\å^8n3@qÛ©ô¤\ã# õ¦©ù@\ï\ß\'V\'<P€2q\×4o<c\ë\Í9şö\ÏÂ¡›q\é@\Ã8ˆŠV\È\äPF\0\Îy¤\'4\0©&>ö8\íD©ƒ\èj2	ıi$\à\ãõ \n²ii\ça•ô\ëb\Ú{[t\ØW\Ü\Ô \Ûóq¢¥ı\ÑL4A¹\â“\Z,<ñLFªóFX8öæ£¸bb\Ş’¸5œ59am’#)\ïšV(³%º—İœ\é[\Şñ\Ú5Ê©f1\ç¥sŸ\ÚÊ˜\ç\×5]\åv|©\ãÚ€±ôÎ…®[ê–¨\Ê\ê[<\Ö\àÁ\é_6øo\Å\è÷	—o/¾M{§‡¼Gm«Ú£+\Ø\äP#vœ(\ëN€\"š\Ù.c(\ê>µ\Êjz¶\É\Zü„\×f«š&‰d\\0S@…\Ã\Ï?\\Rr=}i\Ìuv\ÒHÒ˜]\ÄZ¯†\ï\ÒóK¼’\ŞT#;NU‡¡¯ğ‡\Æ=7\ÄĞ¦Ÿ­¬v:ùCõRıc\ìk\æ¾ƒ\Ç5wJŒK©ÂŸ7\Şi‰£\è\ÙYXj‚\î\Ú÷8\Ë2¨\É÷®sP\Ô\âB¡)(8\Æ?J†\âòK}*5X*\áw@®&\ïV–I\ÙX\àƒÁ\Æ\rfR\ĞÖ¾¸ó|ô;\Ô\ãp®ŸÂš·uˆ\Èz\ädW\Ê^!Iùª{ñš½§\Ü=´\êY‰ÀoJ™F\ê\Å\ÆVw>ƒ‡JÃœŠ\Æ\ÕôSyn^!‰W¦A\áieµX˜çµ\Òo{wó@\r\ë\\mYIf]Y¤òg\Z¼]\×)\'\ÔZ\á5?\Ä\Ú6¥\'ö»L„Ÿ&‡\Üz~U\íZõ…¦ \Ä2f«)\Æ\rq:’jR?—4¾z\äsZ\ÆV\Ì\n^]\Ú\ê\Í )†\È\ìE{d~&ŠM?}\Æw…á—½ye½¾\ÖRSzV„“L¶\å@ú\Ğ\İö^\æWŠ5¦»¸f\åc8&²RóËeŞª‡¹\ã5&¥rw¨\ç¯•\'‡fÔ¢Qoz!2\ê+H¤‘l\Ü]Z5#{®jó\Şy\Ğu\È\ÇZ\æ#ğ\Í\ÂH†\æs!_AZw\Ùö,O@8\ÅV»8¿ÀnnY£\ê½kc\á~„nuo¦O–>5†\æK¸\æp3¸ö5\ê\Ş²M;FŠ0\ç\ä“Şµ\Ù6tMn\0\áy\'–ñ\Ö\Ïh\êx«\Ñ(š\ã pœ\×?\âI-mf¶)‘\'k\Ú\İ\Ü:ü`™\âxNK)\é]6—ñ¾÷N\"\ßV¶ûb<\Ä;Xy¿šdy\ïe<±$f¹ùe3L\ÎN(qLµ&¶>‡ã§‡§Àš\Ú\î/|üª¦¹ñ#Cñ²\ÛYšN¹d\Æ+\ç÷c¸úV‡\çxõ4U\Ï\ÍS\ì\Òw)\ÔmXö\İ2_ÜLr*\İ\î‡£l]@\Ş±´«€\È8\âº;;†Œq\Ğö­L\Ï<¿Ó\Êb À8ªu³šõ=[O‚şØ°Q¿«\Îo\ì\Ş\ÖfB¥OÒ˜Šª\Ã$c*8?.8¨’Ä1\íR+l }(1ù†q\Å\r@=\è<\Û<õ§òŒ\Z\0…±“\ÏJ` vúSŸ$n\Ô\ĞAô\Ï€IäŠf8Â¡ÁÀ\Î;Ñ¦˜\ÔıiÀg¯_\çPF\àc?I\Ï]\Ù€(\ßZ,ñ°\n9\æ¹{›f¶œWu…‘rz\Öm\íŠÌ¤4š‘\ä‚852Éœ\éIyföòÚ¡€9\rHe\è\ß#*Àr\Ã>\ÜUÃ·Jš999d~ü\Z™Xõ¨\rı*@\Ø`8\é@m\Øÿ\08£ Öš¬¸\ëùšylŒgñ \ëÈ¤\Îò\Å Ác\Ç nùPCv•*O\0Zn\î„õõ\Å\0ñ’9\Ï4)\àn9>”1*x\ÉÏ¥3v8S×­.AÁ\ï\ëš\0>by\êq@\Î:“\éNV#¯ô¦¦\Ï\ÓÚ‹€)­Ô=úÔ…°2Gò¦`g¡\ÇZ&\0È§$ÀO©„€\Şô\ŞÀ9\Ï\áŠ[\Ş¡«°Ác©!·»U:8\à\ÖB’\äÕ¸Ø’§`zROUğµö|\Ø–üK\ØVTNÁ‚·Ez†™v‘Ûª\Í @Gñò\rE©xZ\ÇT\Ì\Ñ‚S\Èuû­E‡s€8n=¹®‡\Ã:\Å\î“8d,c\ÍgjZ=Şß¿_“³\çƒZ\Zl`\Û$sÓšJ\ç¸øsÄjv\ê¬\Ø~\à\×N«¸dW€i·r\Ø\İ,‘9\ê3^·\áŸE}\n\Å+aÀ\ïA-X\êU@¥|´\å €A¤“¥>\0u9¤#&œ\ß\'…4A\è)ˆ1À­\Ï\n›\íUó\ÛiVÿ\0­Z\Ş\Ùı¨\È\ëÁ\æ€=\'U‘e·\n¬Œ\ÇË‘\\\ïö,W\'\å“kg;I\ÅuLR\Ç\Z•ÃwÁüjÁğôwö†x\Z1:™3É¨Á\İ\é3\Ù˜°À\à7CW¬œ¼`±İzÖ¸ò\áˆ\Ø_¤\ác’£ñô¬¶„Z0\Ø£?Æ˜*.”\ì<9|ğ0BÇ„×ª\è÷\"\æ¤\ç#k\Ä,.‰*@\Ë„\Zôß¶\Õb\ÍÇ¡\äW=H\ës¢œ®¬u—ş·’7hf‘7s´t\ÉÍ¢\\@øóÄ‰ù\Z\ì¡pğñ\ã©ù\\~\"°o\ïgBZÕ€\ë\ËıEgsDŒ—±òÀrr*Qj® q“Q\Ëv\×´&3\ß\r\ÅVkƒnBßR+k\Zz\'Q\Å`\Æm`˜şói…tW7\Ñ\ÜG¶PÀQXS\Ú\é\í!s\æù­#¶¦Rò$—Vµí‹š\ã¼A~\×\röu\ÏP+gSº·±€´j»b¸§»\\4q\ê}kX\Ä\ÆR\èuş\Ñã¿¼Øº+7Mı3]\íİ\æ€\æ;˜Y0>R\ÜWœøC\Ä?Ùš´o\ä«Ç¸gvA?júN\Æ÷Iñ.š!`’e~hŸ\ï/\ÓüEY“8+\åNiX\Ì+Ì¼u¬yÌ¶H\ß}¾l}k×¼G\àk\È y4—i£\ë\å¼?Æ¾}\×lõ=jY/\í\İp\ß)=¢ÀŒ\İVo³Z¬(y\"±¿:³}9¸¹$ó\éUJó‘\Å1Š\í\Æ+SF·tqrF\re\"4\Ò*¤â»…‚+M\æ;v/z\0iñ\Û_E\Z1*>õz6…ª\Å}\n\í9b:W‰Z\åœÿ\0\ë\í]/†u¹m5µU]Ğ¼ô Lö\ÈHÇ·qUoô›=In<\Ïj‚\çW\ÓÎ\×P] |vpy÷Eq1x¢[@JX²3r1j\ZS\ÙHQ”ñ\ë\Åf2?wñ¯Gx\íüAb²Gø\È9®3RÓ¥³™•\Ó\éLFbı\áœ\Ôû‚ğ?\n„|­€~¿Zz\í\'š\0\nOJŠE$Z³ƒ\Î3ô¦º`d\Ğ!c\ÛÒ“o8\'š~H\í\×Ú)‹úP€:ú\ÔÀü˜Çµ@U”Ÿ_J‘I+‚8 	@*Â¤s&<UO\ã\ã¦*H\É\r\É9ú\Ğ=GOWc ô®Nò\ÖKw,Ú½q†\á½+#R\Ó\ÖUaüR¹T\èüI=é—–\Ïm.{)‘>ON”†^Bvü\êe$\0U#p_Î¦F\Î2úô8?7Š˜m \0j²·\ç¤1×š\0¶8^\Ç<Ró\ì* \İ3\ëŒÔ¹\àğ(Ã3Ï¡£\îzSAİ‘Œ\ZQ»púf€\Z[\r\è;gš\ÜqùTM\Ît§\Üô 	•J \ÇSFĞ¹ÔÀ\ãŒÓºğ3\ê(¸\\c\Ô\æ‚\ïC§øfNy\ÇÖˆ2rG\\\Ğ\çÀ8 ¾\Üñ\Î;\Ô.\ß( 	#û\Ø¦a€CPy\Åñ†\Z«HrA\ë\Í+”Š¥»¶hI\ç\â¹\Õñ.µ¡^IooÂ®7W-Y¢`œ\Í;S³Ê’\çhN:Ò¹j7F·¹ñş\í[V]Šr-\Ã`~\0p+¿o\rZG\n\Åj\Æ)pœ×—6’¶Ì¯m#$£À\â·ôK§ºYkK\ç\Ã\Ğ8<ŠJIšJœ¢®m\\X^YN<Øˆ@:Ö´ô\ë™ p\ÈHaŠ½m©%İ°¸\Ó\åKû6\ë\åÖ¥·]>ü\æ\İü¹G&6\ã\Ì\ï}\Î\Û\Ã\Ş$¢\Åpp@\×Y½eŒ2Ey\Ã<\äcø…túOˆ…¬!.\äqÁcBa\ÈúOşC|$¾\Ñ1\ßxÇ•¿Â¼3T\Ò/´{·µ¿¶xd^\Ä#Ş½GÀ_\Z\ït_.\Ã_ö\Ä\0\àşò1\ïı\áú×°\êZ…¾#\è‚\æ‚\æ9\Ë,g}ı\rQ•ûŸsŠ\Ùğ\ÜñCª\'š\ÅPœ.\ìş\Öx\ß\á>¯\áy^{h\æÏ®\à2Â¼õ\á\Ã\n{C\"\ÜÂ¿e˜£\å5U5\İ*d’\â)A\Æğ¹ }Gõ®\Ã:\Ê^B!–M³/Oz\ê‘\ç˜—º\Äÿ\0úªFj\Ï>›¬\é\ÆI«uÄ‹}Eqz’\Çj\åmö \×V–\×jC|n\àıÉ¬½^Ä²\ÒF\Ùc\nqøŠ@s0^\É\ß\ÄOqÚ·\í<^ğ\áV<üF°¤„@\Ä\0X¥Q˜l9À\ïŠM\\¤\Ú\Øôˆ|v[d”®G>”‡\Å·»\ís^Us<\ã•±Ù€54\È\Æ\ÊO÷@È¨öhµU©&»bN<À\ßğ:¦\ÚÕ²\È\n“ƒı\Ù3^_,W2şó#¶5v•nTö¦© uY\ßË­#ğ¯\'ãŠ£wª„Œ’rİ²\ÕÈ½Ä¨23/¨ª\ï<’\r¢]ş\ÕJºŒµ¨_K{>\Ò\Ç¨V­D¨Ñ\ç½*\Æò©•ûV†fö•l\îè±¢·=Ö½£D²k]69‹‘*Œ†^k\à9¯\'¿ËpA¯V\Ôe–\"0q\Å&&Imñ&\×L¹\Ó]mŠ\íµ.\0\éşğÎ·u¯\è~1\Ó|\Â\"‘f\\¬\Ñ\à†úúÿ\0:ù\ÇÄ·§Q\×v†\Ìquú\Ô\Z?Ä­g\Â:¨şÎŸu°?½·“”qı¸¦¯~\êZq`=¿P£Ÿ\Èÿ\0C\Íy„ñ\É<R##!\Ã \×\×\rø x\Ö¶wKk\çkIú?®\Òx#Û­fx\ß\á—\â(š{ü‹ 8Á\çğ\'ù\Z\0ù»Ã¶?i»óXeR´|EpÈ«i\å¹\"ºwğ­×„\ã’¨›)’X®+‡•\Íö¥,§œœ.i\0Fµ£9-À­\r6\ß\ìškÜ‘û\É8\ëY·ª÷­¬\0’ƒ¦*\Äw“Kn¶ò¸\Å0’\Ê‚pMGsw0—ªõ\æ\0	ŸS\ëQ°\n­HƒÂ¾0¸\Ó\îc.ß¹\Î}+\Ø\Z\Ú\Ï\Ä\Új\Í\äd2œ\×\Í\ãuµ\Æ	Â\Õ\Üø3\Åòh7ª%,ö\Ì@e\É\ãŞ˜\ÍOK–\ÆwD ƒ\éY„\í\ÇÂ½^\ål|Y§,\Ö\ì¬v\åNyúW\êºd\Ú}\Ë$ˆA®*„PBøT„\0	\çÚ¢z˜N(m»ÚœN*D\É\äŠvhI#\Óó¦{cÂ¥(X‚G´İ½A\ë@<sÀ©S\Ó8ú\Ô8²qõ©BñÖ€$ƒ“W#H\æ]¥FZ¦¬ òhF(Û†G¦(¯¤€	}Eq·v¯o#3\ë^¢†;¸ö°\ËW=«\éh¹\n¹\ÏNzRŒŠ]\Ì?Æ¬«œ\äv¨/-\Ş\Ş^\Æiÿ\0w\É\î)¾$sR«~UI$dŠ™[\é\ï@Ñ‡B2;\Ô\Ê\Ù\ïƒ\ØUT¨À\î{Ô \0{ŸqH	‡ù\Ï_Jpr6ô\Î)ŠpÀ\ã \Í*ö8\â€7Á\Å(\àõÇ§™Ú ”„\ä?\n\0dsN\Ï$~Uòc \0òI\Î3Ò˜İ»’}(p ¦9\æ‚X\0A\Å@}\ÔtéŠ¯#\áw¾ô\âpI\'9¨2¶\0\â\ÅBÒ\à}j\âGúô\Ø\ã£Œ\ã¹5r%\r\0\ÇQRÙ¤P\Ø\Ğ\îÁ\é\Û5©j™\á\ÇNi\Ö/t\Ç\Ğw­\Û}\"Gp	\'§›‘¼`s\Ó\èirùBø=»VT\Ş\Z›!Ï­zœ:RAV\\·|\Ö}\åŠ\äñøÔ©”\ã\Ü\ã´m&m\Zq=¥\Ã\Æzğ­\éu{Û‘\î\ë\ÎÜ ùI÷«ŸgŠ\Ş\"ò\Å`Ü¬WwWŒc \È\éT¤Ê…i¡\Ö\Ûj—\ÚPQ©D.,\Ïİºˆd~>•\ÌøöñfXgÓ®O–O!\r%­{¢6a:\Ôğ\ĞI\Ó\Õj\æ\ÓÃ$A%´†\Â\äòñŸº\n\Ò2]LªĞ3Ä»\çƒô­\ßø·Xğ .´›¶»\ÆNQıˆ¬<qÓŸ\\\ÓG_J³”ú¯Á4@ºn¦‰g¨8Á†SòH\Ù?Ò³<mğKOÕ¥7º[}šBr\áGğ¯š£fFVS‚W»| øƒ\â[\É_J»\Åõœj6\Ë.w§¶{\Ğ-ƒDøGªF\ï\æJ7…wš\×\Ã\Ë+{µiQ2] ”C~«¦Ó§š\êñ£š 6œ‚¿@®xEµù’\á­\ŞØ¬©Áqš‚é 7\"\Ğ\ÆO]ª1]g.,a\ÖQn~ó¦+‰¸¹óG$g§<Ô”™Éµ³\Ü\êÄ¸+<f’M?d\Í6¾\ëÁ­\Åe\ÂBY=s\ÍM0¶ÜˆWs\Ó)\ä\Z\Ól—‰®{ŠwöT‘––6\Úû„d\Zê¯´\æ\Ãwn™Ğ¡E2hcx\İ\n\í$rj\0á¦&v\Û_‘‚0sYò.\Ç\ëšÜ¾\Ó\ËÍ…ù°\ZÊ¹³h¸\Ë÷¦€‰#\çi*Ãµ)\ß	ºø\ÅX\Ó\áy$\Ø~ùN•K6A¦\"Š–\é¼¸«‚Í§tŠ›/Ó¹5\ØÉ˜Efs\Ó\ê\ŞğŒ6V‹{y‡™‡\0Ÿ»L\ro\0\èò\éú`y“kã¸¦ø\ËW¶SHu2H-l08\ÏJñÿ\0\ê-w}”gŒ\å\ér’K\ä\ÚMu!;Ü“ŸZ\å¼\ÇbO^ks_¸Ø©l‡X c\ëLd\Ï-´Šñ;#)\È*pAõ\í_\r¾2jğ:\é\Ú\Øk\ëU\0,ùı\âñ_x9®\Ó\Ã6Ÿd´ûCŒ\ç4õF4é»•£ºˆŒe~ú{OÆ¼‹\Åÿ\0¤°2\ßhñ‡LµF\0úß‡æ¶/\ÕtŸı³Iºx^Uıˆ\èE{·ƒş0\éšÄ‘\éú\ÉK+ò\0Ÿ\İ\È~¿\Âi\á:mÆ”ng¾…¢—$\0E`LJ_yŒxcšú\ãÄ¾\Ò<Mn\Î\"™\ÆC§\İo~?˜¯Ÿüiğ\×U\Ğ\Ø@\Ò\Ä9R98ö\ÇZ\0\ä·#f˜\ß{#§jŠ\ŞLÅ±²pxæŸsŠ\0†\î6<÷\Ôv“nR¬\Ø+Ò­	\Ç\êj„\Êm\çƒ(h½ğ‡Œ\åğ\å\ĞY_}«<\í¯`¸µ³ñ^–·6\Å\Ùr¤s_2O?œ\à÷®÷À>;Ÿ\Ã÷±X\Ü’\Ñ\ÈŸ¹\ïLFŞ£¦=„\Í¨AC\0 æ½ƒT\Ñ-|G§-\Ô2Ê°=k\Ëõ-6]:á£•\ç¨E\r\Ø=?\n—!‡\ÍÓµAÕ<S÷gÖ€&\ã=0*Œœ}*^Ø£o\Í\0A€£şôƒ uúŠ°È¤t\éQÁ9 	@(\ÆzşÁ¸Šp$ó@)1F@ö­-a¾\\t5ƒ\0\Z–LR‚	\Í\0e\ëº%Pş•\Ä\İ\Û5´™\ÇÒ½rW[»|0\æ¹-_I\Éo\àô4šq‘ÉşõeN@\ë\ÓÖ¡º³ky0\Ø\äÀ\ëHe\åaI«*\Ø\ã=R»“\Æ9©•½icy\ÍI\ä`ƒ\ÏjX€=)\ê{f€,`8\Å8v\ä\n…[\'	5 \ìy¦\0I\Ü9ÿ\0\ë\ÓòI\éÒ›\ÎH#?\np#²\àPm‚x<b£2œúô;3\åü@\ïP±\ä`\ç?­!İ¶ <úÖ¤Zv\ÈC¦¦\Ó,0dƒŸ­k$ñ•-–‘öwœ\Z#\Ç·\ä¶M…qÓ ¬+»YQñd\çHµ¡\Ñ\è’~ıd©8Ç­zæ—¤\Åª\ÈpdqÛµxm†£–Á®	.?„v®\ÏÅ¶ï††ñ\â>\ÌT\ÖN\ç¥Fš©\r™éš¥¤Vö\í$˜\\I¯.\Öuònv…p?ˆ\Ô÷’¾­dÔ§”v\r1aùf²&\Ñd\Éòœ\Z”»›G\nÖ¯Rœ—s\Ü1i¤g#±\íJ³6:ŠW\ÓnTpi\r¥À ùD÷\éZ#K[Br\áÁç¹¬ù\à+6øØ©\éÁ\Å\\H\'\Ï1·¯\"›4e[%÷y¦D•\Ï-8\Ú:û\Ò=(\Æ\r&\0Ç­t¹\Çò\Ív~ñõÇƒd•#°‚\îˆ8f*\Ê}ˆ\Íq˜\È\Ílx[J}o\ÄVV¥„’\0\ŞÃ¹ü³LõÇµµ=J{an\Ó\rÁgµt³—9A–\Úp*¶‘d–\ZlP\"\í\0t¬Ÿø‘¼?o‘ª;“’¬zŠ\'x\é5K=B\â\âò\ÚHÔ•Jò+}a\á\Ô\å™\Ùğ[¢ŸJú\çN\×4\Z\Ú5«ùm6ß\ÚB7¯\Ó\ÔW–x\ç\àp\r%ş\Û\æ0v?\áRRg£x†[÷a—=ó[>KC6Vú&#¨İ\ç\\ö“¦\\\éf¼…¢‘x\Úİ«3V»!]Õ>†‹’¶\ß4‹\Èâ¦¸‚+ƒ\æ/w5\å:GŠ5	ö¢±wæ·›\âùFŒsÕ³ŒÓ°\\–\Éóv\Ï\ê\Ö«a\Üµb\\ø\Îf\ÃB\ìŒ\æª\É\ã+ù\×÷²\à`E€˜\Û\\\Ç0tG0µ»\áŸÿ\0\ÂS®\Çg{©C§;ı\Ï0|\Ò{/AŸÆ¸–\×/\Èoô©NqœÕ½w^µ·.\íón>ÀP\Ñ	ğj\ÓJ‡\ÎÓ®Zk9wú\Z ²^X\ê\Ù]B\Ğl<\îkª\ÑuË­\"\Ö(.\\@Š\Ü~eúõ\ÒMo¥x\È*\ã†:\Zy¯ˆõ\Èm\í[\æû‹^6×¢\î\î\æùÛ¹ÛŸJõoˆ?µ”±‘ô\ÙM\Ä#“Ø\ï^!¨%ÆŸµ•<‚1LFe\ä\æ\æ\íÜ§½W9ÖœW½4±#³¦Úµ\íôpœk»Õ¤]7F8r6XX\áºóf\\÷Z¦ñ%\ç\Ûu‚3ò\'_L\Ò:\Ê ›§ô$ú\ÒXŞ½¾¥ö–M\Êzf¤¹% \Ùr]\Î8­V\Ú;ePeÀbq@Ÿ…>)k¸Xİ¾×§±É\Ï\İ\ì\Õ\îzŠ|?\ãm<­¼‰#û\ËYxuü?¨¯’­$\İ\ìóV­ontë”¸´™\á™NUÑ°E\0{§>\r\ÚjFK\İ\'\äŸ\Ø:ÿ\0õÿ\0x†­\á\íGD¢»“ñÁ¯]ğo\ÆÒ¢+/¦G\n/#÷\×úŠôûı\'Cñ˜³f+ˆ¤_’xˆ9ÿ\0¡ \Æs\îMCtŠa9\ê+\Öüiğ‚÷J2]iƒÍ·\à?Î¼“Q†hn>\Í*<n§\æ9 \nQ.\Ä-Z\Z\\ywºs\Âôª®†B° \äŠD2\Ù\Í\ä\Éòƒ\Û4Àõ_‡¾?}\Zùlõ\İk#aXÿ\0¯b\×|1‰´ñwjPÍ·*qÂ¾Vœæ½—\ág\Ä\Ãd\Ñhº´™ˆX¥c\Êû\Zb1¯ô\Ùô\é\ÚP©ª;±^\ï\â¯\nÁ¯\Ú›]¢\ç$\ã^)©i\Ò\Ø\\¼3##© ƒ\Æ\r4\ÄÊ»ˆ\ÇLTÛ†\0\Ç\äj¨¸ô4\ì@”;x9õ^İªd\äc­)\Ô]\0R\Üt§õ\êxşTİ£\×ñ #\åºTª77	$œ=i\ÅXƒÒ€.G/•ƒ\Í[1¥ô%xÉ¬ XıZ‚vˆ©^\ÔÁ\Ö4V ¦F~ö+ºµ’\ŞC\Ç~•\ë\ÎRúˆ®;YÑŒeÏ—±\Å&†6\'\Æj²¬ñ¨nm\İ\Ï{\Ób—üi¿~œ{\ÔÛ?J¦$\Ú¥L¯\Äv¤‚H8\ÅJ§_ZªùT£$h\Ö8\àö\ïQ9?Q\íG™7uú\Ô.\Ädñ\ï\Í\0!q\è2x\ÅiišsJ\ÂW\àjƒO°{\É\Ã6Š\ì!·X£U´ŠH‚8x\nŠ±µS\0\0>´Û‹ˆ­\ç\0š¢†[\Çî±ƒ\×Ú¦Æ‰—~Wm±òGSU\î\ÊÁ\ËóLGaRH†–?j¶¡\r\ä*\"B{ŒÑ¢*)\Ëc–Ÿ\ÃZ¥ıñ˜Ê±ƒ\Ècœ~5ÖŸªé«¶hñ<\Ø\Îx®\Ş7R¸LMs(R?„mşT¶Ze\äz’\ÃA\êœ\ÔûE³6ö2Z\Ä\ä¬%i mtwÿ\0pg5µhº¼O½•\İ}\Ö\æ¯\àD¸ÿ\0H3kq\×Í„pO¸¬¨uo\Ãß¹\Ô\í\Å\å <\Í\ÉŞ‰Bú\ÄÖ–!Á\Úzm\Úö\â,D\È\Ç\Ô\ç5\Ô\Ú\éf¶3^J[%q€*®‰¨\é:\Ô\Ë5½\Â+/%[­;\Æ:ªXh³\ìœŒSY\ÅjV#- \Ì\ë_i—Úœ–‘‚\nœOZ5ô½„ª\Ù2.¼sv~’=\r5|ı¨\Ä\ç­n\éÚ”ZÆF\Û<G\Íh\â?oS¹\Èø§á­\á«\ÆŞ…\à\Ï\Ë&\Ş1\ï\\¤š=Òº§¾A¯ª<3\ã\ß\rxş\Ó\ì7&¼+†·}\Ô÷®S\Æ_	\å·2\ŞhÀºr\Æ#\Û\éZİ£\çÓ¦\\.F\Î=A¯_ø\áf—Z›T>X\0DÏ©\ÎO\ç\\t\Ö\Ò[]y\Æc‘x ŒW\Ò\rôQ¤xV\rÉ¶Y~v\ã×šh\Øp°¯ø…«}«Td÷q\nõ}Zñlt»‹‡8\n†¾xñ-ÿ\0˜%‘,Ç½L„;\Õu«\Ë}enl§’)b|¬ˆpAú×°ü?ø\é\çyZwŠWÂ­\ê¿\ï\ë^E0Y%fdû\ÇÒ¡bIˆÀ\çÒšõf¿\àı\Æ\Zx&@\Ò.RxO\rùW\Ï?øu®xrF“\Éi\ìó‘\"\à{\Õ\ï\r|@Õ¼)*\Éi!{SÌ–\Ò‘¿Àû×·øO\â‡|dm\Ã$wxÄ–s}\ìú¯¨úPW‚1\ëIÒ¾ñ\çÁ+kÿ\02ûCTÜ±Œ\ê?¨¯\ÕôMCD¼kkûgŠE\ã‘Áú\Zw7‘A\æ”ğ8üi;S\0¯XøI¡\îiu9S\íLúş½yu¥»]\İ\Åc-#…¾™ğ®’šN‡on£A)13RH·\â1œš­¨\İ>«5¼\Í‘Œ\îZÒ„ešSÂ\\u³\Ù\ÊÃ¿Ê´„v~ø³¦\ë\raª´¹VÚ²“û¹?Àş•{\Æ\r4_Z™4Š\àŒ¤‰\Ğÿ\0…|\×w/Ø´\Ò\ç\ï¿s\Ô\Ö\ï~/k~uµ¹f¿\Ó\æ	Ìƒı†\íô\éLf_‹~\ë¸a4\r-¸\é \ãü÷®>÷I\çscğ¯²ô/øo\â–E¬±\Í\Ç\ï-\ä\âH\Ï\ÓúŠ\à|Oğn\Ş\Şùµ]2\Ø\å¢^\å\ßğü¨¸[§\Û\Ùhk\"’*ö\ï\\Š¼“d\'\ä\×M\ãc³h\İ\0<‚1\\ü¿\èÖ˜Só¿A@‹ú-¿\Ûug¸a˜aştºœ\æ\æ\îB9À\ï\Å7J\Õ\ßL’\ÔFD¯œµF§›ş4BÜ´78\Ï5d¶Zª\Ş’,¹\àÔªC(oZ\0”\á­\ák^\ÔO\ØnO’\Ç/œ£~Œj­\êD«œƒ\Î(\ê\ï|O\Ñ|T‰m+­û%?+ñü\'¿Ò“\Åÿ\0´\Ä\ÒGÁrÁ>ŞŸÊ¾RŒ\Ş_–\Ä0Á\È<Šõüd\Ôôf‡OÕ•õ?º·\ïcÇ¸ö4¬3\×>\ê¿‘\î¢i#^Qöö®*ş6–C.>a\é_gYj:Œ4\Â`–+¸Hùğ\è}\ÇPk\Ì|gğb;Ÿ2\ïEûÇ“?§Â‹\à²‰#Á\å…ZO”†S‚­Gª\è÷ú \Ñ][¼x<g¡ühFüsLqø]ñ=cXô]n—8‚w==‰¯Cñw…!×­~\×jŠnB\ç\ã\ã_;|?ğóø‹Ä\ÆU¾\ÏJ{{ó\èk\ê}1\ØD-À\Ìq(¿¥>{¾\Óä±\ãt ƒ‚\éTºÚ½«Æ[\å7–ñ30QÖ¼vò\ÎKY\n:A\ïTµ79éŠ“\Ì$\ã5~¸©{ş4\0ğ„\ä©\â”ü£\rOV\â‡Á9•\0D¼ñŠplrE)\ä`\nh\0ñœ\â€$F>”ı\àI\ËÀ\ãùSÀÂ“@Rsò­=‘_[ÃŸz\Ç÷üª\ÜyMœ\â€9kEòİ€Sƒ\Ğ\â¸û‹f‚^ø\Í{DCnS©#š\áõ\İ fÜ¹S\Ğ\Òhg«»c¥XW˜5^\êİ­Ø¼g“Drp9ü)yŸğ©ñŠ¤S§$c½ ,1#¯5­«\İÎ *§`‹\É\'Òº\İ.\Î+<\É>ñf€/ZZGgn\ĞMWºÔ„cdXf\é\ÅVº¾{‚QÕª\ÊV,e±Ö†Y\"DÒ¿›pÄÀÕ¯9¤‘cŒqÓÖ©®ù°¤·@+\×<\àTHR\Õ\"\Ë71F{{Ô±£+Ã¾a\n\İŞ¯$ePŠ³s¢-Ö¤2ª#OQ^>—»\")¯¡+\Zö\Ê+p^Y—NZÁ\ÆmP©£&\r˜\áQ\Û\èQ\Û\ê{/\0qV#»‘˜•\á3\ÇÓwa\ËG³‘_XŠ-†…OÊ‰\íŠ\Ê\Õ<;\ìm DŒ»G_­H³4M¸VµÊ°\ê\nµ¤c\ÊaR¯>‡\ë0\Ü‹u6\î9\ÛñùŠ\äu;=UH[ó-İ²—Lğ=\ë\è\è•e\È\åMq^$Ó¯`F»²Mø(Z\Ò÷\Ü\Ä\Ë\Ğu­:\ê\Î;x¥\nUqµ¸5CXğÔ†c{¦I\ä\Ê\Ü>\r\\\Ğ\Õô›ë¦ş\İ\ìoıø\Æ9®†\Æ}J\Ñ1m2\ŞÛ‘Á=jm¨G\Ò\ÛÊ’Á+F\èAVFÁSõ¯lğ\Ç;‹_+Mñ8i\àû«v«ó/ûÃ¿Ö¼Cñ§¯OZ\ĞG\×úŸ„<5\ãhmõ+fŠNC¬\Ñ‚+²‚··HP|¨0+Ä¿g\í2ñ,ï¯¤šQl\Ì\"\Üvçœœtôü«\Ü	À\É\í@\âFª-´\ä´Vù¤\äŠù\Ç\Æ\Z›¬¾To‚8\È5\é¿u·Ÿ\\”`\ìŒ\Zğ\íb\è\İ_;“•õ;±•\Åı\ÈÁ\Z_\í’A,\ÏqU\'°\Í7&¨¨\Îñ˜\È\\AQ[\\Mkp“Á+G*\Ê\ê\Ø ı{T]\é\0\îE\0{¯><Ml\Ñi\Ş*X¸U½Aó/ûÀuúŠõ­[\Ã\Şñ\î&S\ÄS.Rxsÿ\0×¯ŒG9®Ÿ\Â^;\×<y\æ\é·$DO\ï-\Ü\æ7ü;}E\0t9øEªøjW¸²®ló\Æ9 Zó6VBC\ìE}uà¿ŠñÅ¸²˜¥® \Ãi1\áøşzÿ\0:\Çñ\ßÁ;]Y/4¡ö{\Â2@\è\ß_Z\0ñ/†º?ö‡ˆî¿»‡ù\×\Ğ(B\Ä}8¯7ğ–q\áG{[\Øö\Î>õ\Ş\ÚN·‚­£šL–[¾˜Z\Ø\ã¹µ\ã(¾ş\Ñ\×*sg\'\ë^‡\â\ím-­&l\ãj\àW’G6m\ç»lù“Š^!»\\ù*rÒ±#š\â9Wv\ä“\ëPp9\n¡—t\ÍRûL¿†\ê\Â\æ[{ˆ\Ø’3‚+\éüSótø#ñ\"¶\Ğ>Ø½ûÀ:ù†\Ñs0\ÏJÖ»\Ô\å†\Ó\ì\È\çcE >³×¼#¡ø\Ê\Ã\Îar\\G\È>õ\á\Ş&ø_¨èš¬sH¢K\0~ğ\äq\\÷‚ş!\ë*mfó­	ù\íe?#}=¸¯£ü1\ã]\ÆZthÊ°\ÜJŸ=¤ø\Éúz*\ê…Xe‰\Ç÷@\é\í\Ğ\å^ı\ãoƒ\ÖZº½Ş’<›Ï–;ı3\×ñ¯\Ö4\rKC¸ho d ‘¸Š`a]¨‘À<T6²nR§\ïŠ²Àx\ï\éT\ĞùEOC\Ó\"C\Í2`<¦¸§s\Æ?Èª\×nX¬C’z\ãµ\0V„ò\ä¼V¦‘L—nx^ƒ\Ô\ÕVˆ°H\ï0)e²¸0LpO`h \ÒüA¨húˆ¾\Óî¤·˜\åO_c\ê+\Ü<ñ\ÇRX\í<@\Ò\èğ.~\íş¿\İşUó\ÏNüÑ¼\ÇS@^øƒ\Âz/‹,H¹Š7ó+2`\ç\ßŞ¼\Åÿ\0õ?»\ÜX†Ï¶9\Çù÷¬ÿ\0üI\Öü+()EÅ–~kiO\Ëÿ\0ô5ô…<k£ø\ÖÉ°)(–\Şe\éøôaHg%ğ¿\ÃñhWdÿ\0L¸;¤\ã{Àq^¡k‘§ñuc\êk6\Ó\Ãö\Ö:Ú­H\â#&\ß9MŞ£Ò¶h¬¡”«ƒ\ÔWŸø\ËÂÍº{uP\äd\Ô\×~î±£;œ*Œ“\\£\ë±\Ë|VS!\Â{\n.&x•İ¤–Ò²8#«ƒŒ\äz×¬ø§\Ãp\Ş!¹T>2@k\Ë\î­\ŞVF\äöªN\â!V\É§\ØvÊ«/9©\ÖB¾M0$_•yÎ¤úS‹¿tŒ@\ÙßMLˆƒ\ÜSs‘Œ)rJûP\ÃÈ©\æ\é\ÅD¸¯_z•[\ãj\Úv\ÃqÖ´å·‡U¶!‡8¬…0ñS\ÛÜ´\\\àu G\Ä\Z@J”ù;\Z\ãnmZ\Ù\Î+\Ù/\Â\ê6\ä3Š\á5=;2})43’†\\ğ}z\ÕøI<(\Õ\éòG7CZv6dR\İ>• ié–©\n‰\\e³*ô²\'oaHb8¨$rÍ@Á\İU°¿:g™\Ô*–v\íM¶…\çG%Û¥{€üöpš† ƒTB)g~¬+£ª /÷’\":{šô¿•\Õ\à\0¬BŒT\î\îV<ıM!Œ¾½Xc?61\Ô\×ut\×\Ó\ç?ºz}ı\ë^\ÎcF>P<ŸZ‰@UÀ\â˜Œb˜\Í\ïJ\ÇÒ¢vÈ İ±MŠ\í U=E5\Û\ÍS• :\0\É2C‘ü¨\ïùJ\î\Ï¬=6\æd¹¢\îC\ÔUıK\ÅZ^„™k°8‰NBŸs@~0øe¥\êVM¨’\Æ\åF\á!\0/\ã^g,º´R›a*#…x:7½ojş\'½ñ×™}3\ÊD\ÜUX®\Ğ1R/aLµy.\ïqŠš\Ú>\æ8”\ÎB€*1œ\0k¼øM 6»\ã{@Éº?züztıqTAô¿45\Ğ<%gg€.\\ú“[\Z¦«m£Ù›«¦\"0pqÉ«ˆ¡Tt\æ\ß5\\˜¬¸-ZM“c{Vğ\æ\ã/ÍŒ\Æû\Ç\Ë4]A÷¯üsğ£Wğ\Ì\ïs=Í¡9Ü£?­!ñö¯\á]lM¥\\mPp\Ñ7(\ã\ÜW¸x3â†\ã›U±º\Úß°\Ã[Jxsş\É\ïü\èC>Je!ˆ ­ \àóÒ¾–ñ\çÁkMQd½Ñ”As‚v¨á¾¢¾}\ÕôGB¼kkûfÁ p~†˜€x?\æ—\0ş”‡¨9\Ïj\0LŠ^qIÖŒñ@\Å+Á ’7eu «)Áõ\íş2j\ÑO“®#_[t[ş±¿÷¿xy\Æ3^ƒ\à\r/5\ã¯$ü´0gÓ·6:?‹,\È\É #\å–>O¿ø\Z\âu\rPğ\Â\Ê\èqlzJ¼‘õ\Ë\Øj·úN¢²iÓ´OüC¨ob;×¥\è~;\ÓuVz\Ö\é¾]®~I>„ÿ\0#R#\ç\ïkFò\émAÀ\ÎZ¹Ë`Y8\ÖE\Æ5ôŒ¾\ézú=Í’-µ\æ8\ÇC_8x«Áú¿‡//­¤Áú\Ó.\æú\Úv.‘4MœA¨ŠÇ†\ë\íUã¢œµ\Æid¸<;Š®\Ï\æJô\é[s\äqQ:Sô\Çg–­l¦³s)ƒaòš¸c\È ú\Ö¶\äS\0«VO†Gpğ\Æk›ŸˆÕ® \éGÎ¿Qü_Î½V\æ\Ç\Ãş7\ÒTxn\à|³FrG±ÿ\0_&4€˜Ï½[ğÏ‹õ\nj\Æ]2\é£\r÷£<£û@ÿ\0>_i÷zj™\íG8Q\Óü+Éµias\æF\Ê\Èp\ÊG\"¾¢ğo\Å]\Å,\ï¶X\ê1\å»~\îO÷IşF\ã?…šO‰ ’H[]NW¡?\ÓùP3\åÄy‰\è;U{q½\Şg\ÆGL\×K\âk^‘\í\î-İ¡‰\0\í\ï\\ùBv@€\å¸\ã½/i0†w½“•Nœ÷ª\Z–f‘§ş*Ø»kmªõ\ÆZ³$]É´œ\Ğ-\äó#¸©xN\İü™Œg¡«ıı¨c\å•Q³±Â¨\êI\è+\éŸøYtCm·ı.šF\Ş?\çô¯$øU\á\í\rBeÿ\0F³;¹\íùuüE}!§¦òe\ÇÊ¿*\ĞÀ·o†¤e,\Ç$š–ŠŠ\ât¶·y¤8T4†bx—QX û2¶\r\Ï\ì+Œ²F¼¾36Jƒ\Å;W¾’ö\èóó\Ê\Ù>\ÃÒµ´‹Ak\Ç¦\â5âˆ½¸\Îr+‘ñW„\ŞH\Úx”g®1]\íŒ>d›ˆùV­\ŞZ­\Ô2\"„\ìÍ—6¯n\åX`*%`ƒ^“\â¯\n,c¸¯:¸·x\\©>•¢bŸ3{v©ûc©ªjXT¨Ç©¦\Ûü:\Ò\çhi¨\Ã9=ûT†FÒ€\Z†>\Ô\ã€:Ò’zó\Í\0nÇ½\0*¿¡©‘²9ªÀ…n9ÚæŒŠ\0°²²“ƒ×µfjvûÇ™Ÿ˜zU\Ò\ê8\È\Í2Eó”©&€9Ÿ,1\Ãš¬Z±G# =2)—ˆm®}2i\ZP¸>•#.K)<u¨£‰¤m±\r\Ìx\Í2\'70rO¯Vğ·”½½\å€EH\Ëü\n#T\Ô/\Ó\'‚ˆkÔ°B¨À”ˆ‰a\0 `b£–P‹’i2y„jy\æ¹\rWQk™L7\ËüMV5MŒ7\Ì~ñ«*4Ó¯zb\ã0:Só”ñšB}\éFãš…ı\é\äŠcdv4À¯&@Èª\Â7¸F€\ä\Õ\Ï-¤%ElYY[é–yvB\"Œ–j\0K-Gdùû\ì:×\ëÖ²\éZì¡‹c$ñÖ½\ÏNÔ­õKA=³nˆ¯<ø“¤«v‹’:\â‘Qzqw iD«÷±\È±üMI\È\Übzû\Ö}\Éy”*¾\Ô\îÖ¬B\Ã`\ã\é\Z÷‰üªø^õ¢¾·m œJ\r^\çğÃ†\ÇAŸW™1%\Ë\íL\áı|\×Q¤\ë\Şø¡£”SM·ğ\è­uš>“m¢ipiö‹¶W\n+D\ì`\ÙrY(F8\n	5ó÷5ƒsywt[\nr?•{µ1§x~\\6_”};\×\Ì\Ş.\ÔH‡\ÊwO\ãPõvqwó››§s\êj\åx¤Ibb®œ«‚­4u\ès\ÓÚ„\æ¬g²ø\ã\æ”b\ÓüGº\ê\Ó\î­À¼O¯¯ó¯e\Ô4_\rüAÑ…\Äm\r\ÌR®VXùüı\ë\ãP@Š\è|-\ã=g\Â\Ës¥\İ\\üğ·(\ã\ÜZM\\GUã„z§‡%’\æ\Í\âÓ¨\Û\Éú×™²l0!ÁW\Ö~ø§ ø\â\ÜXİ„´¿a†¶”ğ\çı“şMdø\ï\àÍ–´’^i@EuŒ\à\×Ö‹ó	\ã½\'S\Íl\ë\ZÔ¼=v\Ğ_\Û:p)¬ƒŸAŠ`Ki¹ºH\0\å˜\nö]&\Õlt\è£U\Æ¥y¿„,<\ëÿ\0=º/JôŸ42¬y\ë\éIr\Ü¯+u®3Å—\æ=°\Æ\Ä;Æº\ë\ÙÅµ®?º2k\Ëõ+³y¨\Ë#•x¤#¿ğw\Æ}C\Ã^M†¯¾şÀp7\ï#Ç¸ö5\îV\×^\Zøƒ¢y¶ò\Ã{n\ÃûñŸB:¡¯Œn%2LH\ãŠ\Ò\Ğ|GªxsP÷Kº’\Şuî§†„t\"˜\ÏTñ\çÁ+‹6÷Dd=L`tÿ\0\nñ«›9\ì\åx®\"h\äS‚®1ŠúkÀŸ\Z´¿\ì5\Ñ…ùÂ‰	ı\Ô\Çÿ\0e>\ÇÖ·<gğ\ÃEñm³Mi\r\Ñ\\¤‰\Ğ\Óò\'Œn†»øTğ ’+›vhÁ\â@21\\cG´•#ğ¦ -w=ªkw\Ãö<\Ô6\ãqe\âŸ\Ú\äf·(À\â¨]®É’QøŠ·\İ=*;¸\Õ\à\'hH\Ü\í¤şu\é~ø½©x}\ÓT\İ}§¯s~ò1\ì\İş†¼ºÑ‹ÁŒ\à¹¦İ¿5\êh\ì;\rOÃ¾;\Ñü\ËY¢¼‡*xxÏ¸\ê\ry‡Š~+—\Õ4e2¨˜‡Qø…xŞ¬\êZ\rü\é72[\İ\ë\ìGq^ÿ\0\á_Œz}Ì\é\Ş$’;;\Ö\0b\'>ÿ\0\İ?¥!©\Ú\İ[^8º‰\âT	Áõ¯‰|£xªÔ»G•\ÆVd\ä7¿\ÌWx\Ãá®­\á©ZAMo“µ\ÔgŠ.#\Ï.Ô†/nµvÁ$¾–!Rò\ÈÁUGrN1£%YXs\é^•ğO\ÂM«Ë¬]GşjvÅ\ïO\à8ü}¨×¼\á\Ä\Ğ<=m§\Æ™¹w\ÇRy&»ˆ£X¢X×¢ŒU[(FL\Ä{/Ò®\Ò\Êx«S\n>Ê­ò§\Í\'¹\ì+¡¾»K9.øG\Ôö\æZŒ\ï{vP±,Í¹\Í&\Æ;L®nL\Î:+¯¶‹jª¦³t»QJqÀ\Ñ\é\Öû›\ÌaÀ\éRûxD0ª÷\ïR\Ò\Ñ@\Ê:’\İÀÀ€N;Šò\ßxp+;*€~k\Ø++U\Òã¼ˆü£5I\ØM=\\@\Ğ\Æ=EBi\×{\âO\r÷:©\r\\,ö\æ2TY §\rş\Õ*•-Ò©†©…=>´À»\Ô\ã¶)\"¯ \Ïzƒ\Î-À\ëNTİŒ\ã?Z\0vC\çœ8\ĞÁ1\È\Å	€ø\ĞŠzš\nAô£vTóQù™Ïµ\0bk-™A\çŞ³\ŞEØ \æ­\ëıI\Åiø3D—X\ÔPò€‚jX\Î\Çá¯ƒ\ë­\í\Ô(\ä^\ã)o\n\Ç\Z€ `T4]54\Ë\âE\Æ_‘À5¤$’&¹\ÍgTò‡•ÌúUWSñœs!û¢¹pZIr\äó@Á‚X’Xõ5\'n(ƒ¬BŒ¾”\0\Æ4\ÜúŠi4v\Í\0!>´\ŞX€¹&—vF1“š\×\Òt\Ã#y’=i€\í3MDSq9Td“\é^Iñ7\ÇgU¹m#O‹H¯ñ\Z\è¾(x\ìXÀtM*O\Ş‰]{Jñ›Y¯\î@\0’O&­D›\Õğ‡Tóô†µc“ dö®¯Å¶¿i\Ñ\å_/{`\ã\ë\\‡4\Æ\ÒYX)\Ç5è³$x\ê¢Q\åcN\ç\Í÷p›{–FLñLV8#¸ö®\Ç\Çz_Ù¯\è˜\äñ\Åq!Á\å¬\ÍS6~hRj^1¿:Áh»›\0“œ\nú¼¿\à‡Æ“\àÔ½‘q5\ão<t^ƒüû×¤^\ŞEag-\Ô\Ç\Æ2j\äby\'Åeÿ\0´\"³@\Û#\Õ\à\Zı\ã]_0\ÜpZúè¯‡¼s§:’a\0:q^\ãÿ\0ƒ—úL\Ò^ia®-N\Î\â¡h\îQ\ä\0\0zóHA\à’*I\"xdd‘\n2œ#S\0\ÅX~\â‚zö \çu\çš>9$‰\ÖDvWS•e89õ¯bğ\Ç\íÇ§øu\åp·ıdc\ßû\ßÎ¼l;\ç<\ÓNA\ãŒ\Ğ\Ú:w†ş!h‚x\Ú¨%^%NHúZğoüÔ´)^\ëNV¸¶\' H®\'\Ã2\Ö<%|.ô«¦Ÿ3\Ê?±ô~+\è¾5·7¨¶š\\<2¤‡ı“ı)\â^µû§— \ÚıÁ\ê+r\İ\ÃL\Ï\Øt¯XñW\Ãh5{(ˆn9N\Í^U{§\İ\è\Î\Ö\×P´n½r0\r 1¼O«4V…AË·šà¥˜¤$c–\äÖ–»x\×w\ÛzªV%\Ã\î|ô) \"\É\ÎOZ:\Òw L«¸÷¯Jğ\Åık\Â\Í\Û5ş–8òdoš1ş\ÃC\Åy˜\'šr\ç8 ´4s\Ã_t‚\Ö\Ò\Çr˜ı\ä/Ä‘q\Ô*ò¿|u\Ş\è\\¯,c\ÇJñm#X\Ô4mB;\Í6\êKkˆ\ÎC£cÿ\0\×_@xã¢#\ÓüM¶\Ò\ï¢\İ(ı\Ûÿ\0¼?„ş”ù\ê\ëO»\Ó/P¼n!…DÀ,\Üz\××¾*ğ‡\âû?0¤k3¤\Ñò¿\ÌW\Ï^3øqªøbb\Ínò[öu\ãğ¢\àr¶‚Gó«€‚*”£‚jş\ì?*b3\àa®¤ñÖ›\ß3Jx…6ù18\Ãu\ê)\áI	|³t \r-\Ò\Éy\'(ƒ\åú\Ô\Z‹µÁisƒÖ´®Y\Ù\Åf¤glw¬ö__j\0\ì<ñ?Yğº¤;\ÍŞ\Ím!\àºz\å_Axs\ÅúôöKwF“½´˜a\×ğ\ïõñõ»®3À\Ï³e{qcqö³IÑ\Ê\èpA¥`=\×ÆŸ-u2÷Fı\ÔÜ“¯øÿ\0?­t\Ş±²\Óô84«O–H†\ÙTŒ0=\É½k;á§Œ5sCiõ¨Q¡Œ\ìKµ\áŸIş£Ş»ø¢µ’QyFd‘\0óBò\Ëõ¤2uPª\00)\ÔU\rZøXX¼¹ù\ÏÊƒŞ€9¯ê¡¥0#.¾\íX:E£K\'š\ã–5^fk\ÛÀ™$–>¦ºm>\ÜG8¬Û¸\Ëöğ\îdGZ\èbŒE@:\n¥¦\Û\í_5‡\'¥h\ÓQE\n(¢€1õ)n\àb\0\ÍyGˆt7ŠV!y¯n##\Ïk\Ú2\\\Ä]Tn\ÇÓ°š<xLlx\éP(b\Ü\æ»\rkIò¥l®\×\İkœ–)²F\rh@\ÈÀUù»÷©T|\ÙÎ \İ\Ôc&˜ö 	ú·=»R9\Ãuğ¨Ì °9\æ w`}½i4’\0¸^Wk\Z·ÍŠ†k£\æn´ı+G»ñ\êÁl„¦~f\ÇJ@e¥Î­~±[\Ä\Î\äóŠ÷ß‡ş\Z6*0IÕŸø\Z\ÓEµGhÁ”I\ë³\ÂÆ¸\0T6RB3_j\ÈÔµ·‰™\ĞzÕ‹ûÅ‚\"\Îp¢¸ë«—¼œ»œ/ğJC,¯s)–BKƒÒ…ö\ëMúR\î\Ú3Hbœ­FN\ìšFr{\ÓqL¿…3y43:şUKÓ\æP\Ì\Ü\ĞúVšÓ¸fV_\Ä/\ZC\ám,\ÙZ2›\ÙF\0\Ã\îkk\Å>$²ğ~†ò¹Q1R#N\ä\×\ÍZ®«u®j2\Ş\İ1idnzÂ®(M•¥iï®šYi$¤×£ø/\Ã>YI$PIı+\Â’\æUe\åºdW¯i\ÖQ\ÚÄª«ƒk¢+—^¤=I\Ö\İm\àNEiC!’\İj»\r\İG\Û)6»\Â}p+9«\ê4ax»Ošk\árq^)q‚g‰—M}y›¡Exß‹´¿³^³*ğOJÉ–™ô~™eŸ¦[\ÚF0±F~U\ÉüG\ÕE®,Õ°\Ór\Øô®Ø\' ¯ø…­}¯Vƒş\î!\ÏTÉ‰oªø§P\Ğu8g\Ó.š	\â9Ü§¯\Ôw\ë\ŞøÍ¦xš$\Ó5\åKK\æwŸõrı=µ|ß«]}ªõÜœòj¢¶\ÒFH\Ç©l3\ê|#\Ó<I]\éûbº#!—ø¿Æ¾sñ„õO\r^5½\í»*ƒ€ø\à\×m\àŒºŸ†v:™{\í4a\Ïö?Ò½\íO†~#\èl/\Ô.¸$}ôö\"„|cŒC\êEzõ¯\\ñ\çÁ\ÍCF‘î´¥3Zu\ÚHúW“MÁ!IU‘\Ô\à«N÷3À ğzş¤\íHq×¥\0‰\çò®‹\ÃÆ·Y\âLü§¡®t€8Á\ÍK\ïo2Ka\æ€>“ğŸõ-.%·\Ôw^Y¨\Æò~túÿ\0Jô	\ìô/i[Ç—<l1½~òC_=\èZ\ê\êV\n2@0\Ã5$:\æ«\á\İIn´»¦Á\ås•ob*@¹ã¿ƒ÷ú3\Éy¥£\\Ûv£üúW‘M°\Ì\É*2:\äaŠú³Á¿ô\Óu0–:‹\r»$?»—ı\Ò‘¦ø\ß\á.—\âHš\æ\É\Ìdc£S\ä\ã\ÏašLcš\é<M\à\í[\Ã7\rå»„ñÁ®x§<\ãñ¦\0\ÑÀ\ÆE!\ëı(UÀaR… ûú\Ô t\ÏÕ™Hm¸\àPm\àŸŠzßƒ¤HU¾Ù¦\çæµ”=\Ôÿ\0	ı+\è¿\rø¿Ã?\Ò\Ê\Û:;<\ÛI¸t?OÏ‘_¶Bó\ëWôJ\ëNn,\î\ãm\È\è\Ø \Ğ#\Şüoğb;2ûA“©‡Ö¼jÿ\0LºÒ¦ho\"h\İsÁ\ë¾ø\åÇ•§x§¿\n·\Ê8?\ï\ßQ^‘\â	\è~3Ó·¸ü\Å\ÌwA÷\ã­\ãğ¢y\ZC\Ñi,\ç6×«!€é•\è^2øa«xjB\ĞD\×¤ü®¼ñ\\–¯k­œ0*5yf\ïšb,\Í<…\Ø\ç<\Ó\é\ëL·}ñ/\İôúS\Î	í´F\ívÊ²¹­\Â}kSµ±·’w\n1\Øw?€\ÍPš!,Eq^\Éğ?\Âl–’ø‚\î<\Ê[‚?„u?‰şT\êú‹o¦\é6ú\\	ˆc@\Óüÿ\0:\è•B¨U\0\00\0\íU\ì\â\Ùv3óôª\ÕHÂ¸/j¿h¹eFù#ù\Ü÷5\Ôk·ÿ\0a°`§\Ëò¯·©¯:Poo\ØCù\Ô\ÉôöfIÃ“Öº«H²*À\ëT,\àò£s].Ÿo\åC¸™ªP\ËJ¡(\è)\ÔQLaEPEPH@`AŠZ\0\å<I\áÕ¼…¤Œa±Á\ÅyV¥¦5¼\íËµ‡­{ñ†È¬\ro\ÂÖº¤g(z÷¦¥a4xD¶\ÛX\à\ÕfM„•\Ü\ê¾\Ô\í¤&\Ôùˆ:Ö¹›k\Ê\Ä}…\Ó¢h›A•}\ãQMp›:V½¿‚µ\ë·\ì¥«\Z\í<?ğ«$Ú‹o#ø{Rm@ğ­÷ˆ®\Ôld·\ÎKúj÷o\rxV\ÏC´DH\×p•©§i6ºl+ª€;\n¸òª\Ô9\\¤‡\0ª—\Z31ÂsI%ÀÁ$\áEs:¶¦nX\Åı\Ğ\ë\ïH\nÚ•ó_Nzˆ\Ô\àZ¤i@\Í&}h\ÜsH\ìqJ\Í\Ø­DIÉ -\Í4·h5sO°{©F\Å0¦\ØIu(\Êñ]õíŸ‡t™.nUQs\ÏsSk£X4\Ó:¢¢\ä“_>|Gñ\Ä\Ş\"¾kH­¤m€\ëõªHF/Œ<Os\âjI\ås\ä+b4\ì;\Ã:\ê+#§\É\Û\"¨hZDº•Ê€§\ËS\É5\í>\Ğã±\Ğ=+xÇ«%—´m-,­\Ôµ\È\Æ1Ú‘F\Õö¤$Un\"P~QŠ­#yWI \èx©Q²MGr¹ˆŸ\îœ\Ğ\ÕĞ‹Rœ\à\â¹ir‰B\çš\ê\á2>œUMB601Ö¹\Ú-3¬ñ¤º^‡spNiõ¯œ5\ËÆœHÀobI µ\ëÿ\0†©&š‰kn\íj9yœ~\á÷i2(\êG¯j\Í\îRG3{¦\ÃpI‡÷r÷CŞ±&…\í\Ü\Æ\êU‡c]\ÜV©s÷\Æ$Ş©\ê:a\Ú\ê\"\Ê~\ìª:}i©\Çi\Ílø{Äº§†u¼\Ó.\Ş\ä\Èa\èGz§y¥\Ígóº3Ñ‡5K «B>¦ğ7\Æ\r#Å±¦«³\Ôv\ícòKô=µ\'~\é¾#‰®ôğ\"º# ¯ñ|º’2\ÊpG9\Íz¿€~4\ê>1\Øk%¯tü\à9?¼ñ\ïIˆ\à|E\á=SÃ—õ³(ñÁ¬#Ç ¯´\rüC\Ñ<\è^+¨d\\o_¼¾\ÄW„øó\à\åş‡$—zb4ö½v¢‹÷\É:óG\ëRM\Ã#,ªUÁ‚)\Ø\â˜t½FM6ñ$Bqœ0ö®ü\É¡f³\Äs‘œŠó3÷xşU¿\á­`\Ù\\‹y\Û÷OÀ\É\èi0/\êVe‘¼\æ»/üd\Õ<:R\ÃY§´37\ï\"Ç¸ö5—qlr¼†\äZ\åõ}9¢c,X\ÇqH¬#“\Ã4O6	!¼·u\ÆG\ŞOb;}\rx—>\İ\ém%ö¦{qÏ–ù\Åy¶‡\â=[\ÂÚŒwúU\ÛÁ\"@9WŒ:_Dø\ã.‘\âqŸ«ùv\Z“\0¸cû©±=±¦\Ë÷\Ò\ÛLñÎŒ§0\Æ*Rpk\ëo|)\Ò|Q\Íl‹ovFC/F¯œ¼U\à[\ÃMå³”$\Æ?¥09‘Ój~@\ãœ\Ôƒ\Ç*#\çùP\0ÿ\00\Í®D\ŞÆš\Ù #©¦F\Û$[\äœ\à\03]—‚¾!\ë^¹&\Öo:ÄŸ\ÖS”>\ãû§\ÜW3 ô\ß1ˆ¯=iö…<u¡ø\ëNd‹\ÎF%³Ÿ¯\áı\áô®W\Ç\íuX\å»\Ñÿ\0w9˜»¥x”\Ëgi\ØL\ë*aŒ‰Cz\æ½WÁ_\å‡Ë±ñ6eOº·ˆ>aşğ\ïõ¬^h:…vö·\Ö\í)À8\à\Õr8\é_[jz.…\ãM1e&ˆ\ä\\\Çqÿ\0\×^\ã/…Ú‚\ïsjqiÙf‹ˆ\ä<;¢\Í\â-r\×M€\æ¾‡ğ¨\ê*ú¿JÒ¡\Ó,m\ì-\Ğ$0 G@A^kğcÂŸ`Ó¥\×.\Ó\Ïò\Är¨?Ç¯\å^¹•\\Ÿ¼ÜšSI\n	\'\0rM:°üI¨ı’\Ë\ÉFÄ’õö^ô†r¾$\Õ\r\í\Û?/ÜŒ{zÑ¤\ÙmE$s\Ô\Öu¬mwxd?uN\0®¦\Öªª&²¡§\Ûy³GÊµº*H\Üõ©é€´QE\n(¢˜RP!\r.i(\Å\0-RdÉ¤\0U[¨\ëL6Ğ·X\×ò¦\Éwc–Uõ%9\ÚhpG}G\áM{”AY2ß“j£\Ş1<\Z.Ä—™\èj\ÍË¬LÀòg}µ\æ’k¯6Ù¸Á¢\à`\Ş_\ßO©š\éü¡\Õ¥\È\ÅRç¾‘³œUÌ’)ˆ	¦1¥&˜Ş´\0\ÖÀ¨É§1\ë\íSYZ=\ä¡PP1ll¤»˜\0§Ö¢[h\Ö&YX(Q\É=\éa‚\ÛE°k‰\ÙQQr\Ìk\Çü{\ã‰u	\Z\ŞÜ‘E\\ôõI£ñ\Ç\Òjr\Éii#,*zõ\æ\ÚnŸ.£v\0\Ï\'&§’7¹œD¹gc\ÍzW„<2±F$t<œŠ\Ú1$\Óğ¿‡£µ§OZ\ì‘B(ŒS\"ˆDT\01O&ª÷\r4ÑœŠi5HC\ĞóOa•#Ú¢©zû\Õ$&Ed\ÛKFs‘R\Ü\İóP\çËº\rÙº\Ô\×+ˆık\nŠÌ¤uñ\Î&\Ì1„Œ<†úW\râ¯†¶÷\áî´°\Ï\Ô\Â~\ëı=\rw\Åb»ˆ)\äzŠ`2A€ù’?\ïw_Z\Æ\Å4\İis\é—oouC2U†\áRG±\Ç\"C\×5ô»\á½3\Äv]\ä*Í’Uû\Ê}xÿ\0ˆü©xnC.\Óqe\'Aœö‡jV±W¹\Ç^\è¥\ÔoŒòc#¥rZ††$\Üö\ÙWc\"½)À\è{TwZm½ò\î\å\Ì:0¡;ò\áfU(\ã\ÔT|\ç¯\ã]Ş©£n&+\Ä\Ú\ß\Ã(k“¿Ò§²nT´dı\áÒ­;“b÷‡<Y«xVınôË¦‰”\ÊNUıˆ¯¤<\rñsEñ„Ka¨³\Ô`\Å!ù%ÿ\0tÿ\0JùH`:æ\È\à«ÀğAæ˜©<sğƒMñow`¢¼dcø¿Æ¾vñ…uO\r^µ½õ»¦cƒ^‰\à·ºO×·\ŞX\çl\æHÿ\0ø¡^\ã5·‡~ \è‚dho-\ä^$N«\ìilÅ˜#úRŒ9\ë<ø7¡¼—zbµÅ¡\ä\êµ\åBğ»$¨\ÊÃ‚\Æ)\×x{Z0Kƒû\Å)=\ëfkt–\"Zóh\äh&WŒ\íe\ä\Z\íôO\í¶\Ø-ó¯Qµ-À\Õl\ÚRqû¶ô¬¦\Ì.\n\äs\Åw—°%\Ì0\ÎG\Ç\İÚ´.Q½x4\Ó\Ñ|ñŸTğß•aª\Ô4\ÑÀß¼ˆ²{c^ıiy\áÏˆ:/™o$W–\Ì0GGŒúÚ¾.*T	­]\Äz¯†õï´»§·\É†Œ;Šz·>\nOc\æ\ßhªe‹©@:…x\í\í¬\Ör&Œ£¯§Ö¾˜ğ\Æ}/Ä‹†³\å\Øj$\ÇL}ğŸcZş4øa£ø®š\Ö¼e]8\rş*w\ä¥PÉƒô4\Æ]‘]o‰ü	«xV\éâº\Ì@ñ W)*zc4#1\î\ì*(Ü†\Í]´ı\å«AT™v¹ú\Ó±hÛ£##«$\0F\n¡c\'NkG¨úq@\Zõ¿]¬úm\Æ -û\Ûg\æ9>£±÷ô\'‚ş\"\èş6µm_ıå¬¼†õ\Úz_/Mhˆ\Æx¯|ø7\á¦x]µ+\Äÿ\0J½ù”Ê§ğ\ëø\Ò`z5®öÀÖ³²Yœ–·am§°ö­j‚\Ò‚\İ#’F‘\ÇVcš\r‘\Ö(\Ù\Ü\áTdšómvı\ï\ïX‚r\ç\0z-u^&\ÔD\ßfVÁa¹ş•\Ç\ØB\×7vO}ii–‚4+¦\Òí·¿˜ÃÒ³\ím\É+\ZMt°D!ˆ \íR€’Š(¦0¢Š(\0¢Š()\r)\â£yU{\Ğ!ôd¦ª5\É=*	¯’ÌŒ(ô“\08\ëX\×\×w\n:UKtg¯\ãYs\Ş\Í3d·\\d\ï<²1\ÜÆ‘Y‡sUVR9\'5aXT!%¹\'õ¦g\Ü\ĞÆšq9\ïM™ö[údHO5OSŸd,e¦„R³;Ë¹\î\Õo5N\Èb\Ü^j\Én=ª„+Î˜XŒó\Í\Üõ©!\îdƒ½\0%­³\İJ\Æ}+²³³·Ò¬\Úy\ÙP*\å˜ô3M‹O¶3LUvŒ–=…yW<oı½q5”…4›c‰¤s\áŞµI¼ruGa±Cˆ”õ§û\ßOJòÛ¹\ä–b\Ç&G?•[\Ô.\Ì\ÎÒ¾TtE…iø_@–ú\èO2g ZF7¥\àÿ\0³º\Í*\å<ö¯Rµ¶Kx‚\0A§X¥œ\nªqW3\ï\íV\ßD4‡€sL\ÎM!9üi´\Ğ1Àƒ\Å\0\ã¿jNÙ«H†*Ÿ˜TüUÿ\0N‡\"­\"X\ÙF@lcm:O\ß?Niq¸GZŒ6\"u\î?Æ³­.8³¯‰Š¯meVÀ$=³T\Ğâ©©7Z—v>?\Z\ä45ü²§rq«\Ø\ĞÁ\'£‘a‘†sUouK=1¯§X•7OÆ®+$È®ŒHÊ°4\ÄyÏŠ>\ZG6û\İ¦\ê\Ö\Äü­ş\é\íô¯6t\Æå­®¢xfC‚0A¯¤FG_Î±<A\á};\Ä6\å.\â\Û0$\éÃ¯øjM™\â»#\ê~u‡©hm\n³À¾l\'ª\Õ\×xƒÂºŸ†¦&tó\ì\Éùnqøú\ZÌ†\áp0r=\r!i¨\è!‹Kf1½1ƒ\\ó\Æñ\ÊV@T÷½–÷I‚ø!\")‡qŞ¹[GHc»Œ\Ç û²ÁªL,pÃ’=+ ğÏŒ5¯	\ß-Ö—t\Ñóó\ÆÜ£B+7P\Óg²™I_ïŠ¥}ª„}e\àŠú\'Œ¡[Í–z‹4–O÷Oôª;ø?§x†\'ºÓ€‚ó\ãø«\å¸\åxœI0l‚<ƒ^\Å\à÷šIOñû».\Ï\ÖHÇ¿÷©óOøSTğ\í\ë\Û\ß[º`ğø\à\Öm\Ó\Ù\\‰ñ\é\ë_e\Ü\ÙxwÇº\"Ê\rİ¼«òÊ‡$}úõ\à;ø; ¼—zrµÅ¯P\0\éEÀÆ´¹[˜C©\à•SR\Ó\Äñœt5‡¤\ŞË¦Ü˜f!8 ö5Ö«	£À9\r\Îi\á&…•™Xa‡QUN\í\ß^\Õ\Ô\êºi \Í\Zä¢¹\ÉS69úSL\Ã2Ò½CÀ5o\ìµú†˜8\íó\Ä?\Ùo\èk\Ë1\Û<\Ğ9ô\ïLGÚ¶:—†ü¢—·–\Ëvd<<gĞ ×xû\à¤Ö«-ö‡™\"˜ı+\Èôj~Ô£½\Ò\îä·™‰OØ\ã\ë_Eø\ã>›¯yv\Z\ÙK-@\áV^‘J~¿\Â}©óœV“\Ø\Ü=µ\ÌO\n°\ÅR¸M²·Ö¾¸ñoÃ#\Äğ›ˆcHn\È\ÊÈ\Z¾tñŸµo\r]·\Ú-\Ø\Æ‘N\àr\ÖlAÁÏ­m(ŸÎ°­\ÉYq[–\ß4}Ï­1/¼4ş&ñ-½©L\ÛFD“68\Ú;~=+\ê;u…V4\0GÀ¦kˆø[\áo\ì‰\Ó—Xv\È\ä\Ëş}kĞ‘v(K\Õó-¼+œ*Œš’¹Ÿ\êB(şÎ§…å¾½…&\ì€\æµ[©5\â¹\Év\É\Çj\Ô\Ó\íV8À¥f\é–\ÆG37,ÆºkK1\Õ\0ú\ÖE\Z:e¾•‡°­*j D\nTEPEP\ZBø¥¦·JE.Xgv*‘\È5vU,¸L©s@\r¬}b\Şird¯µl´Jq#+x#¨§†ÚºK½*€J­\íXw:|\Ö\Ç\æRW\ÔT\Æ)K`pj ø\àÒi\\d«)y©C†\é\ÍU÷¤\ÜAùOz\0¶\\V^²\àFş\ç¡…¤\íXš¬¥\İwj¤&Y€m…zT„æ˜‡=¥mˆ2MP…Š6@ˆ2OµvšF”–pù\Ó`g\Õ‡£-´by\Ç\Ìy\0ö÷¯<ø—ñGœøg\Ãòoº\ìšT?w\Ø\Z¤„Eñ\Ç2k7\á\İr\'ü}Ü¯@;^iwq`„lµ„`S\ëV¤Ht\Û/°[>\ç\'u\Ä\İÙ»ş›ge&­z±F	ˆ}\ê\Òl	tm*]^ùdd>X<\nö\rJŠ\Ê\İp U_\è‘\ØÚ¡òÀ>õ\Ñ/Êµ¦\Ú H\n01ˆ\ïšûfšIõ ¡?ıj\\ñ@\Í8ªH– \ëKô£ız:V‰\Ä<Ÿjš#•ş•\rIü\ëDˆdÃ’3ü\ê)¾BH\ïR¯ZeÒƒ¸5R2³\"ögK4¾Lç°¤\Ò\ã+v\ê\Ç$\ÕK\×ó%Š\Üw95jò\å4\í.Y‰bñõ¯,\é<“\ã/ˆ³\"X\Äı9<ô\ÇJÀğ\Ä\İS\Ã\á-¯Y®¬	ÿ\0V\Ç\æAşÉ®K\Æ\Z£\ë\Z\ì²n\È-\Ç=ª´#ŒJÏ­´m{O\×\ì–\çOdR>eş%ö\"´\ë\ä\í^\Ô4Ô¹±¸h\å^£±‡Ö½\×Á\ßtÿ\0¢[]•µ¾\é‚~Y±\íôª$\î%Š9\âh¥Ex\Øa•†A\æ\Ş%økƒ%\æƒò·Vµc\Çüÿ\0Jô\ÊZM\\iŸ9n–	\Ş	\ãh¦C†F\"¤q\r\ÔE\'@\ê{â½§\Ä~\Ó|G	ó\ÓÊ¹\ä¸Aó¯¨¯$\Öü9©øn\ãe\Ü[\í\Éù.\î·øj–¬Rg\'¨\èmnŒU|ûs\Õ{Š\ã5\ra§µ\äwN\â½J9†\Ó\Ï\Ê{U\í¿\ŞÛ‘¾ƒ¡¡0<uƒFø ‚8Á£\'9\î+¶\ÕtH\å%gAÿ\0\Şƒ\\\îŸ5Œ˜‘\Ó\Ğö5iŠ\ÆÏ…ük¬øJü\\i—Lƒ?<M\Ê8÷ô—‚>*h~5„Y\\l´\ÔXa­¥?+ÿ\0ºOZù\'$ŒgŠ’)¤†@ñ¹F^C‚>†Pø\ï\àöŸ¯E%Ö˜¢¼gø«\Æÿ\0³u/\İ6©Àñ²+‘Á®«À?.ô\Ã\âR\×Vœ*Ü¯2F=\ÇñÖ½ª\ïOğÿ\0t„7Š\æc#’>¿ız@|\ä\Ê$n+–\Õl\r¼\"°}«\ÖüS\àıC,Hf´\ÉÃ \éõ®.\ê\Ùfˆ£¯\'±\Ï>’<|Àu¦\0HúÖ¥\í“\Û\\2ò†³Šc$ŒûúUˆ~R>¸«°}>•Xıÿ\0Ç½LÀÀ\ê(\Ò|ñ‡Wğ«\Çe|Zÿ\0K\Î<·o!ş\ËC_CXjñ\æŒZ\ŞH®\àaóF\Ü<dú¢¾,pC\ßùWK¡ëº†‹,w\ÚmÜ–÷>ò¾\Äw\ê^9ø+%³É¨\è<c\æ1c¥s¿\rü%q«ø±m\î\áe‚Ğ‰&:\Ãñ?Ê½#À\Z4ıwË°\×JX\ßğ«/ü²”ÿ\0\ì§ô¯A—FX\ç7š[Go3\à¸\ÛòIõ\Çô¤#J•\0\n0¨0*zj®\Õ®;Ó¨»…µ·y[°\àzšó»\É_Q\ÔJd‘œ±÷­ÿ\0\êx\Ì(xN8\îÕ“¤\Ú»\Û\ï7&²“»°Ñ¥i\0ô®N·ò¢\ŞG\ÌÕŸele”|«É­À\0\0‚„1h¢Š`QE\0••¯k¶\Úœ÷W-\Ñ#–5\ÂZ|Yu¸Û¨iaa\'\ïÀ\ä=Á\ë@\Òoc\Ôi¸\ÍP\Òu­?[¶)* }\åö#µh\Ğ!Œµ aóT¬x¨\ÜnP7i\à\æ™S<,¾\â£\Å\0%#Æ².\Ö¨æº‚\ßılª¾\ÄóYò\ë\Ğ\'#?¿AI°w¢+‚\Ğğ}+\ZkymŸk©Ö¯M®]I\ÂmA\ß&¨I<“\Ò;1÷¨v\ç­!\Çjó¤8¤2H\Ûlr·¢\Ö\Ø-¨B¹\è3[lvY‰¸¬%ÿ\0HÖ˜ Š\Ö$³MArFX\×_ hb$[™\ÆI\åA¨t\r\î\Ü\Ü:€{\×=ñ;\â,^\Z³m3Nu}JU\ÇıX«H’—\Å/‰+¤\Âú&(k\é\Ù9òÁ\íõ¯,¶·m\Ùä™·\êW#2rc·\×Ö£\ÒmŒ ëš“3\Ü\Ês¿$Ÿ\ïŸ\éÿ\0\êª\×sK4ûG\Í,¿*·¾\\··\ŞrO\ÌG5\ê>ğ\Ôv‘#ºóŒò+/Á¾\niG=Mz5´kaGÊ£¦Àµ*…!Gja<R\Ê\ä¹5oj\n4\ßnO4f¥4€_zPsõ¤§Š\Õ\"cA€y dU¤K\ät§&C)\r&yÖ´H†Z²ŒÃƒÈ¦\Æ\Ù\Å>Lˆ\ê\Èf…7’\Î~\îp>•\Ë|S×†¢›h\Ü,’u®¾\ÉV\Ö\Ëspw\Zù\ïâ†¾Ú²ñÊ¡\Æ3^;:!n\ÚŒ	É­H%IW\å~Fk!\0À óô§µ\Ã!*A\èiŒ\Û\ä”\è\åxœ26\äqTm¯\Ã0GÂšºJ·#‘š\0ôÿ\0üU¸\Ó\ÄvZÁi\í²\0—ø£\ÔW´Xjš¢]YÎ“B\ã!”\×\Èÿ\0tŒú\ë ğÏŒ5?\r\Ş	-f>Y?<L~VJ«‰£\ê*†\â\Ş¸ˆ’Xœa‘\ÆA‹\á¯\Øx\Í%‚EYHù£\Ïz\è(\å¾%øo,\ï4]:µ«r\à\'¿Ò¸@\íŒ’+G*ğ\ÊF?Jú6¹¿ø;Nñe\Ù|‹À>K„ÿ\0À‡qR\ÑI52[\Ş\Æc™÷®sSÑ¤†6<ûc\í\Ê\×_¬\èz—‡n|›ø”O\É2òøÿ\0NµQ&\0F\å=H\Ï)\Ô4\'\\\Éió¯÷{Š\Å \Æ\Øa‚\rzıöÙš\Ó÷r÷qš¦’³JVxü‰\ÇF\Ç©1X\å76Aô®›\Â^8\Öüz\'\ÓnHˆŸ\Ş@ü£§õ®~\â\Ò[Y6ºŸc\rVzûsV#\ë\Ï|L\Ğüqj-dh\íµ\\=¤§!ÿ\0\İ\'¨ıj¯Š¾\ZAw¾óI&\êa\ì~•ò”3\Éo*KŒ’!Ê²œ~µ\í\ß¾9\\Û¼:o‰É…Kµ:½\ê=\é4-¯\è3D\Ï\Ô\rªH\Ãz\×\rqlñ±@CÖ¾\ÆÔ´m\ÆzbÎ­\È\ã÷ws^\ãß†š†\ÍqfXG\İt\èh@xû®\Æ\ç“R®6:T\×0\'#u•œ;S†#šÑ±ù +œ\Õ\'_“9ü*Ş¯qp°F¥\Ø*\Ü\Ğ}ğ“\Â\Û\Ş+[»˜³cdC¶Gÿ\0\Â?¿•}9elğ<˜ù8û/­r\Şğ\Ä~ğíµšö‡ù\æaİ_ó\í]°@ ¤!j®¡v,\íLüÇ…úÕª\ã<M©ù’£9\å\\:RvCF;\Ô5O(‡ó5\Ğ\ÛCµF&³ô\ËO.1‘óMtzu¾ù7‘ò­d†_³€Cşñ\äÕŠ(ª\0¤$\0I8–°5S“mqüL;ûPu\r^C>\ÛgÚˆ~ğ\ïM“Å–vVm-ñ(\Ê8\Ú3¸\Ö\r\Í\Ìv°4²¶\Õ^\ä×k:¼º¥\á!±Ÿ•}©±\Å6\Ë^!ñÏˆ5¸”‘œG÷Eem\ç‘LN&œyR7J\ÂZ^]\é7\"\ïM¹xf\'i\àıGzôŸüS¶º)i®*\ÛO\ĞN>\ã}}+\Ë[\å$S4•p@¤)ŸM\Å,sF²D\ê\è\Ã!”\ä\Zs\nù\çAñf³\áyZ\Êgµş+yWğô¯^ğÇt¿ &0\Ş–úıG¨¦c(4t„V=ö¦\ÌcÓ©«š­¬fHc7™z¢¶HúúW73,Ç’M&IVùÏœdw¡¨¥>xVEÁ?ıj\Îs5©Áù£õô¬\Ø\Ë\â\ÕW	 Êš˜0=\é\Å!\â”\Ò—®M0y»d1¯S\Îjø[\Â\ì·_\İó¼\ä/ô«šfˆ/.’\âP|¸\Æ>¾\Õ|si\à\İ(¬e^úE\Ä0ƒ\ÓŞ¶‚!²§\Äoˆ6\ŞÓ¥£#\ê2.ÿ\0V=Mx6—i.·}>­ªH\Ï6÷f<\Ê\İv\ë\íU¡Kÿ\0\ë\Ò\Ïu3b^i[¢/ù\à\n\Ô\Õuh•,\íe¬#j =}\Íh\"-SPk™·ô\Ï \í[şğ\Û\ÜJ³Ì¤–9\çµgxkB—R»Y\ä^3òŒW°i¶1\ØÀ‘ªŒ\Íj—.¢ÜµoZ[ª ¤±Zl\Íòş„\ì·\ç½IEvl“\èi„óHNy uªCzQ\ÇZL\ãñ¤«H–.sõ4§=3FG\åG\áZ$C‚);QŞŒ\àš\Ñ!\0\íIA9Òœ‚*‘,³J‘ñ·¹ªğ\Õ;ıÊ´C\â\íXi^™Á\Ã\â¾_\ÔnöşIX\ä–\'šôß‰ş-Šù\Ş\İ\Î\Ñ\Ç\å^J¯X1\ÎEx\È\ëD\ê\Ät\ã!|\ç\çÖ \Ïpx=3NŠ`K´¼Ò§†\îH;‡®{UP\Ù\Îr@\ã5 \nÃ€O=\èY&I†\å<š“kgµŠ¬ñ\Èx\êkJ\Şõ\'Ú{f€6ôf\ïEºY­\ä ÷{Ÿƒ¾ [kp¤L\àpryÿ\0\ë\×Ï…sóp{S ¸–\Öe–YO\ZiŠ\Ç\×j\Ê\êH ô\"^\r\áß‹úqH\ï¢ô885\ë¾ñN™\âKa-Œ\Ã\Ìç‰Æ˜[»;{ûg·º…&…\Æd\Zò\Ï|;¹\Ó\Ë\Şh»®-\Ç-nytúzÖ½f–“W\Zg\Î1\ÌwIW^ õ\ë‹[mF\ÂOC^Á\âXk\Û\î\"Å­ùÿ\0–\Ê8÷‡õ¯\'Ô´­CA»û6£F\ß\Â\ã•q\ê\rKV*\ç«xz[U<y\Ö\ç\Ğrµ\Ê\Ü\è²›s½»Ş½efm`OQXúŸ‡cœ››1\ËÔ¨\èhL)–)\"8te#ÖšG\ç\Ù\ÜC&\è68ö¬\Éü:&9µ—CWq€ü}ªx~e\Ş\ã+Ÿš\'\å\\}+\è\rø\ÏHñe¯\Ù\ä\Ù\Ó.\ÚS\ß\îúÿ\0:ù{\İ:q#!Êœ†Š\ì<=©µ\Â$ˆ\åfN\à\àƒI\ì9ø;m©,—º0ò\ç\êbş•óî³ \Ş\è×\Ü\r)=G¾ƒğ¿\Å	-ü»Mt\"\è.G\Ş_÷‡­vz\ï†4/\Z\é¢FI½s\Äx4\Ä|i1 Ú½;à·…µ5öÕ®›k#„\È\á¤?\à?˜¨<eğ£V\Ğ/\ìñ4ğ;mG_z÷?øz\Ãöšl*2t®;¤\Ğ_g\Ô\Ş{ğ>•j\0\0\0`\nBB©bp\0\É4¡«Ş‹;FÁÃ¸Àö\Íp\Ö\Êo¯\Úv\åñW<C©5\İ×•?1\Ú «\Z}¨‚%QÛ¯Ö±“»)\í¢\É&º(\"Â¨;uª\Ze¿üµaÓ¥jS@QYº®¤¶1lR\Í\Ğz{\ÓcT\ëöxNen¤v®^YV4i$l\É&‰%,Yİ²I\É&¸k\æ\áš\Î\Õÿ\0v§Àı\ã\éôª\Ø»*øƒZmN\çÊŒ°…½d(÷¨gş5\'Ö‘ºVV$İÖ€}j[)µ´·K;p8æº¿iz^¤CD\Z\í‡\Ô\Ò\Î\"N	\ãŠnxÀ\ëRL	\ä~U‹wq\"O´1âš\Ä\àz~F×­t6hn\ÄWr)@\'ñ\Ç\ÌM„,¤s\riøB:ÿ\0ˆ\Ö\êt\İkhwv¬c\Õ<;`ö–i\É{‰\Î÷brI5ª\ã­J\Ãh\n:P±÷¤s½HT2 +\ìj\Ã*\";R`eOfco2Aî´^e¶\Éò°\ê+E‡Ò©\Ü[$À\àa»R2\Â\Êpjö•\n]j1\Ç#BNNq\\\à–kF\Û.Jvj½\Èb ŠWŒüc§ø+E\Ş\ÅM\Ë\r°@$úı+\ækûıS\Å\Ú\ï›)i\î\î\n½‡·°\é.ğ|#swÜ†\ìŒXoj\å\ã¶_\éò‰\Ê6­0Á\Ús\å/÷G¿¯\å]1’d5bæ§¥¿†ô8-!*\ÒÏ†vn\ãÓ¨\Ó\ëX\ÚF‡6£~¥\É`8[LK\İcP$\È\îY¾fbMzÿ\0‡´8ôûu\Ê\r\Ø\Îkx¤•È»¹wE\ÒbÓ­W\å±\éZŠAl\Ò1P2\rCw)!²“Àõ¥¸8ˆÒ™ÁœsÒ’\íù\ĞSC Zp5\í\ÍH:U$&.iÃ¥7 ô¥­R%“\è\í\Å.Gi\0\àòiO&Œ\Òw­M¥â›š¤‰dĞÆ§¸üª´D\î«ersÈ«H†|Å®\Èó\Şşğœ\Æj¡¶d»]\Åş…„†@Aï•\Ë\Şi—\Z{‘µ#üU\â†G##*A†ƒ*v]7&3\Ó 1º)\Óò¦Âœ/#¸©ON\Ãñ¨\'¡\í\Éô§`ğN3@«®?\ÚÏ­\ç0\ÃÒ¢\Î{\ã½H<b€-[_4lRJúÖˆeeNGµb‚\á\ïOŠY!\Û*{\Z\0\Ù\Èİœs\×µ{L\Õ.ô»´¹´\â‘C)\Åe\Û\İ$\ç’\Õ>G­\0{·ƒ¾(\Új‹®\Ë\×A/ğ¹÷ô5\è\êÁ”2TŒ‚¾C\\©\È\'Š\ï|ñ*ûAdµ»\İscœlcó\'\ĞÓ¸¬}Tµ2\ÓV³k[\Øh›±\ê=Á\ìj=[\Óõ\ËEº°¸YPGñ/\Ôv­\Zb<k\Ä\Ş¾\Ñw\İiÅ®¬%qó\Æ=\Çq\ï\\´St ó_GW\râŸ‡Öš¶û½7e­\ï$®0’Cô©h¤\Ï(¼³µ\Ô\â+:\0ı˜u\Ç\êº%Í‰$‚Ñ»\"õZ\ì\ïmo4«Æµ¿\àOF~‡½7\Ín¡\Ğö5(ga4ò9}² \îzÕˆ£³·¼3\Ù8I\á\â<fµ5l†\æÁ°z˜û\Z\çµ[r»\×1\\\'QœT#¥ó\ÒtÜ¸\äsZ^ñ†­\áK2\Ê]ö\Ìs%¼œ£ÿ\0÷\çZN©=¥Ø‚\é\0š\é\İ\ÖDÀ<P\Ñ\Zñ†‹\ã}<\Æ,øÄ¶³u\Û\×\ê+{M\Ò\ã\ÓDŠIY²¡\ÎvJñ†º+\êš\äaw,\çÍ•\Ô\à\ã°Ï¹şµ\ï´Ğ„¬}P–†0\Øf>Âµ¥‘b‰¤s…Q“^w­^É¨\ßùJ~ñ\ç\ØR“²†i\Ñ5\Í\Ë\İ?L\ák¤µ„\È\ê‹Ôš£i\Ã\Z¨]—m²?5‡\'¥dŠ/F‚8\Õ@)ôQV!¯»aÙ\Ø\ã5\Ä\êp\İ\Ãt\ÏtXğİÒ»Š\ÅñF¡› \\\Ï2«|¸Ua\ÔĞ€ò\Ï\ëşDmglÿ\0¼<9«Š-’rO\\\Ñ3\É,\Í$™\Ü\Ç41Ú™¼cdH¸\çµ8ŸZfw{P\Ä\çµ5tfmGx\ÑdI1¹[#§¸¨µ-FmVé§˜ó\ÙrHL\Õ‡“šN±\ê)X-\ÔY[\æ°õ‰I\ÍkÜ¶\È\Ë\È\ë\\ö¡s¼ü½z\Ğ2›´’Ì±D¥\är@\îk\ß|¡/‡ü?¾œ\ÃtŒ;±¯4øc [YmR\á3om\Âg¡şµ{Kq\Æ8¡™\Íô#v¨Z\Ø\Í1¾¼Ô™Œ$ş4\Æ?<ú\Ôl=\èQ0•)\Ï5ZC*Ê†\È5%¬%¹\ã©Z\Õa\Çz¯yu›e%\í\Û†1x\Ü}(°ú†²t­0\Î\ëş\Ê|´?\Ì×‘\Ê×š\îª\ì\ÌYİ³š›Y\×/<I«»£0Œœ\"Â»\ÏxW\Ë\Û4Š	<“Š\ê¥M%ve)kcW\Â>K(\İq“\Åv¼*\àœRG\ZÂŠ p;P~Sšm\ÜiXcs\Å.\í‹\ïI\Õğ)\'\áh¾ZV>•\ËfSS\Ûqj¨\ì^CŠhx©¥GŒqR­kKR2)?J\\qZ$CN=)8â“š\Ñ!½ú\ĞG¥\ê\Ñ\"~”‡Šw\áH}ª˜¨py«€\åWÖ©/\'š´„”\ÅR%^%\Û!IT\ç±=\r%ÅŒs\Æ~PA\ê)Î›”£\Ë\ëLA%»pwÅ½\ÅxGa\Ç\ê’i\ì\ÇJú\Ö|\ÙWdc¯Q%\'\\zŠÀ\Õ|?\àgA²^\Ä\niÃ¼G€E1N\Õ<U\ë‹i\ì¤1\\/\Ëı\î\Õ\à#µ0 #\ä8\ëŞ”1\Ú}»S0W\ë\ÜÒ“\ë\×h\é&ß”ô\êiù\ÔC8\ã­.\ìŒt=hp¸—!‡z·m¨;f?Fª*üüÃŠ1» ôÀ \r\àÀü\ëÊŸz:õ\é\ëX\ÑO%»c;“<ŠÖ‚\å\'\\©\ã4³¢xƒPĞ¯V\æ\Æv\Ôòá½ˆ¯qğ‡\Äm?\Ä\n–\×Emoºmcò¹öôúW\Ï$`\çò§\Ç3BÁÑˆ#¡\\,}yEx‡ƒ>)\\i\â;-d™\í†\0r\éş\"½–\ÃPµ\Ô\í\ê\Îtš¦¨’®µ \éúı¡·¿€>>\ã¨5\ã\Ş%ğf£\á\É\Ê\rÍ†~Y”r¿\ï\Õ\î´\ÆE‘\n:†V Œ‚)5q\Üù­$ dj\í”Ë™l€pÃ¨¯YñO\ÃX\æ/{¡.N¯jO\Ê\ß\îú}+\Ì.må¶™\á&ŠT8da‚*v\Çjš3‰yùdZv“#8²ÿ\0­_»\ï]F\åa\åÈ ¯|\×Cğ\ïÁ6ú¿‹#Ô3ggû\Æ^Å¿„_Â˜§\àÿ\0\Â;á¨’U\Å\İ\Æ%›\ÔzÀZ\ë(¨.®\Ö\Ù\ånÃsU±&‰u%·€À­\Ğe¿ ®kI·g-u ùœñ\ì*ù¤\Õ5?+$®w9­\Ëx‚\"ª\0À¬».\Ö.\ÙÛ™¦T;\×FªB‚©\é¶\ŞT;\Ø|\ÍWª‚Š(¦Yz\æ‡i¯\ØK°\Ûz«)Áµ( ñ?\ç\ÒøRImqş´s®:W-³\ÆOW\Ò\Z­ô:v™qw:4$ \İ\í_0O\ã¨îµ»“wd¶°Hä¢¨\Æ\Ñ\î)­Mc+\îY)Û«>\\ˆ\'µpÀú\Zª\Ê\Ñ04.\ìwü)N*<ñ\È\Í(#“ÓŠC\"¾•c´bOZ\å’o\ï#µ€fYœ*\îjş±y\æJcV\Ê/\êk°øW\áÏµ^É­\Ü&c+GS\Ü\Ó\Ñ\\ô¯\r\è±h:½”@|«—#»w?h1ô©z„\Ô=FŸJa\éN\'ñ¦\Z\0a¦·¥8û÷¨È œ\ã\ÓŞšÃŠS\×Œ0¥»@Š¬ò8H\Ôe˜ö\ãş4ñ< \Ô>\Çj\Ì,\á;T\â>µ¯\ã¯Hå´‹)8cûÂ¦³|\'á¦\ÒYW¯ [Ò§Õ‘)t4|\áfvI$\\“ƒô¯]´µ\Ò\Ü\"€9\âª\éZtv6\êŒ\ãš\Ğ$g=ª\å+\è+\roÖ›Œ“\ØS	¤s„À¤24û\çÒ¡¹—µ2p¤\ÕI›tŠ½i , \ÛnAãŠ£Ÿ˜\Õ\éN\Øqš¢ \în\Z´!\ê9\Å<zv\Í&8¥\Æ\rkCc½ÿ\0.}i£Ú—<óZ¤KñŠ2zQ\ÔfŒúU¤ ô{Rt¤\'z¤‰c³\Å\'^z\ÒÒ­!Ps\ïV¢ 5YNN*Í¹Á\à\Ó\å°İ†\\ƒŸZ˜©@H?)\í]¿\àò™¹\Ó\Æ\ä\êPv®M\'š\ŞB’‚1Á\r^\ØXò\Ç-\ÃwCÒ•%W\Ê7\ß÷\ëN]’ü\èy\ÇJc¢K\ß+öaL\n—ºlW‘”‘CüW¨\è³\é®^%/	\çŠ\î\Ög€\ì˜pz7cRMO\Êj\0òÖf\ÎÑµ»ƒP²m\ã¡úWY¬xpni\í	W=W±®i”«ùS©F¸ª·S‚:w¥\nA˜\íO–¹c<T|\ÏÒ€£ªø\çÖ£\È\í‘J¤†®(|\á\ç½\0:6õ`£\r\ÏTˆ\ãnZ\0Ò¶½¨Y~V\é×©«™s\ë\ĞVQ\È#µIä”\ìh`g\0óœ\Öÿ\0‡<[ªxn\ée³˜˜ÿ\0&û¬=\Ås\ÑK©¹Holô£‘\ÇJ\0ú_Â9\Ó<O\n¤n ¼\æ\ÏcŞºªù\Ö\êk9–Xdx\İNAW¯x7\âÊ·—c¯·^\è\ì\ß\ãM1Xõ\Ú\çüI\á-;Ä=<«0—>aõõ·ñ\\Â“A\"\ÉŒ«)\È\"¥¦#\ç¯øOR\Ğ\î\Ä7–Gm±K\Ê\É\íõö¯eğ~‚ğü˜{\ró·«ß‡JÛ’\æP$Eu022:\Z–•‡p®?\Åz°@`F\á8\ã»WG©\Ş+7|ü\ç…ú×œ¶\íOUÁ9Š3“\îj&ú\r\"\æjc‹Í“ıd‡\'5\Ò\é\Öşt£ZÏ‚2p u\àWOc\0‚\êz\Ô$2\Ğ\0QIEP…´”P\ÑIš\\\Ó›hn\í\Ş	\ãD\ã§½y7Œ>\n\ÚjK%Æ\á$<ù2?ş5\ëôP€ø\âóJñ‚\ïš)a™O(\ã¯Òµô¯\Ù\êƒÉ¸)½õ«£\éúÕ«[\ê±\Ï\Ä9C_=üUøZ·\Zd{r\ß2c˜ÿ\0õWL¸\Î\ÅY!˜\Ø0ö¬\íF\ã\ìğ0\ï=+šÑµ{˜#ò\æf\ê+¡u\áVY3\ËÚ“F\é_S\Â\ÂmkV·\Ó\à\ÎùŸi8\è;ŸÀWÑºN™¥Acn¡R5õ\Åü:ğ\ä1o\Ö^$q²3\İ\Ízx¤Ù”\ßB65{S\ØóL&¤\Ìa¦\Zs)¤\Ğ:v¦=©Çô\Ò{ŸÒ€#\é\É\é\\GüXºu«Y[?\ï\Ücµ\Ô\ß\\e&Q*EH^i\\€z}Où\à\Zóÿ\0xRk\×:£+G¤Á&œşó\Øg¹\ï\éŸSZB7\ÔM˜ş\ZğµÖ ÿ\0\Ú7@ˆÙ³–ş.•zNœ‰hT mY\ÕG¶\ê8\Æ\Ğ\0\Æ*„O\Æ®‡Ø„ºTbT\ãµY\Î\ìW3\Åx­»k\ë\ÏŞ¨±E\Ñ\Ç^µÏ(a´æ ‘²\İx\0@$\Ô?z\äNj`~Q“Ö›şô±ªBs€f© ùˆ&¬\\1\'*ğ$\ç5qB$\Å;­£\"·Š!…\ŞÔEh‘\"´\Ö\æ”ñøR~j\Ñ-†I \Ì\Ós\ÏZQ\×Ş©!Ş”ô¦\ç&œ3¼Uzı\ê±\r\ë\ïU\æ§Lö\ëLFN“\â,Á\ë\Æj]o\Ãvš\Ô\r5¶Õ›\ã½rG½i\éz\ì\ÖN’\É\ï_<÷;\Ú\ìr÷6wšUÉUdÇ¯z9\Ò\ápx`:W£M‡ˆmv\Ê±7pk‚Ö¼7w¤L]Ah³\ÃL’A·kıÚƒ÷–\Ãz$yüE$•/~\æ¬:‘\Ê`J\0tr\År¼VF±\áøo\ãf\0,ƒî°«²[\Şd#Jv5%µ\èc\åJ6¸\ìh\Î.¬\ît\Ù|»„%ÀqÒ«4I \Ê~•\ê7št±2:«)1\\&«\áÛ>Fš\Ü‹ºÂ©00Š”\nü¹8\Ü;µcä›„v¨$Œ£Ò˜}z\Ğ\0®i¹\ã-œÔ¸9>Ş´2¾\ĞGA\ÛğG\0\"«gó‘\ÜTøãŸ­\0Lñ>c\'\éZ6÷«1\0ğk0´cš\Éxn´»·#µ4ds‘T-\ïˆ\Â\Ì8õ­*\é\Ü{P[\á\ê^P9š\Èı\è\\ñøzW¼xw\Å:g‰m¶S0?2ÿ\0ˆ÷¯–À+^½ğs\ÃL«6½rSû¸ıOô¡1XõòŸ8e8=ı\é\ä\àd\Ôk\']ßd\ß\Ü\Ís(µµ,7pH\ãŠ.-T\\\ê\Ï*\Ú.\àƒ\Î?\Z©¥xr\æ\Ş\Ün\n¬\Ç-“]5½²YÀ°\Ç\ËY½jÁ8\0\n†®36\ÓLò;°8\ì+K8¤¤\'š\0~h\Í34¹\æ€š\\\Ó3FhÔ ñM\ÏSù¥¦N€ÕŸ­\ß\Úiš=\Í\Õ\àV\îV\r\íZ5\åŸµQ6™q\Z¸ò£\ÊF¤ğ\ï\Üş)\r+³\Èõ\é´;÷7ºlÒ±2 P¨=€§xsM}gS‚\Î p\Ç.Ã²µ\Ï\Ä\Ì\ÊTsú×²ü7\Ğ?³t·LŸ¿¸ù†G!{\ãTuJÑ‰\Ù\ÛÁ¤pD\0TP J4¬\Ù\ÍFO \åŸ­0\àzSL9õ n´„v¥8æx ddVV»«Ã£X<ò¸(\îkRiVW?*ŒšğÏˆş#š÷V[8€^+~•QWbd\ÖÚ–¯ñ_‡@·—Ë±’Mò\áG\n\Ë1\êqÀ>•\ïf÷Gğ•§ Jmsİ˜úŸóÚ¼O\áõ‰Ğ’[\ßùo*€p:\×O5\Ó\Îû™\É\'\Ô\×S‡*3½\ÙbY\äf•\Î\æc’hŒûqŞ«©9ëŠ³<fË°çŒœV„R•# \Ç5Ÿ\éS«\î\Êş¬—!Ó­û¹ª\Ûzt«Q6q\é\ÛŞ‹lô\É9=…#e¯&ˆùùˆ\æ™,Ÿ8PsMl¦£‹—\äS\Ü\Ôq›>µ¬P™c¾i½=9¥\éŞGÒ·HÍ†9\æ‚i¥¸¥\Éõ«D\ÜC\éM\ÆO\âFiMZsÓ­&~´´b©@z\Ó\ÇJm(8\ç\'\éLC”ò*tãŠ¬§¦sS©\Ç4À\Ïñ7‚&\Ó\İ\ï4\Å2AÕ¢W\é\\ŠºI•#k\ï^ø¥d^ps\ÔW\âCºóN+¡\ÉQÑ«\ç¥¨\îŒû}i}=„ ©;{ƒ]†Ÿ«[jpn¶F5\Ä\ËÖ³µ½\ÔM\Ë\Ô5\";Û¾øÜ¯~*S)\Ææ¯ˆ|SuÎŸ\Êu)\é\\”s\Íi)IñÁ½FñÁü\êmg\Ãvš\Ä^}¶Ô›Û½Q>§6N7ÇqQ\Ír¨ó8q\Ñ\ÇQL¼²»\ÒnLr¡LN\rK\r\ÄwóŒ5\0B“\Íj\Ûf‚x~Æ¬¸I<sú\Ò2ñ±\×tf«˜\Ş\ßs\Åó\ÅÔ¯q@\î³áµ™škp^¸®]Œ9Š\å\n°\ã$W©E$s¯AYº¶‡\rôg(3Ù±È§qu$g#¨¨sµ\Ï\êkJûNº\Ò\ä!Ô¼G¡ª®Ô—˜÷ª\0rr?\Zúÿ\0:V]­\é\íM\Î\î3@‚qÁúS\ã`N3Q7x¥\Ü1Á8÷3/\Íów©\á•\í\É\Û\ÊúUu%\àu\ÍJ+@§\Ë\â-^\Ö\Â\×!\åp\Â;ŸÀW\Ô\Z}¤:V…º…Š\nyoÁŸ­†&½rŸ¾¹ùa\Èû©\ëø×©«\åó\ØP\Å<õ\ëRmHÁ!@õ5?wqhv\Ş\áAÉ¤ğ]ºšBsJOaL4€Rh\Í74gŠCš3L\Í.Eh\Í&h\Í\0;9¥Š`4£0§šzšUF(\"‹•®\ê+abÀ8Yº;šù\ç\Å\Ú\Ñ\Õug÷1p£\Óÿ\0¯]\ç\Äıj\î\Çt2#£\Êp¼pG±¯v¹p¥ar²\Û÷µE­\Ùw\Âz,š¿‰\ÙW0«o‘±ÀQş5ô\"\ÃÆ£\n£\ÉøÃ‡B\ÒL—\n>\×?\ÎıöÂº’Æ“dÔ•İš˜M‡Ja9æ‘˜¹üi)3I´\0§”ƒŞƒ×¥6Y^g8T\\“@¿5¤\Ól]7ª\îcı¿Æ¼7Iõ\Ï5Ä™e\Ü\\\çô\Ñ|C\×^\îf„ºF\ÜÀƒ°«\Òş\Ç`²°ù\ä\äš\ê¡³9»#¦·O*5P¸\ã2»\Ô:Œ¾8§\Ä9\Çz\Ònò¹)Y\ãù\Ü\0\r\\T…V6Ø¸\ïS#`gŒ“R2\ÒI‚9©\ãm\ÄUU\ä}N*\ÂNxÒ˜\ã*À’~QV`ö\È\Â*¥¿\ï»b0x÷«\Şbª\äŠC,5A™¿\æ‘p3\êj£¸˜Œy÷¤N\éK\ÔúSw|\İ+¡#6\É÷gµÎš ŒóKMj‘\r ği £8\n¤‰“\Û\ëF1@8\Å“T	\íŠN§4\ì\ç9\í@?™ª™¹¤\êJ\\Š?\nb{\Z”Ÿ”õòEJ\Õô¦Q¦\ê\Ğ\ßD7»®kZ9Cpk\Ïç³–\Òo´Z±W;\ÖÖ“¯¥\Î!¸;&\é\Ïzùõ+üA\á›-zÜ‰,\Ã\î\È\"¼«U\Ò/t£\r\äd\ÄN@85\íMÀñM¾°µ\Õ-Z˜–Da\Üt¥(Ü¨\ÊÇ…”\ÏÌ§\èk_H\×f´uIN\å÷«\"ğ\æ‡#\\Ú†\ÈúrR¹ğRd\Êu5±4\ÒH\î\ç·\ÓüAi¶@»ˆ\á‡Q\\·á»­&bê»¢\Ï\\²¿ŸO”l\'µv6\Zµ®©“8#î°ªÜ‹Xó{³“ú\Z´W\å\Ê\æº-Á\Åw\\\Ør§’¾•É¤’\Ù\Éå²8 \ÓF·\Şû\â>\\£·cN¶¼*\ŞTËµº`÷©•\ÖeÊœJŠX\Òe\Ù*œŒ:Š\0.ôø\î\ã9UaA®Wğ\ä\ÖR™­ÙR»U–k2Oš3Ñ‡õ«l\"¼A\Ó4ÀòUq&UÁV`\ÔM\çÿ\0­]¶µá•”³Ã„~ õ\ÈM\ÖS®TxlU&\"·*riG\Ì	\ì}jFˆr\ÊA£o•ı\é€\ä%Oº	hrø\ÄV¶>F}\Ò0şOôükV {÷\Âo\r#\Ã\çU¹@.¯9ª‡õ B‚4²¶Š\ÖjTvvXù\Õ˜³\äÖŒ?*\ç½Hš@‰ô\éJƒjdı\ãÖ O\Ş\Ëş\Ê\Ô\ì\Ù4€\\\ÒŠBi¦\Çgµ\Ü\Òf€š3\Í6(ù£4\ĞiÀ<\nb\Ô\Ñ/\áH°÷cø\n›\Ò\0¢–Š¡\Ş$´±¼Ñ¦ú\Ú9\Ó*¸\ï\\%š\Â\Ûl\Ş\Î%Š¸Œt\Åv&¹ÿ\0W\0\è9?Z\ç\ÑBv\äjdRe€\Ã\0SY†i›½(\ÍH\Çdd\ZBqÒ™‘õ£8¤{QH\r€¿J\æ¼gª‹-<A»†ù=”õ\ë¥f¬\íÀQ“šñ/ˆ:ó\Ì$]\ÄI9\áGğ \éş}ê¢®\Ä\Î>“]ñ\æÉŒ¾yô¯N†/\"\İ€\0®KÁzaHZ\åÁ\ÜÇ‚}+±c­w\ÅrC\Ô\Å\ë!«œ€Zš/—“Q¨\ç8ö©‡ùVE¢¬\Â22\Ü\0*´j[½N1œw\Í0,)%‚ ~U$a¥`ŠI@y>µ]s»\ËL–?xÖ„;b]¸ j\Û¥<¶\í€ú\Õ~¬«ŒúÔªNüp(\Öğˆs\éL‰‹.j\ß(\0ŸJ#„t\ÕØ¥°\ï\ëK\Ær)? û\ÕÔ‘‹d¹\æ“4œ;\Ğy\'Š´‰ùQ×ŠoÓKj’»¹\àqFFx™Á\íIŞ¨B“¸õ§~5Cšp4À3š_Lw¤\ã4\ìóšbšŸ/£_Ãšÿ\0«\ïL\rS‡8¬\ë\Í4IûÈ¾W\ÅjOo%³\àŒ¯¨¦œƒ_4w•4\İr[G[k\ì\ã z\ê\à¹W@\èÛ”÷®b\æ\É.©Pjµ\İÖ(SºK|÷\íT¤&ğ™\n¸¤`‚85\Âø›À»‹\ßh\ãl^\Ğı+¨±\Ô!¼Œ<.¨­(\åŠ¶“@›G„\ï\"C\ÈVT8*İ©Q¥Ä‘¸\ï^«\âO\Ùë±™QDW‹ÈÖ¼\Âö\ÎóI¹k[\èŠÀn\ÍX¸´hšgG£ø…\\núõ6±\á\ËMb5¸)\ã½rO‡š\×Òµ\Él\Ùc”\åi§q5mVóOºÒ®\nÈ…H<{Ô°\ÜG2ln5\éSAc®Ú\áKÁ\î+ƒÖ¼3s¦\Ê\ÒF\ÇÙ…12 ŒecU<—·o6\Ø\îN¥o¥IovW\ä”ş5>\ÂFø\È\Å0\È\î£\Ú\àdğA—«\è‘]DÀ¨e\Ç^\â®Mn%mñ\â)‡q\Ğıi\Ñ\\8\ÌS.ù\Ğ#Í¯tÛ6RT„Jª¾\\ªYN\rze\æŸ\Äm€	=Eq:¦ƒ$N^\0\ÊGUõªLğ\Óø‡\Ä\Öö\Î3l„I1ÿ\0dvüzW\ÒY¢CP;W’x	d\Ğl<öP³O‚ÿ\0N\Õ\é\Ölf\0ñ\Íb\Ù3nµp±\Æ^‚«DF={Õ»e\Üw ,Ä¾\\`w§M\İHNMM74f™$›Ni\0\æu^I€Àô5™q+9\È\äz\Ô\ÖA\ÎXŸ—° Ô´Ú©}4ˆ›c\ÎOz`]\r\æGU_sNöJv,\èO \æ°\"°¾»o¸Á¼ü\n´t´°d;·;uj¤„l-\Æû”E.3V«:\ÖD’ó\ål\í´iˆ)L\Ò\ÑNÀr\Z¦ZwšN9\à{\ÖH5wZºY\ï™#9½P\Íg-\ÊC³ÇµºñM\'“KšCŠ\ä\ÓI\æŠ@8`S×®8\ÅF:óOR:ş´KZ™`\Ò\'fl.ß˜\çµ|\í©\ÌúŞ¼\ÛO\Ê_jã°¯Zø«®ÿ\0g\é	¦\Âß¿Ÿ—®?\Ïô¯7ğ†œ\×\Şk€p8®Š0»3›±\Û\éV\"\ÚÁ\0\\\0½…X\Ø[\ë]=¶”ƒOPW’3YS\Ùùl\Ù\Öó’nÈ˜«#9P­;n:\ç`\ÆCc)¤y\â bF6\ÍHX«Q—nş‚˜H‰r9c\ĞT\Ö\Ñ7´Àµo@\Ç\Í\ÜÕ‚\Ùe\\\â£R8\Çò¥Nd\ã<P”a\æO\0u4G/˜w)ùi \r\Ç­,C *®\Ğ)®ÀN>v\é\ëV\Çò¨\ĞmŠ8$WU8Y\ÊW\È<\ÑÕ¿\Ï\ÑÛšU7µj‘º\æŒş”ŞŒò=*’¤SM)l£4\ÒF2j„.\î¼SAüiO\éMò§an\î)sQŠv\îq\Î*¬\Æ)İ‡JŒzS‡NM$R*G?»lûT@ŒÔ„e=sLÕ‚J»Xd\ZË¹±h‰t\å*ú5L¬`\×\Í‚¯\Ï<RIÊ¤ŸÂ´®\ì|ñJ\Ï\ÉS†\È#­ 2Z\Ş\ãO›Ïµc\ë\ë[\ÚV·\à\n\çdÃªš€Â³/4ÓŸ6²A\È\"š•´Sv&«jºEµjaºŒ0=Š\çt\İu¢ao}\Ãt\Ø\×O\á”9^ \Õ\İ2v<Ÿ\\ğ\Õ÷‡f/ƒ5™<H\İõ–\nL¹^Z÷cŠ\êdWF Œ\æ¼ó\Ä~’\Ñ\ŞûI£\ê\Ğz}+9B\Û\ZFw\Ü\æ\ìon,eÜ¬vz\Z\ë\ì5K}N\ßÊ˜5\Â\Ç*\ÈYqÁR0jt’H$ŒAö¤¥\Ün74µÿ\0\Z\â\Ä§’¢¸ı\Ò\ÚHÑ¸#A¯C\Ò5ÿ\00§\ëÓ“Á©u\Új\Ñ­ÀYzñŞ¨ŸSÏ·$¨Nzp(\ÊU\Êú÷—šmÖ™;,ˆWŞ£Ua¸aEÀ{\î·\'ø£=üi­7Y‚‘\×5\"1A†9óUf†H\Ø\Ílr½Y?Â˜\ÖB¬N\0®\Û\ÂfyT±?¸õ¯?šp¤++Œ\Z\îô[Ã§\Û\Ç\åq\ÏÖ€;4Ì\n\ÑPB‚©X²yaGCW(¸\Í&qMœ\ì.A\Û@l.zUII“\é\éR³<ô¦7\'h¾Ê³@\\SBştmô\ëL \äqRÁ.\ÇÁ\èj;x·.\à\Ñ\"4gP#F¨\êk˜”¹©m¦\Ü6\È\éN»Mğr:\Z±	b·ºÕ‚p*(0# š¯%\Ü&7óFpÖšXn–yY\"RUz¿oÂªkw\Â\ÊÅ‚Ÿ\ŞIò­Cq¨\Çc<0Bˆ\ZN[8Ò¹\ÍZı¯\ïYÿ\0~UÔ›²\ZE-\Ù$I¥Ïµ0œR‚H\æ²(q \ãRsG9\é@\ï\Å7\ÜS‡<\Ğ…8ºC\Ì\çjF¥˜û\n@9\àW\'ñ#]:/‡ş\Çb\â\ç‚P´Ò»°™\ä\Ş,\Õd\×üI4\Ä\î]\ÛPf»¿\è¢4Œ²ûšó\İ\Ğ\Şj@•\ÈSœû×¹øv\È[X«‚EwArA\È\Å\ë+\Z\ì  \íTnm–Px«\ìr=*&Á®ths\Ò\Ûm8\Ç=*	 €XVûÄŒ2jŒÑ‰dÛ*\ÓŒ„„–\ŞÀdş•a:MZ{}¼•\Ì})\ÜCTsÛ¹©cû§œg½D[b`un˜©nP¸\çÒ˜©\Îj\Ê\r«Œ\Ó#M¨29©@æº©Ó¶¬\Ær¾ˆr“)\ÊsÇ¥7¶:f”xĞ‘˜ô;¹©G_­7vô§cV #8¥\ê):Ñ;ıi\Ø Sy\Òæ‘\à{S\Æ<ÑF(\ê2M4œ\Z¡/´£\ÛùTy\ç&œ	\Í0\åN\\w\Ï4À\Üõ\å9zS°‰A\çŒÔ¬1`ÿ\0œ\ÔIaˆ\ç4\ìR¯S+U5nõ2µ|Á\è—T7‰:\äpŞ¢…j•[œ\Ğ4‘½»\â`[RF“.~5™=¤6@\Ê\ç­ 3¯,#¸Œ\ä`ö>•V\×Pº\ÒlÙ’\ß\×Òµ•\à\ÔW0$±\íaÚ’\Ó`6,õn¢B\á‡q\éW\ÒP\ãÖ¼\Æ\à\Ü\é—FKY™~\îx5\ÕhZôz”8\İÎ¼2æ´Œ®KV\âOZ\ê\à\Ü\Úb\Şğs•õ¯9;›–´¾„\Å(8\ç¡úWµ$ \à\Z¥«\èv\Zİ±\î X}\ÙM)Fû[sÈ¼¿\âB\n\Ø\Óu©mX$„”õôªšÆ}\áÛ‚“)’ÔŸ–`?VR’Œ®3\íYİ£K&v“Áe­\Ú}¬H\à\×­x^}:Rñ©xû:UûK\Ùl¤\ì\ÏJ\ê¬õ+}F.Pb\rU\ÓÔ‹4yz9Ûµ\ê`\n.G+]n»\á<†¸³\åEsQ[²’©ö¢\à%ª	\\Hq\Æq]^…hgœH\ã÷qóõ5‰km¹•#^I\0Wuah¶VkñXÔ¶µrAÇ¦*\Ü7yÂ¿\çT€À dŸzi°¿66óš´>}¨NG\"¹Mc\Åz…-\ák\éM9\Äq)ù±\Üı+N].­hI\Ù*†\\ğH5`\\¹x\ÖC°ü´\ÈH ±<öª‹–4 ”9Z\0¶qRDœæ«¤¡€õ«‘¶\åÀ™x.U\×kò* is\éLDR@\ÑÉ’qVcu.~„SUñ×‘F\ÅUfŒr{Sü\Î6\Û\Äûw›qCÛ§–7`ÓšÇº¹i¯ÀydOqô«bLr\Í\ÇS\Î)ˆ\ç¯]šşi	?\Ü_\ëU€â¦¹—Íˆ\0\àTXã¨¬\Ù@x \Z?\n=\é^ù ‘Iø\Ñ\Ç\ãL\É\ãšz\àš‹Z•>´€-ˆ\ZW G,\ÄúW\Ï\Ş7\×\ä\×<G4¡”§j\Î\0¯Wø‡®ÿ\0bxm­¢`..¸\Æyüÿ\0Zñ\r6{¨  rkjQ»\"L\í¼¤\îòØ®I9<W­B‹j£µsÓ–‘Œ+¦#h®Š\îÖŠ\èD;ŒcM?şº\\ñL?1Àük\Æ1	\Î\0¨1|T³ª\0\ïMEGµ0*d\n¬ñ€8jÜ„õ&«±\Ï©Uxò@\0Š³^_\ÌycÖ¥H¶ü\Í\ÔÓŠ\×U(ufS—D4/c§üRcƒ](\È:Rã”qº—#Š¤!@\ëÒ—<b™€\r7 z\Õ—~>^\ŞÔ™\çÂ˜¹\nij„J¼QÁ\Ï5=1\Í³œN\ÂH\ì\Zi\ä(Ï¯JP9¦ÿ\0\ê q\ÏZ;w q\ëø\Ó\å\Îs\ØS³˜¨óšx?…0%N¸\ÅK!>Y\è?ıu\njbN\ÂiÑ«{\Ô\Ê\ÃUTl÷©“5òÇ¢YSS+Ue\Î:T«ú\Ğ2Â¶M<\á†\Ò2*ºœ\Z•I¦;›¤¼];Š¦:`Š\ÜŠ¯qf%\Ë Á¤\Ğ“YG7\ŞPMgO¤ù\æÚ’’x­ÂŒCR•\ã‘H\nºf¹¹…½\ß\É \ã>µ\Ğ\Ç0À\äõ®f÷MIÔ0ÃE2\ËPŸNa\Èf‹ J¸Ë¸š:«›x/`hg^6†\ç\Zÿ\0ƒ®4—{½8m³“\ê¿Jô{•™\ÆÀƒVƒ<ƒÚ©\Å0RhñˆgIF:7pj\ÔE‘\Ã##¸®\Ç\Ä^Šğµ\æœW#’ƒ£W\ZOÉ¶¸‰’pq´ŠÅ¦SLè¬µ±«›œ«ß½eÄ‰ª¤“öe01W#\ÓcA¸—`9 «ñ\Æ\0@Ú¥\ÈV±KH\Ó\Z\Ì\Òİ­\í\ÜT±»T˜\È\â•\ÄHŠ\Î\Û@$š\Ñh\Ú \n«>2h\Ó-ö\Ænd^œ(4É‹I!>ıkX­y­×€\î5o\Zk\êú€¹´\r¸BTƒ\ÇEô\Û]\ê $\\(«+‘òzô\é-ŠsÚ¨ŠL\æŒ\Ò\ìaÚ€œ\ZÑ?w‘TbLrj\ÔnP\äSB\'Qšp\"Q\èj2¥O4Àviw•\éQ\Ó¹\ëL®l »%ö…—\×Ö²µK–´µ0mÄ\Ô÷\Åk\É2ÄŒ\ìpd\×yt×—/+\çğ=)6ˆ\ĞqŠ@y£=\ÍH\Å\Î:šC\ÔR\0\Í»õ¤?\Z	¦\ç9\éF\î\Ôx\ÆzÕˆ\É *òIª\ÊØ¬ë‹¢xjb§\Î\n\'¨\Ïùõ¦•İ„y?\Ä\ryµ¿\ÌCGbLT¾\Ó\ZYV_¼x\È\ç\ÌE]Ş…\'-#rk\×|!¦,Q¡e\Æ\Ñ]\Ô\"’r}j>‡aa‚\Ù`U’sM\ã¦*6“:\Öww-++\n\Ç<ıi3)3\ïù\Ò3€:\Ò\áŸ\èi\Çy8¦+|\Ä\äb‘\ÈnI\éTHpâ¤÷\ØqÚ’$\Üw0\ãµXf`WE*wÕ™\Î]	‘HG\çNİ“šLŒõ®¤b7=\è\'Ú–ŒƒÀªB¨\Å4¯ô»²0\r#sÒ­cõš\Üû\n{sL\'­Z›¸\éI‘’•\ç§Jny\ëLC\ï\Í\ãŒbšN\ã\Å.1\ïLCÕ¸œ\'©¨r\äñF\îx¦\à\àô¢£\à\Ó×’;\ÓÀ\r9G\à})„œÓ‡Lóø\ÓÅ»c\éSdù}pj,Š™¹CƒLF\ÔoƒÒ¬Gu\ê€ş4Q_&zd\ë{œş\ëÿ\0¦D\Ï/ü{ÿ\0­E0¾\çı_ş=N\ßô\Ïÿ\0¢Š`;\í¹ÿ\0–xÿ\0S–üùgÿ\0QE05òJ¿4ø÷ÿ\0Z³$\Ô\Â1Q\ã»ÿ\0­E€Aª‚\î?ñÿ\0şµA=üs!lüÿ\0­E™±.x$\Ê÷KWO²Z5 \Úÿ\0\ëQEh„\Ëq\ê\äõ?ø÷ÿ\0Z¹wWµ%ÍšnA\Ãn\çŸÂŠ*gğ„w3…\î~/’½SÅªp?sÏ®\ïşµW9¡a5 ıOş=ÿ\0Ö©\íoÄ·\n†Àp\ßıj( \rûD\"ˆ\Ö(7õª©\Ôõ?ø÷ÿ\0ZŠ+¤\í{·\åğ?Ú¥[\ï\á1\ä½E†z‡ÿ\0V?:˜\\ƒÿ\0,\Ç\çE\0\Ó6O\İ\Ç\ãBÍƒ÷Z(ª2\İ°?:/7Œ4`ş4QLIp\çUÌ™=(¢˜:\Ü\î-–%;CMayx\0gô¢Š‰\r\Ş:\Ò\ã­RÒ¾ô˜\ãQ@\Ænx£q\æŠ(\0V;€¯\"øª\\]\ëml\ÇB¸UQZSÜ™laøn4{Ì²\çœW°\è\Î\"´\\ş4Q]¿ò\è\Çíš¾~‡õ¦îŸ­W)¨\ß<œŒt÷¨\æœ\à~´QLLb\Ì}?Ztr\æNFyõ¢Š¥¸‹B|oZc\\~\ï\ëE\Ûˆg\Éû½ıi¦\ã·gZ(­\"›“ı\ßÖ£7=N\ÏÖŠ*‘#¼ó\Ûyú\Ó~\Ôs¼ıh¢­Csş\Ç\ëIöŒÿ\0\ëEHLgŸş\Ï\ëMóøû¿­UUºÀûƒó§ı¬‘÷\0üh¢¨^\ç\'\î~´Ÿh%s·õ¢Šb%K£Œ\íıi\ßi\ç\î{õ¢Š\0\Ú\Ï]Ÿ­Eq|\Â\"Áp~´QLdwX\îù¿\Z»ı©ÁO\ã»ÿ\0­E\Æÿ\Ù',1,NULL,NULL,'1',1,'ck1232','2016-11-23 22:02:06','ck1232','2016-11-23 22:02:06','N'),(4,17,'0.jpg','ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿ\Û\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\05?\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rğbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Ú\0\0\0?\0õ~_Ê—=ES\Ú\Ş^IbW;õJ\æ\È^d\Û]:\È:®ó^o1\×\Êk’ñÒœ®½\Ípğjzl¥\ÌÒ²XÕ­?[I\ÈIe+\'N¼Q\ÌW³gpv?•80\Ï¸SJ¹ºC5…\ìğ\Ì9\Ú%![õ\â¹Øµ\ícLŸÈ¿–\áXe\É4ÔƒÙ³\Øm\ç\ÛXğj¶¹\á\Û\rz\Íá¹‰Ia\Ãc¥szN¸·\ÈH˜\íÑ¾•\ÔX]œsø\Õ\Æz“(4xô¾\Õ<¬Kuf%¹S´¨\éõ¯/ñ\ä÷7sM.|\Æ=\Î+\ëù‘&B’ e#Œ\×\â/„\Ú6»ºHÉ\Ï9^™®ˆ\Íu0”;6\Ù_yƒË\İ+C\Èh\Ø0\\ƒ\È¯C\Ô>\İÚ³Mix²m\ä&¹	¬ä°\ì\îGÎ‡ªi\ìf\â\Ö\æw™\Ô\Èâ¤‰’Hb’\âÔƒ¹I\Å00Q“ôª$°\Ä79#šnH{zSŒnzq#99\0ô8-€8¥\Ğr}¨`\0À¤ò¼cµ\0?\'§a\Îq@\î÷\Å °\ä}\r.\0#=\è\äñ\Ç>Ôœdö\0ò:P3\ĞıEø\ã\ÇZ\0UÜ£~zqV\â˜J?R*¶\íËŒcœ}(ŒpG_QH\nš¶’@/ù§zÁUx\ÉV\ë\ÜWon\Â@#\Ö^¯£L±}\ã\ÏÖ˜±I’LsV·º~†¨°h¤`\Ü\ãT±H{uú\Ğ\àp¹\r×­=1€Ns\Ôf¡V\Î\0\àšrñŞ€,†\íƒô§*ñ\Æ1™¨ƒ6I§£ö9\éš\0pQ\ÇP:qNm¤p\åJe\0ó†“v\Ó\Ôs\Û\0¸Ÿn§¾jUG^¥F#©\ÛÖŸ\Ô\")-\Ëqõ©\ÒB¼N:UP\Å_–\â¦x\àç¨¤\Ík\r\Ò\ì#šÀ½\Ó%·?(Ü£µt’®J±ö©—\"\ã\'ù\Ğ3ˆT\äzT¢A(ù±\ÇZİ¾\Ñw†’,g¿\×?,À\ÛÊ\æHğ\Ê\Ä~5j\êvcl³ •QF\È\0ŠIc3È¢Àl\Â[­H˜kù\Ø™cYòjWW\'2\Ì\îs\Ü\Õ\ä\ç<\ã\Ó\çƒ\É÷¡$€´²u,NI\ïÚ¤sÁ\È\ÏQT‡\0\ç=E<3„ö\ï@\Z±N\å»1V¡½+\Ğ\ãš\ÃI6¨çŠ³¸\èI½\0u6:\Äö’ŠVF\ëÁ\Åw\ÚÄ»\ëGD¹&Dõ\ï^CÁ†<b®Cy‚2N;R°Q\è¾3Óµh\×÷ªö®…~t\Ã}+\å+\rNX$\ß”Ç¥{<U5Ê¤SÉ» \ç­.z—\0UY\îvt©\Ã‹p\î+*\ë;1„—\ëP¶cÖ¡ \æšWÀ•¦vS\ÍT’Y“j`H5 \Ú\ËÈ¢ä”’õÁ\äñW!¾\Ü:\Ô2Z«\0ª\ín\èr¿¥06Å†sK\æ7­fE3§\\\Õ\è¦V\ÄL&aSGrA\ëP\à\Z6b€4|Š”>Ee©+Vc›¦hzŠ$\Ïz˜\Ğ\ÑEÌ˜v>E`\ê\ÖRÂ¿j´«\Ç\È£\ÓúVw\Ã\ïˆ¾-´W2$Z¼û\È\Ï`şúÿ\0QÚ»)m\ÖE\ÚG\å´\â\ì\Îø»êŒ­6ò=R\Ìc}+[ğœ\Æ\ãOm¯\×g­Z¹2h¥™	‚C\Ë\nŞ·š;»tš\íH½µGi«\İé’›[ø\Û\Ôr>•\ĞIo§x†\×lŠ¯Œ>òÖµõ…µòyW‡\ØÁrw~¿\Òd7\ZT¯,\İxPVŒ\Ç\Ôt-KÃ³ù\Ğ5 9vúúWI x¦+¥Hn[l\ëIa\â¸\ÛıT‹a?)8\àıE3SğŒ©öıEWaˆ\Ü§§ÒŸ¨zı¥\Î\åUr7­\\\éÒ¼³EñÖ–ÿ\0b\Ôc`«\ØöúW¢iÚŒ+\Å(tn„GÖµŒº3\ÂÚšóF\ÃÚ¾iñ\ì-o\â‰\Ôq\ÏZú[¯¯ø§\áK\Ã~u(#/\å°+h;H\ÂJ\èó¨˜I\Ì2;\ä\ÔÛ˜²\Ø\È>”Ø›¦=±Z>\ä\Úø*GZ\è02•¸\íO–÷ôô©®-pr£‚sUsµGz`J	\İ\ÆsŸZ\r§jn:ô8©Aù€\ÍÄœœsÖ•‘\ÏOSH\nO\é\ëAnû@=	4\0ıË°\ç¦¤™<Œæ€§Î•G9\ÈÀ÷\í@ŸQ\Øb¥R\ã\Ó5Aa·‘BŸ9ô 	3µsÚ®Cz[òqT\Æ\éôâ®A(G¹ µ=\";”w‹‡\êk›ehœ£‚1\ë]…¼\åX#”ú\Ô\Z–³!‘0	†sq\Êzƒù\Z¶?Zªñ\É»]qƒÚ¤B\ä\æ€.©#–ú\ÓÃ¯›º¯oÆ¥ONheoÎ¤##¿øUt`	6A8\äPŠ;^hVÁ=3I•ú’ixlÿ\0\0<€xâ¶§#œbš9giùPp)\"\È	\É=GJ”œ?QU°\ã€=úS\Ñ\Æpzt\é@â˜¢€yæ£º\Ó\í\ïS!B·¨\íL\ê9\çŒu§#²· ÷ j÷K–\ÙÙ€;zñTÕ²Fp+ºo*\åJXº†‰É’!Š\0\çzöÇ¶*\"›[8³VZ)!b‘\ê*23\Ï\ä(\ãÓ\åB³ƒ\È\éJF1ƒÓ­0zs@o\0pqÚ¥I8#®\ëU\ÉÀ\ny#½€\ãŠ\0¶’\Î\rY\Î\Ñ\Ûš\Î\r\Ç_Ê§IT\0£¿RV+Œ3Ç­t\Ş\×_N¾B_Œô5Ä‰>n:zÕ„œ¨œúg¥\0}w\á­f-F\ÅpN*õüX;€¯Ÿ¼\ã6Ó®’\Ş\áğ¤Œf¾€´¼R³WF#¨ h\Î4\Üf¦š\"Pö\æ€\ZF)W\"I@\Ér\"?1â“\Ç \àæ¡»¶ó\â }\êå¤¸¼Ó® ”\ÏZh–vF$aM”?)¬]~90¹­x/c”d0\æ˜’L\Z_ U\Ù<\Zµ\n“Ş˜ñF(E<g½X©«	6*\n]§µ\0^W)\ÕM©æ¬‰8 gÂ–º¥æŸ©-õ•\ÃÁqnIò+\é/‡?\í|]j¶¥!\Öc_™3…˜¬¾ş¢¾_\ç55µ\Ìöw\Ü[\ÈñKWC‚¤w²55©¬&\â}«wl—4Nª\Ùn\äW44»\Í\Z_´i¬JwÛ¹\Ï\á\\G€ş4Z\Ş,:w‰Y`º\à-\æ1Ÿ\ïÿ\0tûôúW¬M$7‡RNCPEqJ.:3®MhV²Õ­oñ£É›8(üs\íVd³pwBøö¬[\ë)	Ş‘­\â«÷dCŞ¢·\Õ>\Ì\á#¼hÛ¡‚ñvşG§\ëP]»©i¶W\á\à\Ômü¹O+*+	ôıc\Ãòı§M”\İZNÃœ}Ev+©Gp»/m\nú0ù‡\áT\îô¸Áó\ì/İ½J.4û™VúÎ‹\âDû6§\0¶º(r1\Ï\×üj	4\íc\ÂÓ‹‹k‹^§Œ{Šmı‹\İ6/¬–SŸøø´ 0úôi\×z–”qi?Û­GŞ‚PCÀÿ\0J`uú‰\íudò‹yw¬lyü=kj\æ\Ú;¸\Z)T20\Åyü¶úF¯0’Ü¶~9\Úük^\Ë^\Ôt’‘j‘ \éöˆù«Œ\Ö\Ì\ÊTú\Ä\á¼qğÙ i/ô\Ä$}\æŒw¯5@b”\Ç(!ÁR;\×\Õq\Ík¨Aº\'Iú×ø\ß\á\Ôw\Ê÷ºr¸\êTÿ\0¯]P©ÑœÒ…\Ï$‰„¼*…İ—VLÕ¹b\Ê\á\àn‡Ò®XB\×÷	m\åø\Ílec™Só`ôïš•pCs\ØV¶·¡6›q\å\îù\Ç&±Q°\Äcù\Ó1\')\É\ÈãšˆO#J™AnC•Û^ŸZUùI\ãµ5x<ô \Æ	\Ç~1@9Aòô2(@I\çZ7±\é@\Î\Ï¾ô\0ªF\Ş\ßÊ—øz\àzTE¶¸\ä\ÓùÙŒ\àš\0]§\0çš±m9\á	<šsM.1Ó¨\ç9 b\êºZ\\\ÄY~÷c\\¤Ğ½¬»\\\ï]„W,\\û´\ÍKLK¨‹/\Ş\ì@\Í 9X\ä9S\Î;Õ­\Ù9\è*¬Ğ½¬ÌŒ¬>´© \çš\0¼cõ©:.;öª¨\äŒn5:É3Ó¦h]\ä¶\ÈjP0€Œ\àvôª\Ã#ƒ}*Xß \àzP\ê:ŸÒ“\0œ\ëL^\Ø\è;bœ>v…\0H8\ïù\ĞF;\â£û\Ã\npz\nrŞ”:œ¨\'šy!€\àzP+OCô§†\ïs@†eù±Ç½YŠ|)V\å}j¡bÀb”¯\ã@¾\Ó`ºB\Êa\\\ÅŞ™-³Ÿ”âº„Ÿø«aºŒ«rH\êFiÁO\\:ŒTE9÷ºMGE*Y¡Á\Ç54,0¥}³@\ÊrSN\Şw\î#ƒ\ëOhöchú\Ô<\ç·J\0z“ÁúúT‡¨\ã¹\ïP8\Æ\çJ8`	 e°\Ø\ÉSÓµ=[kséš«¤·Ò¤V$rH\â€4`˜¡) ×±|7ñùWK\É=0\Äõ¯F%\Ç\'ª\å­ÌL²\ÆJ•9\ÏJB>\Ë&;\Èˆs‘Ú¨IÓ‚+\Í~üB\nš}ôd)cÖ½^EI\ãG\Ï¨\ÍöR4Ãš@/µE5œW*U\Ôf¥\à@4\Êj^\ZdböùJ\Éó\ït÷\Ú\ê@\è\Å\×aÈ¬Ë›o2\nš¥!XÁ³\×s€Çš\è,õH¤QóŸz\çoü54Y’\0x\ç–³\Ü\Ú8GHªÓ K\åX}\àjÂ²µpvzÁ\Ím[\ê\êq“@ QÚ—5\rú°\ÕÔ¸V\ï@\ê)\ì0´ˆ\ÊpA©\\(ñÏ‹~\ë~™\ÚHMÍ <Oô\ãµq§ƒ_Xx[\â†üyn-w$7¬>k9ñ»şz7\áÏµr¾6ø+i\æ\Ş\è;m\îyc>F?Nß‡\åHiŸ=\ç]g…>!k‘R\Ö:\Ğš\Òo™ÓºŸ¥bk\Z.¥¡]µ¦£m$/\î8op{\Öo~¼Ri5fZml}A\á?ˆ\Ú‹¥Š\ÜIö-E\Æ\r¬\Ç\ïö¡úp}«³¸°‚@Dƒ+C€\ßÎ¾.Gh¤ŒU”\äÁ½·Á¢I§xœ¾øö¬w‘¦\í\Ë\Ó\ç½9Ÿ-J\Ö\'M:\×Ñª ‚Û˜¢Ú½N\Ö#ôª\×Z\è´Fg\Æyoşµ^i-\å²K˜%I`•¤‘œ«:j\ÌûW$\Ê\ØtŒt&¹/©ÒŒYüGu5\Îb²†(\Çü´pI?N”\Ù5û——Lúl§\Ôm2N\Õ#ÓŠ\É{B\ä\r£©éŠ¡‘\Şø¶\íH2G»zy‘óùj¾ \Û[‚&²	\ë\äË•?ğÿ\0\Z\ÄÔ™|Æ?Ÿ\Åc>s;ä«ëŠµCg ZüQğı´Š\â;ø$\È¤K©«\Ñ<;\ã-\Äj\"´\Ô šb3\å\çkŸø	\æ¾z\ÃSOÃ«g\éŞ¥\Ã×šU\ÌWV²<SDÁ•Ğœ©­\"­\Ô\ÊJ\ç¶x\ÏÀvº\å»\Íˆ\î”d8}yN—gq\áım…\Üe\Z?QÁúW©x;\âz²G§\ë`\Ô~\è|a%ÿ\0[ú÷†,µ‹i¯šT\íp9­£;J7\ßs\æÿ\0\ëf\çP–f9\çŒ\Ö8‘.rz‘]·‰ş\ëp±6…g‰z\àŠ\æ—À~&Óùt\é`òWb¶ROc\'.†p;T0{Ô¨I\à\ç½Iqj\ê	\nÛ‡j¨²NFqTImF>\î}*E?\'N@\ç>µ^3\è:Ÿ<sŠ\0•UX€1\Í?!GO­D¤osR…\ã\'§Ò¾XG?J@„\å¹\ÈTÌ¿)\ç9éŠƒn\È½\0.À¸\Ç^ù§õ^)»F\Ş;Ô¿)A‘ƒŞ€\"d\\‚3ùÔ±\İ:\äv>´\Ğ0\İñ\ÛŞšügoJö	y	m£5\Ê\Ïm%´¤\ã=q]lS°\\\ÇzeÕœw±6=zR•Iy\ÍYWV\Æ3\ÍAug-¤Ì¬8ö¦¬üy \è\Ã\0æ§Iöª\Ê\ÇKf¥iidd½iû2=;U|\ão­J„ L	T\áAÁ\æy\ÇcƒM@É§«.qj\07| m\äô¥\r·½&3Ç½\àõ 	cpXryõ\ïR‚	\à\æªw\Æ\Üzš[Ï±\0\ãós…9X‰/½\"pOLzSPüÇ°\Å\0[tq‡\èj\Í>)\ã,£Ç¡¨ø\nû\Ä\Ô\Ñ\Î\ÈÀ”\Î]i²\Â\ç+‘Y\ÒÁ´Œ¥w¬#™@`±u\r%€&,‘HHğ03\ïA\àûU›»g…şe\æ«?\ÂH=ù¦1G\Ê:g\ëR†²>•Àœ§ØQ\éHd\é\ÔG\\\Ô\Ê\Å[#ô\íU”·ŸÖ§\\‡\Èş´¹iu%¬«<LU\Ô\äÚ½\Ë\á÷Ä¤»‰,o\Ø$\Ê0	?z¼Œ+\n±m;\Û\Ì$Œ•qÊiöš—(25Zò‡ş>óö\Ù^¾$OZõ¨\Ù.\"‡ Šˆ±\Å¤+M\Ç† ÷¥‡ls\İ\r&*9\×|dg±\ĞyqIùT©¬mSÃ–÷ˆJ¨\Í`ÿ\0\ÂCu¢O‹€^zúWW¦kVZ¤A\í\åROlÑ°<\Ô4«3%Aªp\Ü<gkd\Zõ™\íb¸RG5\Ì\ê\ŞG\â>\Õj]\ÄÑ…k|Ã½k[\ß0x®vki\ìe\Ú\èq¸«]\0\Î=j‰:\Û{\âq\Íi%\È`9®N\ÚnzÖ’\Î@4†|c©$n\È\êC+)Á\Ô\Õ\ë¾ø\á¦\ì¼H¯}h>QtŸ\ë“\ëıñúık\Çğ8\É\æ‚	\ë€i\×>Áš\Ë\Ã?t?>7·½¶”`Hœ•>„uõ¯ñ¯ÁOEgº\ÑÕ®\í:ùÆ¿O_\çõ®Añ.«\á‹õ»\Òn\Ş\Ş@~`9WŒW\Ğ\nøÑ¤ø‰c°\×V=:ù°¡\Øş\æS\ìO\İ>\Çó Z£\æ™#x¤h\åVFS†V ı):WÕ3øS¢øªq{\Ìeeı}E|õ\â¯k^¸q{n\Ïn>\í\Â”ı}(\Zg_ğ\ã\â2\é\Út\Õ\Ü}••¾\Ç;õN÷I\ï\Û\é\Ó\Øü=	‡D´†S–X\Æ\æ\ÎrÇ“\ÏÔšù[Hµ7±—8Xn8\Ïù\é_J\İ\ß6¦\Û[[°R±¨>ÀW\"	jº”$Ú³55C\ä\0ƒ¹®2òY/¦0Û‚±†oZÓ¶\êò\äfF\êI«Ø…BW9\Ğs\Ëc8Üz“Zv¶6Î¡pzqNºÓ¤—\0\0	÷ª\ÂI4\â\Æ2Ø¦#z\ÇOµ•]>S\ßÒ®Í£\ÚÈ¤¦0F1T9]“p\ãz­>©5¤ylñ\Ô\n­Dc\ë\Z“4Œ±sık_\Âş4º\Ò\î£\ÓõILÖ‡\n¹hÿ\0J\Ç\Ô<T³‚§n:\Ö;\êò‚3\ë[GmL¤‘ô,w0‡Bd\È5Z\ál¥W\0€§µy÷|fº\éw²ş\á!‘\İ>‡Ú½2d@À‚§\Ú2\ÛC\æMx…\×\î†x-X\×6eÇ™OZ\Üñ¬\rm\â{•#œü¹\ïXğO°|\İø\é]\Ø\ÂKR‡\İù[=jÀ#<û\æ®]Y¤ˆ%\ïw¬\Â\n6{\n²KJ\ÄdŸzFIü\ÅWFœ{sRƒ\ÇJ\0Ö—‚pzg‘Mú}\éGR\Ç?+ŒR˜\ä\â¤_›zR”œğ:š\0®H.1\ßŞãŸ¥#\0zŠS\È\Î8úõ a³ã¹§F\Ä´{\ÒÄ£\à*GU\Îö\Í\0Cwg\ä\'ûØ®N\ê\ÒKI~\îx8®\Å2¹Áüªµ\í¬wHGñb´R1¶*ÒŸ‘N9õª\×V\ÒZ\ÈA.iM\Çœv¤\å|{Ô³xªÑ¶TsS!À\Ær1@¡\0“Ÿ ©†JŞ \Õe=NsOŸ¥\0J8`9=…9rI\ÆqMSœõ!c÷}?\n`½º3\éš@O~\é00œıh@\ç9\çŞ¤\É\Ï\'ƒ\ë\éP…\Ãgı)q\Ï\0\Ğ¹$òrz	!s\ĞSC|ÀšR{gŠ\0z¹\ÎA*\ÒLpA\âªm\ä\0=\é\Ë\Ğ\àœ”€/4Ø¯\"\'\0Ş¹«\Í&[w$®1œt®ª9™{‚A\æ¬mŠu\ØË;\Ğ3\Ï\Z6^µV\É\Î9\ÍvWš2²+Ÿ»Óü§J\0¤T\0zSòxú\n‰†N\ÜM\Ï\Íô e¨ˆ=¿*[\0)üıjš¾Ó‘\ÜT\ë6H\àœP\ëYä·•e‰ğ\Êr\ë^\Ùğÿ\0\Ç\Ét«exø•p2O¼5\\qÒ¦¶º–\Úu’6*\ë\ÈaÖ€>¿WI\ã„})¥k\ÊşüB*–W\Î\\pI\à×«£¤ñ‡Q°\ç¥NV£jC(^X\ÇyF\àŠó}muO^}²\Çy€²ƒ\Åz®9ª\×úl:³E2\î)§a3\Â_lµtX®$£ƒ“^\Ñ\\F6¤v¯š|W\á¯jm²\Ü!İ’j\é|7\ã\Û\Í4Æ“3<Ds\ÕN=P¯\Üö{\İ*\Ä!”d\×©øz[G/%k§Ñ¼Ge¬B­«¼™­Y#IW)´;\\óH\'h›c\ä„\ZÓ\ã*0En\ê^Š\ã/½«–\Òk*\à•õ\ÅZw%«$\0Nq\ÓÒ˜qÿ\0ê§…\ÇŠL\×9¤P\Ü^iyúR\êG´\èø³®øA£¶’C¥ƒÍ´\Í\Êöªı:W\ĞZŠ|/ñLt‚H\ä“g\ï-\'\0Jƒ\é\Ü{ŒŠøóú\×}ğ§\Ãs\ë\'ûIšX,\ìWÍ¸’3†9\à(>§Ÿ\È\Òn\Ê\ì9n\ì\ç\ÅÆŸª\Ğv2»n1cyı+QÑµ{²§\Ê	wÏ¥wğ¨\Åaÿ\0¦\ÏÔ“Ö©]_H\Ñ5³ ]‡‘\\5*s3¶”9‡id- HS£#“Z‘\Û.Ü¶¨—†÷©\â\Ü\Ò­bjS’$YWŒŠ\çüVÈgkó—\Î+¤¾F2Àt¬=qE\å„7q€e\"®;‰‹¤ø¯IwşÏ¾¹Š\Ú\á>P²»¿>õ{Rµ´2UX‚;)#ô®w_ğ\\^&´Š\ê4D–H÷=kˆƒ]ñ…Döi‡,ÁH\Ñ\ã\ÓÛŠ\ÕA=™7ksg^\Ğ\Ê;Kn\\g\"° ‹i?0$v\ÎqZ£\âK¸	ªZm8 ¹LÒ¹G\\´’e¹³VfnHˆ`¨5¤SØ‰¸ô7¡/	\È\îk\Ô|\ãV¸•4}E\ãòÁ#wÿ\0d×Z_½\ê©Ê§·6·‘%‰ğ\êC)÷ƒM¢Rñ×€`ñ\r¹¹¶\Äwˆ¾Æ¼P\Ónô«Æ´¼ˆ\Ç\"‡¿Ò¾—ğ\ïŠô¯[f\Î\î7¸Œ=¾pñ·|O~•WÅ¾±ñ-‘[…$€r*¢ùY‹W>z³“x\ÚzŞ¤¼±VB\è>lrjŞ§ _xvü\Û\İDÀg\å“I™l‘\ï[\'r\Z±‚Q£!H9\ê3O@;±µ½}f&·Ü£\ã­sÎ²G.JL’Àf\'Á©\É\Ç\n“Œc¯Ö§P1\Ær;\ĞÔqŠrHÁ\ã¥1W\Ç\åO.s@\r1†\Îx¦œ•&\á\Î@ı*\"ÜŒsøP\0œı;Ô¥q÷x¨ò3O\Şx\ã§4\0\î=¨*W\æ\è~”‰œÓ‰\à\Ğ[\Ë8\î\â?/8®Z\ê\ÚKYO\Êq]’d7N\rC}d—1d\0M 9¤8\çğ«1\È\0ısÚ¢¹µ’\ÖS‘•<\ç\ØÜ’1Œt\â€.†\Ën\İ\Ïj_+ƒ¼U@ÿ\0-L‡\'ŒP2Â’9?*Dlö5bSŞ”rO¤ùÈ¤\\“;SA,\éŠwE<\â\nšp\'@§\Çô,[\éQc¦G9¦ƒ÷\ã=*Ua¸q’=j1\Çš`ôüi°[\ä¿QŠ\ÃŸ~”\ØóÀ\È\ëNrA\0(\0 …;@\íR	h\Æ1šb§s\Ï\"—\Ù\Ï\å@£™YpzSeµIc%@<t¨¹<\ÇZtR[\ÇlP\æ€	/s\×mb\\Y\ËoÄ¨G=\Åze•p\ÜZŠ[dhÏ˜Á\éE\Æyø¨\\Ò¦\Ô6F{ú\×Sq \ÛÊ¦H\Û\Ëa\Øô5qf±²»\ÕOM	ı=ªh\ß\æ\ëÚ£hÀ6~‡“RCnÒ·B;t 	\á¹{gY\"«. ó^·\à‰Œ…,õÁ\è®OZò¥³TQ»œu¨\Ç\î\å\Êm\è\Ù\é@Z\Új0\Ş\Ä6JŸ\'½x\'ƒ<z\Út±\Ú]HH\Î1¯j\ÓuX5\ãpr)\Ñ\ÆiÀS\nz°\Í +j:d\Z«\Ã2cšòøbm\á\İ˜Iü«\Û\n©¨\éğ\êV\Íª}ERv\Ä4­Z\ëN˜<R2\àô\Íz¿†|w\r\Ú,7lø&¼\ë\Ä>ŸI¸fT&õô¬‹y^6Ü­¥SI’}+\ÑÎ\ã`\Ê}*+›8®W£5\äñ…Í‹\"LÅ“\ë^¡¦\ëvº„*\ê\ã8\äT5aŸÿ\0\'4ƒ®sš\î|cğ\ËYğ¼\Ï*D÷VY$H‹Êqık‡\É½P}\Î=¨”‡\ÜQ\ëÚ€ˆ\Ò:¢©fc€R}+\é/‡ºğ„.`p?´d_´\\ñŒF?Ÿ\Ç5\ã\rm­\î|¥­Â†Dg”)\îÈŒ\Ëú^ñ\á\Ëûy\à¾cû\á—ü\ë›-9Q\ÓB÷™£¤j\Ñ\ëZx¶k—Š\ê6%€?{\Ó²Hò\Ü•\Ë\Èyf\îk–š+}7^k\Û;²bEİ´\Zµ´c5\ÅÄ—0\Ët=«•\ÇK.\×7‚M(”npÖ¥1ªw6\Òµ ,Ë‡ˆ\îÁæ¹‹\àö¨\árQ\"µ…ê¤…	!OcÚ¤¹´[‹f\ã \rRo\ŞE{£[H¯=py¿¡hÚ¯7RE\â}Ù²?\";\×3£\Û_[k\ÒYÁ!ŒL¤ƒø\Z\åõ¿i:Ô–\×zm\ÜÑ³³¨,?\Z\Ñ]½Õ‡\ë~ˆ¬‰\ÑN\è\Ü\ì\éŠ\ç \Ğ\Õ\0GU	œ\í\ëN\îòò\'\ËF$+\×S4\ÛÕœs\rl¯c)nX‚\Íh\nG=*øB\Ã\0\nX‘Ÿ†>•`(AŠda¯jº‹š\ëO¸’\Şu\n\ê\èpA\Å{\×\ÃŠ¶ş+·M7Tu‹UEwA7¸ô5óÿ\0$lÿ\0\Ï%şµ…aw5\ÒO¯¯!\àƒÚ´\åº0n\ÌûW_ğí»fñ\\D¤\ãƒ\ÜW‡k\Ş¼ğõ\ÛpZ\ßw\Êø\éõ®·\áO\Å3\â(Æ‘«¹ûtkò\ÎFzô½SI·\Õ-\Ş‘YH\î+4\ÜXì¤µ<\n\ÒE*}i/ôt-\ëò¾;\×E¬ø.\ëH¿m\ËnNpH®c\\\Öˆğï¯§ÿ\0^·M=Œ\ÜZ\Ü\ç$†KY™\\Á\ÇÖœ%ˆ\'­k¬ö\Ú\Ôe‘¾p+\"hZ\n7$~”\É&F õ\ãµJ0¤çš«n\Ç?Zœ°Œ\ã\ê(ªNM<qø\ÓT\á»Ôœt\ÇÖ€ÜF1M\ågüdƒšn\ÓÛ­\0*78##ùTˆ7t¨ö\ä‚?:0s\Ã6À)…2ñ\ïOsø\Ó\ÊQ\Æ\r\0f\İZ-\ÔD\Ïò®f{gµv\æ»3Vùj­å€@\"¢?\'<Vcs¸úv¨.\í\ÖB;=z\ÓbSŠ_“Á\0Ô‰\É\ëURAŸ~•(o¥ ,«\È5*õ\ç\ëUƒdzŒóR#vÁ€&Gm­\Ï¹ùx95\Z:šz\ç‚yö C•G$ñAQ\Û\ëš9\åºR·rFA 2*@APA\É©‡h#\'Û½5YU°À›\'¡\èZrû:?˜\å›\nv\Üpğ d¹\ÉÇ¹\Í&p8\ïH\r\Ô\Z@<“wj‘\'!B±\È\ÅW\'$’)\0*x\Îh<\è²!\nNqX7ºtƒqNm+÷\É4®©\r\È=h“Š\İûÁÏ§¥^ó(³\ÆG?…h\Ü\Ø+)\ØpOzÁ½´¹ŒAlP¦¾S¿zUx\ÚF\'Šdq\0J½mm5\ÉQe³\ß(%\È95vşñ…Î—2E<™ˆñ’zV\nh\Í{ÙˆoJ…¬\Ìgv0{b•\Æ}-£\êğjV¨ñ\ÈFz\Ö\ÊWÎ¾ñMÎr‘\È\Í\å:•\î\Ú&³§j	\"”P3ÒœSP\Ó\à\Ôm\Ìr¨9\äW”ø‹\ÃR\éW\Ñ\ÂO\í^\Ä8ª÷¶0\ß[´r¨ Ji\Ø´BXÚº*ymñ±1\ëQ\ë—L¹i#Ra\'Ó¥6ÉˆVqTõ/	|P\Ğ<o\é÷\Ë¢\ã\ŞV\Ê\È\Ønÿ\0Nµ\Ïø\Ï\àõªd¼\Ñq\×,c\ås\î=}\Å|ø­°†SŒ\Zõ?|g\Ô4¸¯¨X\ä&}ö?\Ä=\çA6<\ëW\Ñuğ\Ûj6\ÏƒûÃƒ\îz\Î\è}k\ì¬¼)ñ3C3A$p\È9eû\ÈŞŒ:ƒ^\ãƒú·‡¥k1Z\îÏ’GÎƒúÿ\0:\ç!\à\Éfµñ=•\å¼e¤‚@\àv> û‘ø×ª\Ş\ß\Û[İµÍ´’¢œ\æ6\é\\Ÿ‚4&Ó’7§;uõú]•üy\0!²˜w\éÖ²œSf°›Š\Ğ\Ã\Z§~\Ñ\à… “\Ôd\Zõ]\"Ö±°@ \ä\nñÈ¢Š\Út,	(\Û\'¥{G†\î]>% õö¬k+F\ÈÚ“nWgAkjŠ}\í1Lt\éU#\îšÌ½ñe¥¸	q!E\Î‘Àú\Ö\n\Û\Z»\Ü\ÂÖ‘¢\ÜûIöh^&·¹q§\Ü\r’cOj¹ªkzt…’`GaÁük„\Õn¬®¥ò¥!—‚\rREt=,\éenb»‡T;…n,pßªùĞ\Ş\â¹\ßkGV‰-g`gT\É>¸®»\É1Ly\\(,j\ÒdJ]9ñV•mÛ±PŒ\n\á`\Ò\í­e‘\íÔ€í¸\ë]§Œ®Ï™·?{8¸ß¶,d&\Öf?\İ\çp\ØS4\ĞQ&pr:~µf\Éaš0rw^1E\äb-\ßNõD?\ã‡\âi€şQúW7\Ğ\Ö×Š[wˆnœ>\à\ÄU\r>\ÎMGP·³„e\æ ö\É\ë[\Çcš[•ğûL{=MAÔ¬—/ò„ \éú\æ½\ËÂ¾+[¨£²¿`“\íôa\Ğgßƒ\\:|v¶Z[®\Ø\âUôÖ…º¾\ëƒò¯\Ş_a\Ñ@?Z–“•V¹†+…P\ÊI\ï^u\âO…–\Ú\Õ\Ì\Ó\Å3C#òJ\ã“ô§XüC²\Ğ\âKmjVH\Ë\â)1œz\í¬u›B¹´ºŠh\\d2°¬u‹6Vhò]+\à\İÅ‹n[÷ûÜŒj§Š<s§ c s\Óv1šö£p«\'QµWñc¬,0Aa‘U\Z» ¬x|°Ie#\ØPœg¨\êk®»\ÒEô>r¿®¥s5»•h\Ïºq¹\íøĞ‡$\äTaºsOW\0\à-\0J£\æ\Ïo\ëJ\Ó?_ZD 7cR\ç§4\0\Ãò`cÚ›\É\\Â¤#$óI´m #a¸\Ï\çS‡\ëU\ÈU\é\Ğ\Óø\ã\'½\0N­“Œw\ëO($)ù½ªpN3Š“@Á û\Û12‘´*\æ.\í\Õø\ä\Z\î\n†S\ë\éY÷\ÖQ\Í)4€\å#aüóV¿.‡5İ«\ÚK\á\íM\\\ç#¥.\ÉsS+{fª,œôö§¬‡q€¤\"Ø©\'œgµN²n\ëÇµSªU%ON\İ\è\Ë1 q\ÓÒ\Ø\'¶iŠÁ~&œ[œc4Às\0¤{\n@pô§pH\0~t\Ö`1\è{zP1\ÈpFz“\ØÓƒu$\ç·Zk8\É\rÒ—<qÜšJ	\äIS‹c\'\ÇzTjy÷ô§ò\äLv †8İ·¸£€zb˜I ¸õ\ïN\Æ=¸ cYòx\ÆsHK úSˆ<\Óp}©\0ôcúñD‘$Àn\æ£cŒä´«/ gùP/\ì¤2\å\Ç\É×Õ½Ö¶±*F«Ö©, ‘»%…L\ÉÀU\ÔÖ“\Ze§š)z}\ê´\é•â¨•xÔ˜‹³\á¨F§\åñ  QÖ•Š¹<–\È{y\ĞxgÄ—\Z\Ê)fhI\äg¥s}\àò\rD\'un\à}A@Lhšİ¾«l¯Œ\ãÖµñ_9xo\ÅW\Z4\ê\æL\ÇŞ½\Ë\Ãş!µ\ÖmH\äˆ¦#k\áGSK¶\\[GwE\Z\äõ\ìd/f2z\n\í‘i\'‰$]¬2)‚v>\ç:\Ğz\àzõ¥#¿ŠA\É\ïT#WAñ«\á½E/´«¹-\ç^¥O=t#\ë^ÿ\0\àÿ\0ŒšgŠcM3\\X¬uÂ«\Ë±ş\ì:ù¨ûVß„­–\ç\Äû·aNx\çµc\Û\ï^=R\æD…6gvõ\à\Óü\çó¬MCP5¬ƒ~9\ÇJ\\\Ô^(r–# •Á\ÄÍ¬J÷A£ı\ÛZÌ¤jO\"\Ë>ö>\\\08\è}8ü+Ğ¼ª‘FÏ–_”ık\ÌVOµÀgW]\ã†ÿ\0VÎ…,ˆX\Ä\çı\ê‰Ç™\ZS•™\ï‰bQ+“ñ‘*\Æn z]H\È5\ĞhÚ¤W\Öh|\ÄV„n±3\Çr€\Æı	W%¬Î«Gÿ\0\íúi\Ój^\í°K\Ø;üğ¿p¹<Ö¸Hõ‹\á,ğj0:N!\Z\"6ŸC^İªi\×\ZeÔ—šDÁ¾üG\î·\á\\n«%Æ¥0V¨1Ô¯z\Ú]Q2‹{1ÿ\05†´Ô¡ÀCƒÁô\é\ç^¹{¬\ÚgIr&\ØYp\Êz×‘YÛ¬ùˆ€˜¥yw#\Úù#Ò†\îô^¬\Ä\×õ“{¨³1\Äy\ÂçŠ¯op!\ÚDcsÖ¨jPŒ«dg§µg^\ézõ\Ô\ÑI	IcAò\âM˜úŠ\Ö)lg)=Î²-B \à\åTõ%õ\Îûvlü¸\äûW\'g£\êMv\ÒÜ¾\Ñ\Ô\"]\Ö\ï\Ö\ÓJ`\Ä\îo”QmI\æ\Ğ\à5ûfk·™0Tu>õ\Õü%\ĞşÙª\Üê²¦cµ]‘\äuv\ëù\ç\\Ö¡¼i¤\îa¹¸\Çjö‡úz\é>µ¶*’2_÷øp?\nÛ¡\Î\Íù -ˆ/\Í1\Ùô_\â?—ˆ©5ö[!\êŞ•f\ÙE\Åü²g\ä‡÷Kõ\ê\ÇóÀÿ\0€\×;\â\íal¬n®A\åd\ï\"O.ñUÿ\0ö—ˆŒ\nKA\Ûùuı•b^\ê·vó ¹–0:ùnF*\İö\Û\Íy/\ŞrqŸOÿ\0]`»™$g\'©\Í;m[ø³]´ÀƒT¹Qÿ\0]	şu¿¡ø§X\Õ\Ù\ïµ	®c HsŠ\á\0:ñZ^\Z¹xõdA“¼óG*\Ù\í\Út¸·Q\ÔdU›\İ\rF\×|`\ê=\ë#N¸C« ´ƒÚ¨“\Î\ï´\é-&1º÷ª!v°\ãzõ-cN‚şÔ² \ß\Ûk\Îo\ìä¶œ¡Rx E`\àF\rL•\ëøT;:`S\Ô\0F;ú\Ğ\àr\0¦²øòi¹\É\ãğ©N\Ş:\Ğ\"&\Î9\Æ=j,’y<cŠ{¯q\Å3Ò€Hô©V^{\æ£À\'\ÜR)ı\á\Ç\'\ëLHs1K\å†\'¯µD‘\È\äS÷94Bö\Æ9£;—­sV¯k!â»²†3YW\ÖK( ¯&“É¤„óµ:9# ŠeÕ£[9ùr\rF²`m=¸©ú?RG\éS«|¼+=]²öõb78µ\0X@A\ÇnÙ©³\Æüªº\ß\ãR¸\ë@© t\Å(ùO^O­5\\1\Ç4\á&=1Ú˜r9¤\ç¢şt€Gb{S=}(ÿ\0\êML gœœõ¨\Ç\İúrhP	\ä~´9ş%À\Ú:S2v‚:\æ€I\0zqš\\\Î2\é@\n	#9É¤fc©ô¥S…\Éÿ\0\Zh\0°\Ü<ŠC\nr­ø\âšcóO* O|RòG\ë@\0‚y\í\Ó=\êD›k\äg½43\Å3\ïc\éŠY\Üãš¶,\ì5X¼›¡\å\Ë\ĞJ½\ZÌ\ä\ã CVc“,6u(/Vğ\íö“\'˜À\Én~\ì‰ŞªÁ7 ^£¥Š‹ca\ÎFTıEf\İxgN\ÕA¸Ó¥X¥<\í\ÎTŸoğ¤R9Œ+¦+£ğ®¥u£¸–6`™\åI¬[­6\çI,/ \ÇFjiòEöU\r\Ôò;\ĞU®{¯‡|G«n¿6$]\"®zWiW’\ÚN²Á!ô¯Zğ×‰¢¿…b™‚\Ê0iÕ qI ùy§‚\È\éM—•\æò½#¯½¸lş|Ñ‚2_z\n’F*\Ä\'òô®¿Àol—\Ì\Ò0Y,8#Ò¸öN2+¥ğj¤š‰V\nOrzP3±\ÖUnHU\Øùl|¬•a\ÊU ˜•Vù°¸\Çù\æºù-\áS E.¿À\Ã\n~™\ëù\Ñq\á\ç[4\Ô-S\ÌY3˜Õ°P÷¸ÿ\0õz\Ô\â>\Ås§Ï¹ğ…8\àqš×¶-\å€@û\Ù\\v«w©¢\'—eÕ¿A\"\í\Ş?Æ³\â\ÚM…\n‘\È ûzŠ@z\'†uGET\'\æ\È z×¥C\å\êF&?#£¨¯Ó®ö2²Šô½Q`ù\Åw8?Q\\µ#gsªº-jz\rüp&\í]»n\î=\ëœk\Äm—€¼Fk·¸\Ô^H‚\ÉC‚<\Øşd?Py\Ï^\ß\Éşò\Ú)£\Ï/Áú\â¦\å«õ1Í›Å´¿ªy,‡\ØsD÷K3«)p£\nô¨…û@\å·es\Ï\Õ!˜Z®šfR\0\ÍU²\Û\Ë\çŒS[º‹[\ß|\æU<â¹¹4«0\Ì\Æi7%wğ+X\êµ2–Bõ\Õõ´q\á\\;û×Ÿ\ë·\Ú\Ë\n\ä„\ì+kXºƒN’ w‘÷Z\ä\á™¼\Î@\ç\äš\Ö+©„\å\ĞôOxb\×\Äyµ”#J€:+c\×S{\rï‡¦—\íVì¬ªJŒpÇ·\áš\â~xˆ\éú\ä(VË‚Q¿‹ñ\í_A\Åy¤ø’¶”+H-ğ\ë\ãò\íTÌ™À\é\×kg¡\å›÷„rOv<“ù×–xóX77é±·C¹ñ\êúÙ¯cñ\ï-\àg\Ó¦…yòÿ\0‰Æ¾{\Õlµ=riµ(]±Û‡\è}…\n\Z\Ü\âx­£\éOµb©}\ê{¹\Í\Í\Ë>r?¥Ve\äqT0s¶¶4Kg¤q»XÑ£K*¢ò\Ìp+¼x!³Ğ°~Q~¿şº\0‰¼JöÚ´q\Ä\ÄÄ«¹ñ^‘\áıV=B$*rH\Î3^#a\\LKºFù›Û½t\Ş\×\'¶ñ#\\\Ût?\ìŞ‹ˆö¸¾c\Ï\İ\î*¦¡¤\Ù\êh\Â<yƒ¦*­ö¹§.„/­®W\Ìp0¡Á$úc¨\"¸¸<O6Ÿ|³½]òÀZb&¿\Ó$²”\Æ\è{\à‘Š\Í1°l^‹46\Ş\"\Ó\ÒX°nA\Íqš†qcr\È\êx\é‘@Ê§v\å\ÅL[hŞ¢8\Ë~Y4\åÁ\í×šb¿\Õ	R¨\è*\È\\;P\È\Í\0W\ØBt\æ(\Ş;T˜l•\ë\íJ\"=E\0&2}I\Î8\ÔEp\Ü\n ú\Ğ\×9#õd\"JLŠ¨p\éŒ\Ó\ã^M\0R\Ô,]\Ão\È\ŞY\Ém!\à\í\ÏW£|¤qù¬GOYÑŒzRhg’j\Ê6FsQ\ŞZ5´‡‚\0¦+\în˜5 ^\Üvú\Z•pqŸÆª\Ç!\İ\Ô\Ô\Ê\Ø\Ãqš\0²·Š™H\àj¢7ğ£½LCŸÂ€,/-÷·µ;`c“ÿ\0×¦!gx§¸\ë\ÜP1Jü¾ÆŒ\íü©6\ä\Î\êE;vHô\Å\0 b\0\çÔªÛˆ\îqÀ\ÅDGR€1\è(P™R;ıimc\Øö¢\n|¹zÒ»lşt\0À[\Ó\éJI8;F{\äÒ’\0ÁSONGS@	÷‰\È\é\èqH\ã\Ç\çO\ïƒÇ¯z¯$™\áO \Ğ2HO$·õ§4¢7÷\Îj“b\î\é\Å1r\ì]†i\\iW+¨Y5«‘\ÊğO­qğêš¶‡¨\ÉKƒ‘=\Çq[–\ÙF¤õ«·pZ\\Dó\\F2ÀØ¥\Ìi]\Ø\Ì\Ò “Åº’mk+µ?\Õ\Ä_\å\Î~\è\ÇŸZô\Ï\Û©c#E2¨\Ä2õ#\Øô5\ä\Z†˜ú}Ç›i#\'\å*y\Ğø{\â-Í‚-­\Û,Á\Ç#\æOp{¥¾Á(¸»0²¼\Óe)q/\á[šl\ïYˆ#¥Y²\Õ\â\Ô\ì>Ó¦Èš½–>x|#\éŞ¦³‹M\ÔIm>m®8hŸ‚¾\Ø\í@&ºÏ‡¼H&b¸8oS]Qu‘S}+\É]f± m!»\Õ\Ğ\é~&û\0^\Ì‡c‰ñ\ÇÁX\îÄ·\Ú\0\Ìy1úW…\ê:m\î“xö·öòC2ğU\Çòõ¯Pğ\Æ\ËıÊ°×ƒ\ß\é\ã\n%ÿ\0–°Ÿğ!õ\çŞ½†ÿ\0AğŸ\Ä\İ][47\È>Ycá‘½ê¦¨\Èù\r\Õ\Óø.\î}FE•\Ü\\€«»qÊ¶¼mğ§Yğ¬,1½Õ—P\ê2T{üëƒ·\íe!\ÚÃšc=Š\í&4\Ïr¿)\Æ?ú\Ô\Ûx\é\×o ’&Ùÿ\0ŸËš\Ç\Ğ5uÔ­¤¤ÜŒoQÁüÿ\0\Z\ÛU{«™Æ·$µİW\ßÿ\0¯P2\î³a¥jö\Ñ\ŞÅ†vo”\ïŸ\ëÒ¸\íBaˆaPGA–\Ü+®û=\ãÈŠ#\â-µ\Ñ\İO¶A\ïô\ëXZ®œcºÀ1£yrsı)Ë´\Õ\Ú	Tm½O+©±ñœP¡\0prk’L36	,{ÿ\0UraÁ8\ç·<\Òq¹Q“[¸7Š[U…§UÀé•kQL	SØƒ^7=\ÑPw\Ä\Û{°\'Šd—’¿\É†6\Æq\È\Ïó¨öH\Ó\Û3\×\'\Õ\"Á\İpüvR*—ö´cş^®0À\Zòu|²\á¥~}ø5¡_«»²—É¦©\ØN©\èsjªOŸD¬›ıYaC‚}FqÒ¹)59\Ã\í2r}*¬÷3JÀdûœõ«P!\Ô&¼¼šú\ë\æf ö£\Èığ\\p9\çµA\ä*Iù³\Î*Ïš\0¸÷\ÍZ3¹\Õøj\É\îu+tPˆ/\ÈÀšöp°=ñ,’9ó\Ï*1…P\0ük†ğ”“Ù¤’0\"“\ÑF7~qø\×{«M\äZ¬+ü\\Ÿ¥&&6‰\Ö\Ú=\Äšó²œ$\ê9Qş\Ğ{r?Z\ŞÖ¼/ x\×N2ş\êE”efŒ\ë\ïù\Zù¿_¾:Ç‰İƒ(Ç \ïøœ\ÔzW\ÄmkÂš\Ém2\èˆÄ8\Ìoõ\ÔsL\ro\Zü \Õ<?3\ÍaOl~\ê\ç\'ş{ı?Zó)‘£vWVGS‚¬0A÷¯­|ñK@ñ¬+grc´¿a­g9Y?\İ\'ƒô\ëYş7ø;¦x‚7¸²O&\è—iù¿3\Ô{ÎŸ9x^\Ã\í7¦vH‡Z»â‹“˜¬#?x\îj\êG†n¼)–÷HAŒ–w+ŒıGj\á\ßP\Ô\å¸=d}¨aÿ\0\ê R-tù%4Ÿ»A\ß\ëKL‡\ì\Z+\İ‰n>Tõ\Û\Ü\Öm\ê=\İ\â\Ú\Û)q\Ø÷=\êxo%¹µ	ı@Ûj9$“\Ş M6\ê\î`‚E$\ìıiÀ”BNÈ¦7\í#;ºƒ@şñÎŸs;f@‘Gjö-¬¼O¤¥Å»ƒ!\\©^‡\Ø\×Í©ş‡uƒ÷[\×Ò»x¾o_!´¶~t\ÏOqM1º›-\ÃE$x+\ê1T\0~µ\êwIa\â\í=n-]Y¶ü­O±¯;\Õ4Ù¬.9T©¸ª˜\ÎA#ó§j%nyıiû8ü(›Ç¥?\à‘zz|\Ë\Í#¡<Ÿ¥\0F\ë\ÎF9¦n8*b…HüEGÑh\0\Ècš”0\Ú*r\Øô5.08\Ï1@w<ûû\ÕÈ£\ávœéŠ¦‚zô¡«‚;\æ€(\ë\ZH\nHS\ßÒ¸Ë»f´”J\çŠõ4d½Œ«›¿½szÆ–ƒ#§µKC9e\ÇŞ§W;²{\Ô7Voo)%~^Ô‰)$ş”€º²v\â§S€9E$ñ\ÕdI\Î	 {ˆ\n\Z•XpF}1U²	\ïÖ¥R0ph.GE?=A\'?J„\İ\ÎsS+tİš@”\äõ\ìi0zf‡|!$GaL©# “Ÿjp\äx\ÅDƒ\å$sN$ŸÃ¥\0I’O\0û\çµ!\ÏH\ÇJföŸÂš\ç\å\Î3ô\í@lHéµ]\Ø\í9?‰¥ßA\Ïrj¹s+\ç1Hhz/œ\Ütú\ÕÄo\Ê3ô¢\Ğ}E]Š0Ë¸}ÿ\0Â¥³HÄ\Ç=ÿ\0kZ¦\èö¸Oj¯gjg¹U\àdŸ¥t–º,²Ø¹-\Ğg)X\èŒ§\Ğ\à¼Sˆø9\"²gğ\Ì,û\Z G®+\Ò\á°[Kq)İ˜\æ¨MfŒ\ãœf¥L§†°ğÌºU\Ò^\é÷Oo(\ä8ü=\ëj\ç[²–ò8õ¸\äÓ¯\ÈıÖ§j¿)ÿ\0}GoÎº84\ß\İ\ïp1\ï\é\\\ïˆã´º¹Š–<\î9\ã5JzŠ4yİ‘»o­\ßi1Du¨’÷LõZ•¯\Ïÿ\0{t\×+ñ\Z\à\Éug6™yº\ÒH²»N@lóúb›§]^øvV—L”›wÿ\0[lÿ\04rpx«Qxs\Ä(\Z\×:Mñ9’\Ùù„ú•=¾•¤d®EJ¦x\î2s\ë\Íløw\Å\ZÇ…u½\Òo$Áù“9I£/B+)h\ê9\ã¿¡\Ê}Kà¯‹\Úa]3XX¬5\'ù|¹\î¦?\ì1\è}\ëY7ø!cª\Ìo´f²±ÌŠ\Ê\ÃÔğ¯›•ˆÁ\é\é^\ßğo\â‰.µ8ü=rEı‰F\"I\É/\0×¸ö?-hÿ\0	•ª¬i4\ÒD@I ¸\ëü‡­u^!ğBè‘¦£¤B\ŞY\\\Ü\'$¯¿_Â»M6[©\æ¸ó¶PQÀY6\0\Ï‚9ö­öP\êU€e#ôX.xEå¶£ÿ\0\è\Ì’\Z<`t\ãÉ¬ûæ³‚\Ë0ÀÁö\áC.y\'\×Óš\ê¼V\Úm¶¹qmj¢\0,TğO¿J\ä.®7+Gx\èNrv¶x¦ £“°³–öö\å\\´ş\ìŸŸ¥Dö[wTPeŒò¸\åH<şk¨‚(\ŞfÂ¹“&:ş´\ãojo‘\"eùY\Ç^ı(Œ[(e\ÌG\îŸJC§5¢±tI\"^\ä\0T{Š\êg\ÒNŸª9Ú²\Ú\\\r\Ä(\åO¥>\î\Õ^U<¯Fşòúzp“À’+22³z¯9O!H\ÜHô\"µ.,%I™£Ÿ˜Ö³\æ…Ğ«±$t\"˜…\Ú\Ò&C‡\\c\Å27\ÚH1¢¶;\Õ\Ë8\ZH\ædQ½@\'\ÓosHmE\Í\Ó\ì`søS¼h\çc ÷š¹m§Kyz–¶±»·_ÿ\0U2\Ú\Êy.’r\ÆF} ñ\Í{7…ü7‡ô¿¶±_°Àc\ÈxP=²G\ë@¿\r\é\Ëej‘…\\B‚„¾ï¬ø¬\Z\ë_c\Ón§W\Û1E\Î9=\Ç\ê\n\ë%+a¥¡G¹\îkÆ¼u¨\íZ2&ù\"9|z¿§ó¤„s*ÿ\0cÒ¥¸só\É\Èş•Ê±.Ä·Rk{Ä— 4V‘\à`=kTP\ä–HX2’\äq^\Ëğ\Ï\âş³i2éš¨:…’Œ‰¿yö=Ç±ü\ë\Å\Ü\æ»_Y[/´°!¥ù¿\Ôúˆ7‡üo¦–£¹\\`\ã‰#\Ïbõâ¼—\Å\ßf\Òü\Û\İ\"«UPO¨ş\åô¯0ƒ\Å\Z‡‰›P\Òn\ä¶h\Õd?{\Øú­{¿„~2i÷\ÓÅ¦k\Åmoˆ\ÏAû·>‡û§ôúR\áºnq¤-\İ\Õô\rÂˆ¬:±\ê}şµ\Ï;ˆ/÷„s\Í}k\âO\0i&µ/\Z¤n\ã!ü\ï\ÇO¨ü«À¼eğ\ÛU\ĞVB!’US¹N2Hö\Ç_Â¹ùœd€:\ÔLs!\ÍEm6m°\ß84ı\Ø\ã¥1\İ\Â$Œ•\á‡\"™iq½6¼¿Ê­‘’~•p†\Ú\èH¿tœÿ\0õ¨ºğ&ğ\Å\Ğ’öl~u<\í÷\ìS\ÚYø»HK»FGfM\ÈÃ½|\Íu?R%úŸj\íü	ã»Ş¥”¹–\ÂF“<\Ç\î?Â˜ûı5\ìg1È„=ª8\Ç>¾\Õ\ì\Z¶‡i\âM8^Z•2•X7?Æ¼¿QÓ¥±£‘H \ã\éT\"n\àT¤dc5\\ı\ïL{T»³_Z\0x\ÇCQI¡…IŒ¨£a\'¯\0psŠU\ÏLñR°Àı*s\îz\Ğ¡~iù\â¢)Á‰ Pˆ\Æ#¸\ïZVö\Ñ^¦8\è{\Öz—±\Ï42´R¼@Z\îƒ\ä’T‡¡ô®\"\ê\Ù\íe \çoµzôÌ·–\Ä8\ãš\ä5m ƒ\Êñ\ØÔ´\Z’\ã?YY2\n¯shö³/y¢921\Û\ëHeôñŠ[$còôªQ·\åS¬œğON¸¤2\ÆKgı*PÀñœ\n:õ\ëN\Ï\Í\×J`N\0,FOøSò£Ú¢R\0\Ó\Æ§øP\0¹ƒŞ—I8¥°W\ëšC2s\ë@\r“\ÓŞ¢2\'¯N”\ç}Çõ\\’\Íò\ä“Hhz‡–@Š3šÔ‹N	_;ñVt?jùòOAZ‰\0“’£>˜¤\ÙIU\Î3Ò¤R¬½kv[e\n@\Ï\Ş[\Íş\í2OAKsE¡½f™)$?6\Ò8\Ï_jõ\Ü\è\Æ\Ø4÷EtToC´¯°\Ï_¨¯\Óut\Ó.U$9(~x\Ç;O­t‡TÓµ_4¦Of\à\×<\Õ\ÏN…8T†ögk\â-kH¶%¾\×#‰ƒÒ¸¹<U\Z9òmY\É\ç÷‡òª“iJK[\Ê>‡š£&•p¸À\r¤\ZJ(\×\ê¶Üµu\â}Fôym\"Ä§‚±.Ú $\ËOz­fæ‡¾)1\"ş5v)EGbÊH\áER¾·\\ù£Œñš°„úÃiò|\ëŠb•ç”’JŸÖŒFi3\ëœw£øH\Î}+¤ğO×§8®\ÇÀ~9¸ğ>£qq„7q\Ï\ÇGm¬;Œ6?1ü«\ã©\Õ\Í.\Í\ïõ-¡\\¼®G\Ô\Ğ\×_\rµ»\ßøa5}B\Õ-\æ‘\İT&pW<uü\á]„Å„NPeñòŒõ5C@Ò£\Ñt-:1…‚ §\ë\Ôş¤\Ö?<O/‡m\íM´k,òH1ta\éCĞ“Ç¼cm«iš…\åÎ¥D®wn\ê0:s^Si¯\Ëkq<Í½\ä™n_şµ}i¦ø‡\Ã\Ş6·{	h †µ”\Äw+ı\áşH¯.ñ\×ÀĞ²>¡ ghùšß±úzR*\ç¥\ë\Òê³¥®DEù\ÏaıqZ»\Û\İ0¿<.\îsX:—>÷wW˜¥(¸#üÿ\0Z\Ê\Õo\ÌH\î‡\Î\ÏzV\év·,ó¤· ©@OcL¸µ‹\ç’2Yr§¥y¶\â\Û\Û8\ÌrN*º–8\äVŒ¾:ya\n*\Å\ØI\'¯\éš5¨m)QdAb0€w¹mF\×l\ëºAê¢«K\ã[¨.Í¹Ä›‚v\â¨\\xª\êh*\î£8\ìs\×üú\Ñf\"\Ì\r=­\ÓHóÁ\ë\ÇùjøW\Ãö\Úö¿•Ş¯m¤»7l‚\äÿ\0\íŸbk’mnõ„a®”™I\ëÖ›¦Z\\kZÍ¥”Ešy\åızş4\ì\Óg\á–•hG™\Ş\áG\Ìf9.}j\Åó¯­uKk¸\Zm\Ã\ï7Aùdşu\Õ\é\Z\Äú¬V\ÌL\Öp\ÆyU¨?…tRC¤øª\ÄP\ç\0óò\Éùü©n#\Î|K®Ám\È\Íò@›±\êk\Æm®…\Ì÷zœ\í–bNS^­ñ\áÖ´4ùM“\í\çqõ#\Ğÿ\0ŸÆ¼OSYôû°ÊŒ’t`\Ü\Zh›‹ƒuu$®rY³Q\É\Å3\Îi¤œ`\ÓkN´kûø­\ÆNö\ç\éŞ»ınt\Ò42†a±Ò¹\ß\â¼i¥_¼6©5\'Š/Vÿ\0X[tl\Åo\Ëc¹ E:%ZY1ˆÇ˜\Ùşñ\è*>õ\íµX\ï¤@\ãq ^\ßÒ¦¼f\Ò;pNù÷ş‚´µ›D±\ĞmlB?tA=¿*@u>ø•­ør\è*Kö«\'b^\ŞS•úƒ\ÕM{¯‡ü_\áÿ\0Y}<ò2ö“p\ã\ÜzıG\é_)X¿™lp\Ø\Új\Ì7SYÊ³B\í¡²¬­‚(\Üüiğn\Öı¥¾\ÒAI\È\ÉUŸ¨\èß¡ú×ˆ\êú£¢\Ì\Ğ\Ş[º€p}\Ò~¾¾Æ½_Á\ß\Z\ç¶T´ñ*™\á´:ÿ\0¼?‹ùık\Ô.ô\ßø\ßI1¼7P\Ê0³ÅƒŸb;ı?J\0ùd¶5\rÒ¬–ï¿Œr\rz·Œ~_\é%Öš<\ë~»3\Ç\à{}\ç^M¨E2OöI#h\ä\æV\"€)À¦4iO§´tˆÁ2İ°ÿ\0WĞŸ^\ÕZX\Ë·AÉ¤Œ\Ëcrö\ÓeFp\Ã4Àôß‡ş?“\Ã\×\ëm|\Ìö·<d\ÆOq\í^Í¯øji«¨Y2<\Å7QÄƒ¶=\ëåœr:\nõ…\ß[C’=W‘›Osˆ\ä<˜Iÿ\0\Ù•)_\éò\ØÜ´s)tª\áöô¯rñ_… \×m~\Ûd\Ü»\å<H=G¿ó¯\Ôl$²’D*\ÊOQT\Ä\ÑT\Æ1R†`\ã_in<g¿?…\0LWŒŠŒ\çñ\ïR\Æ7\ÇSAP¼œ~€  ã‘šxÀ\í\Í9‰ÛÆñ RG9â¥Œ+6{\Ô‹œt§€Tp*\0·¦\'\ë\Å\\òc¾‰†>¢²†\âyü\ê\Ô<.\nE\0`\ëz#FH+”=+¹¶ki\çm{„¿€‚qÈ®?Z\Ñ\Z<¹S\Ğ\â“\ÆG Ç¡«Q¿\0ŒsÚ«\ÜÚ½¼§=i±8\à\ç‘RŠ°=9÷©ıjš¸ON•6ñŒ\çÔ†Y\ß\ÆT\n’7\äŒUu?(\ç?Zx\Èb˜†v\à“Zc¾‘dùpj9_\é\îh\Ãi\ç’zf´´­=¥“\Íq\ÛÚ«\é\ÖR]\\©Á\Ø+²‚\Ùb„F«Ó©\ÅK\Z …@Á\ã¥[&8À\0\Õ{‹˜­—5E\Zk\É\nŒ¤c«\Ò4L¿¿\Ír±ü\Ç\×<U{\×!D]ó0Àö©dùV\ã’yc]_‡ü$|x„\È\Ã(¬:SRÚŠ».)\É\Ù?s\á­F}P\Í<«s\ç8Q\ïŞ¥œ\ë:laue»µ\ÇÀ~#ú×®kš\"¼g\ä9÷¬[/O–\Ş1=\×Ö§\Ú\'º7öS°g%á‹­9İ¥{ı‡\'÷lNk®k\Í,\ÆGö‚!#¨<ƒô5›­øœ\Ü~\Å8\çÏ¶\\\ÆOûI\Ô~\É<\Z®8mB\Ø]Z/Kˆ\å#\ê?®)¸_XšC\ã\î\ÏCvş\âşÍ®¡Â™B\ã\ÅY\Ò.¤i7j·‘\Ñ\"$Ÿ\ÇU\İ\çI\Ö6­´\êdÿ\0O\Ãõ\ë£\È? \ÇÒ³zhus¹-$sºv­§\ß\êmi\äº.H‰\ÜŸ&³\æX\Ş\Ú\ÅÛª\Ì%RB3\ÛÖ´¦ğ\äqûv•ù²;V4–¾-\Ón,™‡\Ú\à“…\'“ƒŒÂª/S¼\ê\Ó\ÕH\ä<Sğ\×Vğ\Í\Û,\ã}¾~YBõô\Ír\ï£Î½”\ã\ßõ…ş\"xk\Ç\Ö\ÃL¾h!¿qƒo!\âCşÁ=~k™ñ‡\ÂY-ZK\Ío‹©„öúVúyóû\éw+É?C^•ğO\Â\ï¨x\Ú+Ù¢>M’™[8\Æ\îß®+kv¶¹hgF@pQ†¯øG£gxY¯1%\ã\äqü# ~¹ª@\ÏC¯ñ\î±ö\ß\\:¶b²M«şù\à~\\ŸÂ½w\\\ÔLÑ®nœ\ãb}k\çmb÷ı\È\ß~RfÇ…ı?L˜‘\çšÆ§:\ëB{y&·û­‚¨5\ë¾ø\í2ôÿ\0•>\ê\ßF¿0ÿ\0}G_¨\ç\ë^V\ê,\ê	\Ï5\Z$I `€\ÏJeT\ë¾Ğ¼i¦‹ˆ2dI\án\å_;øÿ\0\áÖ·\á§ai\ì—$Hƒ§Ö¬\è;Õ¼/r.tùö\Äyš\æ7Ç¨ş£šö¿üLğç­Å„û-¯\Øa¬\ç?|ú£wúu [#ô“\êk\èÿ\0ü¶¾óo´ !Ÿ–1º\ßQş\àZ®‹¨h—mk¨[<2)\ï\ĞûƒÒÀ\ÍÒŒQGj`/lW¨üĞ¾Ñ©]k2§\Én¾T$ÿ\0}ºŸÀ\èU\å\ê0P2Oõ¯¦ü¡®\á‹;˜›nù½İ¹?—OÂ“5.cˆ\íû\Ì\Ù\'ı…Á?®\âj-V\áô\ã–Ò´R İ½N~\ÑD—\\Ÿº>DôÚ½6\Ï\áŠ\à¼}­ı›Jœ†Ä—\ËO\\w?•!g„>0Xjó\Ég« ¶eb©r\î\Üv\Ü?„şœö­oü4\Ğüak\çF‰ì»£–3Á÷ú«\æ\ë™?³4]Ç‰e÷\ç\'ÿ\0­Z^ø¥®x>U‰eûVœ[æ´”ü£\İOU?\ç\ì2¯‹¾\ë>ü\èZ[pIªô\ãú+Š\'¸\"Œeœ…¾\Åğ\çŒ|5ñN0\Æ\Èg\Ûû\ËI¸‘=Hõ\â¸|·¶Ô¿µôh˜\í\Éh—ù\ã\×\éùR¸eam§xydR\á@3ı\ê\ãô\è\ÚiÌ’\ïbOQ]7šq4\Zq\ã\É\Ü\Ùƒ.m\ì\Şn²ŠtKqªk­s0Í´’OL/Aøš“Pº’şòYOWc\è*\rQ\ÚUÍ¢Ç‰¥pYÿ\0\Ù¿:T\ä™;t\Äf\Û·»’ßŒgƒšº\Ò$ŸÂ¨ß†IRp;\ã58;€aFE\0L9ú\Z½\áokÕ‹i÷o\Z·\ŞC\Ê8÷³A\í\Ğöª—\Èp%W­ >¤ğÅÄˆ–šˆ\Âù\Æİ’7\î\äöôú\Z±\âÿ\0…úO‰#2\Ç\n\Ãt\ÊW\Èöút¯”\ÚğÈ±¢¸ı\ïjô¿ü^\Õü6ği÷aµ\0ŠFù\ã\ì·ô<Qa™\ZÇ€5?\njSMy	–(Ád`9ö\Èş£Š\ã5ó\ÕÁ\çŞ¾\ÆÓµø\ÎÁ’	#Ÿhù\á~$ˆı;}G\æş5ø1\Şeæ‰…~IŒ\ÔQùQ\êZM¾-§\ï\n°©sÖ£\Ôô›ÿ\0\ê&\È\Z3Ÿ”ô=\é\êC€Ã¡¦#\Ø~|Qş\Ë1\èº\Ü\ä\Ùˆfc“	ô?\ìÿ\0*ô\ßøRr\Ô\Ş\Ù*™\È\Üvtz\ç_8ø3Ã²x£\ÄÖºr!-¾g\Ã\äÿ\0‡ÔŠú³MD\Ée`C\Z| tE@?_X\Éi3#‚0j™jö\ZøQoÕ¯-cL|\áGS\ëõ¯º´–\ŞVVB¸4\Ó\n1^M=Ÿ9\ç=ªúTªõ4ÀpS·\0qH2sµ*\Èn¦šq\ÔuúPDmb\Üs\ÍIœjx>”ƒƒÏ¶(D d\ã&Ÿ¸o\ïù\Ô œ`œ{Sg± i+#¤ñZJ‘_Ú²63˜V:\äJ³o\'’\ÊCÂ€9­oE0³|¤¡\èq\\m\Ô\rm/Jö¹\"ƒQ¶(W,G\"¸{B{fù“*\ßu€©hg²\î\Èô©‘±æ¡¹µ{yI?w5ru\äó\ëR‚¾\ßoÆ¦\r‘€j’?jd;{\Ğ‚I\ç$t\ëR\ÚÀ×“„^TñÒ¢T2ºÄOz\ët\Ë8´\ëP\îş\Ô\Æ^´´\Î\Ô\0\ìsUnõ51\Ç\Ëööª÷W\Ï1*œ\n¬D	#,O^´Š$Š/2_:\é\Ë7a•k\Í2‹À<µQw7|\ä\ä\nõo‡MgT‹<\æ\\\ãÆ¤d¾\rø~D)©j‹ó46\î?\"\ß\á]Œöm;ÓQÒ¶Ù«\'T\Ôc·…‰p¨:ŸóúTJ\ÅÂ£‰‡uc¹\È KTO”`U„ó]\Î\Ó9dNˆ€ô!|šdû›}gÈ¸ ‰Ô”\ÖUß…l®ƒÈ™·v´c†ÿ\0yOT\Ş{E u\í\ëZv·j\Ê]Nc<2ªiªmlÉ•u%fñÃµ†\à\Ï~Gqqd\Üú˜ú¯\á\ÅV²ño‰ü/\íF§b¼,\ä\Ûÿ\0\ëù×¯\ß\Ä#¹\Êr\È\Åq^&\Òo\àyu=5I!IxÓ©ü;Ö­)+H\ÅI\Å\Ş%{\Ù\ëˆeHx1·°5ÿ\0¼—R\ÒÉ¸\'\çUm \ç¸5\ÌÇ¬hš„ìº™Ó®Á–\ß\åû¯O\å]5„šÅšl³o\í\È\áW\ïÀóùRP\åøE)¹ny\Z;D\áÑˆe9N5\ì~\0ø\åy¥yZw‰K\ŞYp«s\ÖX‡¿÷\Ç\ëõ¯\Z\'qJ\0À\Æs\ëZ’}m­x?\Âÿ\04¨\ï\ìd‚Bü\Çq	ı¡ö5\Û\éöQiºu½”#ÁEüZğ\Ùò\Æş]bö\ìO*Y\Å\Ïc²F9#¦G_Â¾ˆ$\0I\è(\ØGüO\Õ6\ÛZ\éQ¸\r;eı€¯üg«?˜#…\Ê\îlü½”pùô¯Eñ\æ³%ß‰\îÜ†	\Z\ìBx\ëÔÂ¼SX»7š”²n;sµ~‚¡j\ÆDu®a?P(\Z…À<°>¼UQ\íF09\ÍX$\Ô&’‹§©ªñJğÈ²Fì®§r°8 ú\Ô~˜ u iğ\Ç[\í,\Ça\â]÷¶ƒ\n·C™cÿ\0\Şş|w¯a\Ô4OüF\Ğ\Å\Ìf¨eY£\ê¸\ê\ë_“\Îükw\Ã~/\Ö|\'¨­&ñ\á?ò\Ò3\ÊH=z\Z\0\ë|sğ‡VğÌqe\İY\äTe€ş¿Î¼Ì©F Œ\Æ\r}]à¯‹šŒ¡M?S\Øj2y27\î\å?\ì1\ï\ìyª>;ø1§\ë\Ë%î—‹{\Ó\Ï\Ê>ÿ\0\×\×ù\Ğ…ü;Ñ†±\â\Ûa\"ƒ·\ï\ä\ÏN:\Ï­}ò2@\Å\ï[	ûÇ¿\á\Éü+\Í|\áÛ\Ëqúl»‘şo÷GL~¿z¼\Â\çQUS•·\\Ÿ÷\Ûü÷Ñ¥q2\åÛ¥˜°§]‹Â¼S\Åw\Û\'[d\æn¦G\'õ\ãğ¯Hñ~º¶VWŒ~\év ÿ\0k ı•y›˜\í./_-4™nh…\âkÁ5ğ	\ÙÁú\Ö(\Ç\åSO+\ÈÜ–bNj&B9*i”Xµ¾¹²¸kY\ä†d9Y°\Ê}Aô—‚¾)ÎšMºø‘\Ä\Êo¼Aó?ˆ¿Q_4Ú {…\Ü>PrEl]\ê3A`Ö±\Èv\Ë\ÔP#\ê\íg\ÃñÎ–.!heY—r\\Br­õ\Ç\È×‡ø£\áf¥¤jğ—ù\ì7\Ş\İQ\é\ëü\ëšğ—u1›Oº\"#€\Ğ?1¿®Gõô_„ü£ø\ÇL†;È’\Ò\æ|¯Ù§ ¬„u\Ø{óø\Ò\æ\rU\ã:ü­a\"s…P1€8§¹ \ãõ¯|ñ\ÇÁ\Ë-`=æ—˜nG!W¿øÿ\0:ñ=cB\Ôt9š\ÈYN\İ\Ø\ê{ı) 1.PO(Àâ ²“|EI\åN*\É<ô\"©/\î¯Jöz\\\ÎOl\ZlÁLM¼‚¸©F2Gz§zÅŠÂ§–<\ĞX\ËÌ§\îŠ\ÔÑ‘ZYodÁHF@÷\ì*¤©ò\ÇoS\Æ(ò\å\Ó\ï\Òc™\0ñ\íü\èr\ÇX½\Ó\ïVö\Î\âH.\îY°E{Oƒ¾5C8\Ë\Äj#º/#÷\ÔtúÊ¼E(r§8 ®5¿h^0\Òó\"C<s.\åš<2·¿~½}\ë\Â<[ğ“Sğ\ì5€{‹2x\\ä¡\ïô<ıkÂ¾>\Öü)t¦\Êr\Ğ1Ì–ò|Ñ¿\á\ØûŠúÁ¾?\Ò<mnğ*¯š\ÚA¹qÓƒĞŒúóHg\'ğ‹\Ã\Ñ\è¾›R¹P·—§-»ªF3´{g“ùW©i\ĞyPuÄ²|\ÌP;\Ãù\æ³ ğÍ½ª.m\'’+f9–×ª1\ìG§?t4\0\ÖP\ÊU†A\í^}\ã/	\Ãp^{UQ&7\×4©/,µ\'Ú¹¯/\Ûqr\ÅM\Ã|Ÿ\ì\n\0ñ{»W¶™‘”‚:Š«¸\çi¯[ñ_†a½V»·P²‘’\0\ë\ï^[wjğLÁ”©\Ïz¤\î\"5n€úÔŠ„óøT	çšŸ\Ì\Ú\0_Ò¯È¦uúQ\Ã\éq\ïLl$“µ:®Á\ÎsM\ãwßŠ3‘Á8ô4\0\í\ÙÁ\Çj`Û—Î¡SƒŒ\â§ğ\àhÅ¼\ï§Õ«%¼Z½±Rª8\äV\Zºóœı*Íµ\ËC(h\Î;\Ğ\'¯h-k!G\\ü­\ë\\mÍ«@Ç–½“P1\êv\ì1ÛŸc\\&©¦„‘£ns\È5-\äa“‚\05~@ùNj7\Ó^)ø\åO<V•…ƒ\É2“Ò¤\r=*\Ş8\ÔO!Á«ò;\Êùcòö”‚±Ú¡y1\Âş4\r\Ò\à\àzqKL\î‚X”\ÛxšY¶(\ÜI\ëŠõ\ï\0øg•©j1ŒcŒ§\Ô\Òeğ\'\ÃĞ¢=OW?\Å-\ß\Üÿ\0…z!\0U\0\00\0\íNb\0À\àU+«……<ıiı\âAÀ`I\è+Œ¸µ€\í‘œª¤úŸó\Å>şõµ)\Ìh\Ñ\ÔòGñŸğôü\é@\\\nbŒ\08¦± °)\Ø\àR\Æj(\î\Ú\Ù÷¯#¡SĞŠGnyª²‚sø\ĞúI\ÄBHØ”÷\ê§\ĞÒ…>™¬\r6\â\â;\Õ\r\Ê\Ç‡¡¡©ø·Iğùq$©5Ú‚D[¾Xÿ\0\Ş#¿·_¥0<oğ¿I\Õtù5V¸L¼&VÀ`\Ã\×\ÜW˜­Æ­\Ù`*|›8ü±$$şó¶I\à\Öö«\âMC\ÄW~¥3`1\ÙU~ƒúõª¶÷Š«*ùxû Qr\Ô,\ê:ô\ÍIc\"\Î{\Zˆø\Òx+D“\Ä+°\Ó\ãJA\Ô\æµFG\Òÿ\0ôĞ¼lÌ›gº&W8\ç ó\ë]V»­\Ûh\Z[_]1«\0Bõ9=ªü0¤\Çc	\Z…Q\è\0À¯1øŸ©‹\ëM)[÷q\æi°{jdÄ—R\Ğü?\ã½4\ÍÙ‡ú\Äá‘Ñ‡Pk\ç|\'\Õü-3\Ü[\Æ÷vy\Î\å\å”{ú\Ô\Ş4Õ¼=\â(î´‹¶‚e;¥•|ŸºÃ¡\ã^\Ïà¯‹º\'a]3XD±\Ôm\Ø\ç÷rŸö[±ö?­ò\Ó+.wq\íHAô§şZ\ê\Ë%öˆnH,@?\ÔzûŠùûX\Ğu\rõ­µw…×€OF÷À\ËúR½)\ë\Å&qÒ˜=\è\ÇnôqœbŒıy V\Ç9\äzW°|4ø¿­i×–ú6¢­©X±Ú¥\Û÷±f\î=\ç^;Ú»ß‡z^dŸR‘z.<ú÷4˜NIo¢x\Æ\Ã\ÍFYş5\á\ã>\â¸\ë\ÍPğ¯\Ú%D{«w%„ª2A>µ\ÊA}w§jI§\Îğ\Î\æu?\Ã\èGp¥z.ñ\Âğ‹-`\Çm1|\Öÿ\0Tÿ\0\\ı\ßÇŠB<\Æ\Ú\Ã^\ÜC§\Æ\Çh;¤úš\ç\ï5¿°yPÂŠ\Ê¥}\ã…šWˆ\Ğ\Ş\Ø‚ğ®U—£W\Î^,ğ~±\á»÷[ûV“Ä |§ü) 2n¯\à¸>bDcr~e \Ôbœ}ª¶\ÜP‚	\é(\Ğl7¡\ïU\ås$¹ü>S¿\çŞµ(ô\àF±(\éŒ\äw5®u;‹‘i\Â,…MƒzıkY7\Çc \Å\\²Ş«ö¦#\Ø|ñ{Q\Ñ\ÄVZ\Ö\ë\ë1\æû\Ø\Ç\×ø¾‡ó¯Z1øk\âö‹yaº‰—\Ó\ï¡=˜CøWÊ¹À84ı\ÄZ—†ußµi\×RA&{zĞ­+ô_ü$¿\ÒY®´\Õó­³œz‡\Ğşu\äú•¬°7\ï’H\Î‚+\éO|_\Ó5Ä\Ç\\\Ù]°\n$oõRŸ|ı\ßÇz¿\ã…úGŠ-šHa¸e\Èe\è~‡ü¥\0|¿‹\ä‰{c&«[2g¸“8\í]\'Š<­xY\Şˆ\à\İşµW€=\Ço\å\\ô£b$	\Ôñ@´H„—\ßL¹‘\í\ØU-H<\În¹.>õ±t‹gg\r‚Œ0\å÷c\Ûğ¬ò7§¡\ë@ˆ`—ÌŒ7~‡8\äç§½g[“\ËBO\ÊMh\ç\å¦\0wdM}ğ\ÛÂ«\á\ï\î£\Û}¨:\\Q?#Ÿ©¯ øm\áøI|U2\Ö6¸š\ã‹øŸ\Ó5ôÍ²ıª\äd~\î,\èOaı*LZd[iñE,­$ |\Ì\Ç<ú~?\n¹EV¼º\Ê\ÒK‰OÊƒ8õ=…!˜$¿\0‹5ló\Ì}»\ë\\}ŠCPk–\å	ŸJ]ZòK‰LE³5\Ãn|vŸÒ¶4{1(\Ç\0sSp6!ˆ›qü«’ñW„\ŞH\Í\ÄJF?Z\î¬b2Ë“÷V¯]\Û-\Ì2	\Ø,|\×sjğJ\ÊÀ‚\rD­‚sŠô¯øH y#^y5\ç7<2•a\İ+D\î!b!˜J”œf«)=GôcšX\ÇRLsLRCjB\à°\Ç\ë@	·\'½9‰Àö :Ò•\É\Ç\×Ò˜\n­\ÎA<Tˆıxò8ª\ãÉ§ùœŒğ(e•£–³µ[o0;šº\Ò(\çÖ˜\ã\ÎR§¯¥\0rûD‡sVl›Ê”©\Æ2ú#ms\è	\Í#H \\\Ô½<Ûó]#g!W\'”Øœ\Î\áTdô\â½GÀ~7.—×¨DKÊ©jF‹|]KPO—ª!}\Íz¾(U\0\Ğ\nDD†5HÀUQ€*)e©bE\"†\Ï8¯j\ãumI¯&kh[\ä\Î$pzÿ\0²ó=ş•g[\Õ]\å6°ıöş\èôúŸÓ§­e\ÇB@‚4¸\Æ\0§“Gjk5q\ÅB\çƒN\'4\Ã@I¹\ÅU*ó8\âN\0p\Æ\Ò6\åZövVºeŒÚ…ü‰)i$s€\0\í@\Òôe‚\Õ\Ë}\çR¿…xŞµg.•­MnIR¯¹?CŸÊ½\ÇE\Ömu\İ8^Y6\èIÀ\ÈÁü«‚ø¤\Ñj*¼cqş}¿Z\n‹³<\Êñ¶İ™‡ñıá¸±\ëÕ®y\ÅJ€2–8ñUo\ÜD#Iv¢’\Ø©©m˜ya0\ÑÒ•N{\Å\r\Õü\'|ğ\ê\Ì#\å˜•«\Õ?g¿	//u\É\â\åDO÷˜súW{\áÿ\0øWâ¦’m&H\ã½)û\ËIˆŞ¾\êˆWU\áo\rYøSF\Zuıß˜\ÎO©\'ü1Z§m\ÎvlM*\Ã\Ê\ç\nŠXşóÇ‰u¶\\\ß\êü\Ì\åŸ\à^O\ëŠõÿ\0ˆ\Z¿ö_†fTlK?È¸<\×\Î^0¾\Ö_eŒöòºş-ú\æ¡\êÁ5õÁ»¾–\àÿ\0d{\n€9SŸÇƒA\èsšC‘\Ç`zÇ€>5jò\ì5ú†š3~ö/¡ş!\ì:ö\ë?Â¿t/´@\Ğ\İF\ã\ï¯\èÃ¨5ñ\È\'ğ± x£Vğ¾¤—úM\ÛÁ*œ9WŒQE€\í<sğƒTğÛ½Å„ougœ£,õ¯4d(\ÅH ô9¯¨üñƒEñt)¦kI \à.¿u1\éò\Ç\Ø\Ô:ø3a®£\Ş\é8†\ìŒü½\ë\ëõ¥°0ô\0ñF3\É\â¶5\Ï\rj½{}F\Õ\ã`H\rü-ô5‘Á\ëÖ¨\ZYV4f8\íZŠ\éšMµªñµF\ãş\×Ö¼\Ï\Âj\ÖgH>c‘ßµzt“‘\n\Ä>ô‡`úwı3I‰—-p\Ë-\Ñ\èÇ÷GOñ®/\Æ:†\Ëu\ï&9#Ú»¹E½²\Ä8æ¼³Rº:±4\ä\æ8\Îú$e\à\ï‹:·ƒR\Ş\Î\áşœ80Hÿ\02öo§J÷]7Wğ¯Ä­¾\Ï$wo\ï!q‰\"\Ïb=?1_\Ü\Ë\ç\\3``p*Î—«\ßh\×\Ñ\ŞX]Imq\Ê\É`Šv\ë:ø%q`\Ò_\èCÌˆóäƒéŸC\Åx\İÍœös<<R!ÁG\\_Cxã­¥úÇ§x¨-½ÁùE\âİ¿û\Ãø~½>•\×x¿á¦…\ãO´B¨“²\æ9¢<¡şª\0ù— 8Le_§µw>+ğ§\á(¦Š\æİ¤p\Û*¯oóŠ\âYH\ë\Í17ÀŞ£µKn\Ì:z\ç¨­\Ï,™<Š|`o \Ğ#d²¸\\zU\å\Ú\Ñ\Ì3pjÅ¯\Í^G­1ù\È\'\0\ål¨`{f»\ßüQ\Õü(R\Şi\ræš½`‘¹AşÁ\íü«\Ï,dó-\Ôw^)·²aJ2\Ìz{P\Ö\Ú/‰<3ñI?e‘&!yo \Û,G\éıFEyßŠ~\rGkzu]!Lˆ™o#{q\Ûğ\ã\é^+g©]i6òió\É\ÊQ\ãl0?…{¿†~3\Çk5®•\â¢gP>Ú‹À?\í¨ü9•+ñJ\Öò\ÚöE½ŠD”œÂ©9\Å}a¯ø7Bñ–Ÿ\ç¢\Â\Şj\îxU½øşcõ¯ñ‡\ÃM_Ã’»¤/=·$2Œœ_ó\Å\0y\İ\ê–Uµf\ŞO5sÒ”Å¹Z6\ï\Åv\ßü&u\ï›¨óa§bYsÑŸ‹ùŒı½1\Í\à\røB(\æ÷xšq\ßqû©ø©5\Ş\Ú@-\í’3‚ı\\\í\ßüúUktó\ï‘òE\Óİ¿ú\ÃùŠÒ©W\âILÿ\0f<›_v\ì?]§|ºu„—–\"ÿ\0yA^e#\Ü\Î-·ngmò·©¤\Ø\Ó!k»¦º±\àzÂ»x¶\"ªk7J³X£\ç]™\'˜\Ã\å^ŸZ±~\Ö\"\0½úšŠ((§¨Y-\å¹Rq^]\â_*;°O˜t8\ë^»Yº¦™\ì,¦„\Ñó½\Ä&e`Aj\à\nôøkfùmaÏ±®x^& ¯J\Ò\äV÷Àö©Ñ•ˆã ª \á»T\Â@r(pc&˜\Ò(ùMA\ç\î\Ç\éÁ9#¯­0\ïòxóÀÂŠ\n¼\Ò/\\œc®hT\0cM(*¤À\ìGpNzı(\\`\\\ç½d³<ˆU*½¬\Ê…wU\é3k:’B‹•\'8ggğ\ÏÁÏ©N.\î\ĞùHrk\Ş †;hV(\ÔQ€+;@Ò¢\Ò4\È\à@À­pIâ¡”„‘ÂŒšæµ­X\Åû¨[37#ı‘\ëşŸ¥Y\Ö5U¶ˆ\ãæ‘¸Dõ?\áüúz\×.»´’±y\ä±\îh\0=½I$òI\ïR´€v§1Tu¤E3&šM\ÇÖ˜<\Ôd’p)Å»V¦“¥´\Òy:sŸOş½\0K¥iy>l¼(,{W|Oñ\ïöı\ãhº[\ãJ¶l;©Ç\ãÿ\0e­tŸüx¶p?†tyv\È\Ãs!û£û€úõ\ã6v²]Ì±Æ§=x\ì*\ã\\õÏ‚z©+¨inx\âd\Éüô®÷\Åö\Â\ã\Ã\× \Ç\ælñ\ß\Åÿ\0“\\7‚4Ÿ\ìy­\ïB\íÛ…ûøş\ê¶E9Ç•‚w>pº…­®^\å8\È}ÿ\0*ˆ‚:ş•\ÚxûHû& \×1¦º;\ãúÀWNTœ~uÓº+|/\Ñe\Öüw§\Û\ÆÎŠ’y\èpB¯\'Ÿ¥}^û?xwÈ°½\×&Nd\"X\ß\Åı+Ùµ\Èôı>{¹~\äHXÖ²\ĞÀò?Š\ÚÌ§[¶¶Uc\0±8\à·oÖ¼\Äw­u¨\ì\r‘}am{\áßˆ\ZY‘|Â¹1I\"ö\ÈõuşU\âş=ø5}¥K-ö’\Z\âw\êGÒ¡h\Æxø$74™ÀÉ©&ŠH\å1ÊŒ¥N\n°Á£#Ÿj Ÿ\ÇÒ@\äñŠ^O t¤\ä8 W+’+\ÔüñŸUğÏ•a©†\ÔtÀp7\ï\"ÿ\0uQ\ìk\Ê\Ïb”0>\È\Û\á_‰š	–†\îcŒ<gÑ—¨5\á¾;ø3¨\è/%Ş–­ui\×hû\Ê?­yö…\â=SÃšŒw\ÚU\Ó\ÛÎ\ÔğG¡Çµ}\à?ŒºgŠt½v8\ìõ\\nÿ\0–3ñ\'\Øşu;\ä³:}\ï¬®rÀŒ\è+~\İ\Ä÷m\'ğ\ÇÀú÷¯YñGÃ‹mM\ZóJe†\ã\ÕZ¼ª\ëM¼\Ğ\Ã[^D\é($GZdx§Wk{\Ãüò|‹J\àZc¡\Ä\İkO\ÄŸlÔ„@\å!\ãñ¬+‡ó$Àş\Zhd\ïŠQŒt¥\È™\äSÉ‘\Èü\ë»ğG\ÄıwÁ“¬QHn´\ârÖ“6W\êz©ÿ\08®2i7r\r>\Åğ÷‹ü3ñLhcd3\íı\å¤\Ä	ÔQ\î+\Î<wğH¯™} ô&\"8ÿ\0\ë/¥xu•\åÍ•\äs\Ù\ÊñN„2H†S\í^\ë\à_lviş+\\\à…[\è\Ç?ğ5\ÌR\Ãntû­+Q0]Û¼N§•a\Ô…E*í˜1Ş¾¸ñ‚|?\ã­1n\É1wEqÊœ÷\éø~5óÿ\0~k¥ò^[a\Ñ\Ôg|J.+j\ÇqSy«x\ê:`\Ö|,T£ƒÒ¯œq\ÏZb3­ÿ\0ss$L@sIó®^s«\Â\Òj(|\åe\ê\Ã\åÄ° ù\0ih°‰¯$¼™u\0ßS\ØT:‰k­ò·2»5¥q\Ø4\Ø,‡ú\ÆI¾½…PÀ<h£ğO\Ä\rg\Â\Î\rœû\í\Éıå´œ£~¸¯ ¼1\ã\ïø\Ú\ÔZ¾\Èo~{9\È\çı\Ãü_‡5òM¹0^˜\É\à+fWŠºœ«‚ô¢\Ã=\ßÆ¿­u÷º>bŸ©A\ßğ\ïüşµ­ğ\çO²\Ñ<.4\Ër?´w—»Œ¬d\'ƒ\Øp3Y\n¼c¯jö—ƒUj³³Q‹–\âM\Çø\Ú\àgzW¥A{q«q\É6Ò©8\ã¡ÿ\0\n-A‚@s§\Ô÷55™­\ê\Ùú{:\ßIòD=\ÏÃ­\0s^\'\ÕK§Ps®@ÿ\0iûş]+H´yd3H2\îsU\ç&\ê\í-”’ˆr\ç\Ô\×M§\Û£8\î2ı¼_r5+¡†!Jƒ·Z¥¦\Ûõ™¾‹Z4\0´QE1…Q@Z¾–—\\t¯\'ñ„\Ñ3\0˜a“Œu¯m¬{FK¸K¨‡C\éM;	£\ç\É\à*H\0Œu¨;‡a]¹¤˜\æ`Sk‚r1÷¾•\ÌKo°’x­	<\"Œ\ã\ÜÔ‹’r*\r\Ø\ã\è›&‚z`cµ5˜c\åü8¨¼Ìœ\ÅG+7\á@<»Gê¹¸‡“QKpqùæ›§é—ºõ\ê\ÛZFH\'\ænÀP36KkVøCkJ\îq…+\Ş>ø7ûÀKp£\Ïp	ö«\rğ¦‡j¯\"˜Œ³¦»p«\Z\íP\0\r!‚AŠ\ÆÔµ$·‰‰À\áTu\'\Ó\ëü‡½X\Ô.ã·…\Û¼ı\Ïoğ\Ç\\\ÜI{9–O•G™û£üjF2I$¹™§˜ü\ÍÛ²ÀS‡Zon)\Ù\ÛÈ¤ò¤\ÔE³Ö‘˜‘\Í0\à\n;v:ô¨İğÑ¸U\í3O{©+ôÿ\0\Zb%Ò´÷¹‘Y—ù\í\ïY\ß<kƒô‘§\é\ì§T¸S°uò—»Ÿ\é[~)ñ%ü<÷Ra\çl¬g™ü=M|Ë¨\ê·ZÎ¥>¥})’\âg\Ü\Íü€ôµRB¹$\Ò!g™Ø–f9,ORk\Ñ<á’®²È™f\ëš\ÇğŸ‡d»¸[™“’~P{W±\éö)g\n€k¦+—R^ºı\ÔÃ•SŠ¿c;\\\éñ»\ã\ÌdŸ\ï\ëQ“¸s\È_O”C©]Zœ\âP\'O\ä\Ãôñ¬\ê+«v3|[¦.£¤¸ eAúş)ú^%,/\ÉŠT«Cu\Îk\è{„Y\ãa•`A ×x\ÇKkmIC|\çGvÿ\0ƒù\ÖV4‹=\ãÁ\Ú\"ø{\Âz~š8“#q\ä\çó\Ç\áXuFƒD‹K…±5\ã…À?\Ãş•wµ\á><\Õÿ\0´¼Ku:¶a´O*?÷ÿ\0[&‰;7ñ.¹q¥jÉ¦\Ü\Éo4lRF\Ø /\0×§øã¦¥zWŠ\ÂE3a\à#ÿ\0¾;q\ÇÒ¼Yº7šœ®UN\ÑôD½µ4´(ú«ÆŸ\n4Ú›\İ=’;¦]\É$dÿ\0zù\ÏÄ¾\Õü/xa\Ô-\İW8òš\è|	ñWZğd©¹»\Ò\Éù­dn¥cúW\Ğzv«\áOŠ\Z3Œs¿½…ø’3\î;z6ñó¥0úÆ½ƒÇ¿o´g’\ïG\rqi\Éò\ÇQôÿ\0\nòI¢x]–Dde\à«õ¦˜‘“K“M\ØqJ¤ÓŠ` <s\Ï\á[’¾1°Ä¸F5‡ps\é\Å:9\Z\'Yˆe<bExO\Æ\Z®„¢\ŞBo,Qy‰\Ï)“ü\'·Ó¥z2¿‡üy¦7–\É/e#F}\Å|û\á¯V\Ç\Êf:q ş÷½I=ıö|—:uÔ–ó)ÊºcüGµH\Z^:ø=£\É-î’¦\æ9)\Ü}?úõ\ã\ÓA$N\É*2:œ0`A¯¦|ñ’\ËSa¥øœGiy÷E\Æ?u/\×û§ô­?\Zü(\Ò<Wnn¬öÁxW)\"rñ\ïL“\Ïqi¼k¦ñO‚õo\Ş<W\Ö\Î#\Î€|¦¹½½±L\éŞƒ\×\éÒZ\ïSQŒ¾•1\È~Nw\Õ~£¯Ö­\ÊT¤8\ì0h\ÓxO\â»\àË öí˜ƒ-¬œ\Æÿ\0‡c\î+\è¯	üBğ\ïôño&\Èoı\å”\çœÿ\0°‹ğ\æ¾HpJŸcùÕ­2\âH_tRuù•”\àƒ\í@@x\ß\à\Ì7^e\î‡û¹>óFğÿ\0\nñ\ëı.\ïK”\ÃyG\"ñ\ÏJô_|qº³‘4\ï‡¹·*İ¨ı\â¼?ˆ~¿Zõ}O@ğ\çtŸ´FñO£\å#\ÔûûşF\"Œ\Ü\\¼¤\áG£¶—É¿ŠvPÈ®8=\rz7Œş\ê¾\ŞÖ‘5Å©\'¼?¯ó®?S²[-\"\ŞÜ û@ı\ä‡Œô\Ä,\×\rq3\Í!\Ë1\É5sŒb£·o2\İXrjN0?Z\0¡~›Ls‚+F\Å$¼xb\ZI%`ˆ«Ô±\è*)c\Â\é\Ç#ò¯Kø\áF¿Ô§×®“6\Öd\0½)û(ıH bğ¾†ü/k£\Ä§#÷Í¿#u?Aü…u6ğGko\"\n«eùZ\á¿\İ_\ê§\çZ#\nóÿ\0\ê\Â\â\êIT\æ(³#\Ô÷?‰ıtş\"\Ô\r¥‡•\Äó’‹ş\È\î/\ç^zW\í\×\ë\Zÿ\0©‡\îjdú»¢\Ù7\ßnY\ÎI®²\Ú,‰*…”Ty\Æ	WG§[ùqyŒ>fşU [DT`Š}P0¢Š(\0¢Š)€”„#\"”\ÑHG1\âO¥üa€;H+\Êu=5­gh§MŒ;‘Á¯} ‚2+ZğÍ¦­WAŸ\åT£Ádµ\ÃY‘”\×{«|?\Ôm˜›I7¯]­\\\Å×†5õb¦Í¸\"¯™c²©$œQIp¸\Ç\å[0x+_º/\Ù\nİuú\Âv2,Ú”f: \àP\ÚƒĞ¼/\â+ ±#$\Ã9«İ¼3\á+-\ÑU\"ø\É#’k[M\Ò-4¸8\"U\n1À«\Ï*¯z‡+!\ÜU.\'X£ff@$“Ó\éÿ\0ê¤’\ã \ä\á~¸®_VÔ\Ûù1\Ü)\ä7Ÿğ©[Q¾kùò2!Sò_s\ïU:S†9ô¦ûPf‘›\å¥$P·J\0c\éLf\ãš_rp*Å“\ŞL\0RA<Z\0vŸ`÷R®‚zz\×Muuc\á½k\Û\É!‰w;şÂ¥Hí´‹&šfUÀ\äúû\nù÷\â_%ñ5ø²³sö˜„\ÒFş÷\Ó\Óó«H/ø¢ó\Å\Úô··Vùb‹<Fƒ\Ü÷4\ÑTºYO”¨h\ÚLš\ÊB€˜\Ôü\í\êk\Úü7¡Gen‡`Vñµd¶hhšRX\Û/\È\ÇOJ\Ø\Æ1Ò|½#Öª÷.ìŠ£~E½Å¥\à\é¡ı\ÇùO\ë´şmF*+¸EÕ¬\Ğ1Àu+‘Ú‹]rc´\çµr^.\Ò\Öò\ØIÂƒ…,İ°x?\Ì~\"º;	\ÍÖ¯\Ã\í\Ú\ãÑ‡õüB[VG\0¯k™\è\Ê:Ÿjk¤ø~\î\ìœB\êx¯œ5K§’\Û+†’Bd ¤ôı?z÷Åˆõyô˜£´¶f²_šYW§\Üz{×‰]E2®\âO¯ô©{”bóN·¼v1³\İõ17FúV\Öò\ÛK\åÊ…Xv5İ­¢]ü“\0Ÿ•‡QUõ\r5’ —qa\Ï\Ë*˜}j“Š\'\æ\ÈŠ\ĞÒµ‹\í\Zö+\Í>\êKkˆ\ÎU\ã84_i3Z¯™óa<†Q\Ó\ëY\à˜\â¨¤ü\rñº\ÃX4\Ïˆí®˜m ~\êO¨şúVÏ¾\é>)€\Şiû!»#rÈ˜!ı=|ª:\Zô_ü[\Ö|!,v³1½Ò³óA#rƒıƒ\Û\éÒ•„rş$ğ­\á{··\Ô-\08Y\0ùZ°yõ\é_c\Ø\ê^ø›¢7’\Ñ\Ü)_\ŞD\ãD}\Åx¿~\Ş\è\ÆK\Í5Å¶s°u‹÷\Çù÷“\ÍK-¼\ÈñÈŒ§X`ƒL§Z`X\Ó\ïfÓ®\Ò\â\Ã/Qz\ZôX\î!\Õôå¸„\î\ÏQ\è}+\Ì=»\Ö×‡u¦Ò¯d\Ë[Hp\ë\é\ïCcR±Ç•‘z\é[ø­­x>Eµ˜µîš§ç¶•¹Aş\Ãvút§\Ü@w¦n7)9®cY\Ó\Ò\"^G\Ş\ê) >Ÿ\Òõ¯\nüL\Ñ[\Èx\çq,I±Ÿ˜¯\"ñ\×Á[9¤½\Ñ–¾P>œñşy¯)±\Õ/tk\è\ïôÛ™-§C•’3‚?Ï¥{×€ş9\Ù\êQÇ§ø¤%µ\ÉùEÚ\İ\Éşğş\å@;\Ïg5´\íñ´r!\Ã+P°\êk\ëo|1\Ñ|]jnmV8\îr’\Ær\èÈ¯|U\àM_Â·/Õ»4@ñ(ı)\Ê)\È\äU†9€c;sÒ¥˜›·À\'#\0\äf›l\Å.¿½\r€Jf\â®hfL\Ç9>ù®“Â¾3Ö¼1¨›­.\í\Ñ?&\å$\ëız\×9pş`Võ\ê*1)Pc^ı\è\ê\ïüKÑ¼qjm.b[[\Ìa\à—”÷[\ëÛ­eø\Û\á\r¦¬’\İi_º¸ \å;ñ¯	¶;m\Z(-Ø™]ü\ÉX`ö\çÖ½ÁŸ¯´o.\ËY\ß}c„\æX\Ç\×ø‡±ü\éæ—\Ôü=xöwö\ï…l|­ô5\0cÖ¾­š\ÓÃ?Ñ¼\èš¨¤\\y‰÷”ú0\ì~µ\ã>3øU¨hl÷\n\×½~Q’(¸?°°ŸS¿·²¶Œ¼ó¸wbx¯«t\r\n\røz\ËEµ\Æc\\;÷œò\Íü\Ï\ä+Ë¾\nxL½\íÇˆob\ÂÛ“\r°aÿ\0-ù›À\ãñ¯l„os1\ï\Âı?úÿ\0\ĞPÀ™QaT`\n	\n	$\09$Ó«\Ä\×şM ³±$\ã\ç#²wüú~t›\ËxƒUk«™\'B~\İÂ¾‹\ëøõ£G±ò\Ñr9<’k>7\×şaÿ\0U\n+ªµ‹ËŒqÉ¬·~\Ê\ßÏ™W(\ä\Öğ*µ¿‘\0\Èù›“V©Œ(¢Š\0(¢Š\0J(¢MŠ(\0´QI:š\0‚ú\Ó\ÌkùSdºŠ1ó0ª¯¨¡û¬(\è$\ä*Â˜÷(ƒŠÉ–üœáª¤—„÷¥q›^Òª\Ë;m\'Ò³>\Øâ‰®÷ZJ{…<\Ñp9»\ëûûV\ÖtşO”\ÒH‹À9o”\ZµŠ \0}v\ã!#\\dÿ\0:½\íL@\ÇŞ˜\Í\Æx§Q±\Ï\0ŒqQ\ÇZy9\éNµ·{¹‚(\Êô&€\Î\Ñ\î\å\0)#§ë®Š+]N’\ê\îE#\\»\Ã\ĞiÖ–v\Ú=‹\İ\\ºD±!gw8½ù¯\Zñ×n5y\Õ,÷\ÇŞ³ŒğUzy\î=Oğ\ß{Ò©!\\¯ñ\Ç\Ó\ê²Í§Û—ŠÈ˜÷Güó÷cü^=s\æ–3j˜Qó?§ğJ–h·¼v±‚\Ç9\Ç^}Mz?ƒ¼1\ä¢H\ã\æ<±\"¶„DÙ©\áO\r¥¬(\ì½NEwS\0ŠdP¬Qª¨\0\ny8\éT\İÀRpi¤\ç=\é?\'Òšø\Ï&¤8\Ï5ü®*~3V™V\Ã÷7·v\ß\ÂXLŸF\ëú‚\Z³9\ÂUYÿ\0u}mp	\ÆLMô?ıp?:¹s÷I½s\ÕVe\'¡\ÓA~\Şh´¿ˆC;p½\ã—ı\Óı5\Çø§á­¶£¾\ïG\Ùmu\É0Ÿõoôô?¥w2$\Ö\æ9Qdº«Ÿız®\rÍÁ2]Zúõ–?¯÷‡\ëõ¨°\î|\ß{¥\Üi—¯mwo$©ù‘\Æ\áV \ÚSd€2ôÁ\ïúÆƒ¤ø¢À%\Ôi*‘û¹ü\Ëô?Ò¼\Ä\Ş\n\Õ<2\æU\ê\Ã<Nƒ•Œ;*–¬Zg\'y¡V–\ÃZ&\è~•\È_\è)>÷¶L\ë\ËB\Ã•z\r¼\ç‚:ı(»°¶\Ô\Ğo_.Q÷]G\"„Àñ\Ébx%1Ê…\\uŠA\Æ2:\ïum\å1\ß\Ä6ÿ\0\ê0?J\ä5-\"{\Î7Ày?­Zbhv‘®j\ZôwšmÜ–÷~WCú{\×Ğ¾øÛ§kÑ¦›\âS¥\ã|¢ùe/\×û§ô¯š\ÆM9kdu\í“LG\Õ~7øK¥x¦¼±\Û\á]\Ê\êxoO­|\ç\â_\ê\Ş¼0_[2\ád\Ç\Êkªğ\Å\Íc\ÂO¥\Ë5ö•`só ÿ\0`öút¯´¾ğ·Ä½¼¦Š\åJüñ·EŸQK`>6\é‘ıi§#œ×±x÷\à½\îŒ\Ò^\è\ên-3ƒ¨ö¯#š!•\ÒD!\Ô\à«bÀ\ê<3­y‘\r6\é¸\ë\ß\ì\×A,k2\\r\ry˜%[rœÒ»]Wû}°IXy\é\×ı¯zM\ÇÕ¬>\É1‘G\î˜òcX\î\nİ«¿ºn#eaœJ\ã¯l\Ú\ÚSò\İcŞš`u¾ø¥­xFT€Hnô\Ò~{Y[…÷S\Ô\ZúDñ\'…ş$\é-L’°\\Km&‘“\×\ê:ò8¯X;[Óµ;½&ò+»™ ¸·$ˆ\Ø \Ña\Çã¿‚SZ/´!¾>¾OAøzÒ¼nö\Ö\âÉ´ñ<R)ù•†1^ù\à?–÷kâ±KÂ‹\Õ+¾;}zWg\â\ï‡\ZŒ\ì~\ÑÆ“2\æ9\â9\rô#ÿ\0\Õ@$¦vË¥G Áù{Weâ¯‡ú¿„\î$[˜Y\à\"UcŞ¹	‘—¨\ëÚ˜‰6³Ãœ uª\ã!†O\â*ı\Ï©À\ïT\Üb¤w \r{&,6\ç Š´AŸbø\Û\ê+H©\ëÒ€-i\Ş$Õ¼1v—úE\ÛÁ2˜UÇ£„W¿øâ¶\âè¢±\Ô\"K]BAŸz9O|z}\ç_9Itu=\Ç\ì|$c²ºñ\ì|9h-ztvÿ\0\ÙHUA’\Âø>™u\äZHÙÕ†Tú”ô5¸\0P\0\0À¨\é6²[Z²\É3H\Ë&O\İ^\Ãúş5¡HI\"EH\ìI\ì+Íµ\ÍBK«‡~D“œ(ş\êvÿ\0>õ\Õx–ô$B\Õ[\0ü\ÒóÛ°®:\Ê6¼¼k—(\áGò¨“\è4iiVB(\Ôc§&ºm6\ÛÍ›y*~¦¨[@UU\0ùtvĞ‹x^ÿ\0Z”2z(¢˜Q@RPIJj7•© Cú\ĞHMU{“Ÿ–«\Ëz±.\é\\b€/<¡G\Ö=ı\İ\Âı\ŞÖ©\Ü\ë«È„gŞ²æ½s’\Ç®2Ä“\Ë!ùšš¬A\ÎMUIyú\Ô\é #Ş’ORi¥¹\ëA=…6\nNi$ Z\íÿ\0’*ş¹ş”‡Zò)bôUy\à0?4^şm\Å\ì\çşZN\Øúò«\äó\Åfh\Ã\Zdlz¾Xş\'5¡»Ş©ˆ±\ÇZa<hc\ïNH^i \æ€s6\ÅS\é]–›§E§Zı¢r©µK\Çrh\Ñô„´„O0\0‘»·¹¯\'ñÿ\0‰n®4m6\å¡\Ğm\ëû\Ä\ë/8¾¹<\Üó\ĞU$&A\ã\Ï/ˆ’\Û\'C‚B‘G’?´&¿ô\ÍzŸÃ¹ó[»©¯,\Îeº™÷;t\Ü} şB¬\İ\\™[\íF Š4\Ù\nr!²û’y\'¹&¯xoB—S»3!ÛŸ•Mh\Z>ğÜ“È·7—cGJõ‹;Tµ„F£·&«\éºzY[¨\ncš¾N+FûC‰\â˜O4Œxÿ\0\ë\Òv\Í\0\Å\Ï&‚i¿ipH\ÍR%‰¸ƒ\ïVF\Õc\È\Î*tl§5¤Q,I¢ó *:öúö¡œ\Ïh\ÈJd\Ô\n\Â14G€oÀÿ\0õ\ë<D}Û„¶;ø © \â­	—!\nI\0dõ5Y:\nÌ¼ÿ\0Oñ•X­\ÇÚ¥ô\ÏDO\á\\\È\ĞÕ–\×Ë•§µ\")I\Ë|’}G¯¸\ç\ëÒ•gI·A<[e+óDü†ñÙ‡ù8¨µ]^\ÏC±û]ô¾\\\Õ3Œœ“SFöº¤sC\"M\á’H\Ûõt4À\à¼Qğ\Î+‚÷º\Ø.:µ±ûô=·O¥y³-Å•\Ó\Ú\Ş@ğN‡0k\èS$\ÖüLL‘\ÏP9_÷€şcòk?_ğÎ™\â[M—q‚ûw:}\åü{j—\Å&xˆt•vH¡\Ğñ\È\íX\×úF-—\ï\"=`n*\êuÿ\0\nj´ªn,³„¸A=ˆ\ìk:€\ÊGô5#<\×P\Ğc—t¶yIß…ø\ÇÒ¹×‰\ã\Ç\"•`pA\í^\Ï}¦[j`°Œe]x?ız\äõ\"\Ô\"\ÚÇ„G©0g:u\éZ:6½¨\èZ„wºmÜ¶÷xd?¡\ÅG¨\é\Z{e†\èóÃ¯­Q\É\ê\Ä}1\à_šv¼Lñ—gz\ß ˜\İJ}ÿ\0ºJ\Óñ\Ç\Â]\'\Å5\åˆX/\n\åYz?§Ö¾U©\ÎMz_>/jş1Yİ–¾\ÒóƒóF?\Ø=¾(°C\Ä~\Õ|5x\Ö÷öÎª\n\à¦±­\ç’\Î\åfŒ\á\×Ø¶\×~ø•¢³A$W(W‡‰#>Œ+\Äü{ğfûFy/t€\×\İv£üúR¸\é}l²§S÷‡¡¨u;¸ˆ\î\ÆGFô5\Íi·“\é¥dVT\Î\ÙŒcÿ\0¯]šJ³F¤Q†A˜\Î\Z\âWh\äuõª$a°yÁ®»W\Ó|\äó#u\ç\ê+˜•	©1\ç‚k¹ğG\Ä\íkÁ²¬p\Ëö<œ½¤¤•ú©şô®qR/\İ\Í\0}‰\áÿ\0xg\â>–cŒ£K·÷–“`HŸOQ\î+\Ìü{ğU\ĞI}¡r¿x\ÄGıo\å^#a¨\\\é×‘]Y\Ï$3£e$ˆ ×½ø\ã”syZwŠv£ğ¢õGıñıh\á\ÑX\Ü\é÷\ïku‘H8*\ãN\í<¹›\'½}o\âoh~2²[¨<¡+.è§ˆ\åO¸\"¾{ñ·€µo\r\\±š\İ\ä€\ËEcŞœ}›`•-É­¸ˆe¹È®~2RPqß‘ŠŞ´;\×n˜o\è³øƒ]´\Ò\í—/3€[²\ì~ƒ5õ>Ÿ§Á¦Y\Ûiv‹²\Ş\Ş0€²?©şµ\ç¼,4ı2oÜ¦&¹;}\Ã\î\Æ\'ñ?Ê½V%À,G\ÌÜŸaRÀ–¢d¶\æü¨2jZ\æüK¨¬i\äÂ§\Ìÿ\0^Â“v˜\Ö.¤¼¹1\ä™&mÍ\Ã\ÓúVŸj\"Geşu—¥Àó\Ì\×2™\Ê+§¶€³$j95‘F†™o¹Œ\Ì8>µ«LŠ1j‹\Ğ\n}0\n(¢˜Q@	H[´\Ö\é@ˆ¤\Ë)ùˆªmÁ<\Õ\Ç]ÉUJœ\Z\0gZ\Ê\Ö-¦•G’P+[¡£¯jC8‚\nƒ\éR)\àWMw¦Au“­\ê+\n\ëMšÔ’Aeõ DiI\ÅD¬E.sŒR¸\É\Å[EL®œ\ÕCÖ“q`óEÀ¹\Ô\Öf½ Â¿ò\Î\Ü ú“Wa¼ª„rN+_¼3€y–\åcAU\ÄX³_&\Ò\Çe§\ÍF\Ø>”ñ—Â¨;\0UˆZI(\Ü\ÇÒºıGXO2Œ@\Ç_¥E¡h\\N¹\Ï@{ÿ\0õ«ø©ñ!­L\Ğ%-{\'\Éq4\\”\Ïı£Ş©!üIñ\ìÚ½\ÙğŸ†\å\ÎJ\İ\İ+a@F\î\ÊKjóI\Úv¶§ıÜ–V#y1ƒ+{vQ\Ø{“Sxô›t\Ø\Ø=\ì¸şĞ™Nv÷òıyc\ë\Çj¥2j·‚\Ò\0L@ü\äwö«J\ìB\éz|ú\İú§\ì\è\ß/¿½{£Gcl¹PU_xz=>\Í\'9\î+¦\0(\Å^\Ú\r #\0S3\Ğs\Å+Ù¦šqŠLG_\éKŒSD°\éFzŒQŠ1\ïZ¤KQRBN¨©ñŸŸŠ\Ò(–N½}³P]ü²\Ôm?Î§^´Ûµj\Ê}¿_*j\Ì\Îö\Õ@`¨X’k?Ã€Î—:£ƒºö]É¢1\ÂËŸÆ¡\×fo°-”,D÷² ¼š\Ö\r§´„‚\Ú,ŸeQÿ\0Ö¯,\ê<§\ã_ˆ¶I—ü°\'› õv\á!\Ï\ã\\€üw«xbbb”\Ëh\Ç/n\ç*~†²¼m¬É¬\ësM#Ò¹r>½\à*¼a!\\\Ü\ÓC>¨ğÇŒ4¿\Ú	,\å\Û8=»Ÿ™\Ä{\ÖÇ”\ÈKB@\ÏT#\å?\à\Î+\ä\Ûû:\é.m&xfŒ\å]N5\í^\rø­m~±\Ùkl°\Üt[÷Xÿ\0µ\éõ§¹\'¤Ÿ&\æ6ŠXÁa\â‘A\ã\Üw¥yß‰¾\Zd½\î‚v?\ŞkV<÷Oô5\è\äGpŠ\àƒ\ÆQ\Ôş \ÓF‹‰¾\ïiO\Ç\Óù}:P\Ğ\î|õº[y\Ú˜á‘†53´S\ÂRuFx\Å{Gˆ¼\'¦ø\\G²\à$\è>aõõ\äz\ï†õO\Ü\â\ê/6ØŸ’\áTı}Ö¡¢®rÚ†„\Ğ+Ii‰\í\ÏŞ…¹ {W} ¬»\å±8a÷¢n¯O†|.T‚*µö“m¨Ÿ6?\ÜÜÃ¨\Ç>ş´\'`<eÑ£fGRpsÚ}á‘‘]Ş¯£+?•yN‹2\rr7\ÚeÎŸ&wG\Ú@85i\ÜV&\Ñu\íK\Ã÷ñ\ßi—r[Î¼CŒB;ı+\èüh\Ó<C\Zi\Ş 1YŞ¶H\ÕJöSúWÌŒx\Çó¥¼SõO>\é^&®ôğ°]‘•e\èÿ\0\ã^&\Ú>«\á;ö\Òõ[vT\'HGô­\0ü_Õ¼-\å\Ù\Ş\î¾\Ó[·\Ïÿ\0dÿ\0C^ù\rÇ…¾$h…\à’+¨\ÈÁ$Œú\ÔTó\ãmqƒŒšæµ4\Â\æ\â$ù\ßÖ½o\Å¯´i\íCOgœ†^«õ®*hªPƒÁQqw,c‡J`\é´~µu+e1\\©ô¬\Ù—¨ª|\ç¥Y\Ï9\Î8ª\Ä\ä\àuõ©†v)À\ì<ñ+\\ğ\\\ê¶\Òı¢ÀŸ\ÖS”?O\îŸq_Hø{Å¾ø…¥yj\Îaó\ÚM÷\×\Üzq_0\ÚZ\Û\Ò\ï®-QgµšHfˆ†G°Tú‚)\ì^<ø*G™ p9cÿ\0<W\á?\n\ßj¾/·\Ñ$ŠH™›3qSùW¡øãš“\â¢\áVışŒQü\Åz¤ú<rÇ¬h“\Å\rÓ¦VT£™O8>ÇE+ˆÔ¶µŠ\Öl\í\Ğ$ P£²‚®\Ô\Ë*Û§\Î*›zn\Ç8ö©\è»…µ¶y›°\àz\Õ\çz”\Ò__‹p\Ù%·Hk¢ñ.¤å‹·«V“j\Ä\äÿ\0Y!\Íg&4jY@± À\áx\Ği–ûW\Îa\É\à}+>\Ö\ßÍ•cõ¾ªB€8\ÇQEÀ(¢Š\0J3Yš\î·k \éyrs#ŒdnÀW\Ãñfö)ów¥Bğÿ\0,\\«ø\ç?¥Qoc\Õh\Åb\è>(\ÒüG}>\ä|ğ¿ŸQıFEm\Ğ++Ld¨\â¥$ãŠ¾`A \nrFü§Š¦xXgŠŒ@\r¡:•a\ÅG5\Ìÿ\0\ë¥Tö\'š¡6½o#¿¿AH¼\ÑR_š/•«{Ymœ‰qW¥\×nd\È@¨=¹5F[‰§9’Fo©¨v9õ¦÷§u4\Ò8ö¤Ö¼M¸kš¼fyt\Ä=d‘¥5\Ğ3˜ôû©3\ÎÂ£ñ®~|¿ˆ\í!^[r=\Íi3T\Ä\09<bºCİ‹™\Ç¾\Õ…¡™\ÜO0\ÂóŠ\Éø›ñ	X3Mu:¬©…\ÇKuşñ÷ô¤Q%/Š?S@ôM@u9H‡‹uô\í*ñı>\Òa[\érukµ\İo»“g¬§ı¦şÅ½*&\Ó\Îó5\İT4\è$\"œów7\\öGV?‡zu\å\ä\ÒLóH\Æ{\É\ß,\ÇøÓ°v@DC;%•®K¤ÿ\0\Zô\ßxU-`IdQ+\'Á~%„ó.Iù™˜u5\êpB°\Ä\0\0\n\Ó\áBZÌ¡v À\0t¨‰§\ÎÙ\ÔYü\é\Óx\'ŠLœ\ÑùóT‹J;ñŠA:sG~õi\Å\íF3I\ÈúS”du\â´H–\'j!¤>”™­%–\Ô\çŠYG\î\éˆr\Í:Oõufl·nMÿ\0‰å—¬:|~Zú–ü†\ãXÿ\0õ¿\ì¿\nı‘_l·‡‘\Zò ük{\ÃÖ¯m¥\ÆÒô‰\Ø\Ï1ÿ\0i¹?—ğ¯\rø»\â#©\ë\ÓC\æ(p˜=‡\Ş?y,\ë<õ§in\à‚Ä·\0úV•¼\ép88=\Åd !F\à;\Óö–V\Úãœ(´@Ù’x§!)€9B\Úü‚`=\Z¯†\ÈùqQ@×ƒş#j>e¶¸&\æ\Ã<\ÆÇ•ÿ\0tö¯t\Ñ<A§x‚\Ì\\\é÷ ş$ş$úŠù@«m\ÏLzÖ¯_hw‰sc;\Å*úôúU\\V>©˜¿\Õı\ß\î‡§Ó§Ò’Xà¼\áš5’6^7ü\ÅrşñÅ§‰l‘&dŠıGÎ™\á½\Åu¬z0\èGZy‰>¼,÷z	%yf´cÿ\0 ÿ\0Nµ\Â+²J\ÑJªpU†¯¢\áğ¨\èÂ¹ÿ\0x?Mñe\ä_&ğ–\á?ˆ\î*Z)3\Çd\İDa¡õ¬\rCC’\İX\ÂÅ±\ë=«©Ö´MO\Ãw]ôE¡\'	:«UHg\n ƒ{R\åÚ†„¬@û\Ñ\n\Ö†BU8 ğE{ö\rşe¶a\rÏª±®7V\Ò\Õ\å1\ßC\äOü3(ùZ©1p=\Åj\è^\"\Ôü9©G}¥\İ<¯u<\èGqT¯,\'²`nC\Ñ\ÇCUr@\È\Õõ>2\é~%DÓµ\á– @P\Í\ÄS\Ç\îŸc\ëZ\Ş(øoi©«^iEbœŒ\ì\Ï\ÊõòJHÁ\Ï#¥z—€>2j¾h¬uB\×\ÚW@¬~x‡û\'\Ó\Ø\ÒhC<C Ojò[_@\ÑH;\ĞúŠ\ànm\Ş	Z	8 ü§\ÔW\×\Å<;\ãıK\Çq/¼<dúŠñ¯|.¿\Ó®mc3Â§)\"G±¤†x¼‹µ°iÉ€§\×5f{v\Ë+©WS‚U27*„\Ç\"¯i¸(ñçš¥·÷y\ÍXÓ‰[€29\ã4À\ê<\á6ñgŒm¬OÙ•¼Û–1\×ó\éø\×\Õö\Ö\ßRó-ŸË´òW\î\äp>œW\rğ«Â«\áÿ\0\r\Écÿ\0N¿Ã¶F\n§ğ¯\ëŸÆ½*$ò\ãß¹÷©b$ª·÷b\ÒÕ¤\Ï\Ìx_­Z®?\ÄÚ ‚…ùPzŸóü©I\Ù‰p[QÔ¼œ“g,}Mo\Ú\Ä;YšE™ \Î>wù˜š\é,mü\é†~\êòk\"<¨wó7ò«tQTEƒ­j›3i|Ç‰vö õ=Y_&\ÖB\Ì\êzŸğ¦¯Šmì­MI¶\"ù€uöÇ­bK*AI#…E,N\0¯<\×u©5{¬!\"\Ö3ò)\ï\îi°Šrd¾#ñÏˆõ3s.R\Ê\ÃxEÿ\0\Ü\Ö^\Şy¦\'v§‚3\Æ1Rt%b2ZÎ·6“<3Fr®‚±®û\ÃKOFJô[\È×Ÿø¿QùWŸI\ç\Ü\ÓYUÔ‡\\û\Ğ)\î}+gym¨[%Í¤ñ\ÏŒ«\Æ\Ù¦ WÍºNµ«xj\ã\í\ZM\Ó \'/rõ×­z×…>$i\Ş\"x\ì®\Ğ\Ø\êMÀRCş\ËCú\Ğe(4v„VN£©­¼\â5@\ØZ\ïX³‚\á\í~\Ñ]*oòCe±\î;W73<Œ\Î\Ç,\Ç$\Ğ\Ùkù\\4\ìû\Õ\Ï\Ó\Û]X\Z’h„‹µ†A¬\ÙDö„°\Ë\Ç\ß\ÔVleüs\ëKŒñU`ºI@ Õ€ß!Šy8¦Ob;\ÓO>´‡Q8Ó£‹¯Ÿ*¯\ëÿ\0Ö«şğÄ“k—:¥\Ëa*\"úıO\éWl´_\í›f|ˆ\à¦Où5\'üec\àm*©%\ìƒmµ¶ycı\ã\ì+x\"YS\â­|¥‹[M©Ì˜‚.Ñ\ï·ô\ë\ç«[Ÿ\ê—7Ú•ÃˆS÷×—M\ÉÁ=«À\áQ4š§‹üDd•\Ú{\ë·$³w\'\Ñ@ü…k_\İZ\Ú\ÚÅ§Ø¸k(	0ğn%\ï)ö\êv÷­G¨ß‰dWˆ!‰Vö\êr\"N\Ê=Xõ\'¹5±\á/É¨]‹©Ğ’z\îŠ\Í\Ğt‰µ›\å™\Ôù@üŠ{û×²\éšlzešª€±’*\ÒI\\W¹z\Ê\Ö;Hh1Ú¬‡>ƒ½1H\Ú)¥±ojEY‰f>ôÌƒßšn\ãÖíš¤±ù\ÑÒ“¨¢­\"X\àx\ÎhŠ1\Æi:t\Åh‘,q)\Ç\ãH8æŒŸÆ‚9úÖ‰\ÆçŸ¯z;zR\äô\ïM\Ï=*\Ò%–\"nN\ßsŞ«@sŸÎ§b6sTˆe¯\ë¢xnòü¶#\Û»\êk\å]V\í¯5\É\Üõ\'©\îk\Ö>)xº+½2\Ú\ÎÔª¦IA\ã\æ<øs^+o~	=\ë\ÇGb,!# sR¼f¡8\Æz¨ö§+\Üg”À›\0ı=ûT‘O%±\É%£=G¥@$ñ‚2qšz’G¨\ï@\ZğÎ—\n7=\ÅHT\ã$\äûV ,º2CZV\×\âC²Qµñ\Ô\ĞõÆŸp“Á+¤¨r\n•\í~\nø—¦\ËSuŠã€®N¯\r8\í\Í9£–R\ni…®‘\ÒTÊ\Êi0\ËÓ•ô\î+\ç\ß|NÕ´eX&ÿ\0I…x\Î{f½o\Âş<\Ò|J¢4³\İÿ\0\Ï_¡\ïL›Íµµı»ÁqMŒ28\Èÿ\0\ë\Zó|8\Å\ŞóD\İ4—¶<²ı=G\ë^ªËA\ÃzÒ†\ç0{{\Òj\ãLù\Ñ%!ÊQ\Ôòr\rM2[\Ş\Âaº]Or+\×|K\à‹+L€[_u \áûCúõ¯&\ÔôG@º6Ú„?» W ÔµbCUğä¶Š\Íó\íªõ+\\•Æ†\\³Ú¸<ı\ÓÚ½^)öğTö5™ªxz\ßP&\æÑ¾\Ït9\Êÿ\0Öš`y$°\Í›dF_Â™8\í]´\Ğùnmµ+m¯\Ğ68o¥eÏ Cpû­f\'Oj«ˆ»\à¿_h7Ñˆ.\'\älñô#¡ô_…~#i\Úüb\ÇUXí®˜mù\î\åüúc_)\Şi–-–Œ²©û\é\Èÿ\0\ëWQ\á\íS\í¨\"vıüc“\ê)0=\Ã\Ç?l5´’óJ¼d¨\è\ÕóÏˆ<5¨\è7­\ÜFHá¾•\í>ø‰¢lµ¾\rwb;ó\Çô=Ç±¯E¹°ğ\ç\ÄÈ­\Äl1½~òF´&#\ã‰TˆÂŒdóŠ\ì>xYüM\ã#‘sekû\ë“Ø¨</\â­oø\ë\á.§ H\ÓÙ«\\Y’H\Û\É\çó¯PøSá xF\È>\İ}‰f=\Ç÷Wğó&Àô[8;€€J½Lqª€S‰\0dœŞuK±ijpp\ï\Âûzš\à€:–¦IÉ†/\ÔÖ—‰5S,…c\'-òF=½h\Ò\ìÅ¼\n‡\ïZ²“»)\Z6ñ\áGš\èm ò üG“Yúu¿™\'˜\Ã\å_\ç[ \n(¬ıSRK8\ÃL\ßq©ö¦}cT‘ù6ga\Ô\0õú\×0\ÌKú“C\Èò;H\ìY\Ø\ä’z\×\â¿d¾›jüô™\Ôöş\èş¿•V\ÂI\ÉØ§\â}tj3‹[wÍ´g’\ß?\áX‰J‰@œÔ™À\Æ9©:\"¬¬Hò¥’e¹œElò7Td\×cªhú~\áh\Ò\ê5—P›%\Ş\Ş\Ãõüiö8™~şsQ¯_J–N@\íX\×ó\É\à)\Çô f¾ry\çÒ§Òµ«\rQmBk\rÅºŸ+\å\Î\æ#\èqÖ¹\ä\Õ8\Ù\\\ÇxgDø7\Û!ó®[vüzQ`{»\árj\×L^\êøù…˜\ä\í\íùõü«}‡½HUQv¨\0vg&\rİ•\Ûò¨\Ùs\ïSj3œRb2\îl°\ÆH\Ç\ëÆ¢†õ‘öL¥v=\ëMúU[›h\ç\\:\ç\ê)•e89©aA,ñ£0P\Ìc\Ğdõ¬\\\Ïd\ß>^/\ï\ßZ»\ÚJg‹|W¦xAûD»Zfm\àæ•½~¦¾c\Öõ½G\ÄúÔ—·’<÷3¶@\Î=G§ ¯Sñw„\Ó\ÅK\ÂòX\ï\"@‘—bÉ´v#·\Ô~µ\ÄÁ¦·‚Q®µ/û]ò-P0at3s\ÈQõ=«¦2L†¬Z¸\ÒO…¼4Q™\å\á)rÀ\ä\àc0¯°8\Ü{Ÿ—œciú=Î¥©,R¹O\ïWtÿ\0wğ\ï\ï\Çj¯h÷šµúg\È\árs°zóßŸ\ë^¹\áoÅ§\Ú#\Ç_S[\Æ)+²f‡‡´H´\ÛTbƒ~8\é[dU\0É§\ä(ç ¨ï˜š†\î4‰™°G$ğ)“AŒóŠWm®1÷Exÿ\0 ¦„QW=)\ã¥E’jA\ÓŞ­!1\â\Í 4¢µH†/8ö¥#ŠnsÚ–´H–2hö\Í“I\Û&­!	À¥\ë@\ïIÚ­\"Xø­9\Âc©ªqœ`µwnqT‘ù§Ä³\Ëqp\Ì\Ç\ï\ëYbØ˜_˜W ]\èñ\ÈNc‡µr·\ÚMÎš\ÆH\ÉnJñS;L}¥Ia\ÉúÓƒKcÒ¥’¡tc¿¾x¨>a¾ôÀ\'=)\È\Ù8\ÏN•Hû\Ø¶)ü\í\äı(m\Ù<°\í@;\é\è*%\È\á¹ştõqß‘Ò€-\Û\Ş<Y>x\Ï\æ+N)’EÜ­Ÿ¡\éX¬2Fy¦š¬ñ>\è\Û\Ô¾W\Ó\éS[\\\Ém\"\Ée9V¡¬\ëkõ™¶7\Èq\Í[1şt\ëøªñùvZ\é.\ä}\áş÷­zİ½Å½\íºM‰4.2¬§ \×\É\0•<‡5\ÔøW\ÆÚŸ‡.‘&ûf?<r§ü)\ÜV>‘ù£\ÙQş5^ÿ\0O´Õ­\Z\Ú\îš\ì{{ƒ\Ø\ÖO†|_¦x\Ü5¬\'\ç\Ï\Ì>¢·™w!\Ãwô?Zb<‡\Äÿ\0\ït†{\Í+uÍ˜\É1õx\Çõú\×%\Ù=Õ‡Q\é_F+d\í#\r\éş\Æø«\áı²\î\Ãm­÷^Ï¿¡÷©q)3\Ênaµ\Ôa1]F‡Ò¸\í[\Ã\ÓYe\r5¿fQó/ø\×cg{£^5¡E*úô#\ÔJb\\\0\n°Ü§µ+Œ\à´û‹•¹´‹4}‹~ŸZ³%½¿óm]m\ïc9\n\ß(ñ­½S\Ãñ\Üs`\âú\íu«œÔ¬\Íõ¹Šuòn\â\ä\ß\é\íN\â:8®’\å7ckte=A\î*[\rcRğığ¾\Ó.)?ˆº\ÃĞ„W§\êWZ]ğè±¸9\çQ]² \ç*Ü© nğÄ7\ÅÑ¾Ÿ¨Â–× aÑ¹ŠO÷I\è}uš^‡•q3\Û\Í!ş\ä\rÈŒ÷Á\ë^\à\í.]OX†\Æ½+ü\ì\İIü})oo	‘ E\É\ÉÀ¦„KY:\åè¶´1©\Ã8\ç\ÙkQ\İcFv8U&¼û\Ä\ZŒ—S˜“>d\Ç\0z-)» E[5ş\Ğ\Ô\Z\å†b„÷®’‹Š>cTtûU¶·HÀ\é\×\Ü\×E¥[ä™˜p8Z\É_·„A\n \í\×\ëSQEX‚¸­Z\Øn\Ú[±»qù]~\î=¥vµ—¯\ê\éz\å\äè®‘FHFİ‡\çŠ\\ò\ï\ëÿ\0`‡\ì\Ö\ïş“ \ëıÁ\ëõ®e‰f$œ\äš[©e\âI¦%\Î\âi#\éôF<¨‘p<Ò£\İ\Æqÿ\0×£æ‚‹\Úv©>•v. \nÄ®\ÖV0=¿ıTıSUŸTºY%Â¬h#0Ä„Q\Øgš\Ï\'Ÿz8\ê0i\0\é0GZ\ÅÔ±\æ)\àg½j\ÊHˆ\â°5\ê\0üéŒ¡s8\nH#\Ó\ë^\Ùğ\ãÃ¿\Ø^[‰\Ó—¸–LõUşş¿y‡€ôñ\'‰\ã®l­q,Ş‡…üM{ó0€)2*>ƒj…\çOlSZ“\"<SI\ç­<œS	 ˜sÁ¨\ØT­\Ï\Å +:ƒÚ³¦´h\ßÌ·m­Ô§cZ¬3PM$¶ò\İ\İJ\"¶…wH\ç°ş¤ô\Ì\ëit­5\ï.bc o.;\Í\'`=»“\é^C¨]^\ëš\Ì\Ò\Í\'›4²\Ät\'\Ûı‘\ĞUx’\ëÄšÁ’=\ÑB™”ı\Å\ÏO©\îÂº\ßxU‹$² ,q“\è+®•;+³)H\Öğg…Å¬k$‹–<±5\è(¡T\0\0Ç¥2t·‰Q@\0T‡Š©;‚V\Zù u¨\áB¶I­J\Ù$Òœ\0¤ƒr\0\ì*¶Ì€v¤Œ\æGoÂª\Î\Ä\Ì@úU!ˆ¿\äTƒÖ¢\0¯¥Hµ¤Q,p\ãS·v¦şt¢µH–.^)\ÇŞ½:\n>•¢D‡~”„\Ò\ä~tœ¯­R%°úQ‚Â“½ú\Õ\"G\'\'¯j¸™d^j’’\r[ƒ…\ë\ÍZ<´La$£*zH\ÊÀ\Ó\ä¶IT•\éJÑ•Fzç¡¨vIjKÀ\Í$=J}=kÁ;NgWğÁ%§´$²v?J\æY¾o&\á<¹T\ã+Ô–T¹ ı+U\Ğ\í\ï\Ôù©‰;8ş5IÁIÓ\ê˜À<ú\nÒ¼±ºÒ¤+:\ï„ı\×µVh\ÒEF~Z`AÁ$w\î¥ ù#\'\Û4\ÖVC\ßvi\ãœg\ìhQ‹rsÏ­Hd\ÅA\É\ë‘ş\íÀ.’\0J\ë¸\ç•\íõn\Şõ\á!d%—³U%p\Ã\ç\éã‘‚ ®:\Ğâ°”nVÈ§s¿\Ü{V$2I-\Èî§¥j[\İ-\ÂğpıÖ€4lµ>\ég·•£•NU\Æ­{ƒş*Cv#²\×^‹p\rşğşµ\â`{p;Ò€PqÀ¦>¸\\ñ«+CÊ²Ÿ\ÔI¹£ûü¯÷½>¿\ã_>xG\â£\á\ÇH%csbH\İ»ş\é¯rĞ¼G¦øŠ\Ğ\\ió«ñó\ÆxdúŠd’\êú.Ÿ¯Y›{\èT?u‡¾\à×ø—Àú‡Y§‡uÖŸŸõŠ9Aş\Ğ\íü«\Û\è±î‡¡ÿ\0\n£™YH\í†F¾¢“CLù¼?\0¯ùú\Õk\Ëx/£ò\îÙ»ƒ\í^·â¯†ğ\İ\ï¼\Ñ@‚\ã«[ôGúz}:}+\Ën­§³™\í\î¢h§C†G9©\Øg#ª\è\Ò$gx[’\Êıj®‘#A\'\Øn Œ\Ä\ÇùW`’ùc3\ÍX\Ñ<‰|Mg¤{÷Ï$CÚ˜ŸğŸÃ‡O\ÒdÕ®÷÷_,@ÿ\0`õüOò¯G¨¢Š8\"HbP±¢…U\0Dó-¼+ı\Õª$\Çñ °[ù±‘¹Ï ®?J‰®î¤¾gƒFµw.¡z-\å\ål¿°ôÿ\0>•³iÁFƒ\åAXIİ–‹–Ğ™$T^§­t±F\"‰QzYú]¾\Ô30\äô­:hAEU\0V~­¤\Ú\ëz{\Ù^+˜ƒ•8 „V…\ã>%ğ\ÚD$%Í¨| d§<duõ®&k72§¸¯¥.§KKYn$\ÉH»\02H·½|³ªxı¥ñM\ä³\é\Ëmg4§d\n¸1¯L\ã¡\'©¡#XÏ¹h6=)\ê\Ù\Ï<Õˆ\Ş\ËT·\ÙL­À÷ª\Ï\Æ\Øe4)\ì}¨8¦õö4Àşt\0\\H‘Z\È\îxQ\Îk¹•Ù‰\0³1\àZ\Ø\Öow³\Æ\Ü/\ßúÖ§\Ã_sÄ‚ötÍ•‰A3öÖ€n\Èõxpxo\ÃQG\"\â\î\ã÷³œw=\à+¡c\ïRHrj\êL¸\ÃMjRi„\Ò	¨\ÏóÉ¨\É\â€\ZiŒ)ÇŸzM¹\äPR&f\Ú?ú\Õ\ä?ñi\Ö.ÿ\0²t\×ÿ\0@·l³¯üµ~›°\íù\Ö×|`Ö°¾‘a/\ï\ç]²•?u}3\ê{û}k–ğ¿‡^\êQ4\Êv\ç<ÿ\0õ­©S»»\"L¿\á\Éq4sJ‡\î©\ìúvŸ²¢(İ“T´=),m\Ô\íˆü«d+i>ˆIu\Z\Ø\ã=i˜É¡\ÛsšS\Ïÿ\0^ aŒTs>\Å$u\Å?8ª\×$œ…û\İ*‚\Ø	\'¹\ÍS\'÷¤û\Õ\Üyvø>•Cø½*\ï\Í=p8\ê)OJp´Q-ç±£=óH8¥ükTˆl	¥\éŞ’‚GQùU¤Kb\ç#©:PO<ñ\ÍR¹¤sŞŒ÷ ’F{\Õ$!\ê9­A÷±UÒ¬\Ã\ÃUò\Øo\n.c•<r*\ÈN	\ë‘]^½\à\Øn•®ôÀ7u1…pÙ¹\Ó\æx\Ù`ò­\Åxii¢WbñŸ.^ÿ\0\İo­	*ƒ\åÊ¥d¡ş´ôx®†S\0 \Ó&D‘6LFW\é@\\\ÙGu#(d=T\×ª\èN\Ó\Ù\å\â\Ï)\é] ’KL	N\è‰\âP?Ÿ¥N\Ñ$\ËÁ”\î––Iò\Ãú\Z‚X˜eH5\Ù\ë^\ZK\Ò\Ãû¹‡<t&¹I¶²y©µ\Çñ\ÅR ùN\æi\Ø\'§\"¤–+\Èıj•\\\Æ)€¹À\ã\ÅH­ƒ\Ôc»\ÔjARr	ü\èpsó/zRH`A*\Õ\'=5\"¸cH\rmCYø8ûÃ½_\ÎõR§Œg¯Z\Â+ó\ãô§\Ãs-¾6\å—Ò›]H\Öo´kÕº±\á•z=G¥e\Ãp“ *y\î*V^(\ï¾øe­„³\Ô\Ù-oº\è’®öH–PHa÷YzŠùY‘·)#\ë\Ñ|ñF\ïF)e©–º²\Î\'\çŒ{zı)\ÜV=\ÈLÑ³\àg¤ƒîŸ¯¡ÿ\0>Õ™\âi\Ş\"·\ÙuÙ”~\ît2ÿ\0ˆö«ºn©c­Y-Í”\É<;vö\"œcš\Ø\æ,\Éüò\'•ÿ\0tŸ\ä:S\á$ğş6Ûˆü\Ër~K„)ö>‡Ú½á§‡±ôC}:ÿ\0¤\Ş\á†G+ğÇ¯\å]{-¶£jñÈ‰,Oòº:ş„†¬*„Pª\0P0\0\è+ã«—ñF¨¡ˆ7\Ë\Üø\î}+zú\él\í^c\É(õ5\æÚƒ¾§©­ %†wJ\İjg.€‘6‰n\Ò½˜|òŸ—=…töV\æiUN\æ¨ÁTUUÂ€\0\Ò\é¶\ŞL;˜|\ÍY¢‹ª¡(\è-¤\ÍP‡QIFhh¤\Í-\01\Ñd‘\Ô20Á¡\åş.ø9§jğ¼º[%\äˆd9_ÁºÖ½NŠi\Øuox‡Áz)\â`~\ë•‡±\èÂ¯i^0‚í…¶¥†\\`1\èÂ¾¬\Ô4\Û-RÕ­o­\ã\ê3ùzWƒ|SøSo¥irk\Z*\É$J\ÃÌ…†Lc\Ô7R?\Îi\İ=ËŒ¬c<(\Ùh˜\İ0j\Üÿ\0e›\áõ\Æ\èú¥İ›ŒÌˆ\ßP?­tşdwñ’BxÊ <©ú\ĞÕ£ª¹€şu\Í\ÊBŠdšg\n ubN1ù\×\Ñ>ğü^ğõ½‚`Ëó¿÷œõü;a\\?\Ã\ß\Ã{ªbhe¡\ÄG\\¿€şb½IKfuB6\çœ\Ôd\âœ\Ü\Ó‘HÌŒóLjyıi¹\Í M0ÆÙ¦‘\Å\035\Éø\ËÅ‘\èº{\Ãƒp\à€:\ã\ßğıO\Ğ\×A¨]y#\ÉI$`X»¶Õ@$±=€\0ŸÃ¿C\åšV‹uñ\Æ.¶d¥…¸ù®moÇ©ì½¸¤\é\İ\ê&\ìfø{Ã—\Úıä—³†ò·şòF\îO8Ï¯sÿ\0×¯N°¶ŠÌªF¿s\Å_\Ôm-t;xô»\ÙKƒ\ê}Ï©=sYñ>k§ec=õ:«K±*`Ÿ›k\Ì\0\\\ÂLUzıkb\Ú\ër¨n\rEŠ/“\Ô\ÒçŒšg˜1\ïC“¥\0*¶W\'½1”\à\çô§ç·¥!a¸qLD3œEŠ¤\ï­Z¸?.* \âA\Íi\"p8¢”\n\\f·Š!±¼÷¥\ïGqGSš\Ñ\"[x “Œt¤=(&©\Ïl\Z;õ¦x9?…;Ò­!O\éNSy\èiIÁÁªñ÷…YB7qÚª©\ÅX\\Ö˜Hñ–\Î\"˜\åsŒÕ±©\é\Zˆ­¼\ÅÚ“\ã‡şµÄ®É—r·=x«š~«qa(!‰N›M|\ê—s\Ğq\êŒMKI¾\ÑnŠJ…yùXt#\ëI\ÚNK€Ã½zL7z~¿g\ä\\ `G~ \×\â	\\\éŒgµÌ¶\Ä\ç r¿Z¢nPe(xğA\èj©…\á>e Üƒ\ïBO#ı\ÚH/L\'Ë”dZ¸2‡ˆ‚=¨\Ûk¸®S¹ô\ä\Z§ª\è–Ú„Ee<pÃ¨©¦¶YŸ\ÌV\\Œ:7³\nX/\Z9¼‹¥òß¶O\İM1{¨iWz4¸d2[voóÒªmIhÛŸJõ[‹h®¢\ÚÁX7PG¸c\Â\ÒA#O§\çL_\áM1œ\Ã+!\'ò 79¬yŠ\í\åÈ›d\ÔN›	\ã=³\éT!€ô÷¥9‘À\î)£+ƒúR\Æ{\Z\0”1ÃiûÀ\å¨	\0¼Ó•³ŒRD%[|nT8­{ñ#ùra[¦}k<\î\éAP@\É&€7Iùx9¦´\ä\nÍ‚ñ\á!,¾¾•§¤Š[ \ĞÏ‡¼Q©xrğOc;/÷œ«ıE{¿„> \é\'!f[k\ã\Ö<7û§úW\Íø;º\Z\ïşøl\ë\":Œ\È~\É`wŸF“øGõü(\İ\ç³óM†+€0$QœF\Çù«•˜Cô\ÈşU›¨\ŞJ]aµ-¼ğ1\ÆM;ˆ§¨¼º•\Û[\Û\0\ŞP!rx-\Ü\Öf‘á«¨VYf\n%v!‰=+¥³²\Z}¸PwNü«€l@£°¬Ú¸Ì»m\'\Ëui;\n\Õt¦æ\Ô\0úRi€Ñš\0~h\Í74f€N\Ì\Ğ\r\0?4´\ÌÓ «_\İ\ÛX\Ø\\]\Ş:¥´1³\Ê\Í\Ğ(Õšó¯ˆÚ°–\Î\æ\Ëzı–\É·\0%˜ÿ\0ªˆúŒ\á\Øzm\é‚W<k]½\Ñu\Óym`ö:ƒİ¶\èUBÆ°ã\ïtÏ¾j†™n÷—\Ú[.\é¥pŠ\0\ëšÌ…¤H¤m\Î–cÜ¦½G\á_‡ğ&\Ö\î\Ö;|ÿ\0\ã\Íı?:gU”`wúN›¤Ác\"5ù›û\Í\ÜşudœÒ»sQÖ \æši\äPy=E!\éH¦\Zq\éM\'˜ ‘Tµ;\èt».§`ªƒ<÷5x\à|\Ä\àÉ¯ø¡â†¹š\Ş\Îİˆ2pz/EüO\'\èVª*\ì™«x£TñN¨t}=˜¥\ì«\Å\Æ\çù¸öÁ=ºvQ^÷¡\Ú\é?<.–yr]•3ş¶Lw?\İ\ç­x_\Ã\Í0Y\ê1jò)Şœ\ÄcŠ\ï®o$¹”¼Y›MuòYje{²{‹©o.$V,\î\Ù,{\æ–?½\ì*´}9\éSBşfyùi¹\Ş\àŸº:g½hF\ÄsT!\à\n¶­\Æs@\Z1\\np¤óŒ\Ô\ÓM´q\Éô¬\È\ç-ø«ŠFK1\àRÚ±Xc“ü\éq%›94\Äùˆcø\n~qõª9\Îp9ª\ß\Ä*i2I5Ç˜¤Ö±D¶O(\ÏR1ô£<ñ[¤f\Ø÷ ô¤\Î)z*\Ñ-¤<õ§z\Ò`ıj’™÷ü( óF«B½iGNM!ıi\Ù\çŞ˜‡/Z™zçŠ®‡\æ©\Ô\àæ˜ˆ¼O\àF’ÿ\0BP	ù¤´\ì}Jz}+†I“ŠRPJ²0Á\ÜW¾G(q\\Ï‰¼g®ƒs-µ,Àpş\Ì;ız\×\ÏJB3\îytR\Ëi(xÜ‚+­\Ò<E\Â.@\ä`ç¡®J\î\ŞóI¾kJÃ{8õ¸¦el\ÆO­B•ŠqL\è|A\àØ¯\İ\é€\êb\Ï…p\ß\é\Zm\ÃF\êAT\×i£ø‘\í™b²½‰\í[z§ø\ØH6\Ç>2²/õªô#m\Ï>X®\Ğ\Ã\ã½6X\Õ\ã\Ü&\äU÷›ªiº-\ÎÙ~W\ãM†õdù&oZD^m<\ìf¶\í\'uöaıj\ê\É\Ò\Æ8\Ç4„2T‚§±U¾\Íå±’\Ó\å=L\à§¥01µ¿\Å{û\ÈÀI{8\è~µ\Ç\\Eq§M\ä\ŞF@\ì\Ø\íık\Ô!ºe!”†#}ê¾£¥CI#‡óJi\æ\åÜ‡\ä<ı*³px\'¯9­OCº\Òdi\"Ì°¾\Ã\ßük<\çRz0=*„@¬ó¥8\0ôô4:l?\İ\Ò@\'„\ĞŠ\ä\àœu§«‚0\Õ\ì{{Ó†8\Îph|t\Æ\Å:&–\r\È=E1_\åÀzTx,\ã·j\0Ô²‘¯d—3HÁB¤ŸJú‡Âš~ğå¶œ¡|\ìo‡ñ9\ëş…x\çÁ-şµ&¿uú=—Ñ¥#¯\à?˜¯ug\ß&I÷4eI\æ§«\Î}j¼6Xô)Ò¹lF½[ô€T;\Ø\Êzt_ñ œÒ’\íL¤\æŒ\ÓI£4€\\\Òæ™š\\\Ğ³Kšnh\Í\0;w4¹¦qJ\Z€=)\ÊsJ«KsŞ€\Î\Öu\ì\İ=¥@¯;!8\ç¦}‡$û_>ø\ËX7—B\Â	L‘D\å\ŞF\Ë!?4‡\êxƒğ¯DøŸ¬]ip´’Fê¬¦(\nôÁû\Ø?\Ş? \á\Ò\Érñ=Ç”ì…¶´»~PŞ™\éøPoF:İ‰e¦\ÜjZü¶Ë¹\îX§©?NµôE…œZfœ \á@£ğ®á·†^\Æ\İõ›\Å\"i\×©\ê©\Üş?Ò»\×l÷¤\ÅRWv@ÍšŒ±\Ğ[4\Ó\ÏzFAšNi¼Š\\\çŠ\0\\\ÒpÔ¦…”€Àñnªšn˜\"-µ§İ¸ÿ\0v5sùqõ\"¾}w—Ä\'iq,™À\ä*ƒ\éŒ\n\ìş%x„\Ü\Í8şY‘ırC\Éÿ\08?÷À¬\Ïif8$½‘y“\åO ÿ\0\ëÿ\0*\é£²&ì¾\ÊµG\0\0\0«h\Ù|TE°1Š’œ\ä\Öõ%vLU‘dn| \ïÖ®ªªaGª±\ìòjd`H\É\Íf2\Údrj\Ê>\ÔÏµS\Î@çŸ¥N§r¨\îyü(ô\äãŒ“R\ÄL\Î‹\Ó\Ü\ÕX\ß\í\r°«xş\ÕyYPp>Q\é@\â—wız…pÏ¯AJO^y¦„\ÄsŸóÒ˜ n\ëKM$n\ë]1D6O\ïG?…5\ÆM.qZ¤f\Ø‘\èh\É\Í7\ïJ¦©\"Gw\íA\ãÚ0£¬*\Ò\ç­E/\'9¦Š \ä\ÑÏ­\æÇŠbN\rLO\îÏ­B¹\Ïj’A˜›Jb:\r_‚üs\å\\/Mo\Ç6x5Á\ßi{\ÛÎ€\ì•z2Õ½+\ÄO‹i¨¯\Ñd\Ç¾z2¹\Ş\×c¥\ÖtK\rz\È\Û_Dz«¨=«\É5\Ï\ßø^|Í›‹l%Â\Í\èk\Øa¸COCS\ËWP4SF²D\ã¬2¡\Å0Œ¬x9T˜nNµsO\Õn4Ù€\ä¦zf·üM\à;1ÿ\0DV–\Ø|\ÏkÕ“ı\ßQ\í\\¤SGr8Àn\àö¬\İ\âk£;\Øo,u\Û3\rÂ«©Q\\gˆ|>œZ\æ\Ó÷¶\ç\Ğrµ3Mg8x\É®¿Iñw( ¸\00Ct5IÜ–¬yµ½\ã\ÂBJ2½1\ÜUĞ‰\"ù‘~µ\×\ë\Ş\r‚õ\Z\ïMe<˜\ÇCô®£¹Ó§d•YO*E$œ\åÉUû²¯ocI\rÜ–òˆ®\Ô)?u¿…\ê\ÄRGr¾\ÜR:Šdó\"=Tö \ÍwQ’ä•\Æk>ev\Ì\ä”\ì~•Òƒ.\ÆZ{\\õ\ê\Éõõy%†ö0N=§°I½„†”\Øù\Ç#<D´|½\ë¾Ö¼;\r\Üd²üİ­q7v—:\\\Ş\\Ëº>\ÍVÀ¢F\Ö\ÏšrœƒøT…E/¥E°\ç¦1@‡n\è@5wO´›Q¿·²¶Bó\Î\ë\Z/©5KƒÁ\"½{\àÏ†ƒ\Ë7ˆ\î“)b¶\È\ê\ß\Äß€\ãó¦«hZT>\Ğmt»p1\nü\íı÷<“ùÖ´D¶vªJ\ÆIy\é\ÔÖ„\rÿ\0•H®\0\äƒ+unŸJ„şõ\Ä}º·Ò§cÛµ ša<\ĞO”€\\\Òd\æ“4™\í@\ÇP\r6– Ss\Å8x\Ğš–5\Ürz\nE„õcŠ˜\0\0¥R@-QT#;Y‚\Î\çI+ø#Ü¯Ì’‚{ú\ë\Îl\â†\Ğ6”¶­£’BªñZ\î¼Gq²\Ö8ø\Î\æúóúW0\É1ıL†®YR©\Z¢€ª£\0Ô„Œ\æ£\Ïz7z\Ôq8\æ\Zi¤\çÖ€N{\Ñü\é ñœb—­\0;=k\ÅZ“i\Ú3$²\ê\èù1·÷s÷›\è&¶G¥y\Ä_3MvQ¸6V\Ãßƒ+ÿ\0%úfšW`\Ï;\Ô\ç:×ˆpg\É\"„\Ê8§õ¯J\Ó\íR\Î\Ê(PpŠ\0®#ÁZov\×N¹	\Âı{şŸÎ½	Ğ…À®ø.X\\Å»»\ä\à\095<}³Q\"Œ\äœúT\Ê02{\Öe§¯¥Y‡†z\Z¬>\î;ö«¦\0\ëü¨\íû\Éöô©\ä}\Î!N9>‚«\îòÇ–œ\È\Õ=ª\0\à\ç‘É F”@Ea@\æ¥\ŞL_Z¬Í”Ç©©¸Üƒ·\\Q`-©\Âûb£ˆ\ïw>ø¦<˜_zt*q\ïU\rX\Ä\Ä\ÓNwŠ:õ\é\'š\ëHÅ²`i	sM\r\ÍúsV‘#\ã£<{\ÓG\ŞÉ¥\Ï5iRG¹\à\Ó3ŸJPqÛŠ`p¸<f”3ù\ÓOPiA\ê1ƒT!sN9öô¦õü©@\Çn)ˆùª~ˆEBi\ì~J`l\çvGN÷OŠ\æ<2ŒúÖ•Õ”–Í•ù£õô¨³šùƒ\Ğ2¬µ+½Aå¥µ\Î2y\"»+Ø®¡Ym\ä¤g…,	2À\Z\Ë\İhó™\í	1\ç\æ<¥\\emÁ«ƒ¡\Ç5\Çø«À±j¬÷\Úa[}C©ù%úúz\Ó\Òõ¨5[d\Ã\ï!\à\Ö\Ôsv=jİ\âM£\Â\ä\Ù\İ=¥ô-\ÂpU\Ç\ëô ©4g‘\Ï\ì\Z÷†\ì<Ck\å\İ&\ÙWı\\\éÃ¡ööö¯*Õ´C\Ãb\ä\ßn\ç\\(ù[\Øúj\ÊQh\Ö2L\Ò\Ò|C%³,7+\ë\é[š“§ø†\Û\Ê&#\åwú\×„e0}\êæªO§H9%=\r	÷cUĞ¯4‹¢HAÑ‡z†\ÅpoÎ½:\Ë-r\×Ê™Uç¨®?\Ä>–Ì´ö¿¼„ó\ÇQTI‘†@bª=¡e³!%<´g\î·\Ó\Ğ\Ñ\Ã\Û>\Ç®qƒVÊ¬£tL3\é@\Û_¤»¢•vH8(\İEA©i0\Ü\Æpª\êz©©n!K•!+ IWª\ÓVi­˜Gr2İ”}\ÖúúS\ÏõM{im·4cªc‘ş5$I—û¯\é^£sf—<ÿ\0r\ZÏ‡¾f–1\åÍŸÀ\Õ&.—¤\ÜjúÅ¶Ÿl»¥¸\"ÿ\0Søu¯§´û(4]\"\ÛLµa·Œ(÷=\É÷\'šñ‡¶W\Zl²j³³¯\î\â\È\í\Üÿ\0Ÿzõ\Í+Rş\ÑB\ì¸(pŞ„\ĞØ\Ëe\Î\Ñ\Üõ­\áW\Øvªv\Ãjo=M[|\Ù2yü\éj\İ\nG–û\ÍÉ§“IšBx¤1sIšJk¸U\Ï\é@g\n2\Ç‘][• ı+:\âRı9ş”YiCtQ\×Ş€4¨÷¤\ÍAu+¤\'\Ë±\î;P\"\Îô\æp£ÔšS¨\ÙFv}¡2{I¬±½»~ğ{·­>Œ–q	·\ÊOnƒ\éT\Z“]1„ûŒÀ“\ê*\ïzÈ\Ñ\ä‚,œ\àgŠØªRQE09l.]\äÈ8ü?úÿ\0Ö°·\îbÇ©æµ¼Gt¯yöh\ÎU9÷½+\Z\Î[\Îh\Î9¦\ç}i23õ\â¤b–¥›Ş—¿€vy§d\í¨\ÇT‹@\r¸s\r³º¨$) W\Íş)½ş\Ò\ÖLP¶ø¢mŠ\Ùû\Ç$–üX“ø×µ|D\×WCğ´ˆ‹›¿\İ\Æ3\È^\çüúŠñOX½æª¬\ãpS¸ı{\á[Ñƒl‰»Ï†´Ák§¢\ã2q\ëŞµ™	5\Ğ\é\Zb&†^X`U;«‘ë¢¤•ù{¥ÌŸ/Ù§¨\Æ9©\ÌY\ÎE!\\GOJ‚ˆ\Ï0yşU;\È#\0\ãs¢ùc]\Í\×Ò¤…L’˜ôö¦\"hÔ¢c—n¦¬@0™\ã®*³€U˜¸\Ú;u4À¶0d_jr\ÌVU\çoZbœ¹>Ø¥ˆ€6¢õ=}h@X\Î\ì*\Ô\ê6€J‰\0@\0\ï\ÔÔ™\È\âºi\Ó\åWf2•\Ç\ç\r\ßZh\ç¥8V\Ö\"\ãû_Z\0\Î(\éKú\Õ$!\0\Çz	¥<S3Ï­U„.{)÷\Ï4„œ\ÓI$j«\0\à\Ù\ÈÁ§\ÍG¸õ<Šp\'Šv&N3øRö\éL¹\æœ8?¥0½ºT\Ïş©¸ÿ\09¨‡\\\â¥\ÆS° Gl0Á³®ô\ìfK~\×ü*Ú·5*¾\r|\Ñ\è˜*pH\æT0 ŠÔº²K€YF\Ù=}k)£xœ«‚©*óLe”\\[1U\ç\"´t¯\ïqk|<¹‡»\Z›!ª•ö›\Ê0İˆ¦€\ë#›\É\Èõ§]Z\Ûj6muMƒ2\rq6ZµÖ’\ë\r\æ\é \è¸®¶\Ú\é\'ˆI†C\Ïªi“km\â?]\èL\×zg™s§Z.¯ş£õ¬eŠ\å2ü+\İUÃ­q&ğwNú†Š²w<=_ğ5‡cHÏ£8ˆe’\Ñ\Ã\Æ\åH®³I\×\Ò\áD7\0<aº\Z\ãVgI\Ş\Ö\î&‚\â3‡\Æ5.\Â0À\ãĞƒPŠi3¡\×|%\rò5Í†\Õ~¥;¥prCq§\Ü‘J8\ãWm¥x\í˜G;e}}+gP\Ò\ì<AjX…*½\ÛsÍ’d¸\0œ_‘”2ªFA©õm\ëJ”–S°taTbŸ $ƒSM0$thWÌ¶,ñ½ñ/Ò\ä^ÃŒes\ÏÖŸóDC¢ \ß\Ì\"kg\Ï\ÜıE0%!P‘“µx\ÅuKx±FO”ùOjã¡™\ßq‘\Z3‚B}«±\Ğ%}6\Ûz‘ºNX{vŞ«!W¯JÑ‰|¨Â½\ë/K•f&q´°\à\Z\Ô&•Àx4„\ÓsNE.	Ö˜?…V•‹\äŸÎ¤v\Üp8QQ±\í@\ÊTğ¸Œm\Çq×­h\Ğ`FE9£´yû\Ù¥–&“\Èõ¦\"\ê°e:\Z‚ısh\ßZ\Şmµ¾\éı*\Ì\ëº\ÕHE]1Hˆ\ç¦x«\ÕZ\Ï<\Ô\É/J\á›\ä·s\éL}±Z\è[Ä»\Ø}\æ…¤\Ôn\Ö\Â\ÊIÛ¨Q\êİ«.úş=>\Ò\âUó¤|*ƒ\É$ô\Ç\ãY:Ş ×—+`Rƒ…»š¬‚\Æ[;\É#;\ÎÄ“\æ—4\Îô¹\ÏÒ²(Z<Šfy&”İ¨Ç­9¦ñŸzp9\æ\Îjh\×q8ÿ\0\n‰Fp{\Ö?Œu\á\á¿\Ïv­¶\æQ\å\Â=\Ï\ÃşÒ¸Gñ#_:ß‰\å6ÿ\0E¶ı\Üj:q\Ôş «\à] Ÿ-\Ù~i>cš\á\ìm\Úşù†w6\æúW¹xSO[	\ç\İIr\Å\È\ÆZ»\Z\Æ\"…tZxVD şl±\ÍD\Ät\Ís\ß[š¥#Ÿ¥@ö\ÅSq/\\\Öô‘+¶Xp*´\î8\Ç\È:{\Õ&+F2M\î>Q÷EJF\Ñ\ï\éW\å¶\ÚÀ»U%R3\Ü\nµ©%| ÷«\Ñ¼\ãµTC´—‘\ÍYL˜Àa†>•@L…;NA5b$\n:|\İi‘G±yû\Çô©G¯J\è§¬\Êrè‡\Ù\êiã‘€0Ô ú\Ö\æCƒ‘”ñ\×5\ÇüiÀğEZB&\Ïg¶*0x\ã­;=\ZvN@\ê)§ô\ïKœ\ç8¤5B\Z\Í\è)	ô¤9Á\ÇÖ“>\Ô\Ä; /\\\np?…F=:ı)sÚ˜®I¸}iÀ\ãÿ\0¯Q\ÇPiû²>jard8\ÅJyN\Õ@\â¦<G\Í;Õ«s‘S«\Õ5cš™[ò÷=\"Ú·4’Á\Âa\Ç>¾•5J­@\ÛIm\'\Í\Êg†ŠÙ­²\×k\0A¬\ë«\ßJúzR>{T<0ú\ÖZ­Ş‹1’Ù‹Ec=?\n\ÚDˆ$LÁ£`-išÍ¾¡h\Ûlƒª¹­x\ç\r×­yÆ­f\Ğ\Í\æÀ\Ïy\riø{\Ä\Ï<\ßa\Ô(%\é¿\ë\ïZ)\\M\"ğ­‡ˆ¡Uò®~\î\á\Ì=¨ö¯/¿°¿ğõ\ï\Ù5(ğ­ş®eû’c\ë\í^\É\Ü\0NGc\ëM¾°´\Õl\Ú\Öò\ê­üÇ¡¢Q¸\ã+6$C\Ï^µr\ÃR\Æ\\Jw\\ÕxR÷\ÃN\×»\î´\Ì\ä¶2ñFõõ›\Ñ\Ü(e?­gª5Ñ£¶‚\î\ÓW¶1\Ê õ\É\ë\Ş’Ü´öƒt^€t¨\ã’Ky\Ä\ÅH\ç\ë]>—®$\ãÉ›†<s\È5W¹\rXód2B\ÛO`Ô¡3–ŒıEwšß…\á\Ô\ÜZae\ëŞ¸ß±\Ëm9†H\È h¸ˆ`w\nW…<ñ]™h÷Wq\Ä2«\éY–ğ¨\'hÁ<\æ»]\Ë\ì–~c\Ş\Ë\Ï\ĞzT\ÊC4†F\0j+¢¿+r*¨\éô¼šIˆ\ÖV¹S‘VP0A$s\\Î­\â/i/©_¾;bˆšWô\×Ò¥Ñ¼M¹¥Å¨Û«F²d=r:\à÷­\×j\í£òG«\Âáœ“ÛµUÉ’O^´\â\n‘ƒ\Í0-’3N2rjºK»†\à\Õ\ÈX\Æ9 	”*ea­‚=* isŠb5¶\èù•%¼¡\×\Ën¸\ã=\èW+\ĞÓ¶£>õz¡õ	M½³¤±\ØmS\×v\éöeY\'¯Ö³5{¦ûX„7—\"° ŸNæ¦„€òq“š\0\Å\Ö›UQƒ²\ÜûG ı	ª8\ç¯5oQ˜Iv\à}\ĞzúŸó\ÅT÷¨{”/nzP:\ÑÒ‚i\0¸\Åş>Ôœ\ç­\'¥\08:z*,sR/\ë@Ä…\äP3\ß\ÓŞ¼Oâ‡ˆ¿µ¼Hm!$\ÛY,(\î{Ÿ\Ó…z·Šu¡\á\ß]^\ä	\äTşñ\ïı~€\×\Î\Ë\æ^]„\ê\Ò7\Ş=~µ¥8İ“&uÓŒ\Óù\ì>û`q\Ğœ×µ\ØÀ-\í1\×\×\à\Í%cT%F\Õ\ë»<+¦³åŠœ5wNE3<cÖ”õ¯`hwÓ­!n1\Å*½#g>ôĞ™Œõ\ê“\ÆK`\n¼\ì0sÏµSœc¥Z%y]Bú\ã5b(±ó¿Ê¥Š3=I´\Õ\ÑNÕ™\Î]`\æ”u=iø\ÇZ1\ß5ÒŒDğy¥\î)@\ä\ç­8zU¡:@úQø\ÓIÁ\Å!oj¡¤İ\Îi;P[œ\Õ\n\ã\Ës\éšv\îƒ5{QœñLWNM \êsùRÜŸZ^\Ù\æ˜\\1ù\Ñ\É\â9ü\éy œ\Ó¤\àc­(¹<b’\Î\ßnõ@=[¥L\àˆ›x¨Tô¦\â#\Î:SÒ«Tª\Ü{\Õdn•*+\å.z…¤j•Z«.zTªM\0X\rR)ªÀÔªx¦76+&^ zz\Ö~[k‚\rm+`S\'·\áy\á»HIm\Öa\Î\rf\İh±J2:0\àƒ[RA$µ—\è{R`Ô†d\Øk\é\Ò{\ì´Y\Â\Éş5\ÔÁp®\ã`\Èzk\æ\É.†PsY±\ÍM\Ñ\î’ßºz}+HË¹-¸a\"@*F5Áø“Àd3\ß\èJO¼ö½¿\İô>\İ+©±\Ô!¼‰d…†OU\î+E%9\ëT\ÒbM£Å­\îw»C:4s!\Ú\È\Ã¥[\0G\î+\Ğ|G\á+=}<\å\Ä\Ê0“ \ë\ìÃ¸¯>š\Ö÷Iºû£\ÇşuÇ¨5“””½+U–	;nO\ï\ßZªn“ZÔ®\É\Û0§n3\ïõ©¢\Óc1\Äò—\Ş\Ü\í\Ï\0{ÖŒP…P\0=C­c2\ÏFaz¤ÿ\0«^O½t*²¸À\ÅM÷i\\	rzVŒV\âuw{òª-2\Ø\Í/™ ı\Ü|ó\Ü\Ô\×n\Ò\ÈO\åZ\Åu%m\ã/\İø§\Ä0]Kªl±L!·dÁ‰{\ì#‚O¿ô®\Î\Ú\ÖKh-m\"[Â¡GaW¼’\íƒÓ½HöûT\å}»U\nŒæ‚¸<\n]\×\0)\äV²n\\ƒƒ\éT¢Œ\ç$U•%y¥4\"ÁN\r.iVA\"\á\Ç>´Œ…O·­Pšc½3‘\Í1Ú	qo\ê:\ë÷\\Ee\ŞHúU«.³\r±·×©­=\ŞüW)ª\ß}²ñˆo\İGò§õ462˜>´_Ò“>”¹ùj!$”f“qúRd\n\0y\îi=)¥j]Àš\0p\'<T\Ñ)f\0sš€q\ëPêº´Z‡w¨\ÊAò„SüLxñ$Æ€<·â¾½ı¡¯.›Ÿ³\Ù.\Ìv.pXş\ëš\æü-bn¯„„p8\×úVM\Äó_^K3¹y¥r\Ä÷f\'¯\âzOƒ4€‚1·c$Î»hG[¾†3—C¼Ñ­EµšŒ`‘Zd\äõ\Zp:bÉÁüe9sI²¢¬„c;\Ô.3 SO.\0$\Ôq¶X±¤2C\éLc€Nq\Å+>2j&`F	S\ÙH\à”A\æ6ö/ozTŒJ\à\ã\n*\ÙÂ®OjŞ”/«3œ­¡\0I\æ˜Ã¿Zya“ŠnA\0ƒÒº‘ˆ\Ò)@ J;³I}ª\Ñ\"\í\ã“Ï­\'Z\\?Æ›\ÛóV„!>Ÿ7q\Í)SL#\áT‰­\Ï(=¦\çê…$c­(#\Ñ×i9ü*„HqÚœ[Š„6A£sŞ€&\È<¢—‚O¥Fcb>”\Ğdzf”\Ë4Á\É\ãôî¿…0£\ëR˜XŸnµ9ŸÖ¦\ä\ÅÀ¦\â>qV\ë\îÎŠ+\ä‘\êı»ı_ş=O\ßô\Ïÿ\0¢Š`8_\Ó?üz”j õ?ø÷ÿ\0ZŠ)€ÿ\0¶\ä«\Çü\n·\Åƒ?ğ*( `u‘J½¸#ı\ïşµf\Ü\ê+¥Vvÿ\0\ëQE \"ş\Öÿ\0¦ø÷ÿ\0Zšú’¸*\Ğd½ÿ\0Ö¢Š@c^_5Œ‚\ê\ÙJ6y¸5\Ğiºû\İÚ¬\0\r\Íÿ\0Ö¢Š\Ö÷4c\Õ\É\ã\Éÿ\0Ç¿úÕ‡\â]a$A%š:«o\Ë6I\Çnœu¢ŠrÙ„w1WU2¶ó?½ÿ\0Ö«ª“ÿ\0õ¨¢¹M	©0ÿ\0\ã\ßıj“ûH\'ÿ\0ÿ\0\ëQE0:5ºZG\Z\ÇÁ\\Ÿš«ArO“ÿ\0õ¨¢·[/\Û\0÷}Ú¥\ÛzG\×ıª(¦\0\×*N|¬ÀªTºÿ\0T?:( B²~\ï\ëJ&\Çğ\çñ¢Š`Kö‘ÿ\0<\Ç\çSExO\ÊPõ¢Š`\\\à üê¬’óÀ\Ç\ãE\Äg\ê·2E§¹C†aŒúf¹¿/¿J(©cB\í\ã­!ôQP1¥{\æ˜rZ( \0:ô¤\ÍS\0\Ï\ç5Iÿ\0\Ñ4\å!`#\Ìoöù4QW\r\Äö8\rKõ.3Œ°õ\ì~*–û€9\Ç\\\ÑEwCøL\ç—Äƒ\Ïùq·¯½0\ÎI\ÎŞôQ\\¦\Är\Ü¿wõ¦¬\ä/\İ÷\ëEÀi¸%1·>´	wH½U!’l|¡p>´K9õ¢Š\í\Ç4·\"ûFy\Ûú\Ğ\'\Ïğş´QZ\"D7<\à&?\Z\Z\ç„ıh¢©	ŒûY8ù?ZSr@oZ(«B]}\ßÖ˜\×_7ú±ù\ÑEZ\Óq“÷?Zˆ\Ü</\ëED²U¼Àÿ\0W\Ôz¶\Ø\ãE\ÄGöŸ›?ZO´\Ûvñõ¢Šh	\ä\áıiÿ\0j#øZ(¦¾Ñ©ú\ÓZñ•		ú\ÑE0(E/\Úy$ƒ\Û5¬5³ı_Qı\ê( ÿ\Ù',2,NULL,NULL,'1',1,'ck1232','2016-11-23 22:02:06','ck1232','2016-11-23 22:02:06','N'),(5,18,'0.jpg','ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿ\Û\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\05?\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rğbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Ú\0\0\0?\0ô\ë=^\ÃR€Oes\ÄGø\çŸO­X7	†¾R°ñ§\á\Ù\ÅŞt\ÑIœ9Wö+\Ğ×®xG\âş—¬\í5°–‡\0HO\îœı‡ñ\ãŞ²T‘n£=?\í	3ùR›¨\Ñ2z¦£DY20*yVS\ÔV&·w\å§\Ùc<Ÿ¼Ga\éJT\ãvœ¤\ì1\â-7q_´`ÿ\0ºj\Êk\r€.£úœWŸH¨¤)|1÷¥FH\çñ®Nc¯Ù¥go7Ê³#z`ƒY~(ğ]‡‰-He\Ç\Ê\àw®*\ß÷Xe-ŸPzWq\á\ï¥ÁW\r‰G\Çø½¾µ¤\'©ƒJ\èò;3ZğEı¢\Ä\í½$Œ‘^Mª\\J“brX³qŞ¾Ñ¼²¶¿¡¸]`‚+Íµÿ\0‚úFª\æKy\Zİ@Et©®¦7\Øùş\Î\én\ã¸ùûSV6´\'‘Û­z§ğRÿ\0GŠK»{¥•F0q\\€@wC ÁÏ¨«M=Œ\ÜZÜ¢®	_ó\ßÒ¥S¸cüi’Û˜œ\ãÖ€\Üv\íšb%\å²\0\Î(<Ÿq\íMF,I\è1\Å*A œ\ãÒ˜…\È\àı©1ògõ¤`\0	\ÍrNy \0\àğNzÓº)<\Ğ	9\ÉÀ£nW#?\\\Ğ!Tzğ{z\Ğ\Ë\É\0=©@\Æ	\ãQ§‘\Çoj\0–61\0W8ö©ò—*U†;b«}H\É\ê)Qü±»ø}s@ÌSLh%2F	\Íe¡;‚…\Æ1š\îb1\İ-€İı\ëV\ÒZ\ŞF’>W¸¤Ÿr\Ã8\ëR!\à{qTUú\ç t«18\à\ç8\ãƒ@ô\ë\Å*¶\ëŒúTjNŞ£­9F}\Æ(eÃ g¯^)\â>˜\ãŞ¢A€@\äı*T\'nA¦?—jpQ´\âŸş\×N;SB“\Ğ\à\Z\0\nñ\Éü)\ê9\È\ëÚ›±A\ë×µ<r¼`q@+ü§\ëÛ½L²c\å\ÆsU”ò	\íÚ¦\ÈrGL\Ò;\İ6+”ùG^H\Æ+›º²–Ùˆ\Ùò†ºÀ\ì„\ÌS¤+„\ØWŸz@q±Q~jq–C\0\'5§£<e.ø¬v-CÚ’¬óÛ¾\è¤da\ÜV•¿‹u\Ëu¡p¸\éû\ÃYh\êıH\äòi¯\Ù4¬˜Sx\ÇY¸B%\Ô&\'\ÓufM¨\\\Üs4¬\Íëš¡\Îzsš]\àsŸ­Ø•ˆÀ=84Rƒ\Æ1TaŒp}qR£•<é«\Æ\ÌpH«ğİœ“Ú°À‚wv4sdŒñ\ÏjB;M/\Ä\×\Ú{+Cp\Ês\Ó<W¥xw\â“|±_øxdSF[ŸZ»\×*y\Ğ\Òh¬4\í~\ÃT‰Z9P\ät\Íi¬Qƒ¹@¯—t\\\ØLÌ¼\äŒñ^\ç\à\ï¶¥j‚V\âš\ZgdNj¬÷{2X“ıY\Åc\\¸Šhd²^±<\Z€\İ1\ïPM&0)ˆ’Y—ƒT\Ú\æT\à\æ¬´öDqÒ¢\Ô#&¯E{»½P’\Ğu—$G©\Å1‚bz\Z_5…f\ÃrAªôr+\ÓQ;)«Ü\æª\íEH4¦%¥<\Öb;)\æ­G?l\Ò\Õ\Åp\İ)ô(¢Š\0øCQpdT^€U qÛš’g/!<jæ¤\ÜkZœ6\êKH\Ø-w&§b@ø[¯ø’Ç¶·¸2iq¯\Ï\ß2¡\í³\Ğş•\é34\Äù\ÎKn9>µ¢h¶ºœ–¶Ë€9f#–>¦µS S\È5\ÇV§3²;)S\åW{•\ÄbR	_n*O²Èª\nœÒ­\Å\ÆÀU†]¹9‰±¬Q\ÎI´\Óp\Ë0ub\íRŞŒ.@Á÷ô¬Ö™£˜ğ@\éÚ˜\á\ÏC~V\Æ\ê@—`|¤Ÿ¿ÿ\0×®œ1Ö¾tòH\îDñ»,ˆr•\ê>øˆû>\í‚_GÂ±\é(ö÷­\ãsq\ê\ÃUA6—r§¡ŒÒ¾X\ÕC«\Ü&0C““_XJdNŸ\Ş¯œüy\á[\İ#X–\ä\Ä\Ím#d0+ZoS)+£›P³.\Ó÷ˆªrÛ˜s…\È\ÍI”`M_LK\×\Ö\ÆFH+·¡\ëO\0\Ï\0\ç)n`h¤\ã\î\çƒPA\Ïb)’L\Ìü\êR@Qœô\"¡\Îd’iCw\ä\Ğ„\à3J«\ÎNpi€3’OzP\Ãôö }\Ğ\0\Ï\"z¾”Üƒ\Û\'Ş´l\Ğ!É“œtğ2q¥1X³ñÒ¤q@\Ç\Æ\Æ,t\\Er%õÈª;p‡½sI\î¹\ÊòE\0S\Õ4€¹š\îV°”•%q}+³·—\ÌıÜŒ1YZ¶C4°Œ\ãÖ)\'\Ë\×ğ5:Oõ¬ğYƒô«K»<8\Å\0]R0ü…J­´üÜœp3UQøÀ\à{T‹ós\ĞP¤`3\ÇğF;q\Îj¶\âƒnx=©\Èy\ÏAL8\r\È\éü\é7\0·Œ\à6=M\0`:\0zŸ—§Ú”>ìŒšh9\ç##Ö°=:\ĞÁ\Ã|\Ù\æ¥\Ï<sP’s\\æ¼€½øR\ÚL2Uù\ëT\ïôx\î—||\Z“p$œœ~”ø\æ(\Ù\É\ÇZ\0ä®¬¤µ|`\à{T\nÄš\î® †ú<0\Ã\Ås—ú$‘ntQ\ÈÀ ‡Á\0{T%@\'9`ƒ!ºö¦2£8¤2>½{Sƒ\r œş”\Æ´˜Á8 	$ı*A €sµ\\\Ş\Ô\å$s’8 Ñ°ÁÁ\Èö©\ÖRÈ¬\à\Ø>˜©„œ`¶Ai­\r\ÖÏ›<÷\èñ9³»\'|)5\å\è\ä{Õ»k·†dt8#¡\Í>\ÇÓ¯c¾³YÈª÷‘s^Yğ\ã\Ç\"B–—95\ë’»€:x¦4dõ£§H…Z™“HiCqN\â“m\0BnU[kT\Ê\É\'qYÚ¥«\É	h\É=+-Z\â\Î]“)ªZˆ\ë\Ú##Š2V]®µÀ\r\ØúÖŒw(\ã \æ˜#“Ö¦ëš ­“Ö®D¤Œ\Ğ\"] \Ğ¨\0Šp÷¦’B*\ÌsgƒU±š:P\àA¥ª\Ñ\ÈA\ÅX\Ü1šC>\0³€I8ú×¸ü?ğ Ğ´Ï¶\\\Æ>\İp™lQ}?Æ¸¯†\Ş\Z¦¨u+˜ÿ\0Ñ­[\åø\ß\Óğ¯h\r¶&$ã§µsW©ou4ay¨\Ï\'ô¦¶gœ“ŠH¦Ê‘\Ğ”Hr\0\êqš\ä:‹¾\Ğ\0njk\Îv\î\İ\íUÁ98jv+%±@\Æ\Ï2\Ê:ó\íX:„\Æ<Ãšº\ÎX¤`\Ö%û‡™²zq\Åi©-\èd\ê•°pÇ€j¦e³•\'†B²2°<Æ›z\áî‚¡^yõ©¡\Ï\\ñ\éVI\î>\nñ\ÌZ\ÄQ\Ø\ê#¾\nÇ\'ÿ\0^º\ÍKL¶\Õ-^˜\ÕÕ‡q_8XH\É}«À\ç#ƒ^\é\á\íu\Îo[-´!?ÎŸ2Fnty7~\\h’½Õ’´–\İpvÿ\0õ«Œ†BI\Ü0\ÃÖ¾¬¸µŠ\î®¡Ñ…yşIo¾ûIL¯%\â•môf2õG…YF\Ò~¹¬»\ËcnóW•\Ş#¶@T‚AR:V¦™¥¾·#Fƒ;FXúV¦mªHG\Êy\ç\"œ¦V®jZi±¹’02Á\ç5EA9È¦I(8\ëÓ½<óŒ‚@\é\ÅF¤÷\éõ§€{ş4\"\àñÂ—aÔ‘\íLŒ\ãò*e$;š\0hS´ªÍœ0\Çõ§/\Í\Æ?Â‘²FX\Ğ\È$÷\Å\nB)¡¶ğ}\éÁ>½x QÀ\'¯­^·•eR’t#©ªŒw\03\Û8¦†ecŒP\Z®–„v\Ï\ë!¢“kpGQ]”W\Î\Ç\Éô9ª:¾$U•\0\İ\ê;\Ò	d#Œ“š°¯\ÇÔš \Ê`˜¤ƒyúT±\Î3×Š\0¾»¹â¬z=»\Õulå³ƒOIÀü}©e\É\íR\Î[úU=\Ø##\éVÁw®3@oœ~t¹\É\íôÂ¸<âœ£\Åß‚hr2O­;,r1\éM\\\0\Í)À;^\Ô:{r=óRâ«©\èO\0S\Ã\ä;õ 	*\İ?¥YI–D*\ã\â© \\Ó‡\Èx9¤}CEdi\"Oµs³Z\Ín\Ìg¸®¾9ö\åNqœ\Z’{Hob\Ç\0úŠ\0\á\ä:úT,¼z\Öı\î\Ğ)¾¸¬‰#\0\àş´†T\İÛ¯õ§+s\ÏOJtŠTƒ\ĞS=W\Å0“´\0r?•H­“jº³jxl\0I9\Ï\áH).Î½*e“#9<vªA¸ ñš•\Ép÷ \r?Qš\Ê\å%‰Êr+\è?‡¾8‹T¶[i¤\Ä\ËÁ\×\ÍJø\äş8­]#XŸK¼I\àvR„t\ïH,}sÈ›Ók9”©\Åsşñ½¾»b±;¯šI\æºÛˆ27/\"”zRñA\\f“\0¸\ã‘T®ôˆ/‚ƒ&¯\nrœP}¢]Y¹h3P[\ê·®@F+\Ğ%1´|€kóE†ğª3\íT¥Ü–Š–š\Ú8È­û[ø\İF\Z¸‹½òÈ–@\ÅA¨­µ¡pGjv\ì#\Ó#™Z¥]­Ò¸\ÛMdœkb\ßUV\Ç\ÍÖ€6öÓ€õªq^+óU¨\æV¦Š¼\Ó\Û P˜4ö-\0xî£\Û\èzE¾n\ØFc\ï7sV\å#\ä\ã9«eFz`š‚eÛ»šò\ÛmİšVVFi\Ë1:\Ó]Ê¸\0\ç3RHÀ1\Ï ¬ö›t™Sši¶¬\ÌÅ‡Q\ÔT7W@2:s\Å(‘T¹ú{\Öd\î@ ò)¤\r’p9\ä\Ö%Ü¤nl\äsW¾B\×\éXšŒ¢(İ\Ç´HÍ³4\Ò\êI\ÍXIcœúU8\ÆrPóÎ¬PN\"€/\Ù7±y5\ëšK†P2:s^O \Ân/<ò¸U\ë^‹¥\Î#\å>µ•CXlzü \æ\\}\Üô­$š\Ø\ÈR	=T\×-mt \î \ÔMp\ÑÉ¾e=Gj#Q­2¤¨\Èñ\ÇÃ¨\ïD—új„œ²\Ãõ\ëƒ\Ğg“BK³*\å\0‚Z÷/QMB ’&\æ¿J\ÇñG‚¬õ»9\"\Å9:s]P©§‘\Ë8\ë\æ|İ¨\ê\Û\îšI9\Ç5Yö¸\ß\ã¾\ruzÿ\0\Â_Á?\î\"I\ã?t©\Åcx‡G]÷º|¢\ê\İ@­”‘“‹Fj°\'9\íS)\Ê\ç&™q@]T\àŸÊ£F8<ş\\UYG5&\ì±â¡q\êx\Ï5/\é@ \È\äŸÎ”‘¸0Zb·^9§ò\Äû\Ğ\0˜\ïŒıi€<T¥8\Îs\Æ>´(Á\àb€\0\Ï?\íR¿# óH\Ş\ÇsS`\Ï\0\ãµ\0V!”†ÁÈ«Ipd[p=qQr\Ù\â£q³}hSI©u\Æğ8\"¹–F·“¹#Š\ìâœ°!†ETÔ´ÔºˆÈ˜\r1Hv9qÓ¥N>n:ŒU9c{w(À\î¥úc\éŠ\0º#©@ŸJ¬¬r2\rI¸ƒ\Å\0Zß–ñN\çw \ÇZ®9À}jU\Æg¥\0K’\ç Œ\ê=\ŞÜ9§ı\å\Û\ĞÖ˜\Ñ2{R†9\éùSH@R¨#üÂ+ ÔŠJœEV{ç‘Š•I8\ÏZ\0s¤\ãƒü©\Ê\ì‡p\ê{Sx ‘\×\ÜQ‚\é@–E•Hp9¬\Û\í%%R\Ñ\0	\ç¥LY¶ñÁ÷©b˜†\nyı¨•¹°xÁV¾•œñ\àµ\Ş\ËoÂ°#\rŠÀ\Ô4‡ŒNTúP;Ÿ›\'¦x\â“<ı:óRK–À0\Å3’0¥\Î§©<zõ\â£À®;Ó\'¦zP2\Ìj\Ù#v6ö©Ô‚r1×µVL¹\ÅJ>Q»\ßÖ­\\º\Ño£¸¶r¤‘\ë_Dx7Ç–š\íŠ#\ÈÀa”õ¯—Õ¹p{\æµt}V\çK¼xX«¸<j\0ú\Ö@­ó\' \Ô[x®;Á>3ƒYµDw`\á\í]¹PW+\È4‡r\ÔcšyZJ\0L\\\ZšÀ ›kşµ\â«]‡(Z&Ã”\ÑKiË†A\\Æ±\áH\æH†µGe\â\ái0¶\Ô~^Á\ÏJ\ë-\îaºˆ<NH\íF¨7<¢\â\Æ\ê\ÂL:¶qR[\Ş8\ï^™w¦[İ¡ƒ&¹\rS\Ã/€q\éV¥rZ!¶¿8\0\ZÖ·¿;FMrh^\ŞB’¡R+J€@\Ó\Ö\Û\ßZ\ĞKÂ¹+yzsZq\Üüh˜e\ëU¦]\Ñ7=ªË›#©¦²„â¼£\Ô0\'À\\‘“ßš\ÌN\'<u\ïZw#9ùUŒ§8\'Š\Ñ\0\à\ÊS\äU³•*1óUõ\Â\Æ29¬Û‡/&n*‘-”\æ!S\È\èk—\Ô\ç\\„\ÎBy®†úQnäª9>µ\Æ<†Iİ¸$š¢	\Ñ\Æó\İ\ÅH»¥*÷¨€\ç\0rkA\ÑÌ²™Ê§\å\Ş4=jmi–\â\Ş\Éc\\ù‚@\í]µ¬óD/Ö¡\Ó\ìCJ\05\Ù\Ø\Û\Û\Ç\nF{\ÖgBVF%ƒt\Ì\ç(\ì\rtf‘ ;^A‚\áH6N03P2›$°<$‡\0­]\'\Äks\"\Ú\İ/—)\á\\ôj¤z`€:U+¡]\ç\å õªŒ\ÜH”–§m,d¡Ï¥e\ë\ê’\èa”g\Ë=ª\r\Ä6÷\Ì,¤”….O\Ş¥¬Á\æ\éW* \ä¡\éô®„\ÓWG+N/•Ÿ/’¦yb|d±\ÍR»±ò¿y#½X¿\r¥qbC\Ô{Ó­\î’s•Ö¶9\Ú\ÔÏŒ\íS¸|§Ş¥Y6·fôÉ«7\Öa>x@\äf¨£\ã\'=\Å2KjÀr0*PÀızUp\Ã¯j˜1\Ú2ö 	2ƒ\Çó¥([‚}) Œ\0¢„$É“À\é@\ny\àÊ—#o§\ãR\Ç\Í\ÓÖ‚ŠA\æ€!VÛ\Çoz\ï8Î\å\ãƒõ¥ò€P¼/<T‘6V± o½\É…T7\Z\0«¨\é«t›•@e\ç W/$rB\År+´V+x5Ÿ¨\Ø-\Äes×Š\0ÀI	8\ã\ĞóÒ¦V\í\Ô\Õ9­\ä\"EÇ­>9/\ËÇ½ .«Ÿc\ÍJ¦\ãøUepz\Ô\ê\Üt\é@9õò	R{ƒ\Å@œñš‘X\Ï\å@\î-ÿ\0ê§»;r3\ÇÀNxgœ\\m8\ãÖ€\Ù\Í.\â9<Š`\é\ëô¥;vö 	Qù\ã?€§†ô\è{Š…zöõ§\È\ÇLt\æ€$\Î0yoÆ”3“ü©ª\İz{P2\Ä\î\Î\r\0N²\Âôu\éV’E\ÃşµEA\İô\íR+`\à½q@¯ôx\ç\ËF0{\Z\ç\'°’\İÊ° ˜ô®\Í&\í\' óK-´W(C.N:šyñŒşÖ“‘\ÔsœWOw¢m$\Åb\\\Û4\ÊñÚF\ãoa\è=h2ÇŠ‰·s€=)ª\Ä§\'µ!b`NA9ªp1’9Et\È\ï\ëVVL‚õ\ï@:>¯q¤^%\ÄŒu½}\à¯\Û\ëvH ‚¤ò\r|Ğ¤dsœV¦­\\\é7©=¹#‘(\ëVPFGJ‹oµrñ¬\ZÕª\Ç#¨”\ÏJ\í2i€*6]\Ü\Z˜¯4\Ò(X\Ñb\Ôm˜ù»\Z\à£ñN¥\à­HAq¹­I\àœñ^¯Š\Ãñ\'†mµ»\'\ãº*“\èÀ\×ğ÷Œ´ıvd•C‘Òº2E\ç\r|¸öZŸ„u¯%^Ao‘«\Ô<3ñ®\Ë{ó\í¸\Ğ\ã\ØW\îw:Ÿ‡\à»RÊ¿5q÷š]Íƒ“‚V½\n\Êş\Şú’	>\â\Ö+”*\êi)X\Z¹\çv·8À$Ö´Sj}O\ÃeX\ÉJ\Ëm»\ì}\ÅZw$­+*Éõ\ëÖ£k\ëÁíš©q1d$qƒU¼òA9¯)#\Ô\"ŸFÁªr¿BG\èšlJ\Ä\çŞ©\Ï+’6\0\êkD&\ÇM/Í…8\Ç=*…\ÎA\ÜÁóOf\Ë\ÔU[Û\r» \ç>\Õd6s¾$¾\ÄB\ÙÜ{V-¤{ò1\Èæ¤”I|ó„÷\íZ+o\å/\Ê=²*‰;&\ácA—sùW¡\Ø\Ú-´\nŠ¸\n1X¾\Z°\n¦\é€\É\ás\ØWF~ğs\ïYN]µ8õ\0\Ûcƒ\ëR©\Â\r®@ú\Õy_\èsP\Ë8A\ê+3Cn\ÃPŸq“Z­\Ãfc\å°\í\\Œs¬w3\ØT\é¤_^\Ê\á\Í&†[½ñS¶E¬m“\Ü\Öp\Z†©\'\ïe›ò®\Ë\Ã\ĞÄ˜‘=ò+b+h@pi\Ñ\Í\éš4ö³¤Å™eS•q^¥\ê\"ú*pl`\ï{\×:\ÒB„\0ÿ\0†j«j	VHd\åOU\Âvfu!ÎŒoˆ\r\ÍÑ“S\Ò\Ó÷\İ^1ü_ızñ\Ù#–\Úá¢–6I\à†\"¾©\ÒuXuk\\‚7?­r>7øuk­\Ä÷vj\"»¨{\ë]Ÿ\ÜqJ:\Ù\îxµ£@ñ\ïP\ßi\Øù\Ñxö«RY\\\éWOkwG\"†¬[H±\ÔV\ÆMğR¤ƒ‘\ÏCS)ô?zÖ¦©c¹7Æ¸\ãµb\0S\å<SmX\äñÚŞ£§_j†6$Ô¸$c½$8©Xv\Ú*$OÀ\ÓÁ\"€¨f9\Å7€ySŒ™c·¨\ÏB9\ÆhÀ†\ïiø°8?Î¢Q\Ğ\ç\éRnÀ”\0\ì9\ÍvœE \Ï\\\ĞX“\Æ1ßŠ\0§©\é‰p…\ĞGj\å\ä‰\ár®0\àWp‘\ÏCÖ³õ-1fŒ²¨\Î2(›ILsõ«)  Ê¨\Í\ÛÍµÁ¶jX\Ü}!—QƒsÁ©\ÔãœŒš¦“š°¤\0	\ëŞ€\'{Ş”ô }\ïL\Ô\'ğOøS•³\ê{P\ë÷	ó@#ojbğMZK•°9÷£v%~´\ã1ù„\Ó;\çÿ\0\Õ@\nƒ“\Û\Õ.v\ÍC\Ó\Ğ\â•_#®O®(\ÆA\ëqH:Ç·\Å\åNzûÒ€\İ;v ı\Şs–¦W\ÇN½ª\È {s\Å8\ç#š\0·¸8¹Zò\Æ9Ğ£(9 >Á9\ÍMøQ×\Ô\ånô\ãù¡ù‡·QYoDp\ëØ¯A!_${\æ«\Ü\Ù[Î¸š%\'®i\Âco}©ÃŒ@º¿\áwA&G\\\ZÉ’\Ü!!²¸\í@¤„1\ãµN\ê:€ \0?…O«\Èûƒ*\0\Ò\Ó5‹*\î;‹iJ²œı}«\Üüñ\ßU·H.X$Ã‚\rx\"Ú„O™Á\æ–\Öi­nh\\\ÆÀö4®\á&@\Èr¥/¼ŸÁ^?Šp–·R À\ä×¨\Û]G<a\Ô\äi>1OQMS—\Ãñ†\íõ›c˜Ç˜9\ä:™q¤\Ş4R£x>µ\ïÀX>\"ğ\ì\Z½³|Ÿ¼ªŒ¬›x{\ÅWšLË‰Ç„×®\è>*´Õ¢P\\,˜\èMxn§¦O¥\\´R¡ğqO°½\Ò@ñ>\Ò=\rSW%Hp\ËØƒTnô\Èn¹\Ú3\\/†ür\ÙH.\É#¦k\Ğm¯!ºŒ<N>õš(ò»•m»1p*d.n\Ïm÷²f…£R\Çó¯=‰pJd\ã&³Ü§ô«W~õº~uLÉ¹±Z¢\Ó\'>¤kZ‘§U·Œ\íS÷ ­y \Î\0ô®ji\Ì÷\rœ`gƒÚ™!HŠF\Z³>|¢0¤d\â£_”~§¤\Ã\æ\Ü\ÚN:P4®\Ö‚\ÕG\Ê\0\Î)%™#\ë\é‘O\Ã,JGRH\È Iô¬YºIÌƒgO°7“ù\ÇNjˆ\í[öº^@^:\Òc5l´ûKcÀ\ëW¼\è¢\èT\ÖQ”c–$zš«,\Êù<\Ò^]C$\í\Ç\çU\'¹–D\Îp\ÃŞ³DÁğ¤œız\Ó\ÖEQ‚z\Ò³6N\ì“\ëU%˜ğC±®\ÈQ‹*¤ö\ê*›\Â\ã-O\\”À~®K§\\­\Ä[•\ävjõ=X¶Ö¬VxH\İ\ÑÓºšñ\ÙUN\Æzw«ZF«>|.-¤${0÷­!.S*”\Ô×™\è>,ğu¿jÍ³mÀ+¢¼KQ\Ñ\ïtÖ‚\åù__BhúÕ®·j%·q¼3\ÕMQñ†­u«WI£C]1¶\Ø\ãq¾s\Ä\íe@´ú\Õ-SD\Â\0a\ÔVü¾¼\Ğõ\'Yci-\Ó\'xÎ¹»\ï$Z‹°9N?\Z\İ4õFm5¹…‡…ˆq‚J‘e\Î1ZsE£\Ú\"<H±\Ù.F0}jˆ-\ÆÜŒ=\êL\äH\ÍW\Ë\éR³œ€\01œÆœ@võ¡\ã5!!³1H\àƒÛšsƒ\é@‡šCò\ç<œu !\ê*EPüµ	\èrj@\Øn8\â€G<õõ\íMvp;R+s‚9úSŒy8ü¨şÀN¤¨õô®rHš\Ør1\íÖ»}„p\ê1Yšš%BÀ\Ğ6F\ìjtpF3õ\æ©Hm!GSR\Æüõ¤2\ê±\Î}}{T©’Ã®=*¨—=	÷©Qğƒ“ŠYV\Ç§“\0$öª¤’p*6\ÖÁ$ŒP‘$»1Ÿ—¿\Ş[\Ç4\Ğ\Ìx~4\ì6y<ö ”}ı©¬ö84\ã óŞ—;€\æ€­\É£×¥=C$f£:b…|`g4*\î\êxæŸ»¡õ=\Å0\çŸcA\è0õ 	8Ï¸¥\äŒg¥D\Ì\Ã\Ó>\Õ\"\à’	 n\Ú\0\İÁ«)2²mo ªm\ÏN\r\nHNz\Ğ®¢Ş»Q\ÈZ\çom&V\ã\'\ë ß:\ÒH©/½h\ÌE\çù‡J¸Ó¤Iz·u§•Rñ“úV\Ìsùò­ &šõŸ3Ÿjlo#I\ÆjP\0\ã\æ\'ŠÒ·²šé€H¾(=¼‹$d«)\ê;Wªø#\Ç2–÷o\Ï@I\ë\\ö1‰\ä±<¨D2[\È+œg¥!\Øú\Î\ê;¨•ÑU\å¯ğW\Ş	\Òñ¸\à5\ì¶W‘\İ\Â6cµ.b”R\nZ\0\Å\×ü=o«Û¶Poƒõ\äú–•>“t\ÑÈ½ø>¢½\ĞVN¹¡AªÛ°dûUE\Ø\"³$Ò»Uº²\\ob¸\éX7:L\Úe\ÉI\å\ÏZÑ´a\ãT	\Ó\ÍƒŒu¬mM\Õ-\Î\Ü\äúT+3û\Ç5_S™UB±Á\Åy‰]…\ÌyŠ’sŠ¥’\Üu\ÇzY\\¶væ¤†&ò÷`c¯5²Fm™÷’ˆ­¤rH\n¿`[\á\Ô\ç&´¼E.\Ø2~f\éô¬‹r1\è)|¸(\ã<s\Ítš$YQ\Îz\×5j†G\ãøz{\×U¤J¡¼¾¤Z™lTw5Ù€\èz\Ô!X\åºóS\ì\É\Î1\íM?!ŒÚ±6%¶ˆ<Š¤ô­·Ë‡=út¬\í.$û¹Àõ­\çP\Ê>N1\éIŒ\Â2È¤©\àö¨‰\Şqß¹\ïZ\Ò\Ún9\à¨½«\Zú\âB9³øĞ“z!6–\ã]³\Ç¦*«\ÜJ†\ÇJµƒ©Ç½C%\ÓM–#\ïZ{)ö\'\ÚÇ¹<·N$R§§Z>\Û( Â¨†dun“\Å[VIsùş9-\Ğ\Ô\âúûGœ~a\Î;\Ó<±œ®M8\Î:ûÔ¨JT0\í\ëJÃ¸û\rJ}\"\å.me(\ë÷”ô#¸5\ëZ&±o®iñ\Ü\Ä@|a\Ó<©¯ ¼Œ°\Ë=;Sô‹û\íP[«&\È\èñ“\ÃCWc:\æ^g¯\êV	sj\èQIn„•\äú\çÁô¾y­\ÃÃ¸\ä\È5\ê\Z.»o®\Øù±©I$g¨?\áZLüÖªMjkt’<_JøOwió0^0@\â¹\ïøN\ëM»q\ÃzñÖ¾‚X\Är8õ9¯2øpb\ÖaQ‚½i\n’r³\áhy¢|0\ÚE=[q\ÏLWK¨\è­$M4k2}\ëœh\Ìm‚5¹\Î=˜Ç§sK\ÏsŠ„dv5\"0\è	0ò2}\é\ÅNFsÒš¬{u§©?J@1‰N0(\É\Æx\Í8®\ã¸Rmó=±L\æå¥X1ø\äUS… c¢œ \î\Í\0Xİ‘~ô4[“#¯ó¨Ğ’NZ˜\î™ }GMY `Š\æfŠKy\0lñ\Ğ\×x\Ês¿¥dj:j\Ì\r 9\è¤İ‚zµa$%p\æ©\É–\ÎÁ‡§¡\Êd\ãÒU8\'Š•N5Q[¿H\Ğ;R\Ürm\Î/j•I*FF*˜ƒ‚¥M\Ç^”À°H\í\Å/J`b2GOJz±+–^´\09\r\ÏR¨^N	8\éHz\ã<÷ r\ÑÓ{\Ğ¹BO\'µ8Í‘\Å5şSÁ\'\ØRFÜI 	-€\çÚ—bò9Šbò2OÖô\èzz\Ğ¸¹&“8ŸÊ‘»dz_¼G·Z\0]§±>”\Ü\ás\ÔÒ\Ì8\Å1”99 	cue95^\â\Î;…-·S‰túÒ«m8=zP;]p\ZRBƒ]4/k\n*Ç€|V` ‘\Ï\ÍNœ#D«/¡\ëR\ÊLĞFù\ÚGNõJh\à\çñ¨­!¸cû¢™Á«3ù¶«ûô*qŞ‘W3\Ú)ƒ«`Š\îü\ã),¥K[¹2½&¸†š9yW\ç\Ó=j?c}\Ü7Pi‰«ŸO\Ù]\Åy\0’6\ëV±\Íxo„|t\Út\Éot\ç\Ë\'\0“^Ñ§\ßÃ¨[¬±8lÆiÂ— P\rKH‡Pˆ«(\İ\ëŠ\ã¯4\é4ùn¸S\Ğ×¢¢qP^\Ø\År€:‚i¦4\Ï+EM\İy¬}bM\×x$…âµœ²\ä\ãµcß·˜\ÙşU\Å\r\Î\Ùlf\àyœı»\Õ\Ğ~\\\Æ9Kœı=\é\Ï)Q\Ç\âkc3œñ#n¹Š5<y¬ø\ÉU\ïO\Ö.õ\à/z†\'\Ü@Ñµ` «Ï©­\Ë`™e\ãÖ±ô\Ö‘¹OS[±\Ç\Êk9£‰’x\ÃFAÊ£xØ\0\Æj!ŠR½CqZ-Á\çô¬^†\È\İ\ÒmF7`\ç½h\É§N{óY\Ú<ÀDw’xÁ«\ì\î\í÷r*@„\"° ‚+•Ö¬s.ñ½Mu»O¡\íT5A4dÒ´¥>I\\Š‘æv\×G‚\æ-\â˜}\å\Ç\"§M1ƒ\ç0Áé¢¨J\Ò[\ÊJŒ§ƒ]‡<JÖ“Àoõ‘ÿ\0U®\É\ÊkTô9b ôkS6M\Ø\ç÷\å[dU7\ÑÙ°\ÂTN\'‘^¹sog¬\é¼\âXe^½Áş„Wœjú5Ö‰rVVó Ÿ.^™úûÔº“·¸\ãI\Ûfgÿ\0c\İ¸U±ş\Ö? \Óï‘°@\'·\Ì+±ğ¦Ÿe¨iN\×v\âYRäƒŒ\n³\â/NÓ´™.-\à\ÄÛ‚©21\êy\ï\éš\\\Òj\í ´c.T\Ù\Ã\Í \0V€ŒqÀ\ÍWò¯w‹v\Ïûµu$¸º‘-\áF\Ú¹5Ú¯‚­…º,—]£~\×\Ï|TÅ©}’\çx\ï#‡°¼¿²—Ï%†Lr@8?Z\é\í<w,Q„\ÔmœC¯\áV?\á\r†ò^\Ş/¶\åÿ\0\âjJÅ´­.k¶¼šA\Zğ’ª\ÄğJ·\"9—r\Çü\'zT„3yñŸt\â¸/k–š¦¯[;z’0*{j„H^\Ê-\Îr]FWRğÿ\0Ÿ\Z\Ü[\àw#¸¢*+\Ş¯ğ“YÊ­©û¿Ê¢\Ö<6“\Ãö‹p7\ã8õªöŒS(ü8\í]\r•\ÉPª\Ç)[˜3\Ìn-šJ2\à\ÔòœóŠô_\èğ\Ü\Æe>~\á{\×<&J0ÛƒÖ™#\Æ\0\äŸZœÇ•\\GÓ¾}*E;q€}¹ Dø\èÒ‡¨\Æ)T€\ß_zqS\É€+¹Á?•4œ:\ÓÛƒF8¤Qœı=h\0Flg½N²daˆ\Îx¨€“\Í\"\ã“Ş€-#| s\Å!Œr2\æ›øñ\Å<60–&€2u=\'ˆ5sSE%¼˜`q\í]\ë\"nA5‹¨\é\âa»\ÒhuXq\È$m\Ôg\"¡6·s’s\éJzõ\ëHe\è\Øq\×53€0j’>:U…\É\í\Çz\0™`zñšœ7pN8ª\à€riÁ³=h\Ï~zš8\ç\Ånx§–C\Û\0¡·œ\ç­7=3ô)\ä	ü)ø0H\í@\n„`óš–3‘¿½CµO¿j\\\ã8<´7O›·ò¤-Ó°¦+d“’A¼8\ç¥\0i\È}\éT‘\É£n\å\ÎFJA\È\äûP[¤\n0H&\Ã\æ8´€ğ­\0&\â1\ëSGq\Î;\Z®3¸ôÿ\0\nS•\äµ.\Å)A*y­[«x¼Ed±,\ŞM\Ât5\ÏG)¿­]²b.»“\ëHf\rö¤O²\ê\'U\ìİ\ãDşñ,~µ\ê‘5½İª\ÚN\"Ÿp\æxcô=\Ísš—‚HóilT¯Xa…L\å¥*\ã=k¿ğg‰®t•)Ùš3½«…’\ídò\îcd|\ãik¦‹\Ëò‘I\Æh*\×=óL\Ô\à\Ôm\ÖHœG­i*d\æ¼W@\Ö&\Ó%S–¸\ÍzŞ¬A©[++\rø\äR%«\Z€b†\íN\Å#E1,nD–\á·rk&òL†ù\"®?\Ã\ï}œKiª\ÛÎ¸\èr¹¬K\ß\nø¾\ÙI6>zñHô®8Û¹\Ú\î1n$œš\ê`¨IlVl±\ëi›­:\â,z\Æk*÷R¸t#\ËÀV¤w\ÓµŠ2\î\Î0\Ø\æ¬Ù³\n\Ç\rEeÁc{wx\Ï¼­¸õ+]\éÏ§˜…\Æ<Ò½=)°F­’ùQ\î\äñĞ•¥Á\ãV*]\í!SFd•€QY3Dtú\\¦[€GOZ\İ*ep1µOz\Ì\Ñ,\Õ-÷[¦kh’\0>•”–\Æş‘i\Z[\ç¦T\ã\01\\İ–¢ğ¤ñ\ï[P\êQÊ™eÇ­fÏ¿Ö¢š5\Æ=*F¼…F@úûUi/†`Ã\Ô‡¨\ÛFû·\"±ö®y­\Ú9ƒDH# ÷­­SREŒ\Õ\r$ù²\É*\Ø\é\í]Ô¥h]œ•#y¤£\ÃÚ½Î°L–øó#?ú÷®³V±‹W\Ó\Z¢q¹$S\ĞöaTô-­#¹¹ˆIq \Ü\Ç\n;q\ëVu­z\ÛJE„\Æ\ï1\\ˆ\Ğ`õ¢;]\ìD\ì\åh\îdøV\Î\çL³¼·™HeŸğ#j/\Z\ÌF„„u/­\İU\ZÅ´’­¹„£ œ\çŠ\Æñµ¶tE\ã\0\ÌCON]¯:¹\çKªK¦\Î%ŠB“»·“\Èı+Ljº•\Ò%\í\ÏN!ÿ\0\Z\ÇF;÷º‹£x\ë^ƒ¦k~\Ó4²¦c<\Ò(2Ÿ$œŸNGJ\Í%²fò}Z&ğEœ\ÒIsq,Œ\è(\Üs\É9ş•\Æ\êt‘	\ê\î	ú(Ñµh.­>\Ñb†(Y\ÈÛ´/#‚¹Ÿkw\ê-l¢B\ç\'ü+[8À\Âü\Õ;\è†\ÙõpÀ\Åkù£`AŒXºcUb½NH©\î\î\Â-ş•M\Ú(\Ö.×‘ø¶,v·\ï8.Å£ù”ñŞ³\âFf\ãœğ=j·ü%V–z\Ó\Øq\äÛ\çJ;J\Ş>ê±„\İÎ¾-…Nül¬[\Ãö×±4\Ö\Ü\È9ù{\Ô>%\Õ\í,¬c6W*\Ï08P\á¸õW1¡x­ôûô‚r\Í‡zU®\í^\ÚFB¸#®ET\Ø\Ù\İÒ½T\Òb\Ö!ûU¶7‘\Ğsš\á\îmd·•–E#´À¯	ù¸5+¶8>€\ÔÀó\íR\0¾ù @ËŸşµG´\ç \0T\ê9\éú\Ò:€T… ŒdzDQß=²\ß)9üig9\0şt\0\ä\Æ\ê3Ú¤#}*0\à\çùÔª[ö\ë@‹*rÇJ\âI#\ÈÁ&«eˆúu§\Æ\Ä7z\0\ÇÔ´Á \'o?Ê¹‰\í\Ş\ŞV\\+\Ñ\Ş(äŒ;z\×?©\éÑœ&=)Ì£ğ­ZCœ\n¥,MŒ­ùƒONx<\Ò¢¤‘’sŸZ•pzqõªj\ìGŠ™_\0p	ô *N\àOÖ¥Ü­Œcòªë‚¼g\éTó‚h\Ğ\éxõ\Í(\0\ç#¦i±·ôâø8=\è\Ëò©*‘Nò{v£n\Õ\ì1Ò€\àœö?•J>c\È\é\È8<\nTqœry\â€&h\È\ç9­5‰\åGAøSÕ\àŸ¦)C3@¼×§§\Ğr\î”W©\àzSy\'sš\0P¹9$ıM!\Ç+šˆô\æ¡f;H\'4™1Œcş´ø\î|¹\Ã/;OJ¬$Úœu=3NŠ3÷›ƒJ\å$l\êNú†–\ï1‘õ‡e\ã\írV³ò\ã–EYe´~\à\äcñ8­KBñ¸+\Ó\Ó<Tw\ZN2Ì·8_3%H\ã¦\å\Æv-\è\Zºñ-\È\Ö5D\İ09ò£p\\a\ÓÂº;\ï–m6a4}\ĞğÀúb¼®+½K\Ãû¬®@r\åZ½Dø‡§jÌ‘jú}\ïEºC€~¾£\ëúÓ¸ši’[™\í¤ò\î‘\èF+¦\ÑõI¬\åV…ˆ\0ò)·Wb8\Óû^šÕ¿\Õ\ß\Ûò§\ëA©\"\ÒÕ€š\Æuš3\ÏšA{Ÿ¢\ë±_Äª\Çw´\Ä`\Íy]‹\Éj\êÀ\Ãõ®¾\Ó\Ä\Ö\è©Ì¨­2i¦KFf›<ğFQ“>„w«?nGfó”ı)¶“<q©l:\ã®*Yf¶\'-Q\Õk\Ïg¢f\ê3yK\æ\Å*´g¨\Íq\×\×i+0hQ‡=TW]x,\åR\×:\×!©Ûª1(ù=ğ8§&Œ†\Ú\åU\Ğ\n\å¼R\Îom•r	Nµ\Ó+\0ø>µ\Ëx¥\ÊjQ`\äâ·‹\ÔÍ¡–Q\0¿9$šÚ´!X\Ğq\\õ´\ÎTmˆ\í[º]­\Õäª¡p¾õ,q;\r6d[v%ºš\ï8ıET·Ó¥U\nOŒ\n¶¶¤cX³dEö—s…õ«p=ÑŒ,Y³¶·Ç™Ó¾kz¦¯%ğq\éIŒÀ	u#}\æü;Õˆ\ì\'v\ãr‘ù\Z\è\Ö\çOO¸7Sÿ\0´\â\\yp©úĞ“d¹X\än¼5<¥ŸnA\ë\Ü\Z©§\Ù–l\ÆøL\×x5a¢\n={U+è œ\ãb“\ï[F¥—,Œ¥¾dtúeı´\Öp«ÈŠ\êH\'ƒ8ª\ÚÇ‡SQœ\\G I6€A\èkŠ’‡&)š&pØª­®\ÍlJ‹ğ}¹ş•ª’j\Æ.\r;£\Òtm,é¶¯\ì,Íœ¯Ò©x®\Ó\Ï\Ó\"‰r3/ô5Á\'¯\âù>\Ôp8\Î[Î¦Ÿ\ÅÚŒ‘~ó÷\Ñ\ç#\r‘O\ì\Ù\"lù¹›1\îtùu)YYÅ¼g\×¥hk\".0®26úŠl>2¹·»Fû>\â:\\ŠÑ¼ø‡s,XXUır\'­Jş$i)5ğ‡¦Ë¦h°\ÛÎ€J\0\ç©5\Âx\Ì\ÊÚµ\Ş\à_ À§OñTo•% t\â5Ò²%\Õo/\İ\ä”gû\Å\ÎMjöI#»m\Ò\ä\n>c÷EI_Nò¶6=}ª;’ba.TN+N\æ\æ\r:\Íæ•–8cRI?Ò”\ÑI]jax«Y·ğ¾Œ\Æ>\Û8)\0\ÎH=\Û\è?Â¼\ŞH\Ş\×LHİ‰\å¼\ÙI9>\ÕS\Ä\Z­\ç‰5™\ïB·—ùr#AMk×¾\Ä\Í\Ë\ãQ]\Ì\ä\ÓØ’~\ë*½\Í\ì\ĞÈ³ \Ê\ç¹\éS7\É\\dµ\Ê//<wú\Õw>\nñ»\Ú\Ï7oşü\'\îšômgBƒUµûe—/Œñ\È>\â¾r´•¡”\ÄüsÁ¯QğÎ“:\Ùj\ÆÙ¸I3÷øU&\"«Y-¥*\Ãõ\0\Æ\ì\ã$õ¯N\ÖôX5\è\rõ˜R\Än\Âÿ\0½y\ÍÕ«[LU”«/n˜¦\" 9\Æ;Ó2E1O’)Á²9 \ØA>‡Òœ¤‚03\ïR\Æg\"˜Ëµ¸\ç4‚¬Nx¤\Ï9#¨©\Z2y\'LS[‚zP¡\Úp9âŸœóµk–$ñøÔ½1\Å\0L0y\Ú=\êÉ·Š\æ,g·8\ÕO0\ïO‚WŠPr@ \rcHT,0s\ÔZå¥ŠKy>`sšõY!Šò{ızW!«\éƒ\Ì+Œ‘\ß˜#‰\ËqVñ\É<š§*Im+`S\ã|®s\Ï|\Òu_õ:¶@=>•M	¯5:IŠ\0¶­ò\àt\ÅKÀŒõQ_\'¾=*T<\ä@oR03Ú—xaŒb¢\Î:Š“ €zıh\Î¦Œu\à\ZV;—9\çµ4œô4€‘H\ïÛ¸§<ã“Ê¢S\Ô\ãùÓ¹\ë\êhL‚¸#\éHFOLóÎ‘\ÌOÖˆ\ç\0‚Z†G\nÁ\Í)|©&¢]Ò·8<\ZCC¡ˆ\Ë!f\éZ3n>”Ø€8õ«Kn†Kf±‰<\n\0Öœv°ÎªF„ŸZ‡I„\Î\ÌÏ‚µtöš,Ó¸T8\É8\è+)J\Ì\İB\è\ç.|7\Ü%¼®µsw‹kz\â½e­¼E\nR—O>Ğ¦7\ÎôIüC\á‚E±ûU‹pö\Òü\È\ÃúWQauiwp²hWGJ\Ô_“§]’\"”ÿ\0²\İ3[\Ğ\Ø%<½Ş¹\íUµO\rA¨[2<*G Õª„:I—l¼M¹ş\Î\×m_O¾b^½\Ãt\"¼\ëÅ—ú…§‰\î\ÕnKF­…=¶öş•«¤\ëWbİ´­n\Ûû_NBT,\ß\ë\"\í•~´\íC\ÂÖš&\Ñu\0\æ)\Î%‡=G½i™Ê”\ãº=~\Ì*@ˆIüi\îG;r‡¯4ltU\Ú;T›\ĞÃ‰‡\ãŠó\Ã.õ h‹¨\Ü:ô\æ¹k‹\É#”\íù“Ğ\Õ\ĞjV2,L\Ö\ãx=…sR[\ËŸ5>\æš)„[cŞƒŠ\â|En©B_°\é]\ËÆ‹;¸=k…ñİªF«Œ\í\Ík©$³XWh\0dúWG¦],\0\È\êG\Ë[\î\\\0\ÅkYW\É\èEq;´¹‰0\êFhi²8\Åf\ÛHV¨\'™Œyõ5I\äŸ\æ\Ú¿Õ•‰8¨H`Xz\Ó6\Ğ\àôĞ™±*d“J°o\â…zƒ\èkk8Ç˜N=\r\'–\î„Hõ«÷™•\Z“øƒP¼zTUº»p+4À©ª\â\ßx\Î\ÒÖ»h\ÑC·÷+8`‘“\ÕO\éU\Zi²%R\Êö8™¯\Ì\Û\'YªÀ‚*¶ˆ\í7A¶»Nó¯g\Ô4›C}º1\Æ\ã\æ=qºÇ‚¦NbÑœ\î\ß}\rh\é\Ûc8\ÖOsœ‡I\Ñv†\Z„‡<\ìe\Ã<V„m¤\Ù(Œ$\ìzüÀY7^\Ô,™#Á9P¿\Ğôü‰qj\Æ)CD3\ÊL…ş‘õ\Ô8³E$Í”\Õô¤#ı\ÔóV¢Ô´›–\ØĞªd÷”úX™U‘\n¹ó¯ø\Ç4A¢!ùƒc\Ğ\ãù\Ô\ë\Ü~\éoT\ÒlV1-º©-\è+ŸºSùH©\âº&·’81µ‚\æ±$¶•¯X7Í»\Ğt¥6ï©D’Ğ—LX!·23ç½«šñµş·`\ßÙ’	6ÿ\0u½\Èõ«~,Ô†§[\ÅfT_O&Ğ¬>\êXÿ\0!ø\ÖV‹\âRõ­˜nÔœ)û¯ô?\ãZ\Û[˜9ic“··}+BMK‹“·k£ƒÇ½aÚ¹†\ì\ÄÇŒ\å~µ\ì:o«F\î=³/İ•Fÿ\0Æ¼\çÄ¼\Ò1>\ß6$9óPqJ´\Ì\ìU,K\'¥D}i©\"\É²“ô»±É¦\"¥\ì9@0G\\T\Ö\Óy‘eOÌ½jV@\ÊrPk9siu´Ÿ”š`z§<~tgK\rJOôg!c‘º¯±ö¯E\×ü=³hol‘K\ã$(\ÎG­|\Íu7>ü«Ò½_\á‡\Äi-f‡C\ÔØ˜I\Äı\Ïc\íM1\ÜZ5¼»]pG	À g‘^«\â_\n%ü&ö\Í0\äe\×=}\ÅyÍ«\ÛJU×iˆ„1È©	‚=\ê\0¤‘Ru\éÒ€A‹\ÏÈ©±ŒÂ‚ òzPs\é\Óğ¥Q¸\Õ+¢ßŠŒ¡\ëLDŠƒ\'\'ŸJwSµv\à“ÿ\0Ö©\É~t,2´G\0j¼šdW±—cœúu=¿Zµ¹0\Ê\nœJC9moC1;)Lúu®RX\Ş\Ü\í \ã<\nõ\Ûø\Òö@\í\ìk‰Õ´²K‚¤7®)4\çc|ú\çŞ§F?•R–6†B®¤zqŠ•%\ãÒ\Ë\ê\Äö\íSòõÏ½SF\ã¥N²½ø\ÒÀ;»ı*M\Ù\\vö¨2A\ë\Ïzz7<ôşT*‘»®;ƒ\Ğcğ¦0Á\ãšpb8\Ç\Ë\ë@1‘\èisú\Ğ-\è(=9l‘@\rf\Éwñ¨Ì§~´oüOjˆn’Pƒ¤P1\Èò…E\éÖ´V\ÓÉˆ`rzÖ†Ÿ§¬1‡eù±W™~JóÖ¥³H£`\n¿k\"\ÌÀ1EKqn·?AY+6\"Fo]µ/SH»3°±°•§[5\ÜÀğŸŞ¯K\Ò5\r;qo-\ÒEr\02¬¿!\'\Ğgµy†®Ca\"o•	`œô®š\îK=^<Ê£fŸş½b\Õ\ÏV•Ô‚qgQ}.›&I¼µ\'9\Ì_ñª0Á\n«H&BzaÁ¼úóB¸‹-ù‹Ÿ^k-\Ä?+\ïñ<¯¸<-ºÁ6P\Ãó\ÜÃ¸òr\à\Z\ÉÕµ\Í>\ÊÎ\'`‡<×˜<²7H\Ù÷&“q\Üwx\ÏZ«°\êú²ô.¨Í·’I9«;v67+\'L*„L>ö:¶\àŠgE•¬{\'œT¯#Ò‰Z¢\Ãtö\ëH3†UqœUQJ\Û$‘¯|\×)Àejp\Ü\ÃÍ¾ı‡¾k)É—g;…t’Ú»¨¹1€3Y\Ú\\‰\n\ËI\èqM›$(b%I¯=\Ö$V\Ö\Øc…À\â½ü5´$\ã=+\Ì$“\Ï\Ôf÷sŠ\Ö™\áÀlv­»5©ƒX°\àã•¿§\Æ©^˜É¦ÄµC°tTD;I\Ç_z²¬¼`qN!ÛŒ\çõ¬\ÒOr\ä\ÚØ…\"Ş¹n«#O’Hò§w±\íR\Û[‰CZp…ŒmR3†ªñ[\"-\'¹š}\ÄJ$\Û\Ç~)\Ë\îÁ^}\Åm¼Ñ¢€\Ø{\ZÍ–ıRp„\0=h\æ“E\n’c\ëŠ\ÕÑ¬\Z÷PDZ$;¤Á\è}ê¥•¬÷\×~L\030\Ê\ä€\ç]æ“¤®—c±¶´\ÍËº\Ğ{UÓ¦Û»3©UEY\Ê\Ñ\Ä	l\"(\ë\ØUX]Z!)\ÎXg‘Š\Í\Ö/šÿ\0RG¶b¼y—:…ª\Õ\Å\Ìvv­$®c“]GD\ëq}ñ•$\06\ç$\Ñy¢i\×P\ìxH\èGo \éTt\ã+!»6³‘;üMd­ö§®\ë\ZGqico÷¤ ¡oÏi4‡ú%ğ…±m±\\:\ÛG#õ\Ç\éP\Ã\áÛ·W\"\å£@J¯›\É|w\Çj\è2\Ö\ï\ZJñ±\\	’¾ü\ÕI<õ·1%\Ãy€c\Îp2O®{8U’9™¬o\"»e\âyê½‡©¨cğ½Å±’\êmER$RÄ¶H_\Ì\Öå¥µ­¤óØ´½f•\ÎO¯_Ö¸\ï\ë\ï|\Ïg8‡wCÀ\Å.Uó\ÊNÇŸx\Ú\Ú\â\êyuD‘\çò\ĞÆ‹ƒÖ¸]\Zù´\ë™X¡\ß*W=‰\î?Zô­_RŠ\Â4ƒh–\êc¶8½s\ÆOµp\Ş+1­\ÌQ\Â\ÒTc\'9?­wA=\rÅ—š{¬7@\ÜÚ\ácó/\Ğÿ\0C]ş›y§\ë–Å­¤Y@<,0\Éõ\äW\ÄÁ\á:“N†\â{)–ki)T\ä:jš\"\çs­|>‰·\Üiª\"sÉŒ}\ÓşÁ]\Ø\ÜX\Ì\Ğ\Ü\ÄÑ°?\Ä:×¡\è?`]¶¼¾Yû¢\î5ù\à`túÊ»¯Xxš\Ù6,s,ƒ),d}Á®\Ö\ã<8\à“U/\Õ\Z ÄÀñ]ßŠ¾\ê\Ş”¿òÛU€\ÏÖ¼ş\é\ÚK,\ç	\Ô{\Õ!\ÆU3\ëZZ\\~L-s\Æ\ãò¦Z¥\å´òˆ¢n˜õ5-¤ÌŒm\ä\ÈÁ\àÆ˜\İğ\Ë\â ‰\ãÑµYqœ,78?\İ5\Ûx·Á¿mõ%_W@½=\Å|Ò®QÁ‚½¥{\ï\Ã‰S†-V™~Ö£l3?IG÷O¿ó¦#‡¹¶{i\n:AçŠ­\É öô¯]ñ‚\ÄñµõŒyÀË \ê¿Jò‹«w·«p}\éˆi\È`N\rM¸`<\Õ@›Öœ2g§s@0\È8\äô\Òµ67…¦‘·\'4\Ä@Q»Šr“œ‚8\íN<Mtt\âOZ–4‘P}ö\Å;%Æ˜¢¸ò¨\ÍMscü9\\s\ĞúVh$ªõ¥\Ó@\ã¯qH?Y\Ñ\Ú&ed\Ãv>µ\ËIÀøe\ã5\ì7Ö‘j0\Üô=\Åp\ÚÆñ\îWÇ±¤\Ğ\Îu$pGaV#9öªoÁ&\Ò2?•>)1~µ#4QÔH\'µ=p0Tñ\ß\ëTÕ8É©•\Ï\0\Ğ€\Ø9©Q”Hæª«œ\çŸjr\É ›”>µ‚qÇ­8\È\0\É\ÍA$´\0…\Él(\ä\ÖÖ“§\â?6E\É<\Ô:>š÷,²\Ó5\Õ$\n¨£nµ&RC!‡\Ì …©\ßb©\nF*´÷‘[FW<ú\n§\Z\ËxXË˜\áıMI¢eµO´’©\ĞpOj¥¨H „\ÛY.ùœ`ù«-p\ä-­š’~è®»Jğ{YÚ‰\î— ÿ\0\rK’æ‹›<b\r\ê\íu+,\ÑE&w\0\ï€\ÇÛµ]‡\\\ÔôYE¶¡°7bFTÿ\0Ÿjô­cA]¥‚}…s+\å¹6óAÕ³}\è\å]\Ëÿ\0\Ö4”\ã-Í”*Swƒ,\èº\åÖ£\äT÷[5¨\Û\äLKnNzüµ\É\Ë\áğ²ı¯A¼{¡\Ï\Ù\ål)öVş†µ´\Ï\Ü\é—g\â6DaÇŸ\Zu¤t?QJT\Ş\ëS¦9ü3Ü»%¤ˆKFcõ=9ª‡N´f;g\0ıA®\Ù$Ğµ[sku±¬­\ÓØÆ¸/\Ío \Çj–Q+\Ü\Ü>\0bxO©¨Wl\×\ëtú–SJS\ÂJ¦¬.š\ÛO\Ï¬½~\rCAš…±ó\"Lıó\íW¯o\ã¿\Óíµ­8oT%e„qœñ\ÈõVfR\Æ\ÓODz\Ü6,‘pOµA5»Jp\ë\ÏN´š%Ô²D\Ês‘\ë\Í:\î\ås´\ä{\ã5\ÆffI§\Í\æ6#‡4Š³†\Ã3\èNj\äMp\ÌS#ô5-òlˆ³¯\İ\r\Äx²øÁa3dWÙ¨e\ÚFI®£\Æ\×&eH¡lµ\Í[0”pkx+\"%¹¥\' JÛ²™b9!º\n~‰\Ë/\Î[¸\Ó\ÃÀK}aR\áA\ê3\ìj\Ìr£ÿ\0>õŠax?6Ú’;ƒ\ÎÓj|‚\ç\ìtJ\Ï\Z†{\æ®E!¸„‚Ia\ÜVµ\àu»gŠ¿\æ<K\İA\ï3YU\Ø	q\Æk\íV9N>õ¿c\Å#¢ÈŠÀ”nõ6³w\rô)q5”W‘\Í8…Y“:±÷WğªŠs3“P\İ|=¨lrU†8\ÎAB+¦ƒÅ¿fw\"i­±…r¼©ô\È\ëø\â¸{&\ßR’;fi\"WeBÇ’=\é5{\ëI\Ò[\Ë\Z\ÈrŒN7‹­4tV>#ûR\æò\æ\İZI\Ôh\ä_•}0MX›_²¹ºˆ\ÜY\\˜\î  ·©\çœWZu˜F\æEe\ç3\ÏCN¹½šÌÑ¯˜ı\Ì``zô­TÙ“¦JOh\Øù¯V\"N\0‘J\ÒE\â-5¯E¬L\í¼\ä\Ì)Ÿ­y„w·31*»†9˜ù\ZÕµ¼ò\âU©f\ë’Oõ­9¬e\És\Ğ.5kE$v.\ØÀV8 \ê6h@3\ç=Âš\àäœ™T$A¤8\n€g5,ms lÅ–•\àsß)s‡³5¼C¯G»CiÑ\Ì\İ3\íŠó\rs\\N‚i7ºa¸O­ZñˆK,‰.v¨<}~ŸÎ¼¿R¸•\Ñcw-4¤¼„òsEœ£\Ò+Cc\Ã\æY¦¼\×.Ùœ\Ä0…¹Ë˜úV}\Èk²ù9-’MO  Ac\ZmÅ¤?\Ş5«¿¦\î*\ìCe->b¢b@BzÕ­Á›­Q˜yªç¤ƒ<Õ¼ñFhMš&\\rix3\Æz¿„¯±g?Éœ´røv>\â³AÀªJb¸Y\Ç\0iõO†>$xÆ–¿\Ù÷‚;{\×kiU\Ïû\'¿ó®w\Æ?¬µƒ-Ş<«œgh\ïş?Î¾y–\à\Ë,~Q#fpA¯Rğ\ÆmSH¹‹OÕ‘õBB‰3û\Ôü‹ñ¢Àq7^¿ğÔ³B’ƒ±N+Ÿ¼kù\Ë\Ç<ık\ì3†>!i&H\Ú•#®‘ŸF\ã^;\ãoƒ—ºbKq¦´Zõ\Ú;…\0yTy\ÈpOQS\Å3\ÛÊ²#•e9v\"³ŒSé·¯opŒ§X`Õµ;¹À<P\Ñ_ş\'C­[G£k*\ß(\Û¯\Òa\è\Úşu£\ã_¬¯¬¢ã¬ˆ?‡ÿ\0­^\àM!õMuf9ö˜•Ï«üùü+\éo\n\ê·\Z¥œ\Ñ\\G‘	\æŸ\ã\È\è}À\Ç\æ)\á\Ïk!FZ‡ {×§ø\Û\Â>\\’\ŞZGû³\É@:õ«\Ìf…â«9ô¦!\È\äzR†\ÜqŠ€qS)\×4qBp@\Îh\è1Ş¤V8\äu¤`	âªÿ\0ÊO<\ä\n\Ğ}h0\Éú\Ğ\"ea€6ş4¡\Ô7N¿¥D§sN_òir+“Œƒ\ÔU\ë\Û8o\ì\Î:õ†²ºcÒ¯Z\\Xd\å}(‡Õ´“2\ç\×\Ís¡¶l08\Ï\íút:•¯\É×®q\È5\çúÎŒ\Ğ\Ê\ÑÈ€0\è}j\Z\Í,€¶Gz°H\Îz{U9!kw!úv©#”n8\ÆGZC/+dğq\ëR«z¥RG\à…X³\Æ;P ãš·§Y5\í\Ø\'%Aô\ÍAonn§¨À<\Z\ì-!‡Lµ\rØ ‰6¢\06ŠÏ¼\Ô\Éo*ß–\ì@ª\×R]„¨w¬#j.Z“(š\Ö&ó§;¥>½ª\Ì\Í}:C\Z·\Ìp¡FKaU#\ä•T\î\İW¶xÁK£\Û&£¨F\ZúA”R?\Õñ©*\ä~ğ\é¥\í\äk%\Ù	\×\Ëÿ\0[\ÓZ\î\ÏoZ\è€“\ëX:¾©ºÀ$p uc\éşzTJ4^SQ\ÓL ®\Ú\Çş\ÃF\È1\äı:\Ö\ìz„ò.\é‘s\íOŠ:\Ä+\'	¯nrwVBL†+\çE˜£\Û<q\Ü[ÿ\0\Ï)—+ø£ğ¯Nû]³Œ0\Ûõ×°µ‘D‰´\î\ïBr‹-¸TZs\áW±™\æ\Ó\'’\Â^\Ñ\ÈÅ‘½ƒc\Ë,‰©Z>»o kwdşƒŸ\Ë5\ï·:4•`§=A¬=C\Ãı•Z!\ëª\Z?\Èôü+UQ=\ÎyQ·\Â\Ì{=F\Ç[³(¯‘²\íd\'<W%¨h:§‡.\ïFc-¤‡Ç§şµÕo«Ike©-¥\ê7+—ˆŸ@zÿ\0:Ö·\Õu‹(LwP‹¨‡X\ÎAüÆ´\ÓSzİš}™K_­ItZQ»\ËL{Tƒ\Ê+…M5·\0\0=+€ôJ‘G“\î\ì?J\Ï\×/|«V]\äŠÕ¹aEœŒJ\à¼I~[÷Jyn%v\r\â;\É\'\ÔU’‘õ\Å^Ò´ñ© tcš¬¤…\Ã.Y˜Š\ŞÑ¬.t\ï;h!eO½nİ–„%©\ZGu¥¸Û¸¦yµk¨\Å:(\'cg¡­m.\ÖZA\ì«)\Ü\Ö}\æ›oezbxÊœÔ©1´º–¤´†ò\å\ãy\í\Ø\Ö-Å‹À\ç+ƒZ‚\ÚKFI\"”<jÜ‘›…\Äv\Ç4ù_Qs.‡-—ˆ“‚qÚ®CuÓ+at9/\å\Ä	óu\"™\'‚µX\æ]°6\ÓßµZH‡&D$ r~µ¯sukBhgH\á‹ËµŒ}\à\í÷İ\è{\nÒ‹\ÃPGdM\"\Ç#7	5\rx\á>\\¥PjÒ’\Ø\ÊNİœÆŸn\ãEg`\çZ_n˜G<‚\â)#–w“cB	C\Ğmbz\à\Ü}j\"óM•f,C©\Èeª\ßg¾»9Xİ³\ß¢\Ün9%+>…›He»î™·I\ÉV~@ u> }x#\ë?j±‚\Õd’I\æc±;¤õ\Éş^\ßZ\ÛL\Õ\Ä	{Â€x\'¦sş&¢ƒÁÚšHgl”’A\ä~5q\Ø\Êv¹IÌ–g\ì:~iñ\ãÀöü—Ö¶­\ãK;6xo#exÀI-Ÿ¹n3\Çaš®|¨—y\Ç]Ã®}sM¹\ĞõÁ	Vs+}˜“Š²[LY\â•\ï?i•‰S\Ó\çòN3\î¯\í´\ëc4×†’“30Û’z\äóšmÅ¥ôk³\ËuÁ<\ç\æŸµm†=&\É<\Øıõü¨Hl\ïµM\ÃZ·_:4~3\ÈFqØƒ\ÜW\Ş\r¸\Ó5\ÃyxVk$\Ã\×…\"±¼=\âıKÃª‹‹wnm\ä?.=¿º~Ÿ­{©X\ë0B8i¢io\0ÿ\01OTF\ç†\ÆÀ\êD(v, «LC?N? ¯CñÃ¸®f7ºky3ƒ’˜ù[ü+€¾²¸\Ó\äh®\"h\ßĞ¢©;ˆÌ¾C*\ç+\ÈúS­¤ó\"R8=\êB“x5RĞ˜\î\"iˆ»×­Av \ÛİºTù*•\Ëù³‡ rh².-\Ø95©¥F!´’\ìı\ãòF¯sT¼‡º¹Kx¹s\Ğ{Ó­šH¤{i	I÷Á \r\İ#]¿\Ğ\ï\Ò÷Nº’\Şu<²¾\Äw\î~ø\Íc©ªYx„Girp¢\à«¨ş\å_<œâiõ‹¾\è^/¶3\Åq\Î\Ã),g\å?B:*ğ/ü=\Öü-9I\á’XAù$QœÂ®x?\âV·\á9–(¤769ù­e?/üÿ\0	úW¿øw\Å\Şø¥²ycİ’\ÚqÊ·±\ïøR\Îü1¢B·±D\İ{pC\Èy‡½›G\ÓSJ\Ó!´L£.\Ãø˜õ5…¤x:\ÛI\×\Ş\ê‰$·?uœùnz\àı?u”Ğ¤ñ˜\äP\Ê{\Zò¯øDE+\ÜZ(\Ú\Ìµz}õ\ÚX\Ù\É;s…§°®n\ÓUŠiş\ÅpÁ§q¸\ç£{\Z/`<2hLRF\0ö¦«×£x·Â«\Éuj¿)\ä +\Ï%…\ãr¬¸#ğª \î\Ç<\Z—i\ÇqUÓ‘“S‰H\ã€$~µ\'qÎ”\á}{S°Fn\ã\0İ‡v9©UB¯®)»¸\é\Å8Ãš9\"¥$\İñQFTŒf¥V\Ø\İiv\Îñ­\ä\ä\ÊÕ½CK‡V¶ß€>S\éYª\ÊFI«Vwnz\åO\\\Ò\Ïõ­\äx\İ0\ãõ\ÌK[\Èw¨¯`\Ö-“Q‹xaÑ±\\£§eQR\Ğ\Ó0\"“\'\Æ+B%\Î˜\Õh\ì9±Ú¶4\Û2n”†ji\ĞHD˜ù\ÏJ²\Î\Ò|òúv¡“jòOL\n«$Œ\ãE\Æ;8@&§¶µ–\âuŠ/#œq\Ï5•´·s¬Q)fcŒ^\İ\à_&“_\ßF\Z\å†QOğõ\êX\Äğ?€¢\ÒcP\ÔQ^ğŒ¢Ÿız\ïY¨cY÷÷©o` ’{P:¦¥´,\Åğ‹\Ôÿ\0õÈ³Iyq\ç\Ìp??º(¸¹}F\ã\ÌlˆTüŠ{ûŸzaTS\ØB“\ëLf\ç\"‡\àd\Z‰Ï½!‘»dúS\ío\Ä,c“&&ôşz®\ìq\ëU$<ó@+\rø;ƒd|­ØŠa·©‰\Óx—o­e\è·S¼¦Ø¡x±œÿ\0t\Õ}{\Çúw‡¡–;æ ¿)bwúÿ\0ö!\ê\Î/ÇŸ­´@º\æ™{¯¿\ì\Ó677\\\'¿µr©¬j2_O;«\Ú\Æø\Zt\î}I©5-jÿ\0]¿7z\Ã\Í#t\Üpz\Ğ¥X²u•|¹)u€ı(¹¢†šŸ@3¡9cøš®\n³€š÷0W?J½o\Ø:v\Íy\Çi\Ík÷fwOZòû‹¶¹š{§\'b\é]gŒµº½û»“ó{W\'©\Â!·†\Â 7J@$UÁ*\ÚF\ß\Ùñ]s’Iºk·º·Uf\É_J\Ô\Ó</§á¢¶oûûq†„j\ç­<\İ*ô\Ã*•\\\à\æ®\è“v(.#u¹€¯?J\éæ³\ÄZZ\Üoİ \Ã\ãœ\â³ô\ÆYc‘sü9â¦¶¹6\îY	<ö£™½„âº™ñGqbL¦õşUz\r­„aCÚ¬\Ë*^†W]¯\ëT\ÚX§·l\ÏY½\Â\ë¡\Ü[Go¢\é-va\r\'\0ä•`M«\"£Oqc?+\äg\Û4\ÛF‡W\ÓM¤Á±‚8 õ\Ë:K«<7\×Â«Ã–Q\ê\Ä\Z\èVKC‘İ½J\Z¥»Ktnu(UH]Æ¼§=[5’l¥Kƒ% ™m÷\0GIÀü«¢\Õ5{Ÿ>\r4\Æ÷€S\è3X\Z„\Z›H~Ûªy`œ\çøahl,\İ\ÜÆ¡M\ÄQÅ\Ö\âPüsù\ÕA®é‘œ}±µ¼ÿ\0Ğ³Ugğ´†b$ºŒD{\Êù\0{}jh¼)j®‚[¢ ø‚\Ô\äñJ\ì9c\ÜcøÇ°\ßMşô»?‘¨›_\Ó[%ô‚Àÿ\0zbOò©“\Ã\ÑGu‰\ZWV?º…\ïv\'û¢w¥\ÛIr–v‘y\Ã\æy<\ÂÁ}y\é\ëG3,F®¥¤M\ç\Ó\î`\İÑ£¸aüˆ©ò\ÕÁ[-rò\ŞAü7\æ/\æÆ®=ˆ½C-\â“I²\r\Çf\ìusƒ\ĞU7Ó­<„\Û»?1\Ã8\ì1\Û=O ª»\"\Ñ(\ë~!¹\Ğôk›û\Ãewq’Áf\Çñ8¯™.®¦\Ôu®®$-4òv=\É5\êõ¢t\Ûm:2ª$s£\0…\ëú\ãò¯#V\ĞÖ\î&¬[„ºP@\Âc±­§\Õn¯õµnò¤\\m1’6\ã¦+V%ÄA\ëZ\Z{!\Üs•\È\ÅQ§øo\âHµ‘ ×‘¦„qö”8ÿ\0xóú×¡\Şø{\Ãş3\ÒV\æ\ÎHfG$±F}ı\ë_<\È!\ÏSòÔñ&«\á›÷“Mºhğ~xÛ”¨\ïü\éX“\Ä\ßµ-C$q4°s‚ıu\Â\İ\æ\Õ\Îz\àûWÑø¢ø®°\Õ#\Òñ\Æ\Ó‡1\È\Ù\'ùk3\Æ_	mµh¤ŸJı\Ü\İB_\ëEÀğ\édT…¤\é‘\ïT\âùQ¥`2ÜŠ\ĞÖ´=OF™,\ïm\ÙœoÁÁª)]\\\Çnƒ$)§¤Dm\íe¿p7’<ú÷5™x­\rÀœw<šÛ¿‘U\Ò\Öõp\r¼w=\ÍgO–½\ÏJ`*0’5aŞŒq\ëT\ì\ä\Ú\Í<ƒW±\Î:ş4\0‘#\Ë2G\Zw!UTrI\ã\î\Ş\ĞN¤\Ùi0(k¹\ŞGy©ú\ä+\Îş\èy©¶© >U¡ù	4Ÿıa\Ï\â+\ß<!bnf“U™xúÿ\0şŸ\'\Ø¦\Î\Ø\ÚZEö¢€]\ÎK\äÕš+?W¾\Z}ƒÈ§÷­òF=X\Ğ?\â=IZwMß¹¶\Î}\ßÿ\0­Ò°´Kw\á®\ä;œj«z\Æ\î\í,Ğ’\İ!õ?\çš\êt\Ëe†1ÀÀTˆ¿%¿\Ú!?\ÌH¯;ñg„¤·v¸Š1´õ\0r+\Õ,¢\ÉóAÒOO[ûfC\×&;7IFNx\íB\È»xU\í¤xôô®\ã1±V>õ ‹\ã¯\'\Õ #“U¼je\'nNs@‰€\çŠNÿ\0ZH\Ø)9\æœ\ãÀ\0\Õ\\1=\Å=‰¾\'\İúÒ°\Ì|ô=\èU³\ĞÆ§B6œ\Õd;	\Í9\\“\ÏAÚ€,Gp\ë•\Ï\Ê{\Z\Ã\Õ-ö?˜95«¼z}*)\â\Æx\Î(`sA\Î@úU\ë\'	¸Èªn<›³\êV•c\äw¨e¥“ô¦\Å—R$QŒ³\neº=\ÔÁ#\Ë\àqšöOxm#şù~¨§µ!–|\àhô\Ët¿½Œ\Øe»^„Hœ(\0qPO8‰zóHc.®V(\Ï#8õ\Åq7÷­©\ÎUıOıö}~•>­©5\ì­mf0p\ì§\ï{o\çUQ/\0P!B\í\n	\Ç^´¹\Å0ó@\rcÏ½Dı)\Ç>¾\Ô\Â1Ï½\0A&@çŠ‚+y.§Gß©\ÇAV\Ä-<›Tx­l<9¦ı»P•bL…R\İY\0ı(\î…ÿ\0\ÕÍ¼E–GŒò8\'Ö¼*xÍ½Ô±H9RT…?™¯¥-\î#¼´x\Èh\ä\\©Á¯ø¤\r?[y@\Är)©Â«ys”cƒƒœ~5~7\í\ÅP^Iƒ‚¨h\\f®ÀF{\í \Ğú\")¾@7\Æ\ÊN=\r_.i tó6œ`+\Ö\ÉÒ®\î\åXT\ã=	®W\á~\æIy¬y\íæ»”(S#zš\àQºl\él£%µ\ÔwSMg,~s\Óó¬geY\ÅÁR\î\ßqó®\ë\Æ	5\Ù±¿^ª*—‡|.·\ÒoN\"¶U\ÏVª‹¶£gC\à›Ym!2³/ ¾ô\Ïøh\\³\Ü\ÛÅ’FHQŞµ´½VÕ·[<¦&€{V\Ï\Ú\Õ0¤–\ÏB9«™tFn\èò\ï\\=×—p„¯ \î+u ‡\íl\á‰\çº;³g$¹{Ew\îq\ÍVk%”~\æ\0ŸZlŠ±\ÃË®?Â›,ˆH\\\îl\ã©\×J‘2H1şÉ©JA´4©[¸_±±km,\ZT¦\Ó\à¯\Ë\ìj¥œ+k§y>\Ñ\r\Üí‡“fYÏµ[³g¶·\êw7\ÜA\Ô\Ód¹Š€³´†òa€ûp{g ®…±\Î÷eB\Ö\Z)0/3ı÷\Ç*=½f&ºk˜™IS¸¼ˆz\í\äıhº\Ó\å¹\ÔP™$<¸C“Z\ÙI7°Qh%‹`»{œ\ëR†ô\Ô\ÄÔµ’AqÀŒ\å#*Ü·÷›<\è*{K›\èt™.\å^{—\ÄK³,\Ç\Ôı;\n»o¡iêº\à	[Àü«\í\ÏZ·\æ%¬¤š…‘Œ+<y#ò4\Õú‰\Ú\Ú\Í\Ê\İ\Û\Æğ™‰»˜\æy3÷G÷Aõõü©–WWöD‹0\Î[ş\\\ç§­hO¨YFø\éN;Cj şmš¯.«i$\rğ\È\ã»I!$\éøRùúl=\îu)In\Ì\Ø\Â€~\Ãõ®[\\ñ­´w­\ç®.\'\n¾ª=ÿ\0ú\Õ9\×ômW\\‹D\Z¥®œ’£\ç\å½€œñ’?\Z³\ãƒ¶z’‘iRÊ† YWvK\äöo\çT“{t·>zñ6´\Ú\æ¯%\Ö„\r‘)\ì£ü“ø\Ö/\à\×E\â\r\ßxx-½\å»)V#\Ìƒş\Ï\ÆEn••‘›wd¥B6jÍ£d9\èy¨-şh™OnE:\"™&»NqÇ­PŸ1_+ô\rÖ®\ÅóD\äU{\ä\ßo¼T\Ğ˜ü\ë¼ğ—\ÅMG\ÃA`Ô‹_iÃŒ3~ñû$õú\Z\à }ğ+w=j­\ëy³$#§V\Å\0}c\nxO\â^‰\ç[¼S\åpH’3\è\Ê­y7ˆş^ø^\ê{\ë\Ú\â§\Ë+\ÑIıEy¶«jzN±º5Ì¶÷*À+FzûĞ­{ß†¾3i×³ÿ\0cx›Ë¶º\áE\È†_¯÷O\é@$rE#	WF9¨÷sœ\×\Òş,øY¤x’\ß\ízvÈ®\n\åYO\Êÿ\0C^\â_\ê¾\Z¹h\î\í\Ü ?\\Ju1\\	W€O5©aÚ…\Ì\Ö\È^i\ÜFŠ;’qU¤ˆM	Á\í^±ğ3Âq,ş\"¼@a¶&+\\®G\Ìß€\ã\êM0;\Í\'\ÂË¦iV:5¶<\ÕÂ´˜û\Ìyf?©ú\nô›;X¬­\"¶„b8\Ô*\Õ2\Ô\Ş\í€\Ï)Ó¹ü\Æ?z\Ö\íR€+ƒñ¬&º’PÙ‚\Çşów?\Óğ®›]¿6Vc8c±=½O\à+Î¥_¶ß¥ºsGŸsI°/hvl\Ìfq™\çš\ë\í\â\ÉXÖ³ôûq@\ã¶o\éğmS+u<\n.F‚4\n:N¢Šc2µ1o n~•\ä\Ş#ğ÷“+:&=1^\İXšÎ\ä{‚ò)§a4|ı*ym·\Ô\Ğ\Ûx\é]ˆ¼<m™£\ÈLY9b§‚3õ©\×n3EQ\rEJ²…\Æ{úSs\0Œ\æ£.«À\éPy…¸±‚7\Å\08a‡§ÖŸœ·\Å5ˆ\Æ•\0<\Ô0\ÚŠ@@¯#ŸjF\0.OÒ¡\Ş9l\ãph\ÕX¢À\æª1’P99§\ê²fr3\È\é]O€<9&µ¨\ÆZ3\å)*\Î\ãá—ƒ\àP¼\İTŠõğ*Œ\Ğ\n­aiœpF0ŠšI)&¥”†\Ë E\É85\ÊkZ£<k\ç\ï°ş\éõÿ\0õzÕkV0ş\æ\Ì\ï\Óı‘\ëşsñEƒ’rO$Ñ°\ZPJ  P\ìmSõ¤Y¹¦“ô…³Şš}hI\ë\éM\Ú\Ò0D\äÔ™/€£“\Åoi\ZXÇ)\0¼Oò¦l\í-ôû)/¯dX\á‰K»·L\é^\ã\ß\\x¿[\ÌE“N·8¶8\Èşù÷5¿ñW\Ç\ß\Û\r¡\ér\ì\Øº\Ëg‡û#õ¯>\ÒtùuµT•\'•q\Ø\\ú\án«ı¥\à¸#f&KV0œõÀ\éúU‰:xº\Óaq[%wúw\Ô~4\ß\Ùÿ\0cş\ä$\ëƒ\é¸“ùWa{\\Á$2«µ)G–V\ï©ó1ÜA©\é\ïNV\É8=\n\Üñ^–\Ú^¯ Û…“~ÿ\0\çŞ°\Êö\ëŞ \Ú\ç¯|QÕ¼½+	S<¼\í\î\ãWş\İ+\ÃrIp\Ú]Ku\'\ÛÚ²~\"h²\És§\İ}\âK8¿\×T±PIü«F\ÃÅº&·wo¦Á3[YÀ¡Q%\\=²;W\'\Ø:z“Ÿ\Şø•\ŞúKµ…ü‰\ÏOz\Ş\Òü7.Ÿjaû@ ÿ\0vµã·†U\rÇ·\'‘ğ	#ó¨“2S\Ã\Û÷2¾\îø§C¦Ig³\á3÷XñZbìŸº„Ò•óFZ!@›e\'” ù¶Ÿ ¨Œ\Òû¨[ñ­O)GEğ Œt\Æi’c¼72ÿ\0¬(ôm¬™|\ÇÙ­­\ÕùbO¶j¶\Ì7*öÆÀj×€†‘’1\ÙW©¦É­\\gyT@;°Éªw\Ú\Û.\æ•Pú±É¬yu\ÛØ•Wû3p*½£³]Éµ[¹\ÆUˆ\Øğ*œ·Lc/$\Ï(w+›\Ä<´\\ğ\0\Í7\írM!*)s‡³EÛG\Ì;QŸL`UuI¦9v8ô+š\Õ<{¢h\Ì\Ñy\ßiz\ÇS\ĞW­üP\Õõx¬v\Ø\Âx3—#\ë\ÛğTa)	\Ê(õ][[Ó´H^]E\n[“øu5\å+ø…s«\æ\ÓNg‚Ó£?Fğ\ÅMq5Ì¦Y\åy$n¬\ìI?C\ï]¤–\æ2¨\ŞÄ\Ë1f$±\ç$õ5\éşøÍ¬ø[Ë²\Ôwj:Zñ±\Û÷‘º\İş‡ô¯.\çhŠ\Ô\Ìúô\ÜxS\âfˆ÷6Ep\Ûq\"2\"{:Ÿ\çù\Zñ/|)»\Ó\ÚK1KÇœùDôú\é\\‘«jZ>¡\î™w%­\Ì}$°q\è}G±¯sğ\Æ3^‰4\ßG\ã|«v£\È\Ú\ÂO¥Kº\à‰Át\ĞÌ¬8e#\Z\å—\0¼\×\Ñş/øec­\Åö«t_0®c–>\ã\ë\ÜW…øÂº–v|ø¢$\0\ãñô¦˜ŠÖ§(U»v©e\\¡\\uª¶²~ğüB®^\ãµP-&ò\á‘\\\à¦x¨\àû¯3ucše\Ôd^‘\Ğ\ÓÒ¤X\Í\Ä\Ñ\ÛD,@\0P¶‰“ú“FV.?ˆ÷¬\İAX7ÀòkkR\Ä\"+8‡\É\0Á>­\Üşu\"	‘‡Q@¾&k^Æ²ı¯O\ãu¬§ş\é\ê\é^ó¢ø‹\Ã´\Ã\íi€ù\í¥\âXş£\Üq_$Y9IpEk\Ù\Ş\\\Ø]\Åsk3\Ã4m¹$Œá¢Àz¿>Klò_\èŒ^,\å£œü‡\é^—\áX´\è¼9c¦\èò+EbOV,;§\æ³~x\ÃT\Ôü/öıyD²yQ\İ(\æ@8,À{ñ‘\éÒ»KKne¿µ‚%–\åW|¨>ø\ê?Ÿ\ãR\ÔEaT`AN$’p)kÄš‡Ù¬ş\ÍbYò	Â\Ïô g-¯\ê¿h¸–\áT~\ê\í\ëøiš%U\Ã\ænI5û~£\Çú¨¸Öº\Û8Dqƒj^¶‡Ì‘cò­À€AUl`ò\â\ŞG\Ì\ßÊ­\Ğ0¢Š)€P@#Š(×´e»…™\0\Î=+\Éõ\İ\à‘\ÙS§^:W¼z\Z\å|I¡‹„ibQ»\ÇQM;	£Áå‰“ ¦/\Ş\Ët®›V\ÒöH\ÛWá”•†öşQ<ŒúÕˆT\n£æ¦Œc\æ=*©~0GJ‘$\Âg4”›‘Ï½#0¨ö¨‹‚8\çµD\Ò÷¹$\Ód\í^[€»Ÿz‚iÀ\ÎJ³ \èş&½X¢FóÉ1@\Ì{=\"ó[Ô’XòÜÂ¾ğ?†“A\ÒcB£\Ì#,qŞŸ\áo\Ø\è6h©ßI\ëš\ê8U\ì\0¨li\îI\'°umTZÇ‘ƒ#p‰ş{:³ªß¥¤%ÜŸEQÔŸOóÒ¹	${‰Œó³v\ì ¤1¸gv’F,\îrX÷4ğ	8\ïI\ÔûR–\Ú)\0\âH\æ¡-“Ö‘Û¼SI\ÇZ\0v\ìõ¦\İòŠB\Ü{ôµt-¦3r»ÿ\0×¦úN˜\Ò6÷¿§µq?¼~4\Ø\Ãz<˜¹e\ÅÌ¨Õ©ş\îJ\è¾!ø\Úh\ße³*u)Ôˆ—şy\ïŸó\Í|\ã$ò\\\Ì\Ò\È\Ï$ò1ff9f$õ5I!·{‰RÁ,\Ç\ë	ğ\Â\ÛD¥Ó¹5ƒ\à\ß3º\Ï*e\Ø\ç$t¯[±·[h\ÕQzu®ˆ®U~¤½Dš?³Â®‹ƒ\0ö\ëúfµYÄˆ®93U_9\ïLÒ¥\rjğ1ù\àr‡>¿JÊ¢\ê4q¿4awdnQõ\Ç_\ÓùW‘©À 79ô¯¢µ;awe,[rH\Ê\çÖ¼+\\°6Zœˆªv“¹r:YšÅŸN}dş\ëj\â¼Yğ\æ\rq\â»Ò¾\Ïc~ó8]ª\ã\ÜÖ½\ât¶¶–y5,\nó}\âe”÷-k©±…ä–@Ê°\Ï\0úW<\áË¬M#7-\Ëw_ğ“øw\Ã\â\âxô\Û\ï³(óDo\"±Q\Ü\ÆkD\Ô\ìu­*\ëb6H¹*H%OpjÄ—–÷\Ñ\ïŠTa†RskŸÒ¼=o \ê3Ï§O4V’òl\ÉÜ¿¼3\Í`\Ú6Iõ:­\Ñ/OÒ›\æ\ÄŠ³\ä\Ôz üª¤º”‰\Î\à°\ÍO0ùMw’1ŞªOt¨>ös\×:äª§dN\çı¦\Ú?­a]kw\ÎJ‰#ˆÈ Ÿ\Ì\Ñ\ÌW)\Ö\Íxœoc\Ûhª3[\ß\\‚U&Dõ\Î\ßş½qò\ê×»M\Ëş-U\'»»š/-\ï&xúliI–iY±\Ú\Æ\ÅÅ½„S=ôÿ\0ˆ.\é[ó\æ±$×´©uA§[µËŸ\â”D¯×š\Æññ\Òô+›„`²mÚ§\Ü×”Å«_Ep³}¦F`s\Ëg5½:\\\ÆS«\Ê{¼\ÚL7Šnš\á\ím‘\á+ô\ÏZô?øE<5\â_˜¬d[Ê¤	\ã\äŸO§Jğ};TMVÁ]u2\ËÄšÏ†5?JºxxÛ”z2ô5¼iF\'<ª\ÊLo>\êşw–\Ò7»²\ÎC(\Ë(÷\ëÍŠ•bAµõŸƒ¾)h~4Œiº‚-¦\Ü5¼§\äÿ\0°\ßÓ¯Ö°üwğV\ÏWY/tq\äİHQÃŸqıEjAó>Oz«­xQ\Ğ/\Z\Úşİ£qĞ‘\Ã{ƒYX8\Í0Œ\Z3\Í?  E\0H‡9©\n…$£š8e5j|w\00W¥:ÿ\0|P\Öü*Û†šV~k9\0z¡şú{W»\é7şø—¥3\ÙÈ¾v\ß\ŞZË$‡q\î2+\å^=jş—¨]\é\Ò%Õ”ò\Û\Ü\ÂÁ’H\Û¦“B=S\Æ\îô§k½5	‰yÙ—ÿ\0­^yq\Úo”d\êÁ¯eğ\'\Ç/R=7\ÅH±\Ë÷E\ê¯\È\ß\ï¯cÓ‘\ÇÒºÿ\0|5\Ñ<]dn-q\É\"\å$‰²\îÿ\0õS\åT]Á\ç~ı)úU\ËZj1P[.u~)ğ±\áÛµ¶š\Õ\Ì%°®£Š\Ä\×\áŠÑ­\â…W0.\×`>ów¦\Èw¹brÇ½7·?JD%\ãAõ¥\Æ{\ĞuÀ0İ¬Š\0\Ít>\Ò.5ıb\ÓNµ’wŸî¤ş5‘y™	şğ\äW¸üğ³Zhrx\î2³\\f;`Ã¤c«~\'ô0=:\ËF´ƒN¶Ñ  ]¿\ìñşµ\Ğ\0@\0\08\0vª¶1\á\Ş\ß~N~ƒ·ù÷«•#C\Ö4grTI\ì+Íµ\ÍIî¥’`Hy\Ø\×ûª:Ÿz\ê|Q~#…l•°d¥>‹\éøŸ\å\\U¤fşü\ÎG\î×„\Õ2`j\è¶>\\jc¹®\Ê:`ùW“Tm¡ò\ã\0˜\×Ck‘\Äy5\",QE\ÆQE\0QE\0\×Eu*\Ã Ó¨ #\Å3†¸·x\ç\ë^cwc²VWR*k\èFUu*\Ã \×-¯ø6\×TR\ê»d\ì\ËÁI\ØV<FKB¤ÿ\0*¬Sh\æ»=KÁ\ZÅ£0„	£\í\rs—>\×mşÏ\ãÒ®\èFheU\ëß½A4ë°€}«j\ÓÁ »p·–v?\á]×‡~$.³j\æ°\çn>ZM ±Áø_ÁWş\"¹G•\Z;L\ä“Õ«\Şt/Zh–i(\Ú=*ı–Ÿoa\n\Çj p*\ÃHu¨r¹VN*\í\ÔpD\ÒH\ØE\çüûúR\Ïtª…İ‚ \ä“\\¦¥¨5ô¼dB§\å^\ç\Ü\ÒW»¹’ö\à\Í\'¢.xQPö¥\ï\éM\'Š\01šc>F;S¸À¨¹À \0±\âš\ÍK‘´\×=*î™§Iw2¹³\Ó\êhM+M{™A#¼ƒÖ´üK\âx~K¹°\\\r°ÅdJ½}}c\á½*K«™8\ãR\ÌOSŠù—\Æ\Ş/¼ñn¹$ò±Kuùa‹<Fş\æ©!šÆ¯u¯\ê\×\Z•ô¦IebO ô\Ğ\n\ßğ§‡^ú\ån%N3òŒt¬\Ïh²jw(J•‰HÇ½{f…¤¥ºe@lq[\Å[V&]\Ò\ì\Ê\İTœs\Åh+\nAút¦“U¸‰\É\Ï?•T¼eFp·	øÿ\0õªu;”\Z«¨\åaKĞ¸~=;ş™¡« /\ÈFpOZó\ïioÀ»·Q¼r§\ØğÏ½z\à\ê®:š\Ê\Ö-Í©A`AË±iš?u“¦xYá±5\É\Ø0y\Çzñ}\Íõ\ÙC\ÊF\ê\ÌO`9?¯ó«_<l5½g\ìö‡Áò¡\Îs\êkSÁ?ØšKjw9k»€\ìµ%dÙ­8\İ\ØõC!A©>¸¥ÀQ÷Er–~$¸•\Ó~OñŠ\Ù7\Í»Ê«‘\Ñk‚\çe™f\â\å\"BH_ÀV\æ¤ÅˆF©.\Ş3\×$÷\æ°o$‘‰Q\Â\çR½\ÊHe\å\è?zSŸ­f=\È\É9\ã¾id¶vb	#Ş¡k3\ß\ëTŒk üm4¨wõÏ§5¡RxúRG0Có\n\Ñ\Ù\Ê|B¹h\í\ímA\áØ¹÷\Çÿ\0®¼ş»ˆ$<¶¼Œš\âk²—\ÂrUø=T}.ñ_\'\Ê~}½k´º.!Kˆ¾t#9\æ\ç \Óx_XX$û\r\Ë~\åş\á?\ÂjÙ˜·ön	¸+\"v\ë¿ğ\'Æ½CCò\ì5\í÷úx 	³™b_\âÇšÀ¹µ\Ã2•\Ë\êzÙ¥3(ı\Û}\àJ\0ú²\ëNğ\ÇÄ\í4P\È8‘:©ôa\ÔÖ¼\Ç?µ?J\ÓØ£\\Z‘HŞ¿Î¸ı\Ä\ÚÏ„õ¾\Ò/\ÈÜ½UÇ£/B+\è¯|_\Ñ<céšº\Åc¨¸\Û\å»~\êSş\Ë‡\Ø\Ğ#\å†VV\ÚÀ†¡ ‚\r}9ã¯ƒvZ\ÚIy¥\ÉùG\Şúúÿ\0:ù\ï\\ğæ¥ İ¼7\Ö\î€\å4À\É\ã\ëS¹?#7§\İ\íS¿góƒš\0kciç¡©,\Ï\Î\ÈOQP¿\0ğ{QyrƒŠ`XO\ÜÍ–\àw®\ÓÀÿ\05ŸH|©Lö\å\í%$§\Õº~•\ÅO÷Á¤YaŒñ@¯¼;\â\ÏüE\Ñ\Ê*\r\ç‰-\'t>Ç¿\ÔWx\ï\àÓ´S]\è„\ÈI‰ºŠòõ¿û6i§\Î\è`¼\Ô%NóÔ\å^±\àÏ<«\ËÂ­\êGû\ê:ıG\ëHû\rÕkk¸^)SŒ0 òyâ¾¦\×ü x\ÛOPùE\å]\Ñ\Ü\Âr\ëŠğ¯ü>\Õ|3;!i-¿†E§p1¼+\áù¼O\â+=2q+~ñÿ\0ºƒ–?—\ë_VY\ØAk\r½…´a-m\Ğ\"¨ù÷¯<ø7\áo\ìMn\é1s{\Ä@V!ş\'Ÿ¦+\Ôabdı\æ\äÿ\0…&\Õ\Äñ\Ú\Û\É4§ŠYK\\¿Šu\0³VÂ¨\ß/ô\×ò©n\Ã9mbö[\É\ß\'÷\×\r’?º½‡\å\Åi\éVB(\Ô\ĞsY:l-ur\×.:Ÿ”{WYmÆ£“Y¡§[ù’yŒ>Uşu¯QÁ†%AÛ­ITEPEPEPEPEPJ+u\0ıE3\ìĞ“ş­*\æ(ú°¨$¿A÷H \"(“Š?\nkNŠ:\ÖTº†OZ¤÷¬\ÍÁ4®3j[¼ğ+>ö\êH\í¤u8`§H^°úTw—u¦\0û\Ì\0sò__]k3\Å=\Ó4ª\r˜\0n\Ç&­cŒf¨X\âK‹\Éÿ\0¿1\Ç\á\Çô«Ù¦!#ÚšqcJN*78 8¢v\ã¥=\Ïz\Â\Å\ïg\0)+ŸÎÓ´÷¼™@…u\Íi\á\í4\Í1\ç «·`?\Ï“\Ëa\á\"[\ë\ÙV(¢\\»zÀ\çÚ¼3\Ç>0¼\×/d·¢\È*ñ«Ç¼gø?\ßn¬{tõªH\n<o?ˆ®\ä$Íœm€ñ#˜õQ\Û×­r:6•.£pó–4\ãn÷—i#8\ã\İ\êğ\ÒZÂ\é\Ó8­b„\ÍO\è\Ù[¡(¥uj\0Zb\"¢…\0R±À\Æ*Û¸XR\Ô\Ò}óI\ÔÓŸZh	£o–‡Pñ²°\È<Mˆü\ÄT‡õi\Èt\çÍŸ”NZPş,Àl9õªğ~\ëQu\Ï\Ë2\îüG\áV\ä@Ã†¹j+H´\Ï\0ğ®ˆš”\ÇP½\İöt|å¿ˆ\×y6­n\îªpFÀ¸\ß\r¤¶Ó£Š\Úñ\0c\ä•{ğ\æò\Í_µ?\Z\à©>vzâ¢‡ÀEÃ¨z\ãµjMpaT1\àT¶:\\\Ze¨[|˜\ä÷5Å«HÛˆÀ¬©FM@°\Ú9\ÍC½œ\äƒÇ­ZkUFFGaLxÙ¹<(\ïŠ\0¨òuQ×¨\ÅE$ŒªI«`¯\íRı‘$P\Ù&¨G?r’\ÊQŠ§$2…Á\æ»H4¸\æÀû5\ærT\0;\n¤\ÈgjºGö­©¶<6rŒ{\ZóıSE¿\ÑnÍ½ı»\ÂıFG=G­{kXc’¯\Ü\é\Ş\Ó<c\à\È\íµXæš5—ø‡§5\ÕF]z«©òKôõ\î+\Ò|sğ—Uğ´=¼msc’C¨\åEy\Ë+)Áœ\×A\Úhz·ö•ª\Û\Î\ß\é0Œıõ«÷6\ë<$H\Æy\ì½µ\Â\Ëe9Wq§j	¨Z	€G\Ş_CIˆ\æo\ì\ÒbŸòÍ¾\é\Íg01¿¡ŒWqh·v\åH÷+‘¸·h\ËF\ã§Ó­	Œô¯\0|j\Õ<9\å\Øj\áõ\r4p	o\Ş\Åô=Ç±ü\ë\Üdµğ¿Ä\Ü[\É\Ìn\0.£\æC\è\Ë\ëş\Zø\ã£ö­ø›TğÎ¤—\ÚU\ã\ÛÎ¾œ«F¦#ºñ\Ç\ÂK@™®,§¶\' /ğ\ë^grùD`¯P}k\é¿üc\ÑüWiz\ê\Åe¨8	‡?º˜û÷O±¤ñ\×Á\í?^…\ï4°\"¹# /ñ ™>ğRG¦•şbkw[ğ¾§\áë‡·¾·d\ÚpVªws\Å0%‘X |;T1±	\â¯Ã‰tó‘’µ@ı\ãŠnZ\ÈG\\UŒ\Z¡d\Ø\Ú=G5 G8¨_@ñÎ¹\à»\è\æ\Ón7Z¹m¬¼\Ç\'\á\ØûŠúÂ8Ğ¼{`mš1\ÉL\Ëi7?Šÿ\0Î¾]»ˆ\Él\Ù##šú\á/„•\à†¼»B·Ú’†\ä|\É\Î\ÑøõüE&q¦\è·:Uß•\æı(.V\ŞQ–»o\îıkz«X\Ã-½”QO+K*¯\Ì\ìrI«4†W¼ºK;Y.¢\ã\Ôö\æz”\Ò\Ş]yD–’V\ß!\Óø£Qü•o\İ\Ãó?=[°ü?­s\ÚM³J\æ\á\Ç\ÎçŠ‰05´\ëQ8Qú\×I¥\Ûÿ\0\ËfÂ³\ím÷ºD¢º\ĞG\Z¢ô’\ÔQE0\n(¢€\n(¢€\n(¦<¨½M\0>‚@\êj«ÜŸ\á\â«O+™_vI¶‚@\Íc\Ş\êS&@ªw:öI=k.[¹gl³RlR\\K!ù˜\Ò+¿©ª«)\ï\ÍXGV#\ÌOSM$Ÿ¥!<\Ò@Ï©¦\İI\åÂ„ôœşk;Z¹ò­®\0şvşt\Ğt¯øòW=_&®\çµVµ]–±¨ì¢¦\'Š¢E-Q·\0óJ[%½´—SAõ4\0ZZIy2ª‚W<ã¿µv¥Ÿ‡ô¹//%Hc‰7I#zR\Ù\Ù\Ûh\Ö/ut\éÆ¥\Ø\à \ï\ÍxŸŒüh\Ş-¼yp\ë\á\Û96\Ãpof\ì·s\è=\ÍR@E\ã/]k·q\Ş`\ÇI\Óm[øGO´8õş\èü{s\çò»)E¹\äs’I\ÉcÜš³wu$÷W-º\âS\ÈQŒz*À+\Â>’\æu¸¸L³8â´Š¸\Z~\rğ¾İ³H§srK\nô\è!HbTAei¤\0}j\Î{ô5mö‡À\â˜[œõ¦“\Ç4ŸCB\á‡aIæ“§CGò«H–*·\Î*\Ï_z¦x\"¬\ç\åÒ´Š%‘\Î\n´r÷ô«}Áëš…—z=\Æ)-\ä-\0\ï!\ÚkDvcƒ3\äñ)º£\É\áE~I	¦-\Üó\0’\ÈJ\ÕN\Ø\Ã±»|\Ù\Ü\Ç\Ô\Ô1\Üùó„F8\Íx­²7Q.j\'¶$\ç$e\Ñ\0Á<T\ê\ì9#ğ©HØ–\Æ\0¬ûˆ¶R:V¤·RaCX\×W’s“L$¶ò\Ë\Óo\'5«Iq=³À©Úœ’Kn‘\Â9ÁúW?>¯w\á\ë \íŸjOnµQWgJ\ZKV-’\r+\ê\Ë$%%`y©ìµ\Ä\Ö\nÖ’¸Qó\Â~úş‹ª\ØdÊµ;k©7,´\è\Íòõ5\ç\Z‡õ¯ø\â\æ\ëK¼dTÚ\Æ\àÁv±\\G¬\Ó\È\ÃÉ³ø\â÷o¨\Ïu\'Ş–Fcøšé µ9\ê½ª¼ñGAñÍ²\Ø]\íukYO\Ë\'À{ı:\×?\ãß‚–º˜’ûDQ\r\Î2c\Z¾nŠg†@ñ9VSA\Æµ{7€>9]\é~V\âR÷vœ¹\É÷şğık¦\Ç9\å\Z¾‡¢]µ­õ³\Ä\êˆuúT\Zuó\é÷;\Æv“†¢¾¿\Õ4\r|C\ÑV\â6†\â)G\Éq8>ş‡õ¯üsğ§Uğ¼\Ï41µÍ¡$‡Q’(%\Ä*\É\Ê0\È5›«işznLoŠ\ÊÑµ´—\ì\Ó\å¹ÿ\0¾MuDy‰£j@\á&,xÁ^5W8\æº]^À©3Ä ÿ\0x\â°eL\Ë\Ó•H\Ã‚½k\Ô<ñ›Vğº\Çc©‡\Ô4\Å\ãk7\ï\"\ì·¡¯,\ã¥;\î€q\Í\0}”‡\Â\ßtC5¼‘]\Æ\Ã$Œú0\ê?\Î+\Ä|wğwP\ÑZK­5Z\â×¨\ÔŸO\ç^w\á\ïj~\Õ÷K»{y—ºô#¸ö¯¢|ñ“Kñ\Z.¯ˆ¬¯\ÛŸ\İMùı\Ó\ì}hó¤RB\ÒÁ*2¸\ê¬1Š¥:í•€æ¾§ñ‡Â7^S{§†ìŒŒtoÇ½|ó\âŸj~½h\ï-To\Ç\\‹\'\Æ=T\æ¶W•ş¹¬s¶A\ï[–\ç|`u\í@¯\áÿ\0…\Û\Å(‚\Ù\Ó6‘-Á\í´vüOô\Ü \n¡cŒ\0\0\é\íş~•\Ç|3ğÀğç…’Y\Ó×¸’OUÂ¿—ó®\ê5Ø€w\î}\é\0ú«t,¬\Şb9(õ=ª\Õqş&Ô†\æU9H¾U»Rn\Èg=x\Ï{|°n$n\Ü\ç\Ô\×Cen#AÀ\àV^‘f@ó%\ä9&ºkK6UA÷GZ\Ìúu¾\Èü\Ò9nŸJ½H\0\0\00-PQ@Q@!8ú\Ò\Ó[¥\0E1b¼\n¦I«r¡uâªGZ@6°u«i™üÀ	OnÕ¿Ş‚¡†È !Iš”@®‚\ïFŠpZ?‘«\â\ÒkWÄŠq\ëR\Æ4K»Á¨ƒqK“\Æ*n2U”ƒósSd‘Tò@£{)\à\â€./\Ì\à{\Ö&¼á£•A\æI\Õö±m i# É®wP\É5ŠwH\Ò\Z¸’\Í\áB€RœŠfx§$o3„A’j„:y„j>¾\Õ\Ú\ézlZu·Ÿ1\nUw\ÜÉ¨ôM,¡Jüdg·¹¯%ø•\ãû\êÂbğ³ld8óOq\È;Ÿ\éTøû\Æ\Ï\ã-BML¸0hV¿=\å\ßg\0ş£<\Ü\×yr’”G\ä\ÚÀ›-¡\'ıZûú±\êO­M7Ù­\í—N³pÖ¶\éf\Çü|\Ê:·û£¢Ç½W\Ó\ì¥\×/\Ñ#S\ä)ã¾õi]>£Ë«_	\åB}\Ñ\è+\Øô6;+e@l\İ*®‡£G§\ÚF6\0@\ãŠ\Ü\áGJ\Óm aŠ)\Ì{Td’i	\Íö££øxªHL:\ç½¨ cß½\'ğV‰\Ä=M£j“R\ÄzóZEÉ–£÷w,¿\ß©\à\Ó.˜\Ã¢œ\á\Ï™\ä\é©^_°B­]g‡l\ÜJ79cŒ\äñ\\Ÿ‡m\Ù\Ü0\İ\Ó\æ\Çzô\íÈ…p=«Â©¦ˆõ \ÛÕš‰l61P\ÜH°€p*Ù‹OygÒ³u+Œú\Ö-¤Œ+™³ma\ïYwK½Nx5%\àhKd\ä÷ªñ\Ê\'ƒAE04‘\Äük¢—JÒ¯¬|™rëƒœdW3qj\Ò]F\èH\Æj—‹¢\Ôü6-®Rg¶•Av\\¢­+ƒ1õŸ¾¨19\Ìr@\İGoÆŸak©K/—qs21#“Jºü—™ \á:Œw­\İ9”\Û,¬r\Ì3Z¶ú™ú^&\r\ì«	x\åÀ“oe¯*¾Ğ¤‰\ZkC\æ\Ã\è9\"½n\ê\ëÏ¸c\Ã(\ã‘{¢$Å¦²\"9H\å…«jz#–£»<“\r’1ƒÒ0<ñÖº\íGFK™$\ì\×_N\Z¹›»9\ìe\Ù2z\Ú\äñ¶µ\àûñq¦]2)ûğ·1\È=\Çõ¯¤¼ñ3@ñå¨±¹	m¨8\ÃZ\Ìxs¨{ı:\×\É=/z–)\ä‚U‘«©\È*pA £<yğV\ÛQ_hcÊŸŒc£Ÿjò˜c½\Óg:v¥\Åq\nX}\á\ì{\×e\àWZsG§x›}Õ¯\n—C™#úÿ\0x~µëº§‡ü;\ã\Í-/-¤†]\ã1\Ü\Ã\Ï>şÿ\0­!<¼{\á9x\é\\®¥§›IKı\Óúö¯Rñ\'ƒ5/\r\ÎL±€ı\ÙTpk•¼´K˜X‘ƒ\í\ïHg$X“¯‡Š¿uh\Ö\Ò4.	şï¸ª%J±Š \Zœ8úÕ‘•\É1U{g©\ÏU÷E1“\à/ŒZ·…\Ş;+òoô\Ì\àF\íó\Æ?\Ù?\Ğ×¾\Å7†~\"\è\Å\âx\îc+‚G\ìGùñ¡Ê°>•\Óhúö¥¢\É¡¥\İ\ÉoqFC\ÔzQõ¤{ãƒwº,’^\é \Ïjv÷O\áW…_ñPK¨XZ\Ù,\á†9ñ#ô5\èøÏ¦ø…SN\×\ÄvW\í„\Ë³\Ç?\İ\'\Ğñ]\Ëx~M>ñ\ït\'Š;<?w õ\È\ä\ZB7‘wH[øWR\ÓUv¨µ:”µ+±gh\Ì\Î\ß*ı}k\Ï\äÎ¡¨„1\Æ~os[$\Õ739\äŒzû\Õ}\"\ËÉ‰w™¾f5œ\Ø\ZV°„Œ`s\ĞWAc“$|\ÍÉªVşlÀ‘ò/&¶h@QE0\n(¢€Œ\Ö‰üKo\á½?\Îp$¸“ˆa\Î7S\èq¶_]\'ªiab?ò\Ò\İòWşzştÆ¢\ŞÇ¨QŠ\ÏÒµ‹\rf\Ğ]i÷)<G®\ÓÊŸB:ƒõ­\nB\ZW5‘†ûÂ¥$ãŠ\Æõ\ÆqH\nn›ƒ‘M\ïR<,¼õ´\ÜP1)²B’®\Ö\0ıj)¯-­ò%™úgŸÊ¨M\â\"(\ÙÏ©\àR`Gw¡õx÷k\ZHd\ÊÈ¥M^—\\º»cÃš¡$\ÒJÙ‘‹Rj†4’i¹â”“šCH†ò\ín$\Ï!…7:\Ôÿ\0\Ï(3ù\Ö\Í\ÏË§c\ë$jÅƒ7^\"½Û“³jøV±%š(­)½I\é]ƒ¢¬¬ó®Xò ¾õ¡\æ\ás@=ÿ\0ú\Õ\ÄüVø–4¨¥\Ğti‡\Û\\m¸ú‘ı\Ğ½üª\â„Pø­ñ,\æOh3ncò]\\!ÿ\0\Çÿ\03øW%§ö-£\Ù?´\'_ô\Éÿ\0R‡Ÿ(S\Æ\ïÊ›¤\Ú6—k­:î¿œ³G\çh\ï3ı\ÔóÚª1‘\åû<%yK“\î\ÇŞ«wd\Ö5„³·N?Jõ	xn;z\0pNµ™\à¿,¬\Ò!\È9¯@·P7ÀV›hŒ›‡Ç¥BO\és“\ïQ“H <óœS~¢“¶\r-R”¾\ãñ¤\Í(\çğ­%‡N\r\İ):JG~Õ¢D18\æŸûS?\á@8#?h‘,´§<æŸ€À\Õı\n”\ã¥Y—ø>pª7÷9\Íz=£•Œg5\â¾\Ô^;¨Ğ·\Ê;W±h“‰Q	\äc8¯ªµ=joCp\ë&\Ò\"]ğ\0\ê{V]×‹´öo-¥\Ü\İ\ÅY\Ôtópxû¬;WŸk\Z:¼şK\åH$g\ä\ËInijz•­\Ã\à\ZÆ´º{{\àfø¤\àûW3®\Ú\êú]ª²$“§üõ^F=\ÅG¡\Ïwwp¡\ĞÆ¹\ã=I«P\Ò\âs\ÖÇ¨\Û[£\à=ı+ºN†}\n;{Í²€¼\Îpvc\ìğ+³‚¨9&£\Öş)\Ø\ØY˜\ÄnòÆ˜\nƒ\nOÖ”{zØ›]Ò¬l\ÈHU3Òµ¼1\à\è\î-şÕ¨\ÆD¤EH$\ç=…p>\n\×\î|W\ãKV¾ˆ›`\à•Û•\Ïaô¯~+\ÎAÁ­\é\Ò\ë#\n•z#Ç¼Kğò÷H/w¤‡¹³\Éfˆòñ\ëøW%\Üu ƒ\È\î+\è\à\Ü\àŒ\Z\ãüQ\àw}Í¦\ÛK\î»Àùı\áıElÑ…\Ï\"¸··\Ôc1Î€\Ì;W5©\è\ïen\"76\Çø€\Ë-uz›¡İ›]BÙ¢tc÷[\Üâ˜³«.nSÁU}¢I3[6,t\î+8$t9\ï^±}¢/=ƒsÉŒôj\ä5-.\ädxş\ÍtL|­V˜Ê“š\é|%\ã­oÁ÷v›rV2{ò=\Çõ®v{Imd)\"°>¾µcƒL®<ñ#\Ã\Ş=´Sˆ\à¿a‡³˜ğ\Ç\Õ\çY*ø_³Ì¼Ñeû\ÍøW\ÌP\ÜIo\"\É´n§*\ÊpA¯nøñ\Æ\â\Ù\â\Ó|N\Æx;Á÷\Ó\Ów÷¾´¬#‹\Öôw\ÃG$e&S\Æ\áŒ\Zã¤‰\Ãa‡S\Îk\ë\İg\Ã\Z´\áwm$L\Ò¥\Ä\\‚}\ëÁ|wğÿ\0R\Ğf7\r2ùh£!…g˜UˆZ”g±\ÎqO\"pÁNzj q<S\Ç ±8­+6\ßhW°¬ö\á9ëŠ¿£#\Ü\\\ŞBTu$\Ğ üğˆ\×<V/\î£-c§\í¸pòş¿•})am4Ü³LZİ˜yQÿ\0w\×õ®wÀş\Ã>µÓpÿ\0¼¸`:¹\ëùtü+±\0(\0t„:³µ{±kjTÁ\Øw«\ä…“€9&¸_jMq1H\ÉËŠ=);!”!P\ÔZC\ÌQz\é-\âÂ€&¨ivbq\î\ßZ\ètø7?˜G\Ó\ëYz\Ú!{MME@Q\\ş¯ª\î&\ÖÙ¸\è\î;û\n`.£«·˜#´|*\\w>ŸJ¯s\ã]6Á\æ¾H£\äTÿ\0–‡\ÓÚ±o/!²¶y\æ`¨ƒ&¼\ÛU\Õ%Õ¯L\Ò#\"\ç…\ãC\ĞpNL—X\Õ\îµ\İJKÛ¦ù˜ü«}µR #ŠD$Jy*N„¬%\íö‘t·še\ÃÁ2ÿ\0tõ„t#\ë^•áŠ–w…-5\Åw\'?ü³c\ïı\ß\åô¯-\ÆšX\Ñğs\ê(Šg\Óh\ë*+£+#†SGµ<Œ\×\Î\Ú‹µ¿I¶\Öo´YƒóZ\ÌI_\Ãû§\é^\Å\á\é^*O.İš\Å]\Ïm/\Ş\ÔŒ(2ph\é‹yª$w\r\Z¨\Ú8\Ü=jk\Íb\×Cos“\ÇÃ¢0%	õô®zLI4›$£s¾9\ËHÁ·r=i€ƒO¸€J¸={J\Îw–\Ìü\à²g†Ö³c4;õ£ Š\á$\0ƒš›\"i	\ÏÖšh\åÂ\æ˜Ş–2YÀ¹\'%ñZ¾ğ»@ó\ß^r\ÓH\\/·aş5wK\Ğ\Ö\îø]\Ê–‹´V_Äˆ0x?Oû\r“#j³&\"şñ\ÈV\ĞZ\Ê>$\Ç\á«g\Ò4™j’.\Ôñn§ÿ\0fôô¯\Ñ,\í\æ\Ö5M\ígòü\×2Bú“\ØU]6\Æ\ç\Äz¬²\ÜNBs5\İÔ‡;»S\Ø\æµu=N\ÅnUºì·‡º¯v>¬\İMh\"+\ëùg¸y\ä!®%\à(\Ç@\ì\0âº¯xY\æ\\\\»rI¬¿xz]Jñnf^¿tz\nö;8ì­–4\0`rEh—/¨·&Š4µ· \0)cm¶å©“¿\î\Æhvò\í1\íRQX±¦\ç?Zhbx¡sÚ©\0\à=\éA\æzS’zÕ¤K×¥.;fš3Á­R&\âğsI\ÔqE\ëš\Ñ\"@SsŠ)«D²\Ú¨\Å\ÑG\Ç×¹©!l¯Ò¤H\Î2°\É=RD§B\É&\áÁ¯¨¯Pğı\ã,Iƒ‘õ¯5µ™– Àeq\ë]n‰yµS‘·Ú¾~ª\Ğõ)½OQŠğ­²¶ÜŸJ\æu¹¡¹&E\Äm\Ü{Ô¶ú™TR[\ÜSn…¥ò³Hªu#Š\ç6H\ångšDòÁ´–¶¡\\QŸj¶ú,196ó\åsĞš’‚A\"¨\Îdkr»1È¬§Û»3Ì«Ô¶1[·\Â-˜´Š¼d±5\çÚ‹\êWOS–·\ÆU\Â.[9%¹\Ò\ru4û„“NØ‘\Âx~µz·ƒüe\â–	\\Gv(O_q\ë_<ÜYSw\n=i°\\Ik\"\Ë²:œ©W\\•Y;»Ÿ^ğÃ±r=\ëÂ¼=ñwQ±X\â\Ôa17g\Ä×­x{\ÅZ_‰m¼\Û‡˜\Ïğ\ëøU]\Ôô«-bÍ­o Yba\Æzp{W’x—À\Ú{«\×v’\0ù\ãúOzöŸ¥-&€ù®9úó†sEİ¦§tñ\Ã÷\ë>)øwi«o»\Óv\Ú\Şõ $‡ú\Zò›\ë;\İ&õ\í/\àh%SÑ‡\Ü\ZC8ıWC\ÑJ\Ì<\Ûb~W\Ç\İú\×5q£:üğ6ô=zª\Ì\nm—‡Œ\Z\Ã\Ôü8®Z\çM“cL_\Â\niæŒŒU”Œv4€°#®²Xá˜o-ü¹Gcõ¬÷ğÿ\0š\Ä\ÛL¸=‰ª¸7<}©\è2ª[\Ü½ò²B+\èOx\ÃDñ¥—\Ù\'D\å‡\Ïm)û\Ç\ÕO\ç_!\Íiw§L‘”©á—¥v\Z¤\×’\Æ\Å%OC\È4„z‡¾¤‚[\í‚A-+\Âu\"\ëK¼x.!x\ÜŒ?Zú\Â\ß\åµ\Úkû¥‡ ººÿ\0¼;ız\×[\â/h8\ÓE\Ì>K<‹˜\î\"9ò¡0>@›’ cŠõ?‚:½&µr™µ±\á28iH\ãòÒ±¼Yğ\ÏYğıøˆ@ò\Æ\ìG©À¯¡|\áø¼?\á\ë-&2‹ºW\ÄÇ–4\Äuv±\áL‡«p>•fš\0\0\00JI$X£i\áTd\Ò™­Ş‹{S8g>Â¸»7\×\Ït\ã\äS„>»|÷·^R¾S\Ğv¡al°B¨:/ó¬›»ı´D\íA\É5\ĞEŠ%AÚ¨\é°`X{-h\Ó@QXzÆ¬\"\rknß¼<;\áöú\Õ\0\İ[V\ÚZ\ÖÙ¹\è\î;{\nç§•!‰¤‘‚ªŒ’{\nq`‹’\Z\à<O¯›\éM³Ÿ!N‡ñŸğ§°’re]{Ym^÷\ä$[\Ç\Â\ßŞ³TcŸzW¹4ü\àŞ¤\éJ\Ê\Ãó\ÏZv\ìqR\éö3\ê7Imng g°÷5\Óx£M\Òôm:\Ò\Í\"ûóÁ\Çr¥ ¹\ÇHB±¨ó\Æ)\Ó*ö5‰sq,s\áXñ\ïAF\Ët\Î8«º7ˆmt8î¤¶¼\ß\Î<„@N}j\æd\Õ[”+‡#­k|;ğñ×¼H/®µ‰\Ïñ?aıh\Øõ_\r\égK\ÒJI¸›÷’“\×\'µj0\ëR\É\í\ÅB\ÇŞ¤Á»•\Ø{TN€©\ïVvı*3‘JÀb\Ïfğ“%±Çªv4\ë{\à\Çc®:ƒZN3\Û5F\î\Í&û®:0\ëR•0\ÎE]Ò­\Ò\ëR†)j1õ\ëŠ\æ\Öi¬¤7)\Ù\ÇJ¿\Ê\ÈC+t\èE\0oxû\Çv~\Òp\ì}FUÅ¼û¿\í7·ó¯š\ŞMG\Ä\Ú\æ\\½\ÕıÜI\É$ûöù\nôø*\ŞIªZ\ŞH÷¬\0d\ËÇ¡\íü«™/ƒt\É-\ÖnP‹†R\Ù\ã\í#øs\Øq]1’{\ËZÕƒxwI´Ò­B»\Î®T\å® cèƒ õ\ëY\Ú….¥¨rê§–	ÿ\0\n­¤\Å¬ß\Î\Ì\\ü\ÎyÀô¯bğş‡›j˜Pn’J\äk±¡£iq\é\Öj \rø\äÖ†y>)¹\Î1ÒŒ\ä\Ï›wÔ´G72*úš[¦\Äj¿Ö˜¤µ\Ğœ\Ón\ß\çš{w§f£Ş¤3š´†}\éÃ®i J9<V‰\Ç\âŒqIß­.sÀ­ )\r&isš\Ñ!\\LñŠN”dšCÒ­\"Y4š³¼©\ÅSˆ\á\Ç?…\\\n	­Ï…\Î\Ç8^\àö­;}r;(\Ôãš­%ªD¢4!˜OzË½´,‹c¢¼&®z±\ŞXx\Æİ—Ê¾¹8«\Í\â+W\\¬\È3\×¼šk`#|\à‘Ş£ûx·-\Ï#¶Mf\è¦\ËUZ=RO\ÚG“ç¯¾ªrø®\ÑU‰“§¿Zòİ®­‚\ÙÁ\ä\Z8\Ïÿ\0X\Óö(=«:mO\Ä\Ó\êd\Ã„õ\äıj¸û5©\Ù× 5N(³ŒJ’ö\âE…F\æ^Kg¡­R\Ñ¶Û»o¨´l\ÆOŞ­$duNAô\íXd÷aœÓ¢–Ks”lJd›`s“Ú´4ıV\ïMºK‹))P\ä:œb²m®’\äc8aÚ¬\0üi =\ÛÁÿ\0mu!²\Ë\×A7Ds\ï\èk\ÒWP\ÊAA¯””Á\ÏC\Ï5\Şø?\âUş‚\ékrMÍ–q±)ô5[ˆú8\ë\ÓÖ³5O×­\r½ü\Çğ¸\á“\èi\Ú>¹§\ë¶b\æ\Â\ád^\ëüKõ¡‚>\ï\åH\nñ/µ;\\D\rÕ†x•G+\ìÃµs±\\gp{ñ\Å},BÈ…YAa•‡ozó¯ü3†\ï}î‡ˆn:µ¹8GúznŸJ›ò«\Û+MQ1(/ğ¸\àŠ\äu=&\æÁó %ùfO\Ó5\×\ÏÍ\Ë[]@\ĞÎ‡Œ0E\àH¾\\¡Z3\ëEÀ\ã´Ù¦Œw$@0I\êGõ§[\Çomxg±+)Ä2>•©¡4R}§N8É‹±úV§kö¼Kò\îS†CÁ4\îK\ç\Å*\åU…ih0\Õü#td°›tÀ\Éo\'(ÿ\0\à}\Åp\ZN©-½É·º$8ö5\Ñ3+\0¤\å¨\èx·Cñş–\Ğ\ÉIñ‰-¦\êªÿ\0…t:F”4¨s,\ê[\ä2uE\ì¹\ïõ¯øg£¾©¬Dƒp·‡\Ê\ë\Ç Ï¹â¾€¦ ¬j\Ø\ãsÿ\0A[7­µ»\Êıg\ë^uª\Ü>£¨u9gm\Î}*d\ì´˜Z\âw¼r\Çš\ém`2H±¯~µJ\ÒŠ5U(À®‡M·ò\âó|\Í\Ó\éP†]DW §QEPˆ§I$\Ò)<·a€\Ø\Î+Œ¼³¸±›¯ğıC~5\ÜW;\ãMU4\Ü\ÌU\ZW\\J\Ã?1\ïøri§`µ\Ï3ñ_ˆ6«iö¯óŸõ®A\éõ®1A‘¼\Ï1‹±,NI<’i\êx\Å+\Ü\Ş1\åCÁÀ¥\Ï\çL$`R¨ £WI\Ög\ÒZ@ˆ²G.7£2GB Š¯¨jjwò]NÅ\ÏLğ£°\ÕO<Œi8=ñHV	[ƒ5ƒ|H¸=‡zÙ¹lEx•\Îj|~$\ĞQVFy\åHaR\Ò;P:’zWĞ\Ğ\Ã^¶²\n<\â7\ÌÃ»¿\á^eğ«\Ã\ÇT\Ö_Y¸L\ÛÙœE‘÷¤ÿ\0\ë\nö—943:¡óõ¨½HÜŸJa\é\ïRdBN~´\ÓÓš‘‡\Õ\Æ(\"ö¨˜pjV\"˜ÂÊ’¢¸*À{\ZÍ’\Ö[f\ßnI_\îV³Æª\êÖºE„º\ëb¸\İÛ²z,n«\â£\é>pPofAö«Ÿaúšò(£º\Öu\ÙiØ’\Í\êO$û\Óõ=_Pñ.¯$\Î\ß4§hPx\n:(ö\è¾\rğ¯”GLœešº©\Ó\åWfr‘­\á\r\Çen®\É\ïŸS]‰\à`v‚1\nL\02z\Ór¸%aB=8ğ0I¤@Nú\Ò\Êv\Ä\Í\ÏJC+ÛóHı*†Ì­\íS\Û`B[¦MSf/!\Ç95H/§zt¨€Á©=\ri&;\ëBóõ£84v­R!‹ÚùR2h÷­%\ë\Å!=ÿ\0Z\r\Õi!IşzÒƒ\íIV˜ªH \Õô\Ãš\ÏS\Î=jü<¨h†yEŸ‡\æx\îK)Wñ\íOŸÃ>r\ÊHtP\Äc¸\ëık¢: \n\"E-œ±dC\Ú|›ñûá°‘\é^\İsÌ¿²®ŠQ\íU¯4H\Ş2ĞŒ¨ù»f»Û0VA¹0S~µ‡s¤ˆ¥s+•F\n¼òi\ç\Ú\\\Â/0c ò*í¦–\ï·{P2	\à\Zšúú=6\ã\ÊŸGbH¬\ÍKP»\ÔdW‘\Æ\Å\0A€\áL\ß\İGhm\Ûs‚\ãœVIc¸\ägŒ\æ˜\Ün\çµ(h9\Æ{P¨\ç\0WÒ­¸\Ï«ß¡©7¨\Î)ˆ—©Ü­‚;Š¿m¨cä—ƒ\êk=H\É\'ƒ\ëK´«Pÿ\0ú\Å\à‚CAÁmu%¹\ä\îJÖŠd2˜÷”¯¢\ë÷\Ú\ê\İX\Ü<R/\\t#\Ğ×·øC\âM†¾©k|V\Öû\äü²c\Ø\×Ï§<\äJrJb!ƒsÁô§q]Ï±õ›°pß\í^\à\ïŠW:aKXµÅ˜8\Z\ê+\Ù\ì5=Z\Ín¬¦I¡qÁSúJ\0\Ïñ…´\ß[\î\â\Û0$\è0\ëş#Ú¼WÄÔ¼3q™“Î¶\'\ä¸AÁö>‡Ú¾ƒ\Ã\'\İ\äz…2h¡¼·xf%‰\Ædb)4\Ì!\ÙGø÷ªw–V÷\Ã.6I\Ù\ÇQ^³â¿†M=î„¥×’Ö„\ä÷O§Zómä™]Y]x*\Ãz\Ò\ÉjZ\\ˆ12dƒòÌ½\rK¥\Êòÿ\0£\Éş¹8¤WI\æ#Fc•r§EtŸ<	©\â\è\ï\İwYYşñÁ\è[øWó\çğ¦¬|=ğ\çü#¾‰%\\]\ÜşöoQè¿€şfº\ê*­ı\Ú\ÙÚ¼§¯E¦˜Œ\ê‹4J~Xùovô¬\r\Z\ÙÊ½Ô£÷’=…Uºv\ÔõQo¸”SºC\êk¢‚0 \0¸\0`VMİŒ¹eo\çL©;\×B\0P\0\è*¦Ÿo\äÁ¸™¹«”Ğ‚Š(¦X\Ş!ğí§ˆ¬…µ\Ñu(KG\"Tı;\Ö\ÍÀñx6\ãF—;\íHn1‘ŸC•\È\Ím$m‚C_EkÚ”\ZN‡y{q	š(£$Ä£&Oöq\ï_/[x\åg\Ô\']F\Ñ`ŠG,¡`œAH\Ú3¾\æ\àƒùæŸ‘·Œ\Z²`‚\î!-œŠ\êFx9ªŒ¬‡>´)a\ĞR\îşTÌF:š:~€Šşq«»c8\ã\ë\\¬PÍ¨\ßEg—šw€w$\Õı^ôK6\Ä9D\ï\ï]·\ÂO}¦öm~\å2‘~\î\ß#«w?…0n\Ê\ç¦x{F‡\Ã\Ú\r¶>vşó¦¯EH\ì	¨š¤\ç\ßQÖ£n”òi‡š@Fj3RS\Z€#aŞ£~˜©\ÏsLlª–<\Ô\Ğm\å\Ç“M (Ágv\è w5\â\Ş1ñ4\Ş\'Õ¼›}\Ëa)c¿ûG\Ü\ÖÏ¼[%ã¶‹a/\î÷~ø©\êGo\Ãùı*§„ü2Ò¼sJ§Ÿº\roJY2f‡ƒ¼*\Ì\èò\'\ÌyúW®Z\Û%¬\Z‚«iz|v6\à`o d\Õ\ì\ç\Õ\ÊW\ÑÓÆšœvõ§O±§ci \àb«\Ş>!Àû\Õ2·=\ê•\Ë•W=M4Ë”¶\Æ;f³Á\êkBs¶Ò¨Ç‚\ÕHC\ÔS\ÇN)1ŠP0+h¢X´¦t\çŠ_ò+TˆaŠ2(?ızBxµiÀşT†\âƒÁ«HBu\è8\Æi}j\ÒG$\Õ\Ë~Sq\Ó5jßƒÁüª‰<\Ê+\Â\Çl£w5o\íF«µşZ\Ùñƒ\×:v^¥:•®V+‰ }	\ìA\àÅ©¤‘\Î\è\Ì:¡=i\ín\Â\Üc\ï\çŞœ»f]\Ñâ¡–5˜“£şZ¿­\0P\Ôt¸®¢d‘w/\\÷\ÆjZEÖ”û\ãK|ñÂ»ñ;B\Â+…\0Œ>\ë})ò\Ú\Ç*1\îJ\0ò\í‰p\'\r\Ü\Õ\\«)\ç¯L\×W¬xm·ì²Œ£˜ık\Ş´S‚²¯¦`\ÙS»Ó­)nzS\æ‹a#\Z‚8\íL+À\æ¤W\É\0ò;œTC\0œgĞŠ3‡\È\È4cp=xâœ®\ÑH	Vô¨‘¾`Gjxuä§¸ f•µòJB\Éò¿½\\#œX`õ«6÷¯	!%{Jjƒô­\ïø¯Sğ\å\Ò\ÏcpUOß¹V„V\nJ²¦\ä`}©J\î\íŒt ¤ü\'\ã\İ3\Ä\Ñ,{\Ö\Şû4~ñÿ\0d÷®¥£\ÉÜ§kzÿ\0­|os-´‚Hİ‘\Ô\ä\ë^³\àÏ‹,]ˆ	d\è—@r?\Şõú\Ó\ë\ë\'\Ì\Æ\Ö==Ò¹¯ø\"\Ã\ÄQ™@÷ |³¨û\Ş\Ì;ız\×G\Ö÷\Ö\Ë,.“B\ã!”\ä\ZBdƒ³I·,¿\ãüş´ó®½\áGE¾×–\ì¬\Ç÷n¼¬ŸC^\ß\à¿¯‡<9oj\Ê>\Ğ\ãÌœÿ\0¶{~+j[{[\è\Ğ\ËS¢°t,\0GB*\Í+\0W\â½\\È‡*Ÿ*V®“V½û“?¼•Æ¼\ì)\Ôõ|˜`<ŸSS\'\Ğh½£Y´6şdŸ\ë%ù˜\×M§[y\Ó•y5Ÿd\à\É\é]=•¿\Ù\í\Âÿ\0\ä\Ô ,QE%PESQE†Awiõ¬–\×1	aa”÷\ä>2ø\'ò<ú+Ü‘‡º\ß\ã^\ËKM0>4¹±\×ü|ğ\ÉÉ´å£úZ\Û\ÒüQg«(†\ã÷0\İÿ\0\ZúwXĞ´\Íz\Ô\Û\êV‘Î¸Àb0\Ëô=E|\éñW\á‰ğºÃ¨i…å´‘ˆ$Œ4g\Ğ\ã¯ÖŒ¸\Ê\Â4Nc`\Ã\ëYÚ\Ï\Ù\íÊ®w\Õ\Í\èú\ÕÍ¼n¤Up£\'+}„We’@\ï\Ô\Û\Ø\Òj\Æ\ËUsN\Ó\ç\Öõ{m6\Ü$\ï·>ƒ¹ü})¥\é¶ú.•o§\ÛE\n\Ô÷5\Ä|6ğ\ä0yšì,™#\İ\Ízµ&eQ\ßA	¨y§L<ŠFcM0ô\Å8û\ni9\ëÖ\raQµ<Ÿzk@ô\äœW\ã\Ï‹Cadÿ\0\éq•=?úÿ\0şº\êuK\ÄH.wNCo–\âg<\"\Ş\äœ\0;“^u\àÿ\0\n\Üü@×®uy\"k}*\'ù‹6Iÿ\0`\ì{ß•i\İ\ê&\Ì\ÏøR\æó\Z…\Ò\â\"\ÜüdJô‹£/–\0\ÛÒ§\ÕZ+yºªE\Ú\ÕB7\ì\é]M]Î¶\Ş\í&^ \â§§5\ÌÁ9R¥I­\Û[Ÿ1y\àúTXe\Ğ5\Û\å<óHŒ\Ó3©\Í89=…T5ÒNj\Él©>¦¡˜\Îqš¤!n~\àQ\ç«7\'\'Š­\Í\\P2|f—ü)\Í/~µ¼Q›bgğ ı):\Z3Z¤Kšk9<{R)¤\â©\"CvGLQœõ¦çŒŒâ—Œrj\Ò¼\ZQ´™Œ\Òt\È\èj„9zã¥Z€Àò8ªœ\ça{\çŞ˜Œı#\Äd†\àŒt\İRk~µ\Öb76!c¸\ÆqÙ«“Ê¶3Öµ4­v{7\Ù(?Jùô\ï¹\Ş\ã\Ø\ä\î-\îô«³Ñ²2ö#­Xx\î†\n\çµzEÅ¾›\âKP%\æc\åq\ÔWŸ\ë~»\Ñg,T¼9ùd(]\ã\à\Å*‡CÚ«\â[²\î–ß¿dÿ\0\Z|Á¾Iqéš²Ñ”ù\ãl®)€‰$q6¶QXºÏ†\à\Ô¸P’ö\çW\ä¶ùŒÖ§Ë—«Gü/ş¥´¿ß˜¤%n¢€<\Òò\Ö\ëL˜\Åt„¨û¯\ëP´a”2\ç\Ğ×©\ßi°^\Û2HŠ\êGC\\§\áû4´öÀ¼?\İ\î)\Ü2‘–´»˜©\È\æ§\r«\×\İj\'B8\çµ1\à›­=}qŠ=3\ÛÖ—\î8 	³ı\îiÄ’1Á\Í@	 \ĞS•³\Èü¨2K$\Z2s\ÜVµ\ê\Î9[\Ğ\Ö^r4\Ò9Ú€7\Èß\ÔÑ•<t\Íg\Ú\Ş\ì\"9úv5£„*y\ÔøK\ÇZŸ…\ç\ÄO\æ\Úó@\ßwÿ\0¬k\İü3\â\í/\Å¢K9B\Î\ÏŸ™\ÄW\Ë\ê¼z\Õ\ë_|4KO\â”!1[ƒ\Üÿ\0ş”\Äz\é¶\Ä\âh˜\Æ\Äü\à«q\ë\ïü\ê\É8=)\ÎHnG­d_O=Ô¢\ÖÕˆÁ#Ó¹4®~¤·Z\ÃNl\×qE\Âd\ã_Æ¢\Ò<7qof»‚+7\Ì\Ù<\×Goj–p­¼_y¹f«g€\0\éP\Ğ\Ì\ÛM/È;°8\èig™¦“@\Í¦f—4\0\ìÑšn\ê\Í\0:–›h\Í\0:ŠLÒŠ\0+\'\ÄZ \Ş_j²[G\İ\0|\Ã\Ùpz’x­c^IñKU7Zu\Ú\Ç\"ˆ­É‚\İI\âI\Ï\Ş¢¾}(\ZWv<“Tm\"òol-\Ş\âFfº‹-[<*û\n³\á½:]oS¶²„a]³#\áQ\Ô\×9nX\Â#=¸¯køg\áñ¦h\ÇQ\Ò.†W#•NßŸ_Ê›:eh\Ä\í-\àŠ\Î\Ò+hT,q¨U°;R³TL}jNQI¦1â´\Ü\àûP\0O>´\ÜPM\'\åŠ\0F\äõúVGˆ5˜t=6K‰_\rƒ´¤Ö¤Ò¤¼\Ò¨‹’}+Áş$ø’[ıqmb‘\ÂG\ÙN9?\Ãùcõ§v\íõ_\â½o [Ë¶\ÒYü\×\Õ\Øõ Ş§\Ô×¾Iy¤x?\ÃÉ¤\éACD›cP:±\ê\ì}k\Å>Xÿ\0ayº€ÿ\0‰#Ú§¸ºy®^iv$·RMu8r­L\ïvNÒ´²3±\ÜX\ç4ø÷?Z®\êx€<ö¤2ôøªüRZ¡J°®wŒ\Z\0\×K‚Éƒ×¥L’G¦+1™W\ØsV\Ñö®\æü©°N\Ø\Ç9\' ¦¶R<w\'šDşûu?¥2y>tPrIªB1É¨\ã?68©½\ê8\Ç\ï+X¢[\'<\Òtô§¥ 8=úV\é¶ô„\àÑ»šO\åZ\"D\'ŠB)s”t\íT†ç“Š\\ú\ĞÃŠ:Š´ \È\Í“\ß”\éA\à}iˆrûcŞ¬\'\ê²{\æ§RH\Ï\\U\Îñ\'‚n´r÷šRµÅ—V‡«\ÇôõË¬‰:\ä˜¯|V+ˆñ?€\â¾/}¤‚ó«E\Ñ$ÿ\0_=(v=.\çky=„\ãc€y½uú~³kª\Û}\åUƒj\â\ËòZ\İ\Ä\Ğ\Ü!\Ã#ğE*4¾ø\Î\çƒR˜\Ünix‡Ám5Ö›ó\ÅÔ \ê+”Š\â[F)&J\Í^£ø“b¹#\êjmo\Âöz\Ô&\â\Ïls\ã8ªô#\Ôá€\á‘\ã\'µC=¼w;D™Y\îÈ¿yú\ÔË«K­&å£™OB:\Ô\Ğ\İ%\È\Ú\ØWP2\î\'´p—\\¡û²ş­2Gp›¸\äv¦º”6Pñ0\ä7z®#{P\Ïo¹\â\Ï1“\Êı=h›\Ö<0%s=ªùsuÀ\è\ÕË¹h$h.‘‘‡s^©\Ñ]\'\éYš¶ƒ\ì_:\çu\Ó\Ï0¨H \08Áü\ëB÷Mº\ÒeÄ‹¾\ÏşzUF,y\\~ÀŒa¾£µ\"\åO`}#)V<IN~he~qO\Ü2Qdö\éB³c“\Å\0Xr:Ç­I¯o‚Ÿ2zf¡Sœ5\"‚¼©\íÒ…e/ˆ5[m>\Ô~ògA\ÜşUõc¦[\é\ÖËˆ @£\Üú×•üğº\ÚY\Í\â;˜ñ,\ÃË·\Ïe\î\é^®­¹ó\éA,¶½\0\îzÔ˜HÁl\êj8~\î\ãŞ‘\Û\Ìq\éÕ©t|ƒ#unŸJR\Ô\éÒ›šCšL\Òf›qŠCº—4\ÍÔ£“@\Í¦\ç4f€KŸZf{šQ\Í\0??•8ÒŠ1NÀcøƒRûÊ’š@@süİ¿ú\â¾xñ^°u=@G\"\Ú²%=‡¯\Ôõ&»ß‰ú\İÕ›½¼¨\Ñ\É7\nMƒ £¹÷¯•®–96\Ê\ØW*p\ç¾(:(\Ån\Ë\ŞĞ¥\ÕüL–j¹‹vù\Ñ{\×\ĞJ‰)`U\n\0®OÀ>mJ3ÜôËœ3²½…uLô™I]\ØFnô\Â\Ô\Í0œ)‹œš\r4œ\Z]\Ô\0‡Œb\Í’IW;Q–\'°€\å<q®&™dc$aP\Ë&Oa÷G\â•xV‘m&¹¯=\Ä\ß0.dr{š\è>!k¯}t\Ñ\ç\r;yŒ3\Ñz ü¹üjßƒ´Ái§,Î¸–_˜\ät«ªŒ.È›²:[x\Ä1\08\ÇÒ¬¡º\äõ	<z\Ò\ÆG>õ¤\İ\İ\Åd^Œo|vh`\ÍU\Â¾µb3\ïŞ¤e¤52¶\ËÁ\'Š®§Lt©\ã\ÚO&€.\Æ@\ÍÀ4\Èşk/ğŠ©7\r\Î|µıj\îğ«“Ú~•Y\ÉôªxsH8\Î:“\ÍTw\ä\â‘1¾i¹\Ãğ3]	\Ù`œ\Ò\Í4^´¿l‘›`O™\ÏÒƒŞ“©\È<U¤!O­&\\\æ\ë\ê):ô<\ÕCœ{ö˜\çµ/\"òj„\'z0~˜¥\Æy\â\nbœ\ç¯JybŞ˜£œ\Ô\Ì>C\ëL¯K\Ö`\Ô\"€ı\ÔÖ¼r†\àğk\Ïn´\émeûM“”s\Ğ\ÖÆ\â5¹aowû«\Ç=\r|ú‘\ÛcC\Ä^°ñ¿\ï—Ë¹Qû¹\Ğ|\Ë\ì}GµyV£¥\ßøvó\ìÚŒ!?»˜}\×\Ç\×Ú½ª)úg§cM¿\Ó\í5[7µ¼‰e‰\Ç ö÷”8¦Tec\ÃJ%şFµ4½~{X\å$¦qV<E\á\ß»\\Ú†¹Ó³\×hÇ¿·½a¡\á7+=Qz3½š;\Äv{e\n_:ƒ\\¹\á«\Í\ZB\ß~xqVm/§°œ\Ø\ã¸õ®\ËN\Ö-uX<‹…S‘‚¬*“¹\r4y”\Ä£8\ïVŠğoJ\è|A\à³k½4nN¦<ô®B9&³¬€€8*E\0M-¸™\ÌĞ°†nõ§\Û_s\r\Â\ä›¿\ÓÖ¤\İ\Â¯¥E4i2ˆ\çRBı\ÖW\éL]X\Ãu\0ªÁ‡\İ\Ç\Âjş–\ÖFš\Ï8”=EvFi\ì	O™8\Ó\ëWdHo#\êí¶‹\ä\ÂA!\Øÿ\0+\Õ\ÄI\à•\Ú\ëIò\ëˆ\å\Ï\ë\\|\É=”\ŞM\Ôdz\Z«\0;W,p¨§(nŠ|‰¹r€\ëQ`¡\0qŞ€$V$cÓ¯j\Üğ¶‹?ˆüCk§@\ïo#øTu5„¥I\ìM{\Ï\Â\r/C“Z¸Oô›\Î\"\È\åc\ãş\éğÃ§\ÚCel»`…\"Š»,Bö\ïT\"m\ÎKiB6®OSH’\ÓH3\ØQØ™?y¹5şöQı\Õ\ä\ÔÅ²ivx¦“\ïHi	¤0\Ï4¹\çšm÷ É \ZJ(ùf›œR€X\àL©£^7\Zj\Ãı\ãùT\Ô\ÒQEV\Äö6\Ú4±\ß\Ú\Çp: qÑ¡\ê+ˆ±H™WNš\Ê!2|ƒ\éŠ\ëüI>Z(\á~cõÿ\0?Î°P\í\ÏV©\Óe’ù\âšNj=Ù£5 /J9\ÚN\é\0¹\æØ¤N\ë\íŠ\0^	®c\ÆÚ¢\Úib\Óp_8”úF:ş|Æº|…$\099¯ø‡\â¹321\İr\Û\Ñ) ~g&œU\ØtBOx\Ìa\ï“\ìz|1,6\êª0\0À\År	ÓˆStS–\á}…v²\ä`J\ïŠä‡©‹\ÖD`ôıj\ÄyE@‹ÜÂ¬ÁÀ\ÅdY4|ò;U˜ñ3Š­Jô\ëSó‘\×P”\çŸSúT‹™\ß\ËO¸>ñõªû\É+{ø‰\ì*\ì*±\')qcŒÂÍ¸(÷¨	\Ü\Ê?:s0ƒÒ÷m_Â™o÷Nrs\Îj\\„ÀúTĞ‘\åŠÒšÔ™lHI8\æ›ü})y4„ü\ÜWRF-’ƒI‘h4„ó\ê*\Ò$\\\äQ\Ü{\Ò\ã?Z7*Ğ‡v\âš{g­\ï)8<š`F/ZŒ\äi\Ù5B¸¹=¸£­!ö½q\Å1\nO\\TÍ/­D\ïR¶M\éÿ\0×¦\Ñ\Ú\ã¬\Ëı-\'\Ã&U\ÇB:Ö¥Å´¶²|Ü¯f\Ålõ¯š;\Ê\Zn»>Ÿ µ¿\ËG\Ñdÿ\0\Z\ë\í\îVH\Ã\ÆÁ”úW1ug\Ìe\\\nÎ‚\êóA—\å\İ%¯u\î>•j@\Ñ\è@¬¨U€ Œz\Zóÿ\0x—¿Ğ”$™,ö½›ı\ßC\í]VªA}’îµ«Á†Z¦”„\îv†x\ÊJ§k#E<o…\Ã\Ä\ÛOZõ_ø6\Ë\Ä1™“÷\Ê>Y”uöa\ÜW–\ßZ^\è\×\Æ\ÏR„\Æÿ\0\Â\ß\Â\ã\Ô\ZÉ¦SL\èôoò!¹8=3VµŸ\r\Ù\ëP™í‚¤\äg†¸\æ@~d<J\Ô\Òõ\é¬d\ìJg\ëŠi\ßr\\mª9›\İ>\ïI¸)*2²¸\àÔ\İG8\Æù×¥Êšˆ-vÉ´œpÃ¨®\\ğ½Î—#<`´Y\ÈaOa-JN¥sŸ™¨=\rR6\Ïl\Şm–Y?Šô\Z–€$½:gÒ§*s\é\éL¶»Šñ\nsÁ±ô¬\İgE†\â/™‰ô\äUÉ­\Òfó˜®ñ/Cõ¢+™¼›•\Úÿ\0£}(\Îoô\Ùô\ç%AxA\ê;}j®Rh\Æ\Ş\Ğ×¥]\é\É8,˜\Üz‚+Š\ÕtŠBğ:¯Lı)\Üd¾ğ\ä#ñ-µˆ\\C»|\Ì\İA\×ó\éø\×\Ó$1GojTv¼{\á\ìr\èvFñ\Ô,÷x\îúW©i·¢ö!p Ö™,Û¶Pp;µt¿Ë× ª\Ğ\á#§­Z¶]\çy\è:T‚,D¾\\aO^\æœM 9¤&‹šLóILw\Ú=\é\0\æeQó(`y\"³n%,~\\7½Kd’Ç…\ÇOZ\0½Fi3U/f’4<÷Àº­\å\İTz“Nöjv,\èO \æ°\"±½»o¸ÁOñ?­6––vù«U$#T\Î^\æ4\×\ë\Å[¬ø$I/U³´JĞªB\n(¢˜©–¸y¤ßµd‚sš½­]¬\×\Íd˜£8Ï©\ïY\ãk\'¹H¸£#½41?ó\ÅH\nI\íE3=y¥Ïµ\08\ZTC“\éOR(SZ›\È\Ò.vÁ°å¿º=k\æıV\à\ëz\é1¶\ÄŠ+×¾+k\ãO\Ñc\Ò\áô‹¯™ñ\Ô-y—„´ÿ\0´\ßù…zp8\ï[Ñ\Ùv;\"ÀZ\éè¨˜Ú¢­\É\ë×½tÖºZ®œ—¸¬¹\ìš)#·©$\ådD•\ÌĞœiÀ\"¬½¿*f	cŸ¦+2‡¡\ÃdS¼\Â\n¢ó#t•0}ÿ\0„T\Ö\Ñ`—l—=O¥0-A…1ü]\É\ïVY³´c½@¼í§®|\Ó\ÇALE˜\Èg=)b˜H\ìÀğ8¨‡;º\àõ§\Â2*\ãÖ„ºaAsÇ¯Z°§TJ1‘Ú\ç®ªp\åF2•\É=\0ühŸÎ˜ş}kkrCŒRrx\Åš5I_zBr)OL\ZfsœÎ¨AŸAI’x\éH\Ìx\Í4>Oÿ\0Z¨W×iÀ\Ôa¹\Ç\äi\Ù\à‘LW=A\èi\à\n`ô\ïFáœSE\Ç_òjbw\ëPµ>O—\ÇzvÛ°YSk\0A¬›«„—‹\æO\åZ\nø©Uò=«\æOH\ç\Õ\Æ(’5•p@\"´\îô\åpd‡‡\î=k7\æF\ÚÀ©´‹5•ÆŸqö›&*z•\ro\èúüW¸Šo\İ\\/õÃ‚+6ûMY™\Ù\"ò\âšvvñ\Í\È«\êºM·dÖ·°¬ˆz\ê}A\í\\¦—\â	mdºˆöz\×[Ê²†F§¡¢w\'c\Éuÿ\0j”\Éó\\\é\äü³(\å=˜Z\Ì;…Ê‘ŸZ÷fXç‰£‘UÑ†\n‘EyÇ‰ü-£¾¡ ©1õ{Oş\'ü*%Å©÷9‹[\Éôù7\Æ\ßQ\ë]›¬\Ú\êpg\0’0\Ê\Õ\ÂE:Í•|«©ÁS\Ô\Z‘w\Äû£bw*VÍø4÷:~:”EqŠe³‘‘\ÃpyS^ƒ£ø“ErG 5oXğíµ	š\0©?\\æ¨ŸS\Î\Ã$À2{Š]\Ê\à\Ç2_óÒ–ÿ\0Kº\Ò\æu’68\â¡YVF¸o_Z\0t›­p\Ùi!ş÷uúúÒ¼P^D…°GPE.\â\ì}º\ÕymäŒ™m\å\â=\ÓÒ˜V]€*ô\è+µğˆG`X›x¿V¯>¶\Ü(s!\'hV\×y¡İ¶›l‘)Ü§–ô€\î™(­ \íTl\Z5s\Ã0\È®“EÀvi3\Í&x§*¥\Ï\İ\0„\àV”\ïö•+6ó\Ï\İ\íQ±\ÉÀ \nû=*\ÌRqM\ÛÛ½?:\0³š’|·ö=i¶ğ\îbA\íI,mç§­04*–¤¹Opiö³\Ë6?J’\éwÀ}jĞ†Yû8\İÖ¬\ÔP\äÀT]Ç¶M\ç#¢Z¡Š\ég¸h\ÑK*_¶}ª¶³|,l©Äò§ø\ÕK›ô°–\Ş8w\Ë\Ô=H\íXz¾ o¯Yı\Ú|¨*[°\ÑEsœš\\\ã­7&Md1ôZny š\0^}8\ïKŠ@i\n8\n\Ë\Z3±Â ,\Äú\nh\ä\ã\Ê|G\×±<4ö\Ñ6.o@3\È^\çòştÒ¸\"ñ~±\'ˆ¼Mqv\èó¶ ?º:Ÿz\íü£ˆ\Ö,¯¹¯=\Ñ,\ÍÖ¤€€Bœœ÷5\î¾³[k \Ø\äŠ\í§\îE\È\ÊZ»%@Œ/U;›a\"“j\ë`TmÒ¹\îY\Ï\ÍlU±ŒU\Ş-0ùz\Öü‘+\ÄUcó&8\ïV˜Œx\à\Ü\Û\ä\Û=ªÂ®½Z’\ßiÀT%0\Ù\ÇJ¡‡œÎ¤$ô\Îj2v©#’x\Æ)\ê	Lw\ïL	P\åB®}j\Êa½241ß½J?:\é¥NÚ³)\Êú\Ôş”¹\É\àS:œšpÀ<t5º2®}º\Óòj5\0ò~\\ôªH	Kq\Ç\ãFx\Ïj[\éKã¨ª°®) jg ô¥\Òpj…q	$õ÷¤\ÏËœb“=)7zqLC³Œ{ö§¯­0L\n\\\ä\æ©!\rjQÁš`\ãšx<v¦!\ê~npjv\'QŠ{T\ØY\ïLµZ¦V\ÅUV÷©³Ş¾\\ô\ËjüsQ\Ü\ÚGr3\Ñû\ZjµJ­Ò€0\å†Kw\Ú\âV·^4\nº\ä\ZÉº²{c¹>dõ \ë»\îc ¨\æ¨Z\ß^hR\íl\ÉkA\ê+d0¦O\nJŒ\ÎE5 \Zú~§o{–\Ş@Ã¸\î+R9Cµ\å±\\i\×Fk9d‰³‘´ñŸ¥u~ñ\Ô\Ğ\Ås¶+¤8<ğ\Ş\â­J\ä´K\âZë›®\í6\Ûj#‘ ,\Ì?­y¤ñ]é—c©B`N9\è\Ã\Ô\â½\Â9‡CTµO\×\í<‹\èC\ã\îH¼2PiJ)\êTec\ÇJ\ÊO\åZšf±5ƒbZ<\Ô:Öƒ¨øb|N<û&8\áGFô5U&@\ÊA¬õFš3·qc®Y\í‘T–7q\\F¹\áYô\×2D7Å0:Tö÷SZJ6#G­u\Úv±o†`7wVª½\Ì\ì\Ñ\æ“Ê·JVB\å\äWk®øI\\«õQ\\¼v\îc•H¢\à%’	f9U\é]V‰fn®Õ˜~\í9>şÕ‹i\0cA\×õ5\İi–‚\Æ\ÍS¼a–52c.\ï;¸\ãÒ­\Ãyü2~uLt u¡06\æ\Æ9\Í[PHT\ÏÖ¹-k\Åz„lcù\Ë\Í3m†?3zŸ ­;]i/¬#º€°tÜ Œ\Z¾—~\é\ãW;\ÛQ\ÂÀ‚\Çğª‹–\êsN\ÉCò\Ğ³Š’4=MVP\ßZ»nZ`L¢¤\Èqµ€\"£g\ÄÈ¥·h\Î\å$¯ò©\âO¯B(W#\ÜR„PY\ĞrGJh\n\ZŒ¬ˆ°Bû°õ8¥{tò€l½3Ö±¯®L\×\ŞX“\Ëe$6zVÕ°s–|Œ\åi\ÜG?~\ÌÚ¤\Òr»SŸÎ«S\İJ%¹b¿t?Æ¢ük6P”fƒÁ£Ş‘:R\è\äŠ(\Ó\× ñÖ™Ó¥H£(h@İ—ûª2Oµ|ÿ\0\ã\ß6¿\âi\åW\Ì‘\Øÿ\0ğ¯Yøƒ®ÿ\0`øZH\ãm·WŸ»Lu¹ü¿¥xE”-{|‘‘œÍJÖœn\Ä\Ù\Ùx/I-±\Ùys¸“^¿k r5\ÌøKNX\âW+Àº²\0_­t\×v´”5\Ônwzfš{\Ò´\Ö;¸\Îh5ğÃ‚ªÆ»¤,©\æm±\ígŠj.#ú\Õ!È¹ª\Í\Û\îÆ­¹\ÂP?\0z\Õ!d#h4P\ìo½S\Ç\æ\ë¥<§Lc­tÒ§Õ™N]Ò—\î§Ş”Œ\ã½t£! bŸŒŒÑŒzR‘ø\Õ!=z\Ò\ç8\æ“8\ã®i»°3Ú¨W%$?ZB\Ù=*<ô\Í&¨W$\'&Œõ\è9¦gúSKS\æ÷4\ß=¨\ê9ô£\0S°ƒ\êy\Å \Æqš^¹\í@\Ç^õ@(?8\æ˜{\Zx\à\ç­0$ŒSô©‰\ÊsÖ¢B>•+’˜‘*5VV\íŞ¥S_*ze¥5\"¶jª¶\rJ­\Í0,†©¤EV5(4§s§\à™ \åk?‘\Ç\æ+ Š‚\æ\É.\å\áıh[8\æû\Ê\rf\İh¡Hš\ß)*òkrH\Ş*\ëŠ]¹ )iZû£­¦ 6·E“±®¢)PAÜ§¸®bóNK¨\È+Ï­W´¾¼\Ñ\äÏº[|õ\êEZ—rlv“E\r\Ü\r\è’D\ãŒ2¯5ñn4¦{\İZk|å­º²»\ê=«¿µ¼Š\â%’¤UÄ0¦\Ò`›Gˆ\Û\Ü-\Âú7p{\Z´ƒkRC„Ws\âoAª\ï¼ÓŠ\Û\ßu p²}}ı\ë†Xî­®Z\Òò\İ\â¸Oó¬šh\Õ4ÎK\×\Z(\Ø]d*Œ\îõ¬\Øök\r4­——;x\Æ*\äZdj\È\\³8^A\è\rh\Ç@¨ÇµK•\ÅkúV’\Ğ\İy²Œªt¦º\0\Ù<õª\ÊJ\à\0\Z˜E+ ˆ\0r{VŸÙ–\ÚCHFH\ïM\Ò\í¸72•~ï¹¥šI	=kH­	<\ÏVğÎ·\ãAª\êz¸°İŸ$¡VUvÇ½w¢5Q*(\0À\ÅZ\ï› §\ÉnP\äZ«n8£$š\n\ãŠPŒ;RÑŸš´­\ã\İA\çÒ¨D‡95i¡\È5H\0œ\àh\Í8:\Ê0xjiVSƒL‘sFò9\ÂO¥1š˜º±‚ø\ïe0>:ık\'S\ì¬\Ú\ßh¿Ë¸vµ\Ş@ŠY\0\Íq÷\×m{vò“òô_¥&Æˆ3ÓŠ1ù\Òd\ç9¥\Ïz†=\èö¦“ùPhqKL\Ï4;\ĞÇ®y«®\é=ªª¶x5\â½ut\Ü\Ü#\â\âEò\â\íÿ\0‡_Â„€òoˆúûk~(•coôk\\\Å§xş\ÈTÓŒ³ù¬9cÁ\Çj\çµ\İÂ§,Y±^³\á\r1PFY0q\í]ô\"–¯¡G\Ğ\ìô\è½ª(ãš¸NE1XmÀ¦³\ãXI\İİ”•9\Î@\Æi0u\äSwš°8¤2\'ùØÂ”œ)\ç\Åa\×>\æ†*N\Ü\Ó@$„nô§\Ç~f@j$q$\áz¦®9ùkzP¾¬\Îr¶ƒq\éQm\çÚ¤c\Æ)½¸\é]H\ÄhR\ã#9¤súR’23\ÅZ$\\c¶)¸\ëJ[ÒšI5hLF=ò?:a`Gzq\É#‚)„ŒuªD‹\èi	i3\Øf™º©“p=E¸¦iNqTƒ§¨\Üı*qô¥-×¥0&\ëÒ•pA\ëP†§‚¥1¸ş´\àE3<bœ:òh\å°2:ŸjŸ9‹œ\æ«™«\Ì]?\n`n$¤v©|ÿ\0öZ(¯”=A\Ş9\ÛúÓ¾\ÒGğş´QL	\äÿ\0wõ§‹²1ò~´QL	E\áÀ?:‘o°\Õÿ\0\ã\ÔQ@\Ë{\ÊÁ\à\é\ßwÿ\0Z±\ä\ÔNÀCœµÿ\0Ö¢Š\0r\ê€q\ä{ı\ïşµE6¢’)V·½ÿ\0Ö¢Š\0\Æ}ZM&\è=²aI\ÉB\Ü\Z\ê­u\Ã4J\æ\ß\Ïÿ\0Ö¢Š¸\ì)£\Õ\Ë˜ñ\ïşµs~%\Õck¸Y£Ô¸by\É\ã®(¢”ş(\îfG¨\îù\ÌG$ÿ\0{ÿ\0­VTÁÿ\0Sÿ\0õ¨¢¹\Í	“T\äs\ë»ÿ\0­RÇ©•\É\ÆH\İÿ\0Ö¢Š\0\è\å\ÔX–”\ïõª»jÿ\0<ñ\ïşµV\äˆÚˆ(‡÷¿ú\Õ\"\ß\àmòø?\íQE\07\í+\æc\Ëÿ\0ÇªqtÇ•ÿ\0QE0\çó÷Zz\Ümşş4QLL]ÿ\0°?:.\Ëñ¢Š`6kœ¹ú\ÕVœŸ\áıh¢š\Ì\î-í´Ÿj\ç±\ïE2)isŒ\ÑE G½\ç9¢Š\0AÈ¤\Üh¢€\Z\äW”|Q\Õ..5hl‰\Ä1&@\É\ïEp\ÜG3\áôC{½b0=+\ØtR‘Ù‚©‚G\\\ÑEw/\á3\'ñ\Zÿ\0i8/\ëM3\Ø\Ç\ëE\ÈXÖ¸#~µ·\0c¯½Pi9ÁùZI.\ÒÁpzu¢Š g1WcŒö\ëVM\Ñ\Î6ñõ¢Š\ì¥ğ˜Oq¿hÿ\0c¯½ ¹9ûŸ­V\È\Ì\r\Î\Ñ\Âu÷¤7%@\Â~´QT„\'Ú‰\Ûú\Ñö³’6ş´QV‰c~Ó¸rŸ­7\í<“¯½U!Ÿ¶\Şşµ\ÚsŸ“§½U![\Ó\Ó\Ëÿ\0Ç©§P\ÈÏ”\ï¯şµU\0\ÓtXƒ·/\ÚNW\åıh¢˜\Ç\É\ÛÖœ.rOÉÆŠ)€\ãw´}À\ZkÒ‘3ú\ÑE0*\Ù_É»\æ‡¦\ê\Ğ\Z¶WıAÿ\0¾ÿ\0ú\ÔQ@\Ïÿ\Ù',1,NULL,NULL,'1',1,'ck1232','2016-11-23 22:22:19','ck1232','2016-11-23 22:22:19','N'),(6,18,'0.jpg','ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿ\Û\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\05?\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rğbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Ú\0\0\0?\0õ”»¶™\Å2H§£#\r/ş*ùoLñ«\áy¶3ğO\ÍòøW±xGâ†‹\âM–·,,/\ÏTò¹ÿ\0e¿¡\æ²TWsGR\Ç~fŒ7G\Úcéš‹\Ê\Ï\İ<úŠg”S¯J¯b»‹Ú¾Å£rŠ¹.\0õ¥K\ëb\ÅE\Ä{½7Œ\Õo(`Š\É\Õ<7k©!%v?f\ZNf5W¹\Ø\ÛÎ’.\ÒA\íõ®c\Æ¬<Gnò\",w8á€®4iú…yº+‰6\Ã+\å^‘\á\İxjV\â9\È\n?\ïª\Ë\áve½U\Ñ\âÒcÁúEŞ™$,cŠò½F\îU¸½IÉ¯³u-&\ËV¶hn¡WV\ã‘^[¯ü°¿\ÉcrĞ“\Î\ÓÈ­”\×S7\ìxuµÀ½L†\ÇSSª2\ä`\ät®\ÏRø?«h½Ğ•%‰\'W8#óU£ ot«M2ZÜ¥¿\'¥N„ısP<-s\ÓŞœ§\0“\Ô\É&#=¹\ãğ¥,Uw½\ê2w\Ø\ä\ÓğXp:v Cr_¯8\âH8\0¦)\é\ÎÒ3\í@À’	\0u\"…L\ä|´\Ür8\Í9T9\àP…#\ĞcŒRsŒ\Ğ`t§ƒ\É¹¦…8õıh4\ĞºjÇ—\Ül£©\íT\Ç\Ï\ß\Øâ¤ˆ˜\Ø2“·¸4…©i¯m!dRS¶;U“NG\\t®\àEôXe‘Ò¹OK{i¨\àı¨a@\Ç\éS|¼qTô\È9Õ…lŸË¯4€¸¸Á\0ı\r*“Ğœc ¨’2SO\Ï^´À²q×®:sFÓzb£\\\0µ(lğ:ƒ´\00Aö¥Tä“€;‡<}h\Æ3\Î~´€B\äg§Ç€=(\Ç#>\Ôc\ç tÇ­\'\\)\ãœ\Õ*?˜¡\\q\îjª9S•0*\09Ö•o´„™|\Ä8 v¬‹w¶¶G\ÔW_\áO\Ë\ÅG5¬Wk£u\0rÌ¤sƒš‘Xº‘¸*Ş¡¤¼Xd‚x5šF\ÄŞË°jwöº\Ş\êH¹ş\ÅlÁñÄ°\r«©M\Ç-š\ç\×cIÇ­A${rJV\ÔO\ã\í~\à’şL\ëX³\ê\×wŒ\ÆYó\êsY\Ü€FGlÒ†ANÀ\\œ}\ì\Ô\Ë!\É\n!Y\È\Ø\Ç$Ş¤ü\Ä\ã\0sE€Ø†\çj\ãŸÊ´­o\Z,0$cƒ\\\çšOld\n9ˆQ´\ç=E\0z‘\ã=CN•<¹\ÉL\çi9\êø›Ê¤W„+2M|ó\Î	#½^·¼`ÀƒÓµ6\ëk]B\ÏPŒ4R+\Û5i!Uq_5h>-¼°¸EI˜®qƒ^\í\á{ûV\ÑKŸ›H.tU^[¡©d8CX÷Kš ,=ñ\ç k\×õª\Ä\Zi,\×2\àŸÎª›\éWƒš˜uÁ¥xRAÒ‹Rm\Ø&®\Çy¼pk)\ì\Îr3MS$G¡¦#s\Ïb:Ò‰\Üµ\Îx=j\ê0`(u¹aŞ¬GpZ£³ŠP\n\ÓL8=\r.j„r‘V’`\İ\éXw&¢ô£4†-Q@j.¡Pô•QIAy¥•·\È\Í\Û>´ÃƒH£\Ñ<ñcXğ\ã\Çmz´4ñ²Fù\Ğ²\ß\Ğş•\ï\Zñn\â«_;MºVp2ğ7ŸQızW\Èd\ä“\ëVlontÛ¤¹³\àVDb\nŸ¨§qZ\ç\Ùş^:T3¸qÒ¼ÀŸ\în\Ê\Ø\ë\Ö\æB\0Qy\çş¿\Ô~Uè·šŒs@%…Ã«©æ”¦’¸\ãİŠš•\ÆAQ‚OlV}¼²Ûº¼d«©\È\Å™\ä.O>†”·^ ×Ÿ9¹;ğ‚Š±\İ\èº\Êj0„\ì¸Q\Èõ÷­pÇ¡\é^mi;G\"H¬U\Ô\ç\"»m+UK\Ø\Â>`9µ¤\'}”\ámPÿ\0\Ä\'\Ğ\î€>Y\Ç\å_-\İş\ãP•@?|\×\Ö0ùö²EŸ¼¤W\Í>3ğõî¬\Êò\Æ|—bU±\Åofc%\î˜\ådÁôª2BĞ¹½O\å9\é\Ï«Ì©,?2‚}kS#%x\äT¡†	a×¥2\â3œ‚˜$u\Çò¦\"m¾c\r\Ø\Ç\åŠp\Æ0;z\ÓŒŒg\ëK‚A>ô\0\í\Ù`O\ĞÒI\ÏN)ª\ØS¸{\Óúpz\Ç\0ùp:ƒNB\ÍÀ\ã<ú\Ôd’H=s\Ø\Å\08py\Í;¦¿Jb6\ã\È\éú\ÓÔŸºqø\Ğ‘9Š@\Ã8\ëõ«\Ñ^G†\ë\Ó5@\0>Ÿ\äR\î £z\n\0\Ê\Õtƒ4±‚W\éYI#·‚»8\\!\\+U\Ò\Z2\ÒB½NqH\n))\Ï…J§<\æ¨Fû¯=y«ËŸ¨\í@ƒÀ\ãúÒ«\ã¯_J‰X\Ë4\á\Éù²I˜GÍƒ’;c\ìô\êMWS´õ\ÅJŒ	İ’(B¤½)Û‚\äu4Ãƒß¯Zn?\Z@I»$c={Šz±Q\È\ÎM3h# `~´¸ã™ 	•²N{v§ù„8 ÿ\0õªº–8\Ï\"¤dœã° jñJ8\È÷¬\ÍCB¦H€öo\'$ö©¢¸<gñ€8¹!–\İ\ÊÈ¸\ÇSA9\\\çó®\Î\æ\Æ\È\Ï1\éõ®n÷I–Ô’€3\ndG\á\Å0:ƒ“\ÅJ	9¦˜\ÈRÀg\è>z6H\ì(lAúPFx\Æ) “š€%ó\nR\rH%<N}:UnCò=:Óƒr?J\0¾²t\ì[µXr\ç¯j\ÍG ‚2q\ÍL’–\í×µ 6¡»òşpızõ‡~(ò¦X¥|sk\Æ\ÒLr3\ØÖ–Ÿ¨½¥\ÂI\Ë\Ó„&±\í\æK›uu9Vu\Ü{\×ğûÆ‘\ß\Û$¿\Ï\Ó×¡\İ š \é\Í1™y¤#ŠVR§\Üú\ĞiA \Zv3IŒŠ\0`¸\\\í\'ó§\áÒ²uXfUó\"\'ŠÌµ\×Z\Ù>AsLGL\ÖÃª\Ó\âÜ†¨Áª\Ã2‚­]Y•…\0[I3Sš “V\ãE1\íô (ğry¦£”*Ê¸aUJúP	Ë”TQ¿­KHGOj¹4ƒ¦=is\Æ)h\È\Ç\ãO†T‰,Ç€)©‚À($w\Ş\rğË»¥Ä‰ó·##¥&\ì®4®\Í\Ï	xdCa\Ğ<×¤Ciöx5=9\ÅA§\Ú-”#Œ‘\ÔúU\Ù\0e\Èı+†¤Ü™\İò¢Ğ‚>•“§Šs³Œ\î½F$Á\È\Éô¬\Íq€¤*É™\íÀ–&*\êrª\Æ\0\ÅG-ÁD\ÆN\r;]Ä–úªıFT»AÊ“\Ş\â­\ëz\r–·dö÷Q+n\Éâš•ô–w‹q¬’)Ê²œ^ƒ\àïˆ–º°KI\Ö±ò«ŸızèŒ®µ9\ç;£Ë¼]\à›\ÏÜ´ˆ­%¡<0ş\Z\ça<òM}Q§\Û\ê\Í\è`‚+\Ä|iğö}\"I/4ø\Ù\íó¹”uZ\Ş3\è\Ì\\oª8×ˆOÜ \ÖE\Ä\rl\ä\àâ´£™œ\ç¯\"µlt™5¤}£…&µ3±\Ê|½‡^õ l(\äâ¤¿³6S2`YN\r\'\È\0\Ô\à\Ù#5\éÀ\ÆOj\\aÀZLTr?3J£+´”\Õ-»¨\"¦\nB°\Î\00)]Àc(“úÒ† €2½\0’\0\Û×¿j`8›šRóMVò\ÎH\àş´\ãŒrq\ì)\0\ÕÜ¿0\Èo­]‰…\Äb7ET\Î@ü)\Ê\Æ2YrNy \íSFò˜¼c¯<V ;$\Û\Îs]¬2‹¶A“\Íc\êú1\æX\Æ3Â€2\ã“8\0\ä\Ô\ê\Ø#$Æ³Ky,7µXI²Ç®@\éH¼“¸\äÿ\0H8\0Ç­VYH\È\Èõ\ÍJ“Œş4ÀœH s\×ùÓ‡\ÍA¸ğ\İje}\Ç 	\í1 ·#iü=i…‰ ş4\áœv\È\ê(\ÛI\0ŒN\İÁ¦ùÒŒ\à­ \'RI5 ùs´g\Ô\Õpüÿ\0õª`\Ãh\Ï^Ÿ\0:9\Z3»>õp<W\á\ÔjŠóœ·ÿ\0^”}\î\r\0RÔ´T\Ã<Y\'½`Mo%¹*\àıv‘M‚Uº\Z\ëMŠğ\Î;PW,x\íÖ¢#:ŠÙº\Òå¶”Œ£×¥g:\ÅH\çÒ€+\éœÂ”°\'*\ns\r¸À¨‡\Ş\éŠ\0š6\'®i\ê\ì#š®\'$\Ó\Ã`sŠ\0²%e\Ï54r\äœZ£¼õ\ä‘\éR!\äqÁ\â€:]\\›J¼Xİ¸<Œõ¯¤<\â\Û}nÁ\È\ã_)+‘\Ğó\ìk£ğÇ‰®t+\ä’&;27ö «n­ÿ\0‰y©Š§\á_\Ú\ë\Úr2\È‘\È\Ík\\A´\ät \n€\Ò\ã4H4\0¥‘YWú7HJ€\Zµ…=\r€¹\Ó\ï4÷%wm=¦¹$D,™\Ï|\×os2&AÏ­s\×\Şl¼CÚš—qX\ÓXŠLdó[–÷ˆ\ËÖ¼ò{»	9V#Ö­Zj\ÒFB\äşt\ì+Œ’+\nx\0\×)i¬\çšµ Ô‘À\æ€5¶œÒ\ê*¼wJ\İ\êÊºô\0ª¼Ô‡\"…\0ò)\ÄdP3\á\İ{\Ã:§‡.\Ú\rF\Õ\ã\0\ád\åo¡¬rk\ì8[\ÃtC$2A}o ù†\äö`y¼‹\Å?\ä\ÓoEŞ™)’È¶LM\ÉQ\ìÆ¥\èZ\Ô\á¼\áç¾¹[‡C´}\Ü×´išjY@\0\06=*/hiah¹A1Œt­½ 61ù\×Z»#²;+±|£<ƒJ±\íocJ1\×\"\Ï \â°6\Ë9U;‹}¼•}\Ü*“ÖªM(e h\Ó\Æ\rg_]\íCóq\ëV/&\Ù\\\æ§t0pj\â‰l\Ê\Ô\îÌ\×<\â©$˜“r–:QM!y\Ù\Í>>1\Æ\0­\ÏNğoÄ‹«O.\ÇS\r<_\ã_ñ¯UI-5kMñ2KE|\ï¡DZ}\Ç>œ÷¯K\Ñæ¹²U’lÔœ\ìË›U¹‘ã‡^Y}CJ¾^1\\Æ‹|\Ú6™rm\ç\ï•\îö°\êp`\í\ŞÎ†¹_x\ßW´\Ù†\àó85¼ji©„£¯™ó\íşª$¹o0‚š­òœ<õ¹®|1ñ=­\ÈQfe^p\ÈÃ‘Y\Ñ\è:Æ–…o¬&‰:e\ãó­“LÅ¦·*;G=;T\Ês\ÍEq\Ç\Ğ|”Àı³\Å2Kh\Û[¿N•\"\Éò\àúT0+´ş&\Ğ>¤dPÀg,NP*FqùT;ğ\0\êq\ÅN¼d3Ò˜8\ä\ã9\ëJ£H;zûT…zôÏ©\ØÁ\Ç^OoAHC†\ÆqÖ \àöæ€Š§ ğ=}\à{t Xl\Ã\'¯sV–\ë\ÎQô\é\ÍB\0\é\Ïù\éL\Î\Çzb€(\êº>ğ^\È\æ°p\Ñ9\rÀ\ã¥vq\\;[½f\êzBÊ¦X¿ )‰Å\Şüª\Ê8\'¶;\Z\Ï(\ÈûXŞ•4r|¾ı\èò¶{~4ğ\Ã	^6=1Z‘$}(\Ğq·°\ÇşúUnT\à=*e;@\'ó 	\ÚqŠ3G#Úš\ÌG_JPª:u\ï@RCgó\Í*ëŠjğrz\Ñ\Él·CÀ \nù^¹=ªN\Ç\'Ş©“ó\r¤¥X+Ôš`80÷\ïR$\ÅH\Ú\nŒ°\ï\Ğ÷ \É·Z\0»˜®WX\×ú1\r˜‡¿N•t™zŠ\'$\Ù\æ€8ùmL`†\É\ÇRQu#¯>ø®ö\ê\Â„=˜úW3}¦\Én~\ï4€\Å\0ó\ÜSX’A\í\ĞS\İoÇµ3\'Œù\Ğ2@ÄŒj‘\ïøUpFG\æ¥\Ø\ã×¥\0XMÁxn¾•,g$ñ™ªñ¶\Ö\Î*nFJóõ «\Â~,¹ğõú2»³†\\\×Ñ¾ñ]–½`€’9¯’T–äµ\Ñøc\Äw:\â:H|¬üËš}M\"‚r:Tx\â°ü/\â[}j\Éd‘\ëÒºON”€ˆGÖŸŒRb\Ãp\ÅY\Ó\ãGb¯\ÉôªãŠ«u,\Ğşör9\Å7.t\Û{”*\È+\Õü&Ñ–’ß§z\Ø\Ó|Um<‚\Ş\èùst\çŒ\×D\nJ™e4\Óh,™\äEg³r²¡{U\È/Š\ã~µ\ß_\èv÷Š~Q“\\f£ Md\ÄÆ¹^µ¢’dZ\Å\ÛmE°>jÖ†ü÷5\ÇC)°\Ù\ÍiÁrN1\Ó\ëE€\ë\à½\Ï~µxL¬µ\ÊA1õ­(®H‹ñÆ¬\ê\Ú6©ú5\Ü\Ö÷$€<³\Ã{Ğ­}/¥xšûX\Ñ#:„\n—E@vA…o|v¯øy¡CT-\äC…Ï­{\Ì`X”`\\µªr«#®•4õb¨\0t\äSLˆûv§2\àm\é\éT^M¤†È®3¬´\ìp:„\ÊGCU\Ì\Å@9\È>´+œŞ€\'y\Ü\â³æ™;zzT\ÓLÕ—4\àdóõªHZú\àm9=+“¿¹%›¾G­jj—8õ\ÍJ\Ì\ì[wõ¢Fm‰\'œğ?Z euU\É\àUu\ï\ß5\Ñø{M28•\Æ;M»+‰+³£\ĞtôX\Ó*O¿½v1©´\n£§[¬\Ç\"®´£#\ê+»³¡+h:)¦¶›\ÏF*Ã¡\Ôi\Z\Ò\ê\nb”˜tôjä¤™@\n×š€]ù%GÃ©\È\ÅTf\Ñ¦¤F•2T+ñ„0\Íá›’c\\…\à‘Ò´4rZ\ß‡ƒ\ç__zgŠmÌš\Ğ@s°ô®‹\étrjŸ+>h K¾6\ã-‘Y÷\ÏU9«±Š\êA\ÎC\çV`¸IF\Ç{\×R0ftx#¦\ã\éS†\0\ã\'Ú¤»´0\È2­U‚ü¹\èzzS$´­ó\àÆ¦İIü*¸+·\'¯¥H‡p8#Ú€%W\Üpx÷¥Ú§OÖ˜	#œñJ¹\Ï#\0\áÁ\Çoj\\€§¯óO€x\Ç|RH €FsßŠ\0[\n0p(c¼ğr=©¬q\0\ÇN8¥##Ó¥\0)P0q\×Ò¦Š@AV\Æ1Ş’5¥›§Ö§®0{\Ğn«¦y€\ÉÚ¹Ñº&*\Ã\æ¡®\Ø)V$ûVF§¦‰s\"r}©“Ÿ»\Üû\ÔÁ\ç¬\ï*ÀÕ„nT\îÈ Š\Ät\é\éR\ä’0~£¥VG\İ\Ôşu20>¹ 1±-–\æóÁ¨C`\àf¤V\Ï›½\0H\ãÖ—ÁcÖ‘INy¥$pJ\07$)\áúdşB£Á zb—<	 	ws\Ç\åNİ“\Óõ;Nz})\êø\É?…\0IĞzÓ·(\É÷¨ş÷Sš\\zô\Å0&la\ëVO—r›\\d\Õ\\\ã¯5\"Hpi—¨hŠ4cšÀ¸µxNEwi(Ûµ\Îj½:+\Åª4Á2\'µ&yœšŞ¹Ñrª½=«&h\Z\"TŒcÖ‰€/\'&”8\ĞTr9$\Z‚z}¨\à9ÀŠ”p@\É\Ï^*¬n‹jœ>õ\äv GQ\áŸ\Ü\èW¨\ê\ä\ÂOÌ¤ô¯¢|7\â]f\Édˆ¯”•»sÖºø®\çC¾FG&~e=¨\ê&_N•\Ö7†üKk­Ù£¤ƒq3[¬¿•H°ô¨wT\ì=i¤f€9{AûLFh	IG Š\çtˆ7:\rğ°\Õš½#h<•\Æx\ÏÁpk6$j£œZ¤ú0=J\×,µx[i”\ät\Í^–\æ]® \×\Ìz6««øWU6²;…F\ã5\ì\Şñõ½ú¬7D,2M-ûšz¯†RP\ÒCÁö®ZX.,$+\"œÁ\Åzlr¤\È6§¸ª·šlˆC(\ÏÒ….\à\âp\Ö\×@œ–­8\ç;G¥C Mh\å\â\É\\ô\ÅW‰˜•aVµ$\â~\è‹a£Dû0\ÅGn¦»P‡\â“Nµö‘B\İP*\Ë\áx\äW—9sJ\ç§\ÙX«*€•‘.l\ã¯!\êŸjÆ¼Â’zzf’,©$€1qO¡GlœU\ã\Î\Ü8\ÅL\ß2wıj¬{\ÉÊ–qYR\Ü\ä±\'#¯Zµxvòs\é\Íc\Ü\Ê3Š´ˆ“2u‚\ÎA=k4©w\Û\Î5%Ë—”\à)Ğ£H\ÃµD,mM\ÕÊ¦+\Ğ4ø\"·‰I¬\ĞF®9­ñ—\ÈŠ\Êo¡µ5\Ô\Ñkõ\nUp=úTnlóÁ>•EÁ\çŠ¬ò°$)\Ífhk}¼–\çúT<\×V>¿\\RZÙ™\Ô\ÏZÙ·\ÓÂNpzJVÑ–\ãO¹[˜Y–U99=Ez]•\ä:µ™\â0\é\\ZÇ·\0ó‘Öôšu\ÚKp:¯¨«„\ìcRŸ7©\Éü@øq5´\Òjz\\e\ãc¹\â¾•\æ#1Íµ†k\ëK¸5KA\"a•†Ojóo|4\ï~£¦.Ù‡%\0\á¿úõ\ÙœRıO.·+2añ\éTo4ónN‡®*\Ôi-œ¯\rÂ²:CqƒW\í\ØJv•\ÏûU©h¼`ƒ\ïS©\0sÖ´5;&|c·½c®\åù[ ŸZd–Ñ‰\É\Ç¹©BD€€ıjL\äœú÷ 	†S\Ï+LAŠx\Â\ç<\Ğ\nG 4\ÒBœc<S÷›\ÜTD\Ô\0\à7Ó¯j”\î:Tqœ\Ô\æ8j\0Lr3O\'\r\Ïô z\ã\Ô\Öl\Ü\ĞV©¥	A– 3Šç¶˜İ•»Wx›]0Mb\êšVC<kùR90Ş‚¬\Æ\à¨Á\ÏcT2\Ö\ìTö<Õ„l\àE\0]B1Š“8Ç¯¯z®²g½L‡¸<ú\â€&B\Ï4\äí•cŒ}\Úz¹€$\İ\Æİ¼PGÖš \ã8÷§·\ïŠ\07v\í\éN\'õ\"ƒ	nô)\0c§\á@»g‡½H>Rx8¨@\0f¤zõŠ\0“;¸\í\éJ\æ¿qH“jœH>½\Å\0<0\É`T\ÑÍ·©ÿ\0\ë\ÔT±\ë\Ç4»¶‚;v „,\İ3\×5Ÿ¤\Åu\Ò0\Çîš°—\rœqS‰ƒ\á\\ö 6ûF¸¶l\ì,¾ Viq^Š\Ñ\ï ‚¤\Õ&\Ö\å+±\Îzv¤À) m \àq†µ\îô	 \ä\0ñõ\È\ê+=\í\ÔN¥1Vg ŸzryUm›_\nr;Õ˜m]Án\Z\0\è¼7â«­ñ\\ùl~e\Í{\ï†|me­Z¡\rÇ¼\æ¾gû\Z…\äg\ÓÖ®\èÚ­Ö‘x²@\ä&r\Ê\rk±õˆH2\r\'z\àü!\ã[mN\Ş4yñÁó]\Ìr«€ÀñH	1\ïN#qH1šp#Óšq¾-ğ|:’˜P	G9¼ºX\îtÛ³nWSô¯¡py\ëŒño…#¿…§@sTŸA4`øg\Çw\rW/º>‡•\ê\Ú^³kª@OQšù\Öki,¦1È›X\Z\ØÑµË­:ex¤n:\Óq¸“>‚dW`¬‹ı9°ÑŒ\ÖG‡¼iú$wkôÉ®¹dP\ÈA¸¨\Õ¹\ÅF¿(È¦\È\àu©‘¸¨¦ls^a\éÈ£g X7\ÃskjYA\èqY7L¥\Èü*Ì†ƒœô ğ§zTó\È6ƒ\éYó\\~lŠ±n\ä\È\ê=\ëRŸj`\ZÔ¿B–\İ\Èõ®jyŒ²±\'\åhÍ•‘wJ\0\ê}kRpEWµ‹,e ú\nÕ³„\Ë2ªô‘CoX [@#5g\ÌØ¹¥E\æ$@&p\0ü\ê\'“\'\å\ÏaX³tI,\Çp9«šv›\ç|Íœõªö´’FFzWWe\nG R\ÙyxÛŒU¥Bª{ŒÓ¼\ÄUùqŸz‚K\ÄL†\ãô\Å!ƒº©9b>†¨\\>NF[\Ó\\İ cµ±Ÿ~µBIœŒ«ûPı/_›FºŒ\Ä\Ç¾¢½.\Îö\ßR³Kˆ<n;vö¯\á\È—q<ÖŸ‡<M.‹t[f8t\Ï\ê+XJ\ÚÕ§Íª\Ü\é|g\àX5xš\æ\ÙÜ¨\È u¯\Ò\ëLº6÷˜\İN0G_zúJ\Îú\ÛQµY\í¤W‡n\ßZ\æüU\ámfİœ •a]1½F¹´{EK”\Øy5“«h­d‰FG\\Vüz]Æw\"^FÁ?8~u…>»^\Èó<[\'}ŒÚ¶Œ\Â.S*A©’PÃ­^»³hş\Ñ0y5–\×\åˆ>”\È.FWOv€H<ÿ\0*®‡s\ãœv©Y\Ç9\íŠ\0\ß?;\n\nÀ¿)#‡?Ö€û\Ç ƒF>bOZP»ˆ#š\Éù¨U\ÇB8§ª«g$s\×Ú£\Æ}A\Ïzz±\ç(ûvt\ä\Ó$|®Ò¹\ÏZ”:–\Æ1\rG\ĞP?©ij\àº˜zVÖ‰Àn5Ü”\ÎA\àwÈ¬mOMÊ—A>´€\ÆY	 c¯5adÁª 42|üS¤œôõ\Í\0]Cœsšxª\È\Ø9\ÍL¼z\0d\Ç8§\çß±«‚1\×ùÔ©ó´`\È\Æ0½¦…\ÇPi›z\ç)Ày\Ç<õ \nK29§p˜\ä\ã¯4œ\ìü§¶h\Ç\Å\09H?ANpr8\ëQ’\0\à\çµ=H\Úx9 	s\×\'¾´¹\èri‡k\î\ãŞ‚F@\Ï\áŠ\0“9\áz*\\\İ\05HÀ\ç}i\Ì\Ø*ËŒcŸ­NdY\0\\óTøx¥rJ\0KØ¥d!æ¹›¸eRz\×T°\ë“Ş š\İ%^€÷ú\Ğ5˜1=†j\é–8S>\ê\ÎHWr)Õ‹)”\Èw\çŞ–g¾\ÜN\Î@\é\Í	#:óŒwªñ¯pÀ\Õ\Ø-¤ÿ\0v2|P2Ö™©M§\\¬°1\\Æ½§Á6ş5†W\Ã\àpkÆ¿³$€~Iô©m®f\Ó\çYab¥NiG\Ô\Ğ\Ê%P\ÊA«Ò¼\ÇÁ^5K´Ky\ß“^™«,a”\äôJ9§¸aºw zRŠC8ÿ\0xN+øšhT	<W™Mk-¤\íŠT¯½û†HÈ®WÄ¾Šş&šÄƒŸ–®2\î&:°gW¬A\Ş\è>$\ÙvHK \Å-¬–S\ä]¬¥oXÇœ”\Ø\Ñ\ÒI:+¥VšR‰9\'\Ïû\Ã\Ôvª·*y\nk\É=\"„·\æ\çò¬É®I\î\Î*\ä«×\éX\×RJct\æ­ ds\Üü\äs\çY\Ó\ÜÒ–g\ÏSŸzÌ¿ŸÊ…ˆ\ëÚ´H†\Ê:…É–O)IëµP!\nFzóM‹såº“\ÏZ™FH\é\ëT\"xÁU\n§Œbº]&\Ì\Å	•şûw¬;8\Ì÷(ˆ8\êk¨rv¬h:q\Çz‰2\â†\ÊW~\Üdf\'€ÀóSAnºµ+\Ğ+6hK8\Ç#­^†óqÀlcµd²œM[··m»Û¦:ŠC4a’rOQT®d\È\Îr3Q\É_Å’;UI5p±\Ô\Ù	\É-Ø—%œ(ƒHVM¸\Új7œ`¸<\äuõ\Ô\âEÇ±\ÍW³—b}¤{€†N7\0}¤¡Aœ\Ó\Úù\Ü\ß5ºMÇœ\Z9%\Ø9\ã\Ü\Ô\Ñu«\ßÜ«äµ»=Ez½\Ü\Z•œw00h\Üd{W‰\Ü\Ü\Äğ\r\Í\ÍI\á\ß\Í\áÛ¢2Ú±ùĞ\ãŞ´‡2\Ò\Æ5Teªz±¬\èğ\ßÙ¼&5%\Æ3•\ã\Ú\ÇÁ»›†o±İ˜\Ğ\à®q^Ó¦ê¶šÎŸå¤\â\ÌCVv®\æ÷«Rq\Ø\ËF½\äx™ğ¿U¶·*nƒ¯l­rº\ç‡ntÛ§Ü¤\ã®} ˆHô5\äş0—!xH0\È\Í\\&Û³&p®.Ud~Ÿ<2³|Â·5M\ât`\ì=½+¡Bx\ë[˜·8\ê}óK*NzT ü\êU`3œ`\Ğ¨	n¼{w¥1“&w(SŒŠ“p\ç°4\0\Æ\Î:S•\ç“\Û\éO*7p(Û•\éÁ ‹ ü\İOz³¿½\ÅT\ÆGò©9 \ç\ÛÖ€,v\Å#Å¹y\Æ:šb6\âpqO‡ZsÚ–•¸–\æ\ÇÒ°Ih¤\ÚAÏ­w“Duô¬GK\Ü7 \ïHfB>x\Ô\êOON\ÕEƒ\Äıø&§ŠM\Ä`t k\èL¬H\çµUW\ä~‚¥W\ÉÀ(\Â0œu©w8\ëU\0=*Â¶\àó\í@\ä;œ\Ò?Ò“v\0\È\çúÓ”\à\ç4\0\à>a‘\íA\ã¥.{ñ€2)7ro¥\09Kv=©A%Ai¤“œcš\08À\ã\ÔP\"N¤7A\ìzÒ“ƒ\×Şš8•<)\0g“@\Ä;º¿Zq#h\àœ÷¦œ\îıiy9\'x€\ZK\È\Ç\×4\ì…\êN\ê8#´\ÖºP›ƒ\à0\ÕK­:9²À\ÇASnÀÊœcœõ¥I9\'9›g¥\Ã\ç?!s®/³À«A@éš©G\àE\Üh~\Î\nJM\r2Ü‘£Œ(ª7\ê\ËÂ€~•Q®\î-H­\ÓÒ¥MR7b	\ëH¡mŒ–R‰blú×­x/Æ‰p«mp\Øa\Ç=\ë\È^`F\å<{R\Ú\ßMm0xØ©µ0j\ç\ÔñH² u9¤\Åyo‚¼wª–·Oµ\Ç\'­z„3$ñ†B\"‘#\Å8r0zRm§@:Ï‡\á½S$h7Š\æ,\ËE\"\ãÒ½)Vv§£C|\Úz\Õ&4QXvŒcšÎ¹A–¥¾\×!R\Ë	\É\ë\çV’V \é^a\è‹z\ÑÂ¥	®N\îq$ŒG•£4Œ­¼œf¹\ë‰y u<V°DÉšM\ß(\ç5ƒ¬Í‚°©\ç­oyEWs“\×Ú¹JC&ª\äôSµ¢Feˆ_\åP>¤Õ˜°2\ß\ÂO½TO–0^Â¯ZB\×À\ÃÖ†R7ôKlî”ƒ\í]E€µ:\Ê\Ím E\à€9«.>^\Øö¬$Í¢¬Š\ä\î õ=ºÔŒWv\n‡qQ\Çz’‰!MÒ€:f´¯`“\ìyN8\ÆEV\Ó\à28lp=\ë 6û\áÀ¨Z1=	.¦)Õ³üF®ÿ\0`ÈŒ7J¸\æ¬\êV¦\ŞB\ã\å¦[k/Æ²\á€ †#8®\ç98\Ş„T­1\ÃFŒ¨V‘\ÛJŠ¯61E”•<r:W§\èZÕ¶©‰•Rlt\éTõ\Ï-Ü­siòN9+Ù¿úõ<õ-t\Çjw³V<ñ4eòğfiÁ$T7\ZTj-\Æï ®£BqˆaE,Q•‡C]\Ìğ[\0sp´¡:’\ê9\Æ{Ft8®\"]·r¬Ë¿6‰	Ïµm\Íp\ÃS¹\Ëdõ5\è\Ziz~–¦\âxL²\r\Î3’=%RnV¸\å(\ŞÇ”\è:¯á›†KI$ò˜å‘—*kÑ¬<r“Ä¦\æ\ÊtJ! Ö¤º–Š\Òl@	oD«2X$9;@Â«—›©\Ê+c%üg¤¡.ó¼xáƒ¡¯5ñ¯iªxŒMi!d‘Š©¬2\\nl–™³ùšÎÉ‡ï–ªœR\ÔS—Duv\Æ;ˆ\Â8Œš\Ê\Öü0ğ.G§¥Oc&Tz\×Ck:È\\¿wŞ¶1g”\ÉBw.1LS·–\Åv\Ş$\ÑPš\İx<+Œtdr\nôõ ‘\Èø=ˆ÷©—k“\Ç«ªŒ÷ô©\í\ç4 ç½i¥YNÒ¸\É\Ç\çH\àäœš\0ø|şµ½\ÇN\Ô7\Ê;\ç4œz9$ gœš°¯Á\ÉÏµ@\0^qùR+óŒ÷¦ ~N}8\â˜\Ñ\å=A¥V9Ï¥?‘Á\é@ş©¦\ï%\ĞrkŸu1¹F\Èç¯­wòÁ¹x=k\ÔôÌƒ\"\ãÖ\ÌPÀŒ\äz\n™ƒ““šª\ê\è\ì¬;\â¤V`s\ïH\È\á¸\È\æ¥\Ï¢©#ñ\ÇÒ¬\Æ\Ù<\Ğ\á‰\\cñ&¤Rs\Ç¨	qOGÛŒŠ\0œ“» ŒsM\Èc¸õ©I\à¦9 p\0\Æ4…€<=(I\ç\èiûFw\È\í@¬FÔ€œŒ™¨ˆ\ÆN;\Ó\Ğ\í8$Œ\Ğˆ=H\íÖ€\ÄdNh ‘øO$gş´\0Îƒ¦sJA:\ÒÀœ£¾ôÀbƒŒ\nn\ß|}<©#\'¿?…+0G>´\0\År¬;\æ¬$\Ş`\Ãc>™ª\İ	ã¨ °qhü{ñ\"†Œı\ài·¾K¨MÆ™ c\Ô\ÆOòªñ;\å³õ­M.i\"¸RŒB÷\Å!\Ü\äq=´\Æ9Ğ£\"¬\ÂÁıö¯M¹\Ó,u«]³ÄŒÀ¬O¼¿Q\\¥\á;\Ë\Éoûø;\ÔR)3\rd’	\ÆYX¯[ğ_Œ\İ+k\Ö\ä÷&¼¦uRE\ÚsĞŠè£Q”ƒ‚QÚò\Üú\"\Ú\â;¨\ÖH\ØGj´©^M\á_\Ëc\"C;\îˆñšõ{+¸o Y#`A ›XœPÀqšv9¢N\Ô\äR`ÿ\0O~j±Œşue†{œ\n‚Nñ9¯9“1õg\"M»°+0g\ÏAkSPm\í–\Æe\\úVğZ\ËrÌG§¾kŒ™”\ßJO9nõ\Õ\Ìq\Ükƒ¸»úS¸9üj\ìI¦®7\í\è}\ë§\Ò`h£G\è\ç’ErVG\Ì)¤\×em9HT`p1\ÅD‹\æ\è\Ô&\nüÀw\ÅFÚ¤\Ê\Ü\Ûô¬¿¶\ä{R¤şh#ø¾µ“F\×7\í®\Ö\áG#¯µK´1\0=j\r2¹v\äµ[8şŠ†R4¬Pô\ÍmÆ»—õ®~Ä°a‚=kd\İ$I‚\Ü\â\ßÛ¬¨w\0\ÃùW\'g1Û	\í]Î <¼A#’+—\ÔnK±Tb+£\İ\ìa]&®XÒ¦¸·¹6b\Ï¥zw‡õ§\Ô#0\ÊAGûÂ¸\ØKx\Ö\ÖÀÒ·\ÌÃ°õ¯S´´¶\Ó`ò\à‰UrÇ©÷&¶m¹\è`\ì¡g¹…©\èl\ÚÅ¾¡n\0‘\0\î3Ö¶.2,2+O;\ßí¶¶_+;w9\äû\âºiWty=\Í8\Úú.k++«¸¶\Ôo[ä™°¿_Ğ ¼½T\Ú2\Ó7[³‰µ\ÛÔ•±™¸š\Ùğş¯\ï40¤¸U˜\ão­b\Ò\Ô\éW²±¤¿µ\Ô\"YU\Z \à–§5\Ş:$©Ú¼öó\ÆW—7pÀFª\î\É\Æk©ódE#$qZ\ÓQ_	\ÏU\ÍÛ˜ñÿ\0[\ïA\ÈyIñ5º£\êM?R¹7Wq\ï\ê¤\Õ[ßšH\×9\ïDn\ÒE;&Ø±\ÊDÛakv\ÉÄ‘ ó\ëYvv¾b?w5b\ß\\²M[û5İ˜ı·‚µMldÖ—7\ã%B&û•\Î\ë>ƒOlwr/ŠõDÓ‘mm\æ$¸\Î	\å~µ\á¯\æ\ç\ì7LN\î‡Ö¨†`\ÏF\åH\Æ1Q\ì=+¶Ö´/´º·R2F+’BTƒ‘\ëLBE\ïN-¸aGJ…Iõ©*0yFLŒñùT[rzwâ¬ª’8\×B½\ã@@ı\r\0ô\Í<\İ{RŠ‚F}h\ÊI=qšp¸\éP©n1Ú¥\\\í\Ï\ë@D¼\á³Nš\Õ<GµB	`1Ò¬B\ä§8 gR\Òó¸¨\Çz\ç\ÈxŸiŠôi \ĞaA÷®gV\Òú°\\øR°Š\ç¯z°Œ1\ïT˜4nQ‰TÑ¶N)½H#õ5\"ü\Ç\ÓÒ««\åpO=ªDb23@C\ÙÀ\ÍJÀ Œ\ÕE\Éõ>\Õ23g¥\0NzŒ\Ô\â0zô8\Å5px¸§3\Ø\Ğ\0\Ù d:9\Æ) 31\0Œw>”ò9®h\äsRu\'\å\ã*.qŞ”6\0úP¡vF[±¡ò\èsN\ÎF;šal{Š`\ç\ĞÀ=úñCc\Ô\Î\Ù\ï@§#9¦\ÈA_ó\Í8È¸\é\ÍBÍœ€OOj@LŸw¨§µ¿\Êk=\åØ˜\ä\Õ<ÿ\0¥r’:\r_P»¶¶]J\ÂFVC–\0ñU\Ó\â}\ë\Ú,Vöµ\Ûy„ñø¨\ëùŠmŒ\Û\âkyW(\ã\Ökh‘#º0\Â\ç!WŠW±q‡3±\Òh\Õ5kŸ\íbğG¿\æT@Ï¸+[Q\Ğn\í>d]ñöd\æ¸ı?Äš‡†$]³ù\Ö\İ\Z69ü«\Ğ4/iúüy°¸X.OŞ·—î±£q\É8»vaò¸\"»-\Äéª\ÌL~ıª‹Ic4şM\Üd»÷û§\è{\Ó.´\ÉÀ~h\Ïñ-Z½¦jjFFjóExş©\\\é“\0®Jç‘šô3]†ö5ù‡™A4\Å(\Øñ[]nY>ñjµ&¨\äq´\çÚ¸kK}V\\l‡õ8­»M^º*°\ÉI\Æ\Ò\ÄW\";9™r\æ}À’F}ª’°$¶\î}3W.¼\â\èÀ?e`G&\ÖLš‰­¾Yô›¡\î?Ê®6%¦%ı\Èqœw®\r\å{©‹Ÿœ\à÷\ë]õ¶ª2²X])\Ï‰¿Â± ĞµI¦|ZJ¤œ\å†*\Ñ,½¦œ6\àû”qŒ\à\ÖØº\Üx\ÆEP}M+G–\æV\Ì\Üp:šnŸ¹\Æ\æ\àv©ve-\rx\ŞI\Êzuµ­cÃƒƒŸ~õ›_¼+JĞ—u\à‘\Û³fˆ\é¬÷}™sÒŸ#=j;\"U€?*\Ş”õ‹5.\Ú\Æ7#Ú¥o™¹üj\Ä6\ä ù±\éVÇ‘¼`})’ñI\"°\ÆsĞŠÄ¼\Ó\ä\Ég=sŠ\îã³·;À¦\\\Û\Æñ\ã*GµiN|¬\Îq\æV0ü\'~,oag\é\Ãjõ8\ä‚\îñ:H;×‘_i¾\\»\âb§¶)‘\ê:Ÿú¹[\à‘]*Z\İÒ…Ö§ \Åö¯2\Ê)9\ÚW¥t\ÒGò\09À\Åyñ^¬ 4œ¶j»ø\ËXb\0LıóMi²&I½Ù¯\âM=¿¶¯€<\Ü\ÍYğÿ\0†\Ö\êAn	 Ì;û~5\ÉË®\İNû§\îˆ¶x©´\ïjV&D…\äDc’G+o\È×™(\èõ;¦ğl^¤Ÿhq±ƒ]\Öulì§•\äTù\\I\Çjó[\Ïjs¶<\é‰\í\Íe\ÜMy}™.dlzZE(ô0’”·eyœ=ó\Ù\É\íWl¬š\âF–l„b³\ÕH†NqŸS]$\nR¨šrvZ*\ïRJ\î-/M\ä€$\È§°ü\ëÊµI\äÚ¨Í™¤&YH\îÆº/ˆšÌµ½º–‘4Şƒû ş§ò®%\î\Z\îC3uz!µÉ¨õ±2\\\Ê	b\Ì{MW“Rš\Ö\å\\dğsRµ\ÔfHÊŒü£Š³3Õ¼\ãAt\Ëc~\ã$aZ\è|C\á°\êo,ùS\ÔW€\é÷\r›A*\èrâ½·À><†x†©\Éû\Üa¹=)¡3––¶\àsMô®ÿ\0Ä\ZY\Õ\ïm#qU\í\\‘_`ƒ\ÜUT#p?Ö–Eİœt\Ç4\Äp3)\êÁˆ*=³@\r\n\ßJx\ËùqR\íùz\n`\È\Ï€+U°9§‚ON9\êA\Å0€8\ç\0õa\Ü\n‘y\è~•C¨\É\ÍH	iˆ™54ö)u`yöY˜Wô©­.l\È_z\0äµ+k¦°4NCšõ+\Ë®£\İ\Ï=\rqZ®—µÙ‘yœT´3)=ñ\í\ëR£a½}\ê\ã\á‡5:É¸}©»\àŒ}*Uaœ{U4q¸úT\é/\'9 i&\'¥Jp	\ïU#aŒ‘Sõşt7½iK|¹sP\äc§½I¸ƒš\0Pvxç± ñƒs\Å!9#oJoÍŒt\çó 	‡\Øş”¬xıj0H^ON´»°\Ù P\É8 škG†A´Am«s@\r `r*m­\é\Ø\ZsşõHe\äp9¤\ÊH–Y\Éb:U£-•n*TQ£V\ã‡\å\Ï\íPÙ¤bTX\Ø6W\0Z\Ñû]\Ä7\å[\È\ïV¬´\æo*1\ĞVÕŒó8]§hû\ÇÒ¡\É\Æ?‡#Á`7\ßÒ‹=$‘e]\Ê\Êr1^‘.—\ZC´(À\éX3›{m\ì¹\ÏÊ½\Í.q¨?ˆM®\Û-ZÙ®­Xq&>t÷­[;›»x~Ó£\Ïı¥bZşö1ô\ï\\´Œ.n<\éOE°¦–š\Æd»°™ ˜td8\ÏøÕ©\Z\Ëutõ=\n\ÏP\Óuˆ$òœGr \æ6\àƒ\î\ryŸü%Ú¶“®\\±–Ve\0\Ó5\Ğ\ÙøƒH\×$òµÁöANú·\'ı +Xğ\ì7M<r­\ìmÈš3÷³ZE¦qN2‹´ø\Û¥Tš\Ş\ÓC<›\ÕNW¨±@PÀ„ü«{F›mÊ…\0g±\Â\Î\ä\Ö+\ãöE,‡§Nµ\ÜÁ*`±Bz*h\'P›%‰sô¨fš\Ô\Z\ĞVc9f\êhA_3p\ÏPk•¸˜»õ=+¬\Õ”Ü©“w÷H®J\îY›\ËV\ëZD™#^Ñ¦\Ş08\ãñ®f\ÊM±\ã5\Öj\Ñ<ºMÊ²òT\ã&¹6\ÕWis\É\íZô3\êi[»JB*‘]f‘§2Dk\Î8\ãe;Ev:|Ñ´Azc½e7¡¤ñmı\ïÒ¬\Æ\ëAÒ‡‘v‡Ş«\ÈÀ\ãš\Ì\Ğ\Ğş\Òq€\ãMmU÷w\r\ëš\Ï;ˆ\ÅF^4 MRK©-¾† ºiqóR\Ç3\';³Æ²Vq´\ízf£g”3Œu§¾Èµl×¹½ˆX1\Îk&{ûr\ÄF2}\rh\è:,º\İ\ï–\î<•¤9\í\íZZ§€@}\ÖS`c\î?9?Z\Ò4\ÛFr«\ìr	¼l$€Ù¸\ï\ì[…;¥QÒ¯^h·šY	4@d\à2	ªss\ÚF:÷¥ªĞ­\Zº-\r>5p\à\ç¿z¯<p ùpNz\ÔÖ®³’d_`Tôü*)\í†òw¹şé¦›±GÊŒ>óŒ”\Ù?\Ô;8\ÊÕ±;sÜ•,öq­»oo—\éT®\Èv±n­£\"†=\Z\Ú.`´i&$”R\íÎ³PCYsƒ?\íû\n¡‘|\×ù‚\Î\Ú\ÖJ\æ1v<\ç]ºk‹y^\\‰\ï\ÈËº¿\Â?*\ç,\æ1¹Á^™¯S\Õôs2!·ƒø¿…¾£µy¾·¢\ŞhwªfˆªŸ\ãu¾†©°\È98ö\é†\íFğ\Ê0z´Œ)ˆ£r\Şbµ~\Ö\à¨I£b®¼‚\rG\"y±”\êJ©lşL†\'¦#Ü¼\ã\èn¢M+Qe•Y¿ŒzV·‰ü.M\í¢‡–µ|\î.¤KÅš\'e1œ©A¯}økñ?ÂºN¡ò\İ*\à\ÒñªBg%¿”H#ŞŒ(\0~µ\è^*ğy‹7VŠLG’ğ\×,m2°\Æ=iˆEq3R\0SùUt9\ÎjPrqŠ\0yUe9T§9\çğ«8$ñ\Í&\ÎHö Es\×\å\È?Jr‚OZ #ó4Ï™O˜ğ9\Å?hOÿ\0Z£\rıiÁ·\n\0	˜?-XŸDK«r\ã«\rT\ß5¡cxÑ¤\îS\ïHYÑ7?&{W?\Ìr\È\Çc^±«Y-\Üe”H®VÒŠ\å‚óŸJ–†eG $\ã§sS«g¡ª91¹RÇ¯<ns\íHe\è\ä\é\ÛÚ§\È\êO\áTQ‰9«²2Iü(Ê°\Î?\np##\08\Æ*EoQL	@N‡¥?<÷¨‰\ã4ü\ãŒ~4\0¾¼ñF\0üù¤\r\ÉÀ ı3@,q\ÜSL£nO#¦3H\Ïò\ätéŠ‰\Ï E¯8¤\Öğ\Ét\à‚¯µ“B (úÖ˜¶xˆ\äÖŠY	p\\qı*[4H\ç\nFr\Z¯F\ê-üª\Åı€TfŒ}+$Jbu\ã»zR..Ç¡øaü\Ë`³`(­z4z4v\Ğˆ\ã­xu–·ı˜G–øû\Ñö­\Ëo\\O‹d½»\\ñ€\Çù\×<“¹\èBšœU™\Òx·QƒG…£<\ç*\çõúW™<Œó4Ä±\ç$\ÖÖ¥£¹º»¹‘KuyI?©¬±ıšN\"Ô lŸ\â`*’±\Ñ\n\\¤h\Ü`sš™\\²Œ€}iV\Ö%\Üş)\égò±Å·ı\áL£&ö\İI\Î9ö\è^–\Óû;=|ô2\äW5³…\Ï²õ\Ê\ß\ê/¥$‘\ÌÑÀd=kXjpcÇ¬\"Ô¾Ü¨\ìEhiŠ^\æ<sšÓ¶6÷v…<°µZ²²h¦P­qscq^=Œ\Ù8ª³J¶ÿ\0, 2‡5,†H\Û*¿^*;¹¡0\í@c\ÆqR;¬\\FW)´çŒƒÒ¹±+¡\Âı\Ü\ÖŞ­l¤*t\ÚOJ\ÊTò\Üóõi¡2–§‰,\ä\È \ì5\ÂXI\Ébs\Î1^©óo)\Ûò\í<\×	dˆ£ ‚2x­Ğ‰-M‹i™q\Åu:kmŒ\î\àõ®r\ÉÁ\0~u\ÔY(6\ë\ÆMD™q,\ï\êÅ¿\nie\ÆI<\Ó$Vu´ b\ß1jlnIn3¸\â¡ó\Ó9\ä\æ¦‰€zÔ±\é\Û\ÎIúb­E-\Èroa°¨/\Ïz¹¶\ØÙ‹Œg¥\"\Ø:{u©\ÈD`\ç4ù»/ssAÔ†•‘\Ãl²K118®\È#˜Õœ€\ärj\ä<9§ı»R\ê1\rÍ’zö®\Òñã´µ’\âF	JXıoJö\Ô\å¯\Ë}\nMs\ÊDˆ®«\ê;\Ö}ş‡c<l<¶n\è*Æ›tn¬E\Ë¤¿>ªµõ\ËF\ÛTå›„Öµ²fhÀ¹ğ¼(s.\Ã\Ûj¨ğÊ¬R?™\æ\ÊFqÀ®\Éw%Æ¤šu´ŒJ\ró\Ë\×\Ó>¦µ¥³ŠxDrn*¤•ˆ\Éü(PCu%mÌ•ğÖ—kd^g\åWsËœ\n¡¥\éºƒ\Êÿ\0;[µ7½\ï]Å”w{R`L*xŒpÖŸf\Èf’(\â\ÙD/Lzœ~”ù½¤¬e_xH±\Òn&–\Zú\ÃùW‡\ë’+\\\\\Æ\åI` ©\ä(ÿ\09¯Oø¬},\ÒRwaJ™\ÆkÉ®\Ü[\Éş*‰\Ê\ÎÈºqm]“\é¾\'“ˆ¯‰d	W¯\ã[Ï¨Aqk\åN‘\İÙ¿nGÿ\0Z¹](\í\Ú\ÃŞ´l\ì%·8Gù{©\èi9!ò2;\ßD\Ñ4ú<›Ó©Ì¿CŞ¹Æ†Tr)F+¶ŠYĞ•=xõ«sibø	$A\æ÷`?/h‡\ì\Ù\ç\Í\ç\îšÏ¿@\\d\Æ+Ò¿°\å\æ³u, œr:U*ˆ—>û‹\îkoH–]1\î\'dP©\äYwV“Es$[S?•Oi9’0ŒyQšĞ†}\'ğ\ï\Ç6\Ş%²\ZuñA|‘ õŒ<5£µ\åª·c?‡Ú¼#MÔ®´«øo,\å1\ÍeZ¾ğ/\ì|o£ù\ìŠ›g„Ÿ½\î)Ü“\ÆeŒ\ÆJ‘‚=ª4lŸaÒ½\Æ~{{»U/lÇ¯R¾Æ¼\îD0¹üqL«İ¿:•#š¬3÷°)\ÈX·$\Ó\ì04„du©ö‚AQ‘°\çŠ\0„)\Ï&¤û¸À\ç¥\Ürs\Í( j\0z\Ù\ÜpjXĞ‚Up77J3/\Ğ„¸\Ç\éP\ê:P¹Œ²œ~u]X“šÑ³½ò\Æ\×û§Û¥\0yÖ«¥2;|˜ úV\'17#ºW¬\êº`»B\è\â8÷®TÒ	ùpECC¹”ŒëŠ²„ñƒù\Öx\ÌLryj\Äm‘Á4†^F\éÀ\ëR\Æ:úš¨\Ğgz˜x¦\áº;Š™_p\ÅU\Èb¥V ó@’\0Á¨d‘O\0`Ó‹ü\ÍWwü\ÏJ\0’@Q’k{J\Óü¤H¹\'jL2Ÿ:@k§X„^\0¤Æˆ!Œ¿\Ş?J´eP¸c©ª—Wq@…zAU¡In\×sYüMM‹L\Ğó\ÊU\0+\Üö¬-f9~\Í$0™%n\Ñ\Ím‚\ÒÊ–¶É¹˜…EwZg…R\Â\Ótª\Zv1ôö©“Q4„\\™\á6x\Æ	\n\Ûù±ƒó+ŸÃ½^\Ò5e¼\æû\ç\0£®9ükÖ¥ğ\â\\\Ş‚€ÿ\0ñŠ\Ï\Ö>Ew\Ì)r1\Ã–Eúô“„·\Ğ\ÚÓ§¶¨\æï´««\Ø0\×/*£w­i>D\\À­I\"²Mñ†\íyjŸz\ŞAó(úWo\áˆ:¤«gy>\ìpc˜`\ìj%¶7…x?Qğx^Qˆ@õ\â¤ÀnŒc\é]d\×vÇ¼:8#¤×œø\ÃÆ·\é®YhšYXdœ\å\å+–Q\íJM\ìT«\Æ;’j~³&Á^¤m=\ë\Ì\ï4+•–};\Å\í\Ü+©mKP\Ğ<A³Q¸–\â\Ör1$ŒI\\Ö¹h\í5u\Ã[].\à{dVÑº\Ğó\ê\Ôö’¹\Öhp}¢W“(\ë¢ò\Ù\Æ=1T|=o\å\Ø8Ï­j´‘ƒ‚\Ã\è{\×;Æµ\ÉLej­\Ô\Ğ\ËÌ¡²?R±‚lª¿5™,¶\Ñ3%\Â7\Ê1Á mB\Ó3\ïGR:\àj˜-»rzt­Y#…\×>Ù¢\Ö\Ê—å•\ê2)\Ü,`\ëL±i1\ì¤}+€²\0Œc½vş:”[\Ù:\'ñ0+ŒµS\åt\äV°\Ø\Î[›6*LuE|ƒƒ\é\\µ§\ÊTw\ï[ñ\\\"¢®A©‘h\Ö\n	ûTl2r0TK¥\èZ»	\0\ÚF=\Í4\ŞÈ—{±cB£w\'\ÜUû7v\Ğ\Ğ\ÕT IŒŸÎ­[Ã¶\à2œgÒ^\â\æ\ìGpÊ€rµW‚s<±#Æ·\åĞ¯¯¬\Í\Ì†^€‚\ßA\\œ\É5µ\áX\Ş7˜cW¶\Ä\è÷g¯h\Ïaon[-Û’’\Ç\ëYş2i\Z\Êt“t\Êc\ï??Ê¸\Øu	m£tò1QjzÔ—w\Í%\Ã4‰÷X’N•´e\î\ês\Êö‡{+x\0^¨\ZÌ†)\ZF¹¹Àw\àı\Õô®.mvkˆ\Ê\Éw)\ÆóşZÇ›S‰\æ¸#’\Äò?kU$d\à\ÏC\Z–—kxm‘\Ğ<‡,Q~Qøú\Ó\ç\Õ\ì­ö¤-¸»rGa\\­Ğ1ˆ¾c\ëÖ¬½\Ñ¹\Óiô&pög &§g•ı\à\æ™«\Ù\ØÚ´Šw¹\Î\ÕÏ½p\Ñ^\È\ç&6\èsL\Ô.¼»`¸\ã\'­\Ğ#ŒñuÜ—ú¢üû°Å¤úšÏóW†w¼\Ô\î\'\'*\\\ã\éZ…2»—¯­s·vt%dWE1¾;*Ó\ßx×¥T‡\È?…j\è ¼™;ıÚ–RE›M<³–¶\"³X“sZÀF8¢@N•›‘j&\Ê9\Æ*„\ä\Ü1[\×V\ŞdgŠ\ç\îa(\äg9ª‹¹2G\âKUˆ½\ÊF7?\Ê\Í\í\\L€\ÛÏ¹~\ízµ\íš\\Û˜\ä]\ÊzŠ\åuŸ	\Ê-š{\ÜB9\ÚÌ¿…uBZ³¦$r	0=«OC\Öo4\rJ+ûZ9bl\ä¾\ÇÚ¹\ëynbG=sWAöúš\Ğ\Ìú\ÏÁ3\Ó|q£m,]\ÛqnO\ê=«ñ‚ŸO®mT›f9\r»\ìk\Êü×¶Zöµ³¼bÁújú_A\ÕañF€&š+\å¡\Çq\íLG€:˜Ø«\Ç¦n%:\í|e\áY4Û†–$&\'iô®!RA\"¨D¨ø$S\İ\Ô•\0\Ëp*e8\0»6\ã RGo¦*R@\ïM*;şT\Zp;9=1Š+\Ïj8\Ç41*œ®aP\î\ëÁ§(Ç­\0h\Ú]\í!ñQ\êúR\\Á\æ!ˆ\àú\Õ`;\ÍjY\ÜDn\Üzš\0ó-WJ*\Ä\íÁ‰–F\Ú\Ù\â½Y\ÑV\î3$*3Nµçš¦˜ñ»|¸+\Û-\r‰.ü\×Ò§˜€}J KFJ’sÛŠe\èGZC/)\Ç½\é\á½êª¹\êN¢¦Œñ“@\ß\êMh\é:{\Ş\\ ”ª\ÚZ=\ä\êƒ;k®bÓ­‚Œn\Ç4iDvĞ„R\0QY÷:“11A\ÎF3PMq%\Ë\ã\î¥7)6©.i1¢X şörÏ­]µ\ãQ¸\Ò\Î\"\ï!Úª£“T­\âö\â8#V’G;U\0\Í{§‚|‡l\Ö\â\á\ï\ä3pz\nEü-\à4h\æ\éü\ÍA‡\'ª\Ç\ì?Æ·nl$D\'j°õ¶Y‚©$ğ+\Öua\n0Xğ©ı\ãş\nEÆ¤£±•s,p\È#eÃ·@)\ĞJ\íb\0íŠ Š\ÆFšSºF\êjBŞ´{8¢i—o4›=J\"³ 2\Ã\Ï\ç^}\â\0\Ãtµ¸˜¨\á“\åwv÷D\â68#¡«¯‹ˆp%Zµ¦ˆÉ»»³Á>\Ï\â-tv—Mqn¿ò\Â^~•¢\İCq\âÑ¨jw>\\pA~µ\í:†Ÿ\äNiy\ÚO5\å¾\"š\×O”A­i\à\ä\áfE\ÃÇ½=\0\éµM6\×]°hœ«>W8®\Z\êmK\Ãğ›\èš{`ÙŠA\Éü\êÖe‰MTY£ù5lI\â5£Ã¨Y\ì\Ã\å5¶€zõ¥º\Ålªˆ\Ê1‚;TÎ¬OJ\Òy$HşX\Æ=kP¸-\Û\'5ç\è\ì‹\ÊTœ\Õ[‹Q¿ºñ\ß_C¸¸–wqÇ¿5rñnwsW¾iP\Zl/ \Ú\è~‡¢-\Ú\r\×i–¶±I i!eÁëº­k%½‘\nüc¡ \'ñ\İ\În\"„s“œV5›)\n£š“\Ä7Q\Ï\â¯\Èô«VZL“\0ñúg5º\Ò&oVoX\Ø#[‡8\Î=)òi\ä’W \n«m{qb\ŞM\Äd¨\îj¦¡„`õ\é$–¬oDe\íhs»?K\r\Ñ\'ó­£IFF:U)-N2£§µ>{\è…\ÉÕš0],‹“\×Ş´m.\ìŸj\æ\Ú\É8ö­†y•W\'&N¬\\ı\ÚX\êM\"Z><•‹¨\'°u‹¹å³ˆJ\ì\âi‘\ê±\çÏ¿Z³öä²H®-\Ù\Òe\n\Û[kmô²¯\îšö\è\Ü2ˆ\Ğ\0E ­T’‘‹ƒr»4 µ¶¸²O´\İ€Â®\0äŸ­e_\é\Â\Ø\È\Z\åYÁ\Â\ÃgÜ‘Ò¥†\â²R\æ6e“qWº{wşUY.#’\ìRT\áGzV\×q6\ï¦\Äö\Ö?d\\‡Ş¼Ÿ›\0û\n¦\É™Oj&pD`òüÿ\0•f\ãM\Ô5IÕ­\àeˆ\02zT\ÓxgV¸\Ã\ÊF\à01Z«t2o¹oH±{H’\æf%I·Á\ì£==Oô\ÅWx\ßQ½È¦E@jÿ\0v\ê{ö=©‡L\Ö\àFW\r\"ûw¨­®/- •.sbr\0ö\Æ?/\çC‹·ms2ª˜öBK(Â±\ï\é\é\í\\\î¹v\Ík3vÁUö=X’\âI%ù\Ø\Ç\0Z\Ã\Ö&ód?(\ä_J‰3H\Ä\ç¬Q¢¨\é€kfÉ¼\È\Ê÷µ^;~¹à±­=6Ì´£+&j†EeÁ\äÖ¤0ˆ\Èe\á‡z´\Ö\é”ûÃšaWŒ‚F{\Z†\ÊHÕ‚ÿ\0Î·\ÃF\r<\\nU\0\ÖLŠR?98=ÇµX³›\Î]\ã‘PQ´‘ù‘üb²u0 c»a†8§\êvc\Ë,\éBv`\Õ\Î\"H¹#@$ö÷Hr=«~xz€Ÿ=±‘C]1g<‘‘©økLñ\n\ï\ÛöK\ì¬Q\Ãq\\…×†µ[Ø­%€³HÁQ×\Õ\Ñ}ôD\Ú\ê^2~ITr>¾µ\ØX\ŞC{j’F\ë4\î¸\íş²m\íi\Ú$vš}¦•œ+6:±\êzÆzuµ½´¢…\ã^s£–†f}\Ê8BzZô6o2\Ü\â=*\âC7ol\à\ÔmZ:0\ï^7\â\ß\nI¦\Ü<‘.\è‰8\"½^\çRûL\È~Tú\Õ8§³\Ömä¶+¸u\ÇZwóûô§‡\ç\"º\ßx]´É\â£\'‚+‘l¡\çŠ`H¼·\\T»py\äzT1œ`\æ¦ó¹\æ˜#Œ\à\â™\Æö£¨\Å(\È\íŸJ@5T“\ÍOÀ?˜¦dn\ÏJV?6{SU89\Å=sœ€EF˜#&¥G\Ç\0ñ@\Z¶7¡WÊ“j· ‹´i\âv3Z‹pÁ óZVZ†\Øü¹W± (Ô´\ÆW?.\ÖŒÛ¢nıU\êš\îœ.	™\0\r\ÜõÁjZv\àJAüª\ZŸ»½_…\Ø\"óïŠ¥oj\áˆÁ­ı&\Å÷ù’Ù¤3R\Æ%±‡!~s\Îi\ì7òOZ{.Ñ½ˆª³K¿\å\0+L7N¸\ëV,lg¿»h\Ë\Ê\ç\0Ö“M\Óæ¾ †2\ì\Ç\0Z÷ø6\Ñn.Zñ\Ç_\îJEø+À\Ğh1%\İÚ¬—\Ä~ÿ\0õ\ë´,ZV8¬½Jş;x™™ö¨š\0‡V\Õ\Ú&%¸\0:“\é\\˜ó.%k‰\Ï\Ìz(\è£Ò$¯q\çÉ£\î.zñ§\é\Å1=})Œ}©IÁæ¢õ dn\Ç9EZ³¾ót\í‰CµŸ+u\ÅTw!‹/sš@tL€¹\'¯z\Ï\Õü7g\â+f³º€>îV¬iWO|›˜¼n\rS\×<sa\á\Ës‡—wx\Çi“pØ‡\Óı¯\Ãó g•\ë?\ïüª-øóNbFü\ßLU[=z{•q4i±˜”†v­n^\ê÷\Z•\Ó]\ês½Ä§¢“€Ó°ª7‘\ÈF:Rn\år\ØöÛ¿2µ±·\Ø\Ö\r\í\Ò\î+“\É\íWu\É^4 9Q\éš\Æ\Ó`k‹•m¥±\ÎI¯4ôR44øZ\Ò!ŸNµu\Õ\îTíŸ­X\Ø\Ê6cõ§,J˜\àg¯4È£H\ã‚+•ñN¤\çô®£Qœ[\Û1\Î;\Zò\Í~û\í¼y\È‘N*\ìFHM\Ô\Ï6ò\Äæº½\ækk¸”\à‚:\Õ=2\İ\"U–Eù{q[8ğ€;\n\Ù\ë¡j\Íx\à†ñÈ€’:P\Ú,p¹’\ÃÌ¶»IJy\È\í]6§§£B·V\î#8<©nÃ™½‘\ÈIfğ\Èc\É?…\\‚Ø”Ps\×5p\ÈdR]#ŒZ:$q\\_G3\ßiªR»²%­.\È\ì<u|\Âv\Ó#«¦x4ÉŒ²8“\Ó\ĞVŞ ’\Íym§¤\íonWs²p[\Ø\Zl`ye³õğ0]œ\íj\İEu9œ\Û\ØÊ´»œ–µ‘•0&s\â«Ë¦iÑ„·å¾˜­\rBİ¬”\Ç4Ö°\Ûm\n¥¤\Úq\ì=k]cM±Sö{™\ã†<~›ú\nz©Ÿ7†‡Ÿ\'•\îzŸ¥\\[3IE32/4‡$ı¯ò¬™5«û\ÉY,b).]\Ïü\Ôrh7\ìñ´\Å²’v—\É\0u,{T\éĞ«K«6\Û\ÄZ`\0»³„¥>\ÛZÒ®j\Íwõ,MfG¥i1Y\Éq5\ÌÓ„;sÚ¬Ş‹N=jÖ›Q\èÒ²\Ú(i\ßÊ€‘–v\'·°ştÔ™.:óÖ—ñ\ÏşÄ€V~­u9[1ğ‡“«\İøv]>X\â[¬\Ì@İ·#f}\ê[RZ{‡l\îeBx(:õşU\\\İ\É\å\ìbx\ì‘,\"\Õpe›=…q¨†\æ\á¥tµj\ë÷\Şa–Bs“\å \é,\íG’Š:¸\0}+)J\ì\è„lˆm\ìŒòc\ÔşU½i§e\ëW\í4Õ·ˆr{Õ‡‰c™¶ù¬’3De\\Œu\éL0\ï%Hæ´­V\ëÏ³\Å*z\í\Ï4¾$ğş±¦X=\í¤xÀ\É2\ËøP£\'°œ¢·f$\ãÉ„ƒŒc\Z¯£:y~Xo»Ÿ\ç\\«\ã;\í\ïlö\Ï»\êx–\äëŠ’İ¿P:\n\×\Ø\Ê\Æ~\Ú7±\íúh$\n\è\Z¹³*G8®sC&*AMuq\Å\åıŞ†°58»\ë?/vz\Åd\Ú\ä^õ\Û\ßÀ0\àz\äoc\Û)#Š\Ú\Êh\å<I¡I«ùh€\Î\\/\çŞ»#co¤h¶\ÚuºQ/©=\Ïõ¬\è§òn@:\Z\ìtM55I>\×(\È\è™\ì=k¢.ú\ÓVw0,É‹lx û\×g£]ci\'€1M¾ğ\Ë9\ß\Z\àö\ÅPXg±SŒ3p>µkC7©gY\ÔÁ/.r«ò\Æ=O­3B‰\í£ûCŞ¹\É5O\Ûõ%…\ÕC\×\Ü\Ö\ê>\Ü(\éŠ.I­<\ê\Ö\æ7PIŒW—ø›\ÃSé³»y!\ä^¿¡\ÛŒ\Ì\ã“÷išşº•»&\ŞôªLg\Ï;J\ç9\ÍJ®1[\Ş!ğ\ì\Úd\Ì¹\à\×9‚\â¨E¤=ûT¹N=±U\0\äTªÄ¦h\ë€I¥<ğ§ô¤V\0ıiË£ñ Q\åJ2IúPJI\æ˜#\î^:TÁğœUh›h\ÏS\éO}(v™¤ƒ\Ë šæ¯­ü©	#*x®€¸\0Ö¨\ß\Û¢-´˜-n\æ9=Mj[J«=³Y°¶‘ºŞ¦ó2\05#,K/™‘ŸÂki5õ\ÊAe‹\0sE¬—“$q.\â\Ç+\Û|\rà¨´¨Vú\í\\0ùAv\Ë>ğ\\:ª\\Ü¢µ\Ûôûµ\ÚQU®gX”óH¢;Û´†6%€\0d“Ú¸«\Ë\ÇÔ§\ÎHOÊ§ø©©µ+ó¨\Ü£?\è\êy?\ß?\áPª\íÒ\Â\àP8ÒŸÊšicœ\ÔGz˜ğı\è¤\Çµ¬—³lL\íş#VÅ£Ü¸Qü« ,tHa2G³6\ØÕˆ\0s¾-Ò®-ü5²\Õ\İ\0ÿ\0X\à°÷¯(…\ä)´—nE¿3À¯¡\ï\à[»)b`u\"¼W±:v©<n3µ #4™q3]³\ÉYN8lş½\ê\ì34\r¹Ok\"In&\Ô|\Ù1ÀD\0VŠ\Ã9?L\Ò,õ\Ü&(3\×kÃ–şP.\çz«µe¼.\ÈX\Æk£µ‰R,\à}`×œwt\'i±8\Şeo“…¥\ZE uşU=¬;#%º\ĞI\Èx¶\ål\ìİ‹\r\İ1^gµ™\ZiHF\ã5\Öø¾s¨\ëF\Õ÷qœ·¥s:‚+\Íh0‘÷­ †l\r0\\YF ;†qPEÖ“€À\ß5\ĞøI\"”¡\Ñÿ\0J\Öñ–>i0z‚4\í-‰æ‰›n²5§˜AÀ­¿e±*rI\éŠv…“Nh\İİ¸©¡\Òö–-’=J9R\ÜNm\ìgZ«L0sÂ¬i¾e…\à“ ñW¼„8\0S#t{„PÉªM\ßB]º›owaö‹°c·“ŒV\\w‰\ZFF–;4\â$y	i®j·w`5\r) ‚P6H\'ƒõ¨epV«hLv\ã.ûÛ·5\Ğr\ès\æ\Ğ\êŸiÕµ5b\'÷q\Ç\Ôı3U4Ái=\Ãtõ<É\â[\Ğ•wP\×\Û\í8£Qn\Ô]¹8ö¨¯Í­’ViJü\Ûñ¶5ôÀÀ©+R½µ‚u†Í¶5ŒrI\ê\ß\ĞRj2ı£PşÍ·\ÊB¼\ÜÉŸ\á³\è?VÒ¡¼Q‹P¼·‘Õ‡\ÊU:}\0\éZ\Æ\Æ\Úx\æŠ!w™÷JşA%½\ĞQ{…¬\Î~Y\Ööñ0¥l\ã;cŒq…ÿ\0]®©¦\Ï\Ù\Õ&¶]–ñ“¾ø\éUlü5±‹¹=\Ê™«7\Úm¥‚ˆ\"w¨\İ#<™\Å%p—.\Å+@O2òX\çß«\ä+\\¾‰lšoô‰9ç§·\áEö§*\Ñ\Úı\æûò¤ûrZ…\Ğóaó™ŸjÕ¿ú\Şô9\ï©J\â\ÒK\Ù\à‰:;\0¿\ã[\Ã\ì¶ \Í2…€	\ëTõ;û\éw:”»Lñ.\ØPÿ\0Ÿ\çÚ¼zm^ûRœ\Ísr\ìÅ³×Š˜ÁÌ¹M@õ­S\Çövl\Ñ[\æWªô®RñÖ§vğ«ùQ·Lu¬`3ó\Z¥x¦9’LVñ£˜J´™©©}\r\Ú]Ew*Ì‡r\È\ZöOüm‰+mPNÕ¼QÁÿ\0xvú×‰/\Ì\ÏZ£13\\„uMic+\Üú¯\Å<=\ãk¶\Ù4Q\Í*\îI\á9Gú\â¼#_ğF§\à—.-\ä&C„”®\ßcQø\ÇZÿ\0†µe‡M¸2Zõ–\ÒòŒ;Ÿc\ï_@xoÇ¾øƒh\Út\â%»#Y\\u>\ê{ş\Ğ’ü8ñn\Æ\áşqĞõ\í\Ñ0h”û\nó¿ü \Â\ïû_\Â\ìK!\Şm\Ï\Şü=k¥ğÎ§%Şœ‰pñü®Œ0A\Ç^wGe\İXØ»€K#\Ä\êö†7-Œ]\Ø9R3\\\æ³bp\Ã$VQvf²WG\'\\×ªx:´h¶·¡?Pq^[p6\ÈG½K\á¼\ÂO\r:w\á—€?Öº\àõ9*-±™2ò`*Œ’{\nóm{Uó[•ó\ÈWÚº¿^˜\àK\Î\ZQºC\èƒüMyú\í=S f¸_z¶\ÌM\ZÉ’1™–5³mdó]¤c8\Ï56Ÿo\äÅ¹‡\Ì\Õ\Ñ\éÖ‹~k™¨‹Q\"\Å\Z¢ğ\0\ÅHy¦Šršs^ Ñ–\î&;¯%Ö´6³™Š¯\ï\ÒF²)W)®\è	t®BõŠ´\Äxs|¬A\éšpn™ümkz$–3—*zVƒ\Z¡£\0\íR/^Ç®jš¾*U@<\ãµ\0X\îI\éÚš\\g¨D…úf‘€rI÷¦““À©\Şï¥1¸úS\ãaŠ\0”\íÇ¥2G\Ûb‘˜y¨g8z f\å\Â]6{š„	gR0NH\Ë\É\íI®ÿ\0\áÿ\0†¥yÄ©˜Ôƒ\ÍH\Î\ï\áÏƒ#µ·ú\í3!\0•\éÀ\00:\n«i\ÛÀ‘(ÀQSI(E\ç­f\ÊA<¢5÷®GY\Ô\ÍÄ¦\ÖùzH\àş€\ÔúŞ¬\È\æ\Öı\éû\íı\Ñş5‡\Z„§°2D@ƒ¥?9¤^zR4€p:\Ğœ\Zo~\r4·J a\Æiª4S½.ŒA$\Ööa´\rwrÊ‘ \Ü\Ì\Üÿ\0U0!f²ğö‘.©¨È±\Ã\n\î%»šùû^ñ¶¡\â®¬ò´QD\àA?qşf´>&x\êOjd´r4»v\Äj8óş•\Í\èZDš\Ò)¦y«Œn\Å{N\é7‹¨hö\×J\ÙF\nòÿ\0‰zxKñ:)nIõ®\ëÁ\Êmtd³sş¨ax\íNñ6—¥¦JŒ¤Á\ÅC™Iõ<\r_%±:\Ó\ÒLƒ‚1x\ëEô\Ê\îHYH\Ú\Ç WU=~¸©±¥\Ïv°\âK\ÕX\í–(À\Îdl\Ğ\Z\Ô\É\æsl¬W\ÒoşÆµ`·#\'ğÀ€z×Ÿc³š\å!.KJ\ÑIú\ÖMÏt­3R‹M–¦N\Ø¯5±qvA,q^o \Ëc«|FY\åEŠ<ªoG¦i\Å]\ê\Ú\×ô›H\Ş]HHAq»bµ\Ä\ËÙ“$­\ÂúW¢ø\êö\Ş\Ê…H,\İ\n\Åğ¦…syr5¨QG\îÔŒSC\èoø;J{[Ei3!Á<Š\é\ä‘P @}1T-t¹\Í+Bz`Õ¡k#q#n¹¢\ï©\İ\n3\Ë1Ø€ŸaŠ‡\Î>D*>•¦\éoIÛŸ\Ì\Õf¹f\â\Ëg¹ª\ĞW)­´­“\éI„iP®XúT\Ïo4¼\Ï&Ñ‚£I<†\"\Ùrÿ\0Ş£\ÔF\å´Ál2?~0¿A,w\"Aj–‘µ·Vr\Ù\É÷<VC^]oı\í\Ã;öE\è*.gaóJ\Ç\ØkÎ¶1pmÜ™tu]D\Ü\ÜMC?*§\ÌGÓµ%åµ²\Èa–{¦s¹”	§úVe\İ\ìE½§ód\ìŠxüjµ™\î@ŒğŠdW#dSø†ıfò\ÑUq[v:Ş£,B8\Î\\öQX\rjÿ\0\çûŠyøªìš²\é\ê|¶T`8µÌ®E\Ø\Ü\Ôo\äÒ­COv^\îOº€ôÿ\0\ëW\"óM)wšGbä““\Ë\Z¥=û\Í;L\\3²Hz}rú·­¬.M²ÎŒ\ß\Ä\à\î#ò¤œ›X¤tw\ä‡v\ä\á\Ëÿ\0­Yö0Iq¨¾£w„† 6“\Øòk–»ø…Ç‹XZR?½À®\ë\Â~/\ĞüKh¶Š\Úìš\ŞC\Éÿ\0t÷«PoQ:Š(òøŒx‡W‘mØ‹(~XÁş/V®^´õ¯hñO\Ã+{–{\Í13¼«÷Z¼ÿ\0Lº\ÒoŒ7P´l\Z\è‚IY²m»²Í»nˆgµ2ò?2Á\éE±+\Ç*r¡\×i\äU’R[‚¶Y\ÎHüj\r»µ0!”\'\å®X\Û6¡*>PrO  \r>§\é-p\ÜK>U}v÷5”\ÒIg}\Ì.\È\à\ä2œ~µ±¨N³\\lŒb(\Æ\Õú\nË¼Œ\É g\Ğ²x#\ãeİˆŠ\ËÄ®­¸tœÈƒ\Üık\ØGöN¿`5]*Hg,¹\Ä~÷³{ıy¯,\ä\İ	\äq]‡<U¬xZó\í\Z]\Ó\Äşò3\Ê8÷2ŠjÃŒšwG\Ò\áğ€\ÖVªD\Ç\ÔSô}D\êºL7¬6™>1µZö`”×³±\è­Q\ÅŞŒ1 W{ğ\Ò\é#\Ó50\íµ\"u‘‰\ì?üMp÷ø\ŞØ«~»x§/4¤R\'\ï<6EtSg=U£7¼A©I3\Èù>}\ËaG÷W·\éVô,E\n¾\íYVq¶¥©µÓ‘N{Wkg“®>c[¥\ËKa4Àò¯&¶€ÀÀ¨m¡òaø&¦¦1f£\rŠ–¡“\ïñ@™&i²F$\\S\æ¥_‰412;…úñ^U«io+aN\Üõô,ğ,ÑG5\ç\Ş$Ñ‘ƒkuö«L!pÑ”¨7u\æµ\ïô\ã¤\0\nı+;`ˆ\ÅP‡¦\ÕQŠ‘x\\cZƒq$T›ş^q@(\Ş3”\Óò´\Ò\çfAª\í3A P²Ë’*µ\å\Î\Ø\n\ç·_J†iÂŒŠ\Ñğç…¯üQx0¬–Àò\Ø\ëô g=¤h÷:Ö¨‘\Ã2\Ø8\×\ÒÑ£\Ò4\Ø\ãT\Ãcš“\Ã\Ş\r±\ÑmQR%\Ş<VùŒ \é\ÅCc\ÌØ¹ü…bkZ\Ç\Ø\âÚŒ\rÃ”tzÿ\0…O«\êQ\éö\æF\ÃJxDõÿ\0\ëWqt÷¼²¹gcÉ¤2È\î,[$œ’OZ•d\Üz\Öh“Œ\Ô\Æ}‹Œ\Ğ\ß<ªõ¦«’A\Ígù\å²ML’`r{Pòø\Ç4€—` d\Õ][wËœŸj\è4]%¥a$ƒ\n:Ÿ\éL\ZN—œK À}\ë\Ë~+üAû\\\á\Í\"Qöt;n¥C\Ã\îƒ\é\ë]\'\Å?¦b\Ú— ó.$uÿ\0–*©¯6–@©—‘ÿ\0R@>\Ê\ÊK\ÛÕ‚1“Ü\ĞW´xG\Ãq\Ú\Û)d\0~5…\à¿‚H\ëóI5\ê‘¤„U\Æ+¦+‘yõX[^G€\0a´ûU\é0Á—tª7HL,GUùªh\î‘£\â\Ö3·\Zg’|@\ÒMµÿ\0\ÚQx\'š\á\×,	\'yÈ¯tñv˜·\Úcœr+\Ä\ä¶x\çxH9 k+\Z§t}I»\ËL¹¡\ræœòúÔ—´­Œ*Uˆ${zW\Ñ\×s\ÄWF=2}€†y¼\Ó\áÆ›÷wÚ½\Ğ\ÄP±a\Ç¹5\ë\×6Iu\Æ\İ`×\ê¼Keo,z±\Ú36»3\ß\ç?8­\ÇÌ‘r\ÏH¹ñ´uI¾[Toİ©q]\Ú!H\ÕXğ\0\æ~\rñr\é³Ë¥\ëD\ÚÎ‡_8\Ó\ßiºŞ™¬Nğ\Ù\Ş\Ç$‰÷£ÁV\0Ò³Cn\åı\ê£\ĞTn‰0\ÛóÆ¬‹t=ip«ĞÂ‚nŠ‹g¸?iûGÏµL\Ä{\ÕK‹„‰If\Å)\àCóò{\ÖU\Ãùrˆ\ÚDDö\à~t²\ê\ß÷H\Ò¥gK¦\İ\ê,\\Ä€w,ùı)\\¤†^\ë6\ä\Å‹+÷\ØsX\×w“\İğœGı\Õš[\Ù-,dhš_6E¤8\0}MsZ¯N‘}ilBó*„\Ş\ä}I\Å8\ŞZ v¬\Ğ)‰HH±=)§Åš^„\Ï,·P‰¶\às’>•\èºü!ş1\ÑYô\æŠ\é]q(n%Cî½¿•y7¾	\Ü\Ø4—\Ú\é¡<˜‰\ä}+x\Ñ}L]u\Ğ\Æ\Ô~-\ËÇ¦\Úş[JpO\Ğqş,\Õ\ï\çy^\é\Ğ1\Î\Ô<\nÉ¸µ\Òw†\â&E8ea‚*õ¼i\Åº’e\ÙuKù\Æ%»™‡»U<ó@Á u\íV’[\Ûd‘Œ\äcğ§£™]•\Ôü¤}i°`N»‰§°\Ë6;(\é>ø³u`R\Ë]\rsmÀ[…túÿ\0\Ï\ë^•¢\è~2\ÓĞ´S#Œ¬‰\Ø\×\Ì\Ò\Zº\r\ÄÚ¯‡fK½:\ä \ã|m\Ê?\Ô“IÇ°ˆ< \\´±¡–\Øÿ\0:\n\ægsLH‡>µ\îø…£ø¶\İl\ï‘-¯X`\Å!ù\\ÿ\0²¥PñÂ˜µ\Ú\ëM\\|\Ûz\è\ÄxXB°	;˜\æ¯\è·B\Ù.\0A\æº\í{õr\ßA«¥•\Ì/\ÌH\ãê–£\äÃ¬!6E£¾õ@O2z÷¦\íbœ\Üò´œ‘\Ç4Í‡0]”\ÆC\×g\à_?Š¼OmfPı™™pÃ A\Ûñ\é\\…\ìG)(\í\Ô\×\Ô\n¼*|7\á\î®b\ÅıøHù•…_\Ì\Ğ½\å¢Ùº$)¶ ¡@QÀô®wWRªXW¤Od³\é\Ïn\Ã\æ#9ÿ\0j¼úş\"\ĞÈŒ0\ë~µ\ÃZ²¹\ÛBW:ñ·Qi \ÉvI\Î8¥ŸrHÑŸZnšş^¡v?8„\ÏJ\Ñ\ì$^8Qú\×Oaù<\Ã÷W§Ö¨Z\Ãû¨\Ñ9,o\Ã†%AÛ­t#Œ’Š(¦0ªòŸ¬UG;˜\Ğ&8sR)\â¢\ÚH¤!&¸X\Ç^k\nı’ô\í\ã4ıJGS\éT\"‰4\ÆrzöŠğ1.Tõö®:\âÏ©5\í\Ó[Gw\×‘\\>¹\àùw´¶Äƒ\×\0qWwG´gµE\É1­‹\í7R¶\È{f`ğŠÆ–\Ö\È[Ys\è\Õ]Êª•V\æT?w¯¥iXøc[Ô¤UÕ•Oñ?\è\Şø]—:‘ód€z\nM¡œ_„¼y¯Ü¥\Å\Ú4vÀ\äÕ¿ú\Õ\îºNk¤Z¤6ñª\í\àU»kHl\âÂ@\àT¬ê¢¡\Ê\ã°\â@Ÿ¨_GiM\'n{“\éR\\]\ÇM,µf¹û\É/§278E\ÏAş4\r™š„ó^\Ü4ÒOa\Øz\n\Ìt+\Óò­wA\éU ß…\0R\0¨æ£‘Á<ñS\Ï\Îq\ĞU7$PŠ\Ü\ZU“<g&¢\Îg9\Ç\0WA\á\İ\nKÉ„²¯\Ê9Ï¥\0^\Ğtw¸a$€…œö§øó\ÆV\Ş\Ñ6C±¯¥R°GŸ»ş\Ñö­Oø‡Nğvˆó\Ì@e\\G\êÆ¾^ñ½y\â}fk\ë\Ù37 Š*\ÒR\â\î}B\î[»©\ZY¥mÅ›’\Ä÷®\×Á¾’YRyW,}«#\Ã:\ß\\,Ò¡\Ú:\nö]&\Å- E\n7cµomX™¡cj–°ª(\Ô\Õ\ÅlZ…I\àÀ0ª`\àk*\'òL\î\æ7\ã\éZY\Ï5—~<«\Äq\ÒA´ıjf´¹ \Å.­Œg#\å\Zü\'D\Õdš8yœr+\Ò\ìg\Ú\Å½bx\ÃL[¨…\Ï#§Zç¹¢\Ğ\Úñÿ\0.¼?¨[Y\é\Æ!!Rò\ïM\Üv¯5¿ø»\â”$·>›\Ò\0HüóPx\è\êóøª\êmB\İ\íÙ›\åFé·¶z\ãd	Ê°$zV<±z\Ø\ÑI£SPø£\ãÑ™a\×3c¼Cø\í]ğ·\Æ\ï\Øjq&³t·\ÖN\àI\æ\"†AÜ‚ ~UÏ9Š3\Û`69Œô5‘u¤¤\Ì“ <©\íU\ÉÁ\ÌÏ±4\íCNÔ­P\Ó\Ş\Şh\å\0‰#Á\ÏÔŠ\Ãñ€5KÈµ+·°\Ô`,È †Œ;Šó„V¯c{!IX!L2©8\Í{¬­A®I\Ş2±\ÑM&®Egywª-ùŠIÀùš BŸÀÒ¾¡#$|ı(…Y2ú\ÔRLROº1\íY\Ü\Ò\Èd·,>f*=ª“#\É>­\Í>\â\è‡\ëI‹÷¸\Í!\ØÏ»/9‘€…r÷\ï!g>ca»fº\Ûö¤\n\æ/—i=0(@b\"\ìnµ\Æk±o¤—\ïp+²¾ö_J\á\í/–ş[›I\'‰\Ï¸®š+[œõ–1\íu\rG\Ãz’j:UÔ¶\Ó)û\Èqù\â½\×À\ß´\ídG§x“Ë²½o”Oÿ\0,e>ÿ\0\İ?¥x\íÍ¢\ÍN•\Ì]Z›id|¿\ÂMt£˜ú£\Æ´o\Ûˆ\"º+”‘:7§5ówŠ¼	¬xVí£º·sx?J\ßğ\'\Å\ÍkÁò\Çgr\Í¥do#|Ñö·Ó¥}¥k~ø‘£1¶’;•\Ûû\È\\bX¾£üŠb>3+\É{‡~	\Íg\æ^\èƒt_x§ù\é^/yg=”\í\r\ÄMŠpU†\r0#B ô©X|\ç ŒŠ‡¡wJ™\Î\n‘”À\Æ@©\á\í\ÊúT\rÔƒŠ}«mv\àŠ:)< Np{cµzo‚>-\ß\èK¶´^öË€¬‘\ê>µ\æ…r	\éS\Ú\"\İ]C8D$nf<\n\0ú©ô\ïxÿ\0LK»IŒ‹Ä¨0\ÃØŠñ|/\Ö4&3\Å	\Ø«§<U__hz´w:=\ËB\0ª*Àzù¯pğo\Å\r\'Å±\r7UH­o\Üm1\Éş®o÷I\ï\ìiù® va\×k\"—ç¹¯¡¼ağ‚\ÏR]\è\Ûa¸<˜Fú\Zğı[\ÃÚ‰x\Ö÷–²$±‚:\Ó øc\á!\âŸÂ·1î°³\"ió\Ğ\ã\î¯\âG\ä\r}<ˆ^8Ş¹‡>ğœ0º}uû\Ù\Ï|‹ø\n\ív _JMŒuq\Ş#±]ùª>IòOû\İë°®7\Ä÷şe\ÊÀŸr,‚}[½cY\'\rMi6¦yÖ¿KŒ§sY\nJ° òkZù¤Ï­a…Ê’:\×<6:%¹\í\Şµ\éPİw(\Ån\×ğ\ÛW:tš{\Çû§Ÿñ®öº£±\É%fQA\éLDr>\Õ\Çz€ÓKd\Ò\Ò€sŠ°«…\ÅE\ZüÙ©©‚2µ;O0d\n\ÃhZ6ñ\Ív¡†¬»\ë1\Ô\n\0«f1Sd£ŠÁŠ“vZ@#\Ù[\Ì0ñ)ÏµFº=\ìù+ùU”™ŒÔ2\Ókkkh\0\Û\Zƒô«-:-d½\Ğ^†«½\éõ¥qšò]g¥ejzŒ¶Ñ©Œ)rqór*5¾¨¬\Íj\è\Ş\n¥¿J\0Í¶\Ô\ïu?2K¹C ˆ\Ô\0=~µ18ª\Zg\î\ì#\É\äŒÕ£\'j„+j¬¬3\éRI RY\çš\0‚S\ÎqU$<\Ôò>y\Ïz\Ñ\ĞôYu+v|™\ïü\Í\0;@\Ğ\ä\Ô\'—\ä\à\äö÷®\ÃWÕ´ÿ\0	iIA\nv)8,GR}©ú¡§øGE3Kş\ê ûÒ¿`?\Ïóß‹|Mw\âMNW’]\Ñ)\Ã\í?)\ÇD_öG\êj’7\Æ~+¼ñ& \×H\Û	\"ô\Şÿ\0=+7A\Ñ\Úş\ár–~¦£´±}Fÿ\0j‚Fy>ƒÒ½KÃš\Z\ÚÂ¤¨\Æ:ú\ÖĞQ3OB\Ò\Ò\Î\İ\Ğ8­õ8ªñ®\Ñşğİ«@-	1\ß\ëNù\ÕQ \éùTúó‘N\Â/#’µ[PÌµ\Ü1¹\áRB\Ù_j{\0\È\ÊOQƒU\ËtM\Ì\Ç%BÊ£j\Ìø»°#©şt\Å\æY<g\ïFqT\ã˜\ÄÌ¤q\\RVv5Gy«hºoˆ¬L7¤¨G\Ê\ã\ï)ö5\ã>,øq}¡³\ÜB¦\î\Är$Qó\'û\Ãú×º´823µûú7Ö¹ÿ\0ø\Â\Ã\Ã6Dİ¡–\á\Æ\Ü¹=\0¤\Ğ\Ó>wm¶K\æI€\0\È÷®{R½{\ÍF,üŠœğ8­¯\ß6¡­›Ç¶Š\å;’8\Ï\È>‚¹»‰VI™Pl\íÈ©E«ğ\Ò\è£\î\ç“Ş½¢7\r\'\"¼C\á´LU	\è+\Ú $\Ä\0WoŒë¦½ÁÀb?*Ëº”¤˜\ëøÕ»û˜\í\â\Ü\ÌÖ¹«½]\åTx5‘ªF„ŸzS\ZM‹Umn\ë\åû«Ş£½“fBi\ÄS\İ\ír¹\à\Öu\Øi2\Ø\ÔS»–\İıj»]0X\ZhL¦ñ¯\Ì\Zò$º?‰¥š,Í¼\Ç5\ë°a•#5\Éx›FşÕ„°¿QòœWE)Y\êaV7E;[\Èo\àK˜±ó}\rV\Ôtõ¸¸\É\íÆ¹‹¹ô‹\ãŠB\ç†»8\çhU—•aÁ®£”á§•\Ùp\ë\ëSi:½ş‡~—ºmÔ–·	÷^3ƒÿ\0\×·«X+1>øssG»<|ÃŒSB>Œğ\Ç+U#\ÓüM²\Òì¢\è\İIõ\ÂJ\ê<cğ\ËFñu£Mn©\Ã.\ä‘\rô?\äWÈ v\ï^…\àOŠú×ƒ¦Kgsy¥\îù­¥oº:e·Ó¥1>(ğ­\á‹\æŠ\æòAÿ\0Y1\\³ƒ\æÿ\0²¯±tx_\âVD“¿¼·~%ˆŸoO~†¼ŸÇ¿&´ó/´?\ŞE÷Œ`tÿ\0\n.Š2\äû\Zb?¥\\¹³\Îc\ÌL¼\ÃO£\ç `\Óù•†flJ>z³t¡\í‘À\ÇÒ©Fv²±õ \r\èøÁ\ã§ô ©\Æ:`\Ô6Œ?­X# b€=Á?µ\Ï™®¿\ÓòËŸ\Ş\Ä=ñcÏ½{kE\áÿ\0\éQ\İC$wÁh\Î$‰ºŒúö5ò=Í«\Í<\"(\Ù\äf\nª£$’x¾ªğ§…%ğß„lì­¤j\r‰\'wc\ÔP?¥&ş•¥\n\É¥43ˆ\Î!•\Öuõa\Øı+Vt\ëšZC)jwŸc³gy‡\åO­yıÁûL\í$„\ê}MmxRó%m‡*Ÿ$c=OsXp\'0yb2k\n\ÏCJK\ß2u2\ëÓ¥sÀmfC]ûˆ·µqwrGL\Ö0:dß†÷MŒV\0N%GSøÿ\0JöšñÏ†º{\İxº\âûEl¬s	a´\ÔşU\ìu\Ñ\rj›…QVfDWiS0\ã5¤\"Dû¢MOº(izšcQN¡£9¦µ\Ç8óª\×\Z„0®dp=¨„\ä«|£5F[‰\î).utrD+øš\Ïk™$9&¦\àZó÷5 ñŒ\ÕD›³Tù\Í\0+9\îi\Zi9£8\Íš\Å\×\'k>;(_\ÌÖ±`=…rú\Ü\á¢\Ú3ó\Ê\åB,Û¸Kt_AR4¼pqY\é)\n ¥3q\Û5B,4§<\Z‚G$c^)›ù«šf›6¥t\í\'Z`;I\Òf\Õ.UB™\çŞ»«\Û\İ7Áú——r,pÆ¼Ÿ\âv\ì Sİ´\ß\nh²^\ŞH\ÅfIò\à\Ş)ñ}\ï‰õ\Õ.e²’4\Ë&<q\ÖWú?¥R@C\â\ïj\Zõû\Ë3\åu\ÂD±\ß\ï·s\\/,‹kl:Œq\ØT—²)M\ÆI\ä9\É\ê\Äõ&º¯øx\åe\ä\ä“ZF7C\Â\ŞÆŒ\Ê=É®\æ4X\Ô\0\0\éQA@Tv©	\âµ\å»R3qÉ¨÷riG\\\äsMÔ»ş•\n‘\éO\ÍZBe«w9#>õhsYğ¶U\Å5¢D6—lIJÎ¼O.V\ëWİ±¶A\ÕMWÕ—(%`\\˜ˆ\ÚW.\è\èüW\â\Ûo\é¯)Ä·,1Y\äŸS\í_:\ëzıÎµ©¼—·2a\Î\æ9\Î\ãô\Ï¢Ÿ]¾\Õ/§¾¾\Êòrw\çjAY‰/œT[õÏ¹¢$‡7ZŠ\ï$EpO@*#¥›aUNôsEXg6\í+\\0\Æ1Ò»i{ º•8^„\Ô\Ê\\ªæ3±\ÛxcKM.\Æ#°+‘É­\ÉõÁy6ø-Ğ±®SUñ,V\ç\ì°|ÀpH¬3\â6@Prp1\\.òw;\ÔRV:[Û©g“2\Èyíš£†>¤\nvÆ©µ\Ù0­l¶š€\0w©V\Î\èEŒ÷4Ë‹Ÿ0qR\Íb@\Æ¤ûc¦ 3¥\0Œ\ÕWPEjµ‹u\Ô\Èòp\nhLÁ™|¼œg\éT\å$‚\nœš\èÎpC¯ô\é§	\éZ&f\Ñ\çº\ï‡¦†X†É”dq÷«™\Ò/\Êá¬®2\08\ìk\Úm4ygº\ÃK+pG&¼ƒ\Æ^\Õ4Mn\á¯-\\•n\Õ\ÕJM«µb“6Ê«©\ï5\Îj¶Ì\ŞQWt]K\í1d8‘?QZ“\Æ$‹zõ¡‘\ÂÊF\å=ºŠ„d÷­{\Ë1m!v\İ	\íYrFA\ã\î\ÕoL\Õ/´{ø\ïl.¥¶¹ˆ\åd°xşuô€ş:\Új\â}¶÷\'\å[\Å»÷‡ğŸ~•óˆ\Ûõ>´\â6öúP#\ë¯ü5\Ñ|]jnm\Äq\\°\ÊK*ß•|\å\âÿ\0j\Şºu¸·sxp2+KÀµ¿:\Û\ï7šh9kY\n?\Ù?\ÂN+\è­Äø¤2B\É7\Ëû\Ûix’<ÿ\0¢€ù\"?\ŞX`öõ¬\â0\Üõ¯}ñ¯ÁÇ³^hŠe„ä˜»­xv£c=•\Ó\Å<M)\èF)ˆ±dü©\ç¦+Ko\ãX\ÖNG\àk ³¶–ş\îhÌ–fŠ;“@‡ğ\ÂcV\×[Y¹6¶).8üºşUôYl¹\èx\á}/\rxv\ÓK‡‘s+÷˜òMo\0\0\0t …¬ıZ\ï\ì¶d)Ä’|«\í\êjù “€+‰ñ¢f•‚[\äŒzZM\Øfj/\Û\ïóÿ\0,b\éN1n‘¤õ<U\ë;O³i\î{•ıjü[\é¬ıZ\æ¨\Í\è-nP»¶3Z1\í\\4¶²Í©Ei\n––GÚª;\×{\rÀ“HW–^*\Êğ}º\İxş6a‘o \×şµ\Ş\ÇDölô\n\èøG[pšC¾fõj\Ü´WRV8[»¸QE\Ä!\éU\İú\àUšcF\r  %ögw•jy£a\ÈTJœu®OSI…\Ó7cµuµ\ĞG:u\ZC8•nj`F+VóB+—·9pk!‘\ábH>ô†H>´\á!^†¡Wôö€´³\Æx5\'ÓŠ£Ó¡§¬¬­\×\"€\'•±Ø®GR9¸µ\ê\æº[¹‡\Ù\\ƒ\Û\É\ê\r»V²F\\D\É7ñJb¢\Ü7{U‹+Yu•†NN\rP‹Zm”º…ĞŠ5\'œdW£\Ú\ÛYxsK’\æ\êX\â$\İ,¬p\nf•¥\Ú\è:{M;$e´’1\á~kÃ¼}\ãyüqª/N”Ã¡Û’òHxWooAT\rñ‹\äñ¶¤ó3<^²|G87\Ûñ? ®N\î\å÷=\Ì\àU^Š;(‚¦–XÂ£*ùV.!C\ØwcşÑ©4]*]bõg•OÊ¸«ŒnÀŸ\Ãz·“‹¹\×s·N:W¨XØ¥´*£ˆ\æ¡Ó´ä´Œ\0 `~U©Œ5ª\ì	\0\Ç^)„ö\æ>¿¥7­1\êH\Í8ÎŒu\ãš_\ĞU$K\08ú\è#®:\n=+T‰b©\ç>•qO|\æ©/Z·\Êæ´Š3üoOzŠ`^\Çù”\ãõ©–˜J¬\ÅO†sY\â!\Í\ÓzŸ>¼€ó\áı\Ñúfº=\Z\ÅZ\İ&”/”_h\Ï\ĞW<\"•ó‰Q»”dâ»½\Ò\Ú\îò\r\"\Ë\Ì>y¥cÊ­ô\ï^cv:R¹‘aá›Ÿj2Ab\\	\'\ï.%\áS\í^«a\á‹]\n\Â(|ùgF\0\0POÖ™¦µ„z\Â\Ú \éöY\ã}‡¯\ãX>/¼º¼»7ğ]4‘\Ä\ß,jNgŒ\n\ä©SŸC¶>S¶h\ß\Ù\å\æ³Un ı\êÆ‹I\ÓQ\ä€Zı\ÜU\r7Oº\Ö\Ù\'½¹–+ts <»ö\Ô\éºx‰CI\Ë(Àp++\Z^Û±–štvvÁc\'©§˜yü+D c·Ò—\È\àS±<\Æ<–\ã$PMyd\ã†·$¶=€\ÅP½\n\" i44\Î^wtn§ZH®–&ÌŸtö5i„{\Îò\ë\\ş­x-\æ2E\É}võ4’gB·±\İä‚¾ôÛZ\Ä)\Äoj\å­üu¦6aºµ¸°b¼U]g\ÅZ-–÷[šLœ\"(\åZƒ¾Ä¶­rh~+\'„¼Z\Ğ\Üi\é-„¨\İ\ïS\Üzojõ¾\Zø‡¡	bxo-\İq¹~òB;c_\êÚœº®¥-\ì€)cÂŠ;\n»\á¿\ê\ŞÔ’óJºh\\GUq\èÃ¸®\èG–68f\î\îz/şj>º:\Z{`r•\ÎZ\\y\Ñ|à¤ƒ‡S\Æ\r{~/h\Ş/‰,51¢\ÃiCû¹û$ÿ\0#Sx·\áu–¤^ûJA\r\Ş2Ptz¢O	¼³Š\æ‡¡k“¸¶h¤0¸9ƒ\ê+\Ñ/ô»½*é­¯`h\İN0Â°5m5gˆº\Ş/\"„c*ø=)\\n8éŠ³$g\æHeëš¬\ÊGÿ\0ª¨C¡\áˆOÔ¯4›¨\ï,.d·¹Œ\îI#lk:6!\Ç)\èÉ G\Ğ\Ş\0ø\åo¨,zw‰\ÂÁr0«z£\ä÷‡ğŸ~•\Ùø»\áŞ‡\ã+3:,ipë”š3•o\ËùŠù\İü¹\Ôô\æ½ÂŸ5ŸJŠŒn´\â~{YO\İOğšC3|Mğÿ\0Vğ­\ã,Ğ»Aü.jô_‚û]Ô º÷V\Ä\Ç\á\Õñ\Éü?­zN\â¯\rüFÒš8Y$l~ö\Ö^$Œÿ\0Q\î*ö¤\\\èšeªC&•–en\â\É\Îş,ô\\Fú’\ç¿O¥IE1\İcFv8U&\Ì\íbğ[Ú˜Á\Ã8\ç\Ùk²¯\ïš\á¿Õ©ÂŠ±®_=\İÉ‰	\İ!\Æ=´´\ËAH½”sõ¬›»÷\0GoYù²~‚¹o\ß,Z{D$\â·u’·298TEyw‰uF¸½(‚ÕŒ\Ù\ÙF6W:\\5Ö“tÿ\0V\Üb*o\Ïö?ˆ	\Ëx1ú\éOø{b.¼9r9g¸Û@ª1ü\ê3jÖ¾>\Ó\Ï\ÚPq\èO?¥V‘Ri¦]¢Š+¤\á\n+—ñWlü3\å\Ä\Ñ«§\ç\ÉWÛµ}IÁ\ÅPÑ¾&\èÚœ\ËotO™\Î9Cÿ\0\×\Ì\íè¦«P\ÊAR2<\ZuT2Â­\È\à\ÔÆ£•K¯Ê•8=¨§ ò)1@\0ª·V]¹F}jI®­\í\Ç\ïfE>™\çòªköÉŸ)^B;\ã#2\ïFš²\éü«<ex Ö”\ÚıÌ¹ª‹ôÉ¬÷‘\äb\ÌrOµK(a>Ô™ö§RJ\0‚ô\âLr\Îr\Òú•Ë“Ÿ›š\é\ï\Ù\á\İRõ\Íi¶ò^—e´Hü\ëH\ìC%µ¶’\îuŠ5%˜şU\êĞ¡\Ñ\í<é¶‰q¸–\à õ5†|7™\n\ÜÎ£\Ï##?\Ã\ï^YñW\â[_I/‡t9Ñ)s:õ§û úzúÕ¤_‰_\çñEùğö€\Ì\Ö!öI\"\Ë\Ãñ\"¸\Ñv\Ğı\n\ÓHú\Ùş\Ê;z\Ò\ÚY&Ø£q}:şõ»À‡øGûG¿ ¨B=\ì\â\Î\Ü|¼#°ôªJ\à>\Ú\Ö]fñbIOıôk\Õü?£Gen¹PõŸ\á;Q+.•\Ô\ÅòZ=H­v\ĞKRóŸZ3Ş£hğÀ\íM8\ç\".G£\'¥8Š¤& úQÚŸ· \ÅH\íš\Ò(†4t¥\Ïc”¸\Ç5ª!«}\Â=*:Ô‘>*\âC,Œ\æ’\á\ÆqBry\ÍLx\ÚG\áZXƒ\ç«r\ÏxŠ[òJ\é4\ÍrKM~\ëHƒŸ{\à0\èG\åXxŒ@g€—R¡[+¨©tû8\æ\Ú\ÑÎ¨Å\n\rxL\ïG¤Ï©éš„ò\İ\Ø]-»J2ğK\ÕO|v5™§\Ü[\Åq+™\Ì\Ùo»ü \Öu¾•µ\ä(~`:\ç¥Wkg‚7ò\ßo9 W?²H\éU\Ù\ÚY\ëè€H\äV¥¿‹#’UŠ\"O¸\ï^h\ZC…ê§ƒ\Ï\ç]§†- XU\ãprsS\ì\ìR©\Ìz‘7 ‚jÁ‰Õ¹<TZae‡sp;U¹\Éò\Îx>µs6\ævE`?\n\çn\åfBkRşBŒ[=+º¼À%‡>õ\Ñ\äwG,~\ïze¿\Ød&K™‚Çr84®şzœ\roiú]«\á©ô§‹Ë“‰\ßŞ„€\ã5{m	ƒOo0ÿ\0sfAúWxŠõX%ŒÛ„?º=w¶ÿ\0õ\r*ñŒ\×\í-¢\çWú\ÕF\Ş\ÎgkvUtg\ßÚºi\ïkœõoc\Ç/tù\ìd+\"e{5@#èš–‘5¼G	ö‹s\ÔwZ\ä¯t”\ËfÅ”uC\ÔWJg9’¯µƒ);‡\"½s\áÿ\0Æ«\í\ËÓµ\İ÷ºx8Y	Ì±¯ñc^BAF\Ã\àÒ†ÀÏ½1i<ø¢¥\Ì\Ås¯\Ë4g\æC\èGô5\å+ğ\rö‚\Í$hgµ?vE\ÇÖ¼‹\Ã^/\Ö|)¨-Ş—vñ0?:uGŒ;\×\Ò~ø­£x\Ú°Ş¬vš^?$Ÿ\î“ü+ó¾³¦´nn#¼+•8,‡ƒ_Rx\Ã\ám¾¢’]i@$§%¡=\é_=øƒ\Ã÷z\ë\Å=»\Ç\ÉaŞ„À\å\ÆTô\ã5d\àúô\æ›4e8ù}(\ÈÚ¼s\ÓÖ¨DDC/­k8ó-\â³$\ÆJ\é|)¢\\xP´\Ó-ó¾gŸ\î\äı\0z—ÀŸ“×ˆ\îC+a´9\Ç?\ÄßŸ{.…š}­•¦\ç$q3ïŠ££ipiV\Úm¢í¶¶Œ*aş5³R!k_¿[{sq\Æ\çúzV´ó,¼¯\ÑFk€Õ®d\Ô/…¸9.røşU2c\r.&¸¹{¹\Ş8Q]]¤9*€u\ëY¶\â$PŒ\n\è,¢\Ûò9=>•g\ã[°A*©\ä’+\Ë\î\ábSŸ™s^“ñ\'\Ã3f¹{\í2EÑ¬®6a]85‹ÑôşuYN—¨ÀÇ¤ª\Û\n\ìCµ‡XşÕ—\0E–ö\â¹…V\ÛC¨^Hv\Â\ÛP\ÆH\É\'ğ®“T\Ô\r\ä\\dù*xÿ\0hú\Ö\ĞWG%Wi2C¯L.™¶d\ïùú\Ô:÷,4)§‰Ä—n1®}O°®W\Õ!\Ó-\ZiOEQÔŸJóK»É¯\îy\Û\çcø\éV\Ì\ã\Âöò\âş\î[«™L“\ÊÛ™‰\ëU¤]y.\ÍÇ)Y–{\Ò76<?\ãmc\Â\ì‘+ıª\Äu·”“´²{*õ\ßø\ÇHñ4X´ŸË¹ç¶\á\Ç\Ó\Ô{Šğ<\çƒÒ£\Øb™f‚FŠT9 ƒ\ê\rpLú†‚+\Æü5ñZ\îÁ\Ò\Ó\Äµ\Ä\Ò\Şÿ\0zÆ©\Ù\ê\Öiwas\Ä\r\Ñ\Ğ\çğ>†™‹‹E—!T–\Æ+\ïS\Å,v\çd‡…\'½XÕµ0yVò«\à•9À®vL\ä\Z–\"“ed*ÿ\0xsK€i·03’\è\Ø~•Q.š7ò\å[Ş¤¢ö=(Ç½5d84òr1HÁ\é\ï\êiO\è@i¾œ\Ó/P3\\]\\G\n\îq\Õ\Ô\×W\àÿ\0.—c·*\Ø\È\èj_ø}RG½¸\ŞÛ•Oşµq\ß¾%\r\")t\Zaö\æ\\\\N§ıH?\Â?\ÚşU´V„3?\â¿\Ä\Ï,M\á\íq¿”»¹C\Óı…?\Ì×˜\è¶\Î\Õukµg\â\Î&x²ı\Ñúš­¡ikzò\ê7û¾Áns!™œô}\ÏA“W¯õ&¸™¤/˜@T‰\0û¨¾€\n´€‚i¤y<˜‰y¤9,y$¤\×q\á?‘d‘y\êI\ïYşğ\ãO ¸™r\Í\É$W¤\Ç\ÛD¨ƒ\ÅinT%¨\ÙvG\0Œ})ó¶\ÛP¸\ëP\ÎA™q“I~ø\n¹¡„\r(9\Ç¡V\ÎA\éR¡\'\Õhd\êsÚ¤z\ÔK\rH™9\æ­\"Y \É\Å\çü(S@\éZ¤C\ZWÛšFSÖ¤\äšks\ì*\Ñ,ŒûS”\àÑ·) \àşµ¢D2\âc=jt>õ]Fq\â§L}*\È<\n\Ò\ê-’BFÑs\Î*Å¢Á	\Ìj¬Xòr8÷¬Tš˜\ç\èEWŸP*\á(À\ê	¯\ï=*\Şø4\\}\à¸À9ü\ê_=%€¤\ØB:z×›\Ø\ë¯\r!\Ü}y«\ÃÄ+\ì\É\ç­K‹-3¢º%\ÂÆ…\æ»\ï\Í+˜`^I-úVip\Øã¸®‹@\×&iY‰J\Îi\Ø\ÒW=\Åuš5*\Ë\ÏaP\\\ê\ĞÀ…¥|\n\ÂÑ§K…U-Û½i^\é\Ï«r\Äq\í\\­³{#PñŠ\Å\çüı1Š\ãuO[\Ïv- Fy\à\Åk_\è¶\Şk-\Ì!°x=\Ç\ãXö\Úm~\×0\Æ\áùù¤}\ÕQQ\ê&\ßCN\ÚY-­ƒ»~ı+Ó¼=¤NºjMp<‰$¶c$\Ùÿ\0\nó½3R\Ğc\Õ\íc\Ônp\'‚GLûW³A<W0¤\ĞH²D\ã*\êr­\é\ÒOYÔªÖˆ\Ã\×</¯¥\Éi\Ô\ÖòŸ»*ŸĞ\â¼_[\Ğ5\İ¯¢\"2~I—”¡¯¢*½å•¶£jö×¤Ğ¿Tq\Ån¢–\Æm\î|\é\Æ+\éYÚ…\Ø3Z‘Şƒ€k\ĞüSğ\Ú\çO/y¢‡¹¶\0–€ò\éôşğ®!“ ü¬\"€8=KI\ÈRxü¹‡¿½XS\éóÀ\Çr\îø…z\å\ÄÚ„^U\ÂOC\\¶¡£]\é\Çrf\âÛ¿M08>ø9Ç¥X·º’\Ò\å&‰Š²œ‚\rn\Ïagvw¡\çğ¬\é´+´\Ü\È¨ô<şT\î#\Û<ñz\â\Ş\Ş+}WuÕ¯~s$\â+Ôµ\Ã\Ş=\ÒPb7,\Ñõ\ÄC_\é×“i\×xpÊ„\á¯LğÏ‰u\rU»\ÓnŠ©û\Ë\ÕXz@ˆ¼qğ«Rğû¼\ĞFn,\É\Èe\ç¼\Ğ\ÂñË±=\r}w\á¯\é>)‹\ì7j–÷6›yVO÷I\ëô\ë\\§¾Z\êk%îŒ¾\\ıL^¿OZw\æ—\ËJ\Ä\×ĞŸ|*lt©|Av„Krv[\î„O\â•yF—\à]Jó\Æ\Ú%\Ì/y?xø\à \å\åú\×\ÕúEœV\ĞCm··@¨£ À\àPÔ‚?.>~ñ\äÔ´U{Ë‘klò£õ¤\'ˆõ%†3ne¹\êkŸÑ­™÷\\\È2ò3\ØTú–¦!\ÜJ©\Ü\çŞºX‚(\0\0:\nÍ»Œ½g™\" \è:\Ö\Ø\0\0AU¬aò¡ı\æ\æ¬\Ó@akúk;U‡´\ÍSÃ°\\\ép\ÚF€$(x\è\0®‚°u­Wfm-\Û\æ\é#\ŞÔ¹S\Z›Fd;4\í&*Ø‘\ç\ÌqüG9¬\İKPƒM²’\æ\á\ÂFƒ$úš’iã·…\å•Â¢Y‰\à\nñ\ïx–]zø\Ç	+eı\Úÿ\0{ı£Zl„“›¹vûU“X»k‰\í\'\äLğ¢«px\\\Õ+M\Ñ\Äóš¸¡pNáš“t¬J	\ã\È5{C\Òd\Õ\ï\ÖøŒs#ú-]ñ%…† -\ì·nQ‰l€}>´‚ú\Ø\æ\Ë|\Øô£õ¤HGj\Èû|±\Ê\İ\ÆzP3]\ÕJÃŠ\ß\Ó5Y,ô4\Ğt›˜¼ıBMòù\'\ç\0ñ\Éÿ\0õW}©‡¶Ø§š»…/$ş\"¹^¹Š\ß=ÿ\0¼\ßÒKmOG°±O°†\Ö3òÆ gÖŸ 9©˜ú\Z…ûƒH\Â\ä3U\î-\Òd!\Ç\ã\ÜU§i„şµ 1›Î²l±/¨\ê*\ÜK \àŠ°\ê9›=“FL¶\Çºö4†h\î\ã®kkÃšz\İ\ÜI$œ\Ç>_RıU\ÉA}“\å\Ê\n¸\ê\rj[^\ÏlY\í\çh”®Wü\âš\Ü~(|J\Ã6\í¤i2+j².×¥ºŸı›\ÓÒ¼J\Ó.¼CªùaØ–&I\æ|«İ¯õ5\Ğø—Àz\Ïö“\İ[³\êy3¿øòOñ2}A<1jš~•>gF\r=\Ê\ËYG¡ş\êöõ<\Ö\ËR^ƒµ\ß2\Ò\æ=&L1\Û)	ğc\Ä\ïş\Ñ\ï\éÒŸ\áoI}v%‘I\ã?Î¡\Ğl®õ›‚df*\íºG\î\ç?Ê½wG\Ò\âÓ­”*€q\é]QW3\ßBÅ„vv\â4P8çŠ”®zöô©I\É47F?…AfrF^\ï\'8«ŞœÏ€8´­”3»û\â³\î|\ì}\é +&~\êÂ€8\ÏZ`R§5*ƒ‚sZ¤r\çx \éÖ˜úS…j‘\ršp?…0~¡ºõ­%\Ï\0Rs\éMŒRõ\ç8\ÅZD¶æ›Œ{\nq\éIù\æ­\É\á;–¤.Y¶¯_­CLt«Q¦IúU#6|õ-ºZ“½YÛ¡nÕ‘5³É¸…\ã¯µzUÎc|K\Ç&~ò\î\ÅsWú<\ÖR;G\è‰ú\â¼\Ğ9c.Õ‘@\İ3S¥´‹‚T`õ\"º\Í3\ì²Fm\î\"\Øñ8\éô«­¡¬\Í\Ì¢¿«Â•\Ær–Ñ•”¤£\ä<\rİ«¥ÓŠC†R3‚³\îm%¸v“\Ë\\£Ò©ù7\Óü²`\È&“W\Zv=WH¾\ØA®•54‘1,…8\á»×„I\â]J\Ô\í€\ãÈª·>+×®K§E#hÁü\ë\Ñm›ª\É#\Õ|M­\èöa¼ıEÄ‘0Xş\ç/–vh\á\çø\Ì~µÊ°šI™Ù\ä\'’\Ç$š³\r¹f\Ü\çjı+XRQ\Ü\ÊU\ØÙ´½’\ê\á\ärB…õ\é]·„ü{¨øneDs5¡?4\Óğô5\Å[XUbÀı\êP	<+dÌ™õ\'‡|S¦x–\ĞMe0ó\0ù\ác†_ñõ¹_\'iÚ•Ö—uÍ¤\ï¨rO5\ìşø£k©,vz\Ë,=\ß\Âÿ\0_CLG¥W\âŸXkÁ\îmö\Úß|À>Wÿ\0xZë•ƒ(e ©\r:7\êºN¡¡^]B‡CÙ‡¨=\ê%¸ş\Ã)\r}ªi6:Í›Z\ßÀ²\ÆzgªŸP{\Zñ\ÏxP\ĞK\İ\Ùn»°–\çŒ{\ëJ\Ã8=G\Ãğ\Ün\Ïı×±®^qsg)\nZ9\ï#t?J\íã˜©\'½GwomªE\åÊ¸|pÃ¨ g,‹ı¦\ë¸@9«\Z`\É	-ß˜\ÜÔ²\Ø\\ir2H<\ËSü@tú\Ö\rü\Ø\È\ÒÚ¹0±İ€r:\çpv²¹9uÖ»\ß	|]¹Ò¶Yx„=Í Â­\È‘¿÷‡\ë^M¤jŸkˆ¬Ÿ\ë¨\ÍhmY\ØO4ô\ÕÆ¦xš\Ş[M¹A63\r\Ü<\çØõ·c\ÛY\Å¬¯(Q\æ:Œn\æ¼\Û\á5…ÉŠk\Ó#¥ª-cS…vú{\ç^¥LA\\‰µ@»‘	ò¨õ5\Ğjw‚\ÎÑ˜;p¿\ã^|3©j˜\Îbˆó\îjdúG´1\Ã\æ?ú\É9$\×Ka›08ùW“Yğ&0\0\äñ]¤D\n§\ïMB=QT\"¤\×Kdÿ\0d]Ò:ò·½q.Ll\Ûø`y\İ^…^iñkTO\Ó!µ·@/.³ºE8+\ëùôüê“°Z\ç\ã¶¡#i\Öo›t8‘‡ü´>ŸA\\Í­¯–77ZX!%0\æ¬Ï¸¤tE$¬şUÏ¥TkÒ¤\áºubv5–\ÙİŸSø\Ğ3±\Ñ|mı™a\äoŞ¦|¹€\É?\Ş9\Åf¶ ndy^Mò1\ÜXI5‚‰\à`J^ù4¬F„—Ê\â°\ç!K6;ñŠµ,…`œVU\ä\ãsƒÚ’\éºuÆ»¬\Ûi–ù\ß3€X\n÷?€¯£\ìla\Ó4\è,m”,0 E\ç\ß	|9ö[	uÛ”Ä·?,ìƒ¿\âk\ÒœPcRWv\"|õ¨›­HÇ½1³=)‘i‡šj‰ºûP22µŠ˜\ÔDd\â\îmReù†±EP\Ïhûd“ a[sÒ°üO¯A\á½,\Î\ÛZòPE¼M\È\Ï÷°ıM¸Ì¿ø´\İ>KR~\Õ\"=×¬Hz/³7ò¯7\Òtùµ[°0qx\àJ\'½\Öo0\ÎÏ½÷¹\'’Ç¹÷¯Yğ†\Ö\Ú•\ãó®ºpQWfm\Ü\ÔğŞ‡…ª1Œ+ 8a€)G\0(¦Œû\n»¸%a\Ë\Î=iùp¹=i\Ê1\ÉéŠ†ô\â,ı\éKs¶Ø·~µš\ÄdŸ­hH|»O\ÃœcÀ\â­\0\à8ö§\í$qH\0\Ç\"¤\\\ç¥mK\Z´£Ò—\âŒ\n\Õ\" \ç­/½\'lŠ\08¢D±\Şôfš{\ÒV‘#ó\Îy>Ô\é\Ç\'f©	’\Âr\ÛI\Æ}ª\Û>\Å\ÏôªHp\â®|¤ñTC<\Ş)’E©\"¥\r˜K\Ì=¸\Ï\ãUeƒ{–ˆ\ì›ôjH\å\Ëy3\r²\Õó\ç V»\Ó,\Ë\È2?Z’[\ë;m±42nûÃ½%Í¢H…\Z\çî¡¾\Ó_Ï²vò×–$ı(R\ê\Æ\é¥³¯,Tt©!Ğ²†B\ÍÓƒÖc\â8nl¡f?1lH¸\ä\ZÕ´Õ­e…\Ñ\È@jC9\İC\ÃÈŠ&$zzV-Î™#\ÈFqŠ\íµ;»%´*—\n\ÎX0\ç5\Ç7ˆyˆ”’z{\Ğl±ü’\0¤q’9ü\ê”\í±\Ù38fŸu3I¶W\ÜGj£\æ³}j„O\ÒÁó+dw©mv—\0rCw\Ö@õÒ¿6AÁ”\Ñ\àB“9\ÍgZßvM\ÇlãŠ¼p\éLG\à\ïˆ÷ú	Kk¶769ûŒy_¡¯o\Ò5\Í?]³6¬‹üKüKõò˜\Ü\ëZš6»¨hW©sc;F\ã®:c\ë@ª©¤ zƒ\\7„~#\éúú%µ\ë-µö1ó#Ÿc\Ø\×w@â¿†\ÖÚû\Í%V\Ú\ï’\ÑtOğ?¥y\rõ…Öxö\×p<3!ÁV5ôõckş\Ó|Gi\ä_C–\ä•xtú\éJÃ¹ó™›*U¹\ïX÷šP“2Z\àñ‡\é]×‰ü¨ørBÌ¦\â\Ï?%\Â>Œ;\Z\åœ4g8\â€8©­^\Ös4*Q\×\ï!«¥Ğ­&\Ö\ï­m\ì\×t·(\ìM\\\Şõ+ \Û\'@Ø¯Jø-\à£a%Ö»t2rbµÿ\0Ù›ú~t\êš.•‰£\Ûiö\ã\ä…0[ûÇ¹üMiQYZ\İğµ³1ƒ‡~C½7 k\Äú±’FX\Ï_’1ıiºU—Ù­\ÕHù,k.\É£©5\Ës\\/¹®š\Ş2\ìªI5–\ã44\Ë2_1‡Ê¿Î¶ªxDª\İjjh¢–Š`6¸ÿ\0x<Gt·ir\Ñ\Ì)VR=½+²¢˜-5>l\Ôôk­.òKy¡tu8\Ã.2=k9g¯fø­­\éz…^{\ËE¹º“\äµ\\†şöG@+\Å4\ÍwNÖ£ò\Üù=9\ã?OZ\r£+‘\\`dbª…\nH\"¯^\Ø\Ï8\ß\è\Êx5H\äŸÒ‚\Åy\Æ3Ú“<vÀ\íH¸\ïCªXô“\é@¯%ò\Ó=\ÍG\á\í_ø†\ÛM‹v\Æ;¦o\î \ëT\ï.7»3t\Æµ{/Â¯\r+CmR\å1u|Pz¬}¿>´\nN\È\î!·Š\Ò\Ö+xP$Q(DQ\Ø\nF\éR1\Éö¨O5\'8Ö¦6E<\Ôly 5F\İjC\ïL4Ç¯5\È8\æ¤?Z‚\êh\í`y¦`¨£$“@jWöº>6¡xØŠ!\Â\ç—n\Ê=\Íxv¥©_x«Z’\êc\ç‹\ÑW°Â¯ø\ÃÄ·>\'\Õ\Ö?b€\íE_\â>¿S]…<2w£:eÛŸ¥tS‡VL™£\àÿ\0\n\í*\î¾\ìq^–‘¬1P\0Q\Ó¬vP,h:O©©\É\Ç8§)\\IX…—(\ÎsÀ§c=ûR?\nqÛ¥!†qU.\ÎùcLŸz²[ôª(|\ËŞ*^¶!\ÅRL\Ç~µføğW\îf´Š\éÁ\èIšh\í\Å;ó­¢ˆlP3K\ÜF:ÑQZ¤Cb­ 9¥#ŠnyÀ¢%‹\Í%/Ò›À=j\Ñ N1K\ÜñM÷\à}j‡.A™«Ñœ\ÍP^X¢®@IQi’yò¼w†L\î*)_Jû\İ\Å;TÑ¯t[‚.~W\ìGÖ¢Š\é%%?6:šù\ã\ĞY\à8\ïŒôp?+\ÅË¹93©Aƒó!ë†«¼ƒ•\êc=GÒ€0uM¥¹ò¤8‚k—–\æò\Õü‹¢\ÊTğÆ½&7Š\à`ñ\ÌUKG‚ò²(#0\ê(¸#\ÎUŠ¹`x\êj\È\ä\çŠØ¿Ò®4·\'\íûÚ¨²¤\ÃtXúS!+8Á\í\Ü\ÓI#§\çŠrqÀ\"XG^\Ô |p	ö§†ò1\ïQc<\æ”6$ŸJ\0˜\çoÒ§‚\î[r²c÷ª¹‚?•H1\Ğôö \r¸®#Vö\ÏJ›¯µ`!hğÑ’	\íZ6ºˆ|,Ÿ+Pô”\Ä\á\Ã#¸\â½+Á¿\î4\Ó–¯º{N\Ëüq\ê+Ì·d‚½h\İ\Çjb>²°Ô­5K4º²f…ú2Ÿ\ç\éV\ë\æx³Rğ\å\Ú\Ée9\ØO\Ï9V\â½\ÛÂ¾:\Ó|O\n¢°‚ğš=\İ=\è\Ò\ËW´R¢\ÉŒ2°\È#\ÜW˜x·\áD—š\ç<µ¡?ú	ş•\êL¹9\r\ëMWù¶°\Úİ½Ò€>e\Óô\ÍO^·\Ò\á\Òi$\ÚÁ†\nz“ôôŸc™§Áen»b…(ş´Á¥ØOûH[F.öó@\äƒşz\Õ\ê\0cºÆŒ\ìpª2My\ç‰5\'»¹ò£\Îù\Õ\0ôZ\ê<E¨-½±€6279ô•\Æ\éµ\åÜ—ò3ˆÁ¨“\è4k\éö«kl‘\Ğdûš\èô«n³0\éÒ³-`2È±¨\ë]4qˆ£T\0©@>Š(ªQE\0QE…\âoXx¢\Ç\ì×»\×q\Ğôü;\×\Ï\Ş2ø=ª\è÷–\nf·S»Í„}ßªõôõ!=)§`>7\ÓüO}£·Ùµ8\ÚXº#š\è\Ù\êı¢\ÂQ\È\å3\Óğ¯pñ_\Ã\r\Ä\ÑH\ë´ºn|\È\×\åc\îµóWŠü?©xÄ²Ù«²”•Ğ®=i\è\Íû›\Æ\çv*\ì\ÛG–;õ©,5s{I*şù“vGCSOi$3\'¨3\íH\Ôw‚¼:\Ş(ñ4V\î¤Y\ÃûÛƒş\Èè¿‰şµô@U‰8\Ô*¨Â\ØW3\à/\rG\á\İ1B·7DK&zEüó5Ò±\æ“0›»\ZM0šSL?\"lS8\Í8ú÷¦\r\0F\Ü})œfz\æšs\íŠ\0‰¤XÕ\È\n¼’kÉ¼{\â\é5ƒ¦Y±¯\×üÿ\0*\ëü]¬-¶‹qv\\­œm\å+#a¦”~I\ì9ô\Î\Ã\ïÍ¨Cÿ\0	&¯\ÛL–…şZ‘\íı\Ñúôõ­©\Âú±7c3\Ã–\Ö$º¼ˆ©a¹U‡8=ÿ\0\Zô-&h\íH?¥R¿¹\\¾\0ñ\ÇZdrg\é\íZ¾Ä£°Yƒ¦\àx§\ä°gvÑ°•=«n9 \æ¢\Ã&8OZ\ÈÊŞœÏ…ú\ÔlFI\Î@¦ş\í‰\îj½Ÿ\Í$\ïR\ÎHˆqÚ‹t\Åõäš¤KÌ´„\nl@\ì\éK1Ë“\ïK	õ­bµ$À\Æ1J8¤<ô¥\Éõ\æº3l\\şTzRdKÚ´H†%5ˆ\rÉ¥&’­!9\ãù\ÒF3HA=O\åKŒU\"D\ïFipx\Å(H@‡œ~Ur\Ü\ç\"ªO^YŠò:S°‰¡¼²\Ö\í|‹…V\Ü1\ÏQ\\oˆ|#6MÅªù¶ıx­A\Ò\Ú\Ê6 Š\ëtŸGp‚€2x ÷¯½\ÏA«o\ëFû%o½]\Úo§·Z\ëµ\ïCzw¦\á_©Œt?J\á\\X\ÌR@\ÊAÁR),Ğ¬\ãv|¹û0\è~´Ø®Y%ògv\ì~•<r%\Òü½{Šd±«ƒ\é•\êq\î)€\é­bºŒ‚¡”õ¸½c\Âò[;\\\Ø\î\ÛüQ\×X$È‚\Ä\Ég‘õ«\É,wÁ$P’	Ï—\"•`ŠH\È\íø\×}®xb\Õ2Eû¹û07Ö¸¹\á¹\Ó\çhnÔ€>\ëz\Óš\äg¸úQÄ‘ßµLñ\î\\\ÆZ„.:}q@\nÇ‘Šr0\ÜH==*0:g\0Ò¯\Ê;{PÛ½8?ZvvÁõ¨A\0€š‘[\åÁü\Å\0[¶½x\0WOZÒE•C#§µb´s\È4ø\åx1==hq”GªK{¹m¦Ia‘£u \äU;[\è\ç\Æ\×÷5a“\åİŒ\Ô\ìø¯“¼r8t:÷‡õ¯X†h/-\ÖX%†A•e9W\È\á²:s_Dü6Ñ®to\n\Ä÷rHfº>o–\Ä\â5\ì1Ûi’u\Ñ$‘±V}\éü%¾ğö÷§\\N–\Ğ<®~UúÓŒª¨Y\0õ¬I\rÆ«t lw1ò€\Â\Ö-/õ$8]–Wù\ÜµiZh—B‘¬{UGs]Qª‰1ú\ÔÙ©°\ÊVF\Ø|>ª\îh&›š@;4SsKL\Í™ \Z\0u™¢€Š3E\nó¿‹Rxv¨\Öma–\â\å\Ä6\îW\çLı\ç\È\ç\n9¯@’T†&’F\nˆ3€¦¾sø·«M¨\Ëos&A¹ù£ˆõ†\Ü”\ê\ç\æ?€\íAQWgcac©IŸrn-9Yq¸WY\à=kš\ÊM*f\Ò\ÓüpÇ²ÿ\0_Â¸¤Y.4E,\ÎB¨^¤ö\Å}\á]<? Ák´y\ì7\ÌÃ»¿—OÂÍª{±6˜JˆœS˜÷¨\ÏZ“˜B}4ñA=i¤\Ğ¥4ŠwjAÒ€Š\ä¼m\â˜t;…\\y\ì¼ó\ĞŸó\ÍtZ¾¡•§½Ä„\Ñ\î\Ï5ó»«]x‡X–\r))ıºÿ\0õp\Ø6w\Ó\ï>(x¦~¾F‹¦ Ş‘\ä(\é\Ïñ¹\äŸ\è1^Á\â­v\Î\ÏMM/M\Ø\0@„G\Ò4{×›øBFğß…~\Ãn\ÅdC$=q\ä)\í;JÅ˜“]6#rÁv \ç$šš&\äc•Q”•j#œÓ° f„Qü«N\Şr€dş—\àUˆ›Ÿ`hif\r·:Ò–ùO¹¬\è$\'yvs~\0úJÀI\'8Uä´Œ\ÅHPx4\èşU÷\ïUšB\Ó8\0ª@Dı~´\è\å¦\ÈW\ëD=+x­Hlœò)Ö¶E <u®„Œ\Û“\ëHO¾y¤\İ\ëFA«H–)\'§zLñHO>´ ş•ip\ïM\Çù4½¨\ÔóL@:\Ğsÿ\0\ê¥õ£ğ\íT„*EX\"«®j~\0É¦#“\Ô,/tK\Ãi¨C´Ÿ» û¬=Aª¤;£5\íÚ–•g«\Ú5µ\ä+\"‡ºŸPkÊ¼C\á‹\ï;H»®,	ùd•öjù·’•\É4ŸIj\Â9\Ée\Î­½KI\ÓüGk¸mY\È\âE®+*\åNN;U\Í;T¸\Ó\å\0S¸4\'Ñ‰Ç±‰«h·º5\Ñ€xq\Ğ\ÒA|““`7c^—å†»f`¹U|ŒzŠ\ã<A\à\éôö7¹’ß¶\"™73\n˜¹=j¡¶hÏ™g\ÇvˆÒ’\É &9FTzö«…C®ø\Î{\Ğ2;{ÄJ·>ò‘Èªú™\ì¯e#¯R*iaI\æıÜ£¤ƒú\Óc¹’ò®Wôa\Ğı(\Ïõ\ëK%\âK|şUŸ•™2¼6zW«Ko\é#š\ãõ¯\àµÅ\Øıvöü)\ÜQ\ã*v\ã¥5‰\àµaÙƒ˜®dƒŒŠ\Ói G)Pc¹\"˜7(À4õ;‡ó \ä•1ù¾\ï~\Õ_>œS\Ô\àn\ï@H)÷»b´-¯YN\É\Ïµ¬Øâ ³„\nY›ø\Ğ¤|:ğ\ßü$&ˆIóY[,Ş„ƒñ?Ö¾Š,^\0\à\\oÃ¿/…¼%2^\Üşös\Üg üuq·»2Yo \ÚFTz\Óv¥¼dFŠ¹<\Ü\Ó\ãPg¯zh;\ä-ü+Àú\ÒÈ»§¹õ4f‚sŞšMH\Å&’šLñ@¥\Ú Qšnis@\n\r8\Zgó§M\0.y§QU\î\æ{{Ie3#ª\åPw4Xc\Æz\Ä6Ö¯m#~\á\0{?û±÷_a\ï_<\ëú„š\İı\İ\Ä\ß4’Ó°ö\Õø÷\ÄF\æ\è\Ù,¤\á‹\È\İ	\'«~ÀzWoÆ§w¥œE¥‘¶ T¢’»:…š\Ôu_·M\îlú\İû~_\á^\Î\íŸÂ²¼=£\Ã\áığYFd`>ó¦´	\æƒ\n’\æb–¨\Éæ”œŠi8¤@\íFsM\È\ê(\Ïj\0	ö\æI\Åf³õıU4]\âõ±½Wlj‰\Ï\0P3\Í~(øb[X_ˆ‰…H\î\ß\Äü\ë…ğv›\çJ÷’/\0\ású\Ö~µs6©ª¥¾\â\ìn}XO\ç^…¥\ØG§\éñBƒ\î¨\ç\Ô\×]ufs}\êûP*ğZ’&<Š¯ü8\ÍI\Z\äœt\éøUI\İ\Ü±r\Ù â­¡\çn2jº¸ÙŠ™\àûsR2Ú±š³‘\Üš¢ sß½N®#\ìH\\şt\ì”n\"„1\êzSV`\r·{ò\ÍúU`e\"iû«\éWL€pzÔ€°Y€<ãŠ­ù	\ÏRjB\ß)\0óQ…ô­ µ\ZFrG&\à\æšN>”!<€x®˜£6\ÉCH\'šB\Ô\Çÿ\0^“9?Z\Ù#6)=ú\Ògšo\Óñ§g¸\ÍQ\"\ãz\\ús\Å!a\Ó4\Òy\È5BE;4\Ì\à\ã­.\ïz«\0ğx r}½i8=O4Á1^\Ïj”œ)>•\ç¯\å\ëR\ã\ä=\é\ß\Ã:²‚r„Ts\Ä\ÑÈª\è\ÃXd\\¥w¡\Ê#›t¶\Äõô®\Â\ËPŠ\î1$S\Ø\Zù\Ô\Ó;­c†ñ7€¤µg¾\Ñtg™-½?\İÿ\0\n\ã\ãul«ƒ†R0E{\Ê8a\ï\\§‰üm¬†»³\Ûo~9\Ü\Ë\'±ÿ\0\Z—\ÅF]\Ï3†i¬\å\ß•\×hş\"Š\íD7İŒz\Z\ägŠ\æ\Âñ\ìµZ\Ğ÷\èGµ?-÷Fp=ªS±N7:-Á\Ğ_+]iÀ,Ÿx\Æ;ı+„h\ît\é\Ìr«+5\Úi>#’Õ„W•\é»Ò¶õ\'Oñ·™³c‰W¡ny\Ò\É\Ï†¢E1J¡\ã=G¥.«¡^h\×H‡h9W\ê.\ÑÀYF\Ô\ÒYlşxÏ›\Ó\æ_­]Hn¢ƒ‘Ú˜CFr¤\ëUšŸ6\×ı\ã?u¾”À\Î\×<?\r\ìgraû8\Ã\İ\Ú\\\é³ys&\ä<+b½B\Úõ$\Ìr©8*\İEA¨\éQ]\ÆØŒ:7Uÿ\0\n\ÌJPÉ‚¤ö\îj\\2úõ³ªh\Z{4¶Á.¥;Š\Ë²\ç9\éLAù€\'ŸQNn\İ× ¥uÀû¸ç¯µ1}\èDlœ‘Ú½\á/…—]ñ ¿¹M\ÖVH\Ù\è\Ïü#úş\ç–ğ<\Ó\Ç@»\ÈÁ@X‚¾¢ğw‡\ãğ§…­´\å\0N\ÃÌ¸a\İ\Ï_Ë§\áLL\è\İ\ËK€j\åº\îl‚¨\Â3\ÏsZ	„@!I!ÀUû\ÍÀ§m¡GAPÁ–c+t\èµ&y¤1\Ù\íM\ÍŠni\0\êO­&h\Í\0/j¤\'(\0\î(\ï@4\0I\é@R(À÷¤XğriõI\0QEV\ç7ğ®…=\äZ‹\Ø+^gtN\Ñ ×¥T°´\Óf½\Zœ6q\Çs›\Â\à\ÖÖ³?Úµ1\Èbıù5R0¨6 Âj†U\Ù`¶Ni¹õ¨\É\ÇJ7~t„;4v¦É£>ô†/¤\È&”~T\0£­yw\Åt	~Ê˜¬\×,=eaÀüó¯F\Õuô*\âöAŸ)	Uşótó\Å|\é\â\ë\éno\ÖÕŸ|ŠK\ÎGC+·\å\ÓğªŒn\Ä\Ó\Í\æ¤\×n2#\äö«Ğœ\á@À\ÅdøgM:b+½†\çã¹­cI\Şı\ÈX\Åk+Œ\\œ‘S Ú gµ5\È\æ¤#*­bhK<ùUˆ\È\Ã6z•\n!\àÂŸ,¥R\Âc¡8\n9©`\ÍË‡aˆ—\î_z¨¿¿s\ZıÀ~fõ­\ÈEP1\ì0-¤¸`3R«o¸\ë\ĞtR&-1b:*H¤3œ’M+nyp˜\æ\'\"ı\Üû\Ö|“•W\ïWPü£œŸjÖ’»\"oAzóúSšLÒ©\çÒº\Ò1lq\âšs¸iù¤\Ç5h‘¸$\æ€x\âœE3†©9\'“\Åñ’h\êAHqø\Õ œ±\ÏÒ\'‘Q \Ç\'SŞ˜‡qŸzpõ\ÅF={S\Æ\Îi€õ\ÍL\Çä¨şBøò?\Ï4Ú\İ&R+É»\Ò\'ó\í•\Ï\Íc[{°px>”¬ª\ë†\0\×Ì‰sI\× \ÔTa¶L:©­´—<µÁ^iùö¤\Ç(\äZZOˆw0µ½ù%=\rZ‘-Zß‡\ì5ûO&\î?˜}\ÉW\ï!ö5\å:Ö…¨xjp—)\æ\Ú1\ÂN£ƒõô5\ìqOÀ\ç#Öqo\í»Áq\Z\ËŒ2°\È4\Ün5+U%\åNq\éWl5i´\é”\î\rmx—Á\Z9{\Í)Z{>­V\é\ê+—I\å8\à¾µ–¨\ÓFw\Ö÷¶ZÕ¡ŠuWt=Eq\Ş ğ|¶E®->xzñÚª\Å<Ö’+\Ä\Äbºı#\ÄQ\\¨†|n<z\Z¤\Ó!¦8‚\á\àr\Èô\Å[\ÂH»\ão­vZï„ ¾Csc…“©_Zà¤†\çNœ£©V\Ï\"€%š(®H2²/İEGÔ¶²¬w#\å?vA÷Z¬G4sƒ\Ù\é²(\Øc‘w\ÆÃE05¼7ƒ €Ø®3[ğ\ØišX€N¼tj\é•%³o2\Ò\ÃÔ¯ñ/øÕ2\ØNpA\é@+c$2ù7	´ô÷¤t\áŠvÚ¶†“¡Ü»‡fEr/¦\İ\ÛÜ¤†EfÚ¸õ4\Æw\ß<3ı¡­¾µr \ÚØŸ“#†”?!\Ï\â+\İ, gõÁxN\îF·\ÒÊ¨UvQÕ$š\î,\Îğ¸\ê\Üş\Éf­º\àn=¦É‘‚/~¾Â¢\"`U˜bo?yªFN0 \ĞR\Í&i3Hf›h\ÍC,›G™ 	·\n\\\æ±\ä”ù„óõ\Íh[0‚\ç“@\Òæ›šÍ½¼‘X¤\\Á4°ª1– ­(š.ÔŸ@k\Êöûœ°Sülxü*í¢X\Üy{³·$±«HF¤2ù’I\è§¦ª¶˜`\ì¤N*\ÕP‚¢¹\Ån\î:\ÅKQN\É¼#m@¤“\è(ŒºO-‹¼\İ=…W\ë‰ş\Órò\àŒ ¨\ë&Pú3\Í4\Z9\Î{R¹£99¦“J\0½)Ã¯­7\å\ä\Üñ@Ÿ\Ä-Itı3‘x\Şa÷G\ç\Ïü¼?E´mOYW|°İ½ş¿şº\ì¾-k¢ÿ\0[].\İÿ\0sj0\Äwnÿ\0\ç\ëQxHf\Û!_šB=»WM]™\Í\èu	†\ÙA$zT~QÇ§j\ê/4°°)Q’\"±Ü©\Æ+IÏ™Š*È¢©\Ïªj,©İ¥4/9üjQBºUO˜r\Ï\åF\ŞoJs±\0\"s#~•b\Ş\Zq\É\êO­PC\ZÄTp*Ebe<ğ´€´\Ô\áw=(*J±À\îHúÔ¶S9\ã­VtF‰UÀşZI_D\rØ±‰$|¿Î®\'CÒ QŒ8©¹ô\ë]”é¨£	JäœŸñ§ ÿ\0\ë\Ôx\Æ8\â¥\\\Z\Ò\Ä\ïG$})@\ïKyªÂ¹¤ fx\Ş1T!˜\Æ{\Ó:ıi\ìp8¤\0óÉª@ \ÏZx=ª0\Îi\àö¦!Tôğ3\ØSs\È=i\ã×½0„\rJüDOÒ¢<`\Ô\Ø\Ê`ñ@\Ê\î\Â;‘½~Y=}k!\ÒH$*\à‚+u_´Mw)µ\Ç\Ğ\×\Ì‰‰EQ½\Óc¸Bz7b+B\â\ÒKi2rW±¨\Ã\î\ì(2\ÃWº\Òe^fH;?¥uö—‘\Ï\É‡C\èk¸µIĞ«µ”†óD›Ì·b\Ğÿ\0\áUG¢#‡\Äx£ÀQ_³\ßi!`»\ê\ÑtI?À\Öæ•¬Á¨Çº\'\Ãÿ\0 \Ö\Äsn\àğj´bNÇƒ±’\Ş\á\ín\âxn\á•\Æ¥ò\Ùt$cÒ½\Ä^°ñ¾&_.\å\î\çAó/øŠòWL\Ô<=z-µÿ\0v\Ç÷s¨ù\\J\ÍÅ£E$\Í]\'\ÄOl\Ë\Ãe{5m\ß\év ¶\İò‰H\á\Åp\í±\ÆTƒW4ıZ\ãOp2Jw¡>\à\ã\Ø\ÆÕ´+­&\à‰‚vp*¼WJÉ¶Cø×¨\Û\Ş\Ùkv~TÊ¬w\ê+\×ü!-™i\í¼=p;S$\Â9BNE!…$\Ë\ÆDs=›\ëU\ÒGˆ\ìu<v#¥J\n°%H¦!\é8$\Ã*\íqü\'úTb\Æ\îEÊ€1\Û\é\Ò*\\\0%\ê:0\êµU\ç–\Ï	q–Œœ$«\Ğıhb\Şr\Ò)$|¤^›\áù&š\Ång\\3ı\Ñ\í\ë^Ua\é#då ¯N\Òõ5GlF\0.\0tp/› \ã\åj\é5R ©\ëO\Í š@sMÏ½8ü‹–A@\Äf\n¹5NP\\óø\n°N\ï˜\Ô-ó\n\0…Tn\ä\n¼\â«\íö§  ñ@3SB#c\Ê.\á\ß\ÓVcMD¤«g¡\Ä_¬Û E\èÀ\Îq\ÅhF\á\×#ñ¨&@nˆ\íV„É‘P£\Ğ\nV`ªYˆ\0u&†`ªXöZfŠ\àGwó´S43,\é½3·8Œf±<I{¶%´C\Ëü\Ïô\ì*\Ğ\Õ`·š\â\ßmº\î\'<ı+”w¹\æ\å\Ü\æ¦Li§sœ\Ó9æœô\éY”.x\Í¤\äqG8õ =A£{R¼\Ğ¾†¨\ëú²hZ\rŞ¢ø\İ\Z\íŒ\Õ\Ï¯ª–`\0\É\Î0+\Éş/\ë\âk¨t)\ß)«ƒò?¯µ8«±3Î¡Yu}T»’\ï4…˜¤u&½·\Â\Zh†r¸\n8•\æ>\r\ÓL\Óù¤pN\Õ\ã·z÷\r:oe\Zw\ÆMw|\ï\Ü\ËyX± :\ÖUÕ˜$º½F+Tõ\éQ¸\íŠ\çL\Ğ\æ^Ü“·ğ¨e‹\Ëù³€+ xr\Ø\éTLt»¿»Ò­1pÁ³%¾ûu©\Â\á°1V$‡iç·¥3f\Õ<riˆ‰€(\Ø<Söa\0&†2®>´óvUÿ\0J¤Bù€0¥Y\0\0t§,;Šx\\ƒš\ì§S	J\â¯Ó½?ªóMöü©\Ûr¸$jØ\êr3Ú¤^§šp\0\Å?=±ôª(\é\éA8\Éô¦n\ÂóÖ\Şô\Ä)#\Ğ\Ç§\×\Ü\ä´Ğ€\à÷\æ“ŒşTg½’Iéµ`\Í.r)¥°88\ÆZb$#$\Ó\ÅF¦œ§=\è\"d0\êV\áH\ÍFƒjG\â#øS²W©•êš·\åS+\×Ë‘d…u\Ú\Ã \ÖeŞcÌ‘r½Ç¥_V\éR†\ã\Ï\çš$E•p@­K«(/\Êşµ˜C\Æ\ØuÁô k:KyEÅ£s\ÇCZúOˆ\Òf÷Ÿºœq“\Ğ\Óønµ“ª\é\Ñ\Ïp0ÃGQM;\Ş9\Ç\0=i·\Öº¥£\Ú\ŞB“B\ãX~¢¼\ãNñ-\æ•0K²gµ\è¼Ÿ\ã^ex—¬±8x\Ød\Z»Ü“\ÌüE\à\Û\Ï—º²\İs§õ<e\â\ã¸÷¬\å\â=Á‡5\ï!–EÁ\0‚9¸/ød2_\èj#Ÿ«\ÛtWÿ\0w\Ğ\ÔJ#>\ç²\ÚI¾69­uºN¿\Êy7x ÷®:9\Ê\Èö÷(\ÑÌ‡Œ0A©v\í\åO#¡)Ø¦®tz\ç„\à¿Cqg…s\ÉP+¹³ŸOœ¤±•9ô\ë]¾•¯½³,W\r”\è\Z¶\ï´\Û\rr\ß;WyUz¶\ç–ÿ\0­Q·\å>´\ãòñ(\Î;†´õ=\n\çJ¸*À˜³Á¨E¸™T°ùs\Èõ¢\àO§D©™\0Áj\íü;jV6»”`Ö¹\İ6É®n#…¯\\v\İ$kI\"\n–À³\Ïpr*ôs¬ƒ®¥fŠrn6õ¦\Äc{Û½N\Ê$\Ér6ö>•\Ï\Ë\â&\ËVM\Z[¥û{¨,£¢\ç \'±>•~{\Æd©\ãÚ˜‘Â’3Ş¤P¡=\ÏZ¤2\Ã&œ’”\àò(×µM~µl\ÔUÅ¦\"U\â’H–A\è}h\ÎE8\Z`VB\ĞI†\éŞ¬W\Ãzt¥eWXT38µµf<…i¡2¤²\Ë=ø…p!A“¬i·q\ç\rŒ)=zVu¬ó5ÜŒ2O\ÍÔ¶jk¹G\Ø\äó	n0\Ù\ï\íN\â9˜ä‘¡ff;§o1Áı¥4¥·1\'½ À\Öe€ c=h\'\è\ãÿ\0­HÏ¾h\Í \èH¥\ÈúP)\ËÉ¦öö§\Æ2\Ô§©C¢h\×zœ\Ø;A\îİ‡\ê\ã_6\Ş\ÜÏ«j²\ÜHÅ¦Bs\êI¯Lø½\â\ŞA [°+MƒÕAü\Ï\â+€ğÕ‘¹\Ô…xCõ?ıjŞŒ.\ìD‘\éÒ„iU\èF++A²[{8ù˜V£dqZ×•\åeĞ˜++\"šO¯J\\\àcÒ™÷?v²,Šb6\äã•q€Ÿ^M:b\Z@½©À``qM­4{\é\ÍWh†\à:Ö®\ÈWpX¨«B*ˆ™¥ù{qV#ˆ\'\ä÷©£‡i$ŒS¶\ã\ë]4¡mY”\å}L&\ŞZ—n~aJ¿\á](ÈŒ™¥\Ç\0Ó±‘\éF>^µhBgò¥Œ‘A\ä\Òg•B»‚{Qœ”\Ì\ã\"€\ÜSHWœgš\0÷¦n dóš	=3œ\Õ\n\ã·w=Gµ7“@#ŸZ\\’¹\àJbcŠ^Z4ƒ\ÏJ`<`v\æ”t¦u\ÏaOû~\"˜Ç“R7\Ü\Èüª$lœÇ¥H\Íû³zPR¦¦Vªªje\Îs_,zE•5 nõ]I\íRŠ`XV\ÅGqm\ÂŒ7÷©¡½jEc@\ÓBö\îC=j\'\×\Ğ:$©µÀ \ÖUÅ“\ÛüÉ’ŸÊ€0ntXgİ‘×­Wµ{\ÏË˜É’ÛºÕ¾§<ñI$+*\í\"„\ì†©Á’\çº÷­H\å1\\öW3›‹&*À\ä¯c[ºN»\æ\"›÷W‚§½h¥rZ\Ä\Ş²ñ~h\Äª>I\ÔuöoQ^awg¢^ıQ‹cÿ\0Pk\Ûb\rW\Ôô»=fÍ­¯aF\İ=Túƒ\ØÒ”nTec\Ç0¯‚µ¡c}=‹®\ÂY{­;\\ğµÿ\0†¥2¦\ë8$”öoñ¨l£7²ª¡=ı++´i£GE©j\Örè…¦@ò1\Â)\ëš\Ä}0I\n\ËF\0\í¡o¥\ÄH30˜¯\İ$qùVœq\è8qÒ¥\ËRHô;io\æÈ¸‘ø¸­|\äT\ÙH\â¤PF=;b‹bšyB(\ä\Ò\ê\Éqo§\Ïıšb[Í„Bòò¡½Mi[CöKM\ä~õ\Ç\ä*«\Ù‘ZXG˜ø#Á¶:\ÍÎµ\â\ßy¼˜”¸}\Í\ŞB•z,cÇ¡õ©\âµ\ÜK`{\nFŒ©úSl\0·¥\'ZLô9§>”4=@£±•G¥QŠ=£\'­\\ŠR8#\"š 4¹÷ §ñ\'Jg4\ÄÇ†¤fVR¡”ğA¦g\Í\Üæ˜Š¤\Çm\'l	@rS9\Åek7Jì–±•9s\êÆ·/o…•£\Íü]zšã™‹»;³“I± )i\0=qG8©(CG\æƒ\Å&y¤©3šnğ:w¥\Í\0=y¤º¾‡I\Ó.µ+ƒˆ­£/\îN8ÿ\0?J9®\âÎ¾-ô\Ø4H\\	%>l\Øô\å˜\ÏüšWvyV­¨Oª\êW·?4“9cøú~ƒğ®÷ÁZFÕ‰Jü\İø\ï\\.‹gö½EÈ‡$ûö¯mğÕŠCl\ãŠî¢”b\ä\Ì&\î\ìtq 5\\`(À¡½\è\Ü\à\â£v\ÈÇ¯Z\çz³A<v ğ=©2\ÉX\í\ÇBx \ÔfM\Ø\çùS\Üt\éŠD=\ÍF\Ç\'wr*„4ò\ÄñœñSGÏ˜òO\éN†0>b9\ì*F9<\×E*}Y”\å\Ñ\êx¦‘”\éOc\íH~\îk¥1¸\Çz1Şœ?ıTqÔœU¡\r#8\ÇjCŒS‰\ÆqM<ô«B\ZF>”\ÂsÓ¨§‘\ï\Í0ú\Õh›=i3´Œpy¤\Éôıj…<‘\Ï\éçšA¸\çF9ô¦!\ã#<Rƒ\r3=GR{P	\ÔÀ“¿j^ƒÖ¢\Ó?¥H0\çLbƒƒšx\Ç½0)\Ã?€ B«\äj\Ã\å\äjº¬\íV9sø\n\0\ßIöŸ»ŸÆ¬-\æ8ò\Ç\çEòÇ¦(\Ôüñÿ\0Ç¿ú\Ôÿ\0·\Ó?üzŠ(\07gw\ÜıjE»ÿ\0`~tQL¤¹ÿ\0TŸn\ã<ÿ\0À¨¢\Ì\Û\ÙR6‘\í\İ\Ônª_\Ú (>W?\ïõ¨¢€\Ô80\çşÿ\0Ö¬\íAşñ£¯!ƒt¢Š´O80\Ï™·€Û°•tQ\ë\'8ò?ñÿ\0şµV«b\ä§SYc`ö\à©ùJ–\È?¥p¯5­µ\Í\ÇÙ¬\ÄBI\n\á_\î€{qE6*;„zˆuÿ\0õª\â\êcşxÿ\0\ã\ßıj(¬%]L\Ïü{ÿ\0­Z\Zeú\Íz¡ùG8\İÿ\0Ö¢Škq\Z³ê›¸0ÿ\0\ã\ßıj€\ê¸/‘\Çû\ßıj(­„/ö˜\Üq6ôù¿ú\Õ!¼G“\ÈïºŠ(8®\×9ò¿ñ\ê”ß¡ÿ\0–ø÷ÿ\0ZŠ(\â\çıÖœ·xş\0\Z(¦\"U\Ôüóÿ\0Çªcu\Æ|±ù\ÑE1\Év{ @nO÷Z( F¹pó\\¬G„E\Ü©5˜ƒE/r\ï7\ãõ \Í\Ç\İıh¢ÈŒ„”…\"Š(»\È8†B=:( ˜²À€N+\ç\Ï\êW\Z¦½sq;\r\Ì\äc\Ğ\0ı(¢´§Ô™llxJ(\ã\n\Åw9<\â½r\Êaº*¦3ÖŠ+ªÂ‰œ~&Z7GÆ\\ü¼¦\Z(¬ö“Ÿ»ú\ÔR]6\áòô÷¢Škq1>\Ô@û¿­:)bJgôQWˆOb\Ï\Ú\È\Ûú\ÔmtA\'oOz(®Óœg\ÚNG\Éú\Ğ.\Ï÷Z(ª}¸“÷?ñ\êS{ÿ\0Lÿ\0ñ\ê(«Bo1Ç—ÿ\0QöŞƒ\Ë\ë\ßuVˆ–BÚˆ\Çú¯ü{ÿ\0­Jo0¹òÿ\0ñ\ê(ªBcğ\ã\îÎš.°\Ø\Ø=z\ÑEP„ş\ÒùIòñ\ïşµ4ê›‡ú¬À¿ú\ÔQT ûa-\ßz{¹¹¿÷¨¢˜‹¼cÿ\0\ãÔ†ÿ\0\'W\ëÿ\0Ö¢Š\0\Ş>\à?T½\Ô\äˆb5\ïš( Z\ê\Í$A\"\Í\Ó;¿ú\Õ{ûW\äÇ“ÿ\0õ¨¢€?ÿ\Ù',2,NULL,NULL,'1',1,'ck1232','2016-11-23 22:22:19','ck1232','2016-11-23 22:22:19','N'),(7,25,'0.jpg','ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿ\Û\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\05?\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rğbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Ú\0\0\0?\0õ~_Ê—=ES\Ú\Ş^IbW;õJ\æ\È^d\Û]:\È:®ó^o1\×\Êk’ñÒœ®½\Ípğjzl¥\ÌÒ²XÕ­?[I\ÈIe+\'N¼Q\ÌW³gpv?•80\Ï¸SJ¹ºC5…\ìğ\Ì9\Ú%![õ\â¹Øµ\ícLŸÈ¿–\áXe\É4ÔƒÙ³\Øm\ç\ÛXğj¶¹\á\Û\rz\Íá¹‰Ia\Ãc¥szN¸·\ÈH˜\íÑ¾•\ÔX]œsø\Õ\Æz“(4xô¾\Õ<¬Kuf%¹S´¨\éõ¯/ñ\ä÷7sM.|\Æ=\Î+\ëù‘&B’ e#Œ\×\â/„\Ú6»ºHÉ\Ï9^™®ˆ\Íu0”;6\Ù_yƒË\İ+C\Èh\Ø0\\ƒ\È¯C\Ô>\İÚ³Mix²m\ä&¹	¬ä°\ì\îGÎ‡ªi\ìf\â\Ö\æw™\Ô\Èâ¤‰’Hb’\âÔƒ¹I\Å00Q“ôª$°\Ä79#šnH{zSŒnzq#99\0ô8-€8¥\Ğr}¨`\0À¤ò¼cµ\0?\'§a\Îq@\î÷\Å °\ä}\r.\0#=\è\äñ\Ç>Ôœdö\0ò:P3\ĞıEø\ã\ÇZ\0UÜ£~zqV\â˜J?R*¶\íËŒcœ}(ŒpG_QH\nš¶’@/ù§zÁUx\ÉV\ë\ÜWon\Â@#\Ö^¯£L±}\ã\ÏÖ˜±I’LsV·º~†¨°h¤`\Ü\ãT±H{uú\Ğ\àp¹\r×­=1€Ns\Ôf¡V\Î\0\àšrñŞ€,†\íƒô§*ñ\Æ1™¨ƒ6I§£ö9\éš\0pQ\ÇP:qNm¤p\åJe\0ó†“v\Ó\Ôs\Û\0¸Ÿn§¾jUG^¥F#©\ÛÖŸ\Ô\")-\Ëqõ©\ÒB¼N:UP\Å_–\â¦x\àç¨¤\Ík\r\Ò\ì#šÀ½\Ó%·?(Ü£µt’®J±ö©—\"\ã\'ù\Ğ3ˆT\äzT¢A(ù±\ÇZİ¾\Ñw†’,g¿\×?,À\ÛÊ\æHğ\Ê\Ä~5j\êvcl³ •QF\È\0ŠIc3È¢Àl\Â[­H˜kù\Ø™cYòjWW\'2\Ì\îs\Ü\Õ\ä\ç<\ã\Ó\çƒ\É÷¡$€´²u,NI\ïÚ¤sÁ\È\ÏQT‡\0\ç=E<3„ö\ï@\Z±N\å»1V¡½+\Ğ\ãš\ÃI6¨çŠ³¸\èI½\0u6:\Äö’ŠVF\ëÁ\Åw\ÚÄ»\ëGD¹&Dõ\ï^CÁ†<b®Cy‚2N;R°Q\è¾3Óµh\×÷ªö®…~t\Ã}+\å+\rNX$\ß”Ç¥{<U5Ê¤SÉ» \ç­.z—\0UY\îvt©\Ã‹p\î+*\ë;1„—\ëP¶cÖ¡ \æšWÀ•¦vS\ÍT’Y“j`H5 \Ú\ËÈ¢ä”’õÁ\äñW!¾\Ü:\Ô2Z«\0ª\ín\èr¿¥06Å†sK\æ7­fE3§\\\Õ\è¦V\ÄL&aSGrA\ëP\à\Z6b€4|Š”>Ee©+Vc›¦hzŠ$\Ïz˜\Ğ\ÑEÌ˜v>E`\ê\ÖRÂ¿j´«\Ç\È£\ÓúVw\Ã\ïˆ¾-´W2$Z¼û\È\Ï`şúÿ\0QÚ»)m\ÖE\ÚG\å´\â\ì\Îø»êŒ­6ò=R\Ìc}+[ğœ\Æ\ãOm¯\×g­Z¹2h¥™	‚C\Ë\nŞ·š;»tš\íH½µGi«\İé’›[ø\Û\Ôr>•\ĞIo§x†\×lŠ¯Œ>òÖµõ…µòyW‡\ØÁrw~¿\Òd7\ZT¯,\İxPVŒ\Ç\Ôt-KÃ³ù\Ğ5 9vúúWI x¦+¥Hn[l\ëIa\â¸\ÛıT‹a?)8\àıE3SğŒ©öıEWaˆ\Ü§§ÒŸ¨zı¥\Î\åUr7­\\\éÒ¼³EñÖ–ÿ\0b\Ôc`«\ØöúW¢iÚŒ+\Å(tn„GÖµŒº3\ÂÚšóF\ÃÚ¾iñ\ì-o\â‰\Ôq\ÏZú[¯¯ø§\áK\Ã~u(#/\å°+h;H\ÂJ\èó¨˜I\Ì2;\ä\ÔÛ˜²\Ø\È>”Ø›¦=±Z>\ä\Úø*GZ\è02•¸\íO–÷ôô©®-pr£‚sUsµGz`J	\İ\ÆsŸZ\r§jn:ô8©Aù€\ÍÄœœsÖ•‘\ÏOSH\nO\é\ëAnû@=	4\0ıË°\ç¦¤™<Œæ€§Î•G9\ÈÀ÷\í@ŸQ\Øb¥R\ã\Ó5Aa·‘BŸ9ô 	3µsÚ®Cz[òqT\Æ\éôâ®A(G¹ µ=\";”w‹‡\êk›ehœ£‚1\ë]…¼\åX#”ú\Ô\Z–³!‘0	†sq\Êzƒù\Z¶?Zªñ\É»]qƒÚ¤B\ä\æ€.©#–ú\ÓÃ¯›º¯oÆ¥ONheoÎ¤##¿øUt`	6A8\äPŠ;^hVÁ=3I•ú’ixlÿ\0\0<€xâ¶§#œbš9giùPp)\"\È	\É=GJ”œ?QU°\ã€=úS\Ñ\Æpzt\é@â˜¢€yæ£º\Ó\í\ïS!B·¨\íL\ê9\çŒu§#²· ÷ j÷K–\ÙÙ€;zñTÕ²Fp+ºo*\åJXº†‰É’!Š\0\çzöÇ¶*\"›[8³VZ)!b‘\ê*23\Ï\ä(\ãÓ\åB³ƒ\È\éJF1ƒÓ­0zs@o\0pqÚ¥I8#®\ëU\ÉÀ\ny#½€\ãŠ\0¶’\Î\rY\Î\Ñ\Ûš\Î\r\Ç_Ê§IT\0£¿RV+Œ3Ç­t\Ş\×_N¾B_Œô5Ä‰>n:zÕ„œ¨œúg¥\0}w\á­f-F\ÅpN*õüX;€¯Ÿ¼\ã6Ó®’\Ş\áğ¤Œf¾€´¼R³WF#¨ h\Î4\Üf¦š\"Pö\æ€\ZF)W\"I@\Ér\"?1â“\Ç \àæ¡»¶ó\â }\êå¤¸¼Ó® ”\ÏZh–vF$aM”?)¬]~90¹­x/c”d0\æ˜’L\Z_ U\Ù<\Zµ\n“Ş˜ñF(E<g½X©«	6*\n]§µ\0^W)\ÕM©æ¬‰8 gÂ–º¥æŸ©-õ•\ÃÁqnIò+\é/‡?\í|]j¶¥!\Öc_™3…˜¬¾ş¢¾_\ç55µ\Ìöw\Ü[\ÈñKWC‚¤w²55©¬&\â}«wl—4Nª\Ùn\äW44»\Í\Z_´i¬JwÛ¹\Ï\á\\G€ş4Z\Ş,:w‰Y`º\à-\æ1Ÿ\ïÿ\0tûôúW¬M$7‡RNCPEqJ.:3®MhV²Õ­oñ£É›8(üs\íVd³pwBøö¬[\ë)	Ş‘­\â«÷dCŞ¢·\Õ>\Ì\á#¼hÛ¡‚ñvşG§\ëP]»©i¶W\á\à\Ômü¹O+*+	ôıc\Ãòı§M”\İZNÃœ}Ev+©Gp»/m\nú0ù‡\áT\îô¸Áó\ì/İ½J.4û™VúÎ‹\âDû6§\0¶º(r1\Ï\×üj	4\íc\ÂÓ‹‹k‹^§Œ{Šmı‹\İ6/¬–SŸøø´ 0úôi\×z–”qi?Û­GŞ‚PCÀÿ\0J`uú‰\íudò‹yw¬lyü=kj\æ\Ú;¸\Z)T20\Åyü¶úF¯0’Ü¶~9\Úük^\Ë^\Ôt’‘j‘ \éöˆù«Œ\Ö\Ì\ÊTú\Ä\á¼qğÙ i/ô\Ä$}\æŒw¯5@b”\Ç(!ÁR;\×\Õq\Ík¨Aº\'Iú×ø\ß\á\Ôw\Ê÷ºr¸\êTÿ\0¯]P©ÑœÒ…\Ï$‰„¼*…İ—VLÕ¹b\Ê\á\àn‡Ò®XB\×÷	m\åø\Ílec™Só`ôïš•pCs\ØV¶·¡6›q\å\îù\Ç&±Q°\Äcù\Ó1\')\É\ÈãšˆO#J™AnC•Û^ŸZUùI\ãµ5x<ô \Æ	\Ç~1@9Aòô2(@I\çZ7±\é@\Î\Ï¾ô\0ªF\Ş\ßÊ—øz\àzTE¶¸\ä\ÓùÙŒ\àš\0]§\0çš±m9\á	<šsM.1Ó¨\ç9 b\êºZ\\\ÄY~÷c\\¤Ğ½¬»\\\ï]„W,\\û´\ÍKLK¨‹/\Ş\ì@\Í 9X\ä9S\Î;Õ­\Ù9\è*¬Ğ½¬ÌŒ¬>´© \çš\0¼cõ©:.;öª¨\äŒn5:É3Ó¦h]\ä¶\ÈjP0€Œ\àvôª\Ã#ƒ}*Xß \àzP\ê:ŸÒ“\0œ\ëL^\Ø\è;bœ>v…\0H8\ïù\ĞF;\â£û\Ã\npz\nrŞ”:œ¨\'šy!€\àzP+OCô§†\ïs@†eù±Ç½YŠ|)V\å}j¡bÀb”¯\ã@¾\Ó`ºB\Êa\\\ÅŞ™-³Ÿ”âº„Ÿø«aºŒ«rH\êFiÁO\\:ŒTE9÷ºMGE*Y¡Á\Ç54,0¥}³@\ÊrSN\Şw\î#ƒ\ëOhöchú\Ô<\ç·J\0z“ÁúúT‡¨\ã¹\ïP8\Æ\çJ8`	 e°\Ø\ÉSÓµ=[kséš«¤·Ò¤V$rH\â€4`˜¡) ×±|7ñùWK\É=0\Äõ¯F%\Ç\'ª\å­ÌL²\ÆJ•9\ÏJB>\Ë&;\Èˆs‘Ú¨IÓ‚+\Í~üB\nš}ôd)cÖ½^EI\ãG\Ï¨\ÍöR4Ãš@/µE5œW*U\Ôf¥\à@4\Êj^\ZdböùJ\Éó\ït÷\Ú\ê@\è\Å\×aÈ¬Ë›o2\nš¥!XÁ³\×s€Çš\è,õH¤QóŸz\çoü54Y’\0x\ç–³\Ü\Ú8GHªÓ K\åX}\àjÂ²µpvzÁ\Ím[\ê\êq“@ QÚ—5\rú°\ÕÔ¸V\ï@\ê)\ì0´ˆ\ÊpA©\\(ñÏ‹~\ë~™\ÚHMÍ <Oô\ãµq§ƒ_Xx[\â†üyn-w$7¬>k9ñ»şz7\áÏµr¾6ø+i\æ\Ş\è;m\îyc>F?Nß‡\åHiŸ=\ç]g…>!k‘R\Ö:\Ğš\Òo™ÓºŸ¥bk\Z.¥¡]µ¦£m$/\î8op{\Öo~¼Ri5fZml}A\á?ˆ\Ú‹¥Š\ÜIö-E\Æ\r¬\Ç\ïö¡úp}«³¸°‚@Dƒ+C€\ßÎ¾.Gh¤ŒU”\äÁ½·Á¢I§xœ¾øö¬w‘¦\í\Ë\Ó\ç½9Ÿ-J\Ö\'M:\×Ñª ‚Û˜¢Ú½N\Ö#ôª\×Z\è´Fg\Æyoşµ^i-\å²K˜%I`•¤‘œ«:j\ÌûW$\Ê\ØtŒt&¹/©ÒŒYüGu5\Îb²†(\Çü´pI?N”\Ù5û——Lúl§\Ôm2N\Õ#ÓŠ\É{B\ä\r£©éŠ¡‘\Şø¶\íH2G»zy‘óùj¾ \Û[‚&²	\ë\äË•?ğÿ\0\Z\ÄÔ™|Æ?Ÿ\Åc>s;ä«ëŠµCg ZüQğı´Š\â;ø$\È¤K©«\Ñ<;\ã-\Äj\"´\Ô šb3\å\çkŸø	\æ¾z\ÃSOÃ«g\éŞ¥\Ã×šU\ÌWV²<SDÁ•Ğœ©­\"­\Ô\ÊJ\ç¶x\ÏÀvº\å»\Íˆ\î”d8}yN—gq\áım…\Üe\Z?QÁúW©x;\âz²G§\ë`\Ô~\è|a%ÿ\0[ú÷†,µ‹i¯šT\íp9­£;J7\ßs\æÿ\0\ëf\çP–f9\çŒ\Ö8‘.rz‘]·‰ş\ëp±6…g‰z\àŠ\æ—À~&Óùt\é`òWb¶ROc\'.†p;T0{Ô¨I\à\ç½Iqj\ê	\nÛ‡j¨²NFqTImF>\î}*E?\'N@\ç>µ^3\è:Ÿ<sŠ\0•UX€1\Í?!GO­D¤osR…\ã\'§Ò¾XG?J@„\å¹\ÈTÌ¿)\ç9éŠƒn\È½\0.À¸\Ç^ù§õ^)»F\Ş;Ô¿)A‘ƒŞ€\"d\\‚3ùÔ±\İ:\äv>´\Ğ0\İñ\ÛŞšügoJö	y	m£5\Ê\Ïm%´¤\ã=q]lS°\\\ÇzeÕœw±6=zR•Iy\ÍYWV\Æ3\ÍAug-¤Ì¬8ö¦¬üy \è\Ã\0æ§Iöª\Ê\ÇKf¥iidd½iû2=;U|\ão­J„ L	T\áAÁ\æy\ÇcƒM@É§«.qj\07| m\äô¥\r·½&3Ç½\àõ 	cpXryõ\ïR‚	\à\æªw\Æ\Üzš[Ï±\0\ãós…9X‰/½\"pOLzSPüÇ°\Å\0[tq‡\èj\Í>)\ã,£Ç¡¨ø\nû\Ä\Ô\Ñ\Î\ÈÀ”\Î]i²\Â\ç+‘Y\ÒÁ´Œ¥w¬#™@`±u\r%€&,‘HHğ03\ïA\àûU›»g…şe\æ«?\ÂH=ù¦1G\Ê:g\ëR†²>•Àœ§ØQ\éHd\é\ÔG\\\Ô\Ê\Å[#ô\íU”·ŸÖ§\\‡\Èş´¹iu%¬«<LU\Ô\äÚ½\Ë\á÷Ä¤»‰,o\Ø$\Ê0	?z¼Œ+\n±m;\Û\Ì$Œ•qÊiöš—(25Zò‡ş>óö\Ù^¾$OZõ¨\Ù.\"‡ Šˆ±\Å¤+M\Ç† ÷¥‡ls\İ\r&*9\×|dg±\ĞyqIùT©¬mSÃ–÷ˆJ¨\Í`ÿ\0\ÂCu¢O‹€^zúWW¦kVZ¤A\í\åROlÑ°<\Ô4«3%Aªp\Ü<gkd\Zõ™\íb¸RG5\Ì\ê\ŞG\â>\Õj]\ÄÑ…k|Ã½k[\ß0x®vki\ìe\Ú\èq¸«]\0\Î=j‰:\Û{\âq\Íi%\È`9®N\ÚnzÖ’\Î@4†|c©$n\È\êC+)Á\Ô\Õ\ë¾ø\á¦\ì¼H¯}h>QtŸ\ë“\ëıñúık\Çğ8\É\æ‚	\ë€i\×>Áš\Ë\Ã?t?>7·½¶”`Hœ•>„uõ¯ñ¯ÁOEgº\ÑÕ®\í:ùÆ¿O_\çõ®Añ.«\á‹õ»\Òn\Ş\Ş@~`9WŒW\Ğ\nøÑ¤ø‰c°\×V=:ù°¡\Øş\æS\ìO\İ>\Çó Z£\æ™#x¤h\åVFS†V ı):WÕ3øS¢øªq{\Ìeeı}E|õ\â¯k^¸q{n\Ïn>\í\Â”ı}(\Zg_ğ\ã\â2\é\Út\Õ\Ü}••¾\Ç;õN÷I\ï\Û\é\Ó\Øü=	‡D´†S–X\Æ\æ\ÎrÇ“\ÏÔšù[Hµ7±—8Xn8\Ïù\é_J\İ\ß6¦\Û[[°R±¨>ÀW\"	jº”$Ú³55C\ä\0ƒ¹®2òY/¦0Û‚±†oZÓ¶\êò\äfF\êI«Ø…BW9\Ğs\Ëc8Üz“Zv¶6Î¡pzqNºÓ¤—\0\0	÷ª\ÂI4\â\Æ2Ø¦#z\ÇOµ•]>S\ßÒ®Í£\ÚÈ¤¦0F1T9]“p\ãz­>©5¤ylñ\Ô\n­Dc\ë\Z“4Œ±sık_\Âş4º\Ò\î£\ÓõILÖ‡\n¹hÿ\0J\Ç\Ô<T³‚§n:\Ö;\êò‚3\ë[GmL¤‘ô,w0‡Bd\È5Z\ál¥W\0€§µy÷|fº\éw²ş\á!‘\İ>‡Ú½2d@À‚§\Ú2\ÛC\æMx…\×\î†x-X\×6eÇ™OZ\Üñ¬\rm\â{•#œü¹\ïXğO°|\İø\é]\Ø\ÂKR‡\İù[=jÀ#<û\æ®]Y¤ˆ%\ïw¬\Â\n6{\n²KJ\ÄdŸzFIü\ÅWFœ{sRƒ\ÇJ\0Ö—‚pzg‘Mú}\éGR\Ç?+ŒR˜\ä\â¤_›zR”œğ:š\0®H.1\ßŞãŸ¥#\0zŠS\È\Î8úõ a³ã¹§F\Ä´{\ÒÄ£\à*GU\Îö\Í\0Cwg\ä\'ûØ®N\ê\ÒKI~\îx8®\Å2¹Áüªµ\í¬wHGñb´R1¶*ÒŸ‘N9õª\×V\ÒZ\ÈA.iM\Çœv¤\å|{Ô³xªÑ¶TsS!À\Ær1@¡\0“Ÿ ©†JŞ \Õe=NsOŸ¥\0J8`9=…9rI\ÆqMSœõ!c÷}?\n`½º3\éš@O~\é00œıh@\ç9\çŞ¤\É\Ï\'ƒ\ë\éP…\Ãgı)q\Ï\0\Ğ¹$òrz	!s\ĞSC|ÀšR{gŠ\0z¹\ÎA*\ÒLpA\âªm\ä\0=\é\Ë\Ğ\àœ”€/4Ø¯\"\'\0Ş¹«\Í&[w$®1œt®ª9™{‚A\æ¬mŠu\ØË;\Ğ3\Ï\Z6^µV\É\Î9\ÍvWš2²+Ÿ»Óü§J\0¤T\0zSòxú\n‰†N\ÜM\Ï\Íô e¨ˆ=¿*[\0)üıjš¾Ó‘\ÜT\ë6H\àœP\ëYä·•e‰ğ\Êr\ë^\Ùğÿ\0\Ç\Ét«exø•p2O¼5\\qÒ¦¶º–\Úu’6*\ë\ÈaÖ€>¿WI\ã„})¥k\ÊşüB*–W\Î\\pI\à×«£¤ñ‡Q°\ç¥NV£jC(^X\ÇyF\àŠó}muO^}²\Çy€²ƒ\Åz®9ª\×úl:³E2\î)§a3\Â_lµtX®$£ƒ“^\Ñ\\F6¤v¯š|W\á¯jm²\Ü!İ’j\é|7\ã\Û\Í4Æ“3<Ds\ÕN=P¯\Üö{\İ*\Ä!”d\×©øz[G/%k§Ñ¼Ge¬B­«¼™­Y#IW)´;\\óH\'h›c\ä„\ZÓ\ã*0En\ê^Š\ã/½«–\Òk*\à•õ\ÅZw%«$\0Nq\ÓÒ˜qÿ\0ê§…\ÇŠL\×9¤P\Ü^iyúR\êG´\èø³®øA£¶’C¥ƒÍ´\Í\Êöªı:W\ĞZŠ|/ñLt‚H\ä“g\ï-\'\0Jƒ\é\Ü{ŒŠøóú\×}ğ§\Ãs\ë\'ûIšX,\ìWÍ¸’3†9\à(>§Ÿ\È\Òn\Ê\ì9n\ì\ç\ÅÆŸª\Ğv2»n1cyı+QÑµ{²§\Ê	wÏ¥wğ¨\Åaÿ\0¦\ÏÔ“Ö©]_H\Ñ5³ ]‡‘\\5*s3¶”9‡id- HS£#“Z‘\Û.Ü¶¨—†÷©\â\Ü\Ò­bjS’$YWŒŠ\çüVÈgkó—\Î+¤¾F2Àt¬=qE\å„7q€e\"®;‰‹¤ø¯IwşÏ¾¹Š\Ú\á>P²»¿>õ{Rµ´2UX‚;)#ô®w_ğ\\^&´Š\ê4D–H÷=kˆƒ]ñ…Döi‡,ÁH\Ñ\ã\ÓÛŠ\ÕA=™7ksg^\Ğ\Ê;Kn\\g\"° ‹i?0$v\ÎqZ£\âK¸	ªZm8 ¹LÒ¹G\\´’e¹³VfnHˆ`¨5¤SØ‰¸ô7¡/	\È\îk\Ô|\ãV¸•4}E\ãòÁ#wÿ\0d×Z_½\ê©Ê§·6·‘%‰ğ\êC)÷ƒM¢Rñ×€`ñ\r¹¹¶\Äwˆ¾Æ¼P\Ónô«Æ´¼ˆ\Ç\"‡¿Ò¾—ğ\ïŠô¯[f\Î\î7¸Œ=¾pñ·|O~•WÅ¾±ñ-‘[…$€r*¢ùY‹W>z³“x\ÚzŞ¤¼±VB\è>lrjŞ§ _xvü\Û\İDÀg\å“I™l‘\ï[\'r\Z±‚Q£!H9\ê3O@;±µ½}f&·Ü£\ã­sÎ²G.JL’Àf\'Á©\É\Ç\n“Œc¯Ö§P1\Ær;\ĞÔqŠrHÁ\ã¥1W\Ç\åO.s@\r1†\Îx¦œ•&\á\Î@ı*\"ÜŒsøP\0œı;Ô¥q÷x¨ò3O\Şx\ã§4\0\î=¨*W\æ\è~”‰œÓ‰\à\Ğ[\Ë8\î\â?/8®Z\ê\ÚKYO\Êq]’d7N\rC}d—1d\0M 9¤8\çğ«1\È\0ısÚ¢¹µ’\ÖS‘•<\ç\ØÜ’1Œt\â€.†\Ën\İ\Ïj_+ƒ¼U@ÿ\0-L‡\'ŒP2Â’9?*Dlö5bSŞ”rO¤ùÈ¤\\“;SA,\éŠwE<\â\nšp\'@§\Çô,[\éQc¦G9¦ƒ÷\ã=*Ua¸q’=j1\Çš`ôüi°[\ä¿QŠ\ÃŸ~”\ØóÀ\È\ëNrA\0(\0 …;@\íR	h\Æ1šb§s\Ï\"—\Ù\Ï\å@£™YpzSeµIc%@<t¨¹<\ÇZtR[\ÇlP\æ€	/s\×mb\\Y\ËoÄ¨G=\Åze•p\ÜZŠ[dhÏ˜Á\éE\Æyø¨\\Ò¦\Ô6F{ú\×Sq \ÛÊ¦H\Û\Ëa\Øô5qf±²»\ÕOM	ı=ªh\ß\æ\ëÚ£hÀ6~‡“RCnÒ·B;t 	\á¹{gY\"«. ó^·\à‰Œ…,õÁ\è®OZò¥³TQ»œu¨\Ç\î\å\Êm\è\Ù\é@Z\Új0\Ş\Ä6JŸ\'½x\'ƒ<z\Út±\Ú]HH\Î1¯j\ÓuX5\ãpr)\Ñ\ÆiÀS\nz°\Í +j:d\Z«\Ã2cšòøbm\á\İ˜Iü«\Û\n©¨\éğ\êV\Íª}ERv\Ä4­Z\ëN˜<R2\àô\Íz¿†|w\r\Ú,7lø&¼\ë\Ä>ŸI¸fT&õô¬‹y^6Ü­¥SI’}+\ÑÎ\ã`\Ê}*+›8®W£5\äñ…Í‹\"LÅ“\ë^¡¦\ëvº„*\ê\ã8\äT5aŸÿ\0\'4ƒ®sš\î|cğ\ËYğ¼\Ï*D÷VY$H‹Êqık‡\É½P}\Î=¨”‡\ÜQ\ëÚ€ˆ\Ò:¢©fc€R}+\é/‡ºğ„.`p?´d_´\\ñŒF?Ÿ\Ç5\ã\rm­\î|¥­Â†Dg”)\îÈŒ\Ëú^ñ\á\Ëûy\à¾cû\á—ü\ë›-9Q\ÓB÷™£¤j\Ñ\ëZx¶k—Š\ê6%€?{\Ó²Hò\Ü•\Ë\Èyf\îk–š+}7^k\Û;²bEİ´\Zµ´c5\ÅÄ—0\Ët=«•\ÇK.\×7‚M(”npÖ¥1ªw6\Òµ ,Ë‡ˆ\îÁæ¹‹\àö¨\árQ\"µ…ê¤…	!OcÚ¤¹´[‹f\ã \rRo\ŞE{£[H¯=py¿¡hÚ¯7RE\â}Ù²?\";\×3£\Û_[k\ÒYÁ!ŒL¤ƒø\Z\åõ¿i:Ô–\×zm\ÜÑ³³¨,?\Z\Ñ]½Õ‡\ë~ˆ¬‰\ÑN\è\Ü\ì\éŠ\ç \Ğ\Õ\0GU	œ\í\ëN\îòò\'\ËF$+\×S4\ÛÕœs\rl¯c)nX‚\Íh\nG=*øB\Ã\0\nX‘Ÿ†>•`(AŠda¯jº‹š\ëO¸’\Şu\n\ê\èpA\Å{\×\ÃŠ¶ş+·M7Tu‹UEwA7¸ô5óÿ\0$lÿ\0\Ï%şµ…aw5\ÒO¯¯!\àƒÚ´\åº0n\ÌûW_ğí»fñ\\D¤\ãƒ\ÜW‡k\Ş¼ğõ\ÛpZ\ßw\Êø\éõ®·\áO\Å3\â(Æ‘«¹ûtkò\ÎFzô½SI·\Õ-\Ş‘YH\î+4\ÜXì¤µ<\n\ÒE*}i/ôt-\ëò¾;\×E¬ø.\ëH¿m\ËnNpH®c\\\Öˆğï¯§ÿ\0^·M=Œ\ÜZ\Ü\ç$†KY™\\Á\ÇÖœ%ˆ\'­k¬ö\Ú\Ôe‘¾p+\"hZ\n7$~”\É&F õ\ãµJ0¤çš«n\Ç?Zœ°Œ\ã\ê(ªNM<qø\ÓT\á»Ôœt\ÇÖ€ÜF1M\ågüdƒšn\ÓÛ­\0*78##ùTˆ7t¨ö\ä‚?:0s\Ã6À)…2ñ\ïOsø\Ó\ÊQ\Æ\r\0f\İZ-\ÔD\Ïò®f{gµv\æ»3Vùj­å€@\"¢?\'<Vcs¸úv¨.\í\ÖB;=z\ÓbSŠ_“Á\0Ô‰\É\ëURAŸ~•(o¥ ,«\È5*õ\ç\ëUƒdzŒóR#vÁ€&Gm­\Ï¹ùx95\Z:šz\ç‚yö C•G$ñAQ\Û\ëš9\åºR·rFA 2*@APA\É©‡h#\'Û½5YU°À›\'¡\èZrû:?˜\å›\nv\Üpğ d¹\ÉÇ¹\Í&p8\ïH\r\Ô\Z@<“wj‘\'!B±\È\ÅW\'$’)\0*x\Îh<\è²!\nNqX7ºtƒqNm+÷\É4®©\r\È=h“Š\İûÁÏ§¥^ó(³\ÆG?…h\Ü\Ø+)\ØpOzÁ½´¹ŒAlP¦¾S¿zUx\ÚF\'Šdq\0J½mm5\ÉQe³\ß(%\È95vşñ…Î—2E<™ˆñ’zV\nh\Í{ÙˆoJ…¬\Ìgv0{b•\Æ}-£\êğjV¨ñ\ÈFz\Ö\ÊWÎ¾ñMÎr‘\È\Í\å:•\î\Ú&³§j	\"”P3ÒœSP\Ó\à\Ôm\Ìr¨9\äW”ø‹\ÃR\éW\Ñ\ÂO\í^\Ä8ª÷¶0\ß[´r¨ Ji\Ø´BXÚº*ymñ±1\ëQ\ë—L¹i#Ra\'Ó¥6ÉˆVqTõ/	|P\Ğ<o\é÷\Ë¢\ã\ŞV\Ê\È\Ønÿ\0Nµ\Ïø\Ï\àõªd¼\Ñq\×,c\ås\î=}\Å|ø­°†SŒ\Zõ?|g\Ô4¸¯¨X\ä&}ö?\Ä=\çA6<\ëW\Ñuğ\Ûj6\ÏƒûÃƒ\îz\Î\è}k\ì¬¼)ñ3C3A$p\È9eû\ÈŞŒ:ƒ^\ãƒú·‡¥k1Z\îÏ’GÎƒúÿ\0:\ç!\à\Éfµñ=•\å¼e¤‚@\àv> û‘ø×ª\Ş\ß\Û[İµÍ´’¢œ\æ6\é\\Ÿ‚4&Ó’7§;uõú]•üy\0!²˜w\éÖ²œSf°›Š\Ğ\Ã\Z§~\Ñ\à… “\Ôd\Zõ]\"Ö±°@ \ä\nñÈ¢Š\Út,	(\Û\'¥{G†\î]>% õö¬k+F\ÈÚ“nWgAkjŠ}\í1Lt\éU#\îšÌ½ñe¥¸	q!E\Î‘Àú\Ö\n\Û\Z»\Ü\ÂÖ‘¢\ÜûIöh^&·¹q§\Ü\r’cOj¹ªkzt…’`GaÁük„\Õn¬®¥ò¥!—‚\rREt=,\éenb»‡T;…n,pßªùĞ\Ş\â¹\ßkGV‰-g`gT\É>¸®»\É1Ly\\(,j\ÒdJ]9ñV•mÛ±PŒ\n\á`\Ò\í­e‘\íÔ€í¸\ë]§Œ®Ï™·?{8¸ß¶,d&\Öf?\İ\çp\ØS4\ĞQ&pr:~µf\Éaš0rw^1E\äb-\ßNõD?\ã‡\âi€şQúW7\Ğ\Ö×Š[wˆnœ>\à\ÄU\r>\ÎMGP·³„e\æ ö\É\ë[\Çcš[•ğûL{=MAÔ¬—/ò„ \éú\æ½\ËÂ¾+[¨£²¿`“\íôa\Ğgßƒ\\:|v¶Z[®\Ø\âUôÖ…º¾\ëƒò¯\Ş_a\Ñ@?Z–“•V¹†+…P\ÊI\ï^u\âO…–\Ú\Õ\Ì\Ó\Å3C#òJ\ã“ô§XüC²\Ğ\âKmjVH\Ë\â)1œz\í¬u›B¹´ºŠh\\d2°¬u‹6Vhò]+\à\İÅ‹n[÷ûÜŒj§Š<s§ c s\Óv1šö£p«\'QµWñc¬,0Aa‘U\Z» ¬x|°Ie#\ØPœg¨\êk®»\ÒEô>r¿®¥s5»•h\Ïºq¹\íøĞ‡$\äTaºsOW\0\à-\0J£\æ\Ïo\ëJ\Ó?_ZD 7cR\ç§4\0\Ãò`cÚ›\É\\Â¤#$óI´m #a¸\Ï\çS‡\ëU\ÈU\é\Ğ\Óø\ã\'½\0N­“Œw\ëO($)ù½ªpN3Š“@Á û\Û12‘´*\æ.\í\Õø\ä\Z\î\n†S\ë\éY÷\ÖQ\Í)4€\å#aüóV¿.‡5İ«\ÚK\á\íM\\\ç#¥.\ÉsS+{fª,œôö§¬‡q€¤\"Ø©\'œgµN²n\ëÇµSªU%ON\İ\è\Ë1 q\ÓÒ\Ø\'¶iŠÁ~&œ[œc4Às\0¤{\n@pô§pH\0~t\Ö`1\è{zP1\ÈpFz“\ØÓƒu$\ç·Zk8\É\rÒ—<qÜšJ	\äIS‹c\'\ÇzTjy÷ô§ò\äLv †8İ·¸£€zb˜I ¸õ\ïN\Æ=¸ cYòx\ÆsHK úSˆ<\Óp}©\0ôcúñD‘$Àn\æ£cŒä´«/ gùP/\ì¤2\å\Ç\É×Õ½Ö¶±*F«Ö©, ‘»%…L\ÉÀU\ÔÖ“\Ze§š)z}\ê´\é•â¨•xÔ˜‹³\á¨F§\åñ  QÖ•Š¹<–\È{y\ĞxgÄ—\Z\Ê)fhI\äg¥s}\àò\rD\'un\à}A@Lhšİ¾«l¯Œ\ãÖµñ_9xo\ÅW\Z4\ê\æL\ÇŞ½\Ë\Ãş!µ\ÖmH\äˆ¦#k\áGSK¶\\[GwE\Z\äõ\ìd/f2z\n\í‘i\'‰$]¬2)‚v>\ç:\Ğz\àzõ¥#¿ŠA\É\ïT#WAñ«\á½E/´«¹-\ç^¥O=t#\ë^ÿ\0\àÿ\0ŒšgŠcM3\\X¬uÂ«\Ë±ş\ì:ù¨ûVß„­–\ç\Äû·aNx\çµc\Û\ï^=R\æD…6gvõ\à\Óü\çó¬MCP5¬ƒ~9\ÇJ\\\Ô^(r–# •Á\ÄÍ¬J÷A£ı\ÛZÌ¤jO\"\Ë>ö>\\\08\è}8ü+Ğ¼ª‘FÏ–_”ık\ÌVOµÀgW]\ã†ÿ\0VÎ…,ˆX\Ä\çı\ê‰Ç™\ZS•™\ï‰bQ+“ñ‘*\Æn z]H\È5\ĞhÚ¤W\Öh|\ÄV„n±3\Çr€\Æı	W%¬Î«Gÿ\0\íúi\Ój^\í°K\Ø;üğ¿p¹<Ö¸Hõ‹\á,ğj0:N!\Z\"6ŸC^İªi\×\ZeÔ—šDÁ¾üG\î·\á\\n«%Æ¥0V¨1Ô¯z\Ú]Q2‹{1ÿ\05†´Ô¡ÀCƒÁô\é\ç^¹{¬\ÚgIr&\ØYp\Êz×‘YÛ¬ùˆ€˜¥yw#\Úù#Ò†\îô^¬\Ä\×õ“{¨³1\Äy\ÂçŠ¯op!\ÚDcsÖ¨jPŒ«dg§µg^\ézõ\Ô\ÑI	IcAò\âM˜úŠ\Ö)lg)=Î²-B \à\åTõ%õ\Îûvlü¸\äûW\'g£\êMv\ÒÜ¾\Ñ\Ô\"]\Ö\ï\Ö\ÓJ`\Ä\îo”QmI\æ\Ğ\à5ûfk·™0Tu>õ\Õü%\ĞşÙª\Üê²¦cµ]‘\äuv\ëù\ç\\Ö¡¼i¤\îa¹¸\Çjö‡úz\é>µ¶*’2_÷øp?\nÛ¡\Î\Íù -ˆ/\Í1\Ùô_\â?—ˆ©5ö[!\êŞ•f\ÙE\Åü²g\ä‡÷Kõ\ê\ÇóÀÿ\0€\×;\â\íal¬n®A\åd\ï\"O.ñUÿ\0ö—ˆŒ\nKA\Ûùuı•b^\ê·vó ¹–0:ùnF*\İö\Û\Íy/\ŞrqŸOÿ\0]`»™$g\'©\Í;m[ø³]´ÀƒT¹Qÿ\0]	şu¿¡ø§X\Õ\Ù\ïµ	®c HsŠ\á\0:ñZ^\Z¹xõdA“¼óG*\Ù\í\Út¸·Q\ÔdU›\İ\rF\×|`\ê=\ë#N¸C« ´ƒÚ¨“\Î\ï´\é-&1º÷ª!v°\ãzõ-cN‚şÔ² \ß\Ûk\Îo\ìä¶œ¡Rx E`\àF\rL•\ëøT;:`S\Ô\0F;ú\Ğ\àr\0¦²øòi¹\É\ãğ©N\Ş:\Ğ\"&\Î9\Æ=j,’y<cŠ{¯q\Å3Ò€Hô©V^{\æ£À\'\ÜR)ı\á\Ç\'\ëLHs1K\å†\'¯µD‘\È\äS÷94Bö\Æ9£;—­sV¯k!â»²†3YW\ÖK( ¯&“É¤„óµ:9# ŠeÕ£[9ùr\rF²`m=¸©ú?RG\éS«|¼+=]²öõb78µ\0X@A\ÇnÙ©³\Æüªº\ß\ãR¸\ë@© t\Å(ùO^O­5\\1\Ç4\á&=1Ú˜r9¤\ç¢şt€Gb{S=}(ÿ\0\êML gœœõ¨\Ç\İúrhP	\ä~´9ş%À\Ú:S2v‚:\æ€I\0zqš\\\Î2\é@\n	#9É¤fc©ô¥S…\Éÿ\0\Zh\0°\Ü<ŠC\nr­ø\âšcóO* O|RòG\ë@\0‚y\í\Ó=\êD›k\äg½43\Å3\ïc\éŠY\Üãš¶,\ì5X¼›¡\å\Ë\ĞJ½\ZÌ\ä\ã CVc“,6u(/Vğ\íö“\'˜À\Én~\ì‰ŞªÁ7 ^£¥Š‹ca\ÎFTıEf\İxgN\ÕA¸Ó¥X¥<\í\ÎTŸoğ¤R9Œ+¦+£ğ®¥u£¸–6`™\åI¬[­6\çI,/ \ÇFjiòEöU\r\Ôò;\ĞU®{¯‡|G«n¿6$]\"®zWiW’\ÚN²Á!ô¯Zğ×‰¢¿…b™‚\Ê0iÕ qI ùy§‚\È\éM—•\æò½#¯½¸lş|Ñ‚2_z\n’F*\Ä\'òô®¿Àol—\Ì\Ò0Y,8#Ò¸öN2+¥ğj¤š‰V\nOrzP3±\ÖUnHU\Øùl|¬•a\ÊU ˜•Vù°¸\Çù\æºù-\áS E.¿À\Ã\n~™\ëù\Ñq\á\ç[4\Ô-S\ÌY3˜Õ°P÷¸ÿ\0õz\Ô\â>\Ås§Ï¹ğ…8\àqš×¶-\å€@û\Ù\\v«w©¢\'—eÕ¿A\"\í\Ş?Æ³\â\ÚM…\n‘\È ûzŠ@z\'†uGET\'\æ\È z×¥C\å\êF&?#£¨¯Ó®ö2²Šô½Q`ù\Åw8?Q\\µ#gsªº-jz\rüp&\í]»n\î=\ëœk\Äm—€¼Fk·¸\Ô^H‚\ÉC‚<\Øşd?Py\Ï^\ß\Éşò\Ú)£\Ï/Áú\â¦\å«õ1Í›Å´¿ªy,‡\ØsD÷K3«)p£\nô¨…û@\å·es\Ï\Õ!˜Z®šfR\0\ÍU²\Û\Ë\çŒS[º‹[\ß|\æU<â¹¹4«0\Ì\Æi7%wğ+X\êµ2–Bõ\Õõ´q\á\\;û×Ÿ\ë·\Ú\Ë\n\ä„\ì+kXºƒN’ w‘÷Z\ä\á™¼\Î@\ç\äš\Ö+©„\å\ĞôOxb\×\Äyµ”#J€:+c\×S{\rï‡¦—\íVì¬ªJŒpÇ·\áš\â~xˆ\éú\ä(VË‚Q¿‹ñ\í_A\Åy¤ø’¶”+H-ğ\ë\ãò\íTÌ™À\é\×kg¡\å›÷„rOv<“ù×–xóX77é±·C¹ñ\êúÙ¯cñ\ï-\àg\Ó¦…yòÿ\0‰Æ¾{\Õlµ=riµ(]±Û‡\è}…\n\Z\Ü\âx­£\éOµb©}\ê{¹\Í\Í\Ë>r?¥Ve\äqT0s¶¶4Kg¤q»XÑ£K*¢ò\Ìp+¼x!³Ğ°~Q~¿şº\0‰¼JöÚ´q\Ä\ÄÄ«¹ñ^‘\áıV=B$*rH\Î3^#a\\LKºFù›Û½t\Ş\×\'¶ñ#\\\Ût?\ìŞ‹ˆö¸¾c\Ï\İ\î*¦¡¤\Ù\êh\Â<yƒ¦*­ö¹§.„/­®W\Ìp0¡Á$úc¨\"¸¸<O6Ÿ|³½]òÀZb&¿\Ó$²”\Æ\è{\à‘Š\Í1°l^‹46\Ş\"\Ó\ÒX°nA\Íqš†qcr\È\êx\é‘@Ê§v\å\ÅL[hŞ¢8\Ë~Y4\åÁ\í×šb¿\Õ	R¨\è*\È\\;P\È\Í\0W\ØBt\æ(\Ş;T˜l•\ë\íJ\"=E\0&2}I\Î8\ÔEp\Ü\n ú\Ğ\×9#õd\"JLŠ¨p\éŒ\Ó\ã^M\0R\Ô,]\Ão\È\ŞY\Ém!\à\í\ÏW£|¤qù¬GOYÑŒzRhg’j\Ê6FsQ\ŞZ5´‡‚\0¦+\în˜5 ^\Üvú\Z•pqŸÆª\Ç!\İ\Ô\Ô\Ê\Ø\Ãqš\0²·Š™H\àj¢7ğ£½LCŸÂ€,/-÷·µ;`c“ÿ\0×¦!gx§¸\ë\ÜP1Jü¾ÆŒ\íü©6\ä\Î\êE;vHô\Å\0 b\0\çÔªÛˆ\îqÀ\ÅDGR€1\è(P™R;ıimc\Øö¢\n|¹zÒ»lşt\0À[\Ó\éJI8;F{\äÒ’\0ÁSONGS@	÷‰\È\é\èqH\ã\Ç\çO\ïƒÇ¯z¯$™\áO \Ğ2HO$·õ§4¢7÷\Îj“b\î\é\Å1r\ì]†i\\iW+¨Y5«‘\ÊğO­qğêš¶‡¨\ÉKƒ‘=\Çq[–\ÙF¤õ«·pZ\\Dó\\F2ÀØ¥\Ìi]\Ø\Ì\Ò “Åº’mk+µ?\Õ\Ä_\å\Î~\è\ÇŸZô\Ï\Û©c#E2¨\Ä2õ#\Øô5\ä\Z†˜ú}Ç›i#\'\å*y\Ğø{\â-Í‚-­\Û,Á\Ç#\æOp{¥¾Á(¸»0²¼\Óe)q/\á[šl\ïYˆ#¥Y²\Õ\â\Ô\ì>Ó¦Èš½–>x|#\éŞ¦³‹M\ÔIm>m®8hŸ‚¾\Ø\í@&ºÏ‡¼H&b¸8oS]Qu‘S}+\É]f± m!»\Õ\Ğ\é~&û\0^\Ì‡c‰ñ\ÇÁX\îÄ·\Ú\0\Ìy1úW…\ê:m\î“xö·öòC2ğU\Çòõ¯Pğ\Æ\ËıÊ°×ƒ\ß\é\ã\n%ÿ\0–°Ÿğ!õ\çŞ½†ÿ\0AğŸ\Ä\İ][47\È>Ycá‘½ê¦¨\Èù\r\Õ\Óø.\î}FE•\Ü\\€«»qÊ¶¼mğ§Yğ¬,1½Õ—P\ê2T{üëƒ·\íe!\ÚÃšc=Š\í&4\Ïr¿)\Æ?ú\Ô\Ûx\é\×o ’&Ùÿ\0ŸËš\Ç\Ğ5uÔ­¤¤ÜŒoQÁüÿ\0\Z\ÛU{«™Æ·$µİW\ßÿ\0¯P2\î³a¥jö\Ñ\ŞÅ†vo”\ïŸ\ëÒ¸\íBaˆaPGA–\Ü+®û=\ãÈŠ#\â-µ\Ñ\İO¶A\ïô\ëXZ®œcºÀ1£yrsı)Ë´\Õ\Ú	Tm½O+©±ñœP¡\0prk’L36	,{ÿ\0UraÁ8\ç·<\Òq¹Q“[¸7Š[U…§UÀé•kQL	SØƒ^7=\ÑPw\Ä\Û{°\'Šd—’¿\É†6\Æq\È\Ïó¨öH\Ó\Û3\×\'\Õ\"Á\İpüvR*—ö´cş^®0À\Zòu|²\á¥~}ø5¡_«»²—É¦©\ØN©\èsjªOŸD¬›ıYaC‚}FqÒ¹)59\Ã\í2r}*¬÷3JÀdûœõ«P!\Ô&¼¼šú\ë\æf ö£\Èığ\\p9\çµA\ä*Iù³\Î*Ïš\0¸÷\ÍZ3¹\Õøj\É\îu+tPˆ/\ÈÀšöp°=ñ,’9ó\Ï*1…P\0ük†ğ”“Ù¤’0\"“\ÑF7~qø\×{«M\äZ¬+ü\\Ÿ¥&&6‰\Ö\Ú=\Äšó²œ$\ê9Qş\Ğ{r?Z\ŞÖ¼/ x\×N2ş\êE”efŒ\ë\ïù\Zù¿_¾:Ç‰İƒ(Ç \ïøœ\ÔzW\ÄmkÂš\Ém2\èˆÄ8\Ìoõ\ÔsL\ro\Zü \Õ<?3\ÍaOl~\ê\ç\'ş{ı?Zó)‘£vWVGS‚¬0A÷¯­|ñK@ñ¬+grc´¿a­g9Y?\İ\'ƒô\ëYş7ø;¦x‚7¸²O&\è—iù¿3\Ô{ÎŸ9x^\Ã\í7¦vH‡Z»â‹“˜¬#?x\îj\êG†n¼)–÷HAŒ–w+ŒıGj\á\ßP\Ô\å¸=d}¨aÿ\0\ê R-tù%4Ÿ»A\ß\ëKL‡\ì\Z+\İ‰n>Tõ\Û\Ü\Öm\ê=\İ\â\Ú\Û)q\Ø÷=\êxo%¹µ	ı@Ûj9$“\Ş M6\ê\î`‚E$\ìıiÀ”BNÈ¦7\í#;ºƒ@şñÎŸs;f@‘Gjö-¬¼O¤¥Å»ƒ!\\©^‡\Ø\×Í©ş‡uƒ÷[\×Ò»x¾o_!´¶~t\ÏOqM1º›-\ÃE$x+\ê1T\0~µ\êwIa\â\í=n-]Y¶ü­O±¯;\Õ4Ù¬.9T©¸ª˜\ÎA#ó§j%nyıiû8ü(›Ç¥?\à‘zz|\Ë\Í#¡<Ÿ¥\0F\ë\ÎF9¦n8*b…HüEGÑh\0\Ècš”0\Ú*r\Øô5.08\Ï1@w<ûû\ÕÈ£\ávœéŠ¦‚zô¡«‚;\æ€(\ë\ZH\nHS\ßÒ¸Ë»f´”J\çŠõ4d½Œ«›¿½szÆ–ƒ#§µKC9e\ÇŞ§W;²{\Ô7Voo)%~^Ô‰)$ş”€º²v\â§S€9E$ñ\ÕdI\Î	 {ˆ\n\Z•XpF}1U²	\ïÖ¥R0ph.GE?=A\'?J„\İ\ÎsS+tİš@”\äõ\ìi0zf‡|!$GaL©# “Ÿjp\äx\ÅDƒ\å$sN$ŸÃ¥\0I’O\0û\çµ!\ÏH\ÇJföŸÂš\ç\å\Î3ô\í@lHéµ]\Ø\í9?‰¥ßA\Ïrj¹s+\ç1Hhz/œ\Ütú\ÕÄo\Ê3ô¢\Ğ}E]Š0Ë¸}ÿ\0Â¥³HÄ\Ç=ÿ\0kZ¦\èö¸Oj¯gjg¹U\àdŸ¥t–º,²Ø¹-\Ğg)X\èŒ§\Ğ\à¼Sˆø9\"²gğ\Ì,û\Z G®+\Ò\á°[Kq)İ˜\æ¨MfŒ\ãœf¥L§†°ğÌºU\Ò^\é÷Oo(\ä8ü=\ëj\ç[²–ò8õ¸\äÓ¯\ÈıÖ§j¿)ÿ\0}GoÎº84\ß\İ\ïp1\ï\é\\\ïˆã´º¹Š–<\î9\ã5JzŠ4yİ‘»o­\ßi1Du¨’÷LõZ•¯\Ïÿ\0{t\×+ñ\Z\à\Éug6™yº\ÒH²»N@lóúb›§]^øvV—L”›wÿ\0[lÿ\04rpx«Qxs\Ä(\Z\×:Mñ9’\Ùù„ú•=¾•¤d®EJ¦x\î2s\ë\Íløw\Å\ZÇ…u½\Òo$Áù“9I£/B+)h\ê9\ã¿¡\Ê}Kà¯‹\Úa]3XX¬5\'ù|¹\î¦?\ì1\è}\ëY7ø!cª\Ìo´f²±ÌŠ\Ê\ÃÔğ¯›•ˆÁ\é\é^\ßğo\â‰.µ8ü=rEı‰F\"I\É/\0×¸ö?-hÿ\0	•ª¬i4\ÒD@I ¸\ëü‡­u^!ğBè‘¦£¤B\ŞY\\\Ü\'$¯¿_Â»M6[©\æ¸ó¶PQÀY6\0\Ï‚9ö­öP\êU€e#ôX.xEå¶£ÿ\0\è\Ì’\Z<`t\ãÉ¬ûæ³‚\Ë0ÀÁö\áC.y\'\×Óš\ê¼V\Úm¶¹qmj¢\0,TğO¿J\ä.®7+Gx\èNrv¶x¦ £“°³–öö\å\\´ş\ìŸŸ¥Dö[wTPeŒò¸\åH<şk¨‚(\ŞfÂ¹“&:ş´\ãojo‘\"eùY\Ç^ı(Œ[(e\ÌG\îŸJC§5¢±tI\"^\ä\0T{Š\êg\ÒNŸª9Ú²\Ú\\\r\Ä(\åO¥>\î\Õ^U<¯Fşòúzp“À’+22³z¯9O!H\ÜHô\"µ.,%I™£Ÿ˜Ö³\æ…Ğ«±$t\"˜…\Ú\Ò&C‡\\c\Å27\ÚH1¢¶;\Õ\Ë8\ZH\ædQ½@\'\ÓosHmE\Í\Ó\ì`søS¼h\çc ÷š¹m§Kyz–¶±»·_ÿ\0U2\Ú\Êy.’r\ÆF} ñ\Í{7…ü7‡ô¿¶±_°Àc\ÈxP=²G\ë@¿\r\é\Ëej‘…\\B‚„¾ï¬ø¬\Z\ë_c\Ón§W\Û1E\Î9=\Ç\ê\n\ë%+a¥¡G¹\îkÆ¼u¨\íZ2&ù\"9|z¿§ó¤„s*ÿ\0cÒ¥¸só\É\Èş•Ê±.Ä·Rk{Ä— 4V‘\à`=kTP\ä–HX2’\äq^\Ëğ\Ï\âş³i2éš¨:…’Œ‰¿yö=Ç±ü\ë\Å\Ü\æ»_Y[/´°!¥ù¿\Ôúˆ7‡üo¦–£¹\\`\ã‰#\Ïbõâ¼—\Å\ßf\Òü\Û\İ\"«UPO¨ş\åô¯0ƒ\Å\Z‡‰›P\Òn\ä¶h\Õd?{\Øú­{¿„~2i÷\ÓÅ¦k\Åmoˆ\ÏAû·>‡û§ôúR\áºnq¤-\İ\Õô\rÂˆ¬:±\ê}şµ\Ï;ˆ/÷„s\Í}k\âO\0i&µ/\Z¤n\ã!ü\ï\ÇO¨ü«À¼eğ\ÛU\ĞVB!’US¹N2Hö\Ç_Â¹ùœd€:\ÔLs!\ÍEm6m°\ß84ı\Ø\ã¥1\İ\Â$Œ•\á‡\"™iq½6¼¿Ê­‘’~•p†\Ú\èH¿tœÿ\0õ¨ºğ&ğ\Å\Ğ’öl~u<\í÷\ìS\ÚYø»HK»FGfM\ÈÃ½|\Íu?R%úŸj\íü	ã»Ş¥”¹–\ÂF“<\Ç\î?Â˜ûı5\ìg1È„=ª8\Ç>¾\Õ\ì\Z¶‡i\âM8^Z•2•X7?Æ¼¿QÓ¥±£‘H \ã\éT\"n\àT¤dc5\\ı\ïL{T»³_Z\0x\ÇCQI¡…IŒ¨£a\'¯\0psŠU\ÏLñR°Àı*s\îz\Ğ¡~iù\â¢)Á‰ Pˆ\Æ#¸\ïZVö\Ñ^¦8\è{\Öz—±\Ï42´R¼@Z\îƒ\ä’T‡¡ô®\"\ê\Ù\íe \çoµzôÌ·–\Ä8\ãš\ä5m ƒ\Êñ\ØÔ´\Z’\ã?YY2\n¯shö³/y¢921\Û\ëHeôñŠ[$còôªQ·\åS¬œğON¸¤2\ÆKgı*PÀñœ\n:õ\ëN\Ï\Í\×J`N\0,FOøSò£Ú¢R\0\Ó\Æ§øP\0¹ƒŞ—I8¥°W\ëšC2s\ë@\r“\ÓŞ¢2\'¯N”\ç}Çõ\\’\Íò\ä“Hhz‡–@Š3šÔ‹N	_;ñVt?jùòOAZ‰\0“’£>˜¤\ÙIU\Î3Ò¤R¬½kv[e\n@\Ï\Ş[\Íş\í2OAKsE¡½f™)$?6\Ò8\Ï_jõ\Ü\è\Æ\Ø4÷EtToC´¯°\Ï_¨¯\Óut\Ó.U$9(~x\Ç;O­t‡TÓµ_4¦Of\à\×<\Õ\ÏN…8T†ögk\â-kH¶%¾\×#‰ƒÒ¸¹<U\Z9òmY\É\ç÷‡òª“iJK[\Ê>‡š£&•p¸À\r¤\ZJ(\×\ê¶Üµu\â}Fôym\"Ä§‚±.Ú $\ËOz­fæ‡¾)1\"ş5v)EGbÊH\áER¾·\\ù£Œñš°„úÃiò|\ëŠb•ç”’JŸÖŒFi3\ëœw£øH\Î}+¤ğO×§8®\ÇÀ~9¸ğ>£qq„7q\Ï\ÇGm¬;Œ6?1ü«\ã©\Õ\Í.\Í\ïõ-¡\\¼®G\Ô\Ğ\×_\rµ»\ßøa5}B\Õ-\æ‘\İT&pW<uü\á]„Å„NPeñòŒõ5C@Ò£\Ñt-:1…‚ §\ë\Ôş¤\Ö?<O/‡m\íM´k,òH1ta\éCĞ“Ç¼cm«iš…\åÎ¥D®wn\ê0:s^Si¯\Ëkq<Í½\ä™n_şµ}i¦ø‡\Ã\Ş6·{	h †µ”\Äw+ı\áşH¯.ñ\×ÀĞ²>¡ ghùšß±úzR*\ç¥\ë\Òê³¥®DEù\ÏaıqZ»\Û\İ0¿<.\îsX:—>÷wW˜¥(¸#üÿ\0Z\Ê\Õo\ÌH\î‡\Î\ÏzV\év·,ó¤· ©@OcL¸µ‹\ç’2Yr§¥y¶\â\Û\Û8\ÌrN*º–8\äVŒ¾:ya\n*\Å\ØI\'¯\éš5¨m)QdAb0€w¹mF\×l\ëºAê¢«K\ã[¨.Í¹Ä›‚v\â¨\\xª\êh*\î£8\ìs\×üú\Ñf\"\Ì\r=­\ÓHóÁ\ë\ÇùjøW\Ãö\Úö¿•Ş¯m¤»7l‚\äÿ\0\íŸbk’mnõ„a®”™I\ëÖ›¦Z\\kZÍ¥”Ešy\åızş4\ì\Óg\á–•hG™\Ş\áG\Ìf9.}j\Åó¯­uKk¸\Zm\Ã\ï7Aùdşu\Õ\é\Z\Äú¬V\ÌL\Öp\ÆyU¨?…tRC¤øª\ÄP\ç\0óò\Éùü©n#\Î|K®Ám\È\Íò@›±\êk\Æm®…\Ì÷zœ\í–bNS^­ñ\áÖ´4ùM“\í\çqõ#\Ğÿ\0ŸÆ¼OSYôû°ÊŒ’t`\Ü\Zh›‹ƒuu$®rY³Q\É\Å3\Îi¤œ`\ÓkN´kûø­\ÆNö\ç\éŞ»ınt\Ò42†a±Ò¹\ß\â¼i¥_¼6©5\'Š/Vÿ\0X[tl\Åo\Ëc¹ E:%ZY1ˆÇ˜\Ùşñ\è*>õ\íµX\ï¤@\ãq ^\ßÒ¦¼f\Ò;pNù÷ş‚´µ›D±\ĞmlB?tA=¿*@u>ø•­ør\è*Kö«\'b^\ŞS•úƒ\ÕM{¯‡ü_\áÿ\0Y}<ò2ö“p\ã\ÜzıG\é_)X¿™lp\Ø\Új\Ì7SYÊ³B\í¡²¬­‚(\Üüiğn\Öı¥¾\ÒAI\È\ÉUŸ¨\èß¡ú×ˆ\êú£¢\Ì\Ğ\Ş[º€p}\Ò~¾¾Æ½_Á\ß\Z\ç¶T´ñ*™\á´:ÿ\0¼?‹ùık\Ô.ô\ßø\ßI1¼7P\Ê0³ÅƒŸb;ı?J\0ùd¶5\rÒ¬–ï¿Œr\rz·Œ~_\é%Öš<\ë~»3\Ç\à{}\ç^M¨E2OöI#h\ä\æV\"€)À¦4iO§´tˆÁ2İ°ÿ\0WĞŸ^\ÕZX\Ë·AÉ¤Œ\Ëcrö\ÓeFp\Ã4Àôß‡ş?“\Ã\×\ëm|\Ìö·<d\ÆOq\í^Í¯øji«¨Y2<\Å7QÄƒ¶=\ëåœr:\nõ…\ß[C’=W‘›Osˆ\ä<˜Iÿ\0\Ù•)_\éò\ØÜ´s)tª\áöô¯rñ_… \×m~\Ûd\Ü»\å<H=G¿ó¯\Ôl$²’D*\ÊOQT\Ä\ÑT\Æ1R†`\ã_in<g¿?…\0LWŒŠŒ\çñ\ïR\Æ7\ÇSAP¼œ~€  ã‘šxÀ\í\Í9‰ÛÆñ RG9â¥Œ+6{\Ô‹œt§€Tp*\0·¦\'\ë\Å\\òc¾‰†>¢²†\âyü\ê\Ô<.\nE\0`\ëz#FH+”=+¹¶ki\çm{„¿€‚qÈ®?Z\Ñ\Z<¹S\Ğ\â“\ÆG Ç¡«Q¿\0ŒsÚ«\ÜÚ½¼§=i±8\à\ç‘RŠ°=9÷©ıjš¸ON•6ñŒ\çÔ†Y\ß\ÆT\n’7\äŒUu?(\ç?Zx\Èb˜†v\à“Zc¾‘dùpj9_\é\îh\Ãi\ç’zf´´­=¥“\Íq\ÛÚ«\é\ÖR]\\©Á\Ø+²‚\Ùb„F«Ó©\ÅK\Z …@Á\ã¥[&8À\0\Õ{‹˜­—5E\Zk\É\nŒ¤c«\Ò4L¿¿\Ír±ü\Ç\×<U{\×!D]ó0Àö©dùV\ã’yc]_‡ü$|x„\È\Ã(¬:SRÚŠ».)\É\Ù?s\á­F}P\Í<«s\ç8Q\ïŞ¥œ\ë:laue»µ\ÇÀ~#ú×®kš\"¼g\ä9÷¬[/O–\Ş1=\×Ö§\Ú\'º7öS°g%á‹­9İ¥{ı‡\'÷lNk®k\Í,\ÆGö‚!#¨<ƒô5›­øœ\Ü~\Å8\çÏ¶\\\ÆOûI\Ô~\É<\Z®8mB\Ø]Z/Kˆ\å#\ê?®)¸_XšC\ã\î\ÏCvş\âşÍ®¡Â™B\ã\ÅY\Ò.¤i7j·‘\Ñ\"$Ÿ\ÇU\İ\çI\Ö6­´\êdÿ\0O\Ãõ\ë£\È? \ÇÒ³zhus¹-$sºv­§\ß\êmi\äº.H‰\ÜŸ&³\æX\Ş\Ú\ÅÛª\Ì%RB3\ÛÖ´¦ğ\äqûv•ù²;V4–¾-\Ón,™‡\Ú\à“…\'“ƒŒÂª/S¼\ê\Ó\ÕH\ä<Sğ\×Vğ\Í\Û,\ã}¾~YBõô\Ír\ï£Î½”\ã\ßõ…ş\"xk\Ç\Ö\ÃL¾h!¿qƒo!\âCşÁ=~k™ñ‡\ÂY-ZK\Ío‹©„öúVúyóû\éw+É?C^•ğO\Â\ï¨x\Ú+Ù¢>M’™[8\Æ\îß®+kv¶¹hgF@pQ†¯øG£gxY¯1%\ã\äqü# ~¹ª@\ÏC¯ñ\î±ö\ß\\:¶b²M«şù\à~\\ŸÂ½w\\\ÔLÑ®nœ\ãb}k\çmb÷ı\È\ß~RfÇ…ı?L˜‘\çšÆ§:\ëB{y&·û­‚¨5\ë¾ø\í2ôÿ\0•>\ê\ßF¿0ÿ\0}G_¨\ç\ë^V\ê,\ê	\Ï5\Z$I `€\ÏJeT\ë¾Ğ¼i¦‹ˆ2dI\án\å_;øÿ\0\áÖ·\á§ai\ì—$Hƒ§Ö¬\è;Õ¼/r.tùö\Äyš\æ7Ç¨ş£šö¿üLğç­Å„û-¯\Øa¬\ç?|ú£wúu [#ô“\êk\èÿ\0ü¶¾óo´ !Ÿ–1º\ßQş\àZ®‹¨h—mk¨[<2)\ï\ĞûƒÒÀ\ÍÒŒQGj`/lW¨üĞ¾Ñ©]k2§\Én¾T$ÿ\0}ºŸÀ\èU\å\ê0P2Oõ¯¦ü¡®\á‹;˜›nù½İ¹?—OÂ“5.cˆ\íû\Ì\Ù\'ı…Á?®\âj-V\áô\ã–Ò´R İ½N~\ÑD—\\Ÿº>DôÚ½6\Ï\áŠ\à¼}­ı›Jœ†Ä—\ËO\\w?•!g„>0Xjó\Ég« ¶eb©r\î\Üv\Ü?„şœö­oü4\Ğüak\çF‰ì»£–3Á÷ú«\æ\ë™?³4]Ç‰e÷\ç\'ÿ\0­Z^ø¥®x>U‰eûVœ[æ´”ü£\İOU?\ç\ì2¯‹¾\ë>ü\èZ[pIªô\ãú+Š\'¸\"Œeœ…¾\Åğ\çŒ|5ñN0\Æ\Èg\Ûû\ËI¸‘=Hõ\â¸|·¶Ô¿µôh˜\í\Éh—ù\ã\×\éùR¸eam§xydR\á@3ı\ê\ãô\è\ÚiÌ’\ïbOQ]7šq4\Zq\ã\É\Ü\Ùƒ.m\ì\Şn²ŠtKqªk­s0Í´’OL/Aøš“Pº’şòYOWc\è*\rQ\ÚUÍ¢Ç‰¥pYÿ\0\Ù¿:T\ä™;t\Äf\Û·»’ßŒgƒšº\Ò$ŸÂ¨ß†IRp;\ã58;€aFE\0L9ú\Z½\áokÕ‹i÷o\Z·\ŞC\Ê8÷³A\í\Ğöª—\Èp%W­ >¤ğÅÄˆ–šˆ\Âù\Æİ’7\î\äöôú\Z±\âÿ\0…úO‰#2\Ç\n\Ãt\ÊW\Èöút¯”\ÚğÈ±¢¸ı\ïjô¿ü^\Õü6ği÷aµ\0ŠFù\ã\ì·ô<Qa™\ZÇ€5?\njSMy	–(Ád`9ö\Èş£Š\ã5ó\ÕÁ\çŞ¾\ÆÓµø\ÎÁ’	#Ÿhù\á~$ˆı;}G\æş5ø1\Şeæ‰…~IŒ\ÔQùQ\êZM¾-§\ï\n°©sÖ£\Ôô›ÿ\0\ê&\È\Z3Ÿ”ô=\é\êC€Ã¡¦#\Ø~|Qş\Ë1\èº\Ü\ä\Ùˆfc“	ô?\ìÿ\0*ô\ßøRr\Ô\Ş\Ù*™\È\Üvtz\ç_8ø3Ã²x£\ÄÖºr!-¾g\Ã\äÿ\0‡ÔŠú³MD\Ée`C\Z| tE@?_X\Éi3#‚0j™jö\ZøQoÕ¯-cL|\áGS\ëõ¯º´–\ŞVVB¸4\Ó\n1^M=Ÿ9\ç=ªúTªõ4ÀpS·\0qH2sµ*\Èn¦šq\ÔuúPDmb\Üs\ÍIœjx>”ƒƒÏ¶(D d\ã&Ÿ¸o\ïù\Ô œ`œ{Sg± i+#¤ñZJ‘_Ú²63˜V:\äJ³o\'’\ÊCÂ€9­oE0³|¤¡\èq\\m\Ô\rm/Jö¹\"ƒQ¶(W,G\"¸{B{fù“*\ßu€©hg²\î\Èô©‘±æ¡¹µ{yI?w5ru\äó\ëR‚¾\ßoÆ¦\r‘€j’?jd;{\Ğ‚I\ç$t\ëR\ÚÀ×“„^TñÒ¢T2ºÄOz\ët\Ë8´\ëP\îş\Ô\Æ^´´\Î\Ô\0\ìsUnõ51\Ç\Ëööª÷W\Ï1*œ\n¬D	#,O^´Š$Š/2_:\é\Ë7a•k\Í2‹À<µQw7|\ä\ä\nõo‡MgT‹<\æ\\\ãÆ¤d¾\rø~D)©j‹ó46\î?\"\ß\á]Œöm;ÓQÒ¶Ù«\'T\Ôc·…‰p¨:ŸóúTJ\ÅÂ£‰‡uc¹\È KTO”`U„ó]\Î\Ó9dNˆ€ô!|šdû›}gÈ¸ ‰Ô”\ÖUß…l®ƒÈ™·v´c†ÿ\0yOT\Ş{E u\í\ëZv·j\Ê]Nc<2ªiªmlÉ•u%fñÃµ†\à\Ï~Gqqd\Üú˜ú¯\á\ÅV²ño‰ü/\íF§b¼,\ä\Ûÿ\0\ëù×¯\ß\Ä#¹\Êr\È\Åq^&\Òo\àyu=5I!IxÓ©ü;Ö­)+H\ÅI\Å\Ş%{\Ù\ëˆeHx1·°5ÿ\0¼—R\ÒÉ¸\'\çUm \ç¸5\ÌÇ¬hš„ìº™Ó®Á–\ß\åû¯O\å]5„šÅšl³o\í\È\áW\ïÀóùRP\åøE)¹ny\Z;D\áÑˆe9N5\ì~\0ø\åy¥yZw‰K\ŞYp«s\ÖX‡¿÷\Ç\ëõ¯\Z\'qJ\0À\Æs\ëZ’}m­x?\Âÿ\04¨\ï\ìd‚Bü\Çq	ı¡ö5\Û\éöQiºu½”#ÁEüZğ\Ùò\Æş]bö\ìO*Y\Å\Ïc²F9#¦G_Â¾ˆ$\0I\è(\ØGüO\Õ6\ÛZ\éQ¸\r;eı€¯üg«?˜#…\Ê\îlü½”pùô¯Eñ\æ³%ß‰\îÜ†	\Z\ìBx\ëÔÂ¼SX»7š”²n;sµ~‚¡j\ÆDu®a?P(\Z…À<°>¼UQ\íF09\ÍX$\Ô&’‹§©ªñJğÈ²Fì®§r°8 ú\Ô~˜ u iğ\Ç[\í,\Ça\â]÷¶ƒ\n·C™cÿ\0\Şş|w¯a\Ô4OüF\Ğ\Å\Ìf¨eY£\ê¸\ê\ë_“\Îükw\Ã~/\Ö|\'¨­&ñ\á?ò\Ò3\ÊH=z\Z\0\ë|sğ‡VğÌqe\İY\äTe€ş¿Î¼Ì©F Œ\Æ\r}]à¯‹šŒ¡M?S\Øj2y27\î\å?\ì1\ï\ìyª>;ø1§\ë\Ë%î—‹{\Ó\Ï\Ê>ÿ\0\×\×ù\Ğ…ü;Ñ†±\â\Ûa\"ƒ·\ï\ä\ÏN:\Ï­}ò2@\Å\ï[	ûÇ¿\á\Éü+\Í|\áÛ\Ëqúl»‘şo÷GL~¿z¼\Â\çQUS•·\\Ÿ÷\Ûü÷Ñ¥q2\åÛ¥˜°§]‹Â¼S\Åw\Û\'[d\æn¦G\'õ\ãğ¯Hñ~º¶VWŒ~\év ÿ\0k ı•y›˜\í./_-4™nh…\âkÁ5ğ	\ÙÁú\Ö(\Ç\åSO+\ÈÜ–bNj&B9*i”Xµ¾¹²¸kY\ä†d9Y°\Ê}Aô—‚¾)ÎšMºø‘\Ä\Êo¼Aó?ˆ¿Q_4Ú {…\Ü>PrEl]\ê3A`Ö±\Èv\Ë\ÔP#\ê\íg\ÃñÎ–.!heY—r\\Br­õ\Ç\È×‡ø£\áf¥¤jğ—ù\ì7\Ş\İQ\é\ëü\ëšğ—u1›Oº\"#€\Ğ?1¿®Gõô_„ü£ø\ÇL†;È’\Ò\æ|¯Ù§ ¬„u\Ø{óø\Ò\æ\rU\ã:ü­a\"s…P1€8§¹ \ãõ¯|ñ\ÇÁ\Ë-`=æ—˜nG!W¿øÿ\0:ñ=cB\Ôt9š\ÈYN\İ\Ø\ê{ı) 1.PO(Àâ ²“|EI\åN*\É<ô\"©/\î¯Jöz\\\ÎOl\ZlÁLM¼‚¸©F2Gz§zÅŠÂ§–<\ĞX\ËÌ§\îŠ\ÔÑ‘ZYodÁHF@÷\ì*¤©ò\ÇoS\Æ(ò\å\Ó\ï\Òc™\0ñ\íü\èr\ÇX½\Ó\ïVö\Î\âH.\îY°E{Oƒ¾5C8\Ë\Äj#º/#÷\ÔtúÊ¼E(r§8 ®5¿h^0\Òó\"C<s.\åš<2·¿~½}\ë\Â<[ğ“Sğ\ì5€{‹2x\\ä¡\ïô<ıkÂ¾>\Öü)t¦\Êr\Ğ1Ì–ò|Ñ¿\á\ØûŠúÁ¾?\Ò<mnğ*¯š\ÚA¹qÓƒĞŒúóHg\'ğ‹\Ã\Ñ\è¾›R¹P·—§-»ªF3´{g“ùW©i\ĞyPuÄ²|\ÌP;\Ãù\æ³ ğÍ½ª.m\'’+f9–×ª1\ìG§?t4\0\ÖP\ÊU†A\í^}\ã/	\Ãp^{UQ&7\×4©/,µ\'Ú¹¯/\Ûqr\ÅM\Ã|Ÿ\ì\n\0ñ{»W¶™‘”‚:Š«¸\çi¯[ñ_†a½V»·P²‘’\0\ë\ï^[wjğLÁ”©\Ïz¤\î\"5n€úÔŠ„óøT	çšŸ\Ì\Ú\0_Ò¯È¦uúQ\Ã\éq\ïLl$“µ:®Á\ÎsM\ãwßŠ3‘Á8ô4\0\í\ÙÁ\Çj`Û—Î¡SƒŒ\â§ğ\àhÅ¼\ï§Õ«%¼Z½±Rª8\äV\Zºóœı*Íµ\ËC(h\Î;\Ğ\'¯h-k!G\\ü­\ë\\mÍ«@Ç–½“P1\êv\ì1ÛŸc\\&©¦„‘£ns\È5-\äa“‚\05~@ùNj7\Ó^)ø\åO<V•…ƒ\É2“Ò¤\r=*\Ş8\ÔO!Á«ò;\Êùcòö”‚±Ú¡y1\Âş4\r\Ò\à\àzqKL\î‚X”\ÛxšY¶(\ÜI\ëŠõ\ï\0øg•©j1ŒcŒ§\Ô\Òeğ\'\ÃĞ¢=OW?\Å-\ß\Üÿ\0…z!\0U\0\00\0\íNb\0À\àU+«……<ıiı\âAÀ`I\è+Œ¸µ€\í‘œª¤úŸó\Å>şõµ)\Ìh\Ñ\ÔòGñŸğôü\é@\\\nbŒ\08¦± °)\Ø\àR\Æj(\î\Ú\Ù÷¯#¡SĞŠGnyª²‚sø\ĞúI\ÄBHØ”÷\ê§\ĞÒ…>™¬\r6\â\â;\Õ\r\Ê\Ç‡¡¡©ø·Iğùq$©5Ú‚D[¾Xÿ\0\Ş#¿·_¥0<oğ¿I\Õtù5V¸L¼&VÀ`\Ã\×\ÜW˜­Æ­\Ù`*|›8ü±$$şó¶I\à\Öö«\âMC\ÄW~¥3`1\ÙU~ƒúõª¶÷Š«*ùxû Qr\Ô,\ê:ô\ÍIc\"\Î{\Zˆø\Òx+D“\Ä+°\Ó\ãJA\Ô\æµFG\Òÿ\0ôĞ¼lÌ›gº&W8\ç ó\ë]V»­\Ûh\Z[_]1«\0Bõ9=ªü0¤\Çc	\Z…Q\è\0À¯1øŸ©‹\ëM)[÷q\æi°{jdÄ—R\Ğü?\ã½4\ÍÙ‡ú\Äá‘Ñ‡Pk\ç|\'\Õü-3\Ü[\Æ÷vy\Î\å\å”{ú\Ô\Ş4Õ¼=\â(î´‹¶‚e;¥•|ŸºÃ¡\ã^\Ïà¯‹º\'a]3XD±\Ôm\Ø\ç÷rŸö[±ö?­ò\Ó+.wq\íHAô§şZ\ê\Ë%öˆnH,@?\ÔzûŠùûX\Ğu\rõ­µw…×€OF÷À\ËúR½)\ë\Å&qÒ˜=\è\ÇnôqœbŒıy V\Ç9\äzW°|4ø¿­i×–ú6¢­©X±Ú¥\Û÷±f\î=\ç^;Ú»ß‡z^dŸR‘z.<ú÷4˜NIo¢x\Æ\Ã\ÍFYş5\á\ã>\â¸\ë\ÍPğ¯\Ú%D{«w%„ª2A>µ\ÊA}w§jI§\Îğ\Î\æu?\Ã\èGp¥z.ñ\Âğ‹-`\Çm1|\Öÿ\0Tÿ\0\\ı\ßÇŠB<\Æ\Ú\Ã^\ÜC§\Æ\Çh;¤úš\ç\ï5¿°yPÂŠ\Ê¥}\ã…šWˆ\Ğ\Ş\Ø‚ğ®U—£W\Î^,ğ~±\á»÷[ûV“Ä |§ü) 2n¯\à¸>bDcr~e \Ôbœ}ª¶\ÜP‚	\é(\Ğl7¡\ïU\ås$¹ü>S¿\çŞµ(ô\àF±(\éŒ\äw5®u;‹‘i\Â,…MƒzıkY7\Çc \Å\\²Ş«ö¦#\Ø|ñ{Q\Ñ\ÄVZ\Ö\ë\ë1\æû\Ø\Ç\×ø¾‡ó¯Z1øk\âö‹yaº‰—\Ó\ï¡=˜CøWÊ¹À84ı\ÄZ—†ußµi\×RA&{zĞ­+ô_ü$¿\ÒY®´\Õó­³œz‡\Ğşu\äú•¬°7\ï’H\Î‚+\éO|_\Ó5Ä\Ç\\\Ù]°\n$oõRŸ|ı\ßÇz¿\ã…úGŠ-šHa¸e\Èe\è~‡ü¥\0|¿‹\ä‰{c&«[2g¸“8\í]\'Š<­xY\Şˆ\à\İşµW€=\Ço\å\\ô£b$	\Ôñ@´H„—\ßL¹‘\í\ØU-H<\În¹.>õ±t‹gg\r‚Œ0\å÷c\Ûğ¬ò7§¡\ë@ˆ`—ÌŒ7~‡8\äç§½g[“\ËBO\ÊMh\ç\å¦\0wdM}ğ\ÛÂ«\á\ï\î£\Û}¨:\\Q?#Ÿ©¯ øm\áøI|U2\Ö6¸š\ã‹øŸ\Ó5ôÍ²ıª\äd~\î,\èOaı*LZd[iñE,­$ |\Ì\Ç<ú~?\n¹EV¼º\Ê\ÒK‰OÊƒ8õ=…!˜$¿\0‹5ló\Ì}»\ë\\}ŠCPk–\å	ŸJ]ZòK‰LE³5\Ãn|vŸÒ¶4{1(\Ç\0sSp6!ˆ›qü«’ñW„\ŞH\Í\ÄJF?Z\î¬b2Ë“÷V¯]\Û-\Ì2	\Ø,|\×sjğJ\ÊÀ‚\rD­‚sŠô¯øH y#^y5\ç7<2•a\İ+D\î!b!˜J”œf«)=GôcšX\ÇRLsLRCjB\à°\Ç\ë@	·\'½9‰Àö :Ò•\É\Ç\×Ò˜\n­\ÎA<Tˆıxò8ª\ãÉ§ùœŒğ(e•£–³µ[o0;šº\Ò(\çÖ˜\ã\ÎR§¯¥\0rûD‡sVl›Ê”©\Æ2ú#ms\è	\Í#H \\\Ô½<Ûó]#g!W\'”Øœ\Î\áTdô\â½GÀ~7.—×¨DKÊ©jF‹|]KPO—ª!}\Íz¾(U\0\Ğ\nDD†5HÀUQ€*)e©bE\"†\Ï8¯j\ãumI¯&kh[\ä\Î$pzÿ\0²ó=ş•g[\Õ]\å6°ıöş\èôúŸÓ§­e\ÇB@‚4¸\Æ\0§“Gjk5q\ÅB\çƒN\'4\Ã@I¹\ÅU*ó8\âN\0p\Æ\Ò6\åZövVºeŒÚ…ü‰)i$s€\0\í@\Òôe‚\Õ\Ë}\çR¿…xŞµg.•­MnIR¯¹?CŸÊ½\ÇE\Ömu\İ8^Y6\èIÀ\ÈÁü«‚ø¤\Ñj*¼cqş}¿Z\n‹³<\Êñ¶İ™‡ñıá¸±\ëÕ®y\ÅJ€2–8ñUo\ÜD#Iv¢’\Ø©©m˜ya0\ÑÒ•N{\Å\r\Õü\'|ğ\ê\Ì#\å˜•«\Õ?g¿	//u\É\â\åDO÷˜súW{\áÿ\0øWâ¦’m&H\ã½)û\ËIˆŞ¾\êˆWU\áo\rYøSF\Zuıß˜\ÎO©\'ü1Z§m\ÎvlM*\Ã\Ê\ç\nŠXşóÇ‰u¶\\\ß\êü\Ì\åŸ\à^O\ëŠõÿ\0ˆ\Z¿ö_†fTlK?È¸<\×\Î^0¾\Ö_eŒöòºş-ú\æ¡\êÁ5õÁ»¾–\àÿ\0d{\n€9SŸÇƒA\èsšC‘\Ç`zÇ€>5jò\ì5ú†š3~ö/¡ş!\ì:ö\ë?Â¿t/´@\Ğ\İF\ã\ï¯\èÃ¨5ñ\È\'ğ± x£Vğ¾¤—úM\ÛÁ*œ9WŒQE€\í<sğƒTğÛ½Å„ougœ£,õ¯4d(\ÅH ô9¯¨üñƒEñt)¦kI \à.¿u1\éò\Ç\Ø\Ô:ø3a®£\Ş\é8†\ìŒü½\ë\ëõ¥°0ô\0ñF3\É\â¶5\Ï\rj½{}F\Õ\ã`H\rü-ô5‘Á\ëÖ¨\ZYV4f8\íZŠ\éšMµªñµF\ãş\×Ö¼\Ï\Âj\ÖgH>c‘ßµzt“‘\n\Ä>ô‡`úwı3I‰—-p\Ë-\Ñ\èÇ÷GOñ®/\Æ:†\Ëu\ï&9#Ú»¹E½²\Ä8æ¼³Rº:±4\ä\æ8\Îú$e\à\ï‹:·ƒR\Ş\Î\áşœ80Hÿ\02öo§J÷]7Wğ¯Ä­¾\Ï$wo\ï!q‰\"\Ïb=?1_\Ü\Ë\ç\\3``p*Î—«\ßh\×\Ñ\ŞX]Imq\Ê\É`Šv\ë:ø%q`\Ò_\èCÌˆóäƒéŸC\Åx\İÍœös<<R!ÁG\\_Cxã­¥úÇ§x¨-½ÁùE\âİ¿û\Ãø~½>•\×x¿á¦…\ãO´B¨“²\æ9¢<¡şª\0ù— 8Le_§µw>+ğ§\á(¦Š\æİ¤p\Û*¯oóŠ\âYH\ë\Í17ÀŞ£µKn\Ì:z\ç¨­\Ï,™<Š|`o \Ğ#d²¸\\zU\å\Ú\Ñ\Ì3pjÅ¯\Í^G­1ù\È\'\0\ål¨`{f»\ßüQ\Õü(R\Şi\ræš½`‘¹AşÁ\íü«\Ï,dó-\Ôw^)·²aJ2\Ìz{P\Ö\Ú/‰<3ñI?e‘&!yo \Û,G\éıFEyßŠ~\rGkzu]!Lˆ™o#{q\Ûğ\ã\é^+g©]i6òió\É\ÊQ\ãl0?…{¿†~3\Çk5®•\â¢gP>Ú‹À?\í¨ü9•+ñJ\Öò\ÚöE½ŠD”œÂ©9\Å}a¯ø7Bñ–Ÿ\ç¢\Â\Şj\îxU½øşcõ¯ñ‡\ÃM_Ã’»¤/=·$2Œœ_ó\Å\0y\İ\ê–Uµf\ŞO5sÒ”Å¹Z6\ï\Åv\ßü&u\ï›¨óa§bYsÑŸ‹ùŒı½1\Í\à\røB(\æ÷xšq\ßqû©ø©5\Ş\Ú@-\í’3‚ı\\\í\ßüúUktó\ï‘òE\Óİ¿ú\ÃùŠÒ©W\âILÿ\0f<›_v\ì?]§|ºu„—–\"ÿ\0yA^e#\Ü\Î-·ngmò·©¤\Ø\Ó!k»¦º±\àzÂ»x¶\"ªk7J³X£\ç]™\'˜\Ã\å^ŸZ±~\Ö\"\0½úšŠ((§¨Y-\å¹Rq^]\â_*;°O˜t8\ë^»Yº¦™\ì,¦„\Ñó½\Ä&e`Aj\à\nôøkfùmaÏ±®x^& ¯J\Ò\äV÷Àö©Ñ•ˆã ª \á»T\Â@r(pc&˜\Ò(ùMA\ç\î\Ç\éÁ9#¯­0\ïòxóÀÂŠ\n¼\Ò/\\œc®hT\0cM(*¤À\ìGpNzı(\\`\\\ç½d³<ˆU*½¬\Ê…wU\é3k:’B‹•\'8ggğ\ÏÁÏ©N.\î\ĞùHrk\Ş †;hV(\ÔQ€+;@Ò¢\Ò4\È\à@À­pIâ¡”„‘ÂŒšæµ­X\Åû¨[37#ı‘\ëşŸ¥Y\Ö5U¶ˆ\ãæ‘¸Dõ?\áüúz\×.»´’±y\ä±\îh\0=½I$òI\ïR´€v§1Tu¤E3&šM\ÇÖ˜<\Ôd’p)Å»V¦“¥´\Òy:sŸOş½\0K¥iy>l¼(,{W|Oñ\ïöı\ãhº[\ãJ¶l;©Ç\ãÿ\0e­tŸüx¶p?†tyv\È\Ãs!û£û€úõ\ã6v²]Ì±Æ§=x\ì*\ã\\õÏ‚z©+¨inx\âd\Éüô®÷\Åö\Â\ã\Ã\× \Ç\ælñ\ß\Åÿ\0“\\7‚4Ÿ\ìy­\ïB\íÛ…ûøş\ê¶E9Ç•‚w>pº…­®^\å8\È}ÿ\0*ˆ‚:ş•\ÚxûHû& \×1¦º;\ãúÀWNTœ~uÓº+|/\Ñe\Öüw§\Û\ÆÎŠ’y\èpB¯\'Ÿ¥}^û?xwÈ°½\×&Nd\"X\ß\Åı+Ùµ\Èôı>{¹~\äHXÖ²\ĞÀò?Š\ÚÌ§[¶¶Uc\0±8\à·oÖ¼\Äw­u¨\ì\r‘}am{\áßˆ\ZY‘|Â¹1I\"ö\ÈõuşU\âş=ø5}¥K-ö’\Z\âw\êGÒ¡h\Æxø$74™ÀÉ©&ŠH\å1ÊŒ¥N\n°Á£#Ÿj Ÿ\ÇÒ@\äñŠ^O t¤\ä8 W+’+\ÔüñŸUğÏ•a©†\ÔtÀp7\ï\"ÿ\0uQ\ìk\Ê\Ïb”0>\È\Û\á_‰š	–†\îcŒ<gÑ—¨5\á¾;ø3¨\è/%Ş–­ui\×hû\Ê?­yö…\â=SÃšŒw\ÚU\Ó\ÛÎ\ÔğG¡Çµ}\à?ŒºgŠt½v8\ìõ\\nÿ\0–3ñ\'\Øşu;\ä³:}\ï¬®rÀŒ\è+~\İ\Ä÷m\'ğ\ÇÀú÷¯YñGÃ‹mM\ZóJe†\ã\ÕZ¼ª\ëM¼\Ğ\Ã[^D\é($GZdx§Wk{\Ãüò|‹J\àZc¡\Ä\İkO\ÄŸlÔ„@\å!\ãñ¬+‡ó$Àş\Zhd\ïŠQŒt¥\È™\äSÉ‘\Èü\ë»ğG\ÄıwÁ“¬QHn´\ârÖ“6W\êz©ÿ\08®2i7r\r>\Åğ÷‹ü3ñLhcd3\íı\å¤\Ä	ÔQ\î+\Î<wğH¯™} ô&\"8ÿ\0\ë/¥xu•\åÍ•\äs\Ù\ÊñN„2H†S\í^\ë\à_lviş+\\\à…[\è\Ç?ğ5\ÌR\Ãntû­+Q0]Û¼N§•a\Ô…E*í˜1Ş¾¸ñ‚|?\ã­1n\É1wEqÊœ÷\éø~5óÿ\0~k¥ò^[a\Ñ\Ôg|J.+j\ÇqSy«x\ê:`\Ö|,T£ƒÒ¯œq\ÏZb3­ÿ\0ss$L@sIó®^s«\Â\Òj(|\åe\ê\Ã\åÄ° ù\0ih°‰¯$¼™u\0ßS\ØT:‰k­ò·2»5¥q\Ø4\Ø,‡ú\ÆI¾½…PÀ<h£ğO\Ä\rg\Â\Î\rœû\í\Éıå´œ£~¸¯ ¼1\ã\ïø\Ú\ÔZ¾\Èo~{9\È\çı\Ãü_‡5òM¹0^˜\É\à+fWŠºœ«‚ô¢\Ã=\ßÆ¿­u÷º>bŸ©A\ßğ\ïüşµ­ğ\çO²\Ñ<.4\Ër?´w—»Œ¬d\'ƒ\Øp3Y\n¼c¯jö—ƒUj³³Q‹–\âM\Çø\Ú\àgzW¥A{q«q\É6Ò©8\ã¡ÿ\0\n-A‚@s§\Ô÷55™­\ê\Ùú{:\ßIòD=\ÏÃ­\0s^\'\ÕK§Ps®@ÿ\0iûş]+H´yd3H2\îsU\ç&\ê\í-”’ˆr\ç\Ô\×M§\Û£8\î2ı¼_r5+¡†!Jƒ·Z¥¦\Ûõ™¾‹Z4\0´QE1…Q@Z¾–—\\t¯\'ñ„\Ñ3\0˜a“Œu¯m¬{FK¸K¨‡C\éM;	£\ç\É\à*H\0Œu¨;‡a]¹¤˜\æ`Sk‚r1÷¾•\ÌKo°’x­	<\"Œ\ã\ÜÔ‹’r*\r\Ø\ã\è›&‚z`cµ5˜c\åü8¨¼Ìœ\ÅG+7\á@<»Gê¹¸‡“QKpqùæ›§é—ºõ\ê\ÛZFH\'\ænÀP36KkVøCkJ\îq…+\Ş>ø7ûÀKp£\Ïp	ö«\rğ¦‡j¯\"˜Œ³¦»p«\Z\íP\0\r!‚AŠ\ÆÔµ$·‰‰À\áTu\'\Ó\ëü‡½X\Ô.ã·…\Û¼ı\Ïoğ\Ç\\\ÜI{9–O•G™û£üjF2I$¹™§˜ü\ÍÛ²ÀS‡Zon)\Ù\ÛÈ¤ò¤\ÔE³Ö‘˜‘\Í0\à\n;v:ô¨İğÑ¸U\í3O{©+ôÿ\0\Zb%Ò´÷¹‘Y—ù\í\ïY\ß<kƒô‘§\é\ì§T¸S°uò—»Ÿ\é[~)ñ%ü<÷Ra\çl¬g™ü=M|Ë¨\ê·ZÎ¥>¥})’\âg\Ü\Íü€ôµRB¹$\Ò!g™Ø–f9,ORk\Ñ<á’®²È™f\ëš\ÇğŸ‡d»¸[™“’~P{W±\éö)g\n€k¦+—R^ºı\ÔÃ•SŠ¿c;\\\éñ»\ã\ÌdŸ\ï\ëQ“¸s\È_O”C©]Zœ\âP\'O\ä\Ãôñ¬\ê+«v3|[¦.£¤¸ eAúş)ú^%,/\ÉŠT«Cu\Îk\è{„Y\ãa•`A ×x\ÇKkmIC|\çGvÿ\0ƒù\ÖV4‹=\ãÁ\Ú\"ø{\Âz~š8“#q\ä\çó\Ç\áXuFƒD‹K…±5\ã…À?\Ãş•wµ\á><\Õÿ\0´¼Ku:¶a´O*?÷ÿ\0[&‰;7ñ.¹q¥jÉ¦\Ü\Éo4lRF\Ø /\0×§øã¦¥zWŠ\ÂE3a\à#ÿ\0¾;q\ÇÒ¼Yº7šœ®UN\ÑôD½µ4´(ú«ÆŸ\n4Ú›\İ=’;¦]\É$dÿ\0zù\ÏÄ¾\Õü/xa\Ô-\İW8òš\è|	ñWZğd©¹»\Ò\Éù­dn¥cúW\Ğzv«\áOŠ\Z3Œs¿½…ø’3\î;z6ñó¥0úÆ½ƒÇ¿o´g’\ïG\rqi\Éò\ÇQôÿ\0\nòI¢x]–Dde\à«õ¦˜‘“K“M\ØqJ¤ÓŠ` <s\Ï\á[’¾1°Ä¸F5‡ps\é\Å:9\Z\'Yˆe<bExO\Æ\Z®„¢\ŞBo,Qy‰\Ï)“ü\'·Ó¥z2¿‡üy¦7–\É/e#F}\Å|û\á¯V\Ç\Êf:q ş÷½I=ıö|—:uÔ–ó)ÊºcüGµH\Z^:ø=£\É-î’¦\æ9)\Ü}?úõ\ã\ÓA$N\É*2:œ0`A¯¦|ñ’\ËSa¥øœGiy÷E\Æ?u/\×û§ô­?\Zü(\Ò<Wnn¬öÁxW)\"rñ\ïL“\Ïqi¼k¦ñO‚õo\Ş<W\Ö\Î#\Î€|¦¹½½±L\éŞƒ\×\éÒZ\ïSQŒ¾•1\È~Nw\Õ~£¯Ö­\ÊT¤8\ì0h\ÓxO\â»\àË öí˜ƒ-¬œ\Æÿ\0‡c\î+\è¯	üBğ\ïôño&\Èoı\å”\çœÿ\0°‹ğ\æ¾HpJŸcùÕ­2\âH_tRuù•”\àƒ\í@@x\ß\à\Ì7^e\î‡û¹>óFğÿ\0\nñ\ëı.\ïK”\ÃyG\"ñ\ÏJô_|qº³‘4\ï‡¹·*İ¨ı\â¼?ˆ~¿Zõ}O@ğ\çtŸ´FñO£\å#\ÔûûşF\"Œ\Ü\\¼¤\áG£¶—É¿ŠvPÈ®8=\rz7Œş\ê¾\ŞÖ‘5Å©\'¼?¯ó®?S²[-\"\ŞÜ û@ı\ä‡Œô\Ä,\×\rq3\Í!\Ë1\É5sŒb£·o2\İXrjN0?Z\0¡~›Ls‚+F\Å$¼xb\ZI%`ˆ«Ô±\è*)c\Â\é\Ç#ò¯Kø\áF¿Ô§×®“6\Öd\0½)û(ıH bğ¾†ü/k£\Ä§#÷Í¿#u?Aü…u6ğGko\"\n«eùZ\á¿\İ_\ê§\çZ#\nóÿ\0\ê\Â\â\êIT\æ(³#\Ô÷?‰ıtş\"\Ô\r¥‡•\Äó’‹ş\È\î/\ç^zW\í\×\ë\Zÿ\0©‡\îjdú»¢\Ù7\ßnY\ÎI®²\Ú,‰*…”Ty\Æ	WG§[ùqyŒ>fşU [DT`Š}P0¢Š(\0¢Š)€”„#\"”\ÑHG1\âO¥üa€;H+\Êu=5­gh§MŒ;‘Á¯} ‚2+ZğÍ¦­WAŸ\åT£Ádµ\ÃY‘”\×{«|?\Ôm˜›I7¯]­\\\Å×†5õb¦Í¸\"¯™c²©$œQIp¸\Ç\å[0x+_º/\Ù\nİuú\Âv2,Ú”f: \àP\ÚƒĞ¼/\â+ ±#$\Ã9«İ¼3\á+-\ÑU\"ø\É#’k[M\Ò-4¸8\"U\n1À«\Ï*¯z‡+!\ÜU.\'X£ff@$“Ó\éÿ\0ê¤’\ã \ä\á~¸®_VÔ\Ûù1\Ü)\ä7Ÿğ©[Q¾kùò2!Sò_s\ïU:S†9ô¦ûPf‘›\å¥$P·J\0c\éLf\ãš_rp*Å“\ŞL\0RA<Z\0vŸ`÷R®‚zz\×Muuc\á½k\Û\É!‰w;şÂ¥Hí´‹&šfUÀ\äúû\nù÷\â_%ñ5ø²³sö˜„\ÒFş÷\Ó\Óó«H/ø¢ó\Å\Úô··Vùb‹<Fƒ\Ü÷4\ÑTºYO”¨h\ÚLš\ÊB€˜\Ôü\í\êk\Úü7¡Gen‡`Vñµd¶hhšRX\Û/\È\ÇOJ\Ø\Æ1Ò|½#Öª÷.ìŠ£~E½Å¥\à\é¡ı\ÇùO\ë´şmF*+¸EÕ¬\Ğ1Àu+‘Ú‹]rc´\çµr^.\Ò\Öò\ØIÂƒ…,İ°x?\Ì~\"º;	\ÍÖ¯\Ã\í\Ú\ãÑ‡õüB[VG\0¯k™\è\Ê:Ÿjk¤ø~\î\ìœB\êx¯œ5K§’\Û+†’Bd ¤ôı?z÷Åˆõyô˜£´¶f²_šYW§\Üz{×‰]E2®\âO¯ô©{”bóN·¼v1³\İõ17FúV\Öò\ÛK\åÊ…Xv5İ­¢]ü“\0Ÿ•‡QUõ\r5’ —qa\Ï\Ë*˜}j“Š\'\æ\ÈŠ\ĞÒµ‹\í\Zö+\Í>\êKkˆ\ÎU\ã84_i3Z¯™óa<†Q\Ó\ëY\à˜\â¨¤ü\rñº\ÃX4\Ïˆí®˜m ~\êO¨şúVÏ¾\é>)€\Şiû!»#rÈ˜!ı=|ª:\Zô_ü[\Ö|!,v³1½Ò³óA#rƒıƒ\Û\éÒ•„rş$ğ­\á{··\Ô-\08Y\0ùZ°yõ\é_c\Ø\ê^ø›¢7’\Ñ\Ü)_\ŞD\ãD}\Åx¿~\Ş\è\ÆK\Í5Å¶s°u‹÷\Çù÷“\ÍK-¼\ÈñÈŒ§X`ƒL§Z`X\Ó\ïfÓ®\Ò\â\Ã/Qz\ZôX\î!\Õôå¸„\î\ÏQ\è}+\Ì=»\Ö×‡u¦Ò¯d\Ë[Hp\ë\é\ïCcR±Ç•‘z\é[ø­­x>Eµ˜µîš§ç¶•¹Aş\Ãvút§\Ü@w¦n7)9®cY\Ó\Ò\"^G\Ş\ê) >Ÿ\Òõ¯\nüL\Ñ[\Èx\çq,I±Ÿ˜¯\"ñ\×Á[9¤½\Ñ–¾P>œñşy¯)±\Õ/tk\è\ïôÛ™-§C•’3‚?Ï¥{×€ş9\Ù\êQÇ§ø¤%µ\ÉùEÚ\İ\Éşğş\å@;\Ïg5´\íñ´r!\Ã+P°\êk\ëo|1\Ñ|]jnmV8\îr’\Ær\èÈ¯|U\àM_Â·/Õ»4@ñ(ı)\Ê)\È\äU†9€c;sÒ¥˜›·À\'#\0\äf›l\Å.¿½\r€Jf\â®hfL\Ç9>ù®“Â¾3Ö¼1¨›­.\í\Ñ?&\å$\ëız\×9pş`Võ\ê*1)Pc^ı\è\ê\ïüKÑ¼qjm.b[[\Ìa\à—”÷[\ëÛ­eø\Û\á\r¦¬’\İi_º¸ \å;ñ¯	¶;m\Z(-Ø™]ü\ÉX`ö\çÖ½ÁŸ¯´o.\ËY\ß}c„\æX\Ç\×ø‡±ü\éæ—\Ôü=xöwö\ï…l|­ô5\0cÖ¾­š\ÓÃ?Ñ¼\èš¨¤\\y‰÷”ú0\ì~µ\ã>3øU¨hl÷\n\×½~Q’(¸?°°ŸS¿·²¶Œ¼ó¸wbx¯«t\r\n\røz\ËEµ\Æc\\;÷œò\Íü\Ï\ä+Ë¾\nxL½\íÇˆob\ÂÛ“\r°aÿ\0-ù›À\ãñ¯l„os1\ï\Âı?úÿ\0\ĞPÀ™QaT`\n	\n	$\09$Ó«\Ä\×şM ³±$\ã\ç#²wüú~t›\ËxƒUk«™\'B~\İÂ¾‹\ëøõ£G±ò\Ñr9<’k>7\×şaÿ\0U\n+ªµ‹ËŒqÉ¬·~\Ê\ßÏ™W(\ä\Öğ*µ¿‘\0\Èù›“V©Œ(¢Š\0(¢Š\0J(¢MŠ(\0´QI:š\0‚ú\Ó\ÌkùSdºŠ1ó0ª¯¨¡û¬(\è$\ä*Â˜÷(ƒŠÉ–üœáª¤—„÷¥q›^Òª\Ë;m\'Ò³>\Øâ‰®÷ZJ{…<\Ñp9»\ëûûV\ÖtşO”\ÒH‹À9o”\ZµŠ \0}v\ã!#\\dÿ\0:½\íL@\ÇŞ˜\Í\Æx§Q±\Ï\0ŒqQ\ÇZy9\éNµ·{¹‚(\Êô&€\Î\Ñ\î\å\0)#§ë®Š+]N’\ê\îE#\\»\Ã\ĞiÖ–v\Ú=‹\İ\\ºD±!gw8½ù¯\Zñ×n5y\Õ,÷\ÇŞ³ŒğUzy\î=Oğ\ß{Ò©!\\¯ñ\Ç\Ó\ê²Í§Û—ŠÈ˜÷Güó÷cü^=s\æ–3j˜Qó?§ğJ–h·¼v±‚\Ç9\Ç^}Mz?ƒ¼1\ä¢H\ã\æ<±\"¶„DÙ©\áO\r¥¬(\ì½NEwS\0ŠdP¬Qª¨\0\ny8\éT\İÀRpi¤\ç=\é?\'Òšø\Ï&¤8\Ï5ü®*~3V™V\Ã÷7·v\ß\ÂXLŸF\ëú‚\Z³9\ÂUYÿ\0u}mp	\ÆLMô?ıp?:¹s÷I½s\ÕVe\'¡\ÓA~\Şh´¿ˆC;p½\ã—ı\Óı5\Çø§á­¶£¾\ïG\Ùmu\É0Ÿõoôô?¥w2$\Ö\æ9Qdº«Ÿız®\rÍÁ2]Zúõ–?¯÷‡\ëõ¨°\î|\ß{¥\Üi—¯mwo$©ù‘\Æ\áV \ÚSd€2ôÁ\ïúÆƒ¤ø¢À%\Ôi*‘û¹ü\Ëô?Ò¼\Ä\Ş\n\Õ<2\æU\ê\Ã<Nƒ•Œ;*–¬Zg\'y¡V–\ÃZ&\è~•\È_\è)>÷¶L\ë\ËB\Ã•z\r¼\ç‚:ı(»°¶\Ô\Ğo_.Q÷]G\"„Àñ\Ébx%1Ê…\\uŠA\Æ2:\ïum\å1\ß\Ä6ÿ\0\ê0?J\ä5-\"{\Î7Ày?­Zbhv‘®j\ZôwšmÜ–÷~WCú{\×Ğ¾øÛ§kÑ¦›\âS¥\ã|¢ùe/\×û§ô¯š\ÆM9kdu\í“LG\Õ~7øK¥x¦¼±\Û\á]\Ê\êxoO­|\ç\â_\ê\Ş¼0_[2\ád\Ç\Êkªğ\Å\Íc\ÂO¥\Ë5ö•`só ÿ\0`öút¯´¾ğ·Ä½¼¦Š\åJüñ·EŸQK`>6\é‘ıi§#œ×±x÷\à½\îŒ\Ò^\è\ên-3ƒ¨ö¯#š!•\ÒD!\Ô\à«bÀ\ê<3­y‘\r6\é¸\ë\ß\ì\×A,k2\\r\ry˜%[rœÒ»]Wû}°IXy\é\×ı¯zM\ÇÕ¬>\É1‘G\î˜òcX\î\nİ«¿ºn#eaœJ\ã¯l\Ú\ÚSò\İcŞš`u¾ø¥­xFT€Hnô\Ò~{Y[…÷S\Ô\ZúDñ\'…ş$\é-L’°\\Km&‘“\×\ê:ò8¯X;[Óµ;½&ò+»™ ¸·$ˆ\Ø \Ña\Çã¿‚SZ/´!¾>¾OAøzÒ¼nö\Ö\âÉ´ñ<R)ù•†1^ù\à?–÷kâ±KÂ‹\Õ+¾;}zWg\â\ï‡\ZŒ\ì~\ÑÆ“2\æ9\â9\rô#ÿ\0\Õ@$¦vË¥G Áù{Weâ¯‡ú¿„\î$[˜Y\à\"UcŞ¹	‘—¨\ëÚ˜‰6³Ãœ uª\ã!†O\â*ı\Ï©À\ïT\Üb¤w \r{&,6\ç Š´AŸbø\Û\ê+H©\ëÒ€-i\Ş$Õ¼1v—úE\ÛÁ2˜UÇ£„W¿øâ¶\âè¢±\Ô\"K]BAŸz9O|z}\ç_9Itu=\Ç\ì|$c²ºñ\ì|9h-ztvÿ\0\ÙHUA’\Âø>™u\äZHÙÕ†Tú”ô5¸\0P\0\0À¨\é6²[Z²\É3H\Ë&O\İ^\Ãúş5¡HI\"EH\ìI\ì+Íµ\ÍBK«‡~D“œ(ş\êvÿ\0>õ\Õx–ô$B\Õ[\0ü\ÒóÛ°®:\Ê6¼¼k—(\áGò¨“\è4iiVB(\Ôc§&ºm6\ÛÍ›y*~¦¨[@UU\0ùtvĞ‹x^ÿ\0Z”2z(¢˜Q@RPIJj7•© Cú\ĞHMU{“Ÿ–«\Ëz±.\é\\b€/<¡G\Ö=ı\İ\Âı\ŞÖ©\Ü\ë«È„gŞ²æ½s’\Ç®2Ä“\Ë!ùšš¬A\ÎMUIyú\Ô\é #Ş’ORi¥¹\ëA=…6\nNi$ Z\íÿ\0’*ş¹ş”‡Zò)bôUy\à0?4^şm\Å\ì\çşZN\Øúò«\äó\Åfh\Ã\Zdlz¾Xş\'5¡»Ş©ˆ±\ÇZa<hc\ïNH^i \æ€s6\ÅS\é]–›§E§Zı¢r©µK\Çrh\Ñô„´„O0\0‘»·¹¯\'ñÿ\0‰n®4m6\å¡\Ğm\ëû\Ä\ë/8¾¹<\Üó\ĞU$&A\ã\Ï/ˆ’\Û\'C‚B‘G’?´&¿ô\ÍzŸÃ¹ó[»©¯,\Îeº™÷;t\Ü} şB¬\İ\\™[\íF Š4\Ù\nr!²û’y\'¹&¯xoB—S»3!ÛŸ•Mh\Z>ğÜ“È·7—cGJõ‹;Tµ„F£·&«\éºzY[¨\ncš¾N+FûC‰\â˜O4Œxÿ\0\ë\Òv\Í\0\Å\Ï&‚i¿ipH\ÍR%‰¸ƒ\ïVF\Õc\È\Î*tl§5¤Q,I¢ó *:öúö¡œ\Ïh\ÈJd\Ô\n\Â14G€oÀÿ\0õ\ë<D}Û„¶;ø © \â­	—!\nI\0dõ5Y:\nÌ¼ÿ\0Oñ•X­\ÇÚ¥ô\ÏDO\á\\\È\ĞÕ–\×Ë•§µ\")I\Ë|’}G¯¸\ç\ëÒ•gI·A<[e+óDü†ñÙ‡ù8¨µ]^\ÏC±û]ô¾\\\Õ3Œœ“SFöº¤sC\"M\á’H\Ûõt4À\à¼Qğ\Î+‚÷º\Ø.:µ±ûô=·O¥y³-Å•\Ó\Ú\Ş@ğN‡0k\èS$\ÖüLL‘\ÏP9_÷€şcòk?_ğÎ™\â[M—q‚ûw:}\åü{j—\Å&xˆt•vH¡\Ğñ\È\íX\×úF-—\ï\"=`n*\êuÿ\0\nj´ªn,³„¸A=ˆ\ìk:€\ÊGô5#<\×P\Ğc—t¶yIß…ø\ÇÒ¹×‰\ã\Ç\"•`pA\í^\Ï}¦[j`°Œe]x?ız\äõ\"\Ô\"\ÚÇ„G©0g:u\éZ:6½¨\èZ„wºmÜ¶÷xd?¡\ÅG¨\é\Z{e†\èóÃ¯­Q\É\ê\Ä}1\à_šv¼Lñ—gz\ß ˜\İJ}ÿ\0ºJ\Óñ\Ç\Â]\'\Å5\åˆX/\n\åYz?§Ö¾U©\ÎMz_>/jş1Yİ–¾\ÒóƒóF?\Ø=¾(°C\Ä~\Õ|5x\Ö÷öÎª\n\à¦±­\ç’\Î\åfŒ\á\×Ø¶\×~ø•¢³A$W(W‡‰#>Œ+\Äü{ğfûFy/t€\×\İv£üúR¸\é}l²§S÷‡¡¨u;¸ˆ\î\ÆGFô5\Íi·“\é¥dVT\Î\ÙŒcÿ\0¯]šJ³F¤Q†A˜\Î\Z\âWh\äuõª$a°yÁ®»W\Ó|\äó#u\ç\ê+˜•	©1\ç‚k¹ğG\Ä\íkÁ²¬p\Ëö<œ½¤¤•ú©şô®qR/\İ\Í\0}‰\áÿ\0xg\â>–cŒ£K·÷–“`HŸOQ\î+\Ìü{ğU\ĞI}¡r¿x\ÄGıo\å^#a¨\\\é×‘]Y\Ï$3£e$ˆ ×½ø\ã”syZwŠv£ğ¢õGıñıh\á\ÑX\Ü\é÷\ïku‘H8*\ãN\í<¹›\'½}o\âoh~2²[¨<¡+.è§ˆ\åO¸\"¾{ñ·€µo\r\\±š\İ\ä€\ËEcŞœ}›`•-É­¸ˆe¹È®~2RPqß‘ŠŞ´;\×n˜o\è³øƒ]´\Ò\í—/3€[²\ì~ƒ5õ>Ÿ§Á¦Y\Ûiv‹²\Ş\Ş0€²?©şµ\ç¼,4ı2oÜ¦&¹;}\Ã\î\Æ\'ñ?Ê½V%À,G\ÌÜŸaRÀ–¢d¶\æü¨2jZ\æüK¨¬i\äÂ§\Ìÿ\0^Â“v˜\Ö.¤¼¹1\ä™&mÍ\Ã\ÓúVŸj\"Geşu—¥Àó\Ì\×2™\Ê+§¶€³$j95‘F†™o¹Œ\Ì8>µ«LŠ1j‹\Ğ\n}0\n(¢˜Q@	H[´\Ö\é@ˆ¤\Ë)ùˆªmÁ<\Õ\Ç]ÉUJœ\Z\0gZ\Ê\Ö-¦•G’P+[¡£¯jC8‚\nƒ\éR)\àWMw¦Au“­\ê+\n\ëMšÔ’Aeõ DiI\ÅD¬E.sŒR¸\É\Å[EL®œ\ÕCÖ“q`óEÀ¹\Ô\Öf½ Â¿ò\Î\Ü ú“Wa¼ª„rN+_¼3€y–\åcAU\ÄX³_&\Ò\Çe§\ÍF\Ø>”ñ—Â¨;\0UˆZI(\Ü\ÇÒºıGXO2Œ@\Ç_¥E¡h\\N¹\Ï@{ÿ\0õ«ø©ñ!­L\Ğ%-{\'\Éq4\\”\Ïı£Ş©!üIñ\ìÚ½\ÙğŸ†\å\ÎJ\İ\İ+a@F\î\ÊKjóI\Úv¶§ıÜ–V#y1ƒ+{vQ\Ø{“Sxô›t\Ø\Ø=\ì¸şĞ™Nv÷òıyc\ë\Çj¥2j·‚\Ò\0L@ü\äwö«J\ìB\éz|ú\İú§\ì\è\ß/¿½{£Gcl¹PU_xz=>\Í\'9\î+¦\0(\Å^\Ú\r #\0S3\Ğs\Å+Ù¦šqŠLG_\éKŒSD°\éFzŒQŠ1\ïZ¤KQRBN¨©ñŸŸŠ\Ò(–N½}³P]ü²\Ôm?Î§^´Ûµj\Ê}¿_*j\Ì\Îö\Õ@`¨X’k?Ã€Î—:£ƒºö]É¢1\ÂËŸÆ¡\×fo°-”,D÷² ¼š\Ö\r§´„‚\Ú,ŸeQÿ\0Ö¯,\ê<§\ã_ˆ¶I—ü°\'› õv\á!\Ï\ã\\€üw«xbbb”\Ëh\Ç/n\ç*~†²¼m¬É¬\ësM#Ò¹r>½\à*¼a!\\\Ü\ÓC>¨ğÇŒ4¿\Ú	,\å\Û8=»Ÿ™\Ä{\ÖÇ”\ÈKB@\ÏT#\å?\à\Î+\ä\Ûû:\é.m&xfŒ\å]N5\í^\rø­m~±\Ùkl°\Üt[÷Xÿ\0µ\éõ§¹\'¤Ÿ&\æ6ŠXÁa\â‘A\ã\Üw¥yß‰¾\Zd½\î‚v?\ŞkV<÷Oô5\è\äGpŠ\àƒ\ÆQ\Ôş \ÓF‹‰¾\ïiO\Ç\Óù}:P\Ğ\î|õº[y\Ú˜á‘†53´S\ÂRuFx\Å{Gˆ¼\'¦ø\\G²\à$\è>aõõ\äz\ï†õO\Ü\â\ê/6ØŸ’\áTı}Ö¡¢®rÚ†„\Ğ+Ii‰\í\ÏŞ…¹ {W} ¬»\å±8a÷¢n¯O†|.T‚*µö“m¨Ÿ6?\ÜÜÃ¨\Ç>ş´\'`<eÑ£fGRpsÚ}á‘‘]Ş¯£+?•yN‹2\rr7\ÚeÎŸ&wG\Ú@85i\ÜV&\Ñu\íK\Ã÷ñ\ßi—r[Î¼CŒB;ı+\èüh\Ó<C\Zi\Ş 1YŞ¶H\ÕJöSúWÌŒx\Çó¥¼SõO>\é^&®ôğ°]‘•e\èÿ\0\ã^&\Ú>«\á;ö\Òõ[vT\'HGô­\0ü_Õ¼-\å\Ù\Ş\î¾\Ó[·\Ïÿ\0dÿ\0C^ù\rÇ…¾$h…\à’+¨\ÈÁ$Œú\ÔTó\ãmqƒŒšæµ4\Â\æ\â$ù\ßÖ½o\Å¯´i\íCOgœ†^«õ®*hªPƒÁQqw,c‡J`\é´~µu+e1\\©ô¬\Ù—¨ª|\ç¥Y\Ï9\Î8ª\Ä\ä\àuõ©†v)À\ì<ñ+\\ğ\\\ê¶\Òı¢ÀŸ\ÖS”?O\îŸq_Hø{Å¾ø…¥yj\Îaó\ÚM÷\×\Üzq_0\ÚZ\Û\Ò\ï®-QgµšHfˆ†G°Tú‚)\ì^<ø*G™ p9cÿ\0<W\á?\n\ßj¾/·\Ñ$ŠH™›3qSùW¡øãš“\â¢\áVışŒQü\Åz¤ú<rÇ¬h“\Å\rÓ¦VT£™O8>ÇE+ˆÔ¶µŠ\Öl\í\Ğ$ P£²‚®\Ô\Ë*Û§\Î*›zn\Ç8ö©\è»…µ¶y›°\àz\Õ\çz”\Ò__‹p\Ù%·Hk¢ñ.¤å‹·«V“j\Ä\äÿ\0Y!\Íg&4jY@± À\áx\Ği–ûW\Îa\É\à}+>\Ö\ßÍ•cõ¾ªB€8\ÇQEÀ(¢Š\0J3Yš\î·k \éyrs#ŒdnÀW\Ãñfö)ów¥Bğÿ\0,\\«ø\ç?¥Qoc\Õh\Åb\è>(\ÒüG}>\ä|ğ¿ŸQıFEm\Ğ++Ld¨\â¥$ãŠ¾`A \nrFü§Š¦xXgŠŒ@\r¡:•a\ÅG5\Ìÿ\0\ë¥Tö\'š¡6½o#¿¿AH¼\ÑR_š/•«{Ymœ‰qW¥\×nd\È@¨=¹5F[‰§9’Fo©¨v9õ¦÷§u4\Ò8ö¤Ö¼M¸kš¼fyt\Ä=d‘¥5\Ğ3˜ôû©3\ÎÂ£ñ®~|¿ˆ\í!^[r=\Íi3T\Ä\09<bºCİ‹™\Ç¾\Õ…¡™\ÜO0\ÂóŠ\Éø›ñ	X3Mu:¬©…\ÇKuşñ÷ô¤Q%/Š?S@ôM@u9H‡‹uô\í*ñı>\Òa[\érukµ\İo»“g¬§ı¦şÅ½*&\Ó\Îó5\İT4\è$\"œów7\\öGV?‡zu\å\ä\ÒLóH\Æ{\É\ß,\ÇøÓ°v@DC;%•®K¤ÿ\0\Zô\ßxU-`IdQ+\'Á~%„ó.Iù™˜u5\êpB°\Ä\0\0\n\Ó\áBZÌ¡v À\0t¨‰§\ÎÙ\ÔYü\é\Óx\'ŠLœ\ÑùóT‹J;ñŠA:sG~õi\Å\íF3I\ÈúS”du\â´H–\'j!¤>”™­%–\Ô\çŠYG\î\éˆr\Í:Oõufl·nMÿ\0‰å—¬:|~Zú–ü†\ãXÿ\0õ¿\ì¿\nı‘_l·‡‘\Zò ük{\ÃÖ¯m¥\ÆÒô‰\Ø\Ï1ÿ\0i¹?—ğ¯\rø»\â#©\ë\ÓC\æ(p˜=‡\Ş?y,\ë<õ§in\à‚Ä·\0úV•¼\ép88=\Åd !F\à;\Óö–V\Úãœ(´@Ù’x§!)€9B\Úü‚`=\Z¯†\ÈùqQ@×ƒş#j>e¶¸&\æ\Ã<\ÆÇ•ÿ\0tö¯t\Ñ<A§x‚\Ì\\\é÷ ş$ş$úŠù@«m\ÏLzÖ¯_hw‰sc;\Å*úôúU\\V>©˜¿\Õı\ß\î‡§Ó§Ò’Xà¼\áš5’6^7ü\ÅrşñÅ§‰l‘&dŠıGÎ™\á½\Åu¬z0\èGZy‰>¼,÷z	%yf´cÿ\0 ÿ\0Nµ\Â+²J\ÑJªpU†¯¢\áğ¨\èÂ¹ÿ\0x?Mñe\ä_&ğ–\á?ˆ\î*Z)3\Çd\İDa¡õ¬\rCC’\İX\ÂÅ±\ë=«©Ö´MO\Ãw]ôE¡\'	:«UHg\n ƒ{R\åÚ†„¬@û\Ñ\n\Ö†BU8 ğE{ö\rşe¶a\rÏª±®7V\Ò\Õ\å1\ßC\äOü3(ùZ©1p=\Åj\è^\"\Ôü9©G}¥\İ<¯u<\èGqT¯,\'²`nC\Ñ\ÇCUr@\È\Õõ>2\é~%DÓµ\á– @P\Í\ÄS\Ç\îŸc\ëZ\Ş(øoi©«^iEbœŒ\ì\Ï\ÊõòJHÁ\Ï#¥z—€>2j¾h¬uB\×\ÚW@¬~x‡û\'\Ó\Ø\ÒhC<C Ojò[_@\ÑH;\ĞúŠ\ànm\Ş	Z	8 ü§\ÔW\×\Å<;\ãıK\Çq/¼<dúŠñ¯|.¿\Ó®mc3Â§)\"G±¤†x¼‹µ°iÉ€§\×5f{v\Ë+©WS‚U27*„\Ç\"¯i¸(ñçš¥·÷y\ÍXÓ‰[€29\ã4À\ê<\á6ñgŒm¬OÙ•¼Û–1\×ó\éø\×\Õö\Ö\ßRó-ŸË´òW\î\äp>œW\rğ«Â«\áÿ\0\r\Écÿ\0N¿Ã¶F\n§ğ¯\ëŸÆ½*$ò\ãß¹÷©b$ª·÷b\ÒÕ¤\Ï\Ìx_­Z®?\ÄÚ ‚…ùPzŸóü©I\Ù‰p[QÔ¼œ“g,}Mo\Ú\Ä;YšE™ \Î>wù˜š\é,mü\é†~\êòk\"<¨wó7ò«tQTEƒ­j›3i|Ç‰vö õ=Y_&\ÖB\Ì\êzŸğ¦¯Šmì­MI¶\"ù€uöÇ­bK*AI#…E,N\0¯<\×u©5{¬!\"\Ö3ò)\ï\îi°Šrd¾#ñÏˆõ3s.R\Ê\ÃxEÿ\0\Ü\Ö^\Şy¦\'v§‚3\Æ1Rt%b2ZÎ·6“<3Fr®‚±®û\ÃKOFJô[\È×Ÿø¿QùWŸI\ç\Ü\ÓYUÔ‡\\û\Ğ)\î}+gym¨[%Í¤ñ\ÏŒ«\Æ\Ù¦ WÍºNµ«xj\ã\í\ZM\Ó \'/rõ×­z×…>$i\Ş\"x\ì®\Ğ\Ø\êMÀRCş\ËCú\Ğe(4v„VN£©­¼\â5@\ØZ\ïX³‚\á\í~\Ñ]*oòCe±\î;W73<Œ\Î\Ç,\Ç$\Ğ\Ùkù\\4\ìû\Õ\Ï\Ó\Û]X\Z’h„‹µ†A¬\ÙDö„°\Ë\Ç\ß\ÔVleüs\ëKŒñU`ºI@ Õ€ß!Šy8¦Ob;\ÓO>´‡Q8Ó£‹¯Ÿ*¯\ëÿ\0Ö«şğÄ“k—:¥\Ëa*\"úıO\éWl´_\í›f|ˆ\à¦Où5\'üec\àm*©%\ìƒmµ¶ycı\ã\ì+x\"YS\â­|¥‹[M©Ì˜‚.Ñ\ï·ô\ë\ç«[Ÿ\ê—7Ú•ÃˆS÷×—M\ÉÁ=«À\áQ4š§‹üDd•\Ú{\ë·$³w\'\Ñ@ü…k_\İZ\Ú\ÚÅ§Ø¸k(	0ğn%\ï)ö\êv÷­G¨ß‰dWˆ!‰Vö\êr\"N\Ê=Xõ\'¹5±\á/É¨]‹©Ğ’z\îŠ\Í\Ğt‰µ›\å™\Ôù@üŠ{û×²\éšlzešª€±’*\ÒI\\W¹z\Ê\Ö;Hh1Ú¬‡>ƒ½1H\Ú)¥±ojEY‰f>ôÌƒßšn\ãÖíš¤±ù\ÑÒ“¨¢­\"X\àx\ÎhŠ1\Æi:t\Åh‘,q)\Ç\ãH8æŒŸÆ‚9úÖ‰\ÆçŸ¯z;zR\äô\ïM\Ï=*\Ò%–\"nN\ßsŞ«@sŸÎ§b6sTˆe¯\ë¢xnòü¶#\Û»\êk\å]V\í¯5\É\Üõ\'©\îk\Ö>)xº+½2\Ú\ÎÔª¦IA\ã\æ<øs^+o~	=\ë\ÇGb,!# sR¼f¡8\Æz¨ö§+\Üg”À›\0ı=ûT‘O%±\É%£=G¥@$ñ‚2qšz’G¨\ï@\ZğÎ—\n7=\ÅHT\ã$\äûV ,º2CZV\×\âC²Qµñ\Ô\ĞõÆŸp“Á+¤¨r\n•\í~\nø—¦\ËSuŠã€®N¯\r8\í\Í9£–R\ni…®‘\ÒTÊ\Êi0\ËÓ•ô\î+\ç\ß|NÕ´eX&ÿ\0I…x\Î{f½o\Âş<\Ò|J¢4³\İÿ\0\Ï_¡\ïL›Íµµı»ÁqMŒ28\Èÿ\0\ë\Zó|8\Å\ŞóD\İ4—¶<²ı=G\ë^ªËA\ÃzÒ†\ç0{{\Òj\ãLù\Ñ%!ÊQ\Ôòr\rM2[\Ş\Âaº]Or+\×|K\à‹+L€[_u \áûCúõ¯&\ÔôG@º6Ú„?» W ÔµbCUğä¶Š\Íó\íªõ+\\•Æ†\\³Ú¸<ı\ÓÚ½^)öğTö5™ªxz\ßP&\æÑ¾\Ït9\Êÿ\0Öš`y$°\Í›dF_Â™8\í]´\Ğùnmµ+m¯\Ğ68o¥eÏ Cpû­f\'Oj«ˆ»\à¿_h7Ñˆ.\'\älñô#¡ô_…~#i\Úüb\ÇUXí®˜mù\î\åüúc_)\Şi–-–Œ²©û\é\Èÿ\0\ëWQ\á\íS\í¨\"vıüc“\ê)0=\Ã\Ç?l5´’óJ¼d¨\è\ÕóÏˆ<5¨\è7­\ÜFHá¾•\í>ø‰¢lµ¾\rwb;ó\Çô=Ç±¯E¹°ğ\ç\ÄÈ­\Äl1½~òF´&#\ã‰TˆÂŒdóŠ\ì>xYüM\ã#‘sekû\ë“Ø¨</\â­oø\ë\á.§ H\ÓÙ«\\Y’H\Û\É\çó¯PøSá xF\È>\İ}‰f=\Ç÷Wğó&Àô[8;€€J½Lqª€S‰\0dœŞuK±ijpp\ï\Âûzš\à€:–¦IÉ†/\ÔÖ—‰5S,…c\'-òF=½h\Ò\ìÅ¼\n‡\ïZ²“»)\Z6ñ\áGš\èm ò üG“Yúu¿™\'˜\Ã\å_\ç[ \n(¬ıSRK8\ÃL\ßq©ö¦}cT‘ù6ga\Ô\0õú\×0\ÌKú“C\Èò;H\ìY\Ø\ä’z\×\â¿d¾›jüô™\Ôöş\èş¿•V\ÂI\ÉØ§\â}tj3‹[wÍ´g’\ß?\áX‰J‰@œÔ™À\Æ9©:\"¬¬Hò¥’e¹œElò7Td\×cªhú~\áh\Ò\ê5—P›%\Ş\Ş\Ãõüiö8™~şsQ¯_J–N@\íX\×ó\É\à)\Çô f¾ry\çÒ§Òµ«\rQmBk\rÅºŸ+\å\Î\æ#\èqÖ¹\ä\Õ8\Ù\\\ÇxgDø7\Û!ó®[vüzQ`{»\árj\×L^\êøù…˜\ä\í\íùõü«}‡½HUQv¨\0vg&\rİ•\Ûò¨\Ùs\ïSj3œRb2\îl°\ÆH\Ç\ëÆ¢†õ‘öL¥v=\ëMúU[›h\ç\\:\ç\ê)•e89©aA,ñ£0P\Ìc\Ğdõ¬\\\Ïd\ß>^/\ï\ßZ»\ÚJg‹|W¦xAûD»Zfm\àæ•½~¦¾c\Öõ½G\ÄúÔ—·’<÷3¶@\Î=G§ ¯Sñw„\Ó\ÅK\ÂòX\ï\"@‘—bÉ´v#·\Ô~µ\ÄÁ¦·‚Q®µ/û]ò-P0at3s\ÈQõ=«¦2L†¬Z¸\ÒO…¼4Q™\å\á)rÀ\ä\àc0¯°8\Ü{Ÿ—œciú=Î¥©,R¹O\ïWtÿ\0wğ\ï\ï\Çj¯h÷šµúg\È\árs°zóßŸ\ë^¹\áoÅ§\Ú#\Ç_S[\Æ)+²f‡‡´H´\ÛTbƒ~8\é[dU\0É§\ä(ç ¨ï˜š†\î4‰™°G$ğ)“AŒóŠWm®1÷Exÿ\0 ¦„QW=)\ã¥E’jA\ÓŞ­!1\â\Í 4¢µH†/8ö¥#ŠnsÚ–´H–2hö\Í“I\Û&­!	À¥\ë@\ïIÚ­\"Xø­9\Âc©ªqœ`µwnqT‘ù§Ä³\Ëqp\Ì\Ç\ï\ëYbØ˜_˜W ]\èñ\ÈNc‡µr·\ÚMÎš\ÆH\ÉnJñS;L}¥Ia\ÉúÓƒKcÒ¥’¡tc¿¾x¨>a¾ôÀ\'=)\È\Ù8\ÏN•Hû\Ø¶)ü\í\äı(m\Ù<°\í@;\é\è*%\È\á¹ştõqß‘Ò€-\Û\Ş<Y>x\Ï\æ+N)’EÜ­Ÿ¡\éX¬2Fy¦š¬ñ>\è\Û\Ô¾W\Ó\éS[\\\Ém\"\Ée9V¡¬\ëkõ™¶7\Èq\Í[1şt\ëøªñùvZ\é.\ä}\áş÷­zİ½Å½\íºM‰4.2¬§ \×\É\0•<‡5\ÔøW\ÆÚŸ‡.‘&ûf?<r§ü)\ÜV>‘ù£\ÙQş5^ÿ\0O´Õ­\Z\Ú\îš\ì{{ƒ\Ø\ÖO†|_¦x\Ü5¬\'\ç\Ï\Ì>¢·™w!\Ãwô?Zb<‡\Äÿ\0\ït†{\Í+uÍ˜\É1õx\Çõú\×%\Ù=Õ‡Q\é_F+d\í#\r\éş\Æø«\áı²\î\Ãm­÷^Ï¿¡÷©q)3\Ênaµ\Ôa1]F‡Ò¸\í[\Ã\ÓYe\r5¿fQó/ø\×cg{£^5¡E*úô#\ÔJb\\\0\n°Ü§µ+Œ\à´û‹•¹´‹4}‹~ŸZ³%½¿óm]m\ïc9\n\ß(ñ­½S\Ãñ\Üs`\âú\íu«œÔ¬\Íõ¹Šuòn\â\ä\ß\é\íN\â:8®’\å7ckte=A\î*[\rcRğığ¾\Ó.)?ˆº\ÃĞ„W§\êWZ]ğè±¸9\çQ]² \ç*Ü© nğÄ7\ÅÑ¾Ÿ¨Â–× aÑ¹ŠO÷I\è}uš^‡•q3\Û\Í!ş\ä\rÈŒ÷Á\ë^\à\í.]OX†\Æ½+ü\ì\İIü})oo	‘ E\É\ÉÀ¦„KY:\åè¶´1©\Ã8\ç\ÙkQ\İcFv8U&¼û\Ä\ZŒ—S˜“>d\Ç\0z-)» E[5ş\Ğ\Ô\Z\å†b„÷®’‹Š>cTtûU¶·HÀ\é\×\Ü\×E¥[ä™˜p8Z\É_·„A\n \í\×\ëSQEX‚¸­Z\Øn\Ú[±»qù]~\î=¥vµ—¯\ê\éz\å\äè®‘FHFİ‡\çŠ\\ò\ï\ëÿ\0`‡\ì\Ö\ïş“ \ëıÁ\ëõ®e‰f$œ\äš[©e\âI¦%\Î\âi#\éôF<¨‘p<Ò£\İ\Æqÿ\0×£æ‚‹\Úv©>•v. \nÄ®\ÖV0=¿ıTıSUŸTºY%Â¬h#0Ä„Q\Øgš\Ï\'Ÿz8\ê0i\0\é0GZ\ÅÔ±\æ)\àg½j\ÊHˆ\â°5\ê\0üéŒ¡s8\nH#\Ó\ë^\Ùğ\ãÃ¿\Ø^[‰\Ó—¸–LõUşş¿y‡€ôñ\'‰\ã®l­q,Ş‡…üM{ó0€)2*>ƒj…\çOlSZ“\"<SI\ç­<œS	 ˜sÁ¨\ØT­\Ï\Å +:ƒÚ³¦´h\ßÌ·m­Ô§cZ¬3PM$¶ò\İ\İJ\"¶…wH\ç°ş¤ô\Ì\ëit­5\ï.bc o.;\Í\'`=»“\é^C¨]^\ëš\Ì\Ò\Í\'›4²\Ät\'\Ûı‘\ĞUx’\ëÄšÁ’=\ÑB™”ı\Å\ÏO©\îÂº\ßxU‹$² ,q“\è+®•;+³)H\Öğg…Å¬k$‹–<±5\è(¡T\0\0Ç¥2t·‰Q@\0T‡Š©;‚V\Zù u¨\áB¶I­J\Ù$Òœ\0¤ƒr\0\ì*¶Ì€v¤Œ\æGoÂª\Î\Ä\Ì@úU!ˆ¿\äTƒÖ¢\0¯¥Hµ¤Q,p\ãS·v¦şt¢µH–.^)\ÇŞ½:\n>•¢D‡~”„\Ò\ä~tœ¯­R%°úQ‚Â“½ú\Õ\"G\'\'¯j¸™d^j’’\r[ƒ…\ë\ÍZ<´La$£*zH\ÊÀ\Ó\ä¶IT•\éJÑ•Fzç¡¨vIjKÀ\Í$=J}=kÁ;NgWğÁ%§´$²v?J\æY¾o&\á<¹T\ã+Ô–T¹ ı+U\Ğ\í\ï\Ôù©‰;8ş5IÁIÓ\ê˜À<ú\nÒ¼±ºÒ¤+:\ï„ı\×µVh\ÒEF~Z`AÁ$w\î¥ ù#\'\Û4\ÖVC\ßvi\ãœg\ìhQ‹rsÏ­Hd\ÅA\É\ë‘ş\íÀ.’\0J\ë¸\ç•\íõn\Şõ\á!d%—³U%p\Ã\ç\éã‘‚ ®:\Ğâ°”nVÈ§s¿\Ü{V$2I-\Èî§¥j[\İ-\ÂğpıÖ€4lµ>\ég·•£•NU\Æ­{ƒş*Cv#²\×^‹p\rşğşµ\â`{p;Ò€PqÀ¦>¸\\ñ«+CÊ²Ÿ\ÔI¹£ûü¯÷½>¿\ã_>xG\â£\á\ÇH%csbH\İ»ş\é¯rĞ¼G¦øŠ\Ğ\\ió«ñó\ÆxdúŠd’\êú.Ÿ¯Y›{\èT?u‡¾\à×ø—Àú‡Y§‡uÖŸŸõŠ9Aş\Ğ\íü«\Û\è±î‡¡ÿ\0\n£™YH\í†F¾¢“CLù¼?\0¯ùú\Õk\Ëx/£ò\îÙ»ƒ\í^·â¯†ğ\İ\ï¼\Ñ@‚\ã«[ôGúz}:}+\Ën­§³™\í\î¢h§C†G9©\Øg#ª\è\Ò$gx[’\Êıj®‘#A\'\Øn Œ\Ä\ÇùW`’ùc3\ÍX\Ñ<‰|Mg¤{÷Ï$CÚ˜ŸğŸÃ‡O\ÒdÕ®÷÷_,@ÿ\0`õüOò¯G¨¢Š8\"HbP±¢…U\0Dó-¼+ı\Õª$\Çñ °[ù±‘¹Ï ®?J‰®î¤¾gƒFµw.¡z-\å\ål¿°ôÿ\0>•³iÁFƒ\åAXIİ–‹–Ğ™$T^§­t±F\"‰QzYú]¾\Ô30\äô­:hAEU\0V~­¤\Ú\ëz{\Ù^+˜ƒ•8 „V…\ã>%ğ\ÚD$%Í¨| d§<duõ®&k72§¸¯¥.§KKYn$\ÉH»\02H·½|³ªxı¥ñM\ä³\é\Ëmg4§d\n¸1¯L\ã¡\'©¡#XÏ¹h6=)\ê\Ù\Ï<Õˆ\Ş\ËT·\ÙL­À÷ª\Ï\Æ\Øe4)\ì}¨8¦õö4Àşt\0\\H‘Z\È\îxQ\Îk¹•Ù‰\0³1\àZ\Ø\Öow³\Æ\Ü/\ßúÖ§\Ã_sÄ‚ötÍ•‰A3öÖ€n\Èõxpxo\ÃQG\"\â\î\ã÷³œw=\à+¡c\ïRHrj\êL¸\ÃMjRi„\Ò	¨\ÏóÉ¨\É\â€\ZiŒ)ÇŸzM¹\äPR&f\Ú?ú\Õ\ä?ñi\Ö.ÿ\0²t\×ÿ\0@·l³¯üµ~›°\íù\Ö×|`Ö°¾‘a/\ï\ç]²•?u}3\ê{û}k–ğ¿‡^\êQ4\Êv\ç<ÿ\0õ­©S»»\"L¿\á\Éq4sJ‡\î©\ìúvŸ²¢(İ“T´=),m\Ô\íˆü«d+i>ˆIu\Z\Ø\ã=i˜É¡\ÛsšS\Ïÿ\0^ aŒTs>\Å$u\Å?8ª\×$œ…û\İ*‚\Ø	\'¹\ÍS\'÷¤û\Õ\Üyvø>•Cø½*\ï\Í=p8\ê)OJp´Q-ç±£=óH8¥ükTˆl	¥\éŞ’‚GQùU¤Kb\ç#©:PO<ñ\ÍR¹¤sŞŒ÷ ’F{\Õ$!\ê9­A÷±UÒ¬\Ã\ÃUò\Øo\n.c•<r*\ÈN	\ë‘]^½\à\Øn•®ôÀ7u1…pÙ¹\Ó\æx\Ù`ò­\Åxii¢WbñŸ.^ÿ\0\İo­	*ƒ\åÊ¥d¡ş´ôx®†S\0 \Ó&D‘6LFW\é@\\\ÙGu#(d=T\×ª\èN\Ó\Ù\å\â\Ï)\é] ’KL	N\è‰\âP?Ÿ¥N\Ñ$\ËÁ”\î––Iò\Ãú\Z‚X˜eH5\Ù\ë^\ZK\Ò\Ãû¹‡<t&¹I¶²y©µ\Çñ\ÅR ùN\æi\Ø\'§\"¤–+\Èıj•\\\Æ)€¹À\ã\ÅH­ƒ\Ôc»\ÔjARr	ü\èpsó/zRH`A*\Õ\'=5\"¸cH\rmCYø8ûÃ½_\ÎõR§Œg¯Z\Â+ó\ãô§\Ãs-¾6\å—Ò›]H\Öo´kÕº±\á•z=G¥e\Ãp“ *y\î*V^(\ï¾øe­„³\Ô\Ù-oº\è’®öH–PHa÷YzŠùY‘·)#\ë\Ñ|ñF\ïF)e©–º²\Î\'\çŒ{zı)\ÜV=\ÈLÑ³\àg¤ƒîŸ¯¡ÿ\0>Õ™\âi\Ş\"·\ÙuÙ”~\ît2ÿ\0ˆö«ºn©c­Y-Í”\É<;vö\"œcš\Ø\æ,\Éüò\'•ÿ\0tŸ\ä:S\á$ğş6Ûˆü\Ër~K„)ö>‡Ú½á§‡±ôC}:ÿ\0¤\Ş\á†G+ğÇ¯\å]{-¶£jñÈ‰,Oòº:ş„†¬*„Pª\0P0\0\è+ã«—ñF¨¡ˆ7\Ë\Üø\î}+zú\él\í^c\É(õ5\æÚƒ¾§©­ %†wJ\İjg.€‘6‰n\Ò½˜|òŸ—=…töV\æiUN\æ¨ÁTUUÂ€\0\Ò\é¶\ŞL;˜|\ÍY¢‹ª¡(\è-¤\ÍP‡QIFhh¤\Í-\01\Ñd‘\Ô20Á¡\åş.ø9§jğ¼º[%\äˆd9_ÁºÖ½NŠi\Øuox‡Áz)\â`~\ë•‡±\èÂ¯i^0‚í…¶¥†\\`1\èÂ¾¬\Ô4\Û-RÕ­o­\ã\ê3ùzWƒ|SøSo¥irk\Z*\É$J\ÃÌ…†Lc\Ô7R?\Îi\İ=ËŒ¬c<(\Ùh˜\İ0j\Üÿ\0e›\áõ\Æ\èú¥İ›ŒÌˆ\ßP?­tşdwñ’BxÊ <©ú\ĞÕ£ª¹€şu\Í\ÊBŠdšg\n ubN1ù\×\Ñ>ğü^ğõ½‚`Ëó¿÷œõü;a\\?\Ã\ß\Ã{ªbhe¡\ÄG\\¿€şb½IKfuB6\çœ\Ôd\âœ\Ü\Ó‘HÌŒóLjyıi¹\Í M0ÆÙ¦‘\Å\035\Éø\ËÅ‘\èº{\Ãƒp\à€:\ã\ßğıO\Ğ\×A¨]y#\ÉI$`X»¶Õ@$±=€\0ŸÃ¿C\åšV‹uñ\Æ.¶d¥…¸ù®moÇ©ì½¸¤\é\İ\ê&\ìfø{Ã—\Úıä—³†ò·şòF\îO8Ï¯sÿ\0×¯N°¶ŠÌªF¿s\Å_\Ôm-t;xô»\ÙKƒ\ê}Ï©=sYñ>k§ec=õ:«K±*`Ÿ›k\Ì\0\\\ÂLUzıkb\Ú\ër¨n\rEŠ/“\Ô\ÒçŒšg˜1\ïC“¥\0*¶W\'½1”\à\çô§ç·¥!a¸qLD3œEŠ¤\ï­Z¸?.* \âA\Íi\"p8¢”\n\\f·Š!±¼÷¥\ïGqGSš\Ñ\"[x “Œt¤=(&©\Ïl\Z;õ¦x9?…;Ò­!O\éNSy\èiIÁÁªñ÷…YB7qÚª©\ÅX\\Ö˜Hñ–\Î\"˜\åsŒÕ±©\é\Zˆ­¼\ÅÚ“\ã‡şµÄ®É—r·=x«š~«qa(!‰N›M|\ê—s\Ğq\êŒMKI¾\ÑnŠJ…yùXt#\ëI\ÚNK€Ã½zL7z~¿g\ä\\ `G~ \×\â	\\\éŒgµÌ¶\Ä\ç r¿Z¢nPe(xğA\èj©…\á>e Üƒ\ïBO#ı\ÚH/L\'Ë”dZ¸2‡ˆ‚=¨\Ûk¸®S¹ô\ä\Z§ª\è–Ú„Ee<pÃ¨©¦¶YŸ\ÌV\\Œ:7³\nX/\Z9¼‹¥òß¶O\İM1{¨iWz4¸d2[voóÒªmIhÛŸJõ[‹h®¢\ÚÁX7PG¸c\Â\ÒA#O§\çL_\áM1œ\Ã+!\'ò 79¬yŠ\í\åÈ›d\ÔN›	\ã=³\éT!€ô÷¥9‘À\î)£+ƒúR\Æ{\Z\0”1ÃiûÀ\å¨	\0¼Ó•³ŒRD%[|nT8­{ñ#ùra[¦}k<\î\éAP@\É&€7Iùx9¦´\ä\nÍ‚ñ\á!,¾¾•§¤Š[ \ĞÏ‡¼Q©xrğOc;/÷œ«ıE{¿„> \é\'!f[k\ã\Ö<7û§úW\Íø;º\Z\ïşøl\ë\":Œ\È~\É`wŸF“øGõü(\İ\ç³óM†+€0$QœF\Çù«•˜Cô\ÈşU›¨\ŞJ]aµ-¼ğ1\ÆM;ˆ§¨¼º•\Û[\Û\0\ŞP!rx-\Ü\Öf‘á«¨VYf\n%v!‰=+¥³²\Z}¸PwNü«€l@£°¬Ú¸Ì»m\'\Ëui;\n\Õt¦æ\Ô\0úRi€Ñš\0~h\Í74f€N\Ì\Ğ\r\0?4´\ÌÓ «_\İ\ÛX\Ø\\]\Ş:¥´1³\Ê\Í\Ğ(Õšó¯ˆÚ°–\Î\æ\Ëzı–\É·\0%˜ÿ\0ªˆúŒ\á\Øzm\é‚W<k]½\Ñu\Óym`ö:ƒİ¶\èUBÆ°ã\ïtÏ¾j†™n÷—\Ú[.\é¥pŠ\0\ëšÌ…¤H¤m\Î–cÜ¦½G\á_‡ğ&\Ö\î\Ö;|ÿ\0\ã\Íı?:gU”`wúN›¤Ác\"5ù›û\Í\ÜşudœÒ»sQÖ \æši\äPy=E!\éH¦\Zq\éM\'˜ ‘Tµ;\èt».§`ªƒ<÷5x\à|\Ä\àÉ¯ø¡â†¹š\Ş\Îİˆ2pz/EüO\'\èVª*\ì™«x£TñN¨t}=˜¥\ì«\Å\Æ\çù¸öÁ=ºvQ^÷¡\Ú\é?<.–yr]•3ş¶Lw?\İ\ç­x_\Ã\Í0Y\ê1jò)Şœ\ÄcŠ\ï®o$¹”¼Y›MuòYje{²{‹©o.$V,\î\Ù,{\æ–?½\ì*´}9\éSBşfyùi¹\Ş\àŸº:g½hF\ÄsT!\à\n¶­\Æs@\Z1\\np¤óŒ\Ô\ÓM´q\Éô¬\È\ç-ø«ŠFK1\àRÚ±Xc“ü\éq%›94\Äùˆcø\n~qõª9\Îp9ª\ß\Ä*i2I5Ç˜¤Ö±D¶O(\ÏR1ô£<ñ[¤f\Ø÷ ô¤\Î)z*\Ñ-¤<õ§z\Ò`ıj’™÷ü( óF«B½iGNM!ıi\Ù\çŞ˜‡/Z™zçŠ®‡\æ©\Ô\àæ˜ˆ¼O\àF’ÿ\0BP	ù¤´\ì}Jz}+†I“ŠRPJ²0Á\ÜW¾G(q\\Ï‰¼g®ƒs-µ,Àpş\Ì;ız\×\ÏJB3\îytR\Ëi(xÜ‚+­\Ò<E\Â.@\ä`ç¡®J\î\ŞóI¾kJÃ{8õ¸¦el\ÆO­B•ŠqL\è|A\àØ¯\İ\é€\êb\Ï…p\ß\é\Zm\ÃF\êAT\×i£ø‘\í™b²½‰\í[z§ø\ØH6\Ç>2²/õªô#m\Ï>X®\Ğ\Ã\ã½6X\Õ\ã\Ü&\äU÷›ªiº-\ÎÙ~W\ãM†õdù&oZD^m<\ìf¶\í\'uöaıj\ê\É\Ò\Æ8\Ç4„2T‚§±U¾\Íå±’\Ó\å=L\à§¥01µ¿\Å{û\ÈÀI{8\è~µ\Ç\\Eq§M\ä\ŞF@\ì\Ø\íık\Ô!ºe!”†#}ê¾£¥CI#‡óJi\æ\åÜ‡\ä<ı*³px\'¯9­OCº\Òdi\"Ì°¾\Ã\ßük<\çRz0=*„@¬ó¥8\0ôô4:l?\İ\Ò@\'„\ĞŠ\ä\àœu§«‚0\Õ\ì{{Ó†8\Îph|t\Æ\Å:&–\r\È=E1_\åÀzTx,\ã·j\0Ô²‘¯d—3HÁB¤ŸJú‡Âš~ğå¶œ¡|\ìo‡ñ9\ëş…x\çÁ-şµ&¿uú=—Ñ¥#¯\à?˜¯ug\ß&I÷4eI\æ§«\Î}j¼6Xô)Ò¹lF½[ô€T;\Ø\Êzt_ñ œÒ’\íL¤\æŒ\ÓI£4€\\\Òæ™š\\\Ğ³Kšnh\Í\0;w4¹¦qJ\Z€=)\ÊsJ«KsŞ€\Î\Öu\ì\İ=¥@¯;!8\ç¦}‡$û_>ø\ËX7—B\Â	L‘D\å\ŞF\Ë!?4‡\êxƒğ¯DøŸ¬]ip´’Fê¬¦(\nôÁû\Ø?\Ş? \á\Ò\Érñ=Ç”ì…¶´»~PŞ™\éøPoF:İ‰e¦\ÜjZü¶Ë¹\îX§©?NµôE…œZfœ \á@£ğ®á·†^\Æ\İõ›\Å\"i\×©\ê©\Üş?Ò»\×l÷¤\ÅRWv@ÍšŒ±\Ğ[4\Ó\ÏzFAšNi¼Š\\\çŠ\0\\\ÒpÔ¦…”€Àñnªšn˜\"-µ§İ¸ÿ\0v5sùqõ\"¾}w—Ä\'iq,™À\ä*ƒ\éŒ\n\ìş%x„\Ü\Í8şY‘ırC\Éÿ\08?÷À¬\Ïif8$½‘y“\åO ÿ\0\ëÿ\0*\é£²&ì¾\ÊµG\0\0\0«h\Ù|TE°1Š’œ\ä\Öõ%vLU‘dn| \ïÖ®ªªaGª±\ìòjd`H\É\Íf2\Údrj\Ê>\ÔÏµS\Î@çŸ¥N§r¨\îyü(ô\äãŒ“R\ÄL\Î‹\Ó\Ü\ÕX\ß\í\r°«xş\ÕyYPp>Q\é@\â—wız…pÏ¯AJO^y¦„\ÄsŸóÒ˜ n\ëKM$n\ë]1D6O\ïG?…5\ÆM.qZ¤f\Ø‘\èh\É\Í7\ïJ¦©\"Gw\íA\ãÚ0£¬*\Ò\ç­E/\'9¦Š \ä\ÑÏ­\æÇŠbN\rLO\îÏ­B¹\Ïj’A˜›Jb:\r_‚üs\å\\/Mo\Ç6x5Á\ßi{\ÛÎ€\ì•z2Õ½+\ÄO‹i¨¯\Ñd\Ç¾z2¹\Ş\×c¥\ÖtK\rz\È\Û_Dz«¨=«\É5\Ï\ßø^|Í›‹l%Â\Í\èk\Øa¸COCS\ËWP4SF²D\ã¬2¡\Å0Œ¬x9T˜nNµsO\Õn4Ù€\ä¦zf·üM\à;1ÿ\0DV–\Ø|\ÏkÕ“ı\ßQ\í\\¤SGr8Àn\àö¬\İ\âk£;\Øo,u\Û3\rÂ«©Q\\gˆ|>œZ\æ\Ó÷¶\ç\Ğrµ3Mg8x\É®¿Iñw( ¸\00Ct5IÜ–¬yµ½\ã\ÂBJ2½1\ÜUĞ‰\"ù‘~µ\×\ë\Ş\r‚õ\Z\ïMe<˜\ÇCô®£¹Ó§d•YO*E$œ\åÉUû²¯ocI\rÜ–òˆ®\Ô)?u¿…\ê\ÄRGr¾\ÜR:Šdó\"=Tö \ÍwQ’ä•\Æk>ev\Ì\ä”\ì~•Òƒ.\ÆZ{\\õ\ê\Éõõy%†ö0N=§°I½„†”\Øù\Ç#<D´|½\ë¾Ö¼;\r\Üd²üİ­q7v—:\\\Ş\\Ëº>\ÍVÀ¢F\Ö\ÏšrœƒøT…E/¥E°\ç¦1@‡n\è@5wO´›Q¿·²¶Bó\Î\ë\Z/©5KƒÁ\"½{\àÏ†ƒ\Ë7ˆ\î“)b¶\È\ê\ß\Äß€\ãó¦«hZT>\Ğmt»p1\nü\íı÷<“ùÖ´D¶vªJ\ÆIy\é\ÔÖ„\rÿ\0•H®\0\äƒ+unŸJ„şõ\Ä}º·Ò§cÛµ ša<\ĞO”€\\\Òd\æ“4™\í@\ÇP\r6– Ss\Å8x\Ğš–5\Ürz\nE„õcŠ˜\0\0¥R@-QT#;Y‚\Î\çI+ø#Ü¯Ì’‚{ú\ë\Îl\â†\Ğ6”¶­£’BªñZ\î¼Gq²\Ö8ø\Î\æúóúW0\É1ıL†®YR©\Z¢€ª£\0Ô„Œ\æ£\Ïz7z\Ôq8\æ\Zi¤\çÖ€N{\Ñü\é ñœb—­\0;=k\ÅZ“i\Ú3$²\ê\èù1·÷s÷›\è&¶G¥y\Ä_3MvQ¸6V\Ãßƒ+ÿ\0%úfšW`\Ï;\Ô\ç:×ˆpg\É\"„\Ê8§õ¯J\Ó\íR\Î\Ê(PpŠ\0®#ÁZov\×N¹	\Âı{şŸÎ½	Ğ…À®ø.X\\Å»»\ä\à\095<}³Q\"Œ\äœúT\Ê02{\Öe§¯¥Y‡†z\Z¬>\î;ö«¦\0\ëü¨\íû\Éöô©\ä}\Î!N9>‚«\îòÇ–œ\È\Õ=ª\0\à\ç‘É F”@Ea@\æ¥\ŞL_Z¬Í”Ç©©¸Üƒ·\\Q`-©\Âûb£ˆ\ïw>ø¦<˜_zt*q\ïU\rX\Ä\Ä\ÓNwŠ:õ\é\'š\ëHÅ²`i	sM\r\ÍúsV‘#\ã£<{\ÓG\ŞÉ¥\Ï5iRG¹\à\Ó3ŸJPqÛŠ`p¸<f”3ù\ÓOPiA\ê1ƒT!sN9öô¦õü©@\Çn)ˆùª~ˆEBi\ì~J`l\çvGN÷OŠ\æ<2ŒúÖ•Õ”–Í•ù£õô¨³šùƒ\Ğ2¬µ+½Aå¥µ\Î2y\"»+Ø®¡Ym\ä¤g…,	2À\Z\Ë\İhó™\í	1\ç\æ<¥\\emÁ«ƒ¡\Ç5\Çø«À±j¬÷\Úa[}C©ù%úúz\Ó\Òõ¨5[d\Ã\ï!\à\Ö\Ôsv=jİ\âM£\Â\ä\Ù\İ=¥ô-\ÂpU\Ç\ëô ©4g‘\Ï\ì\Z÷†\ì<Ck\å\İ&\ÙWı\\\éÃ¡ööö¯*Õ´C\Ãb\ä\ßn\ç\\(ù[\Øúj\ÊQh\Ö2L\Ò\Ò|C%³,7+\ë\é[š“§ø†\Û\Ê&#\åwú\×„e0}\êæªO§H9%=\r	÷cUĞ¯4‹¢HAÑ‡z†\ÅpoÎ½:\Ë-r\×Ê™Uç¨®?\Ä>–Ì´ö¿¼„ó\ÇQTI‘†@bª=¡e³!%<´g\î·\Ó\Ğ\Ñ\Ã\Û>\Ç®qƒVÊ¬£tL3\é@\Û_¤»¢•vH8(\İEA©i0\Ü\Æpª\êz©©n!K•!+ IWª\ÓVi­˜Gr2İ”}\ÖúúS\ÏõM{im·4cªc‘ş5$I—û¯\é^£sf—<ÿ\0r\ZÏ‡¾f–1\åÍŸÀ\Õ&.—¤\ÜjúÅ¶Ÿl»¥¸\"ÿ\0Søu¯§´û(4]\"\ÛLµa·Œ(÷=\É÷\'šñ‡¶W\Zl²j³³¯\î\â\È\í\Üÿ\0Ÿzõ\Í+Rş\ÑB\ì¸(pŞ„\ĞØ\Ëe\Î\Ñ\Üõ­\áW\Øvªv\Ãjo=M[|\Ù2yü\éj\İ\nG–û\ÍÉ§“IšBx¤1sIšJk¸U\Ï\é@g\n2\Ç‘][• ı+:\âRı9ş”YiCtQ\×Ş€4¨÷¤\ÍAu+¤\'\Ë±\î;P\"\Îô\æp£ÔšS¨\ÙFv}¡2{I¬±½»~ğ{·­>Œ–q	·\ÊOnƒ\éT\Z“]1„ûŒÀ“\ê*\ïzÈ\Ñ\ä‚,œ\àgŠØªRQE09l.]\äÈ8ü?úÿ\0Ö°·\îbÇ©æµ¼Gt¯yöh\ÎU9÷½+\Z\Î[\Îh\Î9¦\ç}i23õ\â¤b–¥›Ş—¿€vy§d\í¨\ÇT‹@\r¸s\r³º¨$) W\Íş)½ş\Ò\ÖLP¶ø¢mŠ\Ùû\Ç$–üX“ø×µ|D\×WCğ´ˆ‹›¿\İ\Æ3\È^\çüúŠñOX½æª¬\ãpS¸ı{\á[Ñƒl‰»Ï†´Ák§¢\ã2q\ëŞµ™	5\Ğ\é\Zb&†^X`U;«‘ë¢¤•ù{¥ÌŸ/Ù§¨\Æ9©\ÌY\ÎE!\\GOJ‚ˆ\Ï0yşU;\È#\0\ãs¢ùc]\Í\×Ò¤…L’˜ôö¦\"hÔ¢c—n¦¬@0™\ã®*³€U˜¸\Ú;u4À¶0d_jr\ÌVU\çoZbœ¹>Ø¥ˆ€6¢õ=}h@X\Î\ì*\Ô\ê6€J‰\0@\0\ï\ÔÔ™\È\âºi\Ó\åWf2•\Ç\ç\r\ßZh\ç¥8V\Ö\"\ãû_Z\0\Î(\éKú\Õ$!\0\Çz	¥<S3Ï­U„.{)÷\Ï4„œ\ÓI$j«\0\à\Ù\ÈÁ§\ÍG¸õ<Šp\'Šv&N3øRö\éL¹\æœ8?¥0½ºT\Ïş©¸ÿ\09¨‡\\\â¥\ÆS° Gl0Á³®ô\ìfK~\×ü*Ú·5*¾\r|\Ñ\è˜*pH\æT0 ŠÔº²K€YF\Ù=}k)£xœ«‚©*óLe”\\[1U\ç\"´t¯\ïqk|<¹‡»\Z›!ª•ö›\Ê0İˆ¦€\ë#›\É\Èõ§]Z\Ûj6muMƒ2\rq6ZµÖ’\ë\r\æ\é \è¸®¶\Ú\é\'ˆI†C\Ïªi“km\â?]\èL\×zg™s§Z.¯ş£õ¬eŠ\å2ü+\İUÃ­q&ğwNú†Š²w<=_ğ5‡cHÏ£8ˆe’\Ñ\Ã\Æ\åH®³I\×\Ò\áD7\0<aº\Z\ãVgI\Ş\Ö\î&‚\â3‡\Æ5.\Â0À\ãĞƒPŠi3¡\×|%\rò5Í†\Õ~¥;¥prCq§\Ü‘J8\ãWm¥x\í˜G;e}}+gP\Ò\ì<AjX…*½\ÛsÍ’d¸\0œ_‘”2ªFA©õm\ëJ”–S°taTbŸ $ƒSM0$thWÌ¶,ñ½ñ/Ò\ä^ÃŒes\ÏÖŸóDC¢ \ß\Ì\"kg\Ï\ÜıE0%!P‘“µx\ÅuKx±FO”ùOjã¡™\ßq‘\Z3‚B}«±\Ğ%}6\Ûz‘ºNX{vŞ«!W¯JÑ‰|¨Â½\ë/K•f&q´°\à\Z\Ô&•Àx4„\ÓsNE.	Ö˜?…V•‹\äŸÎ¤v\Üp8QQ±\í@\ÊTğ¸Œm\Çq×­h\Ğ`FE9£´yû\Ù¥–&“\Èõ¦\"\ê°e:\Z‚ısh\ßZ\Şmµ¾\éı*\Ì\ëº\ÕHE]1Hˆ\ç¦x«\ÕZ\Ï<\Ô\É/J\á›\ä·s\éL}±Z\è[Ä»\Ø}\æ…¤\Ôn\Ö\Â\ÊIÛ¨Q\êİ«.úş=>\Ò\âUó¤|*ƒ\É$ô\Ç\ãY:Ş ×—+`Rƒ…»š¬‚\Æ[;\É#;\ÎÄ“\æ—4\Îô¹\ÏÒ²(Z<Šfy&”İ¨Ç­9¦ñŸzp9\æ\Îjh\×q8ÿ\0\n‰Fp{\Ö?Œu\á\á¿\Ïv­¶\æQ\å\Â=\Ï\ÃşÒ¸Gñ#_:ß‰\å6ÿ\0E¶ı\Üj:q\Ôş «\à] Ÿ-\Ù~i>cš\á\ìm\Úşù†w6\æúW¹xSO[	\ç\İIr\Å\È\ÆZ»\Z\Æ\"…tZxVD şl±\ÍD\Ät\Ís\ß[š¥#Ÿ¥@ö\ÅSq/\\\Öô‘+¶Xp*´\î8\Ç\È:{\Õ&+F2M\î>Q÷EJF\Ñ\ï\éW\å¶\ÚÀ»U%R3\Ü\nµ©%| ÷«\Ñ¼\ãµTC´—‘\ÍYL˜Àa†>•@L…;NA5b$\n:|\İi‘G±yû\Çô©G¯J\è§¬\Êrè‡\Ù\êiã‘€0Ô ú\Ö\æCƒ‘”ñ\×5\ÇüiÀğEZB&\Ïg¶*0x\ã­;=\ZvN@\ê)§ô\ïKœ\ç8¤5B\Z\Í\è)	ô¤9Á\ÇÖ“>\Ô\Ä; /\\\np?…F=:ı)sÚ˜®I¸}iÀ\ãÿ\0¯Q\ÇPiû²>jard8\ÅJyN\Õ@\â¦<G\Í;Õ«s‘S«\Õ5cš™[ò÷=\"Ú·4’Á\Âa\Ç>¾•5J­@\ÛIm\'\Í\Êg†ŠÙ­²\×k\0A¬\ë«\ßJúzR>{T<0ú\ÖZ­Ş‹1’Ù‹Ec=?\n\ÚDˆ$LÁ£`-išÍ¾¡h\Ûlƒª¹­x\ç\r×­yÆ­f\Ğ\Í\æÀ\Ïy\riø{\Ä\Ï<\ßa\Ô(%\é¿\ë\ïZ)\\M\"ğ­‡ˆ¡Uò®~\î\á\Ì=¨ö¯/¿°¿ğõ\ï\Ù5(ğ­ş®eû’c\ë\í^\É\Ü\0NGc\ëM¾°´\Õl\Ú\Öò\ê­üÇ¡¢Q¸\ã+6$C\Ï^µr\ÃR\Æ\\Jw\\ÕxR÷\ÃN\×»\î´\Ì\ä¶2ñFõõ›\Ñ\Ü(e?­gª5Ñ£¶‚\î\ÓW¶1\Ê õ\É\ë\Ş’Ü´öƒt^€t¨\ã’Ky\Ä\ÅH\ç\ë]>—®$\ãÉ›†<s\È5W¹\rXód2B\ÛO`Ô¡3–ŒıEwšß…\á\Ô\ÜZae\ëŞ¸ß±\Ëm9†H\È h¸ˆ`w\nW…<ñ]™h÷Wq\Ä2«\éY–ğ¨\'hÁ<\æ»]\Ë\ì–~c\Ş\Ë\Ï\ĞzT\ÊC4†F\0j+¢¿+r*¨\éô¼šIˆ\ÖV¹S‘VP0A$s\\Î­\â/i/©_¾;bˆšWô\×Ò¥Ñ¼M¹¥Å¨Û«F²d=r:\à÷­\×j\í£òG«\Âáœ“ÛµUÉ’O^´\â\n‘ƒ\Í0-’3N2rjºK»†\à\Õ\ÈX\Æ9 	”*ea­‚=* isŠb5¶\èù•%¼¡\×\Ën¸\ã=\èW+\ĞÓ¶£>õz¡õ	M½³¤±\ØmS\×v\éöeY\'¯Ö³5{¦ûX„7—\"° ŸNæ¦„€òq“š\0\Å\Ö›UQƒ²\ÜûG ı	ª8\ç¯5oQ˜Iv\à}\ĞzúŸó\ÅT÷¨{”/nzP:\ÑÒ‚i\0¸\Åş>Ôœ\ç­\'¥\08:z*,sR/\ë@Ä…\äP3\ß\ÓŞ¼Oâ‡ˆ¿µ¼Hm!$\ÛY,(\î{Ÿ\Ó…z·Šu¡\á\ß]^\ä	\äTşñ\ïı~€\×\Î\Ë\æ^]„\ê\Ò7\Ş=~µ¥8İ“&uÓŒ\Óù\ì>û`q\Ğœ×µ\ØÀ-\í1\×\×\à\Í%cT%F\Õ\ë»<+¦³åŠœ5wNE3<cÖ”õ¯`hwÓ­!n1\Å*½#g>ôĞ™Œõ\ê“\ÆK`\n¼\ì0sÏµSœc¥Z%y]Bú\ã5b(±ó¿Ê¥Š3=I´\Õ\ÑNÕ™\Î]`\æ”u=iø\ÇZ1\ß5ÒŒDğy¥\î)@\ä\ç­8zU¡:@úQø\ÓIÁ\Å!oj¡¤İ\Îi;P[œ\Õ\n\ã\Ës\éšv\îƒ5{QœñLWNM \êsùRÜŸZ^\Ù\æ˜\\1ù\Ñ\É\â9ü\éy œ\Ó¤\àc­(¹<b’\Î\ßnõ@=[¥L\àˆ›x¨Tô¦\â#\Î:SÒ«Tª\Ü{\Õdn•*+\å.z…¤j•Z«.zTªM\0X\rR)ªÀÔªx¦76+&^ zz\Ö~[k‚\rm+`S\'·\áy\á»HIm\Öa\Î\rf\İh±J2:0\àƒ[RA$µ—\è{R`Ô†d\Øk\é\Ò{\ì´Y\Â\Éş5\ÔÁp®\ã`\Èzk\æ\É.†PsY±\ÍM\Ñ\î’ßºz}+HË¹-¸a\"@*F5Áø“Àd3\ß\èJO¼ö½¿\İô>\İ+©±\Ô!¼‰d…†OU\î+E%9\ëT\ÒbM£Å­\îw»C:4s!\Ú\È\Ã¥[\0G\î+\Ğ|G\á+=}<\å\Ä\Ê0“ \ë\ìÃ¸¯>š\Ö÷Iºû£\ÇşuÇ¨5“””½+U–	;nO\ï\ßZªn“ZÔ®\É\Û0§n3\ïõ©¢\Óc1\Äò—\Ş\Ü\í\Ï\0{ÖŒP…P\0=C­c2\ÏFaz¤ÿ\0«^O½t*²¸À\ÅM÷i\\	rzVŒV\âuw{òª-2\Ø\Í/™ ı\Ü|ó\Ü\Ô\×n\Ò\ÈO\åZ\Åu%m\ã/\İø§\Ä0]Kªl±L!·dÁ‰{\ì#‚O¿ô®\Î\Ú\ÖKh-m\"[Â¡GaW¼’\íƒÓ½HöûT\å}»U\nŒæ‚¸<\n]\×\0)\äV²n\\ƒƒ\éT¢Œ\ç$U•%y¥4\"ÁN\r.iVA\"\á\Ç>´Œ…O·­Pšc½3‘\Í1Ú	qo\ê:\ë÷\\Ee\ŞHúU«.³\r±·×©­=\ŞüW)ª\ß}²ñˆo\İGò§õ462˜>´_Ò“>”¹ùj!$”f“qúRd\n\0y\îi=)¥j]Àš\0p\'<T\Ñ)f\0sš€q\ëPêº´Z‡w¨\ÊAò„SüLxñ$Æ€<·â¾½ı¡¯.›Ÿ³\Ù.\Ìv.pXş\ëš\æü-bn¯„„p8\×úVM\Äó_^K3¹y¥r\Ä÷f\'¯\âzOƒ4€‚1·c$Î»hG[¾†3—C¼Ñ­EµšŒ`‘Zd\äõ\Zp:bÉÁüe9sI²¢¬„c;\Ô.3 SO.\0$\Ôq¶X±¤2C\éLc€Nq\Å+>2j&`F	S\ÙH\à”A\æ6ö/ozTŒJ\à\ã\n*\ÙÂ®OjŞ”/«3œ­¡\0I\æ˜Ã¿Zya“ŠnA\0ƒÒº‘ˆ\Ò)@ J;³I}ª\Ñ\"\í\ã“Ï­\'Z\\?Æ›\ÛóV„!>Ÿ7q\Í)SL#\áT‰­\Ï(=¦\çê…$c­(#\Ñ×i9ü*„HqÚœ[Š„6A£sŞ€&\È<¢—‚O¥Fcb>”\Ğdzf”\Ë4Á\É\ãôî¿…0£\ëR˜XŸnµ9ŸÖ¦\ä\ÅÀ¦\â>qV\ë\îÎŠ+\ä‘\êı»ı_ş=O\ßô\Ïÿ\0¢Š`8_\Ó?üz”j õ?ø÷ÿ\0ZŠ)€ÿ\0¶\ä«\Çü\n·\Åƒ?ğ*( `u‘J½¸#ı\ïşµf\Ü\ê+¥Vvÿ\0\ëQE \"ş\Öÿ\0¦ø÷ÿ\0Zšú’¸*\Ğd½ÿ\0Ö¢Š@c^_5Œ‚\ê\ÙJ6y¸5\Ğiºû\İÚ¬\0\r\Íÿ\0Ö¢Š\Ö÷4c\Õ\É\ã\Éÿ\0Ç¿úÕ‡\â]a$A%š:«o\Ë6I\Çnœu¢ŠrÙ„w1WU2¶ó?½ÿ\0Ö«ª“ÿ\0õ¨¢¹M	©0ÿ\0\ã\ßıj“ûH\'ÿ\0ÿ\0\ëQE0:5ºZG\Z\ÇÁ\\Ÿš«ArO“ÿ\0õ¨¢·[/\Û\0÷}Ú¥\ÛzG\×ıª(¦\0\×*N|¬ÀªTºÿ\0T?:( B²~\ï\ëJ&\Çğ\çñ¢Š`Kö‘ÿ\0<\Ç\çSExO\ÊPõ¢Š`\\\à üê¬’óÀ\Ç\ãE\Äg\ê·2E§¹C†aŒúf¹¿/¿J(©cB\í\ã­!ôQP1¥{\æ˜rZ( \0:ô¤\ÍS\0\Ï\ç5Iÿ\0\Ñ4\å!`#\Ìoöù4QW\r\Äö8\rKõ.3Œ°õ\ì~*–û€9\Ç\\\ÑEwCøL\ç—Äƒ\Ïùq·¯½0\ÎI\ÎŞôQ\\¦\Är\Ü¿wõ¦¬\ä/\İ÷\ëEÀi¸%1·>´	wH½U!’l|¡p>´K9õ¢Š\í\Ç4·\"ûFy\Ûú\Ğ\'\Ïğş´QZ\"D7<\à&?\Z\Z\ç„ıh¢©	ŒûY8ù?ZSr@oZ(«B]}\ßÖ˜\×_7ú±ù\ÑEZ\Óq“÷?Zˆ\Ü</\ëED²U¼Àÿ\0W\Ôz¶\Ø\ãE\ÄGöŸ›?ZO´\Ûvñõ¢Šh	\ä\áıiÿ\0j#øZ(¦¾Ñ©ú\ÓZñ•		ú\ÑE0(E/\Úy$ƒ\Û5¬5³ı_Qı\ê( ÿ\Ù',1,'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿ\Û\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\0\0\È\0\È\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rğbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Ú\0\0\0?\0ô{\ë‹ÈŠ\Ço\ä‰X|‹*œ1ô\re¶»©±0C\Ş\Æ~{k€Aqş\Ëg\çµs¾$Zx¾\Õ4mjU¶\Öò\0¸#£Áúdw\ê=sqoÊ‹]M\ÍQòJ2÷r‡×·½y\ÒR‹³;a\Ë%q–Z†\â›)´­V\Õt’	F¨\î>¢¸Oü™\'½\×,µƒ$j,–÷(K0\0œnúWO¨X\Ëlc–fy\Õ?\Ôİ¡<~˜nÇ±Á\æ¶ôın;›9,µ2²@\êb7(\n¯<m‘O1œü{Ö”\ê4MJIê›J˜ñ\"\Ñöö¥\Îk¸ñ€®¼+3\\Aº\çHü²u1ƒ\Ğ7ø\×sl\Ğ2<´G¿¥v¦š\Ğ\ãjÀ:€*~zJ…_<qS \ëŠd‹qe¡I,\Ë\Ê?ô5ˆ|\ËKƒë‚½\Ïz\İ\\p(š\Ú+\è|©°’_OjC3#0ÀÁ`G\ë9–k9\Ì®\ï\Øı*\ÔR|¹\È4u1À\âŸ=¼±”}E@œóR+\ãŒ\Ğ-\æŸ=\Ë|ğÿ\0‹\Ûü*¤—w!<³q+ÇcÊº\Õq´ƒ†C\ÕOJÌ¿\Ğ\Ö@e²\ëÕ¢?Ò•†bEr\È\Ã\rÈ­­3^º°™%·¸’9!‘°Esò\Äñ1¤Áš’\í9\0t¢À})ğ\ã\â]Æ¯}—ªÈ\ì?w)lú\Zô[ùf\Ü@¯\ìu­.#šJI¬½}-\à/[ø\ÏHXepš­²\"÷\Ç÷…!ƒ \Ã;ØƒI\ÏGó\ë\ÍHF\rf\\\é÷‘»\Üió\àZû§\é\éM14n\Å)8*\äCWbº#‡üë´×„sˆ¯\áh$÷\èk¤·¹·A@Aª¬¬d\Z*´@©Êš(\å[\á\ÄZ…ƒ\ë~¾ş\Ø\ÓW\æ–\×ş^múğ\É\Ôô8\ã\'°#š»\àÿ\0‹7úm\ÔzoŠ_\é\Ù*\ÒJ34\'=I?|\Ô}>¤\ëZ–ƒ¨%ş•y-­\Êô’6\ÆG¡ö<\Zô4×¼%ñE¿‰\â‹A\×\ØmMZ\İq\Í\Ğy«Û·\'+Ò¢QRVe\ÆN.\èö~š•€¹\Ño\"’ˆü\á\"\ÙS:ô9`ô ƒ\Ó\Éêš®«hv¬‚|c÷q.\ì}@\ã5‚ü3®øF\Æò\È\âU’\åv\İFÁ\áhñÁ\\ö9üë¦›DüÂí¸·|û×Ÿ(¨\Ê\Ç|e\Í™\Z?ŠüOn«§¢\Û\\\é\ròMjÁö÷À$¯áŸj¯\â/\Ïu£Msà¶Šò\Î\æP\ï8\r\îü\ß^‡µ-uVš\Ä%¥\ÔM{°´qózwÖ°t?^\èZ\ë\Ë%°Dc¶\æ\0~òı;C[Ó“F5 §Ÿ\ê:N£¢]mFÕ­\ç\\o \í\ÏNG¦\ÄCŞ½\âV™>¡qŠô\äûN“s\n‡uò\È\à\î½>£\ç²Z4j&ˆ	\çv\×T]\Õ\ÎI+1Y3ƒÇ¥8(\ÚG\éMF\Ü=şµ>\ĞÉŒs\ëT\"½Í´w‘ySg+÷ŠÀ‘%±¸òfC®™W\æÁ\0\Ôw–i{–ıG\İn\ëHxe\ãŒU¥`Gñ¬§Il\î3‘\ĞúŠ¹¼ph\ê¹<S\äyª\ÊÀJrœ\Ğ·°_®%dÿ\0ƒú\×3©\éSX¾J\æ3Ñ‡Jé”†\ï\ÍL®¥v:†C\ÕXRÂ£El\èú½î‹¨\Ã{a3EsÜ¤#\ê\r^¿ğôs+Ig€ıv\Z\ç\ä‚\â\ÒM²\ÆU»du g\Ô^\nñµ¯Œ¬r\Û\"\Ô\"¾„¿\íj\ê6\ãƒ_$hú\ÕŞ¨Cye1Šx\ÎC\×\ØûWÑ¾ñöŸ\â\Ë%F\"E÷°ş\ë\ê)X†\â\ïH“e†­\Ä\íŠf\áXún\ì~µŸw\áû\İ%ŒöR4öıp9`?­h_iÖº¥œ¶—q	!”a”\×k«\ë_n\Ò\ÆúI5\r\îds—UôÏ¨¦£«\Ó5·<3gA\ëEXŠ\r\'Ä–ÿ\0n\Ò\çU”Œ¼s\èÂŠwD\Øø\ÛRÓ¯´›\ÙlµYm®b8h¤\\ÿ\0\Ö÷­¿\0\è°\ë~+¶\ïg\Ù-\Ê\Ïp®2¨ÛBX\íš\è4\ß\Økö‘hş?µ{ûu \Õ\"\â\ê\ÛÜŸ\ã÷\àı\ãZºO‚¬ô-JMJ\ÓZ·\Ô4»ˆ	´#‚\Êz†^\Ìö\íÒ”¶Ğ¸µ}OY·\Ô\ßQ¸û4ƒ\ÄX9V¤„ùüø55Án\Ç\ä>õ\Éü:¼\í×¶\Ï#I!!±\ê9­_x†`”\\\Ù\Ü\Å\ä(>.Š3Á$r9\Çò®J\Çteus+ZµÒ®t•ƒRÒ®\Ôº%Å´d…\Ï\Ì2GA\Î?µ\Ä\Ø\é°Izò\Çsq9FÂ‰]‰®Mzß„5ûmO\ÃWóÊ‚hC$¬Hı\à†8®	â¸½’B\Û ¯úq[B\è™4Ê|I»ğW‰!\Ó/\Şh7ƒ5±PL{‰“?Oºx<ô\'5\Ò\ë>µ–\Ö-{\Ã\ízE\Úòg`>ƒ®=ºŠòo\éók~:´Ó Lª‘8%\à	?…{»ÿ\0óg±\\ µV\ã\n6Ç ü9­­etrÉ«Ùeym9‰a\×<©\Ïò¨\ÑóEzÇşj+w³O\rBtd\İ%Ÿ\Ì\\ô\Ë.{÷®Nÿ\0A–>\Ûj¥\í\Î\0yL\Õ\ÆW\"J\ÆP^ış´õ\Ç\0ƒŠlgœ0\Ç\ÔÔŒ™\Ş\ÕD•\ïôô½„+@ùEsl²\Ù\Üf\\\Ó\Ğ\×Z’`€N*\rCOş\Ğ?f¨9A\ï\ÍZW\È\Æ8¬¦ZLb™pAü\ê\Ô3 \æ¤e\á\Ç?Î¦W\Îqø\Õt6<ú\Ó\ÇOş½0-+• ´LE\Ä-€	H¢F\È\àô§ÿ\0… 0n-Ä´—Ÿ•€\à}jM6]J;¥½³/‘¶\à\é\Æ\ßÇ¿Ò¶	\Ç\ÊT2‘Ò¦I]aX\à` q°ô\r½\à?¦¿\Ù_¢ƒx{Š\ío´\ëmN\Í\ín\ãD\ãö÷ó#\Ş\Ü\Ø^\ÄşS\Û\\)Ş\İXu¯nğ\'\ãñ\Êÿ\0_¦\0c÷e÷ô†f&‘¨xG[V‚g1ıÜ‹Ñ‡¡¢½:[8\î­\Ú)2\Ğ\ÑF\à¬|4k¿\Ñ`¸›Áö\ĞZ3¨gw\ß>\Ş\Øü½ªóøcÃŸa{¯Jºnµ´¼\ÚË€²d˜_¡xöè¢£ğ¼Z•¤2i6–—vN\Äş\è‚;œñ\ØsôÁ\ÏzlHµ\áûË½Y†\á¤Ë©8\'§¿=û~\ìwu­;˜&ov(ËŸ½†½\Ó\É|Agr°‹Í©\Şdd\\?\Ş\ÏLš£5­2lŸ<c¨)Œ\ÓÒ°©-Q½:œº3¿M%\"‚Kx\çUYcÁük\Ê\Æ\ÇÌ\â)„\ä†\Ë\îz\ç¥b\É\ãBI\Ê\Ín©ƒ\Ó\Ì85‘¨\ë—:¡Á–,\ä¨?zœ \Ö\ãH½\ïÀ:4º\ÕıÖ»nV{û]Ì¶…€fW\î¾\à~5G\âf½ş‘œ©´Mò+Œ\'A‘\ë\Çò­_‡±\Øh×šÌ¹…S!d\É^F~lCŸ¦*­Ï|7\â\ç\ZWlLÀ›}V\Ùyn	Ê‡\ïq@?NI­n§’YG-\Õô1DNıÛ³\é¥{‚¼O¯+\Ùğv)\ç\ÌQÁ\ãñ®{Xøu\ák­WN5m:\áv\Ú\ßZ|ÁPKc¡½2+’\Ú\ß!2¥€ò\äV\êŠH8ÿ\0sø\nw\èú¦“j\Ë-\î™0šr$P9Œÿ\0…d(\àƒ\Éö®Gñ%ö«¥\Ìm\æÁ\'\É4/÷\\zÂ»»\ë+K\ë\ÖôRd±\á\ã?~\î­ş4\Ñ&	Œ©#·j’2Fz\n™@r=©\\{SRÿ\0K‹R€\ã‰GCŠ\ä\Ù%´¸1Le\ï\ë]\Êq×¯µA«i1ê¶»£]—(8\ÇzM\æá—¡«ˆwsÕŒD¶³f]®¼sW\á›Ò¤Ãƒ\Øâ¿0\ã\0\ã½@sš\\œúq\Ü\Ğ2cÓ ¨\Ëmn#=I¤iqš‰\Ë&H!=}h\Z5¡+\é\ÉY¥\Ühù’	7)î§¨#\ÛÖ¯xi\"¼µ7ğı¦6\ß-«Cô$ò>÷§~*]C›Rºòm\ÔHHû§ø‡zÖºğe¨%\Ã¶š3‘.ÿ\0-•‡pA\Î~•“¨¯c¡Rv\Ğôÿ\0x\ä…,µL¤øÚ²7½\äÍ«M¥İ§\Ú‘\"ºG*§\Ü€\ÛF6ö\åq\î¬NhªM1J„“\Õ5²A2K´r#GS‚¤r=k\êoƒ¾\'—\Åzu	..¯¬E=\Ìñ X¶\0a\Ëa@\É>\İy¯\×>Gm§gCÔ—UĞ˜ñw	‹¾$^ªFFsúW°xbÁ|ğUp\Ä]ß©”ºõ\İ \à¤`Â´¹\Î\Î#\â¢š\'‰_O»Ñ¤´³•İ¢!2…w\ìs’N\éTaŠ\Æ\î\ä¡1\ÇrŒNÜƒ=:õ\Ço^¹¨´o\İ\Ãq&™\âx5\É&V\ŞUù\íñÀ17n\Üt\ãŒd\Õoxûf\ŞoøRmZ\Å\×\Úôº¶\êHe\ê\İ=ñ\ÆG4¬Q—®h\É´\Ë2\à¿\İ\Ü*\çƒü ş-Ô®R\Ò\æ\İZ\Ø,˜	dS\×`#\êOWœ\Êò™•Ÿx\à\î\'5\î?ô/°øiõIAYod\ÜºÄ™Áö\çw#\Õh°˜ÿ\0j–š?‡ \Ñ-\ã6{\É\n˜\ã^¹÷ÀÁõ\İ^\"\í&¡|J®eğ«\îO½¯]ñÏ†õÛ¹tX—´246Ú¸ıü8b\ß\Ş]\Ü~\×1©|6›\Ã\â_X\İ&±¡ˆšKK»CŸ› pA\ë\î=±@ˆt¯jş½6\ÚL\Â[X#Kk\"\ïŠv#,Y}†y<\Ğ\×Qq¢øW\â0•4]–·\î§\ã¢7lş}xÀ\Íy¥¤›L\åÜµ\ÆÒ rKòíŸ Á\í\Z¯…?v:\Ä\ØS\íÚ€45\İQ\Ğ\ïe°Õ­$·”d\rÃ†÷½?Á\Ş(»ğö®fùfµ‘6\ÜÛ±ùf§ç“œö®§HøÅ‹h^7³ş\Ù\ÓN|¹\Ïü|À\êø±\ÏR¿j_ü0ß¥¶¹\àË¥\Ö4\Õ&B©ş¾´¬½zvÀ<ô ƒXÑ­\ÛO·\×ôW3i\\«M\İĞŠ\ÂV\rÁ\ÍEğ·[Ô­|I‹¸º\Óõò\î\ì\å8\0Y\Æz2€O¾1\×\Öø\Ë\Â2xz\èOl\ì&9\Ør¿\ìŸz«ˆ\å\Êb@©¡s«† \Ó\ïÀb\0¥ƒ´\ÄA®h‰­\Â÷€.Td\ß\ÜW\ÛLb”ma\Åz428d\àõS^ğòk¦\ê\Õ\İ Ë \ï\î)43’Q\Ç5i0\Ï5ŠKyLr‚¬+F\ÔIu\"\ÅË±À©n\Ö\ÖKû‘\Zµyf\ÇA]7Ø­’!¼îŠ«Ç§[-p\\ıùq\ÔûW}\à?Z?\í=IY,ı\Ú7YÏ©?\İ­K.:\r­î¯ \Ü¬\Ïlë”•[kœÿ\0w}9>”öš\×Q‰®Vie»c™!\Ãw°s^Å¨[i\Ò\ŞD²y_.\à=ñXš—„tIZò\Ó}•üXX8\à\ã¡ã†²³oTwC\ìÕ“º<ş+Eh¤%\åVXL†&„\çªpO\ãE_Ôµ;\Èn‹ª|³¨EqyR¹!Àû®8\çwùh¦¢ú‘S+û§ğ¦\çZ_i\ÖZ=\ä-Ü¡nP|\É$#%÷)\àü»±õ\ã½·\ã¯ªh-…\n]­š>\ÚÌ±\îs€¹\Æ9\æ±şü;¹ğ®»ªk\Z›\Û\Ëm¸[+¸\\<SF\ß3H§\è£şú5\æ7ñ¶¦¾9:™y5­\Ônd\ß`ŒôV\n\0 ğEl\Î#\ÏZ7*\ÙVS‚:Wô]sSğö£¡¤\Ş\Ëit‡‡Œ\ã#®\èÃÁ\È5è‰ªxS\â\\k¸ ğ÷‰ˆ\Â\êZÜ\ÂAü\'óÛ¯E®#\ÄşÖ¼!¨}“W´h÷«™yQ\ê­\ßù\Ó½ƒSğ¯\ÅFKmj(ô/?	¨@Ÿ\è÷Gıµş\î}:ö®\×\Ä7sx7\Â\íi%¹·š8–\Ú\Ô¹X\0\0*\İ\ÇLcšòO‡\Úxk\ÙõP|¡\åÅ\î\İN?\àU\Ù^üG:\ÑÑ¯\ì\ã\Õô0¡&µŸ\ï=\n9û¤Çšyf¬\Éqy˜§G\"cÛ¯\ë“ø\Ö\ç…<s¬xC\é“/”\Ä\Éq‹º9»a‡§¿_z\Ş\Õ>i\Ş ±“\\ø{xo­PnŸL”\â\ê\Øúcø‡ø¯:’-\îš)U£¬¬0Aô>ô\ì\Òi^ø„\Ú\Ñhºğ>Á!\Û\É\'\'\ËlI\íÁ\ë\Æ9¯8Ö´]K\Ãú»Zj–’[\Í÷Hq\Ãw„{Š£4–[W!×G¯oÖ½Iøş›‘\ã[#¬iŒ?wqŸô›s¡³\Î9\ês\îqŠ\0ó¿(Ü¼Œ§Tq\ØtüØ[\Z‰umõu.ö[y\Ï\Ş*xoPÀğF{]^·ğ\é\á\Ò\ÛVğ¥\Ú\ëZ3\Ìñ®ˆm+§Q€s\Ó?7 W-\á=x¦\ÛHˆ2¤\ï¾GıZ\\ş]=I½\0}\à(\áñ<ş*»Ñ °\Ô\îQ\ÒYmÀ\ÙsW–S\È\Ë/N®\rt$¼·>V™,p³Ÿ\Ş!ş\ïù\çòõ«öp[\èš:¢ Š\"\n¨9Ú aT~Z\æt”›V\Õ%¿—’\íˆı\0õ\ß\Ğ\n–Àóxb}óÌ]­$?»|~†±Qƒ8ôV§£\Ú\êºkY\\F\n\áI\ì}k\ÂüG\áËŸ\ß2:±„Ÿ‘ê“¸š3G\ËÀjƒ\à\æ¨\Ç2‘\É\Å?y<Lú\Õ\Ìñ^—o|M\ÜH\"r~m£€}j†™h¶–\ì\ìùü¸ö®†\ç\ÚA\'#işU{á§…\Å:©¸ºû2\×ı`é½»-D†Ï‡\ŞmfEÕµXÈ°V\ÌqùlGş\Ëü\ë\Ñõ½IcQahÁ@[g°Ÿ\çÚ¬\êú„Zu¢\Ù\ÚGÛµ-r\Ä\ì\\’I<äœ“\ïQr„b#Mª0\0\àUkqu5úGl2\äüÀôÇ½N¨óÊ±Æ¥™s\Óx\Ó\ì¾9°Ğ´uIm\á›n¥p?Œô Ê™\É=\Èô´›œïŠ¼Lu™Eƒ\Ø\Å¬.H(2-ü<g…=\ÎI¢ñJ6\'k´@!¹>bı\ì|\ßLh¤l­cº\Ó-ôÿ\0|Ó´½^\æ{A{	Æ™xš@]‰ŠÓ\ZğŸ\Zø#U\Ñdm]%S\Ò.X¼:¡\ßx\Úx\Ç>•\éu†Ôµ\Ò-e\ÇÙF\ÛN~f\Ã6q\í´w\èk\Êü1\ã=sÁ72AÙ¬gÈ¸°¸\á™O\ã\×ı¡\é\ÜqW{³•\é\Ô\×u\áˆ÷\Znı…¯Ú¦µ\á\çÀk[ƒ—„z\Ä\İWq\Ó\Ó\Ík\Üx?@ñí¬š—¥[]MWÌ¸\Ğn¦<2\çúgo¼\Ò\î\Î\çOº’\Ö\î	 ¸‰Š¼r)VS\î\r0=\ÌxB\Ú\ßGmO\Â-îœ \ÌÖ˜ÿ\0I 2½FG§~µ\â\Z\Ä\×7r4\Ù\ŞX³Ø¿\áøWa\ájD–Ö·’[_\Û\ÛÌ‡–Q\ÕOcÓ¡\Î@ö®\î\ë\Â\ßd6¾!X|=\â_\àÔ¢\\[]\Ş`\Ï\ÊO©=ºôZ@y^“«\ß\èz„Z†™u-­\ÔG)$m‚=½\Çb½zjx‡\Ã\àK¤:7ˆ±…Šf\Îš½Nzu\åG\Âx£Áºß„/Í®«hÑ†ÿ\0U2ü\Ñ\Ê=U¿§Z\È\\°x\ä\Õ\ì5\ßk>¾h¯\à\ßm!\ÌPü\ÑJ:Œ\é\\õ²#\ŞynG”¥3Œ¨9#ñ8\ÓxK\â.£ Y.™{z®‰ \Øú}\ÑÊz£s°ş\Ù\æºMGÀ:gˆl¯\à)Z|m–].\àq\n\ã¢ús\Ô\çM\0q\Ú7‰5\rë‹¨i—o,¹cî¿³/B:õ\é_Fx\Ò\ÛWH|Rú4:n£y	Yü•\ÂL›¸l\ÉP{\äœğGø[\Âsø›\ÅV\Ú<‰,*¯\æ\\»Z×–<a‘ÔŠú¨˜4m ²Æ‘\Å\n\0‘¨ÀPF:ƒŠLO^´óE¤ÀN\\\æR==?/\æ+_E²[ke cŒ/Ò¹\í\n\Ö]Bõ\ïgÉ’cœ\ã¢ÿ\0Ÿ\ç]¢€ª\0€+&\î1k#\Ä\Z¾¹§¼¨ßƒ±½\ë^i\Üœu}}P’)†ÓŒT|\ì/½}\r­xsN×¢y\Ş>\ìˆp\Ãñ®KşW‡\âŸÍº½¼™ÿ\0T\Î\0?\Í_25ğÿ\0†õ/Ş›kPc´^\'¹aò¨\î©¯g´±Ó¼\á\èô\ë8P@\Éù»’­L÷v>ÑœXZ¢[Û¦B&s÷w’\Ş\Ë\çK€H\áA\áj®;I+I#\Ë!\Ü\ìrMA¹¤*Œ³p\0¤v$…$ô½Wñˆ-ü£›—H\å\Ö\'_ôx‘şó\é\Ç\áBW`ex\ç\Ä\Í\á«A¡\é’3k·ª¯ù­£nÀösÛ¸ñÁ©<	\á8ô;>\á\İÎ¹n>\ïµbø#\Ãw7—’x[&[»†2\rüò{×¢\ïù…tB6%˜¾2\Ó³\á¦;I¹·Ë©a‚Jğ1\Í²¸J‡u\ß\îN0M´VRVv)KAş)ğŸ\â5k…	m¨J\Ü\"a$=„ƒ±\í»ùğµ\ãş\"ğcA3\Ø\êv¦\Ê\É\Õd÷1Ï¨\í^ù¨\ê\Ñ\é6W·\Óô{;c#© c÷W=ÿ\0Š\Ã\Ğ<C\áÏˆz(€B›‚\ï’\Âl	#=7!ô\ê\à)[°&|¹}¤j^½K›w•\Z#¾9¢b¬˜\èA\Ì~•\ÛYø\ÓAñÕ¬z_b_¨\Ùo¯[\Æ¯ •@\ä{n-^…\â\\\éqI,*\×úp\Ë\Ş\Ãşğ\Ç\ï|€:ù»\àĞ¨\×:s€dŸ:}GJ\î;|U\à]kÁw\ŞK>B$µÔ­N\è¤A\Ïc\íùf†x¼G¦yŠª—qı\å3şüô©|-\ã\ÍcÁ\æ]:x–ûI›‹2\ï˜\Üw\Û\×i>£ƒ\ÆA® xKIñ\Z¾¿ğòr\Ó\"–»\Ğn	£ösó˜\ëÛœñLF\'†¾!\İhÖ¿\Ø!³]g\Ã\ìvµ¥Áù\á?v\İA8\ã\Í\\Õ¾Zj\Úkk¾¼:š>y\ì›ş>msÙ—©ËŒõ®^ÒŒ±µ\ÊF\ÑÈŸ\ë#e*\Ê{\ä„w£kZ§‡5(\ïô»\Émn£<<g¨ô#¡t<S@Uhc•XhÛ•#š\è4BòÉ ¼²¹–˜¾ì±¶xõ\ÜWm«\á_‰¡­õu‡@ñ4ŠB\ßF1mtGM\ãø[\ë\é×œT^\Zøc­C\ãxtb\Í\ã·S\çK2d\Æğ©\Ú\Şù\ê	\é@hø|—ú¶‹c¯\ëVvğj·a\ç†0<@ü¥\Æ:œoùp:tU¿\Ü5õôZdg(§|¤Ÿó“]\Ìğ\éZcËµ~Uœ\íı`\è6Os3\\\Üd\ï|ö‡ù÷¨“\è4n\éV‚\Ú\Ôq†aù\ÕzŠ*F! “U¥¼†,\Íò’{\nÔ°¬\é¡£€\ÊF FUş½\ç–\Ò8^\äqš¥ö‡u\æB\ßSV.´B3%¡>ñ·ô5\'™à«¯Pj\íFr–l0H\Ë\è\ÇÖ«³\ç¥E;l‡»\Ş\ãƒù­>ÿ\0R²ğ®5M<Éœí±²\È\r;úó\ÑGRO\0{\àŠºU\Õ\íü!¦‹\ë„\ês)6¶\Øİ´tódaA u$Œ\äy\ï‡ô‹¯\ë³kZ£\É,>fòò6\ã#\ÙÀÀ@G\ZŸüE!º¹3m÷3¨*€vT yÁ\'‚Æ½>\Ò\Ö\r>\Ñ-­$H0\0­\ãrQˆ\ÑQ*€&N(\ëEmrdÉ;X\Ç\\zóúQD@4dÁE\\\è)»\Ü\Ï\ÚX\ã~/ø¬ü1k¤¡\Ûs©\Éö‰\×eŒ}\ÕaùøyF›¨\ÉmqÖ“=½\ÌDdb\Çpj_x‰üK\â\ë«Ïœ[¦\"„\Êõ\ëõ&¹õ^¾¹® ú\'Á_\â¿x´\ï2\ÃtHX\ï\0$öq\Ğ~œö­ÿ\0ø\n\ßP/y¤”´¼<”ÿ\0–Rÿ\0ñ\'\Üq×õó=µ\î0³s\èÿ\0\ã^Ÿ\áŠ7ú	g|†ş\Ä`!/ó\Æ=q\è\æ)\î#ÄI¦{{»cizœ•aŒû‚=}FAık\Ï%¶\Õ|+ª%Õ´\Ó[\ÏnI\â%Y\Ï\ä}\ë\ëtoxûGYce¸@8aò\ÍùƒÇ¸8\î+\Í|]\à‹6&û\\k\Óóò] \æ<ÿ\0{û¿¨?¥sš\Ò<{¡x\Ú4±ñpN\Ö0-^$9OA\ç/Aõ\é\Ïğ\Ï!\ãŸj>¼\Ì\Ğf\Òna3º7\Íı*=g\Â+j\Zh™„9ÿ\0X‹ûK\Ô~WY\à¯\ß\é\Úchº\Ä\êš;®¼\ç*\ÊºO*ÃŸ\ç×š.•\Â\Ûf‰ùa“_Xü%\Ò5+XV\å\çf-4\Íóx\ÈOQò‚q\Ûv8Á¯5³øY \ë\Ş!±Ô´\ß;F«^\éòƒ\çÁB9*OË»°\É\É\Æk\Şu´Ò´¶“ø€\Â\0:µ6\ÄdkSÿ\0hj‰b‡0ÁóI\í\ØŸOzß²¶\Ö\ê¸\ÃMbx~Å‰3MË“½Ï«ğş•©«j#OµFe|„\Ï@}Mg¾£ \Ö5¸ô\Õ 2nQ¹\ËôQ\ï^S\â/\ß\ëzˆ–\Ö\â{;h¸…!©÷bF2O\è?\Ññ?ˆ[SºkX%-n—pÖ·®{ÿ\0_¥fZ\ÅnÖ·3\\NÆ Eı\çbxü	\'ühfVw~ø¢\Ñ¶\×Ğ´}>\Ùò?\ßA×¿+\í\Çz\î\îuK\'±[«Y¢¸Ych\Ü0a¹C_6^\ê\Ê_¸\nc=k\Õ<#§\\\éş¯¿\ãòu\êWi…1Œ\Îˆµ œR\ÔÔ»\Ô\î$˜¤³:©?(\ÎûT\'¥>x\ÕĞ†\\ƒ\Ø\Ös™-O’/\îõ#ük6AjöK\Ğø‡Z“e•²l†2\×2B¯ş<?3À¼ºÿ\0P\Õü_\âS4˜7\×$p¯+idıûe…ixò\î\â÷\ÄZu\Äó\Ç~›X\é»HHˆÀ,À˜3\ÔdŒ\ÖxK\ÃQøO3H¡¯&v\ëa]PJ\×!\îkhZE·‡ô…¶·\0¶\Ò]û³z\ÔÅ·T“6\ØHú\n®§Š\Ò*\àİ‰;RœR\nC]P‰“döç¨¢£ƒ>a÷V\ê&,ñ­K\Ãv÷ª\Ïmˆn1§\î¿ùü\Ç\é\\]ÕŒÖ“4r\Æ\É \ä©\ï\î=Ezæ¥§O¦H‚\è,–\îs\Ê}\Çúú\ZÉ¿\Óí¯¡ò®“\Ê\È:¯¾¯JñS;O3WÛı±Vm\î^ò©ê§¥]\Õô5‹8\İ	?,\Ë\Óñô?¥d«r0\Õ@u\Úˆot›Å½\Ò\î	×‚\ê=\èE{¯„>$i¾%U±¿X\í5|¶ÿ\0W6»\ç\Ğûu¯˜c™•·U‡B+N\à\ä$‡kt\rØš`}\â_‡÷\İ\èAcs’öm÷[\İ	\éô<sÛ¥x¾³ :\ÌEº½¥\Ô,tÀ©S\Ü`ôÿ\0tñô®\çÁ¿®t\ÃŸ¯º²\áR\à\Ë÷şğı~½+\ÑõDñ–—‚h\Ø4g\É\Ô!##Ù‡p=N~\í+\ã¾\ès\Éözö&‡ú<JAa÷¸\ì>§¸®\ËQ¸:¶´!\æ‚\Ô\àcøŸüÿ\0J½u\äøg\Ãp\Ø\Ù)%C\î\Äõ\'\É9\'\Ô\Ó<9§ù1	$\äK\âc\Ô\Ô\Éô\Z7m`ö\ë\ê9\'Ş¨ø‡L—X\Ğ\î¬!¸<\Ê\Ì+»#?˜È­0h\ÎióN¡§\\iW\Ó\ÙÏ°\Ë#†\ÚHg\ÄUmÿ\0•zç‹¾iú\İ\ÜÚ®‘rú^±!,ò§\Í\Äóó¯õı+\Æ/\×RÓµ­\'T´6—ğ±M\ê\Ég_®r)›FW/ø[Gÿ\0„“\Æ\0È¡\ì,–lòÿ\0\n~$~!M{’kÁş_øz+g\0\İ\Ê|Û–\î\\ö\êz8\àõ­\'$Ô²$\î\Èd5‡\â\rf\ßC\Ód»œo»*pÒ¹\è£\Ó\ë\Øg¯JÔ¾º†\Ê\ÖK‹‰8£,\ì\Ä\×ıŸ.©wˆ5\\˜¤\É\Óma\ÏF~n£=¿\n¨C™İ‹¾\nğ\åÄ·x‡Yù\ïg;‘OD±\è\0Àü+¹şUa~²Ä±7Ë´W‹‚0O­\È*\\>\åŒ\Äÿ\0Jjt\æ–\ã™‚Œbº)D™1Ù¤&šM&s]q‰‹dğŸ\Şš)±šŠ\Ò\Ä\ÜÀ/ü?pún§j²\ÛHbnREşò\Ë\Ügµf^h\Ş]¹½Ò™®l‡/	ÿ\0Yøó\ï^¤.,µ\ëc¦\ê\Ö\ê$\ê\ãø‘¿É®+W\Ğ5]}®\ÚV’\Ó?%À\è$§¦zl\â¾~\Ö\Ø\î\Ü\ã£EµUe·aƒtú{}:W)¬ød\Ú\ãMV’!\Ë@~ò}3üzd\Úu¶µºk\r–šŸW€ñ\ßOCş}\ë	\â–9\Ú) ¹N\Z6Ã¸¦˜L\éå“€\ã§CJ²c®ÿ\0V\ĞmõL\É[{\ÜÀd\ÇóşÊ¸[\Ë\ì§0\ÍAü\'¸õ½Zwb\Ú\í£Â°\ßoQ^ùğ_K\ßG¸\Õ\äšA\r\ãl‚\ÇaU8/\\£¿Ö¼+\ÃZD\Ş \×\í4¸[iğ\îpv \å›ğ\0œw¯¬tˆ!²²‚\Ú\Ú0–öñ¬P =@\Z\İL\í,\Ûdn\ÙQ…€ÿ\0\Z—v:S7aqß½4µCmÔ¡\ê\0jhÔ–\É\ã%p+êš”:V™=\ììª‘!o›8\Ï\à	ü¯ğµ¤&ñ\íş¹td{x&óÁs\ÎxA×¶3ÀÀ+\Ú|_§\Új~¸µ¼Œ¼mŒb§vx<søW%¥\ØZi6\Ö\Î‚2\Å\ÙP’§\'“\é\Ï`)½Œ’O¹£#\ä\ÔLsM-š\Ï\×5DÑ´K«÷\ëd¯\ç·õ\ÆzTØ“\Ï<q¨·ˆ<Q‡\árlm?{xğÍş£ºo\'¾¸3L\å\Ü÷=\0•\Çxj\ŞV³—R¸\Ü\ß\ÈebÄ’øFO\'ÿ\0¯]=¾@º\ÔyRFw»¹½jø]¢¶ “p$ó\ï\ë\\\í³o—nx\ÎOÒµ\Òc°œóŒ\n`Z‘³(<iÙ¨I\ä}i\å²k²œlŒ%!ÇšJM\Ô]	¶Kù¨¦§\rE]‰7ol1…—\æL\å$^?\Ğ\ÔÖº£@¦\×R$6y¬\Ö³ŸJ¿Šëµ€ ğAª·6;T´k¾#\Õz‘ş5ói\Ûc\Ğ9Ÿx- ¢«<#\æke9t÷\Ô³\×\Ó<\nÀó\íu˜\ßUùe^\"¼Qó/³zŠ\îm\îfÒ¾h÷Kh:ÇŸ™û>\Ş\Õ© iş%€\ê\Z\\±\Åv\Ù\Üq„”ú8\ê¿_\\ñN\×\Õ\r>\çšjZmÆ›(†ñCF\Ü\Åp¿uıò:Ö²u\r:J\Ü\Åvm\åex{ñüÿ\0•v‘\Ï=‹I¦jv¥\âÿ\0––\Òõ_u?È*†¡ \"7šk›‹.\ëüq}}¨LmX\Éøu¦®ƒ«\Üy»eš\ë¤ƒª¦s\Û\Ô\ã?A\ï^\İf\0P{¿½y/‡¬dmN6„”lğGE\Èô\ã<W©[\İPò€:úzµ \Ò\0	ªğ\Í#\ÊÛˆ	$³\ÂÊ†9‚3•\äc\×4\ècWl‚˜ˆ®¦y3¤H:»›ò<U‹6s	’V\ÏlŸj\0\Øû\ã\ë\İ}j\Í\èˆ\Ë\Z¸5İ‚:Nj´I_Ä·Q­œP^C¸{Z\æ7ROs-Ë‡™÷0PúTy\ÅCwc%\r\\Ä»\Ó}&›\á˜2eºM6:„\Ì\çò÷®\ä\Ë0¼\Ó8H£R\îç¢¨\'ò¯8ğw™\âo_ø’\áv!RrG\n?\0\äj\éFò»\è)=Š\ãAv±º\"#Ò©\0÷ô®\ÂR`÷\ìk>\ê\İ\n’\0Ï­j¤\ÛÔ–¬e\ÚğN8ŠÔ€w=3\ÅU·µ\Û\É\å{g½]PEuÒ§}Y”\çm2œš“Š®:õ§y•Ö¢`\Øöjª2À)­R&\åØÍœ\ÑQB\ÇuVÎ²-‚\r^\ÎEW\Ë&zDsÙ¬¹hğºö5˜¶r\ÙLe³)?3Â¿\×\ßŞŠ(½€š\ê\Ö\ÃÄ–\â´1]EÊ²$Œû\ãôük˜M#RÑ¯\Ş&‘YS\îÈ¤ÿ\0w±ö?™¢Šrøn8½l_\Óôø\í	t_œ¨RŞ¸­mGGŠÿ\0K{¤fu\ÄÁdd$w*AÇ¨\Ï<”QS²H\í<„X¢ET\n\0\0€\íô«–£\Ë\Èa\Éô=(¢µD–Tg¨õ¬\rr\î(\×b\Ê>vvûÿ\0/ÎŠ)· ùaM\Ş(¢¢\ã8ß‰:\ß\Ùt(ô›wÿ\0I\Ô+(8\"0r~™8\ãuløKOFğüÿ\0.\çú\ÑEt\ÅZ™›øV•7“‚£À™¹?(\ë\ïEt’r\ÔSvC‰^İºReEW¡‘‘»¹ğI\0Œ\ÑEtD†nÜŒŠ•d¢Š*\Ñ$‘Ê†P›\Æ\ìg\íEUÿ\Ù','image/jpeg','1',1,'ck1232','2017-02-28 22:54:22','ck1232','2017-02-28 22:54:22','N');
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_inventory`
--

DROP TABLE IF EXISTS `product_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_inventory` (
  `product_inventory_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_suboption_rs_id` int(11) DEFAULT NULL,
  `transfer_from` int(11) DEFAULT NULL,
  `transfer_to` int(11) DEFAULT NULL,
  `plus_or_minus` bit(1) NOT NULL DEFAULT b'1',
  `qty` int(6) NOT NULL DEFAULT '0',
  `remarks` varchar(255) DEFAULT NULL,
  `unit_amt` decimal(8,2) DEFAULT NULL,
  `mode` varchar(255) DEFAULT NULL,
  `reference_id` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `delete_remarks` varchar(255) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`product_inventory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_inventory`
--

LOCK TABLES `product_inventory` WRITE;
/*!40000 ALTER TABLE `product_inventory` DISABLE KEYS */;
INSERT INTO `product_inventory` VALUES (1,38,1,2,'',10,'abc',10.00,NULL,NULL,'2017-03-19',NULL,1,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(2,38,1,2,'\0',10,'abc',10.00,NULL,NULL,'2017-03-19',NULL,1,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(3,38,2,NULL,'',2,NULL,NULL,NULL,NULL,'2017-03-19',NULL,1,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(4,38,2,NULL,'\0',2,NULL,NULL,NULL,NULL,'2017-03-19',NULL,1,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(5,38,NULL,1,'',10,NULL,NULL,NULL,NULL,'2017-03-19',NULL,1,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(6,41,NULL,2,'',2,NULL,NULL,'BATCH',23,'2017-03-19',NULL,1,'euphona','2017-01-16 22:25:56','euphona','2017-01-16 22:25:56','N'),(8,41,NULL,2,'\0',1,NULL,NULL,NULL,NULL,'2017-03-19',NULL,1,'euphona','2017-01-18 22:38:07','euphona','2017-01-18 22:38:07','N'),(10,41,NULL,2,'\0',2,NULL,NULL,NULL,NULL,'2017-03-19',NULL,1,'euphona','2017-01-18 22:44:31','euphona','2017-01-18 22:44:31','N'),(13,41,NULL,3,'',3,NULL,NULL,'BATCH',24,'2017-03-19',NULL,1,'euphona','2017-01-18 22:52:51','euphona','2017-01-18 22:52:51','N'),(14,41,NULL,2,'',2,NULL,NULL,'BATCH',25,'2017-03-19',NULL,1,'euphona','2017-01-18 23:03:59','euphona','2017-01-18 23:03:59','N'),(16,41,NULL,2,'\0',1,'old: 2, new: 1',NULL,'BATCH',25,'2017-03-19',NULL,1,'euphona','2017-01-18 23:04:47','euphona','2017-01-18 23:04:47','N'),(19,41,NULL,2,'\0',1,NULL,NULL,'BATCH',25,'2017-03-19',NULL,1,'euphona','2017-01-18 23:07:49','euphona','2017-01-18 23:07:49','N'),(30,41,NULL,2,'',10,NULL,NULL,'BATCH',25,'2017-03-19',NULL,1,'euphona','2017-01-19 20:36:50','euphona','2017-01-19 20:36:50','N'),(32,41,3,NULL,'\0',1,NULL,NULL,'BATCH',24,'2017-03-19',NULL,1,'euphona','2017-01-19 20:39:39','euphona','2017-01-19 20:39:39','N'),(33,41,2,NULL,'\0',10,NULL,NULL,'BATCH',25,'2017-03-19',NULL,1,'euphona','2017-01-19 20:39:39','euphona','2017-01-19 20:39:39','N');
/*!40000 ALTER TABLE `product_inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_option`
--

DROP TABLE IF EXISTS `product_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_option` (
  `product_option_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `display_ind` char(1) NOT NULL DEFAULT 'N',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`product_option_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_option`
--

LOCK TABLES `product_option` WRITE;
/*!40000 ALTER TABLE `product_option` DISABLE KEYS */;
INSERT INTO `product_option` VALUES (1,'Color','1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(2,'Color','1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(3,'Color','1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(4,'Type','1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(5,'Type','1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(6,'Type','1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(9,'No Option','1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(16,'testck','1',1,'euphona','2016-12-05 23:21:28','euphona','2016-12-05 23:21:28','N'),(17,'testck','1',1,'euphona','2016-12-05 23:21:28','euphona','2016-12-05 23:21:28','N'),(18,'testck','1',1,'euphona','2016-12-05 23:21:28','euphona','2016-12-05 23:21:28','N'),(19,'it works32','1',1,'euphona','2016-12-05 23:25:16','euphona','2016-12-05 23:25:16','N'),(20,'it works32','1',1,'euphona','2016-12-05 23:25:16','euphona','2016-12-05 23:25:16','N'),(21,'it works32','1',1,'euphona','2016-12-05 23:25:16','euphona','2016-12-05 23:25:16','N'),(22,'ckbehbeh','1',2,'euphona','2016-12-20 22:36:35','euphona','2016-12-20 22:36:52','N'),(23,'kns','1',1,'ck1232','2016-12-26 15:22:42','ck1232','2016-12-26 15:22:42','N'),(24,'Memory','1',1,'ck1232','2016-12-26 17:17:01','ck1232','2016-12-26 17:17:01','N'),(25,'Color','1',1,'ck1232','2016-12-26 17:49:00','ck1232','2016-12-26 17:49:00','N'),(26,'Memory','1',1,'ck1232','2016-12-26 17:49:00','ck1232','2016-12-26 17:49:00','N');
/*!40000 ALTER TABLE `product_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_specification`
--

DROP TABLE IF EXISTS `product_specification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_specification` (
  `product_specification_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `content` longtext,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`product_specification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_specification`
--

LOCK TABLES `product_specification` WRITE;
/*!40000 ALTER TABLE `product_specification` DISABLE KEYS */;
INSERT INTO `product_specification` VALUES (11,17,'<p>sddsad</p>\r\n',0,'ck1232','2016-12-26 17:17:01','ck1232','2016-12-26 17:17:01','N'),(12,18,'<p>dasdas</p>\r\n',0,'ck1232','2016-12-26 17:17:01','ck1232','2016-12-26 17:17:01','N'),(13,19,'<p>asdas123</p>\r\n',0,'ck1232','2016-12-26 17:17:01','ck1232','2016-12-26 17:17:01','N'),(14,20,'<p>asdas</p>\r\n',0,'ck1232','2016-12-26 17:17:01','ck1232','2016-12-26 17:17:01','N'),(15,21,'<p>asdas1</p>\r\n',0,'ck1232','2016-12-26 17:17:01','ck1232','2016-12-26 17:17:01','N'),(16,22,'<p>dasdas</p>\r\n',0,'ck1232','2016-12-26 17:17:01','ck1232','2016-12-26 17:17:01','N'),(17,23,'<p>Ck is shit</p>\r\n',0,'ck1232','2016-12-26 17:17:01','ck1232','2016-12-26 17:17:01','N'),(18,24,'<p>iphone lo</p>\r\n',1,'ck1232','2016-12-26 17:17:01','ck1232','2016-12-26 17:17:01','N'),(19,25,'',1,'ck1232','2017-02-28 22:29:59','ck1232','2017-02-28 22:29:59','N');
/*!40000 ALTER TABLE `product_specification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_sub_category`
--

DROP TABLE IF EXISTS `product_sub_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_sub_category` (
  `sub_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `category_id` int(11) NOT NULL,
  `display_ind` char(1) NOT NULL DEFAULT 'Y',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`sub_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_sub_category`
--

LOCK TABLES `product_sub_category` WRITE;
/*!40000 ALTER TABLE `product_sub_category` DISABLE KEYS */;
INSERT INTO `product_sub_category` VALUES (1,'Light Bulbs',1,'Y',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','Y'),(2,'Light Bulbs',1,'Y',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(3,'test1',3,'Y',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(4,'test2',3,'Y',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(5,'test3',3,'Y',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(6,'lamp',4,'Y',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','Y'),(7,'lamp',4,'Y',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','Y'),(8,'lamp',4,'Y',1,'euphona','2017-06-08 21:14:07','euphona','2017-06-08 21:25:13','N');
/*!40000 ALTER TABLE `product_sub_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_suboption`
--

DROP TABLE IF EXISTS `product_suboption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_suboption` (
  `product_suboption_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `product_option_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `display_ind` char(1) NOT NULL DEFAULT 'Y',
  `code` varchar(10) NOT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`product_suboption_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_suboption`
--

LOCK TABLES `product_suboption` WRITE;
/*!40000 ALTER TABLE `product_suboption` DISABLE KEYS */;
INSERT INTO `product_suboption` VALUES (10,17,0,'1','1','1',1,'ck1232','2016-11-23 22:02:03','ck1232','2016-11-23 22:02:03','N'),(11,18,0,'1','1','1',1,'ck1232','2016-11-23 22:22:19','ck1232','2016-11-23 22:22:19','N'),(12,19,1,'1','1','1',1,'ck1232','2016-11-25 23:31:34','ck1232','2016-11-25 23:31:34','N'),(13,21,1,'1','1','1',1,'ck1232','2016-11-25 23:28:44','ck1232','2016-11-25 23:28:44','N'),(14,21,1,'2','1','1',1,'ck1232','2016-11-25 23:28:44','ck1232','2016-11-25 23:28:44','N'),(15,22,4,'1','1','1',1,'ck1232','2016-11-25 23:41:34','ck1232','2016-11-25 23:41:34','Y'),(16,22,2,'1','0','1',1,'ck1232','2016-11-25 23:41:34','ck1232','2016-11-25 23:41:34','Y'),(17,22,2,'2','1','1',1,'ck1232','2016-11-25 23:41:34','ck1232','2016-11-25 23:41:34','Y'),(18,22,2,'123','0','1',1,'ck1232','2016-11-25 23:41:34','ck1232','2016-11-25 23:41:34','Y'),(19,22,4,'1','0','1',1,'ck1232','2016-11-25 23:41:34','ck1232','2016-11-25 23:41:34','Y'),(20,22,6,'1','1','1',1,'ck1232','2016-11-25 23:41:34','euphona','2017-02-22 22:15:37','N'),(21,23,6,'Long','1','Long',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(22,23,6,'Short','1','Short',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(23,23,6,'Round','1','Round',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(24,23,6,'Square','1','Square',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(25,23,6,'Rectangle','1','tangle',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(26,23,6,'Pentagon','1','ntagon',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(27,23,25,'white','1','white',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(28,23,25,'red','1','red',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(29,23,25,'yellow','1','yellow',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(30,23,25,'blue','1','blue',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(31,23,25,'green','1','green',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(32,23,25,'pink','1','pink',1,'euphona','2016-11-27 13:34:19','ck1232','2017-02-26 23:21:14','N'),(34,24,25,'Rose gold','1','Rgold',1,'ck1232','2016-12-26 17:17:01','ck1232','2017-02-26 23:20:46','N'),(35,24,25,'Silver','1','Silver',1,'ck1232','2016-12-26 17:17:01','ck1232','2017-02-26 23:20:46','N'),(36,24,25,'Space Grey','1','SGrey',1,'ck1232','2016-12-26 17:17:01','ck1232','2017-02-26 23:20:46','N'),(37,24,25,'Black','1','Black',1,'ck1232','2016-12-26 17:17:01','ck1232','2017-02-26 23:20:46','N'),(41,24,26,'16 gb','1','16gb',1,'ck1232','2016-12-26 17:21:24','ck1232','2017-02-26 23:20:46','N'),(42,24,26,'64 gb','1','64gb',1,'ck1232','2016-12-26 17:21:24','ck1232','2017-02-26 23:20:46','N'),(43,24,26,'128 gb','1','128gb',1,'ck1232','2016-12-26 17:21:24','ck1232','2017-02-26 23:20:46','N'),(44,25,0,'123','1','123',1,'ck1232','2017-02-28 22:29:59','ck1232','2017-02-28 22:29:59','Y'),(45,25,25,'red','1','red',1,'ck1232','2017-02-28 22:39:07','ck1232','2017-02-28 22:54:21','N'),(46,25,25,'blue','1','blue',1,'ck1232','2017-02-28 22:39:07','ck1232','2017-02-28 22:54:21','N'),(47,25,26,'16GB','1','16GB',1,'ck1232','2017-02-28 22:40:48','ck1232','2017-02-28 22:40:48','Y'),(48,25,26,'32GB','1','32GB',1,'ck1232','2017-02-28 22:40:48','ck1232','2017-02-28 22:40:48','Y'),(49,25,26,'1','1','1',1,'ck1232','2017-02-28 22:54:21','ck1232','2017-02-28 22:54:21','N');
/*!40000 ALTER TABLE `product_suboption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_suboption_rs`
--

DROP TABLE IF EXISTS `product_suboption_rs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_suboption_rs` (
  `product_suboption_rs_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `suboption1_id` int(11) DEFAULT NULL,
  `suboption2_id` int(11) DEFAULT NULL,
  `suboption3_id` int(11) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`product_suboption_rs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_suboption_rs`
--

LOCK TABLES `product_suboption_rs` WRITE;
/*!40000 ALTER TABLE `product_suboption_rs` DISABLE KEYS */;
INSERT INTO `product_suboption_rs` VALUES (38,24,35,41,NULL,1,'ck1232','2016-12-26 17:31:28','ck1232','2016-12-26 17:31:28','N'),(39,24,35,42,NULL,1,'ck1232','2016-12-26 17:36:35','ck1232','2016-12-26 17:36:35','N'),(41,22,20,NULL,NULL,1,'euphona','2016-12-30 15:14:39','euphona','2016-12-30 15:14:39','N'),(52,24,34,41,NULL,1,'euphona','2017-02-22 22:14:59','euphona','2017-02-22 22:14:59','N'),(53,24,36,41,NULL,1,'euphona','2017-02-22 22:14:59','euphona','2017-02-22 22:14:59','N'),(54,24,37,41,NULL,1,'euphona','2017-02-22 22:14:59','euphona','2017-02-22 22:14:59','N'),(55,24,34,42,NULL,1,'euphona','2017-02-22 22:14:59','euphona','2017-02-22 22:14:59','N'),(56,24,36,42,NULL,1,'euphona','2017-02-22 22:14:59','euphona','2017-02-22 22:14:59','N'),(57,24,37,42,NULL,1,'euphona','2017-02-22 22:14:59','euphona','2017-02-22 22:14:59','N'),(58,24,34,43,NULL,1,'euphona','2017-02-22 22:14:59','euphona','2017-02-22 22:14:59','N'),(59,24,35,43,NULL,1,'euphona','2017-02-22 22:14:59','euphona','2017-02-22 22:14:59','N'),(60,24,36,43,NULL,1,'euphona','2017-02-22 22:14:59','euphona','2017-02-22 22:14:59','N'),(61,24,37,43,NULL,1,'euphona','2017-02-22 22:14:59','euphona','2017-02-22 22:14:59','N'),(88,23,21,27,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(89,23,22,27,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(90,23,23,27,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(91,23,24,27,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(92,23,25,27,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(93,23,26,27,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(94,23,21,28,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(95,23,22,28,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(96,23,23,28,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(97,23,24,28,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(98,23,25,28,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(99,23,26,28,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(100,23,21,29,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(101,23,22,29,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(102,23,23,29,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(103,23,24,29,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(104,23,25,29,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(105,23,26,29,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(106,23,21,30,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(107,23,22,30,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(108,23,23,30,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(109,23,24,30,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(110,23,25,30,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(111,23,26,30,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(112,23,21,31,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(113,23,22,31,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(114,23,23,31,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(115,23,24,31,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(116,23,25,31,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(117,23,26,31,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(118,23,21,32,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(119,23,22,32,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(120,23,23,32,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(121,23,24,32,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(122,23,25,32,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(123,23,26,32,NULL,1,'ck1232','2017-02-26 23:20:54','ck1232','2017-02-26 23:20:54','N'),(130,25,45,49,NULL,1,'ck1232','2017-02-28 22:54:21','ck1232','2017-02-28 22:54:21','N'),(131,25,46,49,NULL,1,'ck1232','2017-02-28 22:54:21','ck1232','2017-02-28 22:54:21','N');
/*!40000 ALTER TABLE `product_suboption_rs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_tags`
--

DROP TABLE IF EXISTS `product_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_tags` (
  `tags_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `product_id` int(11) NOT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`tags_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_tags`
--

LOCK TABLES `product_tags` WRITE;
/*!40000 ALTER TABLE `product_tags` DISABLE KEYS */;
INSERT INTO `product_tags` VALUES (1,'23',30,1,'ck1232','2016-12-05 12:49:25','ck1232','2016-12-05 12:49:25','N'),(2,'fsd',30,1,'ck1232','2016-12-05 13:06:33','ck1232','2016-12-05 13:06:33','Y'),(3,'testing',30,1,'ck1232','2016-12-05 13:06:33','ck1232','2016-12-05 13:06:33','N'),(4,'iphone',24,1,'ck1232','2016-12-26 17:17:01','ck1232','2016-12-26 17:17:01','N'),(5,'apple',24,1,'ck1232','2016-12-26 17:17:01','ck1232','2016-12-26 17:17:01','N'),(6,'12',25,1,'ck1232','2017-02-28 22:29:59','ck1232','2017-02-28 22:29:59','N');
/*!40000 ALTER TABLE `product_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion` (
  `promotion_id` int(11) NOT NULL AUTO_INCREMENT,
  `promotion_name` varchar(255) NOT NULL,
  `promotion_message` mediumtext,
  `promotion_start_date` datetime DEFAULT NULL,
  `promotion_end_date` datetime DEFAULT NULL,
  `is_active` char(1) NOT NULL DEFAULT 'Y',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`promotion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,'name','message','2016-05-10 00:00:00','2016-12-10 00:00:00','1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(2,'name','message','2016-10-04 00:00:00','2016-10-06 00:00:00','1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(3,'c','k','2016-10-31 00:00:00','2016-10-31 00:00:00','1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(4,'name','message',NULL,NULL,'1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','Y'),(5,'ck','ck','2016-11-09 19:29:00','2016-11-12 22:16:00','1',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(6,'csdfs','c','2016-11-01 05:00:00','2016-11-30 06:00:00','0',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(7,'a','a','2016-11-19 00:00:00','2016-11-19 23:59:00','1',1,'euphona','2016-11-19 00:18:40','euphona','2016-11-19 00:18:40','N');
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(2,'MODULE_MGR',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(5,'ROLE_ADMIN',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(6,'PRODUCT_MGR',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(7,'PROMOTION_MGR',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `standardtemplate`
--

DROP TABLE IF EXISTS `standardtemplate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `standardtemplate` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(255) NOT NULL,
  `icon` varchar(45) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standardtemplate`
--

LOCK TABLES `standardtemplate` WRITE;
/*!40000 ALTER TABLE `standardtemplate` DISABLE KEYS */;
/*!40000 ALTER TABLE `standardtemplate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage_location`
--

DROP TABLE IF EXISTS `storage_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage_location` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `postal_code` int(8) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage_location`
--

LOCK TABLES `storage_location` WRITE;
/*!40000 ALTER TABLE `storage_location` DISABLE KEYS */;
INSERT INTO `storage_location` VALUES (1,'Warehouse 1','Tampines',123456,1,'euphona','2016-12-05 23:08:35','euphona','2016-12-05 23:08:35','N'),(2,'Warehouse 2','Bedok',234567,1,'euphona','2016-12-05 23:08:35','euphona','2016-12-05 23:08:35','N'),(3,'Warehouse 3','Queenstown',345678,1,'euphona','2016-12-05 23:08:35','euphona','2016-12-05 23:08:35','N');
/*!40000 ALTER TABLE `storage_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submodule`
--

DROP TABLE IF EXISTS `submodule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submodule` (
  `submodule_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `icon` varchar(45) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`submodule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodule`
--

LOCK TABLES `submodule` WRITE;
/*!40000 ALTER TABLE `submodule` DISABLE KEYS */;
INSERT INTO `submodule` VALUES (1,1,'User Management','fa-users','admin/listUser',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(2,1,'Module Management','fa-users','admin/listModule',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(21,1,'Role Management','fa-users','admin/listRole',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(22,1,'Permission Management','fa-users','admin/listPermission',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(24,5,'Category Management','fa-users','product/category/listProductCategory',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(26,5,'Product Management','fa-users','product/product/listProduct',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(28,6,'Promotion Management','fa-users','product/promotion/listPromotion',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(29,6,'Discount Management','fa-users','product/discount/listDiscount',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(30,5,'Product Option Management','fa-users','product/option/listProductOption',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(31,7,'Customer Management','fa-users','customer/listCustomer',1,'euphona','2016-11-15 21:24:32','euphona','2016-11-15 21:24:32','N'),(32,8,'Batch Management','fa-users','/batchintake/listBatchIntake',1,'euphona','2016-11-26 20:12:21','euphona','2016-11-26 20:12:21','N'),(33,9,'Inventory Management','fa-users','/inventory/listInventoryProduct',1,'euphona','2017-01-05 21:17:37','euphona','2017-01-05 21:17:56','N'),(34,9,'Inventory History Management','fa-users','inventoryhistory/listInventoryHistory',1,'euphona','2017-01-20 22:17:50','euphona','2017-01-21 08:30:20','N'),(35,10,'Demo Management','fa-users','/demo/listProduct',1,'euphona','2017-02-25 16:40:36','euphona','2017-02-25 16:40:36','N'),(36,11,'Invoice Management','fa-users','invoice/listInvoice',1,'euphona','2017-02-27 10:32:34','euphona','2017-02-27 10:32:34','N'),(37,12,'Expense Management','fa-users','expense/listExpense',1,'euphona','2017-03-05 15:48:12','euphona','2017-03-05 15:48:12','N'),(38,13,'Salary & Bonus Management','fa-users','salarybonus/listSalaryBonus',1,'euphona','2017-03-11 10:53:23','euphona','2017-03-11 22:42:52','N'),(39,14,'Employee Management','fa-users','employee/listEmployee',1,'euphona','2017-03-12 17:45:08','euphona','2017-03-12 17:45:08','N'),(40,15,'Cheque Management','fa-users','cheque/listCheque',1,'euphona','2017-04-05 21:46:51','euphona','2017-04-05 21:46:51','N'),(41,16,'Report Management','fa-users','report/viewReportGen',1,'euphona','2017-04-07 21:59:50','euphona','2017-04-07 21:59:50','N');
/*!40000 ALTER TABLE `submodule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submodule_permission`
--

DROP TABLE IF EXISTS `submodule_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submodule_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `submodule_id` int(11) NOT NULL,
  `permission_type_id` int(11) NOT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodule_permission`
--

LOCK TABLES `submodule_permission` WRITE;
/*!40000 ALTER TABLE `submodule_permission` DISABLE KEYS */;
INSERT INTO `submodule_permission` VALUES (1,1,1,14,1,'euphona','2016-11-12 21:47:51','euphona','2016-11-12 21:47:51','N'),(2,1,2,11,1,'euphona','2016-11-12 21:49:07','euphona','2016-11-12 21:49:07','N'),(3,1,21,13,1,'euphona','2016-11-12 21:49:19','euphona','2016-11-12 21:49:19','N'),(4,1,22,12,1,'euphona','2016-11-12 21:49:19','euphona','2016-11-12 21:49:19','N'),(5,1,24,16,1,'euphona','2016-11-12 21:49:19','euphona','2016-11-12 21:49:19','N'),(6,1,26,20,1,'euphona','2016-11-12 21:49:19','euphona','2016-11-12 21:49:19','N'),(7,1,28,23,1,'euphona','2016-11-12 21:49:19','euphona','2016-11-12 21:49:19','N'),(8,1,29,24,1,'euphona','2016-11-12 21:49:19','euphona','2016-11-12 21:49:19','N'),(9,1,30,25,1,'euphona','2016-11-12 21:49:19','euphona','2016-11-12 21:49:19','N'),(10,1,31,26,1,'euphona','2016-11-15 21:25:31','euphona','2016-11-15 21:25:31','N'),(11,1,32,27,1,'euphona','2016-11-26 20:13:09','euphona','2016-11-26 20:13:09','N'),(12,1,33,28,1,'euphona','2017-01-05 21:51:50','euphona','2017-01-05 21:51:50','N'),(13,1,34,29,1,'euphona','2017-01-20 22:18:29','euphona','2017-01-20 22:18:29','N'),(14,1,35,30,1,'euphona','2017-02-25 16:41:21','euphona','2017-02-25 16:41:21','N'),(15,1,36,31,1,'euphona','2017-02-27 10:33:01','euphona','2017-02-27 10:33:01','N'),(16,1,37,32,1,'euphona','2017-03-05 15:48:45','euphona','2017-03-05 15:48:45','N'),(17,1,38,33,1,'euphona','2017-03-11 10:53:23','euphona','2017-03-11 10:53:23','N'),(18,1,39,34,1,'euphona','2017-03-12 17:45:40','euphona','2017-03-12 17:45:40','N'),(19,5,1,14,1,'euphona','2016-11-12 22:55:59','euphona','2016-11-12 22:55:59','N'),(20,5,32,27,1,'euphona','2016-11-26 20:13:15','euphona','2016-11-26 20:13:15','N'),(21,6,1,14,1,'euphona','2017-03-11 10:53:23','euphona','2017-03-11 10:53:23','N'),(22,1,40,36,1,'euphona','2017-04-05 21:47:40','euphona','2017-04-05 21:47:40','N'),(23,1,41,37,1,'euphona','2017-04-07 22:00:38','euphona','2017-04-07 22:00:38','N');
/*!40000 ALTER TABLE `submodule_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submodule_permission_type`
--

DROP TABLE IF EXISTS `submodule_permission_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submodule_permission_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `submodule_id` int(11) NOT NULL,
  `permission_type` varchar(45) DEFAULT NULL,
  `seq_num` int(2) NOT NULL DEFAULT '1',
  `url` varchar(255) NOT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodule_permission_type`
--

LOCK TABLES `submodule_permission_type` WRITE;
/*!40000 ALTER TABLE `submodule_permission_type` DISABLE KEYS */;
INSERT INTO `submodule_permission_type` VALUES (11,2,'View',1,'/admin/listModule',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(12,22,'View',1,'/admin/listPermission',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(13,21,'View',1,'/admin/listRole',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(14,1,'View',1,'/admin/listUser',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(16,24,'View',1,'/product/category/listProductCategory',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(20,26,'View',1,'product/product/listProduct',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(23,28,'View',1,'/product/promotion/listPromotion',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(24,29,'View',1,'/product/discount/listDiscount',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(25,30,'View',1,'/product/option/listProductOption',0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(26,31,'View',1,'/customer/listCustomer',1,'euphona','2016-11-15 21:25:16','euphona','2016-11-15 21:25:16','N'),(27,32,'View',1,'/batchintake/listBatchIntake',1,'euphona','2016-11-26 20:12:48','euphona','2016-11-26 20:12:48','N'),(28,33,'View',1,'/inventory/listInventoryProduct',1,'euphona','2017-01-05 21:25:26','euphona','2017-01-05 21:25:26','N'),(29,34,'View',1,'inventory/listInventoryHistory',1,'euphona','2017-01-20 22:18:15','euphona','2017-01-20 22:18:15','N'),(30,35,'View',1,'/demo/listProduct',1,'euphona','2017-02-25 16:41:06','euphona','2017-02-25 16:41:06','N'),(31,36,'View',1,'invoice/listInvoice',1,'euphona','2017-02-27 10:32:49','euphona','2017-02-27 10:32:49','N'),(32,37,'View',1,'expense/listExpense',1,'euphona','2017-03-05 15:48:29','euphona','2017-03-05 15:48:29','N'),(33,38,'View',1,'salarybonus/listSalaryBonus',1,'euphona','2017-03-11 10:53:23','euphona','2017-03-11 10:53:23','N'),(34,39,'View',1,'employee/listEmployee',1,'euphona','2017-03-12 17:45:27','euphona','2017-03-12 17:45:27','N'),(35,32,'test',1,'test',1,'euphona','2017-04-03 21:59:14','euphona','2017-04-03 21:59:14','Y'),(36,40,'View',1,'cheque/listCheque',1,'euphona','2017-04-05 21:47:18','euphona','2017-04-05 21:47:18','N'),(37,41,'View',1,'report/viewReportGen',1,'euphona','2017-04-07 22:00:08','euphona','2017-04-07 22:00:08','N');
/*!40000 ALTER TABLE `submodule_permission_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `transaction_id` varchar(50) NOT NULL,
  `time_stamp` datetime DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `payer` varchar(1024) DEFAULT NULL,
  `payer_name` varchar(512) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `gross_amt` decimal(8,2) DEFAULT NULL,
  `fee_amt` decimal(8,2) DEFAULT NULL,
  `net_amt` decimal(8,2) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_coupon_detail`
--

DROP TABLE IF EXISTS `transaction_coupon_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_coupon_detail` (
  `transaction_id` varchar(50) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id` varchar(255) DEFAULT NULL,
  `amt` decimal(6,2) DEFAULT NULL,
  `amt_currency` varchar(255) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`transaction_id`),
  CONSTRAINT `transaction_coupon_detail_id_fk` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_coupon_detail`
--

LOCK TABLES `transaction_coupon_detail` WRITE;
/*!40000 ALTER TABLE `transaction_coupon_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_coupon_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_detail`
--

DROP TABLE IF EXISTS `transaction_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_detail` (
  `transaction_id` varchar(50) NOT NULL,
  `tpl_reference_id` varchar(255) DEFAULT NULL,
  `gift_message` varchar(512) DEFAULT NULL,
  `gift_receipt` varchar(255) DEFAULT NULL,
  `gift_wrap_name` varchar(255) DEFAULT NULL,
  `buyer_email_opt_in` varchar(255) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`transaction_id`),
  CONSTRAINT `transaction_detail_id_fk` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_detail`
--

LOCK TABLES `transaction_detail` WRITE;
/*!40000 ALTER TABLE `transaction_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_payer_address`
--

DROP TABLE IF EXISTS `transaction_payer_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_payer_address` (
  `transaction_id` varchar(255) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `name` varchar(512) DEFAULT NULL,
  `street1` varchar(300) DEFAULT NULL,
  `street2` varchar(300) DEFAULT NULL,
  `city_name` varchar(120) DEFAULT NULL,
  `state_or_province` varchar(120) DEFAULT NULL,
  `country` varchar(2) DEFAULT NULL,
  `country_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `postal_code` varchar(45) DEFAULT NULL,
  `address_id` varchar(255) DEFAULT NULL,
  `address_owner` varchar(50) DEFAULT NULL,
  `external_address_id` varchar(255) DEFAULT NULL,
  `address_status` varchar(45) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`transaction_id`),
  CONSTRAINT `transaction_payer_address_id_fk` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_payer_address`
--

LOCK TABLES `transaction_payer_address` WRITE;
/*!40000 ALTER TABLE `transaction_payer_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_payer_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_payer_info`
--

DROP TABLE IF EXISTS `transaction_payer_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_payer_info` (
  `transaction_id` varchar(255) NOT NULL,
  `payer` varchar(255) DEFAULT NULL,
  `payer_id` varchar(50) DEFAULT NULL,
  `payer_status` varchar(45) DEFAULT NULL,
  `payer_name` varchar(512) DEFAULT NULL,
  `payer_country` varchar(45) DEFAULT NULL,
  `payer_business` varchar(255) DEFAULT NULL,
  `contact_phone` varchar(255) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`transaction_id`),
  CONSTRAINT `transaction_payer_info_id_fk` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_payer_info`
--

LOCK TABLES `transaction_payer_info` WRITE;
/*!40000 ALTER TABLE `transaction_payer_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_payer_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_payment_info`
--

DROP TABLE IF EXISTS `transaction_payment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_payment_info` (
  `transaction_id` varchar(50) NOT NULL,
  `ebay_transaction_id` varchar(255) DEFAULT NULL,
  `parent_transaction_id` varchar(50) DEFAULT NULL,
  `receipt_id` varchar(45) DEFAULT NULL,
  `transaction_type` varchar(45) DEFAULT NULL,
  `payment_type` varchar(45) DEFAULT NULL,
  `refund_source_code_type` varchar(45) DEFAULT NULL,
  `expectede_check_clear_date` varchar(100) DEFAULT NULL,
  `payment_date` varchar(100) DEFAULT NULL,
  `gross_amt` decimal(6,2) DEFAULT NULL,
  `fee_amt` decimal(6,2) DEFAULT NULL,
  `financing_fee_amt` decimal(6,2) DEFAULT NULL,
  `financing_total_cost` decimal(6,2) DEFAULT NULL,
  `financing_monthly_payment` decimal(6,2) DEFAULT NULL,
  `is_financing` varchar(10) DEFAULT NULL,
  `settle_amt` decimal(6,2) DEFAULT NULL,
  `tax_amt` decimal(6,2) DEFAULT NULL,
  `exchange_rate` varchar(45) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `invoice_id` varchar(255) DEFAULT NULL,
  `custom` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `sales_tax` varchar(255) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`transaction_id`),
  CONSTRAINT `transaction_payment_info_id_fk` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_payment_info`
--

LOCK TABLES `transaction_payment_info` WRITE;
/*!40000 ALTER TABLE `transaction_payment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_payment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_payment_info_option`
--

DROP TABLE IF EXISTS `transaction_payment_info_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_payment_info_option` (
  `transaction_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `option_name` varchar(255) DEFAULT NULL,
  `option_value` varchar(255) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`transaction_id`,`name`),
  CONSTRAINT `transaction_payment_info_option_id_fk` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_payment_info_option`
--

LOCK TABLES `transaction_payment_info_option` WRITE;
/*!40000 ALTER TABLE `transaction_payment_info_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_payment_info_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_payment_item`
--

DROP TABLE IF EXISTS `transaction_payment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_payment_item` (
  `transaction_id` varchar(255) NOT NULL,
  `ebay_item_txn_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `shipping_amt` decimal(6,2) DEFAULT NULL,
  `handling_amt` decimal(6,2) DEFAULT NULL,
  `coupon_id` varchar(255) DEFAULT NULL,
  `coupon_amt` decimal(6,2) DEFAULT NULL,
  `coupon_amt_currency` varchar(255) DEFAULT NULL,
  `amt` decimal(8,2) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`transaction_id`),
  CONSTRAINT `transaction_payment_item_id_fk` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_payment_item`
--

LOCK TABLES `transaction_payment_item` WRITE;
/*!40000 ALTER TABLE `transaction_payment_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_payment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_shipping_option`
--

DROP TABLE IF EXISTS `transaction_shipping_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_shipping_option` (
  `transaction_id` varchar(255) NOT NULL,
  `shipping_calculation_mode` varchar(255) DEFAULT NULL,
  `insurance_option_selected` varchar(255) DEFAULT NULL,
  `shipping_option_is_default` varchar(255) DEFAULT NULL,
  `shipping_option_amt` decimal(6,2) DEFAULT NULL,
  `shipping_option_name` varchar(512) DEFAULT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`transaction_id`),
  CONSTRAINT `transaction_shipping_option_id_fk` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_shipping_option`
--

LOCK TABLES `transaction_shipping_option` WRITE;
/*!40000 ALTER TABLE `transaction_shipping_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_shipping_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `enabled` char(1) NOT NULL DEFAULT 'Y',
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ck1232','$2a$10$fF7SimwO74sU2hSa8u0/u.s5tYGbPMorm6i17w2zdIcbb7mURlb6G',NULL,'choon keat','ck1232@hotmail.com',NULL,'Y',0,'euphona','0000-00-00 00:00:00','euphona','0000-00-00 00:00:00','N'),(2,'euphona','$2a$10$bbH4SEDcWxKoOFuu8RKi0ec1V20XR7UtiaoEpnesBVtuaT3SvX7gm',NULL,'Janice Lee','euphona@hotmail.com',NULL,'Y',0,'euphona','0000-00-00 00:00:00','euphona','0000-00-00 00:00:00','N'),(8,'ck','$2a$10$Z8IgSbjs2yFNdc5GbuVa8.DQbALA5CnPfdO6vFkCHobwxNaTNsdXe',NULL,'ck','ck@hotmail.com',NULL,'Y',0,'euphona','2016-11-12 23:25:20','euphona','2016-11-12 23:25:20','Y');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1,1,'euphona','2017-03-12 12:33:13','euphona','2017-03-12 12:33:13','N'),(2,5,1,1,'euphona','2017-03-12 12:33:13','euphona','2017-03-12 12:33:13','N'),(3,1,2,0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(4,2,2,0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(5,5,2,0,'','0000-00-00 00:00:00','','0000-00-00 00:00:00','N'),(6,5,8,1,'euphona','2016-11-14 00:34:58','euphona','2016-11-14 00:34:58','N');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_item_code`
--

DROP TABLE IF EXISTS `view_item_code`;
/*!50001 DROP VIEW IF EXISTS `view_item_code`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_item_code` AS SELECT 
 1 AS `product_suboption_rs_id`,
 1 AS `product_id`,
 1 AS `product_name`,
 1 AS `suboption1_name`,
 1 AS `suboption1_id`,
 1 AS `suboption2_name`,
 1 AS `suboption2_id`,
 1 AS `suboption3_name`,
 1 AS `suboption3_id`,
 1 AS `item_code`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_latest_transaction`
--

DROP TABLE IF EXISTS `view_latest_transaction`;
/*!50001 DROP VIEW IF EXISTS `view_latest_transaction`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_latest_transaction` AS SELECT 
 1 AS `transaction_id`,
 1 AS `time_stamp`,
 1 AS `type`,
 1 AS `payer`,
 1 AS `payer_name`,
 1 AS `status`,
 1 AS `gross_amt`,
 1 AS `feea_amt`,
 1 AS `net_amt`,
 1 AS `created_on`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_product_inventory`
--

DROP TABLE IF EXISTS `view_product_inventory`;
/*!50001 DROP VIEW IF EXISTS `view_product_inventory`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_product_inventory` AS SELECT 
 1 AS `product_id`,
 1 AS `product_name`,
 1 AS `qty`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_product_inventory_location`
--

DROP TABLE IF EXISTS `view_product_inventory_location`;
/*!50001 DROP VIEW IF EXISTS `view_product_inventory_location`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_product_inventory_location` AS SELECT 
 1 AS `location_id`,
 1 AS `location`,
 1 AS `product_id`,
 1 AS `product_name`,
 1 AS `suboption1_name`,
 1 AS `suboption1_id`,
 1 AS `suboption2_name`,
 1 AS `subOption2_id`,
 1 AS `suboption3_name`,
 1 AS `subOption3_id`,
 1 AS `qty`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_product_suboption_inventory`
--

DROP TABLE IF EXISTS `view_product_suboption_inventory`;
/*!50001 DROP VIEW IF EXISTS `view_product_suboption_inventory`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_product_suboption_inventory` AS SELECT 
 1 AS `product_id`,
 1 AS `product_name`,
 1 AS `suboption1_name`,
 1 AS `suboption1_id`,
 1 AS `suboption2_name`,
 1 AS `suboption2_id`,
 1 AS `suboption3_name`,
 1 AS `suboption3_id`,
 1 AS `qty`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `inventory_from`
--

/*!50001 DROP VIEW IF EXISTS `inventory_from`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `inventory_from` AS select `inv`.`product_suboption_rs_id` AS `product_suboption_rs_id`,`inv`.`transfer_from` AS `transfer_from`,sum((case `inv`.`plus_or_minus` when 0x00 then (`inv`.`qty` * -(1)) when 0x01 then 0 end)) AS `qty` from `product_inventory` `inv` where ((`inv`.`delete_ind` = 'N') and (`inv`.`transfer_from` is not null)) group by `inv`.`product_suboption_rs_id`,`inv`.`transfer_from` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `inventory_location_final_qty`
--

/*!50001 DROP VIEW IF EXISTS `inventory_location_final_qty`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `inventory_location_final_qty` AS select `inventory_location_qty`.`product_suboption_rs_id` AS `product_suboption_rs_id`,`inventory_location_qty`.`location_id` AS `location_id`,(`inventory_location_qty`.`to_qty` + `inventory_location_qty`.`from_qty`) AS `qty` from `inventory_location_qty` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `inventory_location_qty`
--

/*!50001 DROP VIEW IF EXISTS `inventory_location_qty`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `inventory_location_qty` AS select `invto`.`product_suboption_rs_id` AS `product_suboption_rs_id`,`invto`.`transfer_to` AS `location_id`,ifnull(`invto`.`qty`,0) AS `to_qty`,ifnull(`invfrom`.`qty`,0) AS `from_qty` from (`inventory_to` `invto` left join `inventory_from` `invfrom` on(((`invto`.`product_suboption_rs_id` = `invfrom`.`product_suboption_rs_id`) and (`invto`.`transfer_to` = `invfrom`.`transfer_from`)))) union select `invfrom`.`product_suboption_rs_id` AS `product_suboption_rs_id`,`invfrom`.`transfer_from` AS `locationId`,ifnull(`invto`.`qty`,0) AS `to_qty`,ifnull(`invfrom`.`qty`,0) AS `from_qty` from (`inventory_from` `invfrom` left join `inventory_to` `invto` on(((`invto`.`product_suboption_rs_id` = `invfrom`.`product_suboption_rs_id`) and (`invto`.`transfer_to` = `invfrom`.`transfer_from`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `inventory_to`
--

/*!50001 DROP VIEW IF EXISTS `inventory_to`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `inventory_to` AS select `inv`.`product_suboption_rs_id` AS `product_suboption_rs_id`,`inv`.`transfer_to` AS `transfer_to`,sum((case `inv`.`plus_or_minus` when 0x00 then 0 when 0x01 then (`inv`.`qty` * 1) end)) AS `qty` from `product_inventory` `inv` where ((`inv`.`delete_ind` = 'N') and (`inv`.`transfer_to` is not null)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_item_code`
--

/*!50001 DROP VIEW IF EXISTS `view_item_code`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_item_code` AS select `rs`.`product_suboption_rs_id` AS `product_suboption_rs_id`,`rs`.`product_id` AS `product_id`,`p`.`product_name` AS `product_name`,`sopt1`.`name` AS `suboption1_name`,`rs`.`suboption1_id` AS `suboption1_id`,`sopt2`.`name` AS `suboption2_name`,`rs`.`suboption2_id` AS `suboption2_id`,`sopt3`.`name` AS `suboption3_name`,`rs`.`suboption3_id` AS `suboption3_id`,concat(`p`.`product_code`,(case when (`sopt1`.`name` is not null) then concat('-',`sopt1`.`code`) else '' end),(case when (`sopt2`.`name` is not null) then concat('-',`sopt2`.`code`) else '' end),(case when (`sopt3`.`name` is not null) then concat('-',`sopt3`.`code`) else '' end)) AS `item_code` from ((((`product_suboption_rs` `rs` join `product` `p` on((`rs`.`product_id` = `p`.`product_id`))) left join `product_suboption` `sopt1` on((`rs`.`suboption1_id` = `sopt1`.`product_suboption_id`))) left join `product_suboption` `sopt2` on((`rs`.`suboption2_id` = `sopt2`.`product_suboption_id`))) left join `product_suboption` `sopt3` on((`rs`.`suboption3_id` = `sopt3`.`product_suboption_id`))) where (`rs`.`delete_ind` = 'N') group by `rs`.`product_suboption_rs_id`,`rs`.`product_id`,`p`.`product_name`,`rs`.`suboption1_id`,`rs`.`suboption2_id`,`rs`.`suboption3_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_latest_transaction`
--

/*!50001 DROP VIEW IF EXISTS `view_latest_transaction`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_latest_transaction` AS select `transaction`.`transaction_id` AS `transaction_id`,`transaction`.`time_stamp` AS `time_stamp`,`transaction`.`type` AS `type`,`transaction`.`payer` AS `payer`,`transaction`.`payer_name` AS `payer_name`,`transaction`.`status` AS `status`,`transaction`.`gross_amt` AS `gross_amt`,`transaction`.`fee_amt` AS `feea_amt`,`transaction`.`net_amt` AS `net_amt`,`transaction`.`created_on` AS `created_on` from `transaction` order by `transaction`.`time_stamp` desc limit 1 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_product_inventory`
--

/*!50001 DROP VIEW IF EXISTS `view_product_inventory`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_product_inventory` AS select `rs`.`product_id` AS `product_id`,`prd`.`product_name` AS `product_name`,sum(`final_qty`.`qty`) AS `qty` from ((`inventory_location_final_qty` `final_qty` join `product_suboption_rs` `rs` on((`rs`.`product_suboption_rs_id` = `final_qty`.`product_suboption_rs_id`))) join `product` `prd` on((`rs`.`product_id` = `prd`.`product_id`))) where (`final_qty`.`location_id` > 0) group by `rs`.`product_id`,`prd`.`product_name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_product_inventory_location`
--

/*!50001 DROP VIEW IF EXISTS `view_product_inventory_location`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_product_inventory_location` AS select `final_qty`.`location_id` AS `location_id`,`loc`.`name` AS `location`,`rs`.`product_id` AS `product_id`,`prd`.`product_name` AS `product_name`,`sopt1`.`name` AS `suboption1_name`,`rs`.`suboption1_id` AS `suboption1_id`,`sopt2`.`name` AS `suboption2_name`,`rs`.`suboption2_id` AS `subOption2_id`,`sopt3`.`name` AS `suboption3_name`,`rs`.`suboption3_id` AS `subOption3_id`,sum(`final_qty`.`qty`) AS `qty` from ((((((`inventory_location_final_qty` `final_qty` join `product_suboption_rs` `rs` on((`rs`.`product_suboption_rs_id` = `final_qty`.`product_suboption_rs_id`))) join `product` `prd` on((`rs`.`product_id` = `prd`.`product_id`))) left join `product_suboption` `sopt1` on((`sopt1`.`product_suboption_id` = `rs`.`suboption1_id`))) left join `product_suboption` `sopt2` on((`sopt2`.`product_suboption_id` = `rs`.`suboption2_id`))) left join `product_suboption` `sopt3` on((`sopt3`.`product_suboption_id` = `rs`.`suboption3_id`))) left join `storage_location` `loc` on((`final_qty`.`location_id` = `loc`.`location_id`))) where (`final_qty`.`location_id` > 0) group by `rs`.`product_id`,`prd`.`product_name`,`rs`.`suboption1_id`,`rs`.`suboption2_id`,`rs`.`suboption3_id`,`final_qty`.`location_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_product_suboption_inventory`
--

/*!50001 DROP VIEW IF EXISTS `view_product_suboption_inventory`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_product_suboption_inventory` AS select `rs`.`product_id` AS `product_id`,`prd`.`product_name` AS `product_name`,`sopt1`.`name` AS `suboption1_name`,`rs`.`suboption1_id` AS `suboption1_id`,`sopt2`.`name` AS `suboption2_name`,`rs`.`suboption2_id` AS `suboption2_id`,`sopt3`.`name` AS `suboption3_name`,`rs`.`suboption3_id` AS `suboption3_id`,sum(`final_qty`.`qty`) AS `qty` from (((((`inventory_location_final_qty` `final_qty` join `product_suboption_rs` `rs` on((`rs`.`product_suboption_rs_id` = `final_qty`.`product_suboption_rs_id`))) join `product` `prd` on((`rs`.`product_id` = `prd`.`product_id`))) left join `product_suboption` `sopt1` on((`sopt1`.`product_suboption_id` = `rs`.`suboption1_id`))) left join `product_suboption` `sopt2` on((`sopt2`.`product_suboption_id` = `rs`.`suboption2_id`))) left join `product_suboption` `sopt3` on((`sopt3`.`product_suboption_id` = `rs`.`suboption3_id`))) where (`final_qty`.`location_id` > 0) group by `rs`.`product_id`,`prd`.`product_name`,`rs`.`suboption1_id`,`rs`.`suboption2_id`,`rs`.`suboption3_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-10 22:43:06
