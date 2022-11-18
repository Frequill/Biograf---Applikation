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
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `staff_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `salary` varchar(100) DEFAULT NULL,
  `salt1` varchar(50) DEFAULT NULL,
  `email_address` varchar(100) DEFAULT NULL,
  `salt2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`staff_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Toros Cuthulu','ý\Z÷[!ÆîÎ\n7qÛ­ã¨<ì6çw’ZfvÎq¦8)ÃSÎx»M:žrHwL¿\"y¡','33f2f61ccb566b71bdc87fc76666c5f8','ù{}ìïwÔP4‡ÆNÐcÖ<Ä‹Ú—ªƒKMñÿ;<§¸Œ›l˜ºå^ É¨Ž~Yê¾V\0ÖàgÌ','26e0a72f262e22bca498f1515fdc4f18'),(2,'Kenth Agent','Èý»©Bã^Ý‚]B°ÁN*&Ç@‰à½…+U¶çû†|÷VfÂ%˜S±&','94599b3e774065c1c671eb690999e371','A	æ\"\"GghŒv­€dlò—J+ã.ä¼©äZÌ“ÆUa‹\\ÌD I4…“5\'Úó¼\'‡N]dJdæ-Ý¤ª','09e48566b5e99ce13f3c77b39d51bb25'),(3,'Olof Palmé','VðÀßúêõxF}c‘æp¬Ý®uÅÕJM+”äWP`ëHPCï¤­õv%kD+rÏGø','88023933b4f9477b35ac18067e51c209','L.ôhÎ†Š\\VY!6•_¹Â„Â‘ò?Fsšžƒ•òß¹Â”†ÇéšÄ§ÆÁW@k©½gå²érU¶„','315f64e84a45e962649bd063241337fe'),(4,'Switch Bitch','ƒR\r–ÑÉ#çGÝýµb¯61äÈÈÚ(²Vüû›	=]Y7›;ËP£ÃfnÂ»','5fcacca8680549e5ef8f9678378fbb9a','¨%ðRd&!—åtN8™´Ç¸Ïn[‰È­ŽB«	ð:F¸Ï:‡h\"Tx	Nåêü?<ÕîÑýëÂÎÜñ!Üô4','40d769e4d94528140f42448d84d830ac'),(5,'Bjorn Pettersson','<=\n2¡%¸äüR	QJž„òºEô•NÝž<g¯h÷ëÎt¦\\vëÕAJ\r¼','05bf0a939963badc4717572b9eac9f9f','\\ŸLý°ðÍãýz‡áÐ²EXÅ\rÏ£¤4ñíÂËšmG®Ý¤ÁÐõ°-#¨Þ˜(/`´Y¤Q\ZàÄo)X','a202a6c2c1c24d7135eea0594b117f94'),(6,'Alkis Supesson','ô\r÷&ŽËËþö³¢ÿTÉ‰yMIk9á3Cs!Nï–ó3›âM´‘úÌ¥F{>Ë5“','3e9dc3df591d6322f0ebcad1ae854992','£ßôÂ´k$SFÌ¸=m”l>7—)~wSºTlRýÖ·«zÉo¾{&á3âeLx°\ZVÁÃP9¬;Àa	','074c3d2c15141308e80f941718a45045'),(7,'Newton Kaffe Maskin','L%\0Œ–x“DB‡·Džu\\¥? ]ÊQ8‚ã›gÈ“eN†ðõªÇq','3838554e56118cc73e7b3c805edbf1a8','ëFîàH(Of5A*:bø9™æýñÅÌ>¸áè:\\&lÝˆoÿæ;U¦ê}*¾G-?ÛúËê_aMÛXûr–\"DH','06e193f428a3679816e02b5ba73011eb'),(8,'Luke Skywalker','¨à°ù å¬©¨ò:È»îíÞïÕ¯\'¦ìn!Û¹óâÛTu¯¯„jåžÚpºÌÒÃ¶ ','8b367f1d7384fb919f9006c45cae174e','ªòÝò khG\nÆ3Bc×‡Â0¨|£0S™BŒ—û²uëð³o^Æâoâ¥ÛöÆâ‘€`+‚H\nq0UBHdÁÊÍ','7b83437779305f87750ed8d8bf7a26c4'),(9,'Leif GW Persson','q“XtòÂ³àú¦EƒTƒ»*n±«é…_]+ó4o¶¥‚à*ý•‰íÉ¢çü0ot','8e5630e8f3c717e407d2db78b539c07f','dšM‘oŒ}ðÁ©Ü0®¯@™ÎOrRáá‚Z\0(eØšä°$/º÷A¹ öK‘t&ò\nºŒÉ®K¾ýdjì°I›Ñù','1c67ac036e27183b0ce08b15c6432bb4'),(10,'Karl XVI Gustav','Ð|¯œøÌÄ\ZSäuØïî^I&U lÆzàÈ¸öõõ“ÙÓ¶À·É:Úð6bü¾','71bd1a32cf324a9e76384b78ce1beea6','iÓbôÇ±\\<Ó#«èrœî—ˆ4ëŒ×Wrky8‹íÝÆ^¥L!ÐßÄ=‘É›Íú©ÏÞòªÝÕxt»06z','3034f273837c22caca2abe82485fa817');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
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
