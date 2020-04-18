CREATE DATABASE  IF NOT EXISTS `vote` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vote`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: vote
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('a','a'),('aaa','aaa'),('admin','a'),('Peter','123456'),('pig','a'),('小王','123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uservote`
--

DROP TABLE IF EXISTS `uservote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uservote` (
  `uvid` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `oid` int(11) NOT NULL,
  PRIMARY KEY (`uvid`),
  KEY `FK_uservote_username_idx` (`userName`),
  KEY `FK_uservote_oid_idx` (`oid`),
  CONSTRAINT `FK_uservote_username` FOREIGN KEY (`userName`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_uservote_oid` FOREIGN KEY (`oid`) REFERENCES `voteoption` (`oid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uservote`
--

LOCK TABLES `uservote` WRITE;
/*!40000 ALTER TABLE `uservote` DISABLE KEYS */;
INSERT INTO `uservote` VALUES (1,'admin',5),(2,'a',5),(3,'admin',10),(4,'admin',13),(5,'admin',32),(6,'admin',23),(7,'admin',25),(8,'admin',26),(9,'admin',28),(10,'admin',29),(11,'admin',3),(12,'admin',20),(13,'a',1),(14,'a',17),(15,'a',23),(16,'a',25),(17,'a',26),(18,'a',28),(19,'a',29),(20,'admin',39),(21,'pig',36),(22,'pig',5),(23,'pig',6),(24,'pig',7),(25,'pig',8),(26,'pig',17),(27,'pig',42),(28,'pig',45),(29,'pig',46),(30,'pig',47);
/*!40000 ALTER TABLE `uservote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voteinfo`
--

DROP TABLE IF EXISTS `voteinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voteinfo` (
  `vid` varchar(45) NOT NULL,
  `voteName` varchar(100) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voteinfo`
--

LOCK TABLES `voteinfo` WRITE;
/*!40000 ALTER TABLE `voteinfo` DISABLE KEYS */;
INSERT INTO `voteinfo` VALUES ('132a98a5-b6c2-4c53-8c2c-e8d030bd2406','你最想去哪个城市？',1),('3551a13e-a9f6-43a5-a75f-ccc0e37fd903','三国五虎上将指',2),('39aa8226-57bf-4621-a247-1c21d392c4a7','最喜欢的学科',1),('6d316bf6-cb9b-46d4-a9cc-46f782ef988f','爱吃什么蔬菜',1),('72ff1c72-f4d0-4a67-8371-0efe1935d2c2','最喜欢的颜色',1),('832acaf1-d217-4cd0-a2fa-dc9d2b7e56ef','哪个大学最美',1),('a776e051-eb48-4e03-83fa-e825263ca09d','喜欢什么动物',2),('cc187806-00c9-4eca-98b8-93c7eee2e713','古代四大美女',2),('cd04d0c6-3177-49ba-b4f3-31a4f85284fa','最喜欢的三国人物',1);
/*!40000 ALTER TABLE `voteinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voteoption`
--

DROP TABLE IF EXISTS `voteoption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voteoption` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `vid` varchar(45) NOT NULL,
  `optionName` varchar(100) NOT NULL,
  PRIMARY KEY (`oid`),
  KEY `FK_option_vid_idx` (`vid`),
  CONSTRAINT `FK_option_vid` FOREIGN KEY (`vid`) REFERENCES `voteinfo` (`vid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voteoption`
--

LOCK TABLES `voteoption` WRITE;
/*!40000 ALTER TABLE `voteoption` DISABLE KEYS */;
INSERT INTO `voteoption` VALUES (1,'832acaf1-d217-4cd0-a2fa-dc9d2b7e56ef','厦门大学'),(2,'832acaf1-d217-4cd0-a2fa-dc9d2b7e56ef','复旦大学'),(3,'832acaf1-d217-4cd0-a2fa-dc9d2b7e56ef','武汉大学'),(4,'832acaf1-d217-4cd0-a2fa-dc9d2b7e56ef','北京大学'),(5,'cc187806-00c9-4eca-98b8-93c7eee2e713','王昭君'),(6,'cc187806-00c9-4eca-98b8-93c7eee2e713','西施'),(7,'cc187806-00c9-4eca-98b8-93c7eee2e713','貂蝉'),(8,'cc187806-00c9-4eca-98b8-93c7eee2e713','杨贵妃'),(9,'cc187806-00c9-4eca-98b8-93c7eee2e713','凤姐'),(10,'72ff1c72-f4d0-4a67-8371-0efe1935d2c2','红色'),(11,'72ff1c72-f4d0-4a67-8371-0efe1935d2c2','橙色'),(12,'72ff1c72-f4d0-4a67-8371-0efe1935d2c2','黄色'),(13,'72ff1c72-f4d0-4a67-8371-0efe1935d2c2','绿色'),(14,'72ff1c72-f4d0-4a67-8371-0efe1935d2c2','青色'),(15,'72ff1c72-f4d0-4a67-8371-0efe1935d2c2','蓝色'),(16,'72ff1c72-f4d0-4a67-8371-0efe1935d2c2','紫色'),(17,'cd04d0c6-3177-49ba-b4f3-31a4f85284fa','关羽'),(18,'cd04d0c6-3177-49ba-b4f3-31a4f85284fa','张飞'),(19,'cd04d0c6-3177-49ba-b4f3-31a4f85284fa','赵云'),(20,'cd04d0c6-3177-49ba-b4f3-31a4f85284fa','曹操'),(21,'cd04d0c6-3177-49ba-b4f3-31a4f85284fa','刘备'),(22,'cd04d0c6-3177-49ba-b4f3-31a4f85284fa','孙权'),(23,'3551a13e-a9f6-43a5-a75f-ccc0e37fd903','张飞'),(24,'3551a13e-a9f6-43a5-a75f-ccc0e37fd903','许褚'),(25,'3551a13e-a9f6-43a5-a75f-ccc0e37fd903','赵云'),(26,'3551a13e-a9f6-43a5-a75f-ccc0e37fd903','黄忠'),(27,'3551a13e-a9f6-43a5-a75f-ccc0e37fd903','刘备'),(28,'3551a13e-a9f6-43a5-a75f-ccc0e37fd903','马超'),(29,'3551a13e-a9f6-43a5-a75f-ccc0e37fd903','关羽'),(30,'39aa8226-57bf-4621-a247-1c21d392c4a7','数学'),(31,'39aa8226-57bf-4621-a247-1c21d392c4a7','语文'),(32,'39aa8226-57bf-4621-a247-1c21d392c4a7','历史'),(33,'39aa8226-57bf-4621-a247-1c21d392c4a7','化学'),(34,'39aa8226-57bf-4621-a247-1c21d392c4a7','英语'),(35,'39aa8226-57bf-4621-a247-1c21d392c4a7','物理'),(36,'132a98a5-b6c2-4c53-8c2c-e8d030bd2406','北京'),(37,'132a98a5-b6c2-4c53-8c2c-e8d030bd2406','上海'),(38,'132a98a5-b6c2-4c53-8c2c-e8d030bd2406','广州'),(39,'132a98a5-b6c2-4c53-8c2c-e8d030bd2406','深圳'),(40,'132a98a5-b6c2-4c53-8c2c-e8d030bd2406','杭州'),(41,'6d316bf6-cb9b-46d4-a9cc-46f782ef988f','包心菜'),(42,'6d316bf6-cb9b-46d4-a9cc-46f782ef988f','空心菜'),(43,'6d316bf6-cb9b-46d4-a9cc-46f782ef988f','花菜'),(44,'6d316bf6-cb9b-46d4-a9cc-46f782ef988f','香菜'),(45,'a776e051-eb48-4e03-83fa-e825263ca09d','猫'),(46,'a776e051-eb48-4e03-83fa-e825263ca09d','狗'),(47,'a776e051-eb48-4e03-83fa-e825263ca09d','熊猫'),(48,'a776e051-eb48-4e03-83fa-e825263ca09d','兔子'),(49,'a776e051-eb48-4e03-83fa-e825263ca09d','仓鼠');
/*!40000 ALTER TABLE `voteoption` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-18 18:48:11
