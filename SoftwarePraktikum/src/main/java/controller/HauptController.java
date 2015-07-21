//package controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import learning.Benutzer;
//import learning.Fachrichtung;
//import learning.Frage;
//import learning.Gruppe;
//import learning.Inhalt;
//import learning.Medium;
//import learning.Quest;
//import learning.Thema;
//
//import org.apache.commons.io.IOUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import datenhaltung.Datenbank;
//
//@Controller
//public class HauptController {
//	
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
//	    angemeldeterBenutzer = null;
//	    // dem model wird ein Benutzer hinzugefügt, falls sich jemand neu registriert
//	    model.addAttribute("benutzer", new Benutzer());
//		return "Startseite";
//	}
//	
//	@RequestMapping(value= "/loginseite")
//	public String zumLogin(Model model){
//		// dem model wird ein Benutzer hinzugeügt, damit die Logindaten abgefragt werden können
//	model.addAttribute("benutzer", new Benutzer());
//		return "Anmelden";
//	}
//	
//	@RequestMapping(value="/registriert", method=RequestMethod.POST)
//	public String registrieren(@ModelAttribute Benutzer benutzer, Model model){
//		// Bei der Registrierung wird überprüft ob der Benutzername bereits vergeben ist
//		for(Object obj : db.tabelleAusgeben(benutzer.getClass())){
//			Benutzer b = (Benutzer) obj;
//			if (benutzer.benutzername.equals(b.benutzername)){
//				model.addAttribute("nachricht", "Dieser Benutzername ist bereits vergeben");
//				return "Startseite";
//			}
//		}
//		
//		// neuer Benutzer instanziert und in der Datenbank angelegt
//		Benutzer neuerBenutzer = new Benutzer();
//		db.eintragHinzufuegen(neuerBenutzer.getClass(), neuerBenutzer);
//		
//		// Erste Attribute des Benutzers werden erstellt und in der Datenbank aktualisiert
//		neuerBenutzer.setBenutzername(benutzer.getBenutzername());
//		neuerBenutzer.setPasswort(Benutzer.hashPasswort(benutzer.getPasswort()));
//		neuerBenutzer.setEmailAdresse(benutzer.getEmailAdresse());
//		neuerBenutzer.setName(benutzer.name);
//		db.eintragAktualisieren(neuerBenutzer.getClass(), neuerBenutzer);
//		
//		model.addAttribute("nachricht", "Sie sind jetzt registriert");
//		return "Anmelden";
//	}
//	
//	@RequestMapping(value= "/login", method = RequestMethod.POST)
//	public String login(@ModelAttribute Benutzer benutzer, Model model){
//		// Beim login wird nach nicht vorhandenem Benutzername und falschem Passwort geprüft
//		for(Object obj : db.tabelleAusgeben(benutzer.getClass())){
//			Benutzer b = (Benutzer) obj;
//			if(b.getBenutzername().equals(benutzer.getBenutzername())) {
//				if(b.login(benutzer.getPasswort())){
//					// Der angemeldete Benutzer wird gesetzt
//					angemeldeterBenutzer = b;
//					return "Menu";
//				}
//				model.addAttribute("nachricht", "Passwort falsch");
//				return "Anmelden";
//			}
//		}
//		model.addAttribute("nachricht", "Benutzername nicht vorhanden");
//		return "Anmelden";
//	}
//	
//	@RequestMapping(value="/Menu")
//	public String getMenu(Model model){
//		return "Menu2";
//	}
//	
//	@RequestMapping(value="/profil", method=RequestMethod.GET)
//	public String eigenesProfil(Model model){
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : angemeldeterBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		// Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = angemeldeterBenutzer.pinnwand.sortiereNachDatum();
//		
//		// Benutzer geht auf sein eigenes Profil hierbei müssen seine
//		// persönlichen Angaben und Pinnwand dem model hinzugefügt werden,
//		// damit diese angegezeigt werden
//		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
//		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
//		model.addAttribute("themen", themenList);
//		model.addAttribute("benutzer", new Benutzer());
//		model.addAttribute("thema", new Thema());
//		return "EigenesProfil";
//	}
//	
//	@RequestMapping(value="/profil/{benutzername}", method=RequestMethod.GET)
//	public String getProfil(@PathVariable("benutzername") String benutzername, Model model){
//		// Es wird die Profilseite eines anderen Benutzers aufgerufen
//		Benutzer benutzer = new Benutzer();
//		for(Object obj : db.tabelleAusgeben(benutzer.getClass())){
//			Benutzer b = (Benutzer) obj;
//			if(b.getBenutzername().equals(benutzername)) {
//				// der Profilbenutzer wird gesetzt
//				profilBenutzer = b;	
//			}
//		}
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : profilBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		// Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
//		
//		// dem Model müssen die Daten des ProfilBenutzer übergeben werden,
//		// damit diese angezeigt werden können
//		model.addAttribute("themen", themenList);
//		model.addAttribute("profilBenutzer", profilBenutzer);
//		model.addAttribute("rang", profilBenutzer.getRangName());
//		model.addAttribute("thema", new Thema());
//		return "Profil";
//	}
//	
//	@RequestMapping(value="/ProfilDaten", method = RequestMethod.POST)
//	public String datenAendern(@ModelAttribute Benutzer benutzer, Model model){
//		System.out.println("test");
//		System.out.println(benutzer.getAdresse());
//		System.out.println(benutzer.getBeruf());;
//		
//		// angemeldeterBenutzer wird aktualisiert
//		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
//			Benutzer b = (Benutzer) obj;
//			if(b.getBenutzername().equals(angemeldeterBenutzer.getBenutzername())) {
//				angemeldeterBenutzer = b;					
//			}
//		}
//		// neuen Attributwerte werden gesetzt
//		angemeldeterBenutzer.setEmailAdresse(benutzer.getEmailAdresse());
//		angemeldeterBenutzer.setAdresse(benutzer.getAdresse());
//		angemeldeterBenutzer.setGeburtsdatum(benutzer.getGeburtsdatum());
//		angemeldeterBenutzer.setBeruf(benutzer.getBeruf());
//		angemeldeterBenutzer.setStudiengang(benutzer.getStudiengang());
//		
//		// Einträge in der Datenbank werden aktualisiert
//		db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : angemeldeterBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//				
//		// Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = angemeldeterBenutzer.pinnwand.sortiereNachDatum();
//		
//		// Dem Model werden alle relevanten Daten übergeben
//		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
//		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
//		model.addAttribute("themen", themenList);
//		model.addAttribute("benutzer", new Benutzer());
//		model.addAttribute("thema", new Thema());
//		return "EigenesProfil";
//	}
//	
//	@RequestMapping(value="/sortiereLikes/eigenesProfil")
//	public String sortiereLikesEigenesProfil(Model model){
//		// die Pinnwand wird nach Likes sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = angemeldeterBenutzer.pinnwand.sortiereNachBewertung();
//				
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : angemeldeterBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//				
//		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
//		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
//		model.addAttribute("themen", themenList);
//		model.addAttribute("benutzer", new Benutzer());
//		model.addAttribute("thema", new Thema());
//		return "EigenesProfil";
//	}
//	
//	@RequestMapping(value="/sortiereLikes")
//	public String sortiereLikes(Model model){
//		// die Pinnwand wird nach Likes sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = profilBenutzer.pinnwand.sortiereNachBewertung();
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : profilBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//		model.addAttribute("themen", themenList);
//		model.addAttribute("profilBenutzer", profilBenutzer);
//		model.addAttribute("rang", profilBenutzer.getRangName());
//		model.addAttribute("thema", new Thema());
//		return "Profil";
//	}
//	
//	@RequestMapping(value="/sortierDatum/eigenesProfil")
//	public String sortierDatumEigenesProfil(Model model){
//		// die Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = angemeldeterBenutzer.pinnwand.sortiereNachDatum();
//				
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : angemeldeterBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
//		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
//		model.addAttribute("themen", themenList);
//		model.addAttribute("benutzer", new Benutzer());
//		model.addAttribute("thema", new Thema());
//		return "EigenesProfil";		
//	}
//	
//	@RequestMapping(value="/sortierDatum")
//	public String sortierDatum(Model model){
//		// die Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : profilBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//		model.addAttribute("themen", themenList);
//		model.addAttribute("profilBenutzer", profilBenutzer);
//		model.addAttribute("rang", profilBenutzer.getRangName());
//		model.addAttribute("thema", new Thema());
//		return "Profil";
//	}
//	
//	@RequestMapping(value="/hinzufuegen")
//	public String freundHizufuegen(Model model){
//		// angemeldeterBenutzer und profilBenutzer werden aktualisiert
//		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
//			Benutzer b = (Benutzer) obj;
//			if(b.getBenutzername().equals(angemeldeterBenutzer.getBenutzername())) {
//				angemeldeterBenutzer = b;
//			}	
//			if(b.getBenutzername().equals(profilBenutzer.getBenutzername())){
//				profilBenutzer = b;	
//			}
//		}
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : profilBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		// Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
//		
//		// Überprüfung ob der profilBenutzer bereits ein freund ist
//		for(Benutzer benutzer : angemeldeterBenutzer.freunde){
//			if(benutzer.getId() == profilBenutzer.getId()){
//				// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//				model.addAttribute("themen", themenList);
//				model.addAttribute("profilBenutzer", profilBenutzer);
//				model.addAttribute("rang", profilBenutzer.getRangName());
//				model.addAttribute("thema", new Thema());
//				model.addAttribute("nachricht", "Benutzer ist bereits ein Freund");
//				return "Profil";
//			}
//		}
//		
//		// profilBenutzer wird der Freundesliste hinzugefügt
//		angemeldeterBenutzer.freundHinzufuegen(profilBenutzer);
//		
//		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//		model.addAttribute("themen", themenList);
//		model.addAttribute("nachricht", "Benutzer wurde als Freund hinzugefügt");
//		model.addAttribute("profilBenutzer", profilBenutzer);
//		model.addAttribute("rang", profilBenutzer.getRangName());
//		model.addAttribute("thema", new Thema());
//		
//		// die Datenbank wird aktualisiert
//		db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
//		db.eintragAktualisieren(profilBenutzer.getClass(), profilBenutzer);
//		return "Profil";
//	}
//	
//	@RequestMapping(value="/entfernen")
//	public String freundEntfernen(Model model){
//		// Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : profilBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		// Überprüfung ob sich der profilBenutzer in der Freundesliste befindet
//		for(Benutzer benutzer : angemeldeterBenutzer.freunde){
//			if(benutzer.getId() == profilBenutzer.getId()){
//				// Freund wird entfernt
//				angemeldeterBenutzer.freundEntfernen(benutzer);
//				
//				// Datenbank wird aktualisiert
//				db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
//				
//				// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//				model.addAttribute("themen", themenList);
//				model.addAttribute("profilBenutzer", profilBenutzer);
//				model.addAttribute("rang", profilBenutzer.getRangName());
//				model.addAttribute("thema", new Thema());
//				model.addAttribute("nachricht", "Freund wurde entfernt");
//				return "Profil";
//			}
//		}
//
//		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//		model.addAttribute("themen", themenList);
//		model.addAttribute("profilBenutzer", profilBenutzer);
//		model.addAttribute("rang", profilBenutzer.getRangName());
//		model.addAttribute("thema", new Thema());
//		model.addAttribute("nachricht", "Benutzer ist kein Freund");
//		return "Profil";
//	}
//	
//	@RequestMapping(value="/bewertet/eigenesProfil/{thema.inhalt_id}")
//	public String erhoeheLikeEigenesProfil(@PathVariable("thema.inhalt_id") int inhalt_id, Model model){
//		// Inhalt wird geliked
//		Inhalt inhalt = new Inhalt();
//		for(Object obj : db.tabelleAusgeben(inhalt.getClass())){
//			Inhalt i = (Inhalt) obj;
//			if(i.getId() == (inhalt_id)) {
//				i.bewerten(true);
//				//Datenbank wird aktualisiert
//				db.eintragAktualisieren(i.getClass(), i);
//			}
//		}
//		
//		// angemeldeterBenutzer wird aktualisiert
//		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
//			Benutzer b = (Benutzer) obj;
//			if(b.getBenutzername().equals(angemeldeterBenutzer.getBenutzername())) {
//				angemeldeterBenutzer = b;					
//			}
//		}
//				
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : angemeldeterBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//				
//		// Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = angemeldeterBenutzer.pinnwand.sortiereNachDatum();
//				
//		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//		model.addAttribute("themen", themenList);
//		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
//		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
//		model.addAttribute("benutzer", new Benutzer());
//		model.addAttribute("thema", new Thema());
//		return "EigenesProfil";
//	}
//	
//	@RequestMapping(value="/bewertet/{thema.inhalt_id}")
//	public String erhoeheLike(@PathVariable("thema.inhalt_id") int inhalt_id, Model model){
//		
//		// Inhalt wird geliked
//		Inhalt inhalt = new Inhalt();
//		for(Object obj : db.tabelleAusgeben(inhalt.getClass())){
//			Inhalt i = (Inhalt) obj;
//			if(i.getId() == (inhalt_id)) {
//				i.bewerten(true);
//				//Datenbank wird aktualisiert
//				db.eintragAktualisieren(i.getClass(), i);
//			}
//		}
//		
//		// profilBenutzer wird aktualisiert
//		for(Object obj : db.tabelleAusgeben(profilBenutzer.getClass())){
//			Benutzer b = (Benutzer) obj;
//			if(b.getBenutzername().equals(profilBenutzer.getBenutzername())) {
//				profilBenutzer = b;					
//			}
//		}
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : profilBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		// Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
//		
//		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//		model.addAttribute("themen", themenList);
//		model.addAttribute("profilBenutzer", profilBenutzer);
//		model.addAttribute("rang", profilBenutzer.getRangName());
//		model.addAttribute("thema", new Thema());
//		return "Profil";
//	}
//	
//	@RequestMapping(value="/themaLoeschen/{thema.inhalt_id}")
//	public String themaLoeschen(@PathVariable("thema.inhalt_id") int inhalt_id, Model model){
//		Inhalt themaLoeschen = new Thema();
//		for(Object obj : db.tabelleAusgeben(themaLoeschen.getClass())){
//			Thema t = (Thema) obj;
//			if(t.getId() == (inhalt_id)) {
//				// Eintrag aus der Datenbank löschen
//				angemeldeterBenutzer.pinnwand.themaEntfernen(t);
//				db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
//				db.eintragAktualisieren(t.getClass(), t);
//				
//				db.eintragEntfernen(t.getClass(), t.getId());
//				
//			}
//		}
//		
//		// angemeldeterBenutzer wird aktualisiert
//		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
//			Benutzer b = (Benutzer) obj;
//			if(b.getBenutzername().equals(angemeldeterBenutzer.getBenutzername())) {
//				angemeldeterBenutzer = b;					
//			}
//		}
//						
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : angemeldeterBenutzer.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//						
//		// Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = angemeldeterBenutzer.pinnwand.sortiereNachDatum();
//						
//		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//		model.addAttribute("themen", themenList);
//		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
//		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
//		model.addAttribute("benutzer", new Benutzer());
//		model.addAttribute("thema", new Thema());
//		return "EigenesProfil";
//	}
//	
//	@RequestMapping(value="/beitragSchreiben", method = RequestMethod.POST)
//	public String beitragSchreiben(@ModelAttribute Thema thema, Model model){
//		Thema neuesThema = new Thema();
//		db.eintragHinzufuegen(neuesThema.getClass(), neuesThema);
//		neuesThema.setTitel(thema.getTitel());
//		neuesThema.setInhalt(thema.getInhalt());
//		neuesThema.setBenutzer(angemeldeterBenutzer);
//		profilBenutzer.pinnwand.themaHinzufuegen(neuesThema);
//		db.eintragZusammenfuehren(neuesThema.getClass(), neuesThema);
//		
//		// profilBenutzer und angemeldeterBenutzer wird aktualisiert
//		for(Object obj : db.tabelleAusgeben(profilBenutzer.getClass())){
//			Benutzer b = (Benutzer) obj;
//			if(b.getBenutzername().equals(profilBenutzer.getBenutzername())) {
//				profilBenutzer = b;	
//			}
//			if(b.getBenutzername().equals(angemeldeterBenutzer.getBenutzername())) {
//				angemeldeterBenutzer = b;					
//			}
//		}
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema themaDatum : profilBenutzer.pinnwand.themen){
//			themaDatum.hilfsDatum = simple.format(thema.datum);
//		}
//								
//		// Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
//		
//		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//		model.addAttribute("profilBenutzer", profilBenutzer);
//		model.addAttribute("rang", profilBenutzer.getRangName());
//		model.addAttribute("themen", themenList);
//		model.addAttribute("thema", new Thema());
//		
//		return "Profil";
//	}
//	
//	@RequestMapping(value="/EigenerBeitragSchreiben", method = RequestMethod.POST)
//	public String eigenerBeitragSchreiben(@ModelAttribute Thema thema, Model model){
//		Thema neuesThema = new Thema();
//		db.eintragHinzufuegen(neuesThema.getClass(), neuesThema);
//		neuesThema.setTitel(thema.getTitel());
//		neuesThema.setInhalt(thema.getInhalt());
//		neuesThema.setBenutzer(angemeldeterBenutzer);
//		angemeldeterBenutzer.pinnwand.themaHinzufuegen(neuesThema);
//		db.eintragAktualisieren(neuesThema.getClass(), neuesThema);
//		
//		// profilBenutzer und angemeldeterBenutzer wird aktualisiert
//		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
//			Benutzer b = (Benutzer) obj;
//			if(b.getBenutzername().equals(angemeldeterBenutzer.getBenutzername())) {
//				angemeldeterBenutzer = b;					
//			}
//		}
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema themaDatum : angemeldeterBenutzer.pinnwand.themen){
//			themaDatum.hilfsDatum = simple.format(thema.datum);
//		}
//								
//		// Pinnwand wird nach Datum sortiert
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = angemeldeterBenutzer.pinnwand.sortiereNachDatum();
//		
//		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
//		model.addAttribute("profilBenutzer", angemeldeterBenutzer);
//		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
//		model.addAttribute("themen", themenList);
//		model.addAttribute("thema", new Thema());
//		model.addAttribute("benutzer", new Benutzer());
//		return "EigenesProfil";
//	}
//	
//	@RequestMapping(value="/Mitgliederliste")
//	public String getMitgliederliste(Model model){
//		ArrayList<Benutzer> benutzerliste = new ArrayList<Benutzer>();
//		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
//			Benutzer b = (Benutzer) obj;
//			benutzerliste.add(b);
//		}
//		model.addAttribute("benutzer", benutzerliste);
//		return "Benutzerliste";
//	}
//	
//	@RequestMapping(value="/Gruppenliste")
//	public String getGruppenliste(Model model){
//		ArrayList<Gruppe> Gruppenliste = new ArrayList<Gruppe>(); 
//		Gruppe gruppe = new Gruppe();
//		for(Object obj : db.tabelleAusgeben(gruppe.getClass())){
//			Gruppe g = (Gruppe) obj;
//			g.setAnzahlMitglieder(g.anzahl());
//			Gruppenliste.add(g);
//		}
//		
//		model.addAttribute("gruppen", Gruppenliste);
//		return "GruppenListe";
//	}
//	
//	@RequestMapping(value="/eigeneGruppen")
//	public String getEigeneGruppen(Model model){
//		Fachrichtung fachrichtung = new Fachrichtung();
//		ArrayList<Fachrichtung> fachrichtungen = new ArrayList<Fachrichtung>();
//		for(Object obj : db.tabelleAusgeben(fachrichtung.getClass())){
//			Fachrichtung f = (Fachrichtung) obj;
//			fachrichtungen.add(f);
//		}
//		for(Gruppe gruppe : angemeldeterBenutzer.gruppen){
//			gruppe.setAnzahlMitglieder(gruppe.anzahl());
//		}
//		
//		model.addAttribute("fachrichtungen", fachrichtungen);
//		model.addAttribute("gruppen", angemeldeterBenutzer.gruppen);
//		model.addAttribute("gruppe", new Gruppe());
//		return "eigeneGruppenListe";
//	}
//	
//	@RequestMapping(value="/GruppeErstellen", method=RequestMethod.POST)
//	public String gruppeErstellen(@ModelAttribute Gruppe gruppe, Model model){
//		Gruppe neueGruppe = new Gruppe();
//		db.eintragHinzufuegen(neueGruppe.getClass(), neueGruppe);
//		neueGruppe.setName(gruppe.getName());
//		neueGruppe.setKlausurname(gruppe.getKlausurname());
//		angemeldeterBenutzer.gruppen.add(neueGruppe);
//		neueGruppe.mitgliedHinzufuegen(angemeldeterBenutzer);
//		neueGruppe.moderatoren.add(angemeldeterBenutzer);
//		angemeldeterBenutzer.moderierteGruppen.add(neueGruppe);
//		
//		db.eintragAktualisieren(neueGruppe.getClass(), neueGruppe);
//		db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
//		
//		model.addAttribute("gruppen", angemeldeterBenutzer.gruppen);
//		model.addAttribute("gruppe", new Gruppe());
//		return "eigeneGruppenListe";
//	}
//	
//	@RequestMapping(value = "/GruppenBeitreten/{gruppe.gruppen_id}")
//	public String gruppenBeitreten(@PathVariable("gruppe.gruppen_id") int gruppe_id, Model model){
//		Gruppe gruppeBeitreten = new Gruppe();
//		ArrayList<Gruppe> Gruppenliste = new ArrayList<Gruppe>();
//		
//		for(Object obj : db.tabelleAusgeben(gruppeBeitreten.getClass())){
//			Gruppe g = (Gruppe) obj;
//			g.setAnzahlMitglieder(g.anzahl());
//			Gruppenliste.add(g);
//			if(g.getId() == (gruppe_id)) {
//				gruppe = g;
//			}
//		}
//		
//		for(Gruppe gruppe2 : angemeldeterBenutzer.gruppen){
//			if (gruppe2.getId() == gruppe.getId()){
//				model.addAttribute("gruppen", Gruppenliste);
//				model.addAttribute("nachricht", "Sie sind bereits in dieser Gruppe");
//				return "GruppenListe";
//			}
//		}
//		if (angemeldeterBenutzer.gruppeBeitreten(gruppe)){
//			db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
//			db.eintragZusammenfuehren(gruppeBeitreten.getClass(), gruppe);
//			
//			ArrayList<Thema> themenList = new ArrayList<Thema>();
//			themenList = gruppe.pinnwand.sortiereNachDatum();
//			
//			// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//			SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//			for(Thema thema : gruppe.pinnwand.themen){
//				thema.hilfsDatum = simple.format(thema.datum);
//			}
//			
//			model.addAttribute("frage", new Frage());
//		    model.addAttribute("thema", new Thema());
//		    model.addAttribute("themen", themenList);
//		    model.addAttribute("gruppenAnzahl", gruppe.anzahl());
//		    model.addAttribute("gruppe", gruppe);
//			model.addAttribute("nachricht", "Sie sind der Gruppe beitreten");
//			return "GruppenProfil";
//		}
//		else{
//			model.addAttribute("gruppen", Gruppenliste);
//			model.addAttribute("nachricht", "Diese Gruppe ist bereits voll");
//			return "GruppenListe";
//		}
//		
//	}
//	
//	@RequestMapping(value ="/GruppeBeitreten")
//	public String gruppeBeitreten(Model model){
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = gruppe.pinnwand.sortiereNachDatum();
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : gruppe.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		model.addAttribute("frage", new Frage());
//	    model.addAttribute("thema", new Thema());
//	    model.addAttribute("themen", themenList);
//	    model.addAttribute("gruppenAnzahl", gruppe.anzahl());
//	    model.addAttribute("gruppe", gruppe);
//	    
//	    for(Benutzer benutzer : gruppe.mitglieder){
//	    	if(benutzer.getId() == angemeldeterBenutzer.getId()){
//	    		model.addAttribute("nachricht", "Sie sind bereits Mitglied der Gruppe");
//	    		return "GruppenProfil";
//	    	}
//	    }
//		
//	    angemeldeterBenutzer.gruppeBeitreten(gruppe);
//		
//		db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
//		db.eintragZusammenfuehren(gruppe.getClass(), gruppe);
//		
//		model.addAttribute("nachricht", "Sie sind der Gruppe beigetreten");
//		return "GruppenProfil";
//		
//	}
//	
//	@RequestMapping(value = "/GruppeVerlassen")
//	public String gruppeVerlassen(Model model){
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = gruppe.pinnwand.sortiereNachDatum();
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : gruppe.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		model.addAttribute("frage", new Frage());
//	    model.addAttribute("thema", new Thema());
//	    model.addAttribute("themen", themenList);
//	    model.addAttribute("gruppenAnzahl", gruppe.anzahl());
//	    model.addAttribute("gruppe", gruppe);
//	    
//	    for(Benutzer benutzer : gruppe.mitglieder){
//	    	if(benutzer.getId() == angemeldeterBenutzer.getId()){
//	    		angemeldeterBenutzer.gruppeVerlassen(gruppe);
//	    		
//	    		db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
//	    		db.eintragAktualisieren(gruppe.getClass(), gruppe);
//	    		
//	    		model.addAttribute("nachricht", "Sie haben die Gruppe verlassen");
//	    		return "GruppenProfil";
//	    	}
//	    }
//	    model.addAttribute("nachricht", "Sie sind bereits kein Mitglied der Gruppe");
//		
//		return "GruppenProfil";
//	}
//	
//	@RequestMapping(value = "/GruppenPinnwandSortiereLikes")
//	public String gruppenPinnwandSortiereLikes(Model model){
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = gruppe.pinnwand.sortiereNachBewertung();
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : gruppe.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		model.addAttribute("themen", themenList);
//		model.addAttribute("gruppenAnzahl", gruppe.anzahl());
//	    model.addAttribute("gruppe", gruppe);
//		model.addAttribute("frage", new Frage());
//	    model.addAttribute("thema", new Thema());
//	    model.addAttribute("gruppe", gruppe);
//		
//		return "GruppenProfil";
//	}
//	
//	@RequestMapping(value = "/GruppenPinnwandSortiereDatum")
//	public String gruppenPinnwandSortiereDatum(Model model){
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = gruppe.pinnwand.sortiereNachDatum();
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : gruppe.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		model.addAttribute("themen", themenList);
//		model.addAttribute("gruppenAnzahl", gruppe.anzahl());
//	    model.addAttribute("gruppe", gruppe);
//		model.addAttribute("frage", new Frage());
//	    model.addAttribute("thema", new Thema());
//	    model.addAttribute("gruppe", gruppe);
//		
//		return "GruppenProfil";
//	}
//	
//	@RequestMapping(value ="/Loeschen/GruppenProfil/{thema.inhalt_id}")
//	public String loescheGruppenBeitrag(@PathVariable("thema.inhalt_id") int inhalt_id, Model model){
//		Inhalt themaLoeschen = new Thema();
//		for(Object obj : db.tabelleAusgeben(themaLoeschen.getClass())){
//			Thema t = (Thema) obj;
//			if(t.getId() == (inhalt_id)) {
//				// Eintrag aus der Datenbank löschen
//				gruppe.pinnwand.themaEntfernen(t);
//				db.eintragAktualisieren(gruppe.getClass(), gruppe);
//				db.eintragAktualisieren(t.getClass(), t);
//				db.eintragEntfernen(t.getClass(), t.getId());
//			}
//		}
//		for(Object obj : db.tabelleAusgeben(gruppe.getClass())){
//			Gruppe g = (Gruppe) obj;
//			if(g.getId() == (gruppe.getId())) {
//				gruppe = g;
//			}
//		}
//		
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = gruppe.pinnwand.sortiereNachDatum();
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : gruppe.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		model.addAttribute("themen", themenList);
//		model.addAttribute("gruppenAnzahl", gruppe.anzahl());
//	    model.addAttribute("gruppe", gruppe);
//		model.addAttribute("frage", new Frage());
//	    model.addAttribute("thema", new Thema());
//	    model.addAttribute("gruppe", gruppe);
//		
//		return "GruppenProfil";
//	}
//	
//	@RequestMapping(value="/GruppenBeitragSchreiben", method = RequestMethod.POST)
//	public String gruppenBeitragSchreiben(@ModelAttribute Thema thema, Model model){
//		Thema neuesThema = new Thema();
//		db.eintragHinzufuegen(neuesThema.getClass(), neuesThema);
//		neuesThema.setTitel(thema.getTitel());
//		neuesThema.setInhalt(thema.getInhalt());
//		neuesThema.setBenutzer(angemeldeterBenutzer);
//		gruppe.pinnwand.themaHinzufuegen(neuesThema);
//		
//		db.eintragZusammenfuehren(neuesThema.getClass(), neuesThema);
//		db.eintragZusammenfuehren(gruppe.getClass(), gruppe);
//		
//		for(Object obj : db.tabelleAusgeben(gruppe.getClass())){
//			Gruppe g = (Gruppe) obj;
//			if(g.getId() == (gruppe.getId())) {
//				gruppe = g;
//			}
//		}
//		
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = gruppe.pinnwand.sortiereNachDatum();
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema2 : gruppe.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema2.datum);
//		}
//		
//		model.addAttribute("themen", themenList);
//		model.addAttribute("gruppenAnzahl", gruppe.anzahl());
//	    model.addAttribute("gruppe", gruppe);
//		model.addAttribute("frage", new Frage());
//	    model.addAttribute("thema", new Thema());
//	    model.addAttribute("gruppe", gruppe);
//		return "GruppenProfil";
//	}
//	
//	@RequestMapping(value ="/bewertet/GruppenProfil/{thema.inhalt_id}")
//	public String bewerteGruppeProfil(@PathVariable("thema.inhalt_id") int inhalt_id, Model model){
//		// Inhalt wird geliked
//		Inhalt inhalt = new Inhalt();
//		for(Object obj : db.tabelleAusgeben(inhalt.getClass())){
//			Inhalt i = (Inhalt) obj;
//			if(i.getId() == (inhalt_id)) {
//				i.bewerten(true);
//				//Datenbank wird aktualisiert
//				db.eintragAktualisieren(i.getClass(), i);
//			}
//		}
//		
//		for(Object obj : db.tabelleAusgeben(gruppe.getClass())){
//			Gruppe g = (Gruppe) obj;
//			if(g.getId() == (gruppe.getId())) {
//				gruppe = g;
//			}
//		}
//		
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = gruppe.pinnwand.sortiereNachDatum();
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : gruppe.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		model.addAttribute("themen", themenList);
//		model.addAttribute("gruppenAnzahl", gruppe.anzahl());
//	    model.addAttribute("gruppe", gruppe);
//		model.addAttribute("frage", new Frage());
//	    model.addAttribute("thema", new Thema());
//	    model.addAttribute("gruppe", gruppe);
//		return "GruppenProfil";
//	}
//	
//	@RequestMapping(value = "/GruppenProfil/{gruppe.gruppen_id}", method =RequestMethod.GET)
//	public String gruppenProfilAnzeigen(@PathVariable("gruppe.gruppen_id") int gruppe_id, Model model){
//		Gruppe hilfsGruppe = new Gruppe();
//		for(Object obj : db.tabelleAusgeben(hilfsGruppe.getClass())){
//			Gruppe g = (Gruppe) obj;
//			if(g.getId() == (gruppe_id)) {
//				gruppe = g;
//			}
//		}
//		
//		ArrayList<Thema> themenList = new ArrayList<Thema>();
//		themenList = gruppe.pinnwand.sortiereNachDatum();
//		
//		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
//		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
//		for(Thema thema : gruppe.pinnwand.themen){
//			thema.hilfsDatum = simple.format(thema.datum);
//		}
//		
//		model.addAttribute("themen", themenList);
//		model.addAttribute("gruppenAnzahl", gruppe.anzahl());
//	    model.addAttribute("gruppe", gruppe);
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
//		db.eintragZusammenfuehren(neueFrage.getClass(), neueFrage);
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
//		db.eintragZusammenfuehren(neueFrage.getClass(), neueFrage);
//		gruppe.getFragenpool().addFrage(neueFrage);
//		//Datenbank wird aktualisiert
//		db.eintragZusammenfuehren(gruppe.getFragenpool().getClass(), gruppe.getFragenpool());
//		db.eintragZusammenfuehren(gruppe.getClass(), gruppe);
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
//	@RequestMapping(value = "/questBeenden")
//	public String questBeenden(@ModelAttribute Frage frage, Model model){
//		System.out.println("questBeenden-Methode");
//		ArrayList<String> zwischenSpeicherAntworten = frage.getZwischenSpeicherAntworten();
//		Frage mryFrage = new Frage();
//		for (String s:zwischenSpeicherAntworten){
//			String[] result; 
//			result = s.split(";!!;!");
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
//		int punkte = quest.korrigiere();
//		mryFrage.getAntworten().clear();
//		db.eintragZusammenfuehren(mryFrage.getClass(), mryFrage);
//			
//		model.addAttribute("frage", new Frage());
//		model.addAttribute("thema", new Thema());
//	    model.addAttribute("gruppe", gruppe);
//	    System.out.println("jetzt hier");
//	    System.out.println(punkte);
//	    return "GruppenProfil";
//	}
//	
//	@RequestMapping (value = "/medium", method = RequestMethod.GET)
//	public String getForm(Model model) {
//		Medium mediumModel = new Medium();
//		model.addAttribute("medium", mediumModel);
//		return "medium";
//	}
//	
//	@RequestMapping (value = "/medium", method = RequestMethod.POST)
//	public String mediumHochladen(Model model, Medium medium, BindingResult result, HttpServletRequest request) {
//		String ergebnisStatus = "erfolgmedium";
//		
//		if(result.hasErrors()){
//			ergebnisStatus = "medium";
//		}
//		else{
//			MultipartFile multipartMedium = medium.getFile();
//			
//			ServletContext context = request.getServletContext();
//	        String projektPfad = context.getRealPath("");
//	        String [] pfad = projektPfad.split("Kaepsele");
//			String orgName = multipartMedium.getOriginalFilename();
//			String speicherort = pfad[0] + "/Kaepsele/SoftwarePraktikum/Challenge uploads/" + orgName;
//			File desk = new File(speicherort);
//			
//			try{
//				multipartMedium.transferTo(desk);
//			}
//			catch(IllegalStateException | IOException e){
//				e.printStackTrace();
//			}
//		}
//		return ergebnisStatus;
//	}
//	
//	@RequestMapping(value = "/mediumrunterladen", method = RequestMethod.GET)
//	public @ResponseBody void mediumRunterladen(HttpServletRequest request, HttpServletResponse response) {
//		
//		ServletContext context = request.getServletContext();
//        String projektPfad = context.getRealPath("");
//        String [] pfad = projektPfad.split("Kaepsele");
//        String mediumPfad = pfad[0] + "/Kaepsele/SoftwarePraktikum/Challenge uploads/Entwurf.pdf";
//
//		File ladeMedium = new File(mediumPfad);
//		FileInputStream inputStream = null;
//		OutputStream outStream = null;
//		
//		try {
//			inputStream = new FileInputStream(ladeMedium);		
// 
//			String headerKey = "Content-Disposition";
//			String headerValue = String.format("attachment; filename=\"%s\"",ladeMedium.getName());
//			response.setHeader(headerKey, headerValue);
// 
//			outStream = response.getOutputStream();
//			IOUtils.copy(inputStream, outStream);
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		} 
//		finally {
//			try {
//				if (null != inputStream)
//					inputStream.close();
//				if (null != inputStream)
//					outStream.close();
//			} 
//			catch (IOException e) {
//				e.printStackTrace();
//			}
// 
//		}
//	}
//}