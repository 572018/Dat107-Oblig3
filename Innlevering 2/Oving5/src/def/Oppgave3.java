package def;

public class Oppgave3 {

	
	public static <T extends Comparable <T>> boolean binaerSoek (T[] data, int min, int maks, T el) {
		if (min > maks){ // basistilfelle , ingen element
			return false;
		}
		int	midtpunkt = (min + maks) / 2; //midtpunktet på tabellen, hvor søket blir delt opp og algoritmen finner mindre enn eller større en dette punktet
		int resultat = el.compareTo (data[midtpunkt]);
		if (resultat == 0){ // basistilfelle , finner elementet
			return true;
		} 
		if (resultat < 0){ // hvis resultatet er mindre enn verdien på midtpunktet vil denne koden kjøres
			return binaerSoek(data, min, midtpunkt -1, el);
			}
		else { //ellers vil denne deller kjøres. Dette fortsetter helt til algoritmen finner det den søker etter, eller at den har søkt igjennom alt og ikke finner elementet. Da eksisterer ikke elementet i tabellen. 
			return binaerSoek(data, midtpunkt + 1, maks, el);
		}
	}
}
