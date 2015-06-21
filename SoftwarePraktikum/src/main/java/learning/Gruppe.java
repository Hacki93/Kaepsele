package learning;

import java.util.ArrayList;

import kommunikation.Benachrichtigung;

public class Gruppe {

	public String name;
	public String klausurname;
	public Fachrichtung fachrichtung;
	public boolean freigegeben;
	public ArrayList<Benutzer> mitglieder;
	
	/**
	 * 
	 * @return Anzahl der Mitlgieder in einer Gruppe
	 */
	public int anzahl(){
		return 0;
	}

	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

	/**
	 * Es werden Mitglieder der Gruppe benachrichtigt
	 * 
	 * @param b
	 */
	private void mitgliederBenachrichitgen(Benachrichtigung b){
	}
	
	/**
	 * Es wird der Moderator der Gruppe benachrichtigt
	 * 
	 * @param b
	 */
	public void moderatorBenachrichtigen(Benachrichtigung b){
	}
	
	/**
	 * Es wird eine neue Gruppe erstellt
	 * 
	 * @param name: Ist der Name der Gruppe
	 * @param fachrichtung: Ist die Fachrichtung der Gruppe
	 * @param Klausurname: Ist der Name der zu schreibende Klausur
	 */
	public void gruppeGenerieren(String name, Fachrichtung fachrichtung, String klausurname){
		this.name = name;
		this.fachrichtung = fachrichtung;
		this.klausurname = klausurname;
	}
	
	/**
	 * Es wird ein Bneutzer eingeladen
	 * 
	 * @param b ist der Benutzer der in die Gruppe eingeladen wird
	 */
	public void einladen(Benutzer b){	
	}
	
	public void frageErstellen(boolean mcfrage){
	}
	
	public Quest questAntreten(){
		return null;
	}
	
	public Teamcombat teamcombatAntreten(){
		return null;
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
