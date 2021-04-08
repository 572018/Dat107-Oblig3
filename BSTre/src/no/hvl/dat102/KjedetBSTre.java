package no.hvl.dat102;

import java.util.Iterator;

import no.hvl.dat102.adt.BSTreADT;

//********************************************************************
// KjedetBinærSøkeTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {

	private int antall;
	private BinaerTreNode<T> rot;
	private int dybde;

	/**
	 * @return the rot
	 */
	public BinaerTreNode<T> getRot() {
		return rot;
	}

	/**
	 * @param rot the rot to set
	 */
	public void setRot(BinaerTreNode<T> rot) {
		this.rot = rot;
	}

	/******************************************************************
	 * Oppretter et tomt binært søketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et binært søketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære trett er tomt og usann ellers.
	 *****************************************************************/

	int finnDybde(BinaerTreNode<T> Node) {
		if (Node == null)
			return -1;

		int lefth = finnDybde(Node.getVenstre());
		int righth = finnDybde(Node.getHoyre());

		if (lefth > righth) {
			return lefth + 1;
		} else {
			return righth + 1;
		}
	}

	@Override
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære treet er tom og usann ellers.
	 *****************************************************************/
	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	/**********************************************************************
	 * Legger det spesifiserte elementet på passende plass i BS-treet. Like
	 * elementer blir lagt til høyre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/
	@Override
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		
		if (p == null) {
			p = new BinaerTreNode<T>(element);
			return p;
		}
		if (element.compareTo(p.getElement()) < 0) {
			p.setVenstre(leggTilRek(p.getVenstre(), element));

		} else {
			p.setHoyre(leggTilRek(p.getHoyre(), element));
		}
		return p;
	}

	/******************************************************************
	 * Legger det spesifiserte elementet på passende plass i dette binære søketreet.
	 * Like elementer blir lagt til høyre.
	 ******************************************************************/

	public void leggTil2(T element) {
		rot = leggTil2Hjelper(rot, element);
		antall++;
	}

	public BinaerTreNode<T> leggTil2Hjelper(BinaerTreNode<T> p, T element) {
		BinaerTreNode<T> nyRot = new BinaerTreNode<T>(element);
		if (p == null) {
			p = new BinaerTreNode<T>(element);
			return p;
		} else {
			if (p.getElement().compareTo(element) < 0) {
				nyRot.setVenstre(p);
			} else {
				nyRot.setHoyre(p);
			}
		}
		return nyRot;
	}

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette binære søketreet.
	 *********************************************************************/
	@Override
	public T fjernMin() {
		BinaerTreNode<T> tmp;
		BinaerTreNode<T> slettet;
		if (rot.getVenstre() == null) {
			slettet = rot;
			rot = rot.getHoyre();
		} else {
			while (rot.getVenstre().getVenstre()!= null) {
				tmp = rot.getVenstre();
			}
			slettet = rot.getVenstre();
			rot.setVenstre(rot.getVenstre().getHoyre());
		}
		return slettet.getElement();
	}//

	/******************************************************************
	 * Fjerner noden med største verdi fra dette binære søketreet.
	 ******************************************************************/
	@Override
	public T fjernMaks() {
		BinaerTreNode<T> tmp;
		BinaerTreNode<T> slettet;
		if (rot.getHoyre() == null) {
			slettet = rot;
			rot = rot.getHoyre();
		} else {
			while (rot.getHoyre().getHoyre() != null) {
				tmp = rot.getHoyre();
			}
			slettet = rot.getHoyre();
			rot.setHoyre(rot.getHoyre().getVenstre());
		}
		return slettet.getElement();
	}//

	/******************************************************************
	 * Returnerer det minste elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMin() {
		if (rot.getVenstre() == null) {
			return rot.getElement();
		} else {
			while (rot.getVenstre() != null) {
				rot = rot.getVenstre();
			}
			return rot.getElement();
		}
	}//

	/******************************************************************
	 * Returnerer det største elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMaks() {
		if (rot.getHoyre() == null) {
			return rot.getElement();
		} else {
			while (rot.getHoyre() != null) {
				rot = rot.getHoyre();
			}
			return rot.getElement();
		}
	}//

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null ellers. Bruk av rekursjon /
	 ******************************************************************************/
	@Override
	public T finn(T element) {
		return finnElement(rot, element);
	}

	// Den rekursive hjelpemetoden for søking
	public T finnElement(BinaerTreNode<T> rot, T element) {
		BinaerTreNode<T> funnet = new BinaerTreNode<T>(null);
		if (rot.getElement().equals(element))
			return element;
		if ((element.compareTo(rot.getElement()) < 0) && rot.getVenstre() != null)
			funnet.setElement(finnElement(rot.getVenstre(), element));
		else if ((element.compareTo(rot.getElement()) >= 0) && rot.getHoyre() != null)
			funnet.setElement(finnElement(rot.getHoyre(), element));
		else
			funnet.setElement(null);
		return funnet.getElement();
	}

	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		BinaerTreNode<T> funnet = new BinaerTreNode<T>(null);
		if (rot.getElement().equals(element))
			return element;
		while (!(rot.getElement().equals(element)) && (rot.getElement() != null)) {
			if (rot.getElement().compareTo(element) < 0) {
				funnet.setElement(rot.getElement());
				rot = rot.getHoyre();
			}
			if (rot.getElement().compareTo(element) >= 0) {
				funnet.setElement(rot.getElement());
				rot = rot.getVenstre();
			}
		}

		return funnet.getElement().equals(element) ? element : null;
	}

	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visInorden(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInorden(p.getHoyre());
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);

	}

	// log2 N = log10 N / log10 2, 1 Node = dybde 0
	public int minAntallHoyde(int antall) {
		return (int) ((Math.log10(antall) / Math.log10(2)) / (Math.log10(2) / Math.log10(2)));
	}

	public int maksAntallHoyde(int antall) {
		return antall - 1;
	}
	
	public int maksdybdeIBSTre(BinaerTreNode<T> p) {
        if (p == null)
            return 0;
        else
        {
            int VDybde = maksdybdeIBSTre(p.getVenstre());
            int RDybde = maksdybdeIBSTre(p.getHoyre());
  
            if (VDybde > RDybde)
                return (VDybde + 1);
             else
                return (RDybde + 1);
        }
    }
	
	public int mindybdeIBSTre(BinaerTreNode<T> p) {
        if (p == null)
            return 0;
        else
        {
            int VDybde = maksdybdeIBSTre(p.getVenstre());
            int RDybde = maksdybdeIBSTre(p.getHoyre());
  
            if (VDybde < RDybde)
                return (VDybde + 1);
             else
                return (RDybde + 1);
        }
    }
	
}// class
