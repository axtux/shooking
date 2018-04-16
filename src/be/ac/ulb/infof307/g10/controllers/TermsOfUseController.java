package be.ac.ulb.infof307.g10.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

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
		
		// TODO move this to model
		URL file = getClass().getClassLoader().getResource("terms_of_use.txt");
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(file.toURI()), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		String content = String.join("\n", lines);
		button.setText("I agree");
		text.setText(content);
	}
}
