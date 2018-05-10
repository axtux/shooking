package be.ac.ulb.infof307.g10.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is used to create different views with the same template (border
 * plane with a menu) It is useful to permit a uniformity of the different pages
 * of the application The menu used has a defined structure in the file
 * Menu.fxml (resources package) If it is modified, some method used here should
 * not work anymore. They have to be modified in this case
 */
public class GeneralView extends Parent {

	private BorderPane container;

	public GeneralView(Stage stage, String view) {
		this(stage, view, true);
	}
	
	public GeneralView(Stage stage, String view, boolean menu) {
		container = new BorderPane();
		container.setCenter(loadFXML(view));
		if (menu) {
			HBox topMenu = (HBox) loadFXML("Menu");
			disableButton(topMenu, view);
			container.setTop(topMenu);
		}
		// creation of the scene and configuration
		Scene scene = new Scene(container);
		stage.setTitle("Shooking (shopping and cooking)");
		stage.setScene(scene);
		stage.show();
		stage.centerOnScreen();
	}

	/**
	 * This function is used to load the corresponding Parent class of the fxml
	 * representing a view
	 * 
	 * @param name
	 *            The String name of the fxml file located in the resource
	 *            package You should not put the .fxml extension, only the name
	 * @return A Parent node corresponding to the root node of the view
	 */
	private Parent loadFXML(String name) {
		try {

			return FXMLLoader.load(getClass().getResource("/FXML/" + name + ".fxml"));

		} catch (IOException e) {
			// never happens as resource is packed within application
			throw new RuntimeException(e);
		}
	}

	/**
	 * Disable button in menu with id.
	 * @param menu Container within which to look
	 * @param id Id of button to disable
	 */
	private void disableButton(HBox menu, String id) {
		id = id.toLowerCase();
		String buttonId;
		for (Node button : menu.getChildren()) {
			buttonId = button.getId().toLowerCase();
			if (buttonId.equals(id)) {
				button.setDisable(true);
			}
		}
	}

}
