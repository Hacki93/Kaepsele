package datenhaltung;

import java.util.HashMap;
import java.util.List;

import kommunikation.Nachricht;
import learning.Account;
import learning.Admin;
import learning.Benutzer;
import learning.Bossfight;
import learning.Challenge;
import learning.Fachrichtung;
import learning.Frage;
import learning.Fragenpool;
import learning.Gruppe;
import learning.Inhalt;
import learning.Kommentar;
import learning.Mediathek;
import learning.Medium;
import learning.Pinnwand;
import learning.Quest;
import learning.Teamcombat;
import learning.Thema;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Die Klasse DatenbankVerwaltung erstellt und verwaltet alle Datenbanken und bietet Methoden an, die
 * von den einzelnen Klassen zur Speicherung ihrerselbst verwendet werden k&ouml;nnen
 */
@SuppressWarnings("rawtypes")
public class Datenbank {
	

	private HashMap<Class, Tabelle> datenbanken; 
	private SessionFactory factory;
	
	/**
	 * Gibt die Anzahl der gespeicherten Datenbanken aus
	 * @return Anzahlt der gespeicherten Datenbanken
	 */
	public int getSize() {
		return datenbanken.size();
	}
	
	/**
	 * Konstruktor, der die DatenbankVerwaltung initiiert
	 */
	public Datenbank() {
		datenbanken = new HashMap<Class, Tabelle>();
	    try{	    	 
	         Configuration configuration = getConfiguration();
	         StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	         factory = configuration.buildSessionFactory(builder.build());
	    }catch (Throwable ex) { 
	    	ex.printStackTrace();
	    }
	    System.out.println("SessionFactory erfolgreich erstellt.");
	    tabellenEinbinden();
	}
	
	/**
	 * Ansteuern s&auml;mtlicher Tabellen
	 */
	private void tabellenEinbinden(){
		tabelleLaden(new Account().getClass());
		tabelleLaden(new Admin().getClass());
		tabelleLaden(new Benutzer().getClass());
		tabelleLaden(new Bossfight().getClass());
		tabelleLaden(new Challenge().getClass());
		tabelleLaden(new Fachrichtung().getClass());
		tabelleLaden(new Frage().getClass());
		tabelleLaden(new Fragenpool().getClass());
		tabelleLaden(new Gruppe().getClass());
		tabelleLaden(new Inhalt().getClass());
		tabelleLaden(new Kommentar().getClass());
		tabelleLaden(new Mediathek().getClass());
		tabelleLaden(new Medium().getClass());
		tabelleLaden(new Pinnwand().getClass());
		tabelleLaden(new Quest().getClass());
		tabelleLaden(new Teamcombat().getClass());
		tabelleLaden(new Thema().getClass());
		tabelleLaden(new Nachricht().getClass());
	}
	
	/**
	 * L&aauml;dt das Mapping aller relevanter Klassen
	 * @return Die Mappingkonfiguration
	 */
	private Configuration getConfiguration(){
		//Konfiguriere Mapping für alle vorhandenen Tabellen, reine Relationstabellen müssen nicht geladen werden.
		Configuration configuration = new Configuration().configure();
    	configuration.addAnnotatedClass(new Account().getClass());
    	configuration.addAnnotatedClass(new Admin().getClass());
    	configuration.addAnnotatedClass(new Benutzer().getClass());
    	configuration.addAnnotatedClass(new Bossfight().getClass());
    	configuration.addAnnotatedClass(new Challenge().getClass());
    	configuration.addAnnotatedClass(new Fachrichtung().getClass());
    	configuration.addAnnotatedClass(new Frage().getClass());
    	configuration.addAnnotatedClass(new Fragenpool().getClass());
    	configuration.addAnnotatedClass(new Gruppe().getClass());
    	configuration.addAnnotatedClass(new Inhalt().getClass());
    	configuration.addAnnotatedClass(new Kommentar().getClass());
    	configuration.addAnnotatedClass(new Mediathek().getClass());
    	configuration.addAnnotatedClass(new Medium().getClass());
    	configuration.addAnnotatedClass(new Pinnwand().getClass());
    	configuration.addAnnotatedClass(new Quest().getClass());
    	configuration.addAnnotatedClass(new Teamcombat().getClass());
    	configuration.addAnnotatedClass(new Thema().getClass());
    	configuration.addAnnotatedClass(new Nachricht().getClass());
    	return configuration;
	}
	
	/**
	 * Erstellt eine neue Datenbankenverbindung zu einer MySQL-Tabelle, falls die Verbindung noch nicht existiert
	 * @param klasse Die MySQL-Tabelle, die mit dem entsprechenden Objekt verbunden werden soll
	 */
	public void tabelleLaden(Class klasse) {
		if(!datenbanken.containsKey(klasse)) {
			Tabelle db = new Tabelle(klasse, factory);
			datenbanken.put(klasse, db);
			System.out.println("Datenbank für Instanzen des Objekts "+klasse.getName()+" erstellt.");
		}
	}
	
	/**
	 * F&uuml;gt einen Eintrag in die entsprechende Datenbank hinzu
	 * @param klasse Die Tabelle, in die der Eintrag hinzugef&uuml;gt werden soll
	 * @param eintrag Der Tabelleneintrag, der hinzugef&uuml;gt werden soll
	 */
	public int eintragHinzufuegen(Class klasse, Object eintrag) {
		System.out.println("Eintrag in Datenbank "+klasse.getName()+" wird hinzugefügt");
		Tabelle db;
		if(!datenbanken.containsKey(klasse)) {
			System.out.println("Datenbank noch nicht vorhanden, - wird erstellt...");
			db = new Tabelle(klasse, factory);
			datenbanken.put(klasse, db);
		} else {
			System.out.println("Datenbank vorhanden und bereit: "+klasse.getName());
			db = datenbanken.get(klasse);
		}
		return db.eintragHinzufuegen(eintrag);
	}
	
	/**
	 * Entfernt einen Eintrag aus der entsprechenden Datenbank
	 * @param klasse Die Tabelle, aus der der Eintrag entfernt werden soll
	 * @param id Die ID des zu entfernenden Objekts
	 */
	public void eintragEntfernen(Class klasse, int id) {
		Tabelle db;
		if(!datenbanken.containsKey(klasse)) {
			System.out.println("Datenbank noch nicht vorhanden, - wird erstellt...");
			db = new Tabelle(klasse, factory);
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
		Tabelle db;
		if(!datenbanken.containsKey(klasse)) {
			System.out.println("Datenbank noch nicht vorhanden, - wird erstellt...");
			db = new Tabelle(klasse, factory);
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
		Tabelle db;
		if(!datenbanken.containsKey(klasse)) {
			System.out.println("Datenbank noch nicht vorhanden, - wird erstellt...");
			db = new Tabelle(klasse, factory);
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
		Tabelle db;
		if(!datenbanken.containsKey(klasse)) {
			System.out.println("Datenbank noch nicht vorhanden, - wird erstellt...");
			db = new Tabelle(klasse, factory);
			datenbanken.put(klasse, db);
		} else {
			System.out.println("Datenbank vorhanden und bereit: "+klasse.getName());
			db = datenbanken.get(klasse);
		}
		return db.tabelleAusgeben();
	}
	
}
