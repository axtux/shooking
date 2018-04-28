package be.ac.ulb.infof307.g10.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class ShoppingList extends ModelObject {

	private static final long serialVersionUID = -0L;

	@ElementCollection(fetch = FetchType.EAGER)
	Map<Product, Integer> productsAndQuantity;

	// NEEDED BY JPA
	public ShoppingList() {
		productsAndQuantity = new HashMap<>();
	}

	/**
	 * Copy ShoppingList
	 * @param sl Shopping list to copy
	 */
	public ShoppingList(ShoppingList sl) {
		setProductsAndQuantity(sl.productsAndQuantity);
	}

	public void setProduct(Product p, int quantity) {
		productsAndQuantity.put(p, quantity);
	}

	public void addProduct(Product p, int quantity) {
		setProduct(p, quantity+getQuantity(p));
	}

	public void removeProduct(Product p) {
		productsAndQuantity.remove(p);
	}
	
	public int getQuantity(Product p) {
		return productsAndQuantity.getOrDefault(p, 0);
	}
	
	public int size() {
		return productsAndQuantity.size();
	}

	public Set<Product> getProducts() {
		return productsAndQuantity.keySet();
	}

	public Map<Product, Integer> getProductsAndQuantity() {
		return copyMap(productsAndQuantity);
	}

	public void setProductsAndQuantity(Map<Product, Integer> productsAndQuantity) {
		this.productsAndQuantity = copyMap(productsAndQuantity);
	}

	private static Map<Product, Integer> copyMap(Map<Product, Integer> map) {
		return new HashMap<Product, Integer>(map);
	}

}
