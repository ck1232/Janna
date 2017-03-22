-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: jj2
-- ------------------------------------------------------
-- Server version	5.6.21

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_product_rs`
--

LOCK TABLES `batch_product_rs` WRITE;
/*!40000 ALTER TABLE `batch_product_rs` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_stock_intake`
--

LOCK TABLES `batch_stock_intake` WRITE;
/*!40000 ALTER TABLE `batch_stock_intake` DISABLE KEYS */;
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
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`cheque_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheque`
--

LOCK TABLES `cheque` WRITE;
/*!40000 ALTER TABLE `cheque` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
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
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_address`
--

LOCK TABLES `customer_address` WRITE;
/*!40000 ALTER TABLE `customer_address` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
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
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_bonus`
--

LOCK TABLES `employee_bonus` WRITE;
/*!40000 ALTER TABLE `employee_bonus` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_bonus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_salary`
--

DROP TABLE IF EXISTS `employee_salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_salary` (
  `employee_id` int(11) NOT NULL,
  `basic_salary_amt` decimal(8,2) NOT NULL DEFAULT '0.00',
  `over_time_amt` decimal(6,2) DEFAULT NULL,
  `over_time_hours` decimal(6,2) DEFAULT NULL,
  `over_time_remarks` varchar(512) DEFAULT NULL,
  `allowance` decimal(6,2) DEFAULT NULL,
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
  `salary_id` int(11) NOT NULL AUTO_INCREMENT,
  `salary_date` date NOT NULL,
  PRIMARY KEY (`salary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_salary`
--

LOCK TABLES `employee_salary` WRITE;
/*!40000 ALTER TABLE `employee_salary` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense`
--

LOCK TABLES `expense` WRITE;
/*!40000 ALTER TABLE `expense` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_type`
--

LOCK TABLES `expense_type` WRITE;
/*!40000 ALTER TABLE `expense_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `expense_type` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_detail`
--

DROP TABLE IF EXISTS `payment_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_detail` (
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  `payment_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_date` date NOT NULL,
  `payment_mode` int(11) NOT NULL,
  `payment_amt` decimal(8,2) NOT NULL DEFAULT '0.00',
  `cheque_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`payment_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_detail`
--

LOCK TABLES `payment_detail` WRITE;
/*!40000 ALTER TABLE `payment_detail` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_rs`
--

LOCK TABLES `payment_rs` WRITE;
/*!40000 ALTER TABLE `payment_rs` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
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
  `product_image_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`product_image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
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
  `product_suboption_id` int(11) DEFAULT NULL,
  `transfer_from` int(11) DEFAULT NULL,
  `transfer_to` int(11) DEFAULT NULL,
  `plus_or_minus` bit(1) NOT NULL DEFAULT b'1',
  `qty` int(6) NOT NULL DEFAULT '0',
  `remarks` varchar(255) DEFAULT NULL,
  `unit_amt` decimal(8,2) DEFAULT NULL,
  `mode` varchar(255) DEFAULT NULL,
  `reference_id` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`product_inventory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_inventory`
--

LOCK TABLES `product_inventory` WRITE;
/*!40000 ALTER TABLE `product_inventory` DISABLE KEYS */;
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
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`product_option_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_option`
--

LOCK TABLES `product_option` WRITE;
/*!40000 ALTER TABLE `product_option` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_specification`
--

LOCK TABLES `product_specification` WRITE;
/*!40000 ALTER TABLE `product_specification` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_sub_category`
--

LOCK TABLES `product_sub_category` WRITE;
/*!40000 ALTER TABLE `product_sub_category` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_suboption`
--

LOCK TABLES `product_suboption` WRITE;
/*!40000 ALTER TABLE `product_suboption` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_suboption_rs`
--

LOCK TABLES `product_suboption_rs` WRITE;
/*!40000 ALTER TABLE `product_suboption_rs` DISABLE KEYS */;
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
  `product_id` varchar(45) NOT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`tags_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_tags`
--

LOCK TABLES `product_tags` WRITE;
/*!40000 ALTER TABLE `product_tags` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage_location`
--

LOCK TABLES `storage_location` WRITE;
/*!40000 ALTER TABLE `storage_location` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodule`
--

LOCK TABLES `submodule` WRITE;
/*!40000 ALTER TABLE `submodule` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodule_permission`
--

LOCK TABLES `submodule_permission` WRITE;
/*!40000 ALTER TABLE `submodule_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `submodule_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submodule_persmission_type`
--

DROP TABLE IF EXISTS `submodule_persmission_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submodule_persmission_type` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodule_persmission_type`
--

LOCK TABLES `submodule_persmission_type` WRITE;
/*!40000 ALTER TABLE `submodule_persmission_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `submodule_persmission_type` ENABLE KEYS */;
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
  PRIMARY KEY (`transaction_id`)
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
  PRIMARY KEY (`transaction_id`)
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
  PRIMARY KEY (`transaction_id`)
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
  PRIMARY KEY (`transaction_id`)
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
  PRIMARY KEY (`transaction_id`)
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
  PRIMARY KEY (`transaction_id`,`name`)
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
  PRIMARY KEY (`transaction_id`)
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
  PRIMARY KEY (`transaction_id`)
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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
  `user_id` varchar(45) NOT NULL,
  `version` int(5) NOT NULL DEFAULT '1',
  `created_by` varchar(255) NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(255) NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_ind` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'jj2'
--

--
-- Dumping routines for database 'jj2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-18 22:00:00
