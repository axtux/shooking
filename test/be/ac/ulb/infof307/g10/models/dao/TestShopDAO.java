package be.ac.ulb.infof307.g10.models.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;
import be.ac.ulb.infof307.g10.models.Shop;
import be.ac.ulb.infof307.g10.models.dao.ShopDAO;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.database.Database;

public class TestShopDAO extends AbstractTestDatabase {

	public static void createTestingShop() {
		ShopDAO.create("#test testingShop", 0., 0., null);
	}
	
	@Test
	public void createShop() {
		Shop s = ShopDAO.create("#test createShop", 0., 0., null);
		assertNotNull(s);
	}
	
	@Test(expected=ExistingException.class)
	public void createShopException() {
		createTestingShop();
		Shop s = ShopDAO.create("#test new shop in same position", 0., 0., null);
		assertNull(s);
	}
	
	@Test
	public void getShop() {
		createTestingShop();
		Shop s = ShopDAO.getByName("#test testingShop");
		assertNotNull(s);
	}
	
	@Test(expected=NonExistingException.class)
	public void getShopException() {
		Shop s = ShopDAO.getByName("#test badShopName");
		assertNull(s);
	}
	
	@Test
	public void autoSaveShopStock() {
		createTestingShop();
		Shop s = ShopDAO.getByName("#test testingShop");
		s.getStock().addQuantity(ProductDAO.create("#test testingProduct", 12, "g"), 1);
		Database.close();
		s = ShopDAO.getByName("#test testingShop");
		assertEquals(s.getStock().size(), 1);
	}
}
