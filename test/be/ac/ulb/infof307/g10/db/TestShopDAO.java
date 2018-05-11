package be.ac.ulb.infof307.g10.db;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.Shop;

public class TestShopDAO {

	@Test
	public void test_004_createShop() {
		Shop s = ShopDAO.createShop("#test createShop", 0., 0.);
		assertNotNull(s);
	}
	
	@Test(expected=ExistingException.class)
	public void test_005_createShop() {
		ShopDAO.createShop("#test createShop", 0., 0.);
		Shop s = ShopDAO.createShop("#test new shop in same position", 0., 0.);
		assertNull(s);
	}
}
