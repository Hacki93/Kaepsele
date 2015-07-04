package kommunikation;

import java.util.Date;

import learning.Benutzer;
import learning.Gruppe;

/**
 * Diese Klasse stellt den Datentyp Nachricht dar
 * 
 * @author Hannes
 *
 */
public class Nachricht {

	private String titel;
	private String inhalt;
	boolean handlungErforderlich;
	private Date datum;
	private Object adressat;
	private Object sender;
	private int typ;
	private Object anhang;

	public static final int FREUNDHINZUGEFUEGT = 0;
	public static final int GRUPPENEINLADUNG = 1;
	public static final int AUFGABEKORRIGIEREN = 2;
	public static final int BEITRITTSANFRAGE = 3;
	public static final int TEAMHERAUSFORDERUNG = 4;
	public static final int AUFGABEBEWERTET = 5;
	public static final int GRUPPEVOLL = 6;

	/**
	 * Konstruktor mit dem die Nachricht angelegt wird
	 * 
	 * @param titel
	 *            Der Titel der Nachricht
	 * @param inhalt
	 *            Der Inhalt der Nachricht
	 * @param handlungErforderlich
	 *            true, falls die Nachricht eine Interaktion erfordert
	 * @param anhang
	 *            beinhaltet das Objekt auf das sich die Nachricht bezieht
	 * 
	 */
	public Nachricht(Object sender, Object adressat, int typ, Object anhang) {
		switch (typ) {
		case 0:
			titel = "Du hast einen neuen Freund";
			inhalt = ((Benutzer) sender).getName()
					+ " hat Dich zu seiner Freundesliste hinzugefügt";
			break;
		case 1:
			titel = "Du wurdest in eine Gruppe eingeladen";
			inhalt = "Du wurdest in die Gruppe \""
					+ ((Gruppe) sender).getName() + "\" eingeladen";
			break;
		case 2:
			titel = "Bitte korrigiere Deine Aufgabe";
			inhalt = ((Benutzer) sender).getName()
					+ " hat eine von Dir gestellte Aufgabe bearbeitet.\nBitte korrigiere und bewerte diese Aufgabe zeitnah, damit "
					+ ((Benutzer) sender).getName() + " sein Ergebnis erhält.";
			handlungErforderlich = true;
			break;
		case 3:
			titel = ((Benutzer) sender).getName()
					+ "möchte der Gruppe beitreten";
			inhalt = ((Benutzer) sender).getName()
					+ "hat eine Beitrittsanfrage an deine Gruppe "
					+ ((Gruppe) adressat).getName() + " gestellt";
			handlungErforderlich = true;
			break;
		case 4:
			titel = "Herausforderung zum Teamcombat";
			inhalt = "Gruppe " + ((Gruppe) sender).getName() + " hat "
					+ ((Gruppe) adressat).getName() + " herausgefordert";
			handlungErforderlich = true;
			break;
		case 5:
			titel = "Dein Bossfight wurde bewertet";
			inhalt = "Dein Bossfight wurde bewertet";
			break;
		}
		this.anhang = anhang;
		datum = new Date();
		this.sender = sender;
		this.adressat = adressat;
		this.typ = typ;
	}

	public boolean isHandlungErforderlich() {
		return handlungErforderlich;
	}

	/**
	 * Gibt den Titel der Nachricht zur&uuml;ck
	 * 
	 * @return Der Titel der Nachricht
	 */
	public String getTitel() {
		return titel;
	}

	/**
	 * Gibt den Inhalt der Nachricht zur&uuml;ck
	 * 
	 * @return Der Inhalt der Nachricht
	 */
	public String getInhalt() {
		return inhalt;
	}

	/**
	 * Gibt das Erstelldatum der Nachricht zur&uuml;ck
	 * 
	 * @return Das Erstelldatum der Nachricht
	 */
	public Date getDate() {
		return datum;
	}

	/**
	 * Gibt den Adressaten der Nachricht zu&uuml;ck
	 * 
	 * @return Der Adressat der Nachricht
	 */
	public Object getAdressat() {
		return adressat;
	}

	/**
	 * Gibt den Sender der Nachricht zur&uuml;ck
	 * 
	 * @return Der Sender der Nachricht
	 */
	public Object getSender() {
		return sender;
	}

}
