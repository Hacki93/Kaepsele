package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import learning.Benutzer;
import learning.Fachrichtung;
import learning.Frage;
import learning.Gruppe;
import learning.Kommentar;
import learning.Thema;
import datenhaltung.Datenbank;

public class Beispieldaten {

	public static void main(String[] args) {
		dbSchreiben();
		System.err.println("Testlauf vollst�ndig durchgef�hrt und abgeschlossen");
		System.exit(0);
	}

	public static void dbSchreiben() {
		try {

			Datenbank db = new Datenbank();

			// Objekte instanziieren

			Benutzer hannes = new Benutzer();
			Benutzer lena = new Benutzer();
			Gruppe mbis = new Gruppe();
			Gruppe biks = new Gruppe();
			Thema thema = new Thema();
			Kommentar kommentar = new Kommentar();
			Fachrichtung wi = new Fachrichtung();
			Frage frage = new Frage();
			
			// Fragen nach Kategorien instanziieren
			Frage fagrar1 = new Frage();
			Frage fagrar2 = new Frage();
			Frage fagrar3 = new Frage();
			Frage fagrar4 = new Frage();
			Frage fagrar5 = new Frage();
			Frage fagrar6 = new Frage();
			Frage fagrar7 = new Frage();
			Frage fagrar8 = new Frage();
			Frage fagrar9 = new Frage();
			Frage fagrar10 = new Frage();
			
			Frage fmedizin1 = new Frage();
			Frage fmedizin2 = new Frage();
			Frage fmedizin3 = new Frage();
			Frage fmedizin4 = new Frage();
			Frage fmedizin5 = new Frage();
			Frage fmedizin6 = new Frage();
			Frage fmedizin7 = new Frage();
			Frage fmedizin8 = new Frage();
			Frage fmedizin9 = new Frage();
			Frage fmedizin10 = new Frage();
			
			Frage ffestigkeitslehre1 = new Frage();
			Frage ffestigkeitslehre2 = new Frage();
			Frage ffestigkeitslehre3 = new Frage();
			Frage ffestigkeitslehre4 = new Frage();
			Frage ffestigkeitslehre5 = new Frage();
			Frage ffestigkeitslehre6 = new Frage();
			Frage ffestigkeitslehre7 = new Frage();
			Frage ffestigkeitslehre8 = new Frage();
			Frage ffestigkeitslehre9 = new Frage();
			Frage ffestigkeitslehre10 = new Frage();
			
			Frage fphilosophie1 = new Frage();
			Frage fphilosophie2 = new Frage();
			Frage fphilosophie3 = new Frage();
			Frage fphilosophie4 = new Frage();
			Frage fphilosophie5 = new Frage();
			Frage fphilosophie6 = new Frage();
			Frage fphilosophie7 = new Frage();
			Frage fphilosophie8 = new Frage();
			Frage fphilosophie9 = new Frage();
			Frage fphilosophie10 = new Frage();
			
			Frage finformatik1 = new Frage();
			Frage finformatik2 = new Frage();
			Frage finformatik3 = new Frage();
			Frage finformatik4 = new Frage();
			Frage finformatik5 = new Frage();
			Frage finformatik6 = new Frage();
			Frage finformatik7 = new Frage();
			Frage finformatik8 = new Frage();
			Frage finformatik9 = new Frage();
			Frage finformatik10 = new Frage();
			
			Frage fvwl1 = new Frage();
			Frage fvwl2 = new Frage();
			Frage fvwl3 = new Frage();
			Frage fvwl4 = new Frage();
			Frage fvwl5 = new Frage();
			Frage fvwl6 = new Frage();
			Frage fvwl7 = new Frage();
			Frage fvwl8 = new Frage();
			Frage fvwl9 = new Frage();
			Frage fvwl10 = new Frage();

			// Eintrag hinzuf�gen zur Datenbank

			db.eintragHinzufuegen(thema.getClass(), thema);
			db.eintragHinzufuegen(kommentar.getClass(), kommentar);
			db.eintragHinzufuegen(hannes.getClass(), hannes);
			db.eintragHinzufuegen(lena.getClass(), lena);
			db.eintragHinzufuegen(mbis.getClass(), mbis);
			db.eintragHinzufuegen(biks.getClass(), biks);
			db.eintragHinzufuegen(wi.getClass(), wi);
			db.eintragHinzufuegen(frage.getClass(), frage);

			// Objekte f�llen und verbinden

			hannes.registrieren("hannes", "spiegelei");
			hannes.setEmailAdresse("mail@hannes-fischer.com");
			hannes.setName("Hannes Fischer");
			hannes.setAdresse("B�hlenstr. 100, 71088 Holzgerlingen");
			hannes.setRang(1000);
			hannes.setBeruf("Student");
			hannes.setStudiengang("vwlsinformatik B.Sc.");
			hannes.setGeburtsdatum("01/26/1995");
			hannes.setProfilbildURL("/Bild.png");
			hannes.erstelltAm = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			hannes.freundHinzufuegen(lena);

			lena.registrieren("lenchen", "12345678");
			lena.setEmailAdresse("lenamai.er@web.de");
			lena.setName("Lena Maier");
			lena.setAdresse("Schopfloch");
			lena.setRang(2);
			lena.setBeruf("Student");
			lena.setStudiengang("vwlsinformatik B.Sc.");
			lena.setGeburtsdatum("31/12/1993");
			lena.setProfilbildURL("/Bild.png");
			lena.erstelltAm = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			lena.freundHinzufuegen(hannes);

			wi.setName("vwlsinformatik");
			wi.setFreigegeben(false);

			mbis.setFachrichtung(wi);
			mbis.setKlausurname("MBIS 1");
			mbis.setName("Management betrieblicher Informationssysteme");
			mbis.setProfilbildURL("/Gruppenbild.png");
			mbis.mitgliedHinzufuegen(lena);
			mbis.mitgliedHinzufuegen(hannes);
			mbis.moderatorHinzufuegen(hannes);
			mbis.pinnwand.themaHinzufuegen(thema);
			mbis.fragenpool.addFrage(frage);

			mbis.setFachrichtung(wi);
			mbis.setKlausurname("BIKS 1");
			mbis.setName("Betriebliche Informations- und Kommunikationssyseme");
			biks.setProfilbildURL("/BIKS.png");
			biks.mitgliedHinzufuegen(hannes);
			biks.moderatorHinzufuegen(hannes);
			biks.setFachrichtung(wi);
			biks.setKlausurname("MBIS 1");
			biks.setName("Management betrieblicher Informationssysteme");

			kommentar.setBenutzer(lena);
			kommentar.setBewertung(0);
			kommentar.setInhalt("Dankesch�n lieber Hannes");
			kommentar.setTitel("Danke!");
			kommentar.setThema(thema);

			thema.setPinnwand(lena.pinnwand);
			thema.setBenutzer(hannes);
			thema.setBewertung(5);
			thema.setTitel("Happy Birthday");
			thema.setInhalt("Ich w�nsch Dir alles Gute zum Geburtstag!");
			thema.kommentieren(kommentar);

			// Fragen

			frage.setText("Wieviel Uhr ist es?");
			frage.addAntwortmoeglichkeiten("17:00");
			frage.addAntwortmoeglichkeiten("18:00");
			frage.addAntwortmoeglichkeiten("19:00");
			frage.addLoesung("17:00");
			frage.setBenutzer(lena);
			
			
			// 60 Fragen 6 Kategorien

			fagrar1.setText("Welches Getreide liefert weltweit die gr��ten Ertr�ge?");
			fagrar1.addAntwortmoeglichkeiten("Mais");
			fagrar1.addAntwortmoeglichkeiten("Weizen");
			fagrar1.addAntwortmoeglichkeiten("Roggen");
			fagrar1.addAntwortmoeglichkeiten("Roggen");
			fagrar1.addLoesung("Mais");
			fagrar1.setBenutzer(lena);

			fagrar2.setText("Den Gurkenflieger nutzt man �");
			fagrar2.addAntwortmoeglichkeiten("bei der Ernte mancher Gem�sepflanzen");
			fagrar2.addAntwortmoeglichkeiten("in Krisengebieten");
			fagrar2.addAntwortmoeglichkeiten("zum Best�uben der Gurkenfliegerweibchen");
			fagrar2.addAntwortmoeglichkeiten("zum Bestellen des Feldes");
			fagrar2.addLoesung("bei der Ernte mancher Gem�sepflanzen");
			fagrar2.setBenutzer(lena);

			fagrar3.setText("Welche Fl�che steht neun gemeinsam gehaltenen Legehennen gesetzlich mindestens zu?");
			fagrar3.addAntwortmoeglichkeiten("1 qm");
			fagrar3.addAntwortmoeglichkeiten("3 qm");
			fagrar3.addAntwortmoeglichkeiten("5 qm");
			fagrar3.addAntwortmoeglichkeiten("9 qm");
			fagrar3.addLoesung("1 qm");
			fagrar3.setBenutzer(lena);

			fagrar4.setText("Wie schwer ist ein Mastschwein zum Zeitpunkt der Schlachtung im Idealfall?");
			fagrar4.addAntwortmoeglichkeiten("60-80kg");
			fagrar4.addAntwortmoeglichkeiten("100-120kg");
			fagrar4.addAntwortmoeglichkeiten("160-180kg");
			fagrar4.addAntwortmoeglichkeiten("220-240 kg");
			fagrar4.addLoesung("100-120kg");
			fagrar4.setBenutzer(lena);

			fagrar5.setText("Schafe geh�ren zur Unterfamilie der �");
			fagrar5.addAntwortmoeglichkeiten("Ziegenartigen");
			fagrar5.addAntwortmoeglichkeiten("Wolfsartigen");
			fagrar5.addAntwortmoeglichkeiten("Rinderartigen");
			fagrar5.addAntwortmoeglichkeiten("Katzenartigen");
			fagrar5.addLoesung("Ziegenartigen");
			fagrar5.setBenutzer(lena);

			fagrar6.setText("Was ist die Besonderheit des Onagadori-Huhns?");
			fagrar6.addAntwortmoeglichkeiten("Es kann keine Eier legen.");
			fagrar6.addAntwortmoeglichkeiten("Es hat zwei K�pfe.");
			fagrar6.addAntwortmoeglichkeiten("Es bekommt einen meterlangen Schwanz.");
			fagrar6.addAntwortmoeglichkeiten("Es legt zwei Eier.");
			fagrar6.addLoesung("Es bekommt einen meterlangen Schwanz.");
			fagrar6.setBenutzer(lena);

			fagrar7.setText("Welche dieser Pflanzen ist kein Nachtschattengew�chs?");
			fagrar7.addAntwortmoeglichkeiten("Tomate");
			fagrar7.addAntwortmoeglichkeiten("Tabak");
			fagrar7.addAntwortmoeglichkeiten("Trollblume");
			fagrar7.addAntwortmoeglichkeiten("Kartoffel");
			fagrar7.addLoesung("Trollblume");
			fagrar7.setBenutzer(lena);

			fagrar8.setText("Wann sind Zuckerr�ben reif zum Ernten?");
			fagrar8.addAntwortmoeglichkeiten("Wenn die Pflanze h�her als drei Meter gewachsen ist.");
			fagrar8.addAntwortmoeglichkeiten("Wenn die Blattspitzen gelb werden.");
			fagrar8.addAntwortmoeglichkeiten("Wenn die Pflanze ihre Bl�tter verliert.");
			fagrar8.addAntwortmoeglichkeiten("Wenn die R�ben ein Gewicht von 2kg �berschritten haben.");
			fagrar8.addLoesung("Wenn die Blattspitzen gelb werden.");
			fagrar8.setBenutzer(lena);

			fagrar9.setText("Welches ist das gr��te Weinanbaugebiet?");
			fagrar9.addAntwortmoeglichkeiten("Franken");
			fagrar9.addAntwortmoeglichkeiten("Nahen");
			fagrar9.addAntwortmoeglichkeiten("Mittelrhein");
			fagrar9.addAntwortmoeglichkeiten("Rheinhessen");
			fagrar9.addLoesung("Rheinhessen");
			fagrar9.setBenutzer(lena);

			fagrar10.setText("Wenn die Tagesl�nge innerhalb eines Jahres variiert, spricht man von");
			fagrar10.addAntwortmoeglichkeiten("Jahreszeitenklima");
			fagrar10.addAntwortmoeglichkeiten("Tageszeitenklima");
			fagrar10.addAntwortmoeglichkeiten("Endzeitklima");
			fagrar10.addAntwortmoeglichkeiten("Makroklima");
			fagrar10.addLoesung("Jahreszeitenklima");
			fagrar10.setBenutzer(lena);

			// medizin
			fmedizin1.setText("Zur Hautdesinfektion wird eine K�rperstelle mit Alkohol (99%iges Ethanol) benetzt. Dieser Hautbereich f�hlt sich daraufhin vor�bergehend k�hl an. Dies liegt �blicherweise vor allem daran, dass");
			fmedizin1.addAntwortmoeglichkeiten("Alkohol eine h�here W�rmeleitf�higkeit als Luft hat");
			fmedizin1.addAntwortmoeglichkeiten("abgesto�ene Hautpartikel im Alkohol in L�sung gehen");
			fmedizin1.addAntwortmoeglichkeiten("bei der Verdunstung des Alkohols der Haut W�rmeenergie entzogen wird");
			fmedizin1.addAntwortmoeglichkeiten("die spezifische W�rmekapazit�t des Alkohols gr��er als die der Luft ist");
			fmedizin1.addLoesung("bei der Verdunstung des Alkohols der Haut W�rmeenergie entzogen wird");
			fmedizin1.setBenutzer(lena);

			fmedizin2.setText("Eine akute alveol�re Hyperventilation aufgrund psychischer Belastung geht am wahrscheinlichsten einher mit einer/einem");
			fmedizin2.addAntwortmoeglichkeiten("erh�hten arteriellen Protonen-Konzentration");
			fmedizin2.addAntwortmoeglichkeiten("pH-abh�ngigen Dilatation der zerebralen Arteriolen");
			fmedizin2.addAntwortmoeglichkeiten("gesteigerten neuromuskul�ren Erregbarkeit");
			fmedizin2.addAntwortmoeglichkeiten("erh�hten arteriellen CO2-Partialdruck");
			fmedizin2.addLoesung("gesteigerten neuromuskul�ren Erregbarkeit");
			fmedizin2.setBenutzer(lena);

			fmedizin3.setText("Auf einem etwa 5,5 km hohen Berg ist der Luftdruck nur etwa halb so gro� wie der Luftdruck auf Meeresh�he. Etwa wie gro� ist der Sauerstoff-Partialdruck auf dem Berg?");
			fmedizin3.addAntwortmoeglichkeiten("100 hPa");
			fmedizin3.addAntwortmoeglichkeiten("200 hPa");
			fmedizin3.addAntwortmoeglichkeiten("20 hPa");
			fmedizin3.addAntwortmoeglichkeiten("500 hPa");
			fmedizin3.addLoesung("100 hPa");
			fmedizin3.setBenutzer(lena);

			fmedizin4.setText("Ein L�ufer setzte in einer Stunde etwa 2 400 kJ in mechanische Arbeit und W�rme um. Sein durchschnittlicher Energieumsatz betrug in dieser Zeit somit etwa");
			fmedizin4.addAntwortmoeglichkeiten("0,67 W");
			fmedizin4.addAntwortmoeglichkeiten("2,4 W");
			fmedizin4.addAntwortmoeglichkeiten("240 W");
			fmedizin4.addAntwortmoeglichkeiten("670 W");
			fmedizin4.addLoesung("670 W");
			fmedizin4.setBenutzer(lena);

			fmedizin5.setText("Beim nichttrainierten gesunden Erwachsenen kommt es mit zunehmendem Lebensalter zwischen 30 und 80 Jahren (bei jeweils gleichem K�rpergewicht) am wahrscheinlichsten zur/zum");
			fmedizin5.addAntwortmoeglichkeiten("Abnahme der Vitalkapazit�t der Lunge");
			fmedizin5.addAntwortmoeglichkeiten("Abnahme des arteriellen Mitteldrucks");
			fmedizin5.addAntwortmoeglichkeiten("Abnahme des Herzgewichts");
			fmedizin5.addAntwortmoeglichkeiten("Anstieg der glomerul�ren Filtrationsrate");
			fmedizin5.addLoesung("Abnahme der Vitalkapazit�t der Lunge");
			fmedizin5.setBenutzer(lena);

			fmedizin6.setText("Die Elektronegativit�t ist die Energie zur Entfernung eines Valenzelektrons.");
			fmedizin6.addAntwortmoeglichkeiten("Die Elektronegativit�t ist ein Ma� f�r das Bestreben eines Atoms, in einer kovalenten Bindung Elektronen an sich zu ziehen.");
			fmedizin6.addAntwortmoeglichkeiten("Die elektronegativsten Elemente stehen im Periodensystem der Elemente links unten.");
			fmedizin6.addAntwortmoeglichkeiten("Elektronegativit�t und Elektronenaffinit�t sind identische Gr��en.");
			fmedizin6.addAntwortmoeglichkeiten("Die Elektronegativit�t ist ein Ma� f�r das Bestreben eines Atoms, in einer kovalenten Bindung Elektronen an sich zu ziehen.");
			fmedizin6.addLoesung("");
			fmedizin6.setBenutzer(lena);

			fmedizin7.setText("ADP");
			fmedizin7.addAntwortmoeglichkeiten("enth�lt drei Phosphatgruppen");
			fmedizin7.addAntwortmoeglichkeiten("enth�lt eine Pyrimidinbase");
			fmedizin7.addAntwortmoeglichkeiten("ist ein Substrat der DNA-Polymerasen");
			fmedizin7.addAntwortmoeglichkeiten("ist ein Nucleotid");
			fmedizin7.addLoesung("ist ein Nucleotid");
			fmedizin7.setBenutzer(lena);

			fmedizin8.setText("Eine Quelle sendet zu einem bestimmten Zeitpunkt sowohl ein visuelles als auch ein akustisches Signal aus. Etwa welchen zeitlichen Abstand haben visuelles und akustisches Signal nach 30 m Entfernung in Luft (bei 0 �C)?");
			fmedizin8.addAntwortmoeglichkeiten("0,01 s");
			fmedizin8.addAntwortmoeglichkeiten("0,03 s");
			fmedizin8.addAntwortmoeglichkeiten("0,09 s");
			fmedizin8.addAntwortmoeglichkeiten("0,18 s");
			fmedizin8.addLoesung("0,09 s");
			fmedizin8.setBenutzer(lena);

			fmedizin9.setText("Die Hauptmenge des Eisens im Blutplasma ist (bei gesunden Erwachsenen) gebunden an");
			fmedizin9.addAntwortmoeglichkeiten("Albumin");
			fmedizin9.addAntwortmoeglichkeiten("Ferritin");
			fmedizin9.addAntwortmoeglichkeiten("H�moglobin");
			fmedizin9.addAntwortmoeglichkeiten("Transferrin");
			fmedizin9.addLoesung("Transferrin");
			fmedizin9.setBenutzer(lena);

			fmedizin10.setText("Die Glucose-Konzentration im Serum eines Patienten betr�gt 5 mmol/L. Die ungef�hre relative Atommasse von H ist 1, von C 12 und von O 16. Etwa wie viel Milligramm Glucose sind in 100 mL = 1 dL Serum enthalten?");
			fmedizin10.addAntwortmoeglichkeiten("9 mg");
			fmedizin10.addAntwortmoeglichkeiten("62 mg");
			fmedizin10.addAntwortmoeglichkeiten("73 mg");
			fmedizin10.addAntwortmoeglichkeiten("90 mg");
			fmedizin10.addLoesung("90 mg");
			fmedizin10.setBenutzer(lena);

			// festigkeitlehre

			ffestigkeitslehre1.setText("Unter welchem Winkel bricht Kreide bei Torsion?");
			ffestigkeitslehre1.addAntwortmoeglichkeiten("45�");
			ffestigkeitslehre1.addAntwortmoeglichkeiten("90�");
			ffestigkeitslehre1.addAntwortmoeglichkeiten("0�");
			ffestigkeitslehre1.addAntwortmoeglichkeiten("180�");
			ffestigkeitslehre1.addLoesung("45�");
			ffestigkeitslehre1.setBenutzer(lena);

			ffestigkeitslehre2.setText("Wie gro� ist die Zugfestigkeit von S235?");
			ffestigkeitslehre2.addAntwortmoeglichkeiten("335 N/qqm");
			ffestigkeitslehre2.addAntwortmoeglichkeiten("235 N/qqm");
			ffestigkeitslehre2.addAntwortmoeglichkeiten("360 N/qqm");
			ffestigkeitslehre2.addAntwortmoeglichkeiten("460 N/qqm");
			ffestigkeitslehre2.addLoesung("360 N/qqm");
			ffestigkeitslehre2.setBenutzer(lena);

			ffestigkeitslehre3.setText("Welche Gefahr gibt es bei der Druckbelastung von schlanken Bauteilen?");
			ffestigkeitslehre3.addAntwortmoeglichkeiten("Knicken");
			ffestigkeitslehre3.addAntwortmoeglichkeiten("Zicken");
			ffestigkeitslehre3.addAntwortmoeglichkeiten("Ticken");
			ffestigkeitslehre3.addAntwortmoeglichkeiten("Torsion");
			ffestigkeitslehre3.addLoesung("Knicken");
			ffestigkeitslehre3.setBenutzer(lena);

			ffestigkeitslehre4.setText("�ber welche Gr��e l�sst sich die Biegespannung an verschiedenen Stellen eines biegebelasteten Querschnittes errechnen?");
			ffestigkeitslehre4.addAntwortmoeglichkeiten("Volumentr�gheitsmoment");
			ffestigkeitslehre4.addAntwortmoeglichkeiten("Fl�chentr�gheitsmoment");
			ffestigkeitslehre4.addAntwortmoeglichkeiten("Massentr�gheitsmoment");
			ffestigkeitslehre4.addAntwortmoeglichkeiten("Widerstandsmoment");
			ffestigkeitslehre4.addLoesung("Fl�chentr�gheitsmoment");
			ffestigkeitslehre4.setBenutzer(lena);

			ffestigkeitslehre5.setText("Wie kann man sich den Verlauf von Kr�ften und Momenten in einem Bauteil modellhaft vorstellen?");
			ffestigkeitslehre5.addAntwortmoeglichkeiten("Momentensee");
			ffestigkeitslehre5.addAntwortmoeglichkeiten("Kraftstrom");
			ffestigkeitslehre5.addAntwortmoeglichkeiten("Kraftfluss");
			ffestigkeitslehre5.addAntwortmoeglichkeiten("Kraftbach");
			ffestigkeitslehre5.addLoesung("Kraftfluss");
			ffestigkeitslehre5.setBenutzer(lena);

			ffestigkeitslehre6.setText("Wie kann man die Auswirkung von Kerben bei dynamischer Beanspruchung verringern?");
			ffestigkeitslehre6.addAntwortmoeglichkeiten("Entlastungskerben, Oberfl�chenverfestigung und Entlastungsrisse");
			ffestigkeitslehre6.addAntwortmoeglichkeiten("Oberfl�chenverfestigung und Entlastungsrisse");
			ffestigkeitslehre6.addAntwortmoeglichkeiten("Entlastungskerben und Entlastungsrisse");
			ffestigkeitslehre6.addAntwortmoeglichkeiten("Entlastungskerben und Oberfl�chenverfestigung");
			ffestigkeitslehre6.addLoesung("Entlastungskerben und Oberfl�chenverfestigung");
			ffestigkeitslehre6.setBenutzer(lena);

			ffestigkeitslehre7.setText("Welche Grenze begrenzt den elastischen Bereich einer Probe?");
			ffestigkeitslehre7.addAntwortmoeglichkeiten("Zugfestigkeit");
			ffestigkeitslehre7.addAntwortmoeglichkeiten("0,2% Dehngrenze");
			ffestigkeitslehre7.addAntwortmoeglichkeiten("Streckgrenze");
			ffestigkeitslehre7.addAntwortmoeglichkeiten("Schubfestigkeit");
			ffestigkeitslehre7.addLoesung("Streckgrenze");
			ffestigkeitslehre7.setBenutzer(lena);

			ffestigkeitslehre8.setText("Bei welchem Lastfall ist die Annahme einer homogenen Spannungsverteilung nicht zul�ssig?");
			ffestigkeitslehre8.addAntwortmoeglichkeiten("Druck");
			ffestigkeitslehre8.addAntwortmoeglichkeiten("Biegung");
			ffestigkeitslehre8.addAntwortmoeglichkeiten("Zug");
			ffestigkeitslehre8.addAntwortmoeglichkeiten("Normalbelastung");
			ffestigkeitslehre8.addLoesung("Biegung");
			ffestigkeitslehre8.setBenutzer(lena);

			ffestigkeitslehre9.setText("Welche Festigkeitshypothese eignet sich f�r spr�de Werkstoffe?");
			ffestigkeitslehre9.addAntwortmoeglichkeiten("Schubspannungshypothese");
			ffestigkeitslehre9.addAntwortmoeglichkeiten("Torsionsspannungshypothese");
			ffestigkeitslehre9.addAntwortmoeglichkeiten("Gestalt�nderungsenergiehypothese");
			ffestigkeitslehre9.addAntwortmoeglichkeiten("Normalspannungshypothese");
			ffestigkeitslehre9.addLoesung("Normalspannungshypothese");
			ffestigkeitslehre9.setBenutzer(lena);

			ffestigkeitslehre10.setText("Warum verdreht eine Reinigungskraft einen Lappen, um ihn zu trocknen?");
			ffestigkeitslehre10.addAntwortmoeglichkeiten("Er/Sie wei� nicht, dass Dr�cken besser w�re.");
			ffestigkeitslehre10.addAntwortmoeglichkeiten("Durch die Torsion entstehen hohe Zugspannungen.");
			ffestigkeitslehre10.addAntwortmoeglichkeiten("Durch die Torsion entstehen hohe Schubspannungen.");
			ffestigkeitslehre10.addAntwortmoeglichkeiten("Durch die Torsion entstehen hohe Druckspannungen.");
			ffestigkeitslehre10.addLoesung("Durch die Torsion entstehen hohe Druckspannungen.");
			ffestigkeitslehre10.setBenutzer(lena);

			// philosophie
			fphilosophie1.setText("Worin sah Friedrich Nietzsche exemplarisch die Sklavenmoral?");
			fphilosophie1.addAntwortmoeglichkeiten("Christentum");
			fphilosophie1.addAntwortmoeglichkeiten("Sozialismus");
			fphilosophie1.addAntwortmoeglichkeiten("Philosophie");
			fphilosophie1.addAntwortmoeglichkeiten("Herrenmoral");
			fphilosophie1.addLoesung("Christentum");
			fphilosophie1.setBenutzer(lena);

			fphilosophie2.setText("Wer sagte: 'Das Wesen des Kosmos ist die Zahl!'");
			fphilosophie2.addAntwortmoeglichkeiten("Platon");
			fphilosophie2.addAntwortmoeglichkeiten("Sokrates");
			fphilosophie2.addAntwortmoeglichkeiten("Heraklit");
			fphilosophie2.addAntwortmoeglichkeiten("Pythagoras");
			fphilosophie2.addLoesung("Pythagoras");
			fphilosophie2.setBenutzer(lena);

			fphilosophie3.setText("Welches Jahrhundert gilt als 'das Jahrhundert der Aufl�rung'?");
			fphilosophie3.addAntwortmoeglichkeiten("17. Jahrhundert");
			fphilosophie3.addAntwortmoeglichkeiten("18. Jahrhundert");
			fphilosophie3.addAntwortmoeglichkeiten("19. Jahrhundert");
			fphilosophie3.addAntwortmoeglichkeiten("20. Jahrhundert");
			fphilosophie3.addLoesung("18. Jahrhundert");
			fphilosophie3.setBenutzer(lena);

			fphilosophie4.setText("Wozu ist der Mensch nach Satre verurteilt?");
			fphilosophie4.addAntwortmoeglichkeiten("Der Mensch ist verurteilt, frei zu sein. ");
			fphilosophie4.addAntwortmoeglichkeiten("Der Mensch ist verurteilt, in Ketten zu liegen.");
			fphilosophie4.addAntwortmoeglichkeiten("Der Mensch ist verurteilt, sich in die Zw�nge der bestehenden Welt zu f�gen.");
			fphilosophie4.addAntwortmoeglichkeiten("Der Mensch ist verurteilt, sich seinem Geist zu f�gen.");
			fphilosophie4.addLoesung("Der Mensch ist verurteilt, frei zu sein. ");
			fphilosophie4.setBenutzer(lena);

			fphilosophie5.setText("Was bedeutet eigentlich das Wort Philosophie?");
			fphilosophie5.addAntwortmoeglichkeiten("Liebe zur Kunst");
			fphilosophie5.addAntwortmoeglichkeiten("Liebe zur Weisheit");
			fphilosophie5.addAntwortmoeglichkeiten("Liebe zum Leben");
			fphilosophie5.addAntwortmoeglichkeiten("Liebe zu den Frauen");
			fphilosophie5.addLoesung("Liebe zur Weisheit");
			fphilosophie5.setBenutzer(lena);

			fphilosophie6.setText("Ein Satz, dessen Wahrheit nur auf der Bedeutung der in ihm verwendeten W�rter beruht, hei�t");
			fphilosophie6.addAntwortmoeglichkeiten("eklektizistisch");
			fphilosophie6.addAntwortmoeglichkeiten("analytisch");
			fphilosophie6.addAntwortmoeglichkeiten("synkretistisch");
			fphilosophie6.addAntwortmoeglichkeiten("synthetisch");
			fphilosophie6.addLoesung("analytisch");
			fphilosophie6.setBenutzer(lena);

			fphilosophie7.setText("Philosophen, die die sinnliche Erfahrung als die Hauptquelle aller Erkenntnis betrachten, nennt man");
			fphilosophie7.addAntwortmoeglichkeiten("Euhemeristen");
			fphilosophie7.addAntwortmoeglichkeiten("Epistemologen");
			fphilosophie7.addAntwortmoeglichkeiten("Empiristen");
			fphilosophie7.addAntwortmoeglichkeiten("Synthetiker");
			fphilosophie7.addLoesung("Empiristen");
			fphilosophie7.setBenutzer(lena);

			fphilosophie8.setText("Alle Menschen sind sterblich. Alle Griechen sind Menschen. Alle Griechen sind sterblich. Wie nennt man eine solche logische Ableitung?");
			fphilosophie8.addAntwortmoeglichkeiten("Syllogismus");
			fphilosophie8.addAntwortmoeglichkeiten("Synthese");
			fphilosophie8.addAntwortmoeglichkeiten("Sympathie");
			fphilosophie8.addAntwortmoeglichkeiten("Synergie");
			fphilosophie8.addLoesung("Syllogismus");
			fphilosophie8.setBenutzer(lena);

			fphilosophie9.setText("Der Philosoph Voltaire war der Meinung, Gott habe die Welt zwar geschaffen, greife aber seither nicht mehr in sie ein. Wie nennt man diesen Standpunkt?");
			fphilosophie9.addAntwortmoeglichkeiten("Deismus");
			fphilosophie9.addAntwortmoeglichkeiten("Atheismus");
			fphilosophie9.addAntwortmoeglichkeiten("Polytheismus");
			fphilosophie9.addAntwortmoeglichkeiten("Pantheismus");
			fphilosophie9.addLoesung("Deismus");
			fphilosophie9.setBenutzer(lena);

			fphilosophie10.setText("Welcher Philosoph illustrierte seine �Ideenlehre� mit dem H�hlengleichnis?");
			fphilosophie10.addAntwortmoeglichkeiten("Aristoteles");
			fphilosophie10.addAntwortmoeglichkeiten("Epikur");
			fphilosophie10.addAntwortmoeglichkeiten("Platon");
			fphilosophie10.addAntwortmoeglichkeiten("Epiktet");
			fphilosophie10.addLoesung("Platon");
			fphilosophie10.setBenutzer(lena);

			// informatik
			finformatik1.setText("Wof�r steht der Begriff XML ?");
			finformatik1.addAntwortmoeglichkeiten("Extensible Multimedia Language");
			finformatik1.addAntwortmoeglichkeiten("Expert Markup Language");
			finformatik1.addAntwortmoeglichkeiten("Extensible Markup Language");
			finformatik1.addAntwortmoeglichkeiten("Extensible Markup for Logical Documents");
			finformatik1.addLoesung("Extensible Markup Language");
			finformatik1.setBenutzer(lena);

			finformatik2.setText("Was ist ein Semantisches Netz?");
			finformatik2.addAntwortmoeglichkeiten("die weltweite Verknupfung von Webseiten durch Links");
			finformatik2.addAntwortmoeglichkeiten("eine Form der Wissensorganisation, basierend auf Begriffen und deren Relationen");
			finformatik2.addAntwortmoeglichkeiten("die Struktur einer Webseite");
			finformatik2.addAntwortmoeglichkeiten("eine Ontologie");
			finformatik2.addLoesung("eine Form der Wissensorganisation, basierend auf Begriffen und deren Relationen");
			finformatik2.setBenutzer(lena);

			finformatik3.setText("Wofur steht der Begriff CSS?");
			finformatik3.addAntwortmoeglichkeiten("Cascading Stylesheets");
			finformatik3.addAntwortmoeglichkeiten("Complete Style DeScription");
			finformatik3.addAntwortmoeglichkeiten("Complex Style Semantics");
			finformatik3.addAntwortmoeglichkeiten("Customer Style Semantics");
			finformatik3.addLoesung("Cascading Stylesheets");
			finformatik3.setBenutzer(lena);

			finformatik4.setText("Was ist eine Ontologie?");
			finformatik4.addAntwortmoeglichkeiten("das Semantic Web");
			finformatik4.addAntwortmoeglichkeiten("eine Beschreibung von Sinnzusammenh�ngen");
			finformatik4.addAntwortmoeglichkeiten("Modell einer Dom�ne");
			finformatik4.addAntwortmoeglichkeiten("eine Technik des Web 1.0");
			finformatik4.addLoesung("eine Beschreibung von Sinnzusammenh�ngen");
			finformatik4.setBenutzer(lena);

			finformatik5.setText("Wie kann Wissensmanagement im Web 2.0 erfolgen?");
			finformatik5.addAntwortmoeglichkeiten("durch statische Webseiten");
			finformatik5.addAntwortmoeglichkeiten("durch Kollaboration (social Tagging)");
			finformatik5.addAntwortmoeglichkeiten("durch Blogs als Wissensspeicher");
			finformatik5.addAntwortmoeglichkeiten("durch Austausch beispielsweise innerhalb von Sozialen Netzwerken");
			finformatik5.addLoesung("durch Austausch beispielsweise innerhalb von Sozialen Netzwerken");
			finformatik5.setBenutzer(lena);

			finformatik6.setText("Sei�F=P(f(x)). Welche der folgenden Mengen ist das Herbrand-Universum von�F?");
			finformatik6.addAntwortmoeglichkeiten("{}");
			finformatik6.addAntwortmoeglichkeiten("{f(x)}");
			finformatik6.addAntwortmoeglichkeiten("{a}");
			finformatik6.addAntwortmoeglichkeiten("{a,f(a),f(f(a)),�}");
			finformatik6.addLoesung("{a,f(a),f(f(a)),�}");
			finformatik6.setBenutzer(lena);

			finformatik7.setText("Welche der folgenden Aussagen ist nicht korrekt?");
			finformatik7.addAntwortmoeglichkeiten("Jeder K�rper ist ein Ring.");
			finformatik7.addAntwortmoeglichkeiten("Jede Gruppe ist ein Ring.");
			finformatik7.addAntwortmoeglichkeiten("Jede Gruppe ist ein Monoid.");
			finformatik7.addAntwortmoeglichkeiten("Jedes Monoid ist eine Halbgruppe.");
			finformatik7.addLoesung("Jede Gruppe ist ein Ring.");
			finformatik7.setBenutzer(lena);

			finformatik8.setText("Welches�x�ist eine L�sungen der Gleichung�7x kongruent 1mod20?");
			finformatik8.addAntwortmoeglichkeiten("x=20");
			finformatik8.addAntwortmoeglichkeiten("x=2");
			finformatik8.addAntwortmoeglichkeiten("x=7");
			finformatik8.addAntwortmoeglichkeiten("x=3");
			finformatik8.addLoesung("x=3");
			finformatik8.setBenutzer(lena);

			finformatik9.setText("Was ist die Laufzeitkomplexit�t von Mergesort im Average-Case?");
			finformatik9.addAntwortmoeglichkeiten("O(n)");
			finformatik9.addAntwortmoeglichkeiten("O(n�)");
			finformatik9.addAntwortmoeglichkeiten("O(n*log(n))");
			finformatik9.addAntwortmoeglichkeiten("O(log(n))");
			finformatik9.addLoesung("O(n*log(n))");
			finformatik9.setBenutzer(lena);

			finformatik10.setText("Wie gro� prognostizierte Thomas Watson (IBM) den weltweiten Bedarf an Computern?");
			finformatik10.addAntwortmoeglichkeiten("5");
			finformatik10.addAntwortmoeglichkeiten("10");
			finformatik10.addAntwortmoeglichkeiten("15");
			finformatik10.addAntwortmoeglichkeiten("20");
			finformatik10.addLoesung("5");
			finformatik10.setBenutzer(lena);

			// wiwi
			fvwl1.setText("Zeiten hoher Arbeitslosigkeit");
			fvwl1.addAntwortmoeglichkeiten("haben keinerlei Auswirkungen auf die Kurve der Produktionsm�glichkeiten");
			fvwl1.addAntwortmoeglichkeiten("f�hren zu Punkten auf der Kurve der Produktionsm�glichkeiten");
			fvwl1.addAntwortmoeglichkeiten("f�hren zu Punkten innerhalb der Kurve der Produktionsm�glichkeiten");
			fvwl1.addAntwortmoeglichkeiten("f�hren zu Punkten ausserhalb der Kurve der Produktionsm�glichkeiten");
			fvwl1.addLoesung("f�hren zu Punkten innerhalb der Kurve der Produktionsm�glichkeiten");
			fvwl1.setBenutzer(lena);

			fvwl2.setText("Welche Konsumenten handeln rational?");
			fvwl2.addAntwortmoeglichkeiten("Konsumenten, die Kosten und Nutzen jeder zu treffenden Wahl abw�gen");
			fvwl2.addAntwortmoeglichkeiten("Konsumenten, die keine Billiglohn-Jobs annehmen");
			fvwl2.addAntwortmoeglichkeiten("Konsumenten, die einen Teil ihres Einkommens sparen");
			fvwl2.addAntwortmoeglichkeiten("Konsumenten, die immer das billigste Produkt kaufen");
			fvwl2.addLoesung("Konsumenten, die Kosten und Nutzen jeder zu treffenden Wahl abw�gen");
			fvwl2.setBenutzer(lena);

			fvwl3.setText("Die Zuteilung knapper Fussballmatch-Tickets durch Losentscheid wird aus folgendem Grund durchgef�hrt");
			fvwl3.addAntwortmoeglichkeiten("Verkauf an den Meistbietenden");
			fvwl3.addAntwortmoeglichkeiten("Rationierung");
			fvwl3.addAntwortmoeglichkeiten("Gewinnmotiv");
			fvwl3.addAntwortmoeglichkeiten("aus keinem dieser Gr�nde");
			fvwl3.addLoesung("Gewinnmotiv");
			fvwl3.setBenutzer(lena);

			fvwl4.setText("Welches ist die wahrscheinlichste Ursache einer Preiserh�hung f�r frisches Gem�se?");
			fvwl4.addAntwortmoeglichkeiten("Preissenkung f�r D�nger, der in der Gem�seproduktion eingesetzt wird");
			fvwl4.addAntwortmoeglichkeiten("Ueberschwemmungen, welche die Bauern bei der Gem�seernte �berraschen");
			fvwl4.addAntwortmoeglichkeiten("Preissenkung eines Substitutionsgutes");
			fvwl4.addAntwortmoeglichkeiten("Preiserh�hung eines Komplement�rgutes");
			fvwl4.addLoesung("Ueberschwemmungen, welche die Bauern bei der Gem�seernte �berraschen");
			fvwl4.setBenutzer(lena);

			fvwl5.setText("Angenommen, die Kreuzpreiselastizit�t der Nachfrage in bezug auf zwei Produkte sei negativ. Wir wissen, dass");
			fvwl5.addAntwortmoeglichkeiten("die beiden Produkte normale G�ter sind");
			fvwl5.addAntwortmoeglichkeiten("die beiden Produkte Substitutionsg�ter sind");
			fvwl5.addAntwortmoeglichkeiten("die beiden Produkte inferiore G�ter sind");
			fvwl5.addAntwortmoeglichkeiten("die beiden Produkte Komplement�rg�ter sind");
			fvwl5.addLoesung("die beiden Produkte Komplement�rg�ter sind");
			fvwl5.setBenutzer(lena);

			fvwl6.setText("Eine Unternehmung stellt Hemden und Jacken her. Welche Opportunit�tskosten verursacht die Produktion einer Jacke?");
			fvwl6.addAntwortmoeglichkeiten("Kosten der Produktionsfaktoren, die zur Herstellung einer Jacke erforderlich sind");
			fvwl6.addAntwortmoeglichkeiten("Anzahl der Hemden, die mit den f�r die Herstellung einer Jacke verwendeten Produktionsfaktoren h�tten angefertigt werden k�nnen");
			fvwl6.addAntwortmoeglichkeiten("Gesamtkosten f�r die Herstellung einer Jacke");
			fvwl6.addAntwortmoeglichkeiten("Marktpreis einer Jacke");
			fvwl6.addLoesung("Anzahl der Hemden, die mit den f�r die Herstellung einer Jacke verwendeten Produktionsfaktoren h�tten angefertigt werden k�nnen");
			fvwl6.setBenutzer(lena);

			fvwl7.setText("Falls in einer Unternehmung die kurzfristige Durchschnittskostenkurve steigt,");
			fvwl7.addAntwortmoeglichkeiten("ist bei dieser Menge die Grenzkostenkurve �ber der kurzfristigen Durchschnittskostenkurve");
			fvwl7.addAntwortmoeglichkeiten("f�llt die Grenzkostenkurve");
			fvwl7.addAntwortmoeglichkeiten("hat die Unternehmung die Kontrolle �ber ihre Kosten verloren");
			fvwl7.addAntwortmoeglichkeiten("ist bei dieser Menge die Grenzkostenkurve unter der kurzfristigen Durchschnittskostenkurve");
			fvwl7.addLoesung("ist bei dieser Menge die Grenzkostenkurve �ber der kurzfristigen Durchschnittskostenkurve");
			fvwl7.setBenutzer(lena);

			fvwl8.setText("Unternehmen stehen abnehmenden Skalenertr�gen gegen�ber, wenn");
			fvwl8.addAntwortmoeglichkeiten("die Kosten je St�ck mit zunehmender Produktion steigen");
			fvwl8.addAntwortmoeglichkeiten("die Mitarbeiter mit steigender Produktion eine h�here Gewinnbeteiligung verlangen");
			fvwl8.addAntwortmoeglichkeiten("die fixen Kosten steigen");
			fvwl8.addAntwortmoeglichkeiten("wenn die Unternehmung mit steigender Produktion h�here Preise f�r Produktionsfaktoren zahlen m�ssen");
			fvwl8.addLoesung("die Kosten je St�ck mit zunehmender Produktion steigen");
			fvwl8.setBenutzer(lena);

			fvwl9.setText("Welche Aussage ist f�r die vollst�ndige Konkurrenz charakteristisch?");
			fvwl9.addAntwortmoeglichkeiten("Es gibt auf lange Sicht Schranken f�r den Ein- und Austritt von Anbietern");
			fvwl9.addAntwortmoeglichkeiten("Es gibt eine Produktdifferenzierung (d.h. die Anbieter bieten unterschiedliche Produkte an)");
			fvwl9.addAntwortmoeglichkeiten("Die Anbieter verf�gen in bezug auf den Markt �ber mehr Informationen als die Nachfrager");
			fvwl9.addAntwortmoeglichkeiten("K�ufer und Verk�ufer sind Preisnehmer");
			fvwl9.addLoesung("K�ufer und Verk�ufer sind Preisnehmer");
			fvwl9.setBenutzer(lena);

			fvwl10.setText("Die Einkommenselastizit�t der Nachfrage nach frischem Brot wird auf + 0.3 gesch�tzt. Falls die realen Einkommen der Konsumenten ceteris paribus um 15 % steigen, wird die nachgefragte Menge frisches Brot um folgenden Prozentsatz steigen:");
			fvwl10.addAntwortmoeglichkeiten("4.5 %");
			fvwl10.addAntwortmoeglichkeiten("3%");
			fvwl10.addAntwortmoeglichkeiten("4%");
			fvwl10.addAntwortmoeglichkeiten("15%");
			fvwl10.addLoesung("4.5 %");
			fvwl10.setBenutzer(lena);
			
			// Eintr�ge aktualisieren

			db.eintragAktualisieren(thema.getClass(), thema);
			db.eintragAktualisieren(kommentar.getClass(), kommentar);
			db.eintragAktualisieren(lena.getClass(), lena);
			db.eintragAktualisieren(hannes.getClass(), hannes);
			db.eintragAktualisieren(mbis.getClass(), mbis);
			db.eintragAktualisieren(biks.getClass(), biks);
			db.eintragAktualisieren(wi.getClass(), wi);
			db.eintragAktualisieren(frage.getClass(), frage);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
