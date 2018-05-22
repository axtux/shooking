package be.ac.ulb.infof307.g10.models.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class TestProductDAO extends AbstractTestDatabase {

	@Test
	public void createProduct() {
		Product p = ProductDAO.create("#test createProduct", 12, "g");
		assertNotNull(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createProductException() {
		Product p = ProductDAO.create(null, 12, null);
		assertNull(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createProductException2() {
		Product p = ProductDAO.create("", -1, "");
		assertNull(p);
	}

	@Test
	public void getProduct() {
		createProduct();
		Product p = ProductDAO.getByName("#test testingProduct");
		assertNotNull(p);
	}

	@Test(expected = NonExistingException.class)
	public void getProductException() {
		Product p = ProductDAO.getByName("test badProductName");
		assertNull(p);
	}
}
