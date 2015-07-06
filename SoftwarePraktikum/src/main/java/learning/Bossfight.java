package learning;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import kommunikation.Nachricht;

public class Bossfight extends Challenge implements java.io.Serializable{
	private Medium anhang;
	private ArrayList<String> antworten;

	public Bossfight(Benutzer bearbeiter, Medium anhang,
		int erreichbarePunktzahl) {
		this.bearbeiter = bearbeiter;
		this.anhang = anhang;
		this.erreichbarePunktzahl = erreichbarePunktzahl;
		datum = new Date();
		antworten = new ArrayList<String>();
	}

	public Medium getAnhang() {
		return anhang;
	}

	public Medium starten() {
		return anhang;
	}

	public void addAntwort(String antwort) {
		antworten.add(antwort);
	}

	public void korrigieren(Benutzer moderator, int punktzahl) {
		erreichtePunktzahl = erreichtePunktzahl + punktzahl;
		Nachricht nachricht = new Nachricht(moderator, bearbeiter, Nachricht.AUFGABEBEWERTET, this);
		bearbeiter.benachrichtigen(nachricht);
	}

	public void beenden(Gruppe gruppe) {
		Random rand = new Random();
		int index = rand.nextInt(gruppe.moderatoren.size());
		Benutzer moderator = gruppe.moderatoren.get(index); 
		Nachricht nachricht = new Nachricht(bearbeiter, moderator, Nachricht.AUFGABEKORRIGIEREN, this);
		moderator.benachrichtigen(nachricht);
	}

	public boolean bestanden() {
		if (erreichtePunktzahl >= (0.8 * this.erreichbarePunktzahl)) {
			return true;
		} else {
			return false;
		}
	}

}
