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
	 * Es kann eine Gruppe gel�scht werden wenn sie mindestens 2 Monate inaktiv ist
	 * @param gruppe die gel&oumlscht werden soll
	 * @return true, falls die Gruppe gel�scht wurde
	 */
	public boolean gruppeL�schen(Gruppe gruppe){
		// aktuelles Datum
		Date heute = new Date();
		long zweiMonate = 5259487660L;
		
		// Pr�fe ob aktuellster Kommentar nicht �lter als zwei Monate ist
		for (Thema thema : gruppe.pinnwand.themen){
//			thema.sortiereNachDatum();
//			long inaktiveZeit1 = heute.getTime() - thema.kommentare.get(0).erstelltAm.getTime();
//			if (inaktiveZeit1 < zweiMonate){
				return false;
//			}
		}
		
		// Pr�fe ob aktuellster Pinnwandbeitrag nicht �lter als zwei Monate ist
		gruppe.pinnwand.sortiereNachDatum();
		long inaktiveZeit = 0; //  TODO!
		
		if (inaktiveZeit > zweiMonate){
			// l�schen der Gruppenmitglieder 
			for(Benutzer benutzer : gruppe.getMitglieder()){
				benutzer.gruppeVerlassen(gruppe);
			}
			// l�schen der Pinnwand
			for(Thema thema : gruppe.pinnwand.themen){
				gruppe.pinnwand.themaEntfernen(thema);
				for(Kommentar kommentar : thema.getKommentare()){
					thema.kommentarL�schen(kommentar);
				}
			}
			//l�schen der Mediathek
			for(Medium medium : gruppe.mediathek.medien){
				gruppe.mediathek.mediumL�schen(medium);
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
