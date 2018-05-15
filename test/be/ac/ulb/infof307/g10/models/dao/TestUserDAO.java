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
		User u = UserDAO.userSignup("test", "test");
		Assert.assertEquals("test", u.getUsername());
	}

	@Test
	public void signupPersistenceTest() {
		User u = UserDAO.userSignup("test", "test");
		Database.close();
		u = UserDAO.getUser("test");
		Assert.assertNotNull(u);
	}

	@Test(expected = ExistingException.class)
	public void signupExistingUserExceptionTest() {
		UserDAO.userSignup("test", "test");
		UserDAO.userSignup("test", "test");
	}

	@Test
	public void loginTest() {
		UserDAO.userSignup("test", "test");
		User u = UserDAO.userLogin("test", "test");
		Assert.assertEquals("test", u.getUsername());
	}

	@Test(expected = IncorrectPasswordException.class)
	public void loginIncorrectPasswordExceptionTest() {
		UserDAO.userSignup("test", "test");
		UserDAO.userLogin("test", "badPassword");
	}

	@Test(expected = NonExistingException.class)
	public void loginNonExistingUserExceptionTest() {
		UserDAO.userLogin("badUser", "anyPassword");
	}

	public static void createTestingUser() {
		UserDAO.userSignup("#test testingUser", "very good password");
	}
	
	@Test
	public void test_001_userLogin() {
		createTestingUser();
		User u = UserDAO.userLogin("#test testingUser", "very good password");
		assertNotNull(u);
	}
	
	@Test(expected=NonExistingException.class)
	public void test_002_userLoginException() {
		User u = UserDAO.userLogin("#test userLoginException", "very good password");
		assertNull(u);
	}
	
	@Test(expected=IncorrectPasswordException.class)
	public void test_003_userLoginException() {
		createTestingUser();
		User u = UserDAO.userLogin("#test testingUser", "bad password");
		assertNull(u);
	}
	
	@Test
	public void test_004_userSignup() {
		User u = UserDAO.userSignup("#test userSignup", "very good password");
		assertNotNull(u);
	}
	
	@Test(expected=ExistingException.class)
	public void test_005_userSignupException() {
		createTestingUser();
		User u = UserDAO.userSignup("#test testingUser", "very good password");
		assertNull(u);
	}
}
