package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPrice {

	@Test
	public void test_001_toString() {
		String price = Price.toString(199);
		assertEquals(price, "1,99€");
	}

}
