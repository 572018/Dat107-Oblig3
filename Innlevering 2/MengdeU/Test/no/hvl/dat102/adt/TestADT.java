package no.hvl.dat102.adt;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public abstract class TestADT<T> {

	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;
	private MengdeADT<Integer> tom;
	
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;	
	
	protected abstract MengdeADT<Integer> reset();
	
	
	@BeforeEach
	public void setup() {
		m1 = reset();
		m2 = reset();
		tom = reset();
		
	}
	
	@Test
	public void unionTest()	{
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		Assertions.assertTrue(m1.equals(m1.union(m2)));
		
	}
	@Test
	public void snittTest() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		
		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		
		assertTrue(m1.equals(m1.snitt(m2)));
	}
	
	@Test
	public void differensTest() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		
		assertTrue(m1.equals(m1.differens(tom)));
	}
}
