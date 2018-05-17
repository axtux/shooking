package be.ac.ulb.infof307.g10.models.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.dao.ProductDAO;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class TestProductDAO extends AbstractTestDatabase {

	@Test
	public void test_001_createProduct() {
		Product p = ProductDAO.create("#test createProduct", 12, "g");
		assertNotNull(p);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_002_createProductException() {
		Product p = ProductDAO.create(null, 12, null);
		assertNull(p);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_003_createProductException() {
		Product p = ProductDAO.create("", -1, "");
		assertNull(p);
	}
	
	public static void createProduct() {
		ProductDAO.create("#test testingProduct", 12, "g");
	}
	
	@Test
	public void test_004_getProduct() {
		createProduct();
		Product p = ProductDAO.getByName("#test testingProduct");
		assertNotNull(p);
	}
	
	@Test(expected=NonExistingException.class)
	public void test_005_getProductException() {
		Product p = ProductDAO.getByName("test badProductName");
		assertNull(p);
	}
}
