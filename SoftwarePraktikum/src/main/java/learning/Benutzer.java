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
	Pinnwand pinnwand;
	
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
		pinnwand = new Pinnwand();
		pinnwand.erlaubteBenutzer.add(this);
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
	public void freundHinzufügen(Benutzer benutzer){
		System.out.println("Learning:Benutzer:freundHinzufügen: Freund wurde hinzugefügt");
		freunde.add(benutzer);
		pinnwand.erlaubteBenutzer.add(benutzer);
		Nachricht nachricht = new Nachricht(this, benutzer, Nachricht.FREUNDHINZUGEFUEGT);
		setChanged();
		notifyObservers(nachricht);
	}
	
	/**
	 * l&ouml;scht einen Benutzer aus der eigenen Freundesliste
	 * @param benutzer der gel&ouml;tschte Benutzer
	 */
	public void freundLöschen(Benutzer benutzer){
		freunde.remove(benutzer);
		pinnwand.erlaubteBenutzer.remove(benutzer);
	}
	
	/**
	 * Erstellt eine neue Gruppe
	 * @param name : Ist der Name der Gruppe
	 * @param fachrichtung : Ist die Fachrichtung der Gruppe
	 * @param klausurname : Ist die Klausur auf die in der Gruppe gelernt wird
	 */
	public void gruppeErstellen(String name, Fachrichtung fachrichtung, String klausurname){
		Gruppe gruppe = new Gruppe(name, fachrichtung, klausurname);
		this.gruppen.add(gruppe);
		gruppe.mitgliedHinzufügen(this);
		gruppe.moderatoren.add(this);
	}
	
	/**
	 * Eine Gruppe wird in die eigene Gruppenliste hinzugef&uuml;gt
	 * @param gruppe die hinzugef&uuml;gte Gruppe
	 */
	public boolean gruppeBeitreten(Gruppe gruppe){
		if(gruppe.anzahl() < 15){
		gruppen.add(gruppe);
		gruppe.mitgliedHinzufügen(this);
		gruppe.pinnwand.erlaubteBenutzer.add(this);
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
		gruppe.mitgliedLöschen(this);
		gruppe.pinnwand.erlaubteBenutzer.remove(this);
	}
	
	/**
	 * Ein Beitrag auf einer Pinnwand eines Benutzers schreiben
	 * @param inhalt : Ist der Inhalt des Pinnwandbeitrags
	 * @param titel : Ist der Titel des Pinnwandbeitrags
	 * @param benutzer : Ist der Besitzer der Pinnwand
	 * @return true, falls der Eintrag geschrieben wurde
	 */
	public boolean themaSchreiben(String inhalt, String titel, Benutzer benutzer){
		if (benutzer.pinnwand.erlaubteBenutzer.contains(this)) {
			Thema thema = new Thema(inhalt, titel, this);
			benutzer.pinnwand.inhaltHinzufügen(thema);
			return true;
		}
		else{
			// Der Benutzer befindet sich nicht in der Liste der erlaubten Benutzer
			// Benutzer wird informiert, dass er keinen Pinnwandbeitrag bei diesem Benutzer schreiben darf
			return false;
		}
	}
	
	/**
	 * Einen Kommentar zu einem Pinnwandbeitrag schreiben
	 * @param inhalt : Ist der Inhalt des Kommentars
	 * @param titel : Ist der Titel des Kommentars
	 * @param benutzer : Ist der Besitzer der Pinnwand
	 * @param thema : Ist der Pinnwandbeitrag der kommentiert wird
	 * @return true , falls der Kommentar geschrieben wurde
	 */
	public boolean kommentarSchreiben(String inhalt, String titel, Benutzer benutzer, Thema thema){
		if (benutzer.pinnwand.erlaubteBenutzer.contains(this)){
			Kommentar kommentar = new Kommentar(inhalt, titel, this);
			thema.kommentieren(kommentar);
			return true;
		}
		else{
			// Der Benutzer befindet sich nicht in der Liste der erlaubten Benutzer
			// Benutzer wird informiert, dass er keinen Kommentar bei diesem Benutzers schreiben darf
			return false;
		}
	}
	
	/**
	 * Ein Beitrag auf die Pinnwand einer Gruppe schreiben
	 * @param inhalt : Ist der Inhalt des Kommentars
	 * @param titel : Ist der Titel des Kommentars
	 * @param gruppe : Ist die Gruppe in der der Beitrag geschrieben wird
	 * @return 	true, falls der Beitrag geschrieben wurde
	 */
	public boolean gruppenThemaSchreiben(String inhalt, String titel, Gruppe gruppe){
		if (gruppe.pinnwand.erlaubteBenutzer.contains(this)){
			Thema thema = new Thema(inhalt, titel, this);
			gruppe.pinnwand.inhaltHinzufügen(thema);
			return true;
		}
		else{
			// Der Benutzer befindet sich nicht in der Liste der erlaubten Benutzer
			// Benutzer wird informiert, dass er keinen Pinnwandbeitrag bei dieser Gruppe schreiben darf
			return false;
		}
	}
	
	/**
	 * Einen Kommentar in einer Gruppe schreiben
	 * @param inhalt : Ist der Inhalt des Kommentars
	 * @param titel : Ist der Titel des Kommentars
	 * @param gruppe : Ist die Gruppe in der der Beitrag geschrieben wird
	 * @param thema : Ist der Pinnwandbeitrag der Kommentiert wird
	 * @return true, falls der Kommentar geschrieben wurde
	 */
	public boolean gruppenKommentarSchreiben(String inhalt, String titel, Gruppe gruppe, Thema thema){
		if (gruppe.pinnwand.erlaubteBenutzer.contains(this)){
			Kommentar kommentar = new Kommentar(inhalt, titel, this);
			thema.kommentieren(kommentar);
			return true;
		}
		else{
			// Der Benutzer befindet sich nicht in der Liste der erlaubten Benutzer
			// Benutzer wird informiert, dass er keinen Kommentar in dieser Gruppe schreiben darf
			return false;
		}
	}
	
	public String getEmailAdresse(){
		return emailAdresse;
	}
	
	public void setEmailAdresse(String emailAdresse){
		this.emailAdresse = emailAdresse;
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
