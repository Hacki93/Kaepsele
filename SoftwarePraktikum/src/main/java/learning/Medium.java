package learning;

public class Medium {

	public String name;
	public String pfad;
	public int typ;
	public boolean �ffentlich;
	public int id;
	
	public boolean dateiL�schen(){
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

	public boolean is�ffentlich() {
		return �ffentlich;
	}

	public void set�ffentlich(boolean �ffentlich) {
		this.�ffentlich = �ffentlich;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
