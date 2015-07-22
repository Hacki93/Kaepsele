package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Die Klasse Pinnwand stellt den Bereich eines Benutzer-/Gruppenprofils dar, auf dem
 * Mitglieder/Freunde Themen posten k&ouml;nnen.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PINNWAND")
public class Pinnwand implements java.io.Serializable{

	@Id @GeneratedValue
	@Column(name = "pinnwand_id")
	public int pinnwand_id;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="pinnwand")
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<Thema> themen;
		
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PINNWAND_ERLAUBTEBENUTZER", joinColumns =
	@JoinColumn(name = "pinnwand_id"),  inverseJoinColumns =
	@JoinColumn(name = "benutzer_id"))
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<Benutzer> erlaubteBenutzer;
	
	/**
	 * Konstruktor, der eine neue Pinnwand erstellt
	 */
	public Pinnwand(){
		themen = new HashSet<Thema>();
		erlaubteBenutzer = new HashSet<Benutzer>();
	}
	
	/**
	 * Es wird ein neuer Pinnwandbeitrag erstellt
	 * @param inhalt der neue Inhalt auf der Pinnwand
	 */
	public void themaHinzufuegen(Thema thema){
		themen.add(thema);
		thema.setPinnwand(this);
	}
	
	/**
	 * Es wird ein Pinnwandbeitrag gel&ouml;scht
	 * @param inhalt der gel&ouml;tschte Inhalt
	 */
	public void themaEntfernen(Thema thema){
		thema.entfernen();
	}
	
	/**
	 * Sortiert die Pinnwand nach den neuesten Einträgen
	 * 
	 * @return die sortierte Themenliste
	 */
	public ArrayList<Thema> sortiereNachDatum(){
		ArrayList<Thema> tempArrayList = new ArrayList<Thema>();
		Stack<Thema> tempStack = new Stack<Thema>();
		
		for(Thema thema : this.themen){
			tempArrayList.add(thema);
		}
		
		for(int i = 1; i < tempArrayList.size(); i++){
			for(int j = 0; j < tempArrayList.size() - 1; j++){
				if (tempArrayList.get(j).getDatum().compareTo(tempArrayList.get(j+1).getDatum()) < 0){
					tempStack.push(tempArrayList.get(j));
					tempArrayList.set(j, tempArrayList.get(j+1));
					tempArrayList.set(j+1, tempStack.pop());
				}
			}
		}	
		return tempArrayList;
	}
	
	/**
	 * Sortiert die Pinnwand nach den besten Bewertungen
	 * 
	 * @return die sortierte Themenliste
	 */
	public ArrayList<Thema> sortiereNachBewertung(){
		ArrayList<Thema> tempArrayList = new ArrayList<Thema>();
		
		for(Thema thema : this.themen){
			tempArrayList.add(thema);
		}
		
		Collections.sort(tempArrayList);
		return tempArrayList;
	}
	
	public void setThemen(Set<Thema> themen){
		this.themen = themen;
	}
	
	public Set<Thema> getThemen(){
		return themen;
	}
	
	public void setErlaubteBenutzer(Set<Benutzer> benutzer){
		erlaubteBenutzer = benutzer;
	}
	
	public Set<Benutzer> getErlaubteBenutzer(){
		return erlaubteBenutzer;
	}
	
	public void setId(int id){
		pinnwand_id = id;
	}
	
	public int getId(){
		return pinnwand_id;
	}

}
