package learning;

import java.util.Date;

import kommunikation.Nachricht;

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
		questFürHerausforderer = herausgeforderter.fragenpool.getQuest();
		questFürHerausgeforderter = herausforderer.fragenpool.getQuest();
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

	public Quest getQuestFürHerausforderer() {
		return questFürHerausforderer;
	}

	public Quest getQuestFürHerausgeforderter() {
		return questFürHerausgeforderter;
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
