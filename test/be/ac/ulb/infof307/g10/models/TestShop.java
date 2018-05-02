package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Test;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.db.DatabaseTest;

public class TestShop extends DatabaseTest {

	// TODO add more tests
	@Test
	public void createDelete() {
		Shop shop = Shop.create("test1", 0, 0);
		Assert.assertNotNull(shop);
		Database.deleteAll(Shop.class);
	}
	
}
