package be.ac.ulb.infof307.g10;

import java.io.IOException;

import be.ac.ulb.infof307.g10.views.IntCreateAcount;
import be.ac.ulb.infof307.g10.views.LoginPage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
		update();
	}
	
	public void goToTerms() {
		stage.setTitle("Terms of use");
		loadFXML("TermsOfUse");
		update();
	}
	
	public void goToSignUp() {
		new IntCreateAcount(stage);
		update();
	}
	
	public void goToShoppingList() {
		stage.setTitle("Shopping list");
		loadFXML("ShoppingList");
		update();
	}
	
	private void loadFXML(String name) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("views/"+name+".fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			// never happens as resource in packed with application
			e.printStackTrace();
		}
	}
	
	private void update() {
		stage.centerOnScreen();
	}
}
