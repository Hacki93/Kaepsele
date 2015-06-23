package learning;

import java.util.ArrayList;
import java.util.Date;

import kommunikation.Benachrichtigung;
import kommunikation.Nachricht;

public class Benutzer extends Account {

	public Date erstelltAm;
	public String name;
	public int rang;
	private Date geburtsdatum;
	private String adresse;
	private String emailAdresse;
	private String beruf;
	private String studiengang;
	public ArrayList<Benutzer> freunde;
	private ArrayList<Gruppe> gruppen;
	private ArrayList<Nachricht> nachrichten;
	Benachrichtigung benachrichtigung;
	
	/**
	 * Legt einen Benutzer mit den minimal erforderlichen Daten an.
	 * Automatisch erzeugbare Informationen werden automatisch generiert
	 * @param benutzername Der Benutzername
	 * @param passwort Das Passowrt
	 * @param name Der angezeigte echte Name
	 * @param emailAdresse Die Emailadresse
	 */
	public Benutzer(String benutzername, String passwort, String name, String emailAdresse) {
		this.passwort = passwort;
		this.benutzername = benutzername;
		this.name = name;
		this.emailAdresse = emailAdresse;
		freunde = new ArrayList<Benutzer>();
		gruppen = new ArrayList<Gruppe>();
		nachrichten = new ArrayList<Nachricht>();
		rang = 1;
		erstelltAm = new Date();
		benachrichtigung = new Benachrichtigung();
		this.addObserver(benachrichtigung);
	}
	
	/**
	 * Gibt eine Liste der noch zu erledigenden Benachrichtigungen aus
	 * @return Liste alle Nachrichten, die noch eine Interaktion erfodern
	 */
	public ArrayList<Nachricht> getNichtErledigteAufgaben() {
		ArrayList<Nachricht> nichtErledigteNachrichten = new ArrayList<Nachricht>();
		for(Nachricht nachricht : nachrichten) {
			if(!nachricht.isErledigt()) {
				nichtErledigteNachrichten.add(nachricht);
			}
		}
		return nichtErledigteNachrichten;
	}
	
	/**
	 * F&uuml;gt einen Benutzer zur eigenen Freundesliste hinzu und benachrichtigt ihn dar&uuml;ber
	 * @param benutzer Der hinzugef&uuml;gte Benutzer 
	 */
	public void freundHinzuf�gen(Benutzer benutzer){
		System.out.println("Learning:Benutzer:freundHinzuf�gen: Freund wurde hinzugef�gt");
		freunde.add(benutzer);
		Nachricht nachricht = new Nachricht(this, benutzer, Nachricht.FREUNDHINZUGEFUEGT);
		setChanged();
		notifyObservers(nachricht);
	}
	
	/**
	 * l&ouml;scht einen Benutzer aus der eigenen Freundesliste
	 * @param benutzer der gel&ouml;tschte Benutzer
	 */
	public void freundL�schen(Benutzer benutzer){
		freunde.remove(benutzer);
	}
	
	public String getEmailAdresse(){
		return emailAdresse;
	}
	
	public void setEmailAdresse(String emailAdresse){
		this.emailAdresse = emailAdresse;
	}
	
	/**
	 * Eine Gruppe wird in die eigene Gruppenliste hinzugef&uuml;gt
	 * @param gruppe die hinzugef&uuml;gte Gruppe
	 */
	public boolean gruppeBeitreten(Gruppe gruppe){
		if(gruppe.anzahl() < 15){
		gruppen.add(gruppe);
		gruppe.mitgliedHinzuf�gen(this);
		return true;
		}
		else{
			// Die Gruppe ist bereits voll
			// Benutzer wird informiert, dass er der Gruppe nicht beitreten kann
			return false;
		}
	}
	
	/**
	 * Eine Gruppe wird aus der eigenen Gruppenliste entfernt
	 * @param gruppe die entfernte Gruppe
	 */
	public void gruppeVerlassen(Gruppe gruppe){
		gruppen.remove(gruppe);
		gruppe.mitgliedL�schen(this);
	}
	
	public Gruppe gruppeAnlegen(){
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getBeruf() {
		return beruf;
	}

	public void setBeruf(String beruf) {
		this.beruf = beruf;
	}

	public String getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}
	
}
