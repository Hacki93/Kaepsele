package learning;

import java.util.ArrayList;

public class Quest extends Challenge {
public ArrayList<Frage> fragen;

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
}
