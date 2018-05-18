package be.ac.ulb.infof307.g10.utils;

import org.junit.Assert;
import org.junit.Test;

import javafx.util.StringConverter;

public class TestToStringConverter {

	@Test
	public void objectToString() {
		TestClass tc = new TestClass("Coucou petite perruche !");
		Assert.assertEquals("unexpected", tc.toString());
	}

	@Test
	public void objectToStringWithConverter() {
		TestClass tc = new TestClass("Coucou petite perruche !");
		StringConverter<TestClass> sc = new ToStringConverter<>(TestClass::getTest);
		Assert.assertEquals("Coucou petite perruche !", sc.toString(tc));
	}

	@Test(expected=UnsupportedOperationException.class)
	public void objectFromStringException() {
		StringConverter<TestClass> sc = new ToStringConverter<>(TestClass::getTest);
		sc.fromString("Coucou petite perruche !");
	}

	private class TestClass {
		String test;
		
		public TestClass(String test) {
			this.test = test;
		}
		
		public String getTest() {
			return test;
		}
		
		@Override
		public String toString() {
			return "unexpected";
		}
	}
}
