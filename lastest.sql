-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jj
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
-- Table structure for table `batchproduct_rs`
--

DROP TABLE IF EXISTS `batchproduct_rs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batchproduct_rs` (
  `batchid` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `productsuboption1id` int(11) DEFAULT NULL,
  `productsuboption2id` int(11) DEFAULT NULL,
  `productsuboption3id` int(11) DEFAULT NULL,
  `unitcost` decimal(6,2) DEFAULT '0.00',
  `qty` int(11) DEFAULT NULL,
  `deleteind` char(1) NOT NULL DEFAULT 'N',
  `createdon` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batchproduct_rs`
--

LOCK TABLES `batchproduct_rs` WRITE;
/*!40000 ALTER TABLE `batchproduct_rs` DISABLE KEYS */;
/*!40000 ALTER TABLE `batchproduct_rs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batchstockintake`
--

DROP TABLE IF EXISTS `batchstockintake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batchstockintake` (
  `batchid` int(11) NOT NULL AUTO_INCREMENT,
  `remarks` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `storagelocation` int(11) DEFAULT NULL,
  `totalcost` decimal(8,2) DEFAULT '0.00',
  `additionalcost` decimal(6,2) DEFAULT '0.00',
  `deleteind` char(1) NOT NULL DEFAULT 'N',
  `updatedby` varchar(255) DEFAULT NULL,
  `updateon` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  PRIMARY KEY (`batchid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batchstockintake`
--

LOCK TABLES `batchstockintake` WRITE;
/*!40000 ALTER TABLE `batchstockintake` DISABLE KEYS */;
/*!40000 ALTER TABLE `batchstockintake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `gender` char(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `emailaddress` varchar(100) DEFAULT NULL,
  `isActive` bit(1) DEFAULT NULL,
  `userId` varchar(255) NOT NULL,
  `password` varchar(60) NOT NULL,
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedBy` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'F','Lee Jia Cin Janice','2016-11-30','euphona@hotmail.com','\0','euphona','12345','N','Janice','2016-11-09 19:29:00','Janice','2016-11-09 19:29:00',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customeraddress`
--

DROP TABLE IF EXISTS `customeraddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customeraddress` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) DEFAULT NULL,
  `recipientName` varchar(255) DEFAULT NULL,
  `address` varchar(512) DEFAULT NULL,
  `contactNumber` bigint(10) DEFAULT NULL,
  `postalCode` int(8) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `defaultInd` char(1) NOT NULL DEFAULT 'N',
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customeraddress`
--

LOCK TABLES `customeraddress` WRITE;
/*!40000 ALTER TABLE `customeraddress` DISABLE KEYS */;
INSERT INTO `customeraddress` VALUES (1,1,'CK111','Blk 252 #02-390 Pending Road Singapore 670252',93273252,670255,'Singapore','Y','N','Janice','2016-11-09 19:29:00','Janice','2016-11-09 19:29:00',1);
/*!40000 ALTER TABLE `customeraddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliveryfee`
--

DROP TABLE IF EXISTS `deliveryfee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliveryfee` (
  `delieveryfeeId` int(11) NOT NULL AUTO_INCREMENT,
  `weight` int(11) NOT NULL,
  `price` decimal(6,2) NOT NULL,
  `sequence` int(11) DEFAULT NULL,
  `carrierType` varchar(255) DEFAULT NULL,
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`delieveryfeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliveryfee`
--

LOCK TABLES `deliveryfee` WRITE;
/*!40000 ALTER TABLE `deliveryfee` DISABLE KEYS */;
/*!40000 ALTER TABLE `deliveryfee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discount` (
  `discountId` int(11) NOT NULL AUTO_INCREMENT,
  `promoId` int(11) DEFAULT NULL,
  `discountName` varchar(255) DEFAULT NULL,
  `discountType` varchar(100) DEFAULT NULL,
  `discountValue` decimal(6,2) DEFAULT '0.00',
  `applyType` varchar(50) DEFAULT NULL,
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`discountId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (1,NULL,'5 % discount','Percentage %',5.00,'Delivery','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(2,3,'4%','Percentage %',4.00,'Total','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
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
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES (1,'Admin Management','fa-users','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(5,'Product management','fa-users','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(6,'Promotion Management','fa-users','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(7,'Customer Management','fa-users','N','euphona','2016-11-15 21:23:46','euphona','2016-11-15 21:23:46',1);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `productId` int(11) NOT NULL,
  `productName` varchar(255) NOT NULL,
  `unitPrice` decimal(7,2) NOT NULL,
  `subcategoryId` int(11) DEFAULT NULL,
  `desciption` varchar(1000) DEFAULT NULL,
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`productId`)
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
-- Table structure for table `productcategory`
--

DROP TABLE IF EXISTS `productcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `isParent` bit(1) NOT NULL DEFAULT b'0',
  `displayInd` bit(1) NOT NULL DEFAULT b'1',
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcategory`
--

LOCK TABLES `productcategory` WRITE;
/*!40000 ALTER TABLE `productcategory` DISABLE KEYS */;
INSERT INTO `productcategory` VALUES (1,'light bulb','','','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(2,'hel','','','Y','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(3,'testing','','','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(4,'lamp','\0','','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0);
/*!40000 ALTER TABLE `productcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdiscount_rs`
--

DROP TABLE IF EXISTS `productdiscount_rs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productdiscount_rs` (
  `productId` int(11) NOT NULL,
  `discountId` int(11) NOT NULL,
  `discountPrice` decimal(7,2) NOT NULL,
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`productId`,`discountId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdiscount_rs`
--

LOCK TABLES `productdiscount_rs` WRITE;
/*!40000 ALTER TABLE `productdiscount_rs` DISABLE KEYS */;
/*!40000 ALTER TABLE `productdiscount_rs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productimage`
--

DROP TABLE IF EXISTS `productimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productimage` (
  `imageId` int(11) NOT NULL,
  `productId` int(11) DEFAULT NULL,
  `imageName` varchar(255) DEFAULT NULL,
  `image` mediumblob,
  `sequence` int(11) DEFAULT NULL,
  `thumbnailImage` mediumblob,
  `displayInd` bit(1) NOT NULL DEFAULT b'1',
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`imageId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productimage`
--

LOCK TABLES `productimage` WRITE;
/*!40000 ALTER TABLE `productimage` DISABLE KEYS */;
/*!40000 ALTER TABLE `productimage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productoption`
--

DROP TABLE IF EXISTS `productoption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productoption` (
  `productoptionId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `displayInd` bit(1) NOT NULL DEFAULT b'1',
  `sequence` int(11) DEFAULT NULL,
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`productoptionId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productoption`
--

LOCK TABLES `productoption` WRITE;
/*!40000 ALTER TABLE `productoption` DISABLE KEYS */;
INSERT INTO `productoption` VALUES (1,'Color','',1,'N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(2,'Color','',2,'N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(3,'Color','',3,'N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(4,'Type','',1,'N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(5,'Type','',2,'N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(6,'Type','',3,'N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0);
/*!40000 ALTER TABLE `productoption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productspecification`
--

DROP TABLE IF EXISTS `productspecification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productspecification` (
  `productSpecificationId` int(11) NOT NULL,
  `productId` int(11) DEFAULT NULL,
  `content` longtext,
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`productSpecificationId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productspecification`
--

LOCK TABLES `productspecification` WRITE;
/*!40000 ALTER TABLE `productspecification` DISABLE KEYS */;
/*!40000 ALTER TABLE `productspecification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productsubcategory`
--

DROP TABLE IF EXISTS `productsubcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productsubcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `productCategoryId` int(11) NOT NULL,
  `displayInd` bit(1) NOT NULL DEFAULT b'1',
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsubcategory`
--

LOCK TABLES `productsubcategory` WRITE;
/*!40000 ALTER TABLE `productsubcategory` DISABLE KEYS */;
INSERT INTO `productsubcategory` VALUES (1,'Light Bulbs',1,'','Y','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(2,'Light Bulbs',1,'','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(3,'test1',3,'','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(4,'test2',3,'','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(5,'test3',3,'','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(6,'lamp',4,'','Y','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(7,'lamp',4,'','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0);
/*!40000 ALTER TABLE `productsubcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productsuboption`
--

DROP TABLE IF EXISTS `productsuboption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productsuboption` (
  `productSubOptionId` int(11) NOT NULL,
  `productId` int(11) DEFAULT NULL,
  `productoptionId` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `displayInd` bit(1) DEFAULT b'1',
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`productSubOptionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsuboption`
--

LOCK TABLES `productsuboption` WRITE;
/*!40000 ALTER TABLE `productsuboption` DISABLE KEYS */;
/*!40000 ALTER TABLE `productsuboption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion` (
  `promotionId` int(11) NOT NULL AUTO_INCREMENT,
  `promotionName` varchar(255) DEFAULT NULL,
  `promotionMessage` varchar(1000) DEFAULT NULL,
  `promotionStartDate` datetime(6) DEFAULT NULL,
  `promotionEndDate` datetime(6) DEFAULT NULL,
  `isActive` bit(1) NOT NULL DEFAULT b'1',
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`promotionId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,'name','message','2016-05-10 00:00:00.000000','2016-12-10 00:00:00.000000','','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(2,'name','message','2016-10-04 00:00:00.000000','2016-10-06 00:00:00.000000','','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(3,'c','k','2016-10-31 00:00:00.000000','2016-10-31 00:00:00.000000','','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(4,'name','message',NULL,NULL,'','Y','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(5,'ck','ck','2016-11-09 19:29:00.000000','2016-11-12 22:16:00.000000','','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(6,'csdfs','c','2016-11-01 05:00:00.000000','2016-11-30 06:00:00.000000','\0','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(7,'a','a','2016-11-19 00:00:00.000000','2016-11-19 23:59:00.000000','','N','euphona','2016-11-19 00:18:40','euphona','2016-11-19 00:18:40',1);
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
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
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(50) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(50) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(2,'MODULE_MGR','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(5,'ROLE_ADMIN','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(6,'PRODUCT_MGR','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(7,'PROMOTION_MGR','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
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
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodule`
--

LOCK TABLES `submodule` WRITE;
/*!40000 ALTER TABLE `submodule` DISABLE KEYS */;
INSERT INTO `submodule` VALUES (1,1,'User Management','fa-users','admin/listUser','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(2,1,'Module Management','fa-users','admin/listModule','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(21,1,'Role Management','fa-users','admin/listRole','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(22,1,'Permission Management','fa-users','admin/listPermission','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(24,5,'Category Management','fa-users','product/category/listProductCategory','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(26,5,'Product Management','fa-users','product/product/listProduct','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(28,6,'Promotion Management','fa-users','product/promotion/listPromotion','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(29,6,'Discount Management','fa-users','product/discount/listDiscount','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(30,5,'Product Option Management','fa-users','product/option/listProductOption','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(31,7,'Customer Management','fa-users','customer/listCustomer','N','euphona','2016-11-15 21:24:32','euphona','2016-11-15 21:24:32',1);
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
  `permission` varchar(255) NOT NULL,
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`roleId`,`submoduleId`,`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodulepermission`
--

LOCK TABLES `submodulepermission` WRITE;
/*!40000 ALTER TABLE `submodulepermission` DISABLE KEYS */;
INSERT INTO `submodulepermission` VALUES (1,1,'14','N','euphona','2016-11-12 21:47:51','euphona','2016-11-12 21:47:51',1),(1,2,'11','N','euphona','2016-11-12 21:49:07','euphona','2016-11-12 21:49:07',1),(1,21,'13','N','euphona','2016-11-12 21:49:19','euphona','2016-11-12 21:49:19',1),(1,22,'12','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(1,24,'16','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(1,26,'20','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(1,28,'23','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(1,29,'24','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(1,30,'25','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(1,31,'26','N','euphona','2016-11-15 21:25:31','euphona','2016-11-15 21:25:31',1),(5,1,'14','N','euphona','2016-11-12 22:55:59','euphona','2016-11-12 22:55:59',1),(6,1,'14','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',1);
/*!40000 ALTER TABLE `submodulepermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submodulepermissiontype`
--

DROP TABLE IF EXISTS `submodulepermissiontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submodulepermissiontype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `submoduleid` varchar(45) DEFAULT NULL,
  `permissiontype` varchar(45) DEFAULT NULL,
  `seqNo` varchar(45) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodulepermissiontype`
--

LOCK TABLES `submodulepermissiontype` WRITE;
/*!40000 ALTER TABLE `submodulepermissiontype` DISABLE KEYS */;
INSERT INTO `submodulepermissiontype` VALUES (11,'2','View','1','/admin/listModule','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(12,'22','View','1','/admin/listPermission','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(13,'21','View','1','/admin/listRole','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(14,'1','View','1','/admin/listUser','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(16,'24','View','1','/product/category/listProductCategory','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(20,'26','View','1','product/product/listProduct','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(23,'28','View','1','/product/promotion/listPromotion','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(24,'29','View','1','/product/discount/listDiscount','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(25,'30','View','1','/product/option/listProductOption','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(26,'31','View','1','/customer/listCustomer','N','euphona','2016-11-15 21:25:16','euphona','2016-11-15 21:25:16',1);
/*!40000 ALTER TABLE `submodulepermissiontype` ENABLE KEYS */;
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
  `password` varchar(60) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `emailaddress` varchar(255) DEFAULT NULL,
  `lastlogints` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(255) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(255) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `userid_UNIQUE` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ck1232','$2a$10$fF7SimwO74sU2hSa8u0/u.s5tYGbPMorm6i17w2zdIcbb7mURlb6G',NULL,'choon keat','ck1232@hotmail.com',NULL,'','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(2,'euphona','$2a$10$bbH4SEDcWxKoOFuu8RKi0ec1V20XR7UtiaoEpnesBVtuaT3SvX7gm',NULL,'Janice Lee','euphona@hotmail.com',NULL,'','N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(8,'ck','$2a$10$Z8IgSbjs2yFNdc5GbuVa8.DQbALA5CnPfdO6vFkCHobwxNaTNsdXe',NULL,'ck','ck@hotmail.com',NULL,'','N','euphona','2016-11-12 23:25:20','euphona','2016-11-12 23:25:20',1);
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
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  `createdby` varchar(50) NOT NULL,
  `createdon` datetime NOT NULL,
  `updatedby` varchar(50) NOT NULL,
  `updatedon` datetime NOT NULL,
  `version` int(5) unsigned NOT NULL DEFAULT '0',
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
INSERT INTO `user_role` VALUES (1,1,'N','euphona','2016-11-14 00:29:43','euphona','2016-11-14 00:29:43',1),(2,1,'N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(2,2,'N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(2,5,'N','','0000-00-00 00:00:00','','0000-00-00 00:00:00',0),(8,5,'N','euphona','2016-11-14 00:34:58','euphona','2016-11-14 00:34:58',1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-20 15:12:07
