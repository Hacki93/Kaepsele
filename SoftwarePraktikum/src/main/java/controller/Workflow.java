package controller;

import org.hibernate.cfg.Configuration;

import datenhaltung.Datenbank;

/**
 * Die Klasse Workflow initialisiert beim Start der Software s&auml;mtliche erforderlichen Komponenten und
 * betreut den Arbeitsablauf der Software
 * @author Hannes
 */
public class Workflow {
	
	private Datenbank dbv;
	
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
		Configuration configuration = new Configuration().configure();
//   	 configuration.addAnnotatedClass(bc.getClass());
		Datenbank dbv = new Datenbank(configuration);
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
