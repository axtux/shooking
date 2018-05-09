package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Test;

public class TestPrice {

	@Test
	public void test_001_1toString() {
		Assert.assertEquals("0,01€", Price.toString(1));
	}

	@Test
	public void test_001_10toString() {
		Assert.assertEquals("0,10€", Price.toString(10));
	}

	@Test
	public void test_001_199toString() {
		Assert.assertEquals("1,99€", Price.toString(199));
	}

}
