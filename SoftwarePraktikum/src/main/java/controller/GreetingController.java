package controller;

import learning.Benutzer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String greeting( Model model) {
		model.addAttribute("benutzer", new Benutzer());
		return "index";
	}
	
	@RequestMapping(value= "/medium", method = RequestMethod.POST)
	public String login(@ModelAttribute Benutzer benutzer, Model model){
//		benutzer.login())
	}
}
