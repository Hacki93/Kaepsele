package learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * stellt den Datentyp Fragenpool dar, indem Fragen gespeichert werden und
 * Quests erzeugt werden koennen
 * 
 * @author Lena
 *
 */
public class Fragenpool implements java.io.Serializable{
	public HashSet<Frage> fragen;

	public Fragenpool() {
		fragen = new HashSet<Frage>();
	}

	public void addFrage(Frage frage) {
		fragen.add(frage);
	}

	public Quest getQuest() {
		Quest quest = new Quest();
		ArrayList<Frage> fragenliste = new ArrayList<Frage>();
		for (Frage f : fragen){
			fragenliste.add(f);
		}
		while(quest.fragen.size()<10) {
			int zufallsindex = (int) (Math.random()*fragen.size());
			quest.addFrage(fragenliste.get(zufallsindex));
		}
		return quest;
	}

}
