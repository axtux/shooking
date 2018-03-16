package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.Exception.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.Exception.UserAlreadyExistException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSession {
//
//	@BeforeClass
//	public static void createDBTest() {
//		Connector conn = new Connector();
//		try {
//			conn.createUser("Mr. Test", "SuperPassWord");
//		} catch (UserAlreadyExistException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testCreateSession() throws UserAlreadyExistException {
//		Connector conn = new Connector();
//		Session user = conn.createUser("Best Test", "SuperPassWord");
//		assertEquals(user.getUserName(), "Best Test");
//	}
//
//	@Test
//	public void testOpenSession() throws IncorrectPasswordException {
//		Connector conn = new Connector();
//		Session user = conn.openSession("Mr. Test", "SuperPassWord");
//		assertEquals(user.getUserName(), "Mr. Test");
//	}
//
//	@Test(expected = IncorrectPasswordException.class)
//	public void testCannotOpenSession() throws IncorrectPasswordException {
//		Connector conn = new Connector();
//		Session user = conn.openSession("Mr. Test", "BadPassword");
//	}
//
//	@Test(expected = UserAlreadyExistException.class)
//	public void testUserAlreadyExist() throws UserAlreadyExistException {
//		Connector conn = new Connector();
//		Session user1 = conn.createUser("Dupont", "Tintin");
//		Session user2 = conn.createUser("Dupont", "Hadock");
//	}
//
//	@Test
//	public void testDestroyUser() throws UserAlreadyExistException, IncorrectPasswordException {
//		Connector conn = new Connector();
//		Session user = conn.createUser("badUser", "badPassWord");
//		assertTrue(conn.destroyUser("badUser", "badPassWord"));
//	}
//
//	@Test(expected = IncorrectPasswordException.class)
//	public void testCannotDestroyUser() throws UserAlreadyExistException, IncorrectPasswordException {
//		Connector conn = new Connector();
//		Session user = conn.createUser("GoodUser", "GoodPassword");
//		conn.destroyUser("GoodUser", "BadPassword");
//	}
//
//	//TODO test sha256
//
//	@AfterClass
//	public static void destroyDB() throws IncorrectPasswordException {
//		Connector conn = new Connector();
//		conn.destroyUser("Mr. Test", "SuperPassWord");
//		conn.destroyUser("Best Test", "SuperPassWord");
//		conn.destroyUser("Dupont", "Tintin");
//		conn.destroyUser("GoodUser", "GoodPassword");
//	}

}
