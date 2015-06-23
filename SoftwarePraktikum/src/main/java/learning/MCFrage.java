package learning;

import java.util.ArrayList;

public class MCFrage extends Frage {
public ArrayList<String> antworten; 
public int loesung; 

public MCFrage(Benutzer ersteller, String titel, String text, int loesung){
	this.ersteller = ersteller;
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

public int getLösung(){
	return loesung;
}


public int korrigiere(int antwort){
	if (antwort == this.loesung){
		return punktzahl;
	}
	else {
		return 0;
	}
}
}
