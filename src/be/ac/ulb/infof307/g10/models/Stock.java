package be.ac.ulb.infof307.g10.models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

/**
 * Object representing the stock of a shop
 */
@Entity
public class Stock extends ProductsQuantity {

	private static final long serialVersionUID = -0L;

	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Product, Integer> productsAndPrice;

	/**
	 * Needed by JPA
	 */
	protected Stock() {
	}

	public Stock(String name) {
		super(name);
		productsAndPrice = new HashMap<>();
	}

	public int getPrice(Product p) {
		return productsAndPrice.getOrDefault(p, 0);
	}

	/**
	 * Get price of Product p for quantity
	 * 
	 * @param p
	 *            Product
	 * @param quantity
	 *            Quantity
	 * @return Price for quantity
	 * @throws NonExistingException
	 *             if not enough quantity is available in this stock
	 */
	public int getPrice(Product p, int quantity) throws NonExistingException {
		if (quantity < 0) {
			throw new IllegalArgumentException("quantity must be >= 0");
		}
		if (quantity > getQuantity(p)) {
			throw new NonExistingException("not enough quantity for product " + p.getName());
		}
		return getPrice(p) * quantity;
	}

	/**
	 * Get price of shopping list.
	 * 
	 * @param sl
	 *            Shopping list
	 * @return Price adapted to quantity from shopping list or 0 if not enough
	 *         quantity of one product
	 * @throws NonExistingException
	 *             if not enough quantity of one product is available in this
	 *             stock
	 */
	public int getPrice(ShoppingList sl) throws NonExistingException {
		int total = 0;
		for (Product p : sl.getProducts()) {
			total += getPrice(p, sl.getQuantity(p));
		}
		return total;
	}

	public void setPrice(Product p, int price) {
		setProduct(p, getQuantity(p), price);
	}

	public void setProduct(Product p, int quantity, int price) {
		productsAndPrice.put(p, price);
		super.setQuantity(p, quantity);
	}

	@Override
	public void removeProduct(Product p) {
		productsAndPrice.remove(p);
		super.removeProduct(p);
	}

	@Override
	public void clear() {
		productsAndPrice.clear();
		super.clear();
	}

}
