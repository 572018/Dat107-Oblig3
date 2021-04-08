package oppgave4;

import java.util.ArrayList;
import java.util.List;

public class KlientSortering {

	public static void main(String[] args) {
		
		List<Integer> samling = new ArrayList<Integer>();
		for(int i = 0; i <= 16000; i++) {
			samling.add((int) (Math.random()*(16000-1) + 1));
		}
		
		List<Integer> samling2 = new ArrayList<Integer>();
		for(int i = 0; i<= 100000; i++) {
			samling2.add(2);		
		}
	
		long start = System.nanoTime();
		SorteringsMetoder.kvikkSort(samling2, samling2.indexOf(2), samling2.size() - 1 );
		start = System.nanoTime() - start;
		System.out.println("Kvikksort ny brukte " + start/1000000 + "ms");
		
		
		/*
		long start = System.nanoTime();
		SorteringsMetoder.kvikkSortNy(samling, 0, samling.size() - 1 );
		start = System.nanoTime() - start;
		System.out.println("Kvikksort ny brukte " + start/1000000 + "ms");
		*/
		
		/*
		long start = System.nanoTime();
		SorteringsMetoder.bobleSortering(samling);
		start = System.nanoTime() - start;
		System.out.println("bobleSortering brukte " + start/1000000 + "ms");
		
		start = System.nanoTime();
		SorteringsMetoder.fletteSort(samling, samling.get(0), samling.lastIndexOf(samling));
		start = System.nanoTime() - start;
		System.out.println("fletteSort brukte " + start/1000000 + "ms");
		
		start = System.nanoTime();
		SorteringsMetoder.kvikkSort(samling, samling.get(0), samling.lastIndexOf(samling));
		start = System.nanoTime() - start;
		System.out.println("KvikkSort brukte " + start/1000000 + "ms");
		
		start = System.nanoTime();
		SorteringsMetoder.sorteringVedInnsetting(samling);
		start = System.nanoTime() - start;
		System.out.println("SorteringVedInnsetting brukte " + start/1000000 + "ms");
		
		start = System.nanoTime();
		SorteringsMetoder.utvalgsSortering(samling);
		start = System.nanoTime() - start;
		System.out.println("UtvalgsStortering brukte " + start/1000000 + "ms");
		*/
		
		/*
		String resultat = "{";
		for(Integer s: samling) {
			resultat = resultat + s+", ";
		}
		resultat = resultat + "}";
		resultat = resultat.replace(", }", "}");
		System.out.println(resultat);
		
		System.out.println("Samlingen blir nå sortert:");
		SorteringsMetoder.bobleSortering(samling);
		resultat = "{";
		for(Integer s: samling) {
			resultat = resultat + s+", ";
		}
		resultat = resultat + "}";
		resultat = resultat.replace(", }", "}");
		System.out.println(resultat);
		 */
	}
}
