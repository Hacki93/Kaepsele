package learning;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Die Klasse Kommentar stellt einen Kommentar zu einem Pinnwandeintrag dar. 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KOMMENTAR")
@PrimaryKeyJoinColumn(name="kommentar_id", referencedColumnName = "inhalt_id")
public class Kommentar extends Inhalt implements java.io.Serializable{

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="thema_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Thema thema;
	
	/**
	 * Konstruktor f&uuml; Hibernate
	 */
	public Kommentar() {}
	
	/**
	 * Konstruktor für ein neuen Kommentar zu einem Pinnwandbeitrag (Inhalt)
	 * 
	 * @param inhalt: Ist der Inhalt des Kommentars
	 * @param titel: Ist der Titel des Kommentars
	 * @param autor: Ist der Autor des Kommentars
	 */
	public Kommentar(String titel, String inhalt, Benutzer autor){
		this.inhalt = inhalt;
		this.titel = titel;
		this.benutzer = autor;
		bewertung = 0;
		datum = new Date();
	}
	
	/**
	 * Entfernt den Kommentar und alle Relationen zu ihm
	 */
	public void entfernen(){
		benutzer = null;
		medium = null;
		thema.kommentare.remove(this);
		thema = null;
	}
	
	public Thema getThema(){
		return thema;
	}
	
	public void setThema(Thema thema){
		this.thema = thema;
	}
}
