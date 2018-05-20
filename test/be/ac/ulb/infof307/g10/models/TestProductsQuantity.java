package be.ac.ulb.infof307.g10.models;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestProductsQuantity {

	private ProductsQuantity pq;
	private Product p;

	@Before
	public void before() {
		pq = new ShoppingList("name");
		p = new Product("productName", 1, "unit");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nameException() {
		new ShoppingList(null);
	}

	@Test
	public void setProduct() {
		pq.setQuantity(p, 13);
		pq.setQuantity(p, 42);
		Assert.assertEquals(42, pq.getQuantity(p));
	}

	@Test
	public void addProduct() {
		pq.addQuantity(p, 13);
		pq.addQuantity(p, 42);
		Assert.assertEquals(55, pq.getQuantity(p));
	}

	@Test
	public void removeProduct() {
		pq.setQuantity(p, 42);
		pq.removeProduct(p);
		Assert.assertEquals(0, pq.getQuantity(p));
	}

	@Test
	public void size() {
		pq.setQuantity(p, 42);
		Assert.assertEquals(1, pq.size());
	}

	@Test
	public void clear() {
		pq.setQuantity(p, 42);
		pq.clear();
		Assert.assertEquals(0, pq.size());
	}

	@Test
	public void emptyTest() {
		Assert.assertTrue(pq.isEmpty());
	}

	@Test
	public void getProducts() {
		pq.setQuantity(p, 42);
		Set<Product> products = pq.getProducts();
		Assert.assertTrue(products.contains(p));
		Assert.assertEquals(1, products.size());
	}

}
