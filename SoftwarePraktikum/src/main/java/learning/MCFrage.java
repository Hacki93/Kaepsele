package learning;

import java.util.ArrayList;

public class MCFrage extends Frage {
public ArrayList<String> antworten; 
public int l�sung; 


public ArrayList<String> getAntworten(){
	return antworten;
}

public void setAntworten(ArrayList<String> antworten){
	this.antworten = antworten;
}

public int getL�sung(){
	return l�sung;
}

public void setL�sung(int l�sung){
	this.l�sung = l�sung;
}

public int korrigiere(int antwort){
	return antwort;
}
}
