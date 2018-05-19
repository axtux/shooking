package be.ac.ulb.infof307.g10.models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Class representing a shop. It is defined by a name, a stock, a schedule, a
 * latitude and a longitude. His primary keys in the db are the name, the
 * longitude and the latitude. It defines when a shop is unique.
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "longitude", "latitude" }) })
public class Shop extends AbstractObject {

	private static final long serialVersionUID = -0L;

	private String name;
	private double latitude;
	private double longitude;
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<DayOfWeek, String> schedule;

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
	 *            Weekly schedule.
	 */
	public Shop(String name, double latitude, double longitude, Map<DayOfWeek, String> schedule) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("name must not be empty");
		}
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		setSchedule(schedule);
		this.stock = new Stock();
		changedWhenStockChanged();
	}

	@PostLoad
	private void changedWhenStockChanged() {
		Shop self = this;
		this.stock.addObserver((observable, arg) -> self.changed());
	}

	public String getName() {
		return name;
	}

	private void setSchedule(Map<DayOfWeek, String> schedule) {
		if (schedule == null) {
			this.schedule = new HashMap<>();
			return;
		}
		this.schedule = new HashMap<>(schedule);
		// remove eventual empty days
		for (DayOfWeek day : DayOfWeek.values()) {
			if (this.schedule.containsKey(day) && this.schedule.get(day).trim().isEmpty()) {
				this.schedule.remove(day);
			}
		}
	}

	/**
	 * Return the opening time, in String format, of the chosen day.
	 * 
	 * @param day
	 *            Day of which to get schedule.
	 * @return The opening time in String format, or an empty String
	 */
	public String getSchedule(DayOfWeek day) {
		return schedule.getOrDefault(day, "Unknown");
	}

	/**
	 * Get whole schedule as string.
	 * 
	 * @return Format is "Day1: scheduleOfDay\nDay2: ..."
	 */
	public String getWholeSchedule() {
		StringBuilder ret = new StringBuilder();

		for (DayOfWeek day : DayOfWeek.values()) {
			ret.append(day.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
			ret.append(": ");
			ret.append(getSchedule(day));
			ret.append("\n");
		}

		return ret.toString();
	}

	/**
	 * Get shop information.
	 * 
	 * @return Format is "Name\n\nWholeSchedule"
	 */
	public String getInfo() {
		return getName() + "\n\n" + getWholeSchedule();
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
}
