package no.hvl.dat102;

import no.hvl.dat102.adt.TestADT;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class TabellMengdeTest<Integer> extends TestADT {
	
	@Override
	protected MengdeADT<Integer> reset()	{
		return new TabellMengde<Integer>();
	}
}
