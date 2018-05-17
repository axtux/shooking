package be.ac.ulb.infof307.g10.models.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.dao.UserDAO;
import be.ac.ulb.infof307.g10.models.database.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.database.Database;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class TestUserDAO extends AbstractTestDatabase {

	@Test
	public void signupTest() {
		User u = UserDAO.create("test", "test");
		Assert.assertEquals("test", u.getUsername());
	}

	@Test
	public void signupPersistenceTest() {
		User u = UserDAO.create("test", "test");
		Database.close();
		u = UserDAO.getByUsername("test");
		Assert.assertNotNull(u);
	}

	@Test(expected = ExistingException.class)
	public void signupExistingUserExceptionTest() {
		UserDAO.create("test", "test");
		UserDAO.create("test", "test");
	}

	@Test
	public void loginTest() {
		UserDAO.create("test", "test");
		User u = UserDAO.login("test", "test");
		Assert.assertEquals("test", u.getUsername());
	}

	@Test(expected = IncorrectPasswordException.class)
	public void loginIncorrectPasswordExceptionTest() {
		UserDAO.create("test", "test");
		UserDAO.login("test", "badPassword");
	}

	@Test(expected = NonExistingException.class)
	public void loginNonExistingUserExceptionTest() {
		UserDAO.login("badUser", "anyPassword");
	}

	public static void createTestingUser() {
		UserDAO.create("#test testingUser", "very good password");
	}
	
	@Test
	public void test_001_userLogin() {
		createTestingUser();
		User u = UserDAO.login("#test testingUser", "very good password");
		assertNotNull(u);
	}
	
	@Test(expected=NonExistingException.class)
	public void test_002_userLoginException() {
		User u = UserDAO.login("#test userLoginException", "very good password");
		assertNull(u);
	}
	
	@Test(expected=IncorrectPasswordException.class)
	public void test_003_userLoginException() {
		createTestingUser();
		User u = UserDAO.login("#test testingUser", "bad password");
		assertNull(u);
	}
	
	@Test
	public void test_004_userSignup() {
		User u = UserDAO.create("#test userSignup", "very good password");
		assertNotNull(u);
	}
	
	@Test(expected=ExistingException.class)
	public void test_005_userSignupException() {
		createTestingUser();
		User u = UserDAO.create("#test testingUser", "very good password");
		assertNull(u);
	}
}
