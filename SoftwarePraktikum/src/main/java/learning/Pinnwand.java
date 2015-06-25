package learning;

import java.util.ArrayList;
import java.util.Collections;

public class Pinnwand{

	public ArrayList<Thema> themen;
	public ArrayList<Benutzer> erlaubteBenutzer;
	
	/**
	 * Konstruktor, der eine neue Pinnwand erstellt
	 */
	public Pinnwand(){
		themen = new ArrayList<Thema>();
		erlaubteBenutzer = new ArrayList<Benutzer>();
	}
	
	/**
	 * Es wird ein neuer Pinnwandbeitrag erstellt
	 * @param inhalt der neue Inhalt auf der Pinnwand
	 */
	public void inhaltHinzuf�gen(Thema thema){
		themen.add(thema);
	}
	
	/**
	 * Es wird ein Pinnwandbeitrag gel&ouml;scht
	 * @param inhalt der gel&ouml;tschte Inhalt
	 */
	public void inhaltL�schen(Thema thema){
		themen.remove(thema);
	}
	
	/**
	 * Sortiert die Pinnwand nach den neuesten Eintr�gen
	 */
	public ArrayList<Thema> sortiereNachDatum(){
		return this.themen;
	}
	
	/**
	 * Sortiert die Pinnwand nach den besten Bewertungen
	 */
	public ArrayList<Thema> sortiereNachBewertung(){
		Collections.sort(this.themen);
		return this.themen;
	}

}
