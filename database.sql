CREATE DATABASE  IF NOT EXISTS `janna` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `janna`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: janna
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.9-MariaDB

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
-- Table structure for table `acccust`
--

DROP TABLE IF EXISTS `acccust`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acccust` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `birthday` date DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `version` tinyint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acccust`
--

LOCK TABLES `acccust` WRITE;
/*!40000 ALTER TABLE `acccust` DISABLE KEYS */;
/*!40000 ALTER TABLE `acccust` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custtype` enum('acccust','nonacccust') NOT NULL DEFAULT 'nonacccust',
  `custid` int(11) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  `countryid` int(11) NOT NULL,
  `postalcode` int(11) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `defaultind` bit(1) DEFAULT NULL,
  `deleteind` bit(1) DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `version` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adminmodule`
--

DROP TABLE IF EXISTS `adminmodule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminmodule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `folder` bit(1) DEFAULT NULL,
  `display` bit(1) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminmodule`
--

LOCK TABLES `adminmodule` WRITE;
/*!40000 ALTER TABLE `adminmodule` DISABLE KEYS */;
INSERT INTO `adminmodule` VALUES (1,'Root','fa-book','','\0',NULL,'/',NULL,NULL,NULL,NULL,0),(2,'Admin Control','fa-book','','',1,'/admin',NULL,NULL,NULL,NULL,0),(3,'Admin Management','fa-book','\0','',2,'/admin/user/manage',NULL,NULL,NULL,NULL,0),(4,'Role Management','fa-book','\0','',2,'/admin/role/manage',NULL,NULL,NULL,NULL,0),(5,'Module Management','fa-book','\0','',2,'/admin/module/manage',NULL,NULL,NULL,NULL,0),(6,'Customer','fa-book','','',1,'/customer','2016-03-06 15:00:10','ck1232','2016-03-06 15:00:10','ck1232',1),(7,'Customer Management','fa-book','\0','',6,'/customer/manage','2016-03-06 15:00:48','ck1232','2016-03-06 15:00:48','ck1232',1);
/*!40000 ALTER TABLE `adminmodule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditlog`
--

DROP TABLE IF EXISTS `auditlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auditlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event` varchar(50) DEFAULT NULL,
  `entity` varchar(255) DEFAULT NULL,
  `details` varchar(20000) DEFAULT NULL,
  `triggeredon` datetime DEFAULT NULL,
  `triggeredby` varchar(50) DEFAULT NULL,
  `triggeredclientip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditlog`
--

LOCK TABLES `auditlog` WRITE;
/*!40000 ALTER TABLE `auditlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `parentid` int(11) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
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
-- Table structure for table `changelog`
--

DROP TABLE IF EXISTS `changelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `changelog` (
  `change_number` bigint(20) NOT NULL,
  `delta_set` varchar(10) DEFAULT NULL,
  `start_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `complete_dt` datetime DEFAULT NULL,
  `applied_by` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`change_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `changelog`
--

LOCK TABLES `changelog` WRITE;
/*!40000 ALTER TABLE `changelog` DISABLE KEYS */;
/*!40000 ALTER TABLE `changelog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `code` varchar(10) DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `version` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasechangelog`
--

DROP TABLE IF EXISTS `databasechangelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databasechangelog` (
  `ID` varchar(63) NOT NULL,
  `AUTHOR` varchar(63) NOT NULL,
  `FILENAME` varchar(200) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`,`AUTHOR`,`FILENAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangelog`
--

LOCK TABLES `databasechangelog` WRITE;
/*!40000 ALTER TABLE `databasechangelog` DISABLE KEYS */;
INSERT INTO `databasechangelog` VALUES ('key-33','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:17',33,'EXECUTED','7:86e34b5d5503810915215c3c7ea5999c','Adds creates a primary key out of an existing column or set of columns.','',NULL,'3.0.5'),('key-34','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:18',34,'EXECUTED','7:16c6b330ee69a30af220c01f689ec00b','Adds creates a primary key out of an existing column or set of columns.','',NULL,'3.0.5'),('key-35','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:18',35,'EXECUTED','7:526cd1f5f80c53173be5b96d45998c96','Adds creates a primary key out of an existing column or set of columns.','',NULL,'3.0.5'),('key-36','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:19',36,'EXECUTED','7:54fdef4be0179ffe24d8f3d4900d2283','Adds creates a primary key out of an existing column or set of columns.','',NULL,'3.0.5'),('key-37','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:19',37,'EXECUTED','7:a70a985b88384e9de1ca765cbe62d3c0','Adds creates a primary key out of an existing column or set of columns.','',NULL,'3.0.5'),('key-38','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:20',38,'EXECUTED','7:132b3e2e323a6f0d7993958e7a12afe0','Adds creates a primary key out of an existing column or set of columns.','',NULL,'3.0.5'),('key-39','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:21',39,'EXECUTED','7:882cec20234c287fc414a75ca9e9c2a3','Adds creates a primary key out of an existing column or set of columns.','',NULL,'3.0.5'),('key-40','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:21',40,'EXECUTED','7:7415291d3ace1745b5393c9ed3c920d3','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-41','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:22',41,'EXECUTED','7:252d45ea7fc96184b0cf36012d96c721','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-42','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:22',42,'EXECUTED','7:6fee46e304dac6ecdbd86e6b10d5774c','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-43','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:22',43,'EXECUTED','7:a9f9c2e7b476c15de9ee561098792d6c','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-44','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:22',44,'EXECUTED','7:d9d66e6699c0ae8f8ce7ff8473f14502','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-45','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:23',45,'EXECUTED','7:f115e83f3d0097de56850d7fa1c0c399','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-46','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:23',46,'EXECUTED','7:80e99f4828bd62a89a2a3921774ca139','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-47','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:24',47,'EXECUTED','7:7ddee4b6ac70c4ab810c99d99e6d7e18','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-48','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:24',48,'EXECUTED','7:70189c473304dd6066d4925c5a02bada','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-49','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:25',49,'EXECUTED','7:ce42cde8d5560a7a9138c52c0f07968f','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-50','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:25',50,'EXECUTED','7:08681ed593ac7ee81c4a85cd7ad1d5fc','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-51','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:25',51,'EXECUTED','7:a4a5f3fba475423e067c4149d61a4833','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-52','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:25',52,'EXECUTED','7:d67d5120a20de34f031ab0b026d7b476','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-53','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:26',53,'EXECUTED','7:90e5eff2701deb2925df70c346f6b9c9','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-54','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:26',54,'EXECUTED','7:f3ae137bf3906ce6c722b826e3dc1204','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-55','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:26',55,'EXECUTED','7:ea1646bf5b488dd389bca4293e8b7e4b','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-56','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:27',56,'EXECUTED','7:8473535ab989f7fddc02b22b661a81b9','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-57','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:27',57,'EXECUTED','7:4a7a2b2966b4910a88a82aee25cc9cef','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-58','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:28',58,'EXECUTED','7:f1a8d753d7e7e071395af7edd19f0c14','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-59','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:28',59,'EXECUTED','7:e1fa0b805d52e1254dbbe3f56b57191a','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-60','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:29',60,'EXECUTED','7:016ef8e3bed6fffcc3a7e99863315010','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-61','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:30',61,'EXECUTED','7:41a83cefb22f50f9de983b0a50103bef','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-62','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:30',62,'EXECUTED','7:f3de1693edcc608c39c9f65e60c8a56e','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-63','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:31',63,'EXECUTED','7:667aef9b1711b234f0e99b6b0ebd50f8','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-64','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:31',64,'EXECUTED','7:f0b45a46cd779db1976bf3936a456a63','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-65','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:31',65,'EXECUTED','7:aa7917b0247d7029217ac3e2db665153','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-66','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:31',66,'EXECUTED','7:7b1a797b2ab15060653144b6f0ff6cac','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-67','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:32',67,'EXECUTED','7:123345301b1321a19559f684cc652b07','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-68','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:32',68,'EXECUTED','7:2a2ef685017b5db66fd0ca78224045b4','Adds a unique constrant to an existing column or set of columns.','',NULL,'3.0.5'),('key-69','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:33',69,'EXECUTED','7:08873437c32a45a3aeb3460ff2d83f28','Adds a foreign key constraint to an existing column','',NULL,'3.0.5'),('key-70','Choon Keat','/src/main/resources/liquibase/table/db-key.xml','2016-03-06 14:58:34',70,'EXECUTED','7:f7adacd0c62e43dcd2be8a187440ccce','Adds a foreign key constraint to an existing column','',NULL,'3.0.5'),('module-1','Choon Keat','/src/main/resources/liquibase/data/db-module.xml','2016-03-06 14:58:35',79,'EXECUTED','7:9268bc31876a06d95e71421ae3890e71','Inserts data into an existing table','',NULL,'3.0.5'),('module-2','Choon Keat','/src/main/resources/liquibase/data/db-module.xml','2016-03-06 14:58:35',80,'EXECUTED','7:33998497ecbd4e41d083ef32377afcf2','Inserts data into an existing table','',NULL,'3.0.5'),('module-3','Choon Keat','/src/main/resources/liquibase/data/db-module.xml','2016-03-06 14:58:35',81,'EXECUTED','7:bc0b21cea3b0efe8655a2be3bc55ff84','Inserts data into an existing table','',NULL,'3.0.5'),('module-4','Choon Keat','/src/main/resources/liquibase/data/db-module.xml','2016-03-06 14:58:35',82,'EXECUTED','7:22eca305fe6d70e41b557a6537d45e52','Inserts data into an existing table','',NULL,'3.0.5'),('module-5','Choon Keat','/src/main/resources/liquibase/data/db-module.xml','2016-03-06 14:58:35',83,'EXECUTED','7:275abd1db32aff7a92d092e04ef4e6d4','Inserts data into an existing table','',NULL,'3.0.5'),('role-1','Choon Keat','/src/main/resources/liquibase/data/db-user.xml','2016-03-06 14:58:34',72,'EXECUTED','7:acfc4451550180a9724a15b91e71fa53','Inserts data into an existing table','',NULL,'3.0.5'),('role_module-1','Choon Keat','/src/main/resources/liquibase/data/db-user.xml','2016-03-06 14:58:34',74,'EXECUTED','7:7a4851df0796f2149a6d7582f67506df','Inserts data into an existing table','',NULL,'3.0.5'),('role_module-2','Choon Keat','/src/main/resources/liquibase/data/db-user.xml','2016-03-06 14:58:34',75,'EXECUTED','7:ee02d7aa5d99f7fa0e1748ed4fd204a1','Inserts data into an existing table','',NULL,'3.0.5'),('role_module-3','Choon Keat','/src/main/resources/liquibase/data/db-user.xml','2016-03-06 14:58:34',76,'EXECUTED','7:de8fb41ebc11a56d358379b2db5ff3bd','Inserts data into an existing table','',NULL,'3.0.5'),('role_module-4','Choon Keat','/src/main/resources/liquibase/data/db-user.xml','2016-03-06 14:58:34',77,'EXECUTED','7:c19bd55db32d4479918bfb7fab087362','Inserts data into an existing table','',NULL,'3.0.5'),('role_module-5','Choon Keat','/src/main/resources/liquibase/data/db-user.xml','2016-03-06 14:58:35',78,'EXECUTED','7:4e04776344839bf17da74d7793e8a499','Inserts data into an existing table','',NULL,'3.0.5'),('table-1','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:06',1,'EXECUTED','7:d6978559abe016ff5d2172599106df1f','Create Table','',NULL,'3.0.5'),('table-10','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:09',10,'EXECUTED','7:cd3a96a1875eaae1ae0b5b33646e32ef','Create Table','',NULL,'3.0.5'),('table-11','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:09',11,'EXECUTED','7:d642059e6b3ac02aa394c095d9c6c005','Create Table','',NULL,'3.0.5'),('table-12','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:10',12,'EXECUTED','7:5ce1ede216ac8807d5e98eb61cceb067','Create Table','',NULL,'3.0.5'),('table-13','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:10',13,'EXECUTED','7:2d83c12ccc4d3505edea35be418fd9d2','Create Table','',NULL,'3.0.5'),('table-14','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:10',14,'EXECUTED','7:09aab1deea34577d280d2ba2c61b4531','Create Table','',NULL,'3.0.5'),('table-15','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:11',15,'EXECUTED','7:4053df81b66c5a1c906d10ec79a8bfad','Create Table','',NULL,'3.0.5'),('table-16','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:11',16,'EXECUTED','7:5ff5a06a41f478997ff38216187cc620','Create Table','',NULL,'3.0.5'),('table-17','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:11',17,'EXECUTED','7:207f12d43eef1d2235c24dcfca3e1eb9','Create Table','',NULL,'3.0.5'),('table-18','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:12',18,'EXECUTED','7:435facfc2296bc3326141e42cbfd0319','Create Table','',NULL,'3.0.5'),('table-19','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:12',19,'EXECUTED','7:064c5fe7821e2ac316c1864f36d121c9','Create Table','',NULL,'3.0.5'),('table-2','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:07',2,'EXECUTED','7:dd69f753018749e1ed1e009a60d3e0bc','Create Table','',NULL,'3.0.5'),('table-20','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:12',20,'EXECUTED','7:3de52b379237d0aa148e17ef5c4139d3','Create Table','',NULL,'3.0.5'),('table-21','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:13',21,'EXECUTED','7:819ca00e934723bcba658b1f82e54e14','Create Table','',NULL,'3.0.5'),('table-22','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:13',22,'EXECUTED','7:e36ec281f43fe2061b31cefe482a75f4','Create Table','',NULL,'3.0.5'),('table-23','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:13',23,'EXECUTED','7:fcf02fadadcbc1d83d0085c1d1f73c7e','Create Table','',NULL,'3.0.5'),('table-24','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:14',24,'EXECUTED','7:c739092b6f428c1918a8c5ab253a4109','Create Table','',NULL,'3.0.5'),('table-25','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:14',25,'EXECUTED','7:b62a1469030d655eb73c9da10b7739eb','Create Table','',NULL,'3.0.5'),('table-26','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:14',26,'EXECUTED','7:659c74efe7e09f13b04380328a72b4d8','Create Table','',NULL,'3.0.5'),('table-27','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:15',27,'EXECUTED','7:a7de5893adcf0ea03b489428ebefea66','Create Table','',NULL,'3.0.5'),('table-28','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:15',28,'EXECUTED','7:92e7537a57bf5b8cd083fddeb563cd80','Create Table','',NULL,'3.0.5'),('table-29','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:15',29,'EXECUTED','7:ed644a54d3fa6c8c5a30d68f583421c2','Create Table','',NULL,'3.0.5'),('table-3','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:07',3,'EXECUTED','7:06f980c8504382e32db1c46a7c5fe9e6','Create Table','',NULL,'3.0.5'),('table-30','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:16',30,'EXECUTED','7:0d70c77b02e5cc725aace1d426d16b5c','Create Table','',NULL,'3.0.5'),('table-31','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:16',31,'EXECUTED','7:0d76de26eb43e52dcc8526e3df45cfa9','Create Table','',NULL,'3.0.5'),('table-32','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:17',32,'EXECUTED','7:ccb969343415b20c7e69161442cd8efc','Create Table','',NULL,'3.0.5'),('table-4','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:07',4,'EXECUTED','7:238487e021c84bfd4116ad2bc2a7368f','Create Table','',NULL,'3.0.5'),('table-5','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:08',5,'EXECUTED','7:4ab2b9849f2c99273d9232e51146a682','Create Table','',NULL,'3.0.5'),('table-6','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:08',6,'EXECUTED','7:142e080eab34bdbb563af100e2412b8e','Create Table','',NULL,'3.0.5'),('table-7','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:08',7,'EXECUTED','7:de4ec528c4dc352a4cc0d1db3d376e9b','Create Table','',NULL,'3.0.5'),('table-8','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:08',8,'EXECUTED','7:6d16fefb02f20bcee52eff8aa631cf9c','Create Table','',NULL,'3.0.5'),('table-9','Choon Keat','/src/main/resources/liquibase/table/db-createTable.xml','2016-03-06 14:58:09',9,'EXECUTED','7:e079ee34586f39194ee395afa115dac4','Create Table','',NULL,'3.0.5'),('user-1','Choon Keat','/src/main/resources/liquibase/data/db-user.xml','2016-03-06 14:58:34',71,'EXECUTED','7:7966fe91c8dc4b4c1f59320aa570ffa8','Inserts data into an existing table','',NULL,'3.0.5'),('user_role-1','Choon Keat','/src/main/resources/liquibase/data/db-user.xml','2016-03-06 14:58:34',73,'EXECUTED','7:ce10d59c063dccfd13a2bce0defaca59','Inserts data into an existing table','',NULL,'3.0.5');
/*!40000 ALTER TABLE `databasechangelog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasechangeloglock`
--

DROP TABLE IF EXISTS `databasechangeloglock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangeloglock`
--

LOCK TABLES `databasechangeloglock` WRITE;
/*!40000 ALTER TABLE `databasechangeloglock` DISABLE KEYS */;
INSERT INTO `databasechangeloglock` VALUES (1,'\0',NULL,NULL);
/*!40000 ALTER TABLE `databasechangeloglock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emailconfig`
--

DROP TABLE IF EXISTS `emailconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emailconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `host` varchar(100) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `protocol` varchar(10) DEFAULT NULL,
  `authenticate` bit(1) DEFAULT NULL,
  `maxattempt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailconfig`
--

LOCK TABLES `emailconfig` WRITE;
/*!40000 ALTER TABLE `emailconfig` DISABLE KEYS */;
/*!40000 ALTER TABLE `emailconfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emailtemplate`
--

DROP TABLE IF EXISTS `emailtemplate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emailtemplate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `sendername` varchar(50) DEFAULT NULL,
  `senderemail` varchar(255) DEFAULT NULL,
  `content` mediumtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailtemplate`
--

LOCK TABLES `emailtemplate` WRITE;
/*!40000 ALTER TABLE `emailtemplate` DISABLE KEYS */;
/*!40000 ALTER TABLE `emailtemplate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emailtype`
--

DROP TABLE IF EXISTS `emailtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emailtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailtype`
--

LOCK TABLES `emailtype` WRITE;
/*!40000 ALTER TABLE `emailtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `emailtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense`
--

DROP TABLE IF EXISTS `expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `amount` decimal(6,2) DEFAULT '0.00',
  `description` mediumtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
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
-- Table structure for table `expensetype`
--

DROP TABLE IF EXISTS `expensetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expensetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expensetype`
--

LOCK TABLES `expensetype` WRITE;
/*!40000 ALTER TABLE `expensetype` DISABLE KEYS */;
/*!40000 ALTER TABLE `expensetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `comment` mediumtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jannaweb`
--

DROP TABLE IF EXISTS `jannaweb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jannaweb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `resourcename` varchar(50) DEFAULT NULL,
  `resourcevalue` mediumtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jannaweb`
--

LOCK TABLES `jannaweb` WRITE;
/*!40000 ALTER TABLE `jannaweb` DISABLE KEYS */;
/*!40000 ALTER TABLE `jannaweb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `icon` varchar(45) DEFAULT NULL,
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES (1,'Admin Management','fa-users','N');
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nonacccust`
--

DROP TABLE IF EXISTS `nonacccust`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nonacccust` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `addressid` int(11) NOT NULL DEFAULT '0',
  `updatedby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nonacccust`
--

LOCK TABLES `nonacccust` WRITE;
/*!40000 ALTER TABLE `nonacccust` DISABLE KEYS */;
/*!40000 ALTER TABLE `nonacccust` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_product` (
  `orderid` int(11) NOT NULL,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `productid` int(11) NOT NULL,
  `qty` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`orderid`,`productid`),
  UNIQUE KEY `orderid` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `custType` enum('acccust','nonacccust') NOT NULL DEFAULT 'nonacccust',
  `custid` int(11) DEFAULT NULL,
  `paymentid` int(11) DEFAULT NULL,
  `addressid` int(11) DEFAULT NULL,
  `promoid` int(11) DEFAULT NULL,
  `orderNum` varchar(50) NOT NULL,
  `orderdate` date DEFAULT NULL,
  `paymentdate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `measurement` varchar(1000) DEFAULT NULL,
  `sellprice` decimal(6,2) DEFAULT NULL,
  `categoryid` int(11) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `version` tinyint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
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
  `productid` int(11) NOT NULL,
  `categoryid` int(11) NOT NULL,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(3) unsigned DEFAULT NULL,
  `product_categorycol` varchar(45) NOT NULL,
  PRIMARY KEY (`productid`,`categoryid`,`product_categorycol`),
  UNIQUE KEY `productid` (`productid`)
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
-- Table structure for table `productcolour`
--

DROP TABLE IF EXISTS `productcolour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productcolour` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) DEFAULT NULL,
  `colour` varchar(45) NOT NULL,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updateby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcolour`
--

LOCK TABLES `productcolour` WRITE;
/*!40000 ALTER TABLE `productcolour` DISABLE KEYS */;
/*!40000 ALTER TABLE `productcolour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productsize`
--

DROP TABLE IF EXISTS `productsize`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productsize` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qty` int(11) NOT NULL DEFAULT '0',
  `buyprice` decimal(6,2) DEFAULT '0.00',
  `productcolourid` int(11) DEFAULT NULL,
  `size` varchar(50) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsize`
--

LOCK TABLES `productsize` WRITE;
/*!40000 ALTER TABLE `productsize` DISABLE KEYS */;
/*!40000 ALTER TABLE `productsize` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `bannerid` int(11) DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  `discountpercentage` decimal(5,2) DEFAULT '0.00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
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
-- Table structure for table `promotion_product`
--

DROP TABLE IF EXISTS `promotion_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion_product` (
  `productcolourid` int(11) NOT NULL,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `promotionid` int(11) NOT NULL,
  `discountpercentage` decimal(5,2) DEFAULT NULL,
  `discountprice` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`productcolourid`,`promotionid`),
  UNIQUE KEY `productcolourid` (`productcolourid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion_product`
--

LOCK TABLES `promotion_product` WRITE;
/*!40000 ALTER TABLE `promotion_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotion_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `cost` decimal(7,2) DEFAULT '0.00',
  `invoiceno` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `supplierName` varchar(50) DEFAULT NULL,
  `receiveby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_product`
--

DROP TABLE IF EXISTS `purchase_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_product` (
  `purchaseid` int(11) NOT NULL,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `productcolourid` int(11) NOT NULL,
  PRIMARY KEY (`purchaseid`,`productcolourid`),
  UNIQUE KEY `purchaseid` (`purchaseid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_product`
--

LOCK TABLES `purchase_product` WRITE;
/*!40000 ALTER TABLE `purchase_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referenceno`
--

DROP TABLE IF EXISTS `referenceno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referenceno` (
  `referenceno` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`referenceno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referenceno`
--

LOCK TABLES `referenceno` WRITE;
/*!40000 ALTER TABLE `referenceno` DISABLE KEYS */;
/*!40000 ALTER TABLE `referenceno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `version` tinyint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN',NULL,NULL,NULL,NULL,0),(2,'MODULE_MGR',NULL,NULL,NULL,NULL,0),(4,'Product Manager',NULL,NULL,NULL,NULL,NULL),(5,'ROLE_ADMIN',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_module`
--

DROP TABLE IF EXISTS `role_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_module` (
  `roleid` int(11) NOT NULL,
  `moduleid` int(11) NOT NULL,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`roleid`,`moduleid`),
  KEY `FK_6sf83ovn2fgmgrmtfrqj2dcc4` (`moduleid`),
  CONSTRAINT `FK_6sf83ovn2fgmgrmtfrqj2dcc4` FOREIGN KEY (`moduleid`) REFERENCES `adminmodule` (`id`),
  CONSTRAINT `FK_aw7iea74gflksq2plx2oiv2t` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_module`
--

LOCK TABLES `role_module` WRITE;
/*!40000 ALTER TABLE `role_module` DISABLE KEYS */;
INSERT INTO `role_module` VALUES (1,1,'2016-03-06 15:00:59','ck1232','2016-03-06 15:00:59','ck1232',1),(1,2,'2016-03-06 15:00:59','ck1232','2016-03-06 15:00:59','ck1232',1),(1,3,'2016-03-06 15:00:59','ck1232','2016-03-06 15:00:59','ck1232',1),(1,4,'2016-03-06 15:00:59','ck1232','2016-03-06 15:00:59','ck1232',1),(1,5,'2016-03-06 15:00:59','ck1232','2016-03-06 15:00:59','ck1232',1),(1,6,'2016-03-06 15:00:59','ck1232','2016-03-06 15:00:59','ck1232',1),(1,7,'2016-03-06 15:00:59','ck1232','2016-03-06 15:00:59','ck1232',1);
/*!40000 ALTER TABLE `role_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submodule`
--

DROP TABLE IF EXISTS `submodule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submodule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `icon` varchar(45) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `deleteInd` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodule`
--

LOCK TABLES `submodule` WRITE;
/*!40000 ALTER TABLE `submodule` DISABLE KEYS */;
INSERT INTO `submodule` VALUES (1,1,'User Management','fa-users','listUser','N'),(2,1,'Module Management','fa-users','listModule','N');
/*!40000 ALTER TABLE `submodule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submodulepermission`
--

DROP TABLE IF EXISTS `submodulepermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submodulepermission` (
  `roleId` int(11) NOT NULL,
  `submoduleId` int(11) NOT NULL,
  `permission` varchar(255) NOT NULL DEFAULT 'VIEW',
  PRIMARY KEY (`roleId`,`submoduleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodulepermission`
--

LOCK TABLES `submodulepermission` WRITE;
/*!40000 ALTER TABLE `submodulepermission` DISABLE KEYS */;
/*!40000 ALTER TABLE `submodulepermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `emailaddress` varchar(50) DEFAULT NULL,
  `lastlogints` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `createdby` varchar(50) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedBy` varchar(50) DEFAULT NULL,
  `version` tinyint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `userid_UNIQUE` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ck1232','1232ck1232',NULL,'choon keat','ck1232@hotmail.com',NULL,'',NULL,NULL,NULL,NULL,0),(2,'euphona','12345',NULL,'Janice Lee','euphona@hotmail.com',NULL,'',NULL,NULL,NULL,NULL,0),(5,'jj','12345',NULL,'Janice Lee','jj@hotmail.com',NULL,'',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `version` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`userid`,`roleid`),
  KEY `role_roleid_fk` (`roleid`),
  CONSTRAINT `role_roleid_fk` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_userid_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,NULL,NULL,NULL,NULL,NULL),(1,2,NULL,NULL,NULL,NULL,NULL),(1,4,NULL,NULL,NULL,NULL,NULL),(2,1,NULL,NULL,NULL,NULL,NULL),(2,2,NULL,NULL,NULL,NULL,NULL),(2,5,NULL,NULL,NULL,NULL,NULL),(5,1,NULL,NULL,NULL,NULL,NULL),(5,2,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wishlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(50) DEFAULT NULL,
  `version` tinyint(4) DEFAULT NULL,
  `custid` int(11) DEFAULT NULL,
  `productcolourid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-15 19:20:49
