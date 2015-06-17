package learning;

import java.util.ArrayList;
import java.util.HashMap;

public class Benutzer extends Account {

	public String name;
	public int rang;
	private int geburtsdatum;
	private String adresse;
	private String beruf;
	private String studiengang;
	public ArrayList<Benutzer> freunde;
	
	private HashMap<Benutzer, Gruppe> gruppen = new HashMap<Benutzer, Gruppe>();
	
	public void freundHinzufügen(Benutzer b){
	}
	
	public void gruppeBeitreten(Gruppe g){
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

	public int getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(int geburtsdatum) {
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
