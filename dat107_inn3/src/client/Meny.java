package client;

import java.util.Scanner;

public class Meny {

	private TUI tui;
	public final static Scanner SC = new Scanner(System.in);
	
	
	public void start() {
		tui = new TUI();
		while(true) {
			System.out.println("Velkommen til databasen for selskapet!\n"
					+ "For å legge til en ansatt tast: 1\n"
					+ "For å slette en ansatt tast: 2\n"
					+ "For å endre eller oppdatere en ansatt tast: 3\n"
					+ "For å legge til en avdeling tast: 4\n"
					+ "For å endre eller oppdatere en avdeling tast: 5\n"
					+ "For å avslutte skriv: avslutt");
			
			String kommando = SC.nextLine().toLowerCase();
			switch(kommando) {
			
			case "1":
				tui.leggTilAnsatt();
				break;
			case "2":
				tui.slettAnsatt();
				break;
			case "3":
				tui.endreAnsatt();
				break;
			case "4":
				tui.LeggTilAvdeling();
				break;
			case "5":
				tui.endreAvdeling();
				break;
			case "6":
				tui.slettAvdeling();
			case "avslutt":
				System.exit(0);
				
			default: 
				System.out.println("dette er ikke en gyldig kommando");
				break;
			}
		}
	}

}
