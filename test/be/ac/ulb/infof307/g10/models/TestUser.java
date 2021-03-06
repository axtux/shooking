package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.exceptions.EmptyPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.IncorrectPasswordException;
import be.ac.ulb.infof307.g10.models.exceptions.PasswordsDoNotMatchException;

public class TestUser {

	@Test
	public void username() {
		User user = new User("username", "password");
		Assert.assertEquals("username", user.getName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nameException() {
		new User(null, "password");
	}

	@Test(expected = EmptyPasswordException.class)
	public void nullPassword() {
		new User("username", null);
	}

	@Test(expected = EmptyPasswordException.class)
	public void emptyPassword() {
		new User("username", "");
	}

	@Test(expected = EmptyPasswordException.class)
	public void spacePassword() {
		new User("username", "  ");
	}

	@Test(expected = PasswordsDoNotMatchException.class)
	public void noMatchPassword() {
		new User("username", "one_pwd", "other_pwd");
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

	@Test(expected = EmptyPasswordException.class)
	public void setNullPassword() {
		User user = new User("username", "password");
		user.setPassword(null);
	}

	@Test(expected = EmptyPasswordException.class)
	public void setEmptyPassword() {
		User user = new User("username", "password");
		user.setPassword("");
	}

	@Test(expected = EmptyPasswordException.class)
	public void setSpacePassword() {
		User user = new User("username", "password");
		user.setPassword("  ");
	}

	@Test
	public void shoppingListsNotNull() {
		User user = new User("username", "password");
		Assert.assertNotNull(user.getShoppingLists());
	}

	@Test
	public void addShoppingList() {
		User user = new User("username", "password");
		Assert.assertEquals(user.getShoppingLists().size(),0);
		user.addShoppingList(new ShoppingList("test"));
		Assert.assertEquals(user.getShoppingLists().size(),1);
	}

}
