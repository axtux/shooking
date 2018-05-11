package be.ac.ulb.infof307.g10.controllers;

import be.ac.ulb.infof307.g10.Main;
import be.ac.ulb.infof307.g10.views.MainView;
import be.ac.ulb.infof307.g10.views.View;
import javafx.application.Platform;
import javafx.fxml.FXML;

/**
 * This class is the main controller, it implements all the methods used in the
 * different page of the application. The redirection to the over pages are
 * implemented here
 */
public class MenuController {

	@FXML
	private void showShoppingList() {
		MainView.show(View.SHOPPING_LIST);
	}

	@FXML
	private void showMap() {
		MainView.show(View.MAP);
	}

	@FXML
	private void showRecipe() {
		MainView.show(View.RECIPE);
	}

	@FXML
	private void logout() {
		Main.logout();
	}

	@FXML
	private void exit() {
		Platform.exit();
	}

}
