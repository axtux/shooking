package be.ac.ulb.infof307.g10.db;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.ExistingException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;

public class TestUserDAO extends AbstractTestDatabase {

	public static void createTestingUser() {
		DAO.userSignup("#test testingUser", "very good password");
	}
	
	@Test
	public void test_001_userLogin() {
		User u = DAO.userLogin("#test userLogin", "very good password");
		assertNotNull(u);
	}
	
	@Test(expected=NonExistingException.class)
	public void test_002_userLoginException() {
		createTestingUser();
		User u = DAO.userLogin("#test userLoginException", "very good password");
		assertNull(u);
	}
	
	@Test(expected=IncorrectPasswordException.class)
	public void test_003_userLoginException() {
		createTestingUser();
		User u = DAO.userLogin("#test testingUser", "bas password");
		assertNull(u);
	}
}
