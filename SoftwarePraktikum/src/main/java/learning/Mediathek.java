package learning;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "MEDIATHEK")
public class Mediathek implements java.io.Serializable{

	@Id @GeneratedValue
	@Column(name = "mediathek_id")
	private int mediathek_id;
	
	@OneToMany(mappedBy="mediathek", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Medium> medien;
	
	/**
	 * Konstruktor der Mediathek
	 */
	public Mediathek(){
		medien = new HashSet<Medium>();
	}
	
	/**
	 * Gibt den Pfad des Mediums an
	 * @param id : Idendifiziert das Medium
	 * @return pfad des Mediums
	 */
	public String getMedium(int id){
		for (Medium medium : this.medien){
			if (medium.getId() == id){
				return medium.getPfad();
			}
		}
		return null;
	}
	
	/**
	 * F&uumlgt ein Medium in die Mediatehek hinzu
	 * @param medium das hinzugef&uumlgt werden soll
	 */
	public void mediumHinzufügen(Medium medium){
		this.medien.add(medium);
		medium.setMediathek(this);
	}
	
	/**
	 * l&oumlscht ein Medium aus der Mediathek
	 * @param medium das gel&oumlscht werden soll
	 */
	public void mediumLöschen(Medium medium){
		this.medien.remove(medium);
	}
	
	public Set<Medium> getMedien(){
		return medien;
	}
	
	public void setMedien(Set<Medium> medien){
		this.medien = medien;
	}
	
	public int getId(){
		return mediathek_id;
	}
	
	public void setId(int id){
		mediathek_id = id;
	}
}
