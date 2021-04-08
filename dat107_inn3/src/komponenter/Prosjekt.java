//package komponenter;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "prosjekt", schema = "firma_inn3")
//public class Prosjekt {
//
//	@Id
//	@SequenceGenerator(name = "ProsjektNr_seq", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProsjektNr_seq")
//	private int prosjektNr;
//	private String navn;
//	private String beskrivelse;
//
//	private List<Ansatt> ansatt;
//	
//	public Prosjekt() {
//	}
//
//	public Prosjekt(String navn, String beskrivelse) {
//		this.navn = navn;
//		this.beskrivelse = beskrivelse;
//	}
//
//	public int getProsjektNr() {
//		return prosjektNr;
//	}
//
//	public void setProsjektNr(int prosjektNr) {
//		this.prosjektNr = prosjektNr;
//	}
//
//	public String getNavn() {
//		return navn;
//	}
//
//	public void setNavn(String navn) {
//		this.navn = navn;
//	}
//
//	public String getBeskrivelse() {
//		return beskrivelse;
//	}
//
//	public void setBeskrivelse(String beskrivelse) {
//		this.beskrivelse = beskrivelse;
//	}
//
//}
