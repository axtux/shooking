package be.ac.ulb.infof307.g10.controllers;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import be.ac.ulb.infof307.g10.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

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
