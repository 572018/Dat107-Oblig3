package def;

public class Oppgave3 {

	
	public static <T extends Comparable <T>> boolean binaerSoek (T[] data, int min, int maks, T el) {
		if (min > maks){ // basistilfelle , ingen element
			return false;
		}
		int	midtpunkt = (min + maks) / 2; //midtpunktet p� tabellen, hvor s�ket blir delt opp og algoritmen finner mindre enn eller st�rre en dette punktet
		int resultat = el.compareTo (data[midtpunkt]);
		if (resultat == 0){ // basistilfelle , finner elementet
			return true;
		} 
		if (resultat < 0){ // hvis resultatet er mindre enn verdien p� midtpunktet vil denne koden kj�res
			return binaerSoek(data, min, midtpunkt -1, el);
			}
		else { //ellers vil denne deller kj�res. Dette fortsetter helt til algoritmen finner det den s�ker etter, eller at den har s�kt igjennom alt og ikke finner elementet. Da eksisterer ikke elementet i tabellen. 
			return binaerSoek(data, midtpunkt + 1, maks, el);
		}
	}
}
