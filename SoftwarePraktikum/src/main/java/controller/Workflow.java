package controller;

import datenhaltung.DatenbankenVerwaltung;

/**
 * Die Klasse Workflow initialisiert beim Start der Software s&auml;mtliche erforderlichen Komponenten und
 * betreut den Arbeitsablauf der Software
 * @author Hannes
 */
public class Workflow {
	
	private DatenbankenVerwaltung dbv;
	
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
		dbv = new DatenbankenVerwaltung();
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
