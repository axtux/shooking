package be.ac.ulb.infof307.g10.views;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogView {
	// singleton
	private static Stage current;
	private static Stage getStage() {
		if (current == null) {
			current = new Stage();
			current.initModality(Modality.APPLICATION_MODAL);
		}
		return current;
	}

	public static void show(final String view, final String title) {
		Parent parent = View.loadFXML(view);
		Scene scene = new Scene(parent);
		Stage stage = getStage();
		stage.setTitle(title);
		stage.setScene(scene);
		stage.showAndWait();
	}

	public static void hide() {
		getStage().hide();
	}
}
