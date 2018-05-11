package be.ac.ulb.infof307.g10.db;

import be.ac.ulb.infof307.g10.models.User;

import javax.persistence.NoResultException;

/**
 * Adding some queries to GenericDatabase to meet the need of our custom
 * objects. Abstract because contains only static methods.
 */
public class Database extends GenericDatabase {

	public static void init() {
		setProp("name", "GL10PU");
		if (isEmpty()) {
			Data.fillDB();
		}
	}

	public static User getUser(String username) throws NoResultException {
		return getOne(User.class, "SELECT b from User b where b.username LIKE ?1", username);
	}
}
