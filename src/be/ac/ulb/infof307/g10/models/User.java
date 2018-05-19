package be.ac.ulb.infof307.g10.models;

import java.util.ArrayList;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;


import javax.persistence.*;

import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.utils.Crypto;

/**
 * Manage user, password and shopping list. Use static methods to get instance.
 */
@Entity
public class User extends AbstractObject implements Observer{

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
		changedWhenListsChanged();
	}
	@Override
	public void update(Observable o, Object o1){
		this.changed();
		System.out.println("User saved");
	}

	@PostLoad
	private void changedWhenListsChanged() {
		User self = this;
		for(ShoppingList shopList: this.getShoppingLists()){
			shopList.addObserver((observable, arg) -> self.changed());
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

	/**
	 * Add a shopping list
	 * @param shoppingList the shopping list to add
	 */
	public void addShoppingList(ShoppingList shoppingList) {
		shoppingList.addObserver((observable, arg) -> this.changed());
		shoppingList.addObserver(this);
		shoppingLists.add(shoppingList);
		this.changed();
	}
}
