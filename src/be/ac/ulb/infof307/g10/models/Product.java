package be.ac.ulb.infof307.g10.models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Class representing a product. It is defined by a name (string), a size
 * (positive integer) and a unit (string) related to the size.
 */
@Entity
public class Product extends AbstractObject {

	private static final long serialVersionUID = -0L;

	@Column(unique = true)
	private String name;
	private int size;
	private String sizeUnit;

	/**
	 * Needed by JPA
	 */
	protected Product() {
	}

	public Product(String name, int size, String sizeUnit) {

		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("name must not be empty");
		}
		if (size <= 0) {
			throw new IllegalArgumentException("size must be > 0");
		}
		if (sizeUnit == null || sizeUnit.trim().isEmpty()) {
			throw new IllegalArgumentException("size unit must not be empty");
		}

		this.name = name;
		this.size = size;
		this.sizeUnit = sizeUnit;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public String getSizeUnit() {
		return sizeUnit;
	}

	public String getStringSize() {
		return size + sizeUnit;
	}

	public String getFullName() {
		return name + " (" + getStringSize() + ")";
	}

	public String getIngredientName() {
		return name + " (" + sizeUnit + ")";
	}

}
