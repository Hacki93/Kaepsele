package learning;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CHALLENGE")
@Inheritance(strategy=InheritanceType.JOINED)
public class Challenge implements java.io.Serializable{
	
	@Id @GeneratedValue
	@Column(name = "challenge_id")
	public int challenge_id;
	
	@Column(name = "datum")
	public Date datum; 
	
	@Transient
	public Benutzer bearbeiter; 
	
	@Column(name = "erreichbarePunktzahl")
	public int erreichbarePunktzahl;
	
	@Column(name = "erreichtePunktzahl")
	protected int erreichtePunktzahl;
	
	
	public Benutzer getBearbeiter() {
		return bearbeiter;
	}
	
	public void setBearbeiter(Benutzer bearbeiter) {
		this.bearbeiter = bearbeiter;
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
	
	public int korrigiere(){
		return 0;
	}
	

}
