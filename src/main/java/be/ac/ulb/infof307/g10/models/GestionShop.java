package be.ac.ulb.infof307.g10.models;

import java.util.HashMap;
import java.util.Map;

import be.ac.ulb.infof307.g10.db.DatabaseFacade;

public class GestionShop {

	public GestionShop(){
		
	}
	
	/**
	 * Modify an existing Shop
	 * 
	 * @param	shop		The Shop to modify
	 * @param	newName		The new name of the shop. If the name dont change, put "null"
	 * @param	newProduct	Ah list (HasMap) of new product to add in the shop stock
	 * @param	setStock	If is True, the newProduct list replace the entire stock of the Shop
	 */
	public void modifyShop(Shop shop, String newName, Map<Product, Integer> newProduct, boolean setStock){
		if (newName != null) {
			shop.setName(newName);
		}
		if (newProduct != null) {
			if (setStock) {
				shop.setStock(newProduct);
			}
			else {
				for (Map.Entry<Product, Integer> entry : newProduct.entrySet()){
					shop.addProduct(entry.getKey(), entry.getValue());
				}
			}
		}
		DatabaseFacade.update(shop);
	}
	
	public void modifyShop(Shop shop, String newName, Map<Product, Integer> newProduct) {
		modifyShop(shop, newName, newProduct, false);
	}
	
	/**
	 * Create a new Shop and put it in the DB
	 * 
	 * @param	name	The name of the Shop
	 * @param	stock	The stock of the Shop. if the stock was empty, put null or nothing
	 * @return			A new Shop
	 */
	public Shop createShop(String name, Map<Product, Integer> stock){
		Shop shop;
		if (stock == null){
			shop = new Shop(name);
		}
		else {
			shop = new Shop(name, stock);
		}
		DatabaseFacade.insert(shop);
		return shop;
	}
	
	public Shop createShop(String name){
		return createShop(name, null);
	}
	
	/**
	 * Delete a Shop from DB
	 * 
	 * @param	name	The Shop name in String format
	 */
	public void delShop(String name){
		Shop shop = getShop(name);
		delShop(shop);
	}
	
	/**
	 * Delete a Shop from DB
	 * 
	 * @param shop	The Shop object
	 */
	public void delShop(Shop shop) {
		DatabaseFacade.delete(shop);
	}
	
	/**
	 * Return the Shop with the name "name" from the DB
	 * 
	 * @param	String	The name of the Shop
	 * @return			A Shop from the DB
	 */
	public Shop getShop(String name){
		return new Shop(name);
	}
}
