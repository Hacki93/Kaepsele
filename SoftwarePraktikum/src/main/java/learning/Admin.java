package learning;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name="admin_id", referencedColumnName = "account_id")
public class Admin extends Account implements java.io.Serializable{

	/**
	 * Es kann eine Gruppe gelöscht werden wenn sie mindestens 2 Monate inaktiv ist
	 * @param gruppe die gel&oumlscht werden soll
	 * @return true, falls die Gruppe gelöscht wurde
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
			//löschen der Mediathek
			for(Medium medium : gruppe.mediathek.medien){
				gruppe.mediathek.mediumLöschen(medium);
			} 
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean fachrichtungFreigeben(Fachrichtung k){
		k.setFreigegeben(true);
		return k.getFreigegeben();
	}
	
	public boolean gruppeFreigeben(Gruppe g){
		g.setFreigegeben(true);
		return g.isFreigegeben();
	}
}
