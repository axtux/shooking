package be.ac.ulb.infof307.g10.models.database;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.ManagedType;

import be.ac.ulb.infof307.g10.models.AbstractObject;
import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;

/**
 * Object to manage {@link AbstractObject} persistence. This database is working
 * only with {@link AbstractObject}s because save method needs an auto generated
 * id. General way to access this class is using a DAO. For more information
 * about internal behavior, please see official JPA documentation.
 */
final public class Database {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static final Map<String, String> properties = new HashMap<>();

	/**
	 * Avoid object creation
	 */
	private Database() {
	}
	/**
	 * Set property to overwrite any value from persistence.xml
	 * 
	 * @param name
	 *            Name of property
	 * @param value
	 *            Value
	 */
	public static void setProp(String name, String value) {
		properties.put(name, value);
		// force reopening at next use
		close();
	}

	/**
	 * Return the EntityManager
	 * 
	 * @return EntityManager
	 */
	private synchronized static EntityManager getEM() {
		if (properties.get("name") == null) {
			throw new DatabaseException("You must set name property before using Database");
		}
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory(properties.get("name"), properties);
		}
		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
			// flush at commit
			em.setFlushMode(FlushModeType.COMMIT);
		}
		return em;
	}

	/**
	 * Surround
	 * 
	 * @param transaction
	 *            Transaction to run
	 */
	private static void transaction(Runnable transaction) {
		EntityManager em = getEM();
		em.getTransaction().begin();
		transaction.run();
		em.getTransaction().commit();
	}

	private static void query(String query) {
		transaction(() -> getEM().createQuery(query).executeUpdate());
	}

	private static void nativeQuery(String query) {
		transaction(() -> getEM().createNativeQuery(query).executeUpdate());
	}

	private static void persist(Object o) {
		transaction(() -> getEM().persist(o));
	}

	private static void merge(Object o) {
		transaction(() -> getEM().merge(o));
	}

	/**
	 * Get managed classes by this database
	 * 
	 * @return Array of simpleName of the managed classes
	 */
	public static Class<?>[] getManagedClasses() {
		// get managed types from meta model
		Set<ManagedType<?>> mt = getEM().getMetamodel().getManagedTypes();

		int size = mt.size();
		Class<?>[] arr = new Class[size];

		for (ManagedType<?> t : mt) {
			size--;
			arr[size] = t.getJavaType();
		}

		return arr;
	}

	private static <T> TypedQuery<T> createQuery(Class<T> type, String query, Object[] params) {
		TypedQuery<T> tq = getEM().createQuery(query, type);
		int i = 1;
		for (Object p : params) {
			tq = tq.setParameter(i, p);
			i++;
		}
		return tq;
	}

	/**
	 * Get one Object of class type from database corresponding to query with
	 * parameters params bound as positional parameters. In your query, use ?1
	 * for first parameter, ?2 for second, ...
	 * 
	 * @param <T>
	 *            Type of Object to get
	 * @param type
	 *            Return Object type
	 * @param query
	 *            Query in Java Persistence Query Language
	 * @param params
	 *            Optional positional parameters starting at 1 ("?1" for first
	 *            parameter)
	 * @return Object of type T
	 */
	public static <T> T getOne(Class<T> type, String query, Object... params)
			throws NoResultException, NonUniqueResultException {
		T result = createQuery(type, query, params).getSingleResult();
		// detach object
		getEM().clear();
		return result;
	}

	/**
	 * Same as {@link #getOne(Class, String, Object...)} for multiple objects.
	 * 
	 * @param <T>
	 *            Type of Object to get
	 * @param type
	 *            Return Object type
	 * @param query
	 *            Query in Java Persistence Query Language
	 * @param params
	 *            Optional positional parameters starting at 1 ("?1" for first
	 *            parameter)
	 * @return List of objects. Can be empty.
	 */
	public static <T> List<T> getAll(Class<T> type, String query, Object... params) {
		List<T> resultList = createQuery(type, query, params).getResultList();
		// detach objects
		getEM().clear();
		return resultList;
	}

	public static <T> List<T> getAll(Class<T> type) {
		String sql = "SELECT o from " + type.getSimpleName() + " o";
		return getAll(type, sql);
	}

	/**
	 * Delete all objects of class type from database
	 * 
	 * @param type
	 *            Type of objects to delete
	 */
	public static void deleteAll(Class<?> type) {
		query("delete from " + type.getSimpleName() + " o");
	}

	public static void delete(AbstractObject o) throws DatabaseException {
		if (o.getId() == null) {
			throw new DatabaseException("Object to delete have never been saved");
		}

		query("delete from " + o.getClass().getSimpleName() + " o WHERE o.id=" + o.getId());
	}

	/**
	 * Delete all objects from database
	 */
	public static void empty() {
		// disable FK constraints
		nativeQuery("SET FOREIGN_KEY_CHECKS=0");
		// clear links between objects and database
		getEM().clear();
		for (Class<?> c : getManagedClasses()) {
			// abstract classes have no table
			if (Modifier.isAbstract(c.getModifiers())) {
				continue;
			}
			deleteAll(c);
		}
		// enable FK constraints
		nativeQuery("SET FOREIGN_KEY_CHECKS=1");
	}

	public static boolean isEmpty() {
		for (Class<?> c : getManagedClasses()) {
			if (!getAll(c).isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Save object into database.
	 * 
	 * @param o
	 *            Object to save
	 */
	public static void save(AbstractObject o) throws DatabaseException {
		try {
			// id is defined when object is saved the first time
			if (o.getId() == null) {
				persist(o);
			} else {
				merge(o);
			}
			// detach object
			getEM().clear();
		} catch (RollbackException e) {
			throw new DatabaseException(e);
		}
	}

	/**
	 * Save object into database.
	 * 
	 * @param ol
	 *            Objects to save
	 */
	public static void save(Iterable<? extends AbstractObject> ol) throws DatabaseException {
		for (AbstractObject o : ol) {
			save(o);
		}
	}

	public synchronized static void close() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}
