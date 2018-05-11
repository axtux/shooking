package be.ac.ulb.infof307.g10.db;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;

public class TestShoppingListDAO {

	public static void createTestingShoppingList() {
		ShoppingListDAO.createShoppingList("#test testingShoppingList");
	}
	
	@Test
	public void test_001_createShoppingList() {
		ShoppingList sl = ShoppingListDAO.createShoppingList("#test createShoppingList");
		assertNotNull(sl);
	}
	
	@Test(expected=ExistingException.class)
	public void test_002_createShoppingListException() {
		createTestingShoppingList();
		ShoppingList sl = ShoppingListDAO.createShoppingList("#test testingShoppingList");
		assertNull(sl);
	}
	
	@Test
	public void test_003_getShoppingList() {
		createTestingShoppingList();
		ShoppingList sl = ShoppingListDAO.createShoppingList("#test testingShoppingList");
		assertNotNull(sl);
	}
	
	@Test(expected=NonExistingException.class)
	public void test_004_getShoppingListException() {
		ShoppingList sl = ShoppingListDAO.createShoppingList("#test getShoppingListException");
		assertNull(sl);
	}
}
