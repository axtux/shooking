package be.ac.ulb.infof307.g10.db;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.ManagedType;

import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

/**
 * Persistence database to manage Objects persistence.
 * This database is generic (as its name suggest), and is working without knowing object type.
 * Feel free to extends this class to add your own queries to your database.
 */
public class GenericDatabase {
	/**
	 * Can be defined within underlying class
	 * TODO should be ?
	 */
	protected static String NAME = "GL10PU";
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static boolean autoCommit = true;

	/**
	 * Return the EntityManager
	 * @return EntityManager
	 */
	private static EntityManager getEM() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory(NAME);
		}
		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
			// flush at commit
			em.setFlushMode(FlushModeType.COMMIT);
		}
		return em;
	}

	/**
	 * Return underlying transaction
	 * @return EntityTransaction
	 */
	private static EntityTransaction getET() {
		return getEM().getTransaction();
	}

	/**
	 * Get managed classes by this database
	 * @return Array of simpleName of the managed classes
	 */
	public static Class<?>[] getManagedClasses() {
		// get managed types from metamodel
		Set<ManagedType<?>> mt = getEM().getMetamodel().getManagedTypes();
		
		int size = mt.size();
		Class<?>[] arr = new Class[size];
		
		for(ManagedType<?> t: mt) {
			size--;
			arr[size] = t.getJavaType();
		}
		
		return arr;
	}

	/**
	 * Disable autoCommit before doing lots of operations on database. Re-enable when finished.
	 * @param autoCommit New value. Default true.
	 */
	public static void setAutoCommit(boolean autoCommit) {
		GenericDatabase.autoCommit = autoCommit;
		if(autoCommit) {
			// commit after starting auto commit
			getET().commit();
		} else {
			// begin transaction before
			getET().begin();
		}
	}

	private static void begin() {
		if (autoCommit) {
			getET().begin();
		}
	}

	private static void commit() {
		if (autoCommit) {
			getET().commit();
		}
	}

	/**
	 * Create TypedQuery of type with query bound with positional params
	 * @param type
	 * @param query
	 * @param params Optional positional parameters starting at 1 ("?1" for first parameter)
	 * @return
	 */
	private static <T> TypedQuery<T> createQuery(Class<T> type, String query, Object[] params) {
		TypedQuery<T> tq = getEM().createQuery(query, type);
		int i = 1;
		for(Object p: params) {
			tq = tq.setParameter(i, p);
			i++;
		}
		return tq;
	}
	/**
	 * Get one Object of type c from database corresponding to query bounds with params
	 * Params have to be positional parameters. E.g. ?1 for first parameter.
	 * @param <T> Type of Object to get
	 * @param type Return Object type
	 * @param query JPQL Query
	 * @param params Optional positional parameters starting at 1 ("?1" for first parameter)
	 * @return Object of type T
	 */
	public static <T> T getOne(Class<T> type, String query, Object ... params)
			throws NoResultException, NonUniqueResultException {
		return createQuery(type, query, params).getSingleResult();
	}

	/**
	 * Get all Object of type c from database corresponding to query bounds with params
	 * @param <T> Type of Object to get
	 * @param type Return Object type
	 * @param query JPQL Query
	 * @param params Optional positional parameters starting at 1 ("?1" for first parameter)
	 * @return Objects of type T
	 */
	public static <T> List<T> getAll(Class<T> type, String query, Object ... params) {
		return createQuery(type, query, params).getResultList();
	}

	public static <T> List<T> getAll(Class<T> type) {
		String sql = "SELECT o from "+type.getSimpleName()+" o";
		return getAll(type, sql);
	}

	/**
	 * Delete all objects of class type from database
	 * @param type Type of objects to delete
	 */
	public static void deleteAll(Class<?> type) {
		begin();
		getEM().createQuery("delete from "+type.getSimpleName()+" o").executeUpdate();
		commit();
	}

	/**
	 * Delete all objects from database
	 */
	public static void empty() {
		// disable FK constraints
		begin();
		getEM().createNativeQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();
		commit();
		// clear links between objects and database
		getEM().clear();
		// start batch operations
		setAutoCommit(false);
		for(Class<?> c: getManagedClasses()) {
			deleteAll(c);
		}
		// end batch operations
		setAutoCommit(true);
		// enable FK constraints
		begin();
		getEM().createNativeQuery("SET FOREIGN_KEY_CHECKS=1").executeUpdate();
		commit();
	}

	public static boolean isEmpty() {
		for(Class<?> c: getManagedClasses()) {
			if (!getAll(c).isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Insert an object into database. Any further modification will be reflected into database
	 * unless you call the {@link #detach(Object)} method.
	 * @param o Object to insert
	 */
	private static void insert(Object o) throws ExistingException {
		try {
			begin();
			getEM().persist(o);
			commit();
		} catch(RollbackException e) {
			throw new ExistingException(e);
		}
	}

	/**
	 * Update detached object into database.
	 * @param o Object to update
	 */
	private static void update(Object o) throws NonExistingException {
		try {
			begin();
			getEM().merge(o);
			commit();
		} catch (RollbackException e) {
			throw new NonExistingException(e);
		}
	}
	/**
	 * Save object into database.
	 * @param o Object to save
	 */
	public static void save(Object o) {
		try {
			insert(o);
		} catch (ExistingException ee) {
			try {
				update(o);
			} catch (NonExistingException nee) {
				throw new DatabaseException(nee);
			}
		}
		detach(o);
	}

	/**
	 * Delete object from database.
	 * @param o Object to delete
	 */
	public static void delete(Object o) throws NoResultException {
		begin();
		getEM().remove(o);
		commit();
	}

	/**
	 * Detach object from database. Any further modification of the object will not be saved into database
	 * unless you use {@link #update(Object)} method.
	 * @param o Object to detach
	 */
	private static void detach(Object o) {
		begin();
		getEM().detach(o);
		commit();
	}

	public static void close() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}
