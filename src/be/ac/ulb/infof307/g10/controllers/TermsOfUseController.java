package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TermsOfUseController implements Initializable {
	@FXML
	private TextArea text;
	@FXML
	private Button button;
	@FXML
	void agree(MouseEvent event) {
		button.setDisable(true);
		System.out.println("agreed");
		Main.getInstance().goToSignUp();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("initialization");
		InputStream in = getClass().getResourceAsStream("/terms_of_use.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String content = reader.lines().collect(Collectors.joining());
		button.setText("I agree");
		text.setText(content);

	}
}
