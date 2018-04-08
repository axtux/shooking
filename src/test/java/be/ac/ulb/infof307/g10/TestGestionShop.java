package be.ac.ulb.infof307.g10;

import static org.junit.Assert.*;

import java.util.HashMap;
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
		
		gs.createShop("The Best Shopper");
		gs.createShop("The Best Shop", testingStock);
		gs.createShop("Shopshop");
		gs.createShop("Shoppy");
	}
	
	@Test
	public void testCreateShop() {
		Shop shop1 = gs.createShop("Testing Shop");
		Shop shop2 = gs.getShop("Testing Shop");
		assertEquals(shop1.getId(), shop2.getId());
	}
	
	@Test
	public void testCreateShopWithStock() {
		Shop shop1 = gs.createShop("RestoU", testingStock);
		Shop shop2 = gs.getShop("RestoU");
		assertEquals(shop1.getId(), shop2.getId());
	}
	
	@Test
	public void testModifyShopName(){
		Shop shop = gs.getShop("The Best Shopper");
		gs.modifyShop(shop, "Shopping Cora HORNU", null);
		assertEquals(shop.getName(), "Shopping Cora HORNU");
	}
	
	@Test
	public void testModifyShopStock() {
		Shop shop = gs.getShop("The Best Shop");
		Map<Product, Integer> productList = new HashMap<>();
		productList.put(pro2, 12000);
		gs.modifyShop(shop, null, productList);
		assertTrue(gs.getShop("The Best Shop").getStock().size() == 2);
	}
	
	@Test
	public void testModifyShopSetStock() {
		Shop shop = gs.getShop("The Best Shop");
		Map<Product, Integer> productList = new HashMap<>();
		productList.put(pro2, 12000);
		gs.modifyShop(shop, null, productList, true);
		assertTrue(gs.getShop("The Best Shop").getStock().size() == 1);
		
	}
	
	@Test(expected = NoResultException.class)
	public void testDelShopName() {
		String name = "Shopshop";
		gs.delShop(name);
		gs.getShop(name);
	}

	@Test(expected = NoResultException.class)
	public void testDelShopObject() {
		Shop shop = gs.getShop("Shoppy");
		gs.delShop(shop);
		gs.getShop("Shoppy");
	}
	@AfterClass
	public static void deleteTestingShop(){
		gs.delShop("The Best Shop");
		gs.delShop("Shopping Cora HORNU");
		gs.delShop("RestoU");
		gs.delShop("Testing Shop");
	}
}
