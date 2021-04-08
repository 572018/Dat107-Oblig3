//package dao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import komponenter.Avdeling;
//import komponenter.Prosjekt;
//
//public class ProsjektDAO {
//
//	private EntityManagerFactory emf;
//
//	public ProsjektDAO() {
//
//		emf = Persistence.createEntityManagerFactory("FirmaUnit");
//	}
//
//	public void leggTilProsjekt(Prosjekt prosjekt) {
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
//			em.persist(prosjekt);
//			tx.commit();
//		} finally {
//			em.close();
//		}
//	}
//
//	public boolean slettProsjekt(int prosjektNr) {
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		boolean bool = false;
//		try {
//			tx.begin();
//			Prosjekt hentetProsjekt = em.find(Prosjekt.class, prosjektNr);
//			hentetProsjekt = null;
//			em.merge(hentetProsjekt);
//			bool = true;
//		} finally {
//			tx.commit();
//			em.close();
//		}
//		return bool;
//	}
//
//	public Prosjekt finnProsjekt(int prosjektNr) {
//
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		Prosjekt hentetProsjekt;
//		try {
//			tx.begin();
//			hentetProsjekt= em.find(Prosjekt.class, prosjektNr);
//		} finally {
//			em.close();
//		}
//		return hentetProsjekt;
//	}
//
//	public boolean oppdaterAvdeling(Prosjekt prosjekt) {
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		Prosjekt hentetProsjekt;
//		boolean bool = false;
//		try {
//			tx.begin();
//			hentetProsjekt = finnProsjekt(prosjekt.getProsjektNr());
//			hentetProsjekt = prosjekt;
//			em.merge(hentetProsjekt);
//			tx.commit();
//			bool = true;
//		} finally {
//			em.close();
//		}
//		return bool;
//	}
//
//}
