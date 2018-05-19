package be.ac.ulb.infof307.g10.models;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestShoppingList {

	private ShoppingList sl;
	private Product p;

	@Before
	public void before() {
		sl = new ShoppingList("name");
		p = new Product("productName", 1, "unit");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullNameException() {
		new ShoppingList(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyNameException() {
		new ShoppingList("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void spaceNameException() {
		new ShoppingList("  ");
	}

	@Test
	public void name() {
		Assert.assertEquals("name", sl.getName());
	}

	@Test
	public void setName() {
		sl.setName("lastname");
		Assert.assertEquals("lastname", sl.getName());
	}

	@Test
	public void setProduct() {
		sl.setQuantity(p, 13);
		sl.setQuantity(p, 42);
		Assert.assertEquals(42, sl.getQuantity(p));
	}

	@Test
	public void addProduct() {
		sl.addQuantity(p, 13);
		sl.addQuantity(p, 42);
		Assert.assertEquals(55, sl.getQuantity(p));
	}

	@Test
	public void removeProduct() {
		sl.setQuantity(p, 42);
		sl.removeProduct(p);
		Assert.assertEquals(0, sl.getQuantity(p));
	}

	@Test
	public void size() {
		sl.setQuantity(p, 42);
		Assert.assertEquals(1, sl.size());
	}

	@Test
	public void clear() {
		sl.setQuantity(p, 42);
		sl.clear();
		Assert.assertEquals(0, sl.size());
	}

	@Test
	public void emptyTest() {
		Assert.assertTrue(sl.isEmpty());
	}

	@Test
	public void getProducts() {
		sl.setQuantity(p, 42);
		Set<Product> products = sl.getProducts();
		Assert.assertTrue(products.contains(p));
		Assert.assertEquals(1, products.size());
	}

}
