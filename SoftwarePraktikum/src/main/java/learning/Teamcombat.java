package learning;

import java.util.Date;

import kommunikation.Nachricht;

public class Teamcombat {
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
		questFuerHerausforderer = this.herausgeforderter.fragenpool.getQuest();
		questFuerHerausgeforderter = this.herausforderer.fragenpool.getQuest();
	}

	public Gruppe auswerten(){
		return null;
	}

	public Date getAblaufdatum() {
		return ablaufdatum;
	}


	public Gruppe getHerausforderer() {
		return herausforderer;
	}
	
	/**
	 * erstellt einen Quest fuer die Herausforder-Gruppe 
	 * aus dem Fragenpool der herausgeforderten Gruppe  
	 * @return
	 */
	public Quest getQuestFuerHerausforderer() {
		return questFuerHerausforderer;
	}

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
