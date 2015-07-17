//package controller;
//
//import learning.Benutzer;
//import learning.Frage;
//import learning.Gruppe;
//import learning.Inhalt;
//import learning.Quest;
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
//	
//	@RequestMapping(value = "/", method=RequestMethod.GET)
//	public String greeting(Model model) {
//	    db = new Datenbank();
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
//		Frage neueFrage = new Frage();
//		db.eintragHinzufuegen(neueFrage.getClass(), neueFrage);
//		neueFrage.setText(frage.getText());
//		neueFrage.setBenutzer(angemeldeterBenutzer);
//		System.out.println(gruppe.getName());
//		for (int i=0; i<4; i++){
//			neueFrage.addAntwortmoeglichkeiten(frage.getZwischenSpeicherAntworten().get(i));
//		}
//		
//		if(frage.isZwischenSpeicherLoesung1()){
//			neueFrage.addLoesung(frage.getZwischenSpeicherAntworten().get(0));
//		}
//		
//		if(frage.isZwischenSpeicherLoesung2()){
//			neueFrage.addLoesung(frage.getZwischenSpeicherAntworten().get(1));
//		}
//		
//		if(frage.isZwischenSpeicherLoesung3()){
//			neueFrage.addLoesung(frage.getZwischenSpeicherAntworten().get(2));
//		}
//		
//		if(frage.isZwischenSpeicherLoesung4()){
//			neueFrage.addLoesung(frage.getZwischenSpeicherAntworten().get(3));
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
//		model.addAttribute("frage", frage);
//		model.addAttribute("thema", new Thema());
//	    model.addAttribute("gruppe", gruppe);
//		return "GruppenProfil";
//	}
//	
//	@RequestMapping(value = "/QuestStarten")
//	public String questStarten(Model model){
//		Quest quest = new Quest(); 
//		quest =  gruppe.questAntreten(angemeldeterBenutzer);
//		this.quest = quest;
//		model.addAttribute("quest", this.quest);
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
//}
