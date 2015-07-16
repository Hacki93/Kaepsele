package learning;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kommunikation.Nachricht;

/**
 * Ein Bossfight ist eine Spezialisierung von Challenge und stellt vor dem Benutzer eine Altklausur dar.
 * Damit ist er die letzte H&uuml;rde zur Bestehung einer Gruppe und dem Amt des Moderators.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "BOSSFIGHT")
@PrimaryKeyJoinColumn(name = "bossfight_id", referencedColumnName = "challenge_id")
public class Bossfight extends Challenge implements java.io.Serializable {

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="medium_id")
	private Medium medium;

	@ElementCollection(targetClass = String.class)
	@CollectionTable(name="BOSSFIGHT_ANTWORTEN", joinColumns=@JoinColumn(name="bossfight_id"))
	private Set<String> antworten;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="gruppe_id")
	public Gruppe gruppe;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Bossfight() {
		antworten = new HashSet<String>();
	}

	/**
	 * Legt einen neuen Bossfight an
	 * 
	 * @param bearbeiter Der Bearbeiter des Bossfights
	 * @param medium Die Klausur, auf die sich Bossfight bezieht
	 * @param erreichbarePunktzahl Die erreichbare Punktzahl
	 * @param gruppe Gruppe zu der der Bossfight geh&oumlrt
	 */
	public Bossfight(Benutzer bearbeiter, Medium medium, int erreichbarePunktzahl, Gruppe gruppe) {
		this.benutzer = bearbeiter;
		this.medium = medium;
		this.erreichbarePunktzahl = erreichbarePunktzahl;
		this.gruppe = gruppe;
		datum = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		antworten = new HashSet<String>();
	}

	/**
	 * Gibt den Anhang des Bossfights zur&uumlck
	 * 
	 * @return Klausur
	 */
	public Medium starten() {
		return medium;
	}

	/**
	 * speichert die Antworten des Bearbeiters
	 * 
	 * @param antwort
	 */
	public void addAntwort(String antwort) {
		antworten.add(antwort);
	}

	/**
	 * Setzt die erreichte Punktzahl des Bossfights und benachrichtigt den
	 * Bearbeiter dar&uumlber
	 * 
	 * @param moderator
	 * @param punktzahl
	 */
	public void korrigieren(Benutzer moderator, int punktzahl) {
		erreichtePunktzahl = erreichtePunktzahl + punktzahl;
		Nachricht nachricht = new Nachricht(moderator, benutzer, Nachricht.AUFGABEBEWERTET, this);
		benutzer.benachrichtigen(nachricht);
	}

	/**
	 * Beendet den Bossfight und benachrichtigt einen Moderator dar&uumlber
	 */
	public void beenden() {
		Benutzer moderator = (Benutzer) gruppe.moderatoren.toArray()[0];
		while (moderator.equals(benutzer)) {
			moderator = (Benutzer) gruppe.moderatoren.toArray()[0];
		}
		Nachricht nachricht = new Nachricht(benutzer, moderator,
				Nachricht.AUFGABEKORRIGIEREN, this);
		moderator.benachrichtigen(nachricht);
	}

	/**
	 * Pr&uumlft, ob ein Bossfight bestanden wurde
	 * 
	 * @return true, falls der Bossfight bestanden wurde
	 */
	public boolean bestanden() {
		if (erreichtePunktzahl >= (0.8 * this.erreichbarePunktzahl)) {
			benutzer.rangErhoehen();
			return true;
		} else {
			return false;
		}
	}

	public Medium getMedium() {
		return medium;
	}
	
	public void setMedium(Medium medium) {
		this.medium = medium;
	}
	
	public Gruppe getGruppe(){
		return gruppe;
	}
	
	public void setGruppe(Gruppe gruppe){
		this.gruppe = gruppe;
	}
	
	public Set<String> getAntworten(){
		return antworten;
	}
	public void setAntworten(Set<String> antworten){
		this.antworten = antworten;
	}
}
