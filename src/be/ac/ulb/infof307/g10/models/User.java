package be.ac.ulb.infof307.g10.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;

import be.ac.ulb.infof307.g10.models.exceptions.EmptyPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.EmptyUsernameException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.utils.Crypto;

/**
 * Manage user, password and shopping list. Use static methods to get instance.
 */
@Entity
public class User extends AbstractObject {

	private static final long serialVersionUID = -0L;

	@Column(unique = true)
	private String username;

	private String hashedPassword;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ShoppingList> shoppingLists;

	/**
	 * The salt added to the password so that two user with 2 same password have not the same hashed password
	 */
	private String salt;

	/**
	 * Needed by JPA
	 */
	protected User() {
	}

	public User(String username, String password) {
		if (username == null || username.trim().isEmpty()) {
			throw new EmptyUsernameException("username must not be empty");
		}
		this.username = username;
		setPassword(password);
		shoppingLists = new HashSet<ShoppingList>();
		changedWhenListsChanged();
	}

	/**
	 * Add an observer to all the shopping list to notify a change to the User
	 */
	@PostLoad
	private void changedWhenListsChanged() {
		for (ShoppingList shopList : getShoppingLists()) {
			changedWhenListChanged(shopList);
		}
	}

	/**
	 * Add an observer to a specific shopping list
	 * @param list the shopping list that has to be observed
	 */
	private void changedWhenListChanged(ShoppingList list) {
		User self = this;
		list.addObserver((observable, arg) -> self.changed());
	}

	public String getUsername() {
		return username;
	}

	private String hash(String password) {
		return Crypto.sha256(password + this.salt);
	}

	public void setPassword(String password) {
		if (password == null || password.trim().isEmpty()) {
			throw new EmptyPasswordException("password must not be empty");
		}
		this.salt = Crypto.generateSalt();
		this.hashedPassword = hash(password);
		this.changed();
	}

	/**
	 * Check password. Check is case sensitive.
	 * 
	 * @param password
	 *            Password to check
	 * @throws IncorrectPasswordException
	 *             If password does not match.
	 */
	public void checkPassword(String password) throws IncorrectPasswordException {
		if (!hash(password).equals(hashedPassword)) {
			throw new IncorrectPasswordException();
		}
	}

	public Set<ShoppingList> getShoppingLists() {
		return shoppingLists;
	}

	/**
	 * Add a shopping list
	 * 
	 * @param shoppingList
	 *            the shopping list to add
	 */
	public void addShoppingList(ShoppingList shoppingList) {
		shoppingLists.add(shoppingList);
		changedWhenListChanged(shoppingList);
		this.changed();
	}
}
