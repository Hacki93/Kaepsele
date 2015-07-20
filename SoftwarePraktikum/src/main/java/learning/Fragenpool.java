package learning;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Die Klasse Fragenpool stellt den Datentyp Fragenpool dar, indem Fragen gespeichert werden und
 * Quests erzeugt werden koennen
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FRAGENPOOL")
public class Fragenpool implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "fragenpool_id")
	public int fragenpool_id;

	@OneToMany(mappedBy="fragenpool", fetch = FetchType.EAGER, orphanRemoval = true)
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<Frage> fragen;
	
	@Transient
	private static final int fragenanzahl = 10;

	/**
	 * Erzeugt den Fragenpool einer Gruppe 
	 */
	public Fragenpool() {
		fragen = new HashSet<Frage>();
	}

	/**
	 * F&uumlgt dem Fragenpool ein Frage hinzu
	 * @param frage
	 */
	public void addFrage(Frage frage) {
		fragen.add(frage);
		frage.setFragenpool(this);
	}

	/**
	 * Erstellt einen neuen Quest mit zuf&aumlllig ausgew&aumlhlten Fragen aus dem
	 * Fragenpool
	 * 
	 * @return Quest 
	 */
	public Quest getQuest(Gruppe gruppe) {
		Quest quest = new Quest();
		quest.setDatum(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		quest.setGruppe(gruppe);
		ArrayList<Frage> fragenliste = new ArrayList<Frage>();
		for (Frage f : fragen) {
			if (!f.isGeblockt()){
			fragenliste.add(f);
			}
		}
		while (quest.fragen.size() < Math.min(fragenanzahl, fragen.size())) {
			int zufallsindex = (int) (Math.random() * fragen.size());
			quest.addFrage(fragenliste.get(zufallsindex));
		}
		return quest;
	}
	
	public Quest getQuestFuerTeamcombat(Gruppe gruppe) {
		Quest quest = new Quest();
		quest.setDatum(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		quest.setGruppe(gruppe);
		ArrayList<Frage> fragenliste = new ArrayList<Frage>();
		for (Frage f : fragen) {
			if (!f.isGeblockt()){
			fragenliste.add(f);
			}
		}
		System.out.println();
		while (quest.fragen.size() < Math.min(fragenanzahl, fragenliste.size())) {
			int zufallsindex = (int) (Math.random() * fragenliste.size());
			quest.addFrage(fragenliste.get(zufallsindex));
		}
		return quest;
	}
	
	public void setFragen(Set<Frage> fragen){
		this.fragen = fragen;
	}
	
	public Set<Frage> getFragen(){
		return fragen;
	}
	
	public void setId(int id){
		fragenpool_id = id;
	}
	
	public int getId(){
		return fragenpool_id;
	}

}
