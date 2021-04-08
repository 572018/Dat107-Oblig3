package komponenter;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ansatt", schema = "firma_inn3")
public class Ansatt {

	@Id
	@SequenceGenerator(name = "AnsattNr_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AnsattNr_seq")
	private int ansattNr;
	private String fornavn;
	private String etternavn;
	private String brukernavn;
	private Date ansettelsesDato;
	private String stilling;
	private int manedslonn;

	@ManyToOne()
	private Avdeling avdeling;

//	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "ansatt")
//	private	List<Prosjekt> prosjekt;

	public Ansatt() {

	}

	public Ansatt(String fornavn, String etternavn, Date ansettelsesDato, String stilling,
			int manedslonn, Avdeling avdeling) {
		
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelsesDato = ansettelsesDato;
		this.stilling = stilling;
		this.manedslonn = manedslonn;
		this.avdeling = avdeling;
		setBrukernavn();
	}

	public String skrivUt() {
		return "Ansatt Nr: " + ansattNr + "\nFornavn: " + fornavn + "\nEtternavn: " + etternavn + "\nAnsettelses Dato: "
				+ ansettelsesDato + "\nStilling: " + stilling + "\nMånedslønn: " + manedslonn + "\nAvdeling: "; // +
																												// avdeling;
	}

	public int getAnsattNr() {
		return ansattNr;
	}

	public void setAnsattNr(int ansattNr) {
		this.ansattNr = ansattNr;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn() {
		brukernavn = fornavn.substring(0, 2) + etternavn.substring(0, 2);
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Date getAnsettelsesDato() {
		return ansettelsesDato;
	}

	public void setAnsettelsesDato(Date ansettelsesDato) {
		this.ansettelsesDato = ansettelsesDato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getManedslonn() {
		return manedslonn;
	}

	public void setManedslonn(int månedslonn) {
		this.manedslonn = månedslonn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

//	public List<Prosjekt> getProsjekt() {
//		return prosjekt;
//	}
//
//	public void setProsjekt(List<Prosjekt> prosjekt) {
//		this.prosjekt = prosjekt;
//	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}
	
	

}
