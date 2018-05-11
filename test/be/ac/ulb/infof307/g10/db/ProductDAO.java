package be.ac.ulb.infof307.g10.db;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class ProductDAO {

	@Test
	public void test_001_createProduct() {
		Product p = ProductDAO.createProduct("#test createProduct", 12, "g");
		assertNotNull(p);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_002_createProductException() {
		Product p = ProductDAO.createProduct(null, 12, null);
		assertNull(p);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_003_createProductException() {
		Product p = ProductDAO.createProduct("", -1, "");
		assertNull(p);
	}
	
	public static void createProduct() {
		ProductDAO.createProduct("#test testingProduct", 12, "g");
	}
	
	@Test
	public void test_004_getProduct() {
		createProduct();
		Product p = ProductDAO.getProduct("#test testingProduct");
		assertNotNull(p);
	}
	
	@Test(expected=NonExistingException.class)
	public void test_005_getProduct() {
		createProduct();
		Product p = ProductDAO.getProduct("test bad product name");
		assertNull(p);
	}
}
