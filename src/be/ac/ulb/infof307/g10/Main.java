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
		show(View.LOGIN);
	}

	public static void main(final String[] args) {
		launch(args);
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
		show(View.SHOPPING_LIST);
	}

	public void show(View view) {
		new GeneralView(stage, view);
	}

	public void showDialog(View view) {
		DialogView.show(view);
	}

	public void showCreateShopDialog(final LatLong position) {
		CreateShopController.sposition = position;
		DialogView.show(View.CREATE_SHOP);
	}

	public void showResearchShopDialog(final ShoppingList shoppingList) {
		ResearchShopController.ssl = shoppingList;
		DialogView.show(View.RESEARCH_SHOP);
	}

	public void closeDialog() {
		DialogView.hide();
	}

	public void exit() {
		Platform.exit();
	}

}
