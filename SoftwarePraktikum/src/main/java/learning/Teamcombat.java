package learning;

import java.util.Date;

import kommunikation.Nachricht;

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
		questF�rHerausforderer = herausgeforderter.fragenpool.getQuest();
		questF�rHerausgeforderter = herausforderer.fragenpool.getQuest();
//		Nachricht nachricht = new Nachricht(this.herausforderer, this.herausgeforderter, 4);
//		gruppeBenachrichtigen(herausgeforderter, nachricht);
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

	public Quest getQuestF�rHerausforderer() {
		return questF�rHerausforderer;
	}

	public Quest getQuestF�rHerausgeforderter() {
		return questF�rHerausgeforderter;
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
