package learning;
import java.util.Date;

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
			thema.sortiereNachDatum();
			long inaktiveZeit1 = heute.getTime() - thema.kommentare.get(0).erstelltAm.getTime();
			if (inaktiveZeit1 < zweiMonate){
				return false;
			}
		}
		
		// Prüfe ob aktuellster Pinnwandbeitrag nicht älter als zwei Monate ist
		gruppe.pinnwand.sortiereNachDatum();
		long inaktiveZeit = heute.getTime() - gruppe.pinnwand.themen.get(0).erstelltAm.getTime();
		
		if (inaktiveZeit > zweiMonate){
			for(Benutzer benutzer : gruppe.getMitglieder()){
				benutzer.gruppeVerlassen(gruppe);
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
