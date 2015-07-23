package learning;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Die Klasse Quest beinhaltet mehrere zuf&auml;llig aus dem Fragenpool genommene MC-Fragen.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "QUEST")
@PrimaryKeyJoinColumn(name = "quest_id", referencedColumnName = "challenge_id")
public class Quest extends Challenge implements java.io.Serializable {

	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinTable(name = "QUEST_FRAGEN", joinColumns =
	@JoinColumn(name = "quest_id"),  inverseJoinColumns =
	@JoinColumn(name = "frage_id"))
	public Set<Frage> fragen;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gruppe_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	public Gruppe gruppe;
	
	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@CollectionTable(name="QUEST_ANTWORTEN", joinColumns=
	@JoinColumn(name="frage_id"))
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<String> antworten;
	

	/**
	 * Erstellt einen Quest
	 */
	public Quest() {
		antworten = new HashSet<String>();
		fragen = new HashSet<Frage>();
		erreichbarePunktzahl = 0;
		erreichtePunktzahl = 0;
	}

	public int getErreichbarePunktzahl() {
		return erreichbarePunktzahl;
	}

	/**
	 * F&uumlgt dem Quest eine Frage hinzu und gleicht die erreichbare Punktzahl an
	 * 
	 * @param frage
	 */
	public boolean addFrage(Frage frage) {
		if (fragen.add(frage)) {
			erreichbarePunktzahl = erreichbarePunktzahl + 3	* frage.getLoesung().size();
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * F&uuml;
	 * @param antwort
	 */
	public void addAntwort(String antwort) {
		this.antworten.add(antwort);
	}
	
	/**
	 * Vergleicht die gegebenen Antworten mit der L&oumlsung und gibt die
	 * entsprechende Punktzahl zur&uumlck
	 * 
	 * @return erreichte Punktzahl
	 */
	public int korrigiere(){
		erreichtePunktzahl = 0;
		for(String s : antworten){
			String[] parts = s.split(";!!;!");
			int frage_id = Integer.parseInt(parts[0]);
			String antwort = parts[1];
			for (Frage f : fragen){
				Set<String> loesungtemp = f.getLoesung();
				if(f.getId()==frage_id){
					if(loesungtemp.contains(antwort)){
						erreichtePunktzahl += 3;
						loesungtemp.remove(antwort);
					}else{
						erreichtePunktzahl -= 3;
					}
					erreichtePunktzahl -= loesungtemp.size()*3; 
				}
			}
		}
		if (erreichtePunktzahl < 0) {
			erreichtePunktzahl = 0; 
		}
		return erreichtePunktzahl; 
	}

	public Set<Frage> getFragen(){
		return fragen;
	}
	
	public void setFragen(Set<Frage> fragen){
		this.fragen = fragen;
	}
	
	public Gruppe getGruppe(){
		return gruppe;
	}
	
	public void setGruppe(Gruppe gruppe){
		this.gruppe = gruppe;
	}
	
	public Set<String> getAntworten() {
		return antworten;
	}
	
	public void setAntworten(Set<String> antworten){
		this.antworten = antworten;
	}
}
