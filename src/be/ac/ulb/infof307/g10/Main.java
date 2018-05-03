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

import java.util.Arrays;

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

	//TODO avoir une liste des pages possible ici et faire des sublist dans les méthode pour récupérer ce qu'on veut
	// ceci permettrait de pas se tromper facilement dans l'écrite des boutons à disable
	
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
        page.disableButtons(Arrays.asList("map","shoppingList","recipe"));
        page.setTitle("Create your account");
        update();
	}
	public void goToRecipe() {
		GeneralView page = new GeneralView(stage, "Recipe", "Menu");
		page.disableButtons(Arrays.asList("recipe"));
		page.setTitle("Recipes");
		update();
	}
	public void goToShoppingList() {
		GeneralView page = new GeneralView(stage, "ShoppingList", "Menu");
		page.disableButtons(Arrays.asList("shoppingList"));
		page.setTitle("Shopping List");
		update();
	}



	public void goToMap(){
		GeneralView page = new GeneralView(stage, "Map", "Menu");
		page.disableButtons(Arrays.asList("map"));
		page.setTitle("Shopping Map");
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

		} catch (IOException e) { // never happens as resource in packed with application
			e.printStackTrace();
		}
	}

	private void update() {
		stage.centerOnScreen();
	}

}
