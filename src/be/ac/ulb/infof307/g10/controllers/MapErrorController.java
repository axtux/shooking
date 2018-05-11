package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.views.DialogView;
import be.ac.ulb.infof307.g10.views.MainView;
import be.ac.ulb.infof307.g10.views.View;
import javafx.fxml.FXML;

public class MapErrorController {

	@FXML
	void tryAgain() {
		DialogView.hide();
		MainView.show(View.MAP);
	}

}
