package be.ac.ulb.infof307.g10.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class ProductsQuantity extends AbstractObject {

	private static final long serialVersionUID = 1L;

	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Product, Integer> productsQuantity;

	protected ProductsQuantity() {
		productsQuantity = new HashMap<>();
	}

	public void setProduct(Product p, int quantity) {
		productsQuantity.put(p, quantity);
		changed();
	}

	public void addProduct(Product p, int quantity) {
		setProduct(p, quantity + getQuantity(p));
	}

	public void removeProduct(Product p) {
		productsQuantity.remove(p);
		changed();
	}

	public int getQuantity(Product p) {
		return productsQuantity.getOrDefault(p, 0);
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
