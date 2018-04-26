package be.ac.ulb.infof307.g10.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

public class GenericDatabase {
	private static final String NAME = "GL10PU";
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction et;

	/**
	 * Return the EntityManager
	 * @return EntityManager
	 */
	public static EntityManager getEM() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory(NAME);
		}
		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
		}
		return em;
	}

	/**
	 * Return underlying transaction
	 * @return EntityTransaction
	 */
	public static EntityTransaction getET() {
		if (et == null) {
			et = getEM().getTransaction();
		}
		return et;
	}

	/**
	 * Get one Object of type c from database with query and params
	 * @param c Return Object type
	 * @param query JPQL Query
	 * @param params Optional positional parameters (?X starting at 1)
	 * @return Object of type T
	 */
	public static <T> T getOne(Class<T> c, String query, Object ... params) {
		TypedQuery<T> tq = getEM().createQuery(query, c);
		int i = 1;
		for(Object p: params) {
			tq = tq.setParameter(i, p);
			i++;
		}
		return tq.getSingleResult();
	}

	/**
	 * Get all Objects of type c from database with query and params
	 * @param c Return Object type
	 * @param query JPQL Query
	 * @param params Optional positional parameters (?X starting at 1)
	 * @return Objects of type T
	 */
	public static <T> List<T> getAll(Class<T> c, String query, Object ... params) {
		TypedQuery<T> tq = getEM().createQuery(query, c);
		int i = 1;
		for(Object p: params) {
			tq.setParameter(i, p);
			i++;
		}
		return tq.getResultList();
	}

	public static void insert(Object o) throws RollbackException {
		getET().begin();
		getEM().persist(o);
		getET().commit();
	}

	public static void update(Object o) throws RollbackException {
		getET().begin();
		getEM().merge(o);
		getET().commit();
	}

	public static void delete(Object o) throws NoResultException {
		getET().begin();
		getEM().remove(o);
		getET().commit();
	}

	public static void detach(Object o) {
		getET().begin();
		getEM().detach(o);
		getET().commit();
	}
}
