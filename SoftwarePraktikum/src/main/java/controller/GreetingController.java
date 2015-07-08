package controller;

import learning.Benutzer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import datenhaltung.Datenbank;

@Controller
public class GreetingController {
	
	Datenbank db;
	Benutzer angemeldeterBenutzer;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String greeting( Model model) {
	    db = new Datenbank();
		model.addAttribute("benutzer", new Benutzer());
		return "index";
	}
	
	@RequestMapping(value= "/medium", method = RequestMethod.POST)
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
				return "index";
			}
		}
		System.out.println("Benutzer nicht gefunden");
		return "index";
	}
}