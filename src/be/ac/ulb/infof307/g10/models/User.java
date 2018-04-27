package be.ac.ulb.infof307.g10.models;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import javax.persistence.RollbackException;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingUserException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingUserException;
import be.ac.ulb.infof307.g10.utils.Hash;

/**
 * Manage user, password and shopping list.
 * Use static methods to get instance.
 */
@Entity
public class User extends ModelObject {

	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer id;

	@Column(unique = true)
	@Basic(optional = false)
	private String username;

	@Basic(optional = false)
	private String hashedPassword;

	@OneToOne(cascade = CascadeType.ALL)
	private ShoppingList shoppingList;

	// NEEDED BY JPA
	private User() {}

	private User(String username, String password) {
		this.username = username;
		setPassword(password);
		this.shoppingList = new ShoppingList();
	}

	public Integer getId() {
		return id;
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
	public static User login(String username, String password)
		throws IncorrectPasswordException, NonExistingUserException {
		try {
			User u = Database.getUser(username);
			if (u.isPassword(password)) {
				return u;
			}
			throw new IncorrectPasswordException();
		} catch(NoResultException e) {
			throw new NonExistingUserException(e);
		}
	}
	
	public static User signup(String username, String password)
		throws ExistingUserException {
		try {
			User u = new User(username, password);
			Database.insert(u);
			return u;
		} catch (RollbackException e) {
			throw new ExistingUserException(e);
		}
	}
}
