package be.ac.ulb.infof307.g10.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Product extends ModelObject {

	private static final long serialVersionUID = -0L;

	@Column(unique = true)
	private String name;
	private int size;
	private String sizeUnit;

	@SuppressWarnings("unused") // NEEDED BY JPA
	private Product() {}

	public Product(String name, int size, String sizeUnit) {
		if (name == null || sizeUnit == null) {
			throw new NullPointerException();
		}
		if(size < 0) {
			throw new IllegalArgumentException("size must be > 0");
		}
		this.name = name;
		this.size = size;
		this.sizeUnit = sizeUnit;
	}

	public String getName() {
		return name;
	}

	public Integer getSize() {
		return size;
	}

	public String getSizeUnit() {
		return sizeUnit;
	}

	public String getStringSize() {
		return size+sizeUnit;
	}

	public String getFullName() {
		return name+" ("+size+sizeUnit+")";
	}

}
