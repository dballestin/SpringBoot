CREATE DATABASE  IF NOT EXISTS `elementos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `elementos`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: elementos
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `elementos`
--

DROP TABLE IF EXISTS `elementos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `elementos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Elementos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementos`
--

LOCK TABLES `elementos` WRITE;
/*!40000 ALTER TABLE `elementos` DISABLE KEYS */;
INSERT INTO `elementos` VALUES (4,'Lagarto'),(2,'Papel'),(1,'Piedra'),(5,'Spock'),(3,'Tijeras');
/*!40000 ALTER TABLE `elementos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elementosjuegos`
--

DROP TABLE IF EXISTS `elementosjuegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `elementosjuegos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `elemento_id` int NOT NULL,
  `juego_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_elementojuego` (`elemento_id`,`juego_id`),
  KEY `fk_elementos_idx` (`elemento_id`),
  KEY `fk_juegos_idx` (`juego_id`),
  CONSTRAINT `fk_elementos` FOREIGN KEY (`elemento_id`) REFERENCES `elementos` (`id`),
  CONSTRAINT `fk_juegos` FOREIGN KEY (`juego_id`) REFERENCES `juegos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Elementos de cada juego';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementosjuegos`
--

LOCK TABLES `elementosjuegos` WRITE;
/*!40000 ALTER TABLE `elementosjuegos` DISABLE KEYS */;
INSERT INTO `elementosjuegos` VALUES (1,1,1),(4,1,2),(2,2,1),(5,2,2),(3,3,1),(6,3,2),(7,4,2),(8,5,2);
/*!40000 ALTER TABLE `elementosjuegos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juegos`
--

DROP TABLE IF EXISTS `juegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juegos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Juegos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juegos`
--

LOCK TABLES `juegos` WRITE;
/*!40000 ALTER TABLE `juegos` DISABLE KEYS */;
INSERT INTO `juegos` VALUES (1,'PiedraPapelTijeras','Clásico juego de Piedra, Papel o Tijeras'),(2,'PiedraPapelTijerasLagartoSpock','Versión extendida del juego de Piedra, Papel o Tijeras con 2 elementos nuevos: Lagarto y Spock. Conocido por la serie Big Bang Theory');
/*!40000 ALTER TABLE `juegos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reglas`
--

DROP TABLE IF EXISTS `reglas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reglas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `elemento_ganador_id` int NOT NULL,
  `elemento_perdedor_id` int NOT NULL,
  `juego_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_regla` (`elemento_ganador_id`,`elemento_perdedor_id`,`juego_id`),
  KEY `fk_elemento_ganador_idx` (`elemento_ganador_id`),
  KEY `fk_elemento_perdedor_idx` (`elemento_perdedor_id`),
  KEY `fk_juego_idx` (`juego_id`),
  CONSTRAINT `fk_elemento_ganador` FOREIGN KEY (`elemento_ganador_id`) REFERENCES `elementos` (`id`),
  CONSTRAINT `fk_elemento_perdedor` FOREIGN KEY (`elemento_perdedor_id`) REFERENCES `elementos` (`id`),
  CONSTRAINT `fk_juego` FOREIGN KEY (`juego_id`) REFERENCES `juegos` (`id`),
  CONSTRAINT `dist_elementos` CHECK ((`elemento_ganador_id` <> `elemento_perdedor_id`))
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Reglas de los juegos de los elementos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reglas`
--

LOCK TABLES `reglas` WRITE;
/*!40000 ALTER TABLE `reglas` DISABLE KEYS */;
INSERT INTO `reglas` VALUES (1,1,3,1),(4,1,3,2),(5,1,4,2),(2,2,1,1),(6,2,1,2),(7,2,5,2),(3,3,2,1),(8,3,2,2),(9,3,4,2),(10,4,2,2),(11,4,5,2),(12,5,1,2),(13,5,3,2);
/*!40000 ALTER TABLE `reglas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-28 17:04:37
