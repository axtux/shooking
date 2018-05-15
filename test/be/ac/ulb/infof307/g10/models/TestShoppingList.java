package be.ac.ulb.infof307.g10.models;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import be.ac.ulb.infof307.g10.db.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.db.GenericDatabase;
import be.ac.ulb.infof307.g10.models.dao.ProductDAO;
import be.ac.ulb.infof307.g10.models.dao.ShoppingListDAO;

public class TestShoppingList extends AbstractTestDatabase {
	
	private ShoppingList sl;

	@Before
	public void create() {
		super.before();
		//sl = new ShoppingList();
		sl = ShoppingListDAO.createShoppingList("#test testingSL");
	}

	@Test
	public void emptyTest() {
		Assert.assertTrue(sl.getProducts().isEmpty());
	}

	@Test
	public void setTest() {
		Product p1 = ProductDAO.createProduct("#test testingProduct1", 1, "unit");
		Product p2 = ProductDAO.createProduct("#test testingProduct2", 1, "unit");
		sl.setProduct(p1, 1);
		sl.setProduct(p2, 2);
		Assert.assertEquals(1, sl.getQuantity(p1));
		Assert.assertEquals(2, sl.getQuantity(p2));
		Assert.assertEquals(2, sl.size());
	}
	
	@Test
	public void setTestDB() {
		Product p1 = ProductDAO.createProduct("#test testingProduct1", 1, "unit");
		Product p2 = ProductDAO.createProduct("#test testingProduct2", 1, "unit");
		sl.setProduct(p1, 1);
		sl.setProduct(p2, 2);
		GenericDatabase.close();
		sl = ShoppingListDAO.getShoppingList("#test testingSL");
		p1 = ProductDAO.getProduct("#test testingProduct1");
		p2 = ProductDAO.getProduct("#test testingProduct2");
		Assert.assertEquals(1, sl.getQuantity(p1));
		Assert.assertEquals(2, sl.getQuantity(p2));
		Assert.assertEquals(2, sl.size());
	}

	@Test
	public void addTest() {
		Product p1 = ProductDAO.createProduct("#test testingProduct1", 1, "unit");
		sl.addProduct(p1, 1);
		sl.addProduct(p1, 1);
		sl.addProduct(p1, 1);
		Assert.assertEquals(3, sl.getQuantity(p1));
		Assert.assertEquals(1, sl.size());
	}

	@Test
	public void addTestDB() {
		Product p1 = ProductDAO.createProduct("#test testingProduct1", 1, "unit");
		sl.addProduct(p1, 1);
		sl.addProduct(p1, 1);
		sl.addProduct(p1, 1);
		GenericDatabase.close();
		sl = ShoppingListDAO.getShoppingList("#test testingSL");
		p1 = ProductDAO.getProduct("#test testingProduct1");
		Assert.assertEquals(3, sl.getQuantity(p1));
		Assert.assertEquals(1, sl.size());
	}
	
	@Test
	public void removeTest() {
		Product p1 = ProductDAO.createProduct("#test testingProduct1", 1, "unit");
		Product p2 = ProductDAO.createProduct("#test testingProduct2", 1, "unit");
		sl.setProduct(p1, 1);
		sl.setProduct(p2, 2);
		sl.removeProduct(p1);
		Assert.assertEquals(0, sl.getQuantity(p1));
		Assert.assertEquals(2, sl.getQuantity(p2));
		Assert.assertEquals(1, sl.size());
	}
	
	@Test
	public void removeTestDB() {
		Product p1 = ProductDAO.createProduct("#test testingProduct1", 1, "unit");
		Product p2 = ProductDAO.createProduct("#test testingProduct2", 1, "unit");
		sl.setProduct(p1, 1);
		sl.setProduct(p2, 2);
		sl.removeProduct(p1);
		GenericDatabase.close();
		sl = ShoppingListDAO.getShoppingList("#test testingSL");
		p1 = ProductDAO.getProduct("#test testingProduct1");
		p2 = ProductDAO.getProduct("#test testingProduct2");
		Assert.assertEquals(0, sl.getQuantity(p1));
		Assert.assertEquals(2, sl.getQuantity(p2));
		Assert.assertEquals(1, sl.size());
	}

	@Test
	public void getProductsTest() {
		Product p1 = ProductDAO.createProduct("#test testingProduct1", 1, "unit");
		Product p2 = ProductDAO.createProduct("#test testingProduct2", 1, "unit");
		sl.setProduct(p1, 1);
		sl.setProduct(p2, 2);
		Set<Product> set = sl.getProducts();
		Assert.assertTrue(set.contains(p1));
		Assert.assertTrue(set.contains(p2));
		Assert.assertEquals(2, set.size());
	}

	@Test
	public void copyTest() {
		Product p1 = ProductDAO.createProduct("#test testingProduct1", 1, "unit");
		Product p2 = ProductDAO.createProduct("#test testingProduct2", 1, "unit");
		sl.setProduct(p1, 1);
		sl.setProduct(p2, 2);

		ShoppingList copy = new ShoppingList(sl);
		sl.removeProduct(p1);
		sl.removeProduct(p2);
		Assert.assertEquals(2, copy.size());
	}

}
