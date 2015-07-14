package learning;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import kommunikation.Nachricht;

@SuppressWarnings("serial")
@Entity
@Table(name = "TEAMCOMBAT")
public class Teamcombat implements java.io.Serializable {
	
	@Id @GeneratedValue
	@Column(name = "teamcombat_id")
	public int teamcombat_id;
	
	@Column(name = "ablaufdatum")
	public Date ablaufdatum;
	
	@Transient
	public Gruppe herausforderer;
	
	@Transient
	public Gruppe herausgeforderter;
	
	@Transient
	public Quest questFuerHerausforderer;
	
	@Transient
	public Quest questFuerHerausgeforderter;
	
	@Transient
	public Gruppe gewinner;
	
	private int punkte;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Teamcombat() {	}

	/**
	 * Legt einen neuen Teamcombat an
	 * 
	 * @param herausforderer
	 *            Die herausfordernde Gruppe
	 * @param herausgeforderter
	 *            Die herausgeforderte Gruppe
	 */
	public Teamcombat(Gruppe herausforderer, Gruppe herausgeforderter) {
		
		this.herausgeforderter = herausgeforderter;
		this.herausforderer = herausforderer;
		questFuerHerausforderer = this.herausgeforderter.fragenpool.getQuest();
		questFuerHerausgeforderter = this.herausforderer.fragenpool.getQuest();
		Date now = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		ablaufdatum = calendar.getTime();
		punkte = 0; 
		new Thread(){
			public void run(){
				try{
					Thread.sleep(ablaufdatum.getTime()-new Date().getTime());
					auswerten();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}.start();
	}

	/**
	 * Wertet den Teamcombat aus und gibt die Gewinnergruppe zur&uumlck
	 * 
	 * @return Gewinnergruppe
	 */
	public Gruppe auswerten() {
		for (Benutzer benutzer:herausforderer.getMitglieder()){
			benutzer.aufgabeErledigt(this);
		}
		for (Benutzer benutzer:herausgeforderter.getMitglieder()){
			benutzer.aufgabeErledigt(this);
		}
		int herausforderer = questFuerHerausforderer.korrigiere();
		int herausgeforderter = questFuerHerausgeforderter.korrigiere();
		if (herausforderer > herausgeforderter) {
			gewinner = this.herausforderer;
			punkte = herausforderer; 
			Nachricht nachricht = new Nachricht(gewinner, gewinner, Nachricht.TEAMCOMBATGEWONNEN, this);
			this.herausforderer.benachrichtigen(nachricht);
			this.herausgeforderter.benachrichtigen(nachricht);
			return this.herausforderer;
		} else {
			gewinner = this.herausgeforderter;
			punkte = herausgeforderter; 
			Nachricht nachricht = new Nachricht(gewinner, gewinner, Nachricht.TEAMCOMBATGEWONNEN, this);
			
			this.herausforderer.benachrichtigen(nachricht);
			this.herausgeforderter.benachrichtigen(nachricht);
			return this.herausgeforderter;
		}
	}

	/**
	 * Gibt das Ablaufdatum als String zur&uumlck
	 * 
	 * @return Ablaufdatum als String
	 */
	public String showAblaufdatum() {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		return dateFormat.format(ablaufdatum);
	}

	/**
	 * erstellt einen Quest f&uumlr die herausfordernde Gruppe aus dem Fragenpool
	 * der herausgeforderten Gruppe
	 * 
	 * @return QuestFuerHerausforderer
	 */
	public Quest getQuestFuerHerausforderer() {
		return questFuerHerausforderer;
	}

	/**
	 * erstellt einen Quest f&uumlr die herausgeforderte Gruppe aus dem Fragenpool
	 * der hausfordernden Gruppe
	 * 
	 * @return QuestFuerHerausgeforderter
	 */
	public Quest getQuestFuerHerausgeforderter() {
		return questFuerHerausgeforderter;
	}

	/**
	 * Gibt den zu bearbeitenden Quest des Teamcombats zur&uumlck
	 * 
	 * @param teamcombat
	 *            Der Teamcombat der bearbeitet werden soll
	 * @return Der zu bearbeitende Quest
	 */
	public Quest bearbeiten(Benutzer benutzer) {
		if (this.herausforderer.getMitglieder().contains(benutzer)) {
			return this.questFuerHerausforderer;
		} else {
			return this.questFuerHerausgeforderter;
		}
	}

	public int getId() {
		return teamcombat_id;
	}

	public Gruppe getHerausgeforderter() {
		return herausgeforderter;
	}

	public Gruppe getGewinner() {
		return gewinner;
	}

	public Date getAblaufdatum() {
		return ablaufdatum;
	}

	public void setAblaufdatum(Date ablaufdatum) {
		this.ablaufdatum = ablaufdatum;
		Date now = new Date();
		if (now.after(ablaufdatum) || now.equals(ablaufdatum) ){
			auswerten();
		} else {
			new Thread(){
				public void run(){
					try{
						Thread.sleep(ablaufdatum.getTime()-new Date().getTime());
						auswerten();
					} catch (Exception e){
						e.printStackTrace();
					}
				}
			}.start();
		}
	}

	public void setHerausforderer(Gruppe herausforderer) {
		this.herausforderer = herausforderer;
	}

	public void setHerausgeforderter(Gruppe herausgeforderter) {
		this.herausgeforderter = herausgeforderter;
	}

	public void setQuestFuerHerausforderer(Quest questFuerHerausforderer) {
		this.questFuerHerausforderer = questFuerHerausforderer;
	}

	public void setQuestFuerHerausgeforderter(Quest questFuerHerausgeforderter) {
		this.questFuerHerausgeforderter = questFuerHerausgeforderter;
	}

	public void setGewinner(Gruppe gewinner) {
		this.gewinner = gewinner;
	}

	public void setId(int id) {
		teamcombat_id = id;
	}

	public Gruppe getHerausforderer() {
		return herausforderer;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
}
