CREATE DATABASE  IF NOT EXISTS `fenix_laser_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fenix_laser_db`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fenix_laser_db
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'grill-parrilla'),(2,'cuchillos'),(3,'relojes'),(4,'accesorios'),(5,'personalizados');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones_usuario`
--

DROP TABLE IF EXISTS `direcciones_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direcciones_usuario` (
  `id_direccion` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `calle` varchar(100) NOT NULL,
  `numero_externo` varchar(10) NOT NULL,
  `numero_interno` varchar(10) DEFAULT NULL,
  `colonia` varchar(100) NOT NULL,
  `codigo_postal` varchar(10) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `referencia` text,
  PRIMARY KEY (`id_direccion`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `direcciones_usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones_usuario`
--

LOCK TABLES `direcciones_usuario` WRITE;
/*!40000 ALTER TABLE `direcciones_usuario` DISABLE KEYS */;
INSERT INTO `direcciones_usuario` VALUES (1,1,'Siempre Falsa','123','4','Lic. Fake','54923','Nezahualcóyotl','Edomex',NULL),(2,2,'Av. Siempre Viva','742','A','Springfield','57000','Nezahualcóyotl','Edomex',NULL),(3,3,'Paseo de la Falsedad','500','Piso 10','Juárez','06600','Cuauhtémoc','CDMX',NULL),(4,4,'Camino Fake','15',NULL,'San José','54010','Tlalnepantla','Edomex',NULL),(5,5,'Calle de la Amargura','666','Interior 2','El Olvido','52140','Metepec','Edomex',NULL);
/*!40000 ALTER TABLE `direcciones_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiquetas`
--

DROP TABLE IF EXISTS `etiquetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etiquetas` (
  `id_etiqueta` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_etiqueta`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiquetas`
--

LOCK TABLES `etiquetas` WRITE;
/*!40000 ALTER TABLE `etiquetas` DISABLE KEYS */;
INSERT INTO `etiquetas` VALUES (1,'combo'),(2,'parrilla'),(3,'premium'),(4,'madera'),(5,'hacha'),(11,'cuchillos');
/*!40000 ALTER TABLE `etiquetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagenes_producto`
--

DROP TABLE IF EXISTS `imagenes_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagenes_producto` (
  `id_imagen` int NOT NULL AUTO_INCREMENT,
  `id_producto` int NOT NULL,
  `url` text NOT NULL,
  PRIMARY KEY (`id_imagen`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `imagenes_producto_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagenes_producto`
--

LOCK TABLES `imagenes_producto` WRITE;
/*!40000 ALTER TABLE `imagenes_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `imagenes_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagos` (
  `id_pago` int NOT NULL AUTO_INCREMENT,
  `id_pedido` int NOT NULL,
  `metodo` varchar(50) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `estado` varchar(30) DEFAULT 'pagado',
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_pago`),
  KEY `id_pedido` (`id_pedido`),
  CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
INSERT INTO `pagos` VALUES (6,1,'Tarjeta de crédito',2999.00,'pagado','2026-02-01 09:00:00'),(7,2,'Tarjeta de débito',2499.00,'pagado','2026-02-03 12:30:00'),(8,3,'Transferencia',699.00,'pendiente','2026-02-05 15:45:00'),(9,4,'Tarjeta de crédito',399.00,'rechazado','2026-02-07 10:15:00'),(10,5,'PayPal',499.00,'pagado','2026-02-09 18:00:00');
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_detalle`
--

DROP TABLE IF EXISTS `pedido_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_detalle` (
  `id_detalle` int NOT NULL AUTO_INCREMENT,
  `id_pedido` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `id_pedido` (`id_pedido`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `pedido_detalle_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`),
  CONSTRAINT `pedido_detalle_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_detalle`
--

LOCK TABLES `pedido_detalle` WRITE;
/*!40000 ALTER TABLE `pedido_detalle` DISABLE KEYS */;
INSERT INTO `pedido_detalle` VALUES (1,1,1,1,2999.00),(2,2,2,1,2499.00),(3,3,3,1,699.00),(4,4,4,1,399.00),(5,5,5,1,499.00);
/*!40000 ALTER TABLE `pedido_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `estado` varchar(30) DEFAULT 'pendiente',
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `direccion_envio` text NOT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,1,2999.00,'Completado','2026-02-01 09:00:00','Calle Falsa 123, Cdmx'),(2,2,2499.00,'Enviado','2026-02-03 12:30:00','Av. Siempre Viva 742, Guadalajara'),(3,3,699.00,'Pendiente','2026-02-05 15:45:00','Paseo de la Reforma 50, Monterrey'),(4,4,399.00,'Procesando','2026-02-07 10:15:00','Calle 10 sur #405, Puebla'),(5,5,499.00,'Cancelado','2026-02-09 18:00:00','Av. Benito Juárez 101, Querétaro');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_etiqueta`
--

DROP TABLE IF EXISTS `producto_etiqueta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_etiqueta` (
  `id_producto` int NOT NULL,
  `id_etiqueta` int NOT NULL,
  PRIMARY KEY (`id_producto`,`id_etiqueta`),
  KEY `id_etiqueta` (`id_etiqueta`),
  CONSTRAINT `producto_etiqueta_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  CONSTRAINT `producto_etiqueta_ibfk_2` FOREIGN KEY (`id_etiqueta`) REFERENCES `etiquetas` (`id_etiqueta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_etiqueta`
--

LOCK TABLES `producto_etiqueta` WRITE;
/*!40000 ALTER TABLE `producto_etiqueta` DISABLE KEYS */;
INSERT INTO `producto_etiqueta` VALUES (1,1),(2,1),(1,2),(2,2),(1,3),(4,5),(3,11),(5,11);
/*!40000 ALTER TABLE `producto_etiqueta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text,
  `precio` decimal(10,2) NOT NULL,
  `imagen` text,
  `rating` decimal(2,1) DEFAULT NULL,
  `visible_catalogo` tinyint(1) DEFAULT '1',
  `visible_recomendados` tinyint(1) DEFAULT '0',
  `id_categoria` int DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Combo doble','Grill Box Doble 9 kg + Tabla y Hacha',2999.00,'https://lh3.googleusercontent.com/u/0/d/17cC8N54pIF_xy9Kr1eqbhiu3gVPOgEsG',4.8,1,1,1),(2,'Super Combo','Grill Box Sencilla 6 kg + Tabla y Hacha',2499.00,'https://lh3.googleusercontent.com/u/0/d/1EtkaVTyKK2pXNBq6feGtC0QEBJshNp2t',4.7,1,2,1),(3,'Set de cuchillos','Set de cuchillos profesionales',699.00,'https://lh3.googleusercontent.com/u/0/d/1JtHDWnaTV4lFFW2z4i2-TRWdw4sTTvzh',4.9,1,2,2),(4,'Hacha','Hacha para carne',399.00,'https://lh3.googleusercontent.com/u/0/d/1q6mKj2-7FK7Zu4-yzxjY0ZLdKoNmcFSq',4.6,1,2,4),(5,'Cuchillo chef','Cuchillo chef profesional',499.00,'https://lh3.googleusercontent.com/u/0/d/1zxcGi6dd2FgAMYUdddJcyMusbpRapyZC',4.8,1,2,4);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` varchar(20) DEFAULT 'cliente',
  `fecha_registro` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Adrián Espinoza','adrian.esp@mail.com','+525512345678','Adri2024','cliente','2023-05-12 10:30:00'),(2,'Mariana Valdés','m.valdes92@provisional.net','+56987654321','Mar123','cliente','2023-06-01 14:15:22'),(3,'Roberto Olvera','roberto_dev@tech.org','+34600112233','Rob_88','cliente','2023-08-15 09:45:10'),(4,'Sofía Castillo','sofi.cast@webmail.com','+541122334455','Sofi99!','cliente','2023-09-20 18:20:05'),(5,'Fernando Ruiz','fruiz_ventas@empresa.com','+573004455667','Fer.2023','cliente','2023-11-11 11:11:11');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-09 15:43:50
