package learning;

import java.util.ArrayList;

public class Pinnwand {

	public ArrayList<Inhalt> inhalte;
	public ArrayList erlaubteBenutzer;
	
	/**
	 * Konstruktor, der eine neue Pinnwand erstellt
	 */
	public Pinnwand(){
		inhalte = new ArrayList<Inhalt>();
		erlaubteBenutzer = new ArrayList();
	}
	
	/**
	 * Es wird ein neuer Pinnwandbeitrag erstellt
	 * @param inhalt der neue Inhalt auf der Pinnwand
	 */
	public void inhaltHinzuf�gen(Inhalt inhalt){
		inhalte.add(inhalt);
	}
	
	/**
	 * Es wird ein Pinnwandbeitrag gel�scht
	 * @param inhalt der gel&ouml;tschte Inhalt
	 */
	public void inhaltL�schen(Inhalt inhalt){
		inhalte.remove(inhalt);
	}
	
	/**
	 * Sortiert die Pinnwand nach den neuesten Eintr�gen
	 */
	public void sortiereNachDatum(){
		
	}
	
	/**
	 * Sortiert die Pinnwand nach den besten Bewertungen
	 */
	public void sortiereNachBewertung(){
		
	}
}
