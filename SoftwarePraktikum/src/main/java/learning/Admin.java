package learning;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Die Klasse Admin stellt eine Spezialisierung von Account dar. Sie bietet Haupts&auml;lich Methoden
 * zur Verwaltung von Benutzern und Gruppen dar.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name="admin_id", referencedColumnName = "account_id")
public class Admin extends Account implements java.io.Serializable{

	/**
	 * Es kann eine Gruppe gel&ouml;scht werden, wenn sie mindestens 2 Monate inaktiv ist
	 * @param gruppe Gruppe, die gel&ouml;scht werden soll
	 * @return true, falls die Gruppe gel&ouml;scht wurde
	 */
	public boolean gruppeLöschen(Gruppe gruppe){
		// aktuelles Datum
		Date heute = new Date();
		long zweiMonate = 5259487660L;
		
		// Prüfe ob aktuellster Kommentar nicht älter als zwei Monate ist
		for (Thema thema : gruppe.pinnwand.themen){
//			thema.sortiereNachDatum();
//			long inaktiveZeit1 = heute.getTime() - thema.kommentare.get(0).erstelltAm.getTime();
//			if (inaktiveZeit1 < zweiMonate){
				return false;
//			}
		}
		
		// Prüfe ob aktuellster Pinnwandbeitrag nicht älter als zwei Monate ist
		gruppe.pinnwand.sortiereNachDatum();
		long inaktiveZeit = 0; //  TODO!
		
		if (inaktiveZeit > zweiMonate){
			// löschen der Gruppenmitglieder 
			for(Benutzer benutzer : gruppe.getMitglieder()){
				benutzer.gruppeVerlassen(gruppe);
			}
			// löschen der Pinnwand
			for(Thema thema : gruppe.pinnwand.themen){
				gruppe.pinnwand.themaEntfernen(thema);
				for(Kommentar kommentar : thema.getKommentare()){
					thema.kommentarLöschen(kommentar);
				}
			}
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Setzt das freigegeben-flag einer Fachrichtung auf true
	 * @param fachrichtung Fachrichtung, die freigegeben werden soll
	 */
	public void fachrichtungFreigeben(Fachrichtung fachrichtung){
		fachrichtung.setFreigegeben(true);
	}
	
	/**
	 * Setzt das freigegeben-flag einer Gruppe auf true
	 * @param gruppe Gruppe, die freigegeben werden soll
	 */
	public void gruppeFreigeben(Gruppe gruppe){
		gruppe.setFreigegeben(true);
	}
}
