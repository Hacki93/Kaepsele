package controller;


import java.util.ArrayList;
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
//		dbSchreiben();
		lena();
//		sortierTest();
//		zeitTest();
		System.exit(0);
		}
	
	public static void lena(){
		Gruppe gruppe1 = new Gruppe();
		gruppe1.setName("Gruppe 1");
		Gruppe gruppe2 = new Gruppe(); 
		gruppe2.setName("Gruppe2");
		Benutzer lena = new Benutzer("lena", "1234", "Lena Maier", "lenamai.er@web.de"); 
		Benutzer hannes = new Benutzer("hannes", "1234", "Hannes Fischer", "lenamai.er@web.de");
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
		System.out.println("Frage hinzugefügt");		
		gruppe1.teamcombatAntreten(gruppe2);
		
//		for (Nachricht n:hannes.getNachrichten()){
//			Teamcombat t = (Teamcombat) n.getAnhang();
//			t.
//		}
		Quest quest = new Quest();
		
		for (Nachricht n :lena.getAufgaben()){
			quest = (Quest)lena.aufgabeBearbeiten(n);
		}
		
		HashSet<String> antworten = new HashSet<String>();
		antworten.add("Du da");
		Frage frage1 = quest.getNaechsteFrage();
		frage1.addAntworten(antworten);
		System.out.println("Lena hat antworten hinzugefügt");
		
		for (Nachricht n :lena.getAufgaben()){
			quest = (Quest)lena.aufgabeBearbeiten(n);
			for  (Frage f:quest.fragen){
				for (String s:f.antworten){
					System.out.println(s);
				}
			}
		}
		
		Quest quest2 = new Quest(); 
		for (Nachricht n: hannes.getAufgaben()){
			quest2 = (Quest)hannes.aufgabeBearbeiten(n);
		}
		
		
		HashSet<String> antworten2 = new HashSet<String>();
		antworten2.add("Ich bins"); 
		Frage frage2 = quest2.getNaechsteFrage();
		frage2.addAntworten(antworten2);
		
		System.out.println("Hannes hat antworten hinzugefügt");
		for (Nachricht n :lena.getAufgaben()){
			quest = (Quest)lena.aufgabeBearbeiten(n);
			for  (Frage f:quest.fragen){
				for (String s:f.antworten){
					System.out.println(s);
				}
			}
		}
		
		
		
		System.out.println("hannes quest");
		
		for (Nachricht n :hannes.getAufgaben()){
			quest = (Quest)hannes.aufgabeBearbeiten(n);
			for  (Frage f:quest.fragen){
				for (String s:f.antworten){
					System.out.println(s);
				}
			}
		}
		
		
	}
	
	public static void zeitTest(){
			      try { 
			         System.out.println(new Date( ) + "\n"); 
			         Thread.sleep(3*10*100); 
			         System.out.println(new Date( ) + "\n"); 
			      } catch (Exception e) { 
			          System.out.println("Got an exception!"); 
			      }
			   
			
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
			mbis.getPinnwand().themaHinzufügen(thema);
			thema.kommentieren(kommentar);
			System.out.println(mbis.getMediathek().getId());
			mbis.getMediathek().mediumHinzufügen(med);
			mbis.setFachrichtung(wi);		
			
			db.eintragAktualisieren(lena.getClass(), lena);
			db.eintragAktualisieren(hannes.getClass(), hannes);
			db.eintragAktualisieren(thema.getClass(), thema);
			db.eintragAktualisieren(kommentar.getClass(), kommentar);
			db.eintragAktualisieren(mbis.getClass(), mbis);
			db.eintragAktualisieren(med.getClass(), med);
			}

		public static void sortierTest(){
			Pinnwand pinnwand = new Pinnwand();
			
			Benutzer hannes = new Benutzer();
			
			Thema thema1 = new Thema("Frage1", "wie alt bist du?", hannes);
			Thema thema2 = new Thema("Frage2", "wie alt bist du?", hannes);
			Thema thema3 = new Thema("Frage3", "wie alt bist du?", hannes);
			Thema thema4 = new Thema("Frage4", "wie alt bist du?", hannes);
			
			pinnwand.themen.add(thema1);
			pinnwand.themen.add(thema2);
			pinnwand.themen.add(thema3);
			pinnwand.themen.add(thema4);
			
			thema1.setBewertung(100);		
			thema2.setBewertung(200);	
			thema3.setBewertung(5);	
			thema4.setBewertung(400);	
			
			System.out.println("unsortiert:");
			for(Thema thema : pinnwand.themen){
				System.out.println(thema.getBewertung());
			}
			
			ArrayList<Thema> sortiert = new ArrayList<Thema>();
			sortiert = pinnwand.sortiereNachBewertung();
			
			System.out.println("Nach Bewertung sortiert:");
			for(Thema thema : sortiert){
				System.out.println(thema.getBewertung());
			}
			
			thema1.datum.setTime(3000);
			thema2.datum.setTime(20);
			thema3.datum.setTime(500000);
			thema4.datum.setTime(40);
			
			System.out.println("unsortiert:");
			for(Thema thema : pinnwand.themen){
				System.out.println(thema.getBewertung());
			}
			
			ArrayList<Thema> sortiertDatum = new ArrayList<Thema>();
			sortiertDatum = pinnwand.sortiereNachDatum();
		
			System.out.println("Nach Datum sortiert:");
			for(Thema thema : sortiertDatum){
				System.out.println(thema.getBewertung());
			}
			
			Kommentar kommentar1 = new Kommentar("Antwort1", "12 Jahre", hannes);
			Kommentar kommentar2 = new Kommentar("Antwort2", "12 Jahre", hannes);
			Kommentar kommentar3 = new Kommentar("Antwort3", "12 Jahre", hannes);
			Kommentar kommentar4 = new Kommentar("Antwort4", "12 Jahre", hannes);
			
			thema1.kommentieren(kommentar1);
			thema1.kommentieren(kommentar2);
			thema1.kommentieren(kommentar3);
			thema1.kommentieren(kommentar4);
			
			kommentar1.datum.setTime(49494);
			kommentar2.datum.setTime(4);
			kommentar3.datum.setTime(494);
			kommentar4.datum.setTime(111111494);
			
			System.out.println("unsortiert:");
			for(Kommentar kommentar : thema1.getKommentare()){
				System.out.println(kommentar.getTitel());
			}
			
			ArrayList<Kommentar> sortiertDatum2 = new ArrayList<Kommentar>();
			sortiertDatum2 = thema1.sortiereNachDatum();
			
			System.out.println("sortiert:");
			for(Kommentar kommentar : sortiertDatum2){
				System.out.println(kommentar.getTitel());
			}
		}
}
