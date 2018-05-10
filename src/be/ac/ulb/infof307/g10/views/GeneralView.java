package be.ac.ulb.infof307.g10.views;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * This class is used to create different views with the same template (border
 * plane with a menu) It is useful to permit a uniformity of the different pages
 * of the application The menu used has a defined structure in the file
 * Menu.fxml (resources package) If it is modified, some method used here should
 * not work anymore. They have to be modified in this case
 */
public class GeneralView {

	private BorderPane container;

	public GeneralView(Stage stage, String view) {
		this(stage, view, true);
	}
	
	public GeneralView(Stage stage, String view, boolean menu) {
		container = new BorderPane();
		container.setCenter(View.loadFXML(view));
		if (menu) {
			HBox topMenu = (HBox) View.loadFXML("Menu");
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
