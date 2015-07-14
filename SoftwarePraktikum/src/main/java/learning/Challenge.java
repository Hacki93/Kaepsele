package learning;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Challenge stellt eine abstrakte Generalisierung von Bossfight und Quest dar.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CHALLENGE")
@Inheritance(strategy=InheritanceType.JOINED)
public class Challenge implements java.io.Serializable{
	
	@Id @GeneratedValue
	@Column(name = "challenge_id")
	public int challenge_id;
	
	@Column(name = "datum")
	public Date datum; 
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="benutzer_id")
	public Benutzer benutzer; //Bearbeiter 
	
	@Column(name = "erreichbarePunktzahl")
	public int erreichbarePunktzahl;

	@Column(name = "erreichtePunktzahl")
	protected int erreichtePunktzahl;
		
	public int getChallenge_id() {
		return challenge_id;
	}

	public void setChallenge_id(int challenge_id) {
		this.challenge_id = challenge_id;
	}

	public int getErreichbarePunktzahl() {
		return erreichbarePunktzahl;
	}

	public void setErreichbarePunktzahl(int erreichbarePunktzahl) {
		this.erreichbarePunktzahl = erreichbarePunktzahl;
	}

	public int getErreichtePunktzahl() {
		return erreichtePunktzahl;
	}

	public void setErreichtePunktzahl(int erreichtePunktzahl) {
		this.erreichtePunktzahl = erreichtePunktzahl;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}
	
	public void setBenutzer(Benutzer bearbeiter) {
		this.benutzer = bearbeiter;
	}
	
	public int getId() {
		return challenge_id;
	}
	
	public void setId(int id) {
		challenge_id = id;
	}
	
	public Date getDatum(){
		return datum;
	}
	
	public void setDatum(Date datum) {
		this.datum = datum;
	}
}
