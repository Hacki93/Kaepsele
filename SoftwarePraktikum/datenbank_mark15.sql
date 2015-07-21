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
  `benutzername` varchar(200) DEFAULT NULL,
  `passwort` varchar(200) DEFAULT NULL,
  `emailAdresse` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'hannes','39dfbd98328c657ae83dfddac21cf292','mail@hannes-fischer.com'),(2,'lenchen','25d55ad283aa400af464c76d713c07ad','lenamai.er@web.de');
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
-- Table structure for table `aufgabe`
--

DROP TABLE IF EXISTS `aufgabe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aufgabe` (
  `aufgabe_id` int(11) NOT NULL AUTO_INCREMENT,
  `senderGruppe_id` int(11) DEFAULT NULL,
  `senderBenutzer_id` int(11) DEFAULT NULL,
  `empfaengerBenutzer_id` int(11) DEFAULT NULL,
  `anhangTeamcombat_id` int(11) DEFAULT NULL,
  `anhangBossfight_id` int(11) DEFAULT NULL,
  `anhangGruppe_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`aufgabe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aufgabe`
--

LOCK TABLES `aufgabe` WRITE;
/*!40000 ALTER TABLE `aufgabe` DISABLE KEYS */;
/*!40000 ALTER TABLE `aufgabe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benutzer`
--

DROP TABLE IF EXISTS `benutzer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `benutzer` (
  `benutzer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `rang` int(11) DEFAULT NULL,
  `geburtsdatum` varchar(200) DEFAULT NULL,
  `beruf` varchar(200) DEFAULT NULL,
  `studiengang` varchar(200) DEFAULT NULL,
  `erstelltAm` varchar(200) DEFAULT NULL,
  `adresse` varchar(200) DEFAULT NULL,
  `pinnwand_id` int(11) DEFAULT NULL,
  `profilbildurl` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`benutzer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benutzer`
--

LOCK TABLES `benutzer` WRITE;
/*!40000 ALTER TABLE `benutzer` DISABLE KEYS */;
INSERT INTO `benutzer` VALUES (1,'Hannes Fischer',1000,'01/26/1995','Student','Wirtschaftsinformatik B.Sc.','21/07/2015','Bühlenstr. 100, 71088 Holzgerlingen',1,'/Bild.png'),(2,'Lena Maier',2,'31/12/1993','Student','Wirtschaftsinformatik B.Sc.','21/07/2015','Schopfloch',2,'/Bild.png');
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
INSERT INTO `benutzer_freunde` VALUES (1,2),(2,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bossfight`
--

LOCK TABLES `bossfight` WRITE;
/*!40000 ALTER TABLE `bossfight` DISABLE KEYS */;
INSERT INTO `bossfight` VALUES (1,NULL,1);
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
  `antworten` varchar(20000) DEFAULT NULL,
  PRIMARY KEY (`bossfight_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bossfight_antworten`
--

LOCK TABLES `bossfight_antworten` WRITE;
/*!40000 ALTER TABLE `bossfight_antworten` DISABLE KEYS */;
INSERT INTO `bossfight_antworten` VALUES (1,'42');
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
  `datum` varchar(200) DEFAULT NULL,
  `erreichbarePunktzahl` int(11) DEFAULT NULL,
  `erreichtePunktzahl` int(11) DEFAULT NULL,
  `benutzer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`challenge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challenge`
--

LOCK TABLES `challenge` WRITE;
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
INSERT INTO `challenge` VALUES (1,'21/07/2015',0,0,NULL),(2,'21/07/2015',3,3,1),(3,'21/07/2015',0,0,NULL),(4,'21/07/2015',3,0,NULL);
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
  `name` varchar(200) DEFAULT NULL,
  `freigegeben` bit(1) DEFAULT NULL,
  PRIMARY KEY (`fachrichtung_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fachrichtung`
--

LOCK TABLES `fachrichtung` WRITE;
/*!40000 ALTER TABLE `fachrichtung` DISABLE KEYS */;
INSERT INTO `fachrichtung` VALUES (1,NULL,'\0'),(2,NULL,'\0'),(3,'Wirtschaftsinformatik','\0');
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
  `text` varchar(20000) DEFAULT NULL,
  `benutzer_id` int(11) DEFAULT NULL,
  `fragenpool_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`frage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frage`
--

LOCK TABLES `frage` WRITE;
/*!40000 ALTER TABLE `frage` DISABLE KEYS */;
INSERT INTO `frage` VALUES (1,2,'Willst Du mit mir gehn?',2,1),(2,3,'Willst Du mit mir gehn?',2,2);
/*!40000 ALTER TABLE `frage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frage_antwortmoeglichkeiten`
--

DROP TABLE IF EXISTS `frage_antwortmoeglichkeiten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frage_antwortmoeglichkeiten` (
  `frage_id` int(11) NOT NULL DEFAULT '0',
  `antwortmoeglichkeiten` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`frage_id`,`antwortmoeglichkeiten`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frage_antwortmoeglichkeiten`
--

LOCK TABLES `frage_antwortmoeglichkeiten` WRITE;
/*!40000 ALTER TABLE `frage_antwortmoeglichkeiten` DISABLE KEYS */;
INSERT INTO `frage_antwortmoeglichkeiten` VALUES (1,'Ja'),(1,'Nein'),(1,'Vielleicht'),(2,'Ja'),(2,'Nein'),(2,'Vielleicht');
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
  `loesung` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`frage_id`,`loesung`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frage_loesung`
--

LOCK TABLES `frage_loesung` WRITE;
/*!40000 ALTER TABLE `frage_loesung` DISABLE KEYS */;
INSERT INTO `frage_loesung` VALUES (2,'Ja');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fragenpool`
--

LOCK TABLES `fragenpool` WRITE;
/*!40000 ALTER TABLE `fragenpool` DISABLE KEYS */;
INSERT INTO `fragenpool` VALUES (1),(2);
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
  `name` varchar(10000) DEFAULT NULL,
  `klausurname` varchar(200) DEFAULT NULL,
  `freigegeben` bit(1) DEFAULT NULL,
  `fachrichtung_id` int(11) DEFAULT NULL,
  `pinnwand_id` int(11) DEFAULT NULL,
  `fragenpool_id` int(11) DEFAULT NULL,
  `profilbildurl` varchar(10000) DEFAULT NULL,
  `erstelltAm` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`gruppen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppe`
--

LOCK TABLES `gruppe` WRITE;
/*!40000 ALTER TABLE `gruppe` DISABLE KEYS */;
INSERT INTO `gruppe` VALUES (1,'Betriebliche Informations- und Kommunikationssyseme','BIKS 1','\0',3,3,1,'/Gruppenbild.png','21/07/2015'),(2,'Management betrieblicher Informationssysteme','MBIS 1','\0',3,4,2,'/BIKS.png','21/07/2015');
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
INSERT INTO `gruppen_mitglieder` VALUES (1,1),(1,2),(2,1);
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
INSERT INTO `gruppen_moderatoren` VALUES (1,1),(2,1);
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
  `inhalt` varchar(20000) DEFAULT NULL,
  `titel` varchar(200) DEFAULT NULL,
  `erstelltAm` varchar(200) DEFAULT NULL,
  `benutzer_id` int(11) DEFAULT NULL,
  `medium_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`inhalt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inhalt`
--

LOCK TABLES `inhalt` WRITE;
/*!40000 ALTER TABLE `inhalt` DISABLE KEYS */;
INSERT INTO `inhalt` VALUES (1,5,'Themeninhalt von Hannes','Thementitel von Hannes','2015-07-21 23:19:37.927',1,1),(2,25,'Themeninhalt von Lena','Thementitel von Lena','2015-07-21 23:19:37.937',2,NULL),(3,1,'Themeninhalt von Lena','Thementitel von Lena','2015-07-21 23:19:37.947',2,NULL),(4,205,'Themeninhalt von Lena','Thementitel von Lena','2015-07-21 23:19:37.957',2,NULL),(5,21,'Themeninhalt von Lena','Thementitel von Lena','2015-07-21 23:19:37.967',2,NULL),(6,34,'Themeninhalt von hannes','Thementitel von hannes','2015-07-21 23:19:37.977',1,NULL),(7,34,'Themeninhalt von hannes','Thementitel von hannes','2015-07-21 23:19:37.987',1,NULL),(8,4,'Themeninhalt von Lenchen','Thementitel von lenchen','2015-07-21 23:19:37.997',2,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
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
  `name` varchar(200) DEFAULT NULL,
  `dateiname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`medium_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medium`
--

LOCK TABLES `medium` WRITE;
/*!40000 ALTER TABLE `medium` DISABLE KEYS */;
INSERT INTO `medium` VALUES (1,'Entwurf','Entwurf.pdf'),(2,NULL,NULL),(3,NULL,NULL);
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
  `titel` varchar(200) DEFAULT NULL,
  `inhalt` varchar(10000) DEFAULT NULL,
  `datum` varchar(200) DEFAULT NULL,
  `typ` int(11) DEFAULT NULL,
  `empfaenger_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`nachricht_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nachricht`
--

LOCK TABLES `nachricht` WRITE;
/*!40000 ALTER TABLE `nachricht` DISABLE KEYS */;
INSERT INTO `nachricht` VALUES (1,'Du hast einen neuen Freund','Lena Maier hat Dich zur Freundesliste hinzugefügt','21/07/2015 23:19',0,1),(2,'Du hast einen neuen Freund','Hannes Fischer hat Dich zur Freundesliste hinzugefügt','21/07/2015 23:19',0,2),(3,'Teamcombat ausgewertet','Betriebliche Informations- und Kommunikationssysemehat den Teamcombat gewonnen','21/07/2015 23:19',6,1),(4,'Teamcombat ausgewertet','Betriebliche Informations- und Kommunikationssysemehat den Teamcombat gewonnen','21/07/2015 23:19',6,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinnwand`
--

LOCK TABLES `pinnwand` WRITE;
/*!40000 ALTER TABLE `pinnwand` DISABLE KEYS */;
INSERT INTO `pinnwand` VALUES (1),(2),(3),(4);
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
INSERT INTO `pinnwand_erlaubtebenutzer` VALUES (1,1),(1,2),(1,3),(1,4),(2,1),(2,2),(2,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest`
--

LOCK TABLES `quest` WRITE;
/*!40000 ALTER TABLE `quest` DISABLE KEYS */;
INSERT INTO `quest` VALUES (2,1),(3,2),(4,1);
/*!40000 ALTER TABLE `quest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_antworten`
--

DROP TABLE IF EXISTS `quest_antworten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quest_antworten` (
  `frage_id` int(11) NOT NULL DEFAULT '0',
  `antworten` varchar(200) NOT NULL,
  PRIMARY KEY (`frage_id`,`antworten`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_antworten`
--

LOCK TABLES `quest_antworten` WRITE;
/*!40000 ALTER TABLE `quest_antworten` DISABLE KEYS */;
INSERT INTO `quest_antworten` VALUES (2,'1;!!;!Ja');
/*!40000 ALTER TABLE `quest_antworten` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_fragen`
--

DROP TABLE IF EXISTS `quest_fragen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quest_fragen` (
  `quest_id` int(11) NOT NULL,
  `frage_id` int(11) NOT NULL,
  PRIMARY KEY (`quest_id`,`frage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_fragen`
--

LOCK TABLES `quest_fragen` WRITE;
/*!40000 ALTER TABLE `quest_fragen` DISABLE KEYS */;
INSERT INTO `quest_fragen` VALUES (2,1),(3,1),(4,2);
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
  `ablaufdatum` varchar(200) DEFAULT NULL,
  `herausforderer_gruppe_id` int(11) DEFAULT NULL,
  `herausgeforderter_gruppe_id` int(11) DEFAULT NULL,
  `herausforderer_quest_id` int(11) DEFAULT NULL,
  `herausgeforderter_quest_id` int(11) DEFAULT NULL,
  `gewinner_gruppe_id` int(11) DEFAULT NULL,
  `gewinnerpunkte` int(11) DEFAULT NULL,
  PRIMARY KEY (`teamcombat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teamcombat`
--

LOCK TABLES `teamcombat` WRITE;
/*!40000 ALTER TABLE `teamcombat` DISABLE KEYS */;
INSERT INTO `teamcombat` VALUES (1,'2015-07-24 23:19:48.31',2,1,3,4,1,0);
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
  `pinnwand_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`thema_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thema`
--

LOCK TABLES `thema` WRITE;
/*!40000 ALTER TABLE `thema` DISABLE KEYS */;
INSERT INTO `thema` VALUES (1,1),(2,1),(3,1),(4,1),(5,2),(6,2),(7,3),(8,3);
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

-- Dump completed on 2015-07-21 23:20:51
