package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import learning.Benutzer;
import learning.Bossfight;
import learning.Fachrichtung;
import learning.Frage;
import learning.Gruppe;
import learning.Kommentar;
import learning.Medium;
import learning.Thema;
import datenhaltung.Datenbank;

public class Beispieldaten {

	public static void main(String[] args) {
		dbSchreiben();
		System.err.println("Testlauf vollständig durchgeführt und abgeschlossen");
		System.exit(0);
	}

	public static void dbSchreiben() {
		try {

			Datenbank db = new Datenbank();

			// Objekte instanziieren

			Benutzer hannes = new Benutzer();
			Benutzer lena = new Benutzer();
			Benutzer stefanie = new Benutzer();
			Benutzer paula = new Benutzer();
			Benutzer hans = new Benutzer();
			Benutzer richard = new Benutzer();
			Benutzer philipp = new Benutzer();
			Benutzer nicole = new Benutzer();
			
			Bossfight bossfight = new Bossfight();
			Medium	medium = new Medium();
			
			Gruppe mbis = new Gruppe();
			Gruppe biks = new Gruppe();
			
			Gruppe infobasics = new Gruppe();
			Gruppe vwl = new Gruppe();
			Gruppe bwl = new Gruppe();
			Gruppe ärztlichePrüfung = new Gruppe();
			Gruppe agrareinführung = new Gruppe();
			Gruppe festigkeitslehre = new Gruppe();
			
			
			Thema thema = new Thema();
			Thread.sleep(10L);
			Thema themalena1 = new Thema();
			Thread.sleep(10L);
			Thema themabwl1 = new Thema();
			Thread.sleep(10L);
			Thema themabwl2 = new Thema();
			Thread.sleep(10L);
			Thema themabwl3 = new Thema();
			
			Kommentar kommentar = new Kommentar();
			Kommentar kommentar2 = new Kommentar();
			Fachrichtung wi = new Fachrichtung();
			Fachrichtung agrar = new Fachrichtung();
			Fachrichtung medizin = new Fachrichtung();
			Fachrichtung ingenieur = new Fachrichtung();
			Fachrichtung philosophie = new Fachrichtung();
			
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

			Frage fbwl1 = new Frage();
			Frage fbwl2 = new Frage();
			Frage fbwl3 = new Frage();
			Frage fbwl4 = new Frage();
			Frage fbwl5 = new Frage();
			Frage fbwl6 = new Frage();
			Frage fbwl7 = new Frage();
			Frage fbwl8 = new Frage();
			Frage fbwl9 = new Frage();
			Frage fbwl10 = new Frage();
			// Eintrag hinzufügen zur Datenbank

			db.eintragHinzufuegen(thema.getClass(), thema);
			db.eintragHinzufuegen(themalena1.getClass(), themalena1);
			db.eintragHinzufuegen(themabwl1.getClass(), themabwl1);
			db.eintragHinzufuegen(themabwl2.getClass(), themabwl2);
			db.eintragHinzufuegen(themabwl3.getClass(), themabwl3);
			
			db.eintragHinzufuegen(bossfight.getClass(), bossfight);
			db.eintragHinzufuegen(medium.getClass(), medium);
			
			db.eintragHinzufuegen(kommentar.getClass(), kommentar);
			db.eintragHinzufuegen(kommentar2.getClass(), kommentar2);
			db.eintragHinzufuegen(hannes.getClass(), hannes);
			db.eintragHinzufuegen(lena.getClass(), lena);
			db.eintragHinzufuegen(richard.getClass(), richard);
			db.eintragHinzufuegen(stefanie.getClass(), stefanie);
			db.eintragHinzufuegen(paula.getClass(), paula);
			db.eintragHinzufuegen(hans.getClass(), hans);
			db.eintragHinzufuegen(philipp.getClass(), philipp);
			db.eintragHinzufuegen(nicole.getClass(), nicole);
			
			db.eintragHinzufuegen(mbis.getClass(), mbis);
			db.eintragHinzufuegen(biks.getClass(), biks);
			db.eintragHinzufuegen(wi.getClass(), wi);
			db.eintragHinzufuegen(frage.getClass(), frage);
			
			db.eintragHinzufuegen(agrar.getClass(), agrar);
			db.eintragHinzufuegen(philosophie.getClass(), philosophie);
			db.eintragHinzufuegen(ingenieur.getClass(), ingenieur);
			db.eintragHinzufuegen(medizin.getClass(), medizin);
			
			db.eintragHinzufuegen(finformatik1.getClass(), finformatik1);
			db.eintragHinzufuegen(finformatik2.getClass(), finformatik2);
			db.eintragHinzufuegen(finformatik3.getClass(), finformatik3);
			db.eintragHinzufuegen(finformatik4.getClass(), finformatik4);
			db.eintragHinzufuegen(finformatik5.getClass(), finformatik5);
			db.eintragHinzufuegen(finformatik6.getClass(), finformatik6);
			db.eintragHinzufuegen(finformatik7.getClass(), finformatik7);
			db.eintragHinzufuegen(finformatik8.getClass(), finformatik8);
			db.eintragHinzufuegen(finformatik9.getClass(), finformatik9);
			db.eintragHinzufuegen(finformatik10.getClass(), finformatik10);	
			db.eintragHinzufuegen(fvwl1.getClass(), fvwl1);
			db.eintragHinzufuegen(fvwl2.getClass(), fvwl2);
			db.eintragHinzufuegen(fvwl3.getClass(), fvwl3);
			db.eintragHinzufuegen(fvwl4.getClass(), fvwl4);
			db.eintragHinzufuegen(fvwl5.getClass(), fvwl5);
			db.eintragHinzufuegen(fvwl6.getClass(), fvwl6);
			db.eintragHinzufuegen(fvwl7.getClass(), fvwl7);
			db.eintragHinzufuegen(fvwl8.getClass(), fvwl8);
			db.eintragHinzufuegen(fvwl9.getClass(), fvwl9);
			db.eintragHinzufuegen(fvwl10.getClass(), fvwl10);		
			db.eintragHinzufuegen(fphilosophie1.getClass(), fphilosophie1);
			db.eintragHinzufuegen(fphilosophie2.getClass(), fphilosophie2);
			db.eintragHinzufuegen(fphilosophie3.getClass(), fphilosophie3);
			db.eintragHinzufuegen(fphilosophie4.getClass(), fphilosophie4);
			db.eintragHinzufuegen(fphilosophie5.getClass(), fphilosophie5);
			db.eintragHinzufuegen(fphilosophie6.getClass(), fphilosophie6);
			db.eintragHinzufuegen(fphilosophie7.getClass(), fphilosophie7);
			db.eintragHinzufuegen(fphilosophie8.getClass(), fphilosophie8);
			db.eintragHinzufuegen(fphilosophie9.getClass(), fphilosophie9);
			db.eintragHinzufuegen(fphilosophie10.getClass(), fphilosophie10);
			db.eintragHinzufuegen(fagrar1.getClass(), fagrar1);
			db.eintragHinzufuegen(fagrar2.getClass(), fagrar2);
			db.eintragHinzufuegen(fagrar3.getClass(), fagrar3);
			db.eintragHinzufuegen(fagrar4.getClass(), fagrar4);
			db.eintragHinzufuegen(fagrar5.getClass(), fagrar5);
			db.eintragHinzufuegen(fagrar6.getClass(), fagrar6);
			db.eintragHinzufuegen(fagrar7.getClass(), fagrar7);
			db.eintragHinzufuegen(fagrar8.getClass(), fagrar8);
			db.eintragHinzufuegen(fagrar9.getClass(), fagrar9);
			db.eintragHinzufuegen(fagrar10.getClass(), fagrar10);
			db.eintragHinzufuegen(fmedizin1.getClass(), fmedizin1);
			db.eintragHinzufuegen(fmedizin2.getClass(), fmedizin2);
			db.eintragHinzufuegen(fmedizin3.getClass(), fmedizin3);
			db.eintragHinzufuegen(fmedizin4.getClass(), fmedizin4);
			db.eintragHinzufuegen(fmedizin5.getClass(), fmedizin5);
			db.eintragHinzufuegen(fmedizin6.getClass(), fmedizin6);
			db.eintragHinzufuegen(fmedizin7.getClass(), fmedizin7);
			db.eintragHinzufuegen(fmedizin8.getClass(), fmedizin8);
			db.eintragHinzufuegen(fmedizin9.getClass(), fmedizin9);
			db.eintragHinzufuegen(fmedizin10.getClass(), fmedizin10);
			db.eintragHinzufuegen(ffestigkeitslehre1.getClass(), ffestigkeitslehre1);
			db.eintragHinzufuegen(ffestigkeitslehre2.getClass(), ffestigkeitslehre2);
			db.eintragHinzufuegen(ffestigkeitslehre3.getClass(), ffestigkeitslehre3);
			db.eintragHinzufuegen(ffestigkeitslehre4.getClass(), ffestigkeitslehre4);
			db.eintragHinzufuegen(ffestigkeitslehre5.getClass(), ffestigkeitslehre5);
			db.eintragHinzufuegen(ffestigkeitslehre6.getClass(), ffestigkeitslehre6);
			db.eintragHinzufuegen(ffestigkeitslehre7.getClass(), ffestigkeitslehre7);
			db.eintragHinzufuegen(ffestigkeitslehre8.getClass(), ffestigkeitslehre8);
			db.eintragHinzufuegen(ffestigkeitslehre9.getClass(), ffestigkeitslehre9);
			db.eintragHinzufuegen(ffestigkeitslehre10.getClass(), ffestigkeitslehre10);

			// Objekte füllen und verbinden

			hannes.registrieren("hannes", "spiegelei");
			hannes.setEmailAdresse("mail@hannes-fischer.com");
			hannes.setName("Hannes Fischer");
			hannes.setAdresse("Bühlenstr. 100, 71088 Holzgerlingen");
			hannes.setRang(1000);
			hannes.setBeruf("Student");
			hannes.setStudiengang("vwlsinformatik B.Sc.");
			hannes.setGeburtsdatum("01/26/1995");
			hannes.setProfilbildURL("/Bild.png");
			hannes.erstelltAm = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

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
			
			//richard
			richard.registrieren("richard", "12345678");
			richard.setEmailAdresse("lenamai.er@web.de");
			richard.setName("Richard Laumayer");
			richard.setAdresse("Bielefeld");
			richard.setRang(20);
			richard.setBeruf("Student");
			richard.setStudiengang("Bauingenieur B.Sc.");
			richard.setGeburtsdatum("16/06/1995");
			richard.setProfilbildURL("/Bild.png");
			richard.erstelltAm = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			richard.freundHinzufuegen(lena);
			// stefanie
			stefanie.registrieren("stefanie", "12345678");
			stefanie.setEmailAdresse("lenamai.er@web.de");
			stefanie.setName("Stefanie Bieler");
			stefanie.setAdresse("Stuttgart");
			stefanie.setRang(430);
			stefanie.setBeruf("Student");
			stefanie.setStudiengang("Wiwi B.Sc.");
			stefanie.setGeburtsdatum("16/06/1995");
			stefanie.setProfilbildURL("/Bild.png");
			stefanie.erstelltAm = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			stefanie.freundHinzufuegen(lena);
			// paula
			paula.registrieren("paula", "12345678");
			paula.setEmailAdresse("lenamai.er@web.de");
			paula.setName("Paula Frei");
			paula.setAdresse("Stuttgart");
			paula.setRang(520);
			paula.setBeruf("Künstlerin");
			paula.setStudiengang("Archtitektur B.Sc.");
			paula.setGeburtsdatum("16/04/1993");
			paula.setProfilbildURL("/Bild.png");
			paula.erstelltAm = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			paula.freundHinzufuegen(lena);
			//Hans
			hans.registrieren("hans", "12345678");
			hans.setEmailAdresse("lenamai.er@web.de");
			hans.setName("Hans Zimmer");
			hans.setAdresse("Bielefeld");
			hans.setRang(20);
			hans.setBeruf("Student");
			hans.setStudiengang("wissenschaftlicher Mitarbeiter");
			hans.setGeburtsdatum("04/06/1990");
			hans.setProfilbildURL("/Bild.png");
			hans.erstelltAm = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			hans.freundHinzufuegen(lena);
			
		// philipp
			philipp.registrieren("philipp", "12345678");
			philipp.setEmailAdresse("lenamai.er@web.de");
			philipp.setName("Philipp Peters");
			philipp.setAdresse("Bielefeld");
			philipp.setRang(20);
			philipp.setBeruf("Student");
			philipp.setStudiengang("Lehramt");
			philipp.setGeburtsdatum("16/06/1995");
			philipp.setProfilbildURL("/Bild.png");
			philipp.erstelltAm = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			philipp.freundHinzufuegen(lena);
			
			// nicole
			nicole.registrieren("nicole", "12345678");
			nicole.setEmailAdresse("lenamai.er@web.de");
			nicole.setName("Nicole Laumayer");
			nicole.setAdresse("Bielefeld");
			nicole.setRang(20);
			nicole.setBeruf("Student");
			nicole.setStudiengang("Lebensmittelchemie B.Sc.");
			nicole.setGeburtsdatum("07/02/1993");
			nicole.setProfilbildURL("/Bild.png");
			nicole.erstelltAm = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			nicole.freundHinzufuegen(lena);

			hannes.freundHinzufuegen(lena);
			hannes.freundHinzufuegen(richard);
			hannes.freundHinzufuegen(stefanie);
			hannes.freundHinzufuegen(paula);
			hannes.freundHinzufuegen(hans);
			hannes.freundHinzufuegen(philipp);
			hannes.freundHinzufuegen(nicole);
			
			medium.setDateiname("Musterklausur.pdf");
			medium.setName("Musterklausur");
			
			bossfight.setMedium(medium);
			
			wi.setName("Wirtschaftsinformatik");
			wi.setFreigegeben(false);

			mbis.setFachrichtung(wi);
			mbis.setKlausurname("MBIS");
			mbis.setName("Management betrieblicher Informationssysteme");
			mbis.setProfilbildURL("/Gruppenbild.png");
			mbis.mitgliedHinzufuegen(lena);
			mbis.mitgliedHinzufuegen(hannes);
			mbis.moderatorHinzufuegen(hannes);
			mbis.pinnwand.themaHinzufuegen(thema);
			mbis.fragenpool.addFrage(frage);
			mbis.setFachrichtungsname("WI");

			biks.setFachrichtung(wi);
			biks.setKlausurname("BIKS");
			biks.setName("Betriebliche Informations- und Kommunikationssyseme");
			biks.setProfilbildURL("/BIKS.png");
			biks.mitgliedHinzufuegen(hannes);
			biks.moderatorHinzufuegen(hannes);
			biks.setFachrichtung(wi);
			biks.setKlausurname("MBIS 1");
			mbis.setFachrichtungsname("WI");
			
			biks.teamcombatAntreten(mbis);
			
			bwl.setFachrichtung(wi);
			bwl.setKlausurname("BWL");
			bwl.setName("Betriebswirtschaftslehre");
			bwl.setProfilbildURL("/Gruppenbild.png");
			bwl.mitgliedHinzufuegen(lena);
			bwl.mitgliedHinzufuegen(hannes);
			bwl.mitgliedHinzufuegen(hans);
			bwl.mitgliedHinzufuegen(nicole);
			bwl.mitgliedHinzufuegen(richard);
			bwl.mitgliedHinzufuegen(philipp);
			bwl.mitgliedHinzufuegen(paula);
			bwl.mitgliedHinzufuegen(stefanie);
			bwl.moderatorHinzufuegen(hannes);
			bwl.pinnwand.themaHinzufuegen(thema);
			bwl.fragenpool.addFrage(fbwl1);
			bwl.fragenpool.addFrage(fbwl2);
			bwl.fragenpool.addFrage(fbwl3);
			bwl.fragenpool.addFrage(fbwl4);
			bwl.fragenpool.addFrage(fbwl5);
			bwl.fragenpool.addFrage(fbwl6);
			bwl.fragenpool.addFrage(fbwl7);
			bwl.fragenpool.addFrage(fbwl8);
			bwl.fragenpool.addFrage(fbwl9);
			bwl.fragenpool.addFrage(fbwl10);
			mbis.setFachrichtungsname("WiWi");
			bwl.addBossfight(bossfight);
			
			vwl.setFachrichtung(wi);
			vwl.setKlausurname("VWL");
			vwl.setName("Volkswirtschaftslehre");
			vwl.setProfilbildURL("/Gruppenbild.png");
			vwl.mitgliedHinzufuegen(lena);
			vwl.mitgliedHinzufuegen(hannes);
			vwl.mitgliedHinzufuegen(hans);
			vwl.mitgliedHinzufuegen(nicole);
			vwl.mitgliedHinzufuegen(richard);
			vwl.mitgliedHinzufuegen(philipp);
			vwl.mitgliedHinzufuegen(paula);
			vwl.mitgliedHinzufuegen(stefanie);
			vwl.moderatorHinzufuegen(hannes);
			vwl.pinnwand.themaHinzufuegen(thema);
			vwl.fragenpool.addFrage(fvwl1);
			vwl.fragenpool.addFrage(fvwl2);
			vwl.fragenpool.addFrage(fvwl3);
			vwl.fragenpool.addFrage(fvwl4);
			vwl.fragenpool.addFrage(fvwl5);
			vwl.fragenpool.addFrage(fvwl6);
			vwl.fragenpool.addFrage(fvwl7);
			vwl.fragenpool.addFrage(fvwl8);
			vwl.fragenpool.addFrage(fvwl9);
			vwl.fragenpool.addFrage(fvwl10);
			mbis.setFachrichtungsname("WiWi");
			
			infobasics.setFachrichtung(wi);
			infobasics.setKlausurname("InfoBasic");
			infobasics.setName("Grundwissen Informatik");
			infobasics.setProfilbildURL("/Gruppenbild.png");
			infobasics.mitgliedHinzufuegen(lena);
			infobasics.mitgliedHinzufuegen(hannes);
			infobasics.mitgliedHinzufuegen(richard);
			infobasics.mitgliedHinzufuegen(stefanie);
			infobasics.mitgliedHinzufuegen(paula);
			infobasics.moderatorHinzufuegen(hannes);
			infobasics.pinnwand.themaHinzufuegen(thema);
			infobasics.fragenpool.addFrage(finformatik1);
			infobasics.fragenpool.addFrage(finformatik2);
			infobasics.fragenpool.addFrage(finformatik3);
			infobasics.fragenpool.addFrage(finformatik4);
			infobasics.fragenpool.addFrage(finformatik5);
			infobasics.fragenpool.addFrage(finformatik6);
			infobasics.fragenpool.addFrage(finformatik7);
			infobasics.fragenpool.addFrage(finformatik8);
			infobasics.fragenpool.addFrage(finformatik9);
			infobasics.fragenpool.addFrage(finformatik10);
			mbis.setFachrichtungsname("Info");
			
			
			
			ärztlichePrüfung.setFachrichtung(wi);
			ärztlichePrüfung.setKlausurname("Staatsexamen Medizin");
			ärztlichePrüfung.setName("Anatomie");
			ärztlichePrüfung.setProfilbildURL("/Gruppenbild.png");
			ärztlichePrüfung.mitgliedHinzufuegen(lena);
			ärztlichePrüfung.mitgliedHinzufuegen(hannes);
			ärztlichePrüfung.mitgliedHinzufuegen(nicole);
			ärztlichePrüfung.mitgliedHinzufuegen(philipp);
			ärztlichePrüfung.moderatorHinzufuegen(hannes);
			ärztlichePrüfung.pinnwand.themaHinzufuegen(thema);
			ärztlichePrüfung.fragenpool.addFrage(fmedizin1);
			ärztlichePrüfung.fragenpool.addFrage(fmedizin2);
			ärztlichePrüfung.fragenpool.addFrage(fmedizin3);
			ärztlichePrüfung.fragenpool.addFrage(fmedizin4);
			ärztlichePrüfung.fragenpool.addFrage(fmedizin5);
			ärztlichePrüfung.fragenpool.addFrage(fmedizin6);
			ärztlichePrüfung.fragenpool.addFrage(fmedizin7);
			ärztlichePrüfung.fragenpool.addFrage(fmedizin8);
			ärztlichePrüfung.fragenpool.addFrage(fmedizin9);
			ärztlichePrüfung.fragenpool.addFrage(fmedizin10);
			mbis.setFachrichtungsname("Medizin");
			
			
			
			agrareinführung.setFachrichtung(agrar);
			agrareinführung.setKlausurname("AGRA");
			agrareinführung.setName("Agrarwirtschaft 2");
			agrareinführung.setProfilbildURL("/Gruppenbild.png");
			agrareinführung.mitgliedHinzufuegen(lena);
			agrareinführung.mitgliedHinzufuegen(hannes);
			agrareinführung.mitgliedHinzufuegen(paula);
			agrareinführung.mitgliedHinzufuegen(hans);
			agrareinführung.mitgliedHinzufuegen(stefanie);
			agrareinführung.moderatorHinzufuegen(hannes);
			agrareinführung.pinnwand.themaHinzufuegen(thema);
			agrareinführung.fragenpool.addFrage(fagrar1);
			agrareinführung.fragenpool.addFrage(fagrar2);
			agrareinführung.fragenpool.addFrage(fagrar3);
			agrareinführung.fragenpool.addFrage(fagrar4);
			agrareinführung.fragenpool.addFrage(fagrar5);
			agrareinführung.fragenpool.addFrage(fagrar6);
			agrareinführung.fragenpool.addFrage(fagrar7);
			agrareinführung.fragenpool.addFrage(fagrar8);
			agrareinführung.fragenpool.addFrage(fagrar9);
			agrareinführung.fragenpool.addFrage(fagrar10);
			mbis.setFachrichtungsname("Agrar");
			

			
			festigkeitslehre.setFachrichtung(ingenieur);
			festigkeitslehre.setKlausurname("Festigkeitslehre 1");
			festigkeitslehre.setName("Festigkeitslehre");
			festigkeitslehre.setProfilbildURL("/Gruppenbild.png");
			festigkeitslehre.mitgliedHinzufuegen(lena);
			festigkeitslehre.mitgliedHinzufuegen(hannes);
			festigkeitslehre.mitgliedHinzufuegen(hans);
			festigkeitslehre.moderatorHinzufuegen(hannes);
			festigkeitslehre.pinnwand.themaHinzufuegen(thema);
			festigkeitslehre.fragenpool.addFrage(ffestigkeitslehre1);
			festigkeitslehre.fragenpool.addFrage(ffestigkeitslehre2);
			festigkeitslehre.fragenpool.addFrage(ffestigkeitslehre3);
			festigkeitslehre.fragenpool.addFrage(ffestigkeitslehre4);
			festigkeitslehre.fragenpool.addFrage(ffestigkeitslehre5);
			festigkeitslehre.fragenpool.addFrage(ffestigkeitslehre6);
			festigkeitslehre.fragenpool.addFrage(ffestigkeitslehre7);
			festigkeitslehre.fragenpool.addFrage(ffestigkeitslehre8);
			festigkeitslehre.fragenpool.addFrage(ffestigkeitslehre9);
			festigkeitslehre.fragenpool.addFrage(ffestigkeitslehre10);
			mbis.setFachrichtungsname("Ing");

			kommentar2.setBenutzer(lena);
			kommentar2.setBewertung(0);
			kommentar2.setInhalt("Gerne!");
			kommentar2.setThema(thema);
			
			kommentar.setBenutzer(hannes);
			kommentar.setBewertung(0);
			kommentar.setInhalt("Dankeschön!");
			kommentar.setThema(thema);

			
			
			thema.setPinnwand(hannes.pinnwand);
			thema.setBenutzer(lena);
			thema.setBewertung(5);
			thema.setTitel("Happy Birthday");
			thema.setInhalt("Ich wünsch Dir alles Gute zum Geburtstag!");
			thema.kommentieren(kommentar);
			
			themabwl1.setPinnwand(bwl.pinnwand);
			themabwl1.setBenutzer(hannes);
			themabwl1.setBewertung(4);
			themabwl1.setInhalt("Vorlesung morgen fällt aus!");
			themabwl1.setTitel("WICHTIG");
			
			themabwl2.setPinnwand(bwl.pinnwand);
			themabwl2.setBenutzer(lena);
			themabwl2.setBewertung(0);
			themabwl2.setInhalt("Hat jemand Aufgabe 8.2 verstanden? :/");
			themabwl2.setTitel("Frage");
			
			themabwl3.setPinnwand(bwl.pinnwand);
			themabwl3.setBenutzer(hannes);
			themabwl3.setBewertung(4);
			themabwl3.setInhalt("Hey Leute, unter wikipedia.de findet ihr einige cooles Infos.");
			themabwl3.setTitel("Link zur Aufgabe");
			
			themalena1.setPinnwand(lena.pinnwand);
			themalena1.setBenutzer(lena);
			themalena1.setBewertung(1);
			themalena1.setInhalt("Hey Leute, hab leider mein Handy verloren");
			themalena1.setTitel("Nur per Facebook erreichbar");

			// Fragen

			frage.setText("Wieviel Uhr ist es?");
			frage.addAntwortmoeglichkeiten("17:00");
			frage.addAntwortmoeglichkeiten("18:00");
			frage.addAntwortmoeglichkeiten("19:00");
			frage.addLoesung("17:00");
			frage.setBenutzer(lena);
			
			
			// 60 Fragen 6 Kategorien

			fagrar1.setText("Welches Getreide liefert weltweit die größten Erträge?");
			fagrar1.addAntwortmoeglichkeiten("Mais");
			fagrar1.addAntwortmoeglichkeiten("Weizen");
			fagrar1.addAntwortmoeglichkeiten("Roggen");
			fagrar1.addAntwortmoeglichkeiten("Roggen");
			fagrar1.addLoesung("Mais");
			fagrar1.setBenutzer(lena);

			fagrar2.setText("Den Gurkenflieger nutzt man …");
			fagrar2.addAntwortmoeglichkeiten("bei der Ernte mancher Gemüsepflanzen");
			fagrar2.addAntwortmoeglichkeiten("in Krisengebieten");
			fagrar2.addAntwortmoeglichkeiten("zum Bestäuben der Gurkenfliegerweibchen");
			fagrar2.addAntwortmoeglichkeiten("zum Bestellen des Feldes");
			fagrar2.addLoesung("bei der Ernte mancher Gemüsepflanzen");
			fagrar2.setBenutzer(lena);

			fagrar3.setText("Welche Fläche steht neun gemeinsam gehaltenen Legehennen gesetzlich mindestens zu?");
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

			fagrar5.setText("Schafe gehören zur Unterfamilie der …");
			fagrar5.addAntwortmoeglichkeiten("Ziegenartigen");
			fagrar5.addAntwortmoeglichkeiten("Wolfsartigen");
			fagrar5.addAntwortmoeglichkeiten("Rinderartigen");
			fagrar5.addAntwortmoeglichkeiten("Katzenartigen");
			fagrar5.addLoesung("Ziegenartigen");
			fagrar5.setBenutzer(lena);

			fagrar6.setText("Was ist die Besonderheit des Onagadori-Huhns?");
			fagrar6.addAntwortmoeglichkeiten("Es kann keine Eier legen.");
			fagrar6.addAntwortmoeglichkeiten("Es hat zwei Köpfe.");
			fagrar6.addAntwortmoeglichkeiten("Es bekommt einen meterlangen Schwanz.");
			fagrar6.addAntwortmoeglichkeiten("Es legt zwei Eier.");
			fagrar6.addLoesung("Es bekommt einen meterlangen Schwanz.");
			fagrar6.setBenutzer(lena);

			fagrar7.setText("Welche dieser Pflanzen ist kein Nachtschattengewächs?");
			fagrar7.addAntwortmoeglichkeiten("Tomate");
			fagrar7.addAntwortmoeglichkeiten("Tabak");
			fagrar7.addAntwortmoeglichkeiten("Trollblume");
			fagrar7.addAntwortmoeglichkeiten("Kartoffel");
			fagrar7.addLoesung("Trollblume");
			fagrar7.setBenutzer(lena);

			fagrar8.setText("Wann sind Zuckerrüben reif zum Ernten?");
			fagrar8.addAntwortmoeglichkeiten("Wenn die Pflanze höher als drei Meter gewachsen ist.");
			fagrar8.addAntwortmoeglichkeiten("Wenn die Blattspitzen gelb werden.");
			fagrar8.addAntwortmoeglichkeiten("Wenn die Pflanze ihre Blätter verliert.");
			fagrar8.addAntwortmoeglichkeiten("Wenn die Rüben ein Gewicht von 2kg überschritten haben.");
			fagrar8.addLoesung("Wenn die Blattspitzen gelb werden.");
			fagrar8.setBenutzer(lena);

			fagrar9.setText("Welches ist das größte Weinanbaugebiet?");
			fagrar9.addAntwortmoeglichkeiten("Franken");
			fagrar9.addAntwortmoeglichkeiten("Nahen");
			fagrar9.addAntwortmoeglichkeiten("Mittelrhein");
			fagrar9.addAntwortmoeglichkeiten("Rheinhessen");
			fagrar9.addLoesung("Rheinhessen");
			fagrar9.setBenutzer(lena);

			fagrar10.setText("Wenn die Tageslänge innerhalb eines Jahres variiert, spricht man von");
			fagrar10.addAntwortmoeglichkeiten("Jahreszeitenklima");
			fagrar10.addAntwortmoeglichkeiten("Tageszeitenklima");
			fagrar10.addAntwortmoeglichkeiten("Endzeitklima");
			fagrar10.addAntwortmoeglichkeiten("Makroklima");
			fagrar10.addLoesung("Jahreszeitenklima");
			fagrar10.setBenutzer(lena);

			// medizin
			fmedizin1.setText("Zur Hautdesinfektion wird eine Körperstelle mit Alkohol (99%iges Ethanol) benetzt. Dieser Hautbereich fühlt sich daraufhin vorübergehend kühl an. Dies liegt üblicherweise vor allem daran, dass");
			fmedizin1.addAntwortmoeglichkeiten("Alkohol eine höhere Wärmeleitfähigkeit als Luft hat");
			fmedizin1.addAntwortmoeglichkeiten("abgestoßene Hautpartikel im Alkohol in Lösung gehen");
			fmedizin1.addAntwortmoeglichkeiten("bei der Verdunstung des Alkohols der Haut Wärmeenergie entzogen wird");
			fmedizin1.addAntwortmoeglichkeiten("die spezifische Wärmekapazität des Alkohols größer als die der Luft ist");
			fmedizin1.addLoesung("bei der Verdunstung des Alkohols der Haut Wärmeenergie entzogen wird");
			fmedizin1.setBenutzer(lena);

			fmedizin2.setText("Eine akute alveoläre Hyperventilation aufgrund psychischer Belastung geht am wahrscheinlichsten einher mit einer/einem");
			fmedizin2.addAntwortmoeglichkeiten("erhöhten arteriellen Protonen-Konzentration");
			fmedizin2.addAntwortmoeglichkeiten("pH-abhängigen Dilatation der zerebralen Arteriolen");
			fmedizin2.addAntwortmoeglichkeiten("gesteigerten neuromuskulären Erregbarkeit");
			fmedizin2.addAntwortmoeglichkeiten("erhöhten arteriellen CO2-Partialdruck");
			fmedizin2.addLoesung("gesteigerten neuromuskulären Erregbarkeit");
			fmedizin2.setBenutzer(lena);

			fmedizin3.setText("Auf einem etwa 5,5 km hohen Berg ist der Luftdruck nur etwa halb so groß wie der Luftdruck auf Meereshöhe. Etwa wie groß ist der Sauerstoff-Partialdruck auf dem Berg?");
			fmedizin3.addAntwortmoeglichkeiten("100 hPa");
			fmedizin3.addAntwortmoeglichkeiten("200 hPa");
			fmedizin3.addAntwortmoeglichkeiten("20 hPa");
			fmedizin3.addAntwortmoeglichkeiten("500 hPa");
			fmedizin3.addLoesung("100 hPa");
			fmedizin3.setBenutzer(lena);

			fmedizin4.setText("Ein Läufer setzte in einer Stunde etwa 2 400 kJ in mechanische Arbeit und Wärme um. Sein durchschnittlicher Energieumsatz betrug in dieser Zeit somit etwa");
			fmedizin4.addAntwortmoeglichkeiten("0,67 W");
			fmedizin4.addAntwortmoeglichkeiten("2,4 W");
			fmedizin4.addAntwortmoeglichkeiten("240 W");
			fmedizin4.addAntwortmoeglichkeiten("670 W");
			fmedizin4.addLoesung("670 W");
			fmedizin4.setBenutzer(lena);

			fmedizin5.setText("Beim nichttrainierten gesunden Erwachsenen kommt es mit zunehmendem Lebensalter zwischen 30 und 80 Jahren (bei jeweils gleichem Körpergewicht) am wahrscheinlichsten zur/zum");
			fmedizin5.addAntwortmoeglichkeiten("Abnahme der Vitalkapazität der Lunge");
			fmedizin5.addAntwortmoeglichkeiten("Abnahme des arteriellen Mitteldrucks");
			fmedizin5.addAntwortmoeglichkeiten("Abnahme des Herzgewichts");
			fmedizin5.addAntwortmoeglichkeiten("Anstieg der glomerulären Filtrationsrate");
			fmedizin5.addLoesung("Abnahme der Vitalkapazität der Lunge");
			fmedizin5.setBenutzer(lena);

			fmedizin6.setText("Die Elektronegativität ist die Energie zur Entfernung eines Valenzelektrons.");
			fmedizin6.addAntwortmoeglichkeiten("Die Elektronegativität ist ein Maß für das Bestreben eines Atoms, in einer kovalenten Bindung Elektronen an sich zu ziehen.");
			fmedizin6.addAntwortmoeglichkeiten("Die elektronegativsten Elemente stehen im Periodensystem der Elemente links unten.");
			fmedizin6.addAntwortmoeglichkeiten("Elektronegativität und Elektronenaffinität sind identische Größen.");
			fmedizin6.addAntwortmoeglichkeiten("Die Elektronegativität ist ein Maß für das Bestreben eines Atoms, in einer kovalenten Bindung Elektronen an sich zu ziehen.");
			fmedizin6.addLoesung("");
			fmedizin6.setBenutzer(lena);

			fmedizin7.setText("ADP");
			fmedizin7.addAntwortmoeglichkeiten("enthält drei Phosphatgruppen");
			fmedizin7.addAntwortmoeglichkeiten("enthält eine Pyrimidinbase");
			fmedizin7.addAntwortmoeglichkeiten("ist ein Substrat der DNA-Polymerasen");
			fmedizin7.addAntwortmoeglichkeiten("ist ein Nucleotid");
			fmedizin7.addLoesung("ist ein Nucleotid");
			fmedizin7.setBenutzer(lena);

			fmedizin8.setText("Eine Quelle sendet zu einem bestimmten Zeitpunkt sowohl ein visuelles als auch ein akustisches Signal aus. Etwa welchen zeitlichen Abstand haben visuelles und akustisches Signal nach 30 m Entfernung in Luft (bei 0 °C)?");
			fmedizin8.addAntwortmoeglichkeiten("0,01 s");
			fmedizin8.addAntwortmoeglichkeiten("0,03 s");
			fmedizin8.addAntwortmoeglichkeiten("0,09 s");
			fmedizin8.addAntwortmoeglichkeiten("0,18 s");
			fmedizin8.addLoesung("0,09 s");
			fmedizin8.setBenutzer(lena);

			fmedizin9.setText("Die Hauptmenge des Eisens im Blutplasma ist (bei gesunden Erwachsenen) gebunden an");
			fmedizin9.addAntwortmoeglichkeiten("Albumin");
			fmedizin9.addAntwortmoeglichkeiten("Ferritin");
			fmedizin9.addAntwortmoeglichkeiten("Hämoglobin");
			fmedizin9.addAntwortmoeglichkeiten("Transferrin");
			fmedizin9.addLoesung("Transferrin");
			fmedizin9.setBenutzer(lena);

			fmedizin10.setText("Die Glucose-Konzentration im Serum eines Patienten beträgt 5 mmol/L. Die ungefähre relative Atommasse von H ist 1, von C 12 und von O 16. Etwa wie viel Milligramm Glucose sind in 100 mL = 1 dL Serum enthalten?");
			fmedizin10.addAntwortmoeglichkeiten("9 mg");
			fmedizin10.addAntwortmoeglichkeiten("62 mg");
			fmedizin10.addAntwortmoeglichkeiten("73 mg");
			fmedizin10.addAntwortmoeglichkeiten("90 mg");
			fmedizin10.addLoesung("90 mg");
			fmedizin10.setBenutzer(lena);

			// festigkeitlehre

			ffestigkeitslehre1.setText("Unter welchem Winkel bricht Kreide bei Torsion?");
			ffestigkeitslehre1.addAntwortmoeglichkeiten("45°");
			ffestigkeitslehre1.addAntwortmoeglichkeiten("90°");
			ffestigkeitslehre1.addAntwortmoeglichkeiten("0°");
			ffestigkeitslehre1.addAntwortmoeglichkeiten("180°");
			ffestigkeitslehre1.addLoesung("45°");
			ffestigkeitslehre1.setBenutzer(lena);

			ffestigkeitslehre2.setText("Wie groß ist die Zugfestigkeit von S235?");
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

			ffestigkeitslehre4.setText("Über welche Größe lässt sich die Biegespannung an verschiedenen Stellen eines biegebelasteten Querschnittes errechnen?");
			ffestigkeitslehre4.addAntwortmoeglichkeiten("Volumenträgheitsmoment");
			ffestigkeitslehre4.addAntwortmoeglichkeiten("Flächenträgheitsmoment");
			ffestigkeitslehre4.addAntwortmoeglichkeiten("Massenträgheitsmoment");
			ffestigkeitslehre4.addAntwortmoeglichkeiten("Widerstandsmoment");
			ffestigkeitslehre4.addLoesung("Flächenträgheitsmoment");
			ffestigkeitslehre4.setBenutzer(lena);

			ffestigkeitslehre5.setText("Wie kann man sich den Verlauf von Kräften und Momenten in einem Bauteil modellhaft vorstellen?");
			ffestigkeitslehre5.addAntwortmoeglichkeiten("Momentensee");
			ffestigkeitslehre5.addAntwortmoeglichkeiten("Kraftstrom");
			ffestigkeitslehre5.addAntwortmoeglichkeiten("Kraftfluss");
			ffestigkeitslehre5.addAntwortmoeglichkeiten("Kraftbach");
			ffestigkeitslehre5.addLoesung("Kraftfluss");
			ffestigkeitslehre5.setBenutzer(lena);

			ffestigkeitslehre6.setText("Wie kann man die Auswirkung von Kerben bei dynamischer Beanspruchung verringern?");
			ffestigkeitslehre6.addAntwortmoeglichkeiten("Entlastungskerben, Oberflächenverfestigung und Entlastungsrisse");
			ffestigkeitslehre6.addAntwortmoeglichkeiten("Oberflächenverfestigung und Entlastungsrisse");
			ffestigkeitslehre6.addAntwortmoeglichkeiten("Entlastungskerben und Entlastungsrisse");
			ffestigkeitslehre6.addAntwortmoeglichkeiten("Entlastungskerben und Oberflächenverfestigung");
			ffestigkeitslehre6.addLoesung("Entlastungskerben und Oberflächenverfestigung");
			ffestigkeitslehre6.setBenutzer(lena);

			ffestigkeitslehre7.setText("Welche Grenze begrenzt den elastischen Bereich einer Probe?");
			ffestigkeitslehre7.addAntwortmoeglichkeiten("Zugfestigkeit");
			ffestigkeitslehre7.addAntwortmoeglichkeiten("0,2% Dehngrenze");
			ffestigkeitslehre7.addAntwortmoeglichkeiten("Streckgrenze");
			ffestigkeitslehre7.addAntwortmoeglichkeiten("Schubfestigkeit");
			ffestigkeitslehre7.addLoesung("Streckgrenze");
			ffestigkeitslehre7.setBenutzer(lena);

			ffestigkeitslehre8.setText("Bei welchem Lastfall ist die Annahme einer homogenen Spannungsverteilung nicht zulässig?");
			ffestigkeitslehre8.addAntwortmoeglichkeiten("Druck");
			ffestigkeitslehre8.addAntwortmoeglichkeiten("Biegung");
			ffestigkeitslehre8.addAntwortmoeglichkeiten("Zug");
			ffestigkeitslehre8.addAntwortmoeglichkeiten("Normalbelastung");
			ffestigkeitslehre8.addLoesung("Biegung");
			ffestigkeitslehre8.setBenutzer(lena);

			ffestigkeitslehre9.setText("Welche Festigkeitshypothese eignet sich für spröde Werkstoffe?");
			ffestigkeitslehre9.addAntwortmoeglichkeiten("Schubspannungshypothese");
			ffestigkeitslehre9.addAntwortmoeglichkeiten("Torsionsspannungshypothese");
			ffestigkeitslehre9.addAntwortmoeglichkeiten("Gestaltänderungsenergiehypothese");
			ffestigkeitslehre9.addAntwortmoeglichkeiten("Normalspannungshypothese");
			ffestigkeitslehre9.addLoesung("Normalspannungshypothese");
			ffestigkeitslehre9.setBenutzer(lena);

			ffestigkeitslehre10.setText("Warum verdreht eine Reinigungskraft einen Lappen, um ihn zu trocknen?");
			ffestigkeitslehre10.addAntwortmoeglichkeiten("Er/Sie weiß nicht, dass Drücken besser wäre.");
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

			fphilosophie3.setText("Welches Jahrhundert gilt als 'das Jahrhundert der Auflärung'?");
			fphilosophie3.addAntwortmoeglichkeiten("17. Jahrhundert");
			fphilosophie3.addAntwortmoeglichkeiten("18. Jahrhundert");
			fphilosophie3.addAntwortmoeglichkeiten("19. Jahrhundert");
			fphilosophie3.addAntwortmoeglichkeiten("20. Jahrhundert");
			fphilosophie3.addLoesung("18. Jahrhundert");
			fphilosophie3.setBenutzer(lena);

			fphilosophie4.setText("Wozu ist der Mensch nach Satre verurteilt?");
			fphilosophie4.addAntwortmoeglichkeiten("Der Mensch ist verurteilt, frei zu sein. ");
			fphilosophie4.addAntwortmoeglichkeiten("Der Mensch ist verurteilt, in Ketten zu liegen.");
			fphilosophie4.addAntwortmoeglichkeiten("Der Mensch ist verurteilt, sich in die Zwänge der bestehenden Welt zu fügen.");
			fphilosophie4.addAntwortmoeglichkeiten("Der Mensch ist verurteilt, sich seinem Geist zu fügen.");
			fphilosophie4.addLoesung("Der Mensch ist verurteilt, frei zu sein. ");
			fphilosophie4.setBenutzer(lena);

			fphilosophie5.setText("Was bedeutet eigentlich das Wort Philosophie?");
			fphilosophie5.addAntwortmoeglichkeiten("Liebe zur Kunst");
			fphilosophie5.addAntwortmoeglichkeiten("Liebe zur Weisheit");
			fphilosophie5.addAntwortmoeglichkeiten("Liebe zum Leben");
			fphilosophie5.addAntwortmoeglichkeiten("Liebe zu den Frauen");
			fphilosophie5.addLoesung("Liebe zur Weisheit");
			fphilosophie5.setBenutzer(lena);

			fphilosophie6.setText("Ein Satz, dessen Wahrheit nur auf der Bedeutung der in ihm verwendeten Wörter beruht, heißt");
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

			fphilosophie10.setText("Welcher Philosoph illustrierte seine «Ideenlehre» mit dem Höhlengleichnis?");
			fphilosophie10.addAntwortmoeglichkeiten("Aristoteles");
			fphilosophie10.addAntwortmoeglichkeiten("Epikur");
			fphilosophie10.addAntwortmoeglichkeiten("Platon");
			fphilosophie10.addAntwortmoeglichkeiten("Epiktet");
			fphilosophie10.addLoesung("Platon");
			fphilosophie10.setBenutzer(lena);

			// informatik
			finformatik1.setText("Wofür steht der Begriff XML ?");
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
			finformatik4.addAntwortmoeglichkeiten("eine Beschreibung von Sinnzusammenhängen");
			finformatik4.addAntwortmoeglichkeiten("Modell einer Domäne");
			finformatik4.addAntwortmoeglichkeiten("eine Technik des Web 1.0");
			finformatik4.addLoesung("eine Beschreibung von Sinnzusammenhängen");
			finformatik4.setBenutzer(lena);

			finformatik5.setText("Wie kann Wissensmanagement im Web 2.0 erfolgen?");
			finformatik5.addAntwortmoeglichkeiten("durch statische Webseiten");
			finformatik5.addAntwortmoeglichkeiten("durch Kollaboration (social Tagging)");
			finformatik5.addAntwortmoeglichkeiten("durch Blogs als Wissensspeicher");
			finformatik5.addAntwortmoeglichkeiten("durch Austausch beispielsweise innerhalb von Sozialen Netzwerken");
			finformatik5.addLoesung("durch Austausch beispielsweise innerhalb von Sozialen Netzwerken");
			finformatik5.setBenutzer(lena);

			finformatik6.setText("Sei F=P(f(x)). Welche der folgenden Mengen ist das Herbrand-Universum von F?");
			finformatik6.addAntwortmoeglichkeiten("{}");
			finformatik6.addAntwortmoeglichkeiten("{f(x)}");
			finformatik6.addAntwortmoeglichkeiten("{a}");
			finformatik6.addAntwortmoeglichkeiten("{a,f(a),f(f(a)),…}");
			finformatik6.addLoesung("{a,f(a),f(f(a)),…}");
			finformatik6.setBenutzer(lena);

			finformatik7.setText("Welche der folgenden Aussagen ist nicht korrekt?");
			finformatik7.addAntwortmoeglichkeiten("Jeder Körper ist ein Ring.");
			finformatik7.addAntwortmoeglichkeiten("Jede Gruppe ist ein Ring.");
			finformatik7.addAntwortmoeglichkeiten("Jede Gruppe ist ein Monoid.");
			finformatik7.addAntwortmoeglichkeiten("Jedes Monoid ist eine Halbgruppe.");
			finformatik7.addLoesung("Jede Gruppe ist ein Ring.");
			finformatik7.setBenutzer(lena);

			finformatik8.setText("Welches x ist eine Lösungen der Gleichung 7x kongruent 1mod20?");
			finformatik8.addAntwortmoeglichkeiten("x=20");
			finformatik8.addAntwortmoeglichkeiten("x=2");
			finformatik8.addAntwortmoeglichkeiten("x=7");
			finformatik8.addAntwortmoeglichkeiten("x=3");
			finformatik8.addLoesung("x=3");
			finformatik8.setBenutzer(lena);

			finformatik9.setText("Was ist die Laufzeitkomplexität von Mergesort im Average-Case?");
			finformatik9.addAntwortmoeglichkeiten("O(n)");
			finformatik9.addAntwortmoeglichkeiten("O(n²)");
			finformatik9.addAntwortmoeglichkeiten("O(n*log(n))");
			finformatik9.addAntwortmoeglichkeiten("O(log(n))");
			finformatik9.addLoesung("O(n*log(n))");
			finformatik9.setBenutzer(lena);

			finformatik10.setText("Wie groß prognostizierte Thomas Watson (IBM) den weltweiten Bedarf an Computern?");
			finformatik10.addAntwortmoeglichkeiten("5");
			finformatik10.addAntwortmoeglichkeiten("10");
			finformatik10.addAntwortmoeglichkeiten("15");
			finformatik10.addAntwortmoeglichkeiten("20");
			finformatik10.addLoesung("5");
			finformatik10.setBenutzer(lena);

			// wiwi
			fvwl1.setText("Zeiten hoher Arbeitslosigkeit");
			fvwl1.addAntwortmoeglichkeiten("haben keinerlei Auswirkungen auf die Kurve der Produktionsmöglichkeiten");
			fvwl1.addAntwortmoeglichkeiten("führen zu Punkten auf der Kurve der Produktionsmöglichkeiten");
			fvwl1.addAntwortmoeglichkeiten("führen zu Punkten innerhalb der Kurve der Produktionsmöglichkeiten");
			fvwl1.addAntwortmoeglichkeiten("führen zu Punkten ausserhalb der Kurve der Produktionsmöglichkeiten");
			fvwl1.addLoesung("führen zu Punkten innerhalb der Kurve der Produktionsmöglichkeiten");
			fvwl1.setBenutzer(lena);

			fvwl2.setText("Welche Konsumenten handeln rational?");
			fvwl2.addAntwortmoeglichkeiten("Konsumenten, die Kosten und Nutzen jeder zu treffenden Wahl abwägen");
			fvwl2.addAntwortmoeglichkeiten("Konsumenten, die keine Billiglohn-Jobs annehmen");
			fvwl2.addAntwortmoeglichkeiten("Konsumenten, die einen Teil ihres Einkommens sparen");
			fvwl2.addAntwortmoeglichkeiten("Konsumenten, die immer das billigste Produkt kaufen");
			fvwl2.addLoesung("Konsumenten, die Kosten und Nutzen jeder zu treffenden Wahl abwägen");
			fvwl2.setBenutzer(lena);

			fvwl3.setText("Die Zuteilung knapper Fussballmatch-Tickets durch Losentscheid wird aus folgendem Grund durchgeführt");
			fvwl3.addAntwortmoeglichkeiten("Verkauf an den Meistbietenden");
			fvwl3.addAntwortmoeglichkeiten("Rationierung");
			fvwl3.addAntwortmoeglichkeiten("Gewinnmotiv");
			fvwl3.addAntwortmoeglichkeiten("aus keinem dieser Gründe");
			fvwl3.addLoesung("Gewinnmotiv");
			fvwl3.setBenutzer(lena);

			fvwl4.setText("Welches ist die wahrscheinlichste Ursache einer Preiserhöhung für frisches Gemüse?");
			fvwl4.addAntwortmoeglichkeiten("Preissenkung für Dünger, der in der Gemüseproduktion eingesetzt wird");
			fvwl4.addAntwortmoeglichkeiten("Ueberschwemmungen, welche die Bauern bei der Gemüseernte überraschen");
			fvwl4.addAntwortmoeglichkeiten("Preissenkung eines Substitutionsgutes");
			fvwl4.addAntwortmoeglichkeiten("Preiserhöhung eines Komplementärgutes");
			fvwl4.addLoesung("Ueberschwemmungen, welche die Bauern bei der Gemüseernte überraschen");
			fvwl4.setBenutzer(lena);

			fvwl5.setText("Angenommen, die Kreuzpreiselastizität der Nachfrage in bezug auf zwei Produkte sei negativ. Wir wissen, dass");
			fvwl5.addAntwortmoeglichkeiten("die beiden Produkte normale Güter sind");
			fvwl5.addAntwortmoeglichkeiten("die beiden Produkte Substitutionsgüter sind");
			fvwl5.addAntwortmoeglichkeiten("die beiden Produkte inferiore Güter sind");
			fvwl5.addAntwortmoeglichkeiten("die beiden Produkte Komplementärgüter sind");
			fvwl5.addLoesung("die beiden Produkte Komplementärgüter sind");
			fvwl5.setBenutzer(lena);

			fvwl6.setText("Eine Unternehmung stellt Hemden und Jacken her. Welche Opportunitätskosten verursacht die Produktion einer Jacke?");
			fvwl6.addAntwortmoeglichkeiten("Kosten der Produktionsfaktoren, die zur Herstellung einer Jacke erforderlich sind");
			fvwl6.addAntwortmoeglichkeiten("Anzahl der Hemden, die mit den für die Herstellung einer Jacke verwendeten Produktionsfaktoren hätten angefertigt werden können");
			fvwl6.addAntwortmoeglichkeiten("Gesamtkosten für die Herstellung einer Jacke");
			fvwl6.addAntwortmoeglichkeiten("Marktpreis einer Jacke");
			fvwl6.addLoesung("Anzahl der Hemden, die mit den für die Herstellung einer Jacke verwendeten Produktionsfaktoren hätten angefertigt werden können");
			fvwl6.setBenutzer(lena);

			fvwl7.setText("Falls in einer Unternehmung die kurzfristige Durchschnittskostenkurve steigt,");
			fvwl7.addAntwortmoeglichkeiten("ist bei dieser Menge die Grenzkostenkurve über der kurzfristigen Durchschnittskostenkurve");
			fvwl7.addAntwortmoeglichkeiten("fällt die Grenzkostenkurve");
			fvwl7.addAntwortmoeglichkeiten("hat die Unternehmung die Kontrolle über ihre Kosten verloren");
			fvwl7.addAntwortmoeglichkeiten("ist bei dieser Menge die Grenzkostenkurve unter der kurzfristigen Durchschnittskostenkurve");
			fvwl7.addLoesung("ist bei dieser Menge die Grenzkostenkurve über der kurzfristigen Durchschnittskostenkurve");
			fvwl7.setBenutzer(lena);

			fvwl8.setText("Unternehmen stehen abnehmenden Skalenerträgen gegenüber, wenn");
			fvwl8.addAntwortmoeglichkeiten("die Kosten je Stück mit zunehmender Produktion steigen");
			fvwl8.addAntwortmoeglichkeiten("die Mitarbeiter mit steigender Produktion eine höhere Gewinnbeteiligung verlangen");
			fvwl8.addAntwortmoeglichkeiten("die fixen Kosten steigen");
			fvwl8.addAntwortmoeglichkeiten("wenn die Unternehmung mit steigender Produktion höhere Preise für Produktionsfaktoren zahlen müssen");
			fvwl8.addLoesung("die Kosten je Stück mit zunehmender Produktion steigen");
			fvwl8.setBenutzer(lena);

			fvwl9.setText("Welche Aussage ist für die vollständige Konkurrenz charakteristisch?");
			fvwl9.addAntwortmoeglichkeiten("Es gibt auf lange Sicht Schranken für den Ein- und Austritt von Anbietern");
			fvwl9.addAntwortmoeglichkeiten("Es gibt eine Produktdifferenzierung (d.h. die Anbieter bieten unterschiedliche Produkte an)");
			fvwl9.addAntwortmoeglichkeiten("Die Anbieter verfügen in bezug auf den Markt über mehr Informationen als die Nachfrager");
			fvwl9.addAntwortmoeglichkeiten("Käufer und Verkäufer sind Preisnehmer");
			fvwl9.addLoesung("Käufer und Verkäufer sind Preisnehmer");
			fvwl9.setBenutzer(lena);

			fvwl10.setText("Die Einkommenselastizität der Nachfrage nach frischem Brot wird auf + 0.3 geschätzt. Falls die realen Einkommen der Konsumenten ceteris paribus um 15 % steigen, wird die nachgefragte Menge frisches Brot um folgenden Prozentsatz steigen:");
			fvwl10.addAntwortmoeglichkeiten("4.5 %");
			fvwl10.addAntwortmoeglichkeiten("3%");
			fvwl10.addAntwortmoeglichkeiten("4%");
			fvwl10.addAntwortmoeglichkeiten("15%");
			fvwl10.addLoesung("4.5 %");
			fvwl10.setBenutzer(lena);
			
			
/// MC Fragen
			
			fbwl1.setText("Bei welchen Lösungsmöglichkeiten von asymmetrischer Information entstehen vor allem beim Agenten Agency-Kosten ?");
			fbwl1.addAntwortmoeglichkeiten("Signaling");
			fbwl1.addAntwortmoeglichkeiten("Leistungsabhängige Entlohnung");
			fbwl1.addAntwortmoeglichkeiten("Monitoring");
			fbwl1.addAntwortmoeglichkeiten("Screening");
			fbwl1.addLoesung("Signaling");
			fbwl1.addLoesung("Screening");
			fbwl1.setBenutzer(lena);

			fbwl2.setText("Welche Art der Tenten erzielt ein Unternehmen, wenn es mit Hilfe siener Ressourcen Innovationen hervorbringt und sich die daraus entstandenen Innovationsgewinne aneignet?");
			fbwl2.addAntwortmoeglichkeiten("Ricardo-Renten");
			fbwl2.addAntwortmoeglichkeiten("Quasirenten");
			fbwl2.addAntwortmoeglichkeiten("Schumpeter-Renten");
			fbwl2.addAntwortmoeglichkeiten("Monopolrenten");
			fbwl2.addLoesung("Schumpeter-Renten");
			fbwl2.setBenutzer(lena);

			fbwl3.setText("Ein schwäbisches Metallbauunternehmen beschließt gewisse Einzelteile bei einem bestimmten Lieferanten einzukaufen, da diese qualitativ hochwertiger und kostengünstiger zugekauft werden können. Ordenen Sie die richtigen beschaffungspolitischen Instrumente zu.");
			fbwl3.addAntwortmoeglichkeiten("Beschaffungsprogrammpolitik");
			fbwl3.addAntwortmoeglichkeiten("Beschaffungskonditionenpolitik");
			fbwl3.addAntwortmoeglichkeiten("Kommunikationspolitik");
			fbwl3.addAntwortmoeglichkeiten("Bezugspolitik");
			fbwl3.addLoesung("Beschaffungsprogrammpolitik");
			fbwl3.addLoesung("Bezugspolitik");
			fbwl3.setBenutzer(lena);

			fbwl4.setText("Unter welche Güterarten werden Patente und Lizenzen eingeordnet?");
			fbwl4.addAntwortmoeglichkeiten("Wirtschaftsgüter");
			fbwl4.addAntwortmoeglichkeiten("Immaterielle Güter");
			fbwl4.addAntwortmoeglichkeiten("Realgüter");
			fbwl4.addAntwortmoeglichkeiten("Reine Güterformen");
			fbwl4.addLoesung("Wirtschaftsgüter");
			fbwl4.addLoesung("Immaterielle Güter");
			fbwl4.addLoesung("Realgüter");
			fbwl4.addLoesung("Reine Güterformen");
			fbwl4.setBenutzer(lena);

			fbwl5.setText("Welche Zwecke efüllt das Inventar?");
			fbwl5.addAntwortmoeglichkeiten("Das Inventar dient dem Abgleich von Buch- und Ist-Beständen.");
			fbwl5.addAntwortmoeglichkeiten("Das Inventar kontrolliert die ordnungsgemäße Verbuchung aller Geschäftsvorfälle des Jahres");
			fbwl5.addAntwortmoeglichkeiten("Das Inventar dient der Kontrolle des Unternehmens durch das Finanzamt");
			fbwl5.addAntwortmoeglichkeiten("Das Inventar garantiert die Wahrheit der Werte in der Bilanz");
			fbwl5.addLoesung("Das Inventar dient dem Abgleich von Buch- und Ist-Beständen.");
			fbwl5.addLoesung("Das Inventar garantiert die Wahrheit der Werte in der Bilanz");
			fbwl5.setBenutzer(lena);

			fbwl6.setText("Welche Geschäftsvorfälle sind erfolgswirksam?");
			fbwl6.addAntwortmoeglichkeiten("Bildung einer Rückstellung für unterlassene Aufwendungen für Instandhaltung.");
			fbwl6.addAntwortmoeglichkeiten("Auszahlung eines Gehaltsvorschusses an einen Mitarbeiter.");
			fbwl6.addAntwortmoeglichkeiten("Private Warenentnahme des Unternehmers über den Einkaufspreis der Waren:");
			fbwl6.addAntwortmoeglichkeiten("Private Bareinlage des Unternehmers zur Erhöhung des Eigenkapitals des Unternehmens.");
			fbwl6.addLoesung("Bildung einer Rückstellung für unterlassene Aufwendungen für Instandhaltung.");
			fbwl6.setBenutzer(lena);

			fbwl7.setText("Welche der folgenden Aussagen ist richtig ?");
			fbwl7.addAntwortmoeglichkeiten("Der Aufwand ist der gesamte Wertezuwachs. ");
			fbwl7.addAntwortmoeglichkeiten("Die indirekte Abschreibung erfolgt als Sollbuchung auf dem passivem Verrechnungskonto.");
			fbwl7.addAntwortmoeglichkeiten("Abschlussbuchungen des EK-Kontos erfolgen direkt in das GuV-Konto. ");
			fbwl7.addAntwortmoeglichkeiten("Warenrücksendungen werden im gemischten Warenkonto im Soll gebucht.");
			fbwl7.setBenutzer(lena);

			fbwl8.setText("Ein periodenfremder Aufwand entsteht, wenn…");
			fbwl8.addAntwortmoeglichkeiten("…das Unternehmen die vertraglich vereinbarte Miete für das vergangene Jahr erst in diesem Jahr zahlt.");
			fbwl8.addAntwortmoeglichkeiten("…der im letzten Jahr geschätzte Forderungsverlust größer als der tatsächliche Forderungsverlust ist. ");
			fbwl8.addAntwortmoeglichkeiten("…die Pauschalwertberichtigungen auf Forderungen im letzten Jahr zu niedrig gebildet wurden.");
			fbwl8.addAntwortmoeglichkeiten("…das Unternehmen mehr Steuern nachzahlen muss als im letzten Jahr angenommen.");
			fbwl8.addLoesung("…die Pauschalwertberichtigungen auf Forderungen im letzten Jahr zu niedrig gebildet wurden.");
			fbwl8.addLoesung("…das Unternehmen mehr Steuern nachzahlen muss als im letzten Jahr angenommen.");
			fbwl8.setBenutzer(lena);

			fbwl9.setText("Was sind Grunde für Abschreibungen?");
			fbwl9.addAntwortmoeglichkeiten("Wir schicken eine Mahnung an einen Kunden, weil er bisher seine Rechnung nicht gezahlt hat.");
			fbwl9.addAntwortmoeglichkeiten("Die Fristen zur Nutzung eines Markennamen für die eigenen Produkte laufen aus.");
			fbwl9.addAntwortmoeglichkeiten("Der Buchwert liegt unter den Wiederbeschaffungskosten eines Vermögensgutes.");
			fbwl9.addAntwortmoeglichkeiten("Der technische Verschleiß einer Maschine ist in diesem Jahr höher als Angenommen.");
			fbwl9.addLoesung("Die Fristen zur Nutzung eines Markennamen für die eigenen Produkte laufen aus.");
			fbwl9.setBenutzer(lena);

			fbwl10.setText(" Bei welchen der folgenden Geschäftsvorfälle ist die Umsatzsteuer (in Form der Vorsteuer bzw. Mehrwertsteuer, ggf. auch als Korrektur der Umsatzsteuer) zu berücksichtigen? ");
			fbwl10.addAntwortmoeglichkeiten("Bildung einer Rückstellung für unterlassene Aufwendungen für Instandhaltung, die im folgenden Geschäftsjahr innerhalb von 3 Monaten nachgeholt werden.");
			fbwl10.addAntwortmoeglichkeiten("Pauschale Abschreibung des Forderungsbestands um 5%.");
			fbwl10.addAntwortmoeglichkeiten("Eine dubiose Forderung wird aufgrund der Einstellung des Insolvenzverfahrens endgültig uneinbringlich und damit endgültig abgeschrieben.");
			fbwl10.addAntwortmoeglichkeiten("Private Warenentnahme des Unternehmers zu Einkaufspreisen.");
			fbwl10.addLoesung("Eine dubiose Forderung wird aufgrund der Einstellung des Insolvenzverfahrens endgültig uneinbringlich und damit endgültig abgeschrieben.");
			fbwl10.addLoesung("Private Warenentnahme des Unternehmers zu Einkaufspreisen.");
			fbwl10.setBenutzer(lena);
			
			// Einträge aktualisieren

			db.eintragAktualisieren(thema.getClass(), thema);
			db.eintragAktualisieren(themalena1.getClass(), themalena1);
			db.eintragAktualisieren(themabwl1.getClass(), themabwl1);
			db.eintragAktualisieren(themabwl2.getClass(), themabwl2);
			db.eintragAktualisieren(themabwl3.getClass(), themabwl3);
			db.eintragAktualisieren(kommentar.getClass(), kommentar);
			db.eintragAktualisieren(lena.getClass(), lena);
			db.eintragAktualisieren(hannes.getClass(), hannes);
			db.eintragAktualisieren(lena.getClass(), lena);
			db.eintragAktualisieren(richard.getClass(), richard);
			db.eintragAktualisieren(stefanie.getClass(), stefanie);
			db.eintragAktualisieren(paula.getClass(), paula);
			db.eintragAktualisieren(hans.getClass(), hans);
			db.eintragAktualisieren(philipp.getClass(), philipp);
			db.eintragAktualisieren(nicole.getClass(), nicole);
			db.eintragAktualisieren(mbis.getClass(), mbis);
			db.eintragAktualisieren(biks.getClass(), biks);
			db.eintragAktualisieren(wi.getClass(), wi);
			db.eintragAktualisieren(frage.getClass(), frage);
			
			db.eintragAktualisieren(finformatik1.getClass(), finformatik1);
			db.eintragAktualisieren(finformatik2.getClass(), finformatik2);
			db.eintragAktualisieren(finformatik3.getClass(), finformatik3);
			db.eintragAktualisieren(finformatik4.getClass(), finformatik4);
			db.eintragAktualisieren(finformatik5.getClass(), finformatik5);
			db.eintragAktualisieren(finformatik6.getClass(), finformatik6);
			db.eintragAktualisieren(finformatik7.getClass(), finformatik7);
			db.eintragAktualisieren(finformatik8.getClass(), finformatik8);
			db.eintragAktualisieren(finformatik9.getClass(), finformatik9);
			db.eintragAktualisieren(finformatik10.getClass(), finformatik10);	
			db.eintragAktualisieren(fvwl1.getClass(), fvwl1);
			db.eintragAktualisieren(fvwl2.getClass(), fvwl2);
			db.eintragAktualisieren(fvwl3.getClass(), fvwl3);
			db.eintragAktualisieren(fvwl4.getClass(), fvwl4);
			db.eintragAktualisieren(fvwl5.getClass(), fvwl5);
			db.eintragAktualisieren(fvwl6.getClass(), fvwl6);
			db.eintragAktualisieren(fvwl7.getClass(), fvwl7);
			db.eintragAktualisieren(fvwl8.getClass(), fvwl8);
			db.eintragAktualisieren(fvwl9.getClass(), fvwl9);
			db.eintragAktualisieren(fvwl10.getClass(), fvwl10);		
			db.eintragAktualisieren(fphilosophie1.getClass(), fphilosophie1);
			db.eintragAktualisieren(fphilosophie2.getClass(), fphilosophie2);
			db.eintragAktualisieren(fphilosophie3.getClass(), fphilosophie3);
			db.eintragAktualisieren(fphilosophie4.getClass(), fphilosophie4);
			db.eintragAktualisieren(fphilosophie5.getClass(), fphilosophie5);
			db.eintragAktualisieren(fphilosophie6.getClass(), fphilosophie6);
			db.eintragAktualisieren(fphilosophie7.getClass(), fphilosophie7);
			db.eintragAktualisieren(fphilosophie8.getClass(), fphilosophie8);
			db.eintragAktualisieren(fphilosophie9.getClass(), fphilosophie9);
			db.eintragAktualisieren(fphilosophie10.getClass(), fphilosophie10);
			db.eintragAktualisieren(fagrar1.getClass(), fagrar1);
			db.eintragAktualisieren(fagrar2.getClass(), fagrar2);
			db.eintragAktualisieren(fagrar3.getClass(), fagrar3);
			db.eintragAktualisieren(fagrar4.getClass(), fagrar4);
			db.eintragAktualisieren(fagrar5.getClass(), fagrar5);
			db.eintragAktualisieren(fagrar6.getClass(), fagrar6);
			db.eintragAktualisieren(fagrar7.getClass(), fagrar7);
			db.eintragAktualisieren(fagrar8.getClass(), fagrar8);
			db.eintragAktualisieren(fagrar9.getClass(), fagrar9);
			db.eintragAktualisieren(fagrar10.getClass(), fagrar10);
			db.eintragAktualisieren(fmedizin1.getClass(), fmedizin1);
			db.eintragAktualisieren(fmedizin2.getClass(), fmedizin2);
			db.eintragAktualisieren(fmedizin3.getClass(), fmedizin3);
			db.eintragAktualisieren(fmedizin4.getClass(), fmedizin4);
			db.eintragAktualisieren(fmedizin5.getClass(), fmedizin5);
			db.eintragAktualisieren(fmedizin6.getClass(), fmedizin6);
			db.eintragAktualisieren(fmedizin7.getClass(), fmedizin7);
			db.eintragAktualisieren(fmedizin8.getClass(), fmedizin8);
			db.eintragAktualisieren(fmedizin9.getClass(), fmedizin9);
			db.eintragAktualisieren(fmedizin10.getClass(), fmedizin10);
			db.eintragAktualisieren(ffestigkeitslehre1.getClass(), ffestigkeitslehre1);
			db.eintragAktualisieren(ffestigkeitslehre2.getClass(), ffestigkeitslehre2);
			db.eintragAktualisieren(ffestigkeitslehre3.getClass(), ffestigkeitslehre3);
			db.eintragAktualisieren(ffestigkeitslehre4.getClass(), ffestigkeitslehre4);
			db.eintragAktualisieren(ffestigkeitslehre5.getClass(), ffestigkeitslehre5);
			db.eintragAktualisieren(ffestigkeitslehre6.getClass(), ffestigkeitslehre6);
			db.eintragAktualisieren(ffestigkeitslehre7.getClass(), ffestigkeitslehre7);
			db.eintragAktualisieren(ffestigkeitslehre8.getClass(), ffestigkeitslehre8);
			db.eintragAktualisieren(ffestigkeitslehre9.getClass(), ffestigkeitslehre9);
			db.eintragAktualisieren(ffestigkeitslehre10.getClass(), ffestigkeitslehre10);
			db.eintragAktualisieren(fbwl1.getClass(), fbwl1);
			db.eintragAktualisieren(fbwl2.getClass(), fbwl2);
			db.eintragAktualisieren(fbwl3.getClass(), fbwl3);
			db.eintragAktualisieren(fbwl4.getClass(), fbwl4);
			db.eintragAktualisieren(fbwl5.getClass(), fbwl5);
			db.eintragAktualisieren(fbwl6.getClass(), fbwl6);
			db.eintragAktualisieren(fbwl7.getClass(), fbwl7);
			db.eintragAktualisieren(fbwl8.getClass(), fbwl8);
			db.eintragAktualisieren(fbwl9.getClass(), fbwl9);
			db.eintragAktualisieren(fbwl10.getClass(), fbwl10);
			db.eintragAktualisieren(medium.getClass(), medium);
			db.eintragAktualisieren(bossfight.getClass(), bossfight);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
