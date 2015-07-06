package learning;

import java.util.Date;

public class Inhalt implements Comparable<Inhalt>, java.io.Serializable{

	public Benutzer autor;
	public int bewertung;
	public String inhalt;
	public Date erstelltAm;
	public Medium anhang;
	public String titel;
	public int id;
	
	/**
	 * Bewertung eines Inhalts
	 * @param wertung kann positiv oder negativ sein
	 */
	public void bewerten(boolean wertung){
		if(wertung == true){
			bewertung++;
		}
		else if(wertung == false){
			bewertung--;
		}
	}
	
	@Override
	public int compareTo(Inhalt inhalt) {
		if (inhalt.getBewertung() == 0 && this.getBewertung() == 0){
			return 0;
		}
		if (this.getBewertung() == 0){
			return 1;
		}
		if (inhalt.getBewertung() == 0){
			return -1;
		}
		return inhalt.getBewertung() - this.getBewertung();
	}

	public Benutzer getAutor() {
		return autor;
	}

	public void setAutor(Benutzer autor) {
		this.autor = autor;
	}

	public int getBewertung() {
		return bewertung;
	}

	public void setBewertung(int bewertung) {
		this.bewertung = bewertung;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public Date getDatum() {
		return erstelltAm;
	}

	public void setDatum(Date datum) {
		erstelltAm = datum;
	}

	public Medium getAnhang() {
		return anhang;
	}

	public void setAnhang(Medium anhang) {
		this.anhang = anhang;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
