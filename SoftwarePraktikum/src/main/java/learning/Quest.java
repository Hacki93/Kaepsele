package learning;

import java.util.ArrayList;

public class Quest extends Challenge {
private ArrayList<Frage> fragen;
private ArrayList<Integer> antworten;

public Quest(){
	fragen = new ArrayList<Frage>();
}


public ArrayList<Frage> starten(){
	return fragen; 
}

public void addFrage(Frage frage){
	fragen.add(frage);
}

public Frage getNaechsteFrage(){
	Frage frage = fragen.get(0);
	fragen.remove(0);
	return frage;
}

public void antwortSpeicher(int antwort){
	antworten.add(antwort);
}

public int getNaechsteAntwort(){
	int antwort = antworten.get(0);
	antworten.remove(0);
	return antwort;
}

public int korrigiere(){
	while (fragen.isEmpty() == false){
		int lösung = getNaechsteFrage().getLoesung();
		int antwort = getNaechsteAntwort();
		if(lösung == antwort){
			this.punktzahl = this.punktzahl + 3; 
		}
		else{
			continue;
		}
	}
	return punktzahl; 
}
}
