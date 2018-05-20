package be.ac.ulb.infof307.g10.models;

import javax.persistence.Entity;

@Entity
public class ShoppingList extends ProductsQuantity {

	private static final long serialVersionUID = -0L;
	private String name;

	/**
	 * Needed by JPA
	 */
	protected ShoppingList() {
		super();
	}

	public ShoppingList(String name) {
		this();
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("name must not be empty");
		}
		this.name = name;
		changed();
	}

}
