package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.dao.ProductDAO;
import be.ac.ulb.infof307.g10.models.dao.ShopDAO;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.database.Database;

public class TestShop extends AbstractTestDatabase {

	private Map<DayOfWeek, String> schedule = new HashMap<>();
	
	public static void createTestingShop() {
		Shop shop = ShopDAO.create("#test testingShop", 0., 0., null);
		Product product = ProductDAO.create("#test testingProduct", 12, "g");
		shop.getStock().addProduct(product, 1);
		Database.save(shop);
		Database.close();
	}
	
	@Test
	public void test_001_getSchedule() {
		Shop shop = new Shop("#test getSchedule", 0., 0., schedule);
		assertEquals(shop.getSchedule(DayOfWeek.MONDAY), "Unknown");
	}
	
	@Test
	public void test_002_setStock() {
		Shop shop = new Shop("#test setStock", 0., 0., schedule);
		shop.getStock().addProduct(new Product("#test testingProduct", 12, "g"), 1);
		assertEquals(shop.getStock().size(), 1);
	}
	
	@Test
	public void test_003_setStockDB() {
		createTestingShop();
		Shop shop = ShopDAO.getByName("#test testingShop");
		assertEquals(shop.getStock().size(), 1);
	}
}
