package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Test;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.db.UserDAO;
import be.ac.ulb.infof307.g10.db.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class TestUser extends AbstractTestDatabase {

	public static User userWithShoppingList() {
		User u = UserDAO.userSignup("test", "test");
		ShoppingList sl = u.getShoppingList();

		Product p1 = new Product("test1", 1, "unit");
		Product p2 = new Product("test2", 2, "unit");
		// products have to be in database
		p1.save();
		p2.save();

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
		Assert.assertEquals(2, o.getShoppingList().size());
	}

	@Test
	public void shoppingListPersistenceTest() {
		User u = userWithShoppingList();
		u.getShoppingList().save();
		Database.close();

		User o = Database.getUser("test");
		Assert.assertEquals(2, o.getShoppingList().size());
	}
}
