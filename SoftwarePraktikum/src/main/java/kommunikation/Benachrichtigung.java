package kommunikation;

import java.util.Observable;
import java.util.Observer;
import learning.Benutzer;
import learning.Gruppe;

/**
 * Diese Klasse beinhaltet Methoden zur (asynchronen) Benachrichtigung von Benutzern
 * @author Hannes
 *
 */
public class Benachrichtigung implements Observer {
	
	/**
	 * Benachrichtigt alle Benutzer der Gruppe
	 * @param gruppe Die Gruppe, deren Mitglieder benachrichtigt werden sollen
	 * @param nachricht Die Nachricht, die versendet werden soll
	 */
	public static void gruppeBenachrichtigen(Gruppe gruppe, Nachricht nachricht) {
		for (Benutzer benutzer : gruppe.mitglieder) {
			benutzerBenachrichtigen(benutzer, nachricht);
		}
	}

	/**
	 * Benachrichtigt alle Benutzer der Gruppe
	 * @param benutzer Die Gruppe, deren Mitglieder benachrichtigt werden sollen
	 * @param nachricht Die Nachricht, die versendet werden soll
	 */
	public static void benutzerBenachrichtigen(Benutzer benutzer, Nachricht nachricht) {
		//Email an den Benutzer senden
		String anschreiben = "Hallo "+((Benutzer)nachricht.getAdressat()).getName()+",\n\n";
		new Email().senden(benutzer.getEmailAdresse(), nachricht.getTitel(), anschreiben+nachricht.getInhalt());
	}

	/**
	 * Eingangspunkt f&uuml;r alle Benachrichtigungen
	 * @param oberservable Quelle der Benachrichtigung
	 * @param inhalt Inhalt der Benachrichtigung
	 */
	@Override
	public void update(Observable observable, Object inhalt) {
		System.out.println("Kommunikation:Benachrichtigung:update: Nachricht eingetroffen");
		Nachricht nachricht = (Nachricht)inhalt;
		if(observable instanceof Benutzer) {
			benutzerBenachrichtigen(((Benutzer)nachricht.getAdressat()), nachricht);
		} 
//		else if (observable instanceof Gruppe) {
//			gruppeBenachrichtigen(((Gruppe)nachricht.getAdressat()), nachricht);
//		}
		
	}
	
}
