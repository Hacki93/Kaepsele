package learning;

import java.util.ArrayList;
import java.util.Date;

public class Bossfight extends Challenge {
	private Medium anhang;
	private ArrayList<String> antworten;
	
	public Bossfight(Benutzer bearbeiter, Medium anhang, int punktzahl){
		this.bearbeiter = bearbeiter; 
		this.anhang = anhang; 
		this.erreichtePunktzahl = punktzahl;
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
	
	public void korrigieren(){
		
	}
	
	public boolean bestanden(){
		if (this.korrigiere() > (0.8 * this.erreichtePunktzahl)){
			return true;
		}
		else{
			return false;
		}
	}

}
