package learning;

public class Admin extends Account{

	public void gruppeL�schen(Gruppe g){
	}
	
	public boolean fachrichtungFreigeben(Fachrichtung k){
		k.setFreigegeben(true);
		return k.isFreigegeben();
	}
	
	public boolean gruppeFreigeben(Gruppe g){
		g.setFreigegeben(true);
		return g.isFreigegeben();
	}
}
