package learning;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "FRAGE")
public class Frage implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "frage_id")
	public int frage_id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="medium_id")
	public Medium medium;

	@Column(name = "titel")
	public String titel;
	
	@Column(name = "text")
	public String text;
	
	@ElementCollection(targetClass = String.class)
	@CollectionTable(name="FRAGE_ANTWORTMOEGLICHKEITEN", joinColumns=@JoinColumn(name="frage_id"))
	public Set<String> antwortmoeglichkeiten;
	
	@ElementCollection(targetClass = String.class)
	@CollectionTable(name="FRAGE_ANTWORTEN", joinColumns=@JoinColumn(name="frage_id"))
	public Set<String> antworten;
	
	@Column(name = "bearbeitet")
	private boolean bearbeitet;
	
	@ElementCollection(targetClass = String.class)
	@CollectionTable(name="FRAGE_LOESUNG", joinColumns=@JoinColumn(name="frage_id"))
	public Set<String> loesung;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="benutzer_id")
	public Benutzer benutzer; //Autor
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="fragenpool_id")
	public Fragenpool fragenpool;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Frage() {
		bearbeitet = false;
		antwortmoeglichkeiten = new HashSet<String>();
		antworten = new HashSet<String>();
		loesung = new HashSet<String>();
		medium = new Medium();
	}

	/**
	 * Erstellt eine Frage
	 * 
	 * @param titel Titel der Frage
	 * @param text Fragentext
	 * @param antwortmoeglichkeiten Die Antwortm&ouml;glichkeiten
	 * @param loesung Die korrekten L&ouml;sungen
	 */
	public Frage(String titel, String text, HashSet<String> antwortmoeglichkeiten, HashSet<String> loesung, Benutzer autor) {
		this.titel = titel;
		this.text = text;
		this.loesung = loesung;
		this.benutzer = autor;
		bearbeitet = false;
		antwortmoeglichkeiten = new HashSet<String>();
		antworten = new HashSet<String>();
		loesung = new HashSet<String>();
		medium = new Medium();
	}

	/**
	 * Vergleicht die gegebenen Antworten mit der L&oumlsung und gibt die
	 * entsprechende Punktzahl zur&uumlck
	 * 
	 * @return erreichte Punktzahl
	 */
	public int korrigiere() {
		Set<String> loesung2 = this.loesung;
		int punkte = 0;
		for (String a : antworten) {
			if (loesung2.contains(a)) {
				punkte = punkte + 3;
				loesung2.remove(a);
			} else {
				punkte = punkte - 3;
			}
		}

		if (loesung2.size() > 0) {
			punkte = punkte - 3 * loesung2.size();
		}

		if (punkte < 0) {
			return 0;
		} else {
			return punkte;
		}
	}

	public Set<String> getLoesung() {
		return loesung;
	}

	public void addAntworten(HashSet<String> antworten) {
		this.antworten = antworten;
	}

	public Set<String> getAntworten() {
		return antworten;
	}

	public boolean isBearbeitet() {
		return bearbeitet;
	}

	public void setBearbeitet(boolean bearbeitet) {
		this.bearbeitet = bearbeitet;
	}

	public Set<String> getAntwortmoeglichkeiten() {
		return antwortmoeglichkeiten;
	}

	public void addAntwortmoeglichkeiten(String antwort) {
		antwortmoeglichkeiten.add(antwort);
	}
	
	public void addLoesung(String loesung) {
		this.loesung.add(loesung);
	}
	
	public void setMedium(Medium medium) {
		this.medium = medium;
	}
	
	public Medium getMedium(){
		return medium;
	}
	
	public void setBenutzer(Benutzer autor) {
		benutzer = autor;
	}
	
	public Benutzer getBenutzer() {
		return benutzer;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText(){
		return text;
	}
	
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public String getTitel(){
		return titel;
	}
	
	public void setFragenpool(Fragenpool fragenpool){
		this.fragenpool = fragenpool;
	}
	
	public Fragenpool getFragenpool(){
		return fragenpool;
	}
}
