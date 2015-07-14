package learning;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
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
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * stellt den Datentyp Fragenpool dar, indem Fragen gespeichert werden und
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

	@OneToMany(mappedBy="fragenpool", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Frage> fragen;
	
	@Transient
	private static final int fragenanzahl = 1;

	/**
	 * Erzeugt den Fragenpool einer Gruppe 
	 */
	public Fragenpool() {
		fragen = new HashSet<Frage>();
	}

	/**
	 * f&uumlgt dem Fragenpool ein Frage hinzu
	 * @param frage
	 */
	public void addFrage(Frage frage) {
		fragen.add(frage);
		frage.setFragenpool(this);
	}

	/**
	 * erstellt einen neuen Quest mit zuf&aumlllig ausgew&aumlhlten Fragen aus dem
	 * Fragenpool
	 * 
	 * @return Quest 
	 */
	public Quest getQuest() {
		Quest quest = new Quest();
		quest.setDatum(new Date());
		ArrayList<Frage> fragenliste = new ArrayList<Frage>();
		for (Frage f : fragen) {
			fragenliste.add(f);
		}
		while (quest.fragen.size() < fragenanzahl) {
			int zufallsindex = (int) (Math.random() * fragen.size());
			quest.addFrage(fragenliste.get(zufallsindex));
		}
		return quest;
	}

}
