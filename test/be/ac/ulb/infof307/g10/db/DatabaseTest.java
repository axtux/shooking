package be.ac.ulb.infof307.g10.db;

import org.junit.Before;
import org.junit.BeforeClass;

/**
 * This class can be extended to run tests on database.
 * A test database will be used to avoid messing with production database.
 * This test database is cleaned before each test to avoid conflict between tests.
 */
public abstract class DatabaseTest {

	@BeforeClass
	public static void beforeClass() {
		// use test database
		Database.setProp("javax.persistence.jdbc.url", "jdbc:h2:./test");
		// turn off logging
		Database.setProp("eclipselink.logging.level", "OFF");
	}

	@Before
	public void before() {
		// clean database
		GenericDatabase.empty();
	}

}
