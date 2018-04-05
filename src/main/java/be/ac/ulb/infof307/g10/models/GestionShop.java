package be.ac.ulb.infof307.g10.models;

import java.util.HashMap;
import java.util.Map;

public class GestionShop {

	public GestionShop(){
		
	}
	
	/**
	 * Modify an existing Shop
	 * 
	 * @param	shop	The Shop to modify
	 */
	public void modifyShop(Shop shop, String newName, Map<Product, Integer> newProduct){
		
	}
	
	/**
	 * Create a new Shop and put it in the DB
	 * 
	 * @return		A new Shop
	 */
	public Shop createShop(String name, Map<Product, Integer> stock){
		
		return new Shop(name, stock);
	}
	
	public Shop createShop(String name){
		return new Shop(name);
	}
	
	/**
	 * Delete a Shop from DB
	 */
	public void delShop(String name){
		
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
