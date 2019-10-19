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
-- Table structure for table `atributo`
--

DROP TABLE IF EXISTS `atributo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atributo` (
  `idAtributo` int(11) NOT NULL AUTO_INCREMENT,
  `privilegio` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `idClase` int(11) NOT NULL,
  PRIMARY KEY (`idAtributo`),
  KEY `idClase_idx` (`idClase`),
  CONSTRAINT `idClaseAtributo` FOREIGN KEY (`idClase`) REFERENCES `clase` (`idClase`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atributo`
--

LOCK TABLES `atributo` WRITE;
/*!40000 ALTER TABLE `atributo` DISABLE KEYS */;
INSERT INTO `atributo` VALUES (14,'Publica','int','id',17),(22,'Privada','int','legajo',24),(23,'Publica','String','nombre',24),(26,'Privada','int','idJefe',29),(27,'Privada','int','idEmpleado',26),(30,'Privada','int','idPersona',39),(31,'Privada','String','nombre',39),(32,'Privada','int','anioDeIngreso',39),(33,'Privada','int','idContacto',40),(34,'Privada','String','email',40),(35,'Privada','int','idEmpresa',41),(36,'Privada','String','direccion',41),(37,'Privada','int','idSucursal',42),(38,'Privada','String','nombreSucursal',42),(39,'Privada','int','idAeropuerto',43),(40,'Privada','String','nombre',43),(41,'Privada','String','direccion',43),(42,'Protected','String','telefono',43),(43,'Privada','int','idAvion',44),(44,'Publica','int','cantidadDePasajeros',44),(45,'Publica','float','pesoMaximo',44),(46,'Privada','int','idComponente',45),(47,'Privada','String','nombre',45),(48,'Privada','int','idPrecio',46),(49,'Privada','float','descuento',46),(50,'Privada','int','tipo',46),(51,'Privada','int','legajo',47),(52,'Privada','int','anioDeIngreso',47),(53,'Privada','int','dni',49),(54,'Privada','String','nombre',49),(55,'Privada','String','apellido',49),(56,'Publica','String','celular',49),(57,'Privada','int','numeroViajero',48),(58,'Privada','float','precioPagado',48),(59,'Privada','String','fechaActualizacion',50),(60,'Privada','float','dni',52),(61,'Privada','Calendar','fechaNacimiento',52),(62,'Privada','String','nombre',52),(63,'Privada','int','idJugador',56),(64,'Protected','String','nombre',56),(65,'Sin Definir','Calendar','fecha',56);
/*!40000 ALTER TABLE `atributo` ENABLE KEYS */;
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
