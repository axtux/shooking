package be.ac.ulb.infof307.g10;

import java.io.IOException;

import be.ac.ulb.infof307.g10.views.*;
import be.ac.ulb.infof307.g10.db.DatabaseFacade;
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
		GeneralView page = new GeneralView(stage, "Login", "Menu");
		String[] buttons = {"logout","goTo"};
		page.disableButtons(buttons);

		page.setTitle("Login Page");
		//loadFXML("Login");
		//update();
	}

	public void goToTerms() {
		stage.setTitle("Terms of use");
		loadFXML("TermsOfUse");
		update(stage);
	}

	public void goToSignUp() {
		GeneralView page = new GeneralView(stage, "CreateAccount", "Menu");
		String[] buttons = {"logout","goTo"};
		page.disableButtons(buttons);

		page.setTitle("Login Page");

	}
	public void goToRecipe() {
		stage.setTitle("RECIPE");
		loadFXML("recipe");
		update();
	}
	public void goToShoppingList() {
		GeneralView page = new GeneralView(stage, "ShoppingList", "Menu");
		String[] buttons = {"logout","goTo"};
		page.disableButtons(buttons);

		page.setTitle("Login Page");

	}



	public void goToMap(){
		//TODO checker si pas fxml GeneralView page = new GeneralView(stage, "Login", "Menu");
		String[] buttons = {"logout","goTo"};
		//page.disableButtons(buttons);

		//page.setTitle("Login Page");

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

	private void update(Stage stage) {
		stage.centerOnScreen();
	}

}
