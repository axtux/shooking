package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.utils.TermsOfUse;
import be.ac.ulb.infof307.g10.views.MainView;
import be.ac.ulb.infof307.g10.views.View;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Controller class of the Terms of use view
 */
public class TermsOfUseController {

	@FXML
	private TextArea text;
	@FXML
	private Button button;

	@FXML
	void agree() {
		button.setDisable(true);
		MainView.show(View.CREATE_ACCOUNT);
	}

	public void initialize() {
		text.setText(TermsOfUse.get());
		// remove focus from text (needed to focus button)
		text.setFocusTraversable(false);
		button.requestFocus();
	}
}
