package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Test;

public class TestShop {

	// TODO add more tests
	@Test
	public void create() {
		Shop shop = Shop.create("test1", 0, 0);
		Assert.assertNotNull(shop);
	}
	
}
