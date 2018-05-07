package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.db.AbstractTestDatabase;

public class TestShop extends AbstractTestDatabase {

	public List<Product> pList;
	public Product p1;
	public Product p2;
	public Product p3;
	@Before
	public void creation() {
		Stock stock = new Stock();
		pList = new ArrayList<>();
		String[] schedule = {"","","","","","",""};
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
	
	@Test
	public void test_004_getWithProducts() {
		List<Product> badList1 = new ArrayList<>();
		List<Product> badList2 = new ArrayList<>();
			//badList1 have only product not in shop stock
		badList1.add(new Product("#test bad product 1", 1, "g"));
			//badList2 have some product in shop stock and some product not in shop stock
		badList2.add(p1);
		badList2.add(new Product("#test bad product 1", 1, "g"));
		assertTrue(Shop.getWithProducts(badList1).isEmpty());
		//assertTrue(Shop.getWithProducts(badList2).isEmpty());
		assertFalse(Shop.getWithProducts(pList).isEmpty());
	}
	
	@Test
	public void test_005_getWithProduct() {
		Product p = new Product("#test Bad product", 1, "g");
		assertFalse(Shop.getWithProduct(p1).isEmpty());
		assertTrue(Shop.getWithProduct(p).isEmpty());
	}
}
