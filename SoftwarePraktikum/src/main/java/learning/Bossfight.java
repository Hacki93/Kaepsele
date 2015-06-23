package learning;

import java.util.Date;

public class Bossfight extends Challenge {
	private Medium anhang;
	
	public Bossfight(Benutzer bearbeiter, Medium anhang, int punktzahl){
		this.bearbeiter = bearbeiter; 
		this.anhang = anhang; 
		this.punktzahl = punktzahl;
		datum = new Date();
	}

	public Medium getAnhang() {
		return anhang;
	}

	
	public Medium starten(){
		return anhang;
	}
	
	public boolean bestanden(){
		if (this.korrigiere() > (0.8 * this.punktzahl)){
			return true;
		}
		else{
			return false;
		}
	}

}
