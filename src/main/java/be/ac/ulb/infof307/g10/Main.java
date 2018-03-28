package be.ac.ulb.infof307.g10;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	/*
	 * Singleton pattern
	 */
	private static Main instance;
	public static Main getInstance() {
		return instance;
	}
	public Main() {
		instance = this;
	}
	
	private Stage stage;
	
	@Override
	public void start(Stage stage){
		this.stage = stage;
		goToLogin();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void goToLogin() {
		new LoginPage(stage);
		center();
	}
	
	public void goToTerms() {
		stage.setTitle("Terms of use");
		loadFXML("TermsOfUse");
		center();
	}
	
	public void goToSignUp() {
		new IntCreateAcount(stage);
		center();
	}
	
	public void goToShoppingList() {
		stage.setTitle("Shopping list");
		loadFXML("Vista");
		center();
	}
	
	private void loadFXML(String name) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(name+".fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			// never happens as resource in packed with application
			e.printStackTrace();
		}
	}
	
	private void center() {
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		stage.setX((bounds.getWidth() - stage.getWidth()) / 2);
		stage.setY((bounds.getHeight() - stage.getHeight()) / 2);
	}
}
