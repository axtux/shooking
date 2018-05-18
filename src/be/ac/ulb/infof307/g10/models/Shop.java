package be.ac.ulb.infof307.g10.models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Class representing a shop. It is defined by a name, a stock, a schedule, a
 * latitude and a longitude. His primary keys in the db are the name, the
 * longitude and the latitude. It defines when a shop is unique.
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "longitude", "latitude" }) })
public class Shop extends AbstractModelObject {

	private static final long serialVersionUID = -0L;

	private String name;
	private double latitude;
	private double longitude;
	private String[] schedule;

	@OneToOne(cascade = CascadeType.ALL)
	private Stock stock;

	/**
	 * Needed by JPA
	 */
	protected Shop() {
	}

	/**
	 * Create shop with default schedule and empty stock.
	 * 
	 * @param name
	 *            Shop name
	 * @param latitude
	 *            Position latitude
	 * @param longitude
	 *            Position longitude
	 */
	public Shop(String name, double latitude, double longitude) {
		this(name, latitude, longitude, null);
	}

	/**
	 * Create shop with empty stock.
	 * 
	 * @param name
	 *            Shop name
	 * @param latitude
	 *            Position latitude
	 * @param longitude
	 *            Position longitude
	 * @param schedule
	 *            Weekly schedule. Length must be 7. If null, default schedule is used.
	 */
	public Shop(String name, double latitude, double longitude, String[] schedule) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("name must not be empty");
		}
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;

		if (schedule == null) {
			schedule = defaultSchedule();
		} else if (schedule.length != 7) {
			throw new IllegalArgumentException("schedule length must be 7");
		}
		this.schedule = schedule.clone();
		this.stock = new Stock();
	}

	public String getName() {
		return name;
	}

	/**
	 * Return the opening time, in String format, of the chosen day.
	 * 
	 * @param day
	 *            0 for Monday, 1 for Tuesday, ..., and 6 for Sunday
	 * @return The opening time in String format, or an empty String
	 */
	public String getSchedule(int day) throws IndexOutOfBoundsException {
		return this.schedule[day];
	}

	/**
	 * Get shop information
	 * 
	 * @return Name and schedule, in String format for all days
	 */
	public String getInfo() {
		StringBuilder ret = new StringBuilder(getName()).append("\n\n");
		int day = 1;

		for (String s : this.schedule) {
			ret.append(DayOfWeek.of(day).getDisplayName(TextStyle.FULL, Locale.ENGLISH)).append(": ").append(s).append("\n");
			day++;
		}
		return ret.toString();
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

	/**
	 * Default schedule is a String array containing 7 Strings "Unknown".
	 * @return Default schedule.
	 */
	public static String[] defaultSchedule() {
		String[] s = new String[7];
		for (int i = 0; i < s.length; i++) {
			s[i] = "Unknown";
		}
		return s;
	}
}
