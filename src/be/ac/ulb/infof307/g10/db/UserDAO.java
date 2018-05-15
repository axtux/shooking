package be.ac.ulb.infof307.g10.db;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class UserDAO {

	public static User userLogin(String username, String password) throws IncorrectPasswordException, NonExistingException {
		try {
			User u = UserDAO.getUser(username);
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
			UserDAO.getUser(username);
			throw new ExistingException();
		} catch (NoResultException e) {
			User u = new User(username, password);
			u.save();
			return u;
		}
	}

	public static User getUser(String username) throws NonExistingException {
		return GenericDatabase.getOne(User.class, "SELECT b from User b where b.username LIKE ?1", username);
	}
}
