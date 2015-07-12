package learning;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Die Klasse Fachrichtung stellt eine Speicherklasse dar.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FACHRICHTUNG")
public class Fachrichtung implements java.io.Serializable{

	@Id @GeneratedValue
	@Column(name = "fachrichtung_id")
	private int fachrichtung_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "freigegeben")
	private boolean freigegeben;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="fachrichtung")
	Set<Gruppe> gruppen;
	
	public Fachrichtung() {
		freigegeben = false;
//		gruppen = new HashSet<Gruppe>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getFreigegeben() {
		return freigegeben;
	}
	
	public void setFreigegeben(boolean freigegeben) {
		this.freigegeben = freigegeben;
	}
	
//	public Set<Gruppe> getGruppen() {
//		return gruppen;
//	}
//	
//	public void setGruppen(HashSet<Gruppe> gruppen) {
//		this.gruppen = gruppen;
//	}
}
