package komponenter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "avdeling", schema = "firma_inn3")
public class Avdeling {

	@Id
	@SequenceGenerator(name = "AvdelingsNr_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AvdelingsNr_seq")
	private int avdelingsNr;
	private String navn;
	
	@OneToOne
	private Ansatt sjef;
	
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "avdeling")
	private List<Ansatt> ansatt;

	public Avdeling() {

	}

	public Avdeling(String navn, Ansatt sjef, List<Ansatt> ansatt) {
		this.navn = navn;
		this.sjef = sjef;
		this.ansatt = ansatt;
	}

	public int getAvdelingsNr() {
		return avdelingsNr;
	}

	public void setAvdelingsNr(int avdelingsNr) {
		this.avdelingsNr = avdelingsNr;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public List<Ansatt> getAnsattListe() {
		return ansatt;
	}

	public void setAnsattListe(List<Ansatt> ansatt) {
		this.ansatt = ansatt;
	}

	public Ansatt getSjef() {
		return sjef;
	}

	public void setSjef(Ansatt sjef) {
		this.sjef = sjef;
	}

	
}
