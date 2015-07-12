package learning;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import kommunikation.Nachricht;

@SuppressWarnings("serial")
@Entity
@Table(name = "BOSSFIGHT")
@PrimaryKeyJoinColumn(name = "bossfight_id", referencedColumnName = "challenge_id")
public class Bossfight extends Challenge implements java.io.Serializable {

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="medium_id")
	private Medium medium;

	@Transient
	private HashSet<String> antworten;
	
	@Transient
	protected Gruppe gruppe; 

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Bossfight() {
	}

	/**
	 * Legt einen neuen Bossfight an
	 * 
	 * @param bearbeiter
	 *            Bearbeiter des Bossfights
	 * @param medium
	 *            Klausur auf die sich Bossfight bezieht
	 * @param erreichbarePunktzahl
	 *            erreichbare Punktzahl
	 * @param gruppe
	 *            Gruppe zu der der Bossfight geh&oumlrt
	 */
	public Bossfight(Benutzer bearbeiter, Medium medium,
			int erreichbarePunktzahl, Gruppe gruppe) {
		this.bearbeiter = bearbeiter;
		this.medium = medium;
		this.erreichbarePunktzahl = erreichbarePunktzahl;
		this.gruppe = gruppe;
		datum = new Date();
		antworten = new HashSet<String>();
	}

	/**
	 * gibt den Anhang des Bossfights zur&uumlck
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
		Nachricht nachricht = new Nachricht(moderator, bearbeiter,
				Nachricht.AUFGABEBEWERTET, this);
		bearbeiter.benachrichtigen(nachricht);
	}

	/**
	 * Beendet den Bossfight und benachrichtigt einen Moderator dar&uumlber
	 */
	public void beenden() {
		Benutzer moderator = (Benutzer) gruppe.moderatoren.toArray()[0];
		while (moderator.equals(bearbeiter)) {
			moderator = (Benutzer) gruppe.moderatoren.toArray()[0];
		}
		Nachricht nachricht = new Nachricht(bearbeiter, moderator,
				Nachricht.AUFGABEKORRIGIEREN, this);
		moderator.benachrichtigen(nachricht);
	}

	/**
	 * pr&uumlft, ob ein Bossfight bestanden wurde
	 * 
	 * @return
	 */
	public boolean bestanden() {
		if (erreichtePunktzahl >= (0.8 * this.erreichbarePunktzahl)) {
			bearbeiter.rangErhoehen();
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
}
