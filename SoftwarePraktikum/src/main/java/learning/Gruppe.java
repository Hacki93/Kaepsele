package learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="fachrichtung_id")
	public Fachrichtung fachrichtung;
	
	@Column(name = "freigegeben")
	public boolean freigegeben;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "GRUPPEN_MITGLIEDER", joinColumns =
	@JoinColumn(name = "gruppen_id"),  inverseJoinColumns =
	@JoinColumn(name = "benutzer_id"))
	private Set<Benutzer> mitglieder;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "GRUPPEN_MODERATOREN", joinColumns =
	@JoinColumn(name = "gruppen_id"),  inverseJoinColumns =
	@JoinColumn(name = "benutzer_id"))
	public Set<Benutzer> moderatoren;
	
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="fragenpool_id")
	public Fragenpool fragenpool;
	
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="pinnwand_id")
	Pinnwand pinnwand;
	
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="mediathek_id")
	Mediathek mediathek;
	
	@Transient
	private HashSet<Teamcombat> teamcombats;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Gruppe(){
		mitglieder = new HashSet<Benutzer>();
		moderatoren = new HashSet<Benutzer>();
		fragenpool = new Fragenpool();
		pinnwand = new Pinnwand();
		mediathek = new Mediathek();
		teamcombats = new HashSet<Teamcombat>();
		fachrichtung = new Fachrichtung();
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
		moderatoren = new HashSet<Benutzer>();
		fragenpool = new Fragenpool();
		pinnwand = new Pinnwand();
		mediathek = new Mediathek();
		teamcombats = new HashSet<Teamcombat>();
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
//		fachrichtung.gruppen.add(this);
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
	 *            der gel&ouml;schte Benutzer
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
	 * @param loesungen
	 */
	public void frageErstellen(String titel, String text, HashSet<String> antwortmoeglichkeiten, HashSet<String> loesungen) {
		Frage frage = new Frage(titel, text, antwortmoeglichkeiten, loesungen);
		this.fragenpool.addFrage(frage);
	}

	/**
	 * Es wird automatisch ein Quest erzeugt und zur&uumlckgegeben
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
		Nachricht nachricht = new Nachricht(this, herausgeforderter, Nachricht.TEAMHERAUSFORDERUNG, teamcombat);
		herausgeforderter.benachrichtigen(nachricht);
		this.benachrichtigen(nachricht);
	}

	public void setMitglieder(Set<Benutzer> mitglieder) {
		this.mitglieder = mitglieder;
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
	
	public void setMediathek(Mediathek mediathek) {
		this.mediathek = mediathek;
	}

	public Mediathek getMediathek() {
		return mediathek;
	}

	public void setPinnwand(Pinnwand pinnwand) {
		this.pinnwand = pinnwand;
	}

	public Pinnwand getPinnwand() {
		return pinnwand;
	}
}
