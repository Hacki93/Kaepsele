package learning;

import java.util.ArrayList;
import java.util.Date;

public class Bossfight extends Challenge {
	private Medium anhang;
	private ArrayList<String> antworten;
	
	public Bossfight(Benutzer bearbeiter, Medium anhang, int erreichbarePunktzahl){
		this.bearbeiter = bearbeiter; 
		this.anhang = anhang; 
		this.erreichbarePunktzahl = erreichbarePunktzahl;
		datum = new Date();
		antworten = new ArrayList<String>();
	}

	public Medium getAnhang() {
		return anhang;
	}

	
	public Medium starten(){
		return anhang;
	}
	
	public void addAntwort(String antwort){
		antworten.add(antwort);
	}
	
	public void korrigieren(int punktzahl){
		erreichtePunktzahl = erreichtePunktzahl + punktzahl;
	}
	
	public void beenden(){
		
	}
	public boolean bestanden(){
		if (erreichtePunktzahl >= (0.8 * this.erreichbarePunktzahl)){
			return true;
		}
		else{
			return false;
		}
	}

}
