package learning;

import java.util.Date;

public class Kommentar extends Inhalt implements java.io.Serializable{

	/**
	 * Konstruktor für ein neuen Kommentar zu einem Pinnwandbeitrag (Inhalt)
	 * 
	 * @param inhalt: Ist der Inhalt des Kommentars
	 * @param titel: Ist der Titel des Kommentars
	 * @param autor: Ist der Autor des Kommentars
	 */
	public Kommentar(String inhalt, String titel, Benutzer autor){
		this.inhalt = inhalt;
		this.titel = titel;
		this.autor= autor;
		bewertung = 0;
		erstelltAm = new Date();
	}
}
