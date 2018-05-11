package be.ac.ulb.infof307.g10.db;

import java.util.Observable;

import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.Stock;
import be.ac.ulb.infof307.g10.models.exceptions.DatabaseException;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;

public class ShopDAO extends AbstractDAO {

	
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
	public static Shop create(String name, double latitude, double longitude) {
		return create(name, latitude, longitude, null);
	}

	/**
	 * Create shop into database with empty stock
	 * 
	 * @param name
	 *            Shop name
	 * @param latitude
	 *            Position latitude
	 * @param longitude
	 *            Position longitude
	 * @param schedule
	 *            Weekly schedule. Length must be 7. 0 for Monday, 1 for
	 *            Tuesday, ..., and 6 for Sunday
	 * @return Created shop
	 */
	public static Shop create(String name, double latitude, double longitude, String[] schedule) {
		return create(name, latitude, longitude, schedule, new Stock());
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
	 *            Weekly schedule. Length must be 7.
	 * @param stock
	 *            Shop stock 0 for Monday, 1 for Tuesday, ..., and 6 for Sunday
	 * @return Created shop
	 */
	public static Shop create(String name, double latitude, double longitude, String[] schedule, Stock stock) {
		String[] safeSchedule = schedule;
		if (safeSchedule == null) {
			safeSchedule = defaultSchedule();
		}
		try {
			Shop s = new Shop(name, latitude, longitude, safeSchedule, stock);
			s.save();
			return s;
		} catch (DatabaseException e) {
			throw new ExistingException(e);
		}
	}

	/**
	 * Save the object when observed object has changed
	 * @param obj	The observed object
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
