CREATE DATABASE  IF NOT EXISTS `furniturestore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `furniturestore`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: furniturestore
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers` (
  `supplier_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(50) DEFAULT NULL,
  `email_address` varchar(100) DEFAULT NULL,
  `salt1` varchar(100) DEFAULT NULL,
  `phone_nr` varchar(100) DEFAULT NULL,
  `salt2` varchar(100) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `postal_code` varchar(100) DEFAULT NULL,
  `salt3` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `salt4` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'Bertils stol och bord AB','xT|Úz$eBŒéb*\rJÃ´\ZÆe¡í_YÙ\n#’!÷J«t—CÉÝ$¬â—Üå£ùÞ·ZÄÃÃ\0qlÄ¾I','e5df766a2a7256d5543d94800d30fb36',';ôËÙÁ0ÒËÓêÚm:dãžkÜ‘iÀÄKœ)‹ê¨>-ÛGf™ùn_JµŸ','911d3fde93c80eacaf89e380af9be58b','Sweden','Stockholm','•h^£âÒ:.¯©(I%Oë6ç\n	Ó><DÜþÑ,óà8SkTÌ]Z\nA´•i','376da941643cbfe736822f3de543eea5','^6ÎvóPVá]í™$TE±«7Amn¦Ñ¾nNÖa}ë-ö¾½Zå“¾ÞõoÞðj—*²§£×|š6Ï€\ZµºO','a5428b0bede1bd2417bbafbd76091236'),(2,'Norrlands mubeleum INC','Ï+ÈF{ÖJ¤ˆ=©·æº&ÍU3@V[\\>b½óY^hØÐsQÄ%¬ÍyXÀä–)Ñ7F•pUÿ×ý$','d07b8bd88d7c5c7b4a6c5a8141247d22',' «¨0+AazÈ%øÄ ú¬7Ue‹œøI[ïkMmÚˆöP~C#¨šr¬‘@I¶Q','59384fd3e7d5f33e669d6e6ec6cf3c60','Sweden','Piteå','fqçýŠžBl=Î©üMŒ±ôn¹/W2a:ö%˜Ñ†ŸsþŠ3Û-“r\r’¶C½ù','4ae74156875f28c58a60ef5accbf3d70','ŠÁESgüJt2á6Úi‰›ž¨œÔ.™ÌUb=ÊX g6õ¨ò;±•g=Õ+(„{','b96cef23cd55640b364a386e1f0dcf11'),(3,'Incels4life','Çw 8eAÃäÙš›,DA†	–éýàEwMÖÀ«TB/¡®ìj•}Nö\\ ;6ëØx ¢btè¥±—O™î','905381f970c88314437363e92b96910d','ï$e^c¢vCäKÛ:v¤¥¹ðöŠø\ZmëÿpO\"ÎgÈ°,ÛjÊâ‘Eµ?{Uk','0c0c509e184654697ee9519f6e24d7ab','Japan','Kyoto','§ùãŠGöôYËò²\ržƒ/?,õ¤ïéýr‡œ1¼½6+äÖÜe-èÜJ/9!ÀsèN','b34383d23b241f6bdb81f79f588ea8d8','²TH·¸ùaû!dÃµÀõ¾¡öÅ«A¼&ŠÅ¨â}aoàHñèóOšB\n*Úëöó|','903baa8e5d54c275cca9dd9c6ae03704'),(4,'Michael Bay Explosive furniture','ß&E8é¶jÓP¤\rZÑ£ð}êkH*¯kë›ÍóºËÞuÁ&õ†=¾l(äœû§µ fT`F%×ªŽ\rÿ\n','5758f3b0723325d7855bc05a07982c24','o YZÅóäþ¬_VDrŒ¢ç`Ñ+0ëûºÏFÓ^°5ßÉ·íÌòRýXP','4504f5cf4558e9ecd492701d5a88f054','USA','Austin','»ôy¦|ýlÈ\nÖRäòn*¡  €pàÞÓï\r»©žhøÎÐQœÑÉÜ¬ˆ˜','fa43d438cd4f4c8d2744b99b29f7b5ce','¢C\0/z%/ææª{-=ùª”`þÙŽVÏ¦•TJ£´G±ÛgqP/ÿsò«#','faad2939fb0a00267dcf72e2ec525cfb'),(5,'Ich habe einen Stuhl INC','¡–bw>O\"k™\0?hD“\0¨îý©lIçÒ)®„\n t\\Š4û\np¼™­E¤ý›),¯iÔ^xÀÆXyÚÁëLd«”³ÜL›9^x','3115c6a73e76c247fb4538b6919b44a2','K5ð¹;¸½Æd€UgnF>žò–8¨¾\\ì3œÏ­‘BÜ”Ãêuíg¤\"úŠ9{m','f6fa1b655c51e33643db65993ea4a50e','Germany','Berlin','Q1±Ô“uÑ»\nj»Q,élÔÌoƒ\r”Jœ×ƒxusÛ—<œ2¢Q”ÂÜµ‰õ','530d6eb588321e9fa35ffc91eae912b4','ËÖQ$ÐÈ†Àj]©ëbs(ŠP+è§ÛÀÉ?§d]W„zO3ÛÞFæF€¢','514f07207a0efd00d523da13c8fc95ff'),(6,'Financial shituation','E8iŒ~¾D}d¹þßÿ¿-U]òvç\'z_Èkn·Ï!]gå·Å¹#QW²ÆÉÑgGŒÕ¸ `’Yò;­ƒž=žC©¤”#4¶í‡','c07d9a99d0c432028dbc48fe629ab319','XÛ½\0Ü¼B¯|DnMxãÐ$¥”^7BüM#ð¢.v‘¨Qÿ ý$ÎAyÓ@¶','21b3f8ab43d7ba9c284b4766897204a3','Sweden','Lund','Ý&©vß\\V þ*ìgä—WSwKå|:©¬óU}l¾\ZÖÕvÎ,w^¸dê:—d^=','f21142eefcd03e47eb6d8e2cde08add9','²9\r;8«¶»î\'0Eù`àæ«£>‚¤\\‰Y²<“$Y‚]É+&¸m$Ò¬–\n','7e19dd3a5a05203d9fd128eaff93a9f9');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-18 22:20:25
