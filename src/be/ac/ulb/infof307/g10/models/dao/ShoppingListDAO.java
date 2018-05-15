package be.ac.ulb.infof307.g10.models.dao;

import java.util.List;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.database.GenericDatabase;
import be.ac.ulb.infof307.g10.models.database.SaverObserver;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class ShoppingListDAO {

	public static ShoppingList createShoppingList(String name) {
		try {
			getShoppingList(name);
			throw new ExistingException();
		} catch (NonExistingException e) {
			ShoppingList sl = new ShoppingList(name);
			sl.addObserver(SaverObserver.getInstance());
			return sl;
		}
	}
	
	public static ShoppingList getShoppingList(String name) throws NonExistingException {
		try {
			return GenericDatabase.getOne(ShoppingList.class, "SELECT b FROM ShoppingList b WHERE b.name LIKE ?1", name);
		} catch (NoResultException e) {
			throw new NonExistingException(e);
		}
	}

	public static List<ShoppingList> getAllShoppingList() throws NonExistingException {
		return GenericDatabase.getAll(ShoppingList.class);
	}
}
