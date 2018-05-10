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
public class MainView {

	private static HBox topMenu;
	private static BorderPane container;
	private static Scene scene;
	private static Stage stage;

	/**
	 * Cache menu, container, scene and stage
	 * @param stage Stage
	 */
	public static void init(Stage s) {
		topMenu = (HBox) View.MENU.getParent();
		container = new BorderPane();
		scene = new Scene(container);
		stage = s;
		stage.setScene(scene);
		stage.setTitle("Shooking (shopping and cooking)");
		stage.show();
	}

	public static void show(View view) {
		if (stage == null) {
			throw new UnsupportedOperationException("You must init stage first");
		}
		if (view.hasMenu()) {
			container.setTop(topMenu);
			disableButton(topMenu, view.toCamelCase());
		} else {
			container.setTop(null);
		}
		container.setCenter(view.getParent());
		// creation of the scene and configuration
		double h = stage.getHeight();
		double w = stage.getWidth();
		stage.sizeToScene();
		if (h != stage.getHeight() || w != stage.getWidth()) {
			stage.centerOnScreen();
		}
	}

	/**
	 * Disable button in menu with id.
	 * @param menu Container within which to look
	 * @param id Id of button to disable
	 */
	private static void disableButton(HBox menu, String id) {
		id = id.toLowerCase();
		String buttonId;
		for (Node button : menu.getChildren()) {
			buttonId = button.getId().toLowerCase();
			button.setDisable(buttonId.equals(id));
		}
	}

}
