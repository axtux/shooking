package be.ac.ulb.infof307.g10;

import static org.junit.Assert.assertNotNull;

import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Recipe;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.dao.ProductDAO;
import be.ac.ulb.infof307.g10.models.dao.RecipeDAO;
import be.ac.ulb.infof307.g10.models.dao.UserDAO;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.database.Data;
import be.ac.ulb.infof307.g10.models.database.Database;

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

	@Test(expected = NoResultException.class)
	public void test_0050_GetUser_noResultExceptionExpected() {
		Assert.assertNotEquals(null, UserDAO.getUser("fzvsvsfvsfvsf"));
	}

	@Test
	public void test_0060_CreateProduct() {
		new Product("#DB 6 Apples", 6, "unit").save();
		new Product("#DB 7 Apples", 6, "unit").save();
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
		l.save();
	}

	@Test(expected = NoResultException.class)
	public void test_0991_DeleteUser_noResultExceptionExpected() {
		Database.delete((UserDAO.getUser("#DB lala")));
	}

	@Test
	public void test_0994_DeleteProduct() {
		Database.delete(ProductDAO.getByName("#DB 7 Apples"));
	}

	@Test
	public void test_1001_ModifyRecipe() {
		Recipe r = new Recipe("#test modify recipe", 1);
		r.save();
		r.setName("#test new name");
		r.addStep("#test step 1");
		r.save();
		assertNotNull(RecipeDAO.getRecipe("#test new name"));
	}
}
