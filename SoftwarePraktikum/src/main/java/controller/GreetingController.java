package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
		return "Startseite";
	}
	
	@RequestMapping(value= "/loginseite")
	public String zumLogin(Model model){
	model.addAttribute("benutzer", new Benutzer());
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
	
	@RequestMapping(value="/Profile/{benutzername}")
	public String getProfil(@PathVariable("benutzername") String benutzername, Model model){
		Benutzer benutzer = new Benutzer();
		for(Object obj : db.tabelleAusgeben(benutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if(b.getBenutzername().equals(benutzername)) {
				profilBenutzer = b;	
				System.out.println(profilBenutzer);
				System.out.println(b);
				model.addAttribute("profilBenutzer", profilBenutzer);
				model.addAttribute("rang", profilBenutzer.getRangName());
				model.addAttribute("themen", profilBenutzer.pinnwand.themen);	
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
	
	@RequestMapping(value="/hinzufuegen")
	public String freundHizufuegen(Model model){
		for(Benutzer benutzer : angemeldeterBenutzer.freunde){
			if(benutzer.getId() == profilBenutzer.getId()){
				model.addAttribute("nachricht", "Benutzer ist bereits ein Freund");
				model.addAttribute("profilBenutzer", profilBenutzer);
				model.addAttribute("rang", profilBenutzer.getRangName());
				model.addAttribute("themen", profilBenutzer.pinnwand.themen);
				return "Profile";
			}
		}
		for(Object obj : db.tabelleAusgeben(angemeldeterBenutzer.getClass())){
			Benutzer b = (Benutzer) obj;
			if (b.getId() == profilBenutzer.getId()){
				System.out.println("Test");
				angemeldeterBenutzer.freundHinzufuegen(b);
			}
		}
		db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
		model.addAttribute("nachricht", "Benutzer wurde als Freund hinzugefügt");
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		model.addAttribute("themen", profilBenutzer.pinnwand.themen);
		return "Profile";
	}
	
	@RequestMapping(value="/entfernen")
	public String freundEntfernen(Model model){
		for(Benutzer benutzer : angemeldeterBenutzer.freunde){
			if(benutzer.getId() == profilBenutzer.getId()){
				angemeldeterBenutzer.freundEntfernen(benutzer);
				db.eintragAktualisieren(angemeldeterBenutzer.getClass(), angemeldeterBenutzer);
				model.addAttribute("profilBenutzer", profilBenutzer);
				model.addAttribute("rang", profilBenutzer.getRangName());
				model.addAttribute("themen", profilBenutzer.pinnwand.themen);
				model.addAttribute("nachricht", "Freund wurde entfernt");
				return "Profile";
			}
		}
		model.addAttribute("nachricht", "Benutzer ist kein Freund");
		model.addAttribute("profilBenutzer", profilBenutzer);
		model.addAttribute("rang", profilBenutzer.getRangName());
		model.addAttribute("themen", profilBenutzer.pinnwand.themen);
		return "Profile";
	}
	
	@RequestMapping(value="/bewertet/{thema.inhalt_id}")
	public String erhoeheLike(@PathVariable("thema.inhalt_id") int thema_id, Model model){
		System.out.println("test");
		Inhalt inhalt = new Inhalt();
		for(Object obj : db.tabelleAusgeben(inhalt.getClass())){
			Thema t = (Thema) obj;
			if(t.getId() == (thema_id)) {
				t.bewerten(true);
			}
		}
		db.eintragAktualisieren(inhalt.getClass(), inhalt);
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