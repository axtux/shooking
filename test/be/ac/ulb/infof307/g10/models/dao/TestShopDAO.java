package be.ac.ulb.infof307.g10.models.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.dao.ShopDAO;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;

public class TestShopDAO extends AbstractTestDatabase {

	public static void createShop() {
		ShopDAO.create("#test testingShop", 0., 0., null);
	}
	
	@Test
	public void test_001_createShop() {
		Shop s = ShopDAO.create("#test createShop", 0., 0., null);
		assertNotNull(s);
	}
	
	@Test(expected=ExistingException.class)
	public void test_002_createShopException() {
		createShop();
		Shop s = ShopDAO.create("#test new shop in same position", 0., 0., null);
		assertNull(s);
	}
	
	@Test
	public void test_003_getShop() {
		createShop();
		Shop s = ShopDAO.getByName("#test testingShop");
		assertNotNull(s);
	}
	
	@Test(expected=NonExistingException.class)
	public void test_004_getShopException() {
		Shop s = ShopDAO.getByName("#test badShopName");
		assertNull(s);
	}
}
