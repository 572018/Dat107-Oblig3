package no.hvl.dat102;


import no.hvl.dat102.adt.TestADT;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class KjedetMengdeTest<Integer> extends TestADT {
	 @Override
		protected MengdeADT<Integer> reset() {
			return new KjedetMengde<Integer>();
		}	
}
