package learning;

import java.util.ArrayList;

public class Mediathek implements java.io.Serializable{

	public ArrayList<Medium> medien;
	
	/**
	 * Konstruktor der Mediathek
	 */
	public Mediathek(){
		medien = new ArrayList<Medium>();
	}
	
	/**
	 * Gibt den Pfad des Mediums an
	 * @param id : Idendifiziert das Medium
	 * @return pfad des Mediums
	 */
	public String getMedium(int id){
		for (Medium medium : this.medien){
			if (medium.getId() == id){
				return medium.getPfad();
			}
		}
		return null;
	}
	
	/**
	 * F&uumlgt ein Medium in die Mediatehek hinzu
	 * @param medium das hinzugef&uumlgt werden soll
	 */
	public void mediumHinzufügen(Medium medium){
		this.medien.add(medium);
	}
	
	/**
	 * l&oumlscht ein Medium aus der Mediathek
	 * @param medium das gel&oumlscht werden soll
	 */
	public void mediumLöschen(Medium medium){
		this.medien.remove(medium);
	}
	
	/**
	 * Gibt an ob ein Medium &oumlffentlich ist
	 * @param id welches Medium &uumlberpr&uumlft werden soll
	 * @return true, falls das Medium öffentlich ist
	 */
	public boolean isÖffentlich(int id){
		for (Medium medium : this.medien){
			if (medium.getId() == id){
				return medium.isÖffentlich();
			}
		}
		return false;
	}
}
