package learning;

import java.util.Date;

public class Challenge implements java.io.Serializable{
public Date datum; 
public Benutzer bearbeiter; 
public int erreichbarePunktzahl;
protected int erreichtePunktzahl;
public int id; 


public Benutzer getBearbeiter() {
	return bearbeiter;
}

public void setBearbeiter(Benutzer bearbeiter) {
	this.bearbeiter = bearbeiter;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Date getDatum(){
	return datum;
}

public void setDatum(Date datum) {
	this.datum = datum;
}


public int korrigiere(){
	return 0;
}


}
