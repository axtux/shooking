package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Test;

public class TestPrice {

	@Test(expected = IllegalArgumentException.class)
	public void negtiveToString() {
		Assert.assertNull(Price.toString(-1));
	}

	@Test
	public void zeroToString() {
		Assert.assertEquals("0,00€", Price.toString(0));
	}

	@Test
	public void leadingZeroToString() {
		Assert.assertEquals("0,01€", Price.toString(1));
	}

	@Test
	public void trailingZeroToString() {
		Assert.assertEquals("0,10€", Price.toString(10));
	}

	@Test
	public void smallToString() {
		Assert.assertEquals("1,99€", Price.toString(199));
	}

	@Test
	public void bigToString() {
		Assert.assertEquals("1234,56€", Price.toString(123456));
	}

}
