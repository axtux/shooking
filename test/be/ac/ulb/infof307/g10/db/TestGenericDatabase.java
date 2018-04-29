package be.ac.ulb.infof307.g10.db;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;

public class TestGenericDatabase {

	@BeforeClass
	public static void beforeClass() {
		Database.empty();
	}

	@After
	public void after() {
		Database.empty();
	}

	@Test
	public void recoverAfterError() {
		User.signup("test", "test");
		try {
			User.signup("test", "test");
			assert false;
		} catch(ExistingException e) {
			assert true;
		}
		User.signup("test2", "test2");
	}
}
