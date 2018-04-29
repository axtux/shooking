package be.ac.ulb.infof307.g10.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Product extends ModelObject {

	private static final long serialVersionUID = -0L;

	@Column(unique = true)
	private String name;
	private String description;
	private int size;
	private int price;

	@SuppressWarnings("unused") // NEEDED BY JPA
	private Product() {}

	public Product(String name, String description, int size) {
		this(name, description, size, 0);
	}

	public Product(String name, String description, int size, int price) {
		if (name == null || description == null) {
			throw new NullPointerException();
		}
		if(size < 0) {
			throw new IllegalArgumentException("size must be > 0");
		}
		if(price < 0) {
			throw new IllegalArgumentException("price must be > 0");
		}
		this.name = name;
		this.description = description;
		this.size = size;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getSize() {
		return size;
	}

	public Integer getPrice() {
		return price;
	}

}
