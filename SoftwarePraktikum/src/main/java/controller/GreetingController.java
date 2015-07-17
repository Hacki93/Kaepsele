package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learning.Benutzer;
import learning.Gruppe;
import learning.Inhalt;
import learning.Medium;
import learning.Thema;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import datenhaltung.Datenbank;

@Controller
public class GreetingController {
	
	Datenbank db;
	Benutzer angemeldeterBenutzer;
	Benutzer profilBenutzer;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String greeting(Model model) {
	    db = new Datenbank();
	    
	    // dem model wird ein Benutzer hinzugefügt, falls sich jemand neu registriert
	    model.addAttribute("benutzer", new Benutzer());
		return "Startseite";
	}
	
	@RequestMapping(value= "/loginseite")
	public String zumLogin(Model model){
		// dem model wird ein Benutzer hinzugeügt, damit die Logindaten abgefragt werden können
	model.addAttribute("benutzer", new Benutzer());
		return "Anmelden";
	}
	
	@RequestMapping(value="/registriert", method=RequestMethod.POST)
	public String registrieren(@ModelAttribute Benutzer benutzer, Model model){
		// Bei der Registrierung wird überprüft ob der Benutzername bereits vergeben ist
		for(Object obj : db.tabelleAusgeben(benutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if (benutzer.benutzername.equals(b.benutzername)){
				model.addAttribute("nachricht", "Dieser Benutzername ist bereits vergeben");
				return "Startseite";
			}
		}
		
		// neuer Benutzer instanziert und in der Datenbank angelegt
		Benutzer neuerBenutzer = new Benutzer();
		db.eintragHinzufuegen(neuerBenutzer.getClass(), neuerBenutzer);
		
		// Erste Attribute des Benutzers werden erstellt und in der Datenbank aktualisiert
		neuerBenutzer.setBenutzername(benutzer.getBenutzername());
		neuerBenutzer.setPasswort(Benutzer.hashPasswort(benutzer.getPasswort()));
		neuerBenutzer.setEmailAdresse(benutzer.getEmailAdresse());
		neuerBenutzer.setName(benutzer.name);
		db.eintragAktualisieren(neuerBenutzer.getClass(), neuerBenutzer);
		
		model.addAttribute("nachricht", "Sie sind jetzt registriert");
		return "Anmelden";
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Benutzer benutzer, Model model){
		// Beim login wird nach nicht vorhandenem Benutzername und falschem Passwort geprüft
		for(Object obj : db.tabelleAusgeben(benutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(benutzer.getBenutzername())) {
				if(b.login(benutzer.getPasswort())){
					// Der angemeldete Benutzer wird gesetzt
					angemeldeterBenutzer = b;
					return "Menu";
				}
				model.addAttribute("nachricht", "Passwort falsch");
				return "Anmelden";
			}
		}
		model.addAttribute("nachricht", "Benutzername nicht vorhanden");
		return "Anmelden";
	}
	
	@RequestMapping(value="/profil")
	public String eigenesProfil(Model model){
		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : angemeldeterBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
		
		// Pinnwand wird nach Datum sortiert
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = angemeldeterBenutzer.pinnwand.sortiereNachDatum();
		
		// Benutzer geht auf sein eigenes Profil hierbei müssen seine
		// persönlichen Angaben und Pinnwand dem model hinzugefügt werden,
		// damit diese angegezeigt werden
		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
		model.addAttribute("themen", themenList);
		return "EigenesProfil";
	}
	
	@RequestMapping(value="/profil/{benutzername}", method=RequestMethod.GET)
	public String getProfil(@PathVariable("benutzername") String benutzername, Model model){
		// Es wird die Profilseite eines anderen Benutzers aufgerufen
		Benutzer benutzer = new Benutzer();
		for(Object obj : db.tabelleAusgeben(benutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(benutzername)) {
				// der Profilbenutzer wird gesetzt
				profilBenutzer = b;	
				
				// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
				for(Thema thema : profilBenutzer.pinnwand.themen){
					thema.hilfsDatum = simple.format(thema.datum);
				}
				
				// Pinnwand wird nach Datum sortiert
				ArrayList<Thema> themenList = new ArrayList<Thema>();
				themenList = profilBenutzer.pinnwand.sortiereNachDatum();
				
				// dem Model müssen die Daten des ProfilBenutzer übergeben werden,
				// damit diese angezeigt werden können
				model.addAttribute("themen", themenList);
				model.addAttribute("profilBenutzer", profilBenutzer);
				model.addAttribute("rang", profilBenutzer.getRangName());
				model.addAttribute("thema", new Thema());
			}
		}
		return "Profil";
	}
	@RequestMapping(value="/sortiereLikes/eigenesProfil")
	public String sortiereLikesEigenesProfil(Model model){
		// die Pinnwand wird nach Likes sortiert
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = angemeldeterBenutzer.pinnwand.sortiereNachBewertung();
				
		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : angemeldeterBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
				
		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
		model.addAttribute("themen", themenList);
		return "EigenesProfil";
	}
	
	@RequestMapping(value="/sortiereLikes")
	public String sortiereLikes(Model model){
		// die Pinnwand wird nach Likes sortiert
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = profilBenutzer.pinnwand.sortiereNachBewertung();
		
		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : profilBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
		
		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
		model.addAttribute("themen", themenList);
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		model.addAttribute("thema", new Thema());
		return "Profil";
	}
	
	@RequestMapping(value="/sortierDatum/eigenesProfil")
	public String sortierDatumEigenesProfil(Model model){
		// die Pinnwand wird nach Datum sortiert
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = angemeldeterBenutzer.pinnwand.sortiereNachDatum();
				
		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : angemeldeterBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
		
		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
		model.addAttribute("themen", themenList);
		return "EigenesProfil";		
	}
	
	@RequestMapping(value="/sortierDatum")
	public String sortierDatum(Model model){
		// die Pinnwand wird nach Datum sortiert
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
		
		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : profilBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
		
		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
		model.addAttribute("themen", themenList);
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		model.addAttribute("thema", new Thema());
		return "Profil";
	}
	
	@RequestMapping(value="/hinzufuegen")
	public String freundHizufuegen(Model model){
		// angemeldeterBenutzer und profilBenutzer werden aktualisiert
		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(angemeldeterBenutzer.getBenutzername())) {
				angemeldeterBenutzer = b;
			}	
			if(b.getBenutzername().equals(profilBenutzer.getBenutzername())){
				profilBenutzer = b;	
			}
		}
		
		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : profilBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
		
		// Pinnwand wird nach Datum sortiert
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
		
		// Überprüfung ob der profilBenutzer bereits ein freund ist
		for(Benutzer benutzer : angemeldeterBenutzer.freunde){
			if(benutzer.getId() == profilBenutzer.getId()){
				// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
				model.addAttribute("themen", themenList);
				model.addAttribute("profilBenutzer", profilBenutzer);
				model.addAttribute("rang", profilBenutzer.getRangName());
				model.addAttribute("thema", new Thema());
				model.addAttribute("nachricht", "Benutzer ist bereits ein Freund");
				return "Profil";
			}
		}
		
		// profilBenutzer wird der Freundesliste hinzugefügt
		angemeldeterBenutzer.freundHinzufuegen(profilBenutzer);
		
		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
		model.addAttribute("themen", themenList);
		model.addAttribute("nachricht", "Benutzer wurde als Freund hinzugefügt");
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		model.addAttribute("thema", new Thema());
		
		// die Datenbank wird aktualisiert
		db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
		db.eintragAktualisieren(profilBenutzer.getClass(), profilBenutzer);
		return "Profil";
	}
	
	@RequestMapping(value="/entfernen")
	public String freundEntfernen(Model model){
		// Pinnwand wird nach Datum sortiert
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
		
		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : profilBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
		
		// Überprüfung ob sich der profilBenutzer in der Freundesliste befindet
		for(Benutzer benutzer : angemeldeterBenutzer.freunde){
			if(benutzer.getId() == profilBenutzer.getId()){
				// Freund wird entfernt
				angemeldeterBenutzer.freundEntfernen(benutzer);
				
				// Datenbank wird aktualisiert
				db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
				
				// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
				model.addAttribute("themen", themenList);
				model.addAttribute("profilBenutzer", profilBenutzer);
				model.addAttribute("rang", profilBenutzer.getRangName());
				model.addAttribute("thema", new Thema());
				model.addAttribute("nachricht", "Freund wurde entfernt");
				return "Profil";
			}
		}

		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
		model.addAttribute("themen", themenList);
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		model.addAttribute("thema", new Thema());
		model.addAttribute("nachricht", "Benutzer ist kein Freund");
		return "Profil";
	}
	
	@RequestMapping(value="/bewertet/eigenesProfil/{thema.inhalt_id}")
	public String erhoeheLikeEigenesProfil(@PathVariable("thema.inhalt_id") int inhalt_id, Model model){
		// Inhalt wird geliked
		Inhalt inhalt = new Inhalt();
		for(Object obj : db.tabelleAusgeben(inhalt.getClass())){
			Inhalt i = (Inhalt) obj;
			if(i.getId() == (inhalt_id)) {
				i.bewerten(true);
				//Datenbank wird aktualisiert
				db.eintragAktualisieren(i.getClass(), i);
			}
		}
		
		// angemeldeterBenutzer wird aktualisiert
		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(angemeldeterBenutzer.getBenutzername())) {
				angemeldeterBenutzer = b;					
			}
		}
				
		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : angemeldeterBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
				
		// Pinnwand wird nach Datum sortiert
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = angemeldeterBenutzer.pinnwand.sortiereNachDatum();
				
		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
		model.addAttribute("themen", themenList);
		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
		return "EigenesProfil";
	}
	
	@RequestMapping(value="/bewertet/{thema.inhalt_id}")
	public String erhoeheLike(@PathVariable("thema.inhalt_id") int inhalt_id, Model model){
		
		// Inhalt wird geliked
		Inhalt inhalt = new Inhalt();
		for(Object obj : db.tabelleAusgeben(inhalt.getClass())){
			Inhalt i = (Inhalt) obj;
			if(i.getId() == (inhalt_id)) {
				i.bewerten(true);
				//Datenbank wird aktualisiert
				db.eintragAktualisieren(i.getClass(), i);
			}
		}
		
		// profilBenutzer wird aktualisiert
		for(Object obj : db.tabelleAusgeben(profilBenutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(profilBenutzer.getBenutzername())) {
				profilBenutzer = b;					
			}
		}
		
		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : profilBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
		
		// Pinnwand wird nach Datum sortiert
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
		
		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
		model.addAttribute("themen", themenList);
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		model.addAttribute("thema", new Thema());
		return "Profil";
	}
	
	@RequestMapping(value="/themaLoeschen/{thema.inhalt_id}")
	public String themaLoeschen(@PathVariable("thema.inhalt_id") int inhalt_id, Model model){
		Inhalt themaLoeschen = new Thema();
		for(Object obj : db.tabelleAusgeben(themaLoeschen.getClass())){
			Thema t = (Thema) obj;
			if(t.getId() == (inhalt_id)) {
				// Eintrag aus der Datenbank löschen
				angemeldeterBenutzer.pinnwand.themaEntfernen(t);
				db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
				db.eintragAktualisieren(t.getClass(), t);
				
				db.eintragEntfernen(t.getClass(), t.getId());
				
			}
		}
		
		// angemeldeterBenutzer wird aktualisiert
		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(angemeldeterBenutzer.getBenutzername())) {
				angemeldeterBenutzer = b;					
			}
		}
						
		// Das Datum der Pinnwandbeiträge wird auf die Minute genau formatiert
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : angemeldeterBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
						
		// Pinnwand wird nach Datum sortiert
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = angemeldeterBenutzer.pinnwand.sortiereNachDatum();
						
		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
		model.addAttribute("themen", themenList);
		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
		return "EigenesProfil";
	}
	
	@RequestMapping(value="/beitragSchreiben", method = RequestMethod.POST)
	public String beitragSchreiben(@ModelAttribute Thema thema, Model model){
		// profilBenutzer wird aktualisiert
		for(Object obj : db.tabelleAusgeben(profilBenutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(profilBenutzer.getBenutzername())) {
				profilBenutzer = b;	
			}
		}
		
		// angemeldeterBenutzer wird aktualisiert
		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(angemeldeterBenutzer.getBenutzername())) {
				angemeldeterBenutzer = b;					
			}
		}
	
		Thema neuesThema = new Thema();
		db.eintragHinzufuegen(neuesThema.getClass(), neuesThema);
		neuesThema.setTitel(thema.getTitel());
		neuesThema.setInhalt(thema.getInhalt());
		neuesThema.setBenutzer(angemeldeterBenutzer);
		profilBenutzer.pinnwand.themaHinzufuegen(neuesThema);
		db.eintragAktualisieren(neuesThema.getClass(), neuesThema);
		
		// dem Model werden alle wichtigen Daten zur Darstellung der Seite übergeben
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		model.addAttribute("themen", profilBenutzer.pinnwand.themen);
		model.addAttribute("thema", new Thema());
		
		return "Profil";
	}
	
	@RequestMapping(value="/Mitgliederliste")
	public String getMitgliederliste(Model model){
		ArrayList<Benutzer> benutzerliste = new ArrayList<Benutzer>();
		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			benutzerliste.add(b);
		}
		model.addAttribute("benutzer", benutzerliste);
		return "Benutzerliste";
	}
	
	@RequestMapping(value="/Gruppenliste")
	public String getGruppenliste(Model model){
		ArrayList<Gruppe> Gruppenliste = new ArrayList<Gruppe>(); 
		Gruppe gruppe = new Gruppe();
		for(Object obj : db.tabelleAusgeben(gruppe.getClass())){
			Gruppe g = (Gruppe) obj;
			g.setAnzahlMitglieder(g.anzahl());
			Gruppenliste.add(g);
		}
		
		model.addAttribute("gruppen", Gruppenliste);
		return "GruppenListe";
	}
	
	@RequestMapping(value="/eigeneGruppen")
	public String getEigeneGruppen(Model model){
		return "eigeneGruppenListe";
	}
	
	@RequestMapping (value = "/medium", method = RequestMethod.GET)
	public String getForm(Model model) {
		Medium mediumModel = new Medium();
		model.addAttribute("medium", mediumModel);
		return "medium";
	}
	
	@RequestMapping (value = "/medium", method = RequestMethod.POST)
	public String mediumHochladen(Model model, Medium medium, BindingResult result, HttpServletRequest request) {
		String ergebnisStatus = "erfolgmedium";
		
		if(result.hasErrors()){
			ergebnisStatus = "medium";
		}
		else{
			MultipartFile multipartMedium = medium.getFile();
			
			ServletContext context = request.getServletContext();
	        String projektPfad = context.getRealPath("");
	        String [] pfad = projektPfad.split("Kaepsele");
			String orgName = multipartMedium.getOriginalFilename();
			String speicherort = pfad[0] + "/Kaepsele/SoftwarePraktikum/Challenge uploads/" + orgName;
			File desk = new File(speicherort);
			
			try{
				multipartMedium.transferTo(desk);
			}
			catch(IllegalStateException | IOException e){
				e.printStackTrace();
			}
		}
		return ergebnisStatus;
	}
	
	@RequestMapping(value = "/mediumrunterladen", method = RequestMethod.GET)
	public @ResponseBody void mediumRunterladen(HttpServletRequest request, HttpServletResponse response) {
		
		ServletContext context = request.getServletContext();
        String projektPfad = context.getRealPath("");
        String [] pfad = projektPfad.split("Kaepsele");
        String mediumPfad = pfad[0] + "/Kaepsele/SoftwarePraktikum/Challenge uploads/Entwurf.pdf";

		File ladeMedium = new File(mediumPfad);
		FileInputStream inputStream = null;
		OutputStream outStream = null;
		
		try {
			inputStream = new FileInputStream(ladeMedium);		
 
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",ladeMedium.getName());
			response.setHeader(headerKey, headerValue);
 
			outStream = response.getOutputStream();
			IOUtils.copy(inputStream, outStream);
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (null != inputStream)
					inputStream.close();
				if (null != inputStream)
					outStream.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
 
		}
	}
}