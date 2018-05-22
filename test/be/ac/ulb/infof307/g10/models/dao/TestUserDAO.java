package be.ac.ulb.infof307.g10.models.dao;

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
import be.ac.ulb.infof307.g10.models.exceptions.PasswordsDoNotMatchException;

public class TestUserDAO extends AbstractTestDatabase {

	@Test
	public void signupTest() {
		User u = UserDAO.create("test", "test", "test");
		Assert.assertEquals("test", u.getName());
	}

	@Test
	public void signupPersistenceTest() {
		User u = UserDAO.create("test", "test", "test");
		Database.close();
		u = UserDAO.getByUsername("test");
		Assert.assertNotNull(u);
	}

	@Test(expected = ExistingException.class)
	public void signupExistingUserExceptionTest() {
		UserDAO.create("test", "test", "test");
		UserDAO.create("test", "test", "test");
	}

	@Test
	public void loginTest() {
		UserDAO.create("test", "test", "test");
		User u = UserDAO.login("test", "test");
		Assert.assertEquals("test", u.getName());
	}

	@Test(expected = PasswordsDoNotMatchException.class)
	public void createPasswordDoNotMatchExceptionTest() {
		UserDAO.create("test", "test", "test2");
	}

	@Test(expected = IncorrectPasswordException.class)
	public void loginIncorrectPasswordExceptionTest() {
		UserDAO.create("test", "test", "test");
		UserDAO.login("test", "badPassword");
	}

	@Test(expected = NonExistingException.class)
	public void loginNonExistingUserExceptionTest() {
		UserDAO.login("badUser", "anyPassword");
	}

	public static void createTestingUser() {
		UserDAO.create("#test testingUser", "very good password", "very good password");
	}
	
	public static ShoppingList shoppingListFromUser() {
		ShoppingList sl = new ShoppingList("test");
		UserDAO.create("test", "test", "test").addShoppingList(sl);
		return sl;
	}

	@Test
	public void setTestDB() {
		ShoppingList sl = shoppingListFromUser();
		Product p1 = ProductDAO.create("#test testingProduct1", 1, "unit");
		Product p2 = ProductDAO.create("#test testingProduct2", 1, "unit");
		sl.setQuantity(p1, 1);
		sl.setQuantity(p2, 2);
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
		ShoppingList sl = shoppingListFromUser();
		Product p1 = ProductDAO.create("#test testingProduct1", 1, "unit");
		sl.addQuantity(p1, 1);
		sl.addQuantity(p1, 1);
		sl.addQuantity(p1, 1);
		Database.close();
		sl = UserDAO.getByUsername("test").getShoppingLists().iterator().next();
		p1 = ProductDAO.getByName("#test testingProduct1");
		Assert.assertEquals(3, sl.getQuantity(p1));
		Assert.assertEquals(1, sl.size());
	}

	@Test
	public void removeTestDB() {
		ShoppingList sl = shoppingListFromUser();
		Product p1 = ProductDAO.create("#test testingProduct1", 1, "unit");
		Product p2 = ProductDAO.create("#test testingProduct2", 1, "unit");
		sl.setQuantity(p1, 1);
		sl.setQuantity(p2, 2);
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
		User o = UserDAO.create("#test testingUser", "badPassword", "badPassword");
		Database.close();
		o = UserDAO.login("#test testingUser", "badPassword");
		o.setPassword("newPassword");
		Database.close();
		o = UserDAO.login("#test testingUser", "newPassword");
	}

}
