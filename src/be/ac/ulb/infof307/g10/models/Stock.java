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

	// NEEDED BY JPA
	public Stock() {
		super();
		productsAndPrice = new HashMap<>();
	}

	public int getPrice(Product p) {
		return productsAndPrice.getOrDefault(p, 0);
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
		productsAndQuantity.remove(p);
		productsAndPrice.remove(p);
	}

}
