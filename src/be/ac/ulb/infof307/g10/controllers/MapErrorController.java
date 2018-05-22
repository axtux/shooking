package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.views.DialogView;
import be.ac.ulb.infof307.g10.views.MainView;
import be.ac.ulb.infof307.g10.views.View;
import javafx.fxml.FXML;

/**
 * Controller of the popup that occurs when a JavaScript exception is caught.
 * For example : when there is no internet connection
 */
public class MapErrorController {

	/**
	 * Try again button
	 */
	@FXML
	void tryAgain() {
		DialogView.hide();
		MainView.show(View.MAP);
	}

}
