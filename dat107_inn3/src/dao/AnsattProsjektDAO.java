//package dao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import komponenter.AnsattProsjekt;
//
//public class AnsattProsjektDAO {
//
//	  private EntityManagerFactory emf;
//
//	  public AnsattProsjektDAO() {
//			
//			emf = Persistence.createEntityManagerFactory("FirmaUnit");
//		}
//	  public void leggTilAnsattProsjekt(AnsattProsjekt prosjekt) {
//			EntityManager em = emf.createEntityManager();
//			EntityTransaction tx = em.getTransaction();
//			try {
//				tx.begin();
//				em.persist(prosjekt);
//				tx.commit();
//			} finally {
//				em.close();
//			}
//		}
//
//		public boolean slettAnsattProsjekt(int prosjektNr) {
//			EntityManager em = emf.createEntityManager();
//			EntityTransaction tx = em.getTransaction();
//			boolean bool = false;
//			try {
//				tx.begin();
//				AnsattProsjekt hentetProsjekt = em.find(AnsattProsjekt.class, prosjektNr);
//				hentetProsjekt = null;
//				em.merge(hentetProsjekt);
//				bool = true;
//			} finally {
//				tx.commit();
//				em.close();
//			}
//			return bool;
//		}
//
//		public AnsattProsjekt finnAnsattProsjekt(int prosjektNr) {
//
//			EntityManager em = emf.createEntityManager();
//			EntityTransaction tx = em.getTransaction();
//			AnsattProsjekt hentetProsjekt;
//			try {
//				tx.begin();
//				hentetProsjekt= em.find(AnsattProsjekt.class, prosjektNr);
//			} finally {
//				em.close();
//			}
//			return hentetProsjekt;
//		}
//
//		public boolean oppdaterAnsattProsjekt(AnsattProsjekt prosjekt) {
//			EntityManager em = emf.createEntityManager();
//			EntityTransaction tx = em.getTransaction();
//			AnsattProsjekt hentetProsjekt;
//			boolean bool = false;
//			try {
//				tx.begin();
//				hentetProsjekt = finnAnsattProsjekt(prosjekt.getProsjekt().getProsjektNr());
//				hentetProsjekt = prosjekt;
//				em.merge(hentetProsjekt);
//				tx.commit();
//				bool = true;
//			} finally {
//				em.close();
//			}
//			return bool;
//		}
//
//}
