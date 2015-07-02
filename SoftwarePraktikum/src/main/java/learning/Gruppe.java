package learning;

import java.util.ArrayList;
import java.util.Observable;

import kommunikation.Benachrichtigung;
import kommunikation.Nachricht;

public class Gruppe extends Observable {

	public String name;
	public String klausurname;
	public Fachrichtung fachrichtung;
	public boolean freigegeben;
	public ArrayList<Benutzer> mitglieder;
	public ArrayList<Benutzer> moderatoren;
	Benachrichtigung benachrichtigung;
	Fragenpool fragenpool;
	Pinnwand pinnwand;
	Mediathek mediathek;
	
	/**
	 * Konstruktor, der eine neue Gruppe erstellt
	 * 
	 * @param name: Ist der Name der Gruppe
	 * @param fachrichtung: Ist die Fachrichtung der Gruppe
	 * @param Klausurname: Ist der Name der zu schreibende Klausur
	 */
	public Gruppe(String name, Fachrichtung fachrichtung, String klausurname){
		this.name = name;
		this.fachrichtung = fachrichtung;
		this.klausurname = klausurname;
		mitglieder = new ArrayList<Benutzer>();
		moderatoren = new ArrayList<Benutzer>();
		Benachrichtigung benachrichtigung = new Benachrichtigung();
		this.addObserver(benachrichtigung);
		fragenpool = new Fragenpool();
		pinnwand = new Pinnwand();
		mediathek = new Mediathek();
	}
	
	/**
	 * 
	 * @return Anzahl der Mitglieder in einer Gruppe
	 */
	public int anzahl(){
		return mitglieder.size();
	}

	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

	/**
	 * Es werden Mitglieder der Gruppe benachrichtigt
	 * @param nachricht Die Nachricht für die Gruppenmitglieder
	 */
	private void mitgliederBenachrichtigen(Nachricht nachricht) {
		setChanged();
		notifyObservers(nachricht);
	}
	
	/**
	 * Es wird der Moderator der Gruppe benachrichtigt
	 * 
	 * @param nachricht
	 */
	public void moderatorBenachrichtigen(Nachricht nachricht){
	}
	
	/**
	 * Es wird ein Benutzer eingeladen
	 * @param benutzer Der Benutzer der in die Gruppe eingeladen wird
	 */
	public void einladen(Benutzer benutzer) {
		Nachricht nachricht = new Nachricht(this, benutzer, Nachricht.GRUPPENEINLADUNG);
		setChanged();
		notifyObservers(nachricht);
	}
	
	/**
	 * F&uuml;gt einen Benutzer in die Mitgliederliste der Gruppe hinzu
	 * @param benutzer der hinzugef&uuml;gte Benutzer
	 */
	public void mitgliedHinzufügen(Benutzer benutzer){
		mitglieder.add(benutzer);
		pinnwand.erlaubteBenutzer.add(benutzer);
	}
	
	/**
	 * l&ouml;scht einen Benutzer aus der Mitgliederliste der Gruppe
	 * @param benutzer der gel&ouml;tschte Benutzer
	 */
	public void mitgliedLöschen(Benutzer benutzer){
		mitglieder.remove(benutzer);
		pinnwand.erlaubteBenutzer.remove(benutzer);
	}
	
	public void frageErstellen(Benutzer ersteller, String titel, String text, int loesung){
		Frage frage = new Frage(ersteller, titel, text, loesung);
		this.fragenpool.addFrage(frage);
	}
	
	public Quest questAntreten(){
		Quest quest = this.fragenpool.getQuest();
		return quest;
	}
	
	public Teamcombat teamcombatAntreten(Gruppe herausgeforderter){
		Teamcombat teamcombat = new Teamcombat(this, herausgeforderter);
		return teamcombat;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKlausurname() {
		return klausurname;
	}

	public void setKlausurname(String klausurname) {
		this.klausurname = klausurname;
	}

	public Fachrichtung getFachrichtung() {
		return fachrichtung;
	}

	public boolean isFreigegeben() {
		return freigegeben;
	}

	public void setFreigegeben(boolean freigegeben) {
		this.freigegeben = freigegeben;
	}
	
}
