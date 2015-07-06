package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Stack;

public class Thema extends Inhalt implements java.io.Serializable{

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
	 * Sortiert die Kommentare nach dem neusten Datum
	 * @return die sortierte Kommentarliste
	 */
	public ArrayList<Kommentar> sortiereNachDatum(){
		Stack<Kommentar> tempStack = new Stack<Kommentar>();
		
		for(int i = 1; i < this.kommentare.size(); i++){
			for(int j = 0; j < this.kommentare.size() - 1; j++){
				if (this.kommentare.get(j).getDatum().compareTo(this.kommentare.get(j+1).getDatum()) < 0){
					tempStack.push(this.kommentare.get(j));
					this.kommentare.set(j, this.kommentare.get(j+1));
					this.kommentare.set(j+1, tempStack.pop());
				}
			}
		}	
		return this.kommentare;
	}
	
	/**
	 * Sortiert die Kommentare nach den besten Bewertungen
	 * @return sortierte Kommentarliste
	 */
	public ArrayList<Kommentar> sortiereNachBewertung(){
		Collections.sort(this.kommentare);
		return this.kommentare;
	}

}
