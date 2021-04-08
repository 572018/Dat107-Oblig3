package def;

import java.util.Scanner;

public class Oppgave1a {
	private static int S = 0;
	
	
	public static void main (String [] args) {
		System.out.println("Skriv tall. Maskinen summerer alle tallene i en så lang rekke som du taster inn");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(sum(n));
		sc.close();
		
	}
	public static int sum(int n) {
		// basis
		if (n == 1 ) { 
			return 1;
		}
		// Rekursiv del
		else {
			S = n + sum(n-1); 
		}
		return S;
	}
}
