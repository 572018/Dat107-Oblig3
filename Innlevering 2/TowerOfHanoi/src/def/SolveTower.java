package def;

import java.lang.Object;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class SolveTower {
/**
* Creates a TowersOfHanoi puzzle and solves it.
*/
	public static void main(String[] args) {
		//Vil ta over en time med 30
		Scanner sc = new Scanner(System.in);
		int ringer = sc.nextInt();
		long starttime = System.nanoTime();
		TowersOfHanoi towers = new TowersOfHanoi(ringer);
		towers.solve();
		System.out.println(towers.getNumberOfMoves() + " steg for " + ringer + " ringer");
		long elapsedTime = (System.nanoTime() - starttime)/(long)1000000;
		System.out.println(elapsedTime + " ms");
		
	
		
		
	}	
}