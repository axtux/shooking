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

import com.lynden.gmapsfx.javascript.object.LatLong;

public class Main extends Application {
	//Singleton pattern
	private static Main instance;

	private Stage stage;
	private Stage dialog;
	private User user;

	/**
	 * Singleton pattern
	 * @return Main instance
	 */
	public static Main getInstance() {
		return instance;
	}

	public Main() {
		super();
		instance = this;
	}


	@Override
	public void init() {
		Database.init();
	}

	@Override
	public void start(final Stage stage) {
		this.stage = stage;
		goToLogin();
	}

	public static void main(final String[] args) {
		launch(args);
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
		goToShoppingList();
	}

	public void goToLogin() {
		new GeneralView(stage, "Login", false);
	}

	public void goToTerms() {
		new GeneralView(stage, "TermsOfUse", false);
	}

	public void goToCreateAccount() {
		new GeneralView(stage, "CreateAccount", false);
	}

	public void goToRecipe() {
		new GeneralView(stage, "Recipe");
	}

	public void goToShoppingList() {
		new GeneralView(stage, "ShoppingList");
	}

	public void goToMap() {
		new GeneralView(stage, "Map");
	}

	public void showMapErrorDialog() {
		showDialog("MapError", "Error");
	}

	public void showCreateShopDialog(final LatLong position) {
		CreateShopController.sposition = position;
		showDialog("CreateShop", "Create shop");
	}

	public void showCreateRecipeDialog() {
		showDialog("CreateRecipe", "Create recipe");
	}

	public void showCreateRecipeDialog(final ShoppingList shoppingList) {
		ResearchShopController.ssl = shoppingList;
		showDialog("ResearchShop", "Research shop");
	}

	public void showCreateProductDialog() {
		showDialog("CreateProduct", "Create product");
	}

	public void exit() {
		Platform.exit();
	}

	private Scene getFXMLScene(final String name) {
		try {
			final Parent parent = FXMLLoader.load(getClass().getResource("/FXML/" + name + ".fxml"));
			return new Scene(parent);
		} catch (IOException e) {
			// never happens as resources are packed within application
			throw new RuntimeException(e);
		}
	}

	private void showDialog(final String name, final String title) {
		final Scene scene = getFXMLScene(name);
		dialog = new Stage();
		dialog.setTitle(title);
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.setScene(scene);
		dialog.showAndWait();
	}

	public void closeDialog() {
		dialog.close();
	}

}
