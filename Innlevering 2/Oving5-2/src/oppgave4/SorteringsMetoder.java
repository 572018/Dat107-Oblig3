package oppgave4;

import java.util.List;

public class SorteringsMetoder {
	/**
	 * Utvalgssortering
	 * 
	 * 
	 * @param samling er data som skal sorteres
	 * 
	 */
	
	public static <T extends Comparable<T>> void utvalgsSortering(List<T> samling) {
		int minstePos;
		for (int i = 0; i < samling.size() - 1; i++) {
			minstePos = i;
			for (int j = i + 1; j < samling.size(); j++) {
				if (samling.get(j).compareTo(samling.get(minstePos)) < 0) {
					minstePos = j;
				}
			}

			// byte om
			T tmp = samling.get(i);
			
			samling.set(i, samling.get(minstePos));
			samling.set(minstePos, tmp);
		}
	}

	public static <T extends Comparable<T>> void sorteringVedInnsetting(List<T> samling) {
		for (int i = 1; i < samling.size(); i++) {
			T nokkel = samling.get(i);
			int p = i;

			while (p > 0 && nokkel.compareTo(samling.get(p-1)) < 0) {
				samling.set(p, samling.get(p-1));
				p--;
			}
			samling.set(p, nokkel);
		}
	}
	

	public static <T extends Comparable<T>> void bobleSortering(List<T> samling) {
		for (int siste = samling.size() - 1; siste > 0; siste--) {
			for (int i = 0; i < siste; i++) {
				if (samling.get(i).compareTo(samling.get(i+1)) > 0) {
					Integer tmp = (Integer) samling.get(i);
					samling.set(i, samling.get(i+1));
					samling.set(i+1, (T) tmp);
				}
			}
		}

	}

	private static <T> void swap(List<T> samling, int i, int j) {
		T tmp = samling.get(i);
		samling.set(i,samling.get(j));
		samling.set(j, tmp);
	}

	private static <T extends Comparable<T>> int finnPartisjon(List<T> samling, int min, int maks) {
		T temp, pivot;
		int midten = (min + maks) / 2;
		pivot = samling.get(midten);
		swap(samling, midten, min); // bytter om første og midtelementet

		int venstre = min + 1;
		int hoyre = maks;
		while (venstre < hoyre) {// ytre løkke

			/** Søker et element som er > enn pivot */
			/** Sikrer at partisjoneringsprosessen vil fortsette så lenge venstre < hoyre */
			while (venstre < hoyre && samling.get(venstre).compareTo(pivot) <= 0) {
				venstre++;
			}

			/** Søker et element som er <= enn pivot */
			while (samling.get(hoyre).compareTo(pivot) > 0) {
				hoyre--;
			}

			/** bytter elementene desom venstre er mindre enn hoyre */
			if (venstre < hoyre) {
				swap(samling, venstre, hoyre);
			}

		} // while – ytre løkke

		/** flytter pivot til riktig og sin endelige plass */

		swap(samling, min, hoyre);

		return hoyre;

	}// metode

	public static <T extends Comparable<T>> void kvikkSort(List<T> samling, int min, int maks) {

		// basis: 0 eller 1 element -> gjer ingenting

		if (min < maks) { // minst to element
			int posPivot = finnPartisjon(samling, min, maks);
			// sorter venstre del
			kvikkSort(samling, min, posPivot - 1);
			// sorter høgre del
			kvikkSort(samling, posPivot + 1, maks);
		}
	}
	
	public static <T extends Comparable<T>> void kvikkSortNy(List<T> data, int min, int maks) {
			final int MIN = 10;
			int posPartisjon;
			if (maks - min + 1 > MIN) {//antall elementer > MIN ?
				posPartisjon = finnPartisjon(data, min, maks);
				kvikkSortNy(data, min, posPartisjon - 1);
				kvikkSortNy(data, posPartisjon + 1, maks);
			}
	}// metode

	private static <T extends Comparable<T>> void flette(List<T> samling, int forste, int midten, int siste) {
		/*
		 * Fletter to sorterte deltabeller, tabell[forste,midten] og
		 * tabell[midten+1,siste] til en sortert tabell Forkrav: forste <= midten <=
		 * siste Deltabellene tabell[forste … midten] og tabell[midten+1 … siste] er
		 * hver sorterte i ikke- avtagende rekkefølge.
		 * 
		 * ResultatTabell[forste … siste] er sortert.
		 * 
		 * Implementasjon : Denne metoden fletter to deltabeller til en hjelpetabell og
		 * kopierer resultatet til den originale tabellen.
		 */

		int storrelse = siste - forste + 1;
		T[] hjelpeTabell =  (T[]) (new Comparable[storrelse]);

		int forsteV = forste;
		int sisteV = midten;
		int forsteH = midten + 1;
		int sisteH = siste;

		// indeks i hjelp
		int h = 0;

		while (forsteV <= sisteV && forsteH <= sisteH) {
			if (samling.get(forsteV).compareTo(samling.get(forsteH)) <= 0) {
				hjelpeTabell[h] = samling.get(forsteV);
				forsteV++;
			} else {
				hjelpeTabell[h] = samling.get(forsteH);
				forsteH++;
			}
			h++;
		}

		// kopiere resten av venstre del (kan være tom)
		while (forsteV <= sisteV) {
			hjelpeTabell[h] = samling.get(forsteV);
			forsteV++;
			h++;
		} // while

		// kopiere resten av høyre del (kan være tom)
		while (forsteH <= sisteH) {
			hjelpeTabell[h] = samling.get(forsteH);
			forsteH++;
			h++;
		} // while

		// Kopier resultatet tilbake til den originale tabellen
		h = 0;
		for (int indeks = forste; indeks <= siste; indeks++) {
			samling.set(indeks, hjelpeTabell[h]);
			h++;
		}
	}// flette */

	public static <T extends Comparable<T>> void fletteSort(List<T> samling, int forste, int siste) {
		// basis: 1 element - > gjer ingenting
		if (forste < siste) { // minst to element
			int midten = (forste + siste) / 2;
			fletteSort(samling, forste, midten);
			fletteSort(samling, midten + 1, siste);
			flette(samling, forste, midten, siste);
		}
	}

}