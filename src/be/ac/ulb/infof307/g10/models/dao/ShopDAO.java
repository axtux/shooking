package be.ac.ulb.infof307.g10.models.dao;

import java.util.List;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.database.GenericDatabase;
import be.ac.ulb.infof307.g10.models.database.SaverObserver;
import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class ShopDAO {

	
	/**
	 * Create shop into database with default schedule and empty stock
	 * 
	 * @param name
	 *            Shop name
	 * @param latitude
	 *            Position latitude
	 * @param longitude
	 *            Position longitude
	 * @return Created shop
	 */
	public static Shop createShop(String name, double latitude, double longitude) {
		return createShop(name, latitude, longitude, null);
	}

	/**
	 * Create shop into database
	 * 
	 * @param name
	 *            Shop name
	 * @param latitude
	 *            Position latitude
	 * @param longitude
	 *            Position longitude
	 * @param schedule
	 *            Weekly schedule. Length must be 7. 0 for Monday, 1 for Tuesday, ..., and 6 for Sunday
	 * @return Created shop
	 */
	public static Shop createShop(String name, double latitude, double longitude, String[] schedule) throws ExistingException{
		try {
			Shop s = new Shop(name, latitude, longitude, schedule);
			s.addObserver(SaverObserver.getInstance());
			return s;
		} catch (DatabaseException e) {
			throw new ExistingException(e);
		}
	}

	public static Shop getShop(String name) throws NonExistingException {
		try{
			return GenericDatabase.getOne(Shop.class, "SELECT b FROM Shop b WHERE b.name LIKE ?1", name);
		} catch (NoResultException e) {
			throw new NonExistingException(e);
		}
	}

	public static List<Shop> getAllShops() throws NonExistingException {
		return GenericDatabase.getAll(Shop.class);
	}
	
}
