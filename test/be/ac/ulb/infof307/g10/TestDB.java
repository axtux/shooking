package be.ac.ulb.infof307.g10;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.dao.ProductDAO;
import be.ac.ulb.infof307.g10.models.dao.RecipeDAO;
import be.ac.ulb.infof307.g10.models.dao.UserDAO;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.database.Data;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

/**
 * The tests have to be executed in a certain order, so they are sorted by name
 * and executed by name ascending Some tests of this class do not have asserts
 * because an exception make the test fail when it has to
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDB {

	@BeforeClass
	public static void createDB() {
		AbstractTestDatabase.beforeClass();
		Database.empty();
	}

	@Test
	public void test_0008_isDBempty() {
		Assert.assertTrue(Database.isEmpty());
	}

	@Test
	public void test_0009_fillDB() {
		Data.fillDB();
	}

	@Test(expected = NonExistingException.class)
	public void test_0050_GetUser_NonExistingExceptionExpected() {
		Assert.assertNotEquals(null, UserDAO.getByUsername("fzvsvsfvsfvsf"));
	}

	@Test
	public void test_0060_CreateProduct() {
		ProductDAO.create("#DB 6 Apples", 6, "unit");
		ProductDAO.create("#DB 7 Apples", 6, "unit");
	}

	@Test
	public void test_0070_GetProduct() {
		ProductDAO.getByName("#DB 6 Apples");
	}

	@Test
	public void test_0072_GetProducts() {
		ProductDAO.getAll();
	}

	@Test
	public void test_0110_CreateList() {
		ShoppingList l = new ShoppingList();
		l.addProduct(ProductDAO.getByName("#DB 6 Apples"), 1);
		l.addProduct(ProductDAO.getByName("#DB 6 Apples"), 2);
	}

	@Test(expected = NonExistingException.class)
	public void test_0991_DeleteUser_NonExistingExceptionExpected() {
		Database.delete((UserDAO.getByUsername("#DB lala")));
	}

	@Test
	public void test_0994_DeleteProduct() {
		Database.delete(ProductDAO.getByName("#DB 7 Apples"));
	}

	@Test
	public void test_1001_ModifyRecipe() {
		Recipe r = RecipeDAO.create("#test modify recipe", 1);
		r.setName("#test new name");
		r.addStep("#test step 1");
		assertNotNull(RecipeDAO.getByName("#test new name"));
	}
}
