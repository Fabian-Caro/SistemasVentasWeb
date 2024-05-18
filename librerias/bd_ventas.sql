CREATE DATABASE  IF NOT EXISTS `bd_ventas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_ventas`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_ventas
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `IdCliente` int unsigned NOT NULL AUTO_INCREMENT,
  `Dni` varchar(8) DEFAULT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Direccion` varchar(244) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`IdCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (17,'2','Juan Guerrero Solis','Los Alamos','1'),(18,'1','Maria Rosas Villanueva','Los Laureles 234','1'),(19,'3','Andres de Santa Cruz','Av. La Frontera 347','1'),(20,'4','Andres Mendoza','Chosica, Lurigancho','1'),(27,'88','Dorlan Pabon','6°15′24″N 75°35′25″O','0');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ventas`
--

DROP TABLE IF EXISTS `detalle_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_ventas` (
  `IdDetalleVentas` int unsigned NOT NULL AUTO_INCREMENT,
  `IdVentas` int unsigned NOT NULL,
  `IdProducto` int unsigned NOT NULL,
  `Cantidad` int unsigned DEFAULT NULL,
  `PrecioVenta` double DEFAULT NULL,
  PRIMARY KEY (`IdDetalleVentas`,`IdVentas`,`IdProducto`),
  KEY `Ventas_has_Producto_FKIndex1` (`IdVentas`),
  KEY `Ventas_has_Producto_FKIndex2` (`IdProducto`),
  CONSTRAINT `detalle_ventas_ibfk_1` FOREIGN KEY (`IdVentas`) REFERENCES `ventas` (`IdVentas`),
  CONSTRAINT `detalle_ventas_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=211 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ventas`
--

LOCK TABLES `detalle_ventas` WRITE;
/*!40000 ALTER TABLE `detalle_ventas` DISABLE KEYS */;
INSERT INTO `detalle_ventas` VALUES (155,96,1,1,150),(156,96,2,1,20),(157,96,3,1,800),(158,97,1,1,150),(159,97,2,1,20),(160,97,3,1,800),(161,97,4,3,500),(162,98,1,1,150),(163,98,1,1,150),(164,99,1,4,150),(165,99,2,3,20),(166,99,3,5,800),(167,99,4,3,500),(168,99,7,5,22),(169,100,1,5,150),(170,101,1,5,150),(171,101,1,0,150),(172,101,2,8,20),(173,101,3,10,800),(174,101,4,8,500),(175,101,7,5,22),(176,102,2,1,20),(177,103,2,1,20),(178,103,1,1,150),(179,103,2,1,20),(180,103,3,1,800),(181,104,2,1,20),(182,104,1,1,150),(183,104,3,1,800),(184,105,2,1,20),(185,105,1,1,150),(186,105,3,1,800),(187,106,2,1,20),(188,106,1,1,150),(189,106,3,1,800),(190,107,2,1,20),(191,107,3,1,800),(192,108,2,1,20),(193,109,1,1,150),(194,109,2,1,20),(195,110,2,1,20),(196,111,2,1,20),(197,112,2,1,20),(198,113,2,1,20),(199,114,2,1,20),(200,115,2,1,20),(201,116,2,1,20),(202,117,2,1,20),(203,118,3,1,800),(204,121,2,3,20),(205,122,2,4,20),(206,123,2,1,20),(207,124,2,1,20),(208,125,2,1,20),(209,126,11,1,42000),(210,127,2,9,20);
/*!40000 ALTER TABLE `detalle_ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `IdEmpleado` int unsigned NOT NULL AUTO_INCREMENT,
  `Dni` varchar(8) NOT NULL,
  `Nombres` varchar(255) DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  `User` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`IdEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'123','Pedro Hernandez','988252459','1','emp01'),(2,'123','Roman Riquelme','988252459','1','Jo46'),(3,'123','Palermo Suarez','453536458','1','Em22'),(8,'123','Giovanni Moreno','310010101','0','G10'),(9,'123','Macnelly Torres','310101010','0','Mac10');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `IdProducto` int unsigned NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(244) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int unsigned DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`IdProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Saya no Uta',35000,100,'1'),(2,'Tengen Toppa Gurren Lagann [BD]',350000,50,'1'),(3,'Laptop Lenovo Ideapad 520',800,84,'1'),(4,'HeadPhones Sony M333',500,90,'1'),(7,'I AM A HERO [Manga]',25000,30,'1'),(11,'Higurashi no naku koro ni [Visual Novel]',42000,99,'1'),(14,'doHna:doHna [Visual Novel]',58000,100,'1'),(15,'NieR:Automata',72000,100,'1');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `IdVentas` int unsigned NOT NULL AUTO_INCREMENT,
  `IdCliente` int unsigned NOT NULL,
  `IdEmpleado` int unsigned NOT NULL,
  `NumeroSerie` varchar(244) DEFAULT NULL,
  `FechaVentas` date DEFAULT NULL,
  `Monto` double DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`IdVentas`),
  KEY `Ventas_FKIndex1` (`IdEmpleado`),
  KEY `Ventas_FKIndex2` (`IdCliente`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`),
  CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (94,17,2,'00000001','2024-10-20',800,'1'),(95,17,2,'00000002','2024-10-20',800,'1'),(96,17,2,'00000003','2024-10-20',800,'1'),(97,18,2,'00000004','2024-10-20',500,'1'),(98,18,2,'00000005','2024-10-20',150,'1'),(99,18,2,'00000006','2024-10-20',22,'1'),(100,18,2,'00000007','2024-10-20',150,'1'),(101,20,2,'00000008','2024-10-20',22,'1'),(102,18,2,'00000009','2024-10-20',20,'1'),(103,18,2,'00000010','2024-10-20',800,'1'),(104,18,2,'00000011','2024-10-20',800,'1'),(105,18,2,'00000012','2024-10-20',800,'1'),(106,20,2,'00000013','2024-10-20',800,'1'),(107,18,2,'00000014','2024-10-20',800,'1'),(108,19,2,'00000015','2024-10-20',20,'1'),(109,17,2,'00000016','2024-10-20',20,'1'),(110,18,2,'00000017','2024-10-20',20,'1'),(111,18,2,'00000018','2024-10-20',20,'1'),(112,18,2,'00000019','2024-10-20',20,'1'),(113,18,2,'00000020','2024-10-20',20,'1'),(114,18,2,'00000021','2024-10-20',20,'1'),(115,18,2,'00000022','2024-10-20',20,'1'),(116,18,2,'00000023','2024-10-20',20,'1'),(117,18,2,'00000024','2024-10-20',20,'1'),(118,17,2,'00000025','2024-10-20',800,'1'),(119,17,2,'00000026','2024-10-20',800,'1'),(120,17,2,'00000027','2024-10-20',800,'1'),(121,18,2,'00000028','2024-10-20',20,'1'),(122,18,2,'00000029','2024-10-20',20,'1'),(123,27,2,'00000030','2024-10-20',20,'1'),(124,27,2,'00000031','2024-10-20',20,'1'),(125,27,2,'00000032','2024-10-20',20,'1'),(126,27,2,'00000033','2024-10-20',42000,'1'),(127,18,2,'00000034','2024-10-20',20,'1');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-18 16:30:44
