package no.hvl.dat102.klient;

import no.hvl.dat102.KjedetBSTre;

public class KlientBSTre {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int snittHoyde = 0;
		for (int j = 0; j < 100; j++) {
			KjedetBSTre<Integer> bstre2 = new KjedetBSTre<Integer>();
			for (int i = 0; i < 8191; i++) {
				bstre2.leggTil((int) Math.floor(Math.random() * 10001));
			}
			System.out.println("Teoretisk minimale høyde " + bstre2.minAntallHoyde(bstre2.antall()));
			System.out.println("Teoretisk maksimale høyde " + bstre2.maksAntallHoyde(bstre2.antall()));
			System.out.println("Største høyden i treet " + bstre2.maksdybdeIBSTre(bstre2.getRot()));
			System.out.println("Minste høyden i treet " + bstre2.mindybdeIBSTre(bstre2.getRot()));
			System.out.println("Antall Noder i bstre: " + bstre2.antall());
			snittHoyde = snittHoyde + bstre2.maksdybdeIBSTre(bstre2.getRot());
		}
		System.out.println("Snitt Høyde av alle trær er " + snittHoyde/100);
//
		/*
		 * Oppgave c)
		 * 
		 * C = 2,2 for 1024 noder
		 * 
		 * 2,2 * log2 (8192) = 28,6
		 * 
		 * Snitt noder ved kjøring = 30;
		 */
		
		
//		// Tester på sortert utskrift
//		System.out.println("Skriver ut elementene sortert i bs-treet");
//		bstre.visInorden();
//
//		// Tester på om et bestemt element fins
//		int element = 8;
//		System.out.println("\nTester paa om elementet " + element + " fins");
//
//		if (bstre.finn(element) != null) {
//			System.out.println("Elementet " + element + " fins i bs-treet");
//		} else {
//			System.out.println("Elementet " + element + " fins ikke i bs-treet");
//		}
//
//		element = 1;
//		System.out.println("\nTester paa om elementet " + element + " fins");
//
//		if (bstre.finn(element) != null) {
//			System.out.println("Elementet " + element + " fins i bs-treet");
//		} else {
//			System.out.println("Elementet " + element + " fins ikke i bs-treet");
//		}
	}

}
