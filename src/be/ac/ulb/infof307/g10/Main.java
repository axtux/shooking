package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.models.exceptions.NonExistingException;
import be.ac.ulb.infof307.g10.views.IntCreateAcount;
import be.ac.ulb.infof307.g10.views.LoginPage;
import be.ac.ulb.infof307.g10.views.MapRendering;
import be.ac.ulb.infof307.g10.views.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
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
	private Stage dialog;
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
		} catch(NonExistingException e) {
			this.user = User.signup("test", "test");
			System.out.println("user test signed up");
		}
		goToMenu();
		//*/goToLogin();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public User getUser() {
		return user;
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

	private Scene getFXMLScene(String name) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/FXML/"+name+".fxml"));
			return new Scene(parent);
		} catch (IOException e) {
			// never happens as resources are packed within application
			throw new RuntimeException(e);
		}
	}

	private void loadFXML(String name) {
		Scene scene = getFXMLScene(name);
		stage.setScene(scene);
		stage.show();
	}

	public void showDialog(String name, String title) {
		Scene scene = getFXMLScene(name);
		dialog = new Stage();
		dialog.setTitle(title);
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.setScene(scene);
		dialog.show();
		dialog.centerOnScreen();
	}
	
	public void closeDialog() {
		dialog.close();
	}
	
	private void update() {
		stage.centerOnScreen();
	}
}
