package learning;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "INHALT")
@Inheritance(strategy=InheritanceType.JOINED)
public class Inhalt implements Comparable<Inhalt>, java.io.Serializable{

	@Id @GeneratedValue
	@Column(name = "inhalt_id")
	public int inhalt_id;
	
	@Transient
	public Benutzer autor;
	
	@Column(name = "bewertung")
	public int bewertung;
	
	@Column(name = "inhalt")
	public String inhalt;
	
	@Column(name = "erstelltAm")
	public Date datum;
	
	@Transient
	public Medium anhang;
	
	@Column(name = "titel")
	public String titel;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Inhalt(){}
	
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
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
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
		return inhalt_id;
	}

	public void setId(int id) {
		this.inhalt_id = id;
	}
	
}
