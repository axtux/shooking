package be.ac.ulb.infof307.g10.models;

/**
 * Manage price as an integer. Currently only contains toString method.
 */
final public class Price {

	/**
	 * Avoid object creation
	 */
	private Price() {
	}

	public static String toString(int price) {
		if (price < 0) {
			throw new IllegalArgumentException("price must be >= 0");
		}
		String cents = Integer.toString(price % 100);
		if (cents.length() == 1) {
			cents = "0" + cents;
		}
		return Integer.toString(price / 100) + "," + cents + "€";
	}
}
