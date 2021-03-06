package be.ac.ulb.infof307.g10.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

/**
 * Object mapping a product with an integer
 */
@Entity
public class ProductsQuantity extends NamedObject {

	private static final long serialVersionUID = 1L;

	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Product, Integer> productsQuantity;

	/**
	 * Needed by JPA
	 */
	protected ProductsQuantity() {
	}

	public ProductsQuantity(String name) {
		super(name);
		productsQuantity = new HashMap<>();
	}

	/**
	 * Return the quantity of the product p. It the map does not contain p, return 0
	 * @param p the product
	 * @return the quantity of the p if p is in the map , 0 if not.
	 */
	public int getQuantity(Product p) {
		return productsQuantity.getOrDefault(p, 0);
	}

	public void setQuantity(Product p, int quantity) {
		productsQuantity.put(p, quantity);
		changed();
	}

	public void addQuantity(Product p, int quantity) {
		setQuantity(p, quantity + getQuantity(p));
	}

	public void removeProduct(Product p) {
		productsQuantity.remove(p);
		changed();
	}

	public int size() {
		return productsQuantity.size();
	}

	public void clear() {
		productsQuantity.clear();
		changed();
	}

	public boolean isEmpty() {
		return productsQuantity.isEmpty();
	}

	public Set<Product> getProducts() {
		// return copy of set
		return new HashSet<>(productsQuantity.keySet());
	}

}
