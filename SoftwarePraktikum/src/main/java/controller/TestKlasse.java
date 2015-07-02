package controller;

import learning.Fachrichtung;
import datenhaltung.DatenbankenVerwaltung;
import datenhaltung.Employee;

public class TestKlasse {

	// Klasse zum Testen von Codebausteinen
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		datenbankenTest();
		
		}

		public static void datenbankenTest(){
			Employee chris = new Employee();
			chris.setFirstName("Christoph");
			chris.setLastName("Jachmann");
			chris.setSalary(5);
			
			Fachrichtung bc = new Fachrichtung();
			bc.setName("Biochemie");
			bc.setFreigegeben(false);
			
			Fachrichtung wi = new Fachrichtung();
			wi.setName("Wirtschaftsinformatik");
			wi.setFreigegeben(false);

			DatenbankenVerwaltung dbv = new DatenbankenVerwaltung();
			dbv.addDatenbank(bc.getClass());
			dbv.addDatenbank(wi.getClass());

			dbv.eintragHinzufuegen(bc.getClass(), bc);
			bc.setFreigegeben(true);
			dbv.eintragAktualisieren(bc.getClass(), bc);
			
		}
}
