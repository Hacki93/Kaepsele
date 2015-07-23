CREATE DATABASE  IF NOT EXISTS `db_kaepsele` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_kaepsele`;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'hannes','39dfbd98328c657ae83dfddac21cf292','mail@hannes-fischer.com'),(2,'lenchen','25d55ad283aa400af464c76d713c07ad','lenamai.er@web.de'),(3,'richard','25d55ad283aa400af464c76d713c07ad','lenamai.er@web.de'),(4,'stefanie','25d55ad283aa400af464c76d713c07ad','lenamai.er@web.de'),(5,'paula','25d55ad283aa400af464c76d713c07ad','lenamai.er@web.de'),(6,'hans','25d55ad283aa400af464c76d713c07ad','lenamai.er@web.de'),(7,'philipp','25d55ad283aa400af464c76d713c07ad','lenamai.er@web.de'),(8,'nicole','25d55ad283aa400af464c76d713c07ad','lenamai.er@web.de');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aufgabe`
--

LOCK TABLES `aufgabe` WRITE;
/*!40000 ALTER TABLE `aufgabe` DISABLE KEYS */;
INSERT INTO `aufgabe` VALUES (1,2,NULL,1,1,NULL,NULL),(2,2,NULL,1,1,NULL,NULL),(10,2,NULL,2,1,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benutzer`
--

LOCK TABLES `benutzer` WRITE;
/*!40000 ALTER TABLE `benutzer` DISABLE KEYS */;
INSERT INTO `benutzer` VALUES (1,'Hannes Fischer',1000,'01/26/1995','Student','vwlsinformatik B.Sc.','23/07/2015','Bühlenstr. 100, 71088 Holzgerlingen',1,'/Bild.png'),(2,'Lena Maier',2,'31/12/1993','Student','vwlsinformatik B.Sc.','23/07/2015','Schopfloch',2,'/Bild.png'),(3,'Richard Laumayer',20,'16/06/1995','Student','Bauingenieur B.Sc.','23/07/2015','Bielefeld',3,'/Bild.png'),(4,'Stefanie Bieler',430,'16/06/1995','Student','Wiwi B.Sc.','23/07/2015','Stuttgart',4,'/Bild.png'),(5,'Paula Frei',520,'16/04/1993','Künstlerin','Archtitektur B.Sc.','23/07/2015','Stuttgart',5,'/Bild.png'),(6,'Hans Zimmer',20,'04/06/1990','Student','wissenschaftlicher Mitarbeiter','23/07/2015','Bielefeld',6,'/Bild.png'),(7,'Philipp Peters',20,'16/06/1995','Student','Lehramt','23/07/2015','Bielefeld',7,'/Bild.png'),(8,'Nicole Laumayer',20,'07/02/1993','Student','Lebensmittelchemie B.Sc.','23/07/2015','Bielefeld',8,'/Bild.png');
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
INSERT INTO `benutzer_freunde` VALUES (1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(2,1),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2);
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
  `antwort` varchar(20000) DEFAULT NULL,
  PRIMARY KEY (`bossfight_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bossfight`
--

LOCK TABLES `bossfight` WRITE;
/*!40000 ALTER TABLE `bossfight` DISABLE KEYS */;
INSERT INTO `bossfight` VALUES (1,1,3,NULL);
/*!40000 ALTER TABLE `bossfight` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challenge`
--

LOCK TABLES `challenge` WRITE;
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
INSERT INTO `challenge` VALUES (1,'23/07/2015',0,0,NULL),(2,'23/07/2015',0,0,NULL),(3,'23/07/2015',0,0,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fachrichtung`
--

LOCK TABLES `fachrichtung` WRITE;
/*!40000 ALTER TABLE `fachrichtung` DISABLE KEYS */;
INSERT INTO `fachrichtung` VALUES (1,NULL,'\0'),(2,NULL,'\0'),(3,'Wirtschaftsinformatik','\0'),(4,NULL,'\0'),(5,NULL,'\0'),(6,NULL,'\0'),(7,NULL,'\0');
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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frage`
--

LOCK TABLES `frage` WRITE;
/*!40000 ALTER TABLE `frage` DISABLE KEYS */;
INSERT INTO `frage` VALUES (1,2,'Wieviel Uhr ist es?',2,1),(2,3,'Wofür steht der Begriff XML ?',2,4),(3,4,'Was ist ein Semantisches Netz?',2,4),(4,5,'Wofur steht der Begriff CSS?',2,4),(5,6,'Was ist eine Ontologie?',2,4),(6,7,'Wie kann Wissensmanagement im Web 2.0 erfolgen?',2,4),(7,8,'Sei F=P(f(x)). Welche der folgenden Mengen ist das Herbrand-Universum von F?',2,4),(8,9,'Welche der folgenden Aussagen ist nicht korrekt?',2,4),(9,10,'Welches x ist eine Lösungen der Gleichung 7x kongruent 1mod20?',2,4),(10,11,'Was ist die Laufzeitkomplexität von Mergesort im Average-Case?',2,4),(11,12,'Wie groß prognostizierte Thomas Watson (IBM) den weltweiten Bedarf an Computern?',2,4),(12,13,'Zeiten hoher Arbeitslosigkeit',2,6),(13,14,'Welche Konsumenten handeln rational?',2,6),(14,15,'Die Zuteilung knapper Fussballmatch-Tickets durch Losentscheid wird aus folgendem Grund durchgeführt',2,6),(15,16,'Welches ist die wahrscheinlichste Ursache einer Preiserhöhung für frisches Gemüse?',2,6),(16,17,'Angenommen, die Kreuzpreiselastizität der Nachfrage in bezug auf zwei Produkte sei negativ. Wir wissen, dass',2,6),(17,18,'Eine Unternehmung stellt Hemden und Jacken her. Welche Opportunitätskosten verursacht die Produktion einer Jacke?',2,6),(18,19,'Falls in einer Unternehmung die kurzfristige Durchschnittskostenkurve steigt,',2,6),(19,20,'Unternehmen stehen abnehmenden Skalenerträgen gegenüber, wenn',2,6),(20,21,'Welche Aussage ist für die vollständige Konkurrenz charakteristisch?',2,6),(21,22,'Die Einkommenselastizität der Nachfrage nach frischem Brot wird auf + 0.3 geschätzt. Falls die realen Einkommen der Konsumenten ceteris paribus um 15 % steigen, wird die nachgefragte Menge frisches Brot um folgenden Prozentsatz steigen:',2,6),(22,23,'Worin sah Friedrich Nietzsche exemplarisch die Sklavenmoral?',2,NULL),(23,24,'Wer sagte: \'Das Wesen des Kosmos ist die Zahl!\'',2,NULL),(24,25,'Welches Jahrhundert gilt als \'das Jahrhundert der Auflärung\'?',2,NULL),(25,26,'Wozu ist der Mensch nach Satre verurteilt?',2,NULL),(26,27,'Was bedeutet eigentlich das Wort Philosophie?',2,NULL),(27,28,'Ein Satz, dessen Wahrheit nur auf der Bedeutung der in ihm verwendeten Wörter beruht, heißt',2,NULL),(28,29,'Philosophen, die die sinnliche Erfahrung als die Hauptquelle aller Erkenntnis betrachten, nennt man',2,NULL),(29,30,'Alle Menschen sind sterblich. Alle Griechen sind Menschen. Alle Griechen sind sterblich. Wie nennt man eine solche logische Ableitung?',2,NULL),(30,31,'Der Philosoph Voltaire war der Meinung, Gott habe die Welt zwar geschaffen, greife aber seither nicht mehr in sie ein. Wie nennt man diesen Standpunkt?',2,NULL),(31,32,'Welcher Philosoph illustrierte seine «Ideenlehre» mit dem Höhlengleichnis?',2,NULL),(32,33,'Welches Getreide liefert weltweit die größten Erträge?',2,7),(33,34,'Den Gurkenflieger nutzt man …',2,7),(34,35,'Welche Fläche steht neun gemeinsam gehaltenen Legehennen gesetzlich mindestens zu?',2,7),(35,36,'Wie schwer ist ein Mastschwein zum Zeitpunkt der Schlachtung im Idealfall?',2,7),(36,37,'Schafe gehören zur Unterfamilie der …',2,7),(37,38,'Was ist die Besonderheit des Onagadori-Huhns?',2,7),(38,39,'Welche dieser Pflanzen ist kein Nachtschattengewächs?',2,7),(39,40,'Wann sind Zuckerrüben reif zum Ernten?',2,7),(40,41,'Welches ist das größte Weinanbaugebiet?',2,7),(41,42,'Wenn die Tageslänge innerhalb eines Jahres variiert, spricht man von',2,7),(42,43,'Zur Hautdesinfektion wird eine Körperstelle mit Alkohol (99%iges Ethanol) benetzt. Dieser Hautbereich fühlt sich daraufhin vorübergehend kühl an. Dies liegt üblicherweise vor allem daran, dass',2,5),(43,44,'Eine akute alveoläre Hyperventilation aufgrund psychischer Belastung geht am wahrscheinlichsten einher mit einer/einem',2,5),(44,45,'Auf einem etwa 5,5 km hohen Berg ist der Luftdruck nur etwa halb so groß wie der Luftdruck auf Meereshöhe. Etwa wie groß ist der Sauerstoff-Partialdruck auf dem Berg?',2,5),(45,46,'Ein Läufer setzte in einer Stunde etwa 2 400 kJ in mechanische Arbeit und Wärme um. Sein durchschnittlicher Energieumsatz betrug in dieser Zeit somit etwa',2,5),(46,47,'Beim nichttrainierten gesunden Erwachsenen kommt es mit zunehmendem Lebensalter zwischen 30 und 80 Jahren (bei jeweils gleichem Körpergewicht) am wahrscheinlichsten zur/zum',2,5),(47,48,'Die Elektronegativität ist die Energie zur Entfernung eines Valenzelektrons.',2,5),(48,49,'ADP',2,5),(49,50,'Eine Quelle sendet zu einem bestimmten Zeitpunkt sowohl ein visuelles als auch ein akustisches Signal aus. Etwa welchen zeitlichen Abstand haben visuelles und akustisches Signal nach 30 m Entfernung in Luft (bei 0 °C)?',2,5),(50,51,'Die Hauptmenge des Eisens im Blutplasma ist (bei gesunden Erwachsenen) gebunden an',2,5),(51,52,'Die Glucose-Konzentration im Serum eines Patienten beträgt 5 mmol/L. Die ungefähre relative Atommasse von H ist 1, von C 12 und von O 16. Etwa wie viel Milligramm Glucose sind in 100 mL = 1 dL Serum enthalten?',2,5),(52,53,'Unter welchem Winkel bricht Kreide bei Torsion?',2,8),(53,54,'Wie groß ist die Zugfestigkeit von S235?',2,8),(54,55,'Welche Gefahr gibt es bei der Druckbelastung von schlanken Bauteilen?',2,8),(55,56,'Über welche Größe lässt sich die Biegespannung an verschiedenen Stellen eines biegebelasteten Querschnittes errechnen?',2,8),(56,57,'Wie kann man sich den Verlauf von Kräften und Momenten in einem Bauteil modellhaft vorstellen?',2,8),(57,58,'Wie kann man die Auswirkung von Kerben bei dynamischer Beanspruchung verringern?',2,8),(58,59,'Welche Grenze begrenzt den elastischen Bereich einer Probe?',2,8),(59,60,'Bei welchem Lastfall ist die Annahme einer homogenen Spannungsverteilung nicht zulässig?',2,8),(60,61,'Welche Festigkeitshypothese eignet sich für spröde Werkstoffe?',2,8),(61,62,'Warum verdreht eine Reinigungskraft einen Lappen, um ihn zu trocknen?',2,8),(62,63,'Unter welche Güterarten werden Patente und Lizenzen eingeordnet?',2,3),(63,64,'Bei welchen Lösungsmöglichkeiten von asymmetrischer Information entstehen vor allem beim Agenten Agency-Kosten ?',2,3),(64,65,'Welche der folgenden Aussagen ist richtig ?',2,3),(65,66,'Welche Geschäftsvorfälle sind erfolgswirksam?',2,3),(66,67,'Ein periodenfremder Aufwand entsteht, wenn…',2,3),(67,68,'Ein schwäbisches Metallbauunternehmen beschließt gewisse Einzelteile bei einem bestimmten Lieferanten einzukaufen, da diese qualitativ hochwertiger und kostengünstiger zugekauft werden können. Ordenen Sie die richtigen beschaffungspolitischen Instrumente zu.',2,3),(68,69,'Welche Art der Tenten erzielt ein Unternehmen, wenn es mit Hilfe siener Ressourcen Innovationen hervorbringt und sich die daraus entstandenen Innovationsgewinne aneignet?',2,3),(69,70,'Was sind Grunde für Abschreibungen?',2,3),(70,71,' Bei welchen der folgenden Geschäftsvorfälle ist die Umsatzsteuer (in Form der Vorsteuer bzw. Mehrwertsteuer, ggf. auch als Korrektur der Umsatzsteuer) zu berücksichtigen? ',2,3),(71,72,'Welche Zwecke efüllt das Inventar?',2,3);
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
INSERT INTO `frage_antwortmoeglichkeiten` VALUES (1,'17:00'),(1,'18:00'),(1,'19:00'),(2,'Expert Markup Language'),(2,'Extensible Markup for Logical Documents'),(2,'Extensible Markup Language'),(2,'Extensible Multimedia Language'),(3,'die Struktur einer Webseite'),(3,'die weltweite Verknupfung von Webseiten durch Links'),(3,'eine Form der Wissensorganisation, basierend auf Begriffen und deren Relationen'),(3,'eine Ontologie'),(4,'Cascading Stylesheets'),(4,'Complete Style DeScription'),(4,'Complex Style Semantics'),(4,'Customer Style Semantics'),(5,'das Semantic Web'),(5,'eine Beschreibung von Sinnzusammenhängen'),(5,'eine Technik des Web 1.0'),(5,'Modell einer Domäne'),(6,'durch Austausch beispielsweise innerhalb von Sozialen Netzwerken'),(6,'durch Blogs als Wissensspeicher'),(6,'durch Kollaboration (social Tagging)'),(6,'durch statische Webseiten'),(7,'{a,f(a),f(f(a)),…}'),(7,'{a}'),(7,'{f(x)}'),(7,'{}'),(8,'Jede Gruppe ist ein Monoid.'),(8,'Jede Gruppe ist ein Ring.'),(8,'Jeder Körper ist ein Ring.'),(8,'Jedes Monoid ist eine Halbgruppe.'),(9,'x=2'),(9,'x=20'),(9,'x=3'),(9,'x=7'),(10,'O(log(n))'),(10,'O(n)'),(10,'O(n*log(n))'),(10,'O(n²)'),(11,'10'),(11,'15'),(11,'20'),(11,'5'),(12,'führen zu Punkten auf der Kurve der Produktionsmöglichkeiten'),(12,'führen zu Punkten ausserhalb der Kurve der Produktionsmöglichkeiten'),(12,'führen zu Punkten innerhalb der Kurve der Produktionsmöglichkeiten'),(12,'haben keinerlei Auswirkungen auf die Kurve der Produktionsmöglichkeiten'),(13,'Konsumenten, die einen Teil ihres Einkommens sparen'),(13,'Konsumenten, die immer das billigste Produkt kaufen'),(13,'Konsumenten, die keine Billiglohn-Jobs annehmen'),(13,'Konsumenten, die Kosten und Nutzen jeder zu treffenden Wahl abwägen'),(14,'aus keinem dieser Gründe'),(14,'Gewinnmotiv'),(14,'Rationierung'),(14,'Verkauf an den Meistbietenden'),(15,'Preiserhöhung eines Komplementärgutes'),(15,'Preissenkung eines Substitutionsgutes'),(15,'Preissenkung für Dünger, der in der Gemüseproduktion eingesetzt wird'),(15,'Ueberschwemmungen, welche die Bauern bei der Gemüseernte überraschen'),(16,'die beiden Produkte inferiore Güter sind'),(16,'die beiden Produkte Komplementärgüter sind'),(16,'die beiden Produkte normale Güter sind'),(16,'die beiden Produkte Substitutionsgüter sind'),(17,'Anzahl der Hemden, die mit den für die Herstellung einer Jacke verwendeten Produktionsfaktoren hätten angefertigt werden können'),(17,'Gesamtkosten für die Herstellung einer Jacke'),(17,'Kosten der Produktionsfaktoren, die zur Herstellung einer Jacke erforderlich sind'),(17,'Marktpreis einer Jacke'),(18,'fällt die Grenzkostenkurve'),(18,'hat die Unternehmung die Kontrolle über ihre Kosten verloren'),(18,'ist bei dieser Menge die Grenzkostenkurve über der kurzfristigen Durchschnittskostenkurve'),(18,'ist bei dieser Menge die Grenzkostenkurve unter der kurzfristigen Durchschnittskostenkurve'),(19,'die fixen Kosten steigen'),(19,'die Kosten je Stück mit zunehmender Produktion steigen'),(19,'die Mitarbeiter mit steigender Produktion eine höhere Gewinnbeteiligung verlangen'),(19,'wenn die Unternehmung mit steigender Produktion höhere Preise für Produktionsfaktoren zahlen müssen'),(20,'Die Anbieter verfügen in bezug auf den Markt über mehr Informationen als die Nachfrager'),(20,'Es gibt auf lange Sicht Schranken für den Ein- und Austritt von Anbietern'),(20,'Es gibt eine Produktdifferenzierung (d.h. die Anbieter bieten unterschiedliche Produkte an)'),(20,'Käufer und Verkäufer sind Preisnehmer'),(21,'15%'),(21,'3%'),(21,'4%'),(21,'4.5 %'),(22,'Christentum'),(22,'Herrenmoral'),(22,'Philosophie'),(22,'Sozialismus'),(23,'Heraklit'),(23,'Platon'),(23,'Pythagoras'),(23,'Sokrates'),(24,'17. Jahrhundert'),(24,'18. Jahrhundert'),(24,'19. Jahrhundert'),(24,'20. Jahrhundert'),(25,'Der Mensch ist verurteilt, frei zu sein. '),(25,'Der Mensch ist verurteilt, in Ketten zu liegen.'),(25,'Der Mensch ist verurteilt, sich in die Zwänge der bestehenden Welt zu fügen.'),(25,'Der Mensch ist verurteilt, sich seinem Geist zu fügen.'),(26,'Liebe zu den Frauen'),(26,'Liebe zum Leben'),(26,'Liebe zur Kunst'),(26,'Liebe zur Weisheit'),(27,'analytisch'),(27,'eklektizistisch'),(27,'synkretistisch'),(27,'synthetisch'),(28,'Empiristen'),(28,'Epistemologen'),(28,'Euhemeristen'),(28,'Synthetiker'),(29,'Syllogismus'),(29,'Sympathie'),(29,'Synergie'),(29,'Synthese'),(30,'Atheismus'),(30,'Deismus'),(30,'Pantheismus'),(30,'Polytheismus'),(31,'Aristoteles'),(31,'Epiktet'),(31,'Epikur'),(31,'Platon'),(32,'Mais'),(32,'Roggen'),(32,'Weizen'),(33,'bei der Ernte mancher Gemüsepflanzen'),(33,'in Krisengebieten'),(33,'zum Bestäuben der Gurkenfliegerweibchen'),(33,'zum Bestellen des Feldes'),(34,'1 qm'),(34,'3 qm'),(34,'5 qm'),(34,'9 qm'),(35,'100-120kg'),(35,'160-180kg'),(35,'220-240 kg'),(35,'60-80kg'),(36,'Katzenartigen'),(36,'Rinderartigen'),(36,'Wolfsartigen'),(36,'Ziegenartigen'),(37,'Es bekommt einen meterlangen Schwanz.'),(37,'Es hat zwei Köpfe.'),(37,'Es kann keine Eier legen.'),(37,'Es legt zwei Eier.'),(38,'Kartoffel'),(38,'Tabak'),(38,'Tomate'),(38,'Trollblume'),(39,'Wenn die Blattspitzen gelb werden.'),(39,'Wenn die Pflanze höher als drei Meter gewachsen ist.'),(39,'Wenn die Pflanze ihre Blätter verliert.'),(39,'Wenn die Rüben ein Gewicht von 2kg überschritten haben.'),(40,'Franken'),(40,'Mittelrhein'),(40,'Nahen'),(40,'Rheinhessen'),(41,'Endzeitklima'),(41,'Jahreszeitenklima'),(41,'Makroklima'),(41,'Tageszeitenklima'),(42,'abgestoßene Hautpartikel im Alkohol in Lösung gehen'),(42,'Alkohol eine höhere Wärmeleitfähigkeit als Luft hat'),(42,'bei der Verdunstung des Alkohols der Haut Wärmeenergie entzogen wird'),(42,'die spezifische Wärmekapazität des Alkohols größer als die der Luft ist'),(43,'erhöhten arteriellen CO2-Partialdruck'),(43,'erhöhten arteriellen Protonen-Konzentration'),(43,'gesteigerten neuromuskulären Erregbarkeit'),(43,'pH-abhängigen Dilatation der zerebralen Arteriolen'),(44,'100 hPa'),(44,'20 hPa'),(44,'200 hPa'),(44,'500 hPa'),(45,'0,67 W'),(45,'2,4 W'),(45,'240 W'),(45,'670 W'),(46,'Abnahme der Vitalkapazität der Lunge'),(46,'Abnahme des arteriellen Mitteldrucks'),(46,'Abnahme des Herzgewichts'),(46,'Anstieg der glomerulären Filtrationsrate'),(47,'Die Elektronegativität ist ein Maß für das Bestreben eines Atoms, in einer kovalenten Bindung Elektronen an sich zu ziehen.'),(47,'Die elektronegativsten Elemente stehen im Periodensystem der Elemente links unten.'),(47,'Elektronegativität und Elektronenaffinität sind identische Größen.'),(48,'enthält drei Phosphatgruppen'),(48,'enthält eine Pyrimidinbase'),(48,'ist ein Nucleotid'),(48,'ist ein Substrat der DNA-Polymerasen'),(49,'0,01 s'),(49,'0,03 s'),(49,'0,09 s'),(49,'0,18 s'),(50,'Albumin'),(50,'Ferritin'),(50,'Hämoglobin'),(50,'Transferrin'),(51,'62 mg'),(51,'73 mg'),(51,'9 mg'),(51,'90 mg'),(52,'0°'),(52,'180°'),(52,'45°'),(52,'90°'),(53,'235 N/qqm'),(53,'335 N/qqm'),(53,'360 N/qqm'),(53,'460 N/qqm'),(54,'Knicken'),(54,'Ticken'),(54,'Torsion'),(54,'Zicken'),(55,'Flächenträgheitsmoment'),(55,'Massenträgheitsmoment'),(55,'Volumenträgheitsmoment'),(55,'Widerstandsmoment'),(56,'Kraftbach'),(56,'Kraftfluss'),(56,'Kraftstrom'),(56,'Momentensee'),(57,'Entlastungskerben und Entlastungsrisse'),(57,'Entlastungskerben und Oberflächenverfestigung'),(57,'Entlastungskerben, Oberflächenverfestigung und Entlastungsrisse'),(57,'Oberflächenverfestigung und Entlastungsrisse'),(58,'0,2% Dehngrenze'),(58,'Schubfestigkeit'),(58,'Streckgrenze'),(58,'Zugfestigkeit'),(59,'Biegung'),(59,'Druck'),(59,'Normalbelastung'),(59,'Zug'),(60,'Gestaltänderungsenergiehypothese'),(60,'Normalspannungshypothese'),(60,'Schubspannungshypothese'),(60,'Torsionsspannungshypothese'),(61,'Durch die Torsion entstehen hohe Druckspannungen.'),(61,'Durch die Torsion entstehen hohe Schubspannungen.'),(61,'Durch die Torsion entstehen hohe Zugspannungen.'),(61,'Er/Sie weiß nicht, dass Drücken besser wäre.'),(62,'Immaterielle Güter'),(62,'Realgüter'),(62,'Reine Güterformen'),(62,'Wirtschaftsgüter'),(63,'Leistungsabhängige Entlohnung'),(63,'Monitoring'),(63,'Screening'),(63,'Signaling'),(64,'Abschlussbuchungen des EK-Kontos erfolgen direkt in das GuV-Konto. '),(64,'Der Aufwand ist der gesamte Wertezuwachs. '),(64,'Die indirekte Abschreibung erfolgt als Sollbuchung auf dem passivem Verrechnungskonto.'),(64,'Warenrücksendungen werden im gemischten Warenkonto im Soll gebucht.'),(65,'Auszahlung eines Gehaltsvorschusses an einen Mitarbeiter.'),(65,'Bildung einer Rückstellung für unterlassene Aufwendungen für Instandhaltung.'),(65,'Private Bareinlage des Unternehmers zur Erhöhung des Eigenkapitals des Unternehmens.'),(65,'Private Warenentnahme des Unternehmers über den Einkaufspreis der Waren:'),(66,'…das Unternehmen die vertraglich vereinbarte Miete für das vergangene Jahr erst in diesem Jahr zahlt.'),(66,'…das Unternehmen mehr Steuern nachzahlen muss als im letzten Jahr angenommen.'),(66,'…der im letzten Jahr geschätzte Forderungsverlust größer als der tatsächliche Forderungsverlust ist. '),(66,'…die Pauschalwertberichtigungen auf Forderungen im letzten Jahr zu niedrig gebildet wurden.'),(67,'Beschaffungskonditionenpolitik'),(67,'Beschaffungsprogrammpolitik'),(67,'Bezugspolitik'),(67,'Kommunikationspolitik'),(68,'Monopolrenten'),(68,'Quasirenten'),(68,'Ricardo-Renten'),(68,'Schumpeter-Renten'),(69,'Der Buchwert liegt unter den Wiederbeschaffungskosten eines Vermögensgutes.'),(69,'Der technische Verschleiß einer Maschine ist in diesem Jahr höher als Angenommen.'),(69,'Die Fristen zur Nutzung eines Markennamen für die eigenen Produkte laufen aus.'),(69,'Wir schicken eine Mahnung an einen Kunden, weil er bisher seine Rechnung nicht gezahlt hat.'),(70,'Bildung einer Rückstellung für unterlassene Aufwendungen für Instandhaltung, die im folgenden Geschäftsjahr innerhalb von 3 Monaten nachgeholt werden.'),(70,'Eine dubiose Forderung wird aufgrund der Einstellung des Insolvenzverfahrens endgültig uneinbringlich und damit endgültig abgeschrieben.'),(70,'Pauschale Abschreibung des Forderungsbestands um 5%.'),(70,'Private Warenentnahme des Unternehmers zu Einkaufspreisen.'),(71,'Das Inventar dient dem Abgleich von Buch- und Ist-Beständen.'),(71,'Das Inventar dient der Kontrolle des Unternehmens durch das Finanzamt'),(71,'Das Inventar garantiert die Wahrheit der Werte in der Bilanz'),(71,'Das Inventar kontrolliert die ordnungsgemäße Verbuchung aller Geschäftsvorfälle des Jahres');
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
INSERT INTO `frage_loesung` VALUES (1,'17:00'),(2,'Extensible Markup Language'),(3,'eine Form der Wissensorganisation, basierend auf Begriffen und deren Relationen'),(4,'Cascading Stylesheets'),(5,'eine Beschreibung von Sinnzusammenhängen'),(6,'durch Austausch beispielsweise innerhalb von Sozialen Netzwerken'),(7,'{a,f(a),f(f(a)),…}'),(8,'Jede Gruppe ist ein Ring.'),(9,'x=3'),(10,'O(n*log(n))'),(11,'5'),(12,'führen zu Punkten innerhalb der Kurve der Produktionsmöglichkeiten'),(13,'Konsumenten, die Kosten und Nutzen jeder zu treffenden Wahl abwägen'),(14,'Gewinnmotiv'),(15,'Ueberschwemmungen, welche die Bauern bei der Gemüseernte überraschen'),(16,'die beiden Produkte Komplementärgüter sind'),(17,'Anzahl der Hemden, die mit den für die Herstellung einer Jacke verwendeten Produktionsfaktoren hätten angefertigt werden können'),(18,'ist bei dieser Menge die Grenzkostenkurve über der kurzfristigen Durchschnittskostenkurve'),(19,'die Kosten je Stück mit zunehmender Produktion steigen'),(20,'Käufer und Verkäufer sind Preisnehmer'),(21,'4.5 %'),(22,'Christentum'),(23,'Pythagoras'),(24,'18. Jahrhundert'),(25,'Der Mensch ist verurteilt, frei zu sein. '),(26,'Liebe zur Weisheit'),(27,'analytisch'),(28,'Empiristen'),(29,'Syllogismus'),(30,'Deismus'),(31,'Platon'),(32,'Mais'),(33,'bei der Ernte mancher Gemüsepflanzen'),(34,'1 qm'),(35,'100-120kg'),(36,'Ziegenartigen'),(37,'Es bekommt einen meterlangen Schwanz.'),(38,'Trollblume'),(39,'Wenn die Blattspitzen gelb werden.'),(40,'Rheinhessen'),(41,'Jahreszeitenklima'),(42,'bei der Verdunstung des Alkohols der Haut Wärmeenergie entzogen wird'),(43,'gesteigerten neuromuskulären Erregbarkeit'),(44,'100 hPa'),(45,'670 W'),(46,'Abnahme der Vitalkapazität der Lunge'),(47,''),(48,'ist ein Nucleotid'),(49,'0,09 s'),(50,'Transferrin'),(51,'90 mg'),(52,'45°'),(53,'360 N/qqm'),(54,'Knicken'),(55,'Flächenträgheitsmoment'),(56,'Kraftfluss'),(57,'Entlastungskerben und Oberflächenverfestigung'),(58,'Streckgrenze'),(59,'Biegung'),(60,'Normalspannungshypothese'),(61,'Durch die Torsion entstehen hohe Druckspannungen.'),(62,'Immaterielle Güter'),(62,'Realgüter'),(62,'Reine Güterformen'),(62,'Wirtschaftsgüter'),(63,'Screening'),(63,'Signaling'),(65,'Bildung einer Rückstellung für unterlassene Aufwendungen für Instandhaltung.'),(66,'…das Unternehmen mehr Steuern nachzahlen muss als im letzten Jahr angenommen.'),(66,'…die Pauschalwertberichtigungen auf Forderungen im letzten Jahr zu niedrig gebildet wurden.'),(67,'Beschaffungsprogrammpolitik'),(67,'Bezugspolitik'),(68,'Schumpeter-Renten'),(69,'Die Fristen zur Nutzung eines Markennamen für die eigenen Produkte laufen aus.'),(70,'Eine dubiose Forderung wird aufgrund der Einstellung des Insolvenzverfahrens endgültig uneinbringlich und damit endgültig abgeschrieben.'),(70,'Private Warenentnahme des Unternehmers zu Einkaufspreisen.'),(71,'Das Inventar dient dem Abgleich von Buch- und Ist-Beständen.'),(71,'Das Inventar garantiert die Wahrheit der Werte in der Bilanz');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fragenpool`
--

LOCK TABLES `fragenpool` WRITE;
/*!40000 ALTER TABLE `fragenpool` DISABLE KEYS */;
INSERT INTO `fragenpool` VALUES (1),(2),(3),(4),(5),(6),(7),(8);
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
  `fachrichtungsname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`gruppen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppe`
--

LOCK TABLES `gruppe` WRITE;
/*!40000 ALTER TABLE `gruppe` DISABLE KEYS */;
INSERT INTO `gruppe` VALUES (1,'Management betrieblicher Informationssysteme','MBIS','\0',3,9,1,'/Gruppenbild.png','23/07/2015','Ing'),(2,'Betriebliche Informations- und Kommunikationssyseme','MBIS 1','\0',3,10,2,'/BIKS.png','23/07/2015',NULL),(3,'Betriebswirtschaftslehre','BWL','\0',3,11,3,'/Gruppenbild.png','23/07/2015',NULL),(4,'Grundwissen Informatik','InfoBasic','\0',3,12,4,'/Gruppenbild.png','23/07/2015',NULL),(5,'Anatomie','Staatsexamen Medizin','\0',3,13,5,'/Gruppenbild.png','23/07/2015',NULL),(6,'Volkswirtschaftslehre','VWL','\0',3,14,6,'/Gruppenbild.png','23/07/2015',NULL);
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
INSERT INTO `gruppen_mitglieder` VALUES (1,1),(1,2),(2,1),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8),(4,1),(4,2),(4,3),(4,4),(4,5),(5,1),(5,2),(5,7),(5,8),(6,1),(6,2),(6,3),(6,4),(6,5),(6,6),(6,7),(6,8);
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
INSERT INTO `gruppen_moderatoren` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inhalt`
--

LOCK TABLES `inhalt` WRITE;
/*!40000 ALTER TABLE `inhalt` DISABLE KEYS */;
INSERT INTO `inhalt` VALUES (1,5,'Ich wünsch Dir alles Gute zum Geburtstag!','Happy Birthday','2015-07-23 10:59:34.85',2,NULL),(2,1,'Hey Leute, hab leider mein Handy verloren','Nur per Facebook erreichbar','2015-07-23 10:59:34.86',2,NULL),(3,4,'Vorlesung morgen fällt aus!','WICHTIG','2015-07-23 10:59:34.87',1,NULL),(4,0,'Hat jemand Aufgabe 8.2 verstanden? :/','Frage','2015-07-23 10:59:34.88',2,NULL),(5,4,'Hey Leute, unter wikipedia.de findet ihr einige cooles Infos.','Link zur Aufgabe','2015-07-23 10:59:34.89',1,NULL),(6,0,'Dankeschön!',NULL,'2015-07-23 10:59:34.89',1,NULL),(7,0,NULL,NULL,'2015-07-23 10:59:34.89',NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kommentar`
--

LOCK TABLES `kommentar` WRITE;
/*!40000 ALTER TABLE `kommentar` DISABLE KEYS */;
INSERT INTO `kommentar` VALUES (6,1),(7,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medium`
--

LOCK TABLES `medium` WRITE;
/*!40000 ALTER TABLE `medium` DISABLE KEYS */;
INSERT INTO `medium` VALUES (1,'Musterklausur','Musterklausur.pdf');
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nachricht`
--

LOCK TABLES `nachricht` WRITE;
/*!40000 ALTER TABLE `nachricht` DISABLE KEYS */;
INSERT INTO `nachricht` VALUES (1,'Herausforderung zum Teamcombat','Die Gruppe \"Betriebliche Informations- und Kommunikationssyseme\" hat \"Management betrieblicher Informationssysteme\" zum Teamcombat herausgefordert.\nDu hast 3 Tage Zeit, um Dein Quest zu bearbeiten!','23/07/2015 10:59',4,NULL),(2,'Herausforderung zum Teamcombat','Die Gruppe \"Betriebliche Informations- und Kommunikationssyseme\" hat \"Management betrieblicher Informationssysteme\" zum Teamcombat herausgefordert.\nDu hast 3 Tage Zeit, um Dein Quest zu bearbeiten!','23/07/2015 10:59',4,NULL),(3,'Du hast einen neuen Freund','Hannes Fischer hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,5),(4,'Du hast einen neuen Freund','Hannes Fischer hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,3),(5,'Du hast einen neuen Freund','Hannes Fischer hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,7),(6,'Du hast einen neuen Freund','Hannes Fischer hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,8),(7,'Du hast einen neuen Freund','Hannes Fischer hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,6),(8,'Du hast einen neuen Freund','Hannes Fischer hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,4),(9,'Du hast einen neuen Freund','Lena Maier hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,1),(10,'Herausforderung zum Teamcombat','Die Gruppe \"Betriebliche Informations- und Kommunikationssyseme\" hat \"Management betrieblicher Informationssysteme\" zum Teamcombat herausgefordert.\nDu hast 3 Tage Zeit, um Dein Quest zu bearbeiten!','23/07/2015 10:59',4,NULL),(11,'Du hast einen neuen Freund','Richard Laumayer hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,2),(12,'Du hast einen neuen Freund','Philipp Peters hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,2),(13,'Du hast einen neuen Freund','Hannes Fischer hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,2),(14,'Du hast einen neuen Freund','Nicole Laumayer hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,2),(15,'Du hast einen neuen Freund','Stefanie Bieler hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,2),(16,'Du hast einen neuen Freund','Paula Frei hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,2),(17,'Du hast einen neuen Freund','Hans Zimmer hat Dich zur Freundesliste hinzugefügt','23/07/2015 10:59',0,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinnwand`
--

LOCK TABLES `pinnwand` WRITE;
/*!40000 ALTER TABLE `pinnwand` DISABLE KEYS */;
INSERT INTO `pinnwand` VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12),(13),(14);
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
INSERT INTO `pinnwand_erlaubtebenutzer` VALUES (1,1),(1,2),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,8),(2,9),(2,11),(2,12),(2,13),(2,14),(3,1),(3,3),(3,11),(3,12),(3,14),(4,1),(4,4),(4,11),(4,12),(4,14),(5,1),(5,5),(5,11),(5,12),(5,14),(6,1),(6,6),(6,11),(6,14),(7,1),(7,7),(7,11),(7,13),(7,14),(8,1),(8,8),(8,11),(8,13),(8,14);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest`
--

LOCK TABLES `quest` WRITE;
/*!40000 ALTER TABLE `quest` DISABLE KEYS */;
INSERT INTO `quest` VALUES (2,2),(3,1);
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
INSERT INTO `quest_fragen` VALUES (2,1);
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
INSERT INTO `teamcombat` VALUES (1,'2015-07-26 10:59:43.217',2,1,2,3,NULL,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thema`
--

LOCK TABLES `thema` WRITE;
/*!40000 ALTER TABLE `thema` DISABLE KEYS */;
INSERT INTO `thema` VALUES (1,1),(2,2),(3,11),(4,11),(5,11);
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

-- Dump completed on 2015-07-23 11:01:17
