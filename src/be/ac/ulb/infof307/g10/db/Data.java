package be.ac.ulb.infof307.g10.db;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Data {
	public static void fillDB() {
		List<Shop> shops = getShops();
		List<Product> products = getProducts();

		// insert products
		for(Product p: products) {
			System.out.println("inserting "+p);
			Database.insert(p);
			System.out.println("inserted "+p);
		}

		int i = 0;
		Stock st;
		//Database.setAutoCommit(false);
		for(Shop s: shops) {
			// low cost first
			st = new Stock();
			for(Product p: products) {
				st.addProduct(p, ThreadLocalRandom.current().nextInt(100), 10*i + p.getPrice());
			}
			s.setStock(st);
			i++;
			Database.insert(s);
		}

		// insert recipes
		for(Recipe r: getRecipes()) {
			Database.insert(r);
		}

		//Database.setAutoCommit(true);
	}
	
	public static List<Shop> getShops() {
		ArrayList<Shop> list = new ArrayList<>();

		// TODO rename method ?
		list.add(Shop.create("Aldi", 0.0, 0.0));
		list.add(Shop.create("Colruyt", 0.0, 0.0));
		list.add(Shop.create("Carrefour", 0.0, 0.0));
		list.add(Shop.create("Delhaize", 0.0, 0.0));
		
		return list;
	}
	
	/**
	 * Return a List of Recipes to put it in the DB
	 * @return	List of Recipes
	 */
	public static List<Recipe> getRecipes() {
		ArrayList<Recipe> list = new ArrayList<>();
		
		list.add(new Recipe("Omelette au fromage", 1));
		list.add(new Recipe("Pancake tombé dans la neige avant le 31 Décembre", 1));
		
		return list;
	}
	
	public static List<Product> getProducts() {
		ArrayList<Product> list = new ArrayList<>();

		list.add(new Product("Bread", "", 100, 200));
		list.add(new Product("Banana", "", 1, 20));
		list.add(new Product("Tomato", "", 1, 30));

		return list;
	}
}
