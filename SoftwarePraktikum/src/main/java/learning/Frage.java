package learning;

import java.util.HashSet;

public class Frage implements java.io.Serializable {
	public HashSet<Medium> anhang;
	public int id;
	public String titel;
	public String text;
	public HashSet<String> antwortmoeglichkeiten;
	public HashSet<String> antworten;

	public HashSet<String> loesung;

	// leerer Konstruktor
	public Frage() {
	}

	public Frage(String titel, String text, HashSet<String> loesung) {
		this.titel = titel;
		this.text = text;
		this.loesung = loesung;

		antwortmoeglichkeiten = new HashSet<String>();
		antworten = new HashSet<String>();
		anhang = new HashSet<Medium>();
	}

	public HashSet<String> getAntwortmoeglichkeiten() {
		return antwortmoeglichkeiten;
	}

	public void addAntwortmoeglichkeiten(String antwort) {
		antwortmoeglichkeiten.add(antwort);
	}

	/**
	 * Vergleicht die gegebenen Antworten mit der Loesung und gibt die
	 * entsprechende Punktzahl zurueck
	 * 
	 * @return erreichte Punktzahl
	 */
	public int korrigiere() {
		HashSet<String> loesung2 = this.loesung;
		int punkte = 0;
		for (String a : antworten) {
			if (loesung2.contains(a)) {
				punkte = punkte + 3;
				loesung2.remove(a);
			} else {
				punkte = punkte - 3;
			}
		}

		if (loesung2.size() > 0) {
			punkte = punkte - 3 * loesung2.size();
		}

		if (punkte < 0) {
			return 0;
		} else {
			return punkte;
		}
	}

	public HashSet<String> getLoesung() {
		return loesung;
	}

	public void addAntworten(HashSet<String> antworten) {
		this.antworten = antworten;
	}

	public HashSet<String> getAntworten() {
		return antworten;
	}
}
