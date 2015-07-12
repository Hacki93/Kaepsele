package learning;

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
	public HashSet<Frage> fragen;

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
	 * F&uumlgt dem Quest eine Frage hinzu und gleicht die erreichbare Punktzahl
	 * an
	 * 
	 * @param frage
	 */
	public void addFrage(Frage frage) {
		if (fragen.add(frage)) {
			erreichbarePunktzahl = erreichbarePunktzahl + 3	* frage.getLoesung().size();
		}
	}

	/**
	 * gibt eine unbearbeitete Frage des Quests zur&uumlck
	 * 
	 * @return n&aumlchste Frage des Quests
	 */
	public Frage getNaechsteFrage() {
		Frage frage = null;
		for (Frage f : fragen) {
			if (!f.isBearbeitet()) {
				frage = f;
			}
		}
		frage.setBearbeitet(true);
		return frage;
	}

	/**
	 * wertet den bearbeiteten Quest aus und gibt die erreichte Punktzahl
	 * zur&uumlck
	 */
	public int korrigiere() {
		for (Frage f : fragen) {
			erreichtePunktzahl = erreichtePunktzahl + f.korrigiere();
		}
		return erreichtePunktzahl;
	}
}
