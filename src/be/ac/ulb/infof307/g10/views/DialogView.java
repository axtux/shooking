package be.ac.ulb.infof307.g10.views;

import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;

/**
 * Manage modal dialog.
 */
final public class DialogView {
	private static MyStage stage;

	/**
	 * Avoid object creation
	 */
	private DialogView() {
	}
	/**
	 * Create stage
	 */
	private synchronized static void init() {
		if (stage == null) {
			stage = new MyStage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.hideOnEscape();
		}
	}

	/**
	 * Show view within a modal dialog window. No other window can be accessed
	 * while a modal dialog is opened. Can be closed with escape key.
	 * 
	 * @param view
	 *            View to show
	 */
	public static void show(View view) {
		show(view, null);
	}

	/**
	 * Same as {{@link #show(View)} adding an event.
	 * 
	 * @param view
	 *            View to show
	 * @param onHidden
	 *            Event whose handle method is called when dialog window is
	 *            hidden.
	 */
	public static void show(View view, EventHandler<WindowEvent> onHidden) {
		init();

		stage.setOnHidden(onHidden);
		stage.setRoot(view.getParent());
		stage.setTitle(view.getName());
		stage.show();
		// center on main view
		stage.setCenter(MainView.getCenter());
	}

	public static void hide() {
		if (stage != null && stage.isShowing()) {
			stage.hide();
		}
	}

}
