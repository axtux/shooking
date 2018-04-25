package be.ac.ulb.infof307.g10.models;

import be.ac.ulb.infof307.g10.db.DatabaseFacade;
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
	private String password;

	@OneToOne
    private ShoppingList shoppingList;

	//NEEDED BY JPA
	public User(){
	}

    public User(String username, String password, ShoppingList userShoppingList) {
        this.username = username;
        this.password = Hash.sha256(password);
        this.shoppingList = userShoppingList;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = Hash.sha256(password);
    }


    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.shoppingList = user.shoppingList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userList=" + shoppingList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
        DatabaseFacade.update(this);
    }
}

