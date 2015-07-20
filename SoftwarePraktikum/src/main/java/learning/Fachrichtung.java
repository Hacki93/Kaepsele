package learning;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Die Klasse Fachrichtung stellt eine Speicherklasse für die Fachrichtungen von Gruppen dar.
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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="fachrichtung", orphanRemoval = true)
	@Cascade(CascadeType.SAVE_UPDATE)
	Set<Gruppe> gruppen;
	
	/**
	 * Leerer Konstruktor für Hibernate und zum Hinzuf&uuml;gen von Fachrichtungen
	 */
	public Fachrichtung() {
		freigegeben = false;
		gruppen = new HashSet<Gruppe>();
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
	
	public Set<Gruppe> getGruppen() {
		return gruppen;
	}
	
	public void setGruppen(HashSet<Gruppe> gruppen) {
		this.gruppen = gruppen;
	}
	
	public int getId(){
		return fachrichtung_id;
	}
	
	public void setId(int id){
		fachrichtung_id = id;
	}
}
