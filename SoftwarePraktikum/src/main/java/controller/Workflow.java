package controller;

import learning.*;

import org.hibernate.cfg.Configuration;

import datenhaltung.Datenbank;

/**
 * Die Klasse Workflow initialisiert beim Start der Software s&auml;mtliche erforderlichen Komponenten und
 * betreut den Arbeitsablauf der Software
 * @author Hannes
 */
public class Workflow {
	
	private Datenbank db;
	
	/**
	 * Konstruktor, in dem der Arbeitsablauf verwaltet wird
	 */
	public Workflow(){
		initiiereDatenbanken();
		ladeObjektStruktur();
	}

	/**
	 * Initialisierung s&auml;mtlicher Datenbankprozesse
	 */
	private void initiiereDatenbanken(){
		//Lade Mapping für alle vorhandenen Tabellen, reine Relationstabellen müssen nicht geladen werden.
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
    	//Verbindung zur Datenbank mit gegebenener Konfiguration herstellen
		db = new Datenbank(configuration);
		//Verbindung zu den Tabellen in gegebener Datenbank herstellen
		db.tabelleLaden(new Account().getClass());
		db.tabelleLaden(new Admin().getClass());
		db.tabelleLaden(new Benutzer().getClass());
		db.tabelleLaden(new Bossfight().getClass());
		db.tabelleLaden(new Challenge().getClass());
		db.tabelleLaden(new Fachrichtung().getClass());
		db.tabelleLaden(new Frage().getClass());
		db.tabelleLaden(new Fragenpool().getClass());
		db.tabelleLaden(new Gruppe().getClass());
		db.tabelleLaden(new Inhalt().getClass());
		db.tabelleLaden(new Kommentar().getClass());
		db.tabelleLaden(new Mediathek().getClass());
		db.tabelleLaden(new Medium().getClass());
		db.tabelleLaden(new Pinnwand().getClass());
		db.tabelleLaden(new Quest().getClass());
		db.tabelleLaden(new Teamcombat().getClass());
		db.tabelleLaden(new Thema().getClass());
	}
	
	private void ladeObjektStruktur(){
		
	}
	
	/**
	 * Workflow starten
	 */
	public static void main(String[] args) {
		new Workflow();
	}
	
}
