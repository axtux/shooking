package be.ac.ulb.infof307.g10.models;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingUserException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingUserException;
import be.ac.ulb.infof307.g10.utils.Hash;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

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

	@OneToOne(cascade = CascadeType.PERSIST)
	private ShoppingList shoppingList;

	// NEEDED BY JPA
	@SuppressWarnings("unused")
	private User() {}

	public User(String username, String password) {
		this(username, password, null);
	}

	public User(String username, String password, ShoppingList shoppingList) {
		this.username = username;
		setPassword(password);
		setShoppingList(shoppingList);
	}

	/**
	 * Create a full copy of user (ShoppingList is also copied)
	 * @param user User to copy
	 */
	public User(User user) {
		this.id = user.id;
		this.username = user.username;
		this.hashedPassword = user.hashedPassword;
		setShoppingList(user.shoppingList);
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username=" + username + ", hashedPassword=" + hashedPassword + ", userList="
				+ shoppingList + '}';
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
		return new ShoppingList(shoppingList);
	}

	public void setShoppingList(ShoppingList shoppingList) {
		if (shoppingList == null) {
			this.shoppingList = new ShoppingList();
		} else {
			this.shoppingList = new ShoppingList(shoppingList);
		}
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
