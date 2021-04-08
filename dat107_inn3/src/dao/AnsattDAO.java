package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import komponenter.Ansatt;
import komponenter.Avdeling;

public class AnsattDAO {

	private EntityManagerFactory emf;
	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("FirmaUnit");
	}

	public void leggTilAnsatt(Ansatt ansatt) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			if (!(sjekkOmAnsattFinnes(ansatt.getBrukernavn()))) {
				
				em.persist(ansatt);
				tx.commit();
			} else {
				System.out.println("Denne personen er allerede ansatt");
			}
		} finally {
			
			em.close();
		}
	}

	public boolean oppdaterAnsatt(Ansatt ansatt) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean bool = false;
		try {
			tx.begin();
			Ansatt hentetAnsatt = finnAnsatt(ansatt.getAnsattNr());
			hentetAnsatt = ansatt;
			em.merge(hentetAnsatt);
			bool = true;
		} finally {
			tx.commit();
			em.close();
		}
		return bool;
	}
	
	private boolean sjekkOmAnsattFinnes(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		List<Ansatt> ansatt = null;
		boolean bool = false;
		try {
			
			TypedQuery<Ansatt> query = em.createQuery("SELECT ansatt FROM Ansatt ansatt ", Ansatt.class);
			ansatt = query.getResultList();
		} finally {
			em.close();
		}
		
		for (int i = 0; i<ansatt.size(); i++) {
			if(brukernavn.equals(ansatt.get(i).getBrukernavn())) {
				bool = true;
			}
		}
		return bool;
	
	}
	public Ansatt finnAnsatt(int ansattnr) {
		EntityManager em = emf.createEntityManager();
		Ansatt ansatt = null;
		try {
			ansatt = em.find(Ansatt.class, ansattnr);
		} finally {
			em.close();
		}
		return ansatt;
	}
	
	public Ansatt finnAnsatt(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		List<Ansatt> ansatt = null;
		try {
			
			TypedQuery<Ansatt> query = em.createQuery("SELECT ansatt FROM Ansatt ansatt", Ansatt.class);
			ansatt = query.getResultList();
		} finally {
			em.close();
		}
		
		return ansatt.get(0);
		
	}
	

	public boolean slettAnsatt(int ansattNr) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean bool = false;
		try {
			tx.begin();
			Ansatt hentetAnsatt = em.find(Ansatt.class, ansattNr);
			hentetAnsatt = null;
			em.merge(hentetAnsatt);
			bool = true;
		} finally {
			tx.commit();
			em.close();
		}
		return bool;
	}
	
	public List<Ansatt> alleAnsatte(){
		EntityManager em = emf.createEntityManager();
		List<Ansatt> ansatt = null;
		try {
			
			TypedQuery<Ansatt> query = em.createQuery("SELECT ansatt FROM Ansatt ansatt ", Ansatt.class);
			ansatt = query.getResultList();
		} finally {
			em.close();
		}
		return ansatt;
	}
}
