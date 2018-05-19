package be.ac.ulb.infof307.g10.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class ProductsQuantity extends AbstractObject {

	private static final long serialVersionUID = 1L;

	//@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Map<Product, Integer> productsAndQuantity;

	protected ProductsQuantity() {
		productsAndQuantity = new HashMap<>();
	}

	public void setProduct(Product p, int quantity) {
		productsAndQuantity.put(p, quantity);
		changed();
	}

	public void addProduct(Product p, int quantity) {
		setProduct(p, quantity + getQuantity(p));
		this.changed();
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
