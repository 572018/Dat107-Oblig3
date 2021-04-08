package def;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Oppgave1b {

	
	private int an;
	private int a0 = 2;
	private int a1 = 5;
	ArrayList<Integer> liste = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Oppgave1b b = new Oppgave1b();
		b.start();
	}
	
	public void start()	{
		liste.add(a0);
		liste.add(a1);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Hvor mange elementer skal beregnes?");
		int elementer = sc.nextInt();
		for(int i = 2; i<= elementer; i++) {
			liste.add(0);
		}
		beregnAn(elementer);
		for(Integer tall: liste) {
			System.out.println(tall);
		}
		sc.close();
		
	}
	
	public int beregnAn(int n) {
		if(n == 0) {
			return a0;
		}
		if(n == 1) {
			return a1;
		}
		else {
		an = 5*beregnAn(n-1) - 6*beregnAn(n-2) + 2;
		liste.set(n, an);
		}
		return an;
	}
}
