package be.ac.ulb.infof307.g10.utils;

import org.junit.Assert;
import org.junit.Test;

public class TestCrypto {
	@Test
	public void emptySha256() {
		String hex = Crypto.sha256("");
		Assert.assertEquals("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", hex);
	}

	@Test
	public void longSha256() {
		String hex = Crypto.sha256("Coucou petite perruche !");
		Assert.assertEquals("928997003ebf4082844abb4216f5301354b09dcf40e146bb3e03a6da800434fd", hex);
	}

	@Test
	public void emptyBytesToHex() {
		byte[] bytes = {};
		String hex = Crypto.bytesToHex(bytes);
		Assert.assertEquals("", hex);
	}

	@Test
	public void longBytesToHex() {
		byte[] bytes = { 0x64, 0x65, 0x66 };
		String hex = Crypto.bytesToHex(bytes);
		Assert.assertEquals("646566", hex);
	}

	@Test
	public void saltLength() {
		String salt = Crypto.generateSalt(5);
		Assert.assertEquals(5, salt.length());
	}

	@Test
	public void saltNotNull() {
		Assert.assertNotNull(Crypto.generateSalt(5));
	}

	@Test
	public void twoSaltsNotEquals() {
		Assert.assertNotEquals(Crypto.generateSalt(5), Crypto.generateSalt(5));
	}

}
