package be.ac.ulb.infof307.g10.db;

/**
 * Adding some queries to GenericDatabase to meet the need of our custom
 * objects. Abstract because contains only static methods.
 */
public class Database extends GenericDatabase {

	public static void init() {
		setProp("name", "GL10PU");
		if (isEmpty()) {
			Data.fillDB();
		}
	}
}
