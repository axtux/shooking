package be.ac.ulb.infof307.g10.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingUserException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingUserException;

public class TestUser {

	@BeforeClass
	public static void beforeClass() {
		Database.deleteAll(User.class);
	}

	@After
	public void after() {
		Database.deleteAll(User.class);
	}


	@Test
	public void usernameTest() {
		User user = new User("test", "test");
		Assert.assertEquals("test", user.getUsername());
	}
	
	@Test
	public void copyTest() {
		User user = new User("test", "test");
		User copy = new User(user);
		copy.setPassword("other");
		Assert.assertEquals(user.getUsername(), copy.getUsername());
		Assert.assertNotEquals(user.getHashedPassword(), copy.getHashedPassword());
	}
	
	@Test
	public void deepCopyTest() {
		ShoppingList sl = new ShoppingList();
		Product p1 = new Product("test1", "test1", 0, 0, 0, 0, 0);
		Product p2 = new Product("test2", "test2", 0, 0, 0, 0, 0);
		sl.addProduct(p1, 42);
		sl.addProduct(p2, 13);
		User user = new User("test", "test", sl);
		User copy = new User(user);
		sl.addProduct(new Product("test3", "test3", 0, 0, 0, 0, 0),  7);
		sl.addProduct(p1, 42);
		Assert.assertEquals(2, copy.getShoppingList().size());
		Assert.assertEquals(42, copy.getShoppingList().getQuantity(p1));
	}

	@Test
	public void signupLoginTest() {
		User.signup("test", "test");
		User u = User.login("test", "test");
		Assert.assertEquals("test", u.getUsername());
	}
	
	@Test(expected = IncorrectPasswordException.class)
	public void loginIncorrectPasswordExceptionTest() {
		User.signup("test", "test");
		User.login("test", "badPassword");
	}
	
	@Test(expected = NonExistingUserException.class)
	public void loginNonExistingUserExceptionTest() {
		User.login("badUser", "anyPassword");
	}
	
	@Test(expected = ExistingUserException.class)
	public void signupExistingUserExceptionTest() {
		User.signup("test", "test");
		User.signup("test", "test");
	}
}
