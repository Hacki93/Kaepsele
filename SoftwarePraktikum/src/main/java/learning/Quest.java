package learning;

import java.util.ArrayList;

public class Quest extends Challenge {
private ArrayList<Frage> fragen;

public Quest(){
	fragen = new ArrayList<Frage>();
}


public ArrayList<Frage> starten(){
	return fragen; 
}

public void addFrage(Frage frage){
	fragen.add(frage);
	this.punktzahl = this.punktzahl + 3; 
}

public Frage getNaechsteFrage(){
	Frage frage = fragen.get(0);
	fragen.remove(0);
	return frage;
}
}
