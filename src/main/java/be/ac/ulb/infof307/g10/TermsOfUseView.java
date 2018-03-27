package be.ac.ulb.infof307.g10;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TermsOfUseView {
	public TermsOfUseView() {
		Stage stage = new Stage();
		stage.setTitle("Terms of use");
		
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
		
		Label text = new Label(content);
		text.setWrapText(true);
		text.setPadding(new Insets(20));
		text.setMaxWidth(800);
		
		ScrollPane sp = new ScrollPane();
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		sp.setMinSize(100, 100);
		sp.setMaxSize(800, 600);
		sp.setContent(text);
		// maxWidth minus padding and scrollbar
		text.setMaxWidth(800 - 2*20 - 20);
		
		Button btn = new Button();
		btn.setText("I accept this conditions");
		btn.setDefaultButton(true);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.close();
				new IntCreateAcount();
			}
		});
		
		VBox vbox = new VBox(sp, btn);
		btn.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vbox);
		stage.setScene(scene);

		stage.show();

	}

}
