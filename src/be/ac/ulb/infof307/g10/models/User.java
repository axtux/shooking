package be.ac.ulb.infof307.g10.models;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
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
	private ArrayList<ShoppingList> shoppingLists;

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
		shoppingLists = new ArrayList<ShoppingList>();
		User self = this;
		for(ShoppingList list:shoppingLists){
			list.addObserver((observable, arg) -> self.changed());
		}
		
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

	/**
	 * Check password. Check is case sensitive.
	 * @param password Password to check
	 * @throws IncorrectPasswordException If password does not match.
	 */
	public void checkPassword(String password) throws IncorrectPasswordException {
		if(Crypto.sha256(password + this.salt).equals(hashedPassword)) {
			return;
		}
		throw new IncorrectPasswordException();
	}

	public ArrayList<ShoppingList> getShoppingLists() {
		return shoppingLists;
	}

	//FIXME - for the moment, this mothods replace the actual ShoppingList,
	//FIXME - but must add it when the multi list will be supported
	public void addShoppingList(ShoppingList shoppingList) {
		shoppingList.addObserver((observable, arg) -> this.changed());
		shoppingLists.add(shoppingList);
		this.changed();
	}
}
