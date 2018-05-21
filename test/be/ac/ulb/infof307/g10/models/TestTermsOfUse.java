package be.ac.ulb.infof307.g10.models;

import org.junit.Assert;
import org.junit.Test;

public class TestTermsOfUse {

	@Test
	public void stringNotNull() {
		String tou = TermsOfUse.get();
		Assert.assertNotNull(tou);
	}
}
