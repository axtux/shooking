package be.ac.ulb.infof307.g10.db;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Data {
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

	public static void fillDB() {
		List<Shop> shops = getShops();
		List<Product> products = getProducts();

		// insert products
		for (Product p : products) {
			p.save();
		}

		int i = 0;
		Stock st;
		// Database.setAutoCommit(false);
		for (Shop s : shops) {
			// low cost first
			st = new Stock();
			for (Product p : products) {
				st.addProduct(p, random(100), 10 * i + random(200, 300));
			}
			s.setStock(st);
			i++;
			s.save();
		}

		// insert recipes
		for (Recipe r : getRecipes()) {
			r.save();
		}

		// Database.setAutoCommit(true);
	}

	public static List<Shop> getShops() {
		List<Shop> list = ShopDAO.getAllShops();

		if (list.isEmpty()) {
			list.add(ShopDAO.createShop("Aldi", 50.828488, 4.362717));
			list.add(ShopDAO.createShop("Colruyt", 50.867831, 4.403058));
			list.add(ShopDAO.createShop("Carrefour", 50.859922, 4.342290));
			list.add(ShopDAO.createShop("Delhaize", 50.845075, 4.389325));
		}

		return list;
	}

	/**
	 * Return a List of Recipes to put it in the DB
	 * 
	 * @return List of Recipes
	 */
	public static List<Recipe> getRecipes() {
		ArrayList<Recipe> list = new ArrayList<>();

		list.add(new Recipe("Omelette au fromage", 1));
		list.add(new Recipe("Pancake tombé dans la neige avant le 31 Décembre", 1));

		return list;
	}

	public static List<Product> getProducts() {
		ArrayList<Product> list = new ArrayList<>();

		list.add(new Product("Pasta", 500, "g"));
		list.add(new Product("Rice", 500, "g"));
		list.add(new Product("Bread", 1, "unit"));
		list.add(new Product("Banana", 1, "unit"));
		list.add(new Product("Tomato", 1, "unit"));

		return list;
	}
}
