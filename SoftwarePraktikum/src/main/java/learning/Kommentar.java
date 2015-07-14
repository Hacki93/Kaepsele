package learning;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Die Klasse Kommentar stellt einen Kommentar zu einem Pinnwandeintrag dar. 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KOMMENTAR")
@PrimaryKeyJoinColumn(name="kommentar_id", referencedColumnName = "inhalt_id")
public class Kommentar extends Inhalt implements java.io.Serializable{

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="thema_id")
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
	
	public Thema getThema(){
		return thema;
	}
	
	public void setThema(Thema thema){
		this.thema = thema;
	}
}
