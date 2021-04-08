package no.hvl.dat102.medlem;

public class Datakontakt {
	
	private Medlem[] medlemstab;
	private int antallMedlemmer;
	
	public Datakontakt() {
		
	}
	public Datakontakt(int size) {
		medlemstab = new Medlem[size];
		antallMedlemmer = 0;
	}

	public void leggTilMedlem(Medlem person) {
		if(antallMedlemmer >= medlemstab.length)
			utvidKapasitet();
		medlemstab[antallMedlemmer] = person;
		justerAntall(1);
	}
	
	public void slettMedlem(String navn) {
		if(medlemstab[finnMedlemsIndeks(navn)].getStatusIndeks()!= -1) {
			medlemstab[medlemstab[finnMedlemsIndeks(navn)].getStatusIndeks()].setStatusIndeks(-1);
		}
		medlemstab[finnMedlemsIndeks(navn)] = null;
		if(antallMedlemmer >= 1)
			trimTab(medlemstab,antallMedlemmer-1);
		justerAntall(-1);
		
	}
	
	public int finnMedlemsIndeks(String medlemsnavn) {
		int i = 0;
		while(!medlemsnavn.equals(medlemstab[i].getNavn())) {
			i++;
			if(i>=medlemstab.length) {
				i= -1;
				System.out.println("denne personen finnes ikke i tabellen");
				break;
			}
		}
		return i;
	}
	
	public Medlem finnPartnerFor(String medlemsnavn) {
		int i = 0;
		Medlem person1 = medlemstab[finnMedlemsIndeks(medlemsnavn)];
		while ((person1.getHobbyer()!=medlemstab[i].getHobbyer() && medlemstab[i].getStatusIndeks()!=-1) && i<=medlemstab.length ) {
			i++;
		}
		return medlemstab[i];
	}
	
	public void tilbakestillStausIndeks(String medlemsnavn) {
		medlemstab[finnMedlemsIndeks(medlemsnavn)].setStatusIndeks(-1);
	}

	public Medlem[] getMedlemstab() {
		return medlemstab;
	}

	public void setMedlemstab(Medlem[] medlemstab) {
		this.medlemstab = medlemstab;
	}

	public int justerAntall(int n) {
		return antallMedlemmer + n;
		
	}
	public int getAntall() {
		return antallMedlemmer;
	}

	public void setAntall(int antallMedlemmer) {
		this.antallMedlemmer = antallMedlemmer;
	}
	
	private void utvidKapasitet(){//eks. utvide 100%
		Medlem[] tab = new Medlem[(int)Math.ceil(2 * medlemstab.length)];
		for (int i = 0; i <= tab.length; i++){
		tab[i] = medlemstab[i];
		}
		medlemstab = tab;
	}
	
	private Medlem[] trimTab(Medlem[] medlemstab, int antall) { // n er antall elementer
		Medlem[] tab = new Medlem[antall];
		int i = 0;
		while (i < antall) {
			tab[i] = medlemstab[i];
			i++;
		}//while
		
		return tab;
		}//
}
