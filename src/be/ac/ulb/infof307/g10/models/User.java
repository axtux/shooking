package be.ac.ulb.infof307.g10.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;
import be.ac.ulb.infof307.g10.utils.Hash;

/**
 * Manage user, password and shopping list. Use static methods to get instance.
 */
@Entity
public class User extends ModelObject {

	private static final long serialVersionUID = -0L;

	@Column(unique = true)
	private String username;

	private String hashedPassword;

	@OneToOne(cascade = CascadeType.ALL)
	private ShoppingList shoppingList;

	/**
	 * Needed by JPA
	 */
	protected User() {
	}

	private User(String username, String password) {
		if (username == null || password == null) {
			throw new NullPointerException();
		}
		this.username = username;
		setPassword(password);
		this.shoppingList = new ShoppingList();
	}

	public String getUsername() {
		return username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setPassword(String password) {
		this.hashedPassword = Hash.sha256(password);
	}

	public boolean isPassword(String password) {
		return Hash.sha256(password).equals(hashedPassword);
	}

	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	// static methods
	public static User login(String username, String password) throws IncorrectPasswordException, NonExistingException {
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

	public static User signup(String username, String password) throws ExistingException {
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
