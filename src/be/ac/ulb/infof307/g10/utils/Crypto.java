package be.ac.ulb.infof307.g10.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Crypto {
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
			// this exception never happens because "SHA-256" is required by
			// implementation
			// see
			// https://docs.oracle.com/javase/8/docs/api/java/security/MessageDigest.html
			throw new RuntimeException(e);
		}
	}

	public static String bytesToHex(byte[] in) {
		StringBuilder builder = new StringBuilder();
		for (byte b : in)
			builder.append(String.format("%02x", b));
		return builder.toString();
	}


	public static String generateSalt(){
		Random rand = new Random();

		String salt = "";
		for (int i = 0 ; i < 15 ; i++){
			int n = rand.nextInt(256);
			salt += (char)n;
		}
		return salt;
	}
}
