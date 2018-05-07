package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPrice {

	@Test
	public void test_001_toString() {
		String price1 = Price.toString(199);
		String price2 = Price.toString(1);
		String price3 = Price.toString(10);
		assertEquals(price1, "1,99€");
		assertEquals(price2, "0,01€");
		assertEquals(price3, "0,10€");
	}

}
