package learning;

import java.util.Date;

import kommunikation.Nachricht;

public class Teamcombat implements java.io.Serializable{
	public Date ablaufdatum; 
	public Gruppe herausforderer; 
	public Gruppe herausgeforderter; 
	public Quest questFuerHerausforderer;
	public Quest questFuerHerausgeforderter;
	public Gruppe gewinner; 
	public int id; 
	
	//leerer Konstruktor
	public Teamcombat(){}
	
	
	/**
	 * Legt einen neuen Teamcombat an
	 * @param herausforderer
	 * @param herausgeforderter
	 */
	public Teamcombat(Gruppe herausforderer, Gruppe herausgeforderter){
		this.herausgeforderter = herausgeforderter;
		this.herausforderer = herausforderer;
		questFuerHerausforderer = this.herausgeforderter.fragenpool.getQuest();
		questFuerHerausgeforderter = this.herausforderer.fragenpool.getQuest();
	}

	
	/**
	 * Wertet den Teamcombat aus und gibt die Gewinnergruppe zurueck
	 * @return Gewinnergruppe
	 */
	public Gruppe auswerten(){
		int herausforderer = questFuerHerausforderer.korrigiere();
		int herausgeforderter = questFuerHerausgeforderter.korrigiere();
		if (herausforderer > herausgeforderter){
			gewinner = this.herausforderer;
			return this.herausforderer;
		} else {
			gewinner = this.herausgeforderter;
			return this.herausgeforderter;
		} 
	}

	public Date getAblaufdatum() {
		return ablaufdatum;
	}


	public Gruppe getHerausforderer() {
		return herausforderer;
	}
	
	/**
	 * erstellt einen Quest fuer die herausfordernde Gruppe 
	 * aus dem Fragenpool der herausgeforderten Gruppe  
	 * @return QuestFuerHerausforderer
	 */
	public Quest getQuestFuerHerausforderer() {
		return questFuerHerausforderer;
	}

	/**
	 * erstellt einen Quest fuer die herausgeforderte Gruppe
	 * aus dem Fragenpool der hausfordernden Gruppe
	 * @return QuestFuerHerausgeforderter
	 */
	public Quest getQuestFuerHerausgeforderter() {
		return questFuerHerausgeforderter;
	}

	public int getId() {
		return id;
	}

	public Gruppe getHerausgeforderter() {
		return herausgeforderter;
	}

	public Gruppe getGewinner() {
		return gewinner;
	}
}
