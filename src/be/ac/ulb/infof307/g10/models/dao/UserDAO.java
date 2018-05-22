package be.ac.ulb.infof307.g10.models.dao;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.database.AutoSaver;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

/**
 * Data access object for {@link User}
 */
final public class UserDAO {

	/**
	 * Avoid object creation
	 */
	private UserDAO() {
	}

	/**
	 * Log a user in
	 * @param username the username
	 * @param password the password
	 * @return the user if it does exist a user with that username and password.
	 * 			Throws an exception if not
	 */
	public static User login(String username, String password) throws IncorrectPasswordException, NonExistingException {
		User u = UserDAO.getByUsername(username);
		u.checkPassword(password);
		AutoSaver.autosave(u);
		return u;
	}

	/**
	 * Create a user in the database
	 * @param username the username
	 * @param password the password
	 * @param password2 the confirmation of the password
	 * @return the created user if no user with that username already exists.
	 * 			An exception if it does.
	 */
	public static User create(String username, String password, String password2) throws ExistingException {
		try {
			UserDAO.getByUsername(username);
			throw new ExistingException("A user already exists with this name");
		} catch (NonExistingException e) {
			User u = new User(username, password, password2);
			AutoSaver.autosave(u);
			return u;
		}
	}

	/**
	 * Research a user with a certain username
	 * @param username the username
	 * @return the user if it does exist. An exception if not.
	 */
	public static User getByUsername(String username) throws NonExistingException {
		try {
			User u = Database.getOne(User.class, "SELECT b from User b where b.name LIKE ?1", username);
			AutoSaver.autosave(u);
			return u;
		} catch (NoResultException e) {
			throw new NonExistingException("no user with that name");
		}
	}

}
