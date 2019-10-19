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
-- Table structure for table `diagramadeclase`
--

DROP TABLE IF EXISTS `diagramadeclase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagramadeclase` (
  `idDiagramaDeClase` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) DEFAULT NULL,
  `emailCreador` varchar(45) NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  PRIMARY KEY (`idDiagramaDeClase`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagramadeclase`
--

LOCK TABLES `diagramadeclase` WRITE;
/*!40000 ALTER TABLE `diagramadeclase` DISABLE KEYS */;
INSERT INTO `diagramadeclase` VALUES (1,'Primer','nico_perez','wiii'),(2,'Segundo','nico_FEO','wouuu'),(3,'Tercero','nico_wi','wouuu'),(4,'Primer diagrama generado por web','nico_perez_velez@hotmail.com','datos.RandomString@73ce9113'),(5,'Llegara el mail','nico_perez_velez@hotmail.com','HAWKWJU76WQ3H1ARXM'),(6,'Primer envio por mail','nico_perez_velez@hotmail.com','QV7SN7WRTQP1LZCW19'),(7,'y ahora...','nico_perez_velez@hotmail.com','JWQ5DBRB5KOCBFNIKY'),(8,'PrimeroConHernan','nykolaiperez@gmail.com','6VXT73Y9YH61EHJNCW'),(9,'Primer diagrama sin contrasenia aleatoria','nykolaiperez@gmail.com','wouuu'),(10,'Manda Mail','nykolaiperez@gmail.com','QYW6B0WUHNB56D8QLJ'),(11,'Probando25-5','nicoperez','nicoperez'),(12,'mi diagrama Uruguay','nico_perez_velez@hotmail.com','pepepompin');
/*!40000 ALTER TABLE `diagramadeclase` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-08 20:33:52
