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
-- Table structure for table `metodo`
--

DROP TABLE IF EXISTS `metodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metodo` (
  `idMetodo` int(11) NOT NULL AUTO_INCREMENT,
  `privilegio` varchar(45) NOT NULL,
  `retorno` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `idClase` int(11) NOT NULL,
  PRIMARY KEY (`idMetodo`),
  KEY `idClase_idx` (`idClase`),
  CONSTRAINT `idClaseMetodo` FOREIGN KEY (`idClase`) REFERENCES `clase` (`idClase`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodo`
--

LOCK TABLES `metodo` WRITE;
/*!40000 ALTER TABLE `metodo` DISABLE KEYS */;
INSERT INTO `metodo` VALUES (8,'Estatico','String','agregarEdad',17),(10,'Privada','Int','calcularSueldo',24),(12,'Protected','Int','calcularSueldoNeto',29),(13,'Publica','Void','terminarContrato',26),(14,'Publica','Void','enviarEmail',40),(16,'Publica','String','mostrarPrecios',43),(17,'Publica','String','repararComponente',44),(18,'Publica','Int','calcularPrecio',45),(19,'Publica','String','mostrarRuta',51),(20,'Publica','String','mostrarTripulacion',51),(21,'Publica','Void','hacerCheckIn',48),(22,'Publica','Void','subirAAvion',48),(23,'Publica','String','mostrarArrivos',50),(24,'Publica','String','mostrarTiempoDeDespegue',50),(25,'Publica','float','pedirAumento',49),(26,'Publica','Int','calcularGoles',56);
/*!40000 ALTER TABLE `metodo` ENABLE KEYS */;
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
