CREATE DATABASE  IF NOT EXISTS `jj` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `jj`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: jj
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES (1,'Admin Management','fa-users','N'),(2,'Project Management','fa-users','Y'),(3,'Test Module','fa-users','Y'),(4,'test Management','fa-users','Y');
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
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
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcategory`
--

LOCK TABLES `productcategory` WRITE;
/*!40000 ALTER TABLE `productcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `productcategory` ENABLE KEYS */;
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
  `categoryId` int(11) NOT NULL,
  `deleteInd` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsubcategory`
--

LOCK TABLES `productsubcategory` WRITE;
/*!40000 ALTER TABLE `productsubcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `productsubcategory` ENABLE KEYS */;
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
INSERT INTO `role` VALUES (1,'ADMIN',NULL,NULL,NULL,NULL,0),(2,'MODULE_MGR',NULL,NULL,NULL,NULL,0),(5,'ROLE_ADMIN',NULL,NULL,NULL,NULL,NULL);
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
  `deleteInd` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodule`
--

LOCK TABLES `submodule` WRITE;
/*!40000 ALTER TABLE `submodule` DISABLE KEYS */;
INSERT INTO `submodule` VALUES (1,1,'User Management','fa-users','admin/listUser','N'),(2,1,'Module Management','fa-users','admin/listModule','N'),(4,3,'Permissions Management','fa-users','admin/listModule','N'),(21,1,'Role Management','fa-users','admin/listRole','N'),(22,1,'Permission Management','fa-users','admin/listPermissionModule','N'),(23,4,'test','fa-users','/admin/listPermission','N');
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
  PRIMARY KEY (`roleId`,`submoduleId`,`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodulepermission`
--

LOCK TABLES `submodulepermission` WRITE;
/*!40000 ALTER TABLE `submodulepermission` DISABLE KEYS */;
INSERT INTO `submodulepermission` VALUES (1,18,'1'),(1,18,'2'),(1,18,'3'),(1,18,'4'),(2,18,'1'),(2,18,'2'),(5,1,'14'),(5,2,'11'),(5,18,'10'),(5,18,'3'),(5,21,'13'),(5,22,'12');
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submodulepermissiontype`
--

LOCK TABLES `submodulepermissiontype` WRITE;
/*!40000 ALTER TABLE `submodulepermissiontype` DISABLE KEYS */;
INSERT INTO `submodulepermissiontype` VALUES (1,'18','view','1','viewUser'),(2,'18','modify','2','modifyUser'),(3,'18','erase','3','erase'),(4,'18','delete','4','delete'),(5,'18','assign','5','assign'),(6,'18','assign_shit','6','assign_shit'),(10,'18','test','10','/???'),(11,'2','View','1','/admin/listModule'),(12,'22','View','1','/admin/listPermission'),(13,'21','View','1','/admin/listRole'),(14,'1','View','1','/admin/listUser');
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
INSERT INTO `user` VALUES (1,'ck1232','$2a$10$fF7SimwO74sU2hSa8u0/u.s5tYGbPMorm6i17w2zdIcbb7mURlb6G',NULL,'choon keat','ck1232@hotmail.com',NULL,'',NULL,NULL,NULL,NULL,0),(2,'euphona','$2a$10$W9oRWeFmOT0bByL5fmAceucetmEYFg2yzq3e50mcu.CO7rUDb/poG',NULL,'Janice Lee','euphona@hotmail.com',NULL,'',NULL,NULL,NULL,NULL,0),(5,'jannie','$2a$10$W9oRWeFmOT0bByL5fmAceucetmEYFg2yzq3e50mcu.CO7rUDb/poG',NULL,'Janice Lee','jj@hotmail.com',NULL,'',NULL,NULL,NULL,NULL,NULL);
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
INSERT INTO `user_role` VALUES (1,1,NULL,NULL,NULL,NULL,NULL),(1,2,NULL,NULL,NULL,NULL,NULL),(1,5,NULL,NULL,NULL,NULL,NULL),(2,1,NULL,NULL,NULL,NULL,NULL),(2,2,NULL,NULL,NULL,NULL,NULL),(2,5,NULL,NULL,NULL,NULL,NULL),(5,1,NULL,NULL,NULL,NULL,NULL),(5,2,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'jj'
--

--
-- Dumping routines for database 'jj'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-28 21:39:09
