CREATE DATABASE  IF NOT EXISTS `umldc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `umldc`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: umldc
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `version`
--

DROP TABLE IF EXISTS `version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `version` (
  `idVersion` int(11) NOT NULL AUTO_INCREMENT,
  `ultimaActualizacion` datetime NOT NULL,
  `comentario` varchar(200) DEFAULT NULL,
  `quien` varchar(45) NOT NULL,
  `idDiagramaDeClase` int(11) NOT NULL,
  PRIMARY KEY (`idVersion`),
  KEY `idDiagramaDeClase_idx` (`idDiagramaDeClase`),
  CONSTRAINT `idDiagramaDeClaseVersion` FOREIGN KEY (`idDiagramaDeClase`) REFERENCES `diagramadeclase` (`idDiagramaDeClase`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `version`
--

LOCK TABLES `version` WRITE;
/*!40000 ALTER TABLE `version` DISABLE KEYS */;
INSERT INTO `version` VALUES (3,'2018-01-28 15:39:55','Primer prueba con web y mail','nico crack',7),(4,'2018-04-10 12:05:07','Mi primer Version','10-4-2019',8),(5,'2018-04-22 19:38:42','Prueba de Abril','Nicolas y Hernan',2),(6,'2018-05-25 19:53:05','Prueba creacion desde cero','Nicolas Perez',11),(7,'2018-06-18 20:49:55','Prueba con metodos abreviados','NicoJunio viva Belgica',2),(8,'2018-06-19 13:13:54','Senagal esta ganando','Odio a Polonia',2),(9,'2018-06-20 12:41:38','Hace mas goles Uruguay','Arabia es muy buena',12);
/*!40000 ALTER TABLE `version` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-08 20:33:51
