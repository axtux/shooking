package be.ac.ulb.infof307.g10;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.ShopManagement;
import be.ac.ulb.infof307.g10.models.Product;
import be.ac.ulb.infof307.g10.models.Shop;

public class TestShopManagement {

	static Map<Product, Integer> testingStock;
	static Product pro1;
	static Product pro2;
	static ShopManagement gs;
	
	@BeforeClass
	public static void createShopTest(){
		testingStock = new HashMap<>();
		pro1 = new Product("#test Product 1", "AAA",100, 200, 300, 400, 300);
		pro2 = new Product("#test Product 2", "BBB",100, 200, 300, 400, 320);
        Database.insert(pro1);
        Database.insert(pro2);
		testingStock.put(pro1, 12);
		
		ShopManagement.createShop("#test Get Shop", 0.0, 0.0);
		ShopManagement.createShop("#test Modify Shop Name", 0.0, 0.0);
		ShopManagement.createShop("#test Modify Shop Stock", testingStock, 0.0, 0.0);
		ShopManagement.createShop("#test Modify Shop Set Stock", testingStock, 0.0, 0.0);
		ShopManagement.createShop("#test Modify Shop Schedule", 0.0, 0.0);
		ShopManagement.createShop("#test Modify Shop Position", 0.0, 0.0);
		ShopManagement.createShop("#test Delete Shop Name", 0.0, 0.0);
		ShopManagement.createShop("#test Delete Shop Object", 0.0, 0.0);
	}
	
	@Test
	public void test_0001_GetShop() {
		Shop shop = ShopManagement.getShop("#test Get Shop");
		assertNotNull(shop);
	}
	
	@Test
	public void test_0002_GetShopFail() {
		Shop shop = ShopManagement.getShop("#test This Shop never exist");
		assertNull(shop);
	}

	@Test
	public void test_0003_GetShops() {
		List<Shop> shops = ShopManagement.getShops();
	}
	
	@Test
	public void test_0004_CreateShop() {
		Shop shop1 = ShopManagement.createShop("#test Create Shop", 0.0, 0.0);
		Shop shop2 = ShopManagement.getShop("#test Create Shop");
		assertEquals(shop1, shop2);
	}
	
	@Test
	public void test_0005_CreateShopFail() {
		Shop shop1 = ShopManagement.createShop("#test Create Shop Fail", 0.0, 0.0);
		Shop shop2 = ShopManagement.createShop("#test Create Shop Fail", 12.0, 12.0);
		assertNull(shop2);
	}
	
	@Test
	public void test_0006_CreateShopWithStock() {
		Shop shop1 = ShopManagement.createShop("#test Create Shop With Stock", testingStock, 0.0, 0.0);
		Shop shop2 = ShopManagement.getShop("#test Create Shop with Stock");
		assertEquals(shop1, shop2);
	}
	
	@Test
	public void test_000_ModifyShopName(){
		Shop shop1 = ShopManagement.getShop("#test Modify Shop Name");
		ShopManagement.modifyShopName(shop1, "#test The New Name");
		Shop shop2 = ShopManagement.getShop("#test The New Name");
		Shop shop3 = ShopManagement.getShop("#test Modify Shop Name");
			// Current Shop
		assertEquals(shop1.getName(), "#test The New Name");
			// Shop save in DB
		assertNotNull(shop2);
		assertNull(shop3);
	}
	
	@Test
	public void test_0007_ModifyShopStock() {
		Shop shop = ShopManagement.getShop("#test Modify Shop Stock");
		ShopManagement.modifyShopStock(shop, pro2, 12);
			// Current Shop
		assertEquals(shop.getStock().size(), 2);
			// Shop save in DB
		assertEquals(ShopManagement.getShop("#test Modify Shop Stock").getStock().size(), 2);
	}
	
	@Test
	public void test_0008_ModifyShopSetStock() {
		Shop shop = ShopManagement.getShop("#test Modify Shop Set Stock");
		Map<Product, Integer> productList = new HashMap<>();
		productList.put(pro2, 12000);
		ShopManagement.modifyShopSetStock(shop, productList);
			// Current Shop
		assertEquals(shop.getStock().size(), 1);
			// Shop save in DB
		assertEquals(ShopManagement.getShop("#test Modify Shop Set Stock").getStock().size(), 1);
	}
	
	@Test
	public void test_0009_ModifyShopSchedule() {
		Shop shop1 = ShopManagement.getShop("#test Modify Shop Schedule");
		ShopManagement.modifyShopSchedule(shop1, "8am - 18pm", "CLOSED","","","","","");
		Shop shop2 = ShopManagement.getShop("#test Modify Shop Schedule");
			// Current Shop
		assertEquals(shop1.getSchedule(0), "8am - 18pm");
		assertEquals(shop1.getSchedule(1), "CLOSED");
			// Shop save in DB
		assertEquals(shop2.getSchedule(0), "8am - 18pm");
		assertEquals(shop2.getSchedule(1), "CLOSED");
	}
	
	@Test
	public void test_0010_ModifyShopPosition() {
		Shop shop1 = ShopManagement.getShop("#test Modify Shop Position");
		ShopManagement.modifyShopPosition(shop1, 12.0, 12.0);
		Shop shop2 = ShopManagement.getShop("#test Modify Shop Position");
			// Current Shop
		assertEquals(shop1.getLatitude(), 12.0, 0.1);
		assertEquals(shop1.getLongitude(), 12.0, 0.1);
			// Shop save in DB
		assertEquals(shop2.getLatitude(), 12.0, 0.1);
		assertEquals(shop2.getLongitude(), 12.0, 0.1);
	}
	
	@Test
	public void test_0011_DelShopName() {
		String name = "#test Delete Shop Name";
		Shop shop1 = ShopManagement.getShop(name);
		ShopManagement.delShop(name);
		Shop shop2 = ShopManagement.getShop(name);
		assertNotNull(shop1);
		assertNull(shop2);
	}

	@Test
	public void test_0012_DelShopObject() {
		Shop shop1 = ShopManagement.getShop("#test Delete Shop Object");
		ShopManagement.delShop(shop1);
		Shop shop2 = ShopManagement.getShop("#test Delete Shop Object");
		assertNotNull(shop1);
		assertNull(shop2);
	}
	
	
	@AfterClass
	public static void deleteTestingShop(){
		ShopManagement.delShop("#test Get Shop");
		ShopManagement.delShop("#test Create Shop");
		ShopManagement.delShop("#test Create Shop Fail");
		ShopManagement.delShop("#test Create Shop With Stock");
		ShopManagement.delShop("#test The New Name");
		ShopManagement.delShop("#test Modify Shop Stock");
		ShopManagement.delShop("#test Modify Shop Set Stock");
		ShopManagement.delShop("#test Modify Shop Schedule");
		ShopManagement.delShop("#test Modify Shop Position");
		
		//DatabaseFacade.delete(pro1);
		//DatabaseFacade.delete(pro2);
	}
}
