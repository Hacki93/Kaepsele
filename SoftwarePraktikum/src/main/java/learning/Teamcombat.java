package learning;

import java.util.Date;

public class Teamcombat {
	public Date ablaufdatum; 
	public Gruppe herausforderer; 
	public Gruppe herausgeforderter; 
	public Quest questF�rHerausforderer;
	public Quest questF�rHerausgeforderter;
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

	public Quest getQuestF�rHerausforderer() {
		return questF�rHerausforderer;
	}

	public void setQuestF�rHerausforderer(Quest questF�rHerausforderer) {
		this.questF�rHerausforderer = questF�rHerausforderer;
	}

	public Quest getQuestF�rHerausgeforderter() {
		return questF�rHerausgeforderter;
	}

	public void setQuestF�rHerausgeforderter(Quest questF�rHerausgeforderter) {
		this.questF�rHerausgeforderter = questF�rHerausgeforderter;
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
