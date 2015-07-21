package learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Die Klasse Frage stellt eine Teilaufgabe eines Quests dar. Sie beinhaltet Methoden zum Speichern
 * und Verwalten Ihrer Attribute.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FRAGE")
public class Frage implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "frage_id")
	public int frage_id;
	
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="medium_id")
	public Medium medium;
	
	@Column(name = "text")
	public String text;
	
	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@CollectionTable(name="FRAGE_ANTWORTMOEGLICHKEITEN", joinColumns=
	@JoinColumn(name="frage_id"))
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<String> antwortmoeglichkeiten;

	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@CollectionTable(name="FRAGE_LOESUNG", joinColumns=
	@JoinColumn(name="frage_id"))
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<String> loesung;
	
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="benutzer_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	public Benutzer benutzer; //Autor
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fragenpool_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	public Fragenpool fragenpool;
	
	@Transient
	public ArrayList<String> zwischenSpeicherAntworten;
	
	@Transient
	public boolean zwischenSpeicherLoesung1;
	
	@Transient
	public boolean zwischenSpeicherLoesung2;
	
	@Transient
	public boolean zwischenSpeicherLoesung3;
	
	@Transient
	public boolean zwischenSpeicherLoesung4;

	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Frage() {
		antwortmoeglichkeiten = new HashSet<String>();
		loesung = new HashSet<String>();
		medium = new Medium();
		zwischenSpeicherAntworten = new ArrayList<String>();
	}

	/**
	 * Erstellt eine Frage
	 * 
	 * @param titel Titel der Frage
	 * @param text Fragentext
	 * @param antwortmoeglichkeiten Die Antwortm&ouml;glichkeiten
	 * @param loesung Die korrekten L&ouml;sungen
	 */
	public Frage(String text, HashSet<String> antwortmoeglichkeiten, HashSet<String> loesung, Benutzer autor) {
		this.text = text;
		this.loesung = loesung;
		this.benutzer = autor;
		this.antwortmoeglichkeiten = antwortmoeglichkeiten;
		this.loesung = loesung;
		medium = new Medium();
		zwischenSpeicherAntworten = new ArrayList<String>();
	}
	
	public void addAntwortmoeglichkeiten(String antwort) {
		antwortmoeglichkeiten.add(antwort);
	}
	
	public void addLoesung(String loesung) {
		this.loesung.add(loesung);
	}

	public Set<String> getLoesung() {
		return loesung;
	}
	
	public void setLoesung(Set<String> loesung){
		this.loesung = loesung;
	}

	public Set<String> getAntwortmoeglichkeiten() {
		return antwortmoeglichkeiten;
	}

	public void setAntwortmoeglichkeiten(Set<String> antwortmoeglichkeiten){
		this.antwortmoeglichkeiten = antwortmoeglichkeiten;
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
	
	public void setFragenpool(Fragenpool fragenpool){
		this.fragenpool = fragenpool;
	}
	
	public Fragenpool getFragenpool(){
		return fragenpool;
	}
	
	public void setId(int id){
		frage_id = id;
	}
	
	public int getId(){
		return frage_id;
	}

	public ArrayList<String> getZwischenSpeicherAntworten() {
		return zwischenSpeicherAntworten;
	}

	public void setZwischenSpeicherAntworten(ArrayList<String> zwischenSpeicher) {
		this.zwischenSpeicherAntworten = zwischenSpeicher;
	}

	public boolean isZwischenSpeicherLoesung1() {
		return zwischenSpeicherLoesung1;
	}

	public void setZwischenSpeicherLoesung1(boolean zwischenSpeicherLoesung1) {
		this.zwischenSpeicherLoesung1 = zwischenSpeicherLoesung1;
	}

	public boolean isZwischenSpeicherLoesung2() {
		return zwischenSpeicherLoesung2;
	}

	public void setZwischenSpeicherLoesung2(boolean zwischenSpeicherLoesung2) {
		this.zwischenSpeicherLoesung2 = zwischenSpeicherLoesung2;
	}

	public boolean isZwischenSpeicherLoesung3() {
		return zwischenSpeicherLoesung3;
	}

	public void setZwischenSpeicherLoesung3(boolean zwischenSpeicherLoesung3) {
		this.zwischenSpeicherLoesung3 = zwischenSpeicherLoesung3;
	}

	public boolean isZwischenSpeicherLoesung4() {
		return zwischenSpeicherLoesung4;
	}

	public void setZwischenSpeicherLoesung4(boolean zwischenSpeicherLoesung4) {
		this.zwischenSpeicherLoesung4 = zwischenSpeicherLoesung4;
	}
}
