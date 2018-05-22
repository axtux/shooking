package be.ac.ulb.infof307.g10.models;

import javax.persistence.Entity;

/**
 * Shopping list object, used to remove abstraction of ProductsQuantity
 */
@Entity
public class ShoppingList extends ProductsQuantity {

	private static final long serialVersionUID = -0L;

	/**
	 * Needed by JPA
	 */
	protected ShoppingList() {
	}

	public ShoppingList(String name) {
		super(name);
	}

}
