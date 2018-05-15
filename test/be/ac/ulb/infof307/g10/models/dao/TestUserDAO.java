package be.ac.ulb.infof307.g10.models.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import be.ac.ulb.infof307.g10.db.AbstractTestDatabase;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.dao.UserDAO;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class TestUserDAO extends AbstractTestDatabase {

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
