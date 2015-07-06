package learning;

import java.util.Observable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import kommunikation.Nachricht;

@Entity
@Table(name = "Account")
@Inheritance(strategy=InheritanceType.JOINED)
public class Account extends Observable implements java.io.Serializable{

	@Id @GeneratedValue
	@Column(name = "account_id")
	public int account_id;
	
	@Column(name = "benutzername")
	public String benutzername;
	
	@Column(name = "passwort")
	protected String passwort;
	
	public void login(){
	}
	
	public void logout(){		
	}
	
	public void registrieren(){
	}
	
	public void benachritigen(Nachricht nachricht){
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
	
}
