package be.ac.ulb.infof307.g10;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ac.ulb.infof307.g10.models.GestionShop;
import be.ac.ulb.infof307.g10.models.Shop;

public class TestShop {

	@Test
	public void testCreateShop() {
		Integer id = 1;
		GestionShop gs = new GestionShop();
		Shop shop = gs.createShop(id);
		assertEquals(shop.getShopId(), id);
	}
	
	@Test
	public void testModifyShop(){
		GestionShop gs = new GestionShop();
		gs.modifyShop(shop);
	}
	
	@Test
	public void testDelShop() {
		Integer id = 1;
		GestionShop gs = new GestionShop();
		gs.delShop(id);
	}

}
