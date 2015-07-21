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
		System.err.println("Testlauf vollständig durchgeführt und abgeschlossen");
		System.exit(0);
		}
	
	public static void dbSchreiben(){
		try{

			Datenbank db = new Datenbank();
			
			//Objekte instanziieren
		
			Benutzer hannes 	= new Benutzer();
			Benutzer lena 		= new Benutzer();
			Gruppe mbis 		= new Gruppe();
			Gruppe biks			= new Gruppe();
			Thema thema 		= new Thema();
			Kommentar kommentar = new Kommentar();
			Fachrichtung wi		= new Fachrichtung();
			Frage frage			= new Frage();
			
			//Eintrag hinzufügen zur Datenbank
			
					
			db.eintragHinzufuegen(thema.getClass(), thema);
			db.eintragHinzufuegen(kommentar.getClass(), kommentar);
			db.eintragHinzufuegen(hannes.getClass(), hannes);
			db.eintragHinzufuegen(lena.getClass(), lena);
			db.eintragHinzufuegen(mbis.getClass(), mbis);
			db.eintragHinzufuegen(biks.getClass(), biks);
			db.eintragHinzufuegen(wi.getClass(), wi);
			db.eintragHinzufuegen(frage.getClass(), frage);
			
			//Objekte füllen und verbinden
			
			hannes.registrieren("hannes", "spiegelei");
			hannes.setEmailAdresse("mail@hannes-fischer.com");
			hannes.setName("Hannes Fischer");
			hannes.setAdresse("Bühlenstr. 100, 71088 Holzgerlingen");
			hannes.setRang(1000);
			hannes.setBeruf("Student");
			hannes.setStudiengang("Wirtschaftsinformatik B.Sc.");
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
			lena.setStudiengang("Wirtschaftsinformatik B.Sc.");
			lena.setGeburtsdatum("31/12/1993");
			lena.setProfilbildURL("/Bild.png");
			lena.erstelltAm = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			lena.freundHinzufuegen(hannes);

			wi.setName("Wirtschaftsinformatik");
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
			kommentar.setInhalt("Dankeschön lieber Hannes");
			kommentar.setTitel("Danke!");
			kommentar.setThema(thema);
			
			thema.setPinnwand(lena.pinnwand);
			thema.setBenutzer(hannes);
			thema.setBewertung(5);
			thema.setTitel("Happy Birthday");
			thema.setInhalt("Ich wünsch Dir alles Gute zum Geburtstag!");
			thema.kommentieren(kommentar);
            
            frage.setText("Wieviel Uhr ist es?");
            frage.addAntwortmoeglichkeiten("17:00");
            frage.addAntwortmoeglichkeiten("18:00");
            frage.addAntwortmoeglichkeiten("19:00");
            frage.addLoesung("17:00");
            frage.setBenutzer(lena);
            
            //Einträge aktualisieren

			db.eintragAktualisieren(thema.getClass(), thema);
			db.eintragAktualisieren(kommentar.getClass(), kommentar);	
			db.eintragAktualisieren(lena.getClass(), lena);
			db.eintragAktualisieren(hannes.getClass(), hannes);
			db.eintragAktualisieren(mbis.getClass(), mbis);
			db.eintragAktualisieren(biks.getClass(), biks);
			db.eintragAktualisieren(wi.getClass(), wi);
			db.eintragAktualisieren(frage.getClass(), frage);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
