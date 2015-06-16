package learning;

public class Medium {

	public String name;
	public String pfad;
	public int typ;
	public boolean öffentlich;
	public int id;
	
	public boolean dateiLöschen(){
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPfad() {
		return pfad;
	}

	public void setPfad(String pfad) {
		this.pfad = pfad;
	}

	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ = typ;
	}

	public boolean isÖffentlich() {
		return öffentlich;
	}

	public void setÖffentlich(boolean öffentlich) {
		this.öffentlich = öffentlich;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
