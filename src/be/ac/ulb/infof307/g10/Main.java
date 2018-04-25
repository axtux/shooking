package be.ac.ulb.infof307.g10;

import java.io.IOException;

import be.ac.ulb.infof307.g10.views.MapRendering;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
    public void init() throws Exception {
        super.init();
        DatabaseFacade.initDB();
    }

    @Override
	public void start(Stage stage){
		this.stage = stage;
		goToLogin();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void goToLogin() {
		stage.setTitle("Login Page");
		loadFXML("Login");
		update();
	}
	
	public void goToTerms() {
		stage.setTitle("Terms of use");
		loadFXML("TermsOfUse");
		update();
	}
	
	public void goToSignUp() {
		stage.setTitle("Creation of account");
		loadFXML("CreateAccount");
		update();
	}
	public void goToRecipe() {
		stage.setTitle("RECIPE");
		loadFXML("recipe");
		update();
	}
	public void goToShoppingList() {
		stage.setTitle("Shopping list");
		loadFXML("ShoppingList");
		update();
	}

	public void goToMenu() {
		stage.setTitle("Menu");
		loadFXML("Menu");
		update();
	}

	public void goToMap(){
		new MapRendering(stage);
		update();
	}

	public void exit(){
		Platform.exit();
	}

	private void loadFXML(String name) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(name+".fxml"));
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
