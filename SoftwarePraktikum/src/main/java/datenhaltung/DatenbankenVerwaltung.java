package datenhaltung;

import java.util.HashMap;
import java.util.List;

/**
 * Die Klasse DatenbankVerwaltung erstellt und verwaltet alle Datenbanken und bietet Methoden an, die
 * von den einzelnen Klassen zur Speicherung ihrerselbst verwendet werden k&ouml;nnen
 * @author Hannes
 *
 */
public class DatenbankenVerwaltung {
	
	private HashMap<Class, Datenbank> datenbanken; 
	
	/**
	 * Konstruktor, der die DatenbankVerwaltung initiiert
	 */
	public DatenbankenVerwaltung() {
		datenbanken = new HashMap<Class, Datenbank>();
	}
	
	/**
	 * Erstellt eine neue Datenbankenverbindung zu einer MySQL-Tabelle, falls die Verbindung noch nicht existiert
	 * @param klasse Die MySQL-Tabelle, die mit dem entsprechenden Objekt verbunden werden soll
	 */
	public void addDatenbank(Class klasse) {
		if(!datenbanken.containsKey(klasse)) {
			Datenbank db = new Datenbank(klasse);
			datenbanken.put(klasse, db);
		}
	}
	
	/**
	 * F&uuml;gt einen Eintrag in die entsprechende Datenbank hinzu
	 * @param klasse Die Tabelle, in die der Eintrag hinzugef&uuml;gt werden soll
	 * @param eintrag Der Tabelleneintrag, der hinzugef&uuml;gt werden soll
	 */
	public void eintragHinzufuegen(Class klasse, Object eintrag){
		Datenbank db;
		if(!datenbanken.containsKey(klasse)) {
			System.out.println("Datenbank noch nicht vorhanden, - wird erstellt...");
			db = new Datenbank(klasse);
			datenbanken.put(klasse, db);
		} else {
			System.out.println("Datenbank vorhanden und bereit: "+klasse.getName());
			db = datenbanken.get(klasse);
		}
		db.eintragHinzufuegen(eintrag);
	}
	
	/**
	 * Entfernt einen Eintrag aus der entsprechenden Datenbank
	 * @param klasse Die Tabelle, aus der der Eintrag entfernt werden soll
	 * @param id Die ID des zu entfernenden Objekts
	 */
	public void eintragEntfernen(Class klasse, int id) {
		Datenbank db;
		if(!datenbanken.containsKey(klasse)) {
			System.out.println("Datenbank noch nicht vorhanden, - wird erstellt...");
			db = new Datenbank(klasse);
			datenbanken.put(klasse, db);
		} else {
			System.out.println("Datenbank vorhanden und bereit: "+klasse.getName());
			db = datenbanken.get(klasse);
		}
		db.eintragEntfernen(id);
	}
	
	/**
	 * Aktualisiert einen Eintrag in der Tabelle
	 * @param klasse Die Tabelle, die den zu aktualisierenden Eintrag enth&uml;lt
	 * @param eintrag Der aktualisierte Eintrag
	 */
	public void eintragAktualisieren(Class klasse, Object eintrag) {
		Datenbank db;
		if(!datenbanken.containsKey(klasse)) {
			System.out.println("Datenbank noch nicht vorhanden, - wird erstellt...");
			db = new Datenbank(klasse);
			datenbanken.put(klasse, db);
		} else {
			System.out.println("Datenbank vorhanden und bereit: "+klasse.getName());
			db = datenbanken.get(klasse);
		}
		db.eintragAktualisieren(eintrag);
	}
	
	/**
	 * Gibt einen Eintrag aus der entsprechenden Datenbank aus
	 * @param klasse Die Tabelle, aus der der Eintrag ausgegeben werden soll
	 * @param id Die ID des auszugebenden Eintrags
	 * @return Der ausgegebene Eintrag
	 */
	public Object eintragAusgeben(Class klasse, int id) {
		Datenbank db;
		if(!datenbanken.containsKey(klasse)) {
			System.out.println("Datenbank noch nicht vorhanden, - wird erstellt...");
			db = new Datenbank(klasse);
			datenbanken.put(klasse, db);
		} else {
			System.out.println("Datenbank vorhanden und bereit: "+klasse.getName());
			db = datenbanken.get(klasse);
		}
		return db.eintragAusgeben(id);
	}
	
	/**
	 * Gibt alle Eintr&auml;ge einer Tabelle zur&uuml;ck
	 * @param klasse Die auszulesende Tabelle
	 * @return Alle Eintr&auml;ge
	 */
	public List<Object> tabelleAusgeben(Class klasse) {
		Datenbank db;
		if(!datenbanken.containsKey(klasse)) {
			System.out.println("Datenbank noch nicht vorhanden, - wird erstellt...");
			db = new Datenbank(klasse);
			datenbanken.put(klasse, db);
		} else {
			System.out.println("Datenbank vorhanden und bereit: "+klasse.getName());
			db = datenbanken.get(klasse);
		}
		return db.tabelleAusgeben();
	}
	
}
