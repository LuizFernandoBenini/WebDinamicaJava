-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `Enderecos`
--

DROP TABLE IF EXISTS `Enderecos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Enderecos` (
  `idEndereco` bigint NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(45) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `localidade` varchar(45) NOT NULL,
  `uf` char(2) NOT NULL,
  `cep` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Enderecos`
--

LOCK TABLES `Enderecos` WRITE;
/*!40000 ALTER TABLE `Enderecos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Enderecos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Funcionarios`
--

DROP TABLE IF EXISTS `Funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Funcionarios` (
  `idFuncionario` bigint NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` varchar(45) NOT NULL,
  `cpf` char(11) NOT NULL,
  `rg` varchar(10) NOT NULL,
  `crm` char(5) NOT NULL,
  `Enderecos_idEnderecos` bigint NOT NULL,
  `tipoFuncionario_idtipoFuncionario` bigint NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  UNIQUE KEY `crm_UNIQUE` (`crm`),
  KEY `fk_Funcionarios_Enderecos1_idx` (`Enderecos_idEnderecos`),
  KEY `fk_Funcionarios_tipoFuncionario1_idx` (`tipoFuncionario_idtipoFuncionario`),
  CONSTRAINT `fk_Funcionarios_Enderecos1` FOREIGN KEY (`Enderecos_idEnderecos`) REFERENCES `Enderecos` (`idEndereco`),
  CONSTRAINT `fk_Funcionarios_tipoFuncionario1` FOREIGN KEY (`tipoFuncionario_idtipoFuncionario`) REFERENCES `tipoFuncionario` (`idtipoFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Funcionarios`
--

LOCK TABLES `Funcionarios` WRITE;
/*!40000 ALTER TABLE `Funcionarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `Funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pacientes`
--

DROP TABLE IF EXISTS `Pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pacientes` (
  `idPaciente` bigint NOT NULL AUTO_INCREMENT,
  `nomePaciente` varchar(45) NOT NULL,
  `cpf` char(11) NOT NULL,
  `sexo` char(1) NOT NULL,
  `dataNascimento` date NOT NULL,
  `tipoSanguineo` varchar(3) DEFAULT NULL,
  `endereco` bigint NOT NULL,
  PRIMARY KEY (`idPaciente`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  KEY `fk_Pacientes_Enderecos1_idx` (`endereco`),
  CONSTRAINT `fk_Pacientes_Enderecos1` FOREIGN KEY (`endereco`) REFERENCES `Enderecos` (`idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pacientes`
--

LOCK TABLES `Pacientes` WRITE;
/*!40000 ALTER TABLE `Pacientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `Pacientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prontuarios`
--

DROP TABLE IF EXISTS `Prontuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prontuarios` (
  `idProntuario` bigint NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `Pacientes_idPaciente` bigint NOT NULL,
  `Funcionarios_idFuncionario` bigint NOT NULL,
  PRIMARY KEY (`idProntuario`),
  KEY `fk_Prontuarios_Pacientes1_idx` (`Pacientes_idPaciente`),
  KEY `fk_Prontuarios_Funcionarios1_idx` (`Funcionarios_idFuncionario`),
  CONSTRAINT `fk_Prontuarios_Funcionarios1` FOREIGN KEY (`Funcionarios_idFuncionario`) REFERENCES `Funcionarios` (`idFuncionario`),
  CONSTRAINT `fk_Prontuarios_Pacientes1` FOREIGN KEY (`Pacientes_idPaciente`) REFERENCES `Pacientes` (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prontuarios`
--

LOCK TABLES `Prontuarios` WRITE;
/*!40000 ALTER TABLE `Prontuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `Prontuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoFuncionario`
--

DROP TABLE IF EXISTS `tipoFuncionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoFuncionario` (
  `idtipoFuncionario` bigint NOT NULL AUTO_INCREMENT,
  `nomeTipoFuncionario` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idtipoFuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoFuncionario`
--

LOCK TABLES `tipoFuncionario` WRITE;
/*!40000 ALTER TABLE `tipoFuncionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoFuncionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-05 19:29:00
