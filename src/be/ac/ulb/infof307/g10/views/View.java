package be.ac.ulb.infof307.g10.views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public enum View {
	CREATE_ACCOUNT(false);
	
	private boolean menu;
	View(boolean menu) {
		this.menu = menu;
	}


	/**
	 * Load parent from FXML file
	 * 
	 * @param name
	 *            The name of the FXML resource file, without ".fxml" extension
	 * @return The root parent node found within FXML file
	 */
	public static Parent loadFXML(String name) {
		try {
			return FXMLLoader.load(View.class.getResource("/FXML/" + name + ".fxml"));
		} catch (IOException e) {
			// never happens as resource is packed within application
			throw new RuntimeException(e);
		}
	}
}
