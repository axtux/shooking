package be.ac.ulb.infof307.g10.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

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

	@OneToOne(cascade = CascadeType.ALL)
	private ShoppingList shoppingList;

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
		shoppingList = new ShoppingList();
		User self = this;
		shoppingList.addObserver((observable, arg) -> self.changed());
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
	 * @param password Password to check
	 * @throws IncorrectPasswordException If password does not match.
	 */
	public void checkPassword(String password) throws IncorrectPasswordException {
		if(!hash(password).equals(hashedPassword)) {
			throw new IncorrectPasswordException();
		}
	}

	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	//FIXME - for the moment, this mothods replace the actual ShoppingList,
	//FIXME - but must add it when the multi list will be supported
	public void addShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
		this.changed();
	}
}
