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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import kommunikation.Nachricht;

/**
 * Die Klasse Teamcombat stellt eine Speziaform von Quests dar, bei der zwei Gruppen sich gegenseitig
 * ein Quest aus ihrem eigenen Fragenpool stellen.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TEAMCOMBAT")
public class Teamcombat implements java.io.Serializable {
	
	@Id @GeneratedValue
	@Column(name = "teamcombat_id")
	public int teamcombat_id;
	
	@Column(name = "ablaufdatum")
	public Date ablaufdatum;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "herausforderer_gruppe_id")
	public Gruppe herausforderer;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "herausgeforderter_gruppe_id")
	public Gruppe herausgeforderter;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "herausforderer_quest_id")
	public Quest questFuerHerausforderer;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "herausgeforderter_quest_id")
	public Quest questFuerHerausgeforderter;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "gewinner_gruppe_id")
	public Gruppe gewinner;
	
	@Column(name="gewinnerpunkte")
	private int gewinnerpunkte;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Teamcombat() {}

	/**
	 * Legt einen neuen Teamcombat an
	 * 
	 * @param herausforderer Die herausfordernde Gruppe
	 * @param herausgeforderter Die herausgeforderte Gruppe
	 */
	public Teamcombat(Gruppe herausforderer, Gruppe herausgeforderter) {
		this.herausgeforderter = herausgeforderter;
		this.herausforderer = herausforderer;
		questFuerHerausforderer = this.herausgeforderter.fragenpool.getQuest(herausforderer);
		questFuerHerausgeforderter = this.herausforderer.fragenpool.getQuest(herausgeforderter);
		Date now = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		ablaufdatum = calendar.getTime();
		gewinnerpunkte = 0; 
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
	 * @return Die Gewinnergruppe
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
			gewinnerpunkte = herausforderer; 
			Nachricht nachricht = new Nachricht(gewinner, gewinner, Nachricht.TEAMCOMBATGEWONNEN, this);
			this.herausforderer.benachrichtigen(nachricht);
			this.herausgeforderter.benachrichtigen(nachricht);
			return this.herausforderer;
		} else {
			gewinner = this.herausgeforderter;
			gewinnerpunkte = herausgeforderter; 
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
	 * Erstellt einen Quest f&uumlr die herausfordernde Gruppe aus dem Fragenpool
	 * der herausgeforderten Gruppe
	 * 
	 * @return QuestFuerHerausforderer
	 */
	public Quest getQuestFuerHerausforderer() {
		return questFuerHerausforderer;
	}

	/**
	 * Erstellt einen Quest f&uumlr die herausgeforderte Gruppe aus dem Fragenpool
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
	 * @param teamcombat Der Teamcombat der bearbeitet werden soll
	 * @return Der zu bearbeitende Quest
	 */
	public Quest bearbeiten(Benutzer benutzer) {
		if (this.herausforderer.getMitglieder().contains(benutzer)) {
			return this.questFuerHerausforderer;
		} else {
			return this.questFuerHerausgeforderter;
		}
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
	
	public Date getAblaufdatum() {
		return ablaufdatum;
	}


	public void setHerausforderer(Gruppe herausforderer) {
		this.herausforderer = herausforderer;
	}
	
	public Gruppe getHerausforderer() {
		return herausforderer;
	}

	public void setHerausgeforderter(Gruppe herausgeforderter) {
		this.herausgeforderter = herausgeforderter;
	}
	
	public Gruppe getHerausgeforderter() {
		return herausgeforderter;
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
	
	public Gruppe getGewinner() {
		return gewinner;
	}

	public void setId(int id) {
		teamcombat_id = id;
	}

	public int getId() {
		return teamcombat_id;
	}
	
	public void setGewinnerpunkte(int punkte) {
		this.gewinnerpunkte = punkte;
	}	

	public int getGewinnerpunkte() {
		return gewinnerpunkte;
	}
}
