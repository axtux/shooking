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
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;

public class TestShop extends AbstractTestDatabase {

	@Test
	public void test_001_createShop() {
		Shop shop = Shop.create("#test createShop", 0, 0);
		assertNotNull(shop);
	}

	@Test(expected = ExistingException.class)
	public void test_002_createShopException() {
		Shop.create("#test create shop exception 1", 0., 0.);
		Shop.create("#test create shop exception 2", 0., 0.);
	}

	@Test
	public void test_003_deleteShop() {
		Database.deleteAll(Shop.class);
		assertTrue(Database.getAllShops().isEmpty());
	}

	@Test
	public void test_004_getSchedule() {
		String[] testingSchedule = { "1", "2", "3", "4", "5", "6", "7" };
		Shop shop = Shop.create("#test getSchedule", 0., 0., testingSchedule);
		assertEquals(shop.getSchedule(0), "1");
	}
}
