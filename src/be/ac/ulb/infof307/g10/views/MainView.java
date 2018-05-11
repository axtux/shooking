package be.ac.ulb.infof307.g10.views;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * This class is used to create different views with the same template (border
 * plane with a menu) It is useful to permit a uniformity of the different pages
 * of the application The menu used has a defined structure in the file
 * Menu.fxml (resources package) If it is modified, some method used here should
 * not work anymore. They have to be modified in this case
 */
public class MainView {

	private static MyStage stage;
	private static BorderPane container;
	private static HBox menu;

	/**
	 * Create menu, container, stage and hide eventual dialog
	 */
	private static void init() {
		if (stage == null) {
			stage = new MyStage();
			container = new BorderPane();
			stage.setRoot(container);
			menu = (HBox) View.MENU.getParent();
			container.setTop(menu);
			stage.setTitle("Shooking (shopping and cooking)");
			stage.show();
		}
		DialogView.hide();
	}

	/**
	 * Show view on main window (hiding eventual existing view).
	 * 
	 * @param view
	 *            View to show.
	 */
	public static void show(View view) {
		init();
		// save center
		Point2D center = stage.getCenter();

		if (view.hasMenu()) {
			container.setTop(menu);
			disableMenuButton(view.toCamelCase());
		} else {
			container.setTop(null);
		}

		container.setCenter(view.getParent());
		stage.sizeToScene();
		// center back to saved center
		stage.setCenter(center);
	}

	/**
	 * Disable button in menu with id.
	 * 
	 * @param menu
	 *            Container within which to look
	 * @param id
	 *            Id of button to disable
	 */
	private static void disableMenuButton(String id) {
		id = id.toLowerCase();
		String buttonId;
		for (Node button : menu.getChildren()) {
			buttonId = button.getId().toLowerCase();
			button.setDisable(buttonId.equals(id));
		}
	}

	/**
	 * Get window center
	 * 
	 * @return Center
	 */
	public static Point2D getCenter() {
		return stage.getCenter();
	}
}
