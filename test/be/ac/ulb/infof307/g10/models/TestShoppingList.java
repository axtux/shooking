package be.ac.ulb.infof307.g10.models;

import org.junit.Test;

public class TestShoppingList {

	@Test(expected = IllegalArgumentException.class)
	public void nameException() {
		new ShoppingList(null);
	}

}
