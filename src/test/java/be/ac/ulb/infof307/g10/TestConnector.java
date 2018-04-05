package be.ac.ulb.infof307.g10;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.Connector;
import be.ac.ulb.infof307.g10.models.Session;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.UserAlreadyExistException;
import be.ac.ulb.infof307.g10.models.exceptions.UserDontExistException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestConnector {
//
	@BeforeClass
	public static void createDBTest() {
		Connector conn = new Connector();
		try {
			conn.createUser("Mr. Test", "SuperPassWord");
		} catch (UserAlreadyExistException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateSession() throws UserAlreadyExistException {
		Connector conn = new Connector();
		Session user = conn.createUser("Best Test", "SuperPassWord");
		assertEquals(user.getUser().getUsername(), "Best Test");
	}

	@Test
	public void testOpenSession() throws IncorrectPasswordException, UserDontExistException {
		Connector conn = new Connector();
		Session user = conn.openSession("Mr. Test", "SuperPassWord");
		assertEquals(user.getUser().getUsername(), "Mr. Test");
	}

	@Test(expected = IncorrectPasswordException.class)
	public void testCannotOpenSession() throws IncorrectPasswordException, UserDontExistException {
		Connector conn = new Connector();
		Session user = conn.openSession("Mr. Test", "BadPassword");
	}

	@Test(expected = UserDontExistException.class)
	public void testUserDontExist() throws IncorrectPasswordException, UserDontExistException {
		Connector conn = new Connector();
		Session user = conn.openSession("BAdUser", "BadPassword");
	}
	
	@Test(expected = UserAlreadyExistException.class)
	public void testUserAlreadyExist() throws UserAlreadyExistException {
		Connector conn = new Connector();
		Session user1 = conn.createUser("Dupont", "Tintin");
		Session user2 = conn.createUser("Dupont", "Hadock");
	}

	@Test
	public void testDestroyUser() throws UserAlreadyExistException, IncorrectPasswordException {
		Connector conn = new Connector();
		Session user = conn.createUser("badUser", "badPassWord");
		assertTrue(conn.destroyUser("badUser", "badPassWord"));
	}

	@Test(expected = IncorrectPasswordException.class)
	public void testCannotDestroyUser() throws UserAlreadyExistException, IncorrectPasswordException {
		Connector conn = new Connector();
		Session user = conn.createUser("GoodUser", "GoodPassword");
		assertFalse(conn.destroyUser("GoodUser", "BadPassword"));
	}

	//TODO test sha256

	@AfterClass
	public static void destroyDB() throws IncorrectPasswordException {
		Connector conn = new Connector();
		conn.destroyUser("Mr. Test", "SuperPassWord");
		conn.destroyUser("Best Test", "SuperPassWord");
		conn.destroyUser("Dupont", "Tintin");
		conn.destroyUser("GoodUser", "GoodPassword");
	}

}
