package be.ac.ulb.infof307.g10;

import be.ac.ulb.infof307.g10.controllers.CreateShopController;
import be.ac.ulb.infof307.g10.controllers.ResearchShopController;
import be.ac.ulb.infof307.g10.db.Database;
import be.ac.ulb.infof307.g10.models.ShoppingList;
import be.ac.ulb.infof307.g10.models.User;
import be.ac.ulb.infof307.g10.views.DialogView;
import be.ac.ulb.infof307.g10.views.GeneralView;
import be.ac.ulb.infof307.g10.views.View;
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
		new GeneralView(stage, View.LOGIN);
	}

	public void goToTerms() {
		new GeneralView(stage, View.TERMS_OF_USE);
	}

	public void goToCreateAccount() {
		new GeneralView(stage, View.CREATE_ACCOUNT);
	}

	public void goToRecipe() {
		new GeneralView(stage, View.RECIPE);
	}

	public void goToShoppingList() {
		new GeneralView(stage, View.SHOPPING_LIST);
	}

	public void goToMap() {
		new GeneralView(stage, View.MAP);
	}

	public void showMapErrorDialog() {
		DialogView.show(View.MAP_ERROR);
	}

	public void showCreateShopDialog(final LatLong position) {
		CreateShopController.sposition = position;
		DialogView.show(View.CREATE_SHOP);
	}

	public void showCreateRecipeDialog() {
		DialogView.show(View.CREATE_RECIPE);
	}

	public void showResearchShopDialog(final ShoppingList shoppingList) {
		ResearchShopController.ssl = shoppingList;
		DialogView.show(View.RESEARCH_SHOP);
	}

	public void showCreateProductDialog() {
		DialogView.show(View.CREATE_PRODUCT);
	}

	public void closeDialog() {
		DialogView.hide();
	}

	public void exit() {
		Platform.exit();
	}

}
