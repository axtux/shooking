package be.ac.ulb.infof307.g10.db;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;
import be.ac.ulb.infof307.g10.models.Shop;

public class TestShopDAO extends AbstractTestDatabase {

	public static void createShop() {
		ShopDAO.createShop("#test testingShop", 0., 0.);
	}
	
	@Test
	public void test_001_createShop() {
		Shop s = ShopDAO.createShop("#test createShop", 0., 0.);
		assertNotNull(s);
	}
	
	@Test(expected=ExistingException.class)
	public void test_002_createShopException() {
		ShopDAO.createShop("#test createShop", 0., 0.);
		Shop s = ShopDAO.createShop("#test new shop in same position", 0., 0.);
		assertNull(s);
	}
	
	@Test
	public void test_003_getShop() {
		createShop();
		Shop s = ShopDAO.getShop("#test testingShop");
		assertNotNull(s);
	}
	
	@Test(expected=NonExistingException.class)
	public void test_004_getShopException() {
		Shop s = ShopDAO.getShop("#test badShopName");
		assertNull(s);
	}
}
