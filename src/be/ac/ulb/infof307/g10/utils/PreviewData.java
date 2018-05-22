package be.ac.ulb.infof307.g10.utils;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.database.Database;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

final public class PreviewData {

	/**
	 * Avoid object creation
	 */
	private PreviewData() {
	}
	/**
	 * Random integer
	 * 
	 * @param max
	 *            Max value (excluded)
	 * @return Random integer
	 */
	public static int random(int max) {
		return random(0, max);
	}

	/**
	 * Random integer
	 * 
	 * @param max
	 *            Max value (excluded)
	 * @param min
	 *            Min value (included)
	 * @return Random integer
	 */
	public static int random(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}

	public static void main(final String[] args) {
		setPreviewData();
		// exit correctly, required for Maven
		Platform.exit();
		System.exit(0);
	}

	public synchronized static void setPreviewData() {
		Database.setProp("name", "GL10PU");
		Database.empty();

		for (Shop s : getShops()) {
			// save products before
			Database.save(s.getStock().getProducts());
			Database.save(s);
		}

		// save recipes
		Database.save(getRecipes());
		Database.save(getUser());
	}

	public static List<Shop> getShops() {
		List<Shop> list = new ArrayList<>();
		List<Product> products = getProducts();

		list.add(new Shop("Aldi", 50.828488, 4.362717));
		list.add(new Shop("Colruyt", 50.867831, 4.403058));
		list.add(new Shop("Carrefour", 50.859922, 4.342290));
		list.add(new Shop("Delhaize", 50.845075, 4.389325));

		int i = 0;
		for (Shop s : list) {
			for (Product p : products) {
				// random stock, random price depending on i (low cost first)
				s.getStock().setProduct(p, random(100), 10 * i + random(200, 300));
			}
			i++;
		}

		return list;
	}

	/**
	 * Return a List of Recipes to put it in the DB
	 * 
	 * @return List of Recipes
	 */
	public static List<Recipe> getRecipes() {
		List<Recipe> list = new ArrayList<>();

		list.add(new Recipe("Omelette au fromage", 3));
		list.add(new Recipe("Pancake tombé dans la neige avant le 31 Décembre", 4));

		return list;
	}

	public static List<Product> getProducts() {
		List<Product> list = new ArrayList<>();

		list.add(new Product("Pasta", 500, "g"));
		list.add(new Product("Rice", 500, "g"));
		list.add(new Product("Bread", 1, "unit"));
		list.add(new Product("Banana", 1, "unit"));
		list.add(new Product("Tomato", 1, "unit"));

		return list;
	}

	public static User getUser() {
		User user = new User("test", "test");
	
		user.addShoppingList(new ShoppingList("Week"));
		user.addShoppingList(new ShoppingList("Weekend"));

		return user;
	}
}
