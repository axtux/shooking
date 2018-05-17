package be.ac.ulb.infof307.g10.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import be.ac.ulb.infof307.g10.utils.Crypto;

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

	private String salt;

	/**
	 * Needed by JPA
	 */
	protected User() {
	}

	public User(String username, String password) {
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
		this.salt = Crypto.generateSalt();
		this.hashedPassword = Crypto.sha256(password + this.salt);
		this.changed();
	}

	public boolean isPassword(String password) {
		return Crypto.sha256(password  + this.salt ).equals(hashedPassword);
	}

	public ShoppingList getShoppingList() {
		return shoppingList;
	}
}
