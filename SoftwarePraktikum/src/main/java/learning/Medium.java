package learning;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "MEDIUM")
public class Medium implements java.io.Serializable {

	@Id @GeneratedValue
	@Column(name = "medium_id")
	public int medium_id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "dateiname")
	public String dateiname;
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="mediathek_id")
	Mediathek mediathek;
	
	@Transient
	MultipartFile file;
		
	/**
	 * Konstruktor f&uuml;r Hibernate
	 */
	public Medium(){}
	
	/**
	 * Konstruktor eines Mediums
	 * @param name ist der Name des Mediums
	 * @param pfad ist der Pfad des Mediums
	 * @param typ ist der Typ des Mediums
	 */
	public Medium(String name, String pfad, String typ){
		this.name = name;
		this.dateiname = pfad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateiname() {
		return dateiname;
	}

	public void setDateiname(String pfad) {
		this.dateiname = pfad;
	}

	public int getId() {
		return medium_id;
	}

	public void setId(int id) {
		medium_id = id;
	}
	
	public MultipartFile getFile() {
		return file; 
	} 

	public void setFile(MultipartFile file) { 
		this.file = file;
		this.dateiname = file.getOriginalFilename();
	}
	
	public Mediathek getMediathek(){
		return mediathek;
	}
	
	public void setMediathek(Mediathek mediathek){
		this.mediathek = mediathek;
	}

}
