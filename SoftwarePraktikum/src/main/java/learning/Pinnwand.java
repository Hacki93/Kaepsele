package learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "PINNWAND")
public class Pinnwand implements java.io.Serializable{

	@Id @GeneratedValue
	@Column(name = "pinnwand_id")
	public int pinnwand_id;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="pinnwand")
	public Set<Thema> themen;
		
	@Transient
	public ArrayList<Benutzer> erlaubteBenutzer;
	
	/**
	 * Konstruktor, der eine neue Pinnwand erstellt
	 */
	public Pinnwand(){
		themen = new HashSet<Thema>();
		erlaubteBenutzer = new ArrayList<Benutzer>();
	}
	
	/**
	 * Es wird ein neuer Pinnwandbeitrag erstellt
	 * @param inhalt der neue Inhalt auf der Pinnwand
	 */
	public void themaHinzufügen(Thema thema){
		themen.add(thema);
	}
	
	/**
	 * Es wird ein Pinnwandbeitrag gel&ouml;scht
	 * @param inhalt der gel&ouml;tschte Inhalt
	 */
	public void themaEntfernen(Thema thema){
		themen.remove(thema);
	}
	
	/**
	 * Sortiert die Pinnwand nach den neuesten Einträgen
	 * @return die sortierte Themenliste
	 */
	public ArrayList<Thema> sortiereNachDatum(){
//		Stack<Thema> tempStack = new Stack<Thema>();
//		
//		for(int i = 1; i < this.themen.size(); i++){
//			for(int j = 0; j < this.themen.size() - 1; j++){
//				if (this.themen.get(j).getDatum().compareTo(this.themen.get(j+1).getDatum()) < 0){
//					tempStack.push(this.themen.get(j));
//					this.themen.set(j, this.themen.get(j+1));
//					this.themen.set(j+1, tempStack.pop());
//				}
//			}
//		}	
//		return this.themen;
		return null;
	}
	
	/**
	 * Sortiert die Pinnwand nach den besten Bewertungen
	 * @return die sortierte Themenliste
	 */
	public ArrayList<Thema> sortiereNachBewertung(){
//		Collections.sort(this.themen);
//		return this.themen;
		return null;
	}

}
