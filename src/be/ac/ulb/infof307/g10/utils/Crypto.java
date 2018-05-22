package be.ac.ulb.infof307.g10.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Some cryptography utility functions.
 */
final public class Crypto {

	/**
	 * Avoid object creation
	 */
	private Crypto() {
	}

	/**
	 * SHA-256
	 * 
	 * @param str
	 *            String to hash
	 * @return Lower case hexadecimal hash
	 */
	public static String sha256(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
			return bytesToHex(hash);
		} catch (NoSuchAlgorithmException e) {
			/**
			 * This exception never happens because "SHA-256" is required by JVM
			 * implementation see
			 * https://docs.oracle.com/javase/8/docs/api/java/security/MessageDigest.html
			 */
			throw new RuntimeException(e);
		}
	}

	public static String bytesToHex(byte[] in) {
		StringBuilder builder = new StringBuilder();
		for (byte b : in)
			builder.append(String.format("%02x", b));
		return builder.toString();
	}

	/**
	 * Generate random string.
	 * 
	 * @param length
	 *            Length of string to generate.
	 * @return Generated String
	 */
	public static String generateSalt(int length) {
		Random rand = new Random();

		StringBuilder salt = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int n = rand.nextInt(256);
			salt.append((char) n);
		}
		return salt.toString();
	}
}
