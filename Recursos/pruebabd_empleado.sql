-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: pruebabd
-- ------------------------------------------------------
-- Server version	8.0.21


--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `tipo_documento` varchar(25) DEFAULT NULL,
  `numero_documento` varchar(25) DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `fecha_vinculacion` datetime DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `salario` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Jhonatan','Realpe','Cedula','123923892','1999-04-26 13:00:00','2003-04-26 13:00:00','Administrador',3000000.00),(2,'Juan','Martinez','Cedula','123923892','1993-04-26 00:00:00','2013-08-26 13:00:00','Gestor',2000000.00),(3,'PruebaSoap','quien','Cedula','121234565','2000-12-12 00:00:00','2020-04-03 00:00:00','Admin',20000.00);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;