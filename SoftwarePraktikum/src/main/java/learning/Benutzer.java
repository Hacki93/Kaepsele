package learning;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import kommunikation.Aufgabe;
import kommunikation.Email;
import kommunikation.Nachricht;

/**
 * Die Klasse Benutzer beinhaltet s&auuml;mtliche Informationen zum Profil eines Benutzers sowie
 * Methoden, um diese zu verwalten
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "BENUTZER")
@PrimaryKeyJoinColumn(name = "benutzer_id", referencedColumnName = "account_id")
public class Benutzer extends Account implements java.io.Serializable {

	@Column(name = "erstelltAm")
	public String erstelltAm;

	@Column(name = "name")
	public String name;

	@Column(name = "rang")
	public int rang;

	@Column(name = "geburtsdatum")
	private String geburtsdatum;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "beruf")
	private String beruf;

	@Column(name = "studiengang")
	private String studiengang;
	
	@Column(name = "profilbildurl")
	private String profilbildurl;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "BENUTZER_FREUNDE", joinColumns = 
	@JoinColumn(name = "benutzer_id"), inverseJoinColumns = 
	@JoinColumn(name = "freunde_id"))
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<Benutzer> freunde;

	// Hilfskollektion zur Umsetzung eines Many-To-Many Self-Joins
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "freunde")
	public Set<Benutzer> freunde2;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "mitglieder")
	public Set<Gruppe> gruppen;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "moderatoren")
	public Set<Gruppe> moderierteGruppen;

	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "pinnwand_id")
	public Pinnwand pinnwand;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "erlaubteBenutzer")
	public Set<Pinnwand> erlaubtePinnwaende;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="benutzer", orphanRemoval = true)
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<Inhalt> inhalte;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="empfaenger", orphanRemoval = true)
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<Nachricht> nachrichten; 
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="empfaengerBenutzer", orphanRemoval = true)
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<Aufgabe> aufgaben; 

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Benutzer() {
		freunde = new HashSet<Benutzer>();
		gruppen = new HashSet<Gruppe>();
		nachrichten = new HashSet<Nachricht>();
		aufgaben = new HashSet<Aufgabe>();
		pinnwand = new Pinnwand();
		pinnwand.erlaubteBenutzer.add(this);
		moderierteGruppen = new HashSet<Gruppe>();
		erlaubtePinnwaende = new HashSet<Pinnwand>();
		erlaubtePinnwaende.add(pinnwand);
	}

	/**
	 * Legt einen Benutzer mit den minimal erforderlichen Daten an. Automatisch
	 * erzeugbare Informationen werden automatisch generiert
	 * 
	 * @param benutzername Der Benutzername
	 * @param passwort Das Passwort
	 * @param name Der angezeigte echte Name
	 * @param emailAdresse Die Emailadresse
	 */
	public Benutzer(String benutzername, String passwort, String name, String emailAdresse) {	
		neuesPasswort(passwort);
		this.benutzername = benutzername;
		this.name = name;
		this.emailAdresse = emailAdresse;
		freunde = new HashSet<Benutzer>();
		gruppen = new HashSet<Gruppe>();
		nachrichten = new HashSet<Nachricht>();
		aufgaben = new HashSet<Aufgabe>();
		moderierteGruppen = new HashSet<Gruppe>();
		rang = 0;
		pinnwand = new Pinnwand();
		pinnwand.erlaubteBenutzer.add(this);
		erlaubtePinnwaende = new HashSet<Pinnwand>();
		erlaubtePinnwaende.add(pinnwand);
		erstelltAm = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	/**
	 * F&uuml;gt einen Benutzer zur eigenen Freundesliste hinzu und
	 * benachrichtigt ihn dar&uuml;ber
	 * 
	 * @param benutzer Der hinzuzuf&uuml;gende Benutzer
	 */
	public void freundHinzufuegen(Benutzer benutzer) {
		freunde.add(benutzer);
		pinnwand.erlaubteBenutzer.add(benutzer);
		Nachricht nachricht = new Nachricht(Nachricht.FREUNDHINZUGEFUEGT, benutzer, this.getName(), null);
		benutzer.benachrichtigen(nachricht);
	}
	
	/**
	 * Setz f&uuml;r den Benutzer ein neues zuf&auml;lliges alphanumerisches Passwort
	 * 
	 * @return Das neue Passwort
	 */
	public void resetPasswort() {
		String quelle = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!?§$%&/()=";
		Random zufall = new Random();
		StringBuilder neuesPasswort = new StringBuilder(10);
		for( int i = 0; i < 10; i++ ) {
	      neuesPasswort.append(quelle.charAt(zufall.nextInt(quelle.length()) ) );
		}
		neuesPasswort(neuesPasswort.toString());
		Nachricht nachricht = new Nachricht(Nachricht.NEUESPASSWORT, this, neuesPasswort.toString(), null);
		String anschreiben = "Hallo " + this.getName() + ",\n\n";
		String gruss = "\n\nLiebe Grüße,\nDein Käpsele-Team";
		new Email().senden(this.getEmailAdresse(), nachricht.getTitel(), anschreiben + nachricht.getInhalt()+gruss);
	}

	/**
	 * Benachrichtigt den Benutzer
	 * 
	 * @param nachricht Der Inhalt der Nachricht
	 */
	public void benachrichtigen(Nachricht nachricht) {
		if (nachricht instanceof Aufgabe){
			aufgaben.add((Aufgabe)nachricht);
		} else {
			nachrichten.add(nachricht);
		}
		String anschreiben = "Hallo " + this.getName() + ",\n\n";
		String gruss = "\n\nLiebe Grüße,\nDein Käpsele-Team";
		new Email().senden(this.getEmailAdresse(), nachricht.getTitel(), anschreiben + nachricht.getInhalt()+gruss);
	}

	/**
	 * L&oumlscht eine bestimmte Nachricht aus der Liste Nachrichten
	 * 
	 * @param nachricht Die zu l&ouml;schende Nachricht
	 */
	public void nachrichtEntfernen(Nachricht nachricht) {
		nachricht.entfernen();
	}

	/**
	 * Erm&oumlglicht es, &uumlber eine Aufgabe direkt zu einem bestimmten Objekt zu gelangen
	 * 
	 * @param aufgabe Die Aufgabe, die bearbeitet werden soll
	 * @return Das Objekt, das bearbeitet werden soll
	 */
	public Object aufgabeBearbeiten(Nachricht aufgabe) {
		if (aufgabe.getTyp() == Nachricht.AUFGABEKORRIGIEREN) {
			return ((Aufgabe)aufgabe).getAnhangBossfight();
		} else {
			Teamcombat teamcombat = ((Aufgabe)aufgabe).getAnhangTeamcombat();
			return teamcombat.bearbeiten(this);
		}
	}

	/**
	 * L&oumlscht eine bestimmte Nachricht aus der Liste aufgaben
	 * 
	 * @param aufgabe Die zu l&ouml;schende Aufgabe
	 */
	public void aufgabeErledigt(Aufgabe aufgabe) {
		aufgabe.entfernen();
	}

	/**
	 * L&oumlscht eine Aufgabe die sich auf ein bestimmtes Objekt bezieht aus der
	 * Liste aufgaben 
	 * 
	 * @param objekt Objekt (z.B Teamcombat) auf das sich die Aufgabe bezieht
	 */
	public void aufgabeErledigt(Object objekt) {
		Aufgabe aufgabe = new Aufgabe(); 
		for (Aufgabe n : getAufgaben()) {
			if(n.getAnhangBossfight() != null) {
				if(n.getAnhangBossfight().equals(objekt)){
					aufgabe = n;
				}
			}
			if(n.getAnhangTeamcombat() != null) {
				if(n.getAnhangTeamcombat().equals(objekt)){
					aufgabe = n;
				}
			}
			if(n.getAnhangGruppe() != null) {
				if(n.getAnhangGruppe().equals(objekt)){
					aufgabe = n;
				}
			}
		}
		aufgaben.remove(aufgabe);
	}

	/**
	 * L&ouml;scht einen Benutzer aus der eigenen Freundesliste
	 * 
	 * @param benutzer Der zu l&ouml;tschende Benutzer
	 */
	public void freundEntfernen(Benutzer benutzer) {
		freunde.remove(benutzer);
		pinnwand.erlaubteBenutzer.remove(benutzer);
	}

	/**
	 * Erstellt eine neue Gruppe
	 * 
	 * @param name Der Name der Gruppe
	 * @param fachrichtung Die Fachrichtung der Gruppe
	 * @param klausurname Die Klausur auf die in der Gruppe gelernt wird
	 */
	public Gruppe gruppeErstellen(String name, Fachrichtung fachrichtung, String klausurname) {
		Gruppe gruppe = new Gruppe(name, fachrichtung, klausurname);
		gruppen.add(gruppe);
		gruppe.mitgliedHinzufuegen(this);
		gruppe.moderatoren.add(this);
		moderierteGruppen.add(gruppe);
		return gruppe;
	}

	/**
	 * Eine Gruppe wird in die eigene Gruppenliste hinzugef&uuml;gt
	 * 
	 * @param gruppe Die hinzugef&uuml;gte Gruppe
	 */
	public boolean gruppeBeitreten(Gruppe gruppe) {
		if (gruppe.anzahl() < 15) {
			gruppen.add(gruppe);
			gruppe.mitgliedHinzufuegen(this);
			gruppe.pinnwand.erlaubteBenutzer.add(this);
			for (Benutzer moderator : gruppe.moderatoren) {
				Nachricht nachricht = new Nachricht(Nachricht.BEITRITTSANFRAGE, moderator, this.getName(), gruppe.getName());
				moderator.benachrichtigen(nachricht);
			}
			return true;
		} else {
			// Die Gruppe ist bereits voll
			// Benutzer wird informiert, dass er der Gruppe nicht beitreten kann
			return false;
		}
	}

	/**
	 * Eine Gruppe wird aus der eigenen Gruppenliste entfernt
	 * 
	 * @param gruppe Die zu entfernende Gruppe
	 */
	public void gruppeVerlassen(Gruppe gruppe) {
		gruppen.remove(gruppe);
		gruppe.mitgliedLoeschen(this);
		gruppe.pinnwand.erlaubteBenutzer.remove(this);
	}

	/**
	 * Ein Beitrag auf einer Pinnwand eines Benutzers schreiben
	 * 
	 * @param inhalt Der Inhalt des Pinnwandbeitrags
	 * @param titel Der Titel des Pinnwandbeitrags
	 * @param benutzer Der Besitzer der Pinnwand
	 * @return true, falls der Eintrag geschrieben wurde
	 */
	public boolean themaSchreiben(String inhalt, String titel, Benutzer benutzer) {
		if (benutzer.pinnwand.erlaubteBenutzer.contains(this)) {
			Thema thema = new Thema(inhalt, titel, this);
			benutzer.pinnwand.themaHinzufuegen(thema);
			return true;
		} else {
			// Der Benutzer befindet sich nicht in der Liste der erlaubten Benutzer
			// Benutzer wird informiert, dass er keinen Pinnwandbeitrag bei diesem Benutzer schreiben darf
			return false;
		}
	}

	/**
	 * Einen Kommentar zu einem Pinnwandbeitrag schreiben
	 * 
	 * @param inhalt Der Inhalt des Kommentars
	 * @param titel Der Titel des Kommentars
	 * @param benutzer Der Besitzer der Pinnwand
	 * @param thema Der Pinnwandbeitrag der kommentiert wird
	 * @return true, falls der Kommentar geschrieben wurde
	 */
	public boolean kommentarSchreiben(String inhalt, String titel, Benutzer benutzer, Thema thema) {
		if (benutzer.pinnwand.erlaubteBenutzer.contains(this)) {
			Kommentar kommentar = new Kommentar(inhalt, titel, this);
			thema.kommentieren(kommentar);
			return true;
		} else {
			// Der Benutzer befindet sich nicht in der Liste der erlaubten Benutzer
			// Benutzer wird informiert, dass er keinen Kommentar bei diesem Benutzers schreiben darf
			return false;
		}
	}

	/**
	 * Ein Beitrag auf die Pinnwand einer Gruppe schreiben
	 * 
	 * @param inhalt Der Inhalt des Kommentars
	 * @param titel Der Titel des Kommentars
	 * @param gruppe Die Gruppe in der der Beitrag geschrieben wird
	 * @return true, falls der Beitrag geschrieben wurde
	 */
	public boolean gruppenThemaSchreiben(String inhalt, String titel, Gruppe gruppe) {
		if (gruppe.pinnwand.erlaubteBenutzer.contains(this)) {
			Thema thema = new Thema(inhalt, titel, this);
			gruppe.pinnwand.themaHinzufuegen(thema);
			return true;
		} else {
			// Der Benutzer befindet sich nicht in der Liste der erlaubten Benutzer
			// Benutzer wird informiert, dass er keinen Pinnwandbeitrag bei dieser Gruppe schreiben darf
			return false;
		}
	}

	/**
	 * Einen Kommentar in einer Gruppe schreiben
	 * 
	 * @param inhalt Der Inhalt des Kommentars
	 * @param titel Der Titel des Kommentars
	 * @param gruppe Die Gruppe in der der Beitrag geschrieben wird
	 * @param thema Der Pinnwandbeitrag der kommentiert wird
	 * @return true, falls der Kommentar geschrieben wurde
	 */
	public boolean gruppenKommentarSchreiben(String inhalt, String titel, Gruppe gruppe, Thema thema) {
		if (gruppe.pinnwand.erlaubteBenutzer.contains(this)) {
			Kommentar kommentar = new Kommentar(inhalt, titel, this);
			thema.kommentieren(kommentar);
			return true;
		} else {
			// Der Benutzer befindet sich nicht in der Liste der erlaubten Benutzer
			// Benutzer wird informiert, dass er keinen Kommentar in dieser Gruppe schreiben darf
			return false;
		}
	}

	/**
	 * Der Moderator einer Gruppe kann Themen auf der Pinnwand l&oumlschen 
	 * 
	 * @param thema Das Thema das gel&oumlscht wird
	 * @param gruppe Die Gruppe in der das Thema gel&oumlscht wird
	 * @return true, falls das Thema gel&oumlscht wurde
	 */
	public boolean gruppenThemaEntfernen(Thema thema, Gruppe gruppe) {
		if (gruppe.moderatoren.contains(this)) {
			gruppe.pinnwand.themaEntfernen(thema);
			for (Kommentar kommentar : thema.getKommentare()) {
				thema.kommentarEntfernen(kommentar);
			}
			return true;
		} else {
			// Der Benutzer ist kein Moderator in dieser Gruppe
			// Benutzer wird informiert, dass er in dieser Gruppe kein Moderator ist
			return false;
		}
	}

	/**
	 * Der Moderator einer Gruppe kann einen Kommentar zu eiem Thema l&oumlschen
	 * 
	 * @param thema Unter diesem Thema befindet sich der zu l&oumlschende Kommentar
	 * @param gruppe Die Gruppe in der der Kommentar gel&oumlscht wird
	 * @param kommentar Der Kommentar der gel&oumlscht wird
	 * @return true, falls der Kommentar gel&oumlscht wurde
	 */
	public boolean gruppenKommentarEntfernen(Thema thema, Gruppe gruppe,
			Kommentar kommentar) {
		if (gruppe.moderatoren.contains(this)) {
			thema.kommentarEntfernen(kommentar);
			return true;
		} else {
			// Der Benutzer ist kein Moderator in dieser Gruppe
			// Benutzer wird informiert, dass er in dieser Gruppe kein Moderator ist
			return false;
		}
	}

	/**
	 * Erh&oumlht den Rang des Benutzers um 1
	 */
	public void rangErhoehen() {
		rang++;
	}

	/**
	 * Gibt die Bezeichnung des Rangs zur&uuml;ck
	 * 
	 * @return Die Bezeichnung des Rangs
	 */
	public String getRangName() {
		if (rang == 0) {
			return "Seggl";
		} else if (rang == 1) {
			return "Dackel";
		} else if (rang < 3) {
			return "Kerle";
		} else if (rang < 5) {
			return "Hauptkerle";
		} else {
			return "Käpsele";
		}
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

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
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

	public Set<Nachricht> getNachrichten() {
		return nachrichten;
	}
	
	public void setNachrichten(Set<Nachricht> nachrichten){
		this.nachrichten = nachrichten;
	}

	public Set<Aufgabe> getAufgaben() {
		return aufgaben;
	}
	
	public void setAufgaben(Set<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

	public Set<Gruppe> getGruppen() {
		return gruppen;
	}

	public void setGruppen(HashSet<Gruppe> gruppen) {
		this.gruppen = gruppen;
	}
	
	public String getErstelltAm() {
		return erstelltAm;
	}

	public void setErstelltAm(String erstelltAm) {
		this.erstelltAm = erstelltAm;
	}
	
	public Pinnwand getPinnwand(){
		return pinnwand;
	}
	
	public void setPinnwand(Pinnwand pinnwand){
		this.pinnwand = pinnwand;
	}
	
	public Set<Pinnwand> getErlaubtePinnwaende(){
		return erlaubtePinnwaende;
	}
	
	public void setErlaubtePinnwaende(Set<Pinnwand> pinnwand){
		this.erlaubtePinnwaende = pinnwand;
	}
	
	public void setProfilbildURL(String profilbildurl){
		this.profilbildurl = profilbildurl;
	}
	
	public String getProfilbildURL(){
		return profilbildurl;
	}
	
	public Set<Nachricht> setNachrichten() {
		return nachrichten;
	}
	
	public void getNachrichten(Set<Nachricht> nachrichten){
		this.nachrichten = nachrichten;
	}
}
