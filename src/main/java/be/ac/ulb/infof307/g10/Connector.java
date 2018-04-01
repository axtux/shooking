package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.db.DatabaseFacade;
import be.ac.ulb.infof307.g10.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.exceptions.UserAlreadyExistException;
import be.ac.ulb.infof307.g10.models.User;
import org.sqlite.SQLiteException;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class Connector {

	/**
	 * Sha 256 hash function
	 * 
	 * @param password	The password of the user in String format
	 * @return			A hash of this password in String format
	 */
	public static String sha256(String password) {
		MessageDigest digest;
		byte[] encodedHash = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			return new String(encodedHash, "UTF-8");
		} catch (UnsupportedEncodingException e) { // this exception never append because "UTF-8" is a correct encoding
			return "";
		}
	}
	
	/**
	 * Check in the DB if the information (username and Password) are correct and, if it's ok, return a Session object to connect the user
	 * 
	 * @param username	The id of the user in String format
	 * @param password	The password of the user in String format
	 * @return			A Session object that represent the user
	 * @throws IncorrectPasswordException	Append if the password of the user is incorrect
	 */
	public Session openSession(String username, String password) throws IncorrectPasswordException {
        if (checkUserPassword(username, password)) {
            return new Session(username);
        }
        return null;
	}
	
	/**
	 * Create a new user in the DB and connect it with a Session object
	 * 
	 * @param username	The id of the user in Sting format
	 * @param password	The password of the user in String format
	 * @return			A Session object that represent the user
	 * @throws UserAlreadyExistException	Append if the id is not already taken by an other user
	 */
	public Session createUser(String username, String password) throws UserAlreadyExistException {
		//Hash the password
        User u = new User(username, password);
        DatabaseFacade d = new DatabaseFacade();

        try{
			d.insertUser(u);
		}
		catch (RollbackException e) {
			throw new UserAlreadyExistException();
		}
		return new Session(username);

	}

	/**
	 * Destroy the user in the DB
	 * 
	 * @param username	The id of the user in String format
	 * @param password	The password of the user in String format
	 * @return			true if the user is correctly deleted
	 * @throws IncorrectPasswordException	Append if the password of the user is incorrect
	 */
	public Boolean destroyUser(String username, String password) throws IncorrectPasswordException {
		// Delete the user in the DB if the password is correct
        if (checkUserPassword(username, password)){
            DatabaseFacade d = new DatabaseFacade();
            User u = d.getUser(username);
            d.deleteUser(u);
            return true;
        }
        return false;
	}

	public boolean checkUserPassword(String username, String password) throws IncorrectPasswordException {
        try {
			DatabaseFacade d = new DatabaseFacade();
			System.out.println(d.getUser(username));
			User u ;
            u = new User(d.getUser(username));
            if (!u.getPassword().equals(sha256(password))) {
                throw new IncorrectPasswordException();
            }
        }
        catch (NullPointerException e){
            //FIXME - clean me
            throw new IncorrectPasswordException();
        }
        catch (NoResultException e){
			throw new IncorrectPasswordException();
		}
        return true;
    }
}
