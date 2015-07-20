package learning;

import java.util.HashSet;
import java.util.Set;

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
	

	/**
	 * Erstellt einen Quest
	 */
	public Quest() {
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
	 * wertet den bearbeiteten Quest aus und gibt die erreichte Punktzahl
	 * zur&uumlck
	 * 
	 * @return Die erreichte Punktzahl
	 */
	public int korrigiere() {
		for (Frage f : fragen) {
			erreichtePunktzahl = erreichtePunktzahl + f.korrigiere();
			f.setGeblockt(false);
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
}
