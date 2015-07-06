package controller;

import org.hibernate.cfg.Configuration;

import learning.Benutzer;
import learning.Fachrichtung;
import learning.Gruppe;
import datenhaltung.DatenbankenVerwaltung;

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
			
			Gruppe mbis = new Gruppe();
			mbis.setName("MBIS");
			
			Fachrichtung fr = new Fachrichtung();
			fr.setName("SWT");
					
			Configuration configuration = new Configuration().configure();
       	    configuration.addAnnotatedClass(hannes.getClass());
       	    configuration.addAnnotatedClass(mbis.getClass());
       	    configuration.addAnnotatedClass(fr.getClass());
			DatenbankenVerwaltung dbv = new DatenbankenVerwaltung(configuration);
			
			
			lena.gruppeBeitreten(mbis);
			hannes.gruppeBeitreten(mbis);

			mbis.setFachrichtung(fr);
//			hannes.freundHinzufügen(lena);
			
			
			dbv.addDatenbank(hannes.getClass());
//			dbv.eintragHinzufuegen(hannes.getClass(), hannes);
//			dbv.eintragHinzufuegen(lena.getClass(), lena);
			dbv.eintragHinzufuegen(fr.getClass(), fr);
			dbv.eintragHinzufuegen(mbis.getClass(), mbis);
		}
}
