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
//		model.addAttribute("quest", new Quest());
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
//	public String questBeenden(@ModelAttribute Quest quest, Model model){
//		if (quest.getAntworten() != null){
//			for (String a: quest.getAntworten()){
//				this.quest.addAntwort(a);
//			}
//		}
//		
//		System.out.println(this.quest.korrigiere());
//		db.eintragAktualisieren(this.quest.getClass(), this.quest);
//		this.quest = null; 
//			
//		model.addAttribute("frage", new Frage());
//		model.addAttribute("thema", new Thema());
//	    model.addAttribute("gruppe", gruppe);
//	    return "GruppenProfil";
//	}
//	
//	@RequestMapping(value = "/TeamcombatsAnzeigen")
//	public String teamcombatsAnzeigen(Model model){
//		ArrayList<Aufgabe> aufgaben = new ArrayList<Aufgabe>();
//		for (Aufgabe a: angemeldeterBenutzer.getAufgaben()){
//			if (a.getTyp() == Nachricht.TEAMHERAUSFORDERUNG){
//				Teamcombat teamcombat = a.getAnhangTeamcombat(); 
//				System.out.println(teamcombat.getId());
//				a.setHilfsIdTeamcombat(teamcombat.getId());
//				
//				// prüft in welcher Gruppe der angemeldete Benutzer ist, damit die Gruppeninfo der gegnerischen Gruppe ausgegeben wird 
//				if (!teamcombat.getHerausforderer().getMitglieder().contains(angemeldeterBenutzer)){
//					teamcombat.getHerausforderer().setAnzahlMitglieder(teamcombat.getHerausforderer().anzahl());
//					a.setGegnerischeGruppenInfo(teamcombat.getHerausforderer());
//				} else {
//					teamcombat.getHerausgeforderter().setAnzahlMitglieder(teamcombat.getHerausgeforderter().anzahl());
//					a.setGegnerischeGruppenInfo(teamcombat.getHerausgeforderter());
//				}
//				aufgaben.add(a);
//			}
//		}
//		
//	
//		model.addAttribute("aufgaben", aufgaben);
//		return "TeamcombatListe";
//	}
//	
//	@RequestMapping(value = "/TeamcombatBearbeiten/{aufgabe.anhangTeamcombat.teamcombat_id}")
//	public String teamcombatBearbeiten(@PathVariable("aufgabe.anhangTeamcombat.teamcombat_id") int teamcombat_id, @ModelAttribute Aufgabe aufgabe1, Model model){
//		Teamcombat teamcombat = new Teamcombat(); 
//		Quest quest = new Quest();
//		teamcombat = (Teamcombat) db.eintragAusgeben(teamcombat.getClass(), teamcombat_id);
//		if (teamcombat.getHerausforderer().getMitglieder().contains(angemeldeterBenutzer)){
//			quest = teamcombat.getQuestFuerHerausforderer(); 
//		} else {
//			quest = teamcombat.getQuestFuerHerausgeforderter();
//		}
//
//		this.quest = quest;
//		ArrayList<Frage> fragen = new ArrayList<Frage>();
//		for (Frage f: quest.getFragen()){
//			fragen.add(f);
//		}
//		
//		if (this.quest.getAntworten() != null){
//			for (String a: this.quest.getAntworten()){
//				String[] parts = a.split(";!!;!");
//				int frage_id = Integer.parseInt(parts[0]);
//				String antwort = parts[1];
//				for (Frage f: fragen){
//					if (f.getId() == frage_id){
//						f.getZwischenSpeicherAntworten().add(antwort);
//					}
//				}
//			}
//		}
//		
//		questFragen=fragen;
//		model.addAttribute("fragen", fragen);
//		model.addAttribute("quest", new Quest());
//		return "QuestTeamcombat";
//	}
//	
//	@RequestMapping(value = "/questTeamcombatSpeichern")
//	public String questTeamcombatSpeichern(@ModelAttribute Quest quest, Model model){
//		if (quest.getAntworten() != null){
//			this.quest.getAntworten().clear();
//			for (String a: quest.getAntworten()){
//				this.quest.addAntwort(a);
//			}
//		}
//		
//		db.eintragAktualisieren(this.quest.getClass(), this.quest);
//		this.quest = null; 
//	    
//	    
//		ArrayList<Aufgabe> aufgaben = new ArrayList<Aufgabe>();
//		for (Aufgabe a: angemeldeterBenutzer.getAufgaben()){
//			if (a.getTyp() == Nachricht.TEAMHERAUSFORDERUNG){
//				Teamcombat teamcombat = a.getAnhangTeamcombat(); 
//				System.out.println(teamcombat.getId());
//				a.setHilfsIdTeamcombat(teamcombat.getId());
//				
//				// prüft in welcher Gruppe der angemeldete Benutzer ist, damit die Gruppeninfo der gegnerischen Gruppe ausgegeben wird 
//				if (!teamcombat.getHerausforderer().getMitglieder().contains(angemeldeterBenutzer)){
//					teamcombat.getHerausforderer().setAnzahlMitglieder(teamcombat.getHerausforderer().anzahl());
//					a.setGegnerischeGruppenInfo(teamcombat.getHerausforderer());
//				} else {
//					teamcombat.getHerausgeforderter().setAnzahlMitglieder(teamcombat.getHerausgeforderter().anzahl());
//					a.setGegnerischeGruppenInfo(teamcombat.getHerausgeforderter());
//				}
//				aufgaben.add(a);
//			}
//		}
//		
//		System.out.println("Teamcombat wurde gespeichert");
//		model.addAttribute("aufgaben", aufgaben);
//		return "TeamcombatListe";
//	}
//	
//}
