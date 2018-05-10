package be.ac.ulb.infof307.g10.views;

import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;

public class DialogView {
	private static MyStage stage;
	/**
	 * Create stage and scene
	 */
	private static void init() {
		if (stage == null) {
			stage = new MyStage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.hideOnEscape();
		}
	}

	public static void show(View view) {
		show(view, null);
	}

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
		if (stage != null) {
			stage.hide();
		}
	}

}
