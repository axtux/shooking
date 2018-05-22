package be.ac.ulb.infof307.g10.views;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

/**
 * This class is used to create different views with the same template (border
 * plane with an eventual menu). Allows uniformity of application views. Menu
 * root element is expected to be an HBox. If modified, this class can provide
 * unexpected behavior.
 */
final public class MainView {

	private static final String APP_NAME = "Shooking (shopping and cooking)";
	private static final double DEFAULT_HEIGTH = 800.0;
	private static final double DEFAULT_WIDTH = 1000.0;
	private static MyStage stage;
	private static BorderPane container;
	private static HBox menu;

	/**
	 * Avoid object creation
	 */
	private MainView() {
	}
	/**
	 * Create menu, container, stage and hide eventual dialog
	 */
	private synchronized static void init() {
		if (stage == null) {
			stage = new MyStage();
			container = new BorderPane();
			stage.setRoot(container);
			menu = (HBox) View.MENU.getParent();
			container.setTop(menu);
			stage.setTitle(APP_NAME);
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
		Region viewParent = view.getParent();

		if (view.hasMenu()) {
			container.setTop(menu);
			disableMenuButton(view.toCamelCase());
			// keep consistent size between views under menu
			viewParent.setPrefHeight(DEFAULT_HEIGTH);
			viewParent.setPrefWidth(DEFAULT_WIDTH);
		} else {
			container.setTop(null);
		}

		container.setCenter(viewParent);
		stage.sizeToScene();
		// center back to saved center
		stage.setCenter(center);

	}

	/**
	 * Disable button in menu with id. Id check is case insensitive.
	 * 
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
