package be.ac.ulb.infof307.g10.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;

import be.ac.ulb.infof307.g10.db.DatabaseFacade;

public class GestionShop {

	public GestionShop(){
		
	}
	
	/**
	 * Return the Shop with the name "name" from the DB.
	 * Return null if the Shop doesn't exist.
	 * 
	 * @param	String	The name of the Shop
	 * @return			A Shop from the DB, or null
	 */
	public Shop getShop(String name) {
		Shop shop;
		try {
			shop = DatabaseFacade.getShop(name);
		} catch (NoResultException e) {
			shop = null;
		}
		return shop;
	}
	
	
	/**
	 * Return a list of all shop in the DB.
	 * The list is empty if there are no shop in the DB.
	 * 
	 * @return		A List of Shop
	 */
	public List<Shop> getShops() {
		List<Shop> shops;
		try {
			shops = DatabaseFacade.getShops();
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
	 * @return			A new Shop or null
	 */
	public Shop createShop(String name, Map<Product, Integer> stock){
		Shop shop;
		try {
			if (stock == null){
				shop = new Shop(name);
			}
			else {
				shop = new Shop(name, stock);
			}
			DatabaseFacade.insert(shop);
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
	 * @param name	The name of the Shop
	 * @return		A new Shop or null
	 */
	public Shop createShop(String name){
		return createShop(name, null);
	}
	
	
	/**
	 * Modify the Shop name and save it in the DB
	 * 
	 * @param shop		The shop to modify
	 * @param newName	The new Shop name in String format
	 */
	public void modifyShopName(Shop shop, String newName){
		shop.setName(newName);
		DatabaseFacade.update(shop);
	}
	
	
	/**
	 * Add a new product with quantity,
	 * or modify the quantity of a product if this product is already in the stock.
	 * 
	 * @param shop		The shop to modify
	 * @param product	The new product to add
	 * @param quantity	The quantity of the product in Integer format
	 */
	public void modifyShopStock(Shop shop, Product product, Integer quantity){
		shop.addProduct(product, quantity);
		DatabaseFacade.update(shop);
	}

	
	/**
	 * Add a new product with quantity,
	 * or modify the quantity of a product if this product is already in the stock.
	 * If the product doesn't exist, the Shop is not modify.
	 * 
	 * @param shop			The shop to modify
	 * @param product		The new product to add in String format
	 * @param description	The description of the product in String format
	 * @param quantity		The quantity of the product in Integer format
	 */
	public void modifyShopStock(Shop shop, String productName, String description, Integer quantity){
		try {
			Product product = DatabaseFacade.getProduct(productName, description);
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
	public void modifyShopSetStock(Shop shop, Map<Product, Integer> newStock) {
		shop.setStock(newStock);
		DatabaseFacade.update(shop);
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
	public void modifyShopSchedule(Shop shop, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday){
		shop.setSchedule(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
		DatabaseFacade.update(shop);
	}
	
	
	/**
	 * Modify the Shop position on the map.
	 * Save it in the DB.
	 * 
	 * @param shop		The shop to modify
	 * @param latitude	The new latitude in float format
	 * @param longitude	The new longitude in float format
	 */
	public void modifyShopPosition(Shop shop, float latitude, float longitude) {
		shop.setPosition(latitude, longitude);
		DatabaseFacade.update(shop);
	}
	
	
	/**
	 * Delete a Shop from DB.
	 * 
	 * @param	name	The Shop name in String format
	 */
	public void delShop(String name) {
		Shop shop = getShop(name);
		delShop(shop);
	}
	
	
	/**
	 * Delete a Shop from DB.
	 * 
	 * @param shop	The Shop object
	 */
	public void delShop(Shop shop) {
		try {
			DatabaseFacade.delete(shop);
		} catch (NoResultException e) {} //Nothing to do
		
	}
	

}
