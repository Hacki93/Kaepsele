package learning;

import java.util.ArrayList;
import java.util.Date;

public class Thema extends Inhalt{

	public ArrayList<Kommentar> kommentare;
	
	/**
	 * Konstruktor für ein neuen Pinnwandbeitrag
	 * 
	 * @param inhalt: Ist der Inhalt des Pinnwandbeitrags
	 * @param titel: Ist der Titel des Pinnwandbeitrags
	 * @param autor: Ist der Autor des Pinnwandbeitrags
	 */
	public Thema(String inhalt, String titel, Benutzer autor){
		this.inhalt = inhalt;
		this.titel = titel;
		this.autor= autor;
		bewertung = 0;
		erstelltAm = new Date();
		kommentare = new ArrayList<Kommentar>();
	}
	
	/**
	 * Erstellt einen Kommentar zu einem Pinnwandbeitrag (Inhalt)
	 * @param kommentar der hinzugef&uuml;gte Kommentar
	 */
	public void kommentieren(Kommentar kommentar){
		kommentare.add(kommentar);
	}
	
	/**
	 * L&ouml;scht einen Kommentar
	 * @param kommentar der gel&oumlschte Kommentar
	 */
	public void kommentarLöschen(Kommentar kommentar){
		kommentare.remove(kommentar);
	}
	
	/**
	 * Bewertung eines Inhalts
	 * @param wertung kann positiv oder negativ sein
	 */
	public void bewerten(boolean wertung){
		if(wertung == true){
			bewertung++;
		}
		else if(wertung == false){
			bewertung--;
		}
	}
}
