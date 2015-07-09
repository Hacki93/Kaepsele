package controller;


import java.util.Date;
import java.util.HashSet;

import kommunikation.Nachricht;

import org.hibernate.cfg.Configuration;

import learning.Account;
import learning.Benutzer;
import learning.Fachrichtung;
import learning.Frage;
import learning.Gruppe;
import learning.Inhalt;
import learning.Kommentar;
import learning.Mediathek;
import learning.Medium;
import learning.Pinnwand;
import learning.Quest;
import learning.Teamcombat;
import learning.Thema;
import datenhaltung.Datenbank;

public class TestKlasse {

	// Klasse zum Testen von Codebausteinen
	public static void main(String[] args) {
		dbSchreiben();
//		lena();
		System.exit(0);

		}
	
	public static void lena(){
		Gruppe gruppe1 = new Gruppe();
		gruppe1.setName("Gruppe 1");
		Gruppe gruppe2 = new Gruppe(); 
		gruppe2.setName("Gruppe2");
		Benutzer lena = new Benutzer("lena", "1234", "Lena Maier", "lenamai.er@web.de"); 
		Benutzer hannes = new Benutzer("hannes", "1234", "Hannes Fischer", "michael_stefan@hotmail.de");
		Benutzer chris = new Benutzer(); 
		Benutzer kevin = new Benutzer(); 
		
		lena.setEmailAdresse("lenamai.er@web.de");
		chris.setEmailAdresse("lenamai.er@web.de");
		kevin.setEmailAdresse("lenamai.er@web.de");
		
		HashSet<String> a = new HashSet<String>();
		HashSet<String> l = new HashSet<String>();
		String frage = "Frage";
		String titel = "Titel";
		String titel2 = "Anderer titel";
		gruppe1.mitgliedHinzufuegen(lena);
		gruppe1.mitgliedHinzufuegen(hannes);
		gruppe2.mitgliedHinzufuegen(kevin);
		gruppe2.mitgliedHinzufuegen(chris);
		gruppe1.frageErstellen(titel, frage, a, l);
		gruppe1.frageErstellen(titel, frage, a, l);
		gruppe1.frageErstellen(titel, frage, a, l);
		gruppe1.frageErstellen(titel, frage, a, l);
		gruppe1.frageErstellen(titel, frage, a, l);
		gruppe1.frageErstellen(titel, frage, a, l);
		gruppe1.frageErstellen(titel, frage, a, l);
		gruppe1.frageErstellen(titel, frage, a, l);
		gruppe1.frageErstellen(titel, frage, a, l);
		gruppe1.frageErstellen(titel, frage, a, l);
		
		gruppe2.frageErstellen("andererTitel", frage, a, l);
		gruppe2.frageErstellen(titel2, frage, a, l);
		gruppe2.frageErstellen(titel2, frage, a, l);
		gruppe2.frageErstellen(titel2, frage, a, l);
		gruppe2.frageErstellen(titel2, frage, a, l);
		gruppe2.frageErstellen(titel2, frage, a, l);
		gruppe2.frageErstellen(titel2, frage, a, l);
		gruppe2.frageErstellen(titel2, frage, a, l);
		gruppe2.frageErstellen(titel2, frage, a, l);
		gruppe2.frageErstellen(titel2, frage, a, l);
		System.out.println("Frage hinzugef�gt");		
		gruppe1.teamcombatAntreten(gruppe2);
		
//		for (Nachricht n:hannes.getNachrichten()){
//			Teamcombat t = (Teamcombat) n.getAnhang();
//			t.
//		}
		
		Quest quest = gruppe2.teamcombatBearbeiten(0);
		Frage frage2 = quest.getNaechsteFrage();
		System.out.println(frage2.titel);
		HashSet<String> antworten = new HashSet<String>();
		antworten.add("Hallo");
		frage2.addAntworten(antworten);
		Quest quest1 = gruppe1.teamcombatBearbeiten(0);
		Frage frage1 = quest1.getNaechsteFrage(); 
		System.out.println(frage1.titel);
	}

		public static void dbSchreiben(){
			Benutzer hannes = new Benutzer();
			hannes.setAdresse("B�hlenstr. 100, 71088 Holzgerlingen");
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
			
			Medium med = new Medium();
			med.setName("Lebenslauf");
			med.setPfad("/resources/media/lebenslauf.pdf");
			med.setTyp("PDF");
			
			Datenbank db = new Datenbank();
			db.eintragHinzufuegen(hannes.getClass(), hannes);
			db.eintragHinzufuegen(lena.getClass(), lena);
			db.eintragHinzufuegen(wi.getClass(), wi);
			db.eintragHinzufuegen(mbis.getClass(), mbis);
			db.eintragHinzufuegen(kommentar.getClass(), kommentar);
			db.eintragHinzufuegen(thema.getClass(), thema);	
			db.eintragHinzufuegen(med.getClass(), med);
			
			lena.setRang(5);
			mbis.mitgliedHinzufuegen(lena);
			mbis.mitgliedHinzufuegen(hannes);
			mbis.getPinnwand().themaHinzuf�gen(thema);
			thema.kommentieren(kommentar);
			System.out.println(mbis.getMediathek().getId());
			mbis.getMediathek().mediumHinzuf�gen(med);
			mbis.setFachrichtung(wi);		
			
			db.eintragAktualisieren(lena.getClass(), lena);
			db.eintragAktualisieren(hannes.getClass(), hannes);
			db.eintragAktualisieren(thema.getClass(), thema);
			db.eintragAktualisieren(kommentar.getClass(), kommentar);
			db.eintragAktualisieren(mbis.getClass(), mbis);
			db.eintragAktualisieren(med.getClass(), med);
			}
}
