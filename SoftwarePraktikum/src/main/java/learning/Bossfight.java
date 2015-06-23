package learning;

import java.util.Date;

public class Bossfight extends Challenge {
	private Medium anhang;
	
	public Bossfight(Benutzer bearbeiter, Medium anhang){
		this.bearbeiter = bearbeiter; 
		this.anhang = anhang; 
		
		datum = new Date();
	}

	public Medium getAnhang() {
		return anhang;
	}

	
	public Medium starten(){
		return anhang;
	}
	
	public boolean bestanden(){
		return false;
	}

}
