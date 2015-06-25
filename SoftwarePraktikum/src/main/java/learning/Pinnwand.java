package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

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
	public void inhaltHinzufügen(Thema thema){
		themen.add(thema);
	}
	
	/**
	 * Es wird ein Pinnwandbeitrag gel&ouml;scht
	 * @param inhalt der gel&ouml;tschte Inhalt
	 */
	public void inhaltLöschen(Thema thema){
		themen.remove(thema);
	}
	
	/**
	 * Sortiert die Pinnwand nach den neuesten Einträgen
	 */
	public ArrayList<Thema> sortiereNachDatum(){
		Stack<Thema> tempStack = new Stack<Thema>();
		ArrayList<Thema> tempArray = new ArrayList<Thema>();
		for(int i = 1; i < this.themen.size(); i++){
			for(int j = 0; j < this.themen.size() - 1; j++){
				if (this.themen.get(j).getDatum().compareTo(this.themen.get(j+1).getDatum()) < 0){
					tempStack.push(this.themen.get(j));
					tempArray.add(this.themen.get(j));
					this.themen.set(j, this.themen.get(j+1));
					this.themen.set(j+1, tempStack.pop());
				}
			}
		}	
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
