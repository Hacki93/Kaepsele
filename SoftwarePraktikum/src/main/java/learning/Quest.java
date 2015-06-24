package learning;

import java.util.ArrayList;

public class Quest extends Challenge {
private ArrayList<Frage> fragen;
private ArrayList<Integer> antworten;
private int zaehlerFragen = 0;
private int zaehlerAntworten = 0;
private int erreichbarePunktzahl = 30; 

public Quest(){
	fragen = new ArrayList<Frage>();
}

public int getErreichbarePunktzahl(){
	return erreichbarePunktzahl;
}

public ArrayList<Frage> starten(){
	return fragen; 
}

public void addFrage(Frage frage){
	fragen.add(frage);
}

public Frage getNaechsteFrage(){
	Frage frage = fragen.get(zaehlerFragen);
	zaehlerFragen++;
	return frage;
}

public void antwortSpeicher(int antwort){
	antworten.add(antwort);
}

public int getNaechsteAntwort(){
	int antwort = antworten.get(zaehlerAntworten);
	zaehlerAntworten++;
	return antwort;
}

public int korrigiere(){
	while (zaehlerFragen < 10){
		int loesung = getNaechsteFrage().getLoesung();
		int antwort = getNaechsteAntwort();
		if(loesung == antwort){
			this.erreichtePunktzahl = this.erreichtePunktzahl + 3; 
		}
		else{
			continue;
		}
	}
	return erreichtePunktzahl; 
}
}
