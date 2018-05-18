package be.ac.ulb.infof307.g10.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class ShoppingList extends AbstractObject {

	private static final long serialVersionUID = -0L;

	private String name;
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Product, Integer> productsAndQuantity;

	/**
	 * Needed by JPA
	 */
	protected ShoppingList() {
		// TODO change when productsQuantity is done
		// should not create shopping list without name
		productsAndQuantity = new HashMap<>();
	}

	public ShoppingList(String name) {
		setName(name);
		productsAndQuantity = new HashMap<>();
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

	public void setProduct(Product p, int quantity) {
		productsAndQuantity.put(p, quantity);
		changed();
	}

	public void addProduct(Product p, int quantity) {
		setProduct(p, quantity + getQuantity(p));
	}

	public void removeProduct(Product p) {
		productsAndQuantity.remove(p);
		changed();
	}

	public int getQuantity(Product p) {
		return productsAndQuantity.getOrDefault(p, 0);
	}

	public int size() {
		return productsAndQuantity.size();
	}

	public void clear() {
		productsAndQuantity.clear();
		changed();
	}

	public boolean isEmpty() {
		return productsAndQuantity.isEmpty();
	}

	public Set<Product> getProducts() {
		// return copy of set
		return new HashSet<>(productsAndQuantity.keySet());
	}

}
