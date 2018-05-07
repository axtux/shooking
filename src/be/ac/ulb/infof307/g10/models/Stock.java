package be.ac.ulb.infof307.g10.models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class Stock extends ShoppingList {

	private static final long serialVersionUID = -0L;

	@ElementCollection(fetch = FetchType.EAGER)
	Map<Product, Integer> productsAndPrice;

	public Stock() { // Needed by JPA
		super();
		productsAndPrice = new HashMap<>();
	}

	public int getPrice(Product p) {
		return productsAndPrice.getOrDefault(p, 0);
	}
	/**
	 * Get price of Product p adapted to quantity
	 * @param p Product
	 * @param quantity Quantity
	 * @return Price adapted to quantity or 0 if not enough quantity of Product
	 */
	public int getPrice(Product p, int quantity) {
		if (quantity > getQuantity(p)) {
			return 0;
		}
		return getPrice(p)*quantity;
	}

	public void setPrice(Product p, int price) {
		setProduct(p, getQuantity(p), price);
	}

	public void setProduct(Product p, int quantity) {
		setProduct(p, quantity, getPrice(p));
	}

	public void setProduct(Product p, int quantity, int price) {
		super.setProduct(p, quantity);
		productsAndPrice.put(p, price);
	}

	public void addProduct(Product p, int quantity) {
		setProduct(p, quantity+getQuantity(p), getPrice(p));
	}

	public void addProduct(Product p, int quantity, int price) {
		setProduct(p, quantity+getQuantity(p), price);
	}

	public void removeProduct(Product p) {
		super.removeProduct(p);
		productsAndPrice.remove(p);
	}

	public void clear() {
		super.clear();
		productsAndPrice.clear();
	}

}
