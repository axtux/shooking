package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.dao.ProductDAO;
import be.ac.ulb.infof307.g10.models.dao.ShopDAO;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.database.Database;

public class TestShop extends AbstractTestDatabase {

	private String[] testingSchedule = { "1", "2", "3", "4", "5", "6", "7" };
	
	public static void createTestingShop() {
		Shop shop = ShopDAO.createShop("#test testingShop", 0., 0.);
		Product product = ProductDAO.createProduct("#test testingProduct", 12, "g");
		shop.getStock().addProduct(product, 1);
		Database.save(shop);
		Database.close();
	}
	
	@Test
	public void test_001_getSchedule() {
		Shop shop = new Shop("#test getSchedule", 0., 0., testingSchedule);
		assertEquals(shop.getSchedule(0), "1");
	}
	
	@Test
	public void test_002_setStock() {
		Shop shop = new Shop("#test setStock", 0., 0., testingSchedule);
		shop.getStock().addProduct(new Product("#test testingProduct", 12, "g"), 1);
		assertEquals(shop.getStock().size(), 1);
	}
	
	@Test
	public void test_003_setStockDB() {
		createTestingShop();
		Shop shop = ShopDAO.getShop("#test testingShop");
		assertEquals(shop.getStock().size(), 1);
	}
}
