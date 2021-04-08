package client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.AnsattDAO;
//import dao.AnsattProsjektDAO;
import dao.AvdelingDAO;
//import dao.ProsjektDAO;
import komponenter.Ansatt;
//import komponenter.AnsattProsjekt;
import komponenter.Avdeling;
//import komponenter.Prosjekt;

public class TUI {

	public TUI() {

	}

	// Ansatt...
	public void leggTilAnsatt() {
		System.out.println("Vi trenger noen opplysninger om den ansatte for å legge personen til i systemene");
		AnsattDAO ansattDAO = new AnsattDAO();
		System.out.print("Fornavn: ");
		String fornavn = Meny.SC.nextLine();
		System.out.print("Etternavn: ");
		String etternavn = Meny.SC.nextLine();
		System.out.print("Ansettelses Dato (YYYY-MM-DD): ");
		Date ansettelsesDato = new Date(0);
		ansettelsesDato = Date.valueOf(Meny.SC.nextLine());
		System.out.print("Stilling: ");
		String stilling = Meny.SC.nextLine();
		System.out.print("Lønn: ");
		int manedslonn = Integer.parseInt(Meny.SC.nextLine());
		Avdeling avdeling = finnAvdeling();

		Ansatt ansatt = new Ansatt(fornavn, etternavn, ansettelsesDato, stilling, manedslonn, avdeling);

		ansattDAO.leggTilAnsatt(ansatt);
		leggTilAnsattIAvdeling(avdeling, ansatt);
	}

	public void endreAnsatt() {
		Ansatt ansatt = finnAnsatt();

		boolean bool = true;
		while (bool) {
			System.out.println("Vil du endre:\nFornavn = 1\nEtternavn = 2" + "\nAnsettelses Dato = 3"
					+ "\nStilling = 4\nLønn = 5\nAvdeling = 6" + "\n avslutt for å stoppe");
			String kommando = Meny.SC.nextLine().toLowerCase();
			switch (kommando) {

			case "1":
				ansatt.setFornavn(Meny.SC.nextLine());
				break;
			case "2":
				ansatt.setEtternavn(Meny.SC.nextLine());
				break;
			case "3":
				ansatt.setAnsettelsesDato(Date.valueOf(Meny.SC.nextLine()));
				break;
			case "4":
				ansatt.setStilling(Meny.SC.nextLine());
				break;
			case "5":
				ansatt.setManedslonn(Integer.parseInt(Meny.SC.nextLine()));
				break;
			case "6":
				if(ansatt.getAnsattNr() == ansatt.getAvdeling().getSjef().getAnsattNr()) {
					System.out.println("Kan ikke endre avdeling på sjefen");
				}else {
					ansatt.setAvdeling(finnAvdeling());
				}
				break;
			case "avslutt":
				AnsattDAO ansattDAO = new AnsattDAO();
				ansattDAO.oppdaterAnsatt(ansatt);
				bool = false;
				;
				break;
			default:
				System.out.println("Dette er ikke en gyldig kommando");
			}
		}
	}

	public void slettAnsatt() {
		List<Avdeling> avdelingListe = hentAlleAvdelinger();
		Ansatt ansatt = finnAnsatt();
		boolean bool = false;
		for(int i = 1; i<= avdelingListe.size(); i++) {
			if(ansatt.getAnsattNr() == avdelingListe.get(i).getSjef().getAnsattNr()) {
				bool = true;
			}
		}
		if(bool == false) {
			AnsattDAO ansattDAO = new AnsattDAO();
			ansattDAO.slettAnsatt(ansatt.getAnsattNr());
		}else {
			System.out.println("Kan ikke slette en ansatt som er sjef for en avdeling");
		}
	}

	public Ansatt finnAnsatt() {
		AnsattDAO ansattDAO = new AnsattDAO();
		Ansatt ansatt = new Ansatt();
		System.out.println("Oppgi brukernavnet eller ansattNr: ");
		String sokeord = Meny.SC.nextLine();

		if (sokeord.matches("\\d")) {
			ansatt = ansattDAO.finnAnsatt(Integer.parseInt(sokeord));

		} else {
			ansatt = ansattDAO.finnAnsatt(sokeord);
		}
		return ansatt;
	}
	// ...Ansatt

	// Avdeling...
	public void LeggTilAvdeling() {
		System.out.println("Det trengs noen opplysninger om den nye avdelingen");
		System.out.print("Navn på avdelingen: ");
		String avdelingsNavn = Meny.SC.nextLine();
		System.out.print("AnsattNr til sjefen av avdelingen: ");

		AnsattDAO ansattDAO = new AnsattDAO();
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		List<Ansatt> ansattListe = new ArrayList<Ansatt>();

		Ansatt sjef = ansattDAO.finnAnsatt(Integer.parseInt(Meny.SC.nextLine()));
		ansattListe.add(sjef);
		Avdeling avdeling = new Avdeling(avdelingsNavn, sjef, ansattListe);

		avdelingDAO.leggTilAvdeling(avdeling);
		sjef.setAvdeling(avdeling);
		ansattDAO.oppdaterAnsatt(sjef);
	}

	public void endreAvdeling() {
		Avdeling avdeling = finnAvdeling();
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		boolean bool = true;
		while (bool) {
			System.out.println(
					"Vil du endre: " + "\nNavn på avdeling = 1" + "\nSjef = 2" + "\nLegg til ansatt til avdeling = 3"
							+ "\nfjern ansatt fra avdeling = 4" + "\nAvslutt for å stoppe");
			String kommando = Meny.SC.nextLine().toLowerCase();
			switch (kommando) {

			case "1":
				avdeling.setNavn(Meny.SC.nextLine());
				avdelingDAO.oppdaterAvdeling(avdeling);
				break;
			case "2":
				System.out.println("Her kan du legge inn en ny sjef for avdelingen");
				Ansatt sjef = finnAnsatt();
				avdeling.setSjef(sjef);
				avdelingDAO.oppdaterAvdeling(avdeling);
				break;
			case "3":
				leggTilAnsattIAvdeling(avdeling.getAvdelingsNr());
				break;
			case "4":
				fjernAnsattFraAvdeling();
				break;
			case "avslutt":
				bool = false;
				;
				break;
			default:
				System.out.println("Dette er ikke en gyldig kommando");
			}
		}
	}

	public void slettAvdeling() {
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		Avdeling avdeling = avdelingDAO.finnAvdeling(Integer.parseInt(Meny.SC.nextLine()));
		if (avdeling.getAnsattListe().size() <= 1) {
			Ansatt ansatt = avdeling.getSjef();
			leggTilAnsattIAvdeling(finnAvdeling(), ansatt);
			avdelingDAO.slettAvdeling(avdeling.getAvdelingsNr());
		} else {
			System.out.println("Du kan ikke slette en avdeling med flere ansatte enn sjefen");
		}
	}

	public void leggTilAnsattIAvdeling(Avdeling avdeling, Ansatt ansatt) {
		avdeling.getAnsattListe().add(ansatt);
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		avdelingDAO.oppdaterAvdeling(avdeling);
	}

	public void leggTilAnsattIAvdeling(int avdelingsNr) {
		Avdeling avdeling = finnAvdeling(avdelingsNr);
		Ansatt ansatt = finnAnsatt();
		avdeling.getAnsattListe().add(ansatt);
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		avdelingDAO.oppdaterAvdeling(avdeling);
	}

	public void fjernAnsattFraAvdeling() {
		Avdeling avdeling = finnAvdeling();
		Ansatt ansatt = finnAnsatt();
		List<Ansatt> ansattListe = avdeling.getAnsattListe();
		ansattListe.remove(ansatt.getAnsattNr());
	}

	public Avdeling finnAvdeling(int avdelingsNr) {
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		Avdeling avdeling = avdelingDAO.finnAvdeling(avdelingsNr);

		return avdeling;
	}

	public Avdeling finnAvdeling() {
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		System.out.println("Oppgi avdelingsNr: ");
		int avdelingsNr = Integer.parseInt(Meny.SC.nextLine());
		Avdeling avdeling = avdelingDAO.finnAvdeling(avdelingsNr);

		return avdeling;
	}
	
	public List<Avdeling> hentAlleAvdelinger(){
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		Avdeling avdeling;
		List<Avdeling> avdelingListe = new ArrayList<Avdeling>();
		int i = 1;
		do {
			avdeling = avdelingDAO.finnAvdeling(i);
			avdelingListe.add(avdeling);
		}while(avdeling != null);
		return avdelingListe;
	}
	
	// ...Avdeling
	
//	// Prosjekt...
//	public void leggTilProsjekt() {
//		System.out.println("Det trengs noen opplysninger om det nye prosjektet");
//		System.out.print("Navn på prosjektet");
//		String prosjektNavn = Meny.SC.nextLine();
//		System.out.println("Beskrivelse på prosjektet");
//		String prosjektBeskrivelse = Meny.SC.nextLine();
//		
//		ProsjektDAO prosjektDAO = new ProsjektDAO();
//		Prosjekt prosjekt = new Prosjekt(prosjektNavn, prosjektBeskrivelse);
//		prosjektDAO.leggTilProsjekt(prosjekt);
//	}
//	
//	public void endreProsjekt() {
//		Prosjekt prosjekt = finnProsjekt();
//		AnsattProsjekt aProsjekt = new AnsattProsjekt();
//		boolean bool = true;
//		while (bool) {
//			System.out.println("Vil du endre:\nNavn på prosjekt = 1\nBeskrivelse på prosjekt = 2" + "\nFøre timer = 3"
//					+ "\nEndre rolle på ansatt = 4");
//			String kommando = Meny.SC.nextLine().toLowerCase();
//			switch (kommando) {
//
//			case "1":
//				System.out.print("Nytt Navn på prosjekt: ");
//				prosjekt.setNavn(Meny.SC.nextLine());
//				break;
//			case "2":
//				System.out.println("Nåværende beskrivelse:");
//				System.out.println(prosjekt.getBeskrivelse());
//				System.out.print("Ny beskrivelse på prosjekt: ");
//				prosjekt.setBeskrivelse(Meny.SC.nextLine());
//				break;
//			case "3":
//				System.out.println("Hvem skal du føre timer på?");
//				skrivTimer(finnAnsatt());
//				break;
//			case "4":
//				aProsjekt.setRolle(Meny.SC.nextLine() );
//				break;
//			
//			case "avslutt":
//				AnsattProsjektDAO apDAO = new AnsattProsjektDAO();
//				apDAO.oppdaterAnsattProsjekt(aProsjekt);
//				bool = false;
//				break;
//			default:
//				System.out.println("Dette er ikke en gyldig kommando");
//			}
//		}
//	}
//	
//	public Prosjekt finnProsjekt() {
//		System.out.println("Oppgi prosjekt nummer");
//		ProsjektDAO pDAO = new ProsjektDAO();
//		Prosjekt prosjekt = pDAO.finnProsjekt(Integer.parseInt(Meny.SC.nextLine()));
//		return prosjekt;
//	}
//	
//	
//	public Prosjekt finnProsjekt(int prosjektNr) {
//		ProsjektDAO pDAO = new ProsjektDAO();
//		Prosjekt prosjekt = pDAO.finnProsjekt(prosjektNr);
//		return prosjekt;
//	}
//	
//	public void skrivTimer(Ansatt Ansatt) {
//		AnsattProsjektDAO apDAO = new AnsattProsjektDAO();
//		System.out.println("Oppgi prosjekt nummer");
//		AnsattProsjekt ap = apDAO.finnAnsattProsjekt(Integer.parseInt(Meny.SC.nextLine()));
//		System.out.println("Oppgi arbeidstimer på " + ap.getProsjekt().getNavn());
//		ap.setTimetall(Integer.parseInt(Meny.SC.nextLine()));
//	}
}
