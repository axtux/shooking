package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.utils.TermsOfUse;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

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
		Main.getInstance().goToCreateAccount();
	}

	public void initialize() {
		text.setText(TermsOfUse.get());
		// remove focus from text (needed to focus button)
		text.setFocusTraversable(false);
		button.requestFocus();
	}
}
