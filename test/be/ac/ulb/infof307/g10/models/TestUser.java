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
		Database.empty();
	}

	@After
	public void after() {
		Database.empty();
	}

	@Test
	public void signupTest() {
		User u = User.signup("test", "test");
		Assert.assertEquals("test", u.getUsername());
	}
	
	@Test
	public void signupPersistenceTest() {
		User u = User.signup("test", "test");
		Database.close();
		u = Database.getUser("test");
		Assert.assertNotNull(u);
	}

	@Test(expected = ExistingUserException.class)
	public void signupExistingUserExceptionTest() {
		User.signup("test", "test");
		User.signup("test", "test");
	}

	@Test
	public void loginTest() {
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

	public static User userWithShoppingList() {
		User u = User.signup("test", "test");
		ShoppingList sl = u.getShoppingList();
		
		Product p1 = new Product("test1", "test1", 0, 0, 0, 0, 0);
		Product p2 = new Product("test2", "test2", 0, 0, 0, 0, 0);
		// products have to be in database
		Database.insert(p1);
		Database.insert(p2);
		
		sl.setProduct(p1, 42);
		sl.setProduct(p2, 13);
		
		return u;
	}
	
	@Test
	public void shoppingListTest() {
		User u = userWithShoppingList();
		Assert.assertEquals(2, u.getShoppingList().size());
	}
	
	@Test
	public void userShoppingListPersistenceTest() {
		User u = userWithShoppingList();
		u.save();
		Database.close();
		
		User o = Database.getUser("test");
		System.out.println(o);
		Assert.assertEquals(2, o.getShoppingList().size());
	}
	
	@Test
	public void shoppingListPersistenceTest() {
		User u = userWithShoppingList();
		u.getShoppingList().save();
		Database.close();
		
		User o = Database.getUser("test");
		System.out.println(o);
		Assert.assertEquals(2, o.getShoppingList().size());
	}
}
