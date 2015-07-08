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
import java.security.*;

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
	public int account_id;
	
	@Column(name = "benutzername")
	public String benutzername;
	
	@Column(name = "passwort")
	public String passwort;
	
	@Transient
	boolean loggedIn;
	
	/**
	 * &Uuml;berpr&uuml;ft, ob das eingegebene Passwort zum Benutzer passt
	 * @param angegebenesPasswort Das eingegebene Passwort
	 * @return true, falls das Passwort korrekt ist
	 */
	public boolean login(String angegebenesPasswort){
		return true; //Anmelden ohne Datenbank
//		if(passwort.equals(angegebenesPasswort)){
//			loggedIn = true;
//			return true;
//		}
//		loggedIn = false;
//		return false;
	}
	
	/**
	 * Meldet den Benutzer ab
	 */
	public void logout(){		
		loggedIn = false;
	}
	
	/**
	 * Legt Benutzername und Passwort an
	 * @param angegebenerBenutzername Der Benutzername
	 * @param angegebenesPasswort Das Passwort
	 */
	public void registrieren(String angegebenerBenutzername, String angegebenesPasswort){
		setBenutzername(angegebenerBenutzername);
		setPasswort(angegebenesPasswort);
	}
	
	/**
	 * Benachrichtigt den Benutzer
	 * @param nachricht Der Inhalt der Nachricht
	 */
	public void benachrichtigen(Nachricht nachricht){
		//TODO!
	}

	/**
	 * Gibt den Benutzernamen zur&uuml;ck
	 * @return Der Benutzername
	 */
	public String getBenutzername() {
		return benutzername;
	}

	/**
	 * Private Hilfsmethode zum Setzen von Benutzernamen durch Hiberante/Registrierung
	 * @param benutzername Der Benutzername
	 */
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	/**
	 * Private Hilfsmethode zum Setzen von Passwort durch Hiberante/Registrierung
	 * @param benutzername Das Passwort
	 */
	public String getPasswort() {
		return passwort;
	}

	/**
	 * Setzen eines Passworts ohne Angabe des alten Passworts
	 * @param passwort
	 */
	public void setPasswort(String passwort) {
		this.passwort = hashPasswort(passwort);
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
}
