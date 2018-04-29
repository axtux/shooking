package be.ac.ulb.infof307.g10.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.RollbackException;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;

@Entity
public class Shop extends ModelObject {

	private static final long serialVersionUID = -0L;

	@Column(unique = true)
	private String name;
	private String[] schedule;
	private double latitude;
	private double longitude;

	@OneToOne(cascade = CascadeType.ALL)
	private Stock stock;

	@SuppressWarnings("unused") // NEEDED BY JPA
	private Shop() {}

	/**
	 * Create shop
	 * @param name Shop name
	 * @param schedule Weekly schedule. Length must be 7.
	 * @param latitude Position latitude
	 * @param longitude Position longitude
	 * @param stock Shop stock
	 */
	public Shop(String name, double latitude, double longitude, String [] schedule, Stock stock) {
		this.name = name;
		if (schedule.length != 7) {
			throw new IllegalArgumentException("schedule length must be 7");
		}
		this.schedule = schedule;
		this.latitude = latitude;
		this.longitude = longitude;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	/**
	 * Return the opening time, in String format, of the chosen day.
	 * @param day 0 for Monday, 1 for Tuesday, ..., and 6 for Sunday (0 <= day < 7)
	 * @return The opening time in String format, or an empty String
	 */
	public String getSchedule(int day) throws IndexOutOfBoundsException {
		return this.schedule[day];
	}

	public double getLatitude() {
		return this.latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public Stock getStock() {
		return stock;
	}
	
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	// static methods
	/**
	 * Create shop into database with default schedule and empty stock
	 * @param name Shop name
	 * @param schedule Weekly schedule. Length must be 7.
	 * @param latitude Position latitude
	 * @param longitude Position longitude
	 * @param stock Shop stock
	 * @return Created shop
	 */
	public static Shop create(String name, double latitude, double longitude) {
		return create(name, latitude, longitude, null);
	}
	/**
	 * Create shop into database with empty stock
	 * @param name Shop name
	 * @param schedule Weekly schedule. Length must be 7.
	 * @param latitude Position latitude
	 * @param longitude Position longitude
	 * @param stock Shop stock
	 * @return Created shop
	 */
	public static Shop create(String name, double latitude, double longitude, String [] schedule) {
		return create(name, latitude, longitude, schedule, new Stock());
	}
	/**
	 * Create shop into database
	 * @param name Shop name
	 * @param schedule Weekly schedule. Length must be 7.
	 * @param latitude Position latitude
	 * @param longitude Position longitude
	 * @param stock Shop stock
	 * @return Created shop
	 */
	public static Shop create(String name, double latitude, double longitude, String [] schedule, Stock stock) {
		if (schedule == null) {
			schedule = defaultSchedule();
		}
		try {
			Shop s = new Shop(name, latitude, longitude, schedule, stock);
			s.save();
			return s;
		} catch (RollbackException e) {
			throw new ExistingException(e);
		}
	}

	public static String[] defaultSchedule() {
		String[] s = new String[7];
		for(int i = 0; i < s.length; i++) {
			s[i] = "CLOSED";
		}
		return s;
	}

	/**
	 * Get shops that contains at least all products.
	 * @param products Products
	 * @return List of Shop
	 */
	public static List<Shop> getWithProducts(List<Product> products) {
		List<Shop> shops = new ArrayList<>();
		for(Shop s: Database.getAll(Shop.class)) {
			for(Product p: products) {
				if(s.getStock().getQuantity(p) > 0) {
					shops.add(s);
				}
			}
		}
		return shops;
	}

	/**
	 * Get shops that contains product.
	 * @param product Product
	 * @return List of Shop
	 */
	public static List<Shop> getWithProduct(Product product) {
		List<Shop> shops = new ArrayList<>();
		for(Shop s: Database.getAll(Shop.class)) {
			if(s.getStock().getQuantity(product) > 0) {
				shops.add(s);
			}
		}
		return shops;
	}
}
