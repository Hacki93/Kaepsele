package controller;

import learning.Benutzer;
import learning.Frage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import datenhaltung.Datenbank;

@Controller
public class LenasController {
	Datenbank db;
	Benutzer angemeldeterBenutzer;
	Benutzer profilBenutzer;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String greeting(Model model) {
	    db = new Datenbank();
	    model.addAttribute("frage", new Frage());
		return "GruppenProfil";
	}
	
	@RequestMapping(value = "/frageErst", method=RequestMethod.POST)
	public String frageErstellen(@ModelAttribute Frage frage, Model model){
		System.out.println("Frage erstellt");
		System.out.println(frage.getText());
		for (String s: frage.getAntwortmoeglichkeiten()){
			System.out.println(s);
		}
		for (String s:frage.getLoesung()){
			System.out.println("Lösung: ");
			System.out.println(s);
		}
		return "Startseite";
	}
	
	
}
