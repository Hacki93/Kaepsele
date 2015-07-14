package learning;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Set;

import kommunikation.Nachricht;

/**
 * Die Klasse Account stellt eine abtrakte Generalisierung von Admin und Benutzer dar.
 * In ihr werden haupts&auml;chlich die Methoden zum An- und Abmelden verwaltet.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Account")
@Inheritance(strategy=InheritanceType.JOINED)
public class Account implements java.io.Serializable{

	@Id @GeneratedValue
	@Column(name = "account_id", unique=true, nullable=false)
	protected int account_id;
	
	@Column(name = "benutzername")
	public String benutzername;
	
	@Column(name = "passwort")
	protected String passwort;
	
	@Transient 
	Set<Nachricht> nachrichten; 
	
	@Transient 
	Set<Nachricht> aufgaben; 
	
	@Column(name = "emailAdresse")
	String emailAdresse;

	/**
	 * &Uuml;berpr&uuml;ft, ob das eingegebene Passwort zum Benutzer passt
	 * @param angegebenesPasswort Das eingegebene Passwort
	 * @return true, falls das Passwort korrekt ist
	 */
	public boolean login(String angegebenesPasswort){
		if(passwort.equals(angegebenesPasswort)){
			return true;
		}
		return false;
	}
	
	/**
	 * Legt Benutzername und Passwort an
	 * @param angegebenerBenutzername Der Benutzername
	 * @param angegebenesPasswort Das Passwort
	 */
	public void registrieren(String angegebenerBenutzername, String angegebenesPasswort){
		setBenutzername(angegebenerBenutzername);
		neuesPasswort(angegebenesPasswort);
	}
	
	/**
	 * Benachrichtigt den Benutzer
	 * @param nachricht Der Inhalt der Nachricht
	 */
	public void benachrichtigen(Nachricht nachricht){
		if (nachricht.isHandlungErforderlich()){
			aufgaben.add(nachricht);
		}
		nachrichten.add(nachricht);
	}
		
	/**
	 * Transformiert das Passwort von Klartext in einen MD5-Hash, der nur schwer
	 * r&uuml;cktransformierbar ist
	 * @param klarTextPasswort Das Passwort im Klartext
	 * @return Das Passwort als MD5-Hash
	 */
	public static String hashPasswort(String klarTextPasswort) {
		String hashedPasswort = "";
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(klarTextPasswort.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			hashedPasswort = bigInt.toString(16);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return hashedPasswort; 
	}
	
	/**
	 * Setzen und Hashen eines Passwort
	 * @param passwort
	 */
	public void neuesPasswort(String passwort) {
		this.passwort = hashPasswort(passwort);
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	public String getEmailAdresse() {
		return emailAdresse;
	}

	public void setEmailAdresse(String emailAdresse) {
		this.emailAdresse = emailAdresse;
	}
	
	public Set<Nachricht> setNachrichten() {
		return nachrichten;
	}
	
	public void getNachrichten(Set<Nachricht> nachrichten){
		this.nachrichten = nachrichten;
	}
	
	public Set<Nachricht> setAufgaben() {
		return aufgaben;
	}
	
	public void getAufgaben(Set<Nachricht> aufgaben){
		this.aufgaben = aufgaben;
	}
	
	public int getId(){
		return account_id;
	}
	
	public void setId(int id){
		account_id = id;
	}
}
