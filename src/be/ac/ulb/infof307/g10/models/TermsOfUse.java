package be.ac.ulb.infof307.g10.models;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Manage terms of use of the application.
 */
final public class TermsOfUse {

	/**
	 * Avoid object creation
	 */
	private TermsOfUse() {
	}

	/**
	 *
	 * @return terms of use
	 */
	public static String get() {
		InputStream in = TermsOfUse.class.getResourceAsStream("/termsOfUse.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		return reader.lines().collect(Collectors.joining("\n"));
	}
}
