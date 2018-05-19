package be.ac.ulb.infof307.g10.models.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.dao.UserDAO;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class TestUserDAO extends AbstractTestDatabase {

	@Test
	public void signupTest() {
		User u = UserDAO.create("test", "test");
		Assert.assertEquals("test", u.getUsername());
	}

	@Test
	public void signupPersistenceTest() {
		User u = UserDAO.create("test", "test");
		Database.close();
		u = UserDAO.getByUsername("test");
		Assert.assertNotNull(u);
	}

	@Test(expected = ExistingException.class)
	public void signupExistingUserExceptionTest() {
		UserDAO.create("test", "test");
		UserDAO.create("test", "test");
	}

	@Test
	public void loginTest() {
		UserDAO.create("test", "test");
		User u = UserDAO.login("test", "test");
		Assert.assertEquals("test", u.getUsername());
	}

	@Test(expected = IncorrectPasswordException.class)
	public void loginIncorrectPasswordExceptionTest() {
		UserDAO.create("test", "test");
		UserDAO.login("test", "badPassword");
	}

	@Test(expected = NonExistingException.class)
	public void loginNonExistingUserExceptionTest() {
		UserDAO.login("badUser", "anyPassword");
	}

	public static void createTestingUser() {
		UserDAO.create("#test testingUser", "very good password");
	}
	
	@Test
	public void test_001_userLogin() {
		createTestingUser();
		User u = UserDAO.login("#test testingUser", "very good password");
		assertNotNull(u);
	}
	
	@Test(expected=NonExistingException.class)
	public void test_002_userLoginException() {
		User u = UserDAO.login("#test userLoginException", "very good password");
		assertNull(u);
	}
	
	@Test(expected=IncorrectPasswordException.class)
	public void test_003_userLoginException() {
		createTestingUser();
		User u = UserDAO.login("#test testingUser", "bad password");
		assertNull(u);
	}
	
	@Test
	public void test_004_userSignup() {
		User u = UserDAO.create("#test userSignup", "very good password");
		assertNotNull(u);
	}
	
	@Test(expected=ExistingException.class)
	public void test_005_userSignupException() {
		createTestingUser();
		User u = UserDAO.create("#test testingUser", "very good password");
		assertNull(u);
	}

	@Test
	public void setTestDB() {
		User u = UserDAO.create("test", "test");
		u.addShoppingList(new ShoppingList("test"));
		ShoppingList sl = u.getShoppingLists().iterator().next();
		Product p1 = ProductDAO.create("#test testingProduct1", 1, "unit");
		Product p2 = ProductDAO.create("#test testingProduct2", 1, "unit");
		sl.setProduct(p1, 1);
		sl.setProduct(p2, 2);
		Database.close();
		sl = UserDAO.getByUsername("test").getShoppingLists().iterator().next();
		p1 = ProductDAO.getByName("#test testingProduct1");
		p2 = ProductDAO.getByName("#test testingProduct2");
		Assert.assertEquals(1, sl.getQuantity(p1));
		Assert.assertEquals(2, sl.getQuantity(p2));
		Assert.assertEquals(2, sl.size());
	}

	@Test
	public void addTestDB() {
		User u = UserDAO.create("test", "test");
		u.addShoppingList(new ShoppingList("test"));
		ShoppingList sl = u.getShoppingLists().iterator().next();
		Product p1 = ProductDAO.create("#test testingProduct1", 1, "unit");
		sl.addProduct(p1, 1);
		sl.addProduct(p1, 1);
		sl.addProduct(p1, 1);
		Database.close();
		sl = UserDAO.getByUsername("test").getShoppingLists().iterator().next();
		p1 = ProductDAO.getByName("#test testingProduct1");
		Assert.assertEquals(3, sl.getQuantity(p1));
		Assert.assertEquals(1, sl.size());
	}

	@Test
	public void removeTestDB() {
		User u = UserDAO.create("test", "test");
		u.addShoppingList(new ShoppingList("test"));
		ShoppingList sl = u.getShoppingLists().iterator().next();
		Product p1 = ProductDAO.create("#test testingProduct1", 1, "unit");
		Product p2 = ProductDAO.create("#test testingProduct2", 1, "unit");
		sl.setProduct(p1, 1);
		sl.setProduct(p2, 2);
		sl.removeProduct(p1);
		Database.close();
		sl = UserDAO.getByUsername("test").getShoppingLists().iterator().next();
		p1 = ProductDAO.getByName("#test testingProduct1");
		p2 = ProductDAO.getByName("#test testingProduct2");
		Assert.assertEquals(0, sl.getQuantity(p1));
		Assert.assertEquals(2, sl.getQuantity(p2));
		Assert.assertEquals(1, sl.size());
	}

	@Test
	public void testPersistenceDB() {
		User o = UserDAO.create("#test testingUser", "badPassword");
		Database.close();
		o = UserDAO.login("#test testingUser", "badPassword");
		o.setPassword("newPassword");
		Database.close();
		o = UserDAO.login("#test testingUser", "newPassword");
	}

}
