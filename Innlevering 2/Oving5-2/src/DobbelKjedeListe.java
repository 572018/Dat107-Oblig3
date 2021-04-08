public class DobbelKjedeListe <T extends Comparable<T>> {
	
	private DobbelNode<T> start;
	private DobbelNode<T> slutt;
	private int antall;
	
	public DobbelKjedeListe(T minVerdi, T maksVerdi) {
		
		DobbelNode<T> startNode = new DobbelNode<T>(minVerdi);
		start = startNode;
		
		DobbelNode<T> sluttNode = new DobbelNode<T>(maksVerdi);
		slutt = sluttNode;
		sluttNode.setForrige(startNode);
		startNode.setNeste(sluttNode);
	}
	
	public void leggTil(T ny) {
		DobbelNode<T> aktuell = start;
		if(ny.compareTo(start.getElement()) <= 0 || ny.compareTo(slutt.getElement()) >= 0){
			System.out.println("Ugyldig verdi");
		}
		else {
			while((ny.compareTo(start.getElement()))>=0) {
				aktuell = aktuell.getNeste();
			}
			aktuell = aktuell.getForrige();
			DobbelNode<T> nyNode = new DobbelNode<T>();
			nyNode.setNeste(aktuell.getNeste());
			nyNode.setForrige(aktuell.getForrige());
			aktuell.getNeste().setNeste(nyNode);
			aktuell.setForrige(nyNode);
		}
	}
	public T fjern(T x) {
		
	}
	public boolean fins(T x) {
		
	}
	public void visListe() {
		
	}
	
}
