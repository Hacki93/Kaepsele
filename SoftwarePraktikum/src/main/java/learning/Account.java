package learning;

import java.util.Observable;

import kommunikation.Benachrichtigung;

public class Account extends Observable{

	private String benutzername;
	private String passwort;
	
	public void login(){
	}
	
	public void logout(){		
	}
	
	public void registrieren(){
	}
	
	public void benachritigen(Benachrichtigung b){
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
