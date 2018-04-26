package be.ac.ulb.infof307.g10.db;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.User;

import javax.persistence.NoResultException;

import java.util.List;

/**
 * Adding some queries to GenericDatabase to meet the need of our custom objects.
 */
public class Database extends GenericDatabase {

	public static void init(){
		if (isEmpty()) {
			Data.fillDB();
		}
	}

	public static User getUser(String username) throws NoResultException {
		return getOne(User.class, "SELECT b from User b where b.username LIKE ?1", username);
	}
	
	public static User getListOwner(Long list_id) throws NoResultException{
		return getOne(User.class, "SELECT b from User b where b.list_id LIKE ?1", list_id);
	}
	
	public static Product getProductFromNameAndDesc(String name, String description) throws NoResultException{
		return getOne(Product.class, "SELECT b FROM Product b WHERE b.name LIKE ?1 AND b.description LIKE ?2",
				name, description);
	}
	
	public static List<Product> getProducts(String name) {
		return getAll(Product.class, "SELECT b FROM Product b WHERE b.name LIKE ?1", name);
	}
	
	public static List<Product> getAllProducts() {
		return getAll(Product.class);
	}
	
	public static Shop getShop(String name) throws NoResultException{
		return getOne(Shop.class, "SELECT b FROM Shop b WHERE b.name LIKE ?1", name);
	}
	
	public static List<Shop> getAllShops() {
		return getAll(Shop.class, "SELECT s FROM Shop s");
	}
	
	public static Recipe getRecipe(String name) throws NoResultException {
		return getOne(Recipe.class, "SELECT b FROM Recipe b WHERE b.name LIKE ?1", name);
	}
	
	public static List<Recipe> getAllRecipes() {
		return getAll(Recipe.class, "SELECT b FROM Recipe b");
	}
	
	public static void deleteList(ShoppingList l) throws NoResultException{
		Database.getListOwner(l.getId()).setShoppingList(null);
		delete(l);
	}
}
