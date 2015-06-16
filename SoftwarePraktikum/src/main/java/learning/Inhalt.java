package learning;

public class Inhalt {

	public Benutzer autor;
	public int bewertung;
	public String inhalt;
	public int Datum;
	public Medium anhang;
	public String titel;
	public int id;
	
	public void bewerten(boolean positiv){
	}

	public Benutzer getAutor() {
		return autor;
	}

	public void setAutor(Benutzer autor) {
		this.autor = autor;
	}

	public int getBewertung() {
		return bewertung;
	}

	public void setBewertung(int bewertung) {
		this.bewertung = bewertung;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public int getDatum() {
		return Datum;
	}

	public void setDatum(int datum) {
		Datum = datum;
	}

	public Medium getAnhang() {
		return anhang;
	}

	public void setAnhang(Medium anhang) {
		this.anhang = anhang;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
