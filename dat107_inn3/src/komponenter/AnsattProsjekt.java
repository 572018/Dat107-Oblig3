//package komponenter;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "ansattProsjekt", schema = "firma_inn3")
//public class AnsattProsjekt {
//
//	@Id
//	@ManyToOne
//    @MapsId("ansattNr")
//    @JoinColumn(name = "ansattNr")
//    private Ansatt ansatt;
//
//	@ManyToOne
//    @MapsId("prosjektNr")
//    @JoinColumn(name = "prosjektNr")
//	private Prosjekt prosjekt;
//	
//	@Column(name = "timetall")
//	private int timetall;
//	@Column(name = "rolle")
//	private String rolle;
//
//	public AnsattProsjekt() {
//
//	}
//
//	public AnsattProsjekt(Ansatt ansatt, Prosjekt prosjekt, int timetall, String rolle) {
//		this.ansatt = ansatt;
//		this.prosjekt = prosjekt;
//		this.timetall = timetall;
//		this.rolle = rolle;
//	}
//
//	public Ansatt getAnsatt() {
//		return ansatt;
//	}
//
//	public void setAnsatt(Ansatt ansatt) {
//		this.ansatt = ansatt;
//	}
//
//	public Prosjekt getProsjekt() {
//		return prosjekt;
//	}
//
//	public void setProsjekt(Prosjekt prosjekt) {
//		this.prosjekt = prosjekt;
//	}
//
//	public int getTimetall() {
//		return timetall;
//	}
//
//	public void setTimetall(int timetall) {
//		this.timetall = timetall;
//	}
//
//	public String getRolle() {
//		return rolle;
//	}
//
//	public void setRolle(String rolle) {
//		this.rolle = rolle;
//	}
//	
//
//}