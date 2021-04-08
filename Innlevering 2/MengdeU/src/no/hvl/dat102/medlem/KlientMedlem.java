package no.hvl.dat102.medlem;

public class KlientMedlem {

	public static void main(String[] args) {
		
		Datakontakt kontakt = new Datakontakt(10);
		Meny meny = new Meny(kontakt);
		meny.start();
	}
}
