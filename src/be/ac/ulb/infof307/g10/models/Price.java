package be.ac.ulb.infof307.g10.models;

public class Price {
	public static String toString(int price) {
		String cents = Integer.toString(price % 100);
		if (cents.length() == 1) {
			cents = "0" + cents;
		}
		return Integer.toString(price / 100) + "," + cents + "€";
	}
}
