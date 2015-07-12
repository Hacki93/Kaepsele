package learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import kommunikation.Email;
import kommunikation.Nachricht;

@SuppressWarnings("serial")
@Entity
@Table(name = "BENUTZER")
@PrimaryKeyJoinColumn(name = "benutzer_id", referencedColumnName = "account_id")
public class Benutzer extends Account implements java.io.Serializable {

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

	@Column(name = "beruf")
	private String beruf;

	@Column(name = "studiengang")
	private String studiengang;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "FREUNDE", joinColumns = @JoinColumn(name = "benutzer_id"), inverseJoinColumns = @JoinColumn(name = "freunde_id"))
	public Set<Benutzer> freunde;

	// Hilfskollektion zur Umsetzung eines Many-To-Many Self-Joins
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "freunde")
	public Set<Benutzer> freunde2;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "mitglieder")
	public Set<Gruppe> gruppen;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "moderatoren")
	public Set<Gruppe> moderierteGruppen;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "pinnwand_id")
	public Pinnwand pinnwand;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="benutzer")
	public Set<Inhalt> inhalte;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Benutzer() {
		freunde = new HashSet<Benutzer>();
		gruppen = new HashSet<Gruppe>();
		nachrichten = new HashSet<Nachricht>();
		aufgaben = new HashSet<Nachricht>();
		pinnwand = new Pinnwand();
		moderierteGruppen = new HashSet<Gruppe>();
	}

	/**
	 * Legt einen Benutzer mit den minimal erforderlichen Daten an. Automatisch
	 * erzeugbare Informationen werden automatisch generiert
	 * 
	 * @param benutzername
	 *            Der Benutzername
	 * @param passwort
	 *            Das Passowrt
	 * @param name
	 *            Der angezeigte echte Name
	 * @param emailAdresse
	 *            Die Emailadresse
	 */
	public Benutzer(String benutzername, String passwort, String name,
			String emailAdresse) {
				
		this.passwort = passwort;
		this.benutzername = benutzername;
		this.name = name;
		this.emailAdresse = emailAdresse;
		freunde = new HashSet<Benutzer>();
		gruppen = new HashSet<Gruppe>();
		nachrichten = new HashSet<Nachricht>();
		aufgaben = new HashSet<Nachricht>();
		moderierteGruppen = new HashSet<Gruppe>();
		rang = 0;
		pinnwand = new Pinnwand();
		pinnwand.erlaubteBenutzer.add(this);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String dateString;
		dateString = formatter.format(date);
		try {
			this.setErstelltAm(formatter.parse(dateString));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * F&uuml;gt einen Benutzer zur eigenen Freundesliste hinzu und
	 * benachrichtigt ihn dar&uuml;ber
	 * 
	 * @param benutzer
	 *            Der hinzugef&uuml;gte Benutzer
	 */
	public void freundHinzufügen(Benutzer benutzer) {
		System.out
				.println("Learning:Benutzer:freundHinzufügen: Freund wurde hinzugefügt");
		freunde.add(benutzer);
		benutzer.freunde.add(this);
		pinnwand.erlaubteBenutzer.add(benutzer);
		Nachricht nachricht = new Nachricht(this, benutzer,
				Nachricht.FREUNDHINZUGEFUEGT, this);
		benutzer.benachrichtigen(nachricht);
	}

	/**
	 * Benachrichtigt den Benutzer
	 * 
	 * @param nachricht
	 *            Der Inhalt der Nachricht
	 */
	public void benachrichtigen(Nachricht nachricht) {
		if (nachricht.isHandlungErforderlich()) {
			aufgaben.add(nachricht);
		}
		nachrichten.add(nachricht);
		String anschreiben = "Hallo " + this.getName() + ",\n\n";
		new Email().senden(this.getEmailAdresse(), nachricht.getTitel(),
				anschreiben + nachricht.getInhalt());
	}

	/**
	 * L&oumlscht eine bestimmte Nachricht aus der Liste nachrichten
	 * 
	 * @param nachricht
	 */
	public void nachrichtEntfernen(Nachricht nachricht) {
		nachrichten.remove(nachricht);
	}

	/**
	 * Erm&oumlglicht es, &uumlber eine Aufgabe direkt zu einem bestimmten Objekt zu gelangen
	 * 
	 * @param aufgabe
	 *            Die Aufgabe, die bearbeitet werden soll
	 * @return gibt das Objekt zur&uumlck, das bearbeitet werden soll
	 */
	public Object aufgabeBearbeiten(Nachricht aufgabe) {
		if (aufgabe.getTyp() == Nachricht.AUFGABEKORRIGIEREN) {
			return (Bossfight) aufgabe.getAnhang();
		} else {
			Teamcombat teamcombat = (Teamcombat) aufgabe.getAnhang();
			return teamcombat.bearbeiten(this);
		}
	}

	/**
	 * L&oumlscht eine bestimmte Nachricht aus der Liste aufgaben
	 * 
	 * @param nachricht
	 */
	public void aufgabeErledigt(Nachricht nachricht) {
		aufgaben.remove(nachricht);
	}

	/**
	 * L&oumlscht eine Aufgabe die sich auf ein bestimmtes Objekt bezieht aus der
	 * Liste aufgaben 
	 * 
	 * @param objekt
	 *            Objekt (z.B Teamcombat) auf das sich die Aufgabe bezieht
	 */
	public void aufgabeErledigt(Object objekt) {
		for (Nachricht n : aufgaben) {
			if (n.getAnhang().equals(objekt)) {
				aufgaben.remove(n);
			}
		}
	}

	/**
	 * l&ouml;scht einen Benutzer aus der eigenen Freundesliste
	 * 
	 * @param benutzer
	 *            der gel&ouml;tschte Benutzer
	 */
	public void freundLoeschen(Benutzer benutzer) {
		freunde.remove(benutzer);
		pinnwand.erlaubteBenutzer.remove(benutzer);
	}

	/**
	 * Erstellt eine neue Gruppe
	 * 
	 * @param name
	 *            : Ist der Name der Gruppe
	 * @param fachrichtung
	 *            : Ist die Fachrichtung der Gruppe
	 * @param klausurname
	 *            : Ist die Klausur auf die in der Gruppe gelernt wird
	 */
	public Gruppe gruppeErstellen(String name, Fachrichtung fachrichtung,
			String klausurname) {
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
	 * @param gruppe
	 *            die hinzugef&uuml;gte Gruppe
	 */
	public boolean gruppeBeitreten(Gruppe gruppe) {
		if (gruppe.anzahl() < 15) {
			gruppen.add(gruppe);
			gruppe.mitgliedHinzufuegen(this);
			gruppe.pinnwand.erlaubteBenutzer.add(this);
			Nachricht nachricht = new Nachricht(this, gruppe,
					Nachricht.BEITRITTSANFRAGE, this);
			gruppe.moderatorBenachrichtigen(nachricht);
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
	 * @param gruppe
	 *            die entfernte Gruppe
	 */
	public void gruppeVerlassen(Gruppe gruppe) {
		gruppen.remove(gruppe);
		gruppe.mitgliedLoeschen(this);
		gruppe.pinnwand.erlaubteBenutzer.remove(this);
	}

	/**
	 * Ein Beitrag auf einer Pinnwand eines Benutzers schreiben
	 * 
	 * @param inhalt
	 *            : Ist der Inhalt des Pinnwandbeitrags
	 * @param titel
	 *            : Ist der Titel des Pinnwandbeitrags
	 * @param benutzer
	 *            : Ist der Besitzer der Pinnwand
	 * @return true, falls der Eintrag geschrieben wurde
	 */
	public boolean themaSchreiben(String inhalt, String titel, Benutzer benutzer) {
		if (benutzer.pinnwand.erlaubteBenutzer.contains(this)) {
			Thema thema = new Thema(inhalt, titel, this);
			benutzer.pinnwand.themaHinzufügen(thema);
			return true;
		} else {
			// Der Benutzer befindet sich nicht in der Liste der erlaubten
			// Benutzer
			// Benutzer wird informiert, dass er keinen Pinnwandbeitrag bei
			// diesem Benutzer schreiben darf
			return false;
		}
	}

	/**
	 * Einen Kommentar zu einem Pinnwandbeitrag schreiben
	 * 
	 * @param inhalt
	 *            : Ist der Inhalt des Kommentars
	 * @param titel
	 *            : Ist der Titel des Kommentars
	 * @param benutzer
	 *            : Ist der Besitzer der Pinnwand
	 * @param thema
	 *            : Ist der Pinnwandbeitrag der kommentiert wird
	 * @return true , falls der Kommentar geschrieben wurde
	 */
	public boolean kommentarSchreiben(String inhalt, String titel,
			Benutzer benutzer, Thema thema) {
		if (benutzer.pinnwand.erlaubteBenutzer.contains(this)) {
			Kommentar kommentar = new Kommentar(inhalt, titel, this);
			thema.kommentieren(kommentar);
			return true;
		} else {
			// Der Benutzer befindet sich nicht in der Liste der erlaubten
			// Benutzer
			// Benutzer wird informiert, dass er keinen Kommentar bei diesem
			// Benutzers schreiben darf
			return false;
		}
	}

	/**
	 * Ein Beitrag auf die Pinnwand einer Gruppe schreiben
	 * 
	 * @param inhalt
	 *            : Ist der Inhalt des Kommentars
	 * @param titel
	 *            : Ist der Titel des Kommentars
	 * @param gruppe
	 *            : Ist die Gruppe in der der Beitrag geschrieben wird
	 * @return true, falls der Beitrag geschrieben wurde
	 */
	public boolean gruppenThemaSchreiben(String inhalt, String titel,
			Gruppe gruppe) {
		if (gruppe.pinnwand.erlaubteBenutzer.contains(this)) {
			Thema thema = new Thema(inhalt, titel, this);
			gruppe.pinnwand.themaHinzufügen(thema);
			return true;
		} else {
			// Der Benutzer befindet sich nicht in der Liste der erlaubten
			// Benutzer
			// Benutzer wird informiert, dass er keinen Pinnwandbeitrag bei
			// dieser Gruppe schreiben darf
			return false;
		}
	}

	/**
	 * Einen Kommentar in einer Gruppe schreiben
	 * 
	 * @param inhalt
	 *            : Ist der Inhalt des Kommentars
	 * @param titel
	 *            : Ist der Titel des Kommentars
	 * @param gruppe
	 *            : Ist die Gruppe in der der Beitrag geschrieben wird
	 * @param thema
	 *            : Ist der Pinnwandbeitrag der Kommentiert wird
	 * @return true, falls der Kommentar geschrieben wurde
	 */
	public boolean gruppenKommentarSchreiben(String inhalt, String titel,
			Gruppe gruppe, Thema thema) {
		if (gruppe.pinnwand.erlaubteBenutzer.contains(this)) {
			Kommentar kommentar = new Kommentar(inhalt, titel, this);
			thema.kommentieren(kommentar);
			return true;
		} else {
			// Der Benutzer befindet sich nicht in der Liste der erlaubten
			// Benutzer
			// Benutzer wird informiert, dass er keinen Kommentar in dieser
			// Gruppe schreiben darf
			return false;
		}
	}

	/**
	 * Der Moderator einer Gruppe kann Themen auf der Pinnwand l&oumlschen
	 * 
	 * @param thema
	 *            : Ist das Thema das gel&oumlscht wird
	 * @param gruppe
	 *            : Ist die Gruppe in der das Thema gel&oumlscht wird
	 * @return true, falls das Thema gel&oumlscht wurde
	 */
	public boolean gruppenThemaLöschen(Thema thema, Gruppe gruppe) {
		if (gruppe.moderatoren.contains(this)) {
			gruppe.pinnwand.themaEntfernen(thema);
			for (Kommentar kommentar : thema.getKommentare()) {
				thema.kommentarLöschen(kommentar);
			}
			return true;
		} else {
			// Der Benutzer ist kein Moderator in dieser Gruppe
			// Benutzer wird informiert, dass er in dieser Gruppe kein Moderator
			// ist
			return false;
		}
	}

	/**
	 * Der Moderator einer Gruppe kann einen Kommentar zu eiem Thema l&oumlschen
	 * 
	 * @param thema
	 *            : Unter diesem Thema befindet sich der zu l&oumlschende
	 *            Kommentar
	 * @param gruppe
	 *            : Ist die Gruppe in der der Kommentar gel&oumlscht wird
	 * @param kommentar
	 *            : Ist der Kommentar der gel&oumlscht wird
	 * @return true, falls der Kommentar gel&oumlscht wurde
	 */
	public boolean gruppenKommentarLöschen(Thema thema, Gruppe gruppe,
			Kommentar kommentar) {
		if (gruppe.moderatoren.contains(this)) {
			thema.kommentarLöschen(kommentar);
			return true;
		} else {
			// Der Benutzer ist kein Moderator in dieser Gruppe
			// Benutzer wird informiert, dass er in dieser Gruppe kein Moderator
			// ist
			return false;
		}
	}

	/**
	 * Der Moderator einer Gruppe kann ein Medium aus der Mediathek l&oumlschen
	 * 
	 * @param medium
	 *            : Ist das Medium das gel&oumlscht wird
	 * @param gruppe
	 *            : Ist die Gruppe in dem das Medium liegt
	 * @return true, falls das Medium gel&oumlscht wurde
	 */
	public boolean gruppenMediumLöschen(Medium medium, Gruppe gruppe) {
		if (gruppe.moderatoren.contains(this)) {
			gruppe.mediathek.mediumLöschen(medium);
			return true;
		} else {
			// Der Benutzer ist kein Moderator in dieser Gruppe
			// Benutzer wird informiert, dass er in dieser Gruppe kein Moderator
			// ist
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

	public HashSet<Nachricht> getNachrichten() {
		return nachrichten;
	}

	public HashSet<Nachricht> getAufgaben() {
		return aufgaben;
	}

	public Set<Gruppe> getGruppen() {
		return gruppen;
	}

	public void setGruppen(HashSet<Gruppe> gruppen) {
		this.gruppen = gruppen;
	}
	
	public Date getErstelltAm() {
		return erstelltAm;
	}

	public void setErstelltAm(Date erstelltAm) {
		this.erstelltAm = erstelltAm;
	}
}
