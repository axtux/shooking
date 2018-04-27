package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingUserException;
import be.ac.ulb.infof307.g10.views.IntCreateAcount;
import be.ac.ulb.infof307.g10.views.LoginPage;
import be.ac.ulb.infof307.g10.views.MapRendering;
import be.ac.ulb.infof307.g10.views.Menu;
import javafx.application.Application;
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
	private User user;

	@Override
	public void init() {
		Database.init();
	}

	@Override
	public void start(Stage stage){
		this.stage = stage;
		//* TODO remove for release
		try {
			this.user = User.login("test", "test");
			System.out.println("user test logged in");
		} catch(NonExistingUserException e) {
			this.user = User.signup("test", "test");
			System.out.println("user test signed up");
		}
		goToMenu();
		//*/goToLogin();
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
	public void goToRecipe() {
		stage.setTitle("Recipe");
		loadFXML("Recipe");
		update();
	}
	public void goToShoppingList() {
		stage.setTitle("Shopping list");
		loadFXML("ShoppingList");
		update();
	}

	public void goToMenu() {
		new Menu(stage);
		update();
	}

	public void goToMap(){
		new MapRendering(stage);
		update();
	}

	private void loadFXML(String name) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/FXML/"+name+".fxml"));
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
