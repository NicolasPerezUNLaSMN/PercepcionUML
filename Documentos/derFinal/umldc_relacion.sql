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
-- Table structure for table `relacion`
--

DROP TABLE IF EXISTS `relacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relacion` (
  `idRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `tipoRelacion` varchar(45) NOT NULL,
  `clase` varchar(45) NOT NULL,
  `idClase` int(11) NOT NULL,
  `inicioRelacion` varchar(45) DEFAULT NULL,
  `finRelacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRelacion`),
  KEY `idClase_idx` (`idClase`),
  CONSTRAINT `idClaseRelacion` FOREIGN KEY (`idClase`) REFERENCES `clase` (`idClase`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relacion`
--

LOCK TABLES `relacion` WRITE;
/*!40000 ALTER TABLE `relacion` DISABLE KEYS */;
INSERT INTO `relacion` VALUES (8,'Composicion','Profesion',17,'0..1','1..*'),(15,'Composicion','Tercerizado',24,'0..1','1..*'),(17,'Dependencia','Tercerizado',29,'0..1','1..*'),(18,'Composicion','Jefe',26,'0..1','0..*'),(19,'Implementacion','Jefe',31,'0..1','0..1'),(20,'Dependencia','Contratado',25,'0..*','0..*'),(21,'Hereda de','Jefe',25,'',''),(22,'Composicion','Empleado',29,'1..*','1..*'),(23,'Composicion','Contacto',39,'0..1','1..*'),(24,'Composicion','Persona',41,'1..*','1..*'),(25,'Hereda de','Empresa',42,'',''),(26,'Composicion','Avion',43,'1..*','1..*'),(27,'Agregacion','Persona',43,'1..*','1..*'),(28,'Composicion','Componente',44,'1..*','1..*'),(29,'Implementacion','Precio',45,'1..*','0..1'),(31,'Hereda de','Empleado',49,'',''),(32,'Hereda de','Pasajero',49,'',''),(33,'Implementacion','PantallaPasajero',48,'',''),(34,'Implementacion','Empleado',51,'',''),(35,'Hereda a','Docente',52,'',''),(36,'Hereda a','NoDocente',52,'',''),(37,'Hereda de','Alien',52,'',''),(38,'Dependencia','Docente',55,'',''),(39,'Implementacion','NoDocente',55,'','');
/*!40000 ALTER TABLE `relacion` ENABLE KEYS */;
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
