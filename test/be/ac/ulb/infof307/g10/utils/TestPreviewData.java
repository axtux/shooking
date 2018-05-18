package be.ac.ulb.infof307.g10.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.database.Database;

public class TestPreviewData {

	@BeforeClass
	public static void beforeClass() {
		// use test database
		Database.setProp("name", "GL10PU");
		// use test database
		Database.setProp("javax.persistence.jdbc.url", "jdbc:h2:./test");
		// turn off logging
		Database.setProp("eclipselink.logging.level", "OFF");
	}
	
	@Before
	public void before() {
		Database.empty();
	}

	@Test
	public void databaseNotEmptyAfterPreviewDataAdded() {
		PreviewData.main(null);
		Assert.assertFalse(Database.isEmpty());
	}

}
