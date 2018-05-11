package be.ac.ulb.infof307.g10.db;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class UserDAO extends AbstractDAO {

	public static User userLogin(String username, String password) throws IncorrectPasswordException, NonExistingException {
		try {
			User u = Database.getUser(username);
			if (u.isPassword(password)) {
				return u;
			}
			throw new IncorrectPasswordException();
		} catch (NoResultException e) {
			throw new NonExistingException(e);
		}
	}

	public static User userSignup(String username, String password) throws ExistingException {
		try {
			Database.getUser(username);
			throw new ExistingException();
		} catch (NoResultException e) {
			User u = new User(username, password);
			u.save();
			return u;
		}
	}
}
