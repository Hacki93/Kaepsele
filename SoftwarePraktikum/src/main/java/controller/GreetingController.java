package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learning.Benutzer;
import learning.Medium;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import datenhaltung.Datenbank;

@Controller
public class GreetingController {
	
	Datenbank db;
	Benutzer angemeldeterBenutzer;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String greeting( Model model) {
	    db = new Datenbank();
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
					System.out.println("Angemeldet");
					return "Startseite";
				}
				System.out.println("Passwort falsch");
				return "Anmelden";
			}
		}
		System.out.println("Benutzer nicht gefunden");
		return "Anmelden";
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