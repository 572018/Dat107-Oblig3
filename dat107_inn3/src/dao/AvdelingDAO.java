package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import client.Meny;
import komponenter.Ansatt;
import komponenter.Avdeling;

public class AvdelingDAO {

	private EntityManagerFactory emf;
	
	public AvdelingDAO() {
		
		emf = Persistence.createEntityManagerFactory("FirmaUnit");
	}
	
	public void leggTilAvdeling(Avdeling avdeling) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

//			if (sjekkOmAvdelingFinnes(avdeling.getNavn()) == null) {
				em.persist(avdeling);
				tx.commit();
//			} else {
//				System.out.println("Denne avdelingen finnes allerede");
//			}
		} finally {
			
			em.close();
		}
	}

	public boolean slettAvdeling(int avdelingsNr) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean bool = false;
		try {
			tx.begin();
			Avdeling hentetAvdeling = em.find(Avdeling.class, avdelingsNr);
			hentetAvdeling = null;
			em.merge(hentetAvdeling);
			bool = true;
		} finally {
			tx.commit();
			em.close();
		}
		return bool;
	}
	
	public Avdeling finnAvdeling(int avdelingsNr) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Avdeling hentetAvdeling;
		try {
			tx.begin();
			hentetAvdeling = em.find(Avdeling.class, avdelingsNr);
		} finally {
			em.close();
		}
		return hentetAvdeling;
	}
	
	public boolean oppdaterAvdeling(Avdeling avdeling) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Avdeling hentetAvdeling;
		boolean bool = false;
		try {
			tx.begin();
			hentetAvdeling = finnAvdeling(avdeling.getAvdelingsNr());
			hentetAvdeling = avdeling;
			em.merge(hentetAvdeling);
			tx.commit();
			bool = true;
		} finally {
			em.close();
		}
		return bool;
	}
	
	private Avdeling sjekkOmAvdelingFinnes(String navn) {
		EntityManager em = emf.createEntityManager();
		List<Avdeling> avdeling = null;
		try {
			
			TypedQuery<Avdeling> query = em.createQuery("SELECT avdeling FROM Avdeling avdeling", Avdeling.class);
			avdeling = query.getResultList();
		} finally {
			em.close();
		}
		int i = 0;
		while(!(navn.equals(avdeling.get(i).getNavn())) && avdeling.get(i)!= null) {
			i++;
		}
		return avdeling.get(i);
		
	}
	

}
