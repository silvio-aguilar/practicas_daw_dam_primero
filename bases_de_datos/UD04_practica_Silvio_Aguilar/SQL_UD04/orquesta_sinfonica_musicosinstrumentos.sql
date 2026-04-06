-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: orquesta_sinfonica
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `musicosinstrumentos`
--

DROP TABLE IF EXISTS `musicosinstrumentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musicosinstrumentos` (
  `PK_MusicosInstrumentosId` int unsigned NOT NULL,
  `FK_Musico_Id` int unsigned DEFAULT NULL,
  `FK_InstrumentoId` int unsigned DEFAULT NULL,
  `AnioEntrada` smallint DEFAULT NULL,
  PRIMARY KEY (`PK_MusicosInstrumentosId`),
  KEY `FK_Musico_Id` (`FK_Musico_Id`),
  KEY `FK_InstrumentoId` (`FK_InstrumentoId`),
  CONSTRAINT `musicosinstrumentos_ibfk_1` FOREIGN KEY (`FK_Musico_Id`) REFERENCES `musico` (`PK_MusicoId`),
  CONSTRAINT `musicosinstrumentos_ibfk_2` FOREIGN KEY (`FK_InstrumentoId`) REFERENCES `instrumento` (`PK_InstrumentoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musicosinstrumentos`
--

LOCK TABLES `musicosinstrumentos` WRITE;
/*!40000 ALTER TABLE `musicosinstrumentos` DISABLE KEYS */;
INSERT INTO `musicosinstrumentos` VALUES (1,1,1,2010),(2,2,2,2015),(3,3,3,2018),(4,4,1,2012),(5,5,4,2019),(6,6,2,2008),(7,7,3,2021),(8,8,4,2016);
/*!40000 ALTER TABLE `musicosinstrumentos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-26  0:26:47
