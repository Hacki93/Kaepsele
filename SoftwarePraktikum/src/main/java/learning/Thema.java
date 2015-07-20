package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Die Klasse Thema stellt einen Beitrag auf der Pinnwand eines Freundes bzw.
 * einer Gruppe dar.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "THEMA")
@PrimaryKeyJoinColumn(name="thema_id", referencedColumnName = "inhalt_id")
public class Thema extends Inhalt implements java.io.Serializable{

	@OneToMany(fetch = FetchType.EAGER, mappedBy="thema", orphanRemoval = true)
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<Kommentar> kommentare;
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pinnwand_id")
	@Cascade(CascadeType.SAVE_UPDATE)
    public Pinnwand pinnwand;
	
    /**
     * Konstruktor f&uuml;r Hibernate
     */
    public Thema(){
    	kommentare = new HashSet<Kommentar>();
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
		this.benutzer = autor;
		bewertung = 0;
		datum = new Date();
		kommentare = new HashSet<Kommentar>();
	}
	
	/**
	 * Entfernt ein Thema und alle Relationen zu ihm
	 */
	public void entfernen(){
		pinnwand.themen.remove(this);
		benutzer = null;
		pinnwand = null;
		medium = null;
		for(Kommentar k : kommentare) {
			kommentarEntfernen(k);
		}
		kommentare.clear();
	}
	
	/**
	 * Erstellt einen Kommentar zu einem Pinnwandbeitrag (Inhalt)
	 * 
	 * @param kommentar der hinzugef&uuml;gte Kommentar
	 */
	public void kommentieren(Kommentar kommentar){
		kommentar.setThema(this);
		kommentare.add(kommentar);
	}
	
	/**
	 * L&ouml;scht einen Kommentar
	 * 
	 * @param kommentar der gel&oumlschte Kommentar
	 */
	public void kommentarEntfernen(Kommentar kommentar){
		kommentar.entfernen();
	}
	
	/**
	 * Sortiert die Kommentare nach dem neusten Datum
	 * 
	 * @return die sortierte Kommentarliste
	 */
	public ArrayList<Kommentar> sortiereNachDatum(){
		ArrayList<Kommentar> tempArrayList = new ArrayList<Kommentar>();
		Stack<Kommentar> tempStack = new Stack<Kommentar>();
		
		for(Kommentar kommentar : this.kommentare){
			tempArrayList.add(kommentar);
		}
		
		for(int i = 1; i < tempArrayList.size(); i++){
			for(int j = 0; j < tempArrayList.size() - 1; j++){
				if (tempArrayList.get(j).getDatum().compareTo(tempArrayList.get(j+1).getDatum()) > 0){
					tempStack.push(tempArrayList.get(j));
					tempArrayList.set(j, tempArrayList.get(j+1));
					tempArrayList.set(j+1, tempStack.pop());
				}
			}
		}		
		return tempArrayList;
	}
	
	/**
	 * Sortiert die Kommentare nach den besten Bewertungen
	 * 
	 * @return sortierte Kommentarliste
	 */
	public ArrayList<Kommentar> sortiereNachBewertung(){
		ArrayList<Kommentar> tempArrayList = new ArrayList<Kommentar>();
		
		for(Kommentar kommentar : this.kommentare){
			tempArrayList.add(kommentar);
		}
		
		Collections.sort(tempArrayList);
		return tempArrayList;
	}

    public Set<Kommentar> getKommentare(){ 
    	return kommentare;
    }
    
    public void setKommentare(Set<Kommentar> kommentare){
    	this.kommentare = kommentare;
    }
    
    public Pinnwand getPinnwand(){
    	return pinnwand;
    }
    
    public void setPinnwand(Pinnwand pinnwand){
    	this.pinnwand = pinnwand;
    }
}
