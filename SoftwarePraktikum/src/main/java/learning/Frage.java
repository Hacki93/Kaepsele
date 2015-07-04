package learning;


import java.util.ArrayList;


public class Frage{
	public static final int punktzahl = 3; 
	public ArrayList<Medium> anhang; 
	public int id;
	public String titel; 
	public String text;
	public ArrayList<String> antworten; 
	public int loesung; 
	
public Frage(){}

public Frage(String titel, String text, int loesung){
	this.titel = titel; 
	this.text = text; 
	this.loesung = loesung;
	
	antworten = new ArrayList<String>();
	anhang = new ArrayList<Medium>();
		
}


public ArrayList<String> getAntworten(){
	return antworten;
}

public void addAntworten(String antwort){
	antworten.add(antwort);
}

public int korrigiere(int antwort){
	if (antwort == this.loesung){
		return punktzahl;
	}
	else {
		return 0;
	}
}

public int getLoesung(){
	return loesung;
}
}

