CREATE DATABASE  IF NOT EXISTS `sombra` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sombra`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: sombra
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `material` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `manufacturer_id` bigint(20) NOT NULL,
  `type_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_s23eobofyp0n5roimk8ar0js3` (`manufacturer_id`),
  KEY `FK_njckp3cd3de2y1qdktj0u8uxo` (`type_id`),
  CONSTRAINT `FK_njckp3cd3de2y1qdktj0u8uxo` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`),
  CONSTRAINT `FK_s23eobofyp0n5roimk8ar0js3` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'rubber','huarache_nm.jpg',150,'',2,1,'huarache NM'),(2,'rubber','huarache_standart.jpg',200,'',2,1,'huarache st'),(3,'cotton','anti_sweater1.jpg',100,'',1,2,'anti_black'),(4,'cotton','anti_sweater_SS17.jpg',120,'',1,2,'anti_gold'),(23,'cotton','anti_cap_pink.jpg',123,'',1,3,'anti cap red'),(24,'cotton','plases_sweaters_1.jpg',140,'',8,2,'plases_sw_one'),(25,'skin','stassy_bag_1.jpg',97,'',7,4,'stassy_bag_black_b'),(26,'skin','supreme_reflective_white.jpg',300,'',9,4,'stassy bag 23LM'),(27,'mesh','supreme_bag_1.jpg',250,'',9,4,'supreme bag white'),(28,'mesh','seupreme_bag_2.jpg',240,'',9,4,'supreme bag blue');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_orders`
--

DROP TABLE IF EXISTS `goods_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods_orders` (
  `goods_id` bigint(20) NOT NULL,
  `orders_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`goods_id`,`orders_user_id`),
  KEY `FK_h87afqxw10kajloht0ev92hbr` (`orders_user_id`),
  CONSTRAINT `FK_h87afqxw10kajloht0ev92hbr` FOREIGN KEY (`orders_user_id`) REFERENCES `orders` (`user_id`),
  CONSTRAINT `FK_okhg4447b9qjh34nm4porkr4l` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_orders`
--

LOCK TABLES `goods_orders` WRITE;
/*!40000 ALTER TABLE `goods_orders` DISABLE KEYS */;
INSERT INTO `goods_orders` VALUES (1,3),(1,4),(3,4),(1,5);
/*!40000 ALTER TABLE `goods_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturers`
--

DROP TABLE IF EXISTS `manufacturers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manufacturers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturers`
--

LOCK TABLES `manufacturers` WRITE;
/*!40000 ALTER TABLE `manufacturers` DISABLE KEYS */;
INSERT INTO `manufacturers` VALUES (1,'USA','anti_social_social_club_logo.jpg','Anti social social club'),(2,'Mexico','huarache_logo.jpeg','Huarache'),(6,'italy','kappa_logo.jfif','kappa'),(7,'france','stassy_logo.png','stassy'),(8,'USA','plases_logo.jpg','plases'),(9,'USA','supreme_logo.png','supreme');
/*!40000 ALTER TABLE `manufacturers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK_k8kupdtcdpqd57b6j4yq9uvdj` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (3),(4),(5);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types`
--

DROP TABLE IF EXISTS `types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` VALUES (1,'shues'),(2,'sweaters'),(3,'caps'),(4,'bags');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'','Ivan','Arabchuk','$2a$04$lAdkzWtznduci9NrAKY20OTTjvwRfA6c0kG.vaAWCLqBsQ98pEYgK','ROLE_USER','ivanko'),(2,'\0','Roman','Romanec','$2a$04$bSfSBMlbTdO1p8kVBdMSLOT8ISeLnj1ddSsXgyfWOqc.ckcDnruW6','ROLE_USER','romanko'),(3,'','Ivan','Arabchuk','$2a$10$yg7njpsG7qk/.TOwso3VWeDVdG1/NkGS4saPxfxjHh0x36NvdyqF6','ROLE_USER','Vanyan'),(4,'','Roman','Gav','$2a$10$9qJsNajvR4epagA7HOnp5usL7L3c5K3gUF6KPBczDxgL7a7GutGHm','ROLE_USER','qwe'),(5,'','Tanya','Goshiy','$2a$10$/i9sHgN/XcI6g2dM.yIIi.kjn7PkAdVqqeqFtgjf7/ZZX6v.ODedG','ROLE_USER','tanya'),(6,'','admin','admin','$2a$10$B8XK6JBp3ZGNkIU4FodtX.Dxo5dZM6gBUd4.MtekHXF7F0MTVdsrG','ROLE_ADMIN','admin'),(7,'','user','user','$2a$10$/vnr6Snwt2u3FpOiu.4E.eADBw7wU1436fS6rHwANUCWGik2bgh.e','ROLE_USER','user');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-13  0:31:51
