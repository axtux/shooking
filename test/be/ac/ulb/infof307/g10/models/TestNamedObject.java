package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNamedObject {

	private NamedObject no;

	@Before
	public void before() {
		no = new NamedObject("test");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullNameException() {
		no = new NamedObject(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyNameException() {
		no = new NamedObject("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void spaceNameException() {
		no = new NamedObject(" ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void spacesNameException() {
		no = new NamedObject("   ");
	}

	@Test
	public void getName() {
		Assert.assertEquals("test", no.getName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullSetNameException() {
		no.setName(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptySetNameException() {
		no.setName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void spaceSetNameException() {
		no.setName(" ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void spacesSetNameException() {
		no.setName("   ");
	}

}
