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
	private HashSet<Frage> fragen;

	public Fragenpool() {
		fragen = new HashSet<Frage>();
	}

	public void addFrage(Frage frage) {
		fragen.add(frage);
	}

	public Quest getQuest() {
		Quest quest = new Quest();
		ArrayList<Frage> fragen2 = new ArrayList<Frage>();
		for (Frage f: fragen){
			fragen2.add(f);
		}
		
		int i = 0;
		HashSet<Integer> zahlen = new HashSet<Integer>();
		Random r = new Random();
		while (i <= 10) {
			int z = r.nextInt(fragen.size());
			if (zahlen.contains(z)) {
				continue;
			}
			zahlen.add(z);
			Frage frage = fragen2.get(z);
			quest.addFrage(frage);
			i++;
		}
		return quest;
	}

}
