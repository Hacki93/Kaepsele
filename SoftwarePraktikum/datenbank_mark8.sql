-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: db_kaepsele
-- ------------------------------------------------------
-- Server version	5.7.7-rc-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `benutzername` varchar(45) DEFAULT NULL,
  `passwort` varchar(45) DEFAULT NULL,
  `emailAdresse` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benutzer`
--

DROP TABLE IF EXISTS `benutzer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `benutzer` (
  `benutzer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `rang` int(11) DEFAULT NULL,
  `geburtsdatum` date DEFAULT NULL,
  `beruf` varchar(45) DEFAULT NULL,
  `studiengang` varchar(45) DEFAULT NULL,
  `erstelltAm` date DEFAULT NULL,
  `adresse` varchar(45) DEFAULT NULL,
  `pinnwand_id` int(11) DEFAULT NULL,
  `profilbildurl` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`benutzer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benutzer`
--

LOCK TABLES `benutzer` WRITE;
/*!40000 ALTER TABLE `benutzer` DISABLE KEYS */;
/*!40000 ALTER TABLE `benutzer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benutzer_freunde`
--

DROP TABLE IF EXISTS `benutzer_freunde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `benutzer_freunde` (
  `benutzer_id` int(11) NOT NULL,
  `freunde_id` int(11) NOT NULL,
  PRIMARY KEY (`benutzer_id`,`freunde_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benutzer_freunde`
--

LOCK TABLES `benutzer_freunde` WRITE;
/*!40000 ALTER TABLE `benutzer_freunde` DISABLE KEYS */;
/*!40000 ALTER TABLE `benutzer_freunde` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bossfight`
--

DROP TABLE IF EXISTS `bossfight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bossfight` (
  `bossfight_id` int(11) NOT NULL AUTO_INCREMENT,
  `medium_id` int(11) DEFAULT NULL,
  `gruppe_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`bossfight_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bossfight`
--

LOCK TABLES `bossfight` WRITE;
/*!40000 ALTER TABLE `bossfight` DISABLE KEYS */;
/*!40000 ALTER TABLE `bossfight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bossfight_antworten`
--

DROP TABLE IF EXISTS `bossfight_antworten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bossfight_antworten` (
  `bossfight_id` int(11) NOT NULL DEFAULT '0',
  `antworten` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`bossfight_id`,`antworten`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bossfight_antworten`
--

LOCK TABLES `bossfight_antworten` WRITE;
/*!40000 ALTER TABLE `bossfight_antworten` DISABLE KEYS */;
/*!40000 ALTER TABLE `bossfight_antworten` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `challenge`
--

DROP TABLE IF EXISTS `challenge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `challenge` (
  `challenge_id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `erreichbarePunktzahl` int(11) DEFAULT NULL,
  `erreichtePunktzahl` int(11) DEFAULT NULL,
  `benutzer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`challenge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challenge`
--

LOCK TABLES `challenge` WRITE;
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fachrichtung`
--

DROP TABLE IF EXISTS `fachrichtung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fachrichtung` (
  `fachrichtung_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `freigegeben` bit(1) DEFAULT NULL,
  PRIMARY KEY (`fachrichtung_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fachrichtung`
--

LOCK TABLES `fachrichtung` WRITE;
/*!40000 ALTER TABLE `fachrichtung` DISABLE KEYS */;
/*!40000 ALTER TABLE `fachrichtung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frage`
--

DROP TABLE IF EXISTS `frage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frage` (
  `frage_id` int(11) NOT NULL AUTO_INCREMENT,
  `medium_id` int(11) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `bearbeitet` bit(1) DEFAULT NULL,
  `benutzer_id` int(11) DEFAULT NULL,
  `fragenpool_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`frage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frage`
--

LOCK TABLES `frage` WRITE;
/*!40000 ALTER TABLE `frage` DISABLE KEYS */;
/*!40000 ALTER TABLE `frage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frage_antworten`
--

DROP TABLE IF EXISTS `frage_antworten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frage_antworten` (
  `frage_id` int(11) NOT NULL DEFAULT '0',
  `antworten` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`frage_id`,`antworten`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frage_antworten`
--

LOCK TABLES `frage_antworten` WRITE;
/*!40000 ALTER TABLE `frage_antworten` DISABLE KEYS */;
/*!40000 ALTER TABLE `frage_antworten` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frage_antwortmoeglichkeiten`
--

DROP TABLE IF EXISTS `frage_antwortmoeglichkeiten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frage_antwortmoeglichkeiten` (
  `frage_id` int(11) NOT NULL DEFAULT '0',
  `antwortmoeglichkeiten` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`frage_id`,`antwortmoeglichkeiten`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frage_antwortmoeglichkeiten`
--

LOCK TABLES `frage_antwortmoeglichkeiten` WRITE;
/*!40000 ALTER TABLE `frage_antwortmoeglichkeiten` DISABLE KEYS */;
/*!40000 ALTER TABLE `frage_antwortmoeglichkeiten` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frage_loesung`
--

DROP TABLE IF EXISTS `frage_loesung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frage_loesung` (
  `frage_id` int(11) NOT NULL DEFAULT '0',
  `loesung` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`frage_id`,`loesung`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frage_loesung`
--

LOCK TABLES `frage_loesung` WRITE;
/*!40000 ALTER TABLE `frage_loesung` DISABLE KEYS */;
/*!40000 ALTER TABLE `frage_loesung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fragenpool`
--

DROP TABLE IF EXISTS `fragenpool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fragenpool` (
  `fragenpool_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fragenpool_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fragenpool`
--

LOCK TABLES `fragenpool` WRITE;
/*!40000 ALTER TABLE `fragenpool` DISABLE KEYS */;
/*!40000 ALTER TABLE `fragenpool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gruppe`
--

DROP TABLE IF EXISTS `gruppe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gruppe` (
  `gruppen_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `klausurname` varchar(45) DEFAULT NULL,
  `freigegeben` bit(1) DEFAULT NULL,
  `fachrichtung_id` int(11) DEFAULT NULL,
  `pinnwand_id` int(11) DEFAULT NULL,
  `fragenpool_id` int(11) DEFAULT NULL,
  `profilbildurl` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`gruppen_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppe`
--

LOCK TABLES `gruppe` WRITE;
/*!40000 ALTER TABLE `gruppe` DISABLE KEYS */;
/*!40000 ALTER TABLE `gruppe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gruppen_mitglieder`
--

DROP TABLE IF EXISTS `gruppen_mitglieder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gruppen_mitglieder` (
  `gruppen_id` int(11) NOT NULL,
  `benutzer_id` int(11) NOT NULL,
  PRIMARY KEY (`gruppen_id`,`benutzer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppen_mitglieder`
--

LOCK TABLES `gruppen_mitglieder` WRITE;
/*!40000 ALTER TABLE `gruppen_mitglieder` DISABLE KEYS */;
/*!40000 ALTER TABLE `gruppen_mitglieder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gruppen_moderatoren`
--

DROP TABLE IF EXISTS `gruppen_moderatoren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gruppen_moderatoren` (
  `gruppen_id` int(11) NOT NULL,
  `benutzer_id` int(11) NOT NULL,
  PRIMARY KEY (`gruppen_id`,`benutzer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppen_moderatoren`
--

LOCK TABLES `gruppen_moderatoren` WRITE;
/*!40000 ALTER TABLE `gruppen_moderatoren` DISABLE KEYS */;
/*!40000 ALTER TABLE `gruppen_moderatoren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inhalt`
--

DROP TABLE IF EXISTS `inhalt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inhalt` (
  `inhalt_id` int(11) NOT NULL AUTO_INCREMENT,
  `bewertung` int(11) DEFAULT '0',
  `inhalt` varchar(45) DEFAULT NULL,
  `titel` varchar(45) DEFAULT NULL,
  `erstelltAm` date DEFAULT NULL,
  `benutzer_id` int(11) DEFAULT NULL,
  `medium_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`inhalt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inhalt`
--

LOCK TABLES `inhalt` WRITE;
/*!40000 ALTER TABLE `inhalt` DISABLE KEYS */;
/*!40000 ALTER TABLE `inhalt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kommentar`
--

DROP TABLE IF EXISTS `kommentar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kommentar` (
  `kommentar_id` int(11) NOT NULL AUTO_INCREMENT,
  `thema_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`kommentar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kommentar`
--

LOCK TABLES `kommentar` WRITE;
/*!40000 ALTER TABLE `kommentar` DISABLE KEYS */;
/*!40000 ALTER TABLE `kommentar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medium`
--

DROP TABLE IF EXISTS `medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medium` (
  `medium_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `dateiname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`medium_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medium`
--

LOCK TABLES `medium` WRITE;
/*!40000 ALTER TABLE `medium` DISABLE KEYS */;
/*!40000 ALTER TABLE `medium` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nachricht`
--

DROP TABLE IF EXISTS `nachricht`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nachricht` (
  `nachricht_id` int(11) NOT NULL AUTO_INCREMENT,
  `titel` varchar(45) DEFAULT NULL,
  `inhalt` varchar(45) DEFAULT NULL,
  `handlungErforderlich` bit(1) DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `adressat_benutzer_id` int(11) DEFAULT NULL,
  `sender_benutzer_id` int(11) DEFAULT NULL,
  `typ` int(11) DEFAULT NULL,
  PRIMARY KEY (`nachricht_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nachricht`
--

LOCK TABLES `nachricht` WRITE;
/*!40000 ALTER TABLE `nachricht` DISABLE KEYS */;
/*!40000 ALTER TABLE `nachricht` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinnwand`
--

DROP TABLE IF EXISTS `pinnwand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinnwand` (
  `pinnwand_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pinnwand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinnwand`
--

LOCK TABLES `pinnwand` WRITE;
/*!40000 ALTER TABLE `pinnwand` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinnwand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinnwand_erlaubtebenutzer`
--

DROP TABLE IF EXISTS `pinnwand_erlaubtebenutzer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinnwand_erlaubtebenutzer` (
  `benutzer_id` int(11) NOT NULL,
  `pinnwand_id` int(11) NOT NULL,
  PRIMARY KEY (`benutzer_id`,`pinnwand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinnwand_erlaubtebenutzer`
--

LOCK TABLES `pinnwand_erlaubtebenutzer` WRITE;
/*!40000 ALTER TABLE `pinnwand_erlaubtebenutzer` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinnwand_erlaubtebenutzer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest`
--

DROP TABLE IF EXISTS `quest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quest` (
  `quest_id` int(11) NOT NULL AUTO_INCREMENT,
  `gruppe_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`quest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest`
--

LOCK TABLES `quest` WRITE;
/*!40000 ALTER TABLE `quest` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_fragen`
--

DROP TABLE IF EXISTS `quest_fragen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quest_fragen` (
  `quest_id` int(11) NOT NULL,
  `frage_id` varchar(45) NOT NULL,
  PRIMARY KEY (`quest_id`,`frage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_fragen`
--

LOCK TABLES `quest_fragen` WRITE;
/*!40000 ALTER TABLE `quest_fragen` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest_fragen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teamcombat`
--

DROP TABLE IF EXISTS `teamcombat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teamcombat` (
  `teamcombat_id` int(11) NOT NULL AUTO_INCREMENT,
  `ablaufdatum` date DEFAULT NULL,
  `gewinnerpunkte` int(11) DEFAULT NULL,
  PRIMARY KEY (`teamcombat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teamcombat`
--

LOCK TABLES `teamcombat` WRITE;
/*!40000 ALTER TABLE `teamcombat` DISABLE KEYS */;
/*!40000 ALTER TABLE `teamcombat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thema`
--

DROP TABLE IF EXISTS `thema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thema` (
  `thema_id` int(11) NOT NULL AUTO_INCREMENT,
  `pinnwand_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`thema_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thema`
--

LOCK TABLES `thema` WRITE;
/*!40000 ALTER TABLE `thema` DISABLE KEYS */;
/*!40000 ALTER TABLE `thema` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-14 16:49:47
