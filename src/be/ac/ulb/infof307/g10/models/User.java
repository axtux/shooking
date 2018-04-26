package be.ac.ulb.infof307.g10.models;

import be.ac.ulb.infof307.g10.db.Database;
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

	@OneToOne
	private ShoppingList shoppingList;

	// NEEDED BY JPA
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

	public ShoppingList getShoppingList() {
		return new ShoppingList(shoppingList);
	}

	public void setShoppingList(ShoppingList shoppingList) {
		if (shoppingList == null) {
			this.shoppingList = null;
		} else {
			this.shoppingList = new ShoppingList(shoppingList);
		}
	}
}
