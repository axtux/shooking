package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.db.AbstractTestDatabase;

public class TestShop extends AbstractTestDatabase {

	static private List<Product> pList;
	static private Product p1;
	static private Product p2;
	static private Product p3;
	@BeforeClass
	public static void beforeClass() {
		Stock stock = new Stock();
		String[] schedule = {"","","","","","",""};
		pList = new ArrayList<>();
		p1 = new Product("#test product 1", 1, "g");
		p2 = new Product("#test product 2", 1, "g");
		p3 = new Product("#test product 3", 1, "g");
		p1.save();
		p2.save();
		p3.save();
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		stock.addProduct(p1, 1);
		stock.addProduct(p2, 1);
		stock.addProduct(p3, 1);
		Shop.create("#test Shop with Stock", 0., 0., schedule, stock);
	}
	
	@Test
	public void test_001_createShop() {
		Shop shop = Shop.create("#test createShop", 0, 0);
		assertNotNull(shop);
	}
	
	@Test
	public void test_002_deleteShop() {
		Database.deleteAll(Shop.class);
		assertTrue(Database.getAllShops().isEmpty());
	}
	
	@Test
	public void test_003_getSchedule() {
		String[] testingSchedule = {"1","2","3","4","5","6","7"};
		Shop shop = Shop.create("#test getSchedule", 0.,0., testingSchedule);
		assertEquals(shop.getSchedule(0), "1");
	}
}
