package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.models.Connector;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.UserAlreadyExistException;
import be.ac.ulb.infof307.g10.models.exceptions.UserDoesNotExistException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Some tests of this class do not have asserts beacause an exception make the test fail when it has to
 */
public class TestConnector {
//
	@BeforeClass
	public static void createDBTest() {
		try {
            Connector conn = new Connector();
			conn.createUser("Mr. Test", "SuperPassWord");
		} catch (UserAlreadyExistException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_0001_CreateSession() throws UserAlreadyExistException {
		Connector conn = new Connector();
		User user = conn.createUser("Best Test", "SuperPassWord");
		assertEquals(user.getUsername(), "Best Test");
	}

	@Test
	public void test_0002_OpenSession() throws IncorrectPasswordException, UserDoesNotExistException {
		Connector conn = new Connector();
		User user = conn.openSession("Mr. Test", "SuperPassWord");
		assertEquals(user.getUsername(), "Mr. Test");
	}

	@Test(expected = IncorrectPasswordException.class)
	public void test_0003_CannotOpenSession() throws IncorrectPasswordException, UserDoesNotExistException {
		Connector conn = new Connector();
		conn.openSession("Mr. Test", "BadPassword");
	}

	@Test(expected = UserDoesNotExistException.class)
	public void test_0004_UserDontExist() throws IncorrectPasswordException, UserDoesNotExistException {
		Connector conn = new Connector();
		User user = conn.openSession("BAdUser", "BadPassword");
	}
	
	@Test(expected = UserAlreadyExistException.class)
	public void test_0005_UserAlreadyExist() throws UserAlreadyExistException {
		Connector conn = new Connector();
		conn.createUser("Dupont", "Tintin");
		conn.createUser("Dupont", "Hadock");
	}

	@Test
	public void test_0006_DestroyUser() throws UserAlreadyExistException, IncorrectPasswordException {
		Connector conn = new Connector();
		conn.createUser("badUser", "badPassWord");
		conn.destroyUser("badUser", "badPassWord");
	}

	@Test(expected = IncorrectPasswordException.class)
	public void test_0007_CannotDestroyUser() throws UserAlreadyExistException, IncorrectPasswordException {
		Connector conn = new Connector();
		conn.createUser("GoodUser", "GoodPassword");
		conn.destroyUser("GoodUser", "BadPassword");
	}


	@AfterClass
	public static void destroyDB() throws IncorrectPasswordException {
		Connector conn = new Connector();
		conn.destroyUser("Mr. Test", "SuperPassWord");
		conn.destroyUser("Best Test", "SuperPassWord");
		conn.destroyUser("Dupont", "Tintin");
		conn.destroyUser("GoodUser", "GoodPassword");
	}

}
