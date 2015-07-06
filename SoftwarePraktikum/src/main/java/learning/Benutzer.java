package learning;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import kommunikation.Nachricht;

@SuppressWarnings("serial")
@Entity
@Table(name = "BENUTZER")
@PrimaryKeyJoinColumn(name="benutzer_id", referencedColumnName = "account_id")
public class Benutzer extends Account implements java.io.Serializable{

	@Column(name = "erstelltAm")
	public Date erstelltAm;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "rang")
	public int rang;
	
	@Column(name = "geburtsdatum")
	private Date geburtsdatum;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "emailAdresse")
	private String emailAdresse;
	
	@Column(name = "beruf")
	private String beruf;
	
	@Column(name = "studiengang")
	private String studiengang;
	
	@Transient
	public Set<Benutzer> freunde;
	
	@ManyToMany(mappedBy = "mitglieder")
	private Set<Gruppe> gruppen;
	
	@Transient
	private ArrayList<Nachricht> nachrichten;
	
	@Transient
	private ArrayList<Nachricht> aufgaben;
	
	@Transient
	private Pinnwand pinnwand;
	
	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Benutzer(){
		freunde = new HashSet<Benutzer>();
		gruppen = new HashSet<Gruppe>();
		nachrichten = new ArrayList<Nachricht>();
		aufgaben = new ArrayList<Nachricht>();
		pinnwand = new Pinnwand();
	}
	
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
		freunde = new HashSet<Benutzer>();
		gruppen = new HashSet<Gruppe>();
		nachrichten = new ArrayList<Nachricht>();
		aufgaben = new ArrayList<Nachricht>();
		rang = 1;
		erstelltAm = new Date();
		pinnwand = new Pinnwand();
		pinnwand.erlaubteBenutzer.add(this);
	}
	
	
	/**
	 * F&uuml;gt einen Benutzer zur eigenen Freundesliste hinzu und benachrichtigt ihn dar&uuml;ber
	 * @param benutzer Der hinzugef&uuml;gte Benutzer 
	 */
	public void freundHinzufügen(Benutzer benutzer){
		System.out.println("Learning:Benutzer:freundHinzufügen: Freund wurde hinzugefügt");
		freunde.add(benutzer);
		benutzer.freunde.add(this);
		for(Benutzer b : freunde) {
			System.out.println(b.name);
		}
		pinnwand.erlaubteBenutzer.add(benutzer);
		Nachricht nachricht = new Nachricht(this, benutzer, Nachricht.FREUNDHINZUGEFUEGT, this);
		benutzer.benachrichtigen(nachricht);
	}
	
	/**
	 * Speichert eine Benachrichtigung in der Liste nachrichten
	 * Wenn die Nachricht auch eine Handlung erfordert wird die Nachricht zusaetzlich in der Liste 
	 * aufgaben gespeichert
	 * @param nachricht
	 */
	public void benachrichtigen(Nachricht nachricht){
		if (nachricht.isHandlungErforderlich()){
			aufgaben.add(nachricht);
		}
		nachrichten.add(nachricht);
	}
	
	/**
	 * Loescht eine bestimmte Nachricht aus der Liste nachrichten
	 * @param nachricht
	 */
	public void nachrichtEntfernen(Nachricht nachricht){
		nachrichten.remove(nachricht);
	}
	
	/**
	 * Loescht eine bestimmte Nachricht aus der Liste aufgaben
	 * @param nachricht
	 */
	public void aufgabeErledigt(Nachricht nachricht){
		aufgaben.remove(nachricht);
	}
	
	/**
	 * l&ouml;scht einen Benutzer aus der eigenen Freundesliste
	 * @param benutzer der gel&ouml;tschte Benutzer
	 */
	public void freundLoeschen(Benutzer benutzer){
		freunde.remove(benutzer);
		pinnwand.erlaubteBenutzer.remove(benutzer);
	}
	
	/**
	 * Erstellt eine neue Gruppe
	 * @param name : Ist der Name der Gruppe
	 * @param fachrichtung : Ist die Fachrichtung der Gruppe
	 * @param klausurname : Ist die Klausur auf die in der Gruppe gelernt wird
	 */
	public Gruppe gruppeErstellen(String name, Fachrichtung fachrichtung, String klausurname){
		Gruppe gruppe = new Gruppe(name, fachrichtung, klausurname);
		gruppen.add(gruppe);
		gruppe.mitgliedHinzufuegen(this);
		gruppe.moderatoren.add(this);
		return gruppe;
	}
	
	/**
	 * Eine Gruppe wird in die eigene Gruppenliste hinzugef&uuml;gt
	 * @param gruppe die hinzugef&uuml;gte Gruppe
	 */
	public boolean gruppeBeitreten(Gruppe gruppe){
		if(gruppe.anzahl() < 15){
		gruppen.add(gruppe);
		gruppe.mitgliedHinzufuegen(this);
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
		gruppe.mitgliedLoeschen(this);
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
	
	/**
	 * Der Moderator einer Gruppe kann Themen auf der Pinnwand löschen
	 * @param thema : Ist das Thema das gel&oumlscht wird
	 * @param gruppe : Ist die Gruppe in der das Thema gel&oumlscht wird
	 * @return true, falls das Thema gel&oumlscht wurde
	 */
	public boolean gruppenThemaLöschen(Thema thema, Gruppe gruppe){
		if(gruppe.moderatoren.contains(this)){
			gruppe.pinnwand.inhaltLöschen(thema);
			for(Kommentar kommentar : thema.getKommentare()){
				thema.kommentarLöschen(kommentar);
			}
			return true;
		}
		else{
			// Der Benutzer ist kein Moderator in dieser Gruppe
			// Benutzer wird informiert, dass er in dieser Gruppe kein Moderator ist
			return false;
		}
	}
	
	/**
	 * Der Moderator einer Gruppe kann einen Kommentar zu eiem Thema löschen
	 * @param thema : Unter diesem Thema befindet sich der zu l&oumlschende Kommentar
	 * @param gruppe : Ist die Gruppe in der der Kommentar gel&oumlscht wird
	 * @param kommentar : Ist der Kommentar der gel&oumlscht wird
	 * @return true, falls der Kommentar gel&oumlscht wurde
	 */
	public boolean gruppenKommentarLöschen(Thema thema, Gruppe gruppe, Kommentar kommentar){
		if(gruppe.moderatoren.contains(this)){
			thema.kommentarLöschen(kommentar);
			return true;
		}
		else{
			// Der Benutzer ist kein Moderator in dieser Gruppe
			// Benutzer wird informiert, dass er in dieser Gruppe kein Moderator ist
			return false;
		}
	}
	
	/**
	 * Der Moderator einer Gruppe kann ein Medium aus der Mediathek löschen
	 * @param medium : Ist das Medium das gel&oumlscht wird
	 * @param gruppe : Ist die Gruppe in dem das Medium liegt
	 * @return true, falls das Medium gel&oumlscht wurde
	 */
	public boolean gruppenMediumLöschen(Medium medium, Gruppe gruppe){
		if(gruppe.moderatoren.contains(this)){
			gruppe.mediathek.mediumLöschen(medium);
			return true;
		}
		else{
			// Der Benutzer ist kein Moderator in dieser Gruppe
			// Benutzer wird informiert, dass er in dieser Gruppe kein Moderator ist
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
	
	public ArrayList<Nachricht> getNachrichten(){
		return nachrichten;
	}
	
	public ArrayList<Nachricht> getAufgaben(){
		return aufgaben;
	}
	
	public Set<Gruppe> getGruppen(){
		return gruppen;
	}
	
	public void setGruppen(HashSet<Gruppe> gruppen) {
		this.gruppen = gruppen;
	}
}
