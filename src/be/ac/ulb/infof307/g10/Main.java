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
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

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

	public void goToCreateAccount() {
		GeneralView page = new GeneralView(stage, "CreateAccount", "Menu");

		List<String> buttons = Arrays.asList("logout","shoppingList","map");
		page.disableButtons(buttons);

		page.setTitle("Create your Account");
		stage.setTitle("Account");

	}
	public void goToRecipe() {
		stage.setTitle("Recipe");
		loadFXML("Recipe");
		update();
	}
	public void goToShoppingList() {
		GeneralView page = new GeneralView(stage, "ShoppingList", "Menu");
		List<String> buttons = Arrays.asList("logout","goTo");
		page.disableButtons(buttons);

		page.setTitle("Login Page");

	}



	public void goToMap(){
		//TODO checker si pas fxml GeneralView page = new GeneralView(stage, "Login", "Menu");
		List<String> buttons = Arrays.asList("logout","goTo");
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

	private void update() {
		stage.centerOnScreen();
	}

}
