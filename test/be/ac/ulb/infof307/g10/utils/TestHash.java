package be.ac.ulb.infof307.g10.utils;

import org.junit.Assert;
import org.junit.Test;

public class TestHash {
	@Test
	public void testEmptySha256() {
		String hex = Hash.sha256("");
		Assert.assertEquals("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", hex);
	}

	@Test
	public void testLongSha256() {
		String hex = Hash.sha256("Coucou petite perruche !");
		Assert.assertEquals("928997003ebf4082844abb4216f5301354b09dcf40e146bb3e03a6da800434fd", hex);
	}

	@Test
	public void testEmptyBytesToHex() {
		byte[] bytes = {};
		String hex = Hash.bytesToHex(bytes);
		Assert.assertEquals("", hex);
	}

	@Test
	public void testLongBytesToHex() {
		byte[] bytes = { 0x65, 0x65, 0x65 };
		String hex = Hash.bytesToHex(bytes);
		Assert.assertEquals("656565", hex);
	}
}
