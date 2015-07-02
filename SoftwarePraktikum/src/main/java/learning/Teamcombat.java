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
	
	
	
	public void herausfordern(Gruppe herausforderer, Gruppe herausgeforderter){
		this.herausgeforderter = herausgeforderter;
		questFuerHerausforderer = this.herausgeforderter.fragenpool.getQuest();
		questFuerHerausgeforderter = this.herausforderer.fragenpool.getQuest();
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
		return questFuerHerausforderer;
	}

	public Quest getQuestFürHerausgeforderter() {
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
