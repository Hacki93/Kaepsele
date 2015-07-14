package controller;


import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import kommunikation.Nachricht;
import learning.Benutzer;
import learning.Bossfight;
import learning.Fachrichtung;
import learning.Frage;
import learning.Gruppe;
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
//		System.exit(0);
		}

		public static void dbSchreiben(){	
			try{
				
				//Objekte erstellen
					
				Benutzer hannes 	= new Benutzer();
				Benutzer lena 		= new Benutzer();
				Gruppe mbis 		= new Gruppe();
				Thema thema 		= new Thema();
				Thema thema2		= new Thema();
				Thema thema3		= new Thema();
				Thema thema4		= new Thema();
				Kommentar kommentar = new Kommentar();
				Medium medium 		= new Medium();
				Mediathek mediathek = new Mediathek();
				Fachrichtung wi		= new Fachrichtung();
				Frage frage			= new Frage();
				Bossfight bossfight = new Bossfight();
				
				Datenbank db = new Datenbank();
				
				db.eintragHinzufuegen(medium.getClass(), medium);			
				db.eintragHinzufuegen(thema.getClass(), thema);
				db.eintragHinzufuegen(thema2.getClass(), thema2);
				db.eintragHinzufuegen(thema3.getClass(), thema3);
				db.eintragHinzufuegen(thema4.getClass(), thema4);
				db.eintragHinzufuegen(kommentar.getClass(), kommentar);
				db.eintragHinzufuegen(mediathek.getClass(), mediathek);
				db.eintragHinzufuegen(hannes.getClass(), hannes);
				db.eintragHinzufuegen(lena.getClass(), lena);
				db.eintragHinzufuegen(mbis.getClass(), mbis);
				db.eintragHinzufuegen(wi.getClass(), wi);
				db.eintragHinzufuegen(frage.getClass(), frage);
				db.eintragHinzufuegen(bossfight.getClass(), bossfight);
				
				
				//Objekte füllen und verbinden
				
				hannes.setAdresse("Bühlenstr. 100, 71088 Holzgerlingen");
				hannes.registrieren("hannes", "spiegelei");
				hannes.setRang(1000);
				hannes.setBeruf("Student");
				hannes.setEmailAdresse("mail@hannes-fischer.com");
				hannes.setName("Hannes Fischer");
				hannes.setStudiengang("Wirtschaftsinformatik B.Sc.");
				hannes.setGeburtsdatum(new SimpleDateFormat("dd/MM/yyyy").parse("01/26/1995"));
				hannes.setProfilbildURL("/Bild.png");
				hannes.freundHinzufuegen(lena);
	
				lena.setAdresse("Schopfloch");
				lena.registrieren("lenchen", "12345678");
				lena.setRang(2);
				lena.setBeruf("Student");
				lena.setEmailAdresse("lenamaier@web.de");
				lena.setName("Lena Maier");		
				lena.setStudiengang("Wirtschaftsinformatik B.Sc.");
				lena.setGeburtsdatum(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1993"));
				lena.setProfilbildURL("/Bild.png");
				lena.freundHinzufuegen(hannes);
	
				wi.setName("Wirtschaftsinformatik");
				wi.setFreigegeben(false);
				
				bossfight.addAntwort("42");
				
				mbis.setName("Management betrieblicher Informationssysteme");
				mbis.setKlausurname("MBIS 1");
				mbis.setProfilbildURL("/Gruppenbild.png");
				mbis.mitgliedHinzufuegen(lena);
				mbis.mitgliedHinzufuegen(hannes);
				mbis.moderatorHinzufuegen(hannes);
	            mbis.setMediathek(mediathek);
				mbis.pinnwand.themaHinzufügen(thema);
				mbis.fragenpool.addFrage(frage);
				mbis.setFachrichtung(wi);
				mbis.addBossfight(bossfight);
	
				thema.setPinnwand(hannes.pinnwand);
				thema.setBenutzer(hannes);
				thema.setBewertung(5);
				thema.setInhalt("Themeninhalt von Hannes");
				thema.setTitel("Thementitel von Hannes");
				thema.setMedium(medium);
				thema.kommentieren(kommentar);
				
				thema2.setPinnwand(hannes.pinnwand);
				thema2.setBenutzer(lena);
				thema2.setBewertung(25);
				thema2.setInhalt("Themeninhalt von Lena");
				thema2.setTitel("Thementitel von Lena");
				
				thema3.setPinnwand(hannes.pinnwand);
				thema3.setBenutzer(lena);
				thema3.setBewertung(1);
				thema3.setInhalt("Themeninhalt von Lena");
				thema3.setTitel("Thementitel von Lena");
				
				thema4.setPinnwand(hannes.pinnwand);
				thema4.setBenutzer(lena);
				thema4.setBewertung(205);
				thema4.setInhalt("Themeninhalt von Lena");
				thema4.setTitel("Thementitel von Lena");
				
				kommentar.setBenutzer(lena);
				kommentar.setBewertung(0);
				kommentar.setInhalt("Kommentarinhalt von Lena");
				kommentar.setTitel("Kommentartitel von Lena");
				kommentar.setMedium(medium);
				
	            mediathek.mediumHinzufügen(medium);
	            	
	            medium.setName("Entwurf");
	            medium.setDateiname("Entwurf.pdf");
	            
	            frage.setBearbeitet(false);
	            frage.setText("Willst Du mit mir gehn?");
	            frage.setTitel("Zettel");
	            frage.addAntwortmoeglichkeiten("Vielleicht");
	            frage.addAntwortmoeglichkeiten("Ja");
	            frage.addAntwortmoeglichkeiten("Nein");
	            frage.addLoesung("Ja");
	            frage.setBenutzer(lena);
	            
	            Quest quest = mbis.questAntreten(hannes); //Quest wird dynamisch erzeugt und kann nicht als new Quest() angelegt werden!
	            db.eintragHinzufuegen(quest.getClass(), quest);
				
				db.eintragAktualisieren(thema.getClass(), thema);
				db.eintragAktualisieren(thema2.getClass(), thema2);
				db.eintragAktualisieren(thema3.getClass(), thema3);
				db.eintragAktualisieren(thema4.getClass(), thema4);
				db.eintragAktualisieren(kommentar.getClass(), kommentar);
				db.eintragAktualisieren(mediathek.getClass(), mediathek);
				db.eintragAktualisieren(medium.getClass(), medium);	
				mbis.setMediathek(mediathek);
				db.eintragAktualisieren(lena.getClass(), lena);
				db.eintragAktualisieren(hannes.getClass(), hannes);
				db.eintragAktualisieren(mbis.getClass(), mbis);
				db.eintragAktualisieren(wi.getClass(), wi);
				db.eintragAktualisieren(frage.getClass(), frage);
				db.eintragAktualisieren(quest.getClass(), quest);
				db.eintragAktualisieren(bossfight.getClass(), bossfight);

			} catch (Exception e) {
				e.printStackTrace();
			}
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
//			
//			thema1.datum.setTime(3000);
//			thema2.datum.setTime(20);
//			thema3.datum.setTime(500000);
//			thema4.datum.setTime(40);
//			
//			System.out.println("unsortiert:");
//			for(Thema thema : pinnwand.themen){
//				System.out.println(thema.getBewertung());
//			}
//			
//			ArrayList<Thema> sortiertDatum = new ArrayList<Thema>();
//			sortiertDatum = pinnwand.sortiereNachDatum();
//		
//			System.out.println("Nach Datum sortiert:");
//			for(Thema thema : sortiertDatum){
//				System.out.println(thema.getBewertung());
//			}
//			
//			Kommentar kommentar1 = new Kommentar("Antwort1", "12 Jahre", hannes);
//			Kommentar kommentar2 = new Kommentar("Antwort2", "12 Jahre", hannes);
//			Kommentar kommentar3 = new Kommentar("Antwort3", "12 Jahre", hannes);
//			Kommentar kommentar4 = new Kommentar("Antwort4", "12 Jahre", hannes);
//			
//			thema1.kommentieren(kommentar1);
//			thema1.kommentieren(kommentar2);
//			thema1.kommentieren(kommentar3);
//			thema1.kommentieren(kommentar4);
//			
//			kommentar1.datum.setTime(49494);
//			kommentar2.datum.setTime(4);
//			kommentar3.datum.setTime(494);
//			kommentar4.datum.setTime(111111494);
//			
//			System.out.println("unsortiert:");
//			for(Kommentar kommentar : thema1.getKommentare()){
//				System.out.println(kommentar.getTitel());
//			}
//			
//			ArrayList<Kommentar> sortiertDatum2 = new ArrayList<Kommentar>();
//			sortiertDatum2 = thema1.sortiereNachDatum();
//			
//			System.out.println("sortiert:");
//			for(Kommentar kommentar : sortiertDatum2){
//				System.out.println(kommentar.getTitel());
//			}
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
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			
			gruppe2.frageErstellen("andererTitel", frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			System.out.println("Frage hinzugefügt");	
			System.out.println(new Date());
			Teamcombat t = gruppe1.teamcombatAntreten(gruppe2);
			
			Quest quest = t.bearbeiten(lena);
			
			
			HashSet<String> antworten = new HashSet<String>();
			antworten.add("Du da");
			Frage frage1 = quest.getNaechsteFrage();
			frage1.addAntworten(antworten);
			System.out.println("Lena hat antworten hinzugefügt");
			
			
			
//			Quest quest2 = new Quest(); 
//			for (Nachricht n: hannes.getAufgaben()){
//				quest2 = (Quest)hannes.aufgabeBearbeiten(n);
//			}
//			
//			
//			HashSet<String> antworten2 = new HashSet<String>();
//			antworten2.add("Ich bins"); 
//			Frage frage2 = quest2.getNaechsteFrage();
//			frage2.addAntworten(antworten2);
//			
//			System.out.println("Hannes hat antworten hinzugefügt");
//			for (Nachricht n :lena.getAufgaben()){
//				quest = (Quest)lena.aufgabeBearbeiten(n);
//				for  (Frage f:quest.fragen){
//					for (String s:f.antworten){
//						System.out.println(s);
//					}
//				}
//			}
//			
//			
//			
//			System.out.println("hannes quest");
//			
//			for (Nachricht n :hannes.getAufgaben()){
//				quest = (Quest)hannes.aufgabeBearbeiten(n);
//				for  (Frage f:quest.fragen){
//					for (String s:f.antworten){
//						System.out.println(s);
//					}
//				}
//			}
//			
//			
		}
				
		public static void zeitTest(){
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
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			gruppe1.frageErstellen(titel, frage, a, l, kevin);
			
			gruppe2.frageErstellen("andererTitel", frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			gruppe2.frageErstellen(titel2, frage, a, l, kevin);
			System.out.println("Frage hinzugefügt");	
			Teamcombat t = gruppe1.teamcombatAntreten(gruppe2);
			
			
		}
}
