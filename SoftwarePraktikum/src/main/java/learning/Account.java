package learning;

import java.util.Observable;

import kommunikation.Nachricht;

public class Account extends Observable implements java.io.Serializable{

	public String benutzername;
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
