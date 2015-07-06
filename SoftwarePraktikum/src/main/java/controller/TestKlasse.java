package controller;

import java.util.Date;

import org.hibernate.cfg.Configuration;

import learning.Benutzer;
import learning.Fachrichtung;
import learning.Gruppe;
import learning.Inhalt;
import learning.Kommentar;
import learning.Thema;
import datenhaltung.Datenbank;

public class TestKlasse {

	// Klasse zum Testen von Codebausteinen
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		datenbankenTest();
		
		}

		public static void datenbankenTest(){
			Benutzer hannes = new Benutzer();
			hannes.setAdresse("Bühlenstr. 100, 71088 Holzgerlingen");
			hannes.setBenutzername("hannes");
			hannes.setRang(1000);
			hannes.setBeruf("Student");
			hannes.setEmailAdresse("mail@hannes-fischer.com");
			hannes.setName("Hannes Fischer");

			Benutzer lena = new Benutzer();
			lena.setAdresse("Schopfloch");
			lena.setBenutzername("lenchen");
			lena.setRang(2);
			lena.setBeruf("Student");
			lena.setEmailAdresse("lenamaier@web.de");
			lena.setName("Lena Maier");
			
			hannes.freundHinzufügen(lena);
			
			Gruppe mbis = new Gruppe();
			mbis.setName("MBIS");
			
			Fachrichtung fr = new Fachrichtung();
			fr.setName("SWT");
			
//			Thema thema = new Thema();
//			thema.setBewertung(2);
//			thema.setDatum(new Date());
//			thema.setTitel("Thematitel");
//			thema.setInhalt("Themainhalt");
			
//			Kommentar kommentar = new Kommentar();
//			kommentar.setBewertung(0);
//			kommentar.setInhalt("Kommentarinhalt");
//			kommentar.setTitel("Kommentartitel");
			
//			thema.kommentieren(kommentar);
			
			Configuration configuration = new Configuration().configure();
       	    configuration.addAnnotatedClass(hannes.getClass());
       	    configuration.addAnnotatedClass(mbis.getClass());
       	    configuration.addAnnotatedClass(fr.getClass());
//       	    configuration.addAnnotatedClass(kommentar.getClass());
//       	    configuration.addAnnotatedClass(thema.getClass());
       	    configuration.addAnnotatedClass(new Inhalt().getClass());
			Datenbank db = new Datenbank(configuration);
			
			db.tabelleHinzufuegen(hannes.getClass());
//			db.tabelleHinzufuegen(thema.getClass());
			
			db.eintragHinzufuegen(hannes.getClass(), hannes);
			db.eintragHinzufuegen(lena.getClass(), lena);
			
//			db.tabelleHinzufuegen(kommentar.getClass());
//			db.tabelleHinzufuegen(thema.getClass());
//			System.out.println("Kommentar: "+db.eintragHinzufuegen(kommentar.getClass(), kommentar));
//			System.out.println("Thema: "+db.eintragHinzufuegen(thema.getClass(), thema));
		}
}
