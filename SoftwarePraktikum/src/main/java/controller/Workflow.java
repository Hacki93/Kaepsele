package controller;

import learning.Benutzer;
import learning.Fachrichtung;
import learning.Pinnwand;
import learning.Thema;
import datenhaltung.Datenbank;
import datenhaltung.Employee;

/**
 * @author Hannes
 *
 */
public class Workflow {

	
	public static void main(String[] args) {
		
	
		Benutzer benutzer1 = new Benutzer("Test1", "Test1", "Test1", "Test1");
		
		Thema thema1 = new Thema("Test1", "Test1", benutzer1);
		Thema thema2 = new Thema("Test2", "Test2", benutzer1);
		Thema thema3 = new Thema("Test3", "Test3", benutzer1);
		Thema thema4 = new Thema("Test4", "Test4", benutzer1);
		
		thema1.setBewertung(5);
		thema2.setBewertung(7);
		thema3.setBewertung(2);
		thema4.setBewertung(10);
		
		Pinnwand pinnwand = new Pinnwand();
		
		pinnwand.inhaltHinzufügen(thema1);
		pinnwand.inhaltHinzufügen(thema2);
		pinnwand.inhaltHinzufügen(thema3);
		pinnwand.inhaltHinzufügen(thema4);
		
		for(Thema t : pinnwand.themen){
			System.out.println(t.getBewertung());
		}
		
		pinnwand.sortiereNachBewertung();
		
		for(Thema t : pinnwand.themen){
			System.out.println(t.getBewertung());
		}
	}

}
