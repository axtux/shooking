package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUser {
	private User user;

	@Before
	public void create() {
		user = new User("test", "test");
	}
	
	@Test
	public void usernameTest() {
		Assert.assertEquals("test", user.getUsername());
	}
	
	@Test
	public void testCopy() {
		User copy = new User(user);
		copy.setPassword("other");
		Assert.assertEquals(user.getUsername(), copy.getUsername());
		Assert.assertNotEquals(user.getHashedPassword(), copy.getHashedPassword());
	}
	
	@Test
	public void testDeepCopy() {
		ShoppingList sl = new ShoppingList();
		Product p1 = new Product("test1", "test1", 0, 0, 0, 0, 0);
		Product p2 = new Product("test2", "test2", 0, 0, 0, 0, 0);
		sl.addProduct(p1, 42);
		sl.addProduct(p2, 13);
		user = new User("test", "test", sl);
		User copy = new User(user);
		sl.addProduct(new Product("test3", "test3", 0, 0, 0, 0, 0),  7);
		sl.addProduct(p1, 42);
		Assert.assertEquals(2, copy.getShoppingList().size());
		Assert.assertEquals(42, copy.getShoppingList().getQuantity(p1));
	}
}
