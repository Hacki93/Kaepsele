package learning;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "THEMA")
@PrimaryKeyJoinColumn(name="thema_id", referencedColumnName = "inhalt_id")
public class Thema extends Inhalt implements java.io.Serializable{

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="thema")
	private Set<Kommentar> kommentare;
    
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="pinnwand_id")
    private Pinnwand pinnwand;
	
    /**
     * Konstruktor f&uuml;r Hibernate
     */
    public Thema(){
    	kommentare = new HashSet<Kommentar>();
    }
    
    public Set<Kommentar> getKommentare(){ 
    	return kommentare;
    }
    
    public void setKommentare(Set<Kommentar> kommentare){
    	this.kommentare = kommentare;
    }
    
    
	/**
	 * Konstruktor für ein neuen Pinnwandbeitrag
	 * 
	 * @param inhalt: Ist der Inhalt des Pinnwandbeitrags
	 * @param titel: Ist der Titel des Pinnwandbeitrags
	 * @param autor: Ist der Autor des Pinnwandbeitrags
	 */
	public Thema(String inhalt, String titel, Benutzer autor){
		this.inhalt = inhalt;
		this.titel = titel;
		this.autor= autor;
		bewertung = 0;
		datum = new Date();
		kommentare = new HashSet<Kommentar>();
	}
	
	/**
	 * Erstellt einen Kommentar zu einem Pinnwandbeitrag (Inhalt)
	 * @param kommentar der hinzugef&uuml;gte Kommentar
	 */
	public void kommentieren(Kommentar kommentar){
		kommentare.add(kommentar);
	}
	
	/**
	 * L&ouml;scht einen Kommentar
	 * @param kommentar der gel&oumlschte Kommentar
	 */
	public void kommentarLöschen(Kommentar kommentar){
		kommentare.remove(kommentar);
	}
	
//	/**
//	 * Sortiert die Kommentare nach dem neusten Datum
//	 * @return die sortierte Kommentarliste
//	 */
//	public Set<Kommentar> sortiereNachDatum(){
//		Stack<Kommentar> tempStack = new Stack<Kommentar>();
//		for(int i = 1; i < this.kommentare.size(); i++){
//			for(int j = 0; j < this.kommentare.size() - 1; j++){
//				if (this.kommentare..get(j).getDatum().compareTo(this.kommentare.get(j+1).getDatum()) < 0){
//					tempStack.push(this.kommentare.get(j));
//					this.kommentare.set(j, this.kommentare.get(j+1));
//					this.kommentare.set(j+1, tempStack.pop());
//				}
//			}
//		}	
//		return this.kommentare;
//	}
	
//	/**
//	 * Sortiert die Kommentare nach den besten Bewertungen
//	 * @return sortierte Kommentarliste
//	 */
//	public ArrayList<Kommentar> sortiereNachBewertung(){
//		Collections.sort(this.kommentare);
//		return this.kommentare;
//	}

}
