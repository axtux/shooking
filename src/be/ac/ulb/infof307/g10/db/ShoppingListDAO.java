package be.ac.ulb.infof307.g10.db;

import java.util.List;
import java.util.Observable;

import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.ShoppingList;

public class ShoppingListDAO extends AbstractDAO {

	public static ShoppingList createShoppingList(String name) {
		ShoppingList sl = new ShoppingList(name);
		sl.addObserver(SaverObserver.getInstance());
		return sl;
	}
	
	public static ShoppingList getShoppingList(String name) {
		return GenericDatabase.getOne(ShoppingList.class, "SELECT b FROM ShoppingList b WHERE b.name LIKE ?1", name);
	}

	public static List<ShoppingList> getAllShoppingList() {
		return GenericDatabase.getAll(ShoppingList.class);
	}
}
