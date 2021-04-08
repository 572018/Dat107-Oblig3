package no.hvl.dat102.medlem;

import java.util.Scanner;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private Datakontakt kontakt;
	
	public Meny(Datakontakt kontakt){
		tekstgr = new Tekstgrensesnitt();
		this.kontakt = kontakt; 
	}
	
	public void start(){
		
		while (true) {
			
			System.out.println("Kommandoliste:\nNyttmedlem \nSlettmedlem \nVismedlem \nAvslutt ");
			System.out.println("Skriv inn en kommando...");
			switch (Tekstgrensesnitt.SC.nextLine().toLowerCase()) {
			
			case "nyttmedlem":
				tekstgr.nyttMedlem(kontakt);
				break;
				
			case "slettmedlem":
				tekstgr.slettMedlem(kontakt);
				break;
				
			case "vismedlem":
				tekstgr.visMedlem(kontakt);
				break;
				
			case "avslutt":
				System.out.println("Avslutter...");
				System.exit(0);
				break;
				
		default: 
			System.out.println("Ugyldig kommando");
			}
			
		}
	}
	
}


