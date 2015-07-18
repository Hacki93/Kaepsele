package kommunikation;

import java.text.SimpleDateFormat;
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
	private String datum;
	
	@Column(name = "typ")
	private int typ;
	
	@Transient
	private Object adressat;
	
	@Column(name = "adressat_id")
	public int adressat_id;
	
	@Transient
	private Object sender;
	
	@Column(name = "sender_id")
	public int sender_id;
	
	@Transient
	private Object anhang;

	@Column(name = "anhang_id")
	public int anhang_id;
	

	public static final int FREUNDHINZUGEFUEGT 	= 0;
	public static final int GRUPPENEINLADUNG 	= 1;
	public static final int AUFGABEKORRIGIEREN 	= 2;
	public static final int BEITRITTSANFRAGE 	= 3;
	public static final int TEAMHERAUSFORDERUNG = 4;
	public static final int AUFGABEBEWERTET 	= 5;
	public static final int TEAMCOMBATGEWONNEN 	= 6;
	public static final int NEUESPASSWORT 		= 7;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Nachricht(){	}
	
	/**
	 * Konstruktor mit dem die Nachricht angelegt wird
	 * 
	 * @param titel Der Titel der Nachricht
	 * @param inhalt Der Inhalt der Nachricht
	 * @param handlungErforderlich true, falls die Nachricht eine Interaktion erfordert
	 * @param anhang beinhaltet das Objekt auf das sich die Nachricht bezieht
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
					+ "hat eine Beitrittsanfrage an deine Gruppe \""
					+ ((Gruppe) adressat).getName() + "\" gestellt";
			break;
		case 4:
			titel = "Herausforderung zum Teamcombat";
			inhalt = "Die Gruppe \""+((Gruppe) sender).getName() + "\" hat \""
					+ ((Gruppe)adressat).getName() + "\" zum Teamcombat herausgefordert.\nDu hast 3 Tage Zeit, um Dein Quest zu bearbeiten!";
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
			break;
		case 7:
			titel = "Neues Passwort";
			inhalt = "Für Deinen Account auf Käpsele.de wurde ein neues Passwort beantragt.\nEs lautet "+((String) anhang)+"\nBitte logge Dich zeitnah ein und ändere Dein Passwort.";
		}
		this.anhang = anhang;
		datum = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
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

	public String getTitel() {
		return titel;
	}

	public String getInhalt() {
		return inhalt;
	}

	public String getDatum() {
		return datum;
	}
	
	public void setDatum(String datum) {
		this.datum = datum;
	}

	public Object getAdressat() {
		return adressat;
	}
	
	public void setAdressat(Object adressat){
		this.adressat = adressat;
	}

	public Object getSender() {
		return sender;
	}
	
	public void setSender(Object sender) {
		this.sender = sender;
	}
	
	public Object getAnhang() {
		return anhang;
	}

	public void setAnhang(Object anhang) {
		this.anhang = anhang;
	}
	
	public Object getAdressatId() {
		return adressat_id;
	}
	
	public void setAdressatId(int id){
		adressat_id = id;
	}

	public Object getSenderId() {
		return sender_id;
	}
	
	public void setSenderId(int id) {
		sender_id = id;
	}
	
	public Object getAnhangId() {
		return anhang_id;
	}

	public void setAnhangId(int id) {
		anhang_id = id;
	}

}
