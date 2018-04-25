package be.ac.ulb.infof307.g10.models;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;

import be.ac.ulb.infof307.g10.db.Database;

public class ShopManagement {

	public ShopManagement(){
		
	}
	
	/**
	 * Return the Shop with the name "name" from the DB.
	 * Return null if the Shop doesn't exist.
	 * 
	 * @param name		The name of the Shop
	 * @return			A Shop from the DB, or null
	 */
	public static Shop getShop(String name) {
		Shop shop;
		try {
			shop = Database.getShop(name);
		} catch (NoResultException e) {
			shop = null;
		}
		return shop;
	}
	
	
	/**
	 * Return a list of all shop in the DB
	 * The list is empty if there are no shop in the DB.
	 * 
	 * @return		A ShoppingList of Shop
	 */
	public static List<Shop> getShops() {
		List<Shop> shops;
		try {
			shops = Database.getAllShops();
		} catch (NoResultException e) {
			shops = new ArrayList<>();
		}
		return shops;
	}
	
	
	/**
	 * Create a new Shop and put it in the DB.
	 * If the Shop is already exist, return null.
	 * 
	 * @param	name	The name of the Shop
	 * @param	stock	The stock of the Shop. if the stock was empty, put null or nothing
	 * @param latitude	Shop coordinates latitude
	 * @param longitude	Shop coordinates longitude
	 * @return			A new Shop or null
	 */
	public static Shop createShop(String name, Map<Product, Integer> stock, double latitude, double longitude){
		Shop shop;
		try {
			if (stock == null){
				shop = new Shop(name, latitude, longitude);
			}
			else {
				shop = new Shop(name, stock, latitude, longitude);
			}
			Database.insert(shop);
		} catch (NoResultException e) {
			shop = null;
		} catch (RollbackException r) {
			shop = null;
		}
		return shop;
	}
	
	
	/**
	 * Create a new Shop and put it in the DB.
	 * If the Shop is already exist, return null.
	 * 
	 * @param name		The name of the Shop
	 * @param latitude	Shop coordinates latitude
	 * @param longitude	Shop coordinates longitude
	 * @return			A new Shop or null
	 */
	public static Shop createShop(String name, double latitude, double longitude){
		return createShop(name, null, latitude, longitude);
	}
	
	
	/**
	 * Modify the Shop name and save it in the DB
	 * 
	 * @param shop		The shop to modify
	 * @param newName	The new Shop name in String format
	 */
	public static void modifyShopName(Shop shop, String newName){
		shop.setName(newName);
		Database.update(shop);
	}
	
	
	/**
	 * Add a new product with quantity,
	 * or modify the quantity of a product if this product is already in the stock.
	 * 
	 * @param shop		The shop to modify
	 * @param product	The new product to add
	 * @param quantity	The quantity of the product in Integer format
	 */
	public static void modifyShopStock(Shop shop, Product product, Integer quantity){
		shop.addProduct(product, quantity);
		Database.update(shop);
	}

	
	/**
	 * Add a new product with quantity,
	 * or modify the quantity of a product if this product is already in the stock.
	 * If the product doesn't exist, the Shop is not modify.
	 * 
	 * @param shop			The shop to modify
	 * @param productName		The new product to add in String format
	 * @param description	The description of the product in String format
	 * @param quantity		The quantity of the product in Integer format
	 */
	public static void modifyShopStock(Shop shop, String productName, String description, Integer quantity){
		try {
			Product product = Database.getProductFromNameAndDesc(productName, description);
			modifyShopStock(shop, product, quantity);
		} catch (NoResultException e) {} // Nothing to do
	}
	
	
	/**
	 * Reload a new stock for the Shop.
	 * Save it in the DB.
	 * 
	 * @param shop		The shop to modify
	 * @param newStock	The new stock to load
	 */
	public static void modifyShopSetStock(Shop shop, Map<Product, Integer> newStock) {
		shop.setStock(newStock);
		Database.update(shop);
	}
	
	
	/**
	 * Modify the opening time of the Shop.
	 * Save it in the DB.
	 * 
	 * @param shop		The shop to modify
	 * @param monday	The schedule for Monday
	 * @param tuesday	The schedule for Tuesday
	 * @param wednesday	The schedule for Wednesday
	 * @param thursday	The schedule for Thursday
	 * @param friday	The schedule for Friday
	 * @param saturday	The schedule for Saturday
	 * @param sunday	The schedule for Sunday
	 */
	public static void modifyShopSchedule(Shop shop, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday){
		shop.setSchedule(0, monday);
		shop.setSchedule(1, tuesday);
		shop.setSchedule(2, wednesday);
		shop.setSchedule(3, thursday);
		shop.setSchedule(4, friday);
		shop.setSchedule(5, saturday);
		shop.setSchedule(6, sunday);
		Database.update(shop);
	}
	
	
	/**
	 * Modify the Shop position on the map.
	 * Save it in the DB.
	 * 
	 * @param shop		The shop to modify
	 * @param latitude	The new latitude in float format
	 * @param longitude	The new longitude in float format
	 */
	public static void modifyShopPosition(Shop shop, double latitude, double longitude) {
		shop.setPosition(latitude, longitude);
		Database.update(shop);
	}
	
	
	/**
	 * Delete a Shop from DB.
	 * 
	 * @param	name	The Shop name in String format
	 */
	public static void delShop(String name) {
		Shop shop = getShop(name);
		delShop(shop);
	}
	
	
	/**
	 * Delete a Shop from DB.
	 * 
	 * @param shop	The Shop object
	 */
	public static void delShop(Shop shop) {
		try {
			Database.delete(shop);
		} catch (NoResultException e) {} //Nothing to do
		
	}
	

}
