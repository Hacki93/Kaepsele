package learning;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Die Klasse Fachrichtung stellt eine Speicherklasse dar.
 * @author Hannes
 */
@Entity
@Table(name = "FACHRICHTUNG")
public class Fachrichtung {

	@Id @GeneratedValue
	@Column(name = "id")
	public int id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "freigegeben")
	public boolean freigegeben;
	
	public Fachrichtung(String name, boolean freigegeben) {
		this.name = name;
		this.freigegeben = freigegeben;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isFreigegeben() {
		return freigegeben;
	}
	
	public void setFreigegeben(boolean freigegeben) {
		this.freigegeben = freigegeben;
	}
}
