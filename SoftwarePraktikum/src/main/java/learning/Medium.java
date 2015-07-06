package learning;

public class Medium implements java.io.Serializable {

	public String name;
	public String pfad;
	public String typ;
	public int id;
	
	/**
	 * Konstruktor eines Mediums
	 * @param name ist der Name des Mediums
	 * @param pfad ist der Pfad des Mediums
	 * @param typ ist der Typ des Mediums
	 */
	public Medium(String name, String pfad, String typ){
		this.name = name;
		this.pfad = pfad;
		this.typ = typ;
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

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
