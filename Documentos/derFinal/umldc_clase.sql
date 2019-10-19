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
-- Table structure for table `clase`
--

DROP TABLE IF EXISTS `clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clase` (
  `idClase` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `idVersion` int(11) NOT NULL,
  PRIMARY KEY (`idClase`),
  KEY `idVersion_idx` (`idVersion`),
  CONSTRAINT `idVersionClase` FOREIGN KEY (`idVersion`) REFERENCES `version` (`idVersion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clase`
--

LOCK TABLES `clase` WRITE;
/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
INSERT INTO `clase` VALUES (17,'Persona','Publica',4),(18,'Contacto','Publica',4),(19,'Profesion','Publica',4),(24,'Empleado','Publica',5),(25,'Contratado','Publica',5),(26,'Tercerizado','Interface',5),(29,'Jefe','Enum',5),(31,'Limpieza','Abstracta',5),(39,'Persona','Publica',6),(40,'Contacto','Publica',6),(41,'Empresa','Publica',6),(42,'Sucursal','Interface',6),(43,'AeroPuerto','Publica',7),(44,'Avion','Publica',7),(45,'Componente','Publica',7),(46,'Precio','Publica',7),(47,'Empleado','Publica',7),(48,'Pasajero','Publica',7),(49,'Persona','Publica',7),(50,'PantallaPasajero','Interface',7),(51,'FuncionesPiloto','Abstracta',7),(52,'Persona','Abstracta',8),(53,'Docente','Publica',8),(54,'NoDocente','Publica',8),(55,'Alien','Publica',8),(56,'Jugador','Publica',9);
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;
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
