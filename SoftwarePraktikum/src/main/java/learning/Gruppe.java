package learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import kommunikation.Nachricht;

@Entity
@Table(name = "GRUPPE")
public class Gruppe implements java.io.Serializable {

	@Id @GeneratedValue
	@Column(name = "gruppen_id")
	public int gruppen_id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "klausurname")
	public String klausurname;
	
    @ManyToOne
    @JoinColumn(name="fachrichtung_id")
	public Fachrichtung fachrichtung;
	
	@Column(name = "freigegeben")
	public boolean freigegeben;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "GRUPPEN_MITGLIEDER", joinColumns =
	@JoinColumn(name = "gruppen_id"),  inverseJoinColumns =
	@JoinColumn(name = "benutzer_id"))
	private Set<Benutzer> mitglieder;
	
	@Transient
	public ArrayList<Benutzer> moderatoren;
	
	@Transient
	Fragenpool fragenpool;
	
	@Transient
	Pinnwand pinnwand;
	
	@Transient
	Mediathek mediathek;
	
	@Transient
	private ArrayList<Teamcombat> teamcombats;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Gruppe(){
		mitglieder = new HashSet<Benutzer>();
		moderatoren = new ArrayList<Benutzer>();
		fragenpool = new Fragenpool();
		pinnwand = new Pinnwand();
		mediathek = new Mediathek();
		teamcombats = new ArrayList<Teamcombat>();
	}
	
	/**
	 * Konstruktor, der eine neue Gruppe erstellt
	 * 
	 * @param name Der Name der Gruppe
	 * @param fachrichtung Die Fachrichtung der Gruppe
	 * @param Klausurname Der Name der zu schreibende Klausur
	 */
	public Gruppe(String name, Fachrichtung fachrichtung, String klausurname) {
		this.name = name;
		setFachrichtung(fachrichtung);
		this.klausurname = klausurname;
		mitglieder = new HashSet<Benutzer>();
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
		fachrichtung.gruppen.add(this);
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
		Nachricht nachricht = new Nachricht(this, benutzer, Nachricht.GRUPPENEINLADUNG, this);
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
		Nachricht nachricht = new Nachricht(this, herausgeforderter, 4, teamcombat);
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
	
	public Set<Benutzer> getMitglieder() {
		return mitglieder;
	}
	
	public void setMitglieder(HashSet<Benutzer> benutzer) {
		this.mitglieder = benutzer;
	}

}
