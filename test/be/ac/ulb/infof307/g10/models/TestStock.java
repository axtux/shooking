package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStock {

	static private Stock stock;
	static private Product p;
	@BeforeClass
	public static void beforeClass() {
		stock = new Stock();
		p = new Product("#test Product test", 1, "g");
		stock.addProduct(p, 5, 10);
	}
	
	@Before
	public void before() {
		stock.setProduct(p, 5, 10);
	}
	
	@Test
	public void test_001_getPrice() {
		assertEquals(stock.getPrice(p), 10);
		assertEquals(stock.getPrice(p, 5), 50);
		assertEquals(stock.getPrice(p, 9), 0);
	}
	
	@Test
	public void test_002_setPrice() {
		stock.setPrice(p, 12);
		assertEquals(stock.getPrice(p), 12);
	}
	
	@Test
	public void test_003_setProduct() {
		stock.setProduct(p, 12);
		stock.setProduct(p, 12, 25);
		assertEquals(stock.getQuantity(p), 12);
		assertEquals(stock.getPrice(p), 25);
	}

}
