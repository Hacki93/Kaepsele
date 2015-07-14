package learning;

import java.util.ArrayList;
import java.util.HashSet;
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


@SuppressWarnings("serial")
@Entity
@Table(name = "GRUPPE")
public class Gruppe implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "gruppen_id")
	public int gruppen_id;

	@Column(name = "name")
	public String name;

	@Column(name = "klausurname")
	public String klausurname;

	@Column(name = "profilbildurl")
	private String profilbildurl;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fachrichtung_id")
	public Fachrichtung fachrichtung;

	@Column(name = "freigegeben")
	public boolean freigegeben;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "GRUPPEN_MITGLIEDER", joinColumns = 
	@JoinColumn(name = "gruppen_id"), inverseJoinColumns = 
	@JoinColumn(name = "benutzer_id"))
	private Set<Benutzer> mitglieder;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "GRUPPEN_MODERATOREN", joinColumns = 
	@JoinColumn(name = "gruppen_id"), inverseJoinColumns = 
	@JoinColumn(name = "benutzer_id"))
	public Set<Benutzer> moderatoren;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fragenpool_id")
	public Fragenpool fragenpool;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "pinnwand_id")
	public Pinnwand pinnwand;

	@Transient
	public Set<Teamcombat> teamcombats;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="gruppe")
	private Set<Quest> quests;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "gruppe")
	Set<Bossfight> bossfights;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Gruppe() {
		mitglieder = new HashSet<Benutzer>();
		moderatoren = new HashSet<Benutzer>();
		fragenpool = new Fragenpool();
		pinnwand = new Pinnwand();
		teamcombats = new HashSet<Teamcombat>();
		fachrichtung = new Fachrichtung();
		bossfights = new HashSet<Bossfight>();
		quests = new HashSet<Quest>();
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
		fragenpool = new Fragenpool(); // löschen
		pinnwand = new Pinnwand(); // löschen
		teamcombats = new HashSet<Teamcombat>();
		bossfights = new HashSet<Bossfight>();
	}

	/**
	 * Anzahl der Mitglieder der Gruppe
	 * 
	 * @return Anzahl der Mitglieder
	 */
	public int anzahl() {
		return mitglieder.size();
	}

	/**
	 * F&uuml;gt einen Bossfight der Gruppe hinzu
	 * 
	 * @param bossfight Der Bossfight, der hinzugef&uuml;gt werden soll-
	 */
	public void addBossfight(Bossfight bossfight) {
		bossfights.add(bossfight);
		bossfight.setGruppe(this);
	}

	/**
	 * Gibt bei gen&uumlgend Punkten einen Bossfight zur&uumlck
	 * 
	 * @param benutzer
	 * @return bei gen&uumlgend Punkten einen Bossfight, sonst null
	 */
	public Bossfight bossfightAntreten(Benutzer benutzer) {
		if (aktuellerPunktestand(benutzer) >= 80) {
			ArrayList<Bossfight> fights = new ArrayList<Bossfight>();
			for (Bossfight bf : fights) {
				fights.add(bf);
			}
			int zufallsindex = (int) (Math.random() * fights.size());
			return fights.get(zufallsindex);
		} else {
			return null;
		}
	}

	/**
	 * Pr&uumlft den aktuellen Punktestand eines Benutzers innerhalb der Gruppe
	 * 
	 * @param benutzer
	 * @return aktueller Punktestand 
	 */
	public int aktuellerPunktestand(Benutzer benutzer) {
		int punkte = 0;
		for (Quest q : quests) {
			if (q.getBenutzer().equals(benutzer)) {
				punkte = punkte + q.getErreichtePunktzahl();
			}
		}

		for (Teamcombat t : teamcombats) {
			if (t.getGewinner().equals(this)) {
				punkte = punkte + t.getGewinnerpunkte();
			}
		}
		return punkte;
	}

	/**
	 * Es werden Mitglieder der Gruppe benachrichtigt
	 * 
	 * @param nachricht Die Nachricht
	 */
	public void benachrichtigen(Nachricht nachricht) {
		for (Benutzer mitglied : mitglieder) {
			mitglied.benachrichtigen(nachricht);
		}
	}

	/**
	 * Es wird der Moderator der Gruppe benachrichtigt
	 * 
	 * @param nachricht Die Nachricht
	 */
	public void moderatorBenachrichtigen(Nachricht nachricht) {
		for (Benutzer moderator : moderatoren) {
			moderator.benachrichtigen(nachricht);
		}
	}

	/**
	 * Es wird ein Benutzer eingeladen
	 * 
	 * @param benutzer Der Benutzer der in die Gruppe eingeladen wird
	 */
	public void einladen(Benutzer benutzer) {
		Nachricht nachricht = new Nachricht(this, benutzer, Nachricht.GRUPPENEINLADUNG, this);
		benutzer.benachrichtigen(nachricht);
	}

	/**
	 * F&uuml;gt einen Benutzer in die Mitgliederliste der Gruppe hinzu
	 * 
	 * @param benutzer Der hinzuzuf&uuml;gende Benutzer
	 */
	public void mitgliedHinzufuegen(Benutzer benutzer) {
		mitglieder.add(benutzer);
		benutzer.gruppen.add(this);
		pinnwand.erlaubteBenutzer.add(benutzer);
	}

	/**
	 * L&ouml;scht einen Benutzer aus der Mitgliederliste der Gruppe
	 * 
	 * @param benutzer Der zu l&ouml;schende Benutzer
	 */
	public void mitgliedLoeschen(Benutzer benutzer) {
		mitglieder.remove(benutzer);
		benutzer.gruppen.remove(this);
		pinnwand.erlaubteBenutzer.remove(benutzer);
	}

	/**
	 * F&uuml;gt einen Benutzer in die Moderatorenliste der Gruppe hinzu
	 * 
	 * @param benutzer Der hinzuzuf&uuml;gende Benutzer
	 */
	public void moderatorHinzufuegen(Benutzer benutzer) {
		moderatoren.add(benutzer);
		benutzer.moderierteGruppen.add(this);
	}

	/**
	 * L&ouml;scht einen Benutzer aus der Moderatorenliste der Gruppe
	 * 
	 * @param benutzer Der zu l&ouml;schende Benutzer
	 */
	public void moderatorLoeschen(Benutzer benutzer) {
		moderatoren.remove(benutzer);
		benutzer.moderierteGruppen.remove(this);
	}

	/**
	 * Es wird ein Frage erstellt und im Fragenpool der Gruppe gespeichert
	 * 
	 * @param text Der Text der Frage
	 * @param loesungen Die L&ouml;sung
	 */
	public void frageErstellen(String text, HashSet<String> antwortmoeglichkeiten, HashSet<String> loesungen, Benutzer autor) {
		Frage frage = new Frage(text, antwortmoeglichkeiten, loesungen, autor);
		this.fragenpool.addFrage(frage);
	}

	/**
	 * Es wird automatisch ein Quest erzeugt und zur&uumlckgegeben
	 * 
	 * @return Quest Das erzeugte Quest
	 */
	public Quest questAntreten(Benutzer bearbeiter) {
		Quest quest = this.fragenpool.getQuest(this);
		quest.setBenutzer(bearbeiter);
		quests.add(quest);
		return quest;
	}

	/**
	 * Es wird ein Teamcombat erzeugt und in den Gruppen gespeichert
	 * 
	 * @param herausgeforderter Die Gruppe, die herausgerfordert werden soll
	 * 
	 * @return Teamcombat Der erzeugte Teamcombat
	 */
	public Teamcombat teamcombatAntreten(Gruppe herausgeforderter) {
		Teamcombat teamcombat = new Teamcombat(this, herausgeforderter);
		this.teamcombats.add(teamcombat);
		herausgeforderter.teamcombats.add(teamcombat);
		Nachricht nachricht = new Nachricht(this, herausgeforderter, Nachricht.TEAMHERAUSFORDERUNG, teamcombat);
		herausgeforderter.benachrichtigen(nachricht);
		this.benachrichtigen(nachricht);
		return teamcombat;
	}
	
	public void setFachrichtung(Fachrichtung fachrichtung) {
		this.fachrichtung = fachrichtung;
		fachrichtung.gruppen.add(this);
	}
	
	public Fachrichtung getFachrichtung() {
		return fachrichtung;
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

	public void setPinnwand(Pinnwand pinnwand) {
		this.pinnwand = pinnwand;
	}

	public Pinnwand getPinnwand() {
		return pinnwand;
	}

	public void setProfilbildURL(String profilbildurl) {
		this.profilbildurl = profilbildurl;
	}

	public String getProfilbildURL() {
		return profilbildurl;
	}
	
	public void setFragenpool(Fragenpool fragenpool){
		this.fragenpool = fragenpool;
	}
	
	public Fragenpool getFragenpool(){
		return fragenpool;
	}
	
	public void setId(int id){
		gruppen_id = id;
	}
	
	public int getId(){
		return gruppen_id;
	}
}
