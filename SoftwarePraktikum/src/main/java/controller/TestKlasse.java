package controller;


import java.util.Date;

import org.hibernate.cfg.Configuration;

import learning.Account;
import learning.Benutzer;
import learning.Fachrichtung;
import learning.Gruppe;
import learning.Inhalt;
import learning.Kommentar;
import learning.Pinnwand;
import learning.Thema;
import datenhaltung.Datenbank;

public class TestKlasse {

	// Klasse zum Testen von Codebausteinen
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dbSchreiben();
		dbLesen();
		}
	
	public static void dbLesen(){
		
	}

		public static void dbSchreiben(){
			Benutzer hannes = new Benutzer();
			hannes.setAdresse("Bühlenstr. 100, 71088 Holzgerlingen");
			hannes.registrieren("hannes", "spiegelei");
			hannes.setRang(1000);
			hannes.setBeruf("Student");
			hannes.setEmailAdresse("mail@hannes-fischer.com");
			hannes.setName("Hannes Fischer");
			hannes.setStudiengang("Wirtschaftsinformatik B.Sc.");

			Benutzer lena = new Benutzer();
			lena.setAdresse("Schopfloch");
			lena.registrieren("lenchen", "12345678");
			lena.setRang(2);
			lena.setBeruf("Student");
			lena.setEmailAdresse("lenamaier@web.de");
			lena.setName("Lena Maier");		
			lena.setStudiengang("Wirtschaftsinformatik B.Sc.");
			
			Fachrichtung wi = new Fachrichtung();
			wi.setName("Wirtschaftsinformatik");
			wi.setFreigegeben(false);
			
			Gruppe mbis = new Gruppe();
			mbis.setName("Management betrieblicher Informationssysteme");
			mbis.setKlausurname("MBIS 1");
			
			Kommentar kommentar = new Kommentar();
			kommentar.setBewertung(0);
			kommentar.setInhalt("Kommentarinhalt");
			kommentar.setTitel("Kommentartitel");
			
			Thema thema = new Thema();
			thema.setAutor(hannes);
			thema.setBewertung(2);
			thema.setDatum(new Date());
			thema.setTitel("Thematitel");
			thema.setInhalt("Themainhalt");			
			thema.kommentieren(kommentar);
			
			Pinnwand pw = new Pinnwand();
			pw.themaHinzufügen(thema);
			mbis.setPinnwand(pw);
			
			mbis.setFachrichtung(wi);		
			mbis.mitgliedHinzufuegen(lena);
			mbis.mitgliedHinzufuegen(hannes);
			
			Datenbank db = new Datenbank();
			db.eintragHinzufuegen(hannes.getClass(), hannes);
			db.eintragHinzufuegen(lena.getClass(), lena);
			db.eintragHinzufuegen(wi.getClass(), wi);
			db.eintragHinzufuegen(mbis.getClass(), mbis);
			db.eintragHinzufuegen(kommentar.getClass(), kommentar);
			db.eintragHinzufuegen(thema.getClass(), thema);
			db.eintragHinzufuegen(pw.getClass(), pw);
			
			lena.setRang(5);
			db.eintragAktualisieren(lena.getClass(), lena);
		}
}
