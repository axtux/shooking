package be.ac.ulb.infof307.g10.models.dao;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.database.AutoSaver;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class UserDAO {

	public static User login(String username, String password) throws IncorrectPasswordException, NonExistingException {
		User u = UserDAO.getByUsername(username);
		u.checkPassword(password);
		AutoSaver.autosave(u);
		return u;
	}

	public static User create(String username, String password) throws ExistingException {
		try {
			UserDAO.getByUsername(username);
			throw new ExistingException();
		} catch (NonExistingException e) {
			User u = new User(username, password);
			AutoSaver.autosave(u);
			return u;
		}
	}

	public static User getByUsername(String username) throws NonExistingException {
		try {
			User u = Database.getOne(User.class, "SELECT b from User b where b.username LIKE ?1", username);
			AutoSaver.autosave(u);
			return u;
		} catch (NoResultException e) {
			throw new NonExistingException(e);
		}
	}

}
