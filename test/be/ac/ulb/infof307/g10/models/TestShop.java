package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Test;

import be.ac.ulb.infof307.g10.db.Database;

public class TestShop {

	// TODO add more tests
	@Test
	public void createDelete() {
		Shop shop = Shop.create("test1", 0, 0);
		Assert.assertNotNull(shop);
		Database.deleteAll(Shop.class);
	}
	
}
