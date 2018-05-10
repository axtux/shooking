package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.views.View;
import javafx.fxml.FXML;

public class MapErrorController extends MainController {

	@FXML
	void tryAgain() {
		Main.getInstance().closeDialog();
		Main.getInstance().show(View.MAP);
	}

}
