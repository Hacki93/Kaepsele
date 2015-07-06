package learning;

import java.util.ArrayList;

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
@PrimaryKeyJoinColumn(name="quest_id", referencedColumnName = "challenge_id")
public class Quest extends Challenge implements java.io.Serializable {
	
	@Transient
	private ArrayList<Frage> fragen;
	
	@Transient
	private ArrayList<Integer> antworten;
	
	@Column(name="zaehlerFragen")
	private int zaehlerFragen;
	
	@Column(name="zaehlerAntworten")
	private int zaehlerAntworten;
	
	@Transient
	private int erreichbarePunktzahl = 30;

	public Quest() {
		fragen = new ArrayList<Frage>();
		zaehlerAntworten = 0;
		zaehlerFragen = 0;
	}

	public int getErreichbarePunktzahl() {
		return erreichbarePunktzahl;
	}

	public void addFrage(Frage frage) {
		fragen.add(frage);
	}

	public Frage getNaechsteFrage() {
		Frage frage = fragen.get(zaehlerFragen);
		zaehlerFragen++;
		return frage;
	}

	public void antwortSpeichern(int antwort) {
		antworten.add(antwort);
	}

	public int getNaechsteAntwort() {
		int antwort = antworten.get(zaehlerAntworten);
		zaehlerAntworten++;
		return antwort;
	}

	/**
	 * wertet den bearbeiteten Quest aus und gibt die erreichte Punktzahl
	 * zurueck
	 */
	public int korrigiere() {
		while (zaehlerFragen < 10) {
			int loesung = getNaechsteFrage().getLoesung();
			int antwort = getNaechsteAntwort();
			if (loesung == antwort) {
				this.erreichtePunktzahl = this.erreichtePunktzahl + 3;
			} else {
				continue;
			}
		}
		return erreichtePunktzahl;
	}
}
