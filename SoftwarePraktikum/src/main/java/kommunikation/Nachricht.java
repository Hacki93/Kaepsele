package kommunikation;

import java.util.Date;

import learning.Benutzer;
import learning.Gruppe;

/**
 * Diese Klasse stellt den Datentyp Nachricht dar
 * @author Hannes
 *
 */
public class Nachricht {
	
	private String titel;
	private String inhalt;
	boolean handlungErforderlich;
	boolean erledigt;
	private Date datum;
	private Object adressat;
	private Object sender;
	
	public static final int FREUNDHINZUGEFUEGT = 0;
	public static final int GRUPPENEINLADUNG = 1;
	public static final int AUFGABEKORRIGIEREN = 2;
	public static final int BEITRITTSANFRAGE = 3;
	public static final int TEAMHERAUSFORDERUNG = 4;
	public static final int AUFGABEBEWERTET = 5;
	
	/**
	 * Konstruktor mit dem die Nachricht angelegt wird
	 * @param titel Der Titel der Nachricht
	 * @param inhalt Der Inhalt der Nachricht
	 * @param handlungErforderlich true, falls die Nachricht eine Interaktion erfordert
	 */
	public Nachricht(Object sender, Benutzer adressat, int typ) {
		if(typ == FREUNDHINZUGEFUEGT) {
			titel = "Du hast einen neuen Freund";
			inhalt = ((Benutzer)sender).getName() + " hat Dich zu seiner Freundesliste hinzugefügt.";
		} else if (typ == GRUPPENEINLADUNG) {
			titel ="Du wurdest in eine Gruppe eingeladen";
			inhalt = "Du wurdest in die Gruppe \"" + ((Gruppe)sender).getName() + "\" eingeladen";
		} else if (typ == AUFGABEKORRIGIEREN) {
			titel = "Bitte korrigiere Deine Aufgabe";
			inhalt = ((Benutzer)sender).getName() + " hat eine von Dir gestellt Aufgabe bearbeitet.\nBitte korrigiere und bewerte diese Aufgabe zeitnah, damit "+((Benutzer)sender).getName()+ " sein Ergebnis erhält.";
		}
		datum = new Date();
		this.sender = sender;
		this.adressat = adressat;
	}
	
	/**
	 * Gibt zur&uuml;ck, ob eine Nachricht erledigt wurde, falls sie eine Interaktion erfodert
	 * @return true, falls interagiert wurde oder keine Interaktion erforderlich ist
	 */
	public boolean isErledigt() {
		if (handlungErforderlich) {
			return erledigt;
		}
		return true;
	}
	
	/**
	 * Setzt die Interaktion einer Nachricht auf erledigt
	 * @param isErledigt true, falls interagiert wurde
	 */
	public void setErledigt(boolean isErledigt) {
		erledigt = isErledigt;
	}
	
	/**
	 * Gibt den Titel der Nachricht zur&uuml;ck
	 * @return Der Titel der Nachricht
	 */
	public String getTitel() {
		return titel;
	}
	
	/**
	 * Gibt den Inhalt der Nachricht zur&uuml;ck
	 * @return Der Inhalt der Nachricht
	 */
	public String getInhalt() {
		return inhalt;
	}
	
	/**
	 * Gibt das Erstelldatum der Nachricht zur&uuml;ck
	 * @return Das Erstelldatum der Nachricht
	 */
	public Date getDate() {
		return datum;
	}

	/**
	 * Gibt den Adressaten der Nachricht zu&uuml;ck
	 * @return Der Adressat der Nachricht
	 */
	public Object getAdressat() {
		return adressat;
	}
	
	/**
	 * Gibt den Sender der Nachricht zur&uuml;ck
	 * @return Der Sender der Nachricht
	 */
	public Object getSender(){
		return sender;
	}
	
}
