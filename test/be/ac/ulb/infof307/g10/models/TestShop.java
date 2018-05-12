package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g10.db.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.db.ProductDAO;
import be.ac.ulb.infof307.g10.db.ShopDAO;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;

public class TestShop extends AbstractTestDatabase {

	private String[] testingSchedule = { "1", "2", "3", "4", "5", "6", "7" };
	
	public static void createTestingShop() {
		Shop shop = ShopDAO.createShop("#test testingShop", 0., 0.);
		Product product = ProductDAO.createProduct("#test testingProduct", 12, "g");
		Stock stock = new Stock();
		stock.addProduct(product, 1);
		shop.setStock(stock);
	}
	
	@Test
	public void test_001_getSchedule() {
		Shop shop = new Shop("#test getSchedule", 0., 0., testingSchedule,  new Stock());
		assertEquals(shop.getSchedule(0), "1");
	}
	
	@Test
	public void test_002_setStock() {
		Shop shop = new Shop("#test setStock", 0., 0., testingSchedule, new Stock());
		Stock stock = new Stock();
		stock.addProduct(new Product("#test testingProduct", 12, "g"), 1);
		shop.setStock(stock);
		assertEquals(shop.getStock().size(), 1);
	}
	
	@Test
	public void test_003_setStockDB() {
		createTestingShop();
		Shop shop = ShopDAO.getShop("#test testingShop");
		assertEquals(shop.getStock().size(), 1);
	}
	

	/*
	@Test
	public void test_0091_updateShopStock() {
		Shop shop = ShopDAO.getShop("#DB Delhaize");

		Arrays.asList(shop.getStock());
		Product p = ProductDAO.getProduct("#DB 6 Apples");
		int quantity = shop.getStock().getQuantity(p);

		shop.getStock().setProduct(p, quantity - 3);
		shop.save();

		ShopDAO.getShop("#DB Delhaize");
		ProductDAO.getProduct("#DB 6 Apples");
	}*/
}
