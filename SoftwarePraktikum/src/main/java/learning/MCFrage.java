package learning;

import java.util.ArrayList;

public class MCFrage extends Frage {
public ArrayList<String> antworten; 
public int lösung; 


public ArrayList<String> getAntworten(){
	return antworten;
}

public void setAntworten(ArrayList<String> antworten){
	this.antworten = antworten;
}

public int getLösung(){
	return lösung;
}

public void setLösung(int lösung){
	this.lösung = lösung;
}

public int korrigiere(int antwort){
	return antwort;
}
}
