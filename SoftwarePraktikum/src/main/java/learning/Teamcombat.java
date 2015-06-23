package learning;

import java.util.Date;

public class Teamcombat {
	public Date ablaufdatum; 
	public Gruppe herausforderer; 
	public Gruppe herausgeforderter; 
	public Quest questFürHerausforderer;
	public Quest questFürHerausgeforderter;
	public Gruppe gewinner; 
	public int id; 
	
	
	public void herausfordern(Gruppe herausgeforderter){
		this.herausgeforderter = herausgeforderter;
	}

	public Gruppe auswerten(){
		return null;
	}

	public Date getAblaufdatum() {
		return ablaufdatum;
	}

	public void setAblaufdatum(Date ablaufdatum) {
		this.ablaufdatum = ablaufdatum;
	}

	public Gruppe getHerausforderer() {
		return herausforderer;
	}

	public void setHerausforderer(Gruppe herausforderer) {
		this.herausforderer = herausforderer;
	}

	public Quest getQuestFürHerausforderer() {
		return questFürHerausforderer;
	}

	public void setQuestFürHerausforderer(Quest questFürHerausforderer) {
		this.questFürHerausforderer = questFürHerausforderer;
	}

	public Quest getQuestFürHerausgeforderter() {
		return questFürHerausgeforderter;
	}

	public void setQuestFürHerausgeforderter(Quest questFürHerausgeforderter) {
		this.questFürHerausgeforderter = questFürHerausgeforderter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gruppe getHerausgeforderter() {
		return herausgeforderter;
	}

	public Gruppe getGewinner() {
		return gewinner;
	}
}
