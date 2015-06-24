package controller;

import learning.Fachrichtung;
import datenhaltung.Datenbank;
import datenhaltung.Employee;

/**
 * @author Hannes
 *
 */
public class Workflow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Datenbank datenbank = new Datenbank();
		Fachrichtung med = new Fachrichtung("Medizin", false);
		Fachrichtung bc  = new Fachrichtung("Biochemie", true);
		for(Object o: datenbank.tabelleAusgeben("Fachrichtung")) {
			System.out.println();
		}
	}

}
