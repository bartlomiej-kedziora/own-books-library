-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: book
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `author_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Forress','Scotland','Graham','Masterton',1960),(2,'Portland','USA','Stephen','King',1947);
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `genre` varchar(255) DEFAULT NULL,
  `series` varchar(255) DEFAULT NULL,
  `title_en` varchar(255) DEFAULT NULL,
  `title_pl` varchar(255) DEFAULT NULL,
  `year` int(11) NOT NULL,
  `homecollection_id` bigint(20) DEFAULT NULL,
  `myscore_id` bigint(20) DEFAULT NULL,
  `worldscore_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `FK5pp5r40ifhe9yrol30y7yqwa5` (`homecollection_id`),
  KEY `FKjd3xwd3o8850lpp3wftoe7wjr` (`myscore_id`),
  KEY `FK5sgxe4o2tnj8n9vwg1aodn6s4` (`worldscore_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'horror','first series','ManitouE','ManitouP',1999,1,1,1);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forms`
--

DROP TABLE IF EXISTS `forms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forms` (
  `form_id` bigint(20) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `homecollection_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`form_id`),
  KEY `FK1lemlhcniwfha83irprny9923` (`homecollection_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forms`
--

LOCK TABLES `forms` WRITE;
/*!40000 ALTER TABLE `forms` DISABLE KEYS */;
/*!40000 ALTER TABLE `forms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1),(1),(1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homecollection`
--

DROP TABLE IF EXISTS `homecollection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homecollection` (
  `homecollection_id` bigint(20) NOT NULL,
  PRIMARY KEY (`homecollection_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homecollection`
--

LOCK TABLES `homecollection` WRITE;
/*!40000 ALTER TABLE `homecollection` DISABLE KEYS */;
INSERT INTO `homecollection` VALUES (1);
/*!40000 ALTER TABLE `homecollection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `join_author_book`
--

DROP TABLE IF EXISTS `join_author_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `join_author_book` (
  `book_id` bigint(20) NOT NULL,
  `author_id` bigint(20) NOT NULL,
  KEY `FKemcnesrtrqw5ujexh8rxyy1n3` (`author_id`),
  KEY `FKtfbcees7ejkdscp0ahndgn52r` (`book_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `join_author_book`
--

LOCK TABLES `join_author_book` WRITE;
/*!40000 ALTER TABLE `join_author_book` DISABLE KEYS */;
INSERT INTO `join_author_book` VALUES (1,1);
/*!40000 ALTER TABLE `join_author_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `langs`
--

DROP TABLE IF EXISTS `langs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `langs` (
  `lang_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  `homecollection_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`lang_id`),
  KEY `FKtiuvnnjj043bvuasww1bmke2m` (`homecollection_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `langs`
--

LOCK TABLES `langs` WRITE;
/*!40000 ALTER TABLE `langs` DISABLE KEYS */;
/*!40000 ALTER TABLE `langs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myscore`
--

DROP TABLE IF EXISTS `myscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `myscore` (
  `myscore_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` int(11) NOT NULL,
  PRIMARY KEY (`myscore_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myscore`
--

LOCK TABLES `myscore` WRITE;
/*!40000 ALTER TABLE `myscore` DISABLE KEYS */;
INSERT INTO `myscore` VALUES (1,1);
/*!40000 ALTER TABLE `myscore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worldscore`
--

DROP TABLE IF EXISTS `worldscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worldscore` (
  `worldscore_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` int(11) NOT NULL,
  PRIMARY KEY (`worldscore_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worldscore`
--

LOCK TABLES `worldscore` WRITE;
/*!40000 ALTER TABLE `worldscore` DISABLE KEYS */;
INSERT INTO `worldscore` VALUES (1,1);
/*!40000 ALTER TABLE `worldscore` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-04 10:07:33
