package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.dao.ProductDAO;
import be.ac.ulb.infof307.g10.models.dao.UserDAO;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.database.Database;

public class TestUser extends AbstractTestDatabase {

	public static User userWithShoppingList() {
		User u = UserDAO.create("test", "test");
		u.addShoppingList(new ShoppingList());
		ShoppingList sl = u.getShoppingLists().get(0);

		Product p1 = ProductDAO.create("test1", 1, "unit");
		Product p2 = ProductDAO.create("test2", 2, "unit");

		sl.setProduct(p1, 42);
		sl.setProduct(p2, 13);

		return u;
	}

	@Test
	public void shoppingListTest() {
		User u = userWithShoppingList();
		Assert.assertEquals(2, u.getShoppingLists().get(0).size());
	}

	@Test
	public void userShoppingListPersistenceTest() {
		userWithShoppingList();
		Database.close();

		User o = UserDAO.getByUsername("test");
		Assert.assertEquals(2, o.getShoppingLists().get(0).size());
	}

	@Test
	public void shoppingListPersistenceTest() {
		userWithShoppingList();
		Database.close();

		User o = UserDAO.getByUsername("test");
		Assert.assertEquals(2, o.getShoppingLists().get(0).size());
	}

	@Test
	public void addShoppingList() {
		User u = UserDAO.create("test", "test");
		Assert.assertEquals(0,u.getShoppingLists().size());
		u.addShoppingList(new ShoppingList());
		Assert.assertEquals(u.getShoppingLists().size(),1);
	}
}
