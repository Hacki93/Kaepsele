//package controller;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//import kommunikation.Aufgabe;
//import kommunikation.Nachricht;
//import learning.Benutzer;
//import learning.Frage;
//import learning.Gruppe;
//import learning.Inhalt;
//import learning.Quest;
//import learning.Teamcombat;
//import learning.Thema;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import datenhaltung.Datenbank;
//
//@Controller
//public class LenasController {
//	Datenbank db;
//	Benutzer angemeldeterBenutzer;
//	Benutzer profilBenutzer;
//	Gruppe gruppe;
//	Quest quest;
//	ArrayList<Frage> questFragen; 
//	
//	@RequestMapping(value = "/", method=RequestMethod.GET)
//	public String greeting(Model model) {
//	    db = new Datenbank();
//	    angemeldeterBenutzer = new Benutzer(); 
//	    angemeldeterBenutzer = (Benutzer) db.eintragAusgeben(angemeldeterBenutzer.getClass(), 1);
//	    model.addAttribute("benutzer", new Benutzer());
//		return "Startseite";
//	}
//	
//	@RequestMapping(value = "/GruppenProfil/{gruppe_id}", method =RequestMethod.GET)
//	public String gruppenProfilAnzeigen(@PathVariable("gruppe_id") int gruppe_id, Model model){
//		Gruppe gruppe = new Gruppe();
//		for(Object obj : db.tabelleAusgeben(gruppe.getClass())){
//			Gruppe g = (Gruppe) obj;
//			if(g.getId() == (gruppe_id)) {
//				gruppe = g;
//			}
//		}
//		this.gruppe = gruppe;
//		model.addAttribute("frage", new Frage());
//	    model.addAttribute("thema", new Thema());
//	    model.addAttribute("gruppe", gruppe);
//		return "GruppenProfil";
//	}
//	
//	@RequestMapping(value = "/frageErst", method=RequestMethod.POST)
//	public String frageErstellen(@ModelAttribute Frage frage, Model model){
//		if (frage.getText() != null){
//		Frage neueFrage = new Frage();
//		db.eintragHinzufuegen(neueFrage.getClass(), neueFrage);
//		neueFrage.setText(frage.getText());
//		neueFrage.setBenutzer(angemeldeterBenutzer);
//		for (int i=0; i< frage.getZwischenSpeicherAntworten().size(); i++){
//			String antwort = frage.getZwischenSpeicherAntworten().get(i);
//			if(!antwort.equals("")){
//			neueFrage.addAntwortmoeglichkeiten(antwort);
//			}
//		}
//		
//		if(frage.isZwischenSpeicherLoesung1()){
//			if (frage.getZwischenSpeicherAntworten().size() > 0){
//			neueFrage.addLoesung(frage.getZwischenSpeicherAntworten().get(0));	
//			}
//		}
//		
//		if(frage.isZwischenSpeicherLoesung2()){
//			if (frage.getZwischenSpeicherAntworten().size() > 1){
//				neueFrage.addLoesung(frage.getZwischenSpeicherAntworten().get(1));	
//			}
//		}
//		
//		if(frage.isZwischenSpeicherLoesung3()){
//			if (frage.getZwischenSpeicherAntworten().size() > 2){
//				neueFrage.addLoesung(frage.getZwischenSpeicherAntworten().get(2));	
//				}
//		}
//		
//		if(frage.isZwischenSpeicherLoesung4()){
//			if (frage.getZwischenSpeicherAntworten().size() > 3){
//				neueFrage.addLoesung(frage.getZwischenSpeicherAntworten().get(3));	
//				}
//		}
//		
//		neueFrage.medium = frage.getMedium();
//		db.eintragAktualisieren(neueFrage.getClass(), neueFrage);
//		gruppe.getFragenpool().addFrage(neueFrage);
//		//Datenbank wird aktualisiert
//		db.eintragAktualisieren(gruppe.getFragenpool().getClass(), gruppe.getFragenpool());
//		db.eintragAktualisieren(gruppe.getClass(), gruppe);
//		
//		
//		for (String s:neueFrage.getAntwortmoeglichkeiten()){
//			System.out.println("Antwort:");
//			System.out.println(s);
//		
//		}
//		for (String s:neueFrage.getLoesung()){
//			System.out.println("Lösung: ");
//			System.out.println(s);
//		}
//		}
//		model.addAttribute("frage", new Frage());
//		model.addAttribute("thema", new Thema());
//	    model.addAttribute("gruppe", gruppe);
//		return "GruppenProfil";
//	}
//	
//	@RequestMapping(value = "/QuestStarten")
//	public String questStarten(Model model){
//		System.out.println("Neuer Quest angelegt");
//		System.out.println(gruppe.getName());
//		Quest quest =  gruppe.questAntreten(angemeldeterBenutzer);
//		db.eintragZusammenfuehren(quest.getClass(), quest);
//		this.quest = quest;
//		ArrayList<Frage> fragen = new ArrayList<Frage>();
//		for (Frage f: quest.getFragen()){
//			fragen.add(f);
//			System.out.println(f.getText());
//		}
//		questFragen=fragen;
//		model.addAttribute("fragen", fragen);
//		model.addAttribute("frage1", new Frage());
//		return "Quest";
//	}
//	
//	@RequestMapping(value = "/themaErst", method=RequestMethod.POST)
//	public String themaErstellen(@ModelAttribute Thema thema, Model model){
//		System.out.println("Thema erstellt");
//		System.out.println(thema.getTitel());
//		model.addAttribute("frage", new Frage());
//	    model.addAttribute("thema", new Thema());
//		return "GruppenProfil";
//	}
//	
//	@RequestMapping(value = "/questBeenden")
//	public String questBeenden(@ModelAttribute Frage frage, Model model){
//		System.out.println("questBeenden-Methode");
//		ArrayList<String> zwischenSpeicherAntworten = frage.getZwischenSpeicherAntworten();
//		Frage mryFrage = new Frage();
//		for (String s:zwischenSpeicherAntworten){
//			String[] result; 
//			result = s.split(";!§;");
//			int frageId = Integer.parseInt(result[0]);
//			System.out.println(frageId);
//			String loesung = result[1];
//			System.out.println(loesung);
//				for (Frage f: questFragen){
//					int id = f.getId();
//					if (id == frageId){
//						mryFrage = f;
//				} 
//			}
//				
//				mryFrage.addAntwort(loesung);
//				db.eintragZusammenfuehren(mryFrage.getClass(), mryFrage);
//		}
//		
//		System.out.println(quest.korrigiere());
//		mryFrage.getAntworten().clear();
//		db.eintragZusammenfuehren(mryFrage.getClass(), mryFrage);
//			
//		model.addAttribute("frage", new Frage());
//		model.addAttribute("thema", new Thema());
//	    model.addAttribute("gruppe", gruppe);
//	    System.out.println("jetzt hier");
//	    return "GruppenProfil";
//	}
//	
//	@RequestMapping(value = "/TeamcombatsAnzeigen")
//	public String teamcombatsAnzeigen(Model model){
//		ArrayList<Aufgabe> aufgaben = new ArrayList<Aufgabe>();
//		for (Aufgabe a: angemeldeterBenutzer.getAufgaben()){
//			if (a.getTyp() == Nachricht.TEAMHERAUSFORDERUNG){
//				System.out.println(a.getInhalt());
//				aufgaben.add(a);
//			}
//		}
//		
//		for (Aufgabe au: aufgaben){
//			System.out.println("Aufgabe gespeichert: " + au.getTitel());
//		}
//		
//		model.addAttribute(aufgaben);
//		return "TeamcombatListe";
//	}
//	
//}
