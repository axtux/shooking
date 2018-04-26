package be.ac.ulb.infof307.g10.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Entity
public class ShoppingList implements Serializable {

	private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
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
		int before = productsAndQuantity.getOrDefault(p, 0);
		setProduct(p, quantity+before);
	}

	public void removeProduct(Product p) {
		productsAndQuantity.remove(p);
	}

	@Override
	public String toString() {
		return "ShoppingList{" + "id=" + id + ", productsAndAssociatedQuantity=" + productsAndQuantity.toString() + '}';
	}

	public Long getId() {
		return id;
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
		Map<Product, Integer> copy = new HashMap<Product, Integer>();
		for(Entry<Product, Integer> e: map.entrySet()) {
			copy.put(new Product(e.getKey()), e.getValue());
		}
		return copy;
	}
}
