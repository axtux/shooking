package be.ac.ulb.infof307.g10.views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

/**
 * Enumeration of views available within application. Each entry contains an
 * FXML file within FXML resource directory. The filename is CamelCase entry
 * name. Some methods let you deal with those views.
 */
public enum View {
	CREATE_USER,
	CREATE_PRODUCT,
	CREATE_RECIPE,
	CREATE_SHOP,
	CREATE_SHOPPING_LIST,
	LOGIN,
	MAP(true),
	MAP_ERROR,
	MENU,
	RECIPE(true),
	RESEARCH_SHOP,
	SHOPPING_LIST(true),
	TERMS_OF_USE;

	private boolean menu;

	/**
	 * Constructor, set menu as false.
	 */
	View() {
		this(false);
	}
	/**
	 * Constructor
	 * 
	 * @param menu
	 *            Whether or not menu should be included on top of this view.
	 */
	View(boolean menu) {
		this.menu = menu;
	}

	public boolean hasMenu() {
		return menu;
	}

	/**
	 * Takes a String s and change the first letter in upper case
	 */
	public static String firstUpper(String s) {
		if (s.length() == 0) {
			return "";
		}
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}


	public String toCamelCase() {
		String[] parts = toString().toLowerCase().split("_");
		for (int i = 0; i < parts.length; i++) {
			parts[i] = firstUpper(parts[i]);
		}
		return String.join("", parts);
	}

	/**
	 * User readable name.
	 * @return Name
	 */
	public String getName() {
		String[] parts = toString().toLowerCase().split("_");
		parts[0] = firstUpper(parts[0]);
		return String.join(" ", parts);
	}

	/**
	 * Load parent from FXML file. FXML File name should be CamelCase name.
	 * 
	 * @return Parent of view.
	 */
	public Region getParent() {
		try {
			return FXMLLoader.load(View.class.getResource("/FXML/" + toCamelCase() + ".fxml"));
		} catch (IOException e) {
			// never happens as resource is packed within application
			throw new RuntimeException(e);
		}
	}

}
