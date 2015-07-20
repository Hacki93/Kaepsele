package kommunikation;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import learning.Benutzer;

/**
 * Die Klasse Nachricht stellt eine reine Textinformation dar, die einem Benutzer sowohl
 * per Email gesendet wird als auch in seinen Benachrichtigungen angezeigt wird.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "NACHRICHT")
@Inheritance(strategy=InheritanceType.JOINED)
public class Nachricht implements java.io.Serializable{
	
	public static final int FREUNDHINZUGEFUEGT 	= 0;
	public static final int GRUPPENEINLADUNG 	= 1;
	public static final int AUFGABEKORRIGIEREN 	= 2;
	public static final int BEITRITTSANFRAGE 	= 3;
	public static final int TEAMHERAUSFORDERUNG = 4;
	public static final int AUFGABEBEWERTET 	= 5;
	public static final int TEAMCOMBATGEWONNEN 	= 6;
	public static final int NEUESPASSWORT 		= 7;
	
	@Id @GeneratedValue
	@Column(name = "nachricht_id")
	public int nachricht_id;
	
	@Column(name = "titel")
	protected String titel;
	
	@Column(name = "inhalt")
	protected String inhalt;
	
	@Column(name = "datum")
	protected String datum;
	
	@Column(name = "typ")
	protected int typ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empfaenger_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Benutzer empfaenger;
	
	/**
	 * Leerer Konstruktor f&uuml;r Hibernate
	 */
	public Nachricht(){	}
	
	/**
	 * Konstruktor, in dem die eigentliche Nachricht autogeneriert wird.
	 * 
	 * @param typ Der Nachrichtentyp
	 * @param nachricht Der Inhalt der Nachricht
	 */
	public Nachricht(int typ, Benutzer empfaenger, Object nachricht, Object nachricht2) {
		switch (typ) {
		case 0:
			titel = "Du hast einen neuen Freund";
			inhalt = (String) nachricht + " hat Dich zu seiner Freundesliste hinzugefügt";
			break;
		case 3:
			titel = (String) nachricht + "möchte der Gruppe beitreten";
			inhalt = (String) nachricht + "hat eine Beitrittsanfrage an deine Gruppe \""
					+ (String) nachricht2 + "\" gestellt";
			break;
		case 5:
			titel = "Dein Bossfight wurde bewertet";
			if((boolean)nachricht){
			nachricht = "Du hast den Bossfight für die Gruppe \"" + (String) nachricht2+ "\" bestanden.";
			} else {
				this.inhalt = "Du hast den Bossfight für die Gruppe \"" + (String) nachricht2+ "\" leider nicht bestanden.";			
			}
			break;
		case 6: 
			titel = "Teamcombat ausgewertet";
			this.inhalt = (String) nachricht + "hat den Teamcombat gewonnen";
			break;

		case 7:
			titel = "Neues Passwort";
			this.inhalt = "Für Deinen Account auf Käpsele.de wurde ein neues Passwort beantragt.\nEs lautet "+nachricht+"\nBitte logge Dich zeitnah ein und ändere Dein Passwort.";
			break;
		}
		datum = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
		this.typ = typ;
		this.empfaenger = empfaenger;
	}
	
	/**
	 * Entfernt die Nachricht und alle Relationen
	 */
	public void entfernen(){

		empfaenger.nachrichten.remove(this);
	}
	
	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ = typ;
	}

	public String getTitel() {
		return titel;
	}
	
	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getInhalt() {
		return inhalt;
	}
	
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public String getDatum() {
		return datum;
	}
	
	public void setDatum(String datum) {
		this.datum = datum;
	}

	public Benutzer getEmpfaenger(){
		return empfaenger;
	}
	
	public void setEmpfaenger(Benutzer empfaenger){
		this.empfaenger = empfaenger;
	}
}
