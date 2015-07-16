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
	    model.addAttribute("benutzer", new Benutzer());
		return "Startseite";
	}
	
	@RequestMapping(value= "/loginseite")
	public String zumLogin(Model model){
	model.addAttribute("benutzer", new Benutzer());
		return "Anmelden";
	}
	
	@RequestMapping(value="/registriert", method=RequestMethod.POST)
	public String registrieren(@ModelAttribute Benutzer benutzer, Model model){
		Benutzer neuerBenutzer = new Benutzer();
		System.out.println(benutzer.getBenutzername());
		for(Object obj : db.tabelleAusgeben(benutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if (benutzer.benutzername.equals(b.benutzername)){
				model.addAttribute("nachricht", "Dieser Benutzername ist bereits vergeben");
				return "Startseite";
			}
		}
		
		db.eintragHinzufuegen(neuerBenutzer.getClass(), neuerBenutzer);
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
		for(Object obj : db.tabelleAusgeben(benutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(benutzer.getBenutzername())) {
				if(b.login(benutzer.getPasswort())){
					angemeldeterBenutzer = b;
					return "index2";
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
		model.addAttribute("angemeldeterBenutzer", angemeldeterBenutzer);
		model.addAttribute("rang", angemeldeterBenutzer.getRangName());
		model.addAttribute("themen", angemeldeterBenutzer.pinnwand.themen);
		return "EigenesProfil";
	}
	
	@RequestMapping(value="/Profile/{benutzername}", method=RequestMethod.GET)
	public String getProfil(@PathVariable("benutzername") String benutzername, Model model){
		Benutzer benutzer = new Benutzer();
		for(Object obj : db.tabelleAusgeben(benutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(benutzername)) {
				profilBenutzer = b;	
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
				for(Thema thema : profilBenutzer.pinnwand.themen){
					thema.hilfsDatum = simple.format(thema.datum);
				}
				ArrayList<Thema> themenList = new ArrayList<Thema>();
				themenList = profilBenutzer.pinnwand.sortiereNachDatum();
				model.addAttribute("themen", themenList);
				model.addAttribute("profilBenutzer", profilBenutzer);
				model.addAttribute("rang", profilBenutzer.getRangName());
				model.addAttribute("thema", new Thema());
			}
		}
		return "Profile";
	}
	
	@RequestMapping(value="/sortiereLikes")
	public String sortiereLikes(Model model){
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = profilBenutzer.pinnwand.sortiereNachBewertung();
		model.addAttribute("themen", themenList);
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		return "Profile";
	}
	
	@RequestMapping(value="/sortierDatum")
	public String sortierDatum(Model model){
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
		model.addAttribute("themen", themenList);
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		return "Profile";
	}
	
	@RequestMapping(value="/hinzufuegen")
	public String freundHizufuegen(Model model){
		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(angemeldeterBenutzer.getBenutzername())) {
				angemeldeterBenutzer = b;
			}	
			if(b.getBenutzername().equals(profilBenutzer.getBenutzername())){
				profilBenutzer = b;	
			}
		}
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : profilBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
		
		for(Benutzer benutzer : angemeldeterBenutzer.freunde){
			if(benutzer.getId() == profilBenutzer.getId()){
				ArrayList<Thema> themenList = new ArrayList<Thema>();
				themenList = profilBenutzer.pinnwand.sortiereNachDatum();
				model.addAttribute("themen", themenList);
				model.addAttribute("nachricht", "Benutzer ist bereits ein Freund");
				model.addAttribute("profilBenutzer", profilBenutzer);
				model.addAttribute("rang", profilBenutzer.getRangName());
				return "Profile";
			}
		}
		
		angemeldeterBenutzer.freundHinzufuegen(profilBenutzer);
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
		model.addAttribute("themen", themenList);
		model.addAttribute("nachricht", "Benutzer wurde als Freund hinzugefügt");
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
		db.eintragAktualisieren(profilBenutzer.getClass(), profilBenutzer);
		return "Profile";
	}
	
	@RequestMapping(value="/entfernen")
	public String freundEntfernen(Model model){
		for(Benutzer benutzer : angemeldeterBenutzer.freunde){
			if(benutzer.getId() == profilBenutzer.getId()){
				angemeldeterBenutzer.freundEntfernen(benutzer);
				db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
				ArrayList<Thema> themenList = new ArrayList<Thema>();
				themenList = profilBenutzer.pinnwand.sortiereNachDatum();
				model.addAttribute("themen", themenList);
				model.addAttribute("profilBenutzer", profilBenutzer);
				model.addAttribute("rang", profilBenutzer.getRangName());
				model.addAttribute("nachricht", "Freund wurde entfernt");
				return "Profile";
			}
		}
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
		model.addAttribute("themen", themenList);
		model.addAttribute("nachricht", "Benutzer ist kein Freund");
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		return "Profile";
	}
	
	@RequestMapping(value="/bewertet/{thema.inhalt_id}")
	public String erhoeheLike(@PathVariable("thema.inhalt_id") int inhalt_id, Model model){
		Inhalt inhalt = new Inhalt();
		for(Object obj : db.tabelleAusgeben(inhalt.getClass())){
			Inhalt i = (Inhalt) obj;
			if(i.getId() == (inhalt_id)) {
				i.bewerten(true);
				db.eintragAktualisieren(i.getClass(), i);
			}
		}
		
		for(Object obj : db.tabelleAusgeben(profilBenutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(profilBenutzer.getBenutzername())) {
				profilBenutzer = b;					
			}
		}
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm");
		for(Thema thema : profilBenutzer.pinnwand.themen){
			thema.hilfsDatum = simple.format(thema.datum);
		}
		ArrayList<Thema> themenList = new ArrayList<Thema>();
		themenList = profilBenutzer.pinnwand.sortiereNachDatum();
		model.addAttribute("themen", themenList);
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		return "Profile";
	}
	
//	@RequestMapping(value="/beitrag", method = RequestMethod.GET)
//	public String beitragSeite(Model model){
//		Thema beitrag = new Thema();
//		model.addAttribute("beitrag", beitrag);
//		db.eintragHinzufuegen(beitrag.getClass(), beitrag);
//		return "BeitragSchreiben";
//	}
	
	@RequestMapping(value="/beitragSchreiben", method = RequestMethod.POST)
	public String beitragSchreiben(@ModelAttribute Thema thema, Model model){
		System.out.println(thema.getTitel()); 
		System.out.println(thema.getInhalt());
		
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		model.addAttribute("themen", profilBenutzer.pinnwand.themen);
		
		return "Profile";
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