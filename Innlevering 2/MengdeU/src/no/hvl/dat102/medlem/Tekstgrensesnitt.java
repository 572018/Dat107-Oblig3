package no.hvl.dat102.medlem;

import java.util.Scanner;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.medlem.*;


public class Tekstgrensesnitt {
	public final static Scanner SC = new Scanner(System.in);
	// leser inn opplysningene om et medlem fra tastatur og legger det inn i datakotakt 
	public void nyttMedlem(Datakontakt kontakt){
		//Nytt medlemsobj. blir opprettet med new String som navn og en tom meng
		System.out.println("Skriv inn navnet ditt:");
		
		MengdeADT<Hobby> m2 = new KjedetMengde<Hobby>();
		Medlem medlem = new Medlem(new String(SC.nextLine()), m2);
		
		//Hobbyobj. blir opprettet og får verdi fra tastatur. Deretter blir det lagt til i mengden m2
		System.out.println("Skriv inn hobbyer du har:");
		System.out.println("Skriv 'stopp' når du er ferdig");
		String str = "";
		do {
			 str = SC.nextLine();
			if(!(str.equals("stopp"))) {
				Hobby hobby = new Hobby(str);
				m2.leggTil(hobby);
			}
		}
		while(!(str.equals("stopp")));
		
		medlem.setHobbyer(m2);
		kontakt.leggTilMedlem(medlem);
	}
	
	// Sletter et medlem fra tabellen.
	public void slettMedlem(Datakontakt kontakt){
		System.out.println("Skriv inn navnet på medlemmet som skal fjernes:");
		kontakt.slettMedlem(SC.nextLine());
		
	}
	
	public void visMedlem(Datakontakt kontakt) {
	//	Medlem [] medlemstab = kontakt.getMedlemstab();
		System.out.println("Skriv inn navnet du søker etter");
		String navn = SC.nextLine();
		//System.out.println(medlemstab[kontakt.finnMedlemsIndeks(navn)].getNavn()); 
		System.out.println(kontakt.getMedlemstab()[kontakt.finnMedlemsIndeks(navn)].getHobbyer().toString()); 
	}
	
	/*public void endreHobbyer(String navn) {
		Datakontakt data = new Datakontakt();
		Medlem[] medlemstab = Datakontakt.getMedlemstab();
		Medlem medlem = new Medlem();
		medlem.
		medlemstab[data.finnMedlemsIndeks(navn)] ;
	}*/
	
}