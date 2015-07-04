package learning;

import java.util.ArrayList;
import java.util.Observable;

import kommunikation.Benachrichtigung;
import kommunikation.Nachricht;

public class Gruppe {

	public String name;
	public String klausurname;
	public Fachrichtung fachrichtung;
	public boolean freigegeben;
	public ArrayList<Benutzer> mitglieder;
	public ArrayList<Benutzer> moderatoren;
	Fragenpool fragenpool;
	Pinnwand pinnwand;
	Mediathek mediathek;
	private ArrayList<Teamcombat> teamcombats;

	/**
	 * Konstruktor, der eine neue Gruppe erstellt
	 * 
	 * @param name
	 *            : Ist der Name der Gruppe
	 * @param fachrichtung
	 *            : Ist die Fachrichtung der Gruppe
	 * @param Klausurname
	 *            : Ist der Name der zu schreibende Klausur
	 */
	public Gruppe(String name, Fachrichtung fachrichtung, String klausurname) {
		this.name = name;
		this.fachrichtung = fachrichtung;
		this.klausurname = klausurname;
		mitglieder = new ArrayList<Benutzer>();
		moderatoren = new ArrayList<Benutzer>();
		fragenpool = new Fragenpool();
		pinnwand = new Pinnwand();
		mediathek = new Mediathek();
		teamcombats = new ArrayList<Teamcombat>();
	}

	/**
	 * 
	 * @return Anzahl der Mitglieder in einer Gruppe
	 */
	public int anzahl() {
		return mitglieder.size();
	}

	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

	/**
	 * Es werden Mitglieder der Gruppe benachrichtigt
	 * 
	 * @param nachricht
	 *            Die Nachricht für die Gruppenmitglieder
	 */
	private void benachrichtigen(Nachricht nachricht) {
		for (Benutzer mitglied : mitglieder) {
			mitglied.benachrichtigen(nachricht);
		}
	}

	/**
	 * Es wird der Moderator der Gruppe benachrichtigt
	 * 
	 * @param nachricht
	 */
	public void moderatorBenachrichtigen(Nachricht nachricht) {
		for (Benutzer moderator : moderatoren) {
			moderator.benachrichtigen(nachricht);
		}
	}

	/**
	 * Es wird ein Benutzer eingeladen
	 * 
	 * @param benutzer
	 *            Der Benutzer der in die Gruppe eingeladen wird
	 */
	public void einladen(Benutzer benutzer) {
		Nachricht nachricht = new Nachricht(this, benutzer,
				Nachricht.GRUPPENEINLADUNG);
		benutzer.benachrichtigen(nachricht);
	}

	/**
	 * F&uuml;gt einen Benutzer in die Mitgliederliste der Gruppe hinzu
	 * 
	 * @param benutzer
	 *            der hinzugef&uuml;gte Benutzer
	 */
	public void mitgliedHinzufuegen(Benutzer benutzer) {
		mitglieder.add(benutzer);
		pinnwand.erlaubteBenutzer.add(benutzer);
	}

	/**
	 * l&ouml;scht einen Benutzer aus der Mitgliederliste der Gruppe
	 * 
	 * @param benutzer
	 *            der gel&ouml;tschte Benutzer
	 */
	public void mitgliedLoeschen(Benutzer benutzer) {
		mitglieder.remove(benutzer);
		pinnwand.erlaubteBenutzer.remove(benutzer);
	}

	/**
	 * Es wird ein Frage erstellt und im Fragenpool der Gruppe gespeichert
	 * 
	 * @param titel
	 * @param text
	 * @param loesung
	 */
	public void frageErstellen(String titel, String text, int loesung) {
		Frage frage = new Frage(titel, text, loesung);
		this.fragenpool.addFrage(frage);
	}

	/**
	 * Es wird automatisch ein Quest erzeugt und zurueckgegeben
	 * 
	 * @return Quest
	 */
	public Quest questAntreten() {
		Quest quest = this.fragenpool.getQuest();
		return quest;
	}

	/**
	 * Es wird ein Teamcombat erzeugt und in den Gruppen gespeichert
	 * 
	 * @param herausgeforderter
	 * @return Teamcombat
	 */
	public void teamcombatAntreten(Gruppe herausgeforderter) {
		Teamcombat teamcombat = new Teamcombat(this, herausgeforderter);
		this.teamcombats.add(teamcombat);
		herausgeforderter.teamcombats.add(teamcombat);
		Nachricht nachricht = new Nachricht(this, herausgeforderter, 4);
		herausgeforderter.benachrichtigen(nachricht);
		this.benachrichtigen(nachricht);
	}

	/**
	 * gibt den passenden Quest des Teamcombats zurueck, so dass dieser
	 * bearbeitet werden kann
	 * 
	 * @param i
	 * @return
	 */
	public Quest teamcombatBearbeiten(int i) {
		Teamcombat teamcombat = teamcombats.get(i);
		if (this.equals(teamcombat.getHerausforderer())) {
			return teamcombat.questFuerHerausforderer;
		} else {
			return teamcombat.questFuerHerausgeforderter;
		}
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
