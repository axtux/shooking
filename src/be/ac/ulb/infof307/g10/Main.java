package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.controllers.CreateShopController;
import be.ac.ulb.infof307.g10.controllers.ResearchShopController;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.views.GeneralView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

import com.lynden.gmapsfx.javascript.object.LatLong;

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
	public void start(Stage stage) {
		this.stage = stage;
		goToLogin();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		goToShoppingList();
	}

	public void goToLogin() {
		stage.setTitle("Login");
		loadFXML("Login");
		update();
	}

	public void goToTerms() {
		stage.setTitle("Terms of use");
		loadFXML("TermsOfUse");
		update();
	}

	public void goToCreateAccount() {
		stage.setTitle("Account creation");
		loadFXML("CreateAccount");
		update();
	}

	public void goToRecipe() {
		GeneralView page = new GeneralView(stage, "Recipe", "Menu");
		page.disableButtons(Arrays.asList("recipe"));
		update();
	}

	public void goToShoppingList() {
		GeneralView page = new GeneralView(stage, "ShoppingList", "Menu");
		page.disableButtons(Arrays.asList("shoppingList"));
		update();
	}

	public void goToMap() {
		GeneralView page = new GeneralView(stage, "Map", "Menu");
		page.disableButtons(Arrays.asList("map"));
		update();
	}

	public void showMapErrorDialog() {
		showDialog("MapError", "Error");
	}

	public void showCreateShopDialog(LatLong position) {
		CreateShopController.sposition = position;
		showDialog("CreateShop", "Create shop");
	}

	public void showCreateRecipeDialog() {
		showDialog("CreateRecipe", "Create recipe");
	}

	public void showCreateRecipeDialog(ShoppingList sl) {
		ResearchShopController.ssl = sl;
		showDialog("ResearchShop", "Research shop");
	}

	public void showCreateProductDialog() {
		showDialog("CreateProduct", "Create product");
	}

	public void exit() {
		Platform.exit();
	}

	private Scene getFXMLScene(String name) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/FXML/" + name + ".fxml"));
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

	private void showDialog(String name, String title) {
		Scene scene = getFXMLScene(name);
		dialog = new Stage();
		dialog.setTitle(title);
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.setScene(scene);
		dialog.showAndWait();
	}

	public void closeDialog() {
		dialog.close();
	}

	private void update() {
		stage.centerOnScreen();
	}

}
