package be.ac.ulb.infof307.g10.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g10.db.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.db.ShopDAO;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;

public class TestShop extends AbstractTestDatabase {

	@Test
	public void test_001_getSchedule() {
		String[] testingSchedule = { "1", "2", "3", "4", "5", "6", "7" };
		Shop shop = new Shop("#test getSchedule", 0., 0., testingSchedule,  new Stock());
		assertEquals(shop.getSchedule(0), "1");
	}
}
