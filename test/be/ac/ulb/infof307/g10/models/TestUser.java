package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;

public class TestUser {

	@Test
	public void username() {
		User user = new User("username", "password");
		Assert.assertEquals("username", user.getUsername());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullUsername() {
		new User(null, "password");
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyUsername() {
		new User("", "password");
	}

	@Test(expected = IllegalArgumentException.class)
	public void spaceUsername() {
		new User("  ", "password");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullPassword() {
		new User("username", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyPassword() {
		new User("username", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void spacePassword() {
		new User("username", "  ");
	}

	@Test
	public void checkPassword() {
		User user = new User("username", "password");
		// generate exception if incorrect password
		user.checkPassword("password");
	}

	@Test(expected = IncorrectPasswordException.class)
	public void checkPasswordException() {
		User user = new User("username", "password");
		// generate exception if incorrect password
		user.checkPassword("wrong");
	}

	@Test
	public void setPassword() {
		User user = new User("username", "password");
		user.setPassword("newPassword");
		// generate exception if incorrect password
		user.checkPassword("newPassword");
	}

	@Test(expected = IllegalArgumentException.class)
	public void setNullPassword() {
		User user = new User("username", "password");
		user.setPassword(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setEmptyPassword() {
		User user = new User("username", "password");
		user.setPassword("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void setSpacePassword() {
		User user = new User("username", "password");
		user.setPassword("  ");
	}

	@Test
	public void shoppingListNotNull() {
		User user = new User("username", "password");
		Assert.assertNotNull(user.getShoppingList());
	}

}
