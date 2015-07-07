package learning;

import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Stellt den Datentyp Quest dar
 * 
 * @author Lena
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "QUEST")
@PrimaryKeyJoinColumn(name = "quest_id", referencedColumnName = "challenge_id")
public class Quest extends Challenge implements java.io.Serializable {

	@Transient
	private HashSet<Frage> fragen;

	@Transient
	private int erreichbarePunktzahl;

	private int erreichtePunktzahl;

	private ArrayList<Frage> fragenArray;

	public Quest() {
		fragen = new HashSet<Frage>();
		erreichbarePunktzahl = 0;
		erreichtePunktzahl = 0;
		fragenArray = new ArrayList<Frage>();
	}

	public int getErreichbarePunktzahl() {
		return erreichbarePunktzahl;
	}

	public void addFrage(Frage frage) {
		fragen.add(frage);
		fragenArray.add(frage);
		erreichbarePunktzahl = erreichbarePunktzahl + 3
				* frage.getLoesung().size();
	}

	/**
	 * gibt die naechste Frage des Quests zurueck
	 * 
	 * @return naechste Frage des Quests
	 */
	public Frage getNaechsteFrage() {
		Frage frage = fragenArray.get(0);
		fragenArray.remove(0);
		return frage;
	}

	/**
	 * wertet den bearbeiteten Quest aus und gibt die erreichte Punktzahl
	 * zurueck
	 */
	public int korrigiere() {
		for (Frage f : fragen) {
			erreichtePunktzahl = erreichtePunktzahl + f.korrigiere();
		}
		return erreichtePunktzahl;
	}
}
