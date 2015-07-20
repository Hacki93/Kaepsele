package kommunikation;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import learning.Benutzer;
import learning.Bossfight;
import learning.Gruppe;
import learning.Teamcombat;

/**
 * Die Klasse Aufgabe stellt eine Spezialisierung der reinen Nachricht dar, bei der
 * nicht nur Textelemente sondern auch ganze Objekte mitgegegeben werden k&ouml;nnen.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "AUFGABE")
@PrimaryKeyJoinColumn(name="aufgabe_id", referencedColumnName = "nachricht_id")
public class Aufgabe extends Nachricht implements java.io.Serializable{
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "senderGruppe_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Gruppe senderGruppe;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "senderBenutzer_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Benutzer senderBenutzer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empfaengerBenutzer_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Benutzer empfaengerBenutzer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "anhangTeamcombat_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Teamcombat anhangTeamcombat;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "anhangBossfight_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Bossfight anhangBossfight;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "anhangGruppe_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Gruppe anhangGruppe;
	
	/**
	 * Leerer Konstruktor f&uuml;r Hibernate
	 */
	public Aufgabe(){  }
	
	/**
	 * Erstellt eine neue Nachricht vom Typ Aufgabe
	 * 
	 * @param typ Der Nachrichtentyp
	 * @param sender Der Absender
	 * @param adressat Der Adressat
	 * @param anhang Ein angeh&auml;ngtes Objekt
	 */
	public Aufgabe(int typ, Object sender, Object adressat, Object anhang) {
		senderGruppe = null;
		senderBenutzer = null;
		anhangTeamcombat = null;
		anhangBossfight = null;
		anhangGruppe = null;
		switch (typ) {
		case 1:
			senderGruppe = (Gruppe) sender;
			empfaengerBenutzer = (Benutzer) adressat;
			anhangGruppe = (Gruppe) anhang;
			titel = "Du wurdest in eine Gruppe eingeladen";
			inhalt = "Du wurdest in die Gruppe \""
					+ ((Gruppe) sender).getName() + "\" eingeladen";
			break;
		case 2:
			senderBenutzer = (Benutzer) sender;
			empfaengerBenutzer = (Benutzer) adressat;
			anhangBossfight = (Bossfight) anhang;
			titel = "Bitte korrigiere den Bossfight";
			inhalt = ((Benutzer) sender).getName()
					+ " hat einen Bossfight bearbeitet.\nBitte korrigiere und bewerte diesen Bossfight zeitnah, damit "
					+ ((Benutzer) sender).getName() + " sein Ergebnis erhält.";
			break;
		case 4:
			senderGruppe = (Gruppe) sender;
			empfaengerBenutzer = (Benutzer) adressat;
			anhangTeamcombat = (Teamcombat) anhang;
			titel = "Herausforderung zum Teamcombat";
			inhalt = "Die Gruppe \""+((Teamcombat) anhang).herausforderer.getName() + "\" hat \""
					+ ((Teamcombat) anhang).herausgeforderter.getName() + "\" zum Teamcombat herausgefordert.\nDu hast 3 Tage Zeit, um Dein Quest zu bearbeiten!";
			break;
		}
		datum = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
		this.typ = typ;				
	}	
	
	public Bossfight getAnhangBossfight(){
		return anhangBossfight;
	}
	
	public void setAnhangBossfight(Bossfight bossfight){
		anhangBossfight = bossfight;
	}
	
	public Teamcombat getAnhangTeamcombat(){
		return anhangTeamcombat;
	}
	
	public void setTAnhangTeamcombat(Teamcombat teamcombat){
		anhangTeamcombat = teamcombat;
	}
	
	public Gruppe getAnhangGruppe(){
		return anhangGruppe;
	}
	
	public Gruppe getSenderGruppe(){
		return senderGruppe;
	}
	
	public void setSenderGruppe(Gruppe sender){
		senderGruppe = sender;
	}
	
	public Benutzer getSenderBenutzer(){
		return senderBenutzer;
	}
	
	public void setSenderBenutzer(Benutzer sender){
		senderBenutzer = sender;
	}
	
	public Benutzer getEmpfaengerrBenutzer(){
		return empfaengerBenutzer;
	}
	
	public void setEmpfaengerBenutzer(Benutzer empfaenger){
		empfaengerBenutzer = empfaenger;
	}
}
