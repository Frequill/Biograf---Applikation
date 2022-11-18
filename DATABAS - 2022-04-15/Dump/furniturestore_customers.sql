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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) DEFAULT NULL,
  `customer_password` varchar(100) DEFAULT NULL,
  `credit_card_info` varchar(100) DEFAULT NULL,
  `salt1` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `salt2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`customer_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Anthony Smith','967d3babff63ea993061314c61dd5bc1125c63fc3529ac89c37e3e1cbc509023','óT‰/Ï6ôþùíR]VP|·šs¡­¾šèÁçï—\r[ÖÒgÜ»¹òŒÀ˜²•Zt@¨ýYâ@:’:ç','c3c1ba12b1be5ecb682d8d8414da2304','à2JF˜Î™^xtq.ÖLw)û\Z;°ßû²­Üû®G‹\"ÒµÙ#V‚9r{¼F£í<y®½9°|e?aPÕù','62cef2464ad106590dadf8e04143e6f8'),(2,'Joakim Andersson','79d5e3dc70869dde1dfec3002f175b439121eec8927ec5d35dfd464fcd8154b7','pxš©©<S¶$kDñQ‚;;Rƒ$:”u˜¦Ãu³tÇ\nÑOL7fîÑüß=Â‡ÈÖ4òƒ­Fù4TÒ','1ca6480ae63e4763af229ad1839ff1c8','%ÙVpÀ«¤NLDhy«@_?mâ®s÷Äõy¹y@Ñ0j•\\Ó£(@ûz—Ñštq¹=ê4}N‘ÀÓïäËÒßUÙE Œœl+\Z6\"¥Z|·ÜŠP','7af8e9ab732a094e2062fac9d440e470'),(3,'Timmy \"The beard\" Nilsson','793b0232eac75fa9eb9996cfeb8e64f2bf751158079d4c9c1f3c075a959bd816','aUÚ\0RråsÌe§º¨Ó¦f’X;N&«g˜·uNåqûÏî‡ï[.Ã„òª}¸H™Ng\'ó>„;wõÇ¡a','db5f3270324229d6ac2d9e622b77da1f','ò­–\röüùJztôì½\0Ê¦æ$‚­šWŒß(˜³yº¯ah€A‚íˆüµ-ç¿|IíZ§ýh˜\0=»3çY*Æ)','93c1ccacac27bd6dc674a49ccce2e9fe'),(4,'James Bond','27a030ce0fab82f3bfba01bfd88622fc3de719192809e38bfa8d18d58eeef81e','s<RéÕF«	@ Ô%\rrt9Yh1vÒø:ÖD\n¨:‰ÌZÈ´eÂ’ì pñsZßªu¤ÕÓEÓÝo‰Î-uÞ@@^','748a65d2113b0c3aad1d06b014628ad5','é¨äŠÛ-r¯¨,Q“NzÝÀu8À1SjlS6¸mIl»Ñiåz¶Òù%,\\zÎÍñq','d5ae236a5b6cb6c226c57942bb4535e1'),(5,'Sqaure Bob Cirkle-pants','e74b79b03380d4abb9e765743ca6ee19477ff9833e1d4b859fc3f37d670b7675','•^ ·k\0ÐD–%óx÷ÀqÒ(\\®õ2–e®ù²$ùDuUÕ¸¢n¸o¨Ãl vEDdÜ”þ¦\"…½','1aa507f4960699451ccb079ae2f8667a','¸d::Hò­ÎESþu‡ÉL¸­‹‹/\'NCÁoóƒà”of‰k{”ÃCÎË~·sÂD\'Û˜ðùOS','ba62d72607f43f4ddb1f87d9b68103f8'),(6,'Michael Jacksson','f33642111c79b7406e50feae51b7e83474b2a362109ef0fe975b2c2c95ef6889','Âh¨Ž5ñùÙº+ü·\n×\0Y¾L›Ž-¤M)Ñàë4V×¥ÈZHº~l5Z38/ž¢y¦gïN kZh!Ÿf','35c313f84ad5f4f44d33c0527b6ca575','b\'å¥ÏOïs&P“­±7¸ü$¢¬ÀP `ì¥Ì*¼ÃLÄp™*á*w_r\"Ðý\0×±d\r3Eû','0e23354c46cb2fa2912d07e7102d0a5a'),(7,'Pickachu Pokésson','8fc1ca4a09bf485c32856ba4ac6322b1834f05ee5da5c779c97286786e565387','ŸÃV-yë ™>’…\rys~*¦“ž“î37¾D\'¯ØE/…GlvXŽ`\\eH!’z/40áÆx\0G','97cd2bf6ef911f1c60491de7ebfd2e59','ÌÕêÍß?Vvy»LÊ‰d¿ÑìÐ+:±ß.É“`»ßhþuâ#¦ÂçŠërú‘Ö×z‡~1T^U!Ëi¤šy','f59f1e1cf97209fd2fa3e92628d0c5ce'),(8,'Bill \"bygg om hela din kod\" Palmestedt','da78434615c8e5bb54e5b3a42b8e7ff5bd7230908d59a389f6b3cf7383828426','¼ß óýJ—-Jû 3^àïŸBÄqàì*¦Û¦Ý´Ûb—ò¤Ÿzî=\r´¿¦„…ù’Éas‰€˜YnÝP¶áY','2913e6ab1c5b2c8f1efc09165fc3e588','·œ\ZŽ6â^;å‡`gâ#ÛÄÃ˜L\\Þ@TœÌMÄ£:;áêäuS‚°®¨wÌ…€{\n4ü²†øç','e4e605270fe68f61e6284f336bfa6ebd'),(9,'Freddie Mercury','2697581ebcf437f9ed7c3fcab9e09a01172e44adb40a50f281cdd31e671b7f37','êoÜ9Ÿ–î\"¼¹.»/<¼¼q˜I`\'öó¢¥ØÕ45z:¯lëjb\0ö$\0ÞÚÚ¯:ª¼Às¹K˜öß™¢:','151865472f74f7a706ce78bc4b9f9800','BV^}?ë™ø‘”½›ÐÑÉ-¬$Ê¢*Àðœ\'‚l Ë·¨F°^p&kÈq^¥µpŒL¿r0fl‚ÑôD…','be1b1b9fb9d24fe53986371a60e0a7bf'),(10,'Toros Cthulhu','167289cad5ac0a22fb0807ee89521c71e3f7383a28a117192eaf5f9821af0623','U[,öK,Zë«Äé]P^Ç˜#¬)ø]\rß\0-¾3©‡Ñ¥0Ô]»Ë‚+¯/GÖ0 ¬<ö÷ê{b¢Såo%x','21919e1b4476add5e2c97d9d987a26f5','ßÃU¶‰Š8c™[N>d>Ì³FÌµ\0ýÝ\r\0œz{EùhíKŒKUöDG£¼9aú<øOÂf75âçÒcÎ¶±´{Äq’pZè«dbÂé','5a38aed7189010a6dc5a40898f2b5e29'),(11,'Julius \"caesar\" Thomsen','a7e8c8306dca9f21ccd576de873255a69fce4ee85b289dd89986cc91805baef3','f$,êagz\"Â´C#éÕå0ÊÃƒ¬:/­”Ü“§¥zSŒÊìî5ð Ü)oŒ&³bfuû˜O–;²ô9','9e845c757a1dc0dd3a0ab28677f973df','ÀSkzW¼J/óÁY ‚Tª‚ïÀš@ &jøÎrµ´«YcmâfÌ«\0!«Ÿ%±‹\'’ª±œª\"€Ñÿ¯K§é‡TÉdoÞà\\ñÓ8vbhÝÆàâ°	Çr«Hø\Z','6e398de3310787f98304eb118dfa87c7');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
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
