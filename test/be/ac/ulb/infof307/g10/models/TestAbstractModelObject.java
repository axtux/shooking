package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAbstractModelObject {/*
	TestObject to;
	TestObject same;
	TestObject other;

	@Before
	public void before() {
		to = new TestObject("Coucou petite perruche !");
		same = new TestObject("Coucou petite perruche !");
		other = new TestObject("Other");
	}

	@Test
	public void nullIdTest() {
		Assert.assertNull(to.getId());
	}

	@Test
	public void constructionTest() {
		Assert.assertEquals("Coucou petite perruche !", to.getTest());
	}

	@Test
	public void toStringClassNameTest() {
		String str = to.toString();
		Assert.assertTrue("toString contains class name", str.contains(to.getClass().getSimpleName()));
	}

	@Test
	public void toStringPrivateContentTest() {
		String str = to.toString();
		Assert.assertTrue("toString contains private string atribute content",
				str.contains("Coucou petite perruche !"));
	}

	@Test
	public void toStringPrivateNameTest() {
		String str = to.toString();
		Assert.assertTrue("toString contains private string atribute name", str.contains("test"));
	}

	@Test
	public void equalsSameTest() {
		Assert.assertEquals(same, to);
	}

	@Test
	public void equalsNotSameTest() {
		Assert.assertNotEquals(other, to);
	}

	@Test
	public void hashCodeConsistentTest() {
		int tmp = to.hashCode();
		Assert.assertEquals(tmp, to.hashCode());
	}

	@Test
	public void hashCodeSameTest() {
		Assert.assertEquals(same.hashCode(), to.hashCode());
	}

	/**
	 * Test class to test all methods correctly
	 */
	private class TestObject extends AbstractModelObject {/*
		private static final long serialVersionUID = 1L;
		private String test;

		public TestObject(String test) {
			this.test = test;
		}

		public String getTest() {
			return test;
		}//*/
	}
}
