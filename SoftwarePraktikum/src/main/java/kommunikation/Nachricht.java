package kommunikation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import learning.Benutzer;
import learning.Bossfight;
import learning.Gruppe;
import learning.Teamcombat;

/**
 * Diese Klasse stellt den Datentyp Nachricht dar
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "NACHRICHT")
public class Nachricht implements java.io.Serializable{

	@Id @GeneratedValue
	@Column(name = "nachricht_id")
	public int nachricht_id;
	
	@Column(name = "titel")
	private String titel;
	
	@Column(name = "inhalt")
	private String inhalt;
	
	@Column(name = "handlungErforderlich")
	boolean handlungErforderlich;
	
	@Column(name = "datum")
	private Date datum;
	
	@Column(name = "typ")
	private int typ;
	
	@Transient
	private Object adressat;
	
	@Transient
	private Object sender;
	
	@Transient
	private Object anhang;

	

	public static final int FREUNDHINZUGEFUEGT = 0;
	public static final int GRUPPENEINLADUNG = 1;
	public static final int AUFGABEKORRIGIEREN = 2;
	public static final int BEITRITTSANFRAGE = 3;
	public static final int TEAMHERAUSFORDERUNG = 4;
	public static final int AUFGABEBEWERTET = 5;
	public static final int TEAMCOMBATGEWONNEN = 6;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Nachricht(){	}
	
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
			titel = "Bitte korrigiere den Bossfight";
			inhalt = ((Benutzer) sender).getName()
					+ " hat einen Bossfight bearbeitet.\nBitte korrigiere und bewerte diesen Bossfight zeitnah, damit "
					+ ((Benutzer) sender).getName() + " sein Ergebnis erhält.";
			handlungErforderlich = true;
			break;
		case 3:
			titel = ((Benutzer) sender).getName()
					+ "möchte der Gruppe beitreten";
			inhalt = ((Benutzer) sender).getName()
					+ "hat eine Beitrittsanfrage an deine Gruppe "
					+ ((Gruppe) adressat).getName() + " gestellt";
			break;
		case 4:
			titel = "Herausforderung zum Teamcombat";
			inhalt = ((Gruppe) sender).getName() + " hat "
					+ ((Gruppe)adressat).getName() + " herausgefordert";
			handlungErforderlich = true;
			break;
		case 5:
			titel = "Dein Bossfight wurde bewertet";
			if(((Bossfight) anhang).bestanden()){
			inhalt = "Du hast den Bossfight bestanden.";
			} else {
				inhalt = "Du hast den Bossfight leider nicht bestanden.";			
				}
			break;
		case 6: 
			titel = "Teamcombat ausgewertet";
			inhalt = ((Teamcombat) anhang).getGewinner().getName() + "hat den Teamcombat gewonnen";
		}
		this.anhang = anhang;
		datum = new Date();
		this.sender = sender;
		this.adressat = adressat;
		this.typ = typ;
	}

	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
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
	
	public void setAdressat(Object adressat){
		this.adressat = adressat;
	}

	/**
	 * Gibt den Sender der Nachricht zur&uuml;ck
	 * 
	 * @return Der Sender der Nachricht
	 */
	public Object getSender() {
		return sender;
	}
	
	public Object getAnhang() {
		return anhang;
	}

	public void setAnhang(Object anhang) {
		this.anhang = anhang;
	}

}
