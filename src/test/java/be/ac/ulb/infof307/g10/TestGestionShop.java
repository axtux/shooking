package be.ac.ulb.infof307.g10;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g10.db.DatabaseFacade;
import be.ac.ulb.infof307.g10.models.GestionShop;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;

public class TestGestionShop {

	static Map<Product, Integer> testingStock;
	static Product pro1;
	static Product pro2;
	static GestionShop gs;
	
	@BeforeClass
	public static void createShopTest(){
		testingStock = new HashMap<>();
		pro1 = DatabaseFacade.getProduct("Farine d'avoine", "Delhaize");
		pro2 = DatabaseFacade.getProduct("pain", "Carrefour");
		testingStock.put(pro1, 12);
		gs = new GestionShop();
		
		gs.createShop("#test Get Shop", 0.0, 0.0);
		gs.createShop("#test Modify Shop Name", 0.0, 0.0);
		gs.createShop("#test Modify Shop Stock", testingStock, 0.0, 0.0);
		gs.createShop("#test Modify Shop Set Stock", testingStock, 0.0, 0.0);
		gs.createShop("#test Modify Shop Schedule", 0.0, 0.0);
		gs.createShop("#test Modify Shop Position", 0.0, 0.0);
		gs.createShop("#test Delete Shop Name", 0.0, 0.0);
		gs.createShop("#test Delete Shop Object", 0.0, 0.0);
	}
	
	@Test
	public void testGetShop() {
		Shop shop = gs.getShop("#test Get Shop");
		assertNotNull(shop);
	}
	
	@Test
	public void testGetShopFail() {
		Shop shop = gs.getShop("#test This Shop never exist");
		assertNull(shop);
	}

	@Test
	public void testGetShops() {
		List<Shop> shops = gs.getShops();
	}
	
	@Test
	public void testCreateShop() {
		Shop shop1 = gs.createShop("#test Create Shop", 0.0, 0.0);
		Shop shop2 = gs.getShop("#test Create Shop");
		assertEquals(shop1, shop2);
	}
	
	@Test
	public void testCreateShopFail() {
		Shop shop1 = gs.createShop("#test Create Shop Fail", 0.0, 0.0);
		Shop shop2 = gs.createShop("#test Create Shop Fail", 12.0, 12.0);
		assertNull(shop2);
	}
	
	@Test
	public void testCreateShopWithStock() {
		Shop shop1 = gs.createShop("#test Create Shop With Stock", testingStock, 0.0, 0.0);
		Shop shop2 = gs.getShop("#test Create Shop with Stock");
		assertEquals(shop1, shop2);
	}
	
	@Test
	public void testModifyShopName(){
		Shop shop1 = gs.getShop("#test Modify Shop Name");
		gs.modifyShopName(shop1, "#test The New Name");
		Shop shop2 = gs.getShop("#test The New Name");
		Shop shop3 = gs.getShop("#test Modify Shop Name");
			// Current Shop
		assertEquals(shop1.getName(), "#test The New Name");
			// Shop save in DB
		assertNotNull(shop2);
		assertNull(shop3);
	}
	
	@Test
	public void testModifyShopStock() {
		Shop shop = gs.getShop("#test Modify Shop Stock");
		gs.modifyShopStock(shop, pro2, 12);
			// Current Shop
		assertEquals(shop.getStock().size(), 2);
			// Shop save in DB
		assertEquals(gs.getShop("#test Modify Shop Stock").getStock().size(), 2);
	}
	
	@Test
	public void testModifyShopSetStock() {
		Shop shop = gs.getShop("#test Modify Shop Set Stock");
		Map<Product, Integer> productList = new HashMap<>();
		productList.put(pro2, 12000);
		gs.modifyShopSetStock(shop, productList);
			// Current Shop
		assertEquals(shop.getStock().size(), 1);
			// Shop save in DB
		assertEquals(gs.getShop("#test Modify Shop Set Stock").getStock().size(), 1);
	}
	
	@Test
	public void testModifyShopSchedule() {
		Shop shop1 = gs.getShop("#test Modify Shop Schedule");
		gs.modifyShopSchedule(shop1, "8am - 18pm", "CLOSED","","","","","");
		Shop shop2 = gs.getShop("#test Modify Shop Schedule");
			// Current Shop
		assertEquals(shop1.getMondayTime(), "8am - 18pm");
		assertEquals(shop1.getTuesdayTime(), "CLOSED");
			// Shop save in DB
		assertEquals(shop2.getMondayTime(), "8am - 18pm");
		assertEquals(shop2.getTuesdayTime(), "CLOSED");
	}
	
	@Test
	public void testModifyShopPosition() {
		Shop shop1 = gs.getShop("#test Modify Shop Position");
		gs.modifyShopPosition(shop1, 12.0, 12.0);
		Shop shop2 = gs.getShop("#test Modify Shop Position");
			// Current Shop
		assertEquals(shop1.getLatitude(), 12.0, 0.1);
		assertEquals(shop1.getLongitude(), 12.0, 0.1);
			// Shop save in DB
		assertEquals(shop2.getLatitude(), 12.0, 0.1);
		assertEquals(shop2.getLongitude(), 12.0, 0.1);
	}
	
	@Test
	public void testDelShopName() {
		String name = "#test Delete Shop Name";
		Shop shop1 = gs.getShop(name);
		gs.delShop(name);
		Shop shop2 = gs.getShop(name);
		assertNotNull(shop1);
		assertNull(shop2);
	}

	@Test
	public void testDelShopObject() {
		Shop shop1 = gs.getShop("#test Delete Shop Object");
		gs.delShop(shop1);
		Shop shop2 = gs.getShop("#test Delete Shop Object");
		assertNotNull(shop1);
		assertNull(shop2);
	}
	
	
	@AfterClass
	public static void deleteTestingShop(){
		gs.delShop("#test Get Shop");
		gs.delShop("#test Create Shop");
		gs.delShop("#test Create Shop Fail");
		gs.delShop("#test Create Shop With Stock");
		gs.delShop("#test The New Name");
		gs.delShop("#test Modify Shop Stock");
		gs.delShop("#test Modify Shop Set Stock");
		gs.delShop("#test Modify Shop Schedule");
		gs.delShop("#test Modify Shop Position");
	}
}
