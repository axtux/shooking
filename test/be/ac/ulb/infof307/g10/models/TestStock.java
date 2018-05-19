package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class TestStock {

	private Stock stock;
	private Product p;

	@Before
	public void before() {
		stock = new Stock();
		p = new Product("productName", 42, "g");
		stock.setProduct(p, 13, 199);
	}

	@Test
	public void noPrice() {
		p = new Product("non exsitent", 42, "g");
		Assert.assertEquals(0, stock.getPrice(p));
	}

	@Test
	public void price() {
		Assert.assertEquals(199, stock.getPrice(p));
	}

	@Test
	public void multiplePrice() {
		Assert.assertEquals(2 * 199, stock.getPrice(p, 2));
	}

	@Test(expected = NonExistingException.class)
	public void notEnoughPrice() {
		stock.getPrice(p, 50);
	}

	@Test
	public void shoppingListPrice() {
		ShoppingList sl = new ShoppingList();
		sl.addQuantity(p, 2);
		Assert.assertEquals(2 * 199, stock.getPrice(sl));
	}

	@Test(expected = NonExistingException.class)
	public void shoppingListNotEnoughPrice() {
		ShoppingList sl = new ShoppingList();
		sl.addQuantity(p, 50);
		stock.getPrice(sl);
	}

	@Test
	public void setPrice() {
		stock.setPrice(p, 299);
		Assert.assertEquals(299, stock.getPrice(p));
		Assert.assertEquals(13, stock.getQuantity(p));
	}

	@Test
	public void setProductQuantity() {
		stock.setQuantity(p, 15);
		Assert.assertEquals(199, stock.getPrice(p));
		Assert.assertEquals(15, stock.getQuantity(p));
	}
	
	@Test
	public void setProductQuantityAndPrice() {
		stock.setProduct(p, 15, 299);
		Assert.assertEquals(299, stock.getPrice(p));
		Assert.assertEquals(15, stock.getQuantity(p));
	}
	
	@Test
	public void addProduct() {
		stock.addQuantity(p, 2);
		Assert.assertEquals(199, stock.getPrice(p));
		Assert.assertEquals(15, stock.getQuantity(p));
	}
	
	@Test
	public void removeProduct() {
		stock.removeProduct(p);
		Assert.assertEquals(0, stock.getPrice(p));
		Assert.assertEquals(0, stock.getQuantity(p));
	}
	
	@Test
	public void clear() {
		stock.clear();
		Assert.assertEquals(0, stock.getPrice(p));
		Assert.assertEquals(0, stock.getQuantity(p));
	}

}
