package be.ac.ulb.infof307.g10.db;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.User;

import javax.persistence.NoResultException;

import java.util.List;

/**
 * Adding some queries to GenericDatabase to meet the need of our custom objects.
 * Abstract because contains only static methods.
 */
abstract public class Database extends GenericDatabase {

	public static void init(){
		setProp("name", "GL10PU");
		if (isEmpty()) {
			Data.fillDB();
		}
	}

	public static User getUser(String username) throws NoResultException {
		return getOne(User.class, "SELECT b from User b where b.username LIKE ?1", username);
	}

	public static Product getProduct(String name) {
		return getOne(Product.class, "SELECT b FROM Product b WHERE b.name LIKE ?1", name);
	}
	
	public static List<Product> getAllProducts() {
		return getAll(Product.class);
	}
	
	public static Shop getShop(String name) throws NoResultException{
		return getOne(Shop.class, "SELECT b FROM Shop b WHERE b.name LIKE ?1", name);
	}
	
	public static List<Shop> getAllShops() {
		return getAll(Shop.class);
	}
	
	public static Recipe getRecipe(String name) throws NoResultException {
		return getOne(Recipe.class, "SELECT b FROM Recipe b WHERE b.name LIKE ?1", name);
	}
	
	public static List<Recipe> getAllRecipes() {
		return getAll(Recipe.class);
	}
}
