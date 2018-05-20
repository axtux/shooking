package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Test;

public class TestProduct {

	@Test(expected = IllegalArgumentException.class)
	public void nameException() {
		new Product(null, 1, "unit");
	}

	@Test(expected = IllegalArgumentException.class)
	public void zeroSizeException() {
		new Product("name", 0, "unit");
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeSizeException() {
		new Product("name", -1, "unit");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullSizeUnitException() {
		new Product("name", 1, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptySizeUnitException() {
		new Product("name", 1, "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void spaceSizeUnitException() {
		new Product("name", 1, " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void spacesSizeUnitException() {
		new Product("name", 1, "   ");
	}

	@Test
	public void size() {
		Product p = new Product("name", 1, "unit");
		Assert.assertEquals(1, p.getSize());
	}

	@Test
	public void unit() {
		Product p = new Product("name", 1, "unit");
		Assert.assertEquals("unit", p.getSizeUnit());
	}

	@Test
	public void fullName() {
		Product p = new Product("name", 1, "unit");
		Assert.assertEquals("name (1unit)", p.getFullName());
	}
}
