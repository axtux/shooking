package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.controllers.CreateShopController;
import be.ac.ulb.infof307.g10.controllers.ResearchShopController;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.views.DialogView;
import be.ac.ulb.infof307.g10.views.GeneralView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import com.lynden.gmapsfx.javascript.object.LatLong;

public class Main extends Application {
	//Singleton pattern
	private static Main instance;

	private Stage stage;
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
		DialogView.show("MapError", "Error");
	}

	public void showCreateShopDialog(final LatLong position) {
		CreateShopController.sposition = position;
		DialogView.show("CreateShop", "Create shop");
	}

	public void showCreateRecipeDialog() {
		DialogView.show("CreateRecipe", "Create recipe");
	}

	public void showCreateRecipeDialog(final ShoppingList shoppingList) {
		ResearchShopController.ssl = shoppingList;
		DialogView.show("ResearchShop", "Research shop");
	}

	public void showCreateProductDialog() {
		DialogView.show("CreateProduct", "Create product");
	}

	public void closeDialog() {
		DialogView.hide();
	}

	public void exit() {
		Platform.exit();
	}

}
