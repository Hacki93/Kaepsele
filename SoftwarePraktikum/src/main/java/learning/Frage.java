package learning;

import java.util.ArrayList;

public class Frage {
	public int punktzahl; 
	public Benutzer ersteller;
	public ArrayList<Medium> anhang; 
	public int id;
	public String titel; 
	public String text;
	
	
	public int getPunktzahl() {
		return punktzahl;
	}
	
	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}
	
	public Benutzer getErsteller() {
		return ersteller;
	}
	
	public void setErsteller(Benutzer ersteller) {
		this.ersteller = ersteller;
	}
	
	public ArrayList<Medium> getAnhang() {
		return anhang;
	}
	
	public void setAnhang(ArrayList<Medium> anhang) {
		this.anhang = anhang;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitel() {
		return titel;
	}
	
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	} 

}
