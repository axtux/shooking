package be.ac.ulb.infof307.g10.models;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.UserAlreadyExistException;
import be.ac.ulb.infof307.g10.models.exceptions.UserDoesNotExistException;
import be.ac.ulb.infof307.g10.utils.Hash;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;


public class Connector {
	/**
	 * Check in the DB if the information (username and Password) are correct and, if it's ok, return a Session object to connect the user
	 * 
	 * @param username	The id of the user in String format
	 * @param password	The password of the user in String format
	 * @return			A Session object that represent the user
	 * @throws IncorrectPasswordException	Append if the password of the user is incorrect
	 * @throws UserDoesNotExistException 				Append if the username doesn't exist in DB
	 */
	//FIXME - really same methid than CheckUserPassword
	public User openSession(String username, String password) throws IncorrectPasswordException, UserDoesNotExistException {
        try {
			User u = new User(Database.getUser(username));
            if (u.getPassword().equals(Hash.sha256(password))) {
                return u;
            }
            else {
            	throw new IncorrectPasswordException();
            }
        } catch (NoResultException e){
            throw new UserDoesNotExistException();
        }
	}
	
	/**
	 * Create a new user in the DB and connect it with a Session object
	 * 
	 * @param username	The id of the user in Sting format
	 * @param password	The password of the user in String format
	 * @return			A Session object that represent the user
	 * @throws UserAlreadyExistException	Append if the id is not already taken by an other user
	 */
	public User createUser(String username, String password) throws UserAlreadyExistException {
        try{
			User u = new User(username, password);
			Database.insert(u);
			return u;
		}
		catch (RollbackException e) {
			throw new UserAlreadyExistException();
		}

	}

	/**
	 * Destroy the user in the DB
	 * 
	 * @param username	The id of the user in String format
	 * @param password	The password of the user in String format
	 * @throws IncorrectPasswordException	Append if the password of the user is incorrect
	 */
	//FIXME - exceptions and not bool
	public void destroyUser(String username, String password) throws IncorrectPasswordException {
        checkUserPassword(username, password);
        User u = Database.getUser(username);
        Database.delete(u);
	}

	//FIXME - exceptions and not bool
	public void checkUserPassword(String username, String password) throws IncorrectPasswordException {
        try {
			User u ;
            u = new User(Database.getUser(username));
            if (!u.getPassword().equals(Hash.sha256(password))) {
                throw new IncorrectPasswordException();
            }
        } catch (NullPointerException | NoResultException e){
            throw new IncorrectPasswordException();
        }
    }
}
