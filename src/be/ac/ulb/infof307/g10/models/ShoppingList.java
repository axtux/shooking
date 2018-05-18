package be.ac.ulb.infof307.g10.models;

import java.util.HashMap;
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
	public ShoppingList() {
		productsAndQuantity = new HashMap<>();
	}
	
	public ShoppingList(String name) throws IllegalArgumentException {
		if(name==null || name.trim().equals("")) {
			throw new IllegalArgumentException("The name is null or empty");
		}
		this.name = name;
		productsAndQuantity = new HashMap<>();
	}

	/**
	 * Copy ShoppingList
	 * 
	 * @param sl
	 *            Shopping list to copy
	 */
	public ShoppingList(ShoppingList sl) {
		setProductsAndQuantity(sl.productsAndQuantity);
	}

	public String getName() {
		return name;
	}

	public void setProduct(Product p, int quantity) {
		productsAndQuantity.put(p, quantity);
		this.changed();
	}

	public void addProduct(Product p, int quantity) {
		setProduct(p, quantity + getQuantity(p));
		this.changed();
	}

	public void removeProduct(Product p) {
		productsAndQuantity.remove(p);
		this.changed();
	}

	public int getQuantity(Product p) {
		return productsAndQuantity.getOrDefault(p, 0);
	}

	public int size() {
		return productsAndQuantity.size();
	}

	public void clear() {
		productsAndQuantity.clear();
		this.changed();
	}

	public Set<Product> getProducts() {
		return productsAndQuantity.keySet();
	}

	public Map<Product, Integer> getProductsAndQuantity() {
		return new HashMap<>(productsAndQuantity);
	}

	public void setProductsAndQuantity(Map<Product, Integer> productsAndQuantity) {
		this.productsAndQuantity = new HashMap<>(productsAndQuantity);
		this.changed();
	}

}
