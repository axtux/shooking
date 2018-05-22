package be.ac.ulb.infof307.g10.models.dao;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.database.AutoSaver;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

/**
 * Data access object for {@link Shop}
 */
public class ShopDAO {

	/**
	 * Avoid object creation
	 */
	private ShopDAO() {
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
	 *            Schedule. May not contain all days. May be null.
	 * @return Created shop
	 */
	public static Shop create(String name, double latitude, double longitude, Map<DayOfWeek, String> schedule) throws ExistingException{
		try {
			Shop s = new Shop(name, latitude, longitude, schedule);
			AutoSaver.autosave(s);
			return s;
		} catch (DatabaseException e) {
			// TODO extrapolation, should check if duplicate shop exists
			throw new ExistingException("A shop with same coordinates already exists");
		}
	}

	/**
	 * Research a shop with a certain name inside the database.
	 * @param name the name of the shop
	 * @return The shop if a shop with that name does exist. A NoResultException if not
	 */
	public static Shop getByName(String name) throws NonExistingException {
		try{
			Shop shop = Database.getOne(Shop.class, "SELECT b FROM Shop b WHERE b.name LIKE ?1", name);
			AutoSaver.autosave(shop);
			return shop;
		} catch (NoResultException e) {
			throw new NonExistingException(e);
		}
	}

	/**
	 * Return all the existing shops
	 * @return a list containing all the existing shops
	 */
	public static List<Shop> getAll() throws NonExistingException {
		List<Shop> shops = Database.getAll(Shop.class);
		AutoSaver.autosave(shops);
		return shops;
	}
	
}
